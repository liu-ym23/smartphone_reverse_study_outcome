package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableBufferBoundary$BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements mt.u, Disposable {
    private static final long serialVersionUID = -8466418554264089604L;
    final pt.o bufferClose;
    final mt.s bufferOpen;
    final Callable<C> bufferSupplier;
    Map<Long, C> buffers;
    volatile boolean cancelled;
    volatile boolean done;
    final mt.u downstream;
    final AtomicThrowable errors;
    long index;
    final io.reactivex.disposables.a observers;
    final io.reactivex.internal.queue.b queue;
    final AtomicReference<Disposable> upstream;

    public static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements mt.u, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final ObservableBufferBoundary$BufferBoundaryObserver<?, ?, Open, ?> parent;

        public BufferOpenObserver(ObservableBufferBoundary$BufferBoundaryObserver<?, ?, Open, ?> r5) {
            this.parent = r5;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // mt.u
        public void onComplete() {
            lazySet(DisposableHelper.DISPOSED);
            this.parent.openComplete(this);
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            lazySet(DisposableHelper.DISPOSED);
            this.parent.boundaryError(this, r5);
        }

        @Override // mt.u
        public void onNext(Open r5) {
            this.parent.open(r5);
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }
    }

    public ObservableBufferBoundary$BufferBoundaryObserver(mt.u r5, mt.s r10, pt.o r11, Callable<C> r12) {
        this.downstream = r5;
        this.bufferSupplier = r12;
        this.bufferOpen = r10;
        this.bufferClose = r11;
        this.queue = new io.reactivex.internal.queue.b(mt.n.bufferSize());
        this.observers = new io.reactivex.disposables.a();
        this.upstream = new AtomicReference();
        this.buffers = new LinkedHashMap();
        this.errors = new AtomicThrowable();
    }

    public void boundaryError(Disposable r5, Throwable r10) {
        DisposableHelper.dispose(this.upstream);
        this.observers.c(r5);
        onError(r10);
    }

    public void close(ObservableBufferBoundary$BufferCloseObserver<T, C> r5, long r10) {
        this.observers.c(r5);
        if (this.observers.d() != 0) goto L5;
        DisposableHelper.dispose(this.upstream);
        boolean r11 = true;
    L6:
        monitor-enter(this);
        Map<Long, C> r12 = this.buffers;     // Catch: Throwable -> L11
        if (r12 != null) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L13:
        this.queue.offer(r12.remove(Long.valueOf(r10)));     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r11 == false) goto L17;
        this.done = true;
    L17:
        drain();
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r11 = false;
        goto L6
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (DisposableHelper.dispose(this.upstream) == false) goto L15;
        this.cancelled = true;
        this.observers.dispose();
        monitor-enter(this);
        this.buffers = null;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        if (getAndIncrement() == 0) goto L18;
        this.queue.clear();
        return;
    L18:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        mt.u r5 = this.downstream;
        io.reactivex.internal.queue.b r10 = this.queue;
        int r11 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        boolean r12 = this.done;
        if (r12 == true) goto L13;
    L16:
        Collection r13 = (Collection) r10.poll();
        if (r13 != null) goto L19;
        boolean r14 = true;
    L20:
        if (r12 == false) goto L24;
        if (r14 == false) goto L24;
        r5.onComplete();
        return;
    L24:
        if (r14 == true) goto L25;
        r5.onNext(r13);
        goto L7
    L25:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L7;
        return;
    L19:
        r14 = false;
        goto L20
    L13:
        if (this.errors.get() == null) goto L16;
        r10.clear();
        r5.onError(this.errors.terminate());
        return;
    L8:
        r10.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // mt.u
    public void onComplete() {
        this.observers.dispose();
        monitor-enter(this);
        Map<Long, C> r5 = this.buffers;     // Catch: Throwable -> L8
        if (r5 != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        Iterator<C> r10 = r5.values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r10.hasNext() == false) goto L14;
        C r11 = r10.next();     // Catch: Throwable -> L8
        this.queue.offer(r11);     // Catch: Throwable -> L8
        goto L12
    L14:
        this.buffers = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.done = true;
        drain();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.errors.addThrowable(r5) == false) goto L13;
        this.observers.dispose();
        monitor-enter(this);
        this.buffers = null;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.done = true;
        drain();
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        monitor-enter(this);
        Map<Long, C> r10 = this.buffers;     // Catch: Throwable -> L7
        if (r10 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        Iterator<C> r11 = r10.values().iterator();     // Catch: Throwable -> L7
    L11:
        if (r11.hasNext() == false) goto L13;
        r11.next().add(r5);     // Catch: Throwable -> L7
        goto L11
    L13:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this.upstream, r5) == false) goto L6;
        BufferOpenObserver r10 = new BufferOpenObserver(this);
        this.observers.b(r10);
        this.bufferOpen.subscribe(r10);
        return;
    }

    public void open(Open r10) {
        C r5 = this.bufferSupplier.call();     // Catch: Throwable -> L17
        io.reactivex.internal.functions.e.d(r5, "The bufferSupplier returned a null Collection");     // Catch: Throwable -> L17
        C r11 = r5;     // Catch: Throwable -> L17
        Object r12 = this.bufferClose.apply(r10);     // Catch: Throwable -> L17
        io.reactivex.internal.functions.e.d(r12, "The bufferClose returned a null ObservableSource");     // Catch: Throwable -> L17
        mt.s r13 = (mt.s) r12;     // Catch: Throwable -> L17
        long r14 = this.index;
        this.index = 1 + r14;
        monitor-enter(this);
        Map<Long, C> r15 = this.buffers;     // Catch: Throwable -> L9
        if (r15 != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        r15.put(Long.valueOf(r14), r11);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        ObservableBufferBoundary$BufferCloseObserver r16 = new ObservableBufferBoundary$BufferCloseObserver(this, r14);
        this.observers.b(r16);
        r13.subscribe(r16);
        return;
    L9:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        DisposableHelper.dispose(this.upstream);
        onError(th);
    }

    public void openComplete(BufferOpenObserver<Open> r5) {
        this.observers.c(r5);
        if (this.observers.d() != 0) goto L6;
        DisposableHelper.dispose(this.upstream);
        this.done = true;
        drain();
        return;
    }
}
