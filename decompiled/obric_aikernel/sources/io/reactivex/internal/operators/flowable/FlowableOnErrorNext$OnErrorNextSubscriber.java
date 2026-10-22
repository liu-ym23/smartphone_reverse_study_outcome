package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableOnErrorNext$OnErrorNextSubscriber<T> extends SubscriptionArbiter implements xb.g<T> {
    private static final long serialVersionUID = 4063763155303814625L;
    final boolean allowFatal;
    boolean done;
    final tc.c<? super T> downstream;
    final zb.h<? super Throwable, ? extends tc.b<? extends T>> nextSupplier;
    boolean once;
    long produced;

    FlowableOnErrorNext$OnErrorNextSubscriber(tc.c<? super T> r10, zb.h<? super Throwable, ? extends tc.b<? extends T>> r11, boolean r12) {
        super(false);
        this.downstream = r10;
        this.nextSupplier = r11;
        this.allowFatal = r12;
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.once = true;
        this.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.once == true) goto L5;
        this.once = true;
        if (this.allowFatal == true) goto L13;
    L25:
        tc.b r11 = (tc.b) io.reactivex.internal.functions.a.d(this.nextSupplier.apply(r10), "The nextSupplier returned a null Publisher");     // Catch: Throwable -> L22
        long r12 = this.produced;
        if (r12 == 0) goto L20;
        produced(r12);
    L20:
        r11.subscribe(this);
        return;
    L22:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
        return;
    L13:
        if ((r10 instanceof Exception) == true) goto L25;
        this.downstream.onError(r10);
        return;
    L5:
        if (this.done == false) goto L8;
        dc.a.n(r10);
        return;
    L8:
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.once == true) goto L8;
        this.produced++;
    L8:
        this.downstream.onNext(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        setSubscription(r10);
    }
}
