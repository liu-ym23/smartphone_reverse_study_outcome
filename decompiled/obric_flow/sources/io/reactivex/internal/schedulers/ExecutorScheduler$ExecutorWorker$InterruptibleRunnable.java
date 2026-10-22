package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ExecutorScheduler$ExecutorWorker$InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {
    static final int FINISHED = 2;
    static final int INTERRUPTED = 4;
    static final int INTERRUPTING = 3;
    static final int READY = 0;
    static final int RUNNING = 1;
    private static final long serialVersionUID = -3603436687413320876L;
    final Runnable run;
    final qt.a tasks;
    volatile Thread thread;

    public ExecutorScheduler$ExecutorWorker$InterruptibleRunnable(Runnable r5, qt.a r10) {
        this.run = r5;
        this.tasks = r10;
    }

    public void cleanup() {
        qt.a r5 = this.tasks;
        if (r5 == null) goto L6;
        r5.c(this);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    L2:
        int r5 = get();
        if (r5 >= 2) goto L26;
        if (r5 == 0) goto L8;
        if (compareAndSet(1, 3) == false) goto L2;
        Thread r10 = this.thread;
        if (r10 == null) goto L15;
        r10.interrupt();
        this.thread = null;
    L15:
        set(4);
        cleanup();
        return;
    L8:
        if (compareAndSet(0, 4) == false) goto L2;
        cleanup();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() < 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() != 0) goto L30;
        this.thread = Thread.currentThread();
        if (compareAndSet(0, 1) == true) goto L26;
        this.thread = null;
        return;
    L26:
        this.run.run();     // Catch: Throwable -> L15
        this.thread = null;
        if (compareAndSet(1, 2) == false) goto L12;
        cleanup();
        return;
    L12:
        if (get() != 3) goto L14;
        Thread.yield();
        goto L12
    L14:
        Thread.interrupted();
        return;
    L15:
        th = move-exception;
        this.thread = null;
        if (compareAndSet(1, 2) == false) goto L19;
        cleanup();
    L23:
        throw th;
    L19:
        if (get() != 3) goto L21;
        Thread.yield();
        goto L19
    L21:
        Thread.interrupted();
        goto L23
    }
}
