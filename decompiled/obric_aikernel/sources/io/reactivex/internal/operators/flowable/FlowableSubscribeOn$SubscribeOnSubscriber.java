package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableSubscribeOn$SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements xb.g<T>, tc.d, Runnable {
    private static final long serialVersionUID = 8094547886072529208L;
    final tc.c<? super T> downstream;
    final boolean nonScheduledRequests;
    final AtomicLong requested;
    tc.b<T> source;
    final AtomicReference<tc.d> upstream;
    final xb.p.c worker;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final tc.d f9508c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final long f9509g;

        a(tc.d r10, long r11) {
            this.f9508c = r10;
            this.f9509g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9508c.request(this.f9509g);
        }
    }

    FlowableSubscribeOn$SubscribeOnSubscriber(tc.c<? super T> r10, xb.p.c r11, tc.b<T> r12, boolean r13) {
        this.downstream = r10;
        this.worker = r11;
        this.source = r12;
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
        this.nonScheduledRequests = !r13;
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    @Override // tc.c
    public void onComplete() {
        this.downstream.onComplete();
        this.worker.dispose();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
        this.worker.dispose();
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.setOnce(this.upstream, r10) == false) goto L8;
        long r11 = this.requested.getAndSet(0);
        if (r11 == 0) goto L9;
        requestUpstream(r11, r10);
        return;
    L9:
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L13;
        tc.d r11 = this.upstream.get();
        if (r11 == null) goto L7;
        requestUpstream(r10, r11);
        return;
    L7:
        io.reactivex.internal.util.b.a(this.requested, r10);
        tc.d r12 = this.upstream.get();
        if (r12 == null) goto L15;
        long r13 = this.requested.getAndSet(0);
        if (r13 == 0) goto L16;
        requestUpstream(r13, r12);
        return;
    L16:
        return;
    L15:
        return;
    }

    void requestUpstream(long r10, tc.d r11) {
        if (this.nonScheduledRequests == false) goto L5;
    L8:
        r11.request(r10);
        return;
    L5:
        if (Thread.currentThread() == get()) goto L8;
        this.worker.b(new a(r11, r10));
    }

    @Override // java.lang.Runnable
    public void run() {
        lazySet(Thread.currentThread());
        tc.b<T> r10 = this.source;
        this.source = null;
        r10.subscribe(this);
    }
}
