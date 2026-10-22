package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableAll$AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements mt.g {
    private static final long serialVersionUID = -3521127104134758517L;
    boolean done;
    final pt.p predicate;
    zu.d upstream;

    public FlowableAll$AllSubscriber(zu.c r5, pt.p r10) {
        super(r5);
        this.predicate = r10;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        complete(Boolean.TRUE);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.done == false) goto L12;
        return;
    L12:
        if (this.predicate.test(r5) == true) goto L14;
        this.done = true;
        this.upstream.cancel();
        complete(Boolean.FALSE);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }
}
