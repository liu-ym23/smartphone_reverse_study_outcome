package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class t3 extends mt.a0 implements rt.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.s f17975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.s f17976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.d f17977c;
    public final int d;

    public t3(mt.s r5, mt.s r10, pt.d r11, int r12) {
        this.f17975a = r5;
        this.f17976b = r10;
        this.f17977c = r11;
        this.d = r12;
    }

    @Override // rt.b
    public final mt.n a() {
        pt.d r5 = this.f17977c;
        int r10 = this.d;
        return new r3(this.f17975a, this.f17976b, r5, r10);
    }

    @Override // mt.a0
    public final void c(mt.b0 r10) {
        mt.s r5 = this.f17976b;
        pt.d r11 = this.f17977c;
        ObservableSequenceEqualSingle$EqualCoordinator r12 = new ObservableSequenceEqualSingle$EqualCoordinator(r10, this.d, this.f17975a, r5, r11);
        r10.onSubscribe(r12);
        r12.subscribe();
    }
}
