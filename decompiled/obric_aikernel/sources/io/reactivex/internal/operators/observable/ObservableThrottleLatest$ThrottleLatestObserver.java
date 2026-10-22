package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableThrottleLatest$ThrottleLatestObserver<T> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    volatile boolean cancelled;
    volatile boolean done;
    final xb.o<? super T> downstream;
    final boolean emitLast;
    Throwable error;
    final AtomicReference<T> latest;
    final long timeout;
    volatile boolean timerFired;
    boolean timerRunning;
    final TimeUnit unit;
    io.reactivex.disposables.b upstream;
    final xb.p.c worker;

    ObservableThrottleLatest$ThrottleLatestObserver(xb.o<? super T> r10, long r11, TimeUnit r12, xb.p.c r13, boolean r14) {
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.worker = r13;
        this.emitLast = r14;
        this.latest = new AtomicReference();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.worker.dispose();
        if (getAndIncrement() != 0) goto L6;
        this.latest.lazySet(null);
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicReference<T> r10 = this.latest;
        xb.o<? super T> r11 = this.downstream;
        int r12 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r13 = this.done;
        if (r13 == false) goto L18;
        if (this.error == null) goto L18;
        r10.lazySet(null);
        r11.onError(this.error);
    L15:
        this.worker.dispose();
        return;
    L18:
        if (r10.get() != null) goto L20;
        boolean r14 = true;
    L21:
        if (r13 == true) goto L22;
        if (r14 == true) goto L30;
        if (this.timerRunning == false) goto L40;
        if (this.timerFired == true) goto L40;
    L37:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L7;
        return;
    L40:
        r11.onNext(r10.getAndSet(null));
        this.timerFired = false;
        this.timerRunning = true;
        this.worker.c(this, this.timeout, this.unit);
        goto L7
    L30:
        if (this.timerFired == false) goto L37;
        this.timerRunning = false;
        this.timerFired = false;
        goto L37
    L22:
        T r15 = r10.getAndSet(null);
        if (r14 == false) goto L25;
    L27:
        r11.onComplete();
        goto L15
    L25:
        if (this.emitLast == false) goto L27;
        r11.onNext(r15);
        goto L27
    L20:
        r14 = false;
        goto L21
    L8:
        r10.lazySet(null);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // xb.o
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.latest.set(r10);
        drain();
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.timerFired = true;
        drain();
    }
}
