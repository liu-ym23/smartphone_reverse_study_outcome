package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableTake$TakeSubscriber<T> extends AtomicBoolean implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -5636543848937116287L;
    boolean done;
    final tc.c<? super T> downstream;
    final long limit;
    long remaining;
    tc.d upstream;

    FlowableTake$TakeSubscriber(tc.c<? super T> r10, long r11) {
        this.downstream = r10;
        this.limit = r11;
        this.remaining = r11;
    }

    @Override // tc.d
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        this.downstream.onComplete();
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == true) goto L5;
        this.done = true;
        this.upstream.cancel();
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == true) goto L14;
        long r11 = this.remaining;
        long r12 = r11 - 1;
        this.remaining = r12;
        if (r11 > 0) goto L7;
        return;
    L7:
        if (r12 != 0) goto L9;
        boolean r13 = true;
    L10:
        this.downstream.onNext(r10);
        if (r13 == false) goto L16;
        this.upstream.cancel();
        onComplete();
        return;
    L16:
        return;
    L9:
        r13 = false;
        goto L10
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L9;
        this.upstream = r10;
        if (this.limit != 0) goto L7;
        r10.cancel();
        this.done = true;
        EmptySubscription.complete(this.downstream);
        return;
    L7:
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L6;
        return;
    L6:
        if (get() == false) goto L8;
    L14:
        tc.d r11 = this.upstream;
    L12:
        r11.request(r10);
        return;
    L8:
        if (compareAndSet(false, true) == false) goto L14;
        if (r10 < this.limit) goto L14;
        r11 = this.upstream;
        r10 = Long.MAX_VALUE;
        goto L12
    }
}
