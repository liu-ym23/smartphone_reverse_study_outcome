package com.obric.cae.location.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import com.obric.cae.log.CommSenseLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StarPoiDbManager {
    private static final String DB_CREATE_POI_DATAS = "create table poi_datas (_id INTEGER PRIMARY KEY,new_type_name_l1 TEXT DEFAULT '',new_type_name_l2 TEXT DEFAULT '',new_type_name_l3 TEXT DEFAULT '',new_type_code_l1 TEXT DEFAULT '',new_type_code_l2 TEXT DEFAULT '',new_type_code_l3 TEXT DEFAULT '',UNIQUE(new_type_name_l1,new_type_name_l2,new_type_name_l3,new_type_code_l1,new_type_code_l2,new_type_code_l3));";
    private static final String DB_CREATE_POI_DATAS_CODE_INDEX = "CREATE INDEX IF NOT EXISTS poi_datas_code_index ON poi_datas (new_type_code_l1,new_type_code_l2,new_type_code_l3);";
    private static final String DB_DELETE_POI_DATAS = "DROP TABLE IF EXISTS poi_datas";
    private static final String POI_DB_NAME = "star_pois.db";
    private static final int POI_DB_VERSION = 1;
    public static final String TABLE_NAME_POI_DATAS = "poi_datas";
    private static final String TAG = "StarLocation-poi-db";
    private static volatile StarPoiDbManager sInstance;
    private final StarPoiDbHelper mDbHelper;

    public static class PoiData {
        public final String newTypeCodeL1;
        public final String newTypeCodeL2;
        public final String newTypeCodeL3;
        public final String newTypeNameL1;
        public final String newTypeNameL2;
        public final String newTypeNameL3;

        public PoiData(String r8, String r10, String r11, String r12, String r13, String r14) {
            if (r8 != null) goto L5;
            r8 = "";
        L5:
            this.newTypeNameL1 = r8;
            if (r10 != null) goto L8;
            r10 = "";
        L8:
            this.newTypeNameL2 = r10;
            if (r11 != null) goto L11;
            r11 = "";
        L11:
            this.newTypeNameL3 = r11;
            if (r12 != null) goto L14;
            r12 = "";
        L14:
            this.newTypeCodeL1 = r12;
            if (r13 != null) goto L17;
            r13 = "";
        L17:
            this.newTypeCodeL2 = r13;
            if (r14 != null) goto L20;
            r14 = "";
        L20:
            this.newTypeCodeL3 = r14;
        }

        public boolean isValid() {
            if (this.newTypeCodeL3.isEmpty() == false) goto L5;
        L7:
            return false;
        L5:
            if ("0".equals(this.newTypeCodeL3) == true) goto L7;
            return true;
        }
    }

    public static class PoiDataEntry implements BaseColumns {
        public static final String NEW_TYPE_CODE_L1 = "new_type_code_l1";
        public static final String NEW_TYPE_CODE_L2 = "new_type_code_l2";
        public static final String NEW_TYPE_CODE_L3 = "new_type_code_l3";
        public static final String NEW_TYPE_NAME_L1 = "new_type_name_l1";
        public static final String NEW_TYPE_NAME_L2 = "new_type_name_l2";
        public static final String NEW_TYPE_NAME_L3 = "new_type_name_l3";

        public PoiDataEntry() {
        }
    }

    public static class StarPoiDbHelper extends SQLiteOpenHelper {
        public StarPoiDbHelper(Context r8) {
            super(r8, StarPoiDbManager.POI_DB_NAME, null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r8) {
            r8.execSQL(StarPoiDbManager.DB_CREATE_POI_DATAS);
            r8.execSQL(StarPoiDbManager.DB_CREATE_POI_DATAS_CODE_INDEX);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r8, int r10, int r11) {
            CommSenseLog.w(StarPoiDbManager.TAG, "Downgrading database from version " + r10 + " to " + r11);
            r8.execSQL(StarPoiDbManager.DB_DELETE_POI_DATAS);
            onCreate(r8);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r8) {
            super.onOpen(r8);
            StarPoiDbManager.access$000(r8);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
            CommSenseLog.i(StarPoiDbManager.TAG, "Upgrading database from version " + r10 + " to " + r11);
            r8.execSQL(StarPoiDbManager.DB_DELETE_POI_DATAS);
            onCreate(r8);
        }
    }

    private StarPoiDbManager(Context r8) {
        this.mDbHelper = new StarPoiDbHelper(r8.getApplicationContext());
    }

    public static /* synthetic */ void access$000(SQLiteDatabase r8) {
        ensurePoiDatasSchema(r8);
    }

    private static PoiData buildPoiDataFromCursor(Cursor r8) {
        return new PoiData(r8.getString(r8.getColumnIndexOrThrow("new_type_name_l1")), r8.getString(r8.getColumnIndexOrThrow("new_type_name_l2")), r8.getString(r8.getColumnIndexOrThrow("new_type_name_l3")), r8.getString(r8.getColumnIndexOrThrow("new_type_code_l1")), r8.getString(r8.getColumnIndexOrThrow("new_type_code_l2")), r8.getString(r8.getColumnIndexOrThrow("new_type_code_l3")));
    }

    private ContentValues buildPoiDataValues(PoiData r8) {
        ContentValues r10 = new ContentValues();
        r10.put("new_type_name_l1", r8.newTypeNameL1);
        r10.put("new_type_name_l2", r8.newTypeNameL2);
        r10.put("new_type_name_l3", r8.newTypeNameL3);
        r10.put("new_type_code_l1", r8.newTypeCodeL1);
        r10.put("new_type_code_l2", r8.newTypeCodeL2);
        r10.put("new_type_code_l3", r8.newTypeCodeL3);
        return r10;
    }

    private static void deleteInvalidPoiDatas(SQLiteDatabase r8) {
        int r10 = r8.delete(TABLE_NAME_POI_DATAS, "new_type_code_l3 IS NULL OR new_type_code_l3='' OR new_type_code_l3='0'", null);
        if (r10 <= 0) goto L6;
        CommSenseLog.iWithMethodName(TAG, "deleted invalid poi_datas count=" + r10);
        return;
    }

    private static boolean doesTableExist(SQLiteDatabase r8, String r10) {
        Cursor r11 = r8.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{r10});
        if (r11 != null) goto L17;
    L13:
        boolean r12 = false;
    L14:
        if (r11 == null) goto L16;
        r11.close();
    L16:
        return r12;
    L17:
        if (r11.moveToFirst() == false) goto L13;
        r12 = true;
    L7:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L10
    L12:
        throw th;
    L10:
        th = move-exception;
        th.addSuppressed(th);
        goto L12
    }

    private static void ensurePoiDatasSchema(SQLiteDatabase r8) {
        if (doesTableExist(r8, TABLE_NAME_POI_DATAS) == true) goto L5;
        r8.execSQL(DB_CREATE_POI_DATAS);
        CommSenseLog.i(TAG, "created poi_datas table");
    L5:
        r8.execSQL(DB_CREATE_POI_DATAS_CODE_INDEX);
        deleteInvalidPoiDatas(r8);
    }

    public static synchronized StarPoiDbManager getInstance(Context r8) {
        monitor-enter(StarPoiDbManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new StarPoiDbManager(r8);     // Catch: Throwable -> L10
    L7:
        StarPoiDbManager r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(StarPoiDbManager.class);
        return r10;
    }

    private static String[] getPoiDataColumns() {
        return new String[]{"new_type_name_l1", "new_type_name_l2", "new_type_name_l3", "new_type_code_l1", "new_type_code_l2", "new_type_code_l3"};
    }

    private List<PoiData> queryLegacyPoiDatas(SQLiteDatabase r10) {
        ArrayList r8 = new ArrayList();
        Cursor r11 = r10.query(TABLE_NAME_POI_DATAS, getPoiDataColumns(), null, null, null, null, null);     // Catch: Exception -> L22
        if (r11 != null) goto L26;
        if (r11 == null) goto L7;
        r11.close();     // Catch: Exception -> L22
    L7:
        return r8;
    L26:
    L16:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Exception -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L22
        goto L21
    L9:
        if (r11.moveToNext() == false) goto L14;
        PoiData r12 = buildPoiDataFromCursor(r11);     // Catch: Throwable -> L16
        if (r12.isValid() == false) goto L26;
        r8.add(r12);     // Catch: Throwable -> L16
    L14:
        r11.close();     // Catch: Exception -> L22
    L24:
        return r8;
    L22:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "query legacy poi_datas failed", e);
        goto L24
    }

    private int replacePoiDatasLocked(SQLiteDatabase r8, List<PoiData> r10) {
        Iterator<PoiData> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L15;
        PoiData r13 = r11.next();
        if (r13 == null) goto L4;
        if (r13.isValid() == false) goto L4;
        if (r8.replace(TABLE_NAME_POI_DATAS, null, buildPoiDataValues(r13)) == (-1)) goto L14;
        r12 = r12 + 1;
        goto L4
    L14:
        throw new IllegalStateException("replace failed for poiData");
    L15:
        return r12;
    }

    public synchronized PoiData findPoiDataByNewTypeCodeL3(String r14) {
        monitor-enter(this);
        if (r14 != null) goto L44;
    L38:
        monitor-exit(this);
        return null;
    L44:
    L35:
        th = move-exception;
        throw th;
    L7:
        if (r14.isEmpty() == true) goto L38;
        SQLiteDatabase r8 = this.mDbHelper.getReadableDatabase();     // Catch: Throwable -> L35
        ensurePoiDatasSchema(r8);     // Catch: Throwable -> L35
        Cursor r10 = r8.query(TABLE_NAME_POI_DATAS, getPoiDataColumns(), "new_type_code_l3=?", new String[]{r14}, null, null, null, "1");     // Catch: Exception -> L31 Throwable -> L35
        if (r10 != null) goto L40;
    L19:
        CommSenseLog.iWithMethodName(TAG, "no poi data for newTypeCodeL3=".concat(r14));     // Catch: Throwable -> L24
        if (r10 == null) goto L22;
        r10.close();     // Catch: Exception -> L31 Throwable -> L35
    L22:
        monitor-exit(this);
        return null;
    L40:
    L24:
        th = move-exception;
        if (r10 != null) goto L42;
    L30:
        throw th;     // Catch: Exception -> L31 Throwable -> L35
    L42:
        r10.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L31 Throwable -> L35
        goto L30
    L13:
        if (r10.moveToFirst() == false) goto L19;
        PoiData r11 = buildPoiDataFromCursor(r10);     // Catch: Throwable -> L24
        r10.close();     // Catch: Exception -> L31 Throwable -> L35
        monitor-exit(this);
        return r11;
    L31:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed newTypeCodeL3=".concat(r14), e);     // Catch: Throwable -> L35
        return null;
    }

    public synchronized boolean hasPoiDatas() {
        monitor-enter(this);
        SQLiteDatabase r8 = this.mDbHelper.getReadableDatabase();     // Catch: Throwable -> L29
        ensurePoiDatasSchema(r8);     // Catch: Throwable -> L29
        Cursor r10 = r8.rawQuery("SELECT COUNT(1) FROM poi_datas", null);     // Catch: Exception -> L25 Throwable -> L29
        if (r10 != null) goto L36;
    L17:
        int r11 = -1;
    L18:
        if (r11 <= 0) goto L20;
        boolean r12 = true;
    L21:
        if (r10 == null) goto L23;
        r10.close();     // Catch: Exception -> L25 Throwable -> L29
    L23:
        monitor-exit(this);
        return r12;
    L20:
        r12 = false;
        goto L21
    L36:
    L11:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L14
    L16:
        throw th;     // Catch: Exception -> L25 Throwable -> L29
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L25 Throwable -> L29
        goto L16
    L8:
        if (r10.moveToFirst() == false) goto L17;
        r11 = r10.getInt(0);     // Catch: Throwable -> L11
    L25:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);     // Catch: Throwable -> L29
        return false;
    L29:
        th = move-exception;
        throw th;
    }

    public synchronized int importLegacyPoiDatas(SQLiteDatabase r8) {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (hasPoiDatas() == false) goto L7;
    L27:
        monitor-exit(this);
        return 0;
    L7:
        if (doesTableExist(r8, TABLE_NAME_POI_DATAS) == false) goto L27;
        List<PoiData> r10 = queryLegacyPoiDatas(r8);     // Catch: Throwable -> L29
        if (r10.isEmpty() == false) goto L13;
        monitor-exit(this);
        return 0;
    L13:
        SQLiteDatabase r11 = this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L29
        r11.beginTransaction();     // Catch: Throwable -> L29
        ensurePoiDatasSchema(r11);     // Catch: Throwable -> L18 Exception -> L20
        int r12 = replacePoiDatasLocked(r11, r10);     // Catch: Throwable -> L18 Exception -> L20
        r11.setTransactionSuccessful();     // Catch: Throwable -> L18 Exception -> L20
        CommSenseLog.iWithMethodName(TAG, "imported legacy poi_datas count=" + r12);     // Catch: Throwable -> L18 Exception -> L20
        r11.endTransaction();     // Catch: Throwable -> L29
        monitor-exit(this);
        return r12;
    L20:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "import legacy poi_datas failed", e);     // Catch: Throwable -> L18
        r11.endTransaction();     // Catch: Throwable -> L29
        return 0;
    L18:
        th = move-exception;
        r11.endTransaction();     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    }

    public synchronized boolean replacePoiDatas(List<PoiData> r8) {
        monitor-enter(this);
        boolean r10 = false;
        if (r8.isEmpty() == false) goto L9;
        CommSenseLog.wWithMethodName(TAG, "poiDatas is empty");     // Catch: Throwable -> L25
        monitor-exit(this);
        return false;
    L9:
        SQLiteDatabase r11 = this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L25
        r11.beginTransaction();     // Catch: Throwable -> L25
        ensurePoiDatasSchema(r11);     // Catch: Throwable -> L16 Exception -> L18
        r11.delete(TABLE_NAME_POI_DATAS, null, null);     // Catch: Throwable -> L16 Exception -> L18
        int r12 = replacePoiDatasLocked(r11, r8);     // Catch: Throwable -> L16 Exception -> L18
        r11.setTransactionSuccessful();     // Catch: Throwable -> L16 Exception -> L18
        CommSenseLog.iWithMethodName(TAG, "success count=" + r12);     // Catch: Throwable -> L16 Exception -> L18
        if (r12 <= 0) goto L13;
        r10 = true;
    L13:
        r11.endTransaction();     // Catch: Throwable -> L25
        monitor-exit(this);
        return r10;
    L16:
        th = move-exception;
        r11.endTransaction();     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L18:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);     // Catch: Throwable -> L16
        r11.endTransaction();     // Catch: Throwable -> L25
        return false;
    L25:
        th = move-exception;
        throw th;
    }
}
