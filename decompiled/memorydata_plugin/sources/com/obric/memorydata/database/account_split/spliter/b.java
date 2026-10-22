package com.obric.memorydata.database.account_split.spliter;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.obric.memorydata.database.account_split.w;
import com.obric.memorydata.database.account_split.x;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.database.DatabaseIsolationTracker;
import com.obric.memorydata.middleware.database.i;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitMigrationExecutor;", "", "<init>", "()V", "TAG", "", "isCurrentProfileMigrationDone", "", "migrateCurrentProfileIfNeededBlocking", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8819a = null;

    static {
        f8819a = new b();
    }

    private b() {
    }

    public final boolean a() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("personal_sql_split_migration_done_v2", false);
    }

    public final int b() {
        int r3 = 0;
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        if (r0.getBoolean("personal_sql_split_migration_done_v2", false) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitMigrationExecutor", "migration skipped, already done", false, 4, null);
        return 0;
    L6:
        i r4 = c.f8820a.a();
        if (r4.c() == false) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitMigrationExecutor", "skip sql split migration, invalid uid, rawUserId=" + q.f13259a.b(r4.b()) + ", isLogin=" + AppContext.INSTANCE.isLogin(), null, 4, null);
        DatabaseIsolationTracker.a(DatabaseIsolationTracker.f11642a, DatabaseIsolationTracker.SqlMigrationPhase.OVERALL, "skipped_invalid_uid", null, 0, 0, 0, 0, "invalid_profile_id", 60, null);
        return 0;
    L11:
        if (d.f8821a.b("db_iso_PersonalDbSplitMigrationExecutor") == true) goto L14;
        DatabaseIsolationTracker.a(DatabaseIsolationTracker.f11642a, DatabaseIsolationTracker.SqlMigrationPhase.OVERALL, "failed", null, 0, 0, 0, 0, "personal_db_profile_mismatch", 60, null);
        return 0;
    L14:
        long r5 = System.currentTimeMillis();
        SupportSQLiteDatabase r7 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper().getWritableDatabase();
        e r8 = new e();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitMigrationExecutor", "migration start, profileId=" + q.f13259a.b(r4.a()) + ", anonymous=" + r4.c(), false, 4, null);
        a.f8818a.a();     // Catch: Throwable -> L25
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(w.f8834a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L25
    L17:
        if (r9.hasNext() == false) goto L19;
        r3 = r3 + r8.a((x) ZeusTransformUtils.preCheckCast(r9.next(), x.class, "com.obric.memorydata.plugin"), r4, r7);     // Catch: Throwable -> L25
        goto L17
    L19:
        com.obric.memorydata.database.manager.d.f9563a.a(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper().getWritableDatabase());     // Catch: Throwable -> L25
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.asReversed(w.f8834a.a()), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L25
    L21:
        if (r10.hasNext() == false) goto L23;
        r8.b((x) ZeusTransformUtils.preCheckCast(r10.next(), x.class, "com.obric.memorydata.plugin"), r4, r7);     // Catch: Throwable -> L25
        goto L21
    L23:
        r0.save("personal_sql_split_migration_done_v2", true);     // Catch: Throwable -> L25
        long r1 = System.currentTimeMillis() - r5;     // Catch: Throwable -> L25
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitMigrationExecutor", "migration finished, profileId=" + q.f13259a.b(r4.a()) + ", migrated=" + r3 + ", cost=" + r1, false, 4, null);     // Catch: Throwable -> L25
        DatabaseIsolationTracker.a(DatabaseIsolationTracker.f11642a, DatabaseIsolationTracker.SqlMigrationPhase.OVERALL, "success", null, r3, 0, 0, r1, null, SubsamplingScaleImageView.ORIENTATION_180, null);     // Catch: Throwable -> L25
        return r3;
    L25:
        th = move-exception;
        long r14 = System.currentTimeMillis() - r5;
        boolean r2 = ZeusTransformUtils.instanceOf(th, PersonalDbSplitMigrationTimeoutException.class);
        DatabaseIsolationTracker r11 = DatabaseIsolationTracker.f11642a;
        DatabaseIsolationTracker.SqlMigrationPhase r12 = DatabaseIsolationTracker.SqlMigrationPhase.OVERALL;
        if (r2 == false) goto L29;
        String r13 = LocationMonitorConst.TIMEOUT;
    L31:
        if (r2 == false) goto L33;
        String r16 = LocationMonitorConst.TIMEOUT;
    L34:
        DatabaseIsolationTracker.a(r11, r12, r13, null, 0, 0, 0, r14, r16, 60, null);
        throw th;
    L33:
        r16 = th.getClass().getSimpleName();
        goto L34
    L29:
        r13 = "failed";
        goto L31
    }
}
