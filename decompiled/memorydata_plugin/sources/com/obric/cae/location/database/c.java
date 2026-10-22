package com.obric.cae.location.database;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.location.cell.g;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.userAware.datacollection.TrafficRecognitionInfo;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7073a = "location_geofence";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f7074b = null;
    public static final String c = null;
    public static final String d = null;
    public static final /* synthetic */ boolean e = true;
    public final f f;
    public final int g;
    public final HashMap h;
    public final HashMap i;
    public final HashMap j;
    public boolean k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AoiBoard f7075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7076b;
        public final String c;

        public a(AoiBoard r1, String r2, String r3) {
            this.f7075a = r1;
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            this.f7076b = r2;
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            this.c = r3;
        }

        public AoiBoard a() {
            return this.f7075a;
        }

        public String b() {
            return this.f7076b;
        }

        public String c() {
            return this.c;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7078b;
        public final String c;
        public final String d;
        public final long e;

        public b(String r1, String r2, String r3, String r4, long r5) {
            this.f7077a = r1;
            this.f7078b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.location.database.c$c, reason: collision with other inner class name */
    public static final class C0354c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7080b;
        public final boolean c;
        public final String d;
        public final String e;

        public /* synthetic */ C0354c() {
            throw null;
        }

        public C0354c(boolean r2, boolean r3, String r4, String r5) {
            this.f7079a = true;
            this.f7080b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7082b;

        public d(String r1, String r2) {
            this.f7081a = r1;
            this.f7082b = r2;
        }

        public String a() {
            return this.f7082b;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7084b;
        public StarGeofence c;
        public int d;
        public int e;

        public e(StarGeofence r2, int r3, int r4) {
            this.c = r2;
            this.f7083a = r2.getPackageName();
            this.f7084b = r2.getGeofenceId();
            this.d = r3;
            int r5 = c.a(r4);
            this.e = r5;
            this.c.setFirstBreach(c.b(r5));
        }

        public String a() {
            return this.f7083a;
        }

        public void a(int r3) {
            String r0 = c.f7073a;
            int r1 = -1;
            boolean r2 = true;
            if (r3 == 0) goto L7;
            if (r3 == 1) goto L7;
            r3 = -1;
        L7:
            this.e = r3;
            StarGeofence r4 = this.c;
            if (r4 == null) goto L17;
            if (r3 == 0) goto L11;
            if (r3 == 1) goto L11;
        L12:
            if (r1 != 0) goto L15;
            r2 = false;
        L15:
            r4.setFirstBreach(r2);
            return;
        L11:
            r1 = r3;
            goto L12
        }

        public void a(StarGeofence r2) {
            this.c = r2;
            if (r2 == null) goto L14;
            int r1 = this.e;
            String r0 = c.f7073a;
            boolean r3 = true;
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L9;
            r1 = -1;
        L9:
            if (r1 != 0) goto L12;
            r3 = false;
        L12:
            r2.setFirstBreach(r3);
            return;
        }

        public String b() {
            return this.f7084b;
        }

        public StarGeofence c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }
    }

    public static class f extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f7085a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f7086b;
        public final int c;

        public f(Context r5, int r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            super(r7, a(r6), null, 12);
            this.f7086b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.c = r6;
        }

        public static String a(int r2) {
            if (r2 != 0) goto L5;
            return "star_location.db";
        L5:
            return "star_location_" + r2 + ".db";
        }

        public static void a(SQLiteDatabase r2) {
            com.obric.cae.log.a.e("StarLocation-db", "Upgrading location_geofence table from v3 to v4: Adding firstBreach column.");
            r2.execSQL("ALTER TABLE location_geofence ADD COLUMN firstBreach INTEGER DEFAULT 0;");
            com.obric.cae.log.a.e("StarLocation-db", "Added firstBreach column with default value 0 to location_geofence");
            com.obric.cae.log.a.e("StarLocation-db", "Database upgraded from version 3 to 4.");
        }

        public static void a(SQLiteDatabase r2, String r3, String r4, String r5) {
            if (a(r2, r3, r4) == false) goto L5;
            return;
        L5:
            r2.execSQL("ALTER TABLE " + r3 + " ADD COLUMN " + r4 + " " + r5 + ";");
            com.obric.cae.log.a.e("StarLocation-db", "schema repair added " + r4 + " column to " + r3);
        }

        public static boolean a(SQLiteDatabase r3, String r4) {
            boolean r0 = true;
            Cursor r5 = r3.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{r4});
            if (r5 != null) goto L17;
        L13:
            r0 = false;
        L14:
            if (r5 == null) goto L16;
            r5.close();
        L16:
            return r0;
        L17:
            if (r5.moveToFirst() == false) goto L13;
        L7:
            th = move-exception;
            r5.close();     // Catch: Throwable -> L10
        L12:
            throw th;
        L10:
            th = move-exception;
            th.addSuppressed(th);
            goto L12
        }

        public static boolean a(SQLiteDatabase r2, String r3, String r4) {
            Cursor r5 = r2.rawQuery("PRAGMA table_info(" + r3 + ")", null);
            if (r5 != null) goto L24;
            if (r5 == null) goto L6;
            r5.close();
        L6:
            return false;
        L24:
            int r0 = r5.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L18
        L9:
            if (r5.moveToNext() == false) goto L16;
            if (r0 == (-1)) goto L9;
            if (r4.equals(r5.getString(r0)) == false) goto L9;
            r5.close();
            return true;
        L16:
            r5.close();
            return false;
        L18:
            th = move-exception;
            r5.close();     // Catch: Throwable -> L21
        L23:
            throw th;
        L21:
            th = move-exception;
            th.addSuppressed(th);
            goto L23
        }

        public static void b(SQLiteDatabase r5) {
            if (a(r5, "location_geofence") == true) goto L6;
            com.obric.cae.log.a.g("StarLocation-db", "Skipping v4->v5 migration because table does not exist: location_geofence");
            return;
        L6:
            ContentValues r1 = new ContentValues();
            r1.put(ObricMemoryConstants.KEY_PACKAGE_NAME, "com.larus.nova");
            com.obric.cae.log.a.e("StarLocation-db", "v4->v5 migration updated packageName from com.obric.memorydata to com.larus.nova, affectedRows=" + r5.update("location_geofence", r1, "packageName = ?", new String[]{BuildConfig.LIBRARY_PACKAGE_NAME}));
        }

        public static void c(SQLiteDatabase r3) {
            if (a(r3, "location_geofence") == true) goto L7;
            com.obric.cae.log.a.g("StarLocation-db", "Skipping v7->v8 migration because table does not exist: location_geofence");
            return;
        L7:
            if (a(r3, "location_geofence", "poi_id") == true) goto L10;
            r3.execSQL("ALTER TABLE location_geofence ADD COLUMN poi_id TEXT DEFAULT '';");
            com.obric.cae.log.a.e("StarLocation-db", "v7->v8 migration added poi_id column");
        L10:
            if (a(r3, TrafficRecognitionInfo.SOURCE_AOI_BOARD) == true) goto L13;
            r3.execSQL(c.d);
            com.obric.cae.log.a.e("StarLocation-db", "v7->v8 migration created aoi_board table");
            return;
        }

        public static void d(SQLiteDatabase r3) {
            r3.execSQL("DROP INDEX IF EXISTS geofenceAdded");
            if (a(r3, "city_info") == true) goto L7;
            r3.execSQL(c.c);
            String r0 = "v8->v9 migration created missing city_info table";
        L5:
            com.obric.cae.log.a.e("StarLocation-db", r0);
            if (a(r3, TrafficRecognitionInfo.SOURCE_AOI_BOARD) == true) goto L15;
            r3.execSQL(c.d);
            String r1 = "v8->v9 migration created missing aoi_board table";
        L13:
            com.obric.cae.log.a.e("StarLocation-db", r1);
        L17:
            e(r3);
            return;
        L15:
            if (a(r3, TrafficRecognitionInfo.SOURCE_AOI_BOARD, "geofenceId") == true) goto L17;
            r3.execSQL("ALTER TABLE aoi_board ADD COLUMN geofenceId TEXT DEFAULT '';");
            r1 = "v8->v9 migration added geofenceId column to aoi_board";
            goto L13
        L7:
            if (a(r3, "city_info", "geofenceAdded") == true) goto L9;
            r0 = "v8->v9 migration dropped city_info geofenceAdded index if existed";
            goto L5
        L9:
            r3.execSQL("DROP TABLE IF EXISTS city_info_v9_temp");
            String r2 = c.f7073a;
            r3.execSQL("create table city_info_v9_temp (_id INTEGER PRIMARY KEY,adminArea TEXT,subAdminArea TEXT,locality TEXT,subLocality TEXT,updatedAt INTEGER);");
            r3.execSQL("INSERT INTO city_info_v9_temp (_id,adminArea,subAdminArea,locality,subLocality,updatedAt) SELECT _id,adminArea,subAdminArea,locality,subLocality,updatedAt FROM city_info");
            r3.execSQL("DROP TABLE IF EXISTS city_info");
            r3.execSQL("ALTER TABLE city_info_v9_temp RENAME TO city_info");
            r0 = "v8->v9 migration removed geofenceAdded column and index from city_info";
            goto L5
        }

        public static void e(SQLiteDatabase r6) {
            if (a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD) == true) goto L6;
            r6.execSQL(c.d);
            com.obric.cae.log.a.e("StarLocation-db", "onOpen schema repair created aoi_board table");
            return;
        L6:
            a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD, "transition_type", "INTEGER DEFAULT " + AoiBoard.TransitionType.UNKNOWN.ordinal());
            a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD, "confidence", "INTEGER DEFAULT " + AoiBoard.Confidence.MIN.ordinal());
            a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD, "confidence_source", "INTEGER DEFAULT " + AoiBoard.ConfidenceSource.DEFAULT.getValue());
            a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD, "event_time", "INTEGER DEFAULT 0");
            a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD, "type", "INTEGER DEFAULT " + AoiBoard.Type.UNKNOWN.ordinal());
            a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD, "geofenceId", "TEXT DEFAULT ''");
            a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD, "cells", "TEXT DEFAULT ''");
            boolean r4 = a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD, "new_type_code_l3");
            boolean r5 = a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD, "type_code");
            if (r4 == true) goto L10;
            if (r5 == false) goto L10;
            r6.execSQL("ALTER TABLE aoi_board RENAME COLUMN type_code TO new_type_code_l3");
            com.obric.cae.log.a.e("StarLocation-db", "onOpen schema repair renamed aoi_board type_code to new_type_code_l3");
        L14:
            if (a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD, "new_type_code") == false) goto L17;
            r6.execSQL("UPDATE aoi_board SET new_type_code_l3=new_type_code WHERE (new_type_code_l3 IS NULL OR new_type_code_l3='') AND new_type_code IS NOT NULL AND new_type_code!='';");
            r6.execSQL("DROP TABLE IF EXISTS aoi_board_new_type_code_cleanup");
            r6.execSQL("ALTER TABLE aoi_board RENAME TO aoi_board_new_type_code_cleanup");
            r6.execSQL(c.d);
            r6.execSQL("INSERT OR REPLACE INTO aoi_board (_id,poi_id,poi_name,aoi_board,state,transition_type,confidence,confidence_source,event_time,type,geofenceId,cells,new_type_code_l3) SELECT _id,poi_id,poi_name,aoi_board,state,transition_type,confidence,confidence_source,event_time,type,geofenceId,cells,new_type_code_l3 FROM aoi_board_new_type_code_cleanup;");
            r6.execSQL("DROP TABLE IF EXISTS aoi_board_new_type_code_cleanup");
            com.obric.cae.log.a.e("StarLocation-db", "onOpen schema repair removed legacy aoi_board new_type_code column");
        L17:
            ContentValues r1 = new ContentValues();
            r1.put("poi_name", "");
            int r0 = r6.update(TrafficRecognitionInfo.SOURCE_AOI_BOARD, r1, "poi_name IS NULL", null);
            r6.execSQL("UPDATE aoi_board SET poi_name=poi_id WHERE poi_name='';");
            if (r0 <= 0) goto L21;
            com.obric.cae.log.a.e("StarLocation-db", "schema repair normalized null aoi_board poi_name count=" + r0);
            return;
        L21:
            return;
        L10:
            a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD, "new_type_code_l3", "TEXT DEFAULT ''");
            if (r5 == false) goto L14;
            r6.execSQL("UPDATE aoi_board SET new_type_code_l3=type_code WHERE (new_type_code_l3 IS NULL OR new_type_code_l3='') AND type_code IS NOT NULL AND type_code!='';");
            goto L14
        }

        public final void f(SQLiteDatabase r10) {
            if (a(r10, "location_geofence") == true) goto L6;
            com.obric.cae.log.a.g("StarLocation-db", "Skipping v6->v7 migration because table does not exist: location_geofence");
            return;
        L6:
            r10.execSQL("ALTER TABLE location_geofence ADD COLUMN userId INTEGER DEFAULT 0;");
            ContentValues r1 = new ContentValues();
            r1.put("userId", Integer.valueOf(this.c));
            StarGeofence.GeoType r6 = StarGeofence.GeoType.TRAFFIC;
            int r2 = r10.update("location_geofence", r1, "type != ?", new String[]{String.valueOf(r6.ordinal())});
            ContentValues r5 = new ContentValues();
            r5.put("userId", -1);
            g.a(com.obric.cae.location.b.a("v6->v7 migration added userId column, updatedRows=", r2, ", updatedTrafficRows=", r10.update("location_geofence", r5, "type = ?", new String[]{String.valueOf(r6.ordinal())}), ", dbUserId="), this.c, "StarLocation-db");
        }

        public final void g(SQLiteDatabase r12) {
            if (a(r12, "poi_datas") == true) goto L5;
            return;
        L5:
            com.obric.cae.location.database.d r11 = com.obric.cae.location.database.d.a(this.f7086b);
            monitor-enter(r11);
            int r1 = 0;
            if (r11.a() == false) goto L10;
        L48:
            monitor-exit(r11);
        L49:
            r12.execSQL("DROP TABLE IF EXISTS poi_datas");
            com.obric.cae.log.a.e("StarLocation-db", "dropped legacy poi_datas from star_location.db, importedCount=" + r1);
            return;
        L10:
            if (com.obric.cae.location.database.d.a(r12) == false) goto L48;
            ArrayList r0 = new ArrayList();     // Catch: Throwable -> L51
            Cursor r2 = r12.query("poi_datas", new String[]{"new_type_name_l1", "new_type_name_l2", "new_type_name_l3", "new_type_code_l1", "new_type_code_l2", "new_type_code_l3"}, null, null, null, null, null);     // Catch: Exception -> L31 Throwable -> L51
            if (r2 != null) goto L59;
            if (r2 == null) goto L34;
        L23:
            r2.close();     // Catch: Exception -> L31 Throwable -> L51
        L34:
            if (r0.isEmpty() == true) goto L48;
            SQLiteDatabase r3 = r11.f7088b.getWritableDatabase();     // Catch: Throwable -> L51
            r3.beginTransaction();     // Catch: Throwable -> L51
            com.obric.cae.location.database.d.b(r3);     // Catch: Throwable -> L41 Exception -> L43
            int r4 = com.obric.cae.location.database.d.a(r3, r0);     // Catch: Throwable -> L41 Exception -> L43
            r3.setTransactionSuccessful();     // Catch: Throwable -> L41 Exception -> L43
            com.obric.cae.log.a.f("StarLocation-poi-db", "imported legacy poi_datas count=" + r4);     // Catch: Throwable -> L41 Exception -> L43
            r3.endTransaction();     // Catch: Throwable -> L51
            monitor-exit(r11);
            r1 = r4;
            goto L49
        L41:
            th = move-exception;
            r3.endTransaction();     // Catch: Throwable -> L51
            throw th;     // Catch: Throwable -> L51
        L43:
            e = move-exception;
            com.obric.cae.log.a.b("StarLocation-poi-db", "import legacy poi_datas failed", e);     // Catch: Throwable -> L41
            r3.endTransaction();     // Catch: Throwable -> L51
        L59:
        L25:
            th = move-exception;
            r2.close();     // Catch: Throwable -> L28
        L30:
            throw th;     // Catch: Exception -> L31 Throwable -> L51
        L28:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Exception -> L31 Throwable -> L51
            goto L30
        L18:
            if (r2.moveToNext() == false) goto L23;
            com.obric.cae.location.database.d.a r5 = new com.obric.cae.location.database.d.a(r2.getString(r2.getColumnIndexOrThrow("new_type_name_l1")), r2.getString(r2.getColumnIndexOrThrow("new_type_name_l2")), r2.getString(r2.getColumnIndexOrThrow("new_type_name_l3")), r2.getString(r2.getColumnIndexOrThrow("new_type_code_l1")), r2.getString(r2.getColumnIndexOrThrow("new_type_code_l2")), r2.getString(r2.getColumnIndexOrThrow("new_type_code_l3")));     // Catch: Throwable -> L25
            if (r5.a() == false) goto L59;
            r0.add(r5);     // Catch: Throwable -> L25
        L31:
            e = move-exception;
            com.obric.cae.log.a.b("StarLocation-poi-db", "query legacy poi_datas failed", e);     // Catch: Throwable -> L51
        L51:
            th = move-exception;
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r1) {
            r1.execSQL("create table location_geofence (_id INTEGER PRIMARY KEY,userId INTEGER DEFAULT 0,packageName TEXT,id TEXT,latitude REAL,Longitude REAL,radius INTEGER,address TEXT,eventTimestamp INTEGER,transitionType INTEGER,confidence INTEGER,state INTEGER,type INTEGER,firstBreach INTEGER DEFAULT -1,poi_id TEXT DEFAULT '');");
            r1.execSQL("create table geofence_callback (_id INTEGER PRIMARY KEY,packageName TEXT,class TEXT);");
            r1.execSQL(c.c);
            r1.execSQL(c.d);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase r3, int r4, int r5) {
            com.obric.cae.log.a.g("StarLocation-db", "Downgrading database from version " + r4 + " to " + r5);
            r3.execSQL("DROP TABLE IF EXISTS location_geofence");
            r3.execSQL("DROP TABLE IF EXISTS geofence_callback");
            r3.execSQL("DROP TABLE IF EXISTS city_info");
            r3.execSQL("DROP TABLE IF EXISTS aoi_board");
            r3.execSQL("DROP TABLE IF EXISTS poi_datas");
            onCreate(r3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase r3) {
            super.onOpen(r3);
            if (a(r3, "location_geofence") == true) goto L6;
        L8:
            e(r3);
            g(r3);
            return;
        L6:
            if (a(r3, "location_geofence", "poi_id") == true) goto L8;
            r3.execSQL("ALTER TABLE location_geofence ADD COLUMN poi_id TEXT DEFAULT '';");
            com.obric.cae.log.a.e("StarLocation-db", "onOpen schema repair added poi_id column");
            goto L8
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r13, int r14, int r15) {
            com.obric.cae.log.a.c("StarLocation-db", "Upgrading database from version " + r14 + " to " + r15, StarGeofenceManager.getGeofenceLogFile(this.c));
            r13.beginTransaction();
            int r10 = r14;
        L3:
            if (r10 >= r15) goto L28;
            if (r10 != 3) goto L7;
            a(r13);     // Catch: Throwable -> L30 Exception -> L32
            r10 = 4;
        L32:
            e = move-exception;
            com.obric.cae.log.a.a("StarLocation-db", "Error upgrading database from " + r14 + " to " + r15, e);     // Catch: Throwable -> L30
            r13.execSQL("DROP TABLE IF EXISTS location_geofence");     // Catch: Throwable -> L30
            r13.execSQL("DROP TABLE IF EXISTS geofence_callback");     // Catch: Throwable -> L30
            r13.execSQL("DROP TABLE IF EXISTS city_info");     // Catch: Throwable -> L30
            r13.execSQL("DROP TABLE IF EXISTS aoi_board");     // Catch: Throwable -> L30
            r13.execSQL("DROP TABLE IF EXISTS poi_datas");     // Catch: Throwable -> L30
            onCreate(r13);     // Catch: Throwable -> L30
        L34:
            r13.endTransaction();
            return;
        L30:
            th = move-exception;
            r13.endTransaction();
            throw th;
        L7:
            if (r10 == 4) goto L8;
            if (r10 == 5) goto L11;
            if (r10 == 6) goto L15;
            if (r10 == 7) goto L17;
            if (r10 == 8) goto L19;
            if (r10 == 9) goto L21;
            if (r10 == 10) goto L23;
            if (r10 != 11) goto L27;
            g(r13);     // Catch: Throwable -> L30 Exception -> L32
            com.obric.cae.log.a.e("StarLocation-db", "v11->v12 migration moved poi_datas out of star_location.db");     // Catch: Throwable -> L30 Exception -> L32
            r10 = 12;
            goto L3
        L27:
            throw new IllegalStateException("No specific upgrade path for version " + r10);     // Catch: Throwable -> L30 Exception -> L32
        L23:
            e(r13);     // Catch: Throwable -> L30 Exception -> L32
            com.obric.cae.log.a.e("StarLocation-db", "v10->v11 migration added or repaired aoi_board cell columns");     // Catch: Throwable -> L30 Exception -> L32
            r10 = 11;
            goto L3
        L21:
            com.obric.cae.log.a.e("StarLocation-db", "v9->v10 migration skipped legacy poi_datas creation");     // Catch: Throwable -> L30 Exception -> L32
            r10 = 10;
            goto L3
        L19:
            d(r13);     // Catch: Throwable -> L30 Exception -> L32
            r10 = 9;
            goto L3
        L17:
            c(r13);     // Catch: Throwable -> L30 Exception -> L32
            r10 = 8;
            goto L3
        L15:
            f(r13);     // Catch: Throwable -> L30 Exception -> L32
            r10 = 7;
            goto L3
        L11:
            if (a(r13, "city_info") == true) goto L13;
            r13.execSQL(c.c);     // Catch: Throwable -> L30 Exception -> L32
            com.obric.cae.log.a.e("StarLocation-db", "Created table city_info in v6 migration.");     // Catch: Throwable -> L30 Exception -> L32
        L13:
            r10 = 6;
            goto L3
        L8:
            b(r13);     // Catch: Throwable -> L30 Exception -> L32
            r10 = 5;
            goto L3
        L28:
            r13.setTransactionSuccessful();     // Catch: Throwable -> L30 Exception -> L32
            com.obric.cae.log.a.e("StarLocation-db", "Database upgrade successful from " + r14 + " to " + r15);     // Catch: Throwable -> L30 Exception -> L32
            goto L34
        }
    }

    static {
        f7074b = new ConcurrentHashMap();
        c = "create table city_info (_id INTEGER PRIMARY KEY,adminArea TEXT,subAdminArea TEXT,locality TEXT,subLocality TEXT,updatedAt INTEGER);";
        d = "create table aoi_board (_id INTEGER PRIMARY KEY,poi_id TEXT UNIQUE,poi_name TEXT,aoi_board TEXT,state INTEGER DEFAULT " + AoiBoard.State.UNKNOWN.ordinal() + ",transition_type INTEGER DEFAULT " + AoiBoard.TransitionType.UNKNOWN.ordinal() + ",confidence INTEGER DEFAULT " + AoiBoard.Confidence.MIN.ordinal() + ",confidence_source INTEGER DEFAULT " + AoiBoard.ConfidenceSource.DEFAULT.ordinal() + ",event_time INTEGER DEFAULT 0,type INTEGER DEFAULT " + AoiBoard.Type.UNKNOWN.ordinal() + ",geofenceId TEXT DEFAULT '',cells TEXT DEFAULT '',new_type_code_l3 TEXT DEFAULT '');";
    }

    public c(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = false;
        this.g = r5;
        this.f = new f((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
        e();
    }

    public static int a(int r1) {
        if (r1 != 0) goto L4;
        return r1;
    L4:
        if (r1 == 1) goto L9;
        return -1;
    L9:
        return r1;
    }

    public static int a(SQLiteDatabase r4, a r5) {
        ContentValues r0 = new ContentValues();
        if (TextUtils.isEmpty(r5.f7075a.getPoiName()) == true) goto L6;
        r0.put("poi_name", r5.f7075a.getPoiName());
    L6:
        if (TextUtils.isEmpty(r5.f7076b) == true) goto L9;
        r0.put("cells", r5.f7076b);
    L9:
        if (TextUtils.isEmpty(r5.c) == true) goto L12;
        r0.put("new_type_code_l3", r5.c);
    L12:
        if (r0.size() != 0) goto L14;
        return 0;
    L14:
        int r6 = r4.update(TrafficRecognitionInfo.SOURCE_AOI_BOARD, r0, "poi_id=?", new String[]{r5.f7075a.getPoiId()});
        if (r6 <= 0) goto L17;
        com.obric.cae.log.a.d("StarLocation-db", "updated cell aoi_board fields, poiId=" + r5.f7075a.getPoiId() + ", values=" + r0);
    L17:
        return r6;
    }

    public static ContentValues a(AoiBoard r3) {
        ContentValues r0 = new ContentValues();
        r0.put("poi_id", r3.getPoiId());
        r0.put("poi_name", r3.getPoiName());
        r0.put(TrafficRecognitionInfo.SOURCE_AOI_BOARD, r3.getAoiBoard());
        r0.put("state", Integer.valueOf(r3.getCurState().ordinal()));
        r0.put("transition_type", Integer.valueOf(r3.getTransitionType().ordinal()));
        r0.put("confidence", Integer.valueOf(r3.getConfidence().ordinal()));
        r0.put("confidence_source", Integer.valueOf(r3.getConfidenceSource().ordinal()));
        r0.put("event_time", Long.valueOf(r3.getEventTime()));
        r0.put("type", Integer.valueOf(r3.getType().ordinal()));
        r0.put("geofenceId", r3.getGeofenceId());
        return r0;
    }

    public static synchronized c a(Context r4, int r5) {
        monitor-enter(c.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        ConcurrentHashMap r1 = f7074b;     // Catch: Throwable -> L9
        c r2 = (c) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r5)), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r2 != null) goto L7;
        r2 = new c(r6, r5);     // Catch: Throwable -> L9
        r1.put(Integer.valueOf(r5), r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(c.class);
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public static String a(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r3 = r2.trim();
        if (r3.isEmpty() == false) goto L9;
        return null;
    L9:
        return r3;
    }

    public static String a(String r1, String r2) {
        return r1 + "." + r2;
    }

    public static String a(String r1, String r2, String r3, String r4) {
        String r5 = a(r1);
        if (TextUtils.isEmpty(r5) == true) goto L5;
        return r5;
    L5:
        String r6 = a(r4);
        if ("北京市".equals(r6) == false) goto L8;
    L15:
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
        return r6;
    L18:
        String r8 = a(r2);
        if (TextUtils.isEmpty(r8) == true) goto L21;
        return r8;
    L21:
        String r9 = a(r3);
        if (TextUtils.isEmpty(r9) == true) goto L24;
        return r9;
    L24:
        return r6;
    L8:
        if ("上海市".equals(r6) == true) goto L15;
        if ("天津市".equals(r6) == true) goto L15;
        if ("重庆市".equals(r6) == true) goto L15;
        r7 = false;
        goto L16
    }

    public static ArrayList a(Cursor r8) {
        Cursor r9 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r8, Cursor.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        if (r9 != null) goto L5;
    L105:
        return r0;
    L5:
        if (r9.moveToFirst() == false) goto L105;
    L6:
        StarGeofence r1 = new StarGeofence();
        int r2 = r9.getColumnIndex("userId");
        boolean r3 = e;
        if (r3 == true) goto L12;
        if (r2 != (-1)) goto L12;
        throw new AssertionError();
    L12:
        int r4 = r9.getInt(r2);
        int r5 = r9.getColumnIndex(ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (r3 == true) goto L18;
        if (r5 != (-1)) goto L18;
        throw new AssertionError();
    L18:
        r1.setPackageName(r9.getString(r5));
        int r6 = r9.getColumnIndex(OaidModel.KEY_ID);
        if (r3 == true) goto L24;
        if (r6 != (-1)) goto L24;
        throw new AssertionError();
    L24:
        r1.setGeofenceId(r9.getString(r6));
        int r7 = r9.getColumnIndex("latitude");
        if (r3 == true) goto L30;
        if (r7 != (-1)) goto L30;
        throw new AssertionError();
    L30:
        r1.setLatitude(r9.getDouble(r7));
        int r10 = r9.getColumnIndex("Longitude");
        if (r3 == true) goto L36;
        if (r10 != (-1)) goto L36;
        throw new AssertionError();
    L36:
        r1.setLongitude(r9.getDouble(r10));
        int r11 = r9.getColumnIndex("radius");
        if (r3 == true) goto L42;
        if (r11 != (-1)) goto L42;
        throw new AssertionError();
    L42:
        r1.setRadius(r9.getInt(r11));
        int r12 = r9.getColumnIndex(MemoryKeyInfoEntity.KEY_ADDRESS);
        if (r3 == true) goto L48;
        if (r12 != (-1)) goto L48;
        throw new AssertionError();
    L48:
        r1.setAddress(r9.getString(r12));
        int r13 = r9.getColumnIndex("eventTimestamp");
        if (r3 == true) goto L54;
        if (r13 != (-1)) goto L54;
        throw new AssertionError();
    L54:
        r1.setEventTimestamp(r9.getLong(r13));
        int r14 = r9.getColumnIndex("transitionType");
        if (r3 == true) goto L60;
        if (r14 != (-1)) goto L60;
        throw new AssertionError();
    L60:
        r1.setTransitionType(StarGeofence.GeoTransitionType.values()[r9.getInt(r14)]);
        int r15 = r9.getColumnIndex("confidence");
        if (r3 == true) goto L66;
        if (r15 != (-1)) goto L66;
        throw new AssertionError();
    L66:
        r1.setConfidence(StarGeofence.GeoConfidence.values()[r9.getInt(r15)]);
        int r16 = r9.getColumnIndex("state");
        if (r3 == true) goto L72;
        if (r16 != (-1)) goto L72;
        throw new AssertionError();
    L72:
        r1.setGeoState(StarGeofence.GeoState.values()[r9.getInt(r16)]);
        int r17 = r9.getColumnIndex("type");
        if (r3 == true) goto L78;
        if (r17 != (-1)) goto L78;
        throw new AssertionError();
    L78:
        r1.setGeoType(StarGeofence.GeoType.values()[r9.getInt(r17)]);
        int r18 = r9.getColumnIndex("firstBreach");
        if (r3 == true) goto L84;
        if (r18 != (-1)) goto L84;
        throw new AssertionError();
    L84:
        int r19 = r9.getInt(r18);
        boolean r20 = true;
        if (r19 == 0) goto L89;
        if (r19 == 1) goto L89;
        r19 = -1;
    L89:
        if (r19 == 0) goto L93;
        if (r19 == 1) goto L93;
        int r21 = -1;
    L94:
        if (r21 != 0) goto L97;
        r20 = false;
    L97:
        r1.setFirstBreach(r20);
        int r22 = r9.getColumnIndex("poi_id");
        if (r3 == true) goto L103;
        if (r22 != (-1)) goto L103;
        throw new AssertionError();
    L103:
        r1.setPoiId(r9.getString(r22));
        r0.add(new e(r1, r4, r19));
        if (r9.moveToNext() == true) goto L6;
    L93:
        r21 = r19;
        goto L94
    }

    public static void a(SQLiteDatabase r4, String r5, String r6) {
        r4.execSQL("DELETE FROM " + a(r5, "city_info"));
        r4.execSQL("INSERT INTO " + a(r5, "city_info") + " (_id,adminArea,subAdminArea,locality,subLocality,updatedAt) SELECT _id,adminArea,subAdminArea,locality,subLocality,updatedAt FROM " + a(r6, "city_info"));
        r4.execSQL("DELETE FROM " + a(r5, TrafficRecognitionInfo.SOURCE_AOI_BOARD));
        r4.execSQL("INSERT OR REPLACE INTO " + a(r5, TrafficRecognitionInfo.SOURCE_AOI_BOARD) + " (_id,poi_id,poi_name,aoi_board,state,transition_type,confidence,confidence_source,event_time,type,geofenceId,cells,new_type_code_l3) SELECT _id,poi_id,poi_name,aoi_board,state,transition_type,confidence,confidence_source,event_time,type,geofenceId,cells,new_type_code_l3 FROM " + a(r6, TrafficRecognitionInfo.SOURCE_AOI_BOARD));
    }

    public static void a(SQLiteDatabase r4, String r5, String r6, String r7, String r8, long r9) {
        r4.delete("city_info", null, null);
        ContentValues r2 = new ContentValues();
        r2.put("adminArea", r5);
        r2.put("subAdminArea", r6);
        r2.put("locality", r7);
        r2.put("subLocality", r8);
        r2.put("updatedAt", Long.valueOf(r9));
        if (r4.insert("city_info", null, r2) == (-1)) goto L6;
        return;
    L6:
        throw new IllegalStateException("insert city_info failed");
    }

    public static boolean a(int r1, int r2) {
        if (r1 == (-1)) goto L7;
        if (r1 == r2) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean a(File r7) {
        if (r7.exists() == true) goto L6;
        return true;
    L6:
        if (r7.isDirectory() == false) goto L12;
        File[] r0 = r7.listFiles();
        if (r0 == null) goto L12;
        int r3 = r0.length;
        boolean r5 = true;
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L14;
        r5 = r5 & a(r0[r4]);
        r4 = r4 + 1;
    L14:
        if (r7.delete() == false) goto L18;
        if (r5 == false) goto L18;
        return true;
    L18:
        return false;
    L12:
        r5 = true;
        goto L14
    }

    public static ArrayList b(Cursor r4) {
        Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        if (r5 != null) goto L19;
        return r0;
    L19:
    L13:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L6:
        if (r5.moveToFirst() == true) goto L9;
        r5.close();
        return r0;
    L9:
        AoiBoard r1 = new AoiBoard();     // Catch: Throwable -> L13
        r1.setPoiId(r5.getString(r5.getColumnIndexOrThrow("poi_id")));     // Catch: Throwable -> L13
        r1.setPoiName(r5.getString(r5.getColumnIndexOrThrow("poi_name")));     // Catch: Throwable -> L13
        r1.setAoiBoard(r5.getString(r5.getColumnIndexOrThrow(TrafficRecognitionInfo.SOURCE_AOI_BOARD)));     // Catch: Throwable -> L13
        r1.setCurState(AoiBoard.State.values()[r5.getInt(r5.getColumnIndexOrThrow("state"))]);     // Catch: Throwable -> L13
        r1.setTransitionType(AoiBoard.TransitionType.values()[r5.getInt(r5.getColumnIndexOrThrow("transition_type"))]);     // Catch: Throwable -> L13
        r1.setConfidence(AoiBoard.Confidence.values()[r5.getInt(r5.getColumnIndexOrThrow("confidence"))]);     // Catch: Throwable -> L13
        r1.setConfidenceSource(AoiBoard.ConfidenceSource.values()[r5.getInt(r5.getColumnIndexOrThrow("confidence_source"))]);     // Catch: Throwable -> L13
        r1.setEvent(AoiBoard.Event.UNKNOWN);     // Catch: Throwable -> L13
        r1.setEventTime(r5.getLong(r5.getColumnIndexOrThrow("event_time")));     // Catch: Throwable -> L13
        r1.setType(AoiBoard.Type.values()[r5.getInt(r5.getColumnIndexOrThrow("type"))]);     // Catch: Throwable -> L13
        r1.setGeofenceId(r5.getString(r5.getColumnIndexOrThrow("geofenceId")));     // Catch: Throwable -> L13
        r0.add(r1);     // Catch: Throwable -> L13
        if (r5.moveToNext() == true) goto L9;
        r5.close();
        return r0;
    }

    public static boolean b(int r1) {
        if (r1 == 0) goto L7;
        if (r1 == 1) goto L7;
        r1 = -1;
    L7:
        if (r1 != 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final int a(String r3, String r4, String[] r5) {
        com.obric.cae.log.a.c("StarLocation-db", "DB delete, table=" + r3 + ", whereClause=" + r4);
        return this.f.getWritableDatabase().delete(r3, r4, r5);
    }

    public synchronized int a(List<a> r8) {
        monitor-enter(this);
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        if (r9.isEmpty() == false) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        SQLiteDatabase r0 = this.f.getWritableDatabase();     // Catch: Throwable -> L33
        r0.beginTransaction();     // Catch: Throwable -> L33
        Iterator r2 = r9.iterator();     // Catch: Throwable -> L24 Exception -> L26
        int r3 = 0;
    L11:
        if (r2.hasNext() == false) goto L20;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 Exception -> L26
        if (r4 == null) goto L11;
        AoiBoard r5 = r4.f7075a;     // Catch: Throwable -> L24 Exception -> L26
        if (r5 == null) goto L11;
        if (TextUtils.isEmpty(r5.getPoiId()) == true) goto L11;
        r3 = r3 + a(r0, r4);     // Catch: Throwable -> L24 Exception -> L26
        goto L11
    L20:
        r0.setTransactionSuccessful();     // Catch: Throwable -> L24 Exception -> L26
        com.obric.cae.log.a.d("StarLocation-db", "updated count=" + r3 + ", input count=" + r9.size());     // Catch: Throwable -> L24 Exception -> L26
        r0.endTransaction();     // Catch: Throwable -> L33
        monitor-exit(this);
        return r3;
    L26:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-db", "failed", e);     // Catch: Throwable -> L24
        r0.endTransaction();     // Catch: Throwable -> L33
        return 0;
    L24:
        th = move-exception;
        r0.endTransaction();     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    public synchronized int a(Map<String, String> r10) {
        monitor-enter(this);
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        if (r11.isEmpty() == false) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        SQLiteDatabase r0 = this.f.getWritableDatabase();     // Catch: Throwable -> L33
        r0.beginTransaction();     // Catch: Throwable -> L33
        Iterator r2 = r11.entrySet().iterator();     // Catch: Throwable -> L24 Exception -> L26
        int r3 = 0;
    L11:
        if (r2.hasNext() == false) goto L20;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 Exception -> L26
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 Exception -> L26
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 Exception -> L26
        if (TextUtils.isEmpty(r5) == true) goto L11;
        if (TextUtils.isEmpty(r6) == true) goto L11;
        ContentValues r7 = new ContentValues();     // Catch: Throwable -> L24 Exception -> L26
        r7.put("new_type_code_l3", r6);     // Catch: Throwable -> L24 Exception -> L26
        int r8 = r0.update(TrafficRecognitionInfo.SOURCE_AOI_BOARD, r7, "poi_id=?", new String[]{r5});     // Catch: Throwable -> L24 Exception -> L26
        if (r8 <= 0) goto L11;
        r3 = r3 + r8;     // Catch: Throwable -> L24 Exception -> L26
        goto L11
    L20:
        r0.setTransactionSuccessful();     // Catch: Throwable -> L24 Exception -> L26
        com.obric.cae.log.a.d("StarLocation-db", "updated count=" + r3 + ", input count=" + r11.size());     // Catch: Throwable -> L24 Exception -> L26
        r0.endTransaction();     // Catch: Throwable -> L33
        monitor-exit(this);
        return r3;
    L26:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-db", "failed", e);     // Catch: Throwable -> L24
        r0.endTransaction();     // Catch: Throwable -> L33
        return 0;
    L24:
        th = move-exception;
        r0.endTransaction();     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    public final Cursor a(String r9, String[] r10, String r11, String[] r12) {
        com.obric.cae.log.a.a("StarLocation-db", "DB query, table=" + r9 + ", selection=" + r11);
        return this.f.getReadableDatabase().query(r9, r10, r11, r12, null, null, null);
    }

    public synchronized C0354c a(String r27, String r28, String r29, String r30, long r31) {
        monitor-enter(this);
        b r0 = b();     // Catch: Throwable -> L268
        if (r0 != null) goto L7;
        String r3 = null;
    L8:
        String r11 = a(r28, r29, r30, r27);     // Catch: Throwable -> L268
        String r4 = a(r28);     // Catch: Throwable -> L268
        if (TextUtils.isEmpty(r4) == false) goto L11;
        String r12 = r11;
    L13:
        if (r0 != null) goto L15;
    L18:
        boolean r1 = true;
    L19:
        if (r1 == true) goto L30;
        SQLiteDatabase r2 = this.f.getWritableDatabase();     // Catch: Throwable -> L268
        r2.beginTransaction();     // Catch: Throwable -> L268
        a(r2, r27, r12, r29, r30, r31);     // Catch: Throwable -> L26
        r2.setTransactionSuccessful();     // Catch: Throwable -> L26
        r2.endTransaction();     // Catch: Throwable -> L268
        C0354c r5 = new C0354c(false, false, r3, r11);     // Catch: Throwable -> L268
        monitor-exit(this);
        return r5;
    L26:
        th = move-exception;
        r2.endTransaction();     // Catch: Throwable -> L268
        throw th;     // Catch: Throwable -> L268
    L30:
        if (TextUtils.isEmpty(r11) == false) goto L41;
        com.obric.cae.log.a.d("StarLocation-db", "skip city archive: target subAdminArea is empty");     // Catch: Throwable -> L268
        SQLiteDatabase r13 = this.f.getWritableDatabase();     // Catch: Throwable -> L268
        r13.beginTransaction();     // Catch: Throwable -> L268
        a(r13, r27, r28, r29, r30, r31);     // Catch: Throwable -> L37
        r13.setTransactionSuccessful();     // Catch: Throwable -> L37
        r13.endTransaction();     // Catch: Throwable -> L268
        C0354c r6 = new C0354c(true, false, r3, null);     // Catch: Throwable -> L268
        monitor-exit(this);
        return r6;
    L37:
        th = move-exception;
        r13.endTransaction();     // Catch: Throwable -> L268
        throw th;     // Catch: Throwable -> L268
    L41:
        if (TextUtils.isEmpty(r3) == true) goto L228;
        File r7 = i(r3);     // Catch: Throwable -> L268
        File r8 = r7.getParentFile();     // Catch: Throwable -> L268
        if (r8 == null) goto L227;
        if (r8.exists() == false) goto L52;
        if (r8.isDirectory() == true) goto L52;
        throw new IllegalStateException("archive path is not directory");     // Catch: Throwable -> L268
    L52:
        if (r8.exists() == true) goto L59;
        if (r8.mkdirs() == true) goto L59;
        throw new IllegalStateException("create archive directory failed");     // Catch: Throwable -> L268
    L59:
        if (r7.exists() == true) goto L61;
        File r9 = this.f.f7086b.getDatabasePath(f.a(this.g));     // Catch: Throwable -> L268
        Cursor r10 = this.f.getWritableDatabase().rawQuery("PRAGMA wal_checkpoint(FULL)", null);     // Catch: Throwable -> L223
        if (r10 != null) goto L285;
    L104:
        if (r10 == null) goto L106;
        r10.close();     // Catch: Throwable -> L223
    L106:
        this.f.close();     // Catch: Throwable -> L268
        if (r9.exists() == false) goto L222;
        if (r9.isFile() == false) goto L222;
        File r14 = r7.getParentFile();     // Catch: Throwable -> L268
        if (r14 != null) goto L113;
    L117:
        File r15 = new File(r7.getAbsolutePath() + ".tmp");     // Catch: Throwable -> L268
        if (r15.exists() == true) goto L120;
    L323:
        FileInputStream r16 = new FileInputStream(r9);     // Catch: Throwable -> L201
        FileOutputStream r17 = new FileOutputStream(r15);     // Catch: Throwable -> L190
        FileChannel r21 = r16.getChannel();     // Catch: Throwable -> L179
        FileChannel r22 = r17.getChannel();     // Catch: Throwable -> L167
        long r18 = r21.size();     // Catch: Throwable -> L155
        String r25 = r3;
        long r19 = 0;
    L129:
        if (r19 >= r18) goto L135;
        long r110 = r21.transferTo(r19, r18 - r19, r22);     // Catch: Throwable -> L153
        if (r110 <= 0) goto L135;
        r19 = r19 + r110;     // Catch: Throwable -> L153
    L153:
        th = th;
    L157:
        Throwable r20 = th;
        if (r22 == null) goto L328;
        r22.close();     // Catch: Throwable -> L161
    L329:
        throw r20;     // Catch: Throwable -> L165
    L161:
        th = move-exception;
        r20.addSuppressed(th);     // Catch: Throwable -> L165
        throw r20;     // Catch: Throwable -> L165
    L328:
        throw r20;     // Catch: Throwable -> L165
    L135:
        if (r19 != r18) goto L152;
        r17.getFD().sync();     // Catch: Throwable -> L153
        if (r22 == null) goto L139;
        r22.close();     // Catch: Throwable -> L165
    L139:
        r21.close();     // Catch: Throwable -> L177
        r17.close();     // Catch: Throwable -> L188
        r16.close();     // Catch: Throwable -> L199
        if (r7.exists() == false) goto L148;
        if (r7.delete() == true) goto L148;
    L146:
        r15.delete();     // Catch: Throwable -> L268
    L205:
        boolean r23 = false;
    L206:
        if (r23 == false) goto L220;
        b(r7);     // Catch: Throwable -> L268
        SQLiteDatabase r24 = SQLiteDatabase.openOrCreateDatabase(r7, null);     // Catch: Throwable -> L268
        r24.beginTransaction();     // Catch: Throwable -> L216
        ContentValues r26 = new ContentValues();     // Catch: Throwable -> L213
        String r111 = r25;
        r26.put("subAdminArea", r111);     // Catch: Throwable -> L213
        r24.update("city_info", r26, "subAdminArea IS NULL OR TRIM(subAdminArea) = ''", null);     // Catch: Throwable -> L213
        r24.setTransactionSuccessful();     // Catch: Throwable -> L213
        r24.endTransaction();     // Catch: Throwable -> L216
        r24.close();     // Catch: Throwable -> L268
        com.obric.cae.log.a.d("StarLocation-db", "old city archive db copied, city=" + r111);     // Catch: Throwable -> L268
    L229:
        File r32 = i(r11);     // Catch: Throwable -> L268
        if (r32.exists() == true) goto L232;
    L234:
        boolean r33 = false;
    L235:
        if (r33 == true) goto L237;
        SQLiteDatabase r34 = this.f.getWritableDatabase();     // Catch: Throwable -> L268
        r34.beginTransaction();     // Catch: Throwable -> L268
        a(r34, r27, r12, r29, r30, r31);     // Catch: Throwable -> L265
        int r35 = r34.delete(TrafficRecognitionInfo.SOURCE_AOI_BOARD, null, null);     // Catch: Throwable -> L265
        r34.setTransactionSuccessful();     // Catch: Throwable -> L265
        com.obric.cae.log.a.d("StarLocation-db", "active city initialized, clearedAoiCount=" + r35 + ", city=" + r12);     // Catch: Throwable -> L265
        r34.endTransaction();     // Catch: Throwable -> L268
    L262:
        com.obric.cae.log.a.d("StarLocation-db", "city storage switched, previousCity=" + r111 + ", targetCity=" + r11 + ", restoredFromArchive=" + r33);     // Catch: Throwable -> L268
        C0354c r36 = new C0354c(true, r33, r111, r11);     // Catch: Throwable -> L268
        monitor-exit(this);
        return r36;
    L265:
        th = move-exception;
        r34.endTransaction();     // Catch: Throwable -> L268
        throw th;     // Catch: Throwable -> L268
    L237:
        if (r32.exists() == false) goto L257;
        if (r32.isFile() == false) goto L257;
        b(r32);     // Catch: Throwable -> L268
        SQLiteDatabase r37 = this.f.getWritableDatabase();     // Catch: Throwable -> L268
        r37.execSQL("ATTACH DATABASE ? AS city_archive", new Object[]{r32.getAbsolutePath()});     // Catch: Throwable -> L268
        r37.beginTransaction();     // Catch: Throwable -> L251
        a(r37, "main", "city_archive");     // Catch: Throwable -> L248
        a(r37, r27, r12, r29, r30, r31);     // Catch: Throwable -> L248
        r37.setTransactionSuccessful();     // Catch: Throwable -> L248
        r37.endTransaction();     // Catch: Throwable -> L251
        r37.execSQL("DETACH DATABASE city_archive");     // Catch: Throwable -> L246
    L246:
        com.obric.cae.log.a.g("StarLocation-db", "detach city archive failed");     // Catch: Throwable -> L268
        goto L262
    L248:
        th = move-exception;
        r37.endTransaction();     // Catch: Throwable -> L251
        throw th;     // Catch: Throwable -> L251
    L251:
        th = move-exception;
        r37.execSQL("DETACH DATABASE city_archive");     // Catch: Throwable -> L254
    L255:
        throw th;     // Catch: Throwable -> L268
    L254:
        com.obric.cae.log.a.g("StarLocation-db", "detach city archive failed");     // Catch: Throwable -> L268
    L257:
        throw new IllegalStateException("target archive db not found");     // Catch: Throwable -> L268
    L232:
        if (r32.isFile() == false) goto L234;
        r33 = true;
        goto L235
    L213:
        th = move-exception;
        r24.endTransaction();     // Catch: Throwable -> L216
        throw th;     // Catch: Throwable -> L216
    L216:
        th = move-exception;
        r24.close();     // Catch: Throwable -> L268
        throw th;     // Catch: Throwable -> L268
    L220:
        throw new IllegalStateException("copy archive db failed");     // Catch: Throwable -> L268
    L148:
        if (r15.renameTo(r7) == false) goto L146;
        r23 = true;
        goto L206
    L152:
        throw new IllegalStateException("copy incomplete, size=" + r18 + ", copied=" + r19);     // Catch: Throwable -> L153
    L155:
        th = th;
        r25 = r3;
    L165:
        th = th;
    L169:
        Throwable r38 = th;
        if (r21 == null) goto L330;
        r21.close();     // Catch: Throwable -> L173
    L331:
        throw r38;     // Catch: Throwable -> L177
    L173:
        th = move-exception;
        r38.addSuppressed(th);     // Catch: Throwable -> L177
        throw r38;     // Catch: Throwable -> L177
    L330:
        throw r38;     // Catch: Throwable -> L177
    L167:
        th = th;
        r25 = r3;
    L177:
        th = th;
    L181:
        Throwable r39 = th;
        r17.close();     // Catch: Throwable -> L184
    L332:
        throw r39;     // Catch: Throwable -> L188
    L184:
        th = move-exception;
        r39.addSuppressed(th);     // Catch: Throwable -> L188
        throw r39;     // Catch: Throwable -> L188
    L179:
        th = th;
        r25 = r3;
    L188:
        th = th;
    L192:
        Throwable r40 = th;
        r16.close();     // Catch: Throwable -> L195
    L333:
        throw r40;     // Catch: Throwable -> L199
    L195:
        th = move-exception;
        r40.addSuppressed(th);     // Catch: Throwable -> L199
        throw r40;     // Catch: Throwable -> L199
    L190:
        th = th;
        r25 = r3;
    L199:
        th = th;
    L203:
        com.obric.cae.log.a.a("StarLocation-db", "copyFileAtomically failed", th);     // Catch: Throwable -> L268
        r15.delete();     // Catch: Throwable -> L271
    L201:
        th = th;
        r25 = r3;
        goto L203
    L120:
        if (r15.delete() == true) goto L323;
    L116:
        r25 = r3;
        goto L205
    L113:
        if (r14.exists() == true) goto L117;
        if (r14.mkdirs() == true) goto L117;
    L222:
        throw new IllegalStateException("location db not found");     // Catch: Throwable -> L268
    L285:
        r10.moveToFirst();     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L100
    L327:
        throw th;     // Catch: Throwable -> L223
    L100:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L223
        throw th;     // Catch: Throwable -> L223
    L223:
        th = move-exception;
        this.f.close();     // Catch: Throwable -> L268
        throw th;     // Catch: Throwable -> L268
    L61:
        if (r7.isFile() == false) goto L90;
        b(r7);     // Catch: Throwable -> L268
        SQLiteDatabase r41 = this.f.getWritableDatabase();     // Catch: Throwable -> L268
        r41.execSQL("ATTACH DATABASE ? AS city_archive", new Object[]{r7.getAbsolutePath()});     // Catch: Throwable -> L268
        r41.beginTransaction();     // Catch: Throwable -> L84
        a(r41, "city_archive", "main");     // Catch: Throwable -> L81
        r41.setTransactionSuccessful();     // Catch: Throwable -> L81
        r41.endTransaction();     // Catch: Throwable -> L84
        r41.execSQL("DETACH DATABASE city_archive");     // Catch: Throwable -> L68
    L69:
        SQLiteDatabase r42 = SQLiteDatabase.openOrCreateDatabase(r7, null);     // Catch: Throwable -> L268
        r42.beginTransaction();     // Catch: Throwable -> L78
        ContentValues r43 = new ContentValues();     // Catch: Throwable -> L75
        r43.put("subAdminArea", r3);     // Catch: Throwable -> L75
        r42.update("city_info", r43, "subAdminArea IS NULL OR TRIM(subAdminArea) = ''", null);     // Catch: Throwable -> L75
        r42.setTransactionSuccessful();     // Catch: Throwable -> L75
        r42.endTransaction();     // Catch: Throwable -> L78
        r42.close();     // Catch: Throwable -> L268
        com.obric.cae.log.a.d("StarLocation-db", "old city archive tables overwritten, city=" + r3);     // Catch: Throwable -> L268
        r111 = r3;
        goto L229
    L75:
        th = move-exception;
        r42.endTransaction();     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        r42.close();     // Catch: Throwable -> L268
        throw th;     // Catch: Throwable -> L268
    L68:
        com.obric.cae.log.a.g("StarLocation-db", "detach city archive failed");     // Catch: Throwable -> L268
        goto L69
    L81:
        th = move-exception;
        r41.endTransaction();     // Catch: Throwable -> L84
        throw th;     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        r41.execSQL("DETACH DATABASE city_archive");     // Catch: Throwable -> L87
    L88:
        throw th;     // Catch: Throwable -> L268
    L87:
        com.obric.cae.log.a.g("StarLocation-db", "detach city archive failed");     // Catch: Throwable -> L268
        goto L88
    L90:
        throw new IllegalStateException("archive db is not file");     // Catch: Throwable -> L268
    L227:
        throw new IllegalStateException("archive db parent is null");     // Catch: Throwable -> L268
    L228:
        r111 = r3;
        com.obric.cae.log.a.d("StarLocation-db", "skip old city archive: previous subAdminArea is empty");     // Catch: Throwable -> L268
        goto L229
    L15:
        if (TextUtils.equals(a(r0.f7078b, r0.c, r0.d, r0.f7077a), r11) == false) goto L18;
        r1 = false;
        goto L19
    L11:
        r12 = r4;
        goto L13
    L7:
        r3 = a(r0.f7078b, r0.c, r0.d, r0.f7077a);     // Catch: Throwable -> L268
    L268:
        th = move-exception;
        throw th;
    }

    public synchronized List<StarGeofence> a() {
        monitor-enter(this);
        d();     // Catch: Throwable -> L19
        if (this.h.isEmpty() == false) goto L8;
        com.obric.cae.log.a.c("StarLocation-db", "queryAllGeofences, cache empty");     // Catch: Throwable -> L19
        List<StarGeofence> r0 = Collections.emptyList();     // Catch: Throwable -> L19
        monitor-exit(this);
        return r0;
    L8:
        ArrayList r1 = new ArrayList(this.h.size());     // Catch: Throwable -> L19
        Iterator r2 = this.h.values().iterator();     // Catch: Throwable -> L19
    L10:
        if (r2.hasNext() == false) goto L16;
        e r3 = (e) ZeusTransformUtils.preCheckCast(r2.next(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r3 == null) goto L10;
        if (r3.c() == null) goto L10;
        r1.add(r3.c());     // Catch: Throwable -> L19
        goto L10
    L16:
        com.obric.cae.log.a.c("StarLocation-db", "queryAllGeofences, cache size=" + r1.size());     // Catch: Throwable -> L19
        monitor-exit(this);
        return r1;
    L19:
        th = move-exception;
        throw th;
    }

    public synchronized List<StarGeofence> a(int r6, StarGeofence.GeoType r7) {
        monitor-enter(this);
        d();     // Catch: Throwable -> L27
        if (this.h.isEmpty() == false) goto L8;
        com.obric.cae.log.a.b("StarLocation-db", "cache empty, userId=" + r6 + ", geoType=" + r7);     // Catch: Throwable -> L27
        List<StarGeofence> r8 = Collections.emptyList();     // Catch: Throwable -> L27
        monitor-exit(this);
        return r8;
    L8:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L27
        Iterator r1 = this.h.values().iterator();     // Catch: Throwable -> L27
    L10:
        if (r1.hasNext() == false) goto L24;
        e r2 = (e) ZeusTransformUtils.preCheckCast(r1.next(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r2 == null) goto L10;
        if (r2.c() == null) goto L10;
        if (r2.d() != r6) goto L10;
        if (r7 == null) goto L23;
        if (r2.c().getGeoType() != r7) goto L10;
    L23:
        r0.add(r2.c());     // Catch: Throwable -> L27
        goto L10
    L24:
        com.obric.cae.log.a.b("StarLocation-db", "size=" + r0.size() + ", userId=" + r6 + ", geoType=" + r7);     // Catch: Throwable -> L27
        monitor-exit(this);
        return r0;
    L27:
        th = move-exception;
        throw th;
    }

    public synchronized void a(ComponentName r5) {
        monitor-enter(this);
        if (r5 != null) goto L23;
        monitor-exit(this);
        return;
    L23:
        d();     // Catch: Throwable -> L20
        String r0 = r5.getPackageName();     // Catch: Throwable -> L20
        String r6 = r5.getClassName();     // Catch: Throwable -> L20
        d r1 = (d) ZeusTransformUtils.preCheckCast(this.j.get(r0), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r1 == null) goto L15;
        com.obric.cae.log.a.c("StarLocation-db", "registerGeofenceCallback, get Same Class: " + r1.a());     // Catch: Throwable -> L20
        if (r6.equalsIgnoreCase(r1.a()) == false) goto L14;
        com.obric.cae.log.a.c("StarLocation-db", "registerGeofenceCallback, cache hit, skip DB");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L14:
        a("geofence_callback", "packageName = ?", new String[]{r0});     // Catch: Throwable -> L20
        this.j.remove(r0);     // Catch: Throwable -> L20
        com.obric.cae.log.a.c("StarLocation-db", "deleteGeofenceCallback, cache removed pkg=" + r0);     // Catch: Throwable -> L20
    L15:
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L20
        r2.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r0);     // Catch: Throwable -> L20
        r2.put("class", r6);     // Catch: Throwable -> L20
        if (a("geofence_callback", r2) == false) goto L18;
        this.j.put(r0, new d(r0, r6));     // Catch: Throwable -> L20
        com.obric.cae.log.a.c("StarLocation-db", "registerGeofenceCallback, cache updated pkg=" + r0 + ", class=" + r6);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void a(SQLiteDatabase r4) {
        f r0 = this.f;
        int r1 = f.f7085a;
        r0.getClass();
        if (f.a(r4, "city_info") == true) goto L6;
        r4.execSQL(c);
        return;
    L6:
        this.f.getClass();
        f.a(r4, "city_info", "adminArea", "TEXT");
        this.f.getClass();
        f.a(r4, "city_info", "subAdminArea", "TEXT");
        this.f.getClass();
        f.a(r4, "city_info", "locality", "TEXT");
        this.f.getClass();
        f.a(r4, "city_info", "subLocality", "TEXT");
        this.f.getClass();
        f.a(r4, "city_info", "updatedAt", "INTEGER");
    }

    public synchronized void a(StarGeofence r20, int r21) {
        monitor-enter(this);
        d();     // Catch: Throwable -> L16
        StarGeofence r2 = d(r20.getGeofenceId());     // Catch: Throwable -> L16
        if (r2 != null) goto L7;
    L11:
        String r3 = r20.getPackageName();     // Catch: Throwable -> L16
        String r4 = r20.getGeofenceId();     // Catch: Throwable -> L16
        double r5 = r20.getLatitude();     // Catch: Throwable -> L16
        double r6 = r20.getLongitude();     // Catch: Throwable -> L16
        int r8 = r20.getRadius();     // Catch: Throwable -> L16
        String r9 = r20.getAddress();     // Catch: Throwable -> L16
        long r10 = r20.getEventTimestamp();     // Catch: Throwable -> L16
        StarGeofence.GeoTransitionType r12 = r20.getTransitionType();     // Catch: Throwable -> L16
        StarGeofence.GeoConfidence r13 = r20.getConfidence();     // Catch: Throwable -> L16
        StarGeofence.GeoState r14 = r20.getGeoState();     // Catch: Throwable -> L16
        StarGeofence.GeoType r15 = r20.getGeoType();     // Catch: Throwable -> L16
        String r0 = r20.getPoiId();     // Catch: Throwable -> L16
        ContentValues r1 = new ContentValues();     // Catch: Throwable -> L16
        r1.put("userId", Integer.valueOf(r21));     // Catch: Throwable -> L16
        r1.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r3);     // Catch: Throwable -> L16
        r1.put(OaidModel.KEY_ID, r4);     // Catch: Throwable -> L16
        r1.put("latitude", Double.valueOf(r5));     // Catch: Throwable -> L16
        r1.put("Longitude", Double.valueOf(r6));     // Catch: Throwable -> L16
        r1.put("radius", Integer.valueOf(r8));     // Catch: Throwable -> L16
        r1.put(MemoryKeyInfoEntity.KEY_ADDRESS, r9);     // Catch: Throwable -> L16
        r1.put("eventTimestamp", Long.valueOf(r10));     // Catch: Throwable -> L16
        r1.put("transitionType", Integer.valueOf(r12.ordinal()));     // Catch: Throwable -> L16
        r1.put("confidence", Integer.valueOf(r13.ordinal()));     // Catch: Throwable -> L16
        r1.put("state", Integer.valueOf(r14.ordinal()));     // Catch: Throwable -> L16
        r1.put("type", Integer.valueOf(r15.ordinal()));     // Catch: Throwable -> L16
        r1.put("firstBreach", -1);     // Catch: Throwable -> L16
        r1.put("poi_id", r0);     // Catch: Throwable -> L16
        boolean r7 = a("location_geofence", r1);     // Catch: Throwable -> L16
        com.obric.cae.log.a.c("StarLocation-db", "insertGeofence, db inserted=" + r7 + ", pkg=" + r20.getPackageName() + ", id=" + r20.getGeofenceId());     // Catch: Throwable -> L16
        if (r7 == false) goto L14;
        h(r20.getGeofenceId());     // Catch: Throwable -> L16
        a(r20, r21, -1);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L7:
        if (r2.equals(r20) == false) goto L11;
        com.obric.cae.log.a.c("StarLocation-db", "Geofence already exists!");     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void a(StarGeofence r2, int r3, int r4) {
        e r0 = new e(r2, r3, r4);
        this.h.put(r0.b(), r0);
        List r5 = (List) ZeusTransformUtils.preCheckCast(this.i.get(r0.a()), List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        r5 = new ArrayList();
        this.i.put(r0.a(), r5);
    L5:
        r5.add(r0);
        com.obric.cae.log.a.c("StarLocation-db", "cache add geofence, pkg=" + r0.a() + ", id=" + r0.b() + ", firstBreachState=" + r0.e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public synchronized boolean a(StarGeofence r5) {
        monitor-enter(this);
        ?? r0 = 0;
        if (r5 != 0) goto L31;
    L29:
        monitor-exit(this);
        return false;
    L31:
    L26:
        th = move-exception;
        throw th;
    L6:
        if (r5.getPackageName() == null) goto L29;
        if (r5.getGeofenceId() == null) goto L29;
        d();     // Catch: Throwable -> L26
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.h.get(r5.getGeofenceId()), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r1 != 0) goto L13;
    L23:
        boolean r2 = r5.isFirstBreach();     // Catch: Throwable -> L26
        com.obric.cae.log.a.c("StarLocation-db", "advanceGeofenceFirstBreachForNotification, cache miss, id=" + r5.getGeofenceId() + ", isFirstBreach=" + r2);     // Catch: Throwable -> L26
        monitor-exit(this);
        return r2;
    L13:
        if (r1.c() == null) goto L23;
        if (r5.getPackageName().equals(r1.a()) == false) goto L23;
        int r3 = r1.e();     // Catch: Throwable -> L26
        if (r3 != (-1)) goto L20;
        r0 = 1;
    L20:
        r1.a(r0);     // Catch: Throwable -> L26
        r1.a(r5);     // Catch: Throwable -> L26
        r5.setFirstBreach(r0);     // Catch: Throwable -> L26
        com.obric.cae.log.a.c("StarLocation-db", "advanceGeofenceFirstBreachForNotification, id=" + r5.getGeofenceId() + ", from=" + r3 + ", to=" + r0 + ", isFirstBreach=" + r0);     // Catch: Throwable -> L26
        monitor-exit(this);
        return r0;
    }

    public final boolean a(String r7, ContentValues r8) {
        com.obric.cae.log.a.c("StarLocation-db", "DB insert, table=" + r7 + ", values=" + r8);
        long r2 = this.f.getWritableDatabase().insert(r7, null, r8);
        if (r2 != (-1)) goto L5;
        com.obric.cae.log.a.c("StarLocation-db", "insert failed for " + r7 + " values: " + r8);
    L5:
        com.obric.cae.log.a.c("StarLocation-db", "inserted uri at: " + r2);
        if (r2 == (-1)) goto L8;
        return true;
    L8:
        return false;
    }

    public synchronized b b() {
        monitor-enter(this);
        Cursor r0 = this.f.getReadableDatabase().query("city_info", new String[]{"adminArea", "subAdminArea", "locality", "subLocality", "updatedAt"}, null, null, null, null, "_id DESC", "1");     // Catch: Throwable -> L22
        if (r0 != null) goto L25;
    L17:
        if (r0 == null) goto L20;
        r0.close();     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return null;
    L25:
    L11:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L14
    L16:
        throw th;     // Catch: Throwable -> L22
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L22
        goto L16
    L6:
        if (r0.moveToFirst() == false) goto L17;
        b r1 = new b(r0.getString(0), r0.getString(1), r0.getString(2), r0.getString(3), r0.getLong(4));     // Catch: Throwable -> L11
        r0.close();     // Catch: Throwable -> L22
        monitor-exit(this);
        return r1;
    L22:
        th = move-exception;
        throw th;
    }

    public synchronized Map<String, String> b(List<String> r14) {
        monitor-enter(this);
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        HashMap r0 = new HashMap();     // Catch: Throwable -> L36
        if (r15.isEmpty() == false) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        SQLiteDatabase r1 = this.f.getReadableDatabase();     // Catch: Throwable -> L36
        String[] r11 = {"poi_id", "new_type_code_l3"};     // Catch: Throwable -> L36
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L36
    L9:
        if (r16.hasNext() == false) goto L34;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r12) == true) goto L9;
        Cursor r2 = r1.query(TrafficRecognitionInfo.SOURCE_AOI_BOARD, r11, "poi_id=?", new String[]{r12}, null, null, null, "1");     // Catch: Exception -> L31 Throwable -> L36
        if (r2 == null) goto L28;
    L22:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: Exception -> L31 Throwable -> L36
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L31 Throwable -> L36
        goto L27
    L16:
        if (r2.moveToFirst() == false) goto L28;
        String r3 = r2.getString(r2.getColumnIndexOrThrow("new_type_code_l3"));     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r3) == true) goto L29;
        r0.put(r12, r3);     // Catch: Throwable -> L22
    L29:
        r2.close();     // Catch: Exception -> L31 Throwable -> L36
    L28:
        if (r2 == null) goto L9;
    L31:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-db", "failed, poiId=" + r12, e);     // Catch: Throwable -> L36
        goto L9
    L34:
        monitor-exit(this);
        return r0;
    L36:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.obric.cae.location.database.c] */
    public synchronized void b(StarGeofence r7, int r8) {
        monitor-enter(this);
        d();     // Catch: Throwable -> L32
        if (r7 != null) goto L6;
    L19:
        ?? r1 = 0;
    L21:
        if (r1 == 0) goto L25;
        if (r1 == 1) goto L25;
        ?? r3 = -1;
    L26:
        if (r3 == 0) goto L28;
        boolean r4 = true;
    L29:
        r7.setFirstBreach(r4);     // Catch: Throwable -> L32
        ContentValues r5 = new ContentValues();     // Catch: Throwable -> L32
        r5.put("userId", Integer.valueOf(r8));     // Catch: Throwable -> L32
        r5.put("latitude", Double.valueOf(r7.getLatitude()));     // Catch: Throwable -> L32
        r5.put("Longitude", Double.valueOf(r7.getLongitude()));     // Catch: Throwable -> L32
        r5.put("radius", Integer.valueOf(r7.getRadius()));     // Catch: Throwable -> L32
        r5.put(MemoryKeyInfoEntity.KEY_ADDRESS, r7.getAddress());     // Catch: Throwable -> L32
        r5.put("eventTimestamp", Long.valueOf(r7.getEventTimestamp()));     // Catch: Throwable -> L32
        r5.put("transitionType", Integer.valueOf(r7.getTransitionType().ordinal()));     // Catch: Throwable -> L32
        r5.put("confidence", Integer.valueOf(r7.getConfidence().ordinal()));     // Catch: Throwable -> L32
        r5.put("state", Integer.valueOf(r7.getGeoState().ordinal()));     // Catch: Throwable -> L32
        r5.put("type", Integer.valueOf(r7.getGeoType().ordinal()));     // Catch: Throwable -> L32
        r5.put("firstBreach", Integer.valueOf(r1));     // Catch: Throwable -> L32
        r5.put("poi_id", r7.getPoiId());     // Catch: Throwable -> L32
        String[] r6 = {r7.getGeofenceId(), r7.getPackageName()};     // Catch: Throwable -> L32
        com.obric.cae.log.a.c("StarLocation-db", "updateGeofence, DB update id=" + r7.getGeofenceId() + ", pkg=" + r7.getPackageName());     // Catch: Throwable -> L32
        com.obric.cae.log.a.c("StarLocation-db", "DB update, table=location_geofence, whereClause=id = ? AND packageName = ?");     // Catch: Throwable -> L32
        this.f.getWritableDatabase().update("location_geofence", r5, "id = ? AND packageName = ?", r6);     // Catch: Throwable -> L32
        h(r7.getGeofenceId());     // Catch: Throwable -> L32
        a(r7, r8, r1);     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L28:
        r4 = false;
    L25:
        r3 = r1;
        goto L26
    L6:
        if (r7.getPackageName() == null) goto L19;
        if (r7.getGeofenceId() == null) goto L19;
        e r2 = (e) ZeusTransformUtils.preCheckCast(this.h.get(r7.getGeofenceId()), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r2 != null) goto L13;
    L18:
        r1 = r7.isFirstBreach();     // Catch: Throwable -> L32
        goto L21
    L13:
        if (r2.c() == null) goto L18;
        if (r7.getPackageName().equals(r2.a()) == false) goto L18;
        r1 = r2.e();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public final void b(File r2) {
        SQLiteDatabase r3 = SQLiteDatabase.openOrCreateDatabase(r2, null);
        r3.beginTransaction();     // Catch: Throwable -> L11
        a(r3);     // Catch: Throwable -> L8
        this.f.getClass();     // Catch: Throwable -> L8
        f.e(r3);     // Catch: Throwable -> L8
        r3.execSQL("DROP TABLE IF EXISTS location_geofence");     // Catch: Throwable -> L8
        r3.execSQL("DROP TABLE IF EXISTS geofence_callback");     // Catch: Throwable -> L8
        r3.setTransactionSuccessful();     // Catch: Throwable -> L8
        r3.endTransaction();     // Catch: Throwable -> L11
        r3.close();
        return;
    L8:
        th = move-exception;
        r3.endTransaction();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r3.close();
        throw th;
    }

    public synchronized void b(String r4) {
        monitor-enter(this);
        d();     // Catch: Throwable -> L6
        a("geofence_callback", "packageName = ?", new String[]{r4});     // Catch: Throwable -> L6
        this.j.remove(r4);     // Catch: Throwable -> L6
        com.obric.cae.log.a.c("StarLocation-db", "deleteGeofenceCallback, cache removed pkg=" + r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void b(String r3, String r4) {
        monitor-enter(this);
        com.obric.cae.log.a.c("StarLocation-db", "deleteGeofence, pkgName: " + r3 + ", geofenceId: " + r4);     // Catch: Throwable -> L6
        d();     // Catch: Throwable -> L6
        h(r4);     // Catch: Throwable -> L6
        com.obric.cae.log.a.c("StarLocation-db", "deleteGeofence, DB delete whereClause=packageName = ? AND id = ?");     // Catch: Throwable -> L6
        a("location_geofence", "packageName = ? AND id = ?", new String[]{r3, r4});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ComponentName c(String r5) {
        monitor-enter(this);
        if (r5 != null) goto L21;
        monitor-exit(this);
        return null;
    L21:
        d();     // Catch: Throwable -> L18
        d r1 = (d) ZeusTransformUtils.preCheckCast(this.j.get(r5), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r1 != null) goto L10;
    L15:
        com.obric.cae.log.a.c("StarLocation-db", "getGeofenceCallback, cache miss pkg=".concat(r5));     // Catch: Throwable -> L18
        monitor-exit(this);
        return null;
    L10:
        if (r1.a() == null) goto L15;
        com.obric.cae.log.a.c("StarLocation-db", com.obric.cae.location.city.f.a("getGeofenceCallback, cache hit pkg=", r5, ", class=").append(r1.a()).toString());     // Catch: Throwable -> L18
        ComponentName r0 = new ComponentName(r5, r1.a());     // Catch: Throwable -> L18
        monitor-exit(this);
        return r0;
    L18:
        th = move-exception;
        throw th;
    }

    public synchronized boolean c() {
        monitor-enter(this);
        File r0 = this.f.f7086b.getDatabasePath(f.a(this.g)).getParentFile();     // Catch: Throwable -> L10
        if (r0 == null) goto L9;
        File r1 = new File(r0, "star");     // Catch: Throwable -> L10
        boolean r2 = a(r1);     // Catch: Throwable -> L10
        com.obric.cae.log.a.e("StarLocation-db", "deleteCityArchiveRootDir path=" + r1.getAbsolutePath() + ", deleted=" + r2);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r2;
    L9:
        throw new IllegalStateException("location db parent is null");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized StarGeofence d(String r5) {
        monitor-enter(this);
        d();     // Catch: Throwable -> L13
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.h.get(r5), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        StringBuilder r2 = new StringBuilder("queryGeofenceById, cache ");     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
        String r3 = "miss";
    L7:
        com.obric.cae.log.a.c("StarLocation-db", r2.append(r3).append(", id=").append(r5).toString());     // Catch: Throwable -> L13
        if (r0 != null) goto L10;
        StarGeofence r6 = null;
    L11:
        monitor-exit(this);
        return r6;
    L10:
        r6 = r0.c();     // Catch: Throwable -> L13
        goto L11
    L6:
        r3 = "hit";
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void d() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.k == true) goto L6;
        com.obric.cae.log.a.c("StarLocation-db", "ensureCacheLoaded, cache not loaded, loading from DB");     // Catch: Throwable -> L8
        e();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public synchronized int e(String r3) {
        monitor-enter(this);
        d();     // Catch: Throwable -> L9
        e r4 = (e) ZeusTransformUtils.preCheckCast(this.h.get(r3), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r4 != null) goto L6;
        int r5 = 0;
    L7:
        monitor-exit(this);
        return r5;
    L6:
        r5 = r4.d();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void e() {
        monitor-enter(this);
        com.obric.cae.log.a.c("StarLocation-db", "loadCacheFromDb start");     // Catch: Throwable -> L59
        this.h.clear();     // Catch: Throwable -> L59
        this.i.clear();     // Catch: Throwable -> L59
        this.j.clear();     // Catch: Throwable -> L59
        Cursor r0 = a("location_geofence", new String[]{"userId", ObricMemoryConstants.KEY_PACKAGE_NAME, OaidModel.KEY_ID, "latitude", "Longitude", "radius", MemoryKeyInfoEntity.KEY_ADDRESS, "eventTimestamp", "transitionType", "confidence", "state", "type", "firstBreach", "poi_id"}, null, null);     // Catch: Throwable -> L59
        Iterator r1 = a(r0).iterator();     // Catch: Throwable -> L52
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r1.hasNext() == false) goto L16;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r1.next(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
        if (r5 == null) goto L6;
        if (r5.c() == null) goto L6;
        if (r5.b() == null) goto L6;
        a(r5.c(), r5.d(), r5.e());     // Catch: Throwable -> L52
        r4 = r4 + 1;
        goto L6
    L16:
        if (r0 == null) goto L18;
        r0.close();     // Catch: Throwable -> L59
    L18:
        Cursor r2 = a("geofence_callback", new String[]{ObricMemoryConstants.KEY_PACKAGE_NAME, "class"}, null, null);     // Catch: Throwable -> L59
        if (r2 != null) goto L62;
    L47:
        if (r2 == null) goto L49;
        r2.close();     // Catch: Throwable -> L59
    L49:
        this.k = true;     // Catch: Throwable -> L59
        com.obric.cae.log.a.c("StarLocation-db", "loadCacheFromDb done, geofenceCount=" + r4 + ", callbackCount=" + r3);     // Catch: Throwable -> L59
        monitor-exit(this);
        return;
    L62:
    L41:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L44
    L46:
        throw th;     // Catch: Throwable -> L59
    L44:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L59
        goto L46
    L21:
        if (r2.moveToFirst() == false) goto L47;
    L22:
        int r6 = r2.getColumnIndex(ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L41
        int r7 = r2.getColumnIndex("class");     // Catch: Throwable -> L41
        boolean r8 = e;     // Catch: Throwable -> L41
        if (r8 == true) goto L28;
        if (r6 != (-1)) goto L28;
        throw new AssertionError();     // Catch: Throwable -> L41
    L28:
        if (r8 == true) goto L33;
        if (r7 != (-1)) goto L33;
        throw new AssertionError();     // Catch: Throwable -> L41
    L33:
        String r9 = r2.getString(r6);     // Catch: Throwable -> L41
        String r10 = r2.getString(r7);     // Catch: Throwable -> L41
        if (r9 == null) goto L39;
        if (r10 == null) goto L39;
        this.j.put(r9, new d(r9, r10));     // Catch: Throwable -> L41
        r3 = r3 + 1;     // Catch: Throwable -> L41
    L39:
        if (r2.moveToNext() == true) goto L22;
    L52:
        th = move-exception;
        if (r0 != null) goto L67;
    L58:
        throw th;     // Catch: Throwable -> L59
    L67:
        r0.close();     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    }

    public synchronized List<StarGeofence> f(String r6) {
        monitor-enter(this);
        d();     // Catch: Throwable -> L22
        List r0 = (List) ZeusTransformUtils.preCheckCast(this.i.get(r6), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r0 != null) goto L6;
    L19:
        com.obric.cae.log.a.c("StarLocation-db", "queryGeofencesByPkgName, cache empty pkg=" + r6);     // Catch: Throwable -> L22
        List<StarGeofence> r7 = Collections.emptyList();     // Catch: Throwable -> L22
        monitor-exit(this);
        return r7;
    L6:
        if (r0.isEmpty() == true) goto L19;
        ArrayList r1 = new ArrayList(r0.size());     // Catch: Throwable -> L22
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L22
    L10:
        if (r2.hasNext() == false) goto L16;
        e r3 = (e) ZeusTransformUtils.preCheckCast(r2.next(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r3 == null) goto L10;
        if (r3.c() == null) goto L10;
        r1.add(r3.c());     // Catch: Throwable -> L22
        goto L10
    L16:
        com.obric.cae.log.a.c("StarLocation-db", "queryGeofencesByPkgName, cache size=" + r1.size() + ", pkg=" + r6);     // Catch: Throwable -> L22
        monitor-exit(this);
        return r1;
    L22:
        th = move-exception;
        throw th;
    }

    public synchronized b g(String r13) {
        monitor-enter(this);
        if (r13 != null) goto L32;
        monitor-exit(this);
        return null;
    L32:
        Cursor r14 = this.f.getReadableDatabase().query("city_info", new String[]{"adminArea", "subAdminArea", "locality", "subLocality", "updatedAt"}, "subAdminArea = ?", new String[]{r13}, null, null, "_id DESC", "1");     // Catch: Throwable -> L25
        if (r14 != null) goto L30;
    L21:
        if (r14 == null) goto L23;
        r14.close();     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return null;
    L30:
    L15:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L25
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25
        goto L20
    L10:
        if (r14.moveToFirst() == false) goto L21;
        b r0 = new b(r14.getString(0), r14.getString(1), r14.getString(2), r14.getString(3), r14.getLong(4));     // Catch: Throwable -> L15
        r14.close();     // Catch: Throwable -> L25
        monitor-exit(this);
        return r0;
    L25:
        th = move-exception;
        throw th;
    }

    public final void h(String r8) {
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.h.remove(r8), e.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        StringBuilder r7 = new StringBuilder("cache remove geofence miss, id=");
    L5:
        com.obric.cae.log.a.c("StarLocation-db", r7.append(r8).toString());
        return;
    L7:
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.i.get(r0.a()), List.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
        r7 = com.obric.cae.location.city.f.a("cache remove geofence no pkg list, id=", r8, ", pkg=");
        r8 = r0.a();
        goto L5
    L10:
        int r4 = r3.size() - 1;
    L11:
        if (r4 < 0) goto L19;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r3.get(r4), e.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L17;
        if (r8.equals(r5.b()) == false) goto L17;
        r3.remove(r4);
    L17:
        r4 = r4 - 1;
        goto L11
    L19:
        if (r3.isEmpty() == false) goto L21;
        this.i.remove(r0.a());
    L21:
        r7 = new StringBuilder("cache removed geofence, pkg=").append(r0.a()).append(", id=");
        goto L5
    }

    public final File i(String r9) {
        File r0 = this.f.f7086b.getDatabasePath(f.a(this.g)).getParentFile();
        if (r0 == null) goto L48;
        File r1 = new File(r0, "star");
        String r10 = a(r9);
        if (TextUtils.isEmpty(r10) == true) goto L46;
        StringBuilder r3 = new StringBuilder(r10.length());
        int r5 = 0;
    L8:
        if (r5 >= r10.length()) goto L35;
        char r6 = r10.charAt(r5);
        if (r6 != '/') goto L12;
    L31:
        boolean r7 = true;
    L32:
        if (r7 == false) goto L34;
        r6 = '_';
    L34:
        r3.append(r6);
        r5 = r5 + 1;
        goto L8
    L12:
        if (r6 == '\\') goto L31;
        if (r6 == ':') goto L31;
        if (r6 == '*') goto L31;
        if (r6 == '?') goto L31;
        if (r6 == '\"') goto L31;
        if (r6 == '<') goto L31;
        if (r6 == '>') goto L31;
        if (r6 == '|') goto L31;
        if (Character.isISOControl(r6) == true) goto L31;
        r7 = false;
        goto L32
    L35:
        String r11 = r3.toString();
        if (TextUtils.isEmpty(r11) == true) goto L44;
        if (".".equals(r11) == true) goto L44;
        if ("..".equals(r11) == true) goto L44;
        return new File(new File(r1, r11), f.a(this.g));
    L44:
        throw new IllegalArgumentException("invalid city directory name");
    L46:
        throw new IllegalArgumentException("city key is empty");
    L48:
        throw new IllegalStateException("location db parent is null");
    }
}
