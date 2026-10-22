package j1;

/* JADX INFO: loaded from: classes.dex */
public final class f0 extends he.j implements ge.l<r1.t, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f8478a = null;

    static {
        f8478a = new f0();
    }

    public f0() {
        super(1);
    }

    @Override // ge.l
    public final String invoke(r1.t r8) {
        r1.t r10 = r8;
        he.i.f(r10, "spec");
        if (r10.f() == false) goto L5;
        return "Periodic";
    L5:
        return "OneTime";
    }
}
