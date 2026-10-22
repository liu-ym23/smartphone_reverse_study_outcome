package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends he.j implements ge.p<ae.f, ae.f.b, ae.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f10059a = null;

    static {
        f10059a = new s();
    }

    public s() {
        super(2);
    }

    @Override // ge.p
    public final ae.f invoke(ae.f r8, ae.f.b r10) {
        ae.f r11 = r8;
        ae.f.b r12 = r10;
        if ((r12 instanceof r) == false) goto L6;
        return r11.C(((r) r12).v());
    L6:
        return r11.C(r12);
    }
}
