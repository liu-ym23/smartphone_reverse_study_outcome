package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableSkipLastTimed$SkipLastTimedSubscriber<T> extends AtomicInteger implements mt.g, zu.d {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final zu.c downstream;
    Throwable error;
    final io.reactivex.internal.queue.b queue;
    final AtomicLong requested;
    final mt.z scheduler;
    final long time;
    final TimeUnit unit;
    zu.d upstream;

    public FlowableSkipLastTimed$SkipLastTimedSubscriber(zu.c r5, long r10, TimeUnit r11, mt.z r12, int r13, boolean r14) {
        this.requested = new AtomicLong();
        this.downstream = r5;
        this.time = r10;
        this.unit = r11;
        this.scheduler = r12;
        this.queue = new io.reactivex.internal.queue.b(r13);
        this.delayError = r14;
    }

    @Override // zu.d
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    public boolean checkTerminated(boolean r5, boolean r10, zu.c r11, boolean r12) {
        if (this.cancelled == false) goto L6;
        this.queue.clear();
        return true;
    L6:
        if (r5 == false) goto L21;
        if (r12 == false) goto L14;
        if (r10 == false) goto L23;
        Throwable r13 = this.error;
        if (r13 == null) goto L12;
        r11.onError(r13);
    L13:
        return true;
    L12:
        r11.onComplete();
        goto L13
    L23:
        return false;
    L14:
        Throwable r14 = this.error;
        if (r14 == null) goto L18;
        this.queue.clear();
        r11.onError(r14);
        return true;
    L18:
        if (r10 == false) goto L24;
        r11.onComplete();
        return true;
    L24:
        return false;
    L21:
        return false;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        io.reactivex.internal.queue.b r10 = this.queue;
        boolean r11 = this.delayError;
        TimeUnit r12 = this.unit;
        mt.z r13 = this.scheduler;
        long r14 = this.time;
        int r15 = 1;
    L6:
        long r16 = this.requested.get();
        long r17 = 0;
    L8:
        if (r17 == r16) goto L26;
        boolean r18 = this.done;
        Long r19 = (Long) r10.peek();
        if (r19 != null) goto L12;
        boolean r110 = true;
    L13:
        long r111 = r13.b(r12);
        if (r110 == false) goto L16;
    L18:
        boolean r112 = r110;
    L20:
        if (checkTerminated(r18, r112, r5, r11) == true) goto L21;
        if (r112 == true) goto L26;
        r10.poll();
        r5.onNext(r10.poll());
        r17 = r17 + 1;
        goto L8
    L21:
        return;
    L16:
        if (r19.longValue() <= (r111 - r14)) goto L18;
        r112 = true;
        goto L20
    L12:
        r110 = false;
    L26:
        if (r17 == 0) goto L28;
        v0.y(this.requested, r17);
    L28:
        r15 = addAndGet(-r15);
        if (r15 != 0) goto L6;
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
        long r10 = this.scheduler.b(this.unit);
        this.queue.a(Long.valueOf(r10), r5);
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
        drain();
        return;
    }
}
