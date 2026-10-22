package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableConcatWithMaybe$ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements mt.j {
    private static final long serialVersionUID = -7346385463600070225L;
    boolean inMaybe;
    mt.k other;
    final AtomicReference<Disposable> otherDisposable;

    public FlowableConcatWithMaybe$ConcatWithSubscriber(zu.c r5, mt.k r10) {
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
        if (this.inMaybe == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.inMaybe = true;
        this.upstream = SubscriptionHelper.CANCELLED;
        mt.k r5 = this.other;
        this.other = null;
        ((mt.h) r5).b(this);
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

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.otherDisposable, r5);
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        complete(r5);
    }
}
