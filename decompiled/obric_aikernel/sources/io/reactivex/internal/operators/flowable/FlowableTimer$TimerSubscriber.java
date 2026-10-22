package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableTimer$TimerSubscriber extends AtomicReference<io.reactivex.disposables.b> implements tc.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    final tc.c<? super Long> downstream;
    volatile boolean requested;

    FlowableTimer$TimerSubscriber(tc.c<? super Long> r10) {
        this.downstream = r10;
    }

    @Override // tc.d
    public void cancel() {
        DisposableHelper.dispose(this);
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        this.requested = true;
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return;
    L5:
        if (this.requested == false) goto L7;
        this.downstream.onNext(0L);
        lazySet(EmptyDisposable.INSTANCE);
        this.downstream.onComplete();
        return;
    L7:
        lazySet(EmptyDisposable.INSTANCE);
        this.downstream.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
    }

    public void setResource(io.reactivex.disposables.b r10) {
        DisposableHelper.trySet(this, r10);
    }
}
