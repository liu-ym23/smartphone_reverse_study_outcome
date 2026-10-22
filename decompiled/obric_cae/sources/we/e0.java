package we;

/* JADX INFO: loaded from: classes2.dex */
public final enum e0 extends Enum<e0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f13162b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e0 f13163m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e0 f13164n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e0 f13165o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final e0 f13166p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ e0[] f13167q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13168a;

    static {
        e0 r8 = new e0("TLS_1_3", 0, "TLSv1.3");
        f13162b = r8;
        e0 r10 = new e0("TLS_1_2", 1, "TLSv1.2");
        f13163m = r10;
        e0 r11 = new e0("TLS_1_1", 2, "TLSv1.1");
        f13164n = r11;
        e0 r12 = new e0("TLS_1_0", 3, "TLSv1");
        f13165o = r12;
        e0 r13 = new e0("SSL_3_0", 4, "SSLv3");
        f13166p = r13;
        f13167q = new e0[]{r8, r10, r11, r12, r13};
    }

    public e0(String r8, int r10, String r11) {
        super(r8, r10);
        this.f13168a = r11;
    }

    public static e0 a(String r8) {
        r8.getClass();
        byte r10 = -1;
        switch(r8.hashCode()) {
            case -503070503: goto L22;
            case -503070502: goto L18;
            case -503070501: goto L14;
            case 79201641: goto L10;
            case 79923350: goto L6;
            default: goto L25;
        };
    L25:
        switch(r10) {
            case 0: goto L37;
            case 1: goto L35;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L29;
            default: goto L27;
        };
    L27:
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(r8));
    L29:
        return f13165o;
    L31:
        return f13166p;
    L33:
        return f13162b;
    L35:
        return f13163m;
    L37:
        return f13164n;
    L6:
        if (r8.equals("TLSv1") == false) goto L25;
        r10 = 4;
        goto L25
    L10:
        if (r8.equals("SSLv3") == false) goto L25;
        r10 = 3;
        goto L25
    L14:
        if (r8.equals("TLSv1.3") == false) goto L25;
        r10 = 2;
        goto L25
    L18:
        if (r8.equals("TLSv1.2") == false) goto L25;
        r10 = 1;
        goto L25
    L22:
        if (r8.equals("TLSv1.1") == false) goto L25;
        r10 = 0;
        goto L25
    }

    public static e0 valueOf(String r8) {
        return (e0) Enum.valueOf(e0.class, r8);
    }

    public static e0[] values() {
        return (e0[]) f13167q.clone();
    }
}
