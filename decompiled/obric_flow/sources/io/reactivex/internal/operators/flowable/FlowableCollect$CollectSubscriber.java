package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableCollect$CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements mt.g {
    private static final long serialVersionUID = -3589550218733891694L;
    final pt.b collector;
    boolean done;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final U f17643u;
    zu.d upstream;

    public FlowableCollect$CollectSubscriber(zu.c r5, U r10, pt.b r11) {
        super(r5);
        this.collector = r11;
        this.f17643u = r10;
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
        complete(this.f17643u);
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
        if (this.done == false) goto L10;
        return;
    L10:
        this.collector.accept(this.f17643u, r5);     // Catch: Throwable -> L7
        return;
    L7:
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
