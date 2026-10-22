package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableTakeLast$TakeLastSubscriber<T> extends ArrayDeque<T> implements mt.g, zu.d {
    private static final long serialVersionUID = 7240042530241604978L;
    volatile boolean cancelled;
    final int count;
    volatile boolean done;
    final zu.c downstream;
    final AtomicLong requested;
    zu.d upstream;
    final AtomicInteger wip;

    public FlowableTakeLast$TakeLastSubscriber(zu.c r5, int r10) {
        this.requested = new AtomicLong();
        this.wip = new AtomicInteger();
        this.downstream = r5;
        this.count = r10;
    }

    @Override // zu.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
    }

    public void drain() {
        if (this.wip.getAndIncrement() != 0) goto L28;
        zu.c r5 = this.downstream;
        long r10 = this.requested.get();
    L6:
        if (this.cancelled == true) goto L7;
        if (this.done == false) goto L27;
        long r11 = 0;
    L12:
        if (r11 == r10) goto L22;
        if (this.cancelled == true) goto L15;
        T r12 = poll();
        if (r12 == null) goto L18;
        r5.onNext(r12);
        r11 = r11 + 1;
        goto L12
    L18:
        r5.onComplete();
        return;
    L15:
        return;
    L22:
        if (r11 == 0) goto L27;
        if (r10 == Long.MAX_VALUE) goto L27;
        r10 = this.requested.addAndGet(-r11);
    L27:
        if (this.wip.decrementAndGet() != 0) goto L6;
        return;
    L7:
        return;
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.count != size()) goto L5;
        poll();
    L5:
        offer(r5);
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
