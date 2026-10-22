package com.obric.assistant.settings;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final List<String> d;
    public final String e;
    public final String f;
    public final int g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        List<String> r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "AppInfo(packageName=" + this.a + ", appName=" + this.b + ", appEnName=" + this.c + ", appAliasName=" + this.d + ", appPinyinName=" + this.e + ", appPinyinFirstLetter=" + this.f + ", blockSouce=" + this.g + ')';
    }

    public /* synthetic */ b(String r9, String r10, String r11) {
        this(r9, r10, "", null, "", r11, 0);
    }

    public static b a(b r10, List r11, int r12, int r13) {
        String r1 = null;
        if ((r13 & 1) == 0) goto L5;
        String r3 = r10.a;
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r4 = r10.b;
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r5 = r10.c;
    L15:
        if ((r13 & 8) == 0) goto L17;
        r11 = r10.d;
    L17:
        List r6 = r11;
        if ((r13 & 16) == 0) goto L20;
        String r7 = r10.e;
    L22:
        if ((r13 & 32) == 0) goto L24;
        r1 = r10.f;
    L24:
        String r8 = r1;
        if ((r13 & 64) == 0) goto L27;
        r12 = r10.g;
    L27:
        Intrinsics.checkNotNullParameter(r3, "packageName");
        Intrinsics.checkNotNullParameter(r4, "appName");
        Intrinsics.checkNotNullParameter(r5, "appEnName");
        Intrinsics.checkNotNullParameter(r7, "appPinyinName");
        Intrinsics.checkNotNullParameter(r8, "appPinyinFirstLetter");
        return new b(r3, r4, r5, r6, r7, r8, r12);
    L20:
        r7 = null;
        goto L22
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public b(String r2, String r3, String r4, List<String> r5, String r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        Intrinsics.checkNotNullParameter(r3, "appName");
        Intrinsics.checkNotNullParameter(r4, "appEnName");
        Intrinsics.checkNotNullParameter(r6, "appPinyinName");
        Intrinsics.checkNotNullParameter(r7, "appPinyinFirstLetter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
