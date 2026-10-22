package com.obric.memorydata.intelligence.datalearning.profile.task;

import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.intelligence.datalearning.profile.b.b.d;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J \u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J \u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J&\u0010\u001e\u001a\u00020\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0 H\u0002J\u0006\u0010#\u001a\u00020\u0017J\u0006\u0010$\u001a\u00020\u0017J\u0006\u0010%\u001a\u00020\u0017R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/task/UserProfileTaskManager;", "", "<init>", "()V", "tasks", "Ljava/util/ArrayList;", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/BaseProfileTask;", "Lkotlin/collections/ArrayList;", "successTaskCount", "", "shouldNotUpdateTaskExecTime", "", "isNeedCalculate", "startTimestamp", "", "endTimestamp", "getLastModifyTime", "jobName", "", "getJobName", "task", "taskTerm", "setLastModifyTime", "", "modifyTime", "compute", "saveProgress", "taskIndex", "timestamp", "taskCompute", "computeAllTask", "sortedTaskIndexes", "", "startIndex", "getTaskSort", "exec", "setShouldNotUpdateTaskExecTime", "clearProfileStoreData", "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9970a = null;
    private static final Lazy<c> e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<com.obric.memorydata.intelligence.datalearning.profile.task.a> f9971b;
    private int c;
    private boolean d;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/task/UserProfileTaskManager$Companion;", "", "<init>", "()V", "TIME_TERM_LONG", "", "TIME_TERM_MID", "RETRAIN_DAY_COUNT", "", "TAG", "INSTANCE", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/UserProfileTaskManager;", "getINSTANCE", "()Lcom/obric/memorydata/intelligence/datalearning/profile/task/UserProfileTaskManager;", "INSTANCE$delegate", "Lkotlin/Lazy;", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final c a() {
            return (c) ZeusTransformUtils.preCheckCast(c.c().getValue(), c.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f9970a = new a(null);
        e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$c$B0tjDrzOshEd7ePU5w_xtkKtYKo.INSTANCE);
    }

    private c() {
        ArrayList<com.obric.memorydata.intelligence.datalearning.profile.task.a> r0 = new ArrayList();
        this.f9971b = r0;
        r0.add(new com.obric.memorydata.intelligence.datalearning.profile.b.b.c(new b("1", "SleepWakeupMidTask", 1)));
        this.f9971b.add(new com.obric.memorydata.intelligence.datalearning.profile.b.b.b(new b("2", "SleepWakeupLongTask", 2)));
        this.f9971b.add(new com.obric.memorydata.intelligence.datalearning.profile.a.a.a(new b("3", "HomeCompanyTask", 3)));
        this.f9971b.add(new com.obric.memorydata.intelligence.datalearning.profile.b.a.a(new b("4", "ArriveLeaveMomentTask", 4)));
        this.f9971b.add(new d(new b("5", "SleepWakeupPackageTask", 5)));
    }

    private final long a(String r3, long r4) {
        long r2 = com.obric.memorydata.intelligence.datalearning.profile.data.c.a(r3);
        if (r2 != 0) goto L5;
    L7:
        RunLog.INSTANCE.debug("UserProfileTaskManager", "use the time 14 days ago");
        return System.currentTimeMillis() - 1209600000;
    L5:
        if (r2 >= r4) goto L7;
        return r2;
    }

    private final String a(com.obric.memorydata.intelligence.datalearning.profile.task.a r2, String r3) {
        StringBuilder r1 = new StringBuilder();
        r1.append(r2.b()).append("_").append(r3);
        String r4 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        return r4;
    }

    private final void a(int r7, long r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileTaskManager", "save progress lastTaskIndex:" + r7 + ",lastTaskTimestamp:" + r8, false, 4, null);
        com.obric.memorydata.intelligence.datalearning.profile.data.c.a(r7);
        com.obric.memorydata.intelligence.datalearning.profile.data.c.b(r8);
    }

    private final void a(com.obric.memorydata.intelligence.datalearning.profile.task.a r12, String r13, long r14) {
        String r0 = a(r12, r13);
        long r1 = a(r0, r14);
        if (a(r1, r14) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileTaskManager", r0 + " today has calculated", false, 4, null);
        return;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileTaskManager", "[ts]start " + r0 + ", lastTime=" + r1, false, 4, null);
        if (Intrinsics.areEqual("mid", r13) == false) goto L9;
        long r15 = r12.b(r1, r14);
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileTaskManager", "[ts]end " + r0 + ", curTime=" + r15, false, 4, null);
        if (r15 == (-1)) goto L14;
        b(r0, r15);
        return;
    L14:
        return;
    L9:
        r15 = r12.a(r1, r14);
        goto L10
    }

    private final void a(List<Integer> r9, int r10, long r11) {
        int r12 = ((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin")).size();
    L3:
        if (r10 >= r12) goto L9;
        com.obric.memorydata.intelligence.datalearning.profile.task.a r0 = (com.obric.memorydata.intelligence.datalearning.profile.task.a) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull((List) ZeusTransformUtils.preCheckCast(this.f9971b, List.class, "com.obric.memorydata.plugin"), r10), com.obric.memorydata.intelligence.datalearning.profile.task.a.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        a(r0, r10, r11);
    L8:
        r10 = r10 + 1;
        goto L3
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileTaskManager", "task " + r10 + " no register", null, 4, null);
        goto L8
    }

    private final boolean a(long r1, long r3) {
        if ((r.a(r3) - r.a(r1)) < WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean a(com.obric.memorydata.intelligence.datalearning.profile.task.a r2, int r3, long r4) {
        a(r2, "mid", r4);
        a(r2, "long", r4);
        this.c++;
        a(r3 + 1, r4);
        return true;
    }

    private final void b(String r1, long r2) {
        com.obric.memorydata.intelligence.datalearning.profile.data.c.a(r1, r2);
    }

    public static final /* synthetic */ Lazy c() {
        return e;
    }

    private final List<Integer> d() {
        ArrayList r0 = new ArrayList();
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f9971b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.add(Integer.valueOf(((com.obric.memorydata.intelligence.datalearning.profile.task.a) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.intelligence.datalearning.profile.task.a.class, "com.obric.memorydata.plugin")).a()));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private static final c e() {
        return new c();
    }

    public static /* synthetic */ c lambda$B0tjDrzOshEd7ePU5w_xtkKtYKo() {
        return e();
    }

    public final void a() {
        monitor-enter(this);
        this.d = false;     // Catch: Throwable -> L19
        this.c = 0;     // Catch: Throwable -> L19
        List<Integer> r1 = d();     // Catch: Throwable -> L19
        int r2 = com.obric.memorydata.intelligence.datalearning.profile.data.c.b();     // Catch: Throwable -> L19
        long r3 = com.obric.memorydata.intelligence.datalearning.profile.data.c.c();     // Catch: Throwable -> L19
        RunLog.INSTANCE.debug("UserProfileTaskManager", "lastIndex:" + r2 + ", lastTime:" + r3);     // Catch: Throwable -> L19
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L19
        if (r2 > 0) goto L7;
    L13:
        a(r1, 0, r5);     // Catch: Throwable -> L19
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileTaskManager", "up task normal end success: " + this.c, false, 4, null);     // Catch: Throwable -> L19
        if (this.d == true) goto L16;
        com.obric.memorydata.intelligence.datalearning.profile.data.c.a(r5);     // Catch: Throwable -> L19
    L16:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L7:
        if (r2 >= r1.size()) goto L13;
        if (r3 == 0) goto L13;
        if (r3 >= r5) goto L13;
        a(r1, r2, r3);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public final void b() {
        com.obric.memorydata.intelligence.datalearning.profile.data.c.d();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f9971b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.obric.memorydata.intelligence.datalearning.profile.task.a r1 = (com.obric.memorydata.intelligence.datalearning.profile.task.a) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.memorydata.intelligence.datalearning.profile.task.a.class, "com.obric.memorydata.plugin");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).remove(new String[]{a(r1, "mid")});
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).remove(new String[]{a(r1, "long")});
        goto L4
    L6:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMiddleUserProfileDao().deleteAll();
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().deleteAll();
    }
}
