package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableLimit$LimitSubscriber<T> extends AtomicLong implements mt.g, zu.d {
    private static final long serialVersionUID = 2288246011222124525L;
    final zu.c downstream;
    long remaining;
    zu.d upstream;

    public FlowableLimit$LimitSubscriber(zu.c r5, long r10) {
        this.downstream = r5;
        this.remaining = r10;
        lazySet(r10);
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // zu.c
    public void onComplete() {
        if (this.remaining <= 0) goto L6;
        this.remaining = 0;
        this.downstream.onComplete();
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.remaining <= 0) goto L5;
        this.remaining = 0;
        this.downstream.onError(r5);
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // zu.c
    public void onNext(T r10) {
        long r5 = this.remaining;
        if (r5 <= 0) goto L8;
        long r11 = r5 - 1;
        this.remaining = r11;
        this.downstream.onNext(r10);
        if (r11 != 0) goto L9;
        this.upstream.cancel();
        this.downstream.onComplete();
        return;
    L9:
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == true) goto L5;
        return;
    L5:
        if (this.remaining != 0) goto L7;
        r5.cancel();
        EmptySubscription.complete(this.downstream);
        return;
    L7:
        this.upstream = r5;
        this.downstream.onSubscribe(this);
    }

    @Override // zu.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L18;
    L4:
        long r5 = get();
        if (r5 == 0) goto L19;
        if (r5 > r10) goto L10;
        long r11 = r5;
    L12:
        if (compareAndSet(r5, r5 - r11) == false) goto L4;
        this.upstream.request(r11);
        return;
    L10:
        r11 = r10;
        goto L12
    L19:
        return;
    }
}
