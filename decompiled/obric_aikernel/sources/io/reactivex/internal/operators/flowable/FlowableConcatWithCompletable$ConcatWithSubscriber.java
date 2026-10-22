package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableConcatWithCompletable$ConcatWithSubscriber<T> extends AtomicReference<io.reactivex.disposables.b> implements xb.g<T>, xb.b, tc.d {
    private static final long serialVersionUID = -7346385463600070225L;
    final tc.c<? super T> downstream;
    boolean inCompletable;
    xb.c other;
    tc.d upstream;

    FlowableConcatWithCompletable$ConcatWithSubscriber(tc.c<? super T> r10, xb.c r11) {
        this.downstream = r10;
        this.other = r11;
    }

    @Override // tc.d
    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose(this);
    }

    @Override // tc.c
    public void onComplete() {
        if (this.inCompletable == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.inCompletable = true;
        this.upstream = SubscriptionHelper.CANCELLED;
        xb.c r10 = this.other;
        this.other = null;
        r10.a(this);
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.b
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        this.upstream.request(r10);
    }
}
