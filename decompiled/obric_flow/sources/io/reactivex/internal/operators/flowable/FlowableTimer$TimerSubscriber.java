package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableTimer$TimerSubscriber extends AtomicReference<Disposable> implements zu.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    final zu.c downstream;
    volatile boolean requested;

    public FlowableTimer$TimerSubscriber(zu.c r5) {
        this.downstream = r5;
    }

    @Override // zu.d
    public void cancel() {
        DisposableHelper.dispose(this);
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
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

    public void setResource(Disposable r5) {
        DisposableHelper.trySet(this, r5);
    }
}
