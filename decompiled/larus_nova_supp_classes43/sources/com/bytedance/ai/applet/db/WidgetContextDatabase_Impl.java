package com.bytedance.ai.applet.db;

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
public final class WidgetContextDatabase_Impl extends WidgetContextDatabase {
    public volatile b c;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ WidgetContextDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(WidgetContextDatabase_Impl r1) {
            this.a = r1;
            super(1);
        }

        public final void createAllTables(SupportSQLiteDatabase r10) {
            r10.execSQL("CREATE TABLE IF NOT EXISTS `widget_context_info` (`card_id` TEXT NOT NULL, `message_id` TEXT NOT NULL, `conversation_id` TEXT NOT NULL, `bot_id` TEXT NOT NULL, PRIMARY KEY(`card_id`))");
            r10.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r10.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a6db594aa94dc67769d8ca0436b0b18b')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r10) {
            r10.execSQL("DROP TABLE IF EXISTS `widget_context_info`");
            if (WidgetContextDatabase_Impl.d(this.a) == null) goto L7;
            int r0 = WidgetContextDatabase_Impl.e(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(WidgetContextDatabase_Impl.g(this.a), r1)).onDestructiveMigration(r10);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r10) {
            if (WidgetContextDatabase_Impl.h(this.a) == null) goto L7;
            int r0 = WidgetContextDatabase_Impl.i(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(WidgetContextDatabase_Impl.j(this.a), r1)).onCreate(r10);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r10) {
            WidgetContextDatabase_Impl.k(this.a, r10);
            this.a.internalInitInvalidationTracker(r10);
            if (WidgetContextDatabase_Impl.l(this.a) == null) goto L7;
            int r0 = WidgetContextDatabase_Impl.m(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(WidgetContextDatabase_Impl.f(this.a), r1)).onOpen(r10);
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

    @Override // com.bytedance.ai.applet.db.WidgetContextDatabase
    public final com.bytedance.ai.applet.db.a c() {
        if (this.c != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.c != null) goto L10;
        this.c = new b(this);     // Catch: Throwable -> L13
    L10:
        b r0 = this.c;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.c;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r10 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r10.execSQL("DELETE FROM `widget_context_info`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"widget_context_info"});
    }

    public final Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public final Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r0 = new HashMap();
        r0.put(com.bytedance.ai.applet.db.a.class, Collections.emptyList());
        return r0;
    }

    public WidgetContextDatabase_Impl() {
    }

    public static /* synthetic */ List d(WidgetContextDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List e(WidgetContextDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List f(WidgetContextDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List g(WidgetContextDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(WidgetContextDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(WidgetContextDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(WidgetContextDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List l(WidgetContextDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List m(WidgetContextDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r10) {
        RoomOpenHelper r0 = new RoomOpenHelper(r10, new a(this), "a6db594aa94dc67769d8ca0436b0b18b", "b1cb5d918ad0fda61c507b74c13d1d2d");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r10.context).name(r10.name).callback(r0).build();
        return r10.sqliteOpenHelperFactory.create(r1);
    }

    public final List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r1) {
        return Arrays.asList(new Migration[0]);
    }

    public static /* synthetic */ void k(WidgetContextDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
