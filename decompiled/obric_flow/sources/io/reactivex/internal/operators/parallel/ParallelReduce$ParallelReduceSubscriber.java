package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.functions.e;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import pt.c;
import wn.f;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class ParallelReduce$ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
    private static final long serialVersionUID = 8200530050639449080L;
    R accumulator;
    boolean done;
    final c reducer;

    public ParallelReduce$ParallelReduceSubscriber(zu.c r5, R r10, c r11) {
        super(r5);
        this.accumulator = r10;
        this.reducer = r11;
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, zu.c
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        R r5 = this.accumulator;
        this.accumulator = null;
        complete(r5);
        return;
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        f.k(r5);
        return;
    L6:
        this.done = true;
        this.accumulator = null;
        this.downstream.onError(r5);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, zu.c
    public void onNext(T r5) {
        if (this.done == true) goto L11;
        R r10 = (R) this.reducer.apply(this.accumulator, r5);
        e.d(r10, "The reducer returned a null value");     // Catch: Throwable -> L6
        this.accumulator = r10;
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancel();
        onError(th);
        return;
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
