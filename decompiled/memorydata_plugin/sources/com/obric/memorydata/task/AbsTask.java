package com.obric.memorydata.task;

import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskParameter;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\u001bH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/task/AbsTask;", "Lcom/obric/memorydata/task/ITask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "getTaskRequest", "()Lcom/obric/memorydata/task/AbsTaskRequest;", "taskParameter", "Lcom/obric/memorydata/task/impl/TaskParameter;", "getTaskParameter", "()Lcom/obric/memorydata/task/impl/TaskParameter;", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "getTaskInfo", "()Lcom/obric/memorydata/task/impl/TaskInfo;", "isUsed", "", "()Z", "setUsed", "(Z)V", "isCancelled", "isTaskInvalid", "setCancelled", "", "execute", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsTask implements ITask {
    private boolean isUsed;
    private final TaskInfo taskInfo;
    private final TaskParameter taskParameter;
    private final AbsTaskRequest taskRequest;

    public AbsTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        this.taskRequest = r2;
        this.taskParameter = r2.getTaskParameter();
        TaskInfo r3 = r2.getTaskInfo();
        this.taskInfo = r3;
        r3.a(0);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.obric.memorydata.task.impl.TaskResult] */
    private static final Unit execute$lambda$0(Ref.ObjectRef r2, AbsTask r3, Ref.LongRef r4) {
        long r0 = System.currentTimeMillis();
        r2.element = r3.run();
        r4.element = System.currentTimeMillis() - r0;
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$6zsLEbH8Z-HYnv1t77-R1PPMblk, reason: not valid java name */
    public static /* synthetic */ Unit m1185lambda$6zsLEbH8ZHYnv1t77R1PPMblk(Ref.ObjectRef r0, AbsTask r1, Ref.LongRef r2) {
        return execute$lambda$0(r0, r1, r2);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [T, com.obric.memorydata.task.impl.TaskResult] */
    @Override // com.obric.memorydata.task.ITask
    public TaskInfo execute() {
        if (isCancelled() == true) goto L5;
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        final Ref.LongRef r2 = new Ref.LongRef();
        e.d r3 = e.f12914a.a(this.taskRequest);
    L20:
        th = move-exception;
        com.obric.memorydata.task.scheduler.b r4 = com.obric.memorydata.task.scheduler.impl.c.f12961a.d();
        String r8 = this.taskParameter.getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
        r4.g(r8);
        e.f12914a.a(r3);
        throw th;
    L8:
        if (this.taskParameter.getExistingTaskPolicy() == null) goto L10;
        d.f12912a.a(this.taskParameter.getName(), new $$Lambda$AbsTask$6zsLEbH8ZHYnv1t77R1PPMblk(r1, this, r2));     // Catch: Throwable -> L20
    L11:
        com.obric.memorydata.task.scheduler.b r5 = com.obric.memorydata.task.scheduler.impl.c.f12961a.d();
        String r6 = this.taskParameter.getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        r5.g(r6);
        e.f12914a.a(r3);
        if (isTaskInvalid() == true) goto L14;
        TaskResult r0 = (TaskResult) ZeusTransformUtils.preCheckCast(r1.element, TaskResult.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L19;
        this.taskInfo.a(r0);
        this.taskInfo.b(r2.element);
        this.taskInfo.a(r0.getOutput());
    L19:
        return this.taskInfo;
    L14:
        return this.taskInfo;
    L10:
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L20
        r1.element = run();     // Catch: Throwable -> L20
        r2.element = System.currentTimeMillis() - r7;     // Catch: Throwable -> L20
        goto L11
    L5:
        return this.taskInfo;
    }

    public final TaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public final TaskParameter getTaskParameter() {
        return this.taskParameter;
    }

    public final AbsTaskRequest getTaskRequest() {
        return this.taskRequest;
    }

    public final boolean isCancelled() {
        return this.taskRequest.isCancelled();
    }

    public final boolean isTaskInvalid() {
        return this.taskRequest.isInvalid();
    }

    public final boolean isUsed() {
        return this.isUsed;
    }

    public abstract TaskResult run();

    public final void setCancelled() {
        this.taskRequest.setCancelled();
    }

    public final void setUsed(boolean r1) {
        this.isUsed = r1;
    }
}
