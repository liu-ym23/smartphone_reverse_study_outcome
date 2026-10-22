package io.reactivex.internal.subscribers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public class StrictSubscriber<T> extends AtomicInteger implements j<T>, d {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final org.a.c<? super T> downstream;
    final AtomicThrowable error;
    final AtomicBoolean once;
    final AtomicLong requested;
    final AtomicReference<d> upstream;

    public StrictSubscriber(org.a.c<? super T> r3) {
        this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
        this.once = new AtomicBoolean();
    }

    @Override // org.a.d
    public void cancel() {
        if (this.done == true) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        return;
    }

    @Override // org.a.c
    public void onComplete() {
        this.done = true;
        e.a(this.downstream, this, this.error);
    }

    @Override // org.a.c
    public void onError(Throwable r3) {
        this.done = true;
        e.a(this.downstream, r3, this, this.error);
    }

    @Override // org.a.c
    public void onNext(T r3) {
        e.a(this.downstream, r3, this, this.error);
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        if (this.once.compareAndSet(false, true) == false) goto L5;
        this.downstream.onSubscribe(this);
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r5);
        return;
    L5:
        r5.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    @Override // org.a.d
    public void request(long r4) {
        if (r4 > 0) goto L5;
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + r4));
        return;
    L5:
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r4);
    }
}
