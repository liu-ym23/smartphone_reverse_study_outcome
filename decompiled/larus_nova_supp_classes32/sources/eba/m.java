package eba;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m {
    public final int a;
    public final int b;
    public final int c;
    public final jba.b d;
    public final String e;
    public final Integer f;
    public final jba.f g;
    public final jba.a h;
    public final int i;
    public final String j;
    public final jba.c k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        Integer r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        jba.f r5 = this.g;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((((((r4 + r2) * 31) + this.h.hashCode()) * 31) + this.i) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricListeningChildWindowGeometryTrace(displayWidth=" + this.a + ", displayHeight=" + this.b + ", orientation=" + this.c + ", cutoutInsets=" + this.d + ", cutoutSource=" + this.e + ", navigationMode=" + this.f + ", navigationBarInsetsSnapshot=" + this.g + ", consumedNavigationBarInsets=" + this.h + ", edgeMarginPx=" + this.i + ", windowInsetsSource=" + this.j + ", systemCornerRadii=" + this.k + ')';
    }

    public final String a() {
        return "display=" + this.a + 'x' + this.b + " orientation=" + this.c + " cutout=" + this.d + " cutoutSource=" + this.e + " navMode=" + this.f + " navSnapshot=" + this.g + " consumedNav=" + this.h + " edgeMarginPx=" + this.i + " windowInsetsSource=" + this.j + " systemRadii=" + this.k;
    }

    public m(int r2, int r3, int r4, jba.b r5, String r6, Integer r7, jba.f r8, jba.a r9, int r10, String r11, jba.c r12) {
        Intrinsics.checkNotNullParameter(r5, "cutoutInsets");
        Intrinsics.checkNotNullParameter(r6, "cutoutSource");
        Intrinsics.checkNotNullParameter(r9, "consumedNavigationBarInsets");
        Intrinsics.checkNotNullParameter(r11, "windowInsetsSource");
        Intrinsics.checkNotNullParameter(r12, "systemCornerRadii");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }
}
