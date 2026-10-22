package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableSequenceEqual$EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements k {
    private static final long serialVersionUID = -6178010334400373240L;
    final zb.d<? super T, ? super T> comparer;
    final AtomicThrowable error;
    final FlowableSequenceEqual$EqualSubscriber<T> first;
    final FlowableSequenceEqual$EqualSubscriber<T> second;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    T f9504v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    T f9505v2;
    final AtomicInteger wip;

    FlowableSequenceEqual$EqualCoordinator(tc.c<? super Boolean> r10, int r11, zb.d<? super T, ? super T> r12) {
        super(r10);
        this.comparer = r12;
        this.wip = new AtomicInteger();
        this.first = new FlowableSequenceEqual$EqualSubscriber(this, r11);
        this.second = new FlowableSequenceEqual$EqualSubscriber(this, r11);
        this.error = new AtomicThrowable();
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        super.cancel();
        this.first.cancel();
        this.second.cancel();
        if (this.wip.getAndIncrement() != 0) goto L6;
        this.first.clear();
        this.second.clear();
        return;
    }

    void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    @Override // io.reactivex.internal.operators.flowable.k
    public void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        int r10 = 1;
    L6:
        bc.f<T> r11 = this.first.queue;
        bc.f<T> r12 = this.second.queue;
        if (r11 == null) goto L60;
        if (r12 == null) goto L60;
    L10:
        if (isCancelled() == true) goto L11;
        if (this.error.get() != null) goto L15;
        boolean r13 = this.first.done;
        T r14 = this.f9504v1;
        if (r14 == null) goto L70;
    L24:
        boolean r15 = false;
        if (r14 != null) goto L27;
        boolean r16 = true;
    L28:
        boolean r17 = this.second.done;
        T r18 = this.f9505v2;
        if (r18 == null) goto L74;
    L35:
        if (r18 != null) goto L37;
        r15 = true;
    L37:
        if (r13 == false) goto L43;
        if (r17 == false) goto L43;
        if (r16 == false) goto L43;
        if (r15 == false) goto L43;
        complete(Boolean.TRUE);
        return;
    L43:
        if (r13 == false) goto L48;
        if (r17 == false) goto L48;
        if (r16 == r15) goto L48;
        cancelAndClear();
        complete(Boolean.FALSE);
        return;
    L48:
        if (r16 == true) goto L67;
        if (r15 == true) goto L67;
        if (this.comparer.a(r14, r18) == false) goto L53;
        this.f9504v1 = null;
        this.f9505v2 = null;
        this.first.request();
        this.second.request();
        goto L10
    L53:
        cancelAndClear();
        complete(Boolean.FALSE);
        return;
    L56:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancelAndClear();
        this.error.addThrowable(th);
        this.downstream.onError(this.error.terminate());
        return;
    L67:
        r10 = this.wip.addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L74:
        r18 = r12.poll();     // Catch: Throwable -> L32
        this.f9505v2 = r18;
    L32:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancelAndClear();
        this.error.addThrowable(th);
        this.downstream.onError(this.error.terminate());
        return;
    L27:
        r16 = false;
        goto L28
    L70:
        r14 = r11.poll();     // Catch: Throwable -> L21
        this.f9504v1 = r14;
    L21:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancelAndClear();
        this.error.addThrowable(th);
        this.downstream.onError(this.error.terminate());
        return;
    L15:
        cancelAndClear();
        this.downstream.onError(this.error.terminate());
        return;
    L11:
        this.first.clear();
        this.second.clear();
        return;
    L60:
        if (isCancelled() == true) goto L61;
        if (this.error.get() == null) goto L67;
        cancelAndClear();
        this.downstream.onError(this.error.terminate());
        return;
    L61:
        this.first.clear();
        this.second.clear();
    }

    @Override // io.reactivex.internal.operators.flowable.k
    public void innerError(Throwable r10) {
        if (this.error.addThrowable(r10) == false) goto L5;
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    void subscribe(tc.b<? extends T> r10, tc.b<? extends T> r11) {
        r10.subscribe(this.first);
        r11.subscribe(this.second);
    }
}
