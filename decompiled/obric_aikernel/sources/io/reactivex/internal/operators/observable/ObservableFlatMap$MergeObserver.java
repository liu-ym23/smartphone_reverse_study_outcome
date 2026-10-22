package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableFlatMap$MergeObserver<T, U> extends AtomicInteger implements io.reactivex.disposables.b, xb.o<T> {
    static final ObservableFlatMap$InnerObserver<?, ?>[] CANCELLED = null;
    static final ObservableFlatMap$InnerObserver<?, ?>[] EMPTY = null;
    private static final long serialVersionUID = -2117620485640801370L;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final xb.o<? super U> downstream;
    final AtomicThrowable errors;
    long lastId;
    int lastIndex;
    final zb.h<? super T, ? extends xb.n<? extends U>> mapper;
    final int maxConcurrency;
    final AtomicReference<ObservableFlatMap$InnerObserver<?, ?>[]> observers;
    volatile bc.e<U> queue;
    Queue<xb.n<? extends U>> sources;
    long uniqueId;
    io.reactivex.disposables.b upstream;
    int wip;

    static {
        EMPTY = new ObservableFlatMap$InnerObserver[0];
        CANCELLED = new ObservableFlatMap$InnerObserver[0];
    }

    ObservableFlatMap$MergeObserver(xb.o<? super U> r10, zb.h<? super T, ? extends xb.n<? extends U>> r11, boolean r12, int r13, int r14) {
        this.errors = new AtomicThrowable();
        this.downstream = r10;
        this.mapper = r11;
        this.delayErrors = r12;
        this.maxConcurrency = r13;
        this.bufferSize = r14;
        if (r13 == Integer.MAX_VALUE) goto L5;
        this.sources = new ArrayDeque(r13);
    L5:
        this.observers = new AtomicReference(EMPTY);
    }

    boolean addInner(ObservableFlatMap$InnerObserver<T, U> r10) {
    L2:
        ObservableFlatMap$InnerObserver<?, ?>[] r11 = this.observers.get();
        if (r11 == CANCELLED) goto L4;
        int r12 = r11.length;
        ObservableFlatMap$InnerObserver[] r13 = new ObservableFlatMap$InnerObserver[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (this.observers.compareAndSet(r11, (ObservableFlatMap$InnerObserver<?, ?>[]) r13) == false) goto L2;
        return true;
    L4:
        r10.dispose();
        return false;
    }

    boolean checkTerminate() {
        if (this.cancelled == false) goto L5;
        return true;
    L5:
        Throwable r10 = this.errors.get();
        if (this.delayErrors == true) goto L12;
        if (r10 == null) goto L14;
        disposeAll();
        Throwable r11 = this.errors.terminate();
        if (r11 == ExceptionHelper.f9683a) goto L11;
        this.downstream.onError(r11);
    L11:
        return true;
    L14:
        return false;
    L12:
        return false;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.cancelled == true) goto L12;
        this.cancelled = true;
        if (disposeAll() == false) goto L13;
        Throwable r10 = this.errors.terminate();
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10 == ExceptionHelper.f9683a) goto L15;
        dc.a.n(r10);
        return;
    L15:
        return;
    L13:
        return;
    }

    boolean disposeAll() {
        this.upstream.dispose();
        ObservableFlatMap$InnerObserver<?, ?>[] r10 = this.observers.get();
        ObservableFlatMap$InnerObserver<?, ?>[] r11 = CANCELLED;
        int r12 = 0;
        if (r10 == r11) goto L11;
        ObservableFlatMap$InnerObserver<?, ?>[] r13 = this.observers.getAndSet(r11);
        if (r13 == r11) goto L11;
        int r14 = r13.length;
    L7:
        if (r12 >= r14) goto L9;
        r13[r12].dispose();
        r12 = r12 + 1;
        goto L7
    L9:
        return true;
    L11:
        return false;
    }

    void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void drainLoop() {
        xb.o<? super U> r10 = this.downstream;
        int r11 = 1;
    L4:
        if (checkTerminate() == true) goto L5;
        bc.e<U> r12 = this.queue;
        if (r12 != null) goto L9;
    L15:
        boolean r13 = this.done;
        bc.e<U> r14 = this.queue;
        ObservableFlatMap$InnerObserver<?, ?>[] r15 = this.observers.get();
        int r16 = r15.length;
        int r17 = 0;
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L24;
        monitor-enter(this);
        int r18 = this.sources.size();     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
    L25:
        if (r13 == false) goto L37;
        if (r14 != null) goto L28;
    L29:
        if (r16 != 0) goto L37;
        if (r18 != 0) goto L37;
        Throwable r19 = this.errors.terminate();
        if (r19 == ExceptionHelper.f9683a) goto L142;
        if (r19 != null) goto L35;
        r10.onComplete();
        return;
    L35:
        r10.onError(r19);
        return;
    L142:
        return;
    L28:
        if (r14.isEmpty() == true) goto L29;
    L37:
        if (r16 == 0) goto L88;
        long r20 = this.lastId;
        int r21 = this.lastIndex;
        if (r16 > r21) goto L41;
    L42:
        if (r16 > r21) goto L44;
        r21 = 0;
    L44:
        int r110 = 0;
    L45:
        if (r110 >= r16) goto L53;
        if (r15[r21].id == r20) goto L53;
        r21 = r21 + 1;
        if (r21 != r16) goto L52;
        r21 = 0;
    L52:
        r110 = r110 + 1;
    L53:
        this.lastIndex = r21;
        this.lastId = r15[r21].id;
    L54:
        int r22 = 0;
        int r23 = 0;
    L55:
        if (r22 >= r16) goto L87;
        if (checkTerminate() == true) goto L58;
        ObservableFlatMap$InnerObserver<T, U> r111 = r15[r21];
        bc.f<U> r112 = r111.queue;
        if (r112 != null) goto L110;
    L74:
        boolean r113 = r111.done;
        bc.f<U> r114 = r111.queue;
        if (r113 == false) goto L83;
        if (r114 != null) goto L78;
    L79:
        removeInner(r111);
        if (checkTerminate() == true) goto L81;
        r23 = r23 + 1;
        goto L83
    L81:
        return;
    L78:
        if (r114.isEmpty() == true) goto L79;
    L83:
        r21 = r21 + 1;
        if (r21 != r16) goto L86;
    L85:
        r21 = 0;
    L86:
        r22 = r22 + 1;
    L110:
        U r115 = r112.poll();     // Catch: Throwable -> L67
        if (r115 == null) goto L74;
        r10.onNext(r115);
        if (checkTerminate() == false) goto L110;
        return;
    L67:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r111.dispose();
        this.errors.addThrowable(th);
        if (checkTerminate() == true) goto L70;
        removeInner(r111);
        r23 = r23 + 1;
        r21 = r21 + 1;
        if (r21 != r16) goto L86;
    L70:
        return;
    L58:
        return;
    L87:
        this.lastIndex = r21;
        this.lastId = r15[r21].id;
        r17 = r23;
        goto L88
    L41:
        if (r15[r21].id == r20) goto L54;
    L88:
        if (r17 != 0) goto L90;
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L4;
        return;
    L90:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L4;
    L91:
        int r24 = r17 - 1;
        if (r17 == 0) goto L4;
        monitor-enter(this);
        xb.n<? extends U> r25 = this.sources.poll();     // Catch: Throwable -> L102
        if (r25 != null) goto L99;
        this.wip--;     // Catch: Throwable -> L102
        monitor-exit(this);     // Catch: Throwable -> L102
    L101:
        r17 = r24;
        goto L91
    L99:
        monitor-exit(this);     // Catch: Throwable -> L102
        subscribeInner(r25);
    L102:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        throw th;
    L24:
        r18 = 0;
    L9:
        if (checkTerminate() == true) goto L10;
        U r26 = r12.poll();
        if (r26 == null) goto L15;
        r10.onNext(r26);
        goto L9
    L10:
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // xb.o
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        drain();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.done == false) goto L7;
        dc.a.n(r10);
        return;
    L7:
        if (this.errors.addThrowable(r10) == false) goto L9;
        this.done = true;
        drain();
        return;
    L9:
        dc.a.n(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (this.done == false) goto L25;
        return;
    L25:
        xb.n<? extends U> r11 = (xb.n) io.reactivex.internal.functions.a.d(this.mapper.apply(r10), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L22
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L20;
        monitor-enter(this);
        int r12 = this.wip;     // Catch: Throwable -> L17
        if (r12 != this.maxConcurrency) goto L14;
        this.sources.offer(r11);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L14:
        this.wip = r12 + 1;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L20:
        subscribeInner(r11);
        return;
    L22:
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

    /* JADX WARN: Multi-variable type inference failed */
    void removeInner(ObservableFlatMap$InnerObserver<T, U> r10) {
    L2:
        ObservableFlatMap$InnerObserver<?, ?>[] r11 = this.observers.get();
        int r12 = r11.length;
        if (r12 == 0) goto L4;
        int r13 = -1;
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L11;
        if (r11[r14] == r10) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        r13 = r14;
    L11:
        if (r13 < 0) goto L12;
        if (r12 != 1) goto L16;
        ObservableFlatMap$InnerObserver<?, ?>[] r15 = EMPTY;
    L18:
        if (this.observers.compareAndSet(r11, r15) == false) goto L2;
        return;
    L16:
        ObservableFlatMap$InnerObserver<?, ?>[] r16 = new ObservableFlatMap$InnerObserver[r12 - 1];
        System.arraycopy(r11, 0, r16, 0, r13);
        System.arraycopy(r11, r13 + 1, r16, r13, (r12 - r13) - 1);
        r15 = r16;
        goto L18
    L12:
        return;
    }

    void subscribeInner(xb.n<? extends U> r10) {
    L3:
        if ((r10 instanceof Callable) == false) goto L20;
        if (tryEmitScalar((Callable) r10) == false) goto L32;
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L33;
        boolean r11 = false;
        monitor-enter(this);
        xb.n<? extends U> r12 = this.sources.poll();     // Catch: Throwable -> L17
        if (r12 != null) goto L13;
        this.wip--;     // Catch: Throwable -> L17
        r11 = true;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L17
        if (r11 == true) goto L15;
        r10 = r12;
        goto L3
    L15:
        drain();
        return;
    L17:
        th = move-exception;
        throw th;
    L33:
        return;
    L32:
        return;
    L20:
        long r13 = this.uniqueId;
        this.uniqueId = 1 + r13;
        ObservableFlatMap$InnerObserver<T, U> r14 = new ObservableFlatMap$InnerObserver(this, r13);
        if (addInner(r14) == false) goto L31;
        r10.subscribe(r14);
        return;
    }

    void tryEmit(U r10, ObservableFlatMap$InnerObserver<T, U> r11) {
        if (get() == 0) goto L5;
    L9:
        bc.f r12 = r11.queue;
        if (r12 != null) goto L12;
        r12 = new io.reactivex.internal.queue.a(this.bufferSize);
        r11.queue = r12;
    L12:
        r12.offer(r10);
        if (getAndIncrement() == 0) goto L15;
        return;
    L15:
        drainLoop();
        return;
    L5:
        if (compareAndSet(0, 1) == false) goto L9;
        this.downstream.onNext(r10);
        if (decrementAndGet() != 0) goto L15;
    }

    boolean tryEmitScalar(Callable<? extends U> r10) {
        U r11 = r10.call();     // Catch: Throwable -> L29
        if (r11 != null) goto L7;
        return true;
    L7:
        if (get() == 0) goto L9;
    L13:
        bc.e<U> r12 = this.queue;
        if (r12 != null) goto L21;
        if (this.maxConcurrency != Integer.MAX_VALUE) goto L18;
        r12 = new io.reactivex.internal.queue.a(this.bufferSize);
    L19:
        this.queue = r12;
        goto L21
    L18:
        r12 = new SpscArrayQueue(this.maxConcurrency);
    L21:
        if (r12.offer(r11) == true) goto L25;
        onError(new IllegalStateException("Scalar queue full?!"));
        return true;
    L25:
        if (getAndIncrement() == 0) goto L27;
        return false;
    L27:
        drainLoop();
        return true;
    L9:
        if (compareAndSet(0, 1) == false) goto L13;
        this.downstream.onNext(r11);
        if (decrementAndGet() != 0) goto L27;
        return true;
    L29:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.errors.addThrowable(th);
        drain();
        return true;
    }
}
