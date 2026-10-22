package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableRetryPredicate$RetrySubscriber<T> extends AtomicInteger implements xb.g<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final tc.c<? super T> downstream;
    final zb.i<? super Throwable> predicate;
    long produced;
    long remaining;

    /* JADX INFO: renamed from: sa, reason: collision with root package name */
    final SubscriptionArbiter f9503sa;
    final tc.b<? extends T> source;

    FlowableRetryPredicate$RetrySubscriber(tc.c<? super T> r10, long r11, zb.i<? super Throwable> r12, SubscriptionArbiter r13, tc.b<? extends T> r14) {
        this.downstream = r10;
        this.f9503sa = r13;
        this.source = r14;
        this.predicate = r12;
        this.remaining = r11;
    }

    @Override // tc.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        long r11 = this.remaining;
        if (r11 == Long.MAX_VALUE) goto L6;
        this.remaining = r11 - 1;
    L6:
        if (r11 != 0) goto L17;
        this.downstream.onError(r10);
        return;
    L17:
        if (this.predicate.test(r10) == true) goto L12;
        this.downstream.onError(r10);
        return;
    L12:
        subscribeNext();
        return;
    L14:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.produced++;
        this.downstream.onNext(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        this.f9503sa.setSubscription(r10);
    }

    void subscribeNext() {
        if (getAndIncrement() != 0) goto L13;
        int r10 = 1;
    L6:
        if (this.f9503sa.isCancelled() == true) goto L7;
        long r11 = this.produced;
        if (r11 == 0) goto L11;
        this.produced = 0;
        this.f9503sa.produced(r11);
    L11:
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L7:
        return;
    }
}
