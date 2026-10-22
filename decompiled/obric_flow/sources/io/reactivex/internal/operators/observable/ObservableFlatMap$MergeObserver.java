package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableFlatMap$MergeObserver<T, U> extends AtomicInteger implements Disposable, mt.u {
    static final ObservableFlatMap$InnerObserver<?, ?>[] CANCELLED = null;
    static final ObservableFlatMap$InnerObserver<?, ?>[] EMPTY = null;
    private static final long serialVersionUID = -2117620485640801370L;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final mt.u downstream;
    final AtomicThrowable errors;
    long lastId;
    int lastIndex;
    final pt.o mapper;
    final int maxConcurrency;
    final AtomicReference<ObservableFlatMap$InnerObserver<?, ?>[]> observers;
    volatile rt.g queue;
    Queue<mt.s> sources;
    long uniqueId;
    Disposable upstream;
    int wip;

    static {
        EMPTY = new ObservableFlatMap$InnerObserver[0];
        CANCELLED = new ObservableFlatMap$InnerObserver[0];
    }

    public ObservableFlatMap$MergeObserver(mt.u r5, pt.o r10, boolean r11, int r12, int r13) {
        this.errors = new AtomicThrowable();
        this.downstream = r5;
        this.mapper = r10;
        this.delayErrors = r11;
        this.maxConcurrency = r12;
        this.bufferSize = r13;
        if (r12 == Integer.MAX_VALUE) goto L5;
        this.sources = new ArrayDeque(r12);
    L5:
        this.observers = new AtomicReference(EMPTY);
    }

    public boolean addInner(ObservableFlatMap$InnerObserver<T, U> r5) {
    L2:
        ObservableFlatMap$InnerObserver<?, ?>[] r10 = this.observers.get();
        if (r10 == CANCELLED) goto L4;
        int r11 = r10.length;
        ObservableFlatMap$InnerObserver[] r12 = new ObservableFlatMap$InnerObserver[r11 + 1];
        System.arraycopy(r10, 0, r12, 0, r11);
        r12[r11] = r5;
        AtomicReference<ObservableFlatMap$InnerObserver<?, ?>[]> r13 = this.observers;
    L8:
        if (r13.compareAndSet(r10, (ObservableFlatMap$InnerObserver<?, ?>[]) r12) == true) goto L9;
        if (r13.get() == r10) goto L8;
    L9:
        return true;
    L4:
        r5.dispose();
        return false;
    }

    public boolean checkTerminate() {
        if (this.cancelled == false) goto L5;
        return true;
    L5:
        Throwable r5 = this.errors.get();
        if (this.delayErrors == true) goto L12;
        if (r5 == null) goto L14;
        disposeAll();
        Throwable r10 = this.errors.terminate();
        if (r10 == io.reactivex.internal.util.d.f18173a) goto L11;
        this.downstream.onError(r10);
    L11:
        return true;
    L14:
        return false;
    L12:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L12;
        this.cancelled = true;
        if (disposeAll() == false) goto L13;
        Throwable r5 = this.errors.terminate();
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5 == io.reactivex.internal.util.d.f18173a) goto L15;
        wn.f.k(r5);
        return;
    L15:
        return;
    L13:
        return;
    }

    public boolean disposeAll() {
        this.upstream.dispose();
        ObservableFlatMap$InnerObserver<?, ?>[] r5 = this.observers.get();
        ObservableFlatMap$InnerObserver<?, ?>[] r10 = CANCELLED;
        int r11 = 0;
        if (r5 == r10) goto L11;
        ObservableFlatMap$InnerObserver<?, ?>[] r12 = this.observers.getAndSet(r10);
        if (r12 == r10) goto L11;
        int r13 = r12.length;
    L7:
        if (r11 >= r13) goto L9;
        r12[r11].dispose();
        r11 = r11 + 1;
        goto L7
    L9:
        return true;
    L11:
        return false;
    }

    public void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drainLoop() {
        mt.u r5 = this.downstream;
        int r10 = 1;
    L4:
        if (checkTerminate() == true) goto L5;
        rt.g r11 = this.queue;
        if (r11 != null) goto L9;
    L15:
        boolean r12 = this.done;
        rt.g r13 = this.queue;
        ObservableFlatMap$InnerObserver<?, ?>[] r14 = this.observers.get();
        int r15 = r14.length;
        int r16 = 0;
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L24;
        monitor-enter(this);
        int r17 = this.sources.size();     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
    L25:
        if (r12 == false) goto L37;
        if (r13 != null) goto L28;
    L29:
        if (r15 != 0) goto L37;
        if (r17 != 0) goto L37;
        Throwable r18 = this.errors.terminate();
        if (r18 == io.reactivex.internal.util.d.f18173a) goto L143;
        if (r18 != null) goto L35;
        r5.onComplete();
        return;
    L35:
        r5.onError(r18);
        return;
    L143:
        return;
    L28:
        if (r13.isEmpty() == true) goto L29;
    L37:
        if (r15 == 0) goto L88;
        long r19 = this.lastId;
        int r20 = this.lastIndex;
        if (r15 > r20) goto L41;
    L42:
        if (r15 > r20) goto L44;
        r20 = 0;
    L44:
        int r110 = 0;
    L45:
        if (r110 >= r15) goto L53;
        if (r14[r20].f17697id == r19) goto L53;
        r20 = r20 + 1;
        if (r20 != r15) goto L52;
        r20 = 0;
    L52:
        r110 = r110 + 1;
    L53:
        this.lastIndex = r20;
        this.lastId = r14[r20].f17697id;
    L54:
        int r21 = 0;
        int r22 = 0;
    L55:
        if (r21 >= r15) goto L87;
        if (checkTerminate() == true) goto L58;
        ObservableFlatMap$InnerObserver<T, U> r111 = r14[r20];
        rt.h r112 = r111.queue;
        if (r112 != null) goto L109;
    L74:
        boolean r113 = r111.done;
        rt.h r114 = r111.queue;
        if (r113 == false) goto L83;
        if (r114 != null) goto L78;
    L79:
        removeInner(r111);
        if (checkTerminate() == true) goto L81;
        r22 = r22 + 1;
        goto L83
    L81:
        return;
    L78:
        if (r114.isEmpty() == true) goto L79;
    L83:
        r20 = r20 + 1;
        if (r20 != r15) goto L86;
    L85:
        r20 = 0;
    L86:
        r21 = r21 + 1;
    L109:
        Object r115 = r112.poll();     // Catch: Throwable -> L67
        if (r115 == null) goto L74;
        r5.onNext(r115);
        if (checkTerminate() == false) goto L109;
        return;
    L67:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r111.dispose();
        this.errors.addThrowable(th);
        if (checkTerminate() == true) goto L70;
        removeInner(r111);
        r22 = r22 + 1;
        r20 = r20 + 1;
        if (r20 != r15) goto L86;
    L70:
        return;
    L58:
        return;
    L87:
        this.lastIndex = r20;
        this.lastId = r14[r20].f17697id;
        r16 = r22;
        goto L88
    L41:
        if (r14[r20].f17697id == r19) goto L54;
    L88:
        if (r16 != 0) goto L90;
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L4;
        return;
    L90:
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L4;
    L91:
        int r23 = r16 - 1;
        if (r16 == 0) goto L4;
        monitor-enter(this);
        mt.s r24 = this.sources.poll();     // Catch: Throwable -> L99
        if (r24 != null) goto L101;
        this.wip--;     // Catch: Throwable -> L99
        monitor-exit(this);     // Catch: Throwable -> L99
    L103:
        r16 = r23;
        goto L91
    L101:
        monitor-exit(this);     // Catch: Throwable -> L99
        subscribeInner(r24);
    L99:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        throw th;
    L24:
        r17 = 0;
    L9:
        if (checkTerminate() == true) goto L10;
        Object r25 = r11.poll();
        if (r25 == null) goto L15;
        r5.onNext(r25);
        goto L9
    L10:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // mt.u
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        drain();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.done == false) goto L7;
        wn.f.k(r5);
        return;
    L7:
        if (this.errors.addThrowable(r5) == false) goto L9;
        this.done = true;
        drain();
        return;
    L9:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (this.done == false) goto L26;
        return;
    L26:
        Object r10 = this.mapper.apply(r5);     // Catch: Throwable -> L23
        io.reactivex.internal.functions.e.d(r10, "The mapper returned a null ObservableSource");     // Catch: Throwable -> L23
        mt.s r11 = (mt.s) r10;     // Catch: Throwable -> L23
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L21;
        monitor-enter(this);
        int r12 = this.wip;     // Catch: Throwable -> L14
        if (r12 != this.maxConcurrency) goto L16;
        this.sources.offer(r11);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L16:
        this.wip = r12 + 1;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L21:
        subscribeInner(r11);
        return;
    L23:
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

    /* JADX WARN: Multi-variable type inference failed */
    public void removeInner(ObservableFlatMap$InnerObserver<T, U> r10) {
    L2:
        ObservableFlatMap$InnerObserver<?, ?>[] r5 = this.observers.get();
        int r11 = r5.length;
        if (r11 == 0) goto L4;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        if (r5[r12] == r10) goto L12;
        r12 = r12 + 1;
    L12:
        if (r12 < 0) goto L13;
        if (r11 != 1) goto L17;
        ObservableFlatMap$InnerObserver<?, ?>[] r13 = EMPTY;
    L18:
        AtomicReference<ObservableFlatMap$InnerObserver<?, ?>[]> r14 = this.observers;
    L20:
        if (r14.compareAndSet(r5, r13) == true) goto L21;
        if (r14.get() == r5) goto L20;
    L21:
        return;
    L17:
        ObservableFlatMap$InnerObserver<?, ?>[] r15 = new ObservableFlatMap$InnerObserver[r11 - 1];
        System.arraycopy(r5, 0, r15, 0, r12);
        System.arraycopy(r5, r12 + 1, r15, r12, (r11 - r12) - 1);
        r13 = r15;
        goto L18
    L13:
        return;
    L11:
        r12 = -1;
        goto L12
    }

    public void subscribeInner(mt.s r10) {
    L3:
        if ((r10 instanceof Callable) == false) goto L20;
        if (tryEmitScalar((Callable) r10) == false) goto L33;
        if (this.maxConcurrency == Integer.MAX_VALUE) goto L34;
        monitor-enter(this);
        r10 = this.sources.poll();     // Catch: Throwable -> L12
        if (r10 != null) goto L14;
        boolean r5 = true;
        this.wip--;     // Catch: Throwable -> L12
    L15:
        monitor-exit(this);     // Catch: Throwable -> L12
        if (r5 == false) goto L3;
        drain();
        return;
    L14:
        r5 = false;
    L12:
        th = move-exception;
        throw th;
    L34:
        return;
    L33:
        return;
    L20:
        long r11 = this.uniqueId;
        this.uniqueId = 1 + r11;
        ObservableFlatMap$InnerObserver<T, U> r12 = new ObservableFlatMap$InnerObserver(this, r11);
        if (addInner(r12) == false) goto L32;
        r10.subscribe(r12);
        return;
    }

    public void tryEmit(U r5, ObservableFlatMap$InnerObserver<T, U> r10) {
        if (get() == 0) goto L5;
    L9:
        rt.h r11 = r10.queue;
        if (r11 != null) goto L12;
        r11 = new io.reactivex.internal.queue.b(this.bufferSize);
        r10.queue = r11;
    L12:
        r11.offer(r5);
        if (getAndIncrement() == 0) goto L15;
        return;
    L15:
        drainLoop();
        return;
    L5:
        if (compareAndSet(0, 1) == false) goto L9;
        this.downstream.onNext(r5);
        if (decrementAndGet() != 0) goto L15;
    }

    public boolean tryEmitScalar(Callable<? extends U> r5) {
        U r10 = r5.call();     // Catch: Throwable -> L29
        if (r10 != null) goto L7;
        return true;
    L7:
        if (get() == 0) goto L9;
    L13:
        rt.g r11 = this.queue;
        if (r11 != null) goto L21;
        if (this.maxConcurrency != Integer.MAX_VALUE) goto L18;
        r11 = new io.reactivex.internal.queue.b(this.bufferSize);
    L19:
        this.queue = r11;
        goto L21
    L18:
        r11 = new SpscArrayQueue(this.maxConcurrency);
    L21:
        if (r11.offer(r10) == true) goto L25;
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
        this.downstream.onNext(r10);
        if (decrementAndGet() != 0) goto L27;
        return true;
    L29:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.errors.addThrowable(th);
        drain();
        return true;
    }
}
