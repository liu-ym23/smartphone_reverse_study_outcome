package com.loc;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
@w(a = "a")
public final class fw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @x(a = "a1", b = 6)
    private String f5595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @x(a = "a2", b = 6)
    private String f5596b;

    @x(a = "a6", b = 2)
    private int c;

    @x(a = "a3", b = 6)
    private String d;

    @x(a = "a4", b = 6)
    private String e;

    @x(a = "a5", b = 6)
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String[] l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f5598b;
        private String c;
        private String d;
        private boolean e;
        private String f;
        private String[] g;

        public a(String r2, String r3, String r4) {
            this.e = true;
            this.f = "standard";
            this.g = null;
            this.f5597a = r3;
            this.f5598b = r3;
            this.d = r4;
            this.c = r2;
        }

        static /* synthetic */ String a(a r0) {
            return r0.f5597a;
        }

        static /* synthetic */ String b(a r0) {
            return r0.f5598b;
        }

        static /* synthetic */ String c(a r0) {
            return r0.c;
        }

        static /* synthetic */ String d(a r0) {
            return r0.d;
        }

        static /* synthetic */ boolean e(a r0) {
            return r0.e;
        }

        static /* synthetic */ String f(a r0) {
            return r0.f;
        }

        static /* synthetic */ String[] g(a r0) {
            return r0.g;
        }

        public final a a(String r1) {
            this.f5598b = r1;
            return this;
        }

        public final a a(String[] r3) {
            if (r3 == null) goto L4;
            this.g = (String[]) ZeusTransformUtils.preCheckCast(r3.clone(), String[].class, "com.obric.memorydata.plugin");
        L4:
            return this;
        }

        public final fw a() {
            if (this.g == null) goto L7;
            return new fw(this, 0);
        L7:
            throw new l("sdk packages is null");
        }
    }

    private fw() {
        this.c = 1;
        this.l = null;
    }

    private fw(a r2) {
        this.c = 1;
        this.l = null;
        this.g = a.a(r2);
        this.h = a.b(r2);
        this.j = a.c(r2);
        this.i = a.d(r2);
        this.c = a.e(r2) ? 1 : 0;
        this.k = a.f(r2);
        this.l = a.g(r2);
        this.f5596b = fx.b(this.h);
        this.f5595a = fx.b(this.j);
        this.d = fx.b(this.i);
        this.e = fx.b(a(this.l));
        this.f = fx.b(this.k);
    }

    /* synthetic */ fw(a r1, byte r2) {
        this(r1);
    }

    private static String a(String[] r6) {
        if (r6 != null) goto L13;
        return null;
    L13:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L10
        int r2 = r6.length;     // Catch: Throwable -> L10
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r1.append(r6[r3]).append(";");     // Catch: Throwable -> L10
        r3 = r3 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        return r1.toString();
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String[] a(String r1) {
        return r1.split(";");
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.j) == false) goto L8;
        if (TextUtils.isEmpty(this.f5595a) == true) goto L8;
        this.j = fx.c(this.f5595a);
    L8:
        return this.j;
    }

    public final void a(boolean r1) {
        this.c = r1 ? 1 : 0;
    }

    public final String b() {
        return this.g;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.h) == false) goto L8;
        if (TextUtils.isEmpty(this.f5596b) == true) goto L8;
        this.h = fx.c(this.f5596b);
    L8:
        return this.h;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.k) == false) goto L8;
        if (TextUtils.isEmpty(this.f) == true) goto L8;
        this.k = fx.c(this.f);
    L8:
        if (TextUtils.isEmpty(this.k) == false) goto L11;
        this.k = "standard";
    L11:
        return this.k;
    }

    public final boolean e() {
        if (this.c != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean equals(Object r7) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if (r7 != this) goto L9;
        return true;
    L9:
        if (getClass() == r7.getClass()) goto L20;
        return false;
    L20:
        if (this.j.equals(((fw) ZeusTransformUtils.preCheckCast(r7, fw.class, "com.obric.memorydata.plugin")).j) == false) goto L18;
        if (this.g.equals(((fw) ZeusTransformUtils.preCheckCast(r7, fw.class, "com.obric.memorydata.plugin")).g) == false) goto L18;
        if (this.h.equals(((fw) ZeusTransformUtils.preCheckCast(r7, fw.class, "com.obric.memorydata.plugin")).h) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final String[] f() {
        String[] r0 = this.l;
        if (r0 == null) goto L7;
        if (r0.length == 0) goto L7;
    L10:
        return (String[]) ZeusTransformUtils.preCheckCast(this.l.clone(), String[].class, "com.obric.memorydata.plugin");
    L7:
        if (TextUtils.isEmpty(this.e) == true) goto L10;
        this.l = a(fx.c(this.e));
        goto L10
    }
}
