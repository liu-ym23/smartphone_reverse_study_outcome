package qa;

/* JADX INFO: loaded from: classes.dex */
public abstract class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f10294a;

    public d0(d0 r8) {
        this.f10294a = r8;
    }

    public abstract byte[] a(byte[] r8);

    public final byte[] b(byte[] r8) {
        d0 r10 = this.f10294a;
        if (r10 == null) goto L6;
        r8 = r10.b(r8);
    L6:
        return a(r8);
    }
}
