package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableConcatMap$ConcatMapInner<R> extends SubscriptionArbiter implements xb.g<R> {
    private static final long serialVersionUID = 897683679971470653L;
    final c<R> parent;
    long produced;

    FlowableConcatMap$ConcatMapInner(c<R> r10) {
        super(false);
        this.parent = r10;
    }

    @Override // tc.c
    public void onComplete() {
        long r10 = this.produced;
        if (r10 == 0) goto L5;
        this.produced = 0;
        produced(r10);
    L5:
        this.parent.innerComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        long r11 = this.produced;
        if (r11 == 0) goto L5;
        this.produced = 0;
        produced(r11);
    L5:
        this.parent.innerError(r10);
    }

    @Override // tc.c
    public void onNext(R r10) {
        this.produced++;
        this.parent.innerNext(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        setSubscription(r10);
    }
}
