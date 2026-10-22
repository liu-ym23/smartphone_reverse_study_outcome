package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
abstract class ObservableSampleTimed$SampleTimedObserver<T> extends AtomicReference<T> implements mt.u, Disposable, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    final mt.u downstream;
    final long period;
    final mt.z scheduler;
    final AtomicReference<Disposable> timer;
    final TimeUnit unit;
    Disposable upstream;

    public ObservableSampleTimed$SampleTimedObserver(mt.u r5, long r10, TimeUnit r11, mt.z r12) {
        this.timer = new AtomicReference();
        this.downstream = r5;
        this.period = r10;
        this.unit = r11;
        this.scheduler = r12;
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        cancelTimer();
        this.upstream.dispose();
    }

    public void emit() {
        T r5 = getAndSet(null);
        if (r5 == null) goto L6;
        this.downstream.onNext(r5);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // mt.u
    public void onComplete() {
        cancelTimer();
        complete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        cancelTimer();
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        lazySet(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        mt.z r5 = this.scheduler;
        long r11 = this.period;
        Disposable r12 = r5.e(this, r11, r11, this.unit);
        DisposableHelper.replace(this.timer, r12);
        return;
    }
}
