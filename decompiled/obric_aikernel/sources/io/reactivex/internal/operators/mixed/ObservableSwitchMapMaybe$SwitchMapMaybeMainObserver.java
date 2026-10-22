package io.reactivex.internal.operators.mixed;

import dc.a;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.k;
import xb.o;
import zb.h;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements o<T>, b {
    static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = null;
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final o<? super R> downstream;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapMaybeObserver<R>> inner;
    final h<? super T, ? extends k<? extends R>> mapper;
    b upstream;

    static final class SwitchMapMaybeObserver<R> extends AtomicReference<b> implements j<R> {
        private static final long serialVersionUID = 8042919737683345351L;
        volatile R item;
        final ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<?, R> parent;

        SwitchMapMaybeObserver(ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<?, R> r10) {
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

    ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver(o<? super R> r10, h<? super T, ? extends k<? extends R>> r11, boolean r12) {
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.errors = new AtomicThrowable();
        this.inner = new AtomicReference();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
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
        o<? super R> r10 = this.downstream;
        AtomicThrowable r11 = this.errors;
        AtomicReference<SwitchMapMaybeObserver<R>> r12 = this.inner;
        int r13 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (r11.get() != null) goto L12;
    L15:
        boolean r14 = this.done;
        SwitchMapMaybeObserver<R> r15 = r12.get();
        if (r15 != null) goto L18;
        boolean r16 = true;
    L19:
        if (r14 == false) goto L26;
        if (r16 == false) goto L26;
        Throwable r17 = r11.terminate();
        if (r17 == null) goto L24;
        r10.onError(r17);
        return;
    L24:
        r10.onComplete();
        return;
    L26:
        if (r16 == true) goto L31;
        if (r15.item == null) goto L31;
        r12.compareAndSet(r15, null);
        r10.onNext(r15.item);
    L31:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L18:
        r16 = false;
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
        this.upstream.dispose();
        disposeInner();
    L9:
        drain();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // xb.o
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // xb.o
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

    @Override // xb.o
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
        this.upstream.dispose();
        this.inner.getAndSet((SwitchMapMaybeObserver<R>) INNER_DISPOSED);
        onError(th);
    }

    @Override // xb.o
    public void onSubscribe(b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
