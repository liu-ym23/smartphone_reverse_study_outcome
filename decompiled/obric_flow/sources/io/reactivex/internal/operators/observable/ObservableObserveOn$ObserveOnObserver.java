package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableObserveOn$ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements mt.u, Runnable {
    private static final long serialVersionUID = 6576896619930983584L;
    final int bufferSize;
    final boolean delayError;
    volatile boolean disposed;
    volatile boolean done;
    final mt.u downstream;
    Throwable error;
    boolean outputFused;
    rt.h queue;
    int sourceMode;
    Disposable upstream;
    final mt.y worker;

    public ObservableObserveOn$ObserveOnObserver(mt.u r5, mt.y r10, boolean r11, int r12) {
        this.downstream = r5;
        this.worker = r10;
        this.delayError = r11;
        this.bufferSize = r12;
    }

    public boolean checkTerminated(boolean r5, boolean r10, mt.u r11) {
        if (this.disposed == false) goto L6;
        this.queue.clear();
        return true;
    L6:
        if (r5 == false) goto L22;
        Throwable r12 = this.error;
        if (this.delayError == false) goto L16;
        if (r10 == false) goto L24;
        this.disposed = true;
        if (r12 == null) goto L13;
        r11.onError(r12);
    L14:
        this.worker.dispose();
        return true;
    L13:
        r11.onComplete();
        goto L14
    L24:
        return false;
    L16:
        if (r12 == null) goto L19;
        this.disposed = true;
        this.queue.clear();
        r11.onError(r12);
        this.worker.dispose();
        return true;
    L19:
        if (r10 == false) goto L25;
        this.disposed = true;
        r11.onComplete();
        this.worker.dispose();
        return true;
    L25:
        return false;
    L22:
        return false;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public void clear() {
        this.queue.clear();
    }

    @Override // io.reactivex.disposables.Disposable
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

    public void drainFused() {
        int r5 = 1;
    L4:
        if (this.disposed == true) goto L5;
        boolean r10 = this.done;
        Throwable r11 = this.error;
        if (this.delayError == true) goto L12;
        if (r10 == false) goto L12;
        if (r11 == null) goto L12;
        this.disposed = true;
        this.downstream.onError(this.error);
        this.worker.dispose();
        return;
    L12:
        this.downstream.onNext(null);
        if (r10 == true) goto L14;
        r5 = addAndGet(-r5);
        if (r5 != 0) goto L4;
        return;
    L14:
        this.disposed = true;
        Throwable r12 = this.error;
        if (r12 == null) goto L17;
        this.downstream.onError(r12);
    L18:
        this.worker.dispose();
        return;
    L17:
        this.downstream.onComplete();
        goto L18
    }

    public void drainNormal() {
        rt.h r5 = this.queue;
        mt.u r10 = this.downstream;
        int r11 = 1;
    L4:
        if (checkTerminated(this.done, r5.isEmpty(), r10) == true) goto L5;
    L6:
        boolean r12 = this.done;
        Object r13 = r5.poll();     // Catch: Throwable -> L19
        if (r13 != null) goto L10;
        boolean r14 = true;
    L12:
        if (checkTerminated(r12, r14, r10) == true) goto L13;
        if (r14 == true) goto L15;
        r10.onNext(r13);
        goto L6
    L15:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L4;
        return;
    L13:
        return;
    L10:
        r14 = false;
    L19:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.disposed = true;
        this.upstream.dispose();
        r5.clear();
        r10.onError(th);
        this.worker.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // mt.u
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        schedule();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.error = r5;
        this.done = true;
        schedule();
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.sourceMode == 2) goto L8;
        this.queue.offer(r5);
    L8:
        schedule();
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L16;
        this.upstream = r5;
        if ((r5 instanceof rt.c) == false) goto L14;
        rt.c r10 = (rt.c) r5;
        int r11 = r10.requestFusion(7);
        if (r11 != 1) goto L11;
        this.sourceMode = r11;
        this.queue = r10;
        this.done = true;
        this.downstream.onSubscribe(this);
        schedule();
        return;
    L11:
        if (r11 != 2) goto L14;
        this.sourceMode = r11;
        this.queue = r10;
        this.downstream.onSubscribe(this);
        return;
    L14:
        this.queue = new io.reactivex.internal.queue.b(this.bufferSize);
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.h
    public T poll() throws Exception {
        return (T) this.queue.poll();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, rt.d
    public int requestFusion(int r5) {
        if ((r5 & 2) == 0) goto L6;
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

    public void schedule() {
        if (getAndIncrement() != 0) goto L6;
        this.worker.a(this);
        return;
    }
}
