package com.obric.cae.location.database;

import android.aimedia.a;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.text.TextUtils;
import com.android.internal.annotations.GuardedBy;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.log.CommSenseLog;
import com.qualcomm.qti.qesdk.QesdkUtils;
import defpackage.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class StarLocationDbManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String AOI_BOARD_COPY_COLUMNS = "_id,poi_id,poi_name,aoi_board,state,transition_type,confidence,confidence_source,event_time,type,geofenceId,cells,new_type_code_l3";
    private static final String CITY_ARCHIVE_ALIAS = "city_archive";
    private static final String CITY_ARCHIVE_ROOT_DIR = "star";
    private static final String CITY_INFO_COPY_COLUMNS = "_id,adminArea,subAdminArea,locality,subLocality,updatedAt";
    private static final String DB_CREATE_AOI_BOARD = null;
    private static final String DB_CREATE_CITY_INFO = null;
    private static final String DB_CREATE_GEOFENCE_CALLBACK = "create table geofence_callback (_id INTEGER PRIMARY KEY,packageName TEXT,class TEXT);";
    private static final String DB_CREATE_LOCATION_GEOFENCE = "create table location_geofence (_id INTEGER PRIMARY KEY,userId INTEGER DEFAULT 0,packageName TEXT,id TEXT,latitude REAL,Longitude REAL,radius INTEGER,address TEXT,eventTimestamp INTEGER,transitionType INTEGER,confidence INTEGER,state INTEGER,type INTEGER,firstBreach INTEGER DEFAULT -1,poi_id TEXT DEFAULT '');";
    private static final String DB_DELETE_AOI_BOARD = "DROP TABLE IF EXISTS aoi_board";
    private static final String DB_DELETE_CITY_INFO = "DROP TABLE IF EXISTS city_info";
    private static final String DB_DELETE_GEOFENCE_CALLBACK = "DROP TABLE IF EXISTS geofence_callback";
    private static final String DB_DELETE_LOCATION_GEOFENCE = "DROP TABLE IF EXISTS location_geofence";
    private static final String DB_DROP_CITY_INFO_GEOFENCE_ADDED_INDEX = "DROP INDEX IF EXISTS geofenceAdded";
    private static final String DB_DROP_LEGACY_POI_DATAS = "DROP TABLE IF EXISTS poi_datas";
    private static final int FIRST_BREACH_CONSUMED = 0;
    private static final int FIRST_BREACH_FIRST_NOTIFIED = 1;
    private static final int FIRST_BREACH_PENDING = -1;
    private static final String LEGACY_AOI_BOARD_NEW_TYPE_CODE = "new_type_code";
    private static final String LEGACY_AOI_BOARD_TYPE_CODE = "type_code";
    private static final String LEGACY_TABLE_NAME_POI_DATAS = "poi_datas";
    private static final String LOCATION_DB_NAME = "star_location";
    private static final String LOCATION_DB_NAME_SUFFIX = ".db";
    private static final int LOCATION_DB_VERSION = 12;
    private static final String MAIN_DB_ALIAS = "main";
    public static final String TABLE_NAME_AOI_BOARD = "aoi_board";
    public static final String TABLE_NAME_CITY_INFO = "city_info";
    public static final String TABLE_NAME_GEOFENCE_CALLBACK = "geofence_callback";
    public static final String TABLE_NAME_LOCATION_GEOFENCE = "location_geofence";
    private static final String TAG = "StarLocation-db";
    public static final int USER_ID_ALL = -1;
    private static final Map<Integer, StarLocationDbManager> sInstances = null;

    @GuardedBy({"this"})
    private boolean mCacheLoaded;

    @GuardedBy({"this"})
    private final Map<String, InnerGeofenceCallbackEntry> mCallbackByPkg;
    private final StarDbHelper mDbHelper;

    @GuardedBy({"this"})
    private final Map<String, InnerStarGeofenceEntry> mGeofenceById;

    @GuardedBy({"this"})
    private final Map<String, List<InnerStarGeofenceEntry>> mGeofenceByPkg;
    private final int mUserId;

    /* JADX INFO: renamed from: com.obric.cae.location.database.StarLocationDbManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AoiBoardEntry implements BaseColumns {
        public static final String AOI_BOARD = "aoi_board";
        public static final String CELLS = "cells";
        public static final String CONFIDENCE = "confidence";
        public static final String CONFIDENCE_SOURCE = "confidence_source";
        public static final String EVENT_TIME = "event_time";
        public static final String GEOFENCE_ID = "geofenceId";
        public static final String NEW_TYPE_CODE_L3 = "new_type_code_l3";
        public static final String POI_ID = "poi_id";
        public static final String POI_NAME = "poi_name";
        public static final String STATE = "state";
        public static final String TRANSITION_TYPE = "transition_type";
        public static final String TYPE = "type";

        public AoiBoardEntry() {
        }
    }

    public static final class CellAoiBoardEntry {
        private final AoiBoard aoiBoard;
        private final String cells;
        private final String typeCode;

        public CellAoiBoardEntry(AoiBoard r8, String r10, String r11) {
            this.aoiBoard = r8;
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            this.cells = r10;
            if (r11 != null) goto L8;
            r11 = "";
        L8:
            this.typeCode = r11;
        }

        public static /* synthetic */ AoiBoard access$200(CellAoiBoardEntry r8) {
            return r8.aoiBoard;
        }

        public static /* synthetic */ String access$300(CellAoiBoardEntry r8) {
            return r8.cells;
        }

        public static /* synthetic */ String access$400(CellAoiBoardEntry r8) {
            return r8.typeCode;
        }

        public AoiBoard getAoiBoard() {
            return this.aoiBoard;
        }

        public String getCells() {
            return this.cells;
        }

        public String getTypeCode() {
            return this.typeCode;
        }
    }

    public static class CityEntry implements BaseColumns {
        public static final String ADMIN_AREA = "adminArea";
        public static final String LOCALITY = "locality";
        public static final String SUB_ADMIN_AREA = "subAdminArea";
        public static final String SUB_LOCALITY = "subLocality";
        public static final String UPDATED_AT = "updatedAt";

        public CityEntry() {
        }
    }

    public static class CityInfo {
        public final String adminArea;
        public final String locality;
        public final String subAdminArea;
        public final String subLocality;
        public final long updatedAt;

        public CityInfo(String r8, String r10, String r11, String r12, long r13) {
            this.adminArea = r8;
            this.subAdminArea = r10;
            this.locality = r11;
            this.subLocality = r12;
            this.updatedAt = r13;
        }
    }

    public static final class CityStorageSwitchResult {
        public final boolean cityChanged;
        public final String previousCityKey;
        public final boolean restoredFromArchive;
        public final boolean success;
        public final String targetCityKey;

        private CityStorageSwitchResult(boolean r8, boolean r10, boolean r11, String r12, String r13) {
            this.success = r8;
            this.cityChanged = r10;
            this.restoredFromArchive = r11;
            this.previousCityKey = r12;
            this.targetCityKey = r13;
        }

        public /* synthetic */ CityStorageSwitchResult(boolean r8, boolean r10, boolean r11, String r12, String r13, AnonymousClass1 r14) {
            this(r8, r10, r11, r12, r13);
        }
    }

    public static class GeofenceCallbackEntry implements BaseColumns {
        public static final String CLASS_NAME = "class";
        public static final String PACKAGE_NAME = "packageName";

        public GeofenceCallbackEntry() {
        }
    }

    public static class GeofenceEntry implements BaseColumns {
        public static final String ADDRESS = "address";
        public static final String CONFIDENCE = "confidence";
        public static final String EVENT_TIMESTAMP = "eventTimestamp";
        public static final String FIRST_BREACH = "firstBreach";
        public static final String GEOFENCE_ID = "id";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "Longitude";
        public static final String PACKAGE_NAME = "packageName";
        public static final String POI_ID = "poi_id";
        public static final String RADIUS = "radius";
        public static final String STATE = "state";
        public static final String TRANSITION_TYPE = "transitionType";
        public static final String TYPE = "type";
        public static final String USER_ID = "userId";

        public GeofenceEntry() {
        }
    }

    public static class InnerGeofenceCallbackEntry {
        private String className;
        private final String packageName;

        public InnerGeofenceCallbackEntry(String r8, String r10) {
            this.packageName = r8;
            this.className = r10;
        }

        public String getClassName() {
            return this.className;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setClassName(String r8) {
            this.className = r8;
        }
    }

    public static class InnerStarGeofenceEntry {
        private int firstBreachState;
        private StarGeofence geofence;
        private final String geofenceId;
        private final String packageName;
        private int userId;

        public InnerStarGeofenceEntry(StarGeofence r8, int r10) {
            this(r8, r10, r8.isFirstBreach() ? 1 : 0);
        }

        public int getFirstBreachState() {
            return this.firstBreachState;
        }

        public StarGeofence getGeofence() {
            return this.geofence;
        }

        public String getGeofenceId() {
            return this.geofenceId;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public int getUserId() {
            return this.userId;
        }

        public void setFirstBreachState(int r8) {
            int r10 = StarLocationDbManager.access$000(r8);
            this.firstBreachState = r10;
            StarGeofence r11 = this.geofence;
            if (r11 == null) goto L6;
            r11.setFirstBreach(StarLocationDbManager.access$100(r10));
            return;
        }

        public void setGeofence(StarGeofence r8) {
            this.geofence = r8;
            if (r8 == null) goto L6;
            r8.setFirstBreach(StarLocationDbManager.access$100(this.firstBreachState));
            return;
        }

        public void setUserId(int r8) {
            this.userId = r8;
        }

        public InnerStarGeofenceEntry(StarGeofence r8, int r10, int r11) {
            this.geofence = r8;
            this.packageName = r8.getPackageName();
            this.geofenceId = r8.getGeofenceId();
            this.userId = r10;
            int r12 = StarLocationDbManager.access$000(r11);
            this.firstBreachState = r12;
            this.geofence.setFirstBreach(StarLocationDbManager.access$100(r12));
        }
    }

    public static class StarDbHelper extends SQLiteOpenHelper {
        private final Context mContext;
        private final int mUserId;

        public StarDbHelper(Context r8, int r10) {
            super(r8, getDatabaseName(r10), null, 12);
            this.mContext = r8.getApplicationContext();
            this.mUserId = r10;
        }

        public static /* synthetic */ boolean access$1000(StarDbHelper r8, SQLiteDatabase r10, String r11) {
            return r8.doesTableExist(r10, r11);
        }

        public static /* synthetic */ void access$1100(StarDbHelper r8, SQLiteDatabase r10, String r11, String r12, String r13) {
            r8.ensureColumn(r10, r11, r12, r13);
        }

        public static /* synthetic */ String access$1200(int r8) {
            return getDatabaseName(r8);
        }

        public static /* synthetic */ Context access$1300(StarDbHelper r8) {
            return r8.mContext;
        }

        public static /* synthetic */ void access$900(StarDbHelper r8, SQLiteDatabase r10) {
            r8.ensureAoiBoardSchema(r10);
        }

        private boolean doesColumnExist(SQLiteDatabase r8, String r10, String r11) {
            Cursor r12 = r8.rawQuery("PRAGMA table_info(" + r10 + ")", null);
            if (r12 != null) goto L24;
            if (r12 == null) goto L6;
            r12.close();
        L6:
            return false;
        L24:
            int r13 = r12.getColumnIndex(QesdkUtils.TAGS.JSON_TAG_NAME);     // Catch: Throwable -> L18
        L9:
            if (r12.moveToNext() == false) goto L16;
            if (r13 == (-1)) goto L9;
            if (r11.equals(r12.getString(r13)) == false) goto L9;
            r12.close();
            return true;
        L16:
            r12.close();
            return false;
        L18:
            th = move-exception;
            r12.close();     // Catch: Throwable -> L21
        L23:
            throw th;
        L21:
            th = move-exception;
            th.addSuppressed(th);
            goto L23
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

        private void dropLegacyPoiDatas(SQLiteDatabase r8) {
            if (doesTableExist(r8, "poi_datas") == true) goto L5;
            return;
        L5:
            int r10 = StarPoiDbManager.getInstance(this.mContext).importLegacyPoiDatas(r8);
            r8.execSQL(StarLocationDbManager.DB_DROP_LEGACY_POI_DATAS);
            CommSenseLog.i(StarLocationDbManager.TAG, "dropped legacy poi_datas from star_location.db, importedCount=" + r10);
        }

        private void ensureAoiBoardNewTypeCodeL3Column(SQLiteDatabase r8) {
            boolean r10 = doesColumnExist(r8, "aoi_board", "new_type_code_l3");
            boolean r11 = doesColumnExist(r8, "aoi_board", StarLocationDbManager.LEGACY_AOI_BOARD_TYPE_CODE);
            if (r10 == true) goto L7;
            if (r11 == false) goto L7;
            r8.execSQL("ALTER TABLE aoi_board RENAME COLUMN type_code TO new_type_code_l3");
            CommSenseLog.i(StarLocationDbManager.TAG, "onOpen schema repair renamed aoi_board type_code to new_type_code_l3");
            return;
        L7:
            ensureColumn(r8, "aoi_board", "new_type_code_l3", "TEXT DEFAULT ''");
            if (r11 == false) goto L11;
            r8.execSQL("UPDATE aoi_board SET new_type_code_l3=type_code WHERE (new_type_code_l3 IS NULL OR new_type_code_l3='') AND type_code IS NOT NULL AND type_code!='';");
            return;
        }

        private void ensureAoiBoardSchema(SQLiteDatabase r8) {
            if (doesTableExist(r8, "aoi_board") == true) goto L6;
            r8.execSQL(StarLocationDbManager.access$600());
            CommSenseLog.i(StarLocationDbManager.TAG, "onOpen schema repair created aoi_board table");
            return;
        L6:
            ensureColumn(r8, "aoi_board", AoiBoardEntry.TRANSITION_TYPE, "INTEGER DEFAULT " + AoiBoard.TransitionType.UNKNOWN.ordinal());
            ensureColumn(r8, "aoi_board", "confidence", "INTEGER DEFAULT " + AoiBoard.Confidence.MIN.ordinal());
            ensureColumn(r8, "aoi_board", AoiBoardEntry.CONFIDENCE_SOURCE, "INTEGER DEFAULT " + AoiBoard.ConfidenceSource.DEFAULT.getValue());
            ensureColumn(r8, "aoi_board", "event_time", "INTEGER DEFAULT 0");
            ensureColumn(r8, "aoi_board", "type", "INTEGER DEFAULT " + AoiBoard.Type.UNKNOWN.ordinal());
            ensureColumn(r8, "aoi_board", AoiBoardEntry.GEOFENCE_ID, "TEXT DEFAULT ''");
            ensureColumn(r8, "aoi_board", AoiBoardEntry.CELLS, "TEXT DEFAULT ''");
            ensureAoiBoardNewTypeCodeL3Column(r8);
            removeLegacyAoiBoardNewTypeCodeColumn(r8);
            fillEmptyAoiBoardPoiName(r8);
        }

        private void ensureColumn(SQLiteDatabase r8, String r10, String r11, String r12) {
            if (doesColumnExist(r8, r10, r11) == false) goto L5;
            return;
        L5:
            StringBuilder r13 = b.i("ALTER TABLE ", r10, " ADD COLUMN ", r11, " ");
            r13.append(r12);
            r13.append(";");
            r8.execSQL(r13.toString());
            CommSenseLog.i(StarLocationDbManager.TAG, "schema repair added " + r11 + " column to " + r10);
        }

        private void ensureLocationGeofenceSchema(SQLiteDatabase r8) {
            if (doesTableExist(r8, StarLocationDbManager.TABLE_NAME_LOCATION_GEOFENCE) == true) goto L6;
            return;
        L6:
            if (doesColumnExist(r8, StarLocationDbManager.TABLE_NAME_LOCATION_GEOFENCE, "poi_id") == true) goto L9;
            r8.execSQL("ALTER TABLE location_geofence ADD COLUMN poi_id TEXT DEFAULT '';");
            CommSenseLog.i(StarLocationDbManager.TAG, "onOpen schema repair added poi_id column");
            return;
        }

        private void fillEmptyAoiBoardPoiName(SQLiteDatabase r8) {
            ContentValues r10 = new ContentValues();
            r10.put("poi_name", "");
            int r11 = r8.update("aoi_board", r10, "poi_name IS NULL", null);
            r8.execSQL("UPDATE aoi_board SET poi_name=poi_id WHERE poi_name='';");
            if (r11 <= 0) goto L6;
            CommSenseLog.i(StarLocationDbManager.TAG, "schema repair normalized null aoi_board poi_name count=" + r11);
            return;
        }

        private static String getDatabaseName(int r8) {
            if (r8 != 0) goto L5;
            return "star_location.db";
        L5:
            return a.c("star_location_", r8, StarLocationDbManager.LOCATION_DB_NAME_SUFFIX);
        }

        private void migrateFromV10ToV11(SQLiteDatabase r8) {
            ensureAoiBoardSchema(r8);
            CommSenseLog.i(StarLocationDbManager.TAG, "v10->v11 migration added or repaired aoi_board cell columns");
        }

        private void migrateFromV11ToV12(SQLiteDatabase r8) {
            dropLegacyPoiDatas(r8);
            CommSenseLog.i(StarLocationDbManager.TAG, "v11->v12 migration moved poi_datas out of star_location.db");
        }

        private void migrateFromV3ToV4(SQLiteDatabase r8) {
            CommSenseLog.i(StarLocationDbManager.TAG, "Upgrading location_geofence table from v3 to v4: Adding firstBreach column.");
            r8.execSQL("ALTER TABLE location_geofence ADD COLUMN firstBreach INTEGER DEFAULT 0;");
            CommSenseLog.i(StarLocationDbManager.TAG, "Added firstBreach column with default value 0 to location_geofence");
            CommSenseLog.i(StarLocationDbManager.TAG, "Database upgraded from version 3 to 4.");
        }

        private void migrateFromV4ToV5(SQLiteDatabase r8) {
            if (doesTableExist(r8, StarLocationDbManager.TABLE_NAME_LOCATION_GEOFENCE) == true) goto L6;
            CommSenseLog.w(StarLocationDbManager.TAG, "Skipping v4->v5 migration because table does not exist: location_geofence");
            return;
        L6:
            ContentValues r10 = new ContentValues();
            r10.put("packageName", "com.larus.nova");
            CommSenseLog.i(StarLocationDbManager.TAG, "v4->v5 migration updated packageName from com.obric.memorydata to com.larus.nova, affectedRows=" + r8.update(StarLocationDbManager.TABLE_NAME_LOCATION_GEOFENCE, r10, "packageName = ?", new String[]{"com.obric.memorydata"}));
        }

        private void migrateFromV5ToV6(SQLiteDatabase r8) {
            if (doesTableExist(r8, StarLocationDbManager.TABLE_NAME_CITY_INFO) == true) goto L6;
            r8.execSQL(StarLocationDbManager.access$500());
            CommSenseLog.i(StarLocationDbManager.TAG, "Created table city_info in v6 migration.");
            return;
        }

        private void migrateFromV6ToV7(SQLiteDatabase r8) {
            if (doesTableExist(r8, StarLocationDbManager.TABLE_NAME_LOCATION_GEOFENCE) == true) goto L6;
            CommSenseLog.w(StarLocationDbManager.TAG, "Skipping v6->v7 migration because table does not exist: location_geofence");
            return;
        L6:
            r8.execSQL("ALTER TABLE location_geofence ADD COLUMN userId INTEGER DEFAULT 0;");
            ContentValues r10 = new ContentValues();
            r10.put(GeofenceEntry.USER_ID, Integer.valueOf(this.mUserId));
            StarGeofence.GeoType r11 = StarGeofence.GeoType.TRAFFIC;
            int r12 = r8.update(StarLocationDbManager.TABLE_NAME_LOCATION_GEOFENCE, r10, "type != ?", new String[]{String.valueOf(r11.ordinal())});
            ContentValues r13 = new ContentValues();
            r13.put(GeofenceEntry.USER_ID, -1);
            StringBuilder r14 = defpackage.a.g("v6->v7 migration added userId column, updatedRows=", r12, ", updatedTrafficRows=", r8.update(StarLocationDbManager.TABLE_NAME_LOCATION_GEOFENCE, r13, "type = ?", new String[]{String.valueOf(r11.ordinal())}), ", dbUserId=");
            r14.append(this.mUserId);
            CommSenseLog.i(StarLocationDbManager.TAG, r14.toString());
        }

        private void migrateFromV7ToV8(SQLiteDatabase r8) {
            if (doesTableExist(r8, StarLocationDbManager.TABLE_NAME_LOCATION_GEOFENCE) == true) goto L7;
            CommSenseLog.w(StarLocationDbManager.TAG, "Skipping v7->v8 migration because table does not exist: location_geofence");
            return;
        L7:
            if (doesColumnExist(r8, StarLocationDbManager.TABLE_NAME_LOCATION_GEOFENCE, "poi_id") == true) goto L10;
            r8.execSQL("ALTER TABLE location_geofence ADD COLUMN poi_id TEXT DEFAULT '';");
            CommSenseLog.i(StarLocationDbManager.TAG, "v7->v8 migration added poi_id column");
        L10:
            if (doesTableExist(r8, "aoi_board") == true) goto L13;
            r8.execSQL(StarLocationDbManager.access$600());
            CommSenseLog.i(StarLocationDbManager.TAG, "v7->v8 migration created aoi_board table");
            return;
        }

        private void migrateFromV8ToV9(SQLiteDatabase r8) {
            r8.execSQL(StarLocationDbManager.DB_DROP_CITY_INFO_GEOFENCE_ADDED_INDEX);
            if (doesTableExist(r8, StarLocationDbManager.TABLE_NAME_CITY_INFO) == true) goto L7;
            r8.execSQL(StarLocationDbManager.access$500());
            String r10 = "v8->v9 migration created missing city_info table";
        L5:
            CommSenseLog.i(StarLocationDbManager.TAG, r10);
            if (doesTableExist(r8, "aoi_board") == true) goto L15;
            r8.execSQL(StarLocationDbManager.access$600());
            String r11 = "v8->v9 migration created missing aoi_board table";
        L13:
            CommSenseLog.i(StarLocationDbManager.TAG, r11);
        L17:
            ensureAoiBoardSchema(r8);
            return;
        L15:
            if (doesColumnExist(r8, "aoi_board", AoiBoardEntry.GEOFENCE_ID) == true) goto L17;
            r8.execSQL("ALTER TABLE aoi_board ADD COLUMN geofenceId TEXT DEFAULT '';");
            r11 = "v8->v9 migration added geofenceId column to aoi_board";
            goto L13
        L7:
            if (doesColumnExist(r8, StarLocationDbManager.TABLE_NAME_CITY_INFO, "geofenceAdded") == true) goto L9;
            r10 = "v8->v9 migration dropped city_info geofenceAdded index if existed";
            goto L5
        L9:
            r8.execSQL("DROP TABLE IF EXISTS city_info_v9_temp");
            r8.execSQL(StarLocationDbManager.access$700("city_info_v9_temp"));
            r8.execSQL("INSERT INTO city_info_v9_temp (_id,adminArea,subAdminArea,locality,subLocality,updatedAt) SELECT _id,adminArea,subAdminArea,locality,subLocality,updatedAt FROM city_info");
            r8.execSQL(StarLocationDbManager.DB_DELETE_CITY_INFO);
            r8.execSQL("ALTER TABLE city_info_v9_temp RENAME TO city_info");
            r10 = "v8->v9 migration removed geofenceAdded column and index from city_info";
            goto L5
        }

        private void migrateFromV9ToV10(SQLiteDatabase r8) {
            CommSenseLog.i(StarLocationDbManager.TAG, "v9->v10 migration skipped legacy poi_datas creation");
        }

        private void removeLegacyAoiBoardNewTypeCodeColumn(SQLiteDatabase r8) {
            if (doesColumnExist(r8, "aoi_board", StarLocationDbManager.LEGACY_AOI_BOARD_NEW_TYPE_CODE) == true) goto L5;
            return;
        L5:
            r8.execSQL("UPDATE aoi_board SET new_type_code_l3=new_type_code WHERE (new_type_code_l3 IS NULL OR new_type_code_l3='') AND new_type_code IS NOT NULL AND new_type_code!='';");
            r8.execSQL("DROP TABLE IF EXISTS aoi_board_new_type_code_cleanup");
            r8.execSQL("ALTER TABLE aoi_board RENAME TO aoi_board_new_type_code_cleanup");
            r8.execSQL(StarLocationDbManager.access$600());
            r8.execSQL("INSERT OR REPLACE INTO aoi_board (_id,poi_id,poi_name,aoi_board,state,transition_type,confidence,confidence_source,event_time,type,geofenceId,cells,new_type_code_l3) SELECT _id,poi_id,poi_name,aoi_board,state,transition_type,confidence,confidence_source,event_time,type,geofenceId,cells,new_type_code_l3 FROM aoi_board_new_type_code_cleanup;");
            r8.execSQL("DROP TABLE IF EXISTS aoi_board_new_type_code_cleanup");
            CommSenseLog.i(StarLocationDbManager.TAG, "onOpen schema repair removed legacy aoi_board new_type_code column");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r8) {
            r8.execSQL(StarLocationDbManager.DB_CREATE_LOCATION_GEOFENCE);
            r8.execSQL(StarLocationDbManager.DB_CREATE_GEOFENCE_CALLBACK);
            r8.execSQL(StarLocationDbManager.access$500());
            r8.execSQL(StarLocationDbManager.access$600());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r8, int r10, int r11) {
            CommSenseLog.w(StarLocationDbManager.TAG, "Downgrading database from version " + r10 + " to " + r11);
            r8.execSQL(StarLocationDbManager.DB_DELETE_LOCATION_GEOFENCE);
            r8.execSQL(StarLocationDbManager.DB_DELETE_GEOFENCE_CALLBACK);
            r8.execSQL(StarLocationDbManager.DB_DELETE_CITY_INFO);
            r8.execSQL(StarLocationDbManager.DB_DELETE_AOI_BOARD);
            r8.execSQL(StarLocationDbManager.DB_DROP_LEGACY_POI_DATAS);
            onCreate(r8);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r8) {
            super.onOpen(r8);
            ensureLocationGeofenceSchema(r8);
            ensureAoiBoardSchema(r8);
            dropLegacyPoiDatas(r8);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
            CommSenseLog.dumpI(StarLocationDbManager.TAG, "Upgrading database from version " + r10 + " to " + r11, StarGeofenceManager.getGeofenceLogFile(this.mUserId));
            r8.beginTransaction();
            int r12 = r10;
        L3:
            if (r12 >= r11) goto L34;
            int r13 = 4;
            if (r12 == 3) goto L44;
            int r14 = 5;
            if (r12 == 4) goto L10;
            r13 = 6;
            if (r12 == 5) goto L14;
            r14 = 7;
            if (r12 == 6) goto L17;
            r13 = 8;
            if (r12 == 7) goto L20;
            r14 = 9;
            if (r12 == 8) goto L23;
            r13 = 10;
            if (r12 != 9) goto L27;
            migrateFromV9ToV10(r8);     // Catch: Throwable -> L36 Exception -> L38
        L7:
            r12 = r13;
            goto L3
        L27:
            r14 = 11;
            if (r12 == 10) goto L29;
            if (r12 != 11) goto L33;
            migrateFromV11ToV12(r8);     // Catch: Throwable -> L36 Exception -> L38
            r12 = 12;
            goto L3
        L33:
            throw new IllegalStateException("No specific upgrade path for version " + r12);     // Catch: Throwable -> L36 Exception -> L38
        L29:
            migrateFromV10ToV11(r8);     // Catch: Throwable -> L36 Exception -> L38
        L11:
            r12 = r14;
            goto L3
        L23:
            migrateFromV8ToV9(r8);     // Catch: Throwable -> L36 Exception -> L38
            goto L11
        L20:
            migrateFromV7ToV8(r8);     // Catch: Throwable -> L36 Exception -> L38
            goto L7
        L17:
            migrateFromV6ToV7(r8);     // Catch: Throwable -> L36 Exception -> L38
            goto L11
        L14:
            migrateFromV5ToV6(r8);     // Catch: Throwable -> L36 Exception -> L38
            goto L7
        L10:
            migrateFromV4ToV5(r8);     // Catch: Throwable -> L36 Exception -> L38
            goto L11
        L44:
            migrateFromV3ToV4(r8);     // Catch: Throwable -> L36 Exception -> L38
        L36:
            th = move-exception;
            r8.endTransaction();
            throw th;
        L38:
            e = move-exception;
            CommSenseLog.e(StarLocationDbManager.TAG, "Error upgrading database from " + r10 + " to " + r11, e);     // Catch: Throwable -> L36
            r8.execSQL(StarLocationDbManager.DB_DELETE_LOCATION_GEOFENCE);     // Catch: Throwable -> L36
            r8.execSQL(StarLocationDbManager.DB_DELETE_GEOFENCE_CALLBACK);     // Catch: Throwable -> L36
            r8.execSQL(StarLocationDbManager.DB_DELETE_CITY_INFO);     // Catch: Throwable -> L36
            r8.execSQL(StarLocationDbManager.DB_DELETE_AOI_BOARD);     // Catch: Throwable -> L36
            r8.execSQL(StarLocationDbManager.DB_DROP_LEGACY_POI_DATAS);     // Catch: Throwable -> L36
            onCreate(r8);     // Catch: Throwable -> L36
        L35:
            r8.endTransaction();
            return;
        L34:
            r8.setTransactionSuccessful();     // Catch: Throwable -> L36 Exception -> L38
            CommSenseLog.i(StarLocationDbManager.TAG, "Database upgrade successful from " + r10 + " to " + r11);     // Catch: Throwable -> L36 Exception -> L38
            goto L35
        }
    }

    static {
        sInstances = new ConcurrentHashMap();
        DB_CREATE_CITY_INFO = buildCreateCityInfoTableSql(TABLE_NAME_CITY_INFO);
        DB_CREATE_AOI_BOARD = "create table aoi_board (_id INTEGER PRIMARY KEY,poi_id TEXT UNIQUE,poi_name TEXT,aoi_board TEXT,state INTEGER DEFAULT " + AoiBoard.State.UNKNOWN.ordinal() + ",transition_type INTEGER DEFAULT " + AoiBoard.TransitionType.UNKNOWN.ordinal() + ",confidence INTEGER DEFAULT " + AoiBoard.Confidence.MIN.ordinal() + ",confidence_source INTEGER DEFAULT " + AoiBoard.ConfidenceSource.DEFAULT.ordinal() + ",event_time INTEGER DEFAULT 0,type INTEGER DEFAULT " + AoiBoard.Type.UNKNOWN.ordinal() + ",geofenceId TEXT DEFAULT '',cells TEXT DEFAULT '',new_type_code_l3 TEXT DEFAULT '');";
    }

    private StarLocationDbManager(Context r8, int r10) {
        this.mGeofenceById = new HashMap();
        this.mGeofenceByPkg = new HashMap();
        this.mCallbackByPkg = new HashMap();
        this.mCacheLoaded = false;
        this.mUserId = r10;
        this.mDbHelper = new StarDbHelper(r8.getApplicationContext(), r10);
        loadCacheFromDb();
    }

    public static /* synthetic */ int access$000(int r8) {
        return normalizeFirstBreachState(r8);
    }

    public static /* synthetic */ boolean access$100(int r8) {
        return isFirstBreachVisible(r8);
    }

    public static /* synthetic */ String access$500() {
        return DB_CREATE_CITY_INFO;
    }

    public static /* synthetic */ String access$600() {
        return DB_CREATE_AOI_BOARD;
    }

    public static /* synthetic */ String access$700(String r8) {
        return buildCreateCityInfoTableSql(r8);
    }

    @GuardedBy({"this"})
    private void addGeofenceToCacheLocked(StarGeofence r8, int r10) {
        addGeofenceToCacheLocked(r8, r10, r8.isFirstBreach() ? 1 : 0);
    }

    private void archiveCurrentCityTables(String r8) {
        File r10 = getCityArchiveDbFile(r8);
        File r11 = r10.getParentFile();
        if (r11 == null) goto L39;
        if (r11.exists() == false) goto L12;
        if (r11.isDirectory() == true) goto L12;
        throw new IllegalStateException("archive path is not directory");
    L12:
        if (r11.exists() == true) goto L19;
        if (r11.mkdirs() == true) goto L19;
        throw new IllegalStateException("create archive directory failed");
    L19:
        if (r10.exists() == true) goto L21;
        File r12 = getLocationDbFile();
        checkpointAndCloseDatabase();
        if (r12.exists() == false) goto L37;
        if (r12.isFile() == false) goto L37;
        if (copyFileAtomically(r12, r10) == false) goto L35;
        ensureArchiveDatabasePrepared(r10);
        ensureArchiveCityInfoKey(r10, r8);
        StringBuilder r13 = new StringBuilder("old city archive db copied, city=");
    L23:
        r13.append(r8);
        CommSenseLog.dWithMethodName(TAG, r13.toString());
        return;
    L35:
        throw new IllegalStateException("copy archive db failed");
    L37:
        throw new IllegalStateException("location db not found");
    L21:
        if (r10.isFile() == false) goto L26;
        ensureArchiveDatabasePrepared(r10);
        replaceArchiveCityTablesFromMain(r10);
        ensureArchiveCityInfoKey(r10, r8);
        r13 = new StringBuilder("old city archive tables overwritten, city=");
        goto L23
    L26:
        throw new IllegalStateException("archive db is not file");
    L39:
        throw new IllegalStateException("archive db parent is null");
    }

    private void attachArchiveDatabase(SQLiteDatabase r8, File r10) {
        r8.execSQL("ATTACH DATABASE ? AS city_archive", new Object[]{r10.getAbsolutePath()});
    }

    private ContentValues buildAoiBoardValues(AoiBoard r8) {
        ContentValues r10 = new ContentValues();
        r10.put("poi_id", r8.getPoiId());
        r10.put("poi_name", r8.getPoiName());
        r10.put("aoi_board", r8.getAoiBoard());
        r10.put("state", Integer.valueOf(r8.getCurState().ordinal()));
        r10.put(AoiBoardEntry.TRANSITION_TYPE, Integer.valueOf(r8.getTransitionType().ordinal()));
        r10.put("confidence", Integer.valueOf(r8.getConfidence().ordinal()));
        r10.put(AoiBoardEntry.CONFIDENCE_SOURCE, Integer.valueOf(r8.getConfidenceSource().ordinal()));
        r10.put("event_time", Long.valueOf(r8.getEventTime()));
        r10.put("type", Integer.valueOf(r8.getType().ordinal()));
        r10.put(AoiBoardEntry.GEOFENCE_ID, r8.getGeofenceId());
        return r10;
    }

    private ContentValues buildCityInfoValues(String r8, String r10, String r11, String r12, long r13) {
        ContentValues r14 = new ContentValues();
        r14.put(CityEntry.ADMIN_AREA, r8);
        r14.put(CityEntry.SUB_ADMIN_AREA, r10);
        r14.put(CityEntry.LOCALITY, r11);
        r14.put(CityEntry.SUB_LOCALITY, r12);
        r14.put(CityEntry.UPDATED_AT, Long.valueOf(r13));
        return r14;
    }

    private static String buildCreateCityInfoTableSql(String r8) {
        return b.d("create table ", r8, " (_id INTEGER PRIMARY KEY,adminArea TEXT,subAdminArea TEXT,locality TEXT,subLocality TEXT,updatedAt INTEGER);");
    }

    private void checkpointAndCloseDatabase() {
        Cursor r8 = this.mDbHelper.getWritableDatabase().rawQuery("PRAGMA wal_checkpoint(FULL)", null);     // Catch: Throwable -> L17
        if (r8 != null) goto L20;
    L13:
        if (r8 == null) goto L15;
        r8.close();     // Catch: Throwable -> L17
    L15:
        this.mDbHelper.close();
        return;
    L20:
        r8.moveToFirst();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: Throwable -> L17
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.mDbHelper.close();
        throw th;
    }

    private int clearAllAoiBoardsForCitySwitch(SQLiteDatabase r8) {
        return r8.delete("aoi_board", null, null);
    }

    private void copyCityTables(SQLiteDatabase r8, String r10, String r11) {
        r8.execSQL("DELETE FROM " + qualifyTable(r10, TABLE_NAME_CITY_INFO));
        r8.execSQL("INSERT INTO " + qualifyTable(r10, TABLE_NAME_CITY_INFO) + " (_id,adminArea,subAdminArea,locality,subLocality,updatedAt) SELECT _id,adminArea,subAdminArea,locality,subLocality,updatedAt FROM " + qualifyTable(r11, TABLE_NAME_CITY_INFO));
        StringBuilder r12 = new StringBuilder("DELETE FROM ");
        r12.append(qualifyTable(r10, "aoi_board"));
        r8.execSQL(r12.toString());
        r8.execSQL("INSERT OR REPLACE INTO " + qualifyTable(r10, "aoi_board") + " (_id,poi_id,poi_name,aoi_board,state,transition_type,confidence,confidence_source,event_time,type,geofenceId,cells,new_type_code_l3) SELECT _id,poi_id,poi_name,aoi_board,state,transition_type,confidence,confidence_source,event_time,type,geofenceId,cells,new_type_code_l3 FROM " + qualifyTable(r11, "aoi_board"));
    }

    private static boolean copyFileAtomically(File r20, File r21) {
        File r8 = r21.getParentFile();
        if (r8 != null) goto L5;
    L9:
        File r10 = new File(r21.getAbsolutePath() + ".tmp");
        if (r10.exists() == true) goto L12;
    L145:
        FileInputStream r11 = new FileInputStream(r20);     // Catch: Throwable -> L112
        FileOutputStream r12 = new FileOutputStream(r10);     // Catch: Throwable -> L101
        FileChannel r13 = r11.getChannel();     // Catch: Throwable -> L90
        FileChannel r14 = r12.getChannel();     // Catch: Throwable -> L78
        long r15 = r13.size();     // Catch: Throwable -> L66
        long r16 = 0;
    L21:
        if (r16 >= r15) goto L30;
        File r19 = r10;
        long r17 = r16;
        long r18 = r13.transferTo(r16, r15 - r16, r14);     // Catch: Throwable -> L28
        if (r18 <= 0) goto L31;
        r16 = r17 + r18;
        r10 = r19;
    L31:
        if (r16 == r15) goto L133;
        File r22 = r19;
    L64:
        th = th;
    L68:
        Throwable r23 = th;
    L119:
        if (r14 == null) goto L160;
        r14.close();     // Catch: Throwable -> L72
    L161:
        throw r23;     // Catch: Throwable -> L76
    L72:
        th = move-exception;
        r23.addSuppressed(th);     // Catch: Throwable -> L76
        throw r23;     // Catch: Throwable -> L76
    L160:
        throw r23;     // Catch: Throwable -> L76
    L76:
        th = th;
    L80:
        Throwable r24 = th;
    L81:
        if (r13 == null) goto L162;
        r13.close();     // Catch: Throwable -> L84
    L163:
        throw r24;     // Catch: Throwable -> L88
    L84:
        th = move-exception;
        r24.addSuppressed(th);     // Catch: Throwable -> L88
        throw r24;     // Catch: Throwable -> L88
    L88:
        th = th;
    L92:
        Throwable r25 = th;
        r12.close();     // Catch: Throwable -> L95
    L164:
        throw r25;     // Catch: Throwable -> L99
    L99:
        th = th;
    L103:
        Throwable r26 = th;
        r11.close();     // Catch: Throwable -> L106
    L165:
        throw r26;     // Catch: Throwable -> L110
    L106:
        th = move-exception;
        r26.addSuppressed(th);     // Catch: Throwable -> L110
        throw r26;     // Catch: Throwable -> L110
    L110:
        th = th;
    L114:
        CommSenseLog.e(TAG, "copyFileAtomically failed", th);
        r22.delete();     // Catch: Throwable -> L118
        return false;
    L166:
        return false;
    L95:
        th = move-exception;
        r25.addSuppressed(th);     // Catch: Throwable -> L99
        throw r25;     // Catch: Throwable -> L99
    L162:
        throw r24;     // Catch: Throwable -> L88
    L63:
        throw new IllegalStateException("copy incomplete, size=" + r15 + ", copied=" + r17);     // Catch: Throwable -> L64
    L133:
        r12.getFD().sync();     // Catch: Throwable -> L59
        if (r14 != null) goto L137;
    L129:
        r13.close();     // Catch: Throwable -> L57
        r12.close();     // Catch: Throwable -> L55
        r11.close();     // Catch: Throwable -> L53
        if (r21.exists() == true) goto L44;
    L47:
        File r27 = r19;
        if (r27.renameTo(r21) == true) goto L51;
        r27.delete();
        return false;
    L51:
        return true;
    L44:
        if (r21.delete() == true) goto L47;
        r19.delete();
        return false;
    L53:
        th = th;
        r22 = r19;
    L55:
        th = th;
        r22 = r19;
    L57:
        th = th;
        r22 = r19;
        goto L92
    L137:
        r14.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r24 = th;
        r22 = r19;
    L59:
        th = th;
        r22 = r19;
    L28:
        th = move-exception;
        r23 = th;
        r22 = r19;
        goto L119
    L30:
        r19 = r10;
        r17 = r16;
    L66:
        th = th;
        r22 = r10;
    L78:
        th = th;
        r22 = r10;
    L90:
        th = th;
        r22 = r10;
    L101:
        th = th;
        r22 = r10;
    L112:
        th = th;
        r22 = r10;
        goto L114
    L12:
        if (r10.delete() == true) goto L145;
        return false;
    L5:
        if (r8.exists() == true) goto L9;
        if (r8.mkdirs() == true) goto L9;
        return false;
    }

    @GuardedBy({"this"})
    private int delete(String r8, String r10, String[] r11) {
        CommSenseLog.d(TAG, "DB delete, table=" + r8 + ", whereClause=" + r10);
        return this.mDbHelper.getWritableDatabase().delete(r8, r10, r11);
    }

    @GuardedBy({"this"})
    private void deleteGeofenceCallback(String r8) {
        delete(TABLE_NAME_GEOFENCE_CALLBACK, "packageName = ?", new String[]{r8});
        this.mCallbackByPkg.remove(r8);
        CommSenseLog.d(TAG, "deleteGeofenceCallback, cache removed pkg=" + r8);
    }

    private static boolean deleteRecursively(File r8) {
        if (r8.exists() == true) goto L6;
        return true;
    L6:
        if (r8.isDirectory() == false) goto L12;
        File[] r10 = r8.listFiles();
        if (r10 == null) goto L12;
        int r11 = r10.length;
        boolean r12 = true;
        int r13 = 0;
    L10:
        if (r13 >= r11) goto L14;
        r12 = r12 & deleteRecursively(r10[r13]);
        r13 = r13 + 1;
    L14:
        if (r8.delete() == false) goto L18;
        if (r12 == false) goto L18;
        return true;
    L18:
        return false;
    L12:
        r12 = true;
        goto L14
    }

    private void detachArchiveDatabase(SQLiteDatabase r8) {
        r8.execSQL("DETACH DATABASE city_archive");     // Catch: Throwable -> L4
        return;
    L4:
        CommSenseLog.w(TAG, "detach city archive failed");
    }

    private void ensureArchiveCityInfoKey(File r8, String r10) {
        SQLiteDatabase r11 = SQLiteDatabase.openOrCreateDatabase(r8, null);
        r11.beginTransaction();     // Catch: Throwable -> L11
        ContentValues r12 = new ContentValues();     // Catch: Throwable -> L8
        r12.put(CityEntry.SUB_ADMIN_AREA, r10);     // Catch: Throwable -> L8
        r11.update(TABLE_NAME_CITY_INFO, r12, "subAdminArea IS NULL OR TRIM(subAdminArea) = ''", null);     // Catch: Throwable -> L8
        r11.setTransactionSuccessful();     // Catch: Throwable -> L8
        r11.endTransaction();     // Catch: Throwable -> L11
        r11.close();
        return;
    L8:
        th = move-exception;
        r11.endTransaction();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r11.close();
        throw th;
    }

    private void ensureArchiveDatabasePrepared(File r8) {
        SQLiteDatabase r10 = SQLiteDatabase.openOrCreateDatabase(r8, null);
        r10.beginTransaction();     // Catch: Throwable -> L11
        ensureCityInfoSchema(r10);     // Catch: Throwable -> L8
        StarDbHelper.access$900(this.mDbHelper, r10);     // Catch: Throwable -> L8
        r10.execSQL(DB_DELETE_LOCATION_GEOFENCE);     // Catch: Throwable -> L8
        r10.execSQL(DB_DELETE_GEOFENCE_CALLBACK);     // Catch: Throwable -> L8
        r10.setTransactionSuccessful();     // Catch: Throwable -> L8
        r10.endTransaction();     // Catch: Throwable -> L11
        r10.close();
        return;
    L8:
        th = move-exception;
        r10.endTransaction();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r10.close();
        throw th;
    }

    private synchronized void ensureCacheLoaded() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mCacheLoaded == true) goto L6;
        CommSenseLog.d(TAG, "ensureCacheLoaded, cache not loaded, loading from DB");     // Catch: Throwable -> L8
        loadCacheFromDb();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    private void ensureCityInfoSchema(SQLiteDatabase r8) {
        if (StarDbHelper.access$1000(this.mDbHelper, r8, TABLE_NAME_CITY_INFO) == true) goto L6;
        r8.execSQL(DB_CREATE_CITY_INFO);
        return;
    L6:
        StarDbHelper.access$1100(this.mDbHelper, r8, TABLE_NAME_CITY_INFO, CityEntry.ADMIN_AREA, "TEXT");
        StarDbHelper.access$1100(this.mDbHelper, r8, TABLE_NAME_CITY_INFO, CityEntry.SUB_ADMIN_AREA, "TEXT");
        StarDbHelper.access$1100(this.mDbHelper, r8, TABLE_NAME_CITY_INFO, CityEntry.LOCALITY, "TEXT");
        StarDbHelper.access$1100(this.mDbHelper, r8, TABLE_NAME_CITY_INFO, CityEntry.SUB_LOCALITY, "TEXT");
        StarDbHelper.access$1100(this.mDbHelper, r8, TABLE_NAME_CITY_INFO, CityEntry.UPDATED_AT, "INTEGER");
    }

    private File getCityArchiveDbFile(String r8) {
        return new File(new File(getCityArchiveRootDir(), sanitizeCityDirectoryName(r8)), StarDbHelper.access$1200(this.mUserId));
    }

    private File getCityArchiveRootDir() {
        File r8 = getLocationDbFile().getParentFile();
        if (r8 == null) goto L7;
        return new File(r8, CITY_ARCHIVE_ROOT_DIR);
    L7:
        throw new IllegalStateException("location db parent is null");
    }

    @GuardedBy({"this"})
    private int getFirstBreachStateForUpdateLocked(StarGeofence r8) {
        if (r8 != null) goto L4;
        return 0;
    L4:
        if (r8.getPackageName() != null) goto L6;
        return 0;
    L6:
        if (r8.getGeofenceId() == null) goto L22;
        InnerStarGeofenceEntry r10 = this.mGeofenceById.get(r8.getGeofenceId());
        if (r10 == null) goto L18;
        if (r10.getGeofence() == null) goto L18;
        if (r8.getPackageName().equals(r10.getPackageName()) == false) goto L18;
        return r10.getFirstBreachState();
    L18:
        return r8.isFirstBreach() ? 1 : 0;
    L22:
        return 0;
    }

    public static synchronized StarLocationDbManager getInstance(Context r8, int r10) {
        monitor-enter(StarLocationDbManager.class);
        Map<Integer, StarLocationDbManager> r11 = sInstances;     // Catch: Throwable -> L9
        StarLocationDbManager r12 = r11.get(Integer.valueOf(r10));     // Catch: Throwable -> L9
        if (r12 != null) goto L7;
        r12 = new StarLocationDbManager(r8, r10);     // Catch: Throwable -> L9
        r11.put(Integer.valueOf(r10), r12);     // Catch: Throwable -> L9
    L7:
        monitor-exit(StarLocationDbManager.class);
        return r12;
    L9:
        th = move-exception;
        throw th;
    }

    private File getLocationDbFile() {
        return StarDbHelper.access$1300(this.mDbHelper).getDatabasePath(StarDbHelper.access$1200(this.mUserId));
    }

    @GuardedBy({"this"})
    private boolean insert(String r8, ContentValues r10) {
        CommSenseLog.d(TAG, "DB insert, table=" + r8 + ", values=" + r10);
        long r11 = this.mDbHelper.getWritableDatabase().insert(r8, null, r10);
        if (r11 != (-1)) goto L5;
        CommSenseLog.d(TAG, "insert failed for " + r8 + " values: " + r10);
    L5:
        CommSenseLog.d(TAG, "inserted uri at: " + r11);
        if (r11 == (-1)) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean isCityStorageKeyChanged(CityInfo r8, String r10) {
        if (r8 != null) goto L4;
    L7:
        return true;
    L4:
        if (TextUtils.equals(resolveCityStorageKey(r8), r10) == false) goto L7;
        return false;
    }

    private static boolean isDirectControlledMunicipality(String r8) {
        if ("北京市".equals(r8) == false) goto L5;
    L12:
        return true;
    L5:
        if ("上海市".equals(r8) == true) goto L12;
        if ("天津市".equals(r8) == true) goto L12;
        if ("重庆市".equals(r8) == true) goto L12;
        return false;
    }

    private static boolean isFirstBreachVisible(int r8) {
        if (normalizeFirstBreachState(r8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isInvalidFileNameChar(char r8) {
        if (r8 != '/') goto L5;
    L24:
        return true;
    L5:
        if (r8 == '\\') goto L24;
        if (r8 == ':') goto L24;
        if (r8 == '*') goto L24;
        if (r8 == '?') goto L24;
        if (r8 == '\"') goto L24;
        if (r8 == '<') goto L24;
        if (r8 == '>') goto L24;
        if (r8 == '|') goto L24;
        if (Character.isISOControl(r8) == true) goto L24;
        return false;
    }

    private synchronized void loadCacheFromDb() {
        monitor-enter(this);
        CommSenseLog.d(TAG, "loadCacheFromDb start");     // Catch: Throwable -> L48
        this.mGeofenceById.clear();     // Catch: Throwable -> L48
        this.mGeofenceByPkg.clear();     // Catch: Throwable -> L48
        this.mCallbackByPkg.clear();     // Catch: Throwable -> L48
        Cursor r8 = queryGeofenceCursor(null, null);     // Catch: Throwable -> L48
        Iterator<InnerStarGeofenceEntry> r10 = resolveGeofenceCursor(r8).iterator();     // Catch: Throwable -> L41
        int r11 = 0;
        int r12 = 0;
    L6:
        if (r10.hasNext() == false) goto L16;
        InnerStarGeofenceEntry r13 = r10.next();     // Catch: Throwable -> L41
        if (r13 == null) goto L6;
        if (r13.getGeofence() == null) goto L6;
        if (r13.getGeofenceId() == null) goto L6;
        addGeofenceToCacheLocked(r13.getGeofence(), r13.getUserId(), r13.getFirstBreachState());     // Catch: Throwable -> L41
        r12 = r12 + 1;
        goto L6
    L16:
        if (r8 == null) goto L18;
        r8.close();     // Catch: Throwable -> L48
    L18:
        Cursor r14 = queryAllGeofenceCallback();     // Catch: Throwable -> L48
        if (r14 != null) goto L51;
    L36:
        if (r14 == null) goto L38;
        r14.close();     // Catch: Throwable -> L48
    L38:
        this.mCacheLoaded = true;     // Catch: Throwable -> L48
        CommSenseLog.d(TAG, "loadCacheFromDb done, geofenceCount=" + r12 + ", callbackCount=" + r11);     // Catch: Throwable -> L48
        monitor-exit(this);
        return;
    L51:
    L30:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L33
    L35:
        throw th;     // Catch: Throwable -> L48
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L48
        goto L35
    L21:
        if (r14.moveToFirst() == false) goto L36;
    L22:
        int r15 = r14.getColumnIndex("packageName");     // Catch: Throwable -> L30
        int r16 = r14.getColumnIndex(GeofenceCallbackEntry.CLASS_NAME);     // Catch: Throwable -> L30
        String r17 = r14.getString(r15);     // Catch: Throwable -> L30
        String r18 = r14.getString(r16);     // Catch: Throwable -> L30
        if (r17 == null) goto L28;
        if (r18 == null) goto L28;
        this.mCallbackByPkg.put(r17, new InnerGeofenceCallbackEntry(r17, r18));     // Catch: Throwable -> L30
        r11 = r11 + 1;     // Catch: Throwable -> L30
    L28:
        if (r14.moveToNext() == true) goto L22;
    L41:
        th = move-exception;
        if (r8 != null) goto L57;
    L47:
        throw th;     // Catch: Throwable -> L48
    L57:
        r8.close();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    public static boolean matchesUserId(int r8, int r10) {
        if (r8 == (-1)) goto L7;
        if (r8 == r10) goto L7;
        return false;
    L7:
        return true;
    }

    private static String normalizeCityKey(String r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r10 = r8.trim();
        if (r10.isEmpty() == false) goto L9;
        return null;
    L9:
        return r10;
    }

    private static int normalizeFirstBreachState(int r8) {
        if (r8 != 0) goto L4;
        return r8;
    L4:
        if (r8 == 1) goto L9;
        return -1;
    L9:
        return r8;
    }

    private static String qualifyTable(String r8, String r10) {
        return defpackage.a.f(r8, ".", r10);
    }

    @GuardedBy({"this"})
    private Cursor query(String r10, String[] r11, String r12, String[] r13, String r14, String r15, String r16) {
        CommSenseLog.v(TAG, "DB query, table=" + r10 + ", selection=" + r12);
        return this.mDbHelper.getReadableDatabase().query(r10, r11, r12, r13, r14, r15, r16);
    }

    @GuardedBy({"this"})
    private Cursor queryAllGeofenceCallback() {
        return query(TABLE_NAME_GEOFENCE_CALLBACK, new String[]{"packageName", GeofenceCallbackEntry.CLASS_NAME}, null, null, null, null, null);
    }

    @GuardedBy({"this"})
    private Cursor queryGeofenceCallback(String r11) {
        return query(TABLE_NAME_GEOFENCE_CALLBACK, new String[]{"packageName", GeofenceCallbackEntry.CLASS_NAME}, "packageName = ?", new String[]{r11}, null, null, null);
    }

    @GuardedBy({"this"})
    private Cursor queryGeofenceCursor(String r23, String[] r24) {
        return query(TABLE_NAME_LOCATION_GEOFENCE, new String[]{GeofenceEntry.USER_ID, "packageName", "id", "latitude", GeofenceEntry.LONGITUDE, "radius", GeofenceEntry.ADDRESS, GeofenceEntry.EVENT_TIMESTAMP, GeofenceEntry.TRANSITION_TYPE, "confidence", "state", "type", GeofenceEntry.FIRST_BREACH, "poi_id"}, r23, r24, null, null, null);
    }

    @GuardedBy({"this"})
    private Cursor queryGeofenceCursorById(String r8) {
        return queryGeofenceCursor("id = ?", new String[]{r8});
    }

    @GuardedBy({"this"})
    private Cursor queryGeofenceCursorByPkgName(String r8) {
        return queryGeofenceCursor("packageName = ?", new String[]{r8});
    }

    @GuardedBy({"this"})
    private void removeGeofenceFromCacheLocked(String r8) {
        InnerStarGeofenceEntry r10 = this.mGeofenceById.remove(r8);
        if (r10 != null) goto L5;
        StringBuilder r11 = new StringBuilder("cache remove geofence miss, id=");
    L20:
        r11.append(r8);
        CommSenseLog.d(TAG, r11.toString());
        return;
    L5:
        List<InnerStarGeofenceEntry> r12 = this.mGeofenceByPkg.get(r10.getPackageName());
        if (r12 != null) goto L8;
        r11 = b.h("cache remove geofence no pkg list, id=", r8, ", pkg=");
        r8 = r10.getPackageName();
        goto L20
    L8:
        int r13 = r12.size();
    L9:
        r13 = r13 - 1;
        if (r13 < 0) goto L17;
        InnerStarGeofenceEntry r14 = r12.get(r13);
        if (r14 == null) goto L9;
        if (r8.equals(r14.getGeofenceId()) == false) goto L9;
        r12.remove(r13);
        goto L9
    L17:
        if (r12.isEmpty() == false) goto L19;
        this.mGeofenceByPkg.remove(r10.getPackageName());
    L19:
        r11 = new StringBuilder("cache removed geofence, pkg=");
        r11.append(r10.getPackageName());
        r11.append(", id=");
        goto L20
    }

    @GuardedBy({"this"})
    private boolean replace(String r8, ContentValues r10) {
        CommSenseLog.d(TAG, "DB replace, table=" + r8 + ", values=" + r10);
        long r11 = this.mDbHelper.getWritableDatabase().replace(r8, null, r10);
        if (r11 != (-1)) goto L5;
        CommSenseLog.d(TAG, "replace failed for " + r8 + " values: " + r10);
    L5:
        if (r11 == (-1)) goto L7;
        return true;
    L7:
        return false;
    }

    private void replaceArchiveCityTablesFromMain(File r8) {
        SQLiteDatabase r10 = this.mDbHelper.getWritableDatabase();
        attachArchiveDatabase(r10, r8);
        r10.beginTransaction();     // Catch: Throwable -> L11
        copyCityTables(r10, CITY_ARCHIVE_ALIAS, MAIN_DB_ALIAS);     // Catch: Throwable -> L8
        r10.setTransactionSuccessful();     // Catch: Throwable -> L8
        r10.endTransaction();     // Catch: Throwable -> L11
        detachArchiveDatabase(r10);
        return;
    L8:
        th = move-exception;
        r10.endTransaction();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        detachArchiveDatabase(r10);
        throw th;
    }

    private void replaceCityInfo(SQLiteDatabase r11, String r12, String r13, String r14, String r15, long r16) {
        r11.delete(TABLE_NAME_CITY_INFO, null, null);
        if (r11.insert(TABLE_NAME_CITY_INFO, null, buildCityInfoValues(r12, r13, r14, r15, r16)) == (-1)) goto L6;
        return;
    L6:
        throw new IllegalStateException("insert city_info failed");
    }

    private List<AoiBoard> resolveAoiBoardCursor(Cursor r8) {
        ArrayList r10 = new ArrayList();
        if (r8 != null) goto L19;
        return r10;
    L19:
    L13:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L6:
        if (r8.moveToFirst() == true) goto L9;
        r8.close();
        return r10;
    L9:
        AoiBoard r11 = new AoiBoard();     // Catch: Throwable -> L13
        r11.setPoiId(r8.getString(r8.getColumnIndexOrThrow("poi_id")));     // Catch: Throwable -> L13
        r11.setPoiName(r8.getString(r8.getColumnIndexOrThrow("poi_name")));     // Catch: Throwable -> L13
        r11.setAoiBoard(r8.getString(r8.getColumnIndexOrThrow("aoi_board")));     // Catch: Throwable -> L13
        r11.setCurState(AoiBoard.State.values()[r8.getInt(r8.getColumnIndexOrThrow("state"))]);     // Catch: Throwable -> L13
        r11.setTransitionType(AoiBoard.TransitionType.values()[r8.getInt(r8.getColumnIndexOrThrow(AoiBoardEntry.TRANSITION_TYPE))]);     // Catch: Throwable -> L13
        r11.setConfidence(AoiBoard.Confidence.values()[r8.getInt(r8.getColumnIndexOrThrow("confidence"))]);     // Catch: Throwable -> L13
        r11.setConfidenceSource(AoiBoard.ConfidenceSource.values()[r8.getInt(r8.getColumnIndexOrThrow(AoiBoardEntry.CONFIDENCE_SOURCE))]);     // Catch: Throwable -> L13
        r11.setEvent(AoiBoard.Event.UNKNOWN);     // Catch: Throwable -> L13
        r11.setEventTime(r8.getLong(r8.getColumnIndexOrThrow("event_time")));     // Catch: Throwable -> L13
        r11.setType(AoiBoard.Type.values()[r8.getInt(r8.getColumnIndexOrThrow("type"))]);     // Catch: Throwable -> L13
        r11.setGeofenceId(r8.getString(r8.getColumnIndexOrThrow(AoiBoardEntry.GEOFENCE_ID)));     // Catch: Throwable -> L13
        r10.add(r11);     // Catch: Throwable -> L13
        if (r8.moveToNext() == true) goto L9;
        r8.close();
        return r10;
    }

    private static String resolveCityStorageKey(CityInfo r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return resolveCityStorageKey(r8.subAdminArea, r8.locality, r8.subLocality, r8.adminArea);
    }

    @GuardedBy({"this"})
    private List<InnerStarGeofenceEntry> resolveGeofenceCursor(Cursor r8) {
        ArrayList r10 = new ArrayList();
        if (r8 != null) goto L5;
    L8:
        return r10;
    L5:
        if (r8.moveToFirst() == false) goto L8;
    L6:
        StarGeofence r11 = new StarGeofence();
        int r12 = r8.getInt(r8.getColumnIndex(GeofenceEntry.USER_ID));
        r11.setPackageName(r8.getString(r8.getColumnIndex("packageName")));
        r11.setGeofenceId(r8.getString(r8.getColumnIndex("id")));
        r11.setLatitude(r8.getDouble(r8.getColumnIndex("latitude")));
        r11.setLongitude(r8.getDouble(r8.getColumnIndex(GeofenceEntry.LONGITUDE)));
        r11.setRadius(r8.getInt(r8.getColumnIndex("radius")));
        r11.setAddress(r8.getString(r8.getColumnIndex(GeofenceEntry.ADDRESS)));
        r11.setEventTimestamp(r8.getLong(r8.getColumnIndex(GeofenceEntry.EVENT_TIMESTAMP)));
        int r13 = r8.getColumnIndex(GeofenceEntry.TRANSITION_TYPE);
        r11.setTransitionType(StarGeofence.GeoTransitionType.values()[r8.getInt(r13)]);
        int r14 = r8.getColumnIndex("confidence");
        r11.setConfidence(StarGeofence.GeoConfidence.values()[r8.getInt(r14)]);
        int r15 = r8.getColumnIndex("state");
        r11.setGeoState(StarGeofence.GeoState.values()[r8.getInt(r15)]);
        int r16 = r8.getColumnIndex("type");
        r11.setGeoType(StarGeofence.GeoType.values()[r8.getInt(r16)]);
        int r17 = normalizeFirstBreachState(r8.getInt(r8.getColumnIndex(GeofenceEntry.FIRST_BREACH)));
        r11.setFirstBreach(isFirstBreachVisible(r17));
        r11.setPoiId(r8.getString(r8.getColumnIndex("poi_id")));
        r10.add(new InnerStarGeofenceEntry(r11, r12, r17));
        if (r8.moveToNext() == true) goto L6;
        goto L8
    }

    private static String resolveStoredSubAdminArea(String r8, String r10) {
        String r11 = normalizeCityKey(r8);
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return r10;
    L6:
        return r11;
    }

    private void restoreCityTablesFromArchive(File r12, String r13, String r14, String r15, String r16, long r17) {
        if (r12.exists() == false) goto L19;
        if (r12.isFile() == false) goto L19;
        ensureArchiveDatabasePrepared(r12);
        SQLiteDatabase r10 = this.mDbHelper.getWritableDatabase();
        attachArchiveDatabase(r10, r12);
        r10.beginTransaction();     // Catch: Throwable -> L15
        copyCityTables(r10, MAIN_DB_ALIAS, CITY_ARCHIVE_ALIAS);     // Catch: Throwable -> L12
        replaceCityInfo(r10, r13, r14, r15, r16, r17);     // Catch: Throwable -> L12
        r10.setTransactionSuccessful();     // Catch: Throwable -> L12
        r10.endTransaction();     // Catch: Throwable -> L15
        detachArchiveDatabase(r10);
        return;
    L12:
        th = move-exception;
        r10.endTransaction();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        detachArchiveDatabase(r10);
        throw th;
    L19:
        throw new IllegalStateException("target archive db not found");
    }

    private static String sanitizeCityDirectoryName(String r8) {
        String r10 = normalizeCityKey(r8);
        if (TextUtils.isEmpty(r10) == true) goto L21;
        StringBuilder r11 = new StringBuilder(r10.length());
        int r12 = 0;
    L6:
        if (r12 >= r10.length()) goto L11;
        char r13 = r10.charAt(r12);
        if (isInvalidFileNameChar(r13) == false) goto L10;
        r13 = '_';
    L10:
        r11.append(r13);
        r12 = r12 + 1;
        goto L6
    L11:
        String r14 = r11.toString();
        if (TextUtils.isEmpty(r14) == true) goto L19;
        if (".".equals(r14) == true) goto L19;
        if ("..".equals(r14) == true) goto L19;
        return r14;
    L19:
        throw new IllegalArgumentException("invalid city directory name");
    L21:
        throw new IllegalArgumentException("city key is empty");
    }

    private void saveCityInfoAndClearAoiBoards(String r12, String r13, String r14, String r15, long r16) {
        SQLiteDatabase r10 = this.mDbHelper.getWritableDatabase();
        r10.beginTransaction();
        replaceCityInfo(r10, r12, r13, r14, r15, r16);     // Catch: Throwable -> L6
        int r8 = clearAllAoiBoardsForCitySwitch(r10);     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        CommSenseLog.dWithMethodName(TAG, "active city initialized, clearedAoiCount=" + r8 + ", city=" + r13);     // Catch: Throwable -> L6
        r10.endTransaction();
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    private void saveCityInfoOnly(String r10, String r11, String r12, String r13, long r14) {
        SQLiteDatabase r8 = this.mDbHelper.getWritableDatabase();
        r8.beginTransaction();
        replaceCityInfo(r8, r10, r11, r12, r13, r14);     // Catch: Throwable -> L6
        r8.setTransactionSuccessful();     // Catch: Throwable -> L6
        r8.endTransaction();
        return;
    L6:
        th = move-exception;
        r8.endTransaction();
        throw th;
    }

    @GuardedBy({"this"})
    private void update(String r8, ContentValues r10, String r11, String[] r12) {
        CommSenseLog.d(TAG, "DB update, table=" + r8 + ", whereClause=" + r11);
        this.mDbHelper.getWritableDatabase().update(r8, r10, r11, r12);
    }

    private int updateCellAoiBoardValues(SQLiteDatabase r8, CellAoiBoardEntry r10) {
        ContentValues r11 = new ContentValues();
        if (TextUtils.isEmpty(CellAoiBoardEntry.access$200(r10).getPoiName()) == true) goto L6;
        r11.put("poi_name", CellAoiBoardEntry.access$200(r10).getPoiName());
    L6:
        if (TextUtils.isEmpty(CellAoiBoardEntry.access$300(r10)) == true) goto L9;
        r11.put(AoiBoardEntry.CELLS, CellAoiBoardEntry.access$300(r10));
    L9:
        if (TextUtils.isEmpty(CellAoiBoardEntry.access$400(r10)) == true) goto L12;
        r11.put("new_type_code_l3", CellAoiBoardEntry.access$400(r10));
    L12:
        if (r11.size() != 0) goto L15;
        return 0;
    L15:
        int r12 = r8.update("aoi_board", r11, "poi_id=?", new String[]{CellAoiBoardEntry.access$200(r10).getPoiId()});
        if (r12 <= 0) goto L18;
        CommSenseLog.dWithMethodName(TAG, "updated cell aoi_board fields, poiId=" + CellAoiBoardEntry.access$200(r10).getPoiId() + ", values=" + r11);
    L18:
        return r12;
    }

    public synchronized boolean advanceGeofenceFirstBreachForNotification(StarGeofence r8) {
        monitor-enter(this);
        int r10 = 0;
        if (r8 != null) goto L35;
    L33:
        monitor-exit(this);
        return false;
    L35:
    L30:
        th = move-exception;
        throw th;
    L7:
        if (r8.getPackageName() == null) goto L33;
        if (r8.getGeofenceId() == null) goto L33;
        ensureCacheLoaded();     // Catch: Throwable -> L30
        InnerStarGeofenceEntry r11 = this.mGeofenceById.get(r8.getGeofenceId());     // Catch: Throwable -> L30
        if (r11 != null) goto L14;
    L27:
        boolean r12 = r8.isFirstBreach();     // Catch: Throwable -> L30
        CommSenseLog.d(TAG, "advanceGeofenceFirstBreachForNotification, cache miss, id=" + r8.getGeofenceId() + ", isFirstBreach=" + r12);     // Catch: Throwable -> L30
        monitor-exit(this);
        return r12;
    L14:
        if (r11.getGeofence() == null) goto L27;
        if (r8.getPackageName().equals(r11.getPackageName()) == false) goto L27;
        int r13 = r11.getFirstBreachState();     // Catch: Throwable -> L30
        if (r13 != (-1)) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L24;
        r10 = 1;
    L24:
        r11.setFirstBreachState(r10);     // Catch: Throwable -> L30
        r11.setGeofence(r8);     // Catch: Throwable -> L30
        r8.setFirstBreach(r14);     // Catch: Throwable -> L30
        CommSenseLog.d(TAG, "advanceGeofenceFirstBreachForNotification, id=" + r8.getGeofenceId() + ", from=" + r13 + ", to=" + r10 + ", isFirstBreach=" + r14);     // Catch: Throwable -> L30
        monitor-exit(this);
        return r14;
    L21:
        r14 = false;
        goto L22
    }

    public synchronized void closeDatabase() {
        monitor-enter(this);
        this.mDbHelper.close();     // Catch: Throwable -> L5
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

    public synchronized int deleteAllAoiBoards() {
        monitor-enter(this);
        int r8 = delete("aoi_board", "(cells IS NULL OR cells='') AND (new_type_code_l3 IS NULL OR new_type_code_l3='')", null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int deleteAoiBoardsByTypes(Set<AoiBoard.Type> r8) {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (r8.isEmpty() == false) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        StringBuilder r10 = new StringBuilder("type");     // Catch: Throwable -> L26
        r10.append(" IN (");     // Catch: Throwable -> L26
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L26
        Iterator<AoiBoard.Type> r12 = r8.iterator();     // Catch: Throwable -> L26
    L10:
        if (r12.hasNext() == false) goto L19;
        AoiBoard.Type r13 = r12.next();     // Catch: Throwable -> L26
        if (r13 == null) goto L10;
        if (r11.isEmpty() == true) goto L17;
        r10.append(',');     // Catch: Throwable -> L26
    L17:
        r10.append('?');     // Catch: Throwable -> L26
        r11.add(String.valueOf(r13.ordinal()));     // Catch: Throwable -> L26
        goto L10
    L19:
        if (r11.isEmpty() == false) goto L23;
        monitor-exit(this);
        return 0;
    L23:
        r10.append(')');     // Catch: Throwable -> L26
        int r14 = delete("aoi_board", r10.toString(), (String[]) r11.toArray(new String[0]));     // Catch: Throwable -> L26
        monitor-exit(this);
        return r14;
    }

    public synchronized boolean deleteCityArchiveRootDir() {
        monitor-enter(this);
        File r8 = getCityArchiveRootDir();     // Catch: Throwable -> L7
        boolean r10 = deleteRecursively(r8);     // Catch: Throwable -> L7
        CommSenseLog.i(TAG, "deleteCityArchiveRootDir path=" + r8.getAbsolutePath() + ", deleted=" + r10);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void deleteGeofence(String r8, String r10) {
        monitor-enter(this);
        CommSenseLog.d(TAG, "deleteGeofence, pkgName: " + r8 + ", geofenceId: " + r10);     // Catch: Throwable -> L7
        ensureCacheLoaded();     // Catch: Throwable -> L7
        removeGeofenceFromCacheLocked(r10);     // Catch: Throwable -> L7
        CommSenseLog.d(TAG, "deleteGeofence, DB delete whereClause=packageName = ? AND id = ?");     // Catch: Throwable -> L7
        delete(TABLE_NAME_LOCATION_GEOFENCE, "packageName = ? AND id = ?", new String[]{r8, r10});     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized CityInfo getCityInfo() {
        monitor-enter(this);
        Cursor r8 = this.mDbHelper.getReadableDatabase().query(TABLE_NAME_CITY_INFO, new String[]{CityEntry.ADMIN_AREA, CityEntry.SUB_ADMIN_AREA, CityEntry.LOCALITY, CityEntry.SUB_LOCALITY, CityEntry.UPDATED_AT}, null, null, null, null, "_id DESC", "1");     // Catch: Throwable -> L22
        if (r8 != null) goto L25;
    L17:
        if (r8 == null) goto L19;
        r8.close();     // Catch: Throwable -> L22
    L19:
        monitor-exit(this);
        return null;
    L25:
    L11:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L14
    L16:
        throw th;     // Catch: Throwable -> L22
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L22
        goto L16
    L6:
        if (r8.moveToFirst() == false) goto L17;
        CityInfo r10 = new CityInfo(r8.getString(0), r8.getString(1), r8.getString(2), r8.getString(3), r8.getLong(4));     // Catch: Throwable -> L11
        r8.close();     // Catch: Throwable -> L22
        monitor-exit(this);
        return r10;
    L22:
        th = move-exception;
        throw th;
    }

    public synchronized CityInfo getCityInfoBySubAdminArea(String r17) {
        monitor-enter(this);
        if (r17 != null) goto L34;
        monitor-exit(this);
        return null;
    L34:
        Cursor r8 = this.mDbHelper.getReadableDatabase().query(TABLE_NAME_CITY_INFO, new String[]{CityEntry.ADMIN_AREA, CityEntry.SUB_ADMIN_AREA, CityEntry.LOCALITY, CityEntry.SUB_LOCALITY, CityEntry.UPDATED_AT}, "subAdminArea = ?", new String[]{r17}, null, null, "_id DESC", "1");     // Catch: Throwable -> L29
        if (r8 != null) goto L32;
    L24:
        if (r8 == null) goto L26;
        r8.close();     // Catch: Throwable -> L29
    L26:
        monitor-exit(this);
        return null;
    L32:
    L16:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L20
    L37:
        throw th;     // Catch: Throwable -> L29
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L11:
        if (r8.moveToFirst() == false) goto L24;
        CityInfo r10 = new CityInfo(r8.getString(0), r8.getString(1), r8.getString(2), r8.getString(3), r8.getLong(4));     // Catch: Throwable -> L16
        r8.close();     // Catch: Throwable -> L29
        monitor-exit(this);
        return r10;
    L29:
        th = move-exception;
        throw th;
    }

    public synchronized ComponentName getGeofenceCallback(String r8) {
        monitor-enter(this);
        if (r8 != null) goto L22;
        monitor-exit(this);
        return null;
    L22:
        ensureCacheLoaded();     // Catch: Throwable -> L19
        InnerGeofenceCallbackEntry r10 = this.mCallbackByPkg.get(r8);     // Catch: Throwable -> L19
        if (r10 != null) goto L11;
    L16:
        CommSenseLog.d(TAG, "getGeofenceCallback, cache miss pkg=".concat(r8));     // Catch: Throwable -> L19
        monitor-exit(this);
        return null;
    L11:
        if (r10.getClassName() == null) goto L16;
        CommSenseLog.d(TAG, "getGeofenceCallback, cache hit pkg=" + r8 + ", class=" + r10.getClassName());     // Catch: Throwable -> L19
        ComponentName r11 = new ComponentName(r8, r10.getClassName());     // Catch: Throwable -> L19
        monitor-exit(this);
        return r11;
    L19:
        th = move-exception;
        throw th;
    }

    public synchronized void insertGeofence(StarGeofence r20, int r21) {
        monitor-enter(this);
        ensureCacheLoaded();     // Catch: Throwable -> L26
        StarGeofence r8 = queryGeofenceById(r20.getGeofenceId());     // Catch: Throwable -> L26
        if (r8 == null) goto L30;
        if (r8.equals(r20) == false) goto L30;
        CommSenseLog.d(TAG, "Geofence already exists!");     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L30:
        boolean r10 = insertGeofence(r20.getPackageName(), r20.getGeofenceId(), r20.getLatitude(), r20.getLongitude(), r20.getRadius(), r20.getAddress(), r20.getEventTimestamp(), r20.getTransitionType(), r20.getConfidence(), r20.getGeoState(), r20.getGeoType(), r20.getPoiId(), r21);     // Catch: Throwable -> L24
        CommSenseLog.d(TAG, "insertGeofence, db inserted=" + r10 + ", pkg=" + r20.getPackageName() + ", id=" + r20.getGeofenceId());     // Catch: Throwable -> L24
        if (r10 == false) goto L22;
        removeGeofenceFromCacheLocked(r20.getGeofenceId());     // Catch: Throwable -> L19
        addGeofenceToCacheLocked(r20, r21, -1);     // Catch: Throwable -> L19
    L19:
        th = th;
    L28:
        monitor-exit(this);
        throw th;
    L22:
        monitor-exit(this);
        return;
    L24:
        th = th;
    L26:
        th = th;
        goto L28
    }

    public synchronized List<AoiBoard> queryAllAoiBoards() {
        monitor-enter(this);
        List<AoiBoard> r8 = resolveAoiBoardCursor(query("aoi_board", new String[]{"poi_id", "poi_name", "aoi_board", "state", AoiBoardEntry.TRANSITION_TYPE, "confidence", AoiBoardEntry.CONFIDENCE_SOURCE, "event_time", "type", AoiBoardEntry.GEOFENCE_ID}, null, null, null, null, null));     // Catch: Throwable -> L7
        monitor-exit(this);
        return r8;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized List<StarGeofence> queryAllGeofences() {
        monitor-enter(this);
        ensureCacheLoaded();     // Catch: Throwable -> L19
        if (this.mGeofenceById.isEmpty() == false) goto L8;
        CommSenseLog.d(TAG, "queryAllGeofences, cache empty");     // Catch: Throwable -> L19
        List<StarGeofence> r8 = Collections.emptyList();     // Catch: Throwable -> L19
        monitor-exit(this);
        return r8;
    L8:
        ArrayList r10 = new ArrayList(this.mGeofenceById.size());     // Catch: Throwable -> L19
        Iterator<InnerStarGeofenceEntry> r11 = this.mGeofenceById.values().iterator();     // Catch: Throwable -> L19
    L10:
        if (r11.hasNext() == false) goto L16;
        InnerStarGeofenceEntry r12 = r11.next();     // Catch: Throwable -> L19
        if (r12 == null) goto L10;
        if (r12.getGeofence() == null) goto L10;
        r10.add(r12.getGeofence());     // Catch: Throwable -> L19
        goto L10
    L16:
        CommSenseLog.d(TAG, "queryAllGeofences, cache size=" + r10.size());     // Catch: Throwable -> L19
        monitor-exit(this);
        return r10;
    L19:
        th = move-exception;
        throw th;
    }

    public synchronized AoiBoard queryAoiBoardByPoiId(String r12) {
        monitor-enter(this);
        AoiBoard r8 = null;
        if (r12 != null) goto L19;
    L17:
        monitor-exit(this);
        return null;
    L19:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r12.isEmpty() == true) goto L17;
        List<AoiBoard> r13 = resolveAoiBoardCursor(query("aoi_board", new String[]{"poi_id", "poi_name", "aoi_board", "state", AoiBoardEntry.TRANSITION_TYPE, "confidence", AoiBoardEntry.CONFIDENCE_SOURCE, "event_time", "type", AoiBoardEntry.GEOFENCE_ID}, "poi_id=?", new String[]{r12}, null, null, null));     // Catch: Throwable -> L14
        if (r13.isEmpty() == true) goto L12;
        r8 = r13.get(0);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r8;
    }

    public synchronized Map<String, String> queryAoiBoardNewTypeCodeL3s(List<String> r14) {
        monitor-enter(this);
        HashMap r8 = new HashMap();     // Catch: Throwable -> L36
        if (r14.isEmpty() == false) goto L7;
        monitor-exit(this);
        return r8;
    L7:
        SQLiteDatabase r10 = this.mDbHelper.getReadableDatabase();     // Catch: Throwable -> L36
        String[] r11 = {"poi_id", "new_type_code_l3"};     // Catch: Throwable -> L36
        Iterator<String> r15 = r14.iterator();     // Catch: Throwable -> L36
    L9:
        if (r15.hasNext() == false) goto L34;
        String r12 = r15.next();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r12) == true) goto L9;
        Cursor r13 = r10.query("aoi_board", r11, "poi_id=?", new String[]{r12}, null, null, null, "1");     // Catch: Exception -> L31 Throwable -> L36
        if (r13 == null) goto L29;
    L23:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Exception -> L31 Throwable -> L36
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L31 Throwable -> L36
        goto L28
    L16:
        if (r13.moveToFirst() == false) goto L29;
        String r16 = r13.getString(r13.getColumnIndexOrThrow("new_type_code_l3"));     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r16) == true) goto L21;
        r8.put(r12, r16);     // Catch: Throwable -> L23
    L21:
        r13.close();     // Catch: Exception -> L31 Throwable -> L36
    L29:
        if (r13 == null) goto L9;
    L31:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed, poiId=" + r12, e);     // Catch: Throwable -> L36
        goto L9
    L34:
        monitor-exit(this);
        return r8;
    L36:
        th = move-exception;
        throw th;
    }

    public synchronized StarGeofence queryGeofenceById(String r8) {
        monitor-enter(this);
        ensureCacheLoaded();     // Catch: Throwable -> L14
        InnerStarGeofenceEntry r10 = this.mGeofenceById.get(r8);     // Catch: Throwable -> L14
        StringBuilder r11 = new StringBuilder("queryGeofenceById, cache ");     // Catch: Throwable -> L14
        if (r10 != null) goto L7;
        String r12 = "miss";
    L8:
        r11.append(r12);     // Catch: Throwable -> L14
        r11.append(", id=");     // Catch: Throwable -> L14
        r11.append(r8);     // Catch: Throwable -> L14
        CommSenseLog.d(TAG, r11.toString());     // Catch: Throwable -> L14
        if (r10 != null) goto L11;
        StarGeofence r13 = null;
    L12:
        monitor-exit(this);
        return r13;
    L11:
        r13 = r10.getGeofence();     // Catch: Throwable -> L14
        goto L12
    L7:
        r12 = "hit";
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized int queryGeofenceUserIdById(String r8) {
        monitor-enter(this);
        ensureCacheLoaded();     // Catch: Throwable -> L9
        InnerStarGeofenceEntry r10 = this.mGeofenceById.get(r8);     // Catch: Throwable -> L9
        if (r10 != null) goto L6;
        int r11 = 0;
    L7:
        monitor-exit(this);
        return r11;
    L6:
        r11 = r10.getUserId();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized List<StarGeofence> queryGeofencesByPkgName(String r8) {
        monitor-enter(this);
        ensureCacheLoaded();     // Catch: Throwable -> L23
        List<InnerStarGeofenceEntry> r10 = this.mGeofenceByPkg.get(r8);     // Catch: Throwable -> L23
        if (r10 != null) goto L7;
    L20:
        CommSenseLog.d(TAG, "queryGeofencesByPkgName, cache empty pkg=" + r8);     // Catch: Throwable -> L23
        List<StarGeofence> r11 = Collections.emptyList();     // Catch: Throwable -> L23
        monitor-exit(this);
        return r11;
    L7:
        if (r10.isEmpty() == true) goto L20;
        ArrayList r12 = new ArrayList(r10.size());     // Catch: Throwable -> L23
        Iterator<InnerStarGeofenceEntry> r13 = r10.iterator();     // Catch: Throwable -> L23
    L11:
        if (r13.hasNext() == false) goto L17;
        InnerStarGeofenceEntry r14 = r13.next();     // Catch: Throwable -> L23
        if (r14 == null) goto L11;
        if (r14.getGeofence() == null) goto L11;
        r12.add(r14.getGeofence());     // Catch: Throwable -> L23
        goto L11
    L17:
        CommSenseLog.d(TAG, "queryGeofencesByPkgName, cache size=" + r12.size() + ", pkg=" + r8);     // Catch: Throwable -> L23
        monitor-exit(this);
        return r12;
    L23:
        th = move-exception;
        throw th;
    }

    public synchronized List<StarGeofence> queryGeofencesByUserIdAndType(int r8, StarGeofence.GeoType r10) {
        monitor-enter(this);
        ensureCacheLoaded();     // Catch: Throwable -> L28
        if (this.mGeofenceById.isEmpty() == false) goto L9;
        CommSenseLog.vWithMethodName(TAG, "cache empty, userId=" + r8 + ", geoType=" + r10);     // Catch: Throwable -> L28
        List<StarGeofence> r11 = Collections.emptyList();     // Catch: Throwable -> L28
        monitor-exit(this);
        return r11;
    L9:
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L28
        Iterator<InnerStarGeofenceEntry> r13 = this.mGeofenceById.values().iterator();     // Catch: Throwable -> L28
    L11:
        if (r13.hasNext() == false) goto L25;
        InnerStarGeofenceEntry r14 = r13.next();     // Catch: Throwable -> L28
        if (r14 == null) goto L11;
        if (r14.getGeofence() == null) goto L11;
        if (r14.getUserId() != r8) goto L11;
        if (r10 == null) goto L24;
        if (r14.getGeofence().getGeoType() != r10) goto L11;
    L24:
        r12.add(r14.getGeofence());     // Catch: Throwable -> L28
        goto L11
    L25:
        CommSenseLog.vWithMethodName(TAG, "size=" + r12.size() + ", userId=" + r8 + ", geoType=" + r10);     // Catch: Throwable -> L28
        monitor-exit(this);
        return r12;
    L28:
        th = move-exception;
        throw th;
    }

    public synchronized void registerGeofenceCallback(ComponentName r8) {
        monitor-enter(this);
        if (r8 != null) goto L23;
        monitor-exit(this);
        return;
    L23:
        ensureCacheLoaded();     // Catch: Throwable -> L20
        String r10 = r8.getPackageName();     // Catch: Throwable -> L20
        String r11 = r8.getClassName();     // Catch: Throwable -> L20
        InnerGeofenceCallbackEntry r12 = this.mCallbackByPkg.get(r10);     // Catch: Throwable -> L20
        if (r12 == null) goto L15;
        CommSenseLog.d(TAG, "registerGeofenceCallback, get Same Class: " + r12.getClassName());     // Catch: Throwable -> L20
        if (r11.equalsIgnoreCase(r12.getClassName()) == false) goto L14;
        CommSenseLog.d(TAG, "registerGeofenceCallback, cache hit, skip DB");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L14:
        deleteGeofenceCallback(r10);     // Catch: Throwable -> L20
    L15:
        ContentValues r13 = new ContentValues();     // Catch: Throwable -> L20
        r13.put("packageName", r10);     // Catch: Throwable -> L20
        r13.put(GeofenceCallbackEntry.CLASS_NAME, r11);     // Catch: Throwable -> L20
        if (insert(TABLE_NAME_GEOFENCE_CALLBACK, r13) == false) goto L18;
        this.mCallbackByPkg.put(r10, new InnerGeofenceCallbackEntry(r10, r11));     // Catch: Throwable -> L20
        CommSenseLog.d(TAG, "registerGeofenceCallback, cache updated pkg=" + r10 + ", class=" + r11);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized boolean saveCityInfoReturningChanged(String r10, String r11, String r12, String r13, long r14) {
        monitor-enter(this);
        CityInfo r8 = getCityInfo();     // Catch: Throwable -> L6
        String r15 = resolveCityStorageKey(r11, r12, r13, r10);     // Catch: Throwable -> L6
        boolean r16 = isCityStorageKeyChanged(r8, r15);     // Catch: Throwable -> L6
        saveCityInfoOnly(r10, resolveStoredSubAdminArea(r11, r15), r12, r13, r14);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r16;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized CityStorageSwitchResult switchCityStorageForResolvedAddress(String r14, String r15, String r16, String r17, long r18) {
        monitor-enter(this);
        CityInfo r8 = getCityInfo();     // Catch: Throwable -> L31
        String r11 = resolveCityStorageKey(r8);     // Catch: Throwable -> L31
        String r12 = resolveCityStorageKey(r15, r16, r17, r14);     // Catch: Throwable -> L31
        String r10 = resolveStoredSubAdminArea(r15, r12);     // Catch: Throwable -> L31
        if (isCityStorageKeyChanged(r8, r12) == true) goto L10;
        saveCityInfoOnly(r14, r10, r16, r17, r18);     // Catch: Throwable -> L31
        CityStorageSwitchResult r13 = new CityStorageSwitchResult(true, false, false, r11, r12, null);     // Catch: Throwable -> L31
        monitor-exit(this);
        return r13;
    L10:
        if (TextUtils.isEmpty(r12) == false) goto L15;
        CommSenseLog.dWithMethodName(TAG, "skip city archive: target subAdminArea is empty");     // Catch: Throwable -> L31
        saveCityInfoOnly(r14, r15, r16, r17, r18);     // Catch: Throwable -> L31
        CityStorageSwitchResult r19 = new CityStorageSwitchResult(true, true, false, r11, null, null);     // Catch: Throwable -> L31
        monitor-exit(this);
        return r19;
    L15:
        if (TextUtils.isEmpty(r11) == true) goto L17;
        archiveCurrentCityTables(r11);     // Catch: Throwable -> L31
    L18:
        File r20 = getCityArchiveDbFile(r12);     // Catch: Throwable -> L31
        if (r20.exists() == true) goto L21;
    L23:
        boolean r21 = false;
    L25:
        if (r21 == false) goto L27;
        restoreCityTablesFromArchive(r20, r14, r10, r16, r17, r18);     // Catch: Throwable -> L31
    L28:
        CommSenseLog.dWithMethodName(TAG, "city storage switched, previousCity=" + r11 + ", targetCity=" + r12 + ", restoredFromArchive=" + r21);     // Catch: Throwable -> L31
        CityStorageSwitchResult r22 = new CityStorageSwitchResult(true, true, r21, r11, r12, null);     // Catch: Throwable -> L31
        monitor-exit(this);
        return r22;
    L27:
        saveCityInfoAndClearAoiBoards(r14, r10, r16, r17, r18);     // Catch: Throwable -> L31
        goto L28
    L21:
        if (r20.isFile() == false) goto L23;
        r21 = true;
        goto L25
    L17:
        CommSenseLog.dWithMethodName(TAG, "skip old city archive: previous subAdminArea is empty");     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public synchronized void unregisterGeofenceCallback(String r8) {
        monitor-enter(this);
        ensureCacheLoaded();     // Catch: Throwable -> L6
        deleteGeofenceCallback(r8);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean updateAoiBoardGeofenceId(String r8, String r10) {
        monitor-enter(this);
        boolean r11 = false;
        if (r8 != null) goto L26;
    L24:
        monitor-exit(this);
        return false;
    L26:
    L21:
        th = move-exception;
        throw th;
    L7:
        if (r8.isEmpty() == true) goto L24;
        ContentValues r12 = new ContentValues();     // Catch: Throwable -> L21
        if (r10 != null) goto L12;
        String r13 = "";
    L13:
        r12.put(AoiBoardEntry.GEOFENCE_ID, r13);     // Catch: Throwable -> L21
        int r14 = this.mDbHelper.getWritableDatabase().update("aoi_board", r12, "poi_id=?", new String[]{r8});     // Catch: Throwable -> L21
        StringBuilder r15 = new StringBuilder("poiId=");     // Catch: Throwable -> L21
        r15.append(r8);     // Catch: Throwable -> L21
        r15.append(", geofenceId=");     // Catch: Throwable -> L21
        if (r10 != null) goto L16;
        r10 = "";
    L16:
        r15.append(r10);     // Catch: Throwable -> L21
        r15.append(", updated=");     // Catch: Throwable -> L21
        r15.append(r14);     // Catch: Throwable -> L21
        CommSenseLog.dWithMethodName(TAG, r15.toString());     // Catch: Throwable -> L21
        if (r14 <= 0) goto L19;
        r11 = true;
    L19:
        monitor-exit(this);
        return r11;
    L12:
        r13 = r10;
        goto L13
    }

    public synchronized int updateAoiBoardNewTypeCodeL3s(Map<String, String> r10) {
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (r10.isEmpty() == false) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        SQLiteDatabase r8 = this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L33
        r8.beginTransaction();     // Catch: Throwable -> L33
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();     // Catch: Throwable -> L24 Exception -> L26
        int r12 = 0;
    L11:
        if (r11.hasNext() == false) goto L20;
        Map.Entry<String, String> r13 = r11.next();     // Catch: Throwable -> L24 Exception -> L26
        String r14 = r13.getKey();     // Catch: Throwable -> L24 Exception -> L26
        String r15 = r13.getValue();     // Catch: Throwable -> L24 Exception -> L26
        if (TextUtils.isEmpty(r14) == true) goto L11;
        if (TextUtils.isEmpty(r15) == true) goto L11;
        ContentValues r16 = new ContentValues();     // Catch: Throwable -> L24 Exception -> L26
        r16.put("new_type_code_l3", r15);     // Catch: Throwable -> L24 Exception -> L26
        int r17 = r8.update("aoi_board", r16, "poi_id=?", new String[]{r14});     // Catch: Throwable -> L24 Exception -> L26
        if (r17 <= 0) goto L11;
        r12 = r12 + r17;     // Catch: Throwable -> L24 Exception -> L26
        goto L11
    L20:
        r8.setTransactionSuccessful();     // Catch: Throwable -> L24 Exception -> L26
        CommSenseLog.dWithMethodName(TAG, "updated count=" + r12 + ", input count=" + r10.size());     // Catch: Throwable -> L24 Exception -> L26
        r8.endTransaction();     // Catch: Throwable -> L33
        monitor-exit(this);
        return r12;
    L24:
        th = move-exception;
        r8.endTransaction();     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L26:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);     // Catch: Throwable -> L24
        r8.endTransaction();     // Catch: Throwable -> L33
        return 0;
    }

    public synchronized int updateCellAoiBoardFields(List<CellAoiBoardEntry> r8) {
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (r8.isEmpty() == false) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        SQLiteDatabase r10 = this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L33
        r10.beginTransaction();     // Catch: Throwable -> L33
        Iterator<CellAoiBoardEntry> r11 = r8.iterator();     // Catch: Throwable -> L24 Exception -> L26
        int r12 = 0;
    L11:
        if (r11.hasNext() == false) goto L20;
        CellAoiBoardEntry r13 = r11.next();     // Catch: Throwable -> L24 Exception -> L26
        if (r13 == null) goto L11;
        if (CellAoiBoardEntry.access$200(r13) == null) goto L11;
        if (TextUtils.isEmpty(CellAoiBoardEntry.access$200(r13).getPoiId()) == true) goto L11;
        r12 = r12 + updateCellAoiBoardValues(r10, r13);     // Catch: Throwable -> L24 Exception -> L26
        goto L11
    L20:
        r10.setTransactionSuccessful();     // Catch: Throwable -> L24 Exception -> L26
        CommSenseLog.dWithMethodName(TAG, "updated count=" + r12 + ", input count=" + r8.size());     // Catch: Throwable -> L24 Exception -> L26
        r10.endTransaction();     // Catch: Throwable -> L33
        monitor-exit(this);
        return r12;
    L26:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);     // Catch: Throwable -> L24
        r10.endTransaction();     // Catch: Throwable -> L33
        return 0;
    L24:
        th = move-exception;
        r10.endTransaction();     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    }

    public synchronized void updateGeofence(StarGeofence r8, int r10) {
        monitor-enter(this);
        ensureCacheLoaded();     // Catch: Throwable -> L7
        int r11 = getFirstBreachStateForUpdateLocked(r8);     // Catch: Throwable -> L7
        r8.setFirstBreach(isFirstBreachVisible(r11));     // Catch: Throwable -> L7
        ContentValues r12 = new ContentValues();     // Catch: Throwable -> L7
        r12.put(GeofenceEntry.USER_ID, Integer.valueOf(r10));     // Catch: Throwable -> L7
        r12.put("latitude", Double.valueOf(r8.getLatitude()));     // Catch: Throwable -> L7
        r12.put(GeofenceEntry.LONGITUDE, Double.valueOf(r8.getLongitude()));     // Catch: Throwable -> L7
        r12.put("radius", Integer.valueOf(r8.getRadius()));     // Catch: Throwable -> L7
        r12.put(GeofenceEntry.ADDRESS, r8.getAddress());     // Catch: Throwable -> L7
        r12.put(GeofenceEntry.EVENT_TIMESTAMP, Long.valueOf(r8.getEventTimestamp()));     // Catch: Throwable -> L7
        r12.put(GeofenceEntry.TRANSITION_TYPE, Integer.valueOf(r8.getTransitionType().ordinal()));     // Catch: Throwable -> L7
        r12.put("confidence", Integer.valueOf(r8.getConfidence().ordinal()));     // Catch: Throwable -> L7
        r12.put("state", Integer.valueOf(r8.getGeoState().ordinal()));     // Catch: Throwable -> L7
        r12.put("type", Integer.valueOf(r8.getGeoType().ordinal()));     // Catch: Throwable -> L7
        r12.put(GeofenceEntry.FIRST_BREACH, Integer.valueOf(r11));     // Catch: Throwable -> L7
        r12.put("poi_id", r8.getPoiId());     // Catch: Throwable -> L7
        String[] r13 = {r8.getGeofenceId(), r8.getPackageName()};     // Catch: Throwable -> L7
        CommSenseLog.d(TAG, "updateGeofence, DB update id=" + r8.getGeofenceId() + ", pkg=" + r8.getPackageName());     // Catch: Throwable -> L7
        update(TABLE_NAME_LOCATION_GEOFENCE, r12, "id = ? AND packageName = ?", r13);     // Catch: Throwable -> L7
        removeGeofenceFromCacheLocked(r8.getGeofenceId());     // Catch: Throwable -> L7
        addGeofenceToCacheLocked(r8, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized boolean upsertAoiBoards(List<AoiBoard> r11) {
        monitor-enter(this);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (r11.isEmpty() == false) goto L8;
        monitor-exit(this);
        return true;
    L8:
        SQLiteDatabase r8 = this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L39
        r8.beginTransaction();     // Catch: Throwable -> L39
        Iterator<AoiBoard> r12 = r11.iterator();     // Catch: Throwable -> L30 Exception -> L32
        int r10 = 0;
    L12:
        if (r12.hasNext() == false) goto L26;
        AoiBoard r13 = r12.next();     // Catch: Throwable -> L30 Exception -> L32
        if (r13 == null) goto L12;
        if (r13.getPoiId().isEmpty() == true) goto L12;
        ContentValues r14 = buildAoiBoardValues(r13);     // Catch: Throwable -> L30 Exception -> L32
        if (r8.update("aoi_board", r14, "poi_id=?", new String[]{r13.getPoiId()}) == 0) goto L21;
    L25:
        r10 = r10 + 1;     // Catch: Throwable -> L30 Exception -> L32
        goto L12
    L21:
        if (r8.insert("aoi_board", null, r14) != (-1)) goto L25;
        throw new IllegalStateException("upsert failed for poiId=" + r13.getPoiId());     // Catch: Throwable -> L30 Exception -> L32
    L26:
        r8.setTransactionSuccessful();     // Catch: Throwable -> L30 Exception -> L32
        CommSenseLog.vWithMethodName(TAG, "success count=" + r10);     // Catch: Throwable -> L30 Exception -> L32
        r8.endTransaction();     // Catch: Throwable -> L39
        monitor-exit(this);
        return true;
    L30:
        th = move-exception;
        r8.endTransaction();     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L32:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed", e);     // Catch: Throwable -> L30
        r8.endTransaction();     // Catch: Throwable -> L39
        return false;
    }

    @GuardedBy({"this"})
    private void addGeofenceToCacheLocked(StarGeofence r8, int r10, int r11) {
        InnerStarGeofenceEntry r12 = new InnerStarGeofenceEntry(r8, r10, r11);
        this.mGeofenceById.put(r12.getGeofenceId(), r12);
        List<InnerStarGeofenceEntry> r13 = this.mGeofenceByPkg.get(r12.getPackageName());
        if (r13 != null) goto L5;
        r13 = new ArrayList();
        this.mGeofenceByPkg.put(r12.getPackageName(), r13);
    L5:
        r13.add(r12);
        CommSenseLog.d(TAG, "cache add geofence, pkg=" + r12.getPackageName() + ", id=" + r12.getGeofenceId() + ", firstBreachState=" + r12.getFirstBreachState());
    }

    @GuardedBy({"this"})
    private boolean insertGeofence(String r8, String r10, double r11, double r12, int r13, String r14, long r15, StarGeofence.GeoTransitionType r16, StarGeofence.GeoConfidence r17, StarGeofence.GeoState r18, StarGeofence.GeoType r19, String r110, int r111) {
        ContentValues r20 = new ContentValues();
        r20.put(GeofenceEntry.USER_ID, Integer.valueOf(r111));
        r20.put("packageName", r8);
        r20.put("id", r10);
        r20.put("latitude", Double.valueOf(r11));
        r20.put(GeofenceEntry.LONGITUDE, Double.valueOf(r12));
        r20.put("radius", Integer.valueOf(r13));
        r20.put(GeofenceEntry.ADDRESS, r14);
        r20.put(GeofenceEntry.EVENT_TIMESTAMP, Long.valueOf(r15));
        r20.put(GeofenceEntry.TRANSITION_TYPE, Integer.valueOf(r16.ordinal()));
        r20.put("confidence", Integer.valueOf(r17.ordinal()));
        r20.put("state", Integer.valueOf(r18.ordinal()));
        r20.put("type", Integer.valueOf(r19.ordinal()));
        r20.put(GeofenceEntry.FIRST_BREACH, -1);
        r20.put("poi_id", r110);
        return insert(TABLE_NAME_LOCATION_GEOFENCE, r20);
    }

    private static String resolveCityStorageKey(String r8, String r10, String r11, String r12) {
        String r13 = normalizeCityKey(r8);
        if (TextUtils.isEmpty(r13) == true) goto L5;
        return r13;
    L5:
        String r14 = normalizeCityKey(r12);
        if (isDirectControlledMunicipality(r14) == false) goto L8;
        return r14;
    L8:
        String r15 = normalizeCityKey(r10);
        if (TextUtils.isEmpty(r15) == true) goto L11;
        return r15;
    L11:
        String r16 = normalizeCityKey(r11);
        if (TextUtils.isEmpty(r16) == true) goto L14;
        return r16;
    L14:
        return r14;
    }
}
