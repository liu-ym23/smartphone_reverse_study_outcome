package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableTimeout$TimeoutObserver<T> extends AtomicLong implements xb.o<T>, io.reactivex.disposables.b, k {
    private static final long serialVersionUID = 3764492702657003550L;
    final xb.o<? super T> downstream;
    final zb.h<? super T, ? extends xb.n<?>> itemTimeoutIndicator;
    final SequentialDisposable task;
    final AtomicReference<io.reactivex.disposables.b> upstream;

    ObservableTimeout$TimeoutObserver(xb.o<? super T> r10, zb.h<? super T, ? extends xb.n<?>> r11) {
        this.downstream = r10;
        this.itemTimeoutIndicator = r11;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        this.task.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // xb.o
    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        long r11 = get();
        if (r11 == Long.MAX_VALUE) goto L22;
        long r12 = 1 + r11;
        if (compareAndSet(r11, r12) == false) goto L23;
        io.reactivex.disposables.b r13 = this.task.get();
        if (r13 == null) goto L10;
        r13.dispose();
    L10:
        this.downstream.onNext(r10);
        xb.n r14 = (xb.n) io.reactivex.internal.functions.a.d(this.itemTimeoutIndicator.apply(r10), "The itemTimeoutIndicator returned a null ObservableSource.");     // Catch: Throwable -> L16
        ObservableTimeout$TimeoutConsumer r15 = new ObservableTimeout$TimeoutConsumer(r12, this);
        if (this.task.replace(r15) == false) goto L21;
        r14.subscribe(r15);
        return;
    L21:
        return;
    L16:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.get().dispose();
        getAndSet(Long.MAX_VALUE);
        this.downstream.onError(th);
        return;
    L23:
        return;
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this.upstream, r10);
    }

    @Override // io.reactivex.internal.operators.observable.m
    public void onTimeout(long r10) {
        if (compareAndSet(r10, Long.MAX_VALUE) == false) goto L6;
        DisposableHelper.dispose(this.upstream);
        this.downstream.onError(new TimeoutException());
        return;
    }

    @Override // io.reactivex.internal.operators.observable.k
    public void onTimeoutError(long r10, Throwable r11) {
        if (compareAndSet(r10, Long.MAX_VALUE) == false) goto L5;
        DisposableHelper.dispose(this.upstream);
        this.downstream.onError(r11);
        return;
    L5:
        dc.a.n(r11);
    }

    void startFirstTimeout(xb.n<?> r10) {
        if (r10 == null) goto L7;
        ObservableTimeout$TimeoutConsumer r11 = new ObservableTimeout$TimeoutConsumer(0, this);
        if (this.task.replace(r11) == false) goto L8;
        r10.subscribe(r11);
        return;
    L8:
        return;
    }
}
