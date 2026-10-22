package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class q1 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.o f17920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.o f17921c;
    public final int d;
    public final boolean e;

    public q1(mt.n r5, pt.o r10, pt.o r11, int r12, boolean r13) {
        super(r5);
        this.f17920b = r10;
        this.f17921c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        int r5 = this.d;
        boolean r11 = this.e;
        ObservableGroupBy$GroupByObserver r12 = new ObservableGroupBy$GroupByObserver(r10, this.f17920b, this.f17921c, r5, r11);
        this.f17702a.subscribe(r12);
    }
}
