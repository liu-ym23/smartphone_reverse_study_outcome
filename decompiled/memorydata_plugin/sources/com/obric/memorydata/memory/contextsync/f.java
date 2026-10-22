package com.obric.memorydata.memory.contextsync;

import android.os.Handler;
import android.os.Looper;
import androidx.room.InvalidationTracker;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.n;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.TaskRegister;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0018\u001b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J6\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\n2\b\b\u0002\u0010*\u001a\u00020+J\"\u0010,\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\nJ\b\u0010-\u001a\u00020\nH\u0002J\u0015\u0010.\u001a\u0004\u0018\u00010\n2\u0006\u0010/\u001a\u00020\n¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u001eJ\u0010\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020\u0005J\u0016\u00104\u001a\u0002052\u0006\u00103\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005J\u0016\u00107\u001a\u0002052\u0006\u00103\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005J\u000e\u00108\u001a\u0002052\u0006\u0010&\u001a\u00020\nJ\u000e\u00109\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\nJ\u0006\u0010:\u001a\u00020\u001eJ\u0016\u0010;\u001a\u0002052\u0006\u00103\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\nJ\b\u0010<\u001a\u0004\u0018\u00010\u0005J\u001e\u0010=\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(J\u0010\u0010?\u001a\u0004\u0018\u00010%2\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020\n2\u0006\u0010@\u001a\u00020AJ\u000e\u0010C\u001a\u00020(2\u0006\u0010@\u001a\u00020AJ\b\u0010D\u001a\u00020\u001eH\u0002J\b\u0010E\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006F"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/MemoryContextSyncCoordinator;", "", "<init>", "()V", "TAG", "", "INPUT_SOURCE", "INPUT_GENERATION", "INPUT_ATTEMPT", "PROVIDER_CHANGE_DEBOUNCE_MS", "", "batchGeneration", "Ljava/util/concurrent/atomic/AtomicLong;", "providerFullGeneration", "schedulingLock", "providerDebounceHandler", "Landroid/os/Handler;", "providerDebounceRunnable", "Ljava/lang/Runnable;", "semanticObserverRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "screenRecoveryObserverRegistered", "screenRecoveryRequired", "semanticObserver", "com/obric/memorydata/memory/contextsync/MemoryContextSyncCoordinator$semanticObserver$1", "Lcom/obric/memorydata/memory/contextsync/MemoryContextSyncCoordinator$semanticObserver$1;", "screenStateReceiver", "com/obric/memorydata/memory/contextsync/MemoryContextSyncCoordinator$screenStateReceiver$1", "Lcom/obric/memorydata/memory/contextsync/MemoryContextSyncCoordinator$screenStateReceiver$1;", CommonConsts.APM_INNER_EVENT_COST_START, "", "onProviderChanged", "onSemanticChanged", "onSemanticTableInvalidated", "onScreenOn", "enqueueAlignment", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/contextsync/MemoryContextAlignmentSource;", PendingPersonalInfoNotificationTask.KEY_GENERATION, "attempt", "", "delayMs", "policy", "Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;", "enqueueBatch", "invalidateBatchesForProvider", "invalidateBatchesIfCurrent", "expectedGeneration", "(J)Ljava/lang/Long;", "cancelQueuedBatches", "beginMigration", "userId", "onMigrationRestored", "", "token", "abortMigrationBeforeRestore", "isProviderFullRequired", "markProviderFullApplied", "markScreenRecoveryComplete", "isSessionCurrent", "currentUserIdOrNull", "retryAlignment", "retryBatch", "parseSource", Ext.KEY_REQUEST, "Lcom/obric/memorydata/task/AbsTaskRequest;", "parseGeneration", "parseAttempt", "ensureSemanticObserver", "ensureScreenRecoveryObserver", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f10102a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicLong f10103b = null;
    private static final AtomicLong c = null;
    private static final Object d = null;
    private static final Handler e = null;
    private static Runnable f;
    private static final AtomicBoolean g = null;
    private static final AtomicBoolean h = null;
    private static final AtomicBoolean i = null;
    private static final MemoryContextSyncCoordinator$semanticObserver$1 j = null;
    private static final a k = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/contextsync/MemoryContextSyncCoordinator$screenStateReceiver$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements k {
        a() {
        }

        @Override // com.obric.memorydata.ability.k
        public void a(com.obric.memorydata.ability.data.h r2) {
            com.obric.memorydata.ability.data.h r1 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "data");
            if (ZeusTransformUtils.instanceOf(r1, p.class) == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r1, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.f) == false) goto L9;
            f.b(f.f10102a);
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.memorydata.memory.contextsync.MemoryContextSyncCoordinator$semanticObserver$1] */
    static {
        f10102a = new f();
        f10103b = new AtomicLong(0);
        c = new AtomicLong(-1);
        d = new Object();
        e = new Handler(Looper.getMainLooper());
        g = new AtomicBoolean(false);
        h = new AtomicBoolean(false);
        i = new AtomicBoolean(false);
        final String[] r0 = new String[0];
        j = new MemoryContextSyncCoordinator$semanticObserver$1(r0);
        k = new a();
    }

    private f() {
    }

    public static final /* synthetic */ void a(f r0) {
        r0.g();
    }

    public static /* synthetic */ void a(f r6, long r7, int r9, long r10, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r9 = 0;
    L5:
        int r3 = r9;
        if ((r12 & 4) == 0) goto L8;
        r10 = 0;
    L8:
        r6.a(r7, r3, r10);
    }

    public static /* synthetic */ void a(f r6, MemoryContextAlignmentSource r7, long r8, int r10, long r11, ExistingTaskPolicy r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        long r0 = f10103b.get();
    L7:
        if ((r14 & 4) == 0) goto L9;
        int r2 = 0;
    L11:
        if ((r14 & 8) == 0) goto L13;
        long r3 = 0;
    L15:
        if ((r14 & 16) == 0) goto L17;
        ExistingTaskPolicy r5 = ExistingTaskPolicy.REPLACE_IN_QUEUE;
    L18:
        r6.a(r7, r0, r2, r3, r5);
        return;
    L17:
        r5 = r13;
        goto L18
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L11
    L5:
        r0 = r8;
        goto L7
    }

    public static final /* synthetic */ void b(f r0) {
        r0.h();
    }

    private static final void d(long r10) {
        f r0 = f10102a;
        r0.j();
        a(r0, MemoryContextAlignmentSource.PROVIDER_CHANGED, r10, 0, 0, ExistingTaskPolicy.CANCEL_EXISTING, 12, null);
    }

    private final void g() {
        boolean r0 = AppContext.INSTANCE.isLogin();
        if (r0 == true) goto L5;
        return;
    L5:
        if (c.f10095a.a() == true) goto L14;
        int r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryContextSyncDao().countPending();
        if (g.f10104a.a(r0, r1) == true) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncCoordinator", "semantic invalidation ignored, reason=pending_empty", false, 4, null);
        return;
    L11:
        c();
        return;
    }

    private final void h() {
        AtomicBoolean r0 = i;
        if (r0.get() == true) goto L5;
        return;
    L5:
        if (AppContext.INSTANCE.isLogin() == true) goto L7;
        return;
    L7:
        if (c.f10095a.a() == false) goto L10;
        return;
    L10:
        if (r0.compareAndSet(true, false) == true) goto L12;
        return;
    L12:
        Long r3 = a(f10103b.get());
        if (r3 != null) goto L16;
        r0.set(true);
        return;
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncCoordinator", "screen-on recovery scheduled, generation=" + r3, false, 4, null);
        a(this, MemoryContextAlignmentSource.SCREEN_ON_RECOVERY, r3.longValue(), 0, 0, ExistingTaskPolicy.CANCEL_EXISTING, 12, null);
    }

    private final long i() {
        Object r4 = d;
        monitor-enter(r4);
        long r0 = f10103b.incrementAndGet();     // Catch: Throwable -> L7
        c.set(r0);     // Catch: Throwable -> L7
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().b(MemoryContextBatchSyncTask.NAME);     // Catch: Throwable -> L7
        monitor-exit(r4);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    private final void j() {
        if (g.compareAndSet(false, true) == true) goto L10;
        return;
    L10:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getInvalidationTracker().addObserver((InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(j, InvalidationTracker.Observer.class, "com.obric.memorydata.plugin"));     // Catch: RuntimeException -> L7
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncCoordinator", "semantic invalidation observer registered", false, 4, null);     // Catch: RuntimeException -> L7
        return;
    L7:
        e = move-exception;
        g.set(false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncCoordinator", "semantic invalidation observer registration failed: " + e, null, 4, null);
    }

    private final void k() {
        AtomicBoolean r6 = h;
        if (r6.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        if (new com.obric.memorydata.ability.d().a(new com.obric.memorydata.ability.f(100000005, MapsKt.mapOf(TuplesKt.to("mode", com.tom_roush.pdfbox.pdmodel.a.d.f.f))), (k) ZeusTransformUtils.preCheckCast(k, k.class, "com.obric.memorydata.plugin")) == true) goto L9;
        r6.set(false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncCoordinator", "[code=screen_recovery_observer_failed] screen recovery observer registration failed", null, 4, null);
        return;
    }

    public static /* synthetic */ void lambda$q9LGIPUOlIgutqAWekWZK9O0dXQ(long r0) {
        d(r0);
    }

    public final MemoryContextAlignmentSource a(AbsTaskRequest r3) {
        Intrinsics.checkNotNullParameter(r3, Ext.KEY_REQUEST);
        String r4 = r3.getTaskParameter().getInputParams().optString(AILabCheckPermissionTask.KEY_SOURCE);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        f r2 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L5
        Object r5 = Result.m1421constructorimpl(MemoryContextAlignmentSource.valueOf(r4));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r5) == false) goto L11;
        r5 = null;
    L11:
        return (MemoryContextAlignmentSource) ZeusTransformUtils.preCheckCast(r5, MemoryContextAlignmentSource.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final Long a(long r4) {
        Object r3 = d;
        monitor-enter(r3);
        long r0 = 1 + r4;
    L13:
        th = move-exception;
        throw th;
    L6:
        if (f10103b.compareAndSet(r4, r0) == false) goto L8;
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().b(MemoryContextBatchSyncTask.NAME);     // Catch: Throwable -> L13
        Long r5 = Long.valueOf(r0);     // Catch: Throwable -> L13
        monitor-exit(r3);
        return r5;
    L8:
        monitor-exit(r3);
        return null;
    }

    public final String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        String r3 = c.f10095a.a(r4);
        if (r3 != null) goto L5;
        return null;
    L5:
        Object r0 = d;
        monitor-enter(r0);
        f10103b.incrementAndGet();     // Catch: Throwable -> L13
        Runnable r1 = f;     // Catch: Throwable -> L13
        if (r1 == null) goto L10;
        e.removeCallbacks(r1);     // Catch: Throwable -> L13
    L10:
        f r2 = f10102a;     // Catch: Throwable -> L13
        f = null;     // Catch: Throwable -> L13
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().b(MemoryContextAlignmentTask.NAME);     // Catch: Throwable -> L13
        r2.d();     // Catch: Throwable -> L13
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return r3;
    L13:
        th = move-exception;
        throw th;
    }

    public final void a() {
        TaskRegister.f12863a.a(MemoryContextAlignmentTask.NAME, MemoryContextAlignmentTask.class);
        TaskRegister.f12863a.a(MemoryContextBatchSyncTask.NAME, MemoryContextBatchSyncTask.class);
        d.f10097a.a((Function0) ZeusTransformUtils.preCheckCast(new MemoryContextSyncCoordinator$start$1(this), Function0.class, "com.obric.memorydata.plugin"));
        k();
        if (AppContext.INSTANCE.isLogin() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncCoordinator", "start skipped startup alignment: logged out", false, 4, null);
        return;
    L6:
        j();
        if (c.f10095a.a() == false) goto L10;
        ((o) ZeusTransformUtils.preCheckCast(n.f11627a, o.class, "com.obric.memorydata.plugin")).a("context_restore_incomplete", "上次迁移未完成，Context 同步保持暂停，等待重新迁移", new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
        return;
    L10:
        a(this, MemoryContextAlignmentSource.STARTUP, 0, 0, 0, null, 30, null);
    }

    public final void a(long r13, int r15) {
        if (r13 == f10103b.get()) goto L6;
        return;
    L6:
        if (g.f10104a.a(r15) == false) goto L9;
        i.set(true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncCoordinator", "[code=batch_retry_exhausted] batch retry exhausted, screenRecoveryArmed=true", null, 4, null);
        return;
    L9:
        a(r13, r15 + 1, g.f10104a.b(r15));
    }

    public final void a(long r4, int r6, long r7) {
        Object r3 = d;
        monitor-enter(r3);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r4 == f10103b.get()) goto L7;
    L15:
        monitor-exit(r3);
        return;
    L7:
        if (c.f10095a.a() == true) goto L15;
        TaskRequest.Builder r0 = new TaskRequest.Builder(MemoryContextBatchSyncTask.NAME);     // Catch: Throwable -> L17
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L17
        r1.put(PendingPersonalInfoNotificationTask.KEY_GENERATION, r4);     // Catch: Throwable -> L17
        r1.put("attempt", r6);     // Catch: Throwable -> L17
        TaskRequest.Builder r5 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r0.setInputParam(r1), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(5), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.NETWORK_AVAILABLE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r7 <= 0) goto L12;
        r5.setDelay((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.c(r7), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
    L12:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(r5.build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();     // Catch: Throwable -> L17
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r3);
    }

    public final void a(MemoryContextAlignmentSource r11, long r12, int r14) {
        Intrinsics.checkNotNullParameter(r11, AILabCheckPermissionTask.KEY_SOURCE);
        if (r12 == f10103b.get()) goto L6;
        return;
    L6:
        if (g.f10104a.a(r14) == false) goto L9;
        i.set(true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncCoordinator", "[code=alignment_retry_exhausted] alignment retry exhausted, source=" + r11 + ", screenRecoveryArmed=true", null, 4, null);
        return;
    L9:
        a(this, r11, r12, r14 + 1, g.f10104a.b(r14), null, 16, null);
    }

    public final void a(MemoryContextAlignmentSource r4, long r5, int r7, long r8, ExistingTaskPolicy r10) {
        Intrinsics.checkNotNullParameter(r4, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r10, "policy");
        Object r3 = d;
        monitor-enter(r3);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r5 == f10103b.get()) goto L7;
    L15:
        monitor-exit(r3);
        return;
    L7:
        if (c.f10095a.a() == true) goto L15;
        TaskRequest.Builder r0 = new TaskRequest.Builder(MemoryContextAlignmentTask.NAME);     // Catch: Throwable -> L17
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L17
        r1.put(AILabCheckPermissionTask.KEY_SOURCE, r4.name());     // Catch: Throwable -> L17
        r1.put(PendingPersonalInfoNotificationTask.KEY_GENERATION, r5);     // Catch: Throwable -> L17
        r1.put("attempt", r7);     // Catch: Throwable -> L17
        TaskRequest.Builder r6 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r0.setInputParam(r1), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(5), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.NETWORK_AVAILABLE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(r10), TaskRequest.Builder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r8 <= 0) goto L12;
        r6.setDelay((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.c(r8), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
    L12:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(r6.build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();     // Catch: Throwable -> L17
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r3);
    }

    public final boolean a(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "userId");
        if (AppContext.INSTANCE.isLogin() == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), r1) == false) goto L11;
        if (f10103b.get() != r2) goto L11;
        if (c.f10095a.a() == true) goto L11;
        return true;
    }

    public final boolean a(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "userId");
        Intrinsics.checkNotNullParameter(r12, "token");
        boolean r13 = c.f10095a.a(r11, r12);
        i.set(true);
        if (Intrinsics.areEqual(f(), r11) == false) goto L5;
        a(this, MemoryContextAlignmentSource.MIGRATION_RESTORED, 0, 0, 0, null, 30, null);
    L5:
        return r13;
    }

    public final long b(AbsTaskRequest r3) {
        Intrinsics.checkNotNullParameter(r3, Ext.KEY_REQUEST);
        return r3.getTaskParameter().getInputParams().optLong(PendingPersonalInfoNotificationTask.KEY_GENERATION, -1);
    }

    public final void b() {
        if (c.f10095a.a() == false) goto L5;
        return;
    L5:
        Object r7 = d;
        monitor-enter(r7);
        final long r0 = f10102a.i();     // Catch: Throwable -> L18
        Runnable r2 = f;     // Catch: Throwable -> L18
        if (r2 == null) goto L11;
        e.removeCallbacks(r2);     // Catch: Throwable -> L18
    L11:
        if (AppContext.INSTANCE.isLogin() == true) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncCoordinator", "provider change ignored: logged out", false, 4, null);     // Catch: Throwable -> L18
        monitor-exit(r7);
        return;
    L15:
        Runnable r3 = new $$Lambda$f$q9LGIPUOlIgutqAWekWZK9O0dXQ(r0);     // Catch: Throwable -> L18
        f = r3;     // Catch: Throwable -> L18
        e.postDelayed(r3, 5000);     // Catch: Throwable -> L18
        monitor-exit(r7);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final boolean b(long r3) {
        if (c.get() != r3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "userId");
        Intrinsics.checkNotNullParameter(r12, "token");
        if (c.f10095a.b(r11, r12) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(f(), r11) == false) goto L11;
        a(this, MemoryContextAlignmentSource.STARTUP, 0, 0, 0, null, 30, null);
        return true;
    L11:
        return true;
    }

    public final int c(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        return r2.getTaskParameter().getInputParams().optInt("attempt", 0);
    }

    public final void c() {
        if (AppContext.INSTANCE.isLogin() == true) goto L5;
        return;
    L5:
        if (c.f10095a.a() == true) goto L10;
        a(this, MemoryContextAlignmentSource.SEMANTIC_CHANGED, 0, 0, 0, null, 30, null);
        return;
    }

    public final void c(long r3) {
        c.compareAndSet(r3, -1);
    }

    public final void d() {
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().b(MemoryContextBatchSyncTask.NAME);
    }

    public final void e() {
        i.set(false);
    }

    public final String f() {
        if (AppContext.INSTANCE.isLogin() == true) goto L5;
        return null;
    L5:
        String r3 = AppContext.INSTANCE.getUserId();
        boolean r2 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
    L10:
        r2 = false;
    L11:
        if (r2 == true) goto L13;
        return null;
    L13:
        return r3;
    L8:
        if (Intrinsics.areEqual(r3, "0") == true) goto L10;
        goto L10
    }
}
