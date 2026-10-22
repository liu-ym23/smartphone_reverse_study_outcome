package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableOnErrorReturn$OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
    private static final long serialVersionUID = -3740826063558713822L;
    final zb.h<? super Throwable, ? extends T> valueSupplier;

    FlowableOnErrorReturn$OnErrorReturnSubscriber(tc.c<? super T> r10, zb.h<? super Throwable, ? extends T> r11) {
        super(r10);
        this.valueSupplier = r11;
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, tc.c
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, tc.c
    public void onError(Throwable r10) {
        complete(io.reactivex.internal.functions.a.d(this.valueSupplier.apply(r10), "The valueSupplier returned a null value"));
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(new CompositeException(new Throwable[]{r10, th}));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, tc.c
    public void onNext(T r10) {
        this.produced++;
        this.downstream.onNext((Object) r10);
    }
}
