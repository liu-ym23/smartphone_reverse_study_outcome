package io.reactivex.internal.operators.mixed;

import bc.e;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.a;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;
import xb.c;
import xb.g;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableConcatMapCompletable$ConcatMapCompletableObserver<T> extends AtomicInteger implements g<T>, b {
    private static final long serialVersionUID = 3610901111000061034L;
    volatile boolean active;
    int consumed;
    volatile boolean disposed;
    volatile boolean done;
    final xb.b downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapInnerObserver inner;
    final h<? super T, ? extends c> mapper;
    final int prefetch;
    final e<T> queue;
    d upstream;

    static final class ConcatMapInnerObserver extends AtomicReference<b> implements xb.b {
        private static final long serialVersionUID = 5638352172918776687L;
        final FlowableConcatMapCompletable$ConcatMapCompletableObserver<?> parent;

        ConcatMapInnerObserver(FlowableConcatMapCompletable$ConcatMapCompletableObserver<?> r10) {
            this.parent = r10;
        }

        void dispose() {
            DisposableHelper.dispose(this);
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

    FlowableConcatMapCompletable$ConcatMapCompletableObserver(xb.b r10, h<? super T, ? extends c> r11, ErrorMode r12, int r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.errorMode = r12;
        this.prefetch = r13;
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapInnerObserver(this);
        this.queue = new SpscArrayQueue(r13);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.disposed = true;
        this.upstream.cancel();
        this.inner.dispose();
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (this.disposed == true) goto L7;
        if (this.active == true) goto L39;
        if (this.errorMode == ErrorMode.BOUNDARY) goto L14;
    L17:
        boolean r10 = this.done;
        T r11 = this.queue.poll();
        if (r11 != null) goto L20;
        boolean r12 = true;
    L21:
        if (r10 == false) goto L28;
        if (r12 == false) goto L28;
        Throwable r13 = this.errors.terminate();
        xb.b r14 = this.downstream;
        if (r13 == null) goto L26;
        r14.onError(r13);
        return;
    L26:
        r14.onComplete();
        return;
    L28:
        if (r12 == true) goto L39;
        int r15 = this.prefetch;
        int r16 = r15 - (r15 >> 1);
        int r17 = this.consumed + 1;
        if (r17 != r16) goto L32;
        this.consumed = 0;
        this.upstream.request(r16);
    L41:
        c r18 = (c) a.d(this.mapper.apply(r11), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L35
        this.active = true;
        r18.a(this.inner);
    L35:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.queue.clear();
        this.upstream.cancel();
        this.errors.addThrowable(th);
        this.downstream.onError(this.errors.terminate());
        return;
    L32:
        this.consumed = r17;
        goto L41
    L20:
        r12 = false;
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

    void innerComplete() {
        this.active = false;
        drain();
    }

    void innerError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        dc.a.n(r10);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
        this.upstream.cancel();
        Throwable r11 = this.errors.terminate();
        if (r11 == ExceptionHelper.f9683a) goto L10;
        this.downstream.onError(r11);
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

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        dc.a.n(r10);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
        this.inner.dispose();
        Throwable r11 = this.errors.terminate();
        if (r11 == ExceptionHelper.f9683a) goto L10;
        this.downstream.onError(r11);
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

    @Override // tc.c
    public void onNext(T r10) {
        if (this.queue.offer(r10) == false) goto L5;
        drain();
        return;
    L5:
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue full?!"));
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    }
}
