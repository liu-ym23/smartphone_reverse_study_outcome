package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableSkipLastTimed$SkipLastTimedSubscriber<T> extends AtomicInteger implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final tc.c<? super T> downstream;
    Throwable error;
    final io.reactivex.internal.queue.a<Object> queue;
    final AtomicLong requested;
    final xb.p scheduler;
    final long time;
    final TimeUnit unit;
    tc.d upstream;

    FlowableSkipLastTimed$SkipLastTimedSubscriber(tc.c<? super T> r10, long r11, TimeUnit r12, xb.p r13, int r14, boolean r15) {
        this.requested = new AtomicLong();
        this.downstream = r10;
        this.time = r11;
        this.unit = r12;
        this.scheduler = r13;
        this.queue = new io.reactivex.internal.queue.a(r14);
        this.delayError = r15;
    }

    @Override // tc.d
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

    boolean checkTerminated(boolean r10, boolean r11, tc.c<? super T> r12, boolean r13) {
        if (this.cancelled == false) goto L6;
        this.queue.clear();
        return true;
    L6:
        if (r10 == false) goto L21;
        if (r13 == false) goto L14;
        if (r11 == false) goto L23;
        Throwable r14 = this.error;
        if (r14 == null) goto L12;
        r12.onError(r14);
    L13:
        return true;
    L12:
        r12.onComplete();
        goto L13
    L23:
        return false;
    L14:
        Throwable r15 = this.error;
        if (r15 == null) goto L18;
        this.queue.clear();
        r12.onError(r15);
        return true;
    L18:
        if (r11 == false) goto L24;
        r12.onComplete();
        return true;
    L24:
        return false;
    L21:
        return false;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        tc.c<? super T> r10 = this.downstream;
        io.reactivex.internal.queue.a<Object> r11 = this.queue;
        boolean r12 = this.delayError;
        TimeUnit r13 = this.unit;
        xb.p r14 = this.scheduler;
        long r15 = this.time;
        int r16 = 1;
    L6:
        long r17 = this.requested.get();
        long r18 = 0;
    L8:
        if (r18 == r17) goto L26;
        boolean r19 = this.done;
        Long r110 = (Long) r11.peek();
        if (r110 != null) goto L12;
        boolean r111 = true;
    L13:
        long r112 = r14.b(r13);
        if (r111 == false) goto L16;
    L18:
        boolean r113 = r111;
    L20:
        if (checkTerminated(r19, r113, r10, r12) == true) goto L21;
        if (r113 == true) goto L26;
        r11.poll();
        r10.onNext(r11.poll());
        r18 = r18 + 1;
        goto L8
    L21:
        return;
    L16:
        if (r110.longValue() <= (r112 - r15)) goto L18;
        r113 = true;
        goto L20
    L12:
        r111 = false;
    L26:
        if (r18 == 0) goto L28;
        io.reactivex.internal.util.b.e(this.requested, r18);
    L28:
        r16 = addAndGet(-r16);
        if (r16 != 0) goto L6;
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
        long r11 = this.scheduler.b(this.unit);
        this.queue.l(Long.valueOf(r11), r10);
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
        drain();
        return;
    }
}
