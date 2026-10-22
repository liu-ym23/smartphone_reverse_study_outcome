package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableWithLatestFromMany$WithLatestFromSubscriber<T, R> extends AtomicInteger implements rt.a, zu.d {
    private static final long serialVersionUID = 1577321883966341961L;
    final pt.o combiner;
    volatile boolean done;
    final zu.c downstream;
    final AtomicThrowable error;
    final AtomicLong requested;
    final FlowableWithLatestFromMany$WithLatestInnerSubscriber[] subscribers;
    final AtomicReference<zu.d> upstream;
    final AtomicReferenceArray<Object> values;

    public FlowableWithLatestFromMany$WithLatestFromSubscriber(zu.c r5, pt.o r10, int r11) {
        this.downstream = r5;
        this.combiner = r10;
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] r12 = new FlowableWithLatestFromMany$WithLatestInnerSubscriber[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = new FlowableWithLatestFromMany$WithLatestInnerSubscriber(this, r13);
        r13 = r13 + 1;
        goto L3
    L5:
        this.subscribers = r12;
        this.values = new AtomicReferenceArray(r11);
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
        this.error = new AtomicThrowable();
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] r5 = this.subscribers;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].dispose();
        r11 = r11 + 1;
        goto L3
    }

    public void cancelAllBut(int r5) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] r10 = this.subscribers;
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L8;
        if (r11 == r5) goto L7;
        r10[r11].dispose();
    L7:
        r11 = r11 + 1;
        goto L4
    }

    public void innerComplete(int r5, boolean r10) {
        if (r10 == true) goto L5;
        this.done = true;
        SubscriptionHelper.cancel(this.upstream);
        cancelAllBut(r5);
        com.lynx.tasm.behavior.ui.utils.p.v(this.downstream, this, this.error);
        return;
    }

    public void innerError(int r5, Throwable r10) {
        this.done = true;
        SubscriptionHelper.cancel(this.upstream);
        cancelAllBut(r5);
        com.lynx.tasm.behavior.ui.utils.p.x(this.downstream, r10, this, this.error);
    }

    public void innerNext(int r5, Object r10) {
        this.values.set(r5, r10);
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        cancelAllBut(-1);
        com.lynx.tasm.behavior.ui.utils.p.v(this.downstream, this, this.error);
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.done = true;
        cancelAllBut(-1);
        com.lynx.tasm.behavior.ui.utils.p.x(this.downstream, r5, this, this.error);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (tryOnNext(r5) == false) goto L5;
        return;
    L5:
        if (this.done == true) goto L9;
        this.upstream.get().request(1);
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r5);
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r5);
    }

    public void subscribe(zu.b[] r5, int r10) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] r11 = this.subscribers;
        AtomicReference<zu.d> r12 = this.upstream;
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L8;
        if (r12.get() == SubscriptionHelper.CANCELLED) goto L6;
        r5[r13].subscribe(r11[r13]);
        r13 = r13 + 1;
        goto L3
    L6:
        return;
    }

    @Override // rt.a
    public boolean tryOnNext(T r10) {
        if (this.done == false) goto L5;
        return false;
    L5:
        AtomicReferenceArray<Object> r5 = this.values;
        int r11 = r5.length();
        Object[] r12 = new Object[r11 + 1];
        r12[0] = r10;
        int r13 = 0;
    L6:
        if (r13 >= r11) goto L17;
        Object r14 = r5.get(r13);
        if (r14 == null) goto L9;
        r13 = r13 + 1;
        r12[r13] = r14;
        goto L6
    L9:
        return false;
    L17:
        Object r15 = this.combiner.apply(r12);     // Catch: Throwable -> L14
        io.reactivex.internal.functions.e.d(r15, "The combiner returned a null value");     // Catch: Throwable -> L14
        com.lynx.tasm.behavior.ui.utils.p.z(this.downstream, r15, this, this.error);
        return true;
    L14:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancel();
        onError(th);
        return false;
    }
}
