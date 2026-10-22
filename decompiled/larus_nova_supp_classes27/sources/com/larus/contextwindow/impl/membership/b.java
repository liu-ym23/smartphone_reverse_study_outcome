package com.larus.contextwindow.impl.membership;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Function2<String, String, String> g;
    public final Function1<String, String> h;

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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public final String toString() {
        return "ContextWindowSlashSummaryText(contextTitle=" + this.a + ", currentPeriodTitle=" + this.b + ", subscriptionTotalTitle=" + this.c + ", exhaustedTitle=" + this.d + ", unlimitedTitle=" + this.e + ", unusedTitle=" + this.f + ", absoluteUsage=" + this.g + ", percentUsage=" + this.h + ')';
    }

    public b(String r2, String r3, String r4, String r5, String r6, String r7, com.larus.contextwindow.impl.service.c r8, com.larus.contextwindow.impl.service.d r9) {
        Intrinsics.checkNotNullParameter(r2, "contextTitle");
        Intrinsics.checkNotNullParameter(r3, "currentPeriodTitle");
        Intrinsics.checkNotNullParameter(r4, "subscriptionTotalTitle");
        Intrinsics.checkNotNullParameter(r5, "exhaustedTitle");
        Intrinsics.checkNotNullParameter(r6, "unlimitedTitle");
        Intrinsics.checkNotNullParameter(r7, "unusedTitle");
        Intrinsics.checkNotNullParameter(r8, "absoluteUsage");
        Intrinsics.checkNotNullParameter(r9, "percentUsage");
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
