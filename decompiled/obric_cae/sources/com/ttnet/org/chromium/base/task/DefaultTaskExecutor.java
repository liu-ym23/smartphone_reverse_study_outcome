package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;
import com.ttnet.org.chromium.base.ThreadUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class DefaultTaskExecutor implements TaskExecutor {
    private final Map<TaskTraits, TaskRunner> mTraitsToRunnerMap;

    public DefaultTaskExecutor() {
        this.mTraitsToRunnerMap = new HashMap();
    }

    public static /* synthetic */ ChoreographerTaskRunner a() {
        return lambda$createChoreographerTaskRunner$0();
    }

    private synchronized ChoreographerTaskRunner createChoreographerTaskRunner() {
        monitor-enter(this);
        ChoreographerTaskRunner r8 = (ChoreographerTaskRunner) ThreadUtils.runOnUiThreadBlockingNoException(new b());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ ChoreographerTaskRunner lambda$createChoreographerTaskRunner$0() {
        return new ChoreographerTaskRunner(Choreographer.getInstance());
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public boolean canRunTaskImmediately(TaskTraits r8) {
        return false;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SequencedTaskRunner createSequencedTaskRunner(TaskTraits r8) {
        if (r8.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new SequencedTaskRunnerImpl(r8);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r8) {
        if (r8.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new SingleThreadTaskRunnerImpl(null, r8);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public TaskRunner createTaskRunner(TaskTraits r8) {
        if (r8.mIsChoreographerFrame == false) goto L7;
        return createChoreographerTaskRunner();
    L7:
        return new TaskRunnerImpl(r8);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public synchronized void postDelayedTask(TaskTraits r8, Runnable r10, long r11) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (r8.hasExtension() == false) goto L6;
        TaskRunner r12 = createTaskRunner(r8);     // Catch: Throwable -> L12
        r12.postDelayedTask(r10, r11);     // Catch: Throwable -> L12
        r12.destroy();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        TaskRunner r13 = this.mTraitsToRunnerMap.get(r8);     // Catch: Throwable -> L12
        if (r13 != null) goto L9;
        r13 = createTaskRunner(r8);     // Catch: Throwable -> L12
        r13.disableLifetimeCheck();     // Catch: Throwable -> L12
        this.mTraitsToRunnerMap.put(r8, r13);     // Catch: Throwable -> L12
    L9:
        r13.postDelayedTask(r10, r11);     // Catch: Throwable -> L12
        goto L10
    }
}
