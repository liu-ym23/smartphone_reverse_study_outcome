package di8;

import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 {
    public final Integer a;
    public final String b;
    public final String c;
    public final Integer d;
    public final boolean e;
    public final Function0<View> f;

    public g0() {
        this(null, null, null, false, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r6 = (g0) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.c.hashCode()) * 31;
        Integer r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.e == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        Function0<View> r12 = this.f;
        if (r12 == null) goto L23;
        r1 = r12.hashCode();
    L23:
        return r11 + r1;
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "NestedMenuLeftModel(iconRes=" + this.a + ", iconUrl=" + this.b + ", imageName=" + this.c + ", iconSizePx=" + this.d + ", showOriginColor=" + this.e + ", customViewProvider=" + this.f + ')';
    }

    public g0(Integer r4, String r5, Integer r6, boolean r7, gi8.a r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r9 & 4) == 0) goto L11;
        String r0 = "";
    L13:
        if ((r9 & 8) == 0) goto L16;
        r6 = null;
    L16:
        if ((r9 & 16) == 0) goto L19;
        r7 = false;
    L19:
        if ((r9 & 32) == 0) goto L21;
        r8 = null;
    L21:
        Intrinsics.checkNotNullParameter(r0, "imageName");
        this.a = r4;
        this.b = r5;
        this.c = r0;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        return;
    L11:
        r0 = null;
        goto L13
    }
}
