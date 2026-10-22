package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableConcatMapCompletable$ConcatMapCompletableObserver<T> extends AtomicInteger implements g, Disposable {
    private static final long serialVersionUID = 3610901111000061034L;
    volatile boolean active;
    int consumed;
    volatile boolean disposed;
    volatile boolean done;
    final mt.b downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapInnerObserver inner;
    final o mapper;
    final int prefetch;
    final rt.g queue;
    zu.d upstream;

    public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements mt.b {
        private static final long serialVersionUID = 5638352172918776687L;
        final FlowableConcatMapCompletable$ConcatMapCompletableObserver<?> parent;

        public ConcatMapInnerObserver(FlowableConcatMapCompletable$ConcatMapCompletableObserver<?> r5) {
            this.parent = r5;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
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

    public FlowableConcatMapCompletable$ConcatMapCompletableObserver(mt.b r5, o r10, ErrorMode r11, int r12) {
        this.downstream = r5;
        this.mapper = r10;
        this.errorMode = r11;
        this.prefetch = r12;
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapInnerObserver(this);
        this.queue = new SpscArrayQueue(r12);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposed = true;
        this.upstream.cancel();
        this.inner.dispose();
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (this.disposed == true) goto L7;
        if (this.active == true) goto L39;
        if (this.errorMode == ErrorMode.BOUNDARY) goto L14;
    L17:
        boolean r5 = this.done;
        Object r10 = this.queue.poll();
        if (r10 != null) goto L20;
        boolean r11 = true;
    L21:
        if (r5 == false) goto L28;
        if (r11 == false) goto L28;
        Throwable r12 = this.errors.terminate();
        if (r12 == null) goto L26;
        this.downstream.onError(r12);
        return;
    L26:
        this.downstream.onComplete();
        return;
    L28:
        if (r11 == true) goto L39;
        int r13 = this.prefetch;
        int r14 = r13 - (r13 >> 1);
        int r15 = this.consumed + 1;
        if (r15 != r14) goto L32;
        this.consumed = 0;
        this.upstream.request(r14);
    L41:
        Object r16 = this.mapper.apply(r10);     // Catch: Throwable -> L35
        io.reactivex.internal.functions.e.d(r16, "The mapper returned a null CompletableSource");     // Catch: Throwable -> L35
        mt.c r17 = (mt.c) r16;     // Catch: Throwable -> L35
        this.active = true;
        ((mt.a) r17).b(this.inner);
    L35:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.queue.clear();
        this.upstream.cancel();
        this.errors.addThrowable(th);
        this.downstream.onError(this.errors.terminate());
        return;
    L32:
        this.consumed = r15;
        goto L41
    L20:
        r11 = false;
        goto L21
    L14:
        if (this.errors.get() == null) goto L17;
        this.queue.clear();
        this.downstream.onError(this.errors.terminate());
        return;
    L39:
        if (decrementAndGet() != 0) goto L6;
        return;
    L7:
        this.queue.clear();
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    public void innerError(Throwable r5) {
        if (this.errors.addThrowable(r5) == true) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
        this.upstream.cancel();
        Throwable r10 = this.errors.terminate();
        if (r10 == io.reactivex.internal.util.d.f18173a) goto L10;
        this.downstream.onError(r10);
    L10:
        if (getAndIncrement() != 0) goto L15;
        this.queue.clear();
        return;
    L15:
        return;
    L12:
        this.active = false;
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.errors.addThrowable(r5) == true) goto L5;
        wn.f.k(r5);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
        this.inner.dispose();
        Throwable r10 = this.errors.terminate();
        if (r10 == io.reactivex.internal.util.d.f18173a) goto L10;
        this.downstream.onError(r10);
    L10:
        if (getAndIncrement() != 0) goto L15;
        this.queue.clear();
        return;
    L15:
        return;
    L12:
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.queue.offer(r5) == false) goto L5;
        drain();
        return;
    L5:
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue full?!"));
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(this.prefetch);
        return;
    }
}
