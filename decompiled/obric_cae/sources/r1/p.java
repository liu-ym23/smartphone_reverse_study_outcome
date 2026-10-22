package r1;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.work.e f11331b;

    public p(String r8, androidx.work.e r10) {
        he.i.f(r8, "workSpecId");
        he.i.f(r10, "progress");
        this.f11330a = r8;
        this.f11331b = r10;
    }

    public final androidx.work.e a() {
        return this.f11331b;
    }

    public final String b() {
        return this.f11330a;
    }
}
