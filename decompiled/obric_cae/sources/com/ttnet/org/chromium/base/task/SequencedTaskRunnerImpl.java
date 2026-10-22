package com.ttnet.org.chromium.base.task;

import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import s1.x;

/* JADX INFO: loaded from: classes2.dex */
public class SequencedTaskRunnerImpl extends TaskRunnerImpl implements SequencedTaskRunner {

    @GuardedBy("mLock")
    private int mNumUnfinishedNativeTasks;
    private AtomicInteger mPendingTasks;

    public SequencedTaskRunnerImpl(TaskTraits r8) {
        super(r8, "SequencedTaskRunnerImpl", 1);
        this.mPendingTasks = new AtomicInteger();
        disableLifetimeCheck();
    }

    public static /* synthetic */ void a(SequencedTaskRunnerImpl r8, Runnable r10) {
        r8.lambda$postDelayedTaskToNative$0(r10);
    }

    private /* synthetic */ void lambda$postDelayedTaskToNative$0(Runnable r8) {
        r8.run();
        Object r10 = this.mLock;
        monitor-enter(r10);
        int r11 = this.mNumUnfinishedNativeTasks - 1;     // Catch: Throwable -> L9
        this.mNumUnfinishedNativeTasks = r11;     // Catch: Throwable -> L9
        if (r11 != 0) goto L7;
        destroyInternal();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl, com.ttnet.org.chromium.base.task.TaskRunner
    public void initNativeTaskRunner() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        migratePreNativeTasksToNative();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl
    public void postDelayedTaskToNative(Runnable r8, long r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        int r12 = this.mNumUnfinishedNativeTasks;     // Catch: Throwable -> L10
        this.mNumUnfinishedNativeTasks = r12 + 1;     // Catch: Throwable -> L10
        if (r12 != 0) goto L7;
        initNativeTaskRunnerInternal();     // Catch: Throwable -> L10
    L7:
        super.postDelayedTaskToNative(new x(12, this, r8), r10);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl
    public void runPreNativeTask() {
        super.runPreNativeTask();
        if (this.mPendingTasks.decrementAndGet() <= 0) goto L6;
        super.schedulePreNativeTask();
        return;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl
    public void schedulePreNativeTask() {
        if (this.mPendingTasks.getAndIncrement() != 0) goto L6;
        super.schedulePreNativeTask();
        return;
    }
}
