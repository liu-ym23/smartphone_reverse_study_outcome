package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableDebounce$DebounceSubscriber<T, U> extends AtomicLong implements mt.g, zu.d {
    private static final long serialVersionUID = 6725975399620862591L;
    final pt.o debounceSelector;
    final AtomicReference<Disposable> debouncer;
    boolean done;
    final zu.c downstream;
    volatile long index;
    zu.d upstream;

    public FlowableDebounce$DebounceSubscriber(zu.c r5, pt.o r10) {
        this.debouncer = new AtomicReference();
        this.downstream = r5;
        this.debounceSelector = r10;
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose(this.debouncer);
    }

    public void emit(long r5, T r10) {
        if (r5 == this.index) goto L5;
        return;
    L5:
        if (get() == 0) goto L7;
        this.downstream.onNext(r10);
        v0.y(this, 1);
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
        Disposable r5 = this.debouncer.get();
        if (DisposableHelper.isDisposed(r5) == true) goto L9;
        ((g) r5).a();
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onComplete();
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        long r5 = this.index + 1;
        this.index = r5;
        Disposable r11 = this.debouncer.get();
        if (r11 == null) goto L19;
        r11.dispose();
    L19:
        Object r12 = this.debounceSelector.apply(r10);     // Catch: Throwable -> L16
        io.reactivex.internal.functions.e.d(r12, "The publisher supplied is null");     // Catch: Throwable -> L16
        zu.b r13 = (zu.b) r12;     // Catch: Throwable -> L16
        g r14 = new g(this, r5, r10);
        AtomicReference<Disposable> r15 = this.debouncer;
    L11:
        if (r15.compareAndSet(r11, r14) == true) goto L12;
        if (r15.get() == r11) goto L11;
        return;
    L12:
        r13.subscribe(r14);
        return;
    L16:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancel();
        this.downstream.onError(th);
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
