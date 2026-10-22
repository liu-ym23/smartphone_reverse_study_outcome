package io.reactivex.internal.operators.flowable;

import ai.j0;
import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableInterval$IntervalSubscriber extends AtomicLong implements zu.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    long count;
    final zu.c downstream;
    final AtomicReference<Disposable> resource;

    public FlowableInterval$IntervalSubscriber(zu.c r5) {
        this.resource = new AtomicReference();
        this.downstream = r5;
    }

    @Override // zu.d
    public void cancel() {
        DisposableHelper.dispose(this.resource);
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this, r5);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.resource.get() != DisposableHelper.DISPOSED) goto L5;
        return;
    L5:
        if (get() == 0) goto L7;
        zu.c r5 = this.downstream;
        long r10 = this.count;
        this.count = r10 + 1;
        r5.onNext(Long.valueOf(r10));
        v0.y(this, 1);
        return;
    L7:
        this.downstream.onError(new MissingBackpressureException(j0.o(new StringBuilder("Can't deliver value "), this.count, " due to lack of requests")));
        DisposableHelper.dispose(this.resource);
    }

    public void setResource(Disposable r5) {
        DisposableHelper.setOnce(this.resource, r5);
    }
}
