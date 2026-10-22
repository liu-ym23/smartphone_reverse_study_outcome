package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableMaterialize$MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, mt.l> {
    private static final long serialVersionUID = -3740826063558713822L;

    public FlowableMaterialize$MaterializeSubscriber(zu.c r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.c
    public void onComplete() {
        complete(mt.l.f20169b);
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
    public /* bridge */ /* synthetic */ void onDrop(mt.l r5) {
        onDrop2(r5);
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.c
    public void onError(Throwable r5) {
        complete(mt.l.a(r5));
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, zu.c
    public void onNext(T r5) {
        this.produced++;
        zu.c r10 = this.downstream;
        io.reactivex.internal.functions.e.d(r5, "value is null");
        r10.onNext(new mt.l(r5));
    }

    /* JADX INFO: renamed from: onDrop, reason: avoid collision after fix types in other method */
    public void onDrop2(mt.l r5) {
        if (NotificationLite.isError(r5.f20170a) == false) goto L6;
        wn.f.k(r5.b());
        return;
    }
}
