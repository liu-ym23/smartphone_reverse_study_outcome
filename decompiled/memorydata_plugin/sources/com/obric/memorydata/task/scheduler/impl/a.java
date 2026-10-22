package com.obric.memorydata.task.scheduler.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.task.impl.e;
import com.obric.memorydata.task.impl.g;
import com.obric.memorydata.task.impl.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/task/scheduler/impl/EnqueueRunnable;", "Ljava/lang/Runnable;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "getTaskRequest", "()Lcom/obric/memorydata/task/AbsTaskRequest;", ActivityLifecycle.NAME, "", "getName", "()Ljava/lang/String;", "taskId", "getTaskId", "handler", "Landroid/os/Handler;", "taskWrapper", "Lcom/obric/memorydata/task/impl/TaskWrapper;", "run", "", "getTaskResult", "Lcom/obric/memorydata/task/impl/TaskResult;", "handleTaskResult", Ext.KEY_REQUEST, "result", "Lcom/obric/memorydata/task/impl/TaskInfo;", "repeatExecuteCurrentTaskIfNeed", "scheduleHandler", "Companion", "EnqueueIntervalRunnable", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0708a f12955a = null;
    private static final com.obric.memorydata.task.impl.d g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AbsTaskRequest f12956b;
    private final String c;
    private final String d;
    private final Handler e;
    private final h f;

    /* JADX INFO: renamed from: com.obric.memorydata.task.scheduler.impl.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/task/scheduler/impl/EnqueueRunnable$Companion;", "", "<init>", "()V", "TAG", "", "INTERVAL_TIME", "Lcom/obric/memorydata/task/impl/MinuteTimeUnit;", "getINTERVAL_TIME", "()Lcom/obric/memorydata/task/impl/MinuteTimeUnit;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0708a {
        private C0708a() {
        }

        public /* synthetic */ C0708a(DefaultConstructorMarker r1) {
            this();
        }

        public final com.obric.memorydata.task.impl.d a() {
            return a.e();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/task/scheduler/impl/EnqueueRunnable$EnqueueIntervalRunnable;", "Ljava/lang/Runnable;", Api.KEY_UUID, "", "<init>", "(Ljava/lang/String;)V", "run", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12957a;

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, Api.KEY_UUID);
            this.f12957a = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair r0 = (Pair) ZeusTransformUtils.preCheckCast(c.f12961a.a().remove(this.f12957a), Pair.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EnqueueRunnable", "interval trigger ignored because task is missing taskId=" + this.f12957a, false, 4, null);
            return;
        L6:
            AbsTaskRequest r1 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(r0.getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EnqueueRunnable", "interval trigger received taskId=" + this.f12957a + ' ' + com.obric.memorydata.task.utils.d.a(r1), false, 4, null);
            c.f12961a.d().b(r1);
        }
    }

    static {
        f12955a = new C0708a(null);
        g = new com.obric.memorydata.task.impl.d(5);
    }

    public a(AbsTaskRequest r3) {
        Intrinsics.checkNotNullParameter(r3, "taskRequest");
        this.f12956b = r3;
        this.c = r3.getTaskParameter().getName();
        String r0 = r3.getTaskParameter().getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        this.d = r0;
        this.e = new Handler(Looper.getMainLooper());
        this.f = new h(r3);
    }

    private final void a(AbsTaskRequest r13) {
        if (r13.getTaskParameter().getInterval().a() != 0) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r13.getTaskParameter().getInputParams().optString("trigger_source"), CommonConsts.TIMER_TYPE) == true) goto L7;
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EnqueueRunnable", "enqueue interval post: " + r13, false, 4, null);
        r13.getTaskParameter().setDelay((g) ZeusTransformUtils.preCheckCast(new e(), g.class, "com.obric.memorydata.plugin"));
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.PowerManager");
        boolean r1 = ((PowerManager) ZeusTransformUtils.preCheckCast(r0, PowerManager.class, "com.obric.memorydata.plugin")).isDeviceIdleMode();
        long r2 = r13.getTaskParameter().getInterval().b().toMillis(r13.getTaskParameter().getInterval().a());
        com.obric.memorydata.task.impl.d r4 = g;
        if (r2 >= r4.b().toMillis(r4.a())) goto L18;
        if (r1 == true) goto L18;
        if (r13.getTaskParameter().getTriggerExactly() == true) goto L18;
        b(r13);
        return;
    L18:
        com.obric.memorydata.task.utils.b.a(com.obric.memorydata.task.utils.b.f12969a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13, System.currentTimeMillis() + r13.getTaskParameter().getInterval().b().toMillis(r13.getTaskParameter().getInterval().a()), false, false, 24, null);
        return;
    L7:
        if (AwarenessManager.INSTANCE.isPackageAutoTriggerEnabled(r13.getTaskParameter().getName()) == true) goto L12;
        o r3 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r7 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L20;
        com.obric.memorydata.middleware.api.logging.g r5 = new com.obric.memorydata.middleware.api.logging.g();
        r5.a("package_name", r13.getTaskParameter().getName());
        Unit r6 = Unit.INSTANCE;
        r3.a("Timer 自动触发续期已取消", r7, r5.a());
        return;
    }

    private final void a(AbsTaskRequest r13, TaskInfo r14) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EnqueueRunnable", "handleTaskResult request: " + r13 + " result: " + r14, false, 4, null);
        if (r14 == null) goto L7;
        TaskResult r12 = r14.e();
        if (r12 == null) goto L7;
        List<AbsTaskRequest> r15 = r12.getNextTaskRequestList();
    L8:
        if (r15 == null) goto L20;
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r16.hasNext() == false) goto L20;
        AbsTaskRequest r0 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(r16.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin");
        r0.setParentTaskRequest(r13);
        if (r0.getTaskParameter().getDelay().a() != 0) goto L16;
        r0.getTaskParameter().setSync(r13.getTaskParameter().getSync());
    L16:
        if (r13.getTaskParameter().getOnTaskInfoCallBack() == null) goto L11;
        if (r0.getTaskParameter().getOnTaskInfoCallBack() != null) goto L11;
        r0.getTaskParameter().setOnTaskInfoCallBack(r13.getTaskParameter().getOnTaskInfoCallBack());
    L20:
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L23;
    L26:
        boolean r18 = true;
    L27:
        if (r18 == false) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EnqueueRunnable", "Task Execution has been finished : " + r13, false, 4, null);
        return;
    L30:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EnqueueRunnable", "enqueue next tasks count=" + r15.size() + " parent=" + com.obric.memorydata.task.utils.d.a(r13) + " children=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$a$KFj_hCba5FgjuSxVjR6CLn6j19Y.INSTANCE, 31, null), false, 4, null);
        c.f12961a.d().a(r15);
        return;
    L23:
        if (r17.isEmpty() == true) goto L26;
        r18 = false;
    L7:
        r15 = null;
        goto L8
    }

    private final void b(AbsTaskRequest r8) {
        String r0 = r8.getTaskParameter().getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        ((Map) ZeusTransformUtils.preCheckCast(c.f12961a.a(), Map.class, "com.obric.memorydata.plugin")).put(r0, new Pair(r8, null));
        if (Intrinsics.areEqual(r8.getTaskParameter().getInputParams().optString("trigger_source"), CommonConsts.TIMER_TYPE) == true) goto L5;
    L10:
        this.e.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(new b(r0), Runnable.class, "com.obric.memorydata.plugin"), r8.getTaskParameter().getInterval().b().toMillis(r8.getTaskParameter().getInterval().a()));
        return;
    L5:
        if (AwarenessManager.INSTANCE.isPackageAutoTriggerEnabled(r8.getTaskParameter().getName()) == true) goto L10;
        c.f12961a.a().remove(r0);
        o r7 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r6 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L12;
        com.obric.memorydata.middleware.api.logging.g r1 = new com.obric.memorydata.middleware.api.logging.g();
        r1.a("package_name", r8.getTaskParameter().getName());
        Unit r9 = Unit.INSTANCE;
        r7.a("Timer 自动触发载体已撤销", r6, r1.a());
        return;
    }

    private static final CharSequence c(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.utils.d.a(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ com.obric.memorydata.task.impl.d e() {
        return g;
    }

    public static /* synthetic */ CharSequence lambda$KFj_hCba5FgjuSxVjR6CLn6j19Y(AbsTaskRequest r0) {
        return c(r0);
    }

    public final AbsTaskRequest a() {
        return this.f12956b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final TaskResult d() {
        TaskInfo r0 = this.f.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e();
    }

    @Override // java.lang.Runnable
    public void run() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EnqueueRunnable", "run " + Thread.currentThread().getName() + ' ' + this.f12956b, false, 4, null);
        if (this.f12956b.getTaskParameter().getSync() == true) goto L8;
        com.obric.memorydata.task.scheduler.b r0 = c.f12961a.d();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.memorydata.task.scheduler.impl.TaskManager");
        if (((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin")).d(this.f12956b) == true) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EnqueueRunnable", "task pending for unsatisfied conditions " + com.obric.memorydata.task.utils.d.a(this.f12956b), false, 4, null);
        return;
    L8:
        a(this.f12956b);
        this.f.run();
        a(this.f12956b, this.f.a());
    }
}
