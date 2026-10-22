package com.obric.memorydata.task.impl;

import com.bytedance.crash.Ensure;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTask;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.TaskRegister;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/task/impl/TaskWrapper;", "Ljava/lang/Runnable;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "task", "Lcom/obric/memorydata/task/AbsTask;", "getTaskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "run", "", "runRealTask", "retry", "", "buildRealTask", "onTaskExecute", "beforeTaskExecute", "onTaskFinished", "printTaskDetailInfo", "stage", "", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12935a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AbsTaskRequest f12936b;
    private AbsTask c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/task/impl/TaskWrapper$Companion;", "", "<init>", "()V", "TAG", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12935a = new a(null);
    }

    public h(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        this.f12936b = r2;
    }

    static /* synthetic */ void a(h r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.a(r1);
    }

    private final void a(String r8) {
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder().append(r8).append(" task ");
        AbsTask r0 = this.c;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        StringBuilder r10 = r9.append(r2).append(" ,taskinfo ");
        AbsTask r3 = this.c;
        TaskInfo r4 = null;
        if (r3 == null) goto L11;
        TaskInfo r5 = r3.getTaskInfo();
        if (r5 == null) goto L11;
        Integer r6 = Integer.valueOf(r5.hashCode());
    L12:
        StringBuilder r11 = r10.append(r6).append(" ,taskRequest ").append(this.f12936b.hashCode()).append(",taskInfo detail ");
        AbsTask r7 = this.c;
        if (r7 == null) goto L15;
        r4 = r7.getTaskInfo();
    L15:
        IRunLog.a.a(r1, "TaskWrapper", r11.append(r4).append(",onTaskInfoCallBack ").append(this.f12936b.getTaskParameter().getOnTaskInfoCallBack()).toString(), false, 4, null);
        return;
    L11:
        r6 = null;
        goto L12
    L5:
        r2 = 0;
        goto L6
    }

    private final void a(boolean r6) {
        if (r6 == true) goto L5;
        this.c = b();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        RunLog.INSTANCE.error("TaskWrapper", "execute error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        TaskInfo r5 = a();
        if (r5 == null) goto L17;
        r5.e().setCode(TaskResult.EXCEPTION);
        r5.e().setMsg(ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
    L17:
        if (AppContext.INSTANCE.isDebug() == true) goto L19;
    L22:
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(e, TaskRegister.TaskNotFoundException.class) == true) goto L22;
        throw e;
    L5:
        if (this.c == null) goto L11;
        if (this.f12936b.isCancelled() == false) goto L9;
        return;
    L9:
        d();     // Catch: Exception -> L12
        c();     // Catch: Exception -> L12
        e();     // Catch: Exception -> L12
        return;
    L11:
        throw new TaskRegister.TaskNotFoundException(this.f12936b.getTaskParameter().getName() + " build failed, please check its registration");     // Catch: Exception -> L12
    }

    private final AbsTask b() {
        Object r0 = TaskRegister.f12863a.b(this.f12936b.getTaskParameter().getName());
        this.f12936b.getTaskParameter().getName();
        if (Result.m1427isFailureimpl(r0) == false) goto L6;
        return null;
    L6:
        if (Result.m1427isFailureimpl(r0) == false) goto L8;
        Object r1 = null;
    L9:
        if (r1 != null) goto L12;
        return null;
    L12:
        if (Result.m1427isFailureimpl(r0) == false) goto L14;
        r0 = null;
    L14:
        Intrinsics.checkNotNull(r0);
        AbsTask r7 = (AbsTask) ZeusTransformUtils.preCheckCast(((Class) ZeusTransformUtils.preCheckCast(r0, Class.class, "com.obric.memorydata.plugin")).getConstructor(new Class[]{AbsTaskRequest.class}).newInstance(new Object[]{this.f12936b}), AbsTask.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L17;
    L20:
        return null;
    L17:
        if (r7.isUsed() == true) goto L20;
        return r7;
    L8:
        r1 = r0;
        goto L9
    }

    private final void c() {
        AbsTask r0 = this.c;
        Intrinsics.checkNotNull(r0);
        r0.execute();
        AbsTask r1 = this.c;
        Intrinsics.checkNotNull(r1);
        r1.setUsed(true);
        a("onTaskExecute");
    }

    private final void d() {
        AbsTask r0 = this.c;
        if (r0 == null) goto L5;
        TaskInfo r1 = r0.getTaskInfo();
    L6:
        if (r1 == null) goto L17;
        r1.a(TaskInfo.State.RUNNING);
        r1.a(this.f12936b.getTaskParameter().getExecuteImmediately());
        if (r1.j() == 0) goto L10;
    L13:
        com.obric.memorydata.task.scheduler.c r2 = this.f12936b.getTaskParameter().getOnTaskInfoCallBack();
        if (r2 == null) goto L16;
        r2.a(r1);
    L16:
        com.obric.memorydata.task.utils.c.f12971a.b(r1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskWrapper", "task start " + com.obric.memorydata.task.utils.d.a(this.f12936b) + " waitQueueMs=" + r1.j(), false, 4, null);
        goto L17
    L10:
        if (this.f12936b.getTaskParameter().getInterval().a() == 0) goto L12;
        r1.c(-1);
        goto L13
    L12:
        TaskParameter r3 = this.f12936b.getTaskParameter();
        r1.c((System.currentTimeMillis() - r3.getTaskEnqueueTime()) - r3.getDelay().b().toMillis(r3.getDelay().a()));
    L17:
        a("beforeTaskExecute");
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void e() {
        a("onTaskFinished");
        AbsTask r0 = this.c;
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.isTaskInvalid() != true) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskWrapper", "task already invalid, skip result handling " + com.obric.memorydata.task.utils.d.a(this.f12936b), false, 4, null);
        return;
    L12:
        if (this.c != null) goto L14;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskWrapper", "onTaskFinished task is null", null, 4, null);
    L14:
        AbsTask r2 = this.c;
        String r3 = null;
        if (r2 == null) goto L17;
        TaskInfo r4 = r2.getTaskInfo();
    L18:
        if (r4 != null) goto L20;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskWrapper", "onTaskFinished taskinfo is null", null, 4, null);
    L20:
        AbsTask r5 = this.c;
        if (r5 == null) goto L26;
        TaskInfo r6 = r5.getTaskInfo();
        if (r6 == null) goto L26;
        r3 = r6.b();
    L26:
        if (Intrinsics.areEqual(r3, this.f12936b.getTaskParameter().getName()) == true) goto L28;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskWrapper", "onTaskFinished task info name not equals task request name", null, 4, null);
    L28:
        AbsTask r7 = this.c;
        if (r7 == null) goto L49;
        TaskInfo r8 = r7.getTaskInfo();
        if (r8 != null) goto L33;
        return;
    L33:
        if (r8.e().getCode() != 0) goto L35;
        TaskInfo.State r9 = TaskInfo.State.SUCCEEDED;
    L36:
        r8.a(r9);
        if (r8.c() != TaskInfo.State.FAILED) goto L44;
        AbsTask r10 = this.c;
        Intrinsics.checkNotNull(r10);
        if (r10.getTaskParameter().getAutoRetryMaxTimes() == 0) goto L44;
        int r11 = r8.g();
        AbsTask r12 = this.c;
        Intrinsics.checkNotNull(r12);
        if (r11 >= r12.getTaskParameter().getAutoRetryMaxTimes()) goto L44;
        IRunLog r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r14 = new StringBuilder().append("onTaskFinished retry ").append(com.obric.memorydata.task.utils.d.a(r8)).append(" maxRetry=");
        AbsTask r15 = this.c;
        Intrinsics.checkNotNull(r15);
        IRunLog.a.a(r13, "TaskWrapper", r14.append(r15.getTaskParameter().getAutoRetryMaxTimes()).toString(), false, 4, null);
        AbsTask r16 = this.c;
        Intrinsics.checkNotNull(r16);
        TaskInfo r17 = r16.getTaskInfo();
        r17.a(r17.g() + 1);
        a(true);
        return;
    L44:
        com.obric.memorydata.task.scheduler.c r18 = this.f12936b.getTaskParameter().getOnTaskInfoCallBack();
        if (r18 == null) goto L47;
        r18.a(r8);
    L47:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskWrapper", "onTaskFinished " + com.obric.memorydata.task.utils.d.a(r8), false, 4, null);
        return;
    L35:
        r9 = TaskInfo.State.FAILED;
        goto L36
    L49:
        return;
    L17:
        r4 = null;
        goto L18
    }

    public final TaskInfo a() {
        AbsTask r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTaskInfo();
    }

    @Override // java.lang.Runnable
    public void run() {
        long r0 = System.currentTimeMillis();
        a(this, false, 1, null);
        long r2 = System.currentTimeMillis() - r0;
        TaskInfo r5 = a();
        if (r5 == null) goto L6;
        r5.a(r2);
        com.obric.memorydata.task.utils.c.f12971a.a(r5);
        return;
    }
}
