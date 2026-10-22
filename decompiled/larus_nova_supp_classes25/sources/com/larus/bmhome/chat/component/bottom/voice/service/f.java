package com.larus.bmhome.chat.component.bottom.voice.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "Param(conversationId=" + this.a + ", itemId=" + this.b + ", botId=" + this.c + ", isImmerse=" + this.d + ", disableTimeout=" + this.e + ')';
    }

    public f(String r2, String r3, String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "itemId");
        Intrinsics.checkNotNullParameter(r4, "botId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
