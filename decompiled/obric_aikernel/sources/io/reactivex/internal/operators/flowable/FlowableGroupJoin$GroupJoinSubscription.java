package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableGroupJoin$GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements tc.d, f {
    static final Integer LEFT_CLOSE = null;
    static final Integer LEFT_VALUE = null;
    static final Integer RIGHT_CLOSE = null;
    static final Integer RIGHT_VALUE = null;
    private static final long serialVersionUID = -6071216598687999801L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final io.reactivex.disposables.a disposables;
    final tc.c<? super R> downstream;
    final AtomicReference<Throwable> error;
    final zb.h<? super TLeft, ? extends tc.b<TLeftEnd>> leftEnd;
    int leftIndex;
    final Map<Integer, UnicastProcessor<TRight>> lefts;
    final io.reactivex.internal.queue.a<Object> queue;
    final AtomicLong requested;
    final zb.c<? super TLeft, ? super xb.e<TRight>, ? extends R> resultSelector;
    final zb.h<? super TRight, ? extends tc.b<TRightEnd>> rightEnd;
    int rightIndex;
    final Map<Integer, TRight> rights;

    static {
        LEFT_VALUE = 1;
        RIGHT_VALUE = 2;
        LEFT_CLOSE = 3;
        RIGHT_CLOSE = 4;
    }

    FlowableGroupJoin$GroupJoinSubscription(tc.c<? super R> r10, zb.h<? super TLeft, ? extends tc.b<TLeftEnd>> r11, zb.h<? super TRight, ? extends tc.b<TRightEnd>> r12, zb.c<? super TLeft, ? super xb.e<TRight>, ? extends R> r13) {
        this.downstream = r10;
        this.requested = new AtomicLong();
        this.disposables = new io.reactivex.disposables.a();
        this.queue = new io.reactivex.internal.queue.a(xb.e.a());
        this.lefts = new LinkedHashMap();
        this.rights = new LinkedHashMap();
        this.error = new AtomicReference();
        this.leftEnd = r11;
        this.rightEnd = r12;
        this.resultSelector = r13;
        this.active = new AtomicInteger(2);
    }

    @Override // tc.d
    public void cancel() {
        if (this.cancelled == false) goto L5;
        return;
    L5:
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    }

    void cancelAll() {
        this.disposables.dispose();
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.a<Object> r10 = this.queue;
        tc.c<? super R> r11 = this.downstream;
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
        Iterator<UnicastProcessor<TRight>> r16 = this.lefts.values().iterator();
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
        if (r14 == RIGHT_VALUE) goto L59;
        if (r14 == LEFT_CLOSE) goto L74;
        if (r14 != RIGHT_CLOSE) goto L7;
        FlowableGroupJoin$LeftRightEndSubscriber r18 = (FlowableGroupJoin$LeftRightEndSubscriber) r17;
        this.rights.remove(Integer.valueOf(r18.index));
        this.disposables.a(r18);
        goto L7
    L74:
        FlowableGroupJoin$LeftRightEndSubscriber r19 = (FlowableGroupJoin$LeftRightEndSubscriber) r17;
        UnicastProcessor<TRight> r20 = this.lefts.remove(Integer.valueOf(r19.index));
        this.disposables.a(r19);
        if (r20 == null) goto L7;
        r20.onComplete();
        goto L7
    L59:
        int r21 = this.rightIndex;
        this.rightIndex = r21 + 1;
        this.rights.put(Integer.valueOf(r21), (TRight) r17);
        tc.b r22 = (tc.b) io.reactivex.internal.functions.a.d(this.rightEnd.apply(r17), "The rightEnd returned a null Publisher");     // Catch: Throwable -> L69
        FlowableGroupJoin$LeftRightEndSubscriber r23 = new FlowableGroupJoin$LeftRightEndSubscriber(this, false, r21);
        this.disposables.b(r23);
        r22.subscribe(r23);
        if (this.error.get() != null) goto L63;
        Iterator<UnicastProcessor<TRight>> r24 = this.lefts.values().iterator();
    L67:
        if (r24.hasNext() == false) goto L7;
        r24.next().onNext(r17);
        goto L67
    L63:
        r10.clear();
        cancelAll();
        errorAll(r11);
        return;
    L69:
        th = move-exception;
        fail(th, r11, r10);
        return;
    L36:
        UnicastProcessor r25 = UnicastProcessor.e();
        int r26 = this.leftIndex;
        this.leftIndex = r26 + 1;
        this.lefts.put(Integer.valueOf(r26), (UnicastProcessor<TRight>) r25);
        tc.b r27 = (tc.b) io.reactivex.internal.functions.a.d(this.leftEnd.apply(r17), "The leftEnd returned a null Publisher");     // Catch: Throwable -> L54
        FlowableGroupJoin$LeftRightEndSubscriber r28 = new FlowableGroupJoin$LeftRightEndSubscriber(this, true, r26);
        this.disposables.b(r28);
        r27.subscribe(r28);
        if (this.error.get() != null) goto L40;
        a1.c r29 = (Object) io.reactivex.internal.functions.a.d(this.resultSelector.apply(r17, r25), "The resultSelector returned a null value");
        if (this.requested.get() == 0) goto L49;
        r11.onNext(r29);
        io.reactivex.internal.util.b.e(this.requested, 1);
        Iterator<TRight> r30 = this.rights.values().iterator();
    L47:
        if (r30.hasNext() == false) goto L7;
        r25.onNext(r30.next());
        goto L47
    L49:
        fail(new MissingBackpressureException("Could not emit value due to lack of requests"), r11, r10);
        return;
    L51:
        th = move-exception;
        fail(th, r11, r10);
        return;
    L40:
        r10.clear();
        cancelAll();
        errorAll(r11);
        return;
    L54:
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

    void errorAll(tc.c<?> r10) {
        Throwable r11 = ExceptionHelper.b(this.error);
        Iterator<UnicastProcessor<TRight>> r12 = this.lefts.values().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().onError(r11);
        goto L4
    L6:
        this.lefts.clear();
        this.rights.clear();
        r10.onError(r11);
    }

    void fail(Throwable r10, tc.c<?> r11, bc.f<?> r12) {
        io.reactivex.exceptions.a.a(r10);
        ExceptionHelper.a(this.error, r10);
        r12.clear();
        cancelAll();
        errorAll(r11);
    }

    @Override // io.reactivex.internal.operators.flowable.f
    public void innerClose(boolean r10, FlowableGroupJoin$LeftRightEndSubscriber r11) {
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

    @Override // io.reactivex.internal.operators.flowable.f
    public void innerCloseError(Throwable r10) {
        if (ExceptionHelper.a(this.error, r10) == false) goto L5;
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.f
    public void innerComplete(FlowableGroupJoin$LeftRightSubscriber r10) {
        this.disposables.c(r10);
        this.active.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.f
    public void innerError(Throwable r10) {
        if (ExceptionHelper.a(this.error, r10) == false) goto L5;
        this.active.decrementAndGet();
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.f
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

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        return;
    }
}
