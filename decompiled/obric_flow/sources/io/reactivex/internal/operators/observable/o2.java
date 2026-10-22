package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class o2 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17895c;
    public final boolean d;
    public final Object e;

    public o2(mt.n r5, mt.z r10, boolean r11, int r12) {
        this.f17894b = 0;
        super(r5);
        this.e = r10;
        this.d = r11;
        this.f17895c = r12;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f17894b) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        mt.s r10 = this.f17702a;
        pt.o r11 = (pt.o) this.e;
        if (com.lynx.tasm.base.h.i(r5, r11, r10) == true) goto L14;
        r10.subscribe(new ObservableSwitchMap$SwitchMapObserver(r5, r11, this.f17895c, this.d));
        return;
    L14:
        return;
    L9:
        mt.z r12 = (mt.z) this.e;
        boolean r13 = r12 instanceof io.reactivex.internal.schedulers.s;
        mt.s r14 = this.f17702a;
        if (r13 == false) goto L12;
        r14.subscribe(r5);
        return;
    L12:
        r14.subscribe(new ObservableObserveOn$ObserveOnObserver(r5, r12.a(), this.d, this.f17895c));
    }

    public o2(mt.s r5, pt.o r10, int r11, boolean r12) {
        this.f17894b = 1;
        super(r5);
        this.e = r10;
        this.f17895c = r11;
        this.d = r12;
    }
}
