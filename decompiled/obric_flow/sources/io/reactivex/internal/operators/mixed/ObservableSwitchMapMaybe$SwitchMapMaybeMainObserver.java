package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mt.h;
import mt.j;
import mt.k;
import mt.u;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements u, Disposable {
    static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = null;
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final u downstream;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapMaybeObserver<R>> inner;
    final o mapper;
    Disposable upstream;

    public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements j {
        private static final long serialVersionUID = 8042919737683345351L;
        volatile R item;
        final ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<?, R> parent;

        public SwitchMapMaybeObserver(ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<?, R> r5) {
            this.parent = r5;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // mt.j
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // mt.j
        public void onError(Throwable r5) {
            this.parent.innerError(this, r5);
        }

        @Override // mt.j
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }

        @Override // mt.j
        public void onSuccess(R r5) {
            this.item = r5;
            this.parent.drain();
        }
    }

    static {
        INNER_DISPOSED = new SwitchMapMaybeObserver(null);
    }

    public ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver(u r5, o r10, boolean r11) {
        this.downstream = r5;
        this.mapper = r10;
        this.delayErrors = r11;
        this.errors = new AtomicThrowable();
        this.inner = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        disposeInner();
    }

    public void disposeInner() {
        AtomicReference<SwitchMapMaybeObserver<R>> r5 = this.inner;
        SwitchMapMaybeObserver<Object> r10 = INNER_DISPOSED;
        SwitchMapMaybeObserver<R> r11 = r5.getAndSet((SwitchMapMaybeObserver<R>) r10);
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
        u r5 = this.downstream;
        AtomicThrowable r10 = this.errors;
        AtomicReference<SwitchMapMaybeObserver<R>> r11 = this.inner;
        int r12 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (r10.get() != null) goto L12;
    L15:
        boolean r13 = this.done;
        SwitchMapMaybeObserver<R> r14 = r11.get();
        if (r14 != null) goto L18;
        boolean r15 = true;
    L19:
        if (r13 == false) goto L26;
        if (r15 == false) goto L26;
        Throwable r16 = r10.terminate();
        if (r16 == null) goto L24;
        r5.onError(r16);
        return;
    L24:
        r5.onComplete();
        return;
    L26:
        if (r15 == true) goto L36;
        if (r14.item == null) goto L36;
    L31:
        if (r11.compareAndSet(r14, null) == true) goto L35;
        if (r11.get() == r14) goto L31;
    L35:
        r5.onNext(r14.item);
    L36:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L7;
        return;
    L18:
        r15 = false;
        goto L19
    L12:
        if (this.delayErrors == true) goto L15;
        r5.onError(r10.terminate());
        return;
    }

    public void innerComplete(SwitchMapMaybeObserver<R> r5) {
        AtomicReference<SwitchMapMaybeObserver<R>> r10 = this.inner;
    L4:
        if (r10.compareAndSet(r5, null) == true) goto L5;
        if (r10.get() == r5) goto L4;
        return;
    L5:
        drain();
    }

    public void innerError(SwitchMapMaybeObserver<R> r5, Throwable r10) {
        AtomicReference<SwitchMapMaybeObserver<R>> r11 = this.inner;
    L4:
        if (r11.compareAndSet(r5, null) == true) goto L6;
        if (r11.get() == r5) goto L4;
    L14:
        wn.f.k(r10);
        return;
    L6:
        if (this.errors.addThrowable(r10) == false) goto L14;
        if (this.delayErrors == true) goto L10;
        this.upstream.dispose();
        disposeInner();
    L10:
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // mt.u
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // mt.u
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

    @Override // mt.u
    public void onNext(T r5) {
        SwitchMapMaybeObserver<R> r10 = this.inner.get();
        if (r10 == null) goto L21;
        r10.dispose();
    L21:
        Object r11 = this.mapper.apply(r5);     // Catch: Throwable -> L18
        io.reactivex.internal.functions.e.d(r11, "The mapper returned a null MaybeSource");     // Catch: Throwable -> L18
        k r12 = (k) r11;     // Catch: Throwable -> L18
        SwitchMapMaybeObserver<R> r13 = new SwitchMapMaybeObserver(this);
    L7:
        SwitchMapMaybeObserver<R> r14 = this.inner.get();
        if (r14 == INNER_DISPOSED) goto L27;
        AtomicReference<SwitchMapMaybeObserver<R>> r15 = this.inner;
    L12:
        if (r15.compareAndSet(r14, r13) == true) goto L13;
        if (r15.get() == r14) goto L12;
    L13:
        ((h) r12).b(r13);
        return;
    L27:
        return;
    L18:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.dispose();
        this.inner.getAndSet((SwitchMapMaybeObserver<R>) INNER_DISPOSED);
        onError(th);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
