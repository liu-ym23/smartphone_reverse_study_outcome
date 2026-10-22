package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableReduce$ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements mt.g {
    private static final long serialVersionUID = -4663883003264602070L;
    final pt.c reducer;
    zu.d upstream;

    public FlowableReduce$ReduceSubscriber(zu.c r5, pt.c r10) {
        super(r5);
        this.reducer = r10;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
        this.upstream = SubscriptionHelper.CANCELLED;
    }

    @Override // zu.c
    public void onComplete() {
        zu.d r5 = this.upstream;
        SubscriptionHelper r10 = SubscriptionHelper.CANCELLED;
        if (r5 != r10) goto L5;
        return;
    L5:
        this.upstream = r10;
        T r11 = this.value;
        if (r11 == null) goto L8;
        complete(r11);
        return;
    L8:
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        zu.d r10 = this.upstream;
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 != r11) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.upstream = r11;
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.upstream != SubscriptionHelper.CANCELLED) goto L5;
        return;
    L5:
        T r10 = this.value;
        if (r10 != null) goto L13;
        this.value = r5;
        return;
    L13:
        T r11 = (T) this.reducer.apply(r10, r5);
        io.reactivex.internal.functions.e.d(r11, "The reducer returned a null value");     // Catch: Throwable -> L10
        this.value = r11;     // Catch: Throwable -> L10
        return;
    L10:
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
