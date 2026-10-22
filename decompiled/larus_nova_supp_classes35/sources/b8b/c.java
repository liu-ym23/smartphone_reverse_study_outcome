package b8b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31;
        String r1 = this.p;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ThirdSdkKeys(weiboShareAppKey=" + this.a + ", wechatShareAppKey=" + this.b + ", qQShareKey=" + this.c + ", miPushAppId=" + this.d + ", miPushAppKey=" + this.e + ", meizuAppId=" + this.f + ", meizuAppKey=" + this.g + ", oppoPushAppKey=" + this.h + ", oppoPushSecret=" + this.i + ", umengPushAppKey=" + this.j + ", umengPushMessageSecret=" + this.k + ", matrixAppKey=" + this.l + ", matrixAppSecret=" + this.m + ", lenovoPushAppKey=" + this.n + ", lenovoPushAppSecret=" + this.o + ", specificAMapKey=" + this.p + ')';
    }

    public c() {
        Intrinsics.checkNotNullParameter("1426943654", "weiboShareAppKey");
        Intrinsics.checkNotNullParameter("wx2dccad7bcdbdab7e", "wechatShareAppKey");
        Intrinsics.checkNotNullParameter("1107733183", "qQShareKey");
        Intrinsics.checkNotNullParameter("2882303761520457517", "miPushAppId");
        Intrinsics.checkNotNullParameter("5682045751517", "miPushAppKey");
        Intrinsics.checkNotNullParameter("156308", "meizuAppId");
        Intrinsics.checkNotNullParameter("3eef9da123df437e8e95e162841ce438", "meizuAppKey");
        Intrinsics.checkNotNullParameter("457c4a0d7c804931b1f4cabcb2667c87", "oppoPushAppKey");
        Intrinsics.checkNotNullParameter("25939c1fe3254b51b098fd98805ebf65", "oppoPushSecret");
        Intrinsics.checkNotNullParameter("68d4bb39ef272756f7a0cb0f", "umengPushAppKey");
        Intrinsics.checkNotNullParameter("f0a7ddcdcae3b5b95e96819df8f73ca3", "umengPushMessageSecret");
        Intrinsics.checkNotNullParameter("lark", "matrixAppKey");
        Intrinsics.checkNotNullParameter("6rHDjFphS16oTL24RiyY57hstQk0uEGW", "matrixAppSecret");
        Intrinsics.checkNotNullParameter("mRoDHhwAwY7H4Hw5hxxMx4", "lenovoPushAppKey");
        Intrinsics.checkNotNullParameter("8wJRFHYXZv6sam9w4bM4G3", "lenovoPushAppSecret");
        this.a = "1426943654";
        this.b = "wx2dccad7bcdbdab7e";
        this.c = "1107733183";
        this.d = "2882303761520457517";
        this.e = "5682045751517";
        this.f = "156308";
        this.g = "3eef9da123df437e8e95e162841ce438";
        this.h = "457c4a0d7c804931b1f4cabcb2667c87";
        this.i = "25939c1fe3254b51b098fd98805ebf65";
        this.j = "68d4bb39ef272756f7a0cb0f";
        this.k = "f0a7ddcdcae3b5b95e96819df8f73ca3";
        this.l = "lark";
        this.m = "6rHDjFphS16oTL24RiyY57hstQk0uEGW";
        this.n = "mRoDHhwAwY7H4Hw5hxxMx4";
        this.o = "8wJRFHYXZv6sam9w4bM4G3";
        this.p = null;
    }
}
