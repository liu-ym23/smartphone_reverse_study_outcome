package com.obric.memorydata.task.scheduler.impl;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.aikernelcore.h;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.TaskRegister;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J$\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u000b2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00050 J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000bJ\u000e\u0010$\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000bJ\b\u0010&\u001a\u00020\u0016H\u0007J\b\u0010'\u001a\u00020\u0016H\u0007J\u0006\u0010(\u001a\u00020\u0016J\u0012\u0010)\u001a\u00020\u00162\b\u0010*\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u000bH\u0002J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001b0.2\u0006\u0010,\u001a\u00020\u000bH\u0002J\u0010\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/memorydata/task/scheduler/impl/TaskSerialExecutor;", "Ljava/util/concurrent/Executor;", "Lcom/obric/memorydata/aikernelcore/PackageFinishedCallback;", "delegatedExecutor", "highPriority", "", "<init>", "(Ljava/util/concurrent/Executor;Z)V", "getHighPriority", "()Z", LocationMonitorConst.TAG, "", "tasks", "Lcom/obric/memorydata/task/PriorityArrayDeque;", "Lcom/obric/memorydata/task/scheduler/impl/TaskSerialExecutor$Task;", "lock", "", "currentActiveTaskQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "poolSize", "", "execute", "", "command", "Ljava/lang/Runnable;", "check", "runTask", "Lcom/obric/memorydata/task/scheduler/impl/EnqueueRunnable;", "hasTask", "removeTask", ActivityLifecycle.NAME, "retainPredicate", "Lkotlin/Function1;", "Lcom/obric/memorydata/task/AbsTaskRequest;", "removeTaskId", "taskId", "cancelActiveTask", "cancelActiveTaskId", "removeAllTask", "printAll", "scheduleNext", "innerExecuteTask", "active", "hasSameTaskInActiveTask", "taskName", "getSameTaskInActiveTask", "", "onPackageFinished", "bizName", "Task", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d implements com.obric.memorydata.aikernelcore.d, Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f12963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12964b;
    private final String c;
    private final com.obric.memorydata.task.c<a> d;
    private final Object e;
    private ConcurrentLinkedDeque<a> f;
    private final int g;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/task/scheduler/impl/TaskSerialExecutor$Task;", "Ljava/lang/Runnable;", "mTaskSerialExecutor", "Lcom/obric/memorydata/task/scheduler/impl/TaskSerialExecutor;", "mRunnable", "currentActiveTask", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "<init>", "(Lcom/obric/memorydata/task/scheduler/impl/TaskSerialExecutor;Ljava/lang/Runnable;Ljava/util/concurrent/ConcurrentLinkedDeque;)V", "getMRunnable", "()Ljava/lang/Runnable;", "getEnqueueRunnable", "Lcom/obric/memorydata/task/scheduler/impl/EnqueueRunnable;", "run", "", "toString", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f12965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Runnable f12966b;
        private final ConcurrentLinkedDeque<a> c;

        public a(d r3, Runnable r4, ConcurrentLinkedDeque<a> r5) {
            Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "mTaskSerialExecutor");
            Intrinsics.checkNotNullParameter(r6, "mRunnable");
            Intrinsics.checkNotNullParameter(r5, "currentActiveTask");
            this.f12965a = r3;
            this.f12966b = r6;
            this.c = r5;
        }

        public final Runnable a() {
            return this.f12966b;
        }

        public final com.obric.memorydata.task.scheduler.impl.a b() {
            Runnable r2 = this.f12966b;
            if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.task.scheduler.impl.a.class) == true) goto L7;
            return null;
        L7:
            return (com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12966b.run();     // Catch: Throwable -> L5
            this.c.remove(this);
            this.f12965a.a();
            return;
        L5:
            th = move-exception;
            this.c.remove(this);
            this.f12965a.a();
            throw th;
        }

        public String toString() {
            if (ZeusTransformUtils.instanceOf(this.f12966b, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L7;
            return "runnable " + ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(this.f12966b, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a().getTaskParameter();
        L7:
            return super.toString();
        }
    }

    public d(Executor r4, boolean r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "delegatedExecutor");
        this.f12963a = r6;
        this.f12964b = r5;
        StringBuilder r0 = new StringBuilder().append("TaskSerialExecutor-");
        if (r5 == false) goto L5;
        String r7 = "high";
    L6:
        this.c = r0.append(r7).toString();
        this.d = new com.obric.memorydata.task.c();
        this.e = new Object();
        this.f = new ConcurrentLinkedDeque();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.util.concurrent.ThreadPoolExecutor");
        this.g = ((ThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r6, ThreadPoolExecutor.class, "com.obric.memorydata.plugin")).getCorePoolSize();
        h.f8481a.a((com.obric.memorydata.aikernelcore.d) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.aikernelcore.d.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r7 = "normal";
        goto L6
    }

    private static final void a(d r8, final String r9) {
        Object r0 = r8.e;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (((a) ZeusTransformUtils.preCheckCast(r8.d.c(new $$Lambda$d$4IrvtpUk_0az_qj9xwpIBsqAP7g(r9)), a.class, "com.obric.memorydata.plugin")) == null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r8.c, "schedule pending package task " + r9, false, 4, null);     // Catch: Throwable -> L10
        r8.a();     // Catch: Throwable -> L10
    L7:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    private final boolean a(final com.obric.memorydata.task.scheduler.impl.a r4) {
        if (this.d.b(new $$Lambda$d$9ANdkIH428FpislnVCgC2vAlMk(r4)) == false) goto L6;
        RunLog.INSTANCE.error(this.c, "duplicate task id: " + r4.a().getTaskParameter().getUuid(), new Throwable());
        Ensure.ensureNotReachHere(new Throwable(), "TaskSerialExecutor: duplicate task id");
        return false;
    L6:
        return true;
    }

    private static final boolean a(com.obric.memorydata.task.scheduler.impl.a r2, a r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (ZeusTransformUtils.instanceOf(r3.a(), com.obric.memorydata.task.scheduler.impl.a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r3.a(), com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a().getTaskParameter().getUuid().toString(), r2.a().getTaskParameter().getUuid().toString()) == false) goto L7;
        return true;
    }

    private static final boolean a(Runnable r3, a r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "it");
        if (ZeusTransformUtils.instanceOf(r4.a(), com.obric.memorydata.task.scheduler.impl.a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r4.a(), com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b(), ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b()) == false) goto L7;
        return true;
    }

    private static final boolean a(String r1, com.obric.memorydata.task.scheduler.impl.a r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (Intrinsics.areEqual(r2.c(), r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.a().getTaskInfo().c().isFinished() == true) goto L7;
        return true;
    }

    private static final boolean a(String r2, a r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (ZeusTransformUtils.instanceOf(r3.a(), com.obric.memorydata.task.scheduler.impl.a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r3.a(), com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).c(), r2) == false) goto L7;
        return true;
    }

    private static final boolean a(String r2, Function1 r3, a r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "it");
        Runnable r6 = r4.a();
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L5;
        com.obric.memorydata.task.scheduler.impl.a r7 = (com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 != null) goto L8;
    L12:
        return false;
    L8:
        if (Intrinsics.areEqual(r7.b(), r2) == false) goto L12;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(r7.a()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L12;
        return true;
    L5:
        r7 = null;
        goto L6
    }

    private final void b(Runnable r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug(this.c, "schedule next task " + r7);
        if (r7 != null) goto L5;
        return;
    L5:
        this.f.add((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin"));
        this.f12963a.execute(r7);
    }

    private static final boolean b(String r2, a r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (ZeusTransformUtils.instanceOf(r3.a(), com.obric.memorydata.task.scheduler.impl.a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r3.a(), com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).c(), r2) == false) goto L7;
        return true;
    }

    private static final boolean c(String r2, a r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (ZeusTransformUtils.instanceOf(r3.a(), com.obric.memorydata.task.scheduler.impl.a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r3.a(), com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).b(), r2) == false) goto L7;
        return true;
    }

    private final List<com.obric.memorydata.task.scheduler.impl.a> e(String r6) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L3:
        String r3 = null;
        if (r7.hasNext() == false) goto L11;
        Object r2 = r7.next();
        com.obric.memorydata.task.scheduler.impl.a r4 = ((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin")).b();
        if (r4 == null) goto L9;
        r3 = r4.b();
    L9:
        if (Intrinsics.areEqual(r3, r6) == false) goto L3;
        r0.add(r2);
        goto L3
    L11:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L13:
        if (r10.hasNext() == false) goto L21;
        Runnable r1 = ((a) ZeusTransformUtils.preCheckCast(r10.next(), a.class, "com.obric.memorydata.plugin")).a();
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L17;
        com.obric.memorydata.task.scheduler.impl.a r11 = (com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin");
    L18:
        if (r11 == null) goto L13;
        r9.add(r11);
        goto L13
    L17:
        r11 = null;
        goto L18
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ boolean lambda$4IrvtpUk_0az_qj9xwpIBsqAP7g(String r0, a r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ boolean lambda$97tFr9pbOqZiuQvyIDIYprHlt_k(String r0, a r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$9ANdk-IH428FpislnVCgC2vAlMk, reason: not valid java name */
    public static /* synthetic */ boolean m1200lambda$9ANdkIH428FpislnVCgC2vAlMk(com.obric.memorydata.task.scheduler.impl.a r0, a r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$L2zibwDkd9ahiK-yivlJDBDXp5E, reason: not valid java name */
    public static /* synthetic */ boolean m1201lambda$L2zibwDkd9ahiKyivlJDBDXp5E(String r0, com.obric.memorydata.task.scheduler.impl.a r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$atPoSmN7AtY8g_el6V1xQe8r7-E, reason: not valid java name */
    public static /* synthetic */ void m1202lambda$atPoSmN7AtY8g_el6V1xQe8r7E(d r0, String r1) {
        a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$ej7Vv4OVVzyzdvwsxsV2LNSUN_M(String r0, Function1 r1, a r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$qCdYrwBZOHQUPQ4gPpQMgQcLGUk(Runnable r0, a r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$r2aO6f0iekF3h2pegyGsw1wV9OQ(String r0, a r1) {
        return b(r0, r1);
    }

    public final void a() {
        if (this.f.size() < this.g) goto L6;
        RunLog.INSTANCE.debug(this.c, "thread pool is full, skip");
        return;
    L6:
        Object r0 = this.e;
        monitor-enter(r0);
        Runnable r1 = null;
        Stack r2 = new Stack();     // Catch: Throwable -> L44
        boolean r3 = false;
    L11:
        if (this.d.c() <= 0) goto L35;
        if (r3 == true) goto L35;
        a r5 = (a) ZeusTransformUtils.preCheckCast(this.d.a(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (r5 == null) goto L11;
        com.obric.memorydata.task.scheduler.impl.a r6 = r5.b();     // Catch: Throwable -> L44
        if (r6 == null) goto L11;
        ExistingTaskPolicy r7 = r6.a().getTaskParameter().getExistingTaskPolicy();     // Catch: Throwable -> L44
        if (r7 == null) goto L29;
        List<com.obric.memorydata.task.scheduler.impl.a> r8 = e(r6.b());     // Catch: Throwable -> L44
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L29;
        r2.push(r5);     // Catch: Throwable -> L44
        if (r7 != ExistingTaskPolicy.CANCEL_EXISTING) goto L11;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L44
    L26:
        if (r9.hasNext() == false) goto L11;
        ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a().cancel();     // Catch: Throwable -> L44
    L29:
        if (TaskRegister.f12863a.a(r6.b()) == false) goto L33;
        if (h.f8481a.a(r6.b(), this.f12964b) == true) goto L33;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.c, "package task waits for Papaya slot " + com.obric.memorydata.task.utils.d.a(r6.a()) + " highPriority=" + this.f12964b, false, 4, null);     // Catch: Throwable -> L44
        r2.push(r5);     // Catch: Throwable -> L44
    L33:
        r1 = (Runnable) ZeusTransformUtils.preCheckCast(r5, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        r3 = true;
    L35:
        if (r2.empty() == true) goto L37;
        RunLog.INSTANCE.debug(this.c, "add back task " + r2.peek());     // Catch: Throwable -> L44
        com.obric.memorydata.task.c<a> r4 = this.d;     // Catch: Throwable -> L44
        Object r10 = r2.pop();     // Catch: Throwable -> L44
        Intrinsics.checkNotNullExpressionValue(r10, "pop(...)");     // Catch: Throwable -> L44
        r4.b((a) r10);     // Catch: Throwable -> L44
        goto L35
    L37:
        if (r3 == false) goto L41;
        b(r1);     // Catch: Throwable -> L44
        monitor-exit(r0);
        return;
    L41:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L44
        monitor-exit(r0);
        return;
    L44:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.aikernelcore.d
    public void a(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "bizName");
        this.f12963a.execute(new $$Lambda$d$atPoSmN7AtY8g_el6V1xQe8r7E(this, r3));
    }

    public final void a(final String r3, Function1<? super AbsTaskRequest, Boolean> r4) {
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "retainPredicate");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.d.a(new $$Lambda$d$ej7Vv4OVVzyzdvwsxsV2LNSUN_M(r3, r5)), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        com.obric.memorydata.task.scheduler.impl.a r6 = ((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin")).b();
        if (r6 == null) goto L4;
        AbsTaskRequest r7 = r6.a();
        if (r7 == null) goto L4;
        r7.setCancelled();
        goto L4
    }

    public final boolean a(Runnable r3) {
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "command");
        Object r0 = this.e;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L7;
        boolean r2 = this.d.b(new $$Lambda$d$qCdYrwBZOHQUPQ4gPpQMgQcLGUk(r4));     // Catch: Throwable -> L12
        monitor-exit(r0);
        return r2;
    L7:
        monitor-exit(r0);
        return false;
    }

    public final boolean b(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        List<a> r5 = this.d.a(new $$Lambda$d$97tFr9pbOqZiuQvyIDIYprHlt_k(r4));
        RunLog.INSTANCE.debug(this.c, "removedTasks " + r5);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        com.obric.memorydata.task.scheduler.impl.a r1 = ((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin")).b();
        if (r1 == null) goto L4;
        AbsTaskRequest r2 = r1.a();
        if (r2 == null) goto L4;
        r2.setCancelled();
        goto L4
    L11:
        return !((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
    }

    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        com.obric.memorydata.task.scheduler.impl.a r0 = ((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin")).b();
        if (r0 == null) goto L8;
        String r2 = r0.b();
    L10:
        if (Intrinsics.areEqual(r2, r4) == false) goto L4;
        r0.a().setCancelled();
        goto L4
    L8:
        r2 = null;
        goto L10
    }

    public final boolean d(final String r6) {
        Intrinsics.checkNotNullParameter(r6, "taskId");
        Object r0 = this.e;
        monitor-enter(r0);
        List r1 = SequencesKt.toList(SequencesKt.map(SequencesKt.filter(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(TaskSerialExecutor$cancelActiveTaskId$targets$1$active$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), new $$Lambda$d$L2zibwDkd9ahiKyivlJDBDXp5E(r6)), (Function1) ZeusTransformUtils.preCheckCast(TaskSerialExecutor$cancelActiveTaskId$targets$1$active$3.INSTANCE, Function1.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L21
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.d.a(new $$Lambda$d$r2aO6f0iekF3h2pegyGsw1wV9OQ(r6)), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Iterator r8 = r5.iterator();     // Catch: Throwable -> L21
    L6:
        if (r8.hasNext() == false) goto L13;
        com.obric.memorydata.task.scheduler.impl.a r2 = ((a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin")).b();     // Catch: Throwable -> L21
        if (r2 == null) goto L10;
        AbsTaskRequest r3 = r2.a();     // Catch: Throwable -> L21
    L11:
        if (r3 == null) goto L6;
        r7.add(r3);     // Catch: Throwable -> L21
        goto L6
    L10:
        r3 = null;
        goto L11
    L13:
        List r9 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
        monitor-exit(r0);
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r10.hasNext() == false) goto L20;
        ((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r10.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).setCancelled();
        goto L17
    L20:
        return !((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
    L21:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "command");
        Object r0 = this.e;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (ZeusTransformUtils.instanceOf(r7, com.obric.memorydata.task.scheduler.impl.a.class) == false) goto L9;
        int r1 = ((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")).a().getTaskParameter().getPriority();     // Catch: Throwable -> L13
        if (a((com.obric.memorydata.task.scheduler.impl.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.task.scheduler.impl.a.class, "com.obric.memorydata.plugin")) == false) goto L10;
        this.d.a(r1, new a(this, r7, this.f));     // Catch: Throwable -> L13
    L10:
        a();     // Catch: Throwable -> L13
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L9:
        this.d.a(new a(this, r7, this.f));     // Catch: Throwable -> L13
        goto L10
    }
}
