package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements io.reactivex.disposables.b {
    protected static final FutureTask<Void> DISPOSED = null;
    protected static final FutureTask<Void> FINISHED = null;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;

    static {
        Runnable r10 = Functions.f9486a;
        FINISHED = new FutureTask(r10, null);
        DISPOSED = new FutureTask(r10, null);
    }

    AbstractDirectTask(Runnable r10) {
        this.runnable = r10;
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        Future<?> r10 = get();
        if (r10 == FINISHED) goto L15;
        FutureTask<Void> r11 = DISPOSED;
        if (r10 != r11) goto L7;
        return;
    L7:
        if (compareAndSet(r10, r11) == false) goto L17;
        if (r10 != null) goto L10;
        return;
    L10:
        if (this.runner == Thread.currentThread()) goto L12;
        boolean r12 = true;
    L13:
        r10.cancel(r12);
        return;
    L12:
        r12 = false;
        goto L13
    L17:
        return;
    }

    public Runnable getWrappedRunnable() {
        return this.runnable;
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        Future<?> r10 = get();
        if (r10 != FINISHED) goto L5;
    L8:
        return true;
    L5:
        if (r10 == DISPOSED) goto L8;
        return false;
    }

    public final void setFuture(Future<?> r10) {
    L2:
        Future<?> r11 = get();
        if (r11 == FINISHED) goto L19;
        if (r11 == DISPOSED) goto L8;
        if (compareAndSet(r11, r10) == false) goto L2;
        return;
    L8:
        if (this.runner == Thread.currentThread()) goto L10;
        boolean r12 = true;
    L11:
        r10.cancel(r12);
        return;
    L10:
        r12 = false;
        goto L11
    }
}
