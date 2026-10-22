package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ExecutorScheduler$DelayedRunnable extends AtomicReference<Runnable> implements Runnable, io.reactivex.disposables.b {
    private static final long serialVersionUID = -4101336210206799084L;
    final SequentialDisposable direct;
    final SequentialDisposable timed;

    ExecutorScheduler$DelayedRunnable(Runnable r10) {
        super(r10);
        this.timed = new SequentialDisposable();
        this.direct = new SequentialDisposable();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (getAndSet(null) == null) goto L6;
        this.timed.dispose();
        this.direct.dispose();
        return;
    }

    public Runnable getWrappedRunnable() {
        Runnable r10 = get();
        if (r10 == null) goto L6;
        return r10;
    L6:
        return Functions.f9486a;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable r10 = get();
        if (r10 != null) goto L11;
        return;
    L11:
        r10.run();     // Catch: Throwable -> L7
        lazySet(null);
        SequentialDisposable r11 = this.timed;
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        r11.lazySet(r12);
        this.direct.lazySet(r12);
        return;
    L7:
        th = move-exception;
        lazySet(null);
        this.timed.lazySet(DisposableHelper.DISPOSED);
        this.direct.lazySet(DisposableHelper.DISPOSED);
        throw th;
    }
}
