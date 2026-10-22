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
final class FlowableIntervalRange$IntervalRangeSubscriber extends AtomicLong implements zu.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    long count;
    final zu.c downstream;
    final long end;
    final AtomicReference<Disposable> resource;

    public FlowableIntervalRange$IntervalRangeSubscriber(zu.c r5, long r10, long r11) {
        this.resource = new AtomicReference();
        this.downstream = r5;
        this.count = r10;
        this.end = r11;
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
        Disposable r5 = this.resource.get();
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (r5 == r10) goto L18;
        long r11 = get();
        if (r11 == 0) goto L16;
        long r12 = this.count;
        this.downstream.onNext(Long.valueOf(r12));
        if (r12 == this.end) goto L9;
        this.count = r12 + 1;
        if (r11 == Long.MAX_VALUE) goto L19;
        decrementAndGet();
        return;
    L19:
        return;
    L9:
        if (this.resource.get() == r10) goto L11;
        this.downstream.onComplete();
    L11:
        DisposableHelper.dispose(this.resource);
        return;
    L16:
        this.downstream.onError(new MissingBackpressureException(j0.o(new StringBuilder("Can't deliver value "), this.count, " due to lack of requests")));
        DisposableHelper.dispose(this.resource);
        return;
    }

    public void setResource(Disposable r5) {
        DisposableHelper.setOnce(this.resource, r5);
    }
}
