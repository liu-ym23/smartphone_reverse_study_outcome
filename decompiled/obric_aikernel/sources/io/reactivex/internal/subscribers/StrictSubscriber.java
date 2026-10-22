package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tc.c;
import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
public class StrictSubscriber<T> extends AtomicInteger implements g<T>, d {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final c<? super T> downstream;
    final AtomicThrowable error;
    final AtomicBoolean once;
    final AtomicLong requested;
    final AtomicReference<d> upstream;

    public StrictSubscriber(c<? super T> r10) {
        this.downstream = r10;
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
        this.once = new AtomicBoolean();
    }

    @Override // tc.d
    public void cancel() {
        if (this.done == true) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        return;
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        e.a(this.downstream, this, this.error);
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.done = true;
        e.c(this.downstream, r10, this, this.error);
    }

    @Override // tc.c
    public void onNext(T r10) {
        e.e(this.downstream, r10, this, this.error);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        this.downstream.onSubscribe(this);
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r10);
        return;
    L5:
        r10.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    @Override // tc.d
    public void request(long r10) {
        if (r10 > 0) goto L5;
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + r10));
        return;
    L5:
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }
}
