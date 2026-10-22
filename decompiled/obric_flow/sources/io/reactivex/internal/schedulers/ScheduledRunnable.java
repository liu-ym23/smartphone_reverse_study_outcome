package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
    static final Object ASYNC_DISPOSED = null;
    static final Object DONE = null;
    static final int FUTURE_INDEX = 1;
    static final Object PARENT_DISPOSED = null;
    static final int PARENT_INDEX = 0;
    static final Object SYNC_DISPOSED = null;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    static {
        PARENT_DISPOSED = new Object();
        SYNC_DISPOSED = new Object();
        ASYNC_DISPOSED = new Object();
        DONE = new Object();
    }

    public ScheduledRunnable(Runnable r5, qt.a r10) {
        super(3);
        this.actual = r5;
        lazySet(0, r10);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    L2:
        Object r5 = get(1);
        if (r5 == DONE) goto L19;
        Object r10 = SYNC_DISPOSED;
        if (r5 == r10) goto L19;
        Object r11 = ASYNC_DISPOSED;
        if (r5 == r11) goto L19;
        if (get(2) == Thread.currentThread()) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L16;
        r10 = r11;
    L16:
        if (compareAndSet(1, r5, r10) == false) goto L2;
        if (r5 == null) goto L19;
        ((Future) r5).cancel(r12);
        goto L19
    L12:
        r12 = false;
    L19:
        Object r13 = get(0);
        if (r13 == DONE) goto L40;
        Object r14 = PARENT_DISPOSED;
        if (r13 == r14) goto L41;
        if (r13 == null) goto L42;
        if (compareAndSet(0, r13, r14) == false) goto L19;
        ((qt.a) r13).c(this);
        return;
    L42:
        return;
    L41:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Object r5 = get(0);
        if (r5 != PARENT_DISPOSED) goto L5;
    L6:
        return true;
    L5:
        if (r5 == DONE) goto L6;
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        lazySet(2, Thread.currentThread());
        this.actual.run();     // Catch: Throwable -> L5
    L7:
        lazySet(2, null);
        Object r5 = get(0);
        if (r5 == PARENT_DISPOSED) goto L13;
        if (compareAndSet(0, r5, DONE) == false) goto L13;
        if (r5 == null) goto L13;
        ((qt.a) r5).c(this);
    L13:
        Object r10 = get(1);
        if (r10 == SYNC_DISPOSED) goto L50;
        if (r10 == ASYNC_DISPOSED) goto L19;
        if (compareAndSet(1, r10, DONE) == false) goto L13;
        return;
    L19:
        return;
    L50:
        return;
    L5:
        th = move-exception;
        wn.f.k(th);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        lazySet(2, null);
        Object r11 = get(0);
        if (r11 == PARENT_DISPOSED) goto L27;
        if (compareAndSet(0, r11, DONE) == false) goto L27;
        if (r11 == null) goto L27;
        ((qt.a) r11).c(this);
    L27:
        Object r12 = get(1);
        if (r12 == SYNC_DISPOSED) goto L34;
        if (r12 == ASYNC_DISPOSED) goto L34;
        if (compareAndSet(1, r12, DONE) == false) goto L27;
    L34:
        throw th;
    }

    public void setFuture(Future<?> r5) {
    L2:
        Object r10 = get(1);
        if (r10 == DONE) goto L4;
        if (r10 == SYNC_DISPOSED) goto L7;
        if (r10 == ASYNC_DISPOSED) goto L11;
        if (compareAndSet(1, r10, r5) == false) goto L2;
        return;
    L11:
        r5.cancel(true);
        return;
    L7:
        r5.cancel(false);
        return;
    }
}
