package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class f1 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.o f17778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17779c;
    public final int d;
    public final int e;

    public f1(mt.s r5, pt.o r10, boolean r11, int r12, int r13) {
        super(r5);
        this.f17778b = r10;
        this.f17779c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        pt.o r5 = this.f17778b;
        mt.s r11 = this.f17702a;
        if (com.lynx.tasm.base.h.i(r10, r5, r11) == false) goto L5;
        return;
    L5:
        int r12 = this.d;
        int r13 = this.e;
        r11.subscribe(new ObservableFlatMap$MergeObserver(r10, this.f17778b, this.f17779c, r12, r13));
    }
}
