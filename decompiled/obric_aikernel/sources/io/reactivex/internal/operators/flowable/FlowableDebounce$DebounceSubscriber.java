package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableDebounce$DebounceSubscriber<T, U> extends AtomicLong implements xb.g<T>, tc.d {
    private static final long serialVersionUID = 6725975399620862591L;
    final zb.h<? super T, ? extends tc.b<U>> debounceSelector;
    final AtomicReference<io.reactivex.disposables.b> debouncer;
    boolean done;
    final tc.c<? super T> downstream;
    volatile long index;
    tc.d upstream;

    static final class a<T, U> extends io.reactivex.subscribers.a<U> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final FlowableDebounce$DebounceSubscriber<T, U> f9495g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final long f9496h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final T f9497i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f9498j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicBoolean f9499k;

        a(FlowableDebounce$DebounceSubscriber<T, U> r10, long r11, T r12) {
            this.f9499k = new AtomicBoolean();
            this.f9495g = r10;
            this.f9496h = r11;
            this.f9497i = r12;
        }

        void c() {
            if (this.f9499k.compareAndSet(false, true) == false) goto L6;
            this.f9495g.emit(this.f9496h, this.f9497i);
            return;
        }

        @Override // tc.c
        public void onComplete() {
            if (this.f9498j == false) goto L5;
            return;
        L5:
            this.f9498j = true;
            c();
        }

        @Override // tc.c
        public void onError(Throwable r10) {
            if (this.f9498j == false) goto L6;
            dc.a.n(r10);
            return;
        L6:
            this.f9498j = true;
            this.f9495g.onError(r10);
        }

        @Override // tc.c
        public void onNext(U r10) {
            if (this.f9498j == false) goto L5;
            return;
        L5:
            this.f9498j = true;
            a();
            c();
        }
    }

    FlowableDebounce$DebounceSubscriber(tc.c<? super T> r10, zb.h<? super T, ? extends tc.b<U>> r11) {
        this.debouncer = new AtomicReference();
        this.downstream = r10;
        this.debounceSelector = r11;
    }

    @Override // tc.d
    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose(this.debouncer);
    }

    void emit(long r10, T r11) {
        if (r10 == this.index) goto L5;
        return;
    L5:
        if (get() == 0) goto L7;
        this.downstream.onNext(r11);
        io.reactivex.internal.util.b.e(this, 1);
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
        io.reactivex.disposables.b r10 = this.debouncer.get();
        if (DisposableHelper.isDisposed(r10) == true) goto L9;
        ((a) r10).c();
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onComplete();
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        long r11 = this.index + 1;
        this.index = r11;
        io.reactivex.disposables.b r12 = this.debouncer.get();
        if (r12 == null) goto L16;
        r12.dispose();
    L16:
        tc.b r13 = (tc.b) io.reactivex.internal.functions.a.d(this.debounceSelector.apply(r10), "The publisher supplied is null");     // Catch: Throwable -> L13
        a r14 = new a(this, r11, r10);
        if (this.debouncer.compareAndSet(r12, r14) == false) goto L18;
        r13.subscribe(r14);
        return;
    L18:
        return;
    L13:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancel();
        this.downstream.onError(th);
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
