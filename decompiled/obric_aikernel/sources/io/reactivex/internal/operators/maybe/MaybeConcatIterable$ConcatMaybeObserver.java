package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.k;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeConcatIterable$ConcatMaybeObserver<T> extends AtomicInteger implements j<T>, tc.d {
    private static final long serialVersionUID = 3520831347801429610L;
    final AtomicReference<Object> current;
    final SequentialDisposable disposables;
    final tc.c<? super T> downstream;
    long produced;
    final AtomicLong requested;
    final Iterator<? extends k<? extends T>> sources;

    MaybeConcatIterable$ConcatMaybeObserver(tc.c<? super T> r10, Iterator<? extends k<? extends T>> r11) {
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
        if (r13 == null) goto L31;
        boolean r14 = true;
        if (r13 == NotificationLite.COMPLETE) goto L18;
        long r15 = this.produced;
        if (r15 == this.requested.get()) goto L17;
        this.produced = r15 + 1;
        r10.lazySet(null);
        r11.onNext(r13);
    L19:
        if (r14 == false) goto L31;
        if (r12.isDisposed() == true) goto L31;
    L26:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r11.onError(th);
        return;
    L23:
        if (this.sources.hasNext() == false) goto L29;
        ((k) io.reactivex.internal.functions.a.d(this.sources.next(), "The source Iterator returned a null MaybeSource")).a(this);
        goto L31
    L29:
        r11.onComplete();
        goto L31
    L17:
        r14 = false;
        goto L19
    L18:
        r10.lazySet(null);
    L31:
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
