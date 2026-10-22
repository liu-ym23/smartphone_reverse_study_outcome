package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableSwitchMap$SwitchMapObserver<T, R> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b {
    static final ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> CANCELLED = null;
    private static final long serialVersionUID = -3491074160481096299L;
    final AtomicReference<ObservableSwitchMap$SwitchMapInnerObserver<T, R>> active;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final xb.o<? super R> downstream;
    final AtomicThrowable errors;
    final zb.h<? super T, ? extends xb.n<? extends R>> mapper;
    volatile long unique;
    io.reactivex.disposables.b upstream;

    static {
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> r10 = new ObservableSwitchMap$SwitchMapInnerObserver(null, -1, 1);
        CANCELLED = r10;
        r10.cancel();
    }

    ObservableSwitchMap$SwitchMapObserver(xb.o<? super R> r10, zb.h<? super T, ? extends xb.n<? extends R>> r11, int r12, boolean r13) {
        this.active = new AtomicReference();
        this.downstream = r10;
        this.mapper = r11;
        this.bufferSize = r12;
        this.delayErrors = r13;
        this.errors = new AtomicThrowable();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        this.upstream.dispose();
        disposeInner();
        return;
    }

    void disposeInner() {
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r10 = this.active.get();
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> r11 = CANCELLED;
        if (r10 == r11) goto L9;
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r12 = this.active.getAndSet((ObservableSwitchMap$SwitchMapInnerObserver<T, R>) r11);
        if (r12 == r11) goto L10;
        if (r12 == null) goto L11;
        r12.cancel();
        return;
    L11:
        return;
    L10:
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        xb.o<? super R> r10 = this.downstream;
        AtomicReference<ObservableSwitchMap$SwitchMapInnerObserver<T, R>> r11 = this.active;
        boolean r12 = this.delayErrors;
        int r13 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (this.done == true) goto L12;
    L29:
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r14 = r11.get();
        if (r14 == null) goto L74;
        bc.f<R> r15 = r14.queue;
        if (r15 == null) goto L74;
        if (r14.done == false) goto L44;
        boolean r16 = r15.isEmpty();
        if (r12 == false) goto L40;
        if (r16 == false) goto L44;
    L38:
        r11.compareAndSet(r14, null);
        goto L7
    L40:
        if (this.errors.get() != null) goto L24;
        if (r16 == false) goto L44;
    L24:
        r10.onError(this.errors.terminate());
        return;
    L44:
        boolean r17 = false;
    L46:
        if (this.cancelled == true) goto L47;
        if (r14 != r11.get()) goto L50;
        if (r12 == false) goto L53;
    L55:
        boolean r18 = r14.done;
        a1.c r19 = r15.poll();     // Catch: Throwable -> L58
    L64:
        if (r19 != null) goto L66;
        boolean r110 = true;
    L67:
        if (r18 == false) goto L70;
        if (r110 == false) goto L70;
        r11.compareAndSet(r14, null);
    L70:
        if (r110 == true) goto L71;
        r10.onNext(r19);
    L71:
        if (r17 == false) goto L74;
    L66:
        r110 = false;
    L58:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.errors.addThrowable(th);
        r11.compareAndSet(r14, null);
        if (r12 == true) goto L62;
        disposeInner();
        this.upstream.dispose();
        this.done = true;
    L63:
        r17 = true;
        r19 = null;
        goto L64
    L62:
        r14.cancel();
        goto L63
    L53:
        if (this.errors.get() == null) goto L55;
    L50:
        r17 = true;
        goto L71
    L47:
        return;
    L74:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L12:
        if (r11.get() != null) goto L14;
        boolean r20 = true;
    L15:
        if (r12 == false) goto L23;
        if (r20 == false) goto L29;
        Throwable r111 = this.errors.get();
        if (r111 == null) goto L20;
        r10.onError(r111);
        return;
    L20:
        r10.onComplete();
        return;
    L23:
        if (this.errors.get() != null) goto L24;
        if (r20 == false) goto L29;
        r10.onComplete();
        return;
    L14:
        r20 = false;
        goto L15
    }

    void innerError(ObservableSwitchMap$SwitchMapInnerObserver<T, R> r10, Throwable r11) {
        if (r10.index == this.unique) goto L5;
    L10:
        dc.a.n(r11);
        return;
    L5:
        if (this.errors.addThrowable(r11) == false) goto L10;
        if (this.delayErrors == true) goto L9;
        this.upstream.dispose();
    L9:
        r10.done = true;
        drain();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // xb.o
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        drain();
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.done == false) goto L5;
    L10:
        dc.a.n(r10);
        return;
    L5:
        if (this.errors.addThrowable(r10) == false) goto L10;
        if (this.delayErrors == true) goto L9;
        disposeInner();
    L9:
        this.done = true;
        drain();
    }

    @Override // xb.o
    public void onNext(T r10) {
        long r11 = this.unique + 1;
        this.unique = r11;
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r12 = this.active.get();
        if (r12 == null) goto L17;
        r12.cancel();
    L17:
        xb.n r13 = (xb.n) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The ObservableSource returned is null");     // Catch: Throwable -> L14
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r14 = new ObservableSwitchMap$SwitchMapInnerObserver(this, r11, this.bufferSize);
    L7:
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r15 = this.active.get();
        if (r15 == CANCELLED) goto L22;
        if (this.active.compareAndSet(r15, r14) == false) goto L7;
        r13.subscribe(r14);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.dispose();
        onError(th);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
