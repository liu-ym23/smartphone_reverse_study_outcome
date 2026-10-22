package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mt.b0;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableMergeWithSingle$MergeWithObserver<T> extends AtomicInteger implements mt.g, zu.d {
    static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    volatile boolean cancelled;
    int consumed;
    final zu.c downstream;
    long emitted;
    final AtomicThrowable error;
    final int limit;
    volatile boolean mainDone;
    final AtomicReference<zu.d> mainSubscription;
    final OtherObserver<T> otherObserver;
    volatile int otherState;
    final int prefetch;
    volatile rt.g queue;
    final AtomicLong requested;
    T singleItem;

    public static final class OtherObserver<T> extends AtomicReference<Disposable> implements b0 {
        private static final long serialVersionUID = -2935427570954647017L;
        final FlowableMergeWithSingle$MergeWithObserver<T> parent;

        public OtherObserver(FlowableMergeWithSingle$MergeWithObserver<T> r5) {
            this.parent = r5;
        }

        @Override // mt.b0, mt.j
        public void onError(Throwable r5) {
            this.parent.otherError(r5);
        }

        @Override // mt.b0, mt.j
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }

        @Override // mt.b0, mt.j
        public void onSuccess(T r5) {
            this.parent.otherSuccess(r5);
        }
    }

    public FlowableMergeWithSingle$MergeWithObserver(zu.c r5) {
        this.downstream = r5;
        this.mainSubscription = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
        int r10 = mt.e.f20168a;
        this.prefetch = r10;
        this.limit = r10 - (r10 >> 2);
    }

    @Override // zu.d
    public void cancel() {
        this.cancelled = true;
        SubscriptionHelper.cancel(this.mainSubscription);
        DisposableHelper.dispose(this.otherObserver);
        if (getAndIncrement() != 0) goto L6;
        this.queue = null;
        this.singleItem = null;
        return;
    }

    public void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    public void drainLoop() {
        zu.c r5 = this.downstream;
        long r10 = this.emitted;
        int r11 = this.consumed;
        int r12 = this.limit;
        int r13 = 1;
        int r14 = 1;
    L3:
        long r15 = this.requested.get();
    L5:
        if (r10 == r15) goto L35;
        if (this.cancelled == true) goto L8;
        if (this.error.get() != null) goto L12;
        int r16 = this.otherState;
        if (r16 == r13) goto L16;
        boolean r17 = this.mainDone;
        rt.g r18 = this.queue;
        if (r18 == null) goto L20;
        Object r19 = r18.poll();
    L21:
        if (r19 != null) goto L23;
        boolean r110 = true;
    L24:
        if (r17 == false) goto L29;
        if (r110 == false) goto L29;
        if (r16 != 2) goto L29;
        this.queue = null;
        r5.onComplete();
        return;
    L29:
        if (r110 == true) goto L35;
        r5.onNext(r19);
        r10 = r10 + 1;
        r11 = r11 + 1;
        if (r11 != r12) goto L34;
        this.mainSubscription.get().request(r12);
        r11 = 0;
    L34:
        r13 = 1;
        goto L5
    L23:
        r110 = false;
        goto L24
    L20:
        r19 = null;
        goto L21
    L16:
        T r111 = this.singleItem;
        this.singleItem = null;
        this.otherState = 2;
        r5.onNext(r111);
        r10 = r10 + 1;
        goto L5
    L12:
        this.singleItem = null;
        this.queue = null;
        r5.onError(this.error.terminate());
        return;
    L8:
        this.singleItem = null;
        this.queue = null;
        return;
    L35:
        if (r10 == r15) goto L37;
    L57:
        this.emitted = r10;
        this.consumed = r11;
        r14 = addAndGet(-r14);
        if (r14 == 0) goto L59;
        r13 = 1;
        goto L3
    L59:
        return;
    L37:
        if (this.cancelled == true) goto L38;
        if (this.error.get() != null) goto L42;
        boolean r20 = this.mainDone;
        rt.g r21 = this.queue;
        if (r21 != null) goto L47;
    L50:
        boolean r112 = true;
    L51:
        if (r20 == false) goto L57;
        if (r112 == false) goto L57;
        if (this.otherState != 2) goto L57;
        this.queue = null;
        r5.onComplete();
        return;
    L47:
        if (r21.isEmpty() == true) goto L50;
        r112 = false;
        goto L51
    L42:
        this.singleItem = null;
        this.queue = null;
        r5.onError(this.error.terminate());
        return;
    L38:
        this.singleItem = null;
        this.queue = null;
    }

    public rt.g getOrCreateQueue() {
        rt.g r5 = this.queue;
        if (r5 != null) goto L6;
        SpscArrayQueue r10 = new SpscArrayQueue(mt.e.f20168a);
        this.queue = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // zu.c
    public void onComplete() {
        this.mainDone = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.error.addThrowable(r5) == false) goto L5;
        SubscriptionHelper.cancel(this.mainSubscription);
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // zu.c
    public void onNext(T r10) {
        if (compareAndSet(0, 1) == false) goto L20;
        long r5 = this.emitted;
        if (this.requested.get() == r5) goto L16;
        rt.g r11 = this.queue;
        if (r11 != null) goto L9;
    L12:
        this.emitted = r5 + 1;
        this.downstream.onNext(r10);
        int r12 = this.consumed + 1;
        if (r12 != this.limit) goto L15;
        this.consumed = 0;
        this.mainSubscription.get().request(r12);
    L18:
        if (decrementAndGet() != 0) goto L23;
        return;
    L23:
        drainLoop();
        return;
    L15:
        this.consumed = r12;
        goto L18
    L9:
        if (r11.isEmpty() == true) goto L12;
        r11.offer(r10);
        goto L18
    L16:
        getOrCreateQueue().offer(r10);
        goto L18
    L20:
        getOrCreateQueue().offer(r10);
        if (getAndIncrement() == 0) goto L23;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.setOnce(this.mainSubscription, r5, this.prefetch);
    }

    public void otherError(Throwable r5) {
        if (this.error.addThrowable(r5) == false) goto L5;
        SubscriptionHelper.cancel(this.mainSubscription);
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    public void otherSuccess(T r10) {
        if (compareAndSet(0, 1) == false) goto L10;
        long r5 = this.emitted;
        if (this.requested.get() == r5) goto L7;
        this.emitted = r5 + 1;
        this.downstream.onNext(r10);
        this.otherState = 2;
    L13:
        drainLoop();
        return;
    L7:
        this.singleItem = r10;
        this.otherState = 1;
        if (decrementAndGet() != 0) goto L13;
        return;
    L10:
        this.singleItem = r10;
        this.otherState = 1;
        if (getAndIncrement() == 0) goto L13;
    }

    @Override // zu.d
    public void request(long r5) {
        v0.r(this.requested, r5);
        drain();
    }
}
