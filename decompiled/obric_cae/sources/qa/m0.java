package qa;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Proxy f10798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f10805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f10806j;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10807a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f10808b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f10809m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f10810n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ a[] f10811o = null;

        static {
            a r8 = new a("NORMAL", 0);
            f10807a = r8;
            a r10 = new a("INTERRUPT_IO", 1);
            f10808b = r10;
            a r11 = new a("NEVER", 2);
            a r12 = new a("FIX", 3);
            f10809m = r12;
            a r13 = new a("SINGLE", 4);
            f10810n = r13;
            f10811o = new a[]{r8, r10, r11, r12, r13};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f10811o.clone();
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f10812b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f10813m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f10814n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final b f10815o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final b f10816p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final b f10817q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final b f10818r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final /* synthetic */ b[] f10819s = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10820a;

        static {
            b r8 = new b("FIRST_NONDEGRADE", 0, 0);
            f10812b = r8;
            b r10 = new b("NEVER_GRADE", 1, 1);
            f10813m = r10;
            b r11 = new b("DEGRADE_BYERROR", 2, 2);
            f10814n = r11;
            b r12 = new b("DEGRADE_ONLY", 3, 3);
            f10815o = r12;
            b r13 = new b("FIX_NONDEGRADE", 4, 4);
            f10816p = r13;
            b r14 = new b("FIX_DEGRADE_BYERROR", 5, 5);
            f10817q = r14;
            b r15 = new b("FIX_DEGRADE_ONLY", 6, 6);
            f10818r = r15;
            f10819s = new b[]{r8, r10, r11, r12, r13, r14, r15};
        }

        public b(String r8, int r10, int r11) {
            super(r8, r10);
            this.f10820a = r11;
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f10819s.clone();
        }

        public final boolean a() {
            int r8 = this.f10820a;
            if (r8 == 0) goto L10;
            if (r8 == 1) goto L10;
            if (r8 == 4) goto L10;
            return false;
        L10:
            return true;
        }

        public final boolean b() {
            int r8 = this.f10820a;
            if (r8 != 2) goto L5;
            return true;
        L5:
            if (r8 != 3) goto L7;
            return true;
        L7:
            if (r8 != 5) goto L9;
            return true;
        L9:
            if (r8 == 6) goto L17;
            return false;
        L17:
            return true;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f10821a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f10822b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ c[] f10823m = null;

        static {
            c r8 = new c("HTTP", 0);
            f10821a = r8;
            c r10 = new c("HTTPS", 1);
            f10822b = r10;
            f10823m = new c[]{r8, r10};
        }

        public c(String r8, int r10) {
            super(r8, r10);
        }

        public static c valueOf(String r8) {
            return (c) Enum.valueOf(c.class, r8);
        }

        public static c[] values() {
            return (c[]) f10823m.clone();
        }
    }

    public m0() {
        this.f10797a = 20000;
        this.f10798b = null;
        this.f10799c = false;
        this.f10800d = 20000;
        this.f10801e = true;
        this.f10805i = a.f10807a;
        this.f10806j = b.f10812b;
    }

    public static String f(String r8) {
        String r10 = "";
    L29:
        th = move-exception;
        l.a("ht", "pnfp", th);
    L31:
        return r10;
    L4:
        if (TextUtils.isEmpty(r8) == true) goto L31;
        String[] r11 = r8.split("&");     // Catch: Throwable -> L29
        if (r11.length <= 1) goto L31;
        int r12 = r11.length;     // Catch: Throwable -> L29
        int r13 = 0;
        String r14 = "";
    L8:
        if (r13 >= r12) goto L16;
        String r15 = r11[r13];     // Catch: Throwable -> L29
        if (r15.contains("sdkversion") == false) goto L13;
        r14 = r15;
    L13:
        if (r15.contains("product") == true) goto L18;
        r13 = r13 + 1;     // Catch: Throwable -> L29
    L18:
        if (TextUtils.isEmpty(r15) == true) goto L31;
        String[] r16 = r15.split("=");     // Catch: Throwable -> L29
        if (r16.length <= 1) goto L31;
        r10 = r16[1].trim();     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r14) == true) goto L31;
        if (TextUtils.isEmpty(qa.b.a(r10)) == false) goto L31;
        String[] r17 = r14.split("=");     // Catch: Throwable -> L29
        if (r17.length <= 1) goto L31;
        qa.b.b(r10, r17[1].trim());     // Catch: Throwable -> L29
        goto L31
    L16:
        r15 = "";
        goto L18
    }

    public abstract Map<String, String> a();

    public final void b(c r8) {
        if (r8 != c.f10822b) goto L5;
        boolean r10 = true;
    L6:
        this.f10804h = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public abstract String c();

    public final String d(String r8) {
        byte[] r10 = i();
        if (r10 != null) goto L5;
    L12:
        return r8;
    L5:
        if (r10.length == 0) goto L12;
        Map<String, String> r11 = h();
        if (r11 != null) goto L10;
        return r8;
    L10:
        String r12 = k0.b(r11);
        StringBuffer r13 = new StringBuffer();
        r13.append(r8);
        r13.append("?");
        r13.append(r12);
        return r13.toString();
    }

    public String e() {
        return c();
    }

    public boolean g() {
        return this.f10801e;
    }

    public abstract Map<String, String> h();

    public abstract byte[] i();

    public String j() {
        return "";
    }

    public String k() {
        return "";
    }
}
