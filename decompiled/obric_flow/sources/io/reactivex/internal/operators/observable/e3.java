package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class e3 extends st.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final st.a f17770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.n f17771b;

    public e3(st.a r5, mt.n r10) {
        this.f17770a = r5;
        this.f17771b = r10;
    }

    @Override // st.a
    public final void d(pt.g r5) {
        this.f17770a.d(r5);
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        this.f17771b.subscribe(r5);
    }
}
