package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableConcatMap$ConcatMapInner<R> extends SubscriptionArbiter implements mt.g {
    private static final long serialVersionUID = 897683679971470653L;
    final e parent;
    long produced;

    public FlowableConcatMap$ConcatMapInner(e r5) {
        super(false);
        this.parent = r5;
    }

    @Override // zu.c
    public void onComplete() {
        long r5 = this.produced;
        if (r5 == 0) goto L5;
        this.produced = 0;
        produced(r5);
    L5:
        this.parent.innerComplete();
    }

    @Override // zu.c
    public void onError(Throwable r10) {
        long r5 = this.produced;
        if (r5 == 0) goto L5;
        this.produced = 0;
        produced(r5);
    L5:
        this.parent.innerError(r10);
    }

    @Override // zu.c
    public void onNext(R r5) {
        this.produced++;
        this.parent.innerNext(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        setSubscription(r5);
    }
}
