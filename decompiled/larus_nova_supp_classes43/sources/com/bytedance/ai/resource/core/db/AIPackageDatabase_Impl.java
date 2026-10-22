package com.bytedance.ai.resource.core.db;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIPackageDatabase_Impl extends AIPackageDatabase {
    public volatile j r;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ AIPackageDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(AIPackageDatabase_Impl r1) {
            this.a = r1;
            super(16);
        }

        public final void createAllTables(SupportSQLiteDatabase r10) {
            r10.execSQL("CREATE TABLE IF NOT EXISTS `ai_widget_info` (`widget_id` TEXT NOT NULL, `entry` TEXT NOT NULL, `input` TEXT NOT NULL, `output` TEXT NOT NULL, `border` INTEGER NOT NULL, `box_type` INTEGER NOT NULL, `title_type` INTEGER DEFAULT -1, `name` TEXT NOT NULL, `package_name` TEXT NOT NULL, `version_code` INTEGER NOT NULL, `scm_version` TEXT, `version_name` TEXT NOT NULL, `description` TEXT NOT NULL, `icons` TEXT, `manifest_version` TEXT NOT NULL, `prop` TEXT NOT NULL, `recommend` TEXT NOT NULL, `keywords` TEXT, `app_group` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `digest` TEXT NOT NULL, `render_type` TEXT NOT NULL, `size` INTEGER NOT NULL, `ft` INTEGER NOT NULL, `it` INTEGER NOT NULL, `ut` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `create_time` INTEGER NOT NULL, `status` TEXT NOT NULL, `ready_for_deleting` INTEGER DEFAULT 0, `runtime_version` TEXT NOT NULL DEFAULT '', `has_key_store` INTEGER NOT NULL DEFAULT 0, `sign_verify_switch` INTEGER NOT NULL DEFAULT 0, `app_type` INTEGER NOT NULL DEFAULT 1, `source_type` INTEGER NOT NULL DEFAULT 2)");
            r10.execSQL("CREATE TABLE IF NOT EXISTS `ai_applet_info` (`applet_id` TEXT NOT NULL, `pages` TEXT, `plugins` TEXT, `bot_id` TEXT NOT NULL, `applet_entry` TEXT NOT NULL, `runtime_entry` TEXT DEFAULT '', `botDevMode` TEXT NOT NULL, `main_init` TEXT, `services` TEXT, `permissions` TEXT DEFAULT '', `dark_mode` INTEGER NOT NULL DEFAULT 1, `chat` TEXT DEFAULT NULL, `tool_runtime_entry` TEXT DEFAULT '', `settings` TEXT DEFAULT '', `name` TEXT NOT NULL, `package_name` TEXT NOT NULL, `version_code` INTEGER NOT NULL, `scm_version` TEXT, `version_name` TEXT NOT NULL, `description` TEXT NOT NULL, `icons` TEXT, `manifest_version` TEXT NOT NULL, `prop` TEXT NOT NULL, `recommend` TEXT NOT NULL, `keywords` TEXT, `app_group` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `digest` TEXT NOT NULL, `render_type` TEXT NOT NULL, `size` INTEGER NOT NULL, `ft` INTEGER NOT NULL, `it` INTEGER NOT NULL, `ut` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `create_time` INTEGER NOT NULL, `status` TEXT NOT NULL, `ready_for_deleting` INTEGER DEFAULT 0, `runtime_version` TEXT NOT NULL DEFAULT '', `has_key_store` INTEGER NOT NULL DEFAULT 0, `sign_verify_switch` INTEGER NOT NULL DEFAULT 0, `app_type` INTEGER NOT NULL DEFAULT 1, `source_type` INTEGER NOT NULL DEFAULT 2)");
            r10.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r10.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '93ca109155ea257eb3e9ee5753478d24')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r10) {
            r10.execSQL("DROP TABLE IF EXISTS `ai_widget_info`");
            r10.execSQL("DROP TABLE IF EXISTS `ai_applet_info`");
            if (AIPackageDatabase_Impl.d(this.a) == null) goto L7;
            int r0 = AIPackageDatabase_Impl.e(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(AIPackageDatabase_Impl.g(this.a), r1)).onDestructiveMigration(r10);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r10) {
            if (AIPackageDatabase_Impl.h(this.a) == null) goto L7;
            int r0 = AIPackageDatabase_Impl.i(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(AIPackageDatabase_Impl.j(this.a), r1)).onCreate(r10);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r10) {
            AIPackageDatabase_Impl.k(this.a, r10);
            this.a.internalInitInvalidationTracker(r10);
            if (AIPackageDatabase_Impl.l(this.a) == null) goto L7;
            int r0 = AIPackageDatabase_Impl.m(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(AIPackageDatabase_Impl.f(this.a), r1)).onOpen(r10);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onPreMigrate(SupportSQLiteDatabase r1) {
            DBUtil.dropFtsSyncTriggers(r1);
        }

        public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase r10) {
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDatabase
    public final AIPackageDao c() {
        if (this.r != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.r != null) goto L10;
        this.r = new j(this);     // Catch: Throwable -> L13
    L10:
        j r0 = this.r;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.r;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r10 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r10.execSQL("DELETE FROM `ai_widget_info`");     // Catch: Throwable -> L8
        r10.execSQL("DELETE FROM `ai_applet_info`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r10.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r10.inTransaction() == true) goto L15;
        r10.execSQL("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r10.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r10.inTransaction() == true) goto L12;
        r10.execSQL("VACUUM");
    L12:
        throw th;
    }

    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"ai_widget_info", "ai_applet_info"});
    }

    public final Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public final Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r0 = new HashMap();
        r0.put(AIPackageDao.class, Collections.emptyList());
        return r0;
    }

    public AIPackageDatabase_Impl() {
    }

    public static /* synthetic */ List d(AIPackageDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List e(AIPackageDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List f(AIPackageDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List g(AIPackageDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(AIPackageDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(AIPackageDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(AIPackageDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List l(AIPackageDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List m(AIPackageDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r10) {
        RoomOpenHelper r0 = new RoomOpenHelper(r10, new a(this), "93ca109155ea257eb3e9ee5753478d24", "ba6f6e7968f0a170ef8a1ef26a92b39a");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r10.context).name(r10.name).callback(r0).build();
        return r10.sqliteOpenHelperFactory.create(r1);
    }

    public final List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r1) {
        return Arrays.asList(new Migration[0]);
    }

    public static /* synthetic */ void k(AIPackageDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
