package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableRetryBiPredicate$RetryBiSubscriber<T> extends AtomicInteger implements mt.g {
    private static final long serialVersionUID = -7098360935104053232L;
    final zu.c downstream;
    final pt.d predicate;
    long produced;
    int retries;

    /* JADX INFO: renamed from: sa, reason: collision with root package name */
    final SubscriptionArbiter f17650sa;
    final zu.b source;

    public FlowableRetryBiPredicate$RetryBiSubscriber(zu.c r5, pt.d r10, SubscriptionArbiter r11, zu.b r12) {
        this.downstream = r5;
        this.f17650sa = r11;
        this.source = r12;
        this.predicate = r10;
    }

    @Override // zu.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        pt.d r10 = this.predicate;     // Catch: Throwable -> L8
        int r11 = this.retries + 1;     // Catch: Throwable -> L8
        this.retries = r11;     // Catch: Throwable -> L8
        Integer r12 = Integer.valueOf(r11);     // Catch: Throwable -> L8
        ((com.lynx.tasm.utils.c) r10).getClass();     // Catch: Throwable -> L8
        if (io.reactivex.internal.functions.e.b(r12, r5) == true) goto L6;
        this.downstream.onError(r5);
        return;
    L6:
        subscribeNext();
        return;
    L8:
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
        this.f17650sa.setSubscription(r5);
    }

    public void subscribeNext() {
        if (getAndIncrement() != 0) goto L13;
        int r5 = 1;
    L6:
        if (this.f17650sa.isCancelled() == true) goto L7;
        long r10 = this.produced;
        if (r10 == 0) goto L11;
        this.produced = 0;
        this.f17650sa.produced(r10);
    L11:
        this.source.subscribe(this);
        r5 = addAndGet(-r5);
        if (r5 != 0) goto L6;
        return;
    L7:
        return;
    }
}
