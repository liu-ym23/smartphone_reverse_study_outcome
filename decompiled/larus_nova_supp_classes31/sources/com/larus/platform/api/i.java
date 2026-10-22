package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public static final i h = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public static final class a {
    }

    public i() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "BoeDomainConfig(wwwOnlineHost=" + this.a + ", wwwBoeHost=" + this.b + ", wssNormalHost=" + this.c + ", wss100NormalHost=" + this.d + ", wssNormalBoeHost=" + this.e + ", wsSamanthaHost=" + this.f + ", wsSamanthaBoeHost=" + this.g + ')';
    }

    static {
        h = new i(0);
    }

    public /* synthetic */ i(int r9) {
        this("", "", "", "", "", "", "");
    }

    public i(String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "wwwOnlineHost");
        Intrinsics.checkNotNullParameter(r3, "wwwBoeHost");
        Intrinsics.checkNotNullParameter(r4, "wssNormalHost");
        Intrinsics.checkNotNullParameter(r5, "wss100NormalHost");
        Intrinsics.checkNotNullParameter(r6, "wssNormalBoeHost");
        Intrinsics.checkNotNullParameter(r7, "wsSamanthaHost");
        Intrinsics.checkNotNullParameter(r8, "wsSamanthaBoeHost");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
