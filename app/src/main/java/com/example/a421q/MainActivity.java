package com.example.a421q;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ItemsDataAdapter adapter;
    private List<Drawable> images = new ArrayList<>();
    private List<ItemData> data = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ListView listView = findViewById(R.id.list);

        fillImages();
        prepareContent();

        adapter = new ItemsDataAdapter(this, data);
        listView.setAdapter(adapter);


    }
    private void fillImages() {
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_report_image));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_add));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_agenda));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                android.R.drawable.ic_menu_camera));
    }

    private void prepareContent(){
        String[] arrayContent = getString(R.string.list_app).split("\n\n");
        String[] arrayContentSub = getString(R.string.list_appSub).split("\n\n");
        for(int i = 0; i < arrayContent.length; i ++){
            ItemData iteam = new ItemData(images.get(i),arrayContent[i],arrayContentSub[i]);
            data.add(iteam);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_open_notes:
                Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(intentNotes);
                return true;
            case R.id.action_bank:
                Intent intentBank = new Intent(MainActivity.this, BankActivity.class);
                startActivity(intentBank);
                return true;
            case R.id.action_city:
                Intent intentCity = new Intent(MainActivity.this, CityActivity.class);
                startActivity(intentCity);
                return true;
            case R.id.action_calendar:
                Intent intentCalendar = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intentCalendar);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
