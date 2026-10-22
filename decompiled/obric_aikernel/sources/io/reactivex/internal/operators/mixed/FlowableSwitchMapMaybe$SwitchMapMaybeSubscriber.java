package io.reactivex.internal.operators.mixed;

import dc.a;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tc.c;
import tc.d;
import xb.g;
import xb.j;
import xb.k;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements g<T>, d {
    static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = null;
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final c<? super R> downstream;
    long emitted;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapMaybeObserver<R>> inner;
    final h<? super T, ? extends k<? extends R>> mapper;
    final AtomicLong requested;
    d upstream;

    static final class SwitchMapMaybeObserver<R> extends AtomicReference<b> implements j<R> {
        private static final long serialVersionUID = 8042919737683345351L;
        volatile R item;
        final FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber<?, R> parent;

        SwitchMapMaybeObserver(FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber<?, R> r10) {
            this.parent = r10;
        }

        void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xb.j
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // xb.j
        public void onError(Throwable r10) {
            this.parent.innerError(this, r10);
        }

        @Override // xb.j
        public void onSubscribe(b r10) {
            DisposableHelper.setOnce(this, r10);
        }

        @Override // xb.j
        public void onSuccess(R r10) {
            this.item = r10;
            this.parent.drain();
        }
    }

    static {
        INNER_DISPOSED = new SwitchMapMaybeObserver(null);
    }

    FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber(c<? super R> r10, h<? super T, ? extends k<? extends R>> r11, boolean r12) {
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.errors = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.inner = new AtomicReference();
    }

    @Override // tc.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        disposeInner();
    }

    void disposeInner() {
        AtomicReference<SwitchMapMaybeObserver<R>> r10 = this.inner;
        SwitchMapMaybeObserver<Object> r11 = INNER_DISPOSED;
        SwitchMapMaybeObserver<R> r12 = r10.getAndSet((SwitchMapMaybeObserver<R>) r11);
        if (r12 == null) goto L7;
        if (r12 == r11) goto L8;
        r12.dispose();
        return;
    L8:
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        c<? super R> r10 = this.downstream;
        AtomicThrowable r11 = this.errors;
        AtomicReference<SwitchMapMaybeObserver<R>> r12 = this.inner;
        AtomicLong r13 = this.requested;
        long r14 = this.emitted;
        int r15 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (r11.get() != null) goto L12;
    L15:
        boolean r16 = this.done;
        SwitchMapMaybeObserver<R> r17 = r12.get();
        if (r17 != null) goto L18;
        boolean r18 = true;
    L19:
        if (r16 == false) goto L26;
        if (r18 == false) goto L26;
        Throwable r19 = r11.terminate();
        if (r19 == null) goto L24;
        r10.onError(r19);
        return;
    L24:
        r10.onComplete();
        return;
    L26:
        if (r18 == true) goto L33;
        if (r17.item == null) goto L33;
        if (r14 == r13.get()) goto L33;
        r12.compareAndSet(r17, null);
        r10.onNext(r17.item);
        r14 = r14 + 1;
    L33:
        this.emitted = r14;
        r15 = addAndGet(-r15);
        if (r15 != 0) goto L7;
        return;
    L18:
        r18 = false;
        goto L19
    L12:
        if (this.delayErrors == true) goto L15;
        r10.onError(r11.terminate());
        return;
    }

    void innerComplete(SwitchMapMaybeObserver<R> r10) {
        if (this.inner.compareAndSet(r10, null) == false) goto L6;
        drain();
        return;
    }

    void innerError(SwitchMapMaybeObserver<R> r10, Throwable r11) {
        if (this.inner.compareAndSet(r10, null) == true) goto L5;
    L11:
        a.n(r11);
        return;
    L5:
        if (this.errors.addThrowable(r11) == false) goto L11;
        if (this.delayErrors == true) goto L9;
        this.upstream.cancel();
        disposeInner();
    L9:
        drain();
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        a.n(r10);
        return;
    L5:
        if (this.delayErrors == true) goto L7;
        disposeInner();
    L7:
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onNext(T r10) {
        SwitchMapMaybeObserver<R> r11 = this.inner.get();
        if (r11 == null) goto L17;
        r11.dispose();
    L17:
        k r12 = (k) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L14
        SwitchMapMaybeObserver<R> r13 = new SwitchMapMaybeObserver(this);
    L7:
        SwitchMapMaybeObserver<R> r14 = this.inner.get();
        if (r14 == INNER_DISPOSED) goto L22;
        if (this.inner.compareAndSet(r14, r13) == false) goto L7;
        r12.a(r13);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        this.inner.getAndSet((SwitchMapMaybeObserver<R>) INNER_DISPOSED);
        onError(th);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
    }
}
