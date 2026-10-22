package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class h1 extends mt.a implements rt.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.o f17800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17801c;

    public h1(mt.n r5, pt.o r10, boolean r11) {
        this.f17799a = r5;
        this.f17800b = r10;
        this.f17801c = r11;
    }

    @Override // rt.b
    public final mt.n a() {
        return new g1(this.f17799a, this.f17800b, this.f17801c, 0);
    }

    @Override // mt.a
    public final void c(mt.b r5) {
        ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver r10 = new ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver(r5, this.f17800b, this.f17801c);
        this.f17799a.subscribe(r10);
    }
}
