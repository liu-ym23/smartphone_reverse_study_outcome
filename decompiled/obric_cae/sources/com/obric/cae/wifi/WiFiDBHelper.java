package com.obric.cae.wifi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public class WiFiDBHelper extends SQLiteOpenHelper {
    public static final String COL_BSSID = "bssid";
    public static final String COL_EMA_TPUT = "ema_tput";
    public static final String COL_RSSI = "rssi";
    public static final String COL_SAMPLE_COUNT = "sample_count";
    public static final String COL_SCAN_CURR_BSSID = "current_bssid";
    public static final String COL_SCAN_CURR_SSID = "current_ssid";
    public static final String COL_SCAN_FREQS_MHZ = "scanned_freqs_mhz";
    public static final String COL_SCAN_TIME = "timestamp";
    public static final String COL_UPDATE_TIME = "update_time";
    private static final String DB_NAME = "wifi_tput.db";
    private static final int DB_VERSION = 2;
    public static final String TABLE_EMA_TPUT = "wifi_ema_tput";
    public static final String TABLE_SCAN_BAND = "wifi_scan_band";
    private static Context appContext;
    private static volatile WiFiDBHelper instance;

    private WiFiDBHelper(Context r8) {
        super(r8.getApplicationContext(), DB_NAME, null, 2);
        appContext = r8.getApplicationContext();
    }

    public static WiFiDBHelper getInstance() {
        if (instance == null) goto L9;
        if (appContext == null) goto L9;
        return instance;
    L9:
        throw new IllegalStateException("instance is null or appContext is null");
    }

    public void closeDatabase() {
        if (instance == null) goto L6;
        instance.close();
        instance = null;
        appContext = null;
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r8) {
        r8.execSQL("CREATE TABLE IF NOT EXISTS wifi_ema_tput (bssid TEXT NOT NULL, rssi INTEGER NOT NULL, ema_tput INTEGER NOT NULL, sample_count INTEGER NOT NULL, update_time INTEGER NOT NULL, PRIMARY KEY (bssid, rssi))");
        r8.execSQL("CREATE TABLE IF NOT EXISTS wifi_scan_band (current_bssid TEXT, current_ssid TEXT, scanned_freqs_mhz TEXT, timestamp INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r8, int r10, int r11) {
        r8.execSQL("DROP TABLE IF EXISTS wifi_ema_tput");
        r8.execSQL("DROP TABLE IF EXISTS wifi_scan_band");
        onCreate(r8);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
        if (r10 >= 2) goto L6;
        r8.execSQL("CREATE TABLE IF NOT EXISTS wifi_scan_band (current_bssid TEXT, current_ssid TEXT, scanned_freqs_mhz TEXT, timestamp INTEGER)");
        return;
    }

    public static WiFiDBHelper getInstance(Context r8) {
        if (instance != null) goto L15;
        monitor-enter(WiFiDBHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new WiFiDBHelper(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(WiFiDBHelper.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }
}
