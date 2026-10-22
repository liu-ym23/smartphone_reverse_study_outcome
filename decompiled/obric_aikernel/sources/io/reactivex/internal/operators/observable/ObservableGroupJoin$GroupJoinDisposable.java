package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableGroupJoin$GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements io.reactivex.disposables.b, e {
    static final Integer LEFT_CLOSE = null;
    static final Integer LEFT_VALUE = null;
    static final Integer RIGHT_CLOSE = null;
    static final Integer RIGHT_VALUE = null;
    private static final long serialVersionUID = -6071216598687999801L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final io.reactivex.disposables.a disposables;
    final xb.o<? super R> downstream;
    final AtomicReference<Throwable> error;
    final zb.h<? super TLeft, ? extends xb.n<TLeftEnd>> leftEnd;
    int leftIndex;
    final Map<Integer, UnicastSubject<TRight>> lefts;
    final io.reactivex.internal.queue.a<Object> queue;
    final zb.c<? super TLeft, ? super Observable<TRight>, ? extends R> resultSelector;
    final zb.h<? super TRight, ? extends xb.n<TRightEnd>> rightEnd;
    int rightIndex;
    final Map<Integer, TRight> rights;

    static {
        LEFT_VALUE = 1;
        RIGHT_VALUE = 2;
        LEFT_CLOSE = 3;
        RIGHT_CLOSE = 4;
    }

    ObservableGroupJoin$GroupJoinDisposable(xb.o<? super R> r10, zb.h<? super TLeft, ? extends xb.n<TLeftEnd>> r11, zb.h<? super TRight, ? extends xb.n<TRightEnd>> r12, zb.c<? super TLeft, ? super Observable<TRight>, ? extends R> r13) {
        this.downstream = r10;
        this.disposables = new io.reactivex.disposables.a();
        this.queue = new io.reactivex.internal.queue.a(Observable.a());
        this.lefts = new LinkedHashMap();
        this.rights = new LinkedHashMap();
        this.error = new AtomicReference();
        this.leftEnd = r11;
        this.rightEnd = r12;
        this.resultSelector = r13;
        this.active = new AtomicInteger(2);
    }

    void cancelAll() {
        this.disposables.dispose();
    }

    @Override // io.reactivex.disposables.b
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

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.a<?> r10 = this.queue;
        xb.o<? super R> r11 = this.downstream;
        int r12 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (this.error.get() != null) goto L12;
        if (this.active.get() != 0) goto L17;
        boolean r13 = true;
    L18:
        Integer r14 = (Integer) r10.poll();
        if (r14 != null) goto L21;
        boolean r15 = true;
    L22:
        if (r13 == false) goto L30;
        if (r15 == false) goto L30;
        Iterator<UnicastSubject<TRight>> r16 = this.lefts.values().iterator();
    L26:
        if (r16.hasNext() == false) goto L28;
        r16.next().onComplete();
        goto L26
    L28:
        this.lefts.clear();
        this.rights.clear();
        this.disposables.dispose();
        r11.onComplete();
        return;
    L30:
        if (r15 == true) goto L31;
        Object r17 = r10.poll();
        if (r14 == LEFT_VALUE) goto L36;
        if (r14 == RIGHT_VALUE) goto L55;
        if (r14 == LEFT_CLOSE) goto L70;
        if (r14 != RIGHT_CLOSE) goto L7;
        ObservableGroupJoin$LeftRightEndObserver r18 = (ObservableGroupJoin$LeftRightEndObserver) r17;
        this.rights.remove(Integer.valueOf(r18.index));
        this.disposables.a(r18);
        goto L7
    L70:
        ObservableGroupJoin$LeftRightEndObserver r19 = (ObservableGroupJoin$LeftRightEndObserver) r17;
        UnicastSubject<TRight> r20 = this.lefts.remove(Integer.valueOf(r19.index));
        this.disposables.a(r19);
        if (r20 == null) goto L7;
        r20.onComplete();
        goto L7
    L55:
        int r21 = this.rightIndex;
        this.rightIndex = r21 + 1;
        this.rights.put(Integer.valueOf(r21), (TRight) r17);
        xb.n r22 = (xb.n) io.reactivex.internal.functions.a.d(this.rightEnd.apply(r17), "The rightEnd returned a null ObservableSource");     // Catch: Throwable -> L65
        ObservableGroupJoin$LeftRightEndObserver r23 = new ObservableGroupJoin$LeftRightEndObserver(this, false, r21);
        this.disposables.b(r23);
        r22.subscribe(r23);
        if (this.error.get() != null) goto L59;
        Iterator<UnicastSubject<TRight>> r24 = this.lefts.values().iterator();
    L63:
        if (r24.hasNext() == false) goto L7;
        r24.next().onNext(r17);
        goto L63
    L59:
        r10.clear();
        cancelAll();
        errorAll(r11);
        return;
    L65:
        th = move-exception;
        fail(th, r11, r10);
        return;
    L36:
        UnicastSubject r25 = UnicastSubject.h();
        int r26 = this.leftIndex;
        this.leftIndex = r26 + 1;
        this.lefts.put(Integer.valueOf(r26), (UnicastSubject<TRight>) r25);
        xb.n r27 = (xb.n) io.reactivex.internal.functions.a.d(this.leftEnd.apply(r17), "The leftEnd returned a null ObservableSource");     // Catch: Throwable -> L50
        ObservableGroupJoin$LeftRightEndObserver r28 = new ObservableGroupJoin$LeftRightEndObserver(this, true, r26);
        this.disposables.b(r28);
        r27.subscribe(r28);
        if (this.error.get() != null) goto L40;
        r11.onNext((Object) io.reactivex.internal.functions.a.d(this.resultSelector.apply(r17, r25), "The resultSelector returned a null value"));
        Iterator<TRight> r29 = this.rights.values().iterator();
    L45:
        if (r29.hasNext() == false) goto L7;
        r25.onNext(r29.next());
    L47:
        th = move-exception;
        fail(th, r11, r10);
        return;
    L40:
        r10.clear();
        cancelAll();
        errorAll(r11);
        return;
    L50:
        th = move-exception;
        fail(th, r11, r10);
        return;
    L31:
        r12 = addAndGet(-r12);
        if (r12 != 0) goto L7;
        return;
    L21:
        r15 = false;
        goto L22
    L17:
        r13 = false;
        goto L18
    L12:
        r10.clear();
        cancelAll();
        errorAll(r11);
        return;
    L8:
        r10.clear();
    }

    void errorAll(xb.o<?> r10) {
        Throwable r11 = ExceptionHelper.b(this.error);
        Iterator<UnicastSubject<TRight>> r12 = this.lefts.values().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().onError(r11);
        goto L4
    L6:
        this.lefts.clear();
        this.rights.clear();
        r10.onError(r11);
    }

    void fail(Throwable r10, xb.o<?> r11, io.reactivex.internal.queue.a<?> r12) {
        io.reactivex.exceptions.a.a(r10);
        ExceptionHelper.a(this.error, r10);
        r12.clear();
        cancelAll();
        errorAll(r11);
    }

    @Override // io.reactivex.internal.operators.observable.e
    public void innerClose(boolean r10, ObservableGroupJoin$LeftRightEndObserver r11) {
        monitor-enter(this);
        io.reactivex.internal.queue.a<Object> r12 = this.queue;     // Catch: Throwable -> L11
        if (r10 == false) goto L6;
        Integer r13 = LEFT_CLOSE;     // Catch: Throwable -> L11
    L7:
        r12.l(r13, r11);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        drain();
        return;
    L6:
        r13 = RIGHT_CLOSE;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.internal.operators.observable.e
    public void innerCloseError(Throwable r10) {
        if (ExceptionHelper.a(this.error, r10) == false) goto L5;
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // io.reactivex.internal.operators.observable.e
    public void innerComplete(ObservableGroupJoin$LeftRightObserver r10) {
        this.disposables.c(r10);
        this.active.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.observable.e
    public void innerError(Throwable r10) {
        if (ExceptionHelper.a(this.error, r10) == false) goto L5;
        this.active.decrementAndGet();
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // io.reactivex.internal.operators.observable.e
    public void innerValue(boolean r10, Object r11) {
        monitor-enter(this);
        io.reactivex.internal.queue.a<Object> r12 = this.queue;     // Catch: Throwable -> L11
        if (r10 == false) goto L6;
        Integer r13 = LEFT_VALUE;     // Catch: Throwable -> L11
    L7:
        r12.l(r13, r11);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        drain();
        return;
    L6:
        r13 = RIGHT_VALUE;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }
}
