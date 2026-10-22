package io.reactivex.internal.operators.maybe;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mt.h;
import mt.j;
import mt.k;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeConcatArray$ConcatMaybeObserver<T> extends AtomicInteger implements j, zu.d {
    private static final long serialVersionUID = 3520831347801429610L;
    final AtomicReference<Object> current;
    final SequentialDisposable disposables;
    final zu.c downstream;
    int index;
    long produced;
    final AtomicLong requested;
    final k[] sources;

    public MaybeConcatArray$ConcatMaybeObserver(zu.c r5, k[] r10) {
        this.downstream = r5;
        this.sources = r10;
        this.requested = new AtomicLong();
        this.disposables = new SequentialDisposable();
        this.current = new AtomicReference(NotificationLite.COMPLETE);
    }

    @Override // zu.d
    public void cancel() {
        this.disposables.dispose();
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicReference<Object> r5 = this.current;
        zu.c r10 = this.downstream;
        SequentialDisposable r11 = this.disposables;
    L7:
        if (r11.isDisposed() == true) goto L8;
        Object r12 = r5.get();
        if (r12 == null) goto L26;
        if (r12 == NotificationLite.COMPLETE) goto L17;
        long r13 = this.produced;
        if (r13 == this.requested.get()) goto L26;
        this.produced = r13 + 1;
        r5.lazySet(null);
        r10.onNext(r12);
    L19:
        if (r11.isDisposed() == true) goto L26;
        int r14 = this.index;
        k[] r15 = this.sources;
        if (r14 == r15.length) goto L22;
        this.index = r14 + 1;
        ((h) r15[r14]).b(this);
        goto L26
    L22:
        r10.onComplete();
        return;
    L17:
        r5.lazySet(null);
    L26:
        if (decrementAndGet() != 0) goto L7;
        return;
    L8:
        r5.lazySet(null);
    }

    @Override // mt.j
    public void onComplete() {
        this.current.lazySet(NotificationLite.COMPLETE);
        drain();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        this.disposables.replace(r5);
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.current.lazySet(r5);
        drain();
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        drain();
        return;
    }
}
