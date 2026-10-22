package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class l2 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.k f17853b;

    public l2(mt.n r5, mt.k r10) {
        super(r5);
        this.f17853b = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        ObservableMergeWithMaybe$MergeWithObserver r10 = new ObservableMergeWithMaybe$MergeWithObserver(r5);
        r5.onSubscribe(r10);
        this.f17702a.subscribe(r10);
        mt.j r11 = r10.otherObserver;
        ((mt.h) this.f17853b).b(r11);
    }
}
