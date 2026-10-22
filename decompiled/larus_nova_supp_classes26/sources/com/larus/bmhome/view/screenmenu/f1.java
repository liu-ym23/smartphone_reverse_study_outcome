package com.larus.bmhome.view.screenmenu;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f1 implements ot8.a {
    public final int a;
    public final boolean b;
    public final String c;
    public final String d;
    public final Integer e;
    public final Integer f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final Function1<Boolean, Unit> k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f1) == true) goto L8;
        return false;
    L8:
        f1 r6 = (f1) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        String r4 = this.c;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        if (this.g == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r16 + r17) * 31;
        if (this.h == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        if (this.i == false) goto L33;
        int r21 = 1231;
    L34:
        int r22 = (r20 + r21) * 31;
        if (this.j == true) goto L38;
        r2 = 1237;
    L38:
        int r23 = (r22 + r2) * 31;
        Function1<Boolean, Unit> r24 = this.k;
        if (r24 == null) goto L43;
        r5 = r24.hashCode();
    L43:
        return r23 + r5;
    L33:
        r21 = 1237;
        goto L34
    L29:
        r19 = 1237;
        goto L30
    L25:
        r17 = 1237;
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "SwitchMenu(id=" + this.a + ", removeAroundDivider=" + this.b + ", textString=" + this.c + ", iconUrl=" + this.d + ", textIcon=" + this.e + ", textColor=" + this.f + ", isSelected=" + this.g + ", forbiddenDismissAfterClick=" + this.h + ", switchStatus=" + this.i + ", disableClick=" + this.j + ", onTap=" + this.k + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.b;
    }

    @Override // ot8.a
    public final int getId() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f1(int r1, boolean r2, String r3, String r4, Integer r5, Integer r6, boolean r7, boolean r8, boolean r9, boolean r10, Function1<? super Boolean, Unit> r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
