package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableConcatArray$ConcatArraySubscriber<T> extends SubscriptionArbiter implements mt.g {
    private static final long serialVersionUID = -8158322871608889516L;
    final boolean delayError;
    final zu.c downstream;
    List<Throwable> errors;
    int index;
    long produced;
    final zu.b[] sources;
    final AtomicInteger wip;

    public FlowableConcatArray$ConcatArraySubscriber(zu.b[] r5, boolean r10, zu.c r11) {
        super(false);
        this.downstream = r11;
        this.sources = r5;
        this.delayError = r10;
        this.wip = new AtomicInteger();
    }

    @Override // zu.c
    public void onComplete() {
        if (this.wip.getAndIncrement() != 0) goto L30;
        zu.b[] r5 = this.sources;
        int r10 = r5.length;
        int r11 = this.index;
    L6:
        if (r11 == r10) goto L7;
        zu.b r12 = r5[r11];
        if (r12 == null) goto L17;
        long r13 = this.produced;
        if (r13 == 0) goto L28;
        this.produced = 0;
        produced(r13);
    L28:
        r12.subscribe(this);
        r11 = r11 + 1;
        this.index = r11;
        if (this.wip.decrementAndGet() != 0) goto L6;
        return;
    L17:
        NullPointerException r14 = new NullPointerException("A Publisher entry is null");
        if (this.delayError == false) goto L23;
        List r15 = this.errors;
        if (r15 != null) goto L22;
        r15 = new ArrayList((r10 - r11) + 1);
        this.errors = r15;
    L22:
        r15.add(r14);
        r11 = r11 + 1;
        goto L6
    L23:
        this.downstream.onError(r14);
        return;
    L7:
        List<Throwable> r16 = this.errors;
        if (r16 != null) goto L10;
        this.downstream.onComplete();
        return;
    L10:
        if (r16.size() != 1) goto L12;
        this.downstream.onError(r16.get(0));
        return;
    L12:
        this.downstream.onError(new CompositeException(r16));
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.delayError == false) goto L8;
        List r10 = this.errors;
        if (r10 != null) goto L7;
        r10 = new ArrayList((this.sources.length - this.index) + 1);
        this.errors = r10;
    L7:
        r10.add(r5);
        onComplete();
        return;
    L8:
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.produced++;
        this.downstream.onNext(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        setSubscription(r5);
    }
}
