package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes2.dex */
public interface TaskExecutor {
    boolean canRunTaskImmediately(TaskTraits r10);

    SequencedTaskRunner createSequencedTaskRunner(TaskTraits r10);

    SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r10);

    TaskRunner createTaskRunner(TaskTraits r10);

    void postDelayedTask(TaskTraits r10, Runnable r11, long r12);
}
