package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableOnBackpressureDrop$BackpressureDropSubscriber<T> extends AtomicLong implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -6246093802440953054L;
    boolean done;
    final tc.c<? super T> downstream;
    final zb.g<? super T> onDrop;
    tc.d upstream;

    FlowableOnBackpressureDrop$BackpressureDropSubscriber(tc.c<? super T> r10, zb.g<? super T> r11) {
        this.downstream = r10;
        this.onDrop = r11;
    }

    @Override // tc.d
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.downstream.onComplete();
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
        if (get() == 0) goto L13;
        this.downstream.onNext(r10);
        io.reactivex.internal.util.b.e(this, 1);
        return;
    L13:
        this.onDrop.accept(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        onError(th);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this, r10);
        return;
    }
}
