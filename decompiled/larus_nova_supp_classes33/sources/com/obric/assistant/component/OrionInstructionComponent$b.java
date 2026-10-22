package com.obric.assistant.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class OrionInstructionComponent$b {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final Integer e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OrionInstructionComponent$b) == true) goto L8;
        return false;
    L8:
        OrionInstructionComponent$b r6 = (OrionInstructionComponent$b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        Integer r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "RightIconConfig(iconId=" + this.a + ", iconRes=" + this.b + ", marginStart=" + this.c + ", marginEnd=" + this.d + ", iconColor=" + this.e + ')';
    }

    public OrionInstructionComponent$b(int r2, int r3) {
        this.a = 2131381183;
        this.b = 2131244367;
        this.c = r2;
        this.d = r3;
        this.e = null;
    }
}
