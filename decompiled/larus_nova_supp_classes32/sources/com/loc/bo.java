package com.loc;

import android.text.TextUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.net.Proxy;
import java.util.Map;
import n4a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class bo {
    public int a;
    public Proxy b;
    public boolean c;
    public int d;
    public boolean e;
    public String f;
    public boolean g;
    public boolean h;
    public a i;
    public b j;

    public static final enum a extends Enum<a> {
        public static final a a = null;
        public static final a b = null;
        public static final a c = null;
        public static final a d = null;
        public static final a e = null;
        public static final /* synthetic */ a[] g = null;
        private int f;

        static {
            a r0 = new a("NORMAL", 0, 0);
            a = r0;
            a r1 = new a("INTERRUPT_IO", 1, 1);
            b = r1;
            a r3 = new a("NEVER", 2, 2);
            c = r3;
            a r5 = new a("FIX", 3, 3);
            d = r5;
            a r7 = new a("SINGLE", 4, 4);
            e = r7;
            g = new a[]{r0, r1, r3, r5, r7};
        }

        public a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f = r3;
        }

        public static a valueOf(String r1) {
            return (a) r27.a.a(a.class, r1);
        }

        public static a[] values() {
            return (a[]) g.clone();
        }
    }

    public static final enum b extends Enum<b> {
        public static final b a = null;
        public static final b b = null;
        public static final b c = null;
        public static final b d = null;
        public static final b e = null;
        public static final b f = null;
        public static final b g = null;
        public static final /* synthetic */ b[] i = null;
        private int h;

        static {
            b r0 = new b("FIRST_NONDEGRADE", 0, 0);
            a = r0;
            b r1 = new b("NEVER_GRADE", 1, 1);
            b = r1;
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

        public b(String r1, int r2, int r3) {
            super(r1, r2);
            this.h = r3;
        }

        public static b valueOf(String r1) {
            return (b) r27.a.a(b.class, r1);
        }

        public static b[] values() {
            return (b[]) i.clone();
        }

        public final int a() {
            return this.h;
        }

        public final boolean b() {
            int r0 = this.h;
            if (r0 != a.h) goto L5;
            return true;
        L5:
            if (r0 != b.h) goto L7;
            return true;
        L7:
            if (r0 == e.h) goto L14;
            return false;
        L14:
            return true;
        }

        public final boolean c() {
            int r0 = this.h;
            if (r0 != c.h) goto L5;
            return true;
        L5:
            if (r0 != d.h) goto L7;
            return true;
        L7:
            if (r0 != f.h) goto L9;
            return true;
        L9:
            if (r0 == g.h) goto L17;
            return false;
        L17:
            return true;
        }

        public final boolean d() {
            int r0 = this.h;
            if (r0 != c.h) goto L5;
            return true;
        L5:
            if (r0 == f.h) goto L11;
            return false;
        L11:
            return true;
        }

        public final boolean e() {
            if (this.h != b.h) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public static final enum c extends Enum<c> {
        public static final c a = null;
        public static final c b = null;
        public static final /* synthetic */ c[] d = null;
        private int c;

        static {
            c r0 = new c("HTTP", 0, 0);
            a = r0;
            c r1 = new c("HTTPS", 1, 1);
            b = r1;
            d = new c[]{r0, r1};
        }

        public c(String r1, int r2, int r3) {
            super(r1, r2);
            this.c = r3;
        }

        public static c valueOf(String r1) {
            return (c) r27.a.a(c.class, r1);
        }

        public static c[] values() {
            return (c[]) d.clone();
        }
    }

    public bo() {
        this.a = 20000;
        this.b = null;
        this.c = false;
        this.d = 20000;
        this.e = true;
        this.i = a.a;
        this.j = b.a;
    }

    public static String f(String r8) {
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
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
        String r5 = NameKeys.UnloadStrategy_No_Strategy;
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
        if (TextUtils.isEmpty(n4a.c.a(r1)) == false) goto L31;
        String[] r11 = r5.split("=");     // Catch: Throwable -> L29
        if (r11.length <= 1) goto L31;
        n4a.c.b(r1, r11[1].trim());     // Catch: Throwable -> L29
        goto L31
    L16:
        r6 = NameKeys.UnloadStrategy_No_Strategy;
        goto L18
    }

    public abstract Map<String, String> a();

    public final void b(c r2) {
        if (r2 != c.b) goto L5;
        boolean r3 = true;
    L6:
        this.h = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public abstract String c();

    public final String d(String r3) {
        byte[] r0 = i();
        if (r0 != null) goto L5;
        return r3;
    L5:
        if (r0.length == 0) goto L13;
        Map<String, String> r1 = h();
        if (r1 != null) goto L10;
        return r3;
    L10:
        String r2 = d.b(r1);
        StringBuffer r4 = new StringBuffer();
        r4.append(r3);
        r4.append("?");
        r4.append(r2);
        return r4.toString();
    L13:
        return r3;
    }

    public String e() {
        return c();
    }

    public boolean g() {
        return this.e;
    }

    public abstract Map<String, String> h();

    public abstract byte[] i();

    public String j() {
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public String k() {
        return NameKeys.UnloadStrategy_No_Strategy;
    }
}
