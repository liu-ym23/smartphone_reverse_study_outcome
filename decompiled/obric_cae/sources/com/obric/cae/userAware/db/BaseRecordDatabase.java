package com.obric.cae.userAware.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.DateFormat;
import com.obric.cae.log.CommSenseLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseRecordDatabase<T> {
    public static final String COLUMN_HAS_FEEDBACK = "has_feedback";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IS_CORRECT = "is_correct";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final int STATUS_USER_CHOICE_FALSE = 0;
    public static final int STATUS_USER_CHOICE_TRUE = 1;
    public static final String TAG = "BaseRecordDatabase";
    private final SQLiteOpenHelper databaseHelper;
    private final String tableName;

    /* JADX INFO: renamed from: com.obric.cae.userAware.db.BaseRecordDatabase$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class SingleTableDatabaseHelper extends SQLiteOpenHelper {
        private final String createTableSql;
        private final String tableName;

        private SingleTableDatabaseHelper(Context r8, String r10, int r11, String r12, String r13) {
            super(r8, r10, null, r11);
            this.tableName = r12;
            this.createTableSql = r13;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r8) {
            r8.execSQL(this.createTableSql);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
            r8.execSQL("DROP TABLE IF EXISTS " + this.tableName);
            onCreate(r8);
        }

        public /* synthetic */ SingleTableDatabaseHelper(Context r8, String r10, int r11, String r12, String r13, AnonymousClass1 r14) {
            this(r8, r10, r11, r12, r13);
        }
    }

    public BaseRecordDatabase(Context r10, String r11, int r12, String r13, String r14) {
        this(new SingleTableDatabaseHelper(r10, r11, r12, r13, r14, null), r13);
    }

    public int batchUpdateFeedback(List<Long> r10, boolean r11) {
        if (r10.isEmpty() == false) goto L26;
        return 0;
    L26:
        SQLiteDatabase r8 = getWritableDatabase();     // Catch: Throwable -> L19
        r8.beginTransaction();     // Catch: Throwable -> L17
        ContentValues r12 = new ContentValues();     // Catch: Throwable -> L17
        r12.put("has_feedback", 1);     // Catch: Throwable -> L17
        if (r11 == false) goto L9;
        int r13 = 1;
    L10:
        r12.put(COLUMN_IS_CORRECT, Integer.valueOf(r13));     // Catch: Throwable -> L17
        Iterator<Long> r14 = r10.iterator();     // Catch: Throwable -> L17
        int r15 = 0;
    L12:
        if (r14.hasNext() == false) goto L14;
        r15 = r15 + r8.update(this.tableName, r12, "_id = ?", new String[]{String.valueOf(r14.next().longValue())});     // Catch: Throwable -> L17
        goto L12
    L14:
        r8.setTransactionSuccessful();     // Catch: Throwable -> L17
        CommSenseLog.d(getTag(), "batchUpdateFeedback: totalAffected: " + r15);     // Catch: Throwable -> L17
        r8.endTransaction();
        r8.close();
        return r15;
    L9:
        r13 = 0;
    L17:
        th = th;
    L21:
        if (r8 == null) goto L23;
        r8.endTransaction();
        r8.close();
    L23:
        throw th;
    L19:
        th = th;
        r8 = null;
        goto L21
    }

    public void close() {
        this.databaseHelper.close();
    }

    public void deleteAllRecords() {
        SQLiteDatabase r8 = null;
        SQLiteDatabase r10 = getWritableDatabase();     // Catch: Throwable -> L9
        r10.delete(this.tableName, null, null);     // Catch: Throwable -> L7
        r10.close();
        return;
    L7:
        th = th;
        r8 = r10;
    L10:
        if (r8 == null) goto L12;
        r8.close();
    L12:
        throw th;
    L9:
        th = th;
        goto L10
    }

    public List<String> getAllRecordDates() {
        HashSet r8 = new HashSet();
        Cursor r10 = null;
        SQLiteDatabase r14 = getReadableDatabase();     // Catch: Throwable -> L13
        r10 = r14.query(true, this.tableName, new String[]{"timestamp"}, null, null, null, null, "timestamp DESC", null);     // Catch: Throwable -> L11
        if (r10.moveToFirst() == false) goto L9;
    L7:
        r8.add((String) DateFormat.format("yyyy-MM-dd", new Date(r10.getLong(r10.getColumnIndexOrThrow("timestamp")))));     // Catch: Throwable -> L11
        if (r10.moveToNext() == true) goto L7;
    L9:
        r10.close();
        r14.close();
        ArrayList r11 = new ArrayList(r8);
        r11.add(0, "all");
        return r11;
    L11:
        th = th;
    L15:
        if (r10 == null) goto L17;
        r10.close();
    L17:
        if (r14 == null) goto L19;
        r14.close();
    L19:
        throw th;
    L13:
        th = th;
        r14 = null;
        goto L15
    }

    public List<T> getAllRecords() {
        ArrayList r8 = new ArrayList();
        Cursor r10 = null;
        SQLiteDatabase r11 = getReadableDatabase();     // Catch: Throwable -> L12
        r10 = r11.query(this.tableName, null, null, null, null, null, "timestamp DESC");     // Catch: Throwable -> L10
        if (r10.moveToFirst() == false) goto L8;
    L6:
        r8.add(parseRecordFromCursor(r10));     // Catch: Throwable -> L10
        if (r10.moveToNext() == true) goto L6;
    L8:
        r10.close();
        r11.close();
        return r8;
    L10:
        th = th;
    L14:
        if (r10 == null) goto L16;
        r10.close();
    L16:
        if (r11 == null) goto L18;
        r11.close();
    L18:
        throw th;
    L12:
        th = th;
        r11 = null;
        goto L14
    }

    public T getLatestRecord() {
        T r8 = (T) null;
        SQLiteDatabase r10 = getReadableDatabase();     // Catch: Throwable -> L14
        Cursor r11 = r10.query(this.tableName, null, null, null, null, null, "timestamp DESC", "1");     // Catch: Throwable -> L12
    L10:
        th = th;
        r8 = (T) r11;
    L16:
        if (r8 == null) goto L18;
        r8.close();
    L18:
        if (r10 == null) goto L20;
        r10.close();
    L20:
        throw th;
    L6:
        if (r11.moveToFirst() == false) goto L8;
        r8 = parseRecordFromCursor(r11);     // Catch: Throwable -> L10
    L8:
        r11.close();
        r10.close();
        return (T) r8;
    L12:
        th = th;
    L14:
        th = th;
        r10 = null;
        goto L16
    }

    public SQLiteDatabase getReadableDatabase() {
        return this.databaseHelper.getReadableDatabase();
    }

    public T getRecordById(long r11) {
        T r8 = (T) null;
        SQLiteDatabase r10 = getReadableDatabase();     // Catch: Throwable -> L14
        Cursor r12 = r10.query(this.tableName, null, "_id = ?", new String[]{String.valueOf(r11)}, null, null, null);     // Catch: Throwable -> L12
    L10:
        th = th;
        r8 = (T) r12;
    L16:
        if (r8 == null) goto L18;
        r8.close();
    L18:
        if (r10 == null) goto L20;
        r10.close();
    L20:
        throw th;
    L6:
        if (r12.moveToFirst() == false) goto L8;
        r8 = parseRecordFromCursor(r12);     // Catch: Throwable -> L10
    L8:
        r12.close();
        r10.close();
        return (T) r8;
    L12:
        th = th;
    L14:
        th = th;
        r10 = null;
        goto L16
    }

    public List<T> getRecordsByDate(String r13) {
        ArrayList r8 = new ArrayList();
        Cursor r10 = null;
        SQLiteDatabase r11 = getReadableDatabase();     // Catch: Throwable -> L15
        r10 = r11.query(this.tableName, null, null, null, null, null, "timestamp DESC");     // Catch: Throwable -> L13
        if (r10.moveToFirst() == false) goto L11;
    L6:
        if (((String) DateFormat.format("yyyy-MM-dd", new Date(r10.getLong(r10.getColumnIndexOrThrow("timestamp"))))).equals(r13) == false) goto L10;
        r8.add(parseRecordFromCursor(r10));     // Catch: Throwable -> L13
    L10:
        if (r10.moveToNext() == true) goto L6;
    L11:
        r10.close();
        r11.close();
        return r8;
    L13:
        th = th;
    L17:
        if (r10 == null) goto L19;
        r10.close();
    L19:
        if (r11 == null) goto L21;
        r11.close();
    L21:
        throw th;
    L15:
        th = th;
        r11 = null;
        goto L17
    }

    public abstract String getTag();

    public SQLiteDatabase getWritableDatabase() {
        return this.databaseHelper.getWritableDatabase();
    }

    public void insertRecord(T r8) {
        SQLiteDatabase r10 = null;
        SQLiteDatabase r11 = getWritableDatabase();     // Catch: Throwable -> L9
        ContentValues r12 = toContentValues(r8);     // Catch: Throwable -> L7
        r11.insert(this.tableName, null, r12);     // Catch: Throwable -> L7
        r11.close();
        return;
    L7:
        th = th;
        r10 = r11;
    L10:
        if (r10 == null) goto L12;
        r10.close();
    L12:
        throw th;
    L9:
        th = th;
        goto L10
    }

    public abstract T parseRecordFromCursor(Cursor r8);

    public abstract ContentValues toContentValues(T r8);

    public int updateRecordFeedback(long r8, boolean r10) {
        SQLiteDatabase r11 = getWritableDatabase();     // Catch: Throwable -> L12
        ContentValues r12 = new ContentValues();     // Catch: Throwable -> L10
        r12.put("has_feedback", 1);     // Catch: Throwable -> L10
        if (r10 == false) goto L6;
        int r13 = 1;
    L7:
        r12.put(COLUMN_IS_CORRECT, Integer.valueOf(r13));     // Catch: Throwable -> L10
        int r14 = r11.update(this.tableName, r12, "_id = ?", new String[]{String.valueOf(r8)});     // Catch: Throwable -> L10
        r11.close();
        return r14;
    L6:
        r13 = 0;
    L10:
        th = th;
    L14:
        if (r11 == null) goto L16;
        r11.close();
    L16:
        throw th;
    L12:
        th = th;
        r11 = null;
        goto L14
    }

    public BaseRecordDatabase(SQLiteOpenHelper r8, String r10) {
        this.databaseHelper = r8;
        this.tableName = r10;
    }
}
