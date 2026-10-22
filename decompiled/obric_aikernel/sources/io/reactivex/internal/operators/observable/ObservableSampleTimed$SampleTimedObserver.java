package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
abstract class ObservableSampleTimed$SampleTimedObserver<T> extends AtomicReference<T> implements xb.o<T>, io.reactivex.disposables.b, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    final xb.o<? super T> downstream;
    final long period;
    final xb.p scheduler;
    final AtomicReference<io.reactivex.disposables.b> timer;
    final TimeUnit unit;
    io.reactivex.disposables.b upstream;

    ObservableSampleTimed$SampleTimedObserver(xb.o<? super T> r10, long r11, TimeUnit r12, xb.p r13) {
        this.timer = new AtomicReference();
        this.downstream = r10;
        this.period = r11;
        this.unit = r12;
        this.scheduler = r13;
    }

    void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    abstract void complete();

    @Override // io.reactivex.disposables.b
    public void dispose() {
        cancelTimer();
        this.upstream.dispose();
    }

    void emit() {
        T r10 = getAndSet(null);
        if (r10 == null) goto L6;
        this.downstream.onNext(r10);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // xb.o
    public void onComplete() {
        cancelTimer();
        complete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        cancelTimer();
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        lazySet(r10);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        xb.p r11 = this.scheduler;
        long r12 = this.period;
        io.reactivex.disposables.b r13 = r11.e(this, r12, r12, this.unit);
        DisposableHelper.replace(this.timer, r13);
        return;
    }
}
