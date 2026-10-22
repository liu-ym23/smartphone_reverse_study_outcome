package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.a0;
import mt.b0;
import mt.c0;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableConcatWithSingle$ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements b0 {
    private static final long serialVersionUID = -7346385463600070225L;
    c0 other;
    final AtomicReference<Disposable> otherDisposable;

    public FlowableConcatWithSingle$ConcatWithSubscriber(zu.c r5, c0 r10) {
        super(r5);
        this.other = r10;
        this.otherDisposable = new AtomicReference();
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.d
    public void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.otherDisposable);
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.c
    public void onComplete() {
        this.upstream = SubscriptionHelper.CANCELLED;
        c0 r5 = this.other;
        this.other = null;
        ((a0) r5).b(this);
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.c
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.c
    public void onNext(T r5) {
        this.produced++;
        this.downstream.onNext(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.otherDisposable, r5);
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        complete(r5);
    }
}
