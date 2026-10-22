package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableDebounceTimed$DebounceTimedSubscriber<T> extends AtomicLong implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -9102637559663639004L;
    boolean done;
    final tc.c<? super T> downstream;
    volatile long index;
    final long timeout;
    io.reactivex.disposables.b timer;
    final TimeUnit unit;
    tc.d upstream;
    final xb.p.c worker;

    FlowableDebounceTimed$DebounceTimedSubscriber(tc.c<? super T> r10, long r11, TimeUnit r12, xb.p.c r13) {
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.worker = r13;
    }

    @Override // tc.d
    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    void emit(long r10, T r11, FlowableDebounceTimed$DebounceEmitter<T> r12) {
        if (r10 == this.index) goto L5;
        return;
    L5:
        if (get() == 0) goto L7;
        this.downstream.onNext(r11);
        io.reactivex.internal.util.b.e(this, 1);
        r12.dispose();
        return;
    L7:
        cancel();
        this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        io.reactivex.disposables.b r10 = this.timer;
        if (r10 == null) goto L8;
        r10.dispose();
    L8:
        FlowableDebounceTimed$DebounceEmitter r11 = (FlowableDebounceTimed$DebounceEmitter) r10;
        if (r11 == null) goto L11;
        r11.emit();
    L11:
        this.downstream.onComplete();
        this.worker.dispose();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.done = true;
        io.reactivex.disposables.b r11 = this.timer;
        if (r11 == null) goto L9;
        r11.dispose();
    L9:
        this.downstream.onError(r10);
        this.worker.dispose();
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        long r11 = this.index + 1;
        this.index = r11;
        io.reactivex.disposables.b r12 = this.timer;
        if (r12 == null) goto L8;
        r12.dispose();
    L8:
        FlowableDebounceTimed$DebounceEmitter r13 = new FlowableDebounceTimed$DebounceEmitter(r10, r11, this);
        this.timer = r13;
        r13.setResource(this.worker.c(r13, this.timeout, this.unit));
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this, r10);
        return;
    }
}
