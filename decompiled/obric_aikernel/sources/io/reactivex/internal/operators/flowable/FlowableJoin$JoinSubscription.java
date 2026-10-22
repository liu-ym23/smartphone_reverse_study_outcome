package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableJoin$JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements tc.d, f {
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
    final Map<Integer, TLeft> lefts;
    final io.reactivex.internal.queue.a<Object> queue;
    final AtomicLong requested;
    final zb.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final zb.h<? super TRight, ? extends tc.b<TRightEnd>> rightEnd;
    int rightIndex;
    final Map<Integer, TRight> rights;

    static {
        LEFT_VALUE = 1;
        RIGHT_VALUE = 2;
        LEFT_CLOSE = 3;
        RIGHT_CLOSE = 4;
    }

    FlowableJoin$JoinSubscription(tc.c<? super R> r10, zb.h<? super TLeft, ? extends tc.b<TLeftEnd>> r11, zb.h<? super TRight, ? extends tc.b<TRightEnd>> r12, zb.c<? super TLeft, ? super TRight, ? extends R> r13) {
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
        boolean r12 = true;
        int r13 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (this.error.get() != null) goto L12;
        if (this.active.get() != 0) goto L17;
        boolean r14 = r12;
    L18:
        Integer r15 = (Integer) r10.poll();
        if (r15 != null) goto L21;
        boolean r16 = r12;
    L22:
        if (r14 == false) goto L26;
        if (r16 == false) goto L26;
        this.lefts.clear();
        this.rights.clear();
        this.disposables.dispose();
        r11.onComplete();
        return;
    L26:
        if (r16 == true) goto L27;
        Object r17 = r10.poll();
        if (r15 != LEFT_VALUE) goto L58;
        int r18 = this.leftIndex;
        this.leftIndex = r18 + 1;
        this.lefts.put(Integer.valueOf(r18), (TLeft) r17);
        tc.b r19 = (tc.b) io.reactivex.internal.functions.a.d(this.leftEnd.apply(r17), "The leftEnd returned a null Publisher");     // Catch: Throwable -> L54
        FlowableGroupJoin$LeftRightEndSubscriber r20 = new FlowableGroupJoin$LeftRightEndSubscriber(this, r12, r18);
        this.disposables.b(r20);
        r19.subscribe(r20);
        if (this.error.get() != null) goto L36;
        long r21 = this.requested.get();
        Iterator<TRight> r22 = this.rights.values().iterator();
        long r110 = 0;
    L40:
        if (r22.hasNext() == false) goto L52;
        a1.c r23 = (Object) io.reactivex.internal.functions.a.d(this.resultSelector.apply(r17, r22.next()), "The resultSelector returned a null value");
        if (r110 == r21) goto L46;
        r11.onNext(r23);
        r110 = r110 + 1;
        goto L40
    L46:
        ExceptionHelper.a(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
        r10.clear();
        cancelAll();
        errorAll(r11);
        return;
    L48:
        th = move-exception;
        fail(th, r11, r10);
        return;
    L52:
        if (r110 == 0) goto L91;
    L53:
        io.reactivex.internal.util.b.e(this.requested, r110);
    L91:
        r12 = true;
        goto L7
    L36:
        r10.clear();
        cancelAll();
        errorAll(r11);
        return;
    L54:
        th = move-exception;
        fail(th, r11, r10);
        return;
    L58:
        if (r15 != RIGHT_VALUE) goto L85;
        int r24 = this.rightIndex;
        this.rightIndex = r24 + 1;
        this.rights.put(Integer.valueOf(r24), (TRight) r17);
        tc.b r25 = (tc.b) io.reactivex.internal.functions.a.d(this.rightEnd.apply(r17), "The rightEnd returned a null Publisher");     // Catch: Throwable -> L81
        FlowableGroupJoin$LeftRightEndSubscriber r26 = new FlowableGroupJoin$LeftRightEndSubscriber(this, false, r24);
        this.disposables.b(r26);
        r25.subscribe(r26);
        if (this.error.get() != null) goto L63;
        long r27 = this.requested.get();
        Iterator<TLeft> r28 = this.lefts.values().iterator();
        r110 = 0;
    L67:
        if (r28.hasNext() == false) goto L79;
        a1.c r29 = (Object) io.reactivex.internal.functions.a.d(this.resultSelector.apply(r28.next(), r17), "The resultSelector returned a null value");
        if (r110 == r27) goto L73;
        r11.onNext(r29);
        r110 = r110 + 1;
        goto L67
    L73:
        ExceptionHelper.a(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
        r10.clear();
        cancelAll();
        errorAll(r11);
        return;
    L75:
        th = move-exception;
        fail(th, r11, r10);
        return;
    L79:
        if (r110 == 0) goto L91;
    L63:
        r10.clear();
        cancelAll();
        errorAll(r11);
        return;
    L81:
        th = move-exception;
        fail(th, r11, r10);
        return;
    L85:
        if (r15 != LEFT_CLOSE) goto L89;
        FlowableGroupJoin$LeftRightEndSubscriber r30 = (FlowableGroupJoin$LeftRightEndSubscriber) r17;
        Map r31 = this.lefts;
    L87:
        r31.remove(Integer.valueOf(r30.index));
        this.disposables.a(r30);
        goto L91
    L89:
        if (r15 != RIGHT_CLOSE) goto L91;
        r30 = (FlowableGroupJoin$LeftRightEndSubscriber) r17;
        r31 = this.rights;
        goto L87
    L27:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L7;
        return;
    L21:
        r16 = false;
        goto L22
    L17:
        r14 = false;
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
