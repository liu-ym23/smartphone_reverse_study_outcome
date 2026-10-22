package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableRepeat$RepeatSubscriber<T> extends AtomicInteger implements xb.g<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final tc.c<? super T> downstream;
    long produced;
    long remaining;

    /* JADX INFO: renamed from: sa, reason: collision with root package name */
    final SubscriptionArbiter f9500sa;
    final tc.b<? extends T> source;

    FlowableRepeat$RepeatSubscriber(tc.c<? super T> r10, long r11, SubscriptionArbiter r12, tc.b<? extends T> r13) {
        this.downstream = r10;
        this.f9500sa = r12;
        this.source = r13;
        this.remaining = r11;
    }

    @Override // tc.c
    public void onComplete() {
        long r10 = this.remaining;
        if (r10 == Long.MAX_VALUE) goto L6;
        this.remaining = r10 - 1;
    L6:
        if (r10 == 0) goto L8;
        subscribeNext();
        return;
    L8:
        this.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.produced++;
        this.downstream.onNext(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        this.f9500sa.setSubscription(r10);
    }

    void subscribeNext() {
        if (getAndIncrement() != 0) goto L13;
        int r10 = 1;
    L6:
        if (this.f9500sa.isCancelled() == true) goto L7;
        long r11 = this.produced;
        if (r11 == 0) goto L11;
        this.produced = 0;
        this.f9500sa.produced(r11);
    L11:
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L7:
        return;
    }
}
