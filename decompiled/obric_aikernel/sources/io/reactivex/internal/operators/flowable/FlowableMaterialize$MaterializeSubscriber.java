package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableMaterialize$MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, xb.l<T>> {
    private static final long serialVersionUID = -3740826063558713822L;

    FlowableMaterialize$MaterializeSubscriber(tc.c<? super xb.l<T>> r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, tc.c
    public void onComplete() {
        complete(xb.l.a());
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
    protected /* bridge */ /* synthetic */ void onDrop(Object r10) {
        onDrop((xb.l) r10);
    }

    protected void onDrop(xb.l<T> r10) {
        if (r10.e() == false) goto L6;
        dc.a.n(r10.d());
        return;
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, tc.c
    public void onError(Throwable r10) {
        complete(xb.l.b(r10));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, tc.c
    public void onNext(T r10) {
        this.produced++;
        this.downstream.onNext(xb.l.c(r10));
    }
}
