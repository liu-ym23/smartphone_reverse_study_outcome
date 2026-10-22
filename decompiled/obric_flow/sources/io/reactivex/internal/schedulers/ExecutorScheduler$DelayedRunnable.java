package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ExecutorScheduler$DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable {
    private static final long serialVersionUID = -4101336210206799084L;
    final SequentialDisposable direct;
    final SequentialDisposable timed;

    public ExecutorScheduler$DelayedRunnable(Runnable r5) {
        super(r5);
        this.timed = new SequentialDisposable();
        this.direct = new SequentialDisposable();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (getAndSet(null) == null) goto L6;
        this.timed.dispose();
        this.direct.dispose();
        return;
    }

    public Runnable getWrappedRunnable() {
        Runnable r5 = get();
        if (r5 == null) goto L6;
        return r5;
    L6:
        return io.reactivex.internal.functions.e.f17618b;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable r5 = get();
        if (r5 != null) goto L11;
        return;
    L11:
        r5.run();     // Catch: Throwable -> L7
        lazySet(null);
        SequentialDisposable r10 = this.timed;
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        r10.lazySet(r11);
        this.direct.lazySet(r11);
        return;
    L7:
        th = move-exception;
        lazySet(null);
        this.timed.lazySet(DisposableHelper.DISPOSED);
        this.direct.lazySet(DisposableHelper.DISPOSED);
        throw th;
    }
}
