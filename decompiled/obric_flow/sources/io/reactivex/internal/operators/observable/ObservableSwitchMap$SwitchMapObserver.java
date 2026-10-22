package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableSwitchMap$SwitchMapObserver<T, R> extends AtomicInteger implements mt.u, Disposable {
    static final ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> CANCELLED = null;
    private static final long serialVersionUID = -3491074160481096299L;
    final AtomicReference<ObservableSwitchMap$SwitchMapInnerObserver<T, R>> active;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final mt.u downstream;
    final AtomicThrowable errors;
    final pt.o mapper;
    volatile long unique;
    Disposable upstream;

    static {
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> r5 = new ObservableSwitchMap$SwitchMapInnerObserver(null, -1, 1);
        CANCELLED = r5;
        r5.cancel();
    }

    public ObservableSwitchMap$SwitchMapObserver(mt.u r5, pt.o r10, int r11, boolean r12) {
        this.active = new AtomicReference();
        this.downstream = r5;
        this.mapper = r10;
        this.bufferSize = r11;
        this.delayErrors = r12;
        this.errors = new AtomicThrowable();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        this.upstream.dispose();
        disposeInner();
        return;
    }

    public void disposeInner() {
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r5 = this.active.get();
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> r10 = CANCELLED;
        if (r5 == r10) goto L9;
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r11 = this.active.getAndSet((ObservableSwitchMap$SwitchMapInnerObserver<T, R>) r10);
        if (r11 == r10) goto L10;
        if (r11 == null) goto L11;
        r11.cancel();
        return;
    L11:
        return;
    L10:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        mt.u r5 = this.downstream;
        AtomicReference<ObservableSwitchMap$SwitchMapInnerObserver<T, R>> r10 = this.active;
        boolean r11 = this.delayErrors;
        int r12 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (this.done == true) goto L12;
    L29:
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r13 = r10.get();
        if (r13 == null) goto L96;
        rt.h r14 = r13.queue;
        if (r14 == null) goto L96;
        if (r13.done == false) goto L55;
        boolean r15 = r14.isEmpty();
        if (r11 == true) goto L37;
        if (this.errors.get() != null) goto L46;
        if (r15 == false) goto L55;
    L50:
        if (r10.compareAndSet(r13, null) == true) goto L7;
        if (r10.get() == r13) goto L50;
    L46:
        r5.onError(this.errors.terminate());
        return;
    L37:
        if (r15 == false) goto L55;
    L39:
        if (r10.compareAndSet(r13, null) == true) goto L7;
        if (r10.get() == r13) goto L39;
    L55:
        boolean r16 = false;
    L57:
        if (this.cancelled == true) goto L58;
        if (r13 != r10.get()) goto L61;
        if (r11 == false) goto L64;
    L67:
        boolean r17 = r13.done;
        Object r18 = r14.poll();     // Catch: Throwable -> L70
    L81:
        if (r18 != null) goto L83;
        boolean r19 = true;
    L84:
        if (r17 == false) goto L92;
        if (r19 == false) goto L92;
    L87:
        if (r10.compareAndSet(r13, null) == true) goto L61;
        if (r10.get() == r13) goto L87;
    L92:
        if (r19 == true) goto L93;
        r5.onNext(r18);
    L93:
        if (r16 == false) goto L96;
    L83:
        r19 = false;
    L70:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.errors.addThrowable(th);
    L73:
        if (r10.compareAndSet(r13, null) == true) goto L77;
        if (r10.get() == r13) goto L73;
    L77:
        if (r11 == true) goto L79;
        disposeInner();
        this.upstream.dispose();
        this.done = true;
    L80:
        r16 = true;
        r18 = null;
        goto L81
    L79:
        r13.cancel();
        goto L80
    L64:
        if (this.errors.get() == null) goto L67;
        r5.onError(this.errors.terminate());
        return;
    L61:
        r16 = true;
        goto L93
    L58:
        return;
    L96:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L7;
        return;
    L12:
        if (r10.get() != null) goto L14;
        boolean r20 = true;
    L15:
        if (r11 == false) goto L23;
        if (r20 == false) goto L29;
        Throwable r110 = this.errors.get();
        if (r110 == null) goto L20;
        r5.onError(r110);
        return;
    L20:
        r5.onComplete();
        return;
    L23:
        if (this.errors.get() != null) goto L24;
        if (r20 == false) goto L29;
        r5.onComplete();
        return;
    L24:
        r5.onError(this.errors.terminate());
        return;
    L14:
        r20 = false;
        goto L15
    }

    public void innerError(ObservableSwitchMap$SwitchMapInnerObserver<T, R> r5, Throwable r10) {
        if (r5.index == this.unique) goto L5;
    L10:
        wn.f.k(r10);
        return;
    L5:
        if (this.errors.addThrowable(r10) == false) goto L10;
        if (this.delayErrors == true) goto L9;
        this.upstream.dispose();
    L9:
        r5.done = true;
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // mt.u
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        drain();
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.done == false) goto L5;
    L10:
        wn.f.k(r5);
        return;
    L5:
        if (this.errors.addThrowable(r5) == false) goto L10;
        if (this.delayErrors == true) goto L9;
        disposeInner();
    L9:
        this.done = true;
        drain();
    }

    @Override // mt.u
    public void onNext(T r5) {
        long r10 = this.unique + 1;
        this.unique = r10;
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r11 = this.active.get();
        if (r11 == null) goto L21;
        r11.cancel();
    L21:
        Object r12 = this.mapper.apply(r5);     // Catch: Throwable -> L18
        io.reactivex.internal.functions.e.d(r12, "The ObservableSource returned is null");     // Catch: Throwable -> L18
        mt.s r13 = (mt.s) r12;     // Catch: Throwable -> L18
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r14 = new ObservableSwitchMap$SwitchMapInnerObserver(this, r10, this.bufferSize);
    L7:
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> r15 = this.active.get();
        if (r15 == CANCELLED) goto L27;
        AtomicReference<ObservableSwitchMap$SwitchMapInnerObserver<T, R>> r16 = this.active;
    L12:
        if (r16.compareAndSet(r15, r14) == true) goto L13;
        if (r16.get() == r15) goto L12;
    L13:
        r13.subscribe(r14);
        return;
    L27:
        return;
    L18:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.dispose();
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
