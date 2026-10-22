package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableSingle$SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements xb.g<T> {
    private static final long serialVersionUID = -5526049321428043809L;
    final T defaultValue;
    boolean done;
    final boolean failOnEmpty;
    tc.d upstream;

    FlowableSingle$SingleElementSubscriber(tc.c<? super T> r10, T r11, boolean r12) {
        super(r10);
        this.defaultValue = r11;
        this.failOnEmpty = r12;
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
        T r10 = this.value;
        this.value = null;
        if (r10 != null) goto L8;
        r10 = this.defaultValue;
    L8:
        if (r10 != null) goto L13;
        boolean r11 = this.failOnEmpty;
        tc.c<? super T> r12 = this.downstream;
        if (r11 == false) goto L12;
        r12.onError(new NoSuchElementException());
        return;
    L12:
        r12.onComplete();
        return;
    L13:
        complete(r10);
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
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.value == null) goto L9;
        this.done = true;
        this.upstream.cancel();
        this.downstream.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        return;
    L9:
        this.value = r10;
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
