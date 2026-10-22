package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableTake$TakeSubscriber<T> extends AtomicBoolean implements mt.g, zu.d {
    private static final long serialVersionUID = -5636543848937116287L;
    boolean done;
    final zu.c downstream;
    final long limit;
    long remaining;
    zu.d upstream;

    public FlowableTake$TakeSubscriber(zu.c r5, long r10) {
        this.downstream = r5;
        this.limit = r10;
        this.remaining = r10;
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        this.downstream.onComplete();
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == true) goto L5;
        this.done = true;
        this.upstream.cancel();
        this.downstream.onError(r5);
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // zu.c
    public void onNext(T r10) {
        if (this.done == true) goto L14;
        long r5 = this.remaining;
        long r11 = r5 - 1;
        this.remaining = r11;
        if (r5 > 0) goto L7;
        return;
    L7:
        if (r11 != 0) goto L9;
        boolean r12 = true;
    L10:
        this.downstream.onNext(r10);
        if (r12 == false) goto L16;
        this.upstream.cancel();
        onComplete();
        return;
    L16:
        return;
    L9:
        r12 = false;
        goto L10
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L9;
        this.upstream = r5;
        if (this.limit != 0) goto L7;
        r5.cancel();
        this.done = true;
        EmptySubscription.complete(this.downstream);
        return;
    L7:
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == true) goto L6;
        return;
    L6:
        if (get() == false) goto L8;
    L13:
        this.upstream.request(r5);
        return;
    L8:
        if (compareAndSet(false, true) == false) goto L13;
        if (r5 < this.limit) goto L13;
        this.upstream.request(Long.MAX_VALUE);
    }
}
