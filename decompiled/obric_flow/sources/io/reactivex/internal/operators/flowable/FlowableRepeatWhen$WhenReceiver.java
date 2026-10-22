package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableRepeatWhen$WhenReceiver<T, U> extends AtomicInteger implements mt.g, zu.d {
    private static final long serialVersionUID = 2827772011130406689L;
    final AtomicLong requested;
    final zu.b source;
    FlowableRepeatWhen$WhenSourceSubscriber<T, U> subscriber;
    final AtomicReference<zu.d> upstream;

    public FlowableRepeatWhen$WhenReceiver(zu.b r5) {
        this.source = r5;
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
    }

    @Override // zu.c
    public void onComplete() {
        this.subscriber.cancel();
        this.subscriber.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.subscriber.cancel();
        this.subscriber.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(Object r5) {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        if (this.upstream.get() == SubscriptionHelper.CANCELLED) goto L6;
        this.source.subscribe(this.subscriber);
        if (decrementAndGet() != 0) goto L5;
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r5);
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r5);
    }
}
