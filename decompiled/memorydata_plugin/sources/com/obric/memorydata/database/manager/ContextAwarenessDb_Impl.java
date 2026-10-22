package com.obric.memorydata.database.manager;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.obric.memorydata.database.dao.ContextAwarenessSubscriptionDao;
import com.obric.memorydata.database.dao.ContextAwarenessSubscriptionDao_Impl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class ContextAwarenessDb_Impl extends ContextAwarenessDb {
    private volatile ContextAwarenessSubscriptionDao _contextAwarenessSubscriptionDao;

    public ContextAwarenessDb_Impl() {
    }

    static /* synthetic */ List access$000(ContextAwarenessDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$100(ContextAwarenessDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$1000(ContextAwarenessDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$200(ContextAwarenessDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$300(ContextAwarenessDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$400(ContextAwarenessDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$500(ContextAwarenessDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ SupportSQLiteDatabase access$602(ContextAwarenessDb_Impl r2, SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r2.mDatabase = r4;
        return r4;
    }

    static /* synthetic */ void access$700(ContextAwarenessDb_Impl r2, SupportSQLiteDatabase r3) {
        r2.internalInitInvalidationTracker((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ List access$800(ContextAwarenessDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$900(ContextAwarenessDb_Impl r0) {
        return r0.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `context_awareness_subscription`");     // Catch: Throwable -> L8
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

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"context_awareness_subscription"});
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r4) {
        final int r2 = 2;
        RoomOpenHelper r0 = new RoomOpenHelper(r4, new AnonymousClass1(this, r2), "30c0f80403e794e73441aed8dfe5b8da", "5381503d20f3e87e52341971be4d85b8");
        SupportSQLiteOpenHelper.Configuration r3 = SupportSQLiteOpenHelper.Configuration.builder(r4.context).name(r4.name).callback(r0).build();
        return r4.sqliteOpenHelperFactory.create(r3);
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        return Arrays.asList(new Migration[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r2 = new HashMap();
        r2.put(ContextAwarenessSubscriptionDao.class, ContextAwarenessSubscriptionDao_Impl.getRequiredConverters());
        return r2;
    }

    @Override // com.obric.memorydata.database.manager.ContextAwarenessDb
    public ContextAwarenessSubscriptionDao subscriptionDao() {
        if (this._contextAwarenessSubscriptionDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._contextAwarenessSubscriptionDao != null) goto L10;
        this._contextAwarenessSubscriptionDao = new ContextAwarenessSubscriptionDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ContextAwarenessSubscriptionDao r0 = this._contextAwarenessSubscriptionDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._contextAwarenessSubscriptionDao;
    }
}
