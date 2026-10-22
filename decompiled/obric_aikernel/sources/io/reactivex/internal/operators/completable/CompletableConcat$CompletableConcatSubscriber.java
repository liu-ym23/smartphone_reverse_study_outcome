package io.reactivex.internal.operators.completable;

import bc.f;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.c;
import xb.e;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableConcat$CompletableConcatSubscriber extends AtomicInteger implements g<c>, b {
    private static final long serialVersionUID = 9032184911934499404L;
    volatile boolean active;
    int consumed;
    volatile boolean done;
    final xb.b downstream;
    final ConcatInnerObserver inner;
    final int limit;
    final AtomicBoolean once;
    final int prefetch;
    f<c> queue;
    int sourceFused;
    d upstream;

    static final class ConcatInnerObserver extends AtomicReference<b> implements xb.b {
        private static final long serialVersionUID = -5454794857847146511L;
        final CompletableConcat$CompletableConcatSubscriber parent;

        ConcatInnerObserver(CompletableConcat$CompletableConcatSubscriber r10) {
            this.parent = r10;
        }

        @Override // xb.b
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // xb.b
        public void onError(Throwable r10) {
            this.parent.innerError(r10);
        }

        @Override // xb.b
        public void onSubscribe(b r10) {
            DisposableHelper.replace(this, r10);
        }
    }

    CompletableConcat$CompletableConcatSubscriber(xb.b r10, int r11) {
        this.downstream = r10;
        this.prefetch = r11;
        this.inner = new ConcatInnerObserver(this);
        this.once = new AtomicBoolean();
        this.limit = r11 - (r11 >> 2);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.upstream.cancel();
        DisposableHelper.dispose(this.inner);
    }

    void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (isDisposed() == true) goto L7;
        if (this.active == true) goto L28;
        boolean r10 = this.done;
        c r11 = this.queue.poll();     // Catch: Throwable -> L24
        if (r11 != null) goto L15;
        boolean r12 = true;
    L16:
        if (r10 == false) goto L22;
        if (r12 == false) goto L22;
        if (this.once.compareAndSet(false, true) == false) goto L36;
        this.downstream.onComplete();
        return;
    L36:
        return;
    L22:
        if (r12 == true) goto L28;
        this.active = true;
        r11.a(this.inner);
        request();
        goto L28
    L15:
        r12 = false;
    L24:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        innerError(th);
        return;
    L28:
        if (decrementAndGet() != 0) goto L6;
        return;
    }

    void innerComplete() {
        this.active = false;
        drain();
    }

    void innerError(Throwable r10) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        this.upstream.cancel();
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.inner.get());
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        DisposableHelper.dispose(this.inner);
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // tc.c
    public /* bridge */ /* synthetic */ void onNext(Object r10) {
        onNext((c) r10);
    }

    public void onNext(c r10) {
        if (this.sourceFused == 0) goto L5;
    L8:
        drain();
        return;
    L5:
        if (this.queue.offer(r10) == true) goto L8;
        onError(new MissingBackpressureException());
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L24;
        this.upstream = r10;
        int r11 = this.prefetch;
        if (r11 != Integer.MAX_VALUE) goto L7;
        long r12 = Long.MAX_VALUE;
    L9:
        if ((r10 instanceof bc.d) == false) goto L19;
        bc.d r13 = (bc.d) r10;
        int r14 = r13.requestFusion(3);
        if (r14 != 1) goto L15;
        this.sourceFused = r14;
        this.queue = r13;
        this.done = true;
        this.downstream.onSubscribe(this);
        drain();
        return;
    L15:
        if (r14 != 2) goto L19;
        this.sourceFused = r14;
        this.queue = r13;
        this.downstream.onSubscribe(this);
        r10.request(r12);
        return;
    L19:
        if (this.prefetch != Integer.MAX_VALUE) goto L21;
        f<c> r15 = new io.reactivex.internal.queue.a(e.a());
    L22:
        this.queue = r15;
        this.downstream.onSubscribe(this);
        r10.request(r12);
        return;
    L21:
        r15 = new SpscArrayQueue(this.prefetch);
        goto L22
    L7:
        r12 = r11;
        goto L9
    }

    void request() {
        if (this.sourceFused == 1) goto L9;
        int r10 = this.consumed + 1;
        if (r10 != this.limit) goto L7;
        this.consumed = 0;
        this.upstream.request(r10);
        return;
    L7:
        this.consumed = r10;
        return;
    }
}
