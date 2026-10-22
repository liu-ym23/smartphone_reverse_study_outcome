package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableThrottleLatest$ThrottleLatestSubscriber<T> extends AtomicInteger implements xb.g<T>, tc.d, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    volatile boolean cancelled;
    volatile boolean done;
    final tc.c<? super T> downstream;
    final boolean emitLast;
    long emitted;
    Throwable error;
    final AtomicReference<T> latest;
    final AtomicLong requested;
    final long timeout;
    volatile boolean timerFired;
    boolean timerRunning;
    final TimeUnit unit;
    tc.d upstream;
    final xb.p.c worker;

    FlowableThrottleLatest$ThrottleLatestSubscriber(tc.c<? super T> r10, long r11, TimeUnit r12, xb.p.c r13, boolean r14) {
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.worker = r13;
        this.emitLast = r14;
        this.latest = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // tc.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
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
        AtomicLong r11 = this.requested;
        tc.c<? super T> r12 = this.downstream;
        int r13 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r14 = this.done;
        if (r14 == false) goto L19;
        if (this.error == null) goto L19;
        r10.lazySet(null);
        Throwable r15 = this.error;
    L15:
        r12.onError(r15);
    L16:
        this.worker.dispose();
        return;
    L19:
        if (r10.get() != null) goto L21;
        boolean r16 = true;
    L23:
        if (r14 == true) goto L24;
        if (r16 == true) goto L35;
        if (this.timerRunning == false) goto L45;
        if (this.timerFired == true) goto L45;
    L42:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L45:
        T r17 = r10.getAndSet(null);
        long r18 = this.emitted;
        if (r18 == r11.get()) goto L48;
        r12.onNext(r17);
        this.emitted = r18 + 1;
        this.timerFired = false;
        this.timerRunning = true;
        this.worker.c(this, this.timeout, this.unit);
        goto L7
    L48:
        this.upstream.cancel();
        r15 = new MissingBackpressureException("Could not emit value due to lack of requests");
        goto L15
    L35:
        if (this.timerFired == false) goto L42;
        this.timerRunning = false;
        this.timerFired = false;
        goto L42
    L24:
        if (r16 == false) goto L26;
    L31:
        r10.lazySet(null);
    L32:
        r12.onComplete();
        goto L16
    L26:
        if (this.emitLast == false) goto L31;
        T r19 = r10.getAndSet(null);
        long r20 = this.emitted;
        if (r20 == r11.get()) goto L30;
        this.emitted = r20 + 1;
        r12.onNext(r19);
        goto L32
    L30:
        r15 = new MissingBackpressureException("Could not emit final value due to lack of requests");
        goto L15
    L21:
        r16 = false;
        goto L23
    L8:
        r10.lazySet(null);
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.latest.set(r10);
        drain();
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.timerFired = true;
        drain();
    }
}
