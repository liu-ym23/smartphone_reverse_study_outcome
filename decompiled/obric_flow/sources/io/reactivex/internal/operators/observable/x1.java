package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class x1 implements pt.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f18053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f18054c;

    public /* synthetic */ x1(int r5, Object r10, Object r11) {
        this.f18052a = r5;
        this.f18053b = r10;
        this.f18054c = r11;
    }

    @Override // pt.o
    public final Object apply(Object r5) {
        switch(this.f18052a) {
            case 0: goto L9;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        pt.o r10 = (pt.o) this.f18053b;
        Object r11 = r10.apply((mt.n) r5);
        io.reactivex.internal.functions.e.d(r11, "The selector returned a null ObservableSource");
        return mt.n.wrap((mt.s) r11).observeOn((mt.z) this.f18054c);
    L6:
        Object r12 = ((pt.o) this.f18054c).apply(r5);
        io.reactivex.internal.functions.e.d(r12, "The mapper returned a null ObservableSource");
        int r13 = 0;
        return new v2((mt.s) r12, new x1(r13, (pt.c) this.f18053b, r5), 4);
    L9:
        return ((pt.c) this.f18053b).apply(this.f18054c, r5);
    }
}
