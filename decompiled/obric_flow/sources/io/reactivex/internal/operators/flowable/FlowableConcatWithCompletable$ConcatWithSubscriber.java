package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableConcatWithCompletable$ConcatWithSubscriber<T> extends AtomicReference<Disposable> implements mt.g, mt.b, zu.d {
    private static final long serialVersionUID = -7346385463600070225L;
    final zu.c downstream;
    boolean inCompletable;
    mt.c other;
    zu.d upstream;

    public FlowableConcatWithCompletable$ConcatWithSubscriber(zu.c r5, mt.c r10) {
        this.downstream = r5;
        this.other = r10;
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose(this);
    }

    @Override // zu.c
    public void onComplete() {
        if (this.inCompletable == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.inCompletable = true;
        this.upstream = SubscriptionHelper.CANCELLED;
        mt.c r5 = this.other;
        this.other = null;
        ((mt.a) r5).b(this);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        this.upstream.request(r5);
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
