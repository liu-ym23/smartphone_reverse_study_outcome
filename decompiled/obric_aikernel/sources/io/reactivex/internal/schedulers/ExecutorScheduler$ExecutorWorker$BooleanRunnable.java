package io.reactivex.internal.schedulers;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class ExecutorScheduler$ExecutorWorker$BooleanRunnable extends AtomicBoolean implements Runnable, io.reactivex.disposables.b {
    private static final long serialVersionUID = -2421395018820541164L;
    final Runnable actual;

    ExecutorScheduler$ExecutorWorker$BooleanRunnable(Runnable r10) {
        this.actual = r10;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        lazySet(true);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() == false) goto L12;
        return;
    L12:
        this.actual.run();     // Catch: Throwable -> L9
        lazySet(true);
        return;
    L9:
        th = move-exception;
        lazySet(true);
        throw th;
    }
}
