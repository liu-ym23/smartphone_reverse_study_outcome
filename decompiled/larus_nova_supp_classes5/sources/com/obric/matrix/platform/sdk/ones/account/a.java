package com.obric.matrix.platform.sdk.ones.account;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public boolean a;
    public int b;
    public String c;
    public String d;
    public int e;
    public String f;
    public String g;
    public String h;
    public int i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public boolean p;
    public String q;
    public long r;
    public String s;

    public a() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r9.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r9.r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r9.s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = ((((((((((((((((((((((((r2 * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31;
        boolean r4 = this.n;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (((r3 + r5) * 31) + this.o) * 31;
        boolean r7 = this.p;
        if (r7 == true) goto L12;
        r1 = r7;
    L12:
        int r8 = (((r6 + r1) * 31) + this.q.hashCode()) * 31;
        long r9 = this.r;
        return ((r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31) + this.s.hashCode();
    }

    public final String toString() {
        return "AccountInfo(loginState=" + this.a + ", logoutScene=" + this.b + ", secUserId=" + this.c + ", userId=" + this.d + ", odinUserType=" + this.e + ", xTTToken=" + this.f + ", innerSSOToken=" + this.g + ", avatarUrl=" + this.h + ", countryCode=" + this.i + ", userName=" + this.j + ", screenName=" + this.k + ", userEmail=" + this.l + ", userMobile=" + this.m + ", hasPassword=" + this.n + ", userGender=" + this.o + ", isNewUser=" + this.p + ", userSession=" + this.q + ", loginUtcTime=" + this.r + ", loginPhoneNumber=" + this.s + ')';
    }

    public a(int r4) {
        Intrinsics.checkNotNullParameter("", "secUserId");
        Intrinsics.checkNotNullParameter("", "userId");
        Intrinsics.checkNotNullParameter("", "xTTToken");
        Intrinsics.checkNotNullParameter("", "innerSSOToken");
        Intrinsics.checkNotNullParameter("", "avatarUrl");
        Intrinsics.checkNotNullParameter("", "userName");
        Intrinsics.checkNotNullParameter("", "screenName");
        Intrinsics.checkNotNullParameter("", "userEmail");
        Intrinsics.checkNotNullParameter("", "userMobile");
        Intrinsics.checkNotNullParameter("", "userSession");
        Intrinsics.checkNotNullParameter("", "loginPhoneNumber");
        this.a = false;
        this.b = 0;
        this.c = "";
        this.d = "";
        this.e = 0;
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = 86;
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = false;
        this.o = 0;
        this.p = false;
        this.q = "";
        this.r = 0;
        this.s = "";
    }
}
