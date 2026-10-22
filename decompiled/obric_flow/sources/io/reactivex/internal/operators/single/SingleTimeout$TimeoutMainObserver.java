package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.d;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import mt.a0;
import mt.b0;
import mt.c0;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class SingleTimeout$TimeoutMainObserver<T> extends AtomicReference<Disposable> implements b0, Runnable, Disposable {
    private static final long serialVersionUID = 37497744973048446L;
    final b0 downstream;
    final TimeoutFallbackObserver<T> fallback;
    c0 other;
    final AtomicReference<Disposable> task;
    final long timeout;
    final TimeUnit unit;

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements b0 {
        private static final long serialVersionUID = 2071387740092105509L;
        final b0 downstream;

        public TimeoutFallbackObserver(b0 r5) {
            this.downstream = r5;
        }

        @Override // mt.b0, mt.j
        public void onError(Throwable r5) {
            this.downstream.onError(r5);
        }

        @Override // mt.b0, mt.j
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }

        @Override // mt.b0, mt.j
        public void onSuccess(T r5) {
            this.downstream.onSuccess(r5);
        }
    }

    public SingleTimeout$TimeoutMainObserver(b0 r5, c0 r10, long r11, TimeUnit r12) {
        this.downstream = r5;
        this.other = r10;
        this.timeout = r11;
        this.unit = r12;
        this.task = new AtomicReference();
        if (r10 == null) goto L5;
        this.fallback = new TimeoutFallbackObserver(r5);
        return;
    L5:
        this.fallback = null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.task);
        TimeoutFallbackObserver<T> r5 = this.fallback;
        if (r5 == null) goto L6;
        DisposableHelper.dispose(r5);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 != r11) goto L5;
    L7:
        f.k(r5);
        return;
    L5:
        if (compareAndSet(r10, r11) == false) goto L7;
        DisposableHelper.dispose(this.task);
        this.downstream.onError(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        Disposable r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 != r11) goto L5;
        return;
    L5:
        if (compareAndSet(r10, r11) == false) goto L9;
        DisposableHelper.dispose(this.task);
        this.downstream.onSuccess(r5);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        Disposable r5 = get();
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (r5 != r10) goto L5;
        return;
    L5:
        if (compareAndSet(r5, r10) == false) goto L14;
        if (r5 == null) goto L8;
        r5.dispose();
    L8:
        c0 r11 = this.other;
        if (r11 != null) goto L11;
        this.downstream.onError(new TimeoutException(d.c(this.timeout, this.unit)));
        return;
    L11:
        this.other = null;
        a0 r12 = (a0) r11;
        r12.b(this.fallback);
        return;
    }
}
