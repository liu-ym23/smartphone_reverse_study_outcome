package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableLimit$LimitSubscriber<T> extends AtomicLong implements xb.g<T>, tc.d {
    private static final long serialVersionUID = 2288246011222124525L;
    final tc.c<? super T> downstream;
    long remaining;
    tc.d upstream;

    FlowableLimit$LimitSubscriber(tc.c<? super T> r10, long r11) {
        this.downstream = r10;
        this.remaining = r11;
        lazySet(r11);
    }

    @Override // tc.d
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // tc.c
    public void onComplete() {
        if (this.remaining <= 0) goto L6;
        this.remaining = 0;
        this.downstream.onComplete();
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.remaining <= 0) goto L5;
        this.remaining = 0;
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        long r11 = this.remaining;
        if (r11 <= 0) goto L8;
        long r12 = r11 - 1;
        this.remaining = r12;
        this.downstream.onNext(r10);
        if (r12 != 0) goto L9;
        this.upstream.cancel();
        this.downstream.onComplete();
        return;
    L9:
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == true) goto L5;
        return;
    L5:
        if (this.remaining != 0) goto L7;
        r10.cancel();
        EmptySubscription.complete(this.downstream);
        return;
    L7:
        this.upstream = r10;
        this.downstream.onSubscribe(this);
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L18;
    L4:
        long r11 = get();
        if (r11 == 0) goto L19;
        if (r11 > r10) goto L10;
        long r12 = r11;
    L12:
        if (compareAndSet(r11, r11 - r12) == false) goto L4;
        this.upstream.request(r12);
        return;
    L10:
        r12 = r10;
        goto L12
    L19:
        return;
    }
}
