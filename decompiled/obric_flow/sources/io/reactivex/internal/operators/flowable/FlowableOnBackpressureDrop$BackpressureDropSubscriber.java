package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableOnBackpressureDrop$BackpressureDropSubscriber<T> extends AtomicLong implements mt.g, zu.d {
    private static final long serialVersionUID = -6246093802440953054L;
    boolean done;
    final zu.c downstream;
    final pt.g onDrop;
    zu.d upstream;

    public FlowableOnBackpressureDrop$BackpressureDropSubscriber(zu.c r5, pt.g r10) {
        this.downstream = r5;
        this.onDrop = r10;
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.downstream.onComplete();
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
        if (this.done == false) goto L6;
        return;
    L6:
        if (get() == 0) goto L13;
        this.downstream.onNext(r5);
        v0.y(this, 1);
        return;
    L13:
        this.onDrop.accept(r5);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancel();
        onError(th);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this, r5);
        return;
    }
}
