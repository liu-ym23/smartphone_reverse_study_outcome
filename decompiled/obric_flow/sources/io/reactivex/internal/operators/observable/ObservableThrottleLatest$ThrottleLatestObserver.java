package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableThrottleLatest$ThrottleLatestObserver<T> extends AtomicInteger implements mt.u, Disposable, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    volatile boolean cancelled;
    volatile boolean done;
    final mt.u downstream;
    final boolean emitLast;
    Throwable error;
    final AtomicReference<T> latest;
    final long timeout;
    volatile boolean timerFired;
    boolean timerRunning;
    final TimeUnit unit;
    Disposable upstream;
    final mt.y worker;

    public ObservableThrottleLatest$ThrottleLatestObserver(mt.u r5, long r10, TimeUnit r11, mt.y r12, boolean r13) {
        this.downstream = r5;
        this.timeout = r10;
        this.unit = r11;
        this.worker = r12;
        this.emitLast = r13;
        this.latest = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.worker.dispose();
        if (getAndIncrement() != 0) goto L6;
        this.latest.lazySet(null);
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicReference<T> r5 = this.latest;
        mt.u r10 = this.downstream;
        int r11 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r12 = this.done;
        if (r12 == false) goto L17;
        if (this.error == null) goto L17;
        r5.lazySet(null);
        r10.onError(this.error);
        this.worker.dispose();
        return;
    L17:
        if (r5.get() != null) goto L19;
        boolean r13 = true;
    L20:
        if (r12 == true) goto L21;
        if (r13 == true) goto L30;
        if (this.timerRunning == false) goto L40;
        if (this.timerFired == true) goto L40;
    L37:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L7;
        return;
    L40:
        r10.onNext(r5.getAndSet(null));
        this.timerFired = false;
        this.timerRunning = true;
        this.worker.b(this, this.timeout, this.unit);
        goto L7
    L30:
        if (this.timerFired == false) goto L37;
        this.timerRunning = false;
        this.timerFired = false;
        goto L37
    L21:
        T r14 = r5.getAndSet(null);
        if (r13 == false) goto L24;
    L26:
        r10.onComplete();
        this.worker.dispose();
        return;
    L24:
        if (this.emitLast == false) goto L26;
        r10.onNext(r14);
        goto L26
    L19:
        r13 = false;
        goto L20
    L8:
        r5.lazySet(null);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // mt.u
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.error = r5;
        this.done = true;
        drain();
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.latest.set(r5);
        drain();
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.timerFired = true;
        drain();
    }
}
