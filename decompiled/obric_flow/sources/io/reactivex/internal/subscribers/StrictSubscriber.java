package io.reactivex.internal.subscribers;

import com.lynx.tasm.behavior.ui.utils.p;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import zu.c;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public class StrictSubscriber<T> extends AtomicInteger implements g, d {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final c downstream;
    final AtomicThrowable error;
    final AtomicBoolean once;
    final AtomicLong requested;
    final AtomicReference<d> upstream;

    public StrictSubscriber(c r5) {
        this.downstream = r5;
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
        this.once = new AtomicBoolean();
    }

    @Override // zu.d
    public void cancel() {
        if (this.done == true) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        return;
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        p.v(this.downstream, this, this.error);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.done = true;
        p.x(this.downstream, r5, this, this.error);
    }

    @Override // zu.c
    public void onNext(T r5) {
        p.z(this.downstream, r5, this, this.error);
    }

    @Override // zu.c
    public void onSubscribe(d r5) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        this.downstream.onSubscribe(this);
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r5);
        return;
    L5:
        r5.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    @Override // zu.d
    public void request(long r5) {
        if (r5 > 0) goto L5;
        cancel();
        onError(new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r5, "§3.9 violated: positive request amount required but it was ")));
        return;
    L5:
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r5);
    }
}
