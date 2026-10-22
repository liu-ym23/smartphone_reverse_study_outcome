package he;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements le.a, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient le.a f8051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8052b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Class f8053m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f8054n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f8055o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f8056p;

    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8057a = null;

        static {
            f8057a = new a();
        }
    }

    public b(Object r8, Class r10, String r11, String r12, boolean r13) {
        this.f8052b = r8;
        this.f8053m = r10;
        this.f8054n = r11;
        this.f8055o = r12;
        this.f8056p = r13;
    }

    public abstract le.a a();

    public final c b() {
        Class r8 = this.f8053m;
        if (r8 != null) goto L6;
        return null;
    L6:
        if (this.f8056p == false) goto L9;
        p.f8065a.getClass();
        return new k(r8);
    L9:
        return p.a(r8);
    }
}
