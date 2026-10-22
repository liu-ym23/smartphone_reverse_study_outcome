package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends he.j implements ge.p<Boolean, ae.f.b, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f10075a = null;

    static {
        f10075a = new u();
    }

    public u() {
        super(2);
    }

    @Override // ge.p
    public final Boolean invoke(Boolean r8, ae.f.b r10) {
        ae.f.b r11 = r10;
        if (r8.booleanValue() == false) goto L5;
    L8:
        boolean r12 = true;
    L10:
        return Boolean.valueOf(r12);
    L5:
        if ((r11 instanceof r) == true) goto L8;
        r12 = false;
        goto L10
    }
}
