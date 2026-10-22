package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableConcatArray$ConcatArraySubscriber<T> extends SubscriptionArbiter implements xb.g<T> {
    private static final long serialVersionUID = -8158322871608889516L;
    final boolean delayError;
    final tc.c<? super T> downstream;
    List<Throwable> errors;
    int index;
    long produced;
    final Publisher<? extends T>[] sources;
    final AtomicInteger wip;

    FlowableConcatArray$ConcatArraySubscriber(Publisher<? extends T>[] r10, boolean r11, tc.c<? super T> r12) {
        super(false);
        this.downstream = r12;
        this.sources = r10;
        this.delayError = r11;
        this.wip = new AtomicInteger();
    }

    @Override // tc.c
    public void onComplete() {
        if (this.wip.getAndIncrement() != 0) goto L30;
        tc.b[] r10 = this.sources;
        int r11 = r10.length;
        int r12 = this.index;
    L6:
        if (r12 == r11) goto L7;
        tc.b r13 = r10[r12];
        if (r13 == null) goto L17;
        long r14 = this.produced;
        if (r14 == 0) goto L28;
        this.produced = 0;
        produced(r14);
    L28:
        r13.subscribe(this);
        r12 = r12 + 1;
        this.index = r12;
        if (this.wip.decrementAndGet() != 0) goto L6;
        return;
    L17:
        NullPointerException r15 = new NullPointerException("A Publisher entry is null");
        if (this.delayError == false) goto L23;
        List r16 = this.errors;
        if (r16 != null) goto L22;
        r16 = new ArrayList((r11 - r12) + 1);
        this.errors = r16;
    L22:
        r16.add(r15);
        r12 = r12 + 1;
        goto L6
    L23:
        this.downstream.onError(r15);
        return;
    L7:
        List<Throwable> r17 = this.errors;
        if (r17 == null) goto L13;
        int r18 = r17.size();
        tc.c<? super T> r19 = this.downstream;
        if (r18 != 1) goto L12;
        r19.onError(r17.get(0));
        return;
    L12:
        r19.onError(new CompositeException(r17));
        return;
    L13:
        this.downstream.onComplete();
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.delayError == false) goto L8;
        List r11 = this.errors;
        if (r11 != null) goto L7;
        r11 = new ArrayList((this.sources.length - this.index) + 1);
        this.errors = r11;
    L7:
        r11.add(r10);
        onComplete();
        return;
    L8:
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.produced++;
        this.downstream.onNext(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        setSubscription(r10);
    }
}
