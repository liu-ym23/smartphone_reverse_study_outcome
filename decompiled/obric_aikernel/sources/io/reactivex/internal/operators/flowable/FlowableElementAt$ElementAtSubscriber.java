package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableElementAt$ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements xb.g<T> {
    private static final long serialVersionUID = 4066607327284737757L;
    long count;
    final T defaultValue;
    boolean done;
    final boolean errorOnFewer;
    final long index;
    tc.d upstream;

    FlowableElementAt$ElementAtSubscriber(tc.c<? super T> r10, long r11, T r12, boolean r13) {
        super(r10);
        this.index = r11;
        this.defaultValue = r12;
        this.errorOnFewer = r13;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == true) goto L12;
        this.done = true;
        T r10 = this.defaultValue;
        if (r10 != null) goto L10;
        boolean r11 = this.errorOnFewer;
        tc.c<? super T> r12 = this.downstream;
        if (r11 == false) goto L9;
        r12.onError(new NoSuchElementException());
        return;
    L9:
        r12.onComplete();
        return;
    L10:
        complete(r10);
        return;
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
        if (this.done == false) goto L5;
        return;
    L5:
        long r11 = this.count;
        if (r11 != this.index) goto L9;
        this.done = true;
        this.upstream.cancel();
        complete(r10);
        return;
    L9:
        this.count = r11 + 1;
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
