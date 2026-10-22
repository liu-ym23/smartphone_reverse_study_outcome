package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableObserveOn$ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements xb.o<T>, Runnable {
    private static final long serialVersionUID = 6576896619930983584L;
    final int bufferSize;
    final boolean delayError;
    volatile boolean disposed;
    volatile boolean done;
    final xb.o<? super T> downstream;
    Throwable error;
    boolean outputFused;
    bc.f<T> queue;
    int sourceMode;
    io.reactivex.disposables.b upstream;
    final xb.p.c worker;

    ObservableObserveOn$ObserveOnObserver(xb.o<? super T> r10, xb.p.c r11, boolean r12, int r13) {
        this.downstream = r10;
        this.worker = r11;
        this.delayError = r12;
        this.bufferSize = r13;
    }

    boolean checkTerminated(boolean r10, boolean r11, xb.o<? super T> r12) {
        if (this.disposed == false) goto L6;
        this.queue.clear();
        return true;
    L6:
        if (r10 == false) goto L22;
        Throwable r13 = this.error;
        if (this.delayError == false) goto L16;
        if (r11 == false) goto L24;
        this.disposed = true;
        if (r13 == null) goto L13;
        r12.onError(r13);
    L14:
        this.worker.dispose();
        return true;
    L13:
        r12.onComplete();
        goto L14
    L24:
        return false;
    L16:
        if (r13 == null) goto L19;
        this.disposed = true;
        this.queue.clear();
        r12.onError(r13);
        this.worker.dispose();
        return true;
    L19:
        if (r11 == false) goto L25;
        this.disposed = true;
        r12.onComplete();
        this.worker.dispose();
        return true;
    L25:
        return false;
    L22:
        return false;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public void clear() {
        this.queue.clear();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
    public void dispose() {
        if (this.disposed == true) goto L8;
        this.disposed = true;
        this.upstream.dispose();
        this.worker.dispose();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    void drainFused() {
        int r10 = 1;
    L4:
        if (this.disposed == true) goto L5;
        boolean r11 = this.done;
        Throwable r12 = this.error;
        if (this.delayError == true) goto L13;
        if (r11 == false) goto L13;
        if (r12 == null) goto L13;
        this.disposed = true;
        this.downstream.onError(this.error);
    L11:
        this.worker.dispose();
        return;
    L13:
        this.downstream.onNext(null);
        if (r11 == true) goto L15;
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L4;
        return;
    L15:
        this.disposed = true;
        Throwable r13 = this.error;
        if (r13 == null) goto L18;
        this.downstream.onError(r13);
        goto L11
    L18:
        this.downstream.onComplete();
        goto L11
    }

    void drainNormal() {
        bc.f<T> r10 = this.queue;
        xb.o<? super T> r11 = this.downstream;
        int r12 = 1;
    L4:
        if (checkTerminated(this.done, r10.isEmpty(), r11) == true) goto L5;
    L6:
        boolean r13 = this.done;
        T r14 = r10.poll();     // Catch: Throwable -> L19
        if (r14 != null) goto L10;
        boolean r15 = true;
    L12:
        if (checkTerminated(r13, r15, r11) == true) goto L13;
        if (r15 == true) goto L15;
        r11.onNext(r14);
        goto L6
    L15:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L4;
        return;
    L13:
        return;
    L10:
        r15 = false;
    L19:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.disposed = true;
        this.upstream.dispose();
        r10.clear();
        r11.onError(th);
        this.worker.dispose();
        return;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // xb.o
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        schedule();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.error = r10;
        this.done = true;
        schedule();
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.sourceMode == 2) goto L8;
        this.queue.offer(r10);
    L8:
        schedule();
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L16;
        this.upstream = r10;
        if ((r10 instanceof bc.b) == false) goto L14;
        bc.b r11 = (bc.b) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.sourceMode = r12;
        this.queue = r11;
        this.done = true;
        this.downstream.onSubscribe(this);
        schedule();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.sourceMode = r12;
        this.queue = r11;
        this.downstream.onSubscribe(this);
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.f
    public T poll() {
        return this.queue.poll();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, bc.c
    public int requestFusion(int r10) {
        if ((r10 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.outputFused == false) goto L5;
        drainFused();
        return;
    L5:
        drainNormal();
    }

    void schedule() {
        if (getAndIncrement() != 0) goto L6;
        this.worker.b(this);
        return;
    }
}
