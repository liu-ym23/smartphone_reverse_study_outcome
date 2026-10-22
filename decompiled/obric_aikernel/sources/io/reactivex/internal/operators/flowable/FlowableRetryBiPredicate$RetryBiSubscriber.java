package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableRetryBiPredicate$RetryBiSubscriber<T> extends AtomicInteger implements xb.g<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final tc.c<? super T> downstream;
    final zb.d<? super Integer, ? super Throwable> predicate;
    long produced;
    int retries;

    /* JADX INFO: renamed from: sa, reason: collision with root package name */
    final SubscriptionArbiter f9502sa;
    final tc.b<? extends T> source;

    FlowableRetryBiPredicate$RetryBiSubscriber(tc.c<? super T> r10, zb.d<? super Integer, ? super Throwable> r11, SubscriptionArbiter r12, tc.b<? extends T> r13) {
        this.downstream = r10;
        this.f9502sa = r12;
        this.source = r13;
        this.predicate = r11;
    }

    @Override // tc.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        zb.d<? super Integer, ? super Throwable> r11 = this.predicate;     // Catch: Throwable -> L9
        int r12 = this.retries + 1;     // Catch: Throwable -> L9
        this.retries = r12;     // Catch: Throwable -> L9
        if (r11.a(Integer.valueOf(r12), r10) == true) goto L7;
        this.downstream.onError(r10);
        return;
    L7:
        subscribeNext();
        return;
    L9:
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
        this.f9502sa.setSubscription(r10);
    }

    void subscribeNext() {
        if (getAndIncrement() != 0) goto L13;
        int r10 = 1;
    L6:
        if (this.f9502sa.isCancelled() == true) goto L7;
        long r11 = this.produced;
        if (r11 == 0) goto L11;
        this.produced = 0;
        this.f9502sa.produced(r11);
    L11:
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L7:
        return;
    }
}
