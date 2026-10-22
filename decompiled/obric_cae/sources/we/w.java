package we;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final enum w extends Enum<w> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f13319b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final w f13320m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final w f13321n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final w f13322o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final w f13323p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final w f13324q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ w[] f13325r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13326a;

    static {
        w r8 = new w("HTTP_1_0", 0, "http/1.0");
        f13319b = r8;
        w r10 = new w("HTTP_1_1", 1, "http/1.1");
        f13320m = r10;
        w r11 = new w("SPDY_3", 2, "spdy/3.1");
        f13321n = r11;
        w r12 = new w("HTTP_2", 3, "h2");
        f13322o = r12;
        w r13 = new w("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        f13323p = r13;
        w r14 = new w("QUIC", 5, "quic");
        f13324q = r14;
        f13325r = new w[]{r8, r10, r11, r12, r13, r14};
    }

    public w(String r8, int r10, String r11) {
        super(r8, r10);
        this.f13326a = r11;
    }

    public static w a(String r8) {
        if (r8.equals("http/1.0") == false) goto L7;
        return f13319b;
    L7:
        if (r8.equals("http/1.1") == false) goto L11;
        return f13320m;
    L11:
        if (r8.equals("h2_prior_knowledge") == false) goto L15;
        return f13323p;
    L15:
        if (r8.equals("h2") == false) goto L19;
        return f13322o;
    L19:
        if (r8.equals("spdy/3.1") == false) goto L23;
        return f13321n;
    L23:
        if (r8.equals("quic") == false) goto L27;
        return f13324q;
    L27:
        throw new IOException("Unexpected protocol: ".concat(r8));
    }

    public static w valueOf(String r8) {
        return (w) Enum.valueOf(w.class, r8);
    }

    public static w[] values() {
        return (w[]) f13325r.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f13326a;
    }
}
