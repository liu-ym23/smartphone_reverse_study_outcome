package com.bytedance.android.livesdk.i18n.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import g22.b;
import g22.c;
import g22.e;
import g22.h;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class I18nDatabase_Impl extends I18nDatabase {
    public volatile h a;
    public volatile c b;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ I18nDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(I18nDatabase_Impl r1) {
            this.a = r1;
            super(1);
        }

        public final void createAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `translation` (`key` TEXT NOT NULL, `value` TEXT, PRIMARY KEY(`key`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `information` (`key` TEXT NOT NULL, `value` TEXT, PRIMARY KEY(`key`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r2.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'db08c04e8a10c6c1ddb9d9ab384c2f17')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r4) {
            r4.execSQL("DROP TABLE IF EXISTS `translation`");
            r4.execSQL("DROP TABLE IF EXISTS `information`");
            if (I18nDatabase_Impl.e(this.a) == null) goto L7;
            int r0 = I18nDatabase_Impl.f(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(I18nDatabase_Impl.h(this.a), r1)).onDestructiveMigration(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r4) {
            if (I18nDatabase_Impl.i(this.a) == null) goto L7;
            int r0 = I18nDatabase_Impl.j(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(I18nDatabase_Impl.k(this.a), r1)).onCreate(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r4) {
            I18nDatabase_Impl.l(this.a, r4);
            this.a.internalInitInvalidationTracker(r4);
            if (I18nDatabase_Impl.m(this.a) == null) goto L7;
            int r0 = I18nDatabase_Impl.n(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(I18nDatabase_Impl.g(this.a), r1)).onOpen(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onPreMigrate(SupportSQLiteDatabase r1) {
            DBUtil.dropFtsSyncTriggers(r1);
        }

        public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase r23) {
            HashMap r1 = new HashMap(2);
            r1.put("key", new TableInfo.Column("key", "TEXT", true, 1, null, 1));
            r1.put("value", new TableInfo.Column("value", "TEXT", false, 0, null, 1));
            TableInfo r8 = new TableInfo("translation", r1, new HashSet(0), new HashSet(0));
            TableInfo r2 = TableInfo.read(r23, "translation");
            if (r8.equals(r2) == false) goto L5;
            HashMap r3 = new HashMap(2);
            r3.put("key", new TableInfo.Column("key", "TEXT", true, 1, null, 1));
            r3.put("value", new TableInfo.Column("value", "TEXT", false, 0, null, 1));
            TableInfo r4 = new TableInfo("information", r3, new HashSet(0), new HashSet(0));
            TableInfo r0 = TableInfo.read(r23, "information");
            if (r4.equals(r0) == true) goto L11;
            return new RoomOpenHelper.ValidationResult(false, "information(com.bytedance.android.livesdk.i18n.db.I18nInformation).\n Expected:\n" + r4 + "\n Found:\n" + r0);
        L11:
            return new RoomOpenHelper.ValidationResult(true, null);
        L5:
            return new RoomOpenHelper.ValidationResult(false, "translation(com.bytedance.android.livesdk.i18n.db.I18nTranslation).\n Expected:\n" + r8 + "\n Found:\n" + r2);
        }
    }

    @Override // com.bytedance.android.livesdk.i18n.db.I18nDatabase
    public final b c() {
        if (this.b != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.b != null) goto L10;
        this.b = new c(this);     // Catch: Throwable -> L13
    L10:
        c r0 = this.b;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.b;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `translation`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `information`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"translation", "information"});
    }

    @Override // com.bytedance.android.livesdk.i18n.db.I18nDatabase
    public final e d() {
        if (this.a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.a != null) goto L10;
        this.a = new h(this);     // Catch: Throwable -> L13
    L10:
        h r0 = this.a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.a;
    }

    public final Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public final Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r0 = new HashMap();
        r0.put(e.class, Collections.emptyList());
        r0.put(b.class, Collections.emptyList());
        return r0;
    }

    public I18nDatabase_Impl() {
    }

    public static /* synthetic */ List e(I18nDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List f(I18nDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List g(I18nDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(I18nDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(I18nDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(I18nDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List k(I18nDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List m(I18nDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List n(I18nDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new a(this), "db08c04e8a10c6c1ddb9d9ab384c2f17", "e3af7f9b450df7204a5f65d0fd2a1eaa");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public final List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r1) {
        return Arrays.asList(new Migration[0]);
    }

    public static /* synthetic */ void l(I18nDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
