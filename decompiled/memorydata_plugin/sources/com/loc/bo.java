package com.loc;

import android.text.TextUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Proxy;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class bo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5368b;
    private boolean c;
    int d;
    int e;
    Proxy f;
    ak.a g;
    private String h;
    private boolean i;
    private boolean j;
    private a k;
    private b l;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f5369a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f5370b = null;
        public static final a c = null;
        public static final a d = null;
        public static final a e = null;
        private static final /* synthetic */ a[] g = null;
        private int f;

        static {
            a r0 = new a("NORMAL", 0, 0);
            f5369a = r0;
            a r1 = new a("INTERRUPT_IO", 1, 1);
            f5370b = r1;
            a r3 = new a("NEVER", 2, 2);
            c = r3;
            a r5 = new a("FIX", 3, 3);
            d = r5;
            a r7 = new a("SINGLE", 4, 4);
            e = r7;
            g = new a[]{r0, r1, r3, r5, r7};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f = r3;
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.memorydata.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(g.clone(), a[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5371a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f5372b = null;
        public static final b c = null;
        public static final b d = null;
        public static final b e = null;
        public static final b f = null;
        public static final b g = null;
        private static final /* synthetic */ b[] i = null;
        private int h;

        static {
            b r0 = new b("FIRST_NONDEGRADE", 0, 0);
            f5371a = r0;
            b r1 = new b("NEVER_GRADE", 1, 1);
            f5372b = r1;
            b r3 = new b("DEGRADE_BYERROR", 2, 2);
            c = r3;
            b r5 = new b("DEGRADE_ONLY", 3, 3);
            d = r5;
            b r7 = new b("FIX_NONDEGRADE", 4, 4);
            e = r7;
            b r9 = new b("FIX_DEGRADE_BYERROR", 5, 5);
            f = r9;
            b r11 = new b("FIX_DEGRADE_ONLY", 6, 6);
            g = r11;
            i = new b[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.h = r3;
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.memorydata.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(i.clone(), b[].class, "com.obric.memorydata.plugin");
        }

        public final int a() {
            return this.h;
        }

        public final boolean b() {
            int r1 = this.h;
            if (r1 != f5371a.h) goto L5;
            return true;
        L5:
            if (r1 != f5372b.h) goto L7;
            return true;
        L7:
            if (r1 == e.h) goto L14;
            return false;
        L14:
            return true;
        }

        public final boolean c() {
            int r1 = this.h;
            if (r1 != c.h) goto L5;
            return true;
        L5:
            if (r1 != d.h) goto L7;
            return true;
        L7:
            if (r1 != f.h) goto L9;
            return true;
        L9:
            if (r1 == g.h) goto L17;
            return false;
        L17:
            return true;
        }

        public final boolean d() {
            int r1 = this.h;
            if (r1 != c.h) goto L5;
            return true;
        L5:
            if (r1 == f.h) goto L11;
            return false;
        L11:
            return true;
        }

        public final boolean e() {
            if (this.h != f5372b.h) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f5373a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f5374b = null;
        private static final /* synthetic */ c[] d = null;
        private int c;

        static {
            c r0 = new c("HTTP", 0, 0);
            f5373a = r0;
            c r1 = new c("HTTPS", 1, 1);
            f5374b = r1;
            d = new c[]{r0, r1};
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
            this.c = r3;
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.memorydata.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(d.clone(), c[].class, "com.obric.memorydata.plugin");
        }
    }

    public bo() {
        this.d = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
        this.e = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
        this.f = null;
        this.f5367a = false;
        this.f5368b = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
        this.c = true;
        this.k = a.f5369a;
        this.l = b.f5371a;
    }

    private static String a(Map<String, String> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L12;
        return null;
    L12:
    L9:
        th = move-exception;
        n.a(th, "ht", "pnfh");
        return null;
    L6:
        if (r5.containsKey("platinfo") == false) goto L14;
        return c((String) ZeusTransformUtils.preCheckCast(r5.get("platinfo"), String.class, "com.obric.memorydata.plugin"));
    L14:
        return null;
    }

    private String b(String r3) {
        byte[] r0 = d();
        if (r0 != null) goto L5;
    L16:
        return r3;
    L5:
        if (r0.length == 0) goto L16;
        Map<String, String> r2 = b();
        if (ak.e == null) goto L12;
        if (r2 == null) goto L11;
        r2.putAll(ak.e);
        goto L12
    L11:
        r2 = ak.e;
    L12:
        if (r2 != null) goto L14;
        return r3;
    L14:
        String r4 = ao.a(r2);
        StringBuffer r1 = new StringBuffer();
        r1.append(r3).append("?").append(r4);
        return r1.toString();
    }

    private static String c(String r8) {
        String r1 = "";
    L29:
        th = move-exception;
        n.a(th, "ht", "pnfp");
    L31:
        return r1;
    L4:
        if (TextUtils.isEmpty(r8) == true) goto L31;
        String[] r9 = r8.split("&");     // Catch: Throwable -> L29
        if (r9.length <= 1) goto L31;
        int r2 = r9.length;     // Catch: Throwable -> L29
        int r4 = 0;
        String r5 = "";
    L8:
        if (r4 >= r2) goto L16;
        String r6 = r9[r4];     // Catch: Throwable -> L29
        if (r6.contains("sdkversion") == false) goto L13;
        r5 = r6;
    L13:
        if (r6.contains("product") == true) goto L18;
        r4 = r4 + 1;     // Catch: Throwable -> L29
    L18:
        if (TextUtils.isEmpty(r6) == true) goto L31;
        String[] r10 = r6.split("=");     // Catch: Throwable -> L29
        if (r10.length <= 1) goto L31;
        r1 = r10[1].trim();     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r5) == true) goto L31;
        if (TextUtils.isEmpty(com.loc.b.a(r1)) == false) goto L31;
        String[] r11 = r5.split("=");     // Catch: Throwable -> L29
        if (r11.length <= 1) goto L31;
        com.loc.b.a(r1, r11[1].trim());     // Catch: Throwable -> L29
        goto L31
    L16:
        r6 = "";
        goto L18
    }

    public final String A() {
        return this.h;
    }

    public final boolean B() {
        return this.i;
    }

    public final String C() {
        String r0 = f();     // Catch: Throwable -> L12
    L10:
        th = th;
    L14:
        n.a(th, "ht", "pnfr");
    L16:
        return r0;
    L4:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        if (this.f5367a == true) goto L20;
        r0 = a(a());     // Catch: Throwable -> L10
        goto L16
    L20:
        return c(((am) ZeusTransformUtils.preCheckCast(this, am.class, "com.obric.memorydata.plugin")).h());
    L12:
        th = th;
        r0 = "";
        goto L14
    }

    public abstract Map<String, String> a();

    public final void a(int r1) {
        this.d = r1;
    }

    public final void a(a r1) {
        this.k = r1;
    }

    public final void a(b r1) {
        this.l = r1;
    }

    public final void a(c r2) {
        if (r2 != c.f5374b) goto L5;
        boolean r3 = true;
    L6:
        this.j = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void a(String r1) {
        this.h = r1;
    }

    public final void a(Proxy r1) {
        this.f = r1;
    }

    public final void a(boolean r1) {
        this.i = r1;
    }

    public abstract Map<String, String> b();

    public final void b(int r1) {
        this.e = r1;
    }

    public abstract String c();

    public final void c(int r1) {
        this.f5368b = r1;
    }

    public byte[] d() {
        return null;
    }

    public boolean e() {
        return this.c;
    }

    public String f() {
        return "";
    }

    final String m() {
        return b(c());
    }

    final String n() {
        return b(p());
    }

    public String o() {
        return "";
    }

    public String p() {
        return c();
    }

    public final int q() {
        return this.d;
    }

    public final Proxy r() {
        return this.f;
    }

    public final a s() {
        return this.k;
    }

    public final boolean t() {
        return this.f5367a;
    }

    public final void u() {
        this.f5367a = true;
    }

    public final boolean v() {
        return this.j;
    }

    public final ak.a w() {
        return this.g;
    }

    public final b x() {
        return this.l;
    }

    public final int y() {
        return this.f5368b;
    }

    public final void z() {
        this.c = false;
    }
}
