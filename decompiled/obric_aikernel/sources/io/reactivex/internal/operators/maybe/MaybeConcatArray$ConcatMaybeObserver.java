package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.k;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeConcatArray$ConcatMaybeObserver<T> extends AtomicInteger implements j<T>, tc.d {
    private static final long serialVersionUID = 3520831347801429610L;
    final AtomicReference<Object> current;
    final SequentialDisposable disposables;
    final tc.c<? super T> downstream;
    int index;
    long produced;
    final AtomicLong requested;
    final MaybeSource<? extends T>[] sources;

    MaybeConcatArray$ConcatMaybeObserver(tc.c<? super T> r10, MaybeSource<? extends T>[] r11) {
        this.downstream = r10;
        this.sources = r11;
        this.requested = new AtomicLong();
        this.disposables = new SequentialDisposable();
        this.current = new AtomicReference(NotificationLite.COMPLETE);
    }

    @Override // tc.d
    public void cancel() {
        this.disposables.dispose();
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicReference<Object> r10 = this.current;
        tc.c<? super T> r11 = this.downstream;
        SequentialDisposable r12 = this.disposables;
    L7:
        if (r12.isDisposed() == true) goto L8;
        Object r13 = r10.get();
        if (r13 == null) goto L28;
        boolean r14 = true;
        if (r13 == NotificationLite.COMPLETE) goto L18;
        long r15 = this.produced;
        if (r15 == this.requested.get()) goto L17;
        this.produced = r15 + 1;
        r10.lazySet(null);
        r11.onNext(r13);
    L19:
        if (r14 == false) goto L28;
        if (r12.isDisposed() == true) goto L28;
        int r16 = this.index;
        k[] r17 = this.sources;
        if (r16 == r17.length) goto L24;
        this.index = r16 + 1;
        r17[r16].a(this);
        goto L28
    L24:
        r11.onComplete();
        return;
    L17:
        r14 = false;
        goto L19
    L18:
        r10.lazySet(null);
    L28:
        if (decrementAndGet() != 0) goto L7;
        return;
    L8:
        r10.lazySet(null);
    }

    @Override // xb.j
    public void onComplete() {
        this.current.lazySet(NotificationLite.COMPLETE);
        drain();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        this.disposables.replace(r10);
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        this.current.lazySet(r10);
        drain();
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
        return;
    }
}
