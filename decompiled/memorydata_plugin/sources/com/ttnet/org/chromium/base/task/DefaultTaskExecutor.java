package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
class DefaultTaskExecutor implements TaskExecutor {
    private final Map<TaskTraits, TaskRunner> mTraitsToRunnerMap;

    DefaultTaskExecutor() {
        this.mTraitsToRunnerMap = new HashMap();
    }

    private synchronized ChoreographerTaskRunner createChoreographerTaskRunner() {
        monitor-enter(this);
        ChoreographerTaskRunner r0 = (ChoreographerTaskRunner) ZeusTransformUtils.preCheckCast(ThreadUtils.runOnUiThreadBlockingNoException($$Lambda$DefaultTaskExecutor$7gYUTBu98Awmvc8kVKoOR54waiQ.INSTANCE), ChoreographerTaskRunner.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ ChoreographerTaskRunner lambda$createChoreographerTaskRunner$0() {
        return new ChoreographerTaskRunner(Choreographer.getInstance());
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public boolean canRunTaskImmediately(TaskTraits r1) {
        return false;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SequencedTaskRunner createSequencedTaskRunner(TaskTraits r2) {
        if (r2.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new SequencedTaskRunnerImpl(r2);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r2) {
        if (r2.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new SingleThreadTaskRunnerImpl(null, r2);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public TaskRunner createTaskRunner(TaskTraits r2) {
        if (r2.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new TaskRunnerImpl(r2);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public synchronized void postDelayedTask(TaskTraits r4, Runnable r5, long r6) {
        monitor-enter(this);
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r4.hasExtension() == false) goto L6;
        createTaskRunner(r4).postDelayedTask(r7, r6);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        TaskRunner r0 = (TaskRunner) ZeusTransformUtils.preCheckCast(this.mTraitsToRunnerMap.get(r4), TaskRunner.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r0 != null) goto L9;
        r0 = createTaskRunner(r4);     // Catch: Throwable -> L12
        this.mTraitsToRunnerMap.put(r4, r0);     // Catch: Throwable -> L12
    L9:
        r0.postDelayedTask(r7, r6);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
