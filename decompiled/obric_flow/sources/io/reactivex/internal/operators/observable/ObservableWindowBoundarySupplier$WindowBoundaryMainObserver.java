package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableWindowBoundarySupplier$WindowBoundaryMainObserver<T, B> extends AtomicInteger implements mt.u, Disposable, Runnable {
    static final s4 BOUNDARY_DISPOSED = null;
    static final Object NEXT_WINDOW = null;
    private static final long serialVersionUID = 2233020065421370272L;
    final AtomicReference<s4> boundaryObserver;
    final int capacityHint;
    volatile boolean done;
    final mt.u downstream;
    final AtomicThrowable errors;
    final Callable<? extends mt.s> other;
    final io.reactivex.internal.queue.a queue;
    final AtomicBoolean stopWindows;
    Disposable upstream;
    io.reactivex.subjects.i window;
    final AtomicInteger windows;

    static {
        BOUNDARY_DISPOSED = new s4(null);
        NEXT_WINDOW = new Object();
    }

    public ObservableWindowBoundarySupplier$WindowBoundaryMainObserver(mt.u r5, int r10, Callable<? extends mt.s> r11) {
        this.downstream = r5;
        this.capacityHint = r10;
        this.boundaryObserver = new AtomicReference();
        this.windows = new AtomicInteger(1);
        this.queue = new io.reactivex.internal.queue.a();
        this.errors = new AtomicThrowable();
        this.stopWindows = new AtomicBoolean();
        this.other = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
        disposeBoundary();
        if (this.windows.decrementAndGet() != 0) goto L9;
        this.upstream.dispose();
        return;
    L9:
        return;
    }

    public void disposeBoundary() {
        AtomicReference<s4> r5 = this.boundaryObserver;
        s4 r10 = BOUNDARY_DISPOSED;
        s4 r11 = r5.getAndSet(r10);
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
        mt.u r5 = this.downstream;
        io.reactivex.internal.queue.a r10 = this.queue;
        AtomicThrowable r11 = this.errors;
        int r12 = 1;
    L7:
        if (this.windows.get() == 0) goto L8;
        io.reactivex.subjects.i r13 = this.window;
        boolean r14 = this.done;
        if (r14 == true) goto L13;
    L19:
        Object r15 = r10.poll();
        if (r15 != null) goto L22;
        boolean r16 = true;
    L23:
        if (r14 == false) goto L34;
        if (r16 == false) goto L34;
        Throwable r17 = r11.terminate();
        if (r17 != null) goto L30;
        if (r13 == null) goto L29;
        this.window = null;
        r13.onComplete();
    L29:
        r5.onComplete();
        return;
    L30:
        if (r13 == null) goto L32;
        this.window = null;
        r13.onError(r17);
    L32:
        r5.onError(r17);
        return;
    L34:
        if (r16 == true) goto L35;
        if (r15 != NEXT_WINDOW) goto L40;
        if (r13 == null) goto L44;
        this.window = null;
        r13.onComplete();
    L44:
        if (this.stopWindows.get() == true) goto L7;
        io.reactivex.subjects.i r18 = new io.reactivex.subjects.i(this, this.capacityHint);
        this.window = r18;
        this.windows.getAndIncrement();
        mt.s r19 = this.other.call();     // Catch: Throwable -> L54
        io.reactivex.internal.functions.e.d(r19, "The other Callable returned a null ObservableSource");     // Catch: Throwable -> L54
        mt.s r20 = r19;     // Catch: Throwable -> L54
        s4 r21 = new s4(this);
        AtomicReference<s4> r22 = this.boundaryObserver;
    L49:
        if (r22.compareAndSet(null, r21) == true) goto L50;
        if (r22.get() == null) goto L49;
    L50:
        r20.subscribe(r21);
        r5.onNext(r18);
    L54:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r11.addThrowable(th);
        this.done = true;
        goto L7
    L40:
        r13.onNext(r15);
        goto L7
    L35:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L7;
        return;
    L22:
        r16 = false;
        goto L23
    L13:
        if (r11.get() == null) goto L19;
        r10.clear();
        Throwable r23 = r11.terminate();
        if (r13 == null) goto L17;
        this.window = null;
        r13.onError(r23);
    L17:
        r5.onError(r23);
        return;
    L8:
        r10.clear();
        this.window = null;
    }

    public void innerComplete() {
        this.upstream.dispose();
        this.done = true;
        drain();
    }

    public void innerError(Throwable r5) {
        this.upstream.dispose();
        if (this.errors.addThrowable(r5) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    public void innerNext(s4 r5) {
        AtomicReference<s4> r10 = this.boundaryObserver;
    L4:
        if (r10.compareAndSet(r5, null) == true) goto L8;
        if (r10.get() == r5) goto L4;
    L8:
        this.queue.offer(NEXT_WINDOW);
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.stopWindows.get();
    }

    @Override // mt.u
    public void onComplete() {
        disposeBoundary();
        this.done = true;
        drain();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        disposeBoundary();
        if (this.errors.addThrowable(r5) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.queue.offer(r5);
        drain();
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        this.queue.offer(NEXT_WINDOW);
        drain();
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.windows.decrementAndGet() != 0) goto L6;
        this.upstream.dispose();
        return;
    }
}
