package com.ttnet.org.chromium.base.task;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
class SerialExecutor implements Executor {
    Runnable mActive;
    final ArrayDeque<Runnable> mTasks;

    SerialExecutor() {
        this.mTasks = new ArrayDeque();
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable r3) {
        monitor-enter(this);
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        this.mTasks.offer(new AnonymousClass1(this, r4));     // Catch: Throwable -> L8
        if (this.mActive != null) goto L6;
        scheduleNext();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void scheduleNext() {
        monitor-enter(this);
        Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(this.mTasks.poll(), Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        this.mActive = r0;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(this.mActive);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
