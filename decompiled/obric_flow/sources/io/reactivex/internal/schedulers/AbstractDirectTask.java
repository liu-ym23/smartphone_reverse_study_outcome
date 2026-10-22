package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable {
    protected static final FutureTask<Void> DISPOSED = null;
    protected static final FutureTask<Void> FINISHED = null;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;

    static {
        com.bytedance.android.anniex.worker.a r5 = io.reactivex.internal.functions.e.f17618b;
        FINISHED = new FutureTask(r5, null);
        DISPOSED = new FutureTask(r5, null);
    }

    public AbstractDirectTask(Runnable r5) {
        this.runnable = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Future<?> r5 = get();
        if (r5 == FINISHED) goto L15;
        FutureTask<Void> r10 = DISPOSED;
        if (r5 != r10) goto L7;
        return;
    L7:
        if (compareAndSet(r5, r10) == false) goto L17;
        if (r5 != null) goto L10;
        return;
    L10:
        if (this.runner == Thread.currentThread()) goto L12;
        boolean r11 = true;
    L13:
        r5.cancel(r11);
        return;
    L12:
        r11 = false;
        goto L13
    L17:
        return;
    }

    public Runnable getWrappedRunnable() {
        return this.runnable;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        Future<?> r5 = get();
        if (r5 != FINISHED) goto L5;
    L8:
        return true;
    L5:
        if (r5 == DISPOSED) goto L8;
        return false;
    }

    public final void setFuture(Future<?> r5) {
    L2:
        Future<?> r10 = get();
        if (r10 == FINISHED) goto L19;
        if (r10 == DISPOSED) goto L8;
        if (compareAndSet(r10, r5) == false) goto L2;
        return;
    L8:
        if (this.runner == Thread.currentThread()) goto L10;
        boolean r11 = true;
    L11:
        r5.cancel(r11);
        return;
    L10:
        r11 = false;
        goto L11
    }
}
