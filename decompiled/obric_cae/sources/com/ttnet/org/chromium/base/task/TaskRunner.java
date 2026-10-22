package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes2.dex */
public interface TaskRunner {
    void destroy();

    void disableLifetimeCheck();

    void initNativeTaskRunner();

    void postDelayedTask(Runnable r8, long r10);

    void postTask(Runnable r8);
}
