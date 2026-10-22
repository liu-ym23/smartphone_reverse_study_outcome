package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements mt.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zu.c f17669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SubscriptionArbiter f17670b;

    public v(zu.c r5, SubscriptionArbiter r10) {
        this.f17669a = r5;
        this.f17670b = r10;
    }

    @Override // zu.c
    public final void onComplete() {
        this.f17669a.onComplete();
    }

    @Override // zu.c
    public final void onError(Throwable r5) {
        this.f17669a.onError(r5);
    }

    @Override // zu.c
    public final void onNext(Object r5) {
        this.f17669a.onNext(r5);
    }

    @Override // zu.c
    public final void onSubscribe(zu.d r5) {
        this.f17670b.setSubscription(r5);
    }
}
