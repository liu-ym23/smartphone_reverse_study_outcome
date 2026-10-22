package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowablePublish$PublishSubscriber<T> extends AtomicInteger implements mt.g, Disposable {
    static final FlowablePublish$InnerSubscriber[] EMPTY = null;
    static final FlowablePublish$InnerSubscriber[] TERMINATED = null;
    private static final long serialVersionUID = -202316842419149694L;
    final int bufferSize;
    final AtomicReference<FlowablePublish$PublishSubscriber<T>> current;
    volatile rt.h queue;
    final AtomicBoolean shouldConnect;
    int sourceMode;
    final AtomicReference<FlowablePublish$InnerSubscriber<T>[]> subscribers;
    volatile Object terminalEvent;
    final AtomicReference<zu.d> upstream;

    static {
        EMPTY = new FlowablePublish$InnerSubscriber[0];
        TERMINATED = new FlowablePublish$InnerSubscriber[0];
    }

    public FlowablePublish$PublishSubscriber(AtomicReference<FlowablePublish$PublishSubscriber<T>> r5, int r10) {
        this.upstream = new AtomicReference();
        this.subscribers = new AtomicReference(EMPTY);
        this.current = r5;
        this.shouldConnect = new AtomicBoolean();
        this.bufferSize = r10;
    }

    public boolean add(FlowablePublish$InnerSubscriber<T> r5) {
    L2:
        FlowablePublish$InnerSubscriber<T>[] r10 = this.subscribers.get();
        if (r10 == TERMINATED) goto L4;
        int r11 = r10.length;
        FlowablePublish$InnerSubscriber<T>[] r12 = new FlowablePublish$InnerSubscriber[r11 + 1];
        System.arraycopy(r10, 0, r12, 0, r11);
        r12[r11] = r5;
        AtomicReference<FlowablePublish$InnerSubscriber<T>[]> r13 = this.subscribers;
    L7:
        if (r13.compareAndSet(r10, r12) == true) goto L8;
        if (r13.get() == r10) goto L7;
    L8:
        return true;
    L4:
        return false;
    }

    public boolean checkTerminated(Object r5, boolean r10) {
        int r11 = 0;
        if (r5 != null) goto L5;
    L30:
        return false;
    L5:
        if (NotificationLite.isComplete(r5) == false) goto L17;
        if (r10 == false) goto L30;
        AtomicReference<FlowablePublish$PublishSubscriber<T>> r12 = this.current;
    L9:
        if (r12.compareAndSet(this, null) == true) goto L13;
        if (r12.get() == this) goto L9;
    L13:
        FlowablePublish$InnerSubscriber<T>[] r13 = this.subscribers.getAndSet(TERMINATED);
        int r14 = r13.length;
    L14:
        if (r11 >= r14) goto L16;
        r13[r11].child.onComplete();
        r11 = r11 + 1;
        goto L14
    L16:
        return true;
    L17:
        Throwable r15 = NotificationLite.getError(r5);
        AtomicReference<FlowablePublish$PublishSubscriber<T>> r16 = this.current;
    L19:
        if (r16.compareAndSet(this, null) == true) goto L23;
        if (r16.get() == this) goto L19;
    L23:
        FlowablePublish$InnerSubscriber<T>[] r17 = this.subscribers.getAndSet(TERMINATED);
        if (r17.length == 0) goto L28;
        int r18 = r17.length;
    L26:
        if (r11 >= r18) goto L29;
        r17[r11].child.onError(r15);
        r11 = r11 + 1;
    L29:
        return true;
    L28:
        wn.f.k(r15);
        goto L29
    }

    public void dispatch() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicReference<FlowablePublish$InnerSubscriber<T>[]> r5 = this.subscribers;
        boolean r10 = true;
        FlowablePublish$InnerSubscriber<T>[] r11 = r5.get();
        int r12 = 1;
    L6:
        Object r13 = this.terminalEvent;
        rt.h r14 = this.queue;
        if (r14 != null) goto L9;
    L12:
        boolean r15 = r10;
    L14:
        if (checkTerminated(r13, r15) == true) goto L15;
        if (r15 == true) goto L87;
        int r16 = r11.length;
        int r17 = r11.length;
        int r18 = 0;
        int r19 = 0;
        long r110 = Long.MAX_VALUE;
    L19:
        if (r18 >= r17) goto L26;
        FlowablePublish$InnerSubscriber<T> r20 = r11[r18];
        long r111 = r20.get();
        if (r111 == Long.MIN_VALUE) goto L23;
        r110 = Math.min(r110, r111 - r20.emitted);
    L24:
        r18 = r18 + 1;
        goto L19
    L23:
        r19 = r19 + 1;
        goto L24
    L26:
        if (r16 == r19) goto L27;
        int r112 = 0;
    L42:
        long r113 = r112;
        if (r113 >= r110) goto L78;
        Object r21 = this.terminalEvent;
        Object r22 = r14.poll();     // Catch: Throwable -> L47
    L49:
        if (r22 != null) goto L51;
        boolean r23 = r10;
    L53:
        if (checkTerminated(r21, r23) == true) goto L54;
        if (r23 == true) goto L56;
        Object r24 = NotificationLite.getValue(r22);
        int r25 = r11.length;
        int r114 = 0;
        boolean r115 = false;
    L58:
        if (r114 >= r25) goto L68;
        FlowablePublish$InnerSubscriber<T> r26 = r11[r114];
        long r27 = r26.get();
        if (r27 != Long.MIN_VALUE) goto L62;
        r14 = r14;
        r23 = r23;
        r115 = true;
    L67:
        r114 = r114 + 1;
        r14 = r14;
        r23 = r23;
        goto L58
    L62:
        if (r27 == Long.MAX_VALUE) goto L65;
        r26.emitted++;
    L65:
        r26.child.onNext(r24);
        goto L67
    L68:
        rt.h r28 = r14;
        boolean r29 = r23;
        r112 = r112 + 1;
        FlowablePublish$InnerSubscriber<T>[] r30 = r5.get();
        if (r115 == true) goto L73;
        if (r30 != r11) goto L73;
        r14 = r28;
        r15 = r29;
        r10 = true;
    L73:
        if (r112 != 0) goto L75;
    L77:
        r11 = r30;
        r10 = true;
        goto L6
    L75:
        if (this.sourceMode == 1) goto L77;
        this.upstream.get().request(r112);
        goto L77
    L56:
        r15 = r23;
        goto L78
    L54:
        return;
    L51:
        r23 = false;
    L47:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.get().cancel();
        r21 = NotificationLite.error(th);
        this.terminalEvent = r21;
        r22 = null;
    L78:
        if (r112 == 0) goto L82;
        r10 = true;
        if (this.sourceMode == 1) goto L84;
        this.upstream.get().request(r113);
    L84:
        if (r110 == 0) goto L87;
        if (r15 == true) goto L87;
    L82:
        r10 = true;
        goto L84
    L27:
        Object r31 = this.terminalEvent;
        Object r32 = r14.poll();     // Catch: Throwable -> L30
    L32:
        if (r32 != null) goto L34;
        boolean r33 = r10;
    L36:
        if (checkTerminated(r31, r33) == true) goto L37;
        if (this.sourceMode == r10) goto L6;
        this.upstream.get().request(1);
        goto L6
    L37:
        return;
    L34:
        r33 = false;
    L30:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.get().cancel();
        r31 = NotificationLite.error(th);
        this.terminalEvent = r31;
        r32 = null;
    L87:
        r12 = addAndGet(-r12);
        if (r12 == 0) goto L89;
        r11 = r5.get();
        goto L6
    L89:
        return;
    L15:
        return;
    L9:
        if (r14.isEmpty() == true) goto L12;
        r15 = false;
        goto L14
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        FlowablePublish$InnerSubscriber<T>[] r5 = this.subscribers.get();
        FlowablePublish$InnerSubscriber<T>[] r10 = TERMINATED;
        if (r5 != r10) goto L5;
        return;
    L5:
        if (this.subscribers.getAndSet(r10) == r10) goto L18;
        AtomicReference<FlowablePublish$PublishSubscriber<T>> r11 = this.current;
    L8:
        if (r11.compareAndSet(this, null) == true) goto L12;
        if (r11.get() == this) goto L8;
    L12:
        SubscriptionHelper.cancel(this.upstream);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.subscribers.get() != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // zu.c
    public void onComplete() {
        if (this.terminalEvent != null) goto L6;
        this.terminalEvent = NotificationLite.complete();
        dispatch();
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.terminalEvent != null) goto L5;
        this.terminalEvent = NotificationLite.error(r5);
        dispatch();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.sourceMode == 0) goto L5;
    L8:
        dispatch();
        return;
    L5:
        if (this.queue.offer(r5) == true) goto L8;
        onError(new MissingBackpressureException("Prefetch queue is full?!"));
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.setOnce(this.upstream, r5) == true) goto L5;
        return;
    L5:
        if ((r5 instanceof rt.e) == false) goto L14;
        rt.e r10 = (rt.e) r5;
        int r11 = r10.requestFusion(7);
        if (r11 != 1) goto L11;
        this.sourceMode = r11;
        this.queue = r10;
        this.terminalEvent = NotificationLite.complete();
        dispatch();
        return;
    L11:
        if (r11 != 2) goto L14;
        this.sourceMode = r11;
        this.queue = r10;
        r5.request(this.bufferSize);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.bufferSize);
        r5.request(this.bufferSize);
    }

    public void remove(FlowablePublish$InnerSubscriber<T> r10) {
    L2:
        FlowablePublish$InnerSubscriber<T>[] r5 = this.subscribers.get();
        int r11 = r5.length;
        if (r11 == 0) goto L21;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        if (r5[r12].equals(r10) == true) goto L12;
        r12 = r12 + 1;
    L12:
        if (r12 < 0) goto L13;
        if (r11 != 1) goto L17;
        FlowablePublish$InnerSubscriber<T>[] r13 = EMPTY;
    L18:
        AtomicReference<FlowablePublish$InnerSubscriber<T>[]> r14 = this.subscribers;
    L20:
        if (r14.compareAndSet(r5, r13) == true) goto L32;
        if (r14.get() == r5) goto L20;
    L32:
        return;
    L17:
        FlowablePublish$InnerSubscriber<T>[] r15 = new FlowablePublish$InnerSubscriber[r11 - 1];
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
}
