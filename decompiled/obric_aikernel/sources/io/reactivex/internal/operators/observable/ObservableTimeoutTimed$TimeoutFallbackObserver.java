package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableTimeoutTimed$TimeoutFallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<T>, io.reactivex.disposables.b, m {
    private static final long serialVersionUID = 3764492702657003550L;
    final xb.o<? super T> downstream;
    xb.n<? extends T> fallback;
    final AtomicLong index;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<io.reactivex.disposables.b> upstream;
    final xb.p.c worker;

    ObservableTimeoutTimed$TimeoutFallbackObserver(xb.o<? super T> r10, long r11, TimeUnit r12, xb.p.c r13, xb.n<? extends T> r14) {
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.worker = r13;
        this.fallback = r14;
        this.task = new SequentialDisposable();
        this.index = new AtomicLong();
        this.upstream = new AtomicReference();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
        this.worker.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.o
    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        this.worker.dispose();
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r10);
        this.worker.dispose();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        long r11 = this.index.get();
        if (r11 == Long.MAX_VALUE) goto L9;
        long r12 = 1 + r11;
        if (this.index.compareAndSet(r11, r12) == false) goto L10;
        this.task.get().dispose();
        this.downstream.onNext(r10);
        startTimeout(r12);
        return;
    L10:
        return;
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this.upstream, r10);
    }

    @Override // io.reactivex.internal.operators.observable.m
    public void onTimeout(long r10) {
        if (this.index.compareAndSet(r10, Long.MAX_VALUE) == false) goto L6;
        DisposableHelper.dispose(this.upstream);
        xb.n<? extends T> r11 = this.fallback;
        this.fallback = null;
        r11.subscribe(new l(this.downstream, this));
        this.worker.dispose();
        return;
    }

    void startTimeout(long r10) {
        this.task.replace(this.worker.c(new n(r10, this), this.timeout, this.unit));
    }
}
