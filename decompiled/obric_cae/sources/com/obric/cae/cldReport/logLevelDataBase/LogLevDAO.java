package com.obric.cae.cldReport.logLevelDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LogLevDAO {
    private static final String TAG = "LogLevDAO";
    private static LogLevDAO mInstance;
    private final String[] allColumns;
    private SQLiteDatabase mDatabase;
    private final LogLevDatabaseHelper mDbHelper;

    public LogLevDAO(Context r8) {
        this.allColumns = new String[]{"module", LogLevDatabaseHelper.COLUMN_LOGMASK, LogLevDatabaseHelper.COLUMN_STARTED_DATE, LogLevDatabaseHelper.COLUMN_INVALID_DATE};
        LogLevDatabaseHelper r10 = new LogLevDatabaseHelper(r8.getApplicationContext());
        this.mDbHelper = r10;
        this.mDatabase = r10.getWritableDatabase();
    }

    private LogLevEntry cursorToEntry(Cursor r8) {
        return new LogLevEntry(r8.getString(r8.getColumnIndex("module")), r8.getInt(r8.getColumnIndex(LogLevDatabaseHelper.COLUMN_LOGMASK)), r8.getString(r8.getColumnIndex(LogLevDatabaseHelper.COLUMN_STARTED_DATE)), r8.getString(r8.getColumnIndex(LogLevDatabaseHelper.COLUMN_INVALID_DATE)));
    }

    public static LogLevDAO getInstance(Context r8) {
        if (mInstance != null) goto L15;
        monitor-enter(LogLevDAO.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new LogLevDAO(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(LogLevDAO.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public boolean addLogEntry(LogLevEntry r8) {
        ContentValues r10 = new ContentValues();
        r10.put("module", r8.getModule());
        r10.put(LogLevDatabaseHelper.COLUMN_LOGMASK, Integer.valueOf(r8.getLogmask()));
        r10.put(LogLevDatabaseHelper.COLUMN_STARTED_DATE, r8.getStartedDate());
        r10.put(LogLevDatabaseHelper.COLUMN_INVALID_DATE, r8.getInvalidDate());
        if (this.mDatabase.insertOrThrow(LogLevDatabaseHelper.TABLE_NAME, null, r10) == (-1)) goto L13;
        return true;
    L13:
        return false;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void close() {
        this.mDbHelper.close();
    }

    public boolean deleteLogEntry(String r8, int r10) {
        int r11 = this.mDatabase.delete(LogLevDatabaseHelper.TABLE_NAME, "module = ? AND logmask = ?", new String[]{r8, String.valueOf(r10)});     // Catch: Exception -> L5
    L7:
        if (r11 <= 0) goto L12;
        return true;
    L12:
        return false;
    L5:
        e = move-exception;
        e.printStackTrace();
        r11 = 0;
        goto L7
    }

    public List<LogLevEntry> getAllEntries() {
        ArrayList r8 = new ArrayList();
        Cursor r10 = this.mDatabase.query(LogLevDatabaseHelper.TABLE_NAME, this.allColumns, null, null, null, null, null);     // Catch: Exception -> L17
    L20:
    L10:
        th = move-exception;
        if (r10 != null) goto L22;
    L16:
        throw th;     // Catch: Exception -> L17
    L22:
        r10.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L17
        goto L16
    L5:
        if (r10.moveToNext() == false) goto L8;
        r8.add(cursorToEntry(r10));     // Catch: Throwable -> L10
    L8:
        r10.close();     // Catch: Exception -> L17
    L19:
        return r8;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public LogLevEntry getLogEntry(String r10, int r11) {
        String[] r8 = {r10, String.valueOf(r11)};
        LogLevEntry r12 = null;
        Cursor r13 = this.mDatabase.query(LogLevDatabaseHelper.TABLE_NAME, this.allColumns, "module = ? AND logmask = ?", r8, null, null, null);     // Catch: Exception -> L18
        if (r13 != null) goto L21;
    L15:
        if (r13 == null) goto L20;
        r13.close();     // Catch: Exception -> L18
    L20:
        return r12;
    L21:
    L9:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L12
    L14:
        throw th;     // Catch: Exception -> L18
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L18
        goto L14
    L6:
        if (r13.moveToFirst() == false) goto L15;
        r12 = cursorToEntry(r13);     // Catch: Throwable -> L9
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public void open() {
        if (this.mDatabase.isOpen() == true) goto L6;
        this.mDatabase = this.mDbHelper.getWritableDatabase();
        return;
    }

    public boolean updateLogEntry(LogLevEntry r8) {
        ContentValues r10 = new ContentValues();
        r10.put(LogLevDatabaseHelper.COLUMN_STARTED_DATE, r8.getStartedDate());
        r10.put(LogLevDatabaseHelper.COLUMN_INVALID_DATE, r8.getInvalidDate());
        int r11 = this.mDatabase.update(LogLevDatabaseHelper.TABLE_NAME, r10, "module = ? AND logmask = ?", new String[]{r8.getModule(), String.valueOf(r8.getLogmask())});     // Catch: Exception -> L5
    L7:
        if (r11 <= 0) goto L12;
        return true;
    L12:
        return false;
    L5:
        e = move-exception;
        e.printStackTrace();
        r11 = 0;
        goto L7
    }
}
