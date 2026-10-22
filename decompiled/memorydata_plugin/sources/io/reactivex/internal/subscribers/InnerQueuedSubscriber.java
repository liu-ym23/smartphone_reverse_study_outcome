package io.reactivex.internal.subscribers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.a.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.h;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<d> implements j<T>, d {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final c<T> parent;
    final int prefetch;
    long produced;
    volatile f<T> queue;

    public InnerQueuedSubscriber(c<T> r3, int r4) {
        this.parent = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.prefetch = r4;
        this.limit = r4 - (r4 >> 2);
    }

    @Override // org.a.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // org.a.c
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // org.a.c
    public void onError(Throwable r2) {
        this.parent.innerError(this, r2);
    }

    @Override // org.a.c
    public void onNext(T r2) {
        if (this.fusionMode != 0) goto L5;
        this.parent.innerNext(this, r2);
        return;
    L5:
        this.parent.drain();
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        if (SubscriptionHelper.setOnce(this, r5) == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L14;
        io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
        int r1 = r0.requestFusion(3);
        if (r1 != 1) goto L11;
        this.fusionMode = r1;
        this.queue = r0;
        this.done = true;
        this.parent.innerComplete(this);
        return;
    L11:
        if (r1 != 2) goto L14;
        this.fusionMode = r1;
        this.queue = r0;
        h.a(r5, this.prefetch);
        return;
    L14:
        this.queue = h.a(this.prefetch);
        h.a(r5, this.prefetch);
    }

    public f<T> queue() {
        return this.queue;
    }

    @Override // org.a.d
    public void request(long r3) {
        if (this.fusionMode == 1) goto L9;
        long r0 = this.produced + r3;
        if (r0 < this.limit) goto L7;
        this.produced = 0;
        ((d) ZeusTransformUtils.preCheckCast(get(), d.class, "com.obric.memorydata.plugin")).request(r0);
        return;
    L7:
        this.produced = r0;
        return;
    }

    public void requestOne() {
        if (this.fusionMode == 1) goto L9;
        long r0 = this.produced + 1;
        if (r0 != this.limit) goto L7;
        this.produced = 0;
        ((d) ZeusTransformUtils.preCheckCast(get(), d.class, "com.obric.memorydata.plugin")).request(r0);
        return;
    L7:
        this.produced = r0;
        return;
    }

    public void setDone() {
        this.done = true;
    }
}
