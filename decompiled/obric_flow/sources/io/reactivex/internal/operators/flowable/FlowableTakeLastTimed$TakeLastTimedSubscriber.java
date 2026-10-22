package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableTakeLastTimed$TakeLastTimedSubscriber<T> extends AtomicInteger implements mt.g, zu.d {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final long count;
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

    public FlowableTakeLastTimed$TakeLastTimedSubscriber(zu.c r5, long r10, long r11, TimeUnit r12, mt.z r13, int r14, boolean r15) {
        this.requested = new AtomicLong();
        this.downstream = r5;
        this.count = r10;
        this.time = r11;
        this.unit = r12;
        this.scheduler = r13;
        this.queue = new io.reactivex.internal.queue.b(r14);
        this.delayError = r15;
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

    public boolean checkTerminated(boolean r5, zu.c r10, boolean r11) {
        if (this.cancelled == false) goto L6;
        this.queue.clear();
        return true;
    L6:
        if (r11 == false) goto L13;
        if (r5 == false) goto L20;
        Throwable r12 = this.error;
        if (r12 == null) goto L11;
        r10.onError(r12);
    L12:
        return true;
    L11:
        r10.onComplete();
        goto L12
    L20:
        return false;
    L13:
        Throwable r13 = this.error;
        if (r13 == null) goto L17;
        this.queue.clear();
        r10.onError(r13);
        return true;
    L17:
        if (r5 == false) goto L22;
        r10.onComplete();
        return true;
    L22:
        return false;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        io.reactivex.internal.queue.b r10 = this.queue;
        boolean r11 = this.delayError;
        int r12 = 1;
    L7:
        if (this.done == true) goto L9;
    L25:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L7;
        return;
    L9:
        if (checkTerminated(r10.isEmpty(), r5, r11) == true) goto L10;
        long r13 = this.requested.get();
        long r14 = 0;
    L13:
        if (r10.peek() != null) goto L15;
        boolean r15 = true;
    L17:
        if (checkTerminated(r15, r5, r11) == true) goto L18;
        if (r13 == r14) goto L22;
        r10.poll();
        r5.onNext(r10.poll());
        r14 = r14 + 1;
        goto L13
    L22:
        if (r14 == 0) goto L25;
        v0.y(this.requested, r14);
        goto L25
    L18:
        return;
    L15:
        r15 = false;
        goto L17
    }

    @Override // zu.c
    public void onComplete() {
        trim(this.scheduler.b(this.unit), this.queue);
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.delayError == false) goto L5;
        trim(this.scheduler.b(this.unit), this.queue);
    L5:
        this.error = r5;
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onNext(T r5) {
        io.reactivex.internal.queue.b r10 = this.queue;
        long r11 = this.scheduler.b(this.unit);
        r10.a(Long.valueOf(r11), r5);
        trim(r11, r10);
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

    public void trim(long r13, io.reactivex.internal.queue.b r15) {
        long r5 = this.time;
        long r10 = this.count;
        if (r10 != Long.MAX_VALUE) goto L5;
        boolean r12 = true;
    L7:
        if (r15.isEmpty() == true) goto L19;
        if (((Long) r15.peek()).longValue() < (r13 - r5)) goto L18;
        if (r12 == true) goto L27;
        AtomicLong r11 = r15.f18118h;
        long r14 = r11.get();
    L12:
        long r16 = r15.f18115a.get();
        long r17 = r11.get();
        if (r14 == r17) goto L15;
        r14 = r17;
        goto L12
    L15:
        if ((((int) (r16 - r17)) >> 1) > r10) goto L18;
        return;
    L27:
        return;
    L18:
        r15.poll();
        r15.poll();
        goto L7
    L19:
        return;
    L5:
        r12 = false;
        goto L7
    }
}
