package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableRetryPredicate$RetrySubscriber<T> extends AtomicInteger implements mt.g {
    private static final long serialVersionUID = -7098360935104053232L;
    final zu.c downstream;
    final pt.p predicate;
    long produced;
    long remaining;

    /* JADX INFO: renamed from: sa, reason: collision with root package name */
    final SubscriptionArbiter f17651sa;
    final zu.b source;

    public FlowableRetryPredicate$RetrySubscriber(zu.c r5, long r10, pt.p r11, SubscriptionArbiter r12, zu.b r13) {
        this.downstream = r5;
        this.f17651sa = r12;
        this.source = r13;
        this.predicate = r11;
        this.remaining = r10;
    }

    @Override // zu.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        long r10 = this.remaining;
        if (r10 == Long.MAX_VALUE) goto L6;
        this.remaining = r10 - 1;
    L6:
        if (r10 != 0) goto L17;
        this.downstream.onError(r5);
        return;
    L17:
        if (this.predicate.test(r5) == true) goto L12;
        this.downstream.onError(r5);
        return;
    L12:
        subscribeNext();
        return;
    L14:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.produced++;
        this.downstream.onNext(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        this.f17651sa.setSubscription(r5);
    }

    public void subscribeNext() {
        if (getAndIncrement() != 0) goto L13;
        int r5 = 1;
    L6:
        if (this.f17651sa.isCancelled() == true) goto L7;
        long r10 = this.produced;
        if (r10 == 0) goto L11;
        this.produced = 0;
        this.f17651sa.produced(r10);
    L11:
        this.source.subscribe(this);
        r5 = addAndGet(-r5);
        if (r5 != 0) goto L6;
        return;
    L7:
        return;
    }
}
