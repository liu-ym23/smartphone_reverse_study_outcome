package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableDebounceTimed$DebounceTimedSubscriber<T> extends AtomicLong implements mt.g, zu.d {
    private static final long serialVersionUID = -9102637559663639004L;
    boolean done;
    final zu.c downstream;
    volatile long index;
    final long timeout;
    Disposable timer;
    final TimeUnit unit;
    zu.d upstream;
    final mt.y worker;

    public FlowableDebounceTimed$DebounceTimedSubscriber(zu.c r5, long r10, TimeUnit r11, mt.y r12) {
        this.downstream = r5;
        this.timeout = r10;
        this.unit = r11;
        this.worker = r12;
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    public void emit(long r5, T r10, FlowableDebounceTimed$DebounceEmitter<T> r11) {
        if (r5 == this.index) goto L5;
        return;
    L5:
        if (get() == 0) goto L7;
        this.downstream.onNext(r10);
        v0.y(this, 1);
        r11.dispose();
        return;
    L7:
        cancel();
        this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        Disposable r5 = this.timer;
        if (r5 == null) goto L8;
        r5.dispose();
    L8:
        FlowableDebounceTimed$DebounceEmitter r10 = (FlowableDebounceTimed$DebounceEmitter) r5;
        if (r10 == null) goto L11;
        r10.emit();
    L11:
        this.downstream.onComplete();
        this.worker.dispose();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.done = true;
        Disposable r10 = this.timer;
        if (r10 == null) goto L9;
        r10.dispose();
    L9:
        this.downstream.onError(r5);
        this.worker.dispose();
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.done == false) goto L5;
        return;
    L5:
        long r10 = this.index + 1;
        this.index = r10;
        Disposable r11 = this.timer;
        if (r11 == null) goto L8;
        r11.dispose();
    L8:
        FlowableDebounceTimed$DebounceEmitter r12 = new FlowableDebounceTimed$DebounceEmitter(r5, r10, this);
        this.timer = r12;
        r12.setResource(this.worker.b(r12, this.timeout, this.unit));
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this, r5);
        return;
    }
}
