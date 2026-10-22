package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableGroupJoin$GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, r1 {
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
    final Map<Integer, io.reactivex.subjects.i> lefts;
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

    public ObservableGroupJoin$GroupJoinDisposable(mt.u r5, pt.o r10, pt.o r11, pt.c r12) {
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
        if (this.cancelled == false) goto L5;
        return;
    L5:
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
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
        if (r12 == false) goto L30;
        if (r14 == false) goto L30;
        Iterator<io.reactivex.subjects.i> r15 = this.lefts.values().iterator();
    L26:
        if (r15.hasNext() == false) goto L28;
        r15.next().onComplete();
        goto L26
    L28:
        this.lefts.clear();
        this.rights.clear();
        this.disposables.dispose();
        r10.onComplete();
        return;
    L30:
        if (r14 == true) goto L31;
        Object r16 = r5.poll();
        if (r13 == LEFT_VALUE) goto L36;
        if (r13 == RIGHT_VALUE) goto L55;
        if (r13 == LEFT_CLOSE) goto L70;
        if (r13 != RIGHT_CLOSE) goto L7;
        ObservableGroupJoin$LeftRightEndObserver r17 = (ObservableGroupJoin$LeftRightEndObserver) r16;
        this.rights.remove(Integer.valueOf(r17.index));
        this.disposables.a(r17);
        goto L7
    L70:
        ObservableGroupJoin$LeftRightEndObserver r18 = (ObservableGroupJoin$LeftRightEndObserver) r16;
        io.reactivex.subjects.i r19 = this.lefts.remove(Integer.valueOf(r18.index));
        this.disposables.a(r18);
        if (r19 == null) goto L7;
        r19.onComplete();
        goto L7
    L55:
        int r20 = this.rightIndex;
        this.rightIndex = r20 + 1;
        this.rights.put(Integer.valueOf(r20), (TRight) r16);
        Object r21 = this.rightEnd.apply(r16);     // Catch: Throwable -> L65
        io.reactivex.internal.functions.e.d(r21, "The rightEnd returned a null ObservableSource");     // Catch: Throwable -> L65
        mt.s r22 = (mt.s) r21;     // Catch: Throwable -> L65
        ObservableGroupJoin$LeftRightEndObserver r23 = new ObservableGroupJoin$LeftRightEndObserver(this, false, r20);
        this.disposables.b(r23);
        r22.subscribe(r23);
        if (this.error.get() != null) goto L59;
        Iterator<io.reactivex.subjects.i> r24 = this.lefts.values().iterator();
    L63:
        if (r24.hasNext() == false) goto L7;
        r24.next().onNext(r16);
        goto L63
    L59:
        r5.clear();
        cancelAll();
        errorAll(r10);
        return;
    L65:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L36:
        io.reactivex.subjects.i r25 = new io.reactivex.subjects.i(mt.n.bufferSize());
        int r26 = this.leftIndex;
        this.leftIndex = r26 + 1;
        this.lefts.put(Integer.valueOf(r26), r25);
        Object r27 = this.leftEnd.apply(r16);     // Catch: Throwable -> L50
        io.reactivex.internal.functions.e.d(r27, "The leftEnd returned a null ObservableSource");     // Catch: Throwable -> L50
        mt.s r28 = (mt.s) r27;     // Catch: Throwable -> L50
        ObservableGroupJoin$LeftRightEndObserver r29 = new ObservableGroupJoin$LeftRightEndObserver(this, true, r26);
        this.disposables.b(r29);
        r28.subscribe(r29);
        if (this.error.get() != null) goto L40;
        Object r30 = this.resultSelector.apply(r16, r25);     // Catch: Throwable -> L47
        io.reactivex.internal.functions.e.d(r30, "The resultSelector returned a null value");     // Catch: Throwable -> L47
        r10.onNext(r30);
        Iterator<TRight> r31 = this.rights.values().iterator();
    L45:
        if (r31.hasNext() == false) goto L7;
        r25.onNext(r31.next());
    L47:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L40:
        r5.clear();
        cancelAll();
        errorAll(r10);
        return;
    L50:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L31:
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
        Iterator<io.reactivex.subjects.i> r11 = this.lefts.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onError(r10);
        goto L4
    L6:
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
