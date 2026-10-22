package com.ss.android.lark.maintab.export;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final String a;
    public final TabAppInfo.BizType b;
    public final TabAppType c;
    public final String d;
    public final TabAppInfo.CustomNavigationAppLogoType e;
    public final String f;
    public final String g;
    public final String h;
    public String i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        String r1 = this.h;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "bizType:" + this.b + ", appType:" + this.c + ", name:" + this.d + ", logoType:" + this.e + ", logoContent:" + this.f + ", bizAppId:" + this.h + ", extraMap:null, nameMap:nulloriginalName:nullsubType:" + this.i;
    }

    public a(String r2, TabAppInfo.BizType r3, TabAppType r4, String r5, TabAppInfo.CustomNavigationAppLogoType r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "bizType");
        Intrinsics.checkNotNullParameter(r4, "appType");
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, "logoType");
        Intrinsics.checkNotNullParameter(r7, "logoContent");
        Intrinsics.checkNotNullParameter(r8, "url");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
