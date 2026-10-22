package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class k2 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.c f17839b;

    public k2(mt.n r5, mt.c r10) {
        super(r5);
        this.f17839b = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        ObservableMergeWithCompletable$MergeWithObserver r10 = new ObservableMergeWithCompletable$MergeWithObserver(r5);
        r5.onSubscribe(r10);
        this.f17702a.subscribe(r10);
        ObservableMergeWithCompletable$MergeWithObserver.OtherObserver r11 = r10.otherObserver;
        ((mt.a) this.f17839b).b(r11);
    }
}
