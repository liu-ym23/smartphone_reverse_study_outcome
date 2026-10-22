package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableGenerate$GeneratorSubscription<T, S> extends AtomicLong implements xb.d<T>, tc.d {
    private static final long serialVersionUID = 7565982551505011832L;
    volatile boolean cancelled;
    final zb.g<? super S> disposeState;
    final tc.c<? super T> downstream;
    final zb.c<S, ? super xb.d<T>, S> generator;
    boolean hasNext;
    S state;
    boolean terminate;

    FlowableGenerate$GeneratorSubscription(tc.c<? super T> r10, zb.c<S, ? super xb.d<T>, S> r11, zb.g<? super S> r12, S r13) {
        this.downstream = r10;
        this.generator = r11;
        this.disposeState = r12;
        this.state = r13;
    }

    private void dispose(S r10) {
        this.disposeState.accept(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
    }

    @Override // tc.d
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        if (io.reactivex.internal.util.b.a(this, 1) != 0) goto L9;
        S r10 = this.state;
        this.state = null;
        dispose(r10);
        return;
    L9:
        return;
    }

    @Override // xb.d
    public void onComplete() {
        if (this.terminate == true) goto L6;
        this.terminate = true;
        this.downstream.onComplete();
        return;
    }

    @Override // xb.d
    public void onError(Throwable r10) {
        if (this.terminate == false) goto L5;
        dc.a.n(r10);
        return;
    L5:
        if (r10 != null) goto L7;
        r10 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L7:
        this.terminate = true;
        this.downstream.onError(r10);
    }

    @Override // xb.d
    public void onNext(T r10) {
        if (this.terminate == false) goto L5;
        return;
    L5:
        if (this.hasNext == false) goto L8;
        Throwable r11 = new IllegalStateException("onNext already called in this generate turn");
    L7:
        onError(r11);
        return;
    L8:
        if (r10 != null) goto L10;
        r11 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        goto L7
    L10:
        this.hasNext = true;
        this.downstream.onNext(r10);
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L6;
        return;
    L6:
        if (io.reactivex.internal.util.b.a(this, r10) == 0) goto L8;
        return;
    L8:
        S r11 = this.state;
        zb.c<S, ? super xb.d<T>, S> r12 = this.generator;
    L9:
        long r13 = 0;
    L11:
        if (r13 != r10) goto L13;
        r10 = get();
        if (r13 != r10) goto L11;
        this.state = r11;
        r10 = addAndGet(-r13);
        if (r10 != 0) goto L9;
        return;
    L13:
        if (this.cancelled == true) goto L14;
        this.hasNext = false;
        r11 = r12.apply(r11, this);     // Catch: Throwable -> L23
        if (this.terminate == true) goto L21;
        r13 = r13 + 1;
        goto L11
    L21:
        this.cancelled = true;
    L23:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.cancelled = true;
        this.state = null;
        onError(th);
    L15:
        dispose(r11);
        return;
    L14:
        this.state = null;
        goto L15
    }
}
