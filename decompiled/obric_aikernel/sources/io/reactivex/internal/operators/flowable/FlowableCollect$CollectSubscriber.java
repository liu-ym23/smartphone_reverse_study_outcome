package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableCollect$CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements xb.g<T> {
    private static final long serialVersionUID = -3589550218733891694L;
    final zb.b<? super U, ? super T> collector;
    boolean done;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final U f9494u;
    tc.d upstream;

    FlowableCollect$CollectSubscriber(tc.c<? super U> r10, U r11, zb.b<? super U, ? super T> r12) {
        super(r10);
        this.collector = r12;
        this.f9494u = r11;
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
        complete(this.f9494u);
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
        if (this.done == false) goto L10;
        return;
    L10:
        this.collector.accept(this.f9494u, r10);     // Catch: Throwable -> L7
        return;
    L7:
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
