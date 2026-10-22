package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;
import com.ttnet.org.chromium.base.ThreadUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class DefaultTaskExecutor implements TaskExecutor {
    private final Map<TaskTraits, TaskRunner> mTraitsToRunnerMap;

    DefaultTaskExecutor() {
        this.mTraitsToRunnerMap = new HashMap();
    }

    public static /* synthetic */ ChoreographerTaskRunner a() {
        return lambda$createChoreographerTaskRunner$0();
    }

    private synchronized ChoreographerTaskRunner createChoreographerTaskRunner() {
        monitor-enter(this);
        ChoreographerTaskRunner r10 = (ChoreographerTaskRunner) ThreadUtils.runOnUiThreadBlockingNoException(e.f8430c);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ ChoreographerTaskRunner lambda$createChoreographerTaskRunner$0() {
        return new ChoreographerTaskRunner(Choreographer.getInstance());
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public boolean canRunTaskImmediately(TaskTraits r10) {
        return false;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SequencedTaskRunner createSequencedTaskRunner(TaskTraits r10) {
        if (r10.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new SequencedTaskRunnerImpl(r10);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r10) {
        if (r10.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new SingleThreadTaskRunnerImpl(null, r10);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public TaskRunner createTaskRunner(TaskTraits r10) {
        if (r10.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new TaskRunnerImpl(r10);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public synchronized void postDelayedTask(TaskTraits r10, Runnable r11, long r12) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (r10.hasExtension() == false) goto L6;
        createTaskRunner(r10).postDelayedTask(r11, r12);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        TaskRunner r13 = this.mTraitsToRunnerMap.get(r10);     // Catch: Throwable -> L12
        if (r13 != null) goto L9;
        r13 = createTaskRunner(r10);     // Catch: Throwable -> L12
        this.mTraitsToRunnerMap.put(r10, r13);     // Catch: Throwable -> L12
    L9:
        r13.postDelayedTask(r11, r12);     // Catch: Throwable -> L12
        goto L10
    }
}
