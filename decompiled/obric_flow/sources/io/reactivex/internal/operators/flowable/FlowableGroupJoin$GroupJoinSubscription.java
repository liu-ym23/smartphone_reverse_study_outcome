package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableGroupJoin$GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements zu.d, k {
    static final Integer LEFT_CLOSE = null;
    static final Integer LEFT_VALUE = null;
    static final Integer RIGHT_CLOSE = null;
    static final Integer RIGHT_VALUE = null;
    private static final long serialVersionUID = -6071216598687999801L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final io.reactivex.disposables.a disposables;
    final zu.c downstream;
    final AtomicReference<Throwable> error;
    final pt.o leftEnd;
    int leftIndex;
    final Map<Integer, io.reactivex.processors.g> lefts;
    final io.reactivex.internal.queue.b queue;
    final AtomicLong requested;
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

    public FlowableGroupJoin$GroupJoinSubscription(zu.c r5, pt.o r10, pt.o r11, pt.c r12) {
        this.downstream = r5;
        this.requested = new AtomicLong();
        this.disposables = new io.reactivex.disposables.a();
        this.queue = new io.reactivex.internal.queue.b(mt.e.f20168a);
        this.lefts = new LinkedHashMap();
        this.rights = new LinkedHashMap();
        this.error = new AtomicReference();
        this.leftEnd = r10;
        this.rightEnd = r11;
        this.resultSelector = r12;
        this.active = new AtomicInteger(2);
    }

    @Override // zu.d
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

    public void cancelAll() {
        this.disposables.dispose();
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.b r5 = this.queue;
        zu.c r10 = this.downstream;
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
        Iterator<io.reactivex.processors.g> r15 = this.lefts.values().iterator();
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
        if (r13 == RIGHT_VALUE) goto L59;
        if (r13 == LEFT_CLOSE) goto L74;
        if (r13 != RIGHT_CLOSE) goto L7;
        FlowableGroupJoin$LeftRightEndSubscriber r17 = (FlowableGroupJoin$LeftRightEndSubscriber) r16;
        this.rights.remove(Integer.valueOf(r17.index));
        this.disposables.a(r17);
        goto L7
    L74:
        FlowableGroupJoin$LeftRightEndSubscriber r18 = (FlowableGroupJoin$LeftRightEndSubscriber) r16;
        io.reactivex.processors.g r19 = this.lefts.remove(Integer.valueOf(r18.index));
        this.disposables.a(r18);
        if (r19 == null) goto L7;
        r19.onComplete();
        goto L7
    L59:
        int r20 = this.rightIndex;
        this.rightIndex = r20 + 1;
        this.rights.put(Integer.valueOf(r20), (TRight) r16);
        Object r21 = this.rightEnd.apply(r16);     // Catch: Throwable -> L69
        io.reactivex.internal.functions.e.d(r21, "The rightEnd returned a null Publisher");     // Catch: Throwable -> L69
        zu.b r22 = (zu.b) r21;     // Catch: Throwable -> L69
        FlowableGroupJoin$LeftRightEndSubscriber r23 = new FlowableGroupJoin$LeftRightEndSubscriber(this, false, r20);
        this.disposables.b(r23);
        r22.subscribe(r23);
        if (this.error.get() != null) goto L63;
        Iterator<io.reactivex.processors.g> r24 = this.lefts.values().iterator();
    L67:
        if (r24.hasNext() == false) goto L7;
        r24.next().onNext(r16);
        goto L67
    L63:
        r5.clear();
        cancelAll();
        errorAll(r10);
        return;
    L69:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L36:
        io.reactivex.processors.g r25 = new io.reactivex.processors.g(null, mt.e.f20168a);
        int r26 = this.leftIndex;
        this.leftIndex = r26 + 1;
        this.lefts.put(Integer.valueOf(r26), r25);
        Object r27 = this.leftEnd.apply(r16);     // Catch: Throwable -> L54
        io.reactivex.internal.functions.e.d(r27, "The leftEnd returned a null Publisher");     // Catch: Throwable -> L54
        zu.b r28 = (zu.b) r27;     // Catch: Throwable -> L54
        FlowableGroupJoin$LeftRightEndSubscriber r29 = new FlowableGroupJoin$LeftRightEndSubscriber(this, true, r26);
        this.disposables.b(r29);
        r28.subscribe(r29);
        if (this.error.get() != null) goto L40;
        Object r30 = this.resultSelector.apply(r16, r25);     // Catch: Throwable -> L51
        io.reactivex.internal.functions.e.d(r30, "The resultSelector returned a null value");     // Catch: Throwable -> L51
        if (this.requested.get() == 0) goto L49;
        r10.onNext(r30);
        v0.y(this.requested, 1);
        Iterator<TRight> r31 = this.rights.values().iterator();
    L47:
        if (r31.hasNext() == false) goto L7;
        r25.onNext(r31.next());
        goto L47
    L49:
        fail(new MissingBackpressureException("Could not emit value due to lack of requests"), r10, r5);
        return;
    L51:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L40:
        r5.clear();
        cancelAll();
        errorAll(r10);
        return;
    L54:
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

    public void errorAll(zu.c r5) {
        Throwable r10 = io.reactivex.internal.util.d.b(this.error);
        Iterator<io.reactivex.processors.g> r11 = this.lefts.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onError(r10);
        goto L4
    L6:
        this.lefts.clear();
        this.rights.clear();
        r5.onError(r10);
    }

    public void fail(Throwable r5, zu.c r10, rt.h r11) {
        com.lynx.jsbridge.a.t(r5);
        io.reactivex.internal.util.d.a(this.error, r5);
        r11.clear();
        cancelAll();
        errorAll(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.k
    public void innerClose(boolean r5, FlowableGroupJoin$LeftRightEndSubscriber r10) {
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

    @Override // io.reactivex.internal.operators.flowable.k
    public void innerCloseError(Throwable r5) {
        if (io.reactivex.internal.util.d.a(this.error, r5) == false) goto L5;
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // io.reactivex.internal.operators.flowable.k
    public void innerComplete(FlowableGroupJoin$LeftRightSubscriber r5) {
        this.disposables.c(r5);
        this.active.decrementAndGet();
        drain();
    }

    @Override // io.reactivex.internal.operators.flowable.k
    public void innerError(Throwable r5) {
        if (io.reactivex.internal.util.d.a(this.error, r5) == false) goto L5;
        this.active.decrementAndGet();
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // io.reactivex.internal.operators.flowable.k
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

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        return;
    }
}
