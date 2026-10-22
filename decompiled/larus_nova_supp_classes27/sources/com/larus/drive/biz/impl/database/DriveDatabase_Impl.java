package com.larus.drive.biz.impl.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l79.c;
import l79.g;
import l79.h;
import l79.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveDatabase_Impl extends DriveDatabase {
    public volatile l c;
    public volatile g d;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ DriveDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(DriveDatabase_Impl r1) {
            this.a = r1;
            super(1);
        }

        public final void createAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `drive_list_recent` (`file_token` TEXT NOT NULL, `drive_token` TEXT NOT NULL, `order_index` INTEGER NOT NULL, `file_name` TEXT NOT NULL, `file_url` TEXT NOT NULL, `open_time` INTEGER NOT NULL, `edit_time` INTEGER NOT NULL, `icon_info` TEXT NOT NULL, `file_type` TEXT NOT NULL, `is_owner` INTEGER NOT NULL, `drive_obj_type` INTEGER NOT NULL, `extra` TEXT, PRIMARY KEY(`file_token`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `drive_list_mine` (`file_token` TEXT NOT NULL, `drive_token` TEXT NOT NULL, `order_index` INTEGER NOT NULL, `file_name` TEXT NOT NULL, `file_url` TEXT NOT NULL, `open_time` INTEGER NOT NULL, `edit_time` INTEGER NOT NULL, `icon_info` TEXT NOT NULL, `file_type` TEXT NOT NULL, `is_owner` INTEGER NOT NULL, `drive_obj_type` INTEGER NOT NULL, `extra` TEXT, PRIMARY KEY(`file_token`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r2.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e226af5deca5ae564b232857dcb9aa4c')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r4) {
            r4.execSQL("DROP TABLE IF EXISTS `drive_list_recent`");
            r4.execSQL("DROP TABLE IF EXISTS `drive_list_mine`");
            if (DriveDatabase_Impl.e(this.a) == null) goto L7;
            int r0 = DriveDatabase_Impl.f(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(DriveDatabase_Impl.h(this.a), r1)).onDestructiveMigration(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r4) {
            if (DriveDatabase_Impl.i(this.a) == null) goto L7;
            int r0 = DriveDatabase_Impl.j(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(DriveDatabase_Impl.k(this.a), r1)).onCreate(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r4) {
            DriveDatabase_Impl.l(this.a, r4);
            this.a.internalInitInvalidationTracker(r4);
            if (DriveDatabase_Impl.m(this.a) == null) goto L7;
            int r0 = DriveDatabase_Impl.n(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(DriveDatabase_Impl.g(this.a), r1)).onOpen(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onPreMigrate(SupportSQLiteDatabase r1) {
            DBUtil.dropFtsSyncTriggers(r1);
        }

        public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase r3) {
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // com.larus.drive.biz.impl.database.DriveDatabase
    public final c c() {
        if (this.d != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.d != null) goto L10;
        this.d = new g(this);     // Catch: Throwable -> L13
    L10:
        g r0 = this.d;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.d;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `drive_list_recent`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `drive_list_mine`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r2.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r2.inTransaction() == true) goto L15;
        r2.execSQL("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r2.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r2.inTransaction() == true) goto L12;
        r2.execSQL("VACUUM");
    L12:
        throw th;
    }

    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"drive_list_recent", "drive_list_mine"});
    }

    @Override // com.larus.drive.biz.impl.database.DriveDatabase
    public final h d() {
        if (this.c != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.c != null) goto L10;
        this.c = new l(this);     // Catch: Throwable -> L13
    L10:
        l r0 = this.c;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.c;
    }

    public final Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public final Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r0 = new HashMap();
        r0.put(h.class, Collections.emptyList());
        r0.put(c.class, Collections.emptyList());
        return r0;
    }

    public DriveDatabase_Impl() {
    }

    public static /* synthetic */ List e(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List f(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List g(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List k(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List m(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List n(DriveDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new a(this), "e226af5deca5ae564b232857dcb9aa4c", "c4e1b22d0bd18c2276c8efd02205dfdf");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public final List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r1) {
        return Arrays.asList(new Migration[0]);
    }

    public static /* synthetic */ void l(DriveDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
