package com.larus.business.arc.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t {
    public final boolean a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final s g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
        if (this.a == r6.a) goto L12;
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
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
        String r2 = this.c;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        String r6 = this.d;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        String r9 = this.e;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        String r12 = this.f;
        if (r12 == null) goto L23;
        r3 = r12.hashCode();
    L23:
        return ((r11 + r3) * 31) + this.g.hashCode();
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ArcResponseParts(ok=" + this.a + ", command=" + this.b + ", code=" + this.c + ", error=" + this.d + ", group=" + this.e + ", tool=" + this.f + ", body=" + this.g + ')';
    }

    public t(String r3, String r4, String r5) {
        s.c r0 = s.c.a;
        Intrinsics.checkNotNullParameter(r3, "command");
        Intrinsics.checkNotNullParameter(r0, "body");
        this.a = false;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = null;
        this.f = null;
        this.g = r0;
    }
}
