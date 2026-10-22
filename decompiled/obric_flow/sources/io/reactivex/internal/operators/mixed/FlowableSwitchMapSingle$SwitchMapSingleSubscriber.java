package io.reactivex.internal.operators.mixed;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mt.a0;
import mt.b0;
import mt.c0;
import mt.g;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableSwitchMapSingle$SwitchMapSingleSubscriber<T, R> extends AtomicInteger implements g, zu.d {
    static final SwitchMapSingleObserver<Object> INNER_DISPOSED = null;
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final zu.c downstream;
    long emitted;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapSingleObserver<R>> inner;
    final o mapper;
    final AtomicLong requested;
    zu.d upstream;

    public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements b0 {
        private static final long serialVersionUID = 8042919737683345351L;
        volatile R item;
        final FlowableSwitchMapSingle$SwitchMapSingleSubscriber<?, R> parent;

        public SwitchMapSingleObserver(FlowableSwitchMapSingle$SwitchMapSingleSubscriber<?, R> r5) {
            this.parent = r5;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // mt.b0, mt.j
        public void onError(Throwable r5) {
            this.parent.innerError(this, r5);
        }

        @Override // mt.b0, mt.j
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }

        @Override // mt.b0, mt.j
        public void onSuccess(R r5) {
            this.item = r5;
            this.parent.drain();
        }
    }

    static {
        INNER_DISPOSED = new SwitchMapSingleObserver(null);
    }

    public FlowableSwitchMapSingle$SwitchMapSingleSubscriber(zu.c r5, o r10, boolean r11) {
        this.downstream = r5;
        this.mapper = r10;
        this.delayErrors = r11;
        this.errors = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.inner = new AtomicReference();
    }

    @Override // zu.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        disposeInner();
    }

    public void disposeInner() {
        AtomicReference<SwitchMapSingleObserver<R>> r5 = this.inner;
        SwitchMapSingleObserver<Object> r10 = INNER_DISPOSED;
        SwitchMapSingleObserver<R> r11 = r5.getAndSet((SwitchMapSingleObserver<R>) r10);
        if (r11 == null) goto L7;
        if (r11 == r10) goto L8;
        r11.dispose();
        return;
    L8:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        AtomicThrowable r10 = this.errors;
        AtomicReference<SwitchMapSingleObserver<R>> r11 = this.inner;
        AtomicLong r12 = this.requested;
        long r13 = this.emitted;
        int r14 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (r10.get() != null) goto L12;
    L15:
        boolean r15 = this.done;
        SwitchMapSingleObserver<R> r16 = r11.get();
        if (r16 != null) goto L18;
        boolean r17 = true;
    L19:
        if (r15 == false) goto L26;
        if (r17 == false) goto L26;
        Throwable r18 = r10.terminate();
        if (r18 == null) goto L24;
        r5.onError(r18);
        return;
    L24:
        r5.onComplete();
        return;
    L26:
        if (r17 == true) goto L38;
        if (r16.item == null) goto L38;
        if (r13 == r12.get()) goto L38;
    L33:
        if (r11.compareAndSet(r16, null) == true) goto L37;
        if (r11.get() == r16) goto L33;
    L37:
        r5.onNext(r16.item);
        r13 = r13 + 1;
    L38:
        this.emitted = r13;
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L7;
        return;
    L18:
        r17 = false;
        goto L19
    L12:
        if (this.delayErrors == true) goto L15;
        r5.onError(r10.terminate());
        return;
    }

    public void innerError(SwitchMapSingleObserver<R> r5, Throwable r10) {
        AtomicReference<SwitchMapSingleObserver<R>> r11 = this.inner;
    L4:
        if (r11.compareAndSet(r5, null) == true) goto L6;
        if (r11.get() == r5) goto L4;
    L14:
        wn.f.k(r10);
        return;
    L6:
        if (this.errors.addThrowable(r10) == false) goto L14;
        if (this.delayErrors == true) goto L10;
        this.upstream.cancel();
        disposeInner();
    L10:
        drain();
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
        if (this.delayErrors == true) goto L7;
        disposeInner();
    L7:
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onNext(T r5) {
        SwitchMapSingleObserver<R> r10 = this.inner.get();
        if (r10 == null) goto L21;
        r10.dispose();
    L21:
        Object r11 = this.mapper.apply(r5);     // Catch: Throwable -> L18
        io.reactivex.internal.functions.e.d(r11, "The mapper returned a null SingleSource");     // Catch: Throwable -> L18
        c0 r12 = (c0) r11;     // Catch: Throwable -> L18
        SwitchMapSingleObserver<R> r13 = new SwitchMapSingleObserver(this);
    L7:
        SwitchMapSingleObserver<R> r14 = this.inner.get();
        if (r14 == INNER_DISPOSED) goto L27;
        AtomicReference<SwitchMapSingleObserver<R>> r15 = this.inner;
    L12:
        if (r15.compareAndSet(r14, r13) == true) goto L13;
        if (r15.get() == r14) goto L12;
    L13:
        ((a0) r12).b(r13);
        return;
    L27:
        return;
    L18:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        this.inner.getAndSet((SwitchMapSingleObserver<R>) INNER_DISPOSED);
        onError(th);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        v0.r(this.requested, r5);
        drain();
    }
}
