package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableInterval$IntervalSubscriber extends AtomicLong implements tc.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    long count;
    final tc.c<? super Long> downstream;
    final AtomicReference<io.reactivex.disposables.b> resource;

    FlowableInterval$IntervalSubscriber(tc.c<? super Long> r10) {
        this.resource = new AtomicReference();
        this.downstream = r10;
    }

    @Override // tc.d
    public void cancel() {
        DisposableHelper.dispose(this.resource);
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this, r10);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.resource.get() != DisposableHelper.DISPOSED) goto L5;
        return;
    L5:
        if (get() == 0) goto L7;
        tc.c<? super Long> r10 = this.downstream;
        long r11 = this.count;
        this.count = r11 + 1;
        r10.onNext(Long.valueOf(r11));
        io.reactivex.internal.util.b.e(this, 1);
        return;
    L7:
        this.downstream.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
        DisposableHelper.dispose(this.resource);
    }

    public void setResource(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this.resource, r10);
    }
}
