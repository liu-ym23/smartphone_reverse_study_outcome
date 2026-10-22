package nd;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<EnumC0122a, gd.b> f9520a = null;

    /* JADX INFO: renamed from: nd.a$a, reason: collision with other inner class name */
    public static final enum EnumC0122a extends Enum<EnumC0122a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0122a f9521a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0122a f9522b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final EnumC0122a f9523m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final EnumC0122a f9524n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final EnumC0122a f9525o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final EnumC0122a f9526p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final EnumC0122a f9527q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final EnumC0122a f9528r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final /* synthetic */ EnumC0122a[] f9529s = null;

        static {
            EnumC0122a r8 = new EnumC0122a("MSG", 0);
            f9521a = r8;
            EnumC0122a r10 = new EnumC0122a("JSON", 1);
            f9522b = r10;
            EnumC0122a r11 = new EnumC0122a("BUNDLE", 2);
            f9523m = r11;
            EnumC0122a r12 = new EnumC0122a("INTENT", 3);
            f9524n = r12;
            EnumC0122a r13 = new EnumC0122a("THROWABLE", 4);
            f9525o = r13;
            EnumC0122a r14 = new EnumC0122a("BORDER", 5);
            f9526p = r14;
            EnumC0122a r15 = new EnumC0122a("STACKTRACE", 6);
            f9527q = r15;
            EnumC0122a r16 = new EnumC0122a("THREAD", 7);
            f9528r = r16;
            f9529s = new EnumC0122a[]{r8, r10, r11, r12, r13, r14, r15, r16, new EnumC0122a("STACKTRACE_STR", 8)};
        }

        public EnumC0122a(String r8, int r10) {
            super(r8, r10);
        }

        public static EnumC0122a valueOf(String r8) {
            return (EnumC0122a) Enum.valueOf(EnumC0122a.class, r8);
        }

        public static EnumC0122a[] values() {
            return (EnumC0122a[]) f9529s.clone();
        }
    }

    static {
        ConcurrentHashMap<EnumC0122a, gd.b> r8 = new ConcurrentHashMap();
        f9520a = r8;
        r8.put(EnumC0122a.f9521a, new id.a());
        r8.put(EnumC0122a.f9522b, new jd.a());
        r8.put(EnumC0122a.f9523m, new kd.a());
        r8.put(EnumC0122a.f9524n, new kd.b());
        r8.put(EnumC0122a.f9526p, new hd.a(0));
        r8.put(EnumC0122a.f9527q, new ld.a());
        r8.put(EnumC0122a.f9528r, new md.a());
        r8.put(EnumC0122a.f9525o, new hd.a(1));
    }
}
