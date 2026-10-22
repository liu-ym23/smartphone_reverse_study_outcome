package n9;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f20216b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f20217a;

    static {
        f20216b = new b();
    }

    public c() {
        this.f20217a = f20216b;
    }

    public Object a(String r5) {
        b r10 = this.f20217a;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.a(r5);
    }

    public Object b(String r5) {
        b r10 = this.f20217a;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.b(r5);
    }
}
