package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableOnErrorNext$OnErrorNextSubscriber<T> extends SubscriptionArbiter implements mt.g {
    private static final long serialVersionUID = 4063763155303814625L;
    final boolean allowFatal;
    boolean done;
    final zu.c downstream;
    final pt.o nextSupplier;
    boolean once;
    long produced;

    public FlowableOnErrorNext$OnErrorNextSubscriber(zu.c r5, pt.o r10, boolean r11) {
        super(false);
        this.downstream = r5;
        this.nextSupplier = r10;
        this.allowFatal = r11;
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.once = true;
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r10) {
        if (this.once == true) goto L5;
        this.once = true;
        if (this.allowFatal == true) goto L13;
    L25:
        Object r5 = this.nextSupplier.apply(r10);     // Catch: Throwable -> L22
        io.reactivex.internal.functions.e.d(r5, "The nextSupplier returned a null Publisher");     // Catch: Throwable -> L22
        zu.b r11 = (zu.b) r5;     // Catch: Throwable -> L22
        long r12 = this.produced;
        if (r12 == 0) goto L20;
        produced(r12);
    L20:
        r11.subscribe(this);
        return;
    L22:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
        return;
    L13:
        if ((r10 instanceof Exception) == true) goto L25;
        this.downstream.onError(r10);
        return;
    L5:
        if (this.done == false) goto L8;
        wn.f.k(r10);
        return;
    L8:
        this.downstream.onError(r10);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.once == true) goto L8;
        this.produced++;
    L8:
        this.downstream.onNext(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        setSubscription(r5);
    }
}
