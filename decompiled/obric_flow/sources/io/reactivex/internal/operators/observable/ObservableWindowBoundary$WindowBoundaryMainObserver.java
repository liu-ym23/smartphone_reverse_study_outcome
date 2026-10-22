package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableWindowBoundary$WindowBoundaryMainObserver<T, B> extends AtomicInteger implements mt.u, Disposable, Runnable {
    static final Object NEXT_WINDOW = null;
    private static final long serialVersionUID = 2233020065421370272L;
    final n4 boundaryObserver;
    final int capacityHint;
    volatile boolean done;
    final mt.u downstream;
    final AtomicThrowable errors;
    final io.reactivex.internal.queue.a queue;
    final AtomicBoolean stopWindows;
    final AtomicReference<Disposable> upstream;
    io.reactivex.subjects.i window;
    final AtomicInteger windows;

    static {
        NEXT_WINDOW = new Object();
    }

    public ObservableWindowBoundary$WindowBoundaryMainObserver(mt.u r5, int r10) {
        this.downstream = r5;
        this.capacityHint = r10;
        this.boundaryObserver = new n4(this);
        this.upstream = new AtomicReference();
        this.windows = new AtomicInteger(1);
        this.queue = new io.reactivex.internal.queue.a();
        this.errors = new AtomicThrowable();
        this.stopWindows = new AtomicBoolean();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
        this.boundaryObserver.dispose();
        if (this.windows.decrementAndGet() != 0) goto L9;
        DisposableHelper.dispose(this.upstream);
        return;
    L9:
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
        r5.onNext(r18);
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
        Throwable r19 = r11.terminate();
        if (r13 == null) goto L17;
        this.window = null;
        r13.onError(r19);
    L17:
        r5.onError(r19);
        return;
    L8:
        r10.clear();
        this.window = null;
    }

    public void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        this.done = true;
        drain();
    }

    public void innerError(Throwable r5) {
        DisposableHelper.dispose(this.upstream);
        if (this.errors.addThrowable(r5) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    public void innerNext() {
        this.queue.offer(NEXT_WINDOW);
        drain();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.stopWindows.get();
    }

    @Override // mt.u
    public void onComplete() {
        this.boundaryObserver.dispose();
        this.done = true;
        drain();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.boundaryObserver.dispose();
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
        if (DisposableHelper.setOnce(this.upstream, r5) == false) goto L6;
        innerNext();
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.windows.decrementAndGet() != 0) goto L6;
        DisposableHelper.dispose(this.upstream);
        return;
    }
}
