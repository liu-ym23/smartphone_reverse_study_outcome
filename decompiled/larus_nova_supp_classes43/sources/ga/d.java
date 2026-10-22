package ga;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final String a;
    public final boolean b;
    public final String c;
    public final float d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r11.d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r10 = (r0 + r1) * 31;
        String r11 = this.c;
        if (r11 != null) goto L9;
        int r12 = 0;
    L11:
        return ((r10 + r12) * 31) + Float.floatToIntBits(this.d);
    L9:
        r12 = r11.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskConfig(businessName=" + this.a + ", sync=" + this.b + ", entrance=" + this.c + ", pendingTimeout=" + this.d + ')';
    }

    public d() {
        Intrinsics.checkNotNullParameter("caijing_half_blank_detection", "businessName");
        this.a = "caijing_half_blank_detection";
        this.b = false;
        this.c = null;
        this.d = 5.0f;
    }
}
