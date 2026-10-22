package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableAll$AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements xb.g<T> {
    private static final long serialVersionUID = -3521127104134758517L;
    boolean done;
    final zb.i<? super T> predicate;
    tc.d upstream;

    FlowableAll$AllSubscriber(tc.c<? super Boolean> r10, zb.i<? super T> r11) {
        super(r10);
        this.predicate = r11;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        complete(Boolean.TRUE);
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == false) goto L12;
        return;
    L12:
        if (this.predicate.test(r10) == true) goto L14;
        this.done = true;
        this.upstream.cancel();
        complete(Boolean.FALSE);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }
}
