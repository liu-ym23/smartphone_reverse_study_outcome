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
final class FlowableJoin$JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements zu.d, k {
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
    final Map<Integer, TLeft> lefts;
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

    public FlowableJoin$JoinSubscription(zu.c r5, pt.o r10, pt.o r11, pt.c r12) {
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
        boolean r11 = true;
        int r12 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        if (this.error.get() != null) goto L12;
        if (this.active.get() != 0) goto L17;
        boolean r13 = r11;
    L18:
        Integer r14 = (Integer) r5.poll();
        if (r14 != null) goto L21;
        boolean r15 = r11;
    L22:
        if (r13 == false) goto L26;
        if (r15 == false) goto L26;
        this.lefts.clear();
        this.rights.clear();
        this.disposables.dispose();
        r10.onComplete();
        return;
    L26:
        if (r15 == true) goto L27;
        Object r16 = r5.poll();
        if (r14 != LEFT_VALUE) goto L58;
        int r17 = this.leftIndex;
        this.leftIndex = r17 + 1;
        this.lefts.put(Integer.valueOf(r17), (TLeft) r16);
        Object r18 = this.leftEnd.apply(r16);     // Catch: Throwable -> L54
        io.reactivex.internal.functions.e.d(r18, "The leftEnd returned a null Publisher");     // Catch: Throwable -> L54
        zu.b r19 = (zu.b) r18;     // Catch: Throwable -> L54
        FlowableGroupJoin$LeftRightEndSubscriber r20 = new FlowableGroupJoin$LeftRightEndSubscriber(this, r11, r17);
        this.disposables.b(r20);
        r19.subscribe(r20);
        if (this.error.get() != null) goto L36;
        long r21 = this.requested.get();
        Iterator<TRight> r22 = this.rights.values().iterator();
        long r110 = 0;
    L40:
        if (r22.hasNext() == false) goto L52;
        Object r23 = this.resultSelector.apply(r16, r22.next());     // Catch: Throwable -> L48
        io.reactivex.internal.functions.e.d(r23, "The resultSelector returned a null value");     // Catch: Throwable -> L48
        if (r110 == r21) goto L46;
        r10.onNext(r23);
        r110 = r110 + 1;
        goto L40
    L46:
        io.reactivex.internal.util.d.a(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
        r5.clear();
        cancelAll();
        errorAll(r10);
        return;
    L48:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L52:
        if (r110 == 0) goto L90;
        v0.y(this.requested, r110);
    L90:
        r11 = true;
        goto L7
    L36:
        r5.clear();
        cancelAll();
        errorAll(r10);
        return;
    L54:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L58:
        if (r14 != RIGHT_VALUE) goto L85;
        int r24 = this.rightIndex;
        this.rightIndex = r24 + 1;
        this.rights.put(Integer.valueOf(r24), (TRight) r16);
        Object r25 = this.rightEnd.apply(r16);     // Catch: Throwable -> L81
        io.reactivex.internal.functions.e.d(r25, "The rightEnd returned a null Publisher");     // Catch: Throwable -> L81
        zu.b r26 = (zu.b) r25;     // Catch: Throwable -> L81
        FlowableGroupJoin$LeftRightEndSubscriber r27 = new FlowableGroupJoin$LeftRightEndSubscriber(this, false, r24);
        this.disposables.b(r27);
        r26.subscribe(r27);
        if (this.error.get() != null) goto L63;
        long r28 = this.requested.get();
        Iterator<TLeft> r29 = this.lefts.values().iterator();
        long r111 = 0;
    L67:
        if (r29.hasNext() == false) goto L79;
        Object r30 = this.resultSelector.apply(r29.next(), r16);     // Catch: Throwable -> L75
        io.reactivex.internal.functions.e.d(r30, "The resultSelector returned a null value");     // Catch: Throwable -> L75
        if (r111 == r28) goto L73;
        r10.onNext(r30);
        r111 = r111 + 1;
        goto L67
    L73:
        io.reactivex.internal.util.d.a(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
        r5.clear();
        cancelAll();
        errorAll(r10);
        return;
    L75:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L79:
        if (r111 == 0) goto L90;
        v0.y(this.requested, r111);
        goto L90
    L63:
        r5.clear();
        cancelAll();
        errorAll(r10);
        return;
    L81:
        th = move-exception;
        fail(th, r10, r5);
        return;
    L85:
        if (r14 != LEFT_CLOSE) goto L88;
        FlowableGroupJoin$LeftRightEndSubscriber r31 = (FlowableGroupJoin$LeftRightEndSubscriber) r16;
        this.lefts.remove(Integer.valueOf(r31.index));
        this.disposables.a(r31);
        goto L90
    L88:
        if (r14 != RIGHT_CLOSE) goto L90;
        FlowableGroupJoin$LeftRightEndSubscriber r32 = (FlowableGroupJoin$LeftRightEndSubscriber) r16;
        this.rights.remove(Integer.valueOf(r32.index));
        this.disposables.a(r32);
        goto L90
    L27:
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
        r5.clear();
        cancelAll();
        errorAll(r10);
        return;
    L8:
        r5.clear();
    }

    public void errorAll(zu.c r5) {
        Throwable r10 = io.reactivex.internal.util.d.b(this.error);
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
