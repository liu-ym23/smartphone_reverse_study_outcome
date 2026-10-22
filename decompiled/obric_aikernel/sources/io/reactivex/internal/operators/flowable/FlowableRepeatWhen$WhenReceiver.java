package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableRepeatWhen$WhenReceiver<T, U> extends AtomicInteger implements xb.g<Object>, tc.d {
    private static final long serialVersionUID = 2827772011130406689L;
    final AtomicLong requested;
    final tc.b<T> source;
    FlowableRepeatWhen$WhenSourceSubscriber<T, U> subscriber;
    final AtomicReference<tc.d> upstream;

    FlowableRepeatWhen$WhenReceiver(tc.b<T> r10) {
        this.source = r10;
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
    }

    @Override // tc.c
    public void onComplete() {
        this.subscriber.cancel();
        this.subscriber.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.subscriber.cancel();
        this.subscriber.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(Object r10) {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        if (this.upstream.get() == SubscriptionHelper.CANCELLED) goto L6;
        this.source.subscribe(this.subscriber);
        if (decrementAndGet() != 0) goto L5;
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r10);
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }
}
