package defpackage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum a extends Enum<a> {
    public static final a c = null;
    public static final a d = null;
    public static final a e = null;
    public static final a f = null;
    public static final a g = null;
    public static final /* synthetic */ a[] h = null;
    public int a;
    public String b;

    static {
        a r0 = new a("SUCCESS", 0, 0, "success");
        c = r0;
        a r1 = new a("ERROR_NO_PERMISSION", 1, 8002009, "No permission to call this function.");
        d = r1;
        a r2 = new a("ERROR_EXCEEDED_MAXIMUM", 2, 8002010, "Turning on the notification switch request exceeds the maximum number of times.");
        e = r2;
        a r4 = new a("ERROR_REQUIRES_TOO_MANY", 3, 8002011, "Turning on the notification switch requires too many requests.");
        f = r4;
        a r5 = new a("ERROR_VERSION_NOT_SUPPORT", 4, 8002012, "The current version does not support this function, please upgrade Honor Push.");
        g = r5;
        h = new a[]{r0, r1, r2, r4, r5};
    }

    public a(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.a = r3;
        this.b = r4;
    }

    public static a valueOf(String r1) {
        return (a) r27.a.a(a.class, r1);
    }

    public static a[] values() {
        return (a[]) h.clone();
    }
}
