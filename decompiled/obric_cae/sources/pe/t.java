package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends he.j implements ge.p<ae.f, ae.f.b, ae.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ he.o<ae.f> f10064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f10065b;

    public t(he.o r8) {
        this.f10064a = r8;
        this.f10065b = true;
        super(2);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, ae.f] */
    @Override // ge.p
    public final ae.f invoke(ae.f r8, ae.f.b r10) {
        ae.f r11 = r8;
        ae.f.b r12 = r10;
        if ((r12 instanceof r) == false) goto L14;
        he.o<ae.f> r13 = this.f10064a;
        if (r13.f8064a.q0(r12.getKey()) == null) goto L8;
        r13.f8064a = r13.f8064a.h0(r12.getKey());
        ae.f r14 = ((r) r12).K();
    L13:
        return r11.C(r14);
    L8:
        if (this.f10065b == false) goto L10;
        r14 = ((r) r12).v();
        goto L13
    L10:
        r14 = (r) r12;
        goto L13
    L14:
        return r11.C(r12);
    }
}
