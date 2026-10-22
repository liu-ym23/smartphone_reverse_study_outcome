package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t1 {
    public final String a;
    public final Long b;
    public final Integer c;
    public final k0 d;
    public final boolean e;
    public boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t1) == true) goto L8;
        return false;
    L8:
        t1 r6 = (t1) r5;
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
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
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
        int r8 = (((r6 + r1) * 31) + this.d.hashCode()) * 31;
        int r9 = 1231;
        if (this.e == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r8 + r10) * 31;
        if (this.f == true) goto L23;
        r9 = 1237;
    L23:
        return r11 + r9;
    L17:
        r10 = 1237;
        goto L18
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PendingCollaboratedSubscribeRestore(actionBarKey=" + this.a + ", itemId=" + this.b + ", parentInstructionType=" + this.c + ", request=" + this.d + ", reopenPanel=" + this.e + ", readyToApply=" + this.f + ')';
    }

    public final boolean a(com.larus.bmhome.actionbar.model.z0 r9, Integer r10) {
        if (Intrinsics.areEqual(this.c, r10) == true) goto L5;
        return false;
    L5:
        String r11 = this.a;
        Long r1 = null;
        String r2 = null;
        if (r11 != null) goto L8;
    L16:
        Long r12 = this.b;
        if (r12 != null) goto L19;
    L34:
        if (r9 == null) goto L47;
        com.larus.bmhome.actionbar.model.r r13 = r9.q;
        if (r13 == null) goto L48;
        Integer r14 = r13.a;
        if (r14 != null) goto L41;
        return false;
    L41:
        if (r14.intValue() != 28) goto L49;
        return true;
    L49:
        return false;
    L48:
        return false;
    L47:
        return false;
    L19:
        if (r12.longValue() <= 0) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == false) goto L24;
        r1 = r12;
    L24:
        if (r1 == null) goto L34;
        long r4 = r1.longValue();
        if (r9 == null) goto L44;
        Long r15 = r9.a;
        if (r15 != null) goto L31;
        return false;
    L31:
        if (r15.longValue() != r4) goto L45;
        return true;
    L45:
        return false;
    L44:
        return false;
    L21:
        r3 = false;
        goto L22
    L8:
        if ((!StringsKt.isBlank(r11)) == true) goto L11;
        r11 = null;
    L11:
        if (r11 == null) goto L16;
        if (r9 == null) goto L15;
        r2 = r9.b;
    L15:
        return Intrinsics.areEqual(r2, r11);
    }

    public t1(String r2, Long r3, Integer r4, k0 r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "request");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = false;
    }
}
