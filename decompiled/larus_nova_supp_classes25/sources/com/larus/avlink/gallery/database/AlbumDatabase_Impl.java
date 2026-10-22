package com.larus.avlink.gallery.database;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AlbumDatabase_Impl extends AlbumDatabase {
    public volatile d d;
    public volatile k e;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ AlbumDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(AlbumDatabase_Impl r1) {
            this.a = r1;
            super(2);
        }

        public final void createAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `thumbnail_metadata_table` (`id` TEXT NOT NULL, `file_path` TEXT NOT NULL, `file_name` TEXT NOT NULL, `file_size` INTEGER NOT NULL, `sn` TEXT NOT NULL, `image_uuid` INTEGER NOT NULL, `media_type` TEXT NOT NULL, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `create_time` INTEGER NOT NULL, `modify_time` INTEGER NOT NULL, `download_time` INTEGER NOT NULL, `geo_location_info` TEXT, `source_type` TEXT NOT NULL, `processing_status` INTEGER NOT NULL, `is_synced` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            r2.execSQL("CREATE INDEX IF NOT EXISTS `index_thumbnail_metadata_table_create_time` ON `thumbnail_metadata_table` (`create_time`)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `media_metadata_table` (`id` TEXT NOT NULL, `media_id` INTEGER NOT NULL, `system_gallery_id` INTEGER, `file_name` TEXT, `file_size` INTEGER, `media_type` TEXT, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `out_video_width` INTEGER NOT NULL, `out_video_height` INTEGER NOT NULL, `output_video_crop` REAL NOT NULL, `create_time` INTEGER NOT NULL, `geo_location_info` TEXT, `algorithm_type` TEXT, `lifecycle_state` INTEGER NOT NULL, `failure_stage` INTEGER, `failure_reason` TEXT, `download_file_path` TEXT, `temp_file_path` TEXT, `unpack_dir_path` TEXT, `processed_file_path` TEXT, `final_file_path` TEXT, `active_mask` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            r2.execSQL("CREATE INDEX IF NOT EXISTS `index_media_metadata_table_create_time` ON `media_metadata_table` (`create_time`)");
            r2.execSQL("CREATE INDEX IF NOT EXISTS `index_media_metadata_table_lifecycle_state` ON `media_metadata_table` (`lifecycle_state`)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r2.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7203e853da544f9c611788bc9f6883b6')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r4) {
            r4.execSQL("DROP TABLE IF EXISTS `thumbnail_metadata_table`");
            r4.execSQL("DROP TABLE IF EXISTS `media_metadata_table`");
            if (AlbumDatabase_Impl.e(this.a) == null) goto L7;
            int r0 = AlbumDatabase_Impl.f(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(AlbumDatabase_Impl.h(this.a), r1)).onDestructiveMigration(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r4) {
            if (AlbumDatabase_Impl.i(this.a) == null) goto L7;
            int r0 = AlbumDatabase_Impl.j(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(AlbumDatabase_Impl.k(this.a), r1)).onCreate(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r4) {
            AlbumDatabase_Impl.l(this.a, r4);
            this.a.internalInitInvalidationTracker(r4);
            if (AlbumDatabase_Impl.m(this.a) == null) goto L7;
            int r0 = AlbumDatabase_Impl.n(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(AlbumDatabase_Impl.g(this.a), r1)).onOpen(r4);
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

    @Override // com.larus.avlink.gallery.database.AlbumDatabase
    public final b c() {
        if (this.d != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.d != null) goto L10;
        this.d = new d(this);     // Catch: Throwable -> L13
    L10:
        d r0 = this.d;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.d;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `thumbnail_metadata_table`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `media_metadata_table`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"thumbnail_metadata_table", "media_metadata_table"});
    }

    @Override // com.larus.avlink.gallery.database.AlbumDatabase
    public final j d() {
        if (this.e != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.e != null) goto L10;
        this.e = new k(this);     // Catch: Throwable -> L13
    L10:
        k r0 = this.e;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.e;
    }

    public final Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public final Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r0 = new HashMap();
        r0.put(b.class, Collections.emptyList());
        r0.put(j.class, Collections.emptyList());
        return r0;
    }

    public AlbumDatabase_Impl() {
    }

    public static /* synthetic */ List e(AlbumDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List f(AlbumDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List g(AlbumDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(AlbumDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(AlbumDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(AlbumDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List k(AlbumDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List m(AlbumDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List n(AlbumDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new a(this), "7203e853da544f9c611788bc9f6883b6", "c42fc303363694907a94e38823d3d9f1");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public final List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r1) {
        return Arrays.asList(new Migration[0]);
    }

    public static /* synthetic */ void l(AlbumDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
