package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes2.dex */
public interface TaskExecutor {
    boolean canRunTaskImmediately(TaskTraits r8);

    SequencedTaskRunner createSequencedTaskRunner(TaskTraits r8);

    SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r8);

    TaskRunner createTaskRunner(TaskTraits r8);

    void postDelayedTask(TaskTraits r8, Runnable r10, long r11);
}
