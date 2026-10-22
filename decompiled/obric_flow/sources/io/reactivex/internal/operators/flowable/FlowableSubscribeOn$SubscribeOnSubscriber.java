package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableSubscribeOn$SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements mt.g, zu.d, Runnable {
    private static final long serialVersionUID = 8094547886072529208L;
    final zu.c downstream;
    final boolean nonScheduledRequests;
    final AtomicLong requested;
    zu.b source;
    final AtomicReference<zu.d> upstream;
    final mt.y worker;

    public FlowableSubscribeOn$SubscribeOnSubscriber(zu.c r5, mt.y r10, zu.b r11, boolean r12) {
        this.downstream = r5;
        this.worker = r10;
        this.source = r11;
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
        this.nonScheduledRequests = !r12;
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    @Override // zu.c
    public void onComplete() {
        this.downstream.onComplete();
        this.worker.dispose();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
        this.worker.dispose();
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r10) {
        if (SubscriptionHelper.setOnce(this.upstream, r10) == false) goto L8;
        long r5 = this.requested.getAndSet(0);
        if (r5 == 0) goto L9;
        requestUpstream(r5, r10);
        return;
    L9:
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L13;
        zu.d r10 = this.upstream.get();
        if (r10 == null) goto L7;
        requestUpstream(r5, r10);
        return;
    L7:
        v0.r(this.requested, r5);
        zu.d r11 = this.upstream.get();
        if (r11 == null) goto L15;
        long r12 = this.requested.getAndSet(0);
        if (r12 == 0) goto L16;
        requestUpstream(r12, r11);
        return;
    L16:
        return;
    L15:
        return;
    }

    public void requestUpstream(long r5, zu.d r10) {
        if (this.nonScheduledRequests == false) goto L5;
    L8:
        r10.request(r5);
        return;
    L5:
        if (Thread.currentThread() == get()) goto L8;
        this.worker.a(new com.bytedance.ies.bullet.ui.common.e(r10, r5, 3));
    }

    @Override // java.lang.Runnable
    public void run() {
        lazySet(Thread.currentThread());
        zu.b r5 = this.source;
        this.source = null;
        r5.subscribe(this);
    }
}
