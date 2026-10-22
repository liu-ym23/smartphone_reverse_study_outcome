package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableElementAt$ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements mt.g {
    private static final long serialVersionUID = 4066607327284737757L;
    long count;
    final T defaultValue;
    boolean done;
    final boolean errorOnFewer;
    final long index;
    zu.d upstream;

    public FlowableElementAt$ElementAtSubscriber(zu.c r5, long r10, T r11, boolean r12) {
        super(r5);
        this.index = r10;
        this.defaultValue = r11;
        this.errorOnFewer = r12;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == true) goto L12;
        this.done = true;
        T r5 = this.defaultValue;
        if (r5 == null) goto L7;
        complete(r5);
        return;
    L7:
        if (this.errorOnFewer == false) goto L9;
        this.downstream.onError(new NoSuchElementException());
        return;
    L9:
        this.downstream.onComplete();
        return;
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
        if (this.done == false) goto L5;
        return;
    L5:
        long r10 = this.count;
        if (r10 != this.index) goto L9;
        this.done = true;
        this.upstream.cancel();
        complete(r5);
        return;
    L9:
        this.count = r10 + 1;
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
