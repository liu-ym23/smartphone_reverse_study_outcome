package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableRepeat$RepeatSubscriber<T> extends AtomicInteger implements mt.g {
    private static final long serialVersionUID = -7098360935104053232L;
    final zu.c downstream;
    long produced;
    long remaining;

    /* JADX INFO: renamed from: sa, reason: collision with root package name */
    final SubscriptionArbiter f17648sa;
    final zu.b source;

    public FlowableRepeat$RepeatSubscriber(zu.c r5, long r10, SubscriptionArbiter r11, zu.b r12) {
        this.downstream = r5;
        this.f17648sa = r11;
        this.source = r12;
        this.remaining = r10;
    }

    @Override // zu.c
    public void onComplete() {
        long r5 = this.remaining;
        if (r5 == Long.MAX_VALUE) goto L6;
        this.remaining = r5 - 1;
    L6:
        if (r5 == 0) goto L8;
        subscribeNext();
        return;
    L8:
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.produced++;
        this.downstream.onNext(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        this.f17648sa.setSubscription(r5);
    }

    public void subscribeNext() {
        if (getAndIncrement() != 0) goto L13;
        int r5 = 1;
    L6:
        if (this.f17648sa.isCancelled() == true) goto L7;
        long r10 = this.produced;
        if (r10 == 0) goto L11;
        this.produced = 0;
        this.f17648sa.produced(r10);
    L11:
        this.source.subscribe(this);
        r5 = addAndGet(-r5);
        if (r5 != 0) goto L6;
        return;
    L7:
        return;
    }
}
