package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableJoin$JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, r1 {
    static final Integer LEFT_CLOSE = null;
    static final Integer LEFT_VALUE = null;
    static final Integer RIGHT_CLOSE = null;
    static final Integer RIGHT_VALUE = null;
    private static final long serialVersionUID = -6071216598687999801L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final io.reactivex.disposables.a disposables;
    final mt.u downstream;
    final AtomicReference<Throwable> error;
    final pt.o leftEnd;
    int leftIndex;
    final Map<Integer, TLeft> lefts;
    final io.reactivex.internal.queue.b queue;
    final pt.c resultSelector;
    final pt.o rightEnd;
    int rightIndex;
    final Map<Integer, TRight> rights;

    static {
        LEFT_VALUE = 1;
        RIGHT_VALUE = 2;
        LEFT_CLOSE = 3;
        RIGHT_CLOSE = 4;
    }

    public ObservableJoin$JoinDisposable(mt.u r5, pt.o r10, pt.o r11, pt.c r12) {
        this.downstream = r5;
        this.disposables = new io.reactivex.disposables.a();
        this.queue = new io.reactivex.internal.queue.b(mt.n.bufferSize());
        this.lefts = new LinkedHashMap();
        this.rights = new LinkedHashMap();
        this.error = new AtomicReference();
        this.leftEnd = r10;
        this.rightEnd = r11;
        this.resultSelector = r12;
        this.active = new AtomicInteger(2);
    }

    public void cancelAll() {
        this.disposables.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.b r5 = this.queue;
        mt.u r10 = this.downstream;
        int r11 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (this.error.get() != null) goto L12;
        if (this.active.get() != 0) goto L17;
        boolean r12 = true;
    L18:
        Integer r13 = (Integer) r5.poll();
        if (r13 != null) goto L21;
        boolean r14 = true;
    L22:
        if (r12 == false) goto L26;
        if (r14 == false) goto L26;
        this.lefts.clear();
        this.rights.clear();
        this.disposables.dispose();
        r10.onComplete();
        return;
    L26:
        if (r14 == true) goto L27;
        Object r15 = r5.poll();
        if (r13 == LEFT_VALUE) goto L32;
        if (r13 == RIGHT_VALUE) goto L52;
        if (r13 == LEFT_CLOSE) goto L72;
        ObservableGroupJoin$LeftRightEndObserver r16 = (ObservableGroupJoin$LeftRightEndObserver) r15;
        this.rights.remove(Integer.valueOf(r16.index));
        this.disposables.a(r16);
        goto L7
    L72:
        ObservableGroupJoin$LeftRightEndObserver r17 = (ObservableGroupJoin$LeftRightEndObserver) r15;
        this.lefts.remove(Integer.valueOf(r17.index));
        this.disposables.a(r17);
        goto L7
    L52:
        int r18 = this.rightIndex;
        this.rightIndex = r18 + 1;
        this.rights.put(Integer.valueOf(r18), (TRight) r15);
        Object r19 = this.rightEnd.apply(r15);     // Catch: Throwable -> L67
        io.reactivex.internal.functions.e.d(r19, "The rightEnd returned a null ObservableSource");     // Catch: Throwable -> L67
        mt.s r20 = (mt.s) r19;     // Catch: Throwable -> L67
        ObservableGroupJoin$LeftRightEndObserver r21 = new ObservableGroupJoin$LeftRightEndObserver(this, false, r18);
        this.disposables.b(r21);
        r20.subscribe(r21);
        if (this.error.get() != null) goto L56;
        Iterator<TLeft> r22 = this.lefts.values().iterator();
    L60:
        if (r22.hasNext() == false) goto L7;
        Object r23 = this.resultSelector.apply(r22.next(), r15);     // Catch: Throwable -> L64
        io.reactivex.internal.functions.e.d(r23, "The resultSelector returned a null value");     // Catch: Throwable -> L64
        r10.onNext(r23);
    L64:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L56:
        r5.clear();
        cancelAll();
        errorAll(r10);
        return;
    L67:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L32:
        int r24 = this.leftIndex;
        this.leftIndex = r24 + 1;
        this.lefts.put(Integer.valueOf(r24), (TLeft) r15);
        Object r25 = this.leftEnd.apply(r15);     // Catch: Throwable -> L47
        io.reactivex.internal.functions.e.d(r25, "The leftEnd returned a null ObservableSource");     // Catch: Throwable -> L47
        mt.s r26 = (mt.s) r25;     // Catch: Throwable -> L47
        ObservableGroupJoin$LeftRightEndObserver r27 = new ObservableGroupJoin$LeftRightEndObserver(this, true, r24);
        this.disposables.b(r27);
        r26.subscribe(r27);
        if (this.error.get() != null) goto L36;
        Iterator<TRight> r28 = this.rights.values().iterator();
    L40:
        if (r28.hasNext() == false) goto L7;
        Object r29 = this.resultSelector.apply(r15, r28.next());     // Catch: Throwable -> L44
        io.reactivex.internal.functions.e.d(r29, "The resultSelector returned a null value");     // Catch: Throwable -> L44
        r10.onNext(r29);
    L44:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L36:
        r5.clear();
        cancelAll();
        errorAll(r10);
        return;
    L47:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L27:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L7;
        return;
    L21:
        r14 = false;
        goto L22
    L17:
        r12 = false;
        goto L18
    L12:
        r5.clear();
        cancelAll();
        errorAll(r10);
        return;
    L8:
        r5.clear();
    }

    public void errorAll(mt.u r5) {
        Throwable r10 = io.reactivex.internal.util.d.b(this.error);
        this.lefts.clear();
        this.rights.clear();
        r5.onError(r10);
    }

    public void fail(Throwable r5, mt.u r10, io.reactivex.internal.queue.b r11) {
        com.lynx.jsbridge.a.t(r5);
        io.reactivex.internal.util.d.a(this.error, r5);
        r11.clear();
        cancelAll();
        errorAll(r10);
    }

    @Override // io.reactivex.internal.operators.observable.r1
    public void innerClose(boolean r5, ObservableGroupJoin$LeftRightEndObserver r10) {
        monitor-enter(this);
        io.reactivex.internal.queue.b r11 = this.queue;     // Catch: Throwable -> L6
        if (r5 == false) goto L8;
        Integer r12 = LEFT_CLOSE;     // Catch: Throwable -> L6
    L9:
        r11.a(r12, r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        drain();
        return;
    L8:
        r12 = RIGHT_CLOSE;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.internal.operators.observable.r1
    public void innerCloseError(Throwable r5) {
        if (io.reactivex.internal.util.d.a(this.error, r5) == false) goto L5;
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // io.reactivex.internal.operators.observable.r1
    public void innerComplete(ObservableGroupJoin$LeftRightObserver r5) {
        this.disposables.c(r5);
        this.active.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.observable.r1
    public void innerError(Throwable r5) {
        if (io.reactivex.internal.util.d.a(this.error, r5) == false) goto L5;
        this.active.decrementAndGet();
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // io.reactivex.internal.operators.observable.r1
    public void innerValue(boolean r5, Object r10) {
        monitor-enter(this);
        io.reactivex.internal.queue.b r11 = this.queue;     // Catch: Throwable -> L6
        if (r5 == false) goto L8;
        Integer r12 = LEFT_VALUE;     // Catch: Throwable -> L6
    L9:
        r11.a(r12, r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        drain();
        return;
    L8:
        r12 = RIGHT_VALUE;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }
}
