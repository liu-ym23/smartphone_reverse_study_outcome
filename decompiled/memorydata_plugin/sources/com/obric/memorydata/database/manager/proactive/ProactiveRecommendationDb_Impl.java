package com.obric.memorydata.database.manager.proactive;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.obric.memorydata.database.dao.ProactiveAgentMemoryDao;
import com.obric.memorydata.database.dao.ProactiveAgentMemoryDao_Impl;
import com.obric.memorydata.database.dao.ProactiveEcaConditionDao;
import com.obric.memorydata.database.dao.ProactiveEcaConditionDao_Impl;
import com.obric.memorydata.database.dao.ProactiveInspirationDao;
import com.obric.memorydata.database.dao.ProactiveInspirationDao_Impl;
import com.obric.memorydata.database.dao.ProactiveMemoryRuleDao;
import com.obric.memorydata.database.dao.ProactiveMemoryRuleDao_Impl;
import com.obric.memorydata.database.dao.ProactivePhoneEventDao;
import com.obric.memorydata.database.dao.ProactivePhoneEventDao_Impl;
import com.obric.memorydata.database.dao.ProactiveRecommendationsDao;
import com.obric.memorydata.database.dao.ProactiveRecommendationsDao_Impl;
import com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao;
import com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao_Impl;
import com.obric.memorydata.database.dao.ProactiveUserSubscriptionsDao;
import com.obric.memorydata.database.dao.ProactiveUserSubscriptionsDao_Impl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveRecommendationDb_Impl extends ProactiveRecommendationDb {
    private volatile ProactiveAgentMemoryDao _proactiveAgentMemoryDao;
    private volatile ProactiveEcaConditionDao _proactiveEcaConditionDao;
    private volatile ProactiveInspirationDao _proactiveInspirationDao;
    private volatile ProactiveMemoryRuleDao _proactiveMemoryRuleDao;
    private volatile ProactivePhoneEventDao _proactivePhoneEventDao;
    private volatile ProactiveRecommendationsDao _proactiveRecommendationsDao;
    private volatile ProactiveSubscriptionTasksDao _proactiveSubscriptionTasksDao;
    private volatile ProactiveUserSubscriptionsDao _proactiveUserSubscriptionsDao;

    public ProactiveRecommendationDb_Impl() {
    }

    static /* synthetic */ List access$000(ProactiveRecommendationDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$100(ProactiveRecommendationDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$1000(ProactiveRecommendationDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$200(ProactiveRecommendationDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$300(ProactiveRecommendationDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$400(ProactiveRecommendationDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$500(ProactiveRecommendationDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ SupportSQLiteDatabase access$602(ProactiveRecommendationDb_Impl r2, SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r2.mDatabase = r4;
        return r4;
    }

    static /* synthetic */ void access$700(ProactiveRecommendationDb_Impl r2, SupportSQLiteDatabase r3) {
        r2.internalInitInvalidationTracker((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ List access$800(ProactiveRecommendationDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$900(ProactiveRecommendationDb_Impl r0) {
        return r0.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveUserSubscriptions`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveSubscriptionTasks`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveRecommendations`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveEcaCondition`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveInspiration`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactivePhoneEvent`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveAgentMemory`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveMemoryRule`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"ProactiveUserSubscriptions", "ProactiveSubscriptionTasks", "ProactiveRecommendations", "ProactiveEcaCondition", "ProactiveInspiration", "ProactivePhoneEvent", "ProactiveAgentMemory", "ProactiveMemoryRule"});
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r4) {
        final int r2 = 1;
        RoomOpenHelper r0 = new RoomOpenHelper(r4, new AnonymousClass1(this, r2), "2fbdf0285d337e6eb4c35350327e44ff", "fdde3e9805d09b1ee421cd4abb1a6e0f");
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
        r2.put(ProactiveUserSubscriptionsDao.class, ProactiveUserSubscriptionsDao_Impl.getRequiredConverters());
        r2.put(ProactiveSubscriptionTasksDao.class, ProactiveSubscriptionTasksDao_Impl.getRequiredConverters());
        r2.put(ProactiveRecommendationsDao.class, ProactiveRecommendationsDao_Impl.getRequiredConverters());
        r2.put(ProactiveEcaConditionDao.class, ProactiveEcaConditionDao_Impl.getRequiredConverters());
        r2.put(ProactiveInspirationDao.class, ProactiveInspirationDao_Impl.getRequiredConverters());
        r2.put(ProactiveMemoryRuleDao.class, ProactiveMemoryRuleDao_Impl.getRequiredConverters());
        r2.put(ProactivePhoneEventDao.class, ProactivePhoneEventDao_Impl.getRequiredConverters());
        r2.put(ProactiveAgentMemoryDao.class, ProactiveAgentMemoryDao_Impl.getRequiredConverters());
        return r2;
    }

    @Override // com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb
    public ProactiveAgentMemoryDao proactiveAgentMemoryDao() {
        if (this._proactiveAgentMemoryDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveAgentMemoryDao != null) goto L10;
        this._proactiveAgentMemoryDao = new ProactiveAgentMemoryDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactiveAgentMemoryDao r0 = this._proactiveAgentMemoryDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveAgentMemoryDao;
    }

    @Override // com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb
    public ProactiveEcaConditionDao proactiveEcaConditionDao() {
        if (this._proactiveEcaConditionDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveEcaConditionDao != null) goto L10;
        this._proactiveEcaConditionDao = new ProactiveEcaConditionDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactiveEcaConditionDao r0 = this._proactiveEcaConditionDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveEcaConditionDao;
    }

    @Override // com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb
    public ProactiveInspirationDao proactiveInspirationDao() {
        if (this._proactiveInspirationDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveInspirationDao != null) goto L10;
        this._proactiveInspirationDao = new ProactiveInspirationDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactiveInspirationDao r0 = this._proactiveInspirationDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveInspirationDao;
    }

    @Override // com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb
    public ProactiveMemoryRuleDao proactiveMemoryRuleDao() {
        if (this._proactiveMemoryRuleDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveMemoryRuleDao != null) goto L10;
        this._proactiveMemoryRuleDao = new ProactiveMemoryRuleDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactiveMemoryRuleDao r0 = this._proactiveMemoryRuleDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveMemoryRuleDao;
    }

    @Override // com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb
    public ProactivePhoneEventDao proactivePhoneEventDao() {
        if (this._proactivePhoneEventDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactivePhoneEventDao != null) goto L10;
        this._proactivePhoneEventDao = new ProactivePhoneEventDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactivePhoneEventDao r0 = this._proactivePhoneEventDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactivePhoneEventDao;
    }

    @Override // com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb
    public ProactiveRecommendationsDao proactiveRecommendationsDao() {
        if (this._proactiveRecommendationsDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveRecommendationsDao != null) goto L10;
        this._proactiveRecommendationsDao = new ProactiveRecommendationsDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactiveRecommendationsDao r0 = this._proactiveRecommendationsDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveRecommendationsDao;
    }

    @Override // com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb
    public ProactiveSubscriptionTasksDao proactiveSubscriptionTasksDao() {
        if (this._proactiveSubscriptionTasksDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveSubscriptionTasksDao != null) goto L10;
        this._proactiveSubscriptionTasksDao = new ProactiveSubscriptionTasksDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactiveSubscriptionTasksDao r0 = this._proactiveSubscriptionTasksDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveSubscriptionTasksDao;
    }

    @Override // com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb
    public ProactiveUserSubscriptionsDao proactiveUserSubscriptionsDao() {
        if (this._proactiveUserSubscriptionsDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveUserSubscriptionsDao != null) goto L10;
        this._proactiveUserSubscriptionsDao = new ProactiveUserSubscriptionsDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactiveUserSubscriptionsDao r0 = this._proactiveUserSubscriptionsDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveUserSubscriptionsDao;
    }
}
