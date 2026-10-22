package com.obric.cae.location.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import android.provider.BaseColumns;
import com.android.internal.annotations.GuardedBy;
import com.obric.cae.location.cell.CellPoiDbManager;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;

/* JADX INFO: loaded from: classes.dex */
public class StarCellDbManager {
    private static final String CELL_DB_NAME = "star_cell.db";
    private static final int CELL_DB_VERSION = 1;
    private static final String CELL_IDENTITY_SELECTION = "type = ? AND mcc = ? AND mnc = ? AND lac = ? AND cid = ?";
    private static final String DB_CREATE_CELLS_INFO = "create table cells_info (_id INTEGER PRIMARY KEY,type TEXT,mcc TEXT,mnc TEXT,lac INTEGER,cid INTEGER,latitude REAL,longitude REAL,radius REAL,pois TEXT DEFAULT '',aois TEXT DEFAULT '');";
    private static final String DB_CREATE_CELLS_INFO_UNIQUE_INDEX = "CREATE UNIQUE INDEX IF NOT EXISTS cells_info_unique_index ON cells_info (type,mcc,mnc,lac,cid);";
    private static final String DB_CREATE_NEAR_CELLS_INFO = "create table cells_info (_id INTEGER PRIMARY KEY,type TEXT,mcc TEXT,mnc TEXT,lac INTEGER,cid INTEGER);";
    private static final String DB_DELETE_CELLS_INFO = "DROP TABLE IF EXISTS cells_info";
    public static final String NEAR_CELL_DB_NAME = "near_cell.db";
    private static final int NEAR_CELL_DB_VERSION = 1;
    private static final double NEAR_CELL_DISTANCE_THRESHOLD_METERS = 3000.0d;
    public static final String TABLE_NAME_CELLS_INFO = "cells_info";
    private static final String TAG = "StarLocation-cell-db";
    private static volatile StarCellDbManager sInstance;
    private final Context mAppContext;
    private final StarCellDbHelper mDbHelper;
    private final StarCellDbHelper mNearDbHelper;

    public static class CellInfoEntry implements BaseColumns {
        public static final String AOIS = "aois";
        public static final String CID = "cid";
        public static final String LAC = "lac";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String MCC = "mcc";
        public static final String MNC = "mnc";
        public static final String POIS = "pois";
        public static final String RADIUS = "radius";
        public static final String TYPE = "type";

        public CellInfoEntry() {
        }
    }

    public static class InnerCellInfoEntry {
        private String aois;
        private final long cid;
        private final long lac;
        private Double latitude;
        private Double longitude;
        private final String mcc;
        private final String mnc;
        private String pois;
        private Double radius;
        private final String type;

        public InnerCellInfoEntry(String r8, String r10, String r11, long r12, long r13) {
            this.type = r8;
            this.mcc = r10;
            this.mnc = r11;
            this.lac = r12;
            this.cid = r13;
        }

        public String getAois() {
            return this.aois;
        }

        public long getCid() {
            return this.cid;
        }

        public long getLac() {
            return this.lac;
        }

        public Double getLatitude() {
            return this.latitude;
        }

        public Double getLongitude() {
            return this.longitude;
        }

        public String getMcc() {
            return this.mcc;
        }

        public String getMnc() {
            return this.mnc;
        }

        public String getPois() {
            return this.pois;
        }

        public Double getRadius() {
            return this.radius;
        }

        public String getType() {
            return this.type;
        }

        public void setAois(String r8) {
            this.aois = r8;
        }

        public void setLatitude(double r8) {
            this.latitude = Double.valueOf(r8);
        }

        public void setLongitude(double r8) {
            this.longitude = Double.valueOf(r8);
        }

        public void setPois(String r8) {
            this.pois = r8;
        }

        public void setRadius(double r8) {
            this.radius = Double.valueOf(r8);
        }
    }

    public static class StarCellDbHelper extends SQLiteOpenHelper {
        private final String mCreateCellsInfoSql;
        private final String mDbName;

        public StarCellDbHelper(Context r8, String r10, int r11, String r12) {
            super(r8, r10, null, r11);
            this.mDbName = r10;
            this.mCreateCellsInfoSql = r12;
        }

        private boolean doesTableExist(SQLiteDatabase r8, String r10) {
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

        private void ensureCellsInfoSchema(SQLiteDatabase r8) {
            if (doesTableExist(r8, StarCellDbManager.TABLE_NAME_CELLS_INFO) == true) goto L5;
            r8.execSQL(this.mCreateCellsInfoSql);
            CommSenseLog.i(StarCellDbManager.TAG, "onOpen schema repair created cells_info table, db=" + this.mDbName);
        L5:
            r8.execSQL(StarCellDbManager.DB_CREATE_CELLS_INFO_UNIQUE_INDEX);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r8) {
            r8.execSQL(this.mCreateCellsInfoSql);
            r8.execSQL(StarCellDbManager.DB_CREATE_CELLS_INFO_UNIQUE_INDEX);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r8, int r10, int r11) {
            CommSenseLog.w(StarCellDbManager.TAG, "Downgrading database " + this.mDbName + " from version " + r10 + " to " + r11);
            r8.execSQL(StarCellDbManager.DB_DELETE_CELLS_INFO);
            onCreate(r8);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r8) {
            super.onOpen(r8);
            ensureCellsInfoSchema(r8);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
            CommSenseLog.i(StarCellDbManager.TAG, "Upgrading database " + this.mDbName + " from version " + r10 + " to " + r11);
            r8.beginTransaction();
            r8.execSQL(StarCellDbManager.DB_DELETE_CELLS_INFO);     // Catch: Throwable -> L5 Exception -> L7
            onCreate(r8);     // Catch: Throwable -> L5 Exception -> L7
            r8.setTransactionSuccessful();     // Catch: Throwable -> L5 Exception -> L7
            CommSenseLog.i(StarCellDbManager.TAG, "Database upgrade successful " + this.mDbName + " from " + r10 + " to " + r11);     // Catch: Throwable -> L5 Exception -> L7
        L9:
            r8.endTransaction();
            return;
        L7:
            e = move-exception;
            CommSenseLog.e(StarCellDbManager.TAG, "Error upgrading database " + this.mDbName + " from " + r10 + " to " + r11, e);     // Catch: Throwable -> L5
        L5:
            th = move-exception;
            r8.endTransaction();
            throw th;
        }
    }

    private StarCellDbManager(Context r8) {
        Context r10 = r8.getApplicationContext();
        this.mAppContext = r10;
        this.mDbHelper = new StarCellDbHelper(r10, CELL_DB_NAME, 1, DB_CREATE_CELLS_INFO);
        this.mNearDbHelper = new StarCellDbHelper(r10, NEAR_CELL_DB_NAME, 1, DB_CREATE_NEAR_CELLS_INFO);
    }

    private static String[] buildCellIdentitySelectionArgs(String r8, String r10, String r11, long r12, long r13) {
        return new String[]{r8, r10, r11, String.valueOf(r12), String.valueOf(r13)};
    }

    private ContentValues buildCellInfoValues(InnerCellInfoEntry r8) {
        ContentValues r10 = new ContentValues();
        r10.put("type", r8.getType());
        r10.put(CellInfoEntry.MCC, r8.getMcc());
        r10.put(CellInfoEntry.MNC, r8.getMnc());
        r10.put(CellInfoEntry.LAC, Long.valueOf(r8.getLac()));
        r10.put(CellInfoEntry.CID, Long.valueOf(r8.getCid()));
        if (r8.getLatitude() != null) goto L5;
        r10.putNull("latitude");
    L7:
        if (r8.getLongitude() != null) goto L9;
        r10.putNull(CellInfoEntry.LONGITUDE);
    L11:
        if (r8.getRadius() != null) goto L13;
        r10.putNull("radius");
    L14:
        r10.put(CellInfoEntry.POIS, r8.getPois());
        r10.put(CellInfoEntry.AOIS, r8.getAois());
        return r10;
    L13:
        r10.put("radius", r8.getRadius());
        goto L14
    L9:
        r10.put(CellInfoEntry.LONGITUDE, r8.getLongitude());
        goto L11
    L5:
        r10.put("latitude", r8.getLatitude());
        goto L7
    }

    private ContentValues buildNearCellInfoValues(Cursor r8) {
        ContentValues r10 = new ContentValues();
        r10.put("type", r8.getString(r8.getColumnIndexOrThrow("type")));
        r10.put(CellInfoEntry.MCC, r8.getString(r8.getColumnIndexOrThrow(CellInfoEntry.MCC)));
        r10.put(CellInfoEntry.MNC, r8.getString(r8.getColumnIndexOrThrow(CellInfoEntry.MNC)));
        r10.put(CellInfoEntry.LAC, Long.valueOf(r8.getLong(r8.getColumnIndexOrThrow(CellInfoEntry.LAC))));
        r10.put(CellInfoEntry.CID, Long.valueOf(r8.getLong(r8.getColumnIndexOrThrow(CellInfoEntry.CID))));
        return r10;
    }

    @GuardedBy({"this"})
    private int delete(SQLiteOpenHelper r8, String r10, String r11, String[] r12) {
        CommSenseLog.d(TAG, "DB delete, table=" + r10 + ", whereClause=" + r11);
        return r8.getWritableDatabase().delete(r10, r11, r12);
    }

    private static String[] getCellInfoColumns() {
        return new String[]{"type", CellInfoEntry.MCC, CellInfoEntry.MNC, CellInfoEntry.LAC, CellInfoEntry.CID, "latitude", CellInfoEntry.LONGITUDE, "radius", CellInfoEntry.POIS, CellInfoEntry.AOIS};
    }

    public static synchronized StarCellDbManager getInstance(Context r8) {
        monitor-enter(StarCellDbManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new StarCellDbManager(r8);     // Catch: Throwable -> L10
    L7:
        StarCellDbManager r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(StarCellDbManager.class);
        return r10;
    }

    private static String[] getNearCellInfoColumns() {
        return new String[]{"type", CellInfoEntry.MCC, CellInfoEntry.MNC, CellInfoEntry.LAC, CellInfoEntry.CID};
    }

    private static String[] getNearCellRefreshColumns() {
        return new String[]{"type", CellInfoEntry.MCC, CellInfoEntry.MNC, CellInfoEntry.LAC, CellInfoEntry.CID, "latitude", CellInfoEntry.LONGITUDE};
    }

    private static Double getNullableDouble(Cursor r8, String r10) {
        int r11 = r8.getColumnIndexOrThrow(r10);
        if (r8.isNull(r11) == false) goto L6;
        return null;
    L6:
        return Double.valueOf(r8.getDouble(r11));
    }

    public static boolean isCellWithinDistanceMeters(double r11, double r13, double r15, double r17, double r19) {
        LocationUtil r8 = LocationUtil.getInstance();
        if (r19 >= 0.0d) goto L5;
        return false;
    L5:
        if (r8.isValidCoordinate(r11, r13) == true) goto L7;
        return false;
    L7:
        if (r8.isValidCoordinate(r15, r17) == true) goto L10;
        return false;
    L10:
        if (r8.calculateDistance(r11, r13, r15, r17) > r19) goto L15;
        return true;
    L15:
        return false;
    }

    @GuardedBy({"this"})
    private Cursor query(SQLiteOpenHelper r11, String r12, String[] r13, String r14, String[] r15, String r16, String r17, String r18) {
        CommSenseLog.v(TAG, "DB query, table=" + r12 + ", selection=" + r14);
        return r11.getReadableDatabase().query(r12, r13, r14, r15, r16, r17, r18);
    }

    @GuardedBy({"this"})
    private boolean replace(SQLiteOpenHelper r8, String r10, ContentValues r11) {
        CommSenseLog.d(TAG, "DB replace, table=" + r10 + ", values=" + r11);
        long r12 = r8.getWritableDatabase().replace(r10, null, r11);
        if (r12 != (-1)) goto L5;
        CommSenseLog.d(TAG, "replace failed for " + r10 + " values: " + r11);
    L5:
        if (r12 == (-1)) goto L7;
        return true;
    L7:
        return false;
    }

    public synchronized void closeDatabase() {
        monitor-enter(this);
        this.mDbHelper.close();     // Catch: Throwable -> L5
        this.mNearDbHelper.close();     // Catch: Throwable -> L5
        CommSenseLog.d(TAG, "closeDatabase success");     // Catch: Throwable -> L5
    L7:
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
        CommSenseLog.e(TAG, "closeDatabase failed", th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized int deleteAllNearCellInfo() {
        monitor-enter(this);
        int r8 = delete(this.mNearDbHelper, TABLE_NAME_CELLS_INFO, null, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int deleteCellInfo(String r8, String r10, String r11, long r12, long r13) {
        monitor-enter(this);
        int r14 = delete(this.mDbHelper, TABLE_NAME_CELLS_INFO, CELL_IDENTITY_SELECTION, buildCellIdentitySelectionArgs(r8, r10, r11, r12, r13));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r14;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int deleteNearCellInfo(String r8, String r10, String r11, long r12, long r13) {
        monitor-enter(this);
        int r14 = delete(this.mNearDbHelper, TABLE_NAME_CELLS_INFO, CELL_IDENTITY_SELECTION, buildCellIdentitySelectionArgs(r8, r10, r11, r12, r13));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r14;
    L6:
        th = move-exception;
        throw th;
    }

    public void initRfsDb() {
        CellPoiDbManager.refreshToRfsAsync(this.mAppContext);
    }

    public synchronized boolean insertOrReplaceCellInfo(InnerCellInfoEntry r8) {
        monitor-enter(this);
        if (r8 != null) goto L9;
        CommSenseLog.d(TAG, "insertOrReplaceCellInfo, cellInfo is null");     // Catch: Throwable -> L14
        monitor-exit(this);
        return false;
    L9:
        boolean r10 = replace(TABLE_NAME_CELLS_INFO, buildCellInfoValues(r8));     // Catch: Throwable -> L14
        if (r10 == false) goto L12;
        CommSenseLog.iWithMethodName(TAG, "refreshToRfsAsync after successful cell db write, success=" + CellPoiDbManager.refreshToRfsAsync(this.mAppContext));     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r10;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized boolean insertOrReplaceNearCellInfo(InnerCellInfoEntry r8) {
        monitor-enter(this);
        if (r8 != null) goto L8;
        CommSenseLog.d(TAG, "insertOrReplaceNearCellInfo, cellInfo is null");     // Catch: Throwable -> L11
        monitor-exit(this);
        return false;
    L8:
        boolean r10 = replace(this.mNearDbHelper, TABLE_NAME_CELLS_INFO, buildNearCellInfoValues(r8));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r10;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized boolean openDatabase() {
        monitor-enter(this);
        this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L7 SQLException -> L9
        this.mNearDbHelper.getWritableDatabase();     // Catch: Throwable -> L7 SQLException -> L9
        CommSenseLog.d(TAG, "openDatabase success");     // Catch: Throwable -> L7 SQLException -> L9
        monitor-exit(this);
        return true;
    L9:
        e = move-exception;
        CommSenseLog.e(TAG, "openDatabase failed", e);     // Catch: Throwable -> L7
        return false;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized Cursor queryAllCellInfo() {
        monitor-enter(this);
        Cursor r8 = query(this.mDbHelper, TABLE_NAME_CELLS_INFO, getCellInfoColumns(), null, null, null, null, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Cursor queryAllNearCellInfo() {
        monitor-enter(this);
        Cursor r8 = query(this.mNearDbHelper, TABLE_NAME_CELLS_INFO, getNearCellInfoColumns(), null, null, null, null, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Cursor queryCellInfo(String r12, String r13, String r14, long r15, long r17) {
        monitor-enter(this);
        Cursor r8 = query(this.mDbHelper, TABLE_NAME_CELLS_INFO, getCellInfoColumns(), CELL_IDENTITY_SELECTION, buildCellIdentitySelectionArgs(r12, r13, r14, r15, r17), null, null, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r8;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized Cursor queryNearCellInfo(String r12, String r13, String r14, long r15, long r17) {
        monitor-enter(this);
        Cursor r8 = query(this.mNearDbHelper, TABLE_NAME_CELLS_INFO, getNearCellInfoColumns(), CELL_IDENTITY_SELECTION, buildCellIdentitySelectionArgs(r12, r13, r14, r15, r17), null, null, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r8;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized boolean refreshNearCellDb(Location r22) {
        monitor-enter(this);
        if (r22 != null) goto L58;
    L52:
        CommSenseLog.d(TAG, "refreshNearCellDb skip, invalid last delivered location=" + r22);     // Catch: Throwable -> L55
        monitor-exit(this);
        return false;
    L58:
    L55:
        th = move-exception;
        throw th;
    L7:
        if (LocationUtil.getInstance().isValidCoordinate(r22.getLatitude(), r22.getLongitude()) == false) goto L52;
        SQLiteDatabase r8 = this.mDbHelper.getReadableDatabase();     // Catch: Throwable -> L55
        SQLiteDatabase r10 = this.mNearDbHelper.getWritableDatabase();     // Catch: Throwable -> L55
        r10.beginTransaction();     // Catch: Throwable -> L55
        Cursor r11 = r8.query(TABLE_NAME_CELLS_INFO, getNearCellRefreshColumns(), null, null, null, null, null);     // Catch: Throwable -> L44
        r10.delete(TABLE_NAME_CELLS_INFO, null, null);     // Catch: Throwable -> L35
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L13:
        if (r11.moveToNext() == false) goto L25;
        Double r15 = getNullableDouble(r11, "latitude");     // Catch: Throwable -> L35
        Double r16 = getNullableDouble(r11, CellInfoEntry.LONGITUDE);     // Catch: Throwable -> L35
        if (r15 == null) goto L24;
        if (r16 == null) goto L24;
        if (isCellWithinDistanceMeters(r22.getLatitude(), r22.getLongitude(), r15.doubleValue(), r16.doubleValue(), NEAR_CELL_DISTANCE_THRESHOLD_METERS) == false) goto L24;
        if (r10.replace(TABLE_NAME_CELLS_INFO, null, buildNearCellInfoValues(r11)) == (-1)) goto L22;
        r12 = r12 + 1;     // Catch: Throwable -> L35
        goto L13
    L22:
        r14 = r14 + 1;     // Catch: Throwable -> L35
    L24:
        r13 = r13 + 1;     // Catch: Throwable -> L35
        goto L13
    L25:
        CommSenseLog.dWithMethodName(TAG, "refreshNearCellDb finished, matched=" + r12 + ", skipped=" + r13 + ", failed=" + r14 + ", thresholdMeters=" + NEAR_CELL_DISTANCE_THRESHOLD_METERS + ", location=" + r22.getLatitude() + "," + r22.getLongitude());     // Catch: Throwable -> L35
        if (r14 != 0) goto L28;
        r10.setTransactionSuccessful();     // Catch: Throwable -> L35
    L28:
        if (r14 != 0) goto L30;
        boolean r17 = true;
    L31:
        r11.close();     // Catch: Throwable -> L44
        r10.endTransaction();     // Catch: Throwable -> L55
        monitor-exit(this);
        return r17;
    L30:
        r17 = false;
    L35:
        th = move-exception;
        if (r11 == null) goto L77;
        r11.close();     // Catch: Throwable -> L40
    L78:
        throw th;     // Catch: Throwable -> L44
    L40:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L44
        throw th;     // Catch: Throwable -> L44
    L77:
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CommSenseLog.e(TAG, "refreshNearCellDb failed", th);     // Catch: Throwable -> L49
        r10.endTransaction();     // Catch: Throwable -> L55
        return false;
    L49:
        th = move-exception;
        r10.endTransaction();     // Catch: Throwable -> L55
        throw th;     // Catch: Throwable -> L55
    }

    public synchronized boolean refreshNearCellDbFromLastDeliveredLocation() {
        monitor-enter(this);
        boolean r8 = refreshNearCellDb(LocationUtil.getInstance().getLastDeliveredLocation());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    private ContentValues buildNearCellInfoValues(InnerCellInfoEntry r8) {
        ContentValues r10 = new ContentValues();
        r10.put("type", r8.getType());
        r10.put(CellInfoEntry.MCC, r8.getMcc());
        r10.put(CellInfoEntry.MNC, r8.getMnc());
        r10.put(CellInfoEntry.LAC, Long.valueOf(r8.getLac()));
        r10.put(CellInfoEntry.CID, Long.valueOf(r8.getCid()));
        return r10;
    }

    @GuardedBy({"this"})
    private int delete(String r8, String r10, String[] r11) {
        return delete(this.mDbHelper, r8, r10, r11);
    }

    @GuardedBy({"this"})
    private Cursor query(String r10, String[] r11, String r12, String[] r13, String r14, String r15, String r16) {
        return query(this.mDbHelper, r10, r11, r12, r13, r14, r15, r16);
    }

    @GuardedBy({"this"})
    private boolean replace(String r8, ContentValues r10) {
        return replace(this.mDbHelper, r8, r10);
    }
}
