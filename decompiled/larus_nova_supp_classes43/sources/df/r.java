package df;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r {
    public final String a;
    public final String b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof r) == false) goto L10;
        r r11 = (r) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPRequired(promotionId=" + this.a + ", enterFrom=" + this.b + ")";
    }

    public r(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "promotionId");
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        this.a = r10;
        this.b = r11;
    }
}
