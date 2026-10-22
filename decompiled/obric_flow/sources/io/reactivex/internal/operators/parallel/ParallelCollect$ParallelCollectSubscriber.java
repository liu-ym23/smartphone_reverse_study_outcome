package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import pt.b;
import wn.f;
import zu.c;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class ParallelCollect$ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
    private static final long serialVersionUID = -4767392946044436228L;
    C collection;
    final b collector;
    boolean done;

    public ParallelCollect$ParallelCollectSubscriber(c r5, C r10, b r11) {
        super(r5);
        this.collection = r10;
        this.collector = r11;
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        C r5 = this.collection;
        this.collection = null;
        complete(r5);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        f.k(r5);
        return;
    L6:
        this.done = true;
        this.collection = null;
        this.downstream.onError(r5);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, zu.c
    public void onNext(T r5) {
        if (this.done == false) goto L10;
        return;
    L10:
        this.collector.accept(this.collection, r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancel();
        onError(th);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, zu.c
    public void onSubscribe(d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }
}
