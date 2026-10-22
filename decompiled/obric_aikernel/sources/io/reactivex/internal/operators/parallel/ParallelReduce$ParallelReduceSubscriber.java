package io.reactivex.internal.operators.parallel;

import dc.a;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import tc.d;
import zb.c;

/* JADX INFO: loaded from: classes2.dex */
final class ParallelReduce$ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
    private static final long serialVersionUID = 8200530050639449080L;
    R accumulator;
    boolean done;
    final c<R, ? super T, R> reducer;

    ParallelReduce$ParallelReduceSubscriber(tc.c<? super R> r10, R r11, c<R, ? super T, R> r12) {
        super(r10);
        this.accumulator = r11;
        this.reducer = r12;
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, tc.c
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        R r10 = this.accumulator;
        this.accumulator = null;
        complete(r10);
        return;
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, tc.c
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        a.n(r10);
        return;
    L6:
        this.done = true;
        this.accumulator = null;
        this.downstream.onError(r10);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, tc.c
    public void onNext(T r10) {
        if (this.done == true) goto L11;
        this.accumulator = (R) io.reactivex.internal.functions.a.d(this.reducer.apply(this.accumulator, r10), "The reducer returned a null value");
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        onError(th);
        return;
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }
}
