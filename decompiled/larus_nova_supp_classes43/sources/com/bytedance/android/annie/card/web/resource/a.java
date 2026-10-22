package com.bytedance.android.annie.card.web.resource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final boolean a;
    public final String b;
    public final long c;
    public final boolean d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = ((r0 * 31) + this.b.hashCode()) * 31;
        long r11 = this.c;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        if (this.d == true) goto L11;
        r1 = 1237;
    L11:
        return r12 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResourceInfo(isOffline=" + this.a + ", resFrom=" + this.b + ", version=" + this.c + ", useForest=" + this.d + ')';
    }

    public a(boolean r10, String r11, long r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "resFrom");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
