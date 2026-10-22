package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;

/* JADX INFO: loaded from: classes2.dex */
final class m<T> implements xb.g<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final tc.c<? super T> f9517c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final SubscriptionArbiter f9518g;

    m(tc.c<? super T> r10, SubscriptionArbiter r11) {
        this.f9517c = r10;
        this.f9518g = r11;
    }

    @Override // tc.c
    public void onComplete() {
        this.f9517c.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.f9517c.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.f9517c.onNext(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        this.f9518g.setSubscription(r10);
    }
}
