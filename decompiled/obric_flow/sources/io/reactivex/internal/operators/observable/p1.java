package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class p1 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f17905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableGroupBy$State f17906b;

    public p1(Object r5, ObservableGroupBy$State r10) {
        this.f17905a = r5;
        this.f17906b = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        this.f17906b.subscribe(r5);
    }
}
