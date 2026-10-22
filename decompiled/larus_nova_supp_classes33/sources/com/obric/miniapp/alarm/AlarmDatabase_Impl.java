package com.obric.miniapp.alarm;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class AlarmDatabase_Impl extends AlarmDatabase {
    public volatile c a;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ AlarmDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(AlarmDatabase_Impl r1) {
            this.a = r1;
            super(1);
        }

        public final void createAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `alarm` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `triggerTime` INTEGER NOT NULL, `intervalMinutes` INTEGER NOT NULL, `repeatCount` INTEGER NOT NULL, `currentRepeatCount` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `extraInfo` TEXT NOT NULL, `useSystemClock` INTEGER NOT NULL, `token` TEXT NOT NULL, PRIMARY KEY(`id`))");
            r2.execSQL("CREATE INDEX IF NOT EXISTS `index_alarm_triggerTime` ON `alarm` (`triggerTime`)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r2.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '793f298a4c4c52ec60e9dd01bc3c2462')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r4) {
            r4.execSQL("DROP TABLE IF EXISTS `alarm`");
            if (AlarmDatabase_Impl.d(this.a) == null) goto L7;
            int r0 = AlarmDatabase_Impl.e(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(AlarmDatabase_Impl.g(this.a), r1)).onDestructiveMigration(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r4) {
            if (AlarmDatabase_Impl.h(this.a) == null) goto L7;
            int r0 = AlarmDatabase_Impl.i(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(AlarmDatabase_Impl.j(this.a), r1)).onCreate(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r4) {
            AlarmDatabase_Impl.k(this.a, r4);
            this.a.internalInitInvalidationTracker(r4);
            if (AlarmDatabase_Impl.l(this.a) == null) goto L7;
            int r0 = AlarmDatabase_Impl.m(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(AlarmDatabase_Impl.f(this.a), r1)).onOpen(r4);
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

    @Override // com.obric.miniapp.alarm.AlarmDatabase
    public final b c() {
        if (this.a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.a != null) goto L10;
        this.a = new c(this);     // Catch: Throwable -> L13
    L10:
        c r0 = this.a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.a;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `alarm`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"alarm"});
    }

    public final Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public final Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r0 = new HashMap();
        r0.put(b.class, Collections.emptyList());
        return r0;
    }

    public AlarmDatabase_Impl() {
    }

    public static /* synthetic */ List d(AlarmDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List e(AlarmDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List f(AlarmDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List g(AlarmDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(AlarmDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(AlarmDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(AlarmDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List l(AlarmDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List m(AlarmDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new a(this), "793f298a4c4c52ec60e9dd01bc3c2462", "5f2da42d9137e55a8208829f1427a3ab");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public final List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r1) {
        return Arrays.asList(new Migration[0]);
    }

    public static /* synthetic */ void k(AlarmDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
