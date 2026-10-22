package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableWithLatestFrom$WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements bc.a<T>, tc.d {
    private static final long serialVersionUID = -312246233408980075L;
    final zb.c<? super T, ? super U, ? extends R> combiner;
    final tc.c<? super R> downstream;
    final AtomicReference<tc.d> other;
    final AtomicLong requested;
    final AtomicReference<tc.d> upstream;

    FlowableWithLatestFrom$WithLatestFromSubscriber(tc.c<? super R> r10, zb.c<? super T, ? super U, ? extends R> r11) {
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
        this.other = new AtomicReference();
        this.downstream = r10;
        this.combiner = r11;
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // tc.c
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onComplete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (tryOnNext(r10) == true) goto L6;
        this.upstream.get().request(1);
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r10);
    }

    public void otherError(Throwable r10) {
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(r10);
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }

    public boolean setOther(tc.d r10) {
        return SubscriptionHelper.setOnce(this.other, r10);
    }

    @Override // bc.a
    public boolean tryOnNext(T r10) {
        U r11 = get();
        if (r11 != null) goto L10;
    L9:
        return false;
    L10:
        Object r12 = io.reactivex.internal.functions.a.d(this.combiner.apply(r10, r11), "The combiner returned a null value");     // Catch: Throwable -> L7
        this.downstream.onNext(r12);
        return true;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        this.downstream.onError(th);
        goto L9
    }
}
