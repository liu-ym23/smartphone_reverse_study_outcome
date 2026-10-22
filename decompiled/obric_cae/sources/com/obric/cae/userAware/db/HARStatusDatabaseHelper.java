package com.obric.cae.userAware.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.obric.cae.log.CommSenseLog;

/* JADX INFO: loaded from: classes2.dex */
final class HARStatusDatabaseHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "HARStatusRecords.db";
    static final int DATABASE_VERSION = 2;
    private static final String TAG = "HARStatusDatabaseHelper";

    public HARStatusDatabaseHelper(Context r8) {
        super(r8.getApplicationContext(), DATABASE_NAME, null, 2);
    }

    private static void createPoiArrivalSchema(SQLiteDatabase r8) {
        r8.execSQL("CREATE TABLE IF NOT EXISTS poi_arrival_records (_id INTEGER PRIMARY KEY AUTOINCREMENT, event_time INTEGER NOT NULL, event_time_text TEXT DEFAULT '', feedback_time INTEGER NOT NULL DEFAULT 0, feedback_time_text TEXT DEFAULT '', poi_name TEXT DEFAULT '', aoi_name TEXT DEFAULT '', category TEXT DEFAULT '', has_feedback INTEGER NOT NULL DEFAULT 0, user_choice INTEGER NOT NULL DEFAULT -1, UNIQUE(event_time, poi_name, aoi_name, category))");
        r8.execSQL("CREATE INDEX IF NOT EXISTS poi_arrival_event_time_index ON poi_arrival_records (event_time DESC)");
    }

    public static void ensureSchema(SQLiteDatabase r8) {
        r8.execSQL("CREATE TABLE IF NOT EXISTS har_records (_id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp INTEGER NOT NULL, har_status TEXT NOT NULL, has_feedback INTEGER NOT NULL DEFAULT 0, is_correct INTEGER)");
        createPoiArrivalSchema(r8);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r8) {
        ensureSchema(r8);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r8, int r10, int r11) {
        CommSenseLog.w(TAG, "Downgrading database from version " + r10 + " to " + r11);
        r8.execSQL("CREATE TABLE IF NOT EXISTS har_records (_id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp INTEGER NOT NULL, har_status TEXT NOT NULL, has_feedback INTEGER NOT NULL DEFAULT 0, is_correct INTEGER)");
        r8.execSQL("DROP TABLE IF EXISTS poi_arrival_records");
        createPoiArrivalSchema(r8);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
        if (r10 >= 2) goto L6;
        createPoiArrivalSchema(r8);
        return;
    }
}
