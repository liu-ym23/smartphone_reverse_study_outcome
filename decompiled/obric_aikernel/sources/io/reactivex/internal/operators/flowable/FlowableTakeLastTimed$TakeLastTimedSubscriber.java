package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableTakeLastTimed$TakeLastTimedSubscriber<T> extends AtomicInteger implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final long count;
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

    FlowableTakeLastTimed$TakeLastTimedSubscriber(tc.c<? super T> r10, long r11, long r12, TimeUnit r13, xb.p r14, int r15, boolean r16) {
        this.requested = new AtomicLong();
        this.downstream = r10;
        this.count = r11;
        this.time = r12;
        this.unit = r13;
        this.scheduler = r14;
        this.queue = new io.reactivex.internal.queue.a(r15);
        this.delayError = r16;
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

    boolean checkTerminated(boolean r10, tc.c<? super T> r11, boolean r12) {
        if (this.cancelled == false) goto L6;
        this.queue.clear();
        return true;
    L6:
        if (r12 == false) goto L13;
        if (r10 == false) goto L20;
        Throwable r13 = this.error;
        if (r13 == null) goto L11;
        r11.onError(r13);
    L12:
        return true;
    L11:
        r11.onComplete();
        goto L12
    L20:
        return false;
    L13:
        Throwable r14 = this.error;
        if (r14 == null) goto L17;
        this.queue.clear();
        r11.onError(r14);
        return true;
    L17:
        if (r10 == false) goto L22;
        r11.onComplete();
        return true;
    L22:
        return false;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        tc.c<? super T> r10 = this.downstream;
        io.reactivex.internal.queue.a<Object> r11 = this.queue;
        boolean r12 = this.delayError;
        int r13 = 1;
    L7:
        if (this.done == true) goto L9;
    L25:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L9:
        if (checkTerminated(r11.isEmpty(), r10, r12) == true) goto L10;
        long r14 = this.requested.get();
        long r15 = 0;
    L13:
        if (r11.peek() != null) goto L15;
        boolean r16 = true;
    L17:
        if (checkTerminated(r16, r10, r12) == true) goto L18;
        if (r14 == r15) goto L22;
        r11.poll();
        r10.onNext(r11.poll());
        r15 = r15 + 1;
        goto L13
    L22:
        if (r15 == 0) goto L25;
        io.reactivex.internal.util.b.e(this.requested, r15);
        goto L25
    L18:
        return;
    L15:
        r16 = false;
        goto L17
    }

    @Override // tc.c
    public void onComplete() {
        trim(this.scheduler.b(this.unit), this.queue);
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.delayError == false) goto L5;
        trim(this.scheduler.b(this.unit), this.queue);
    L5:
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onNext(T r10) {
        io.reactivex.internal.queue.a<Object> r11 = this.queue;
        long r12 = this.scheduler.b(this.unit);
        r11.l(Long.valueOf(r12), r10);
        trim(r12, r11);
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

    void trim(long r10, io.reactivex.internal.queue.a<Object> r12) {
        long r11 = this.time;
        long r13 = this.count;
        if (r13 != Long.MAX_VALUE) goto L5;
        boolean r14 = true;
    L7:
        if (r12.isEmpty() == true) goto L14;
        if (((Long) r12.peek()).longValue() < (r10 - r11)) goto L13;
        if (r14 == true) goto L21;
        if ((r12.n() >> 1) > r13) goto L13;
        return;
    L21:
        return;
    L13:
        r12.poll();
        r12.poll();
        goto L7
    L14:
        return;
    L5:
        r14 = false;
        goto L7
    }
}
