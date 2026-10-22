package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class r3 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.s f17943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.s f17944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.d f17945c;
    public final int d;

    public r3(mt.s r5, mt.s r10, pt.d r11, int r12) {
        this.f17943a = r5;
        this.f17944b = r10;
        this.f17945c = r11;
        this.d = r12;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        mt.s r5 = this.f17944b;
        pt.d r11 = this.f17945c;
        ObservableSequenceEqual$EqualCoordinator r12 = new ObservableSequenceEqual$EqualCoordinator(r10, this.d, this.f17943a, r5, r11);
        r10.onSubscribe(r12);
        r12.subscribe();
    }
}
