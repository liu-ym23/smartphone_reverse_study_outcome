package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableIntervalRange$IntervalRangeSubscriber extends AtomicLong implements tc.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    long count;
    final tc.c<? super Long> downstream;
    final long end;
    final AtomicReference<io.reactivex.disposables.b> resource;

    FlowableIntervalRange$IntervalRangeSubscriber(tc.c<? super Long> r10, long r11, long r12) {
        this.resource = new AtomicReference();
        this.downstream = r10;
        this.count = r11;
        this.end = r12;
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
        io.reactivex.disposables.b r10 = this.resource.get();
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (r10 == r11) goto L18;
        long r12 = get();
        if (r12 == 0) goto L16;
        long r13 = this.count;
        this.downstream.onNext(Long.valueOf(r13));
        if (r13 == this.end) goto L9;
        this.count = r13 + 1;
        if (r12 == Long.MAX_VALUE) goto L19;
        decrementAndGet();
        return;
    L19:
        return;
    L9:
        if (this.resource.get() == r11) goto L11;
        this.downstream.onComplete();
    L11:
        DisposableHelper.dispose(this.resource);
        return;
    L16:
        this.downstream.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
        DisposableHelper.dispose(this.resource);
        return;
    }

    public void setResource(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this.resource, r10);
    }
}
