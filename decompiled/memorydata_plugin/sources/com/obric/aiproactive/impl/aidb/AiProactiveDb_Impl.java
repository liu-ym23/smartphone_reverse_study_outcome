package com.obric.aiproactive.impl.aidb;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.obric.aiproactive.impl.aidb.dao.AiProactiveDirectFeedbackDao_Impl;
import com.obric.aiproactive.impl.aidb.dao.AiProactiveEcaDao_Impl;
import com.obric.aiproactive.impl.aidb.dao.AiProactiveEventRecordDao_Impl;
import com.obric.aiproactive.impl.aidb.dao.AiProactiveMessageBackupDao_Impl;
import com.obric.aiproactive.impl.aidb.dao.AiProactiveMessageDao_Impl;
import com.obric.aiproactive.impl.aidb.dao.AiProactivePreferenceDao_Impl;
import com.obric.aiproactive.impl.aidb.dao.AiProactiveRecommendationDao_Impl;
import com.obric.aiproactive.impl.aidb.dao.AiProactiveTaskDao_Impl;
import com.obric.aiproactive.impl.aidb.dao.AiProactiveTraceDao_Impl;
import com.obric.aiproactive.impl.aidb.dao.SpellProactiveEcaDao_Impl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class AiProactiveDb_Impl extends AiProactiveDb {
    private volatile com.obric.aiproactive.impl.aidb.dao.a _aiProactiveDirectFeedbackDao;
    private volatile com.obric.aiproactive.impl.aidb.dao.b _aiProactiveEcaDao;
    private volatile com.obric.aiproactive.impl.aidb.dao.c _aiProactiveEventRecordDao;
    private volatile com.obric.aiproactive.impl.aidb.dao.d _aiProactiveMessageBackupDao;
    private volatile com.obric.aiproactive.impl.aidb.dao.e _aiProactiveMessageDao;
    private volatile com.obric.aiproactive.impl.aidb.dao.f _aiProactivePreferenceDao;
    private volatile com.obric.aiproactive.impl.aidb.dao.g _aiProactiveRecommendationDao;
    private volatile com.obric.aiproactive.impl.aidb.dao.h _aiProactiveTaskDao;
    private volatile com.obric.aiproactive.impl.aidb.dao.i _aiProactiveTraceDao;
    private volatile com.obric.aiproactive.impl.aidb.dao.j _spellProactiveEcaDao;

    public AiProactiveDb_Impl() {
    }

    static /* synthetic */ List access$000(AiProactiveDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$100(AiProactiveDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$1000(AiProactiveDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$200(AiProactiveDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$300(AiProactiveDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$400(AiProactiveDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$500(AiProactiveDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ SupportSQLiteDatabase access$602(AiProactiveDb_Impl r2, SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r2.mDatabase = r4;
        return r4;
    }

    static /* synthetic */ void access$700(AiProactiveDb_Impl r2, SupportSQLiteDatabase r3) {
        r2.internalInitInvalidationTracker((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ List access$800(AiProactiveDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$900(AiProactiveDb_Impl r0) {
        return r0.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveEventRecords`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveRecommendation`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveTrace`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveDirectFeedback`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveTask`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactivePreference`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveEca`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveMessage`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ProactiveMessageBackup`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `SpellProactiveEca`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"ProactiveEventRecords", "ProactiveRecommendation", "ProactiveTrace", "ProactiveDirectFeedback", "ProactiveTask", "ProactivePreference", "ProactiveEca", "ProactiveMessage", "ProactiveMessageBackup", "SpellProactiveEca"});
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r4) {
        final int r2 = 1;
        RoomOpenHelper r0 = new RoomOpenHelper(r4, new AnonymousClass1(this, r2), "f56c104561c96f42db3adf2dbb61660d", "c46d6ccc471d112a7b29b411245df71b");
        SupportSQLiteOpenHelper.Configuration r3 = SupportSQLiteOpenHelper.Configuration.builder(r4.context).name(r4.name).callback(r0).build();
        return r4.sqliteOpenHelperFactory.create(r3);
    }

    @Override // com.obric.aiproactive.impl.aidb.AiProactiveDb
    public com.obric.aiproactive.impl.aidb.dao.a directFeedbackDao() {
        if (this._aiProactiveDirectFeedbackDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._aiProactiveDirectFeedbackDao != null) goto L10;
        this._aiProactiveDirectFeedbackDao = new AiProactiveDirectFeedbackDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiproactive.impl.aidb.dao.a r0 = this._aiProactiveDirectFeedbackDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._aiProactiveDirectFeedbackDao;
    }

    @Override // com.obric.aiproactive.impl.aidb.AiProactiveDb
    public com.obric.aiproactive.impl.aidb.dao.b ecaDao() {
        if (this._aiProactiveEcaDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._aiProactiveEcaDao != null) goto L10;
        this._aiProactiveEcaDao = new AiProactiveEcaDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiproactive.impl.aidb.dao.b r0 = this._aiProactiveEcaDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._aiProactiveEcaDao;
    }

    @Override // com.obric.aiproactive.impl.aidb.AiProactiveDb
    public com.obric.aiproactive.impl.aidb.dao.c eventRecordDao() {
        if (this._aiProactiveEventRecordDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._aiProactiveEventRecordDao != null) goto L10;
        this._aiProactiveEventRecordDao = new AiProactiveEventRecordDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiproactive.impl.aidb.dao.c r0 = this._aiProactiveEventRecordDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._aiProactiveEventRecordDao;
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
        r2.put(com.obric.aiproactive.impl.aidb.dao.c.class, AiProactiveEventRecordDao_Impl.getRequiredConverters());
        r2.put(com.obric.aiproactive.impl.aidb.dao.g.class, AiProactiveRecommendationDao_Impl.getRequiredConverters());
        r2.put(com.obric.aiproactive.impl.aidb.dao.a.class, AiProactiveDirectFeedbackDao_Impl.getRequiredConverters());
        r2.put(com.obric.aiproactive.impl.aidb.dao.i.class, AiProactiveTraceDao_Impl.getRequiredConverters());
        r2.put(com.obric.aiproactive.impl.aidb.dao.h.class, AiProactiveTaskDao_Impl.getRequiredConverters());
        r2.put(com.obric.aiproactive.impl.aidb.dao.f.class, AiProactivePreferenceDao_Impl.getRequiredConverters());
        r2.put(com.obric.aiproactive.impl.aidb.dao.b.class, AiProactiveEcaDao_Impl.getRequiredConverters());
        r2.put(com.obric.aiproactive.impl.aidb.dao.e.class, AiProactiveMessageDao_Impl.getRequiredConverters());
        r2.put(com.obric.aiproactive.impl.aidb.dao.d.class, AiProactiveMessageBackupDao_Impl.getRequiredConverters());
        r2.put(com.obric.aiproactive.impl.aidb.dao.j.class, SpellProactiveEcaDao_Impl.getRequiredConverters());
        return r2;
    }

    @Override // com.obric.aiproactive.impl.aidb.AiProactiveDb
    public com.obric.aiproactive.impl.aidb.dao.d messageBackupDao() {
        if (this._aiProactiveMessageBackupDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._aiProactiveMessageBackupDao != null) goto L10;
        this._aiProactiveMessageBackupDao = new AiProactiveMessageBackupDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiproactive.impl.aidb.dao.d r0 = this._aiProactiveMessageBackupDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._aiProactiveMessageBackupDao;
    }

    @Override // com.obric.aiproactive.impl.aidb.AiProactiveDb
    public com.obric.aiproactive.impl.aidb.dao.e messageDao() {
        if (this._aiProactiveMessageDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._aiProactiveMessageDao != null) goto L10;
        this._aiProactiveMessageDao = new AiProactiveMessageDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiproactive.impl.aidb.dao.e r0 = this._aiProactiveMessageDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._aiProactiveMessageDao;
    }

    @Override // com.obric.aiproactive.impl.aidb.AiProactiveDb
    public com.obric.aiproactive.impl.aidb.dao.f preferenceDao() {
        if (this._aiProactivePreferenceDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._aiProactivePreferenceDao != null) goto L10;
        this._aiProactivePreferenceDao = new AiProactivePreferenceDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiproactive.impl.aidb.dao.f r0 = this._aiProactivePreferenceDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._aiProactivePreferenceDao;
    }

    @Override // com.obric.aiproactive.impl.aidb.AiProactiveDb
    public com.obric.aiproactive.impl.aidb.dao.g recommendationDao() {
        if (this._aiProactiveRecommendationDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._aiProactiveRecommendationDao != null) goto L10;
        this._aiProactiveRecommendationDao = new AiProactiveRecommendationDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiproactive.impl.aidb.dao.g r0 = this._aiProactiveRecommendationDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._aiProactiveRecommendationDao;
    }

    @Override // com.obric.aiproactive.impl.aidb.AiProactiveDb
    public com.obric.aiproactive.impl.aidb.dao.j spellEcaDao() {
        if (this._spellProactiveEcaDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._spellProactiveEcaDao != null) goto L10;
        this._spellProactiveEcaDao = new SpellProactiveEcaDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiproactive.impl.aidb.dao.j r0 = this._spellProactiveEcaDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._spellProactiveEcaDao;
    }

    @Override // com.obric.aiproactive.impl.aidb.AiProactiveDb
    public com.obric.aiproactive.impl.aidb.dao.h taskDao() {
        if (this._aiProactiveTaskDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._aiProactiveTaskDao != null) goto L10;
        this._aiProactiveTaskDao = new AiProactiveTaskDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiproactive.impl.aidb.dao.h r0 = this._aiProactiveTaskDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._aiProactiveTaskDao;
    }

    @Override // com.obric.aiproactive.impl.aidb.AiProactiveDb
    public com.obric.aiproactive.impl.aidb.dao.i traceDao() {
        if (this._aiProactiveTraceDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._aiProactiveTraceDao != null) goto L10;
        this._aiProactiveTraceDao = new AiProactiveTraceDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiproactive.impl.aidb.dao.i r0 = this._aiProactiveTraceDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._aiProactiveTraceDao;
    }
}
