package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableWindowBoundary$WindowBoundaryMainObserver<T, B> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b, Runnable {
    static final Object NEXT_WINDOW = null;
    private static final long serialVersionUID = 2233020065421370272L;
    final o<T, B> boundaryObserver;
    final int capacityHint;
    volatile boolean done;
    final xb.o<? super Observable<T>> downstream;
    final AtomicThrowable errors;
    final MpscLinkedQueue<Object> queue;
    final AtomicBoolean stopWindows;
    final AtomicReference<io.reactivex.disposables.b> upstream;
    UnicastSubject<T> window;
    final AtomicInteger windows;

    static {
        NEXT_WINDOW = new Object();
    }

    ObservableWindowBoundary$WindowBoundaryMainObserver(xb.o<? super Observable<T>> r10, int r11) {
        this.downstream = r10;
        this.capacityHint = r11;
        this.boundaryObserver = new o(this);
        this.upstream = new AtomicReference();
        this.windows = new AtomicInteger(1);
        this.queue = new MpscLinkedQueue();
        this.errors = new AtomicThrowable();
        this.stopWindows = new AtomicBoolean();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
        this.boundaryObserver.dispose();
        if (this.windows.decrementAndGet() != 0) goto L9;
        DisposableHelper.dispose(this.upstream);
        return;
    L9:
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        xb.o<? super Observable<T>> r10 = this.downstream;
        MpscLinkedQueue<Object> r11 = this.queue;
        AtomicThrowable r12 = this.errors;
        int r13 = 1;
    L7:
        if (this.windows.get() == 0) goto L8;
        UnicastSubject<T> r14 = this.window;
        boolean r15 = this.done;
        if (r15 == true) goto L13;
    L19:
        Object r16 = r11.poll();
        if (r16 != null) goto L22;
        boolean r17 = true;
    L23:
        if (r15 == false) goto L34;
        if (r17 == false) goto L34;
        Throwable r18 = r12.terminate();
        if (r18 != null) goto L30;
        if (r14 == null) goto L29;
        this.window = null;
        r14.onComplete();
    L29:
        r10.onComplete();
        return;
    L30:
        if (r14 == null) goto L32;
        this.window = null;
        r14.onError(r18);
    L32:
        r10.onError(r18);
        return;
    L34:
        if (r17 == true) goto L35;
        if (r16 != NEXT_WINDOW) goto L40;
        if (r14 == null) goto L44;
        this.window = null;
        r14.onComplete();
    L44:
        if (this.stopWindows.get() == true) goto L7;
        UnicastSubject<T> r19 = UnicastSubject.i(this.capacityHint, this);
        this.window = r19;
        this.windows.getAndIncrement();
        r10.onNext(r19);
        goto L7
    L40:
        r14.onNext((T) r16);
        goto L7
    L35:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L22:
        r17 = false;
        goto L23
    L13:
        if (r12.get() == null) goto L19;
        r11.clear();
        Throwable r20 = r12.terminate();
        if (r14 == null) goto L17;
        this.window = null;
        r14.onError(r20);
    L17:
        r10.onError(r20);
        return;
    L8:
        r11.clear();
        this.window = null;
    }

    void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        this.done = true;
        drain();
    }

    void innerError(Throwable r10) {
        DisposableHelper.dispose(this.upstream);
        if (this.errors.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    void innerNext() {
        this.queue.offer(NEXT_WINDOW);
        drain();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.stopWindows.get();
    }

    @Override // xb.o
    public void onComplete() {
        this.boundaryObserver.dispose();
        this.done = true;
        drain();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.boundaryObserver.dispose();
        if (this.errors.addThrowable(r10) == false) goto L5;
        this.done = true;
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.queue.offer(r10);
        drain();
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this.upstream, r10) == false) goto L6;
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
