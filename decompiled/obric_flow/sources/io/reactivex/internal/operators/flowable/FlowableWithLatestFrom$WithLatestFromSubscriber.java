package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableWithLatestFrom$WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements rt.a, zu.d {
    private static final long serialVersionUID = -312246233408980075L;
    final pt.c combiner;
    final zu.c downstream;
    final AtomicReference<zu.d> other;
    final AtomicLong requested;
    final AtomicReference<zu.d> upstream;

    public FlowableWithLatestFrom$WithLatestFromSubscriber(zu.c r5, pt.c r10) {
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
        this.other = new AtomicReference();
        this.downstream = r5;
        this.combiner = r10;
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // zu.c
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (tryOnNext(r5) == true) goto L6;
        this.upstream.get().request(1);
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r5);
    }

    public void otherError(Throwable r5) {
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(r5);
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r5);
    }

    public boolean setOther(zu.d r5) {
        return SubscriptionHelper.setOnce(this.other, r5);
    }

    @Override // rt.a
    public boolean tryOnNext(T r5) {
        U r10 = get();
        if (r10 != null) goto L10;
    L9:
        return false;
    L10:
        Object r11 = this.combiner.apply(r5, r10);     // Catch: Throwable -> L7
        io.reactivex.internal.functions.e.d(r11, "The combiner returned a null value");     // Catch: Throwable -> L7
        this.downstream.onNext(r11);
        return true;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancel();
        this.downstream.onError(th);
        goto L9
    }
}
