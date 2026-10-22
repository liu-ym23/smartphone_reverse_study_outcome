package com.bytedance.ai.applet.grantingV2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final FlowResult a;
    public final String b;
    public final String c;
    public final u2.a d;
    public final u2.f e;

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
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.c;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        u2.a r16 = this.d;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        u2.f r19 = this.e;
        if (r19 == null) goto L19;
        r10 = r19.hashCode();
    L19:
        return r18 + r10;
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionHandleResult(flowResult=" + this.a + ", toastType=" + this.b + ", toastMessage=" + this.c + ", cardData=" + this.d + ", item=" + this.e + ')';
    }

    public /* synthetic */ a(FlowResult r10, u2.a r11, u2.f r12) {
        this(r10, null, null, r11, r12);
    }

    public a(FlowResult r10, String r11, String r12, u2.a r13, u2.f r14) {
        Intrinsics.checkNotNullParameter(r10, "flowResult");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
