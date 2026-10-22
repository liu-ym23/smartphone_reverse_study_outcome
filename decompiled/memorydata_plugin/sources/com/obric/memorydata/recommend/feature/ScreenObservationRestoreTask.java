package com.obric.memorydata.recommend.feature;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.tile.LiveCardUtil;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.task.impl.c;
import com.obric.memorydata.task.impl.g;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/recommend/feature/ScreenObservationRestoreTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationRestoreTask extends NativeTask {
    public static final a Companion = null;
    private static final String TAG = "ScreenObservationRestoreTask";
    public static final String TASK_NAME = "ScreenObservationRestoreTask";
    private static TaskRequest restoreTask;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/recommend/feature/ScreenObservationRestoreTask$Companion;", "", "<init>", "()V", "TAG", "", "TASK_NAME", "restoreTask", "Lcom/obric/memorydata/task/impl/TaskRequest;", "scheduleRestore", "", "delayMillisTime", "", "cancelIfNeed", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a() {
            TaskRequest r0 = ScreenObservationRestoreTask.access$getRestoreTask$cp();
            if (r0 == null) goto L6;
            r0.cancel();
            return;
        }

        public final void a(long r9) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationRestoreTask", "scheduleRestore, delayMillisTime: " + r9, false, 4, null);
            TaskRequest r8 = ScreenObservationRestoreTask.access$getRestoreTask$cp();
            if (r8 == null) goto L5;
            r8.cancel();
        L5:
            ScreenObservationRestoreTask.access$setRestoreTask$cp((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("ScreenObservationRestoreTask").setDelay((g) ZeusTransformUtils.preCheckCast(new c(r9), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTriggerExactly(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin"));
            TaskRequest r10 = ScreenObservationRestoreTask.access$getRestoreTask$cp();
            if (r10 == null) goto L9;
            r10.enqueue();
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    public ScreenObservationRestoreTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    public static final /* synthetic */ TaskRequest access$getRestoreTask$cp() {
        return restoreTask;
    }

    public static final /* synthetic */ void access$setRestoreTask$cp(TaskRequest r0) {
        restoreTask = r0;
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationRestoreTask", "run Task", false, 4, null);
        com.obric.memorydata.recommend.feature.a.f12505a.c();
        LiveCardUtil.f12634a.a();
        return new TaskResult(0, null, null, null, 14, null);
    }
}
