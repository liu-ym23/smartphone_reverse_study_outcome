package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.p f17836c;

    public /* synthetic */ k(mt.n r5, pt.p r10, int r11) {
        this.f17835b = r11;
        super(r5);
        this.f17836c = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f17835b) {
            case 0: goto L14;
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        j r10 = new j(r5, this.f17836c, 4);
        this.f17702a.subscribe(r10);
        return;
    L6:
        j r11 = new j(r5, this.f17836c, 3);
        this.f17702a.subscribe(r11);
        return;
    L8:
        j r12 = new j(r5, this.f17836c, 2);
        this.f17702a.subscribe(r12);
        return;
    L10:
        w0 r13 = new w0(r5, this.f17836c, 1);
        this.f17702a.subscribe(r13);
        return;
    L12:
        j r14 = new j(r5, this.f17836c, 1);
        this.f17702a.subscribe(r14);
        return;
    L14:
        j r15 = new j(r5, this.f17836c, 0);
        this.f17702a.subscribe(r15);
    }
}
