package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class d4 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.s f17760b;

    public d4(mt.n r5, mt.s r10) {
        super(r5);
        this.f17760b = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        ObservableTakeUntil$TakeUntilMainObserver r10 = new ObservableTakeUntil$TakeUntilMainObserver(r5);
        r5.onSubscribe(r10);
        this.f17760b.subscribe(r10.otherObserver);
        this.f17702a.subscribe(r10);
    }
}
