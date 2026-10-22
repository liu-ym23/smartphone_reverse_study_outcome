package dxb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final b b = null;
    public static final b c = null;
    public static final b d = null;
    public final String a;

    public static final class a {
    }

    static {
        b = new b("larkweb");
        c = new b("chameleon");
        d = new b("unknown");
    }

    public final String a() {
        String r0 = this.a;
        if (r0 != null) goto L6;
        return "unknown";
    L6:
        return r0;
    }

    public b(String r1) {
        this.a = r1;
    }
}
