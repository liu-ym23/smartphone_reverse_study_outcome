package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class m2 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.c0 f17866b;

    public m2(mt.n r5, mt.c0 r10) {
        super(r5);
        this.f17866b = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        ObservableMergeWithSingle$MergeWithObserver r10 = new ObservableMergeWithSingle$MergeWithObserver(r5);
        r5.onSubscribe(r10);
        this.f17702a.subscribe(r10);
        mt.b0 r11 = r10.otherObserver;
        ((mt.a0) this.f17866b).b(r11);
    }
}
