package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableThrottleLatest$ThrottleLatestSubscriber<T> extends AtomicInteger implements mt.g, zu.d, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    volatile boolean cancelled;
    volatile boolean done;
    final zu.c downstream;
    final boolean emitLast;
    long emitted;
    Throwable error;
    final AtomicReference<T> latest;
    final AtomicLong requested;
    final long timeout;
    volatile boolean timerFired;
    boolean timerRunning;
    final TimeUnit unit;
    zu.d upstream;
    final mt.y worker;

    public FlowableThrottleLatest$ThrottleLatestSubscriber(zu.c r5, long r10, TimeUnit r11, mt.y r12, boolean r13) {
        this.downstream = r5;
        this.timeout = r10;
        this.unit = r11;
        this.worker = r12;
        this.emitLast = r13;
        this.latest = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // zu.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
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
        AtomicLong r10 = this.requested;
        zu.c r11 = this.downstream;
        int r12 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r13 = this.done;
        if (r13 == false) goto L17;
        if (this.error == null) goto L17;
        r5.lazySet(null);
        r11.onError(this.error);
        this.worker.dispose();
        return;
    L17:
        if (r5.get() != null) goto L19;
        boolean r14 = true;
    L21:
        if (r13 == true) goto L22;
        if (r14 == true) goto L34;
        if (this.timerRunning == false) goto L44;
        if (this.timerFired == true) goto L44;
    L41:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L7;
        return;
    L44:
        T r15 = r5.getAndSet(null);
        long r16 = this.emitted;
        if (r16 == r10.get()) goto L47;
        r11.onNext(r15);
        this.emitted = r16 + 1;
        this.timerFired = false;
        this.timerRunning = true;
        this.worker.b(this, this.timeout, this.unit);
        goto L7
    L47:
        this.upstream.cancel();
        r11.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
        this.worker.dispose();
        return;
    L34:
        if (this.timerFired == false) goto L41;
        this.timerRunning = false;
        this.timerFired = false;
        goto L41
    L22:
        if (r14 == false) goto L24;
    L29:
        r5.lazySet(null);
        r11.onComplete();
    L30:
        this.worker.dispose();
        return;
    L24:
        if (this.emitLast == false) goto L29;
        T r17 = r5.getAndSet(null);
        long r18 = this.emitted;
        if (r18 == r10.get()) goto L28;
        this.emitted = r18 + 1;
        r11.onNext(r17);
        r11.onComplete();
        goto L30
    L28:
        r11.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
        goto L30
    L19:
        r14 = false;
        goto L21
    L8:
        r5.lazySet(null);
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.error = r5;
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.latest.set(r5);
        drain();
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.timerFired = true;
        drain();
    }
}
