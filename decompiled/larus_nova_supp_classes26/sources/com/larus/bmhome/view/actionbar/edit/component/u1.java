package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u1 {
    public final String a;
    public final Long b;
    public final Integer c;
    public final int d;
    public final long e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof u1) == true) goto L8;
        return false;
    L8:
        u1 r9 = (u1) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        int r8 = (((r6 + r1) * 31) + this.d) * 31;
        long r9 = this.e;
        return r8 + ((int) (r9 ^ (r9 >>> 32)));
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PendingDropdownSubscribeRestore(actionBarKey=" + this.a + ", itemId=" + this.b + ", instructionItemId=" + this.c + ", dropdownBoxId=" + this.d + ", optionId=" + this.e + ')';
    }

    public u1(String r1, Long r2, Integer r3, int r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
