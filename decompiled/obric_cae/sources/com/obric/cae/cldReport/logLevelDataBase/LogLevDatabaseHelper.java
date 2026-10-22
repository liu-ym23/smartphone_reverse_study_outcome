package com.obric.cae.cldReport.logLevelDataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public class LogLevDatabaseHelper extends SQLiteOpenHelper {
    public static final String COLUMN_INVALID_DATE = "invalidDate";
    public static final String COLUMN_LOGMASK = "logmask";
    public static final String COLUMN_MODULE = "module";
    public static final String COLUMN_STARTED_DATE = "startedDate";
    private static final String CREATE_TABLE = "CREATE TABLE log_lev (module TEXT NOT NULL, logmask INTEGER NOT NULL, startedDate TEXT, invalidDate TEXT, PRIMARY KEY (module, logmask));";
    private static final String DATABASE_NAME = "loglev.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS log_lev";
    public static final String TABLE_NAME = "log_lev";

    public LogLevDatabaseHelper(Context r8) {
        super(r8, DATABASE_NAME, null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r8) {
        r8.execSQL(CREATE_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
        r8.execSQL(DROP_TABLE);
        onCreate(r8);
    }
}
