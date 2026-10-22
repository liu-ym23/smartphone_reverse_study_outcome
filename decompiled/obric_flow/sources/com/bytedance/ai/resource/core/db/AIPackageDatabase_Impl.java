package com.bytedance.ai.resource.core.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class AIPackageDatabase_Impl extends AIPackageDatabase {
    private volatile AIPackageDao _aIPackageDao;

    public AIPackageDatabase_Impl() {
    }

    public static /* synthetic */ List access$000(AIPackageDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List access$100(AIPackageDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List access$1000(AIPackageDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List access$200(AIPackageDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List access$300(AIPackageDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List access$400(AIPackageDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List access$500(AIPackageDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ SupportSQLiteDatabase access$602(AIPackageDatabase_Impl r5, SupportSQLiteDatabase r10) {
        r5.mDatabase = r10;
        return r10;
    }

    public static /* synthetic */ void access$700(AIPackageDatabase_Impl r5, SupportSQLiteDatabase r10) {
        r5.internalInitInvalidationTracker(r10);
    }

    public static /* synthetic */ List access$800(AIPackageDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    public static /* synthetic */ List access$900(AIPackageDatabase_Impl r5) {
        return r5.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r5 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r5.execSQL("DELETE FROM `ai_widget_info`");     // Catch: Throwable -> L8
        r5.execSQL("DELETE FROM `ai_applet_info`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r5.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r5.inTransaction() == true) goto L15;
        r5.execSQL("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r5.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r5.inTransaction() == true) goto L12;
        r5.execSQL("VACUUM");
    L12:
        throw th;
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"ai_widget_info", "ai_applet_info"});
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        final int r10 = 8;
        RoomOpenHelper r11 = new RoomOpenHelper(r5, new AnonymousClass1(this, r10), "5ce1a3198980e80d921a20948f2bbc22", "b254797dc612f83da1dd61d7725d43f2");
        SupportSQLiteOpenHelper.Configuration r12 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r11).build();
        return r5.sqliteOpenHelperFactory.create(r12);
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r5) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r5 = new HashMap();
        r5.put(AIPackageDao.class, AIPackageDao_Impl.getRequiredConverters());
        return r5;
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDatabase
    public AIPackageDao userDao() {
        if (this._aIPackageDao != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this._aIPackageDao != null) goto L12;
        this._aIPackageDao = new AIPackageDao_Impl(this);     // Catch: Throwable -> L10
    L12:
        AIPackageDao r5 = this._aIPackageDao;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r5;
    L5:
        return this._aIPackageDao;
    }
}
