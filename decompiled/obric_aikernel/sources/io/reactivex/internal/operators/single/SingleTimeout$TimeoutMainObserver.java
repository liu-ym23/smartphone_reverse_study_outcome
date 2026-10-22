package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;
import xb.s;

/* JADX INFO: loaded from: classes2.dex */
final class SingleTimeout$TimeoutMainObserver<T> extends AtomicReference<b> implements r<T>, Runnable, b {
    private static final long serialVersionUID = 37497744973048446L;
    final r<? super T> downstream;
    final TimeoutFallbackObserver<T> fallback;
    s<? extends T> other;
    final AtomicReference<b> task;
    final long timeout;
    final TimeUnit unit;

    static final class TimeoutFallbackObserver<T> extends AtomicReference<b> implements r<T> {
        private static final long serialVersionUID = 2071387740092105509L;
        final r<? super T> downstream;

        TimeoutFallbackObserver(r<? super T> r10) {
            this.downstream = r10;
        }

        @Override // xb.r
        public void onError(Throwable r10) {
            this.downstream.onError(r10);
        }

        @Override // xb.r
        public void onSubscribe(b r10) {
            DisposableHelper.setOnce(this, r10);
        }

        @Override // xb.r
        public void onSuccess(T r10) {
            this.downstream.onSuccess(r10);
        }
    }

    SingleTimeout$TimeoutMainObserver(r<? super T> r10, s<? extends T> r11, long r12, TimeUnit r13) {
        this.downstream = r10;
        this.other = r11;
        this.timeout = r12;
        this.unit = r13;
        this.task = new AtomicReference();
        if (r11 == null) goto L5;
        this.fallback = new TimeoutFallbackObserver(r10);
        return;
    L5:
        this.fallback = null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.task);
        TimeoutFallbackObserver<T> r10 = this.fallback;
        if (r10 == null) goto L6;
        DisposableHelper.dispose(r10);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        b r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 != r12) goto L5;
    L7:
        dc.a.n(r10);
        return;
    L5:
        if (compareAndSet(r11, r12) == false) goto L7;
        DisposableHelper.dispose(this.task);
        this.downstream.onError(r10);
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        b r11 = get();
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 != r12) goto L5;
        return;
    L5:
        if (compareAndSet(r11, r12) == false) goto L9;
        DisposableHelper.dispose(this.task);
        this.downstream.onSuccess(r10);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        b r10 = get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 != r11) goto L5;
        return;
    L5:
        if (compareAndSet(r10, r11) == false) goto L14;
        if (r10 == null) goto L8;
        r10.dispose();
    L8:
        s<? extends T> r12 = this.other;
        if (r12 != null) goto L11;
        this.downstream.onError(new TimeoutException(ExceptionHelper.c(this.timeout, this.unit)));
        return;
    L11:
        this.other = null;
        r12.a(this.fallback);
        return;
    }
}
