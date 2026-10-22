package com.obric.assistant.settings.memory;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class y {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final ObricReferenceMemorySwitchGroup f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r6 = (y) r5;
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
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
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
        return ((r3 + r2) * 31) + this.f.hashCode();
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricReferenceMemoryRow(id=" + this.a + ", title=" + this.b + ", subtitle=" + this.c + ", checked=" + this.d + ", enabled=" + this.e + ", group=" + this.f + ')';
    }

    public y(String r2, String r3, String r4, boolean r5, boolean r6, ObricReferenceMemorySwitchGroup r7) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "subtitle");
        Intrinsics.checkNotNullParameter(r7, "group");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
