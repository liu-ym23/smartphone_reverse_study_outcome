package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.ErrorMode;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.o f17786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ErrorMode f17787c;
    public final int d;
    public final int e;

    public g0(mt.n r5, pt.o r10, ErrorMode r11, int r12, int r13) {
        super(r5);
        this.f17786b = r10;
        this.f17787c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        int r5 = this.e;
        ErrorMode r11 = this.f17787c;
        ObservableConcatMapEager$ConcatMapEagerMainObserver r12 = new ObservableConcatMapEager$ConcatMapEagerMainObserver(r10, this.f17786b, this.d, r5, r11);
        this.f17702a.subscribe(r12);
    }
}
