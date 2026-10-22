package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableRepeatUntil$RepeatSubscriber<T> extends AtomicInteger implements xb.g<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final tc.c<? super T> downstream;
    long produced;

    /* JADX INFO: renamed from: sa, reason: collision with root package name */
    final SubscriptionArbiter f9501sa;
    final tc.b<? extends T> source;
    final zb.e stop;

    FlowableRepeatUntil$RepeatSubscriber(tc.c<? super T> r10, zb.e r11, SubscriptionArbiter r12, tc.b<? extends T> r13) {
        this.downstream = r10;
        this.f9501sa = r12;
        this.source = r13;
        this.stop = r11;
    }

    @Override // tc.c
    public void onComplete() {
        if (this.stop.getAsBoolean() == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        subscribeNext();
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
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
        this.f9501sa.setSubscription(r10);
    }

    void subscribeNext() {
        if (getAndIncrement() != 0) goto L13;
        int r10 = 1;
    L6:
        if (this.f9501sa.isCancelled() == true) goto L7;
        long r11 = this.produced;
        if (r11 == 0) goto L11;
        this.produced = 0;
        this.f9501sa.produced(r11);
    L11:
        this.source.subscribe(this);
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L7:
        return;
    }
}
