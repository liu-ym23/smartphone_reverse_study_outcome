package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mt.b;
import mt.c;
import mt.g;
import rt.e;
import rt.h;
import wn.f;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableConcat$CompletableConcatSubscriber extends AtomicInteger implements g, Disposable {
    private static final long serialVersionUID = 9032184911934499404L;
    volatile boolean active;
    int consumed;
    volatile boolean done;
    final b downstream;
    final ConcatInnerObserver inner;
    final int limit;
    final AtomicBoolean once;
    final int prefetch;
    h queue;
    int sourceFused;
    d upstream;

    public static final class ConcatInnerObserver extends AtomicReference<Disposable> implements b {
        private static final long serialVersionUID = -5454794857847146511L;
        final CompletableConcat$CompletableConcatSubscriber parent;

        public ConcatInnerObserver(CompletableConcat$CompletableConcatSubscriber r5) {
            this.parent = r5;
        }

        @Override // mt.b
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // mt.b
        public void onError(Throwable r5) {
            this.parent.innerError(r5);
        }

        @Override // mt.b
        public void onSubscribe(Disposable r5) {
            DisposableHelper.replace(this, r5);
        }
    }

    public CompletableConcat$CompletableConcatSubscriber(b r5, int r10) {
        this.downstream = r5;
        this.prefetch = r10;
        this.inner = new ConcatInnerObserver(this);
        this.once = new AtomicBoolean();
        this.limit = r10 - (r10 >> 2);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.cancel();
        DisposableHelper.dispose(this.inner);
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (isDisposed() == true) goto L7;
        if (this.active == true) goto L28;
        boolean r5 = this.done;
        c r10 = (c) this.queue.poll();     // Catch: Throwable -> L24
        if (r10 != null) goto L15;
        boolean r11 = true;
    L16:
        if (r5 == false) goto L22;
        if (r11 == false) goto L22;
        if (this.once.compareAndSet(false, true) == false) goto L36;
        this.downstream.onComplete();
        return;
    L36:
        return;
    L22:
        if (r11 == true) goto L28;
        this.active = true;
        ((mt.a) r10).b(this.inner);
        request();
        goto L28
    L15:
        r11 = false;
    L24:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        innerError(th);
        return;
    L28:
        if (decrementAndGet() != 0) goto L6;
        return;
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    public void innerError(Throwable r5) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        this.upstream.cancel();
        this.downstream.onError(r5);
        return;
    L5:
        f.k(r5);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.inner.get());
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        DisposableHelper.dispose(this.inner);
        this.downstream.onError(r5);
        return;
    L5:
        f.k(r5);
    }

    @Override // zu.c
    public /* bridge */ /* synthetic */ void onNext(Object r5) {
        onNext((c) r5);
    }

    @Override // zu.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L24;
        this.upstream = r10;
        int r5 = this.prefetch;
        if (r5 != Integer.MAX_VALUE) goto L7;
        long r11 = Long.MAX_VALUE;
    L9:
        if ((r10 instanceof e) == false) goto L19;
        e r12 = (e) r10;
        int r13 = r12.requestFusion(3);
        if (r13 != 1) goto L15;
        this.sourceFused = r13;
        this.queue = r12;
        this.done = true;
        this.downstream.onSubscribe(this);
        drain();
        return;
    L15:
        if (r13 != 2) goto L19;
        this.sourceFused = r13;
        this.queue = r12;
        this.downstream.onSubscribe(this);
        r10.request(r11);
        return;
    L19:
        if (this.prefetch != Integer.MAX_VALUE) goto L21;
        this.queue = new io.reactivex.internal.queue.b(mt.e.f20168a);
    L22:
        this.downstream.onSubscribe(this);
        r10.request(r11);
        return;
    L21:
        this.queue = new SpscArrayQueue(this.prefetch);
        goto L22
    L7:
        r11 = r5;
        goto L9
    }

    public void request() {
        if (this.sourceFused == 1) goto L9;
        int r5 = this.consumed + 1;
        if (r5 != this.limit) goto L7;
        this.consumed = 0;
        this.upstream.request(r5);
        return;
    L7:
        this.consumed = r5;
        return;
    }

    public void onNext(c r5) {
        if (this.sourceFused == 0) goto L5;
    L8:
        drain();
        return;
    L5:
        if (this.queue.offer(r5) == true) goto L8;
        onError(new MissingBackpressureException());
    }
}
