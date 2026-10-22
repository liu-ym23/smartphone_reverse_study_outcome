package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableOnErrorReturn$OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
    private static final long serialVersionUID = -3740826063558713822L;
    final pt.o valueSupplier;

    public FlowableOnErrorReturn$OnErrorReturnSubscriber(zu.c r5, pt.o r10) {
        super(r5);
        this.valueSupplier = r10;
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.c
    public void onError(Throwable r5) {
        Object r10 = this.valueSupplier.apply(r5);     // Catch: Throwable -> L5
        io.reactivex.internal.functions.e.d(r10, "The valueSupplier returned a null value");     // Catch: Throwable -> L5
        complete(r10);
        return;
    L5:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.c
    public void onNext(T r5) {
        this.produced++;
        this.downstream.onNext(r5);
    }
}
