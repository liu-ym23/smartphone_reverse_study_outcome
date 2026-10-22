package com.larus.dora.obric.device_management.setting.g;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r {
    public final String a;
    public final DoraObricGSettingsAction b;
    public final String c;
    public final boolean d;
    public final boolean e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        int r4 = 1231;
        if (this.d == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.e == true) goto L15;
        r4 = 1237;
    L15:
        return r6 + r4;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraObricGSettingsItem(title=" + this.a + ", action=" + this.b + ", endText=" + this.c + ", showRedDot=" + this.d + ", showArrow=" + this.e + ')';
    }

    public r(String r3, DoraObricGSettingsAction r4, String r5, boolean r6, int r7) {
        if ((r7 & 4) == 0) goto L5;
        r5 = null;
    L5:
        boolean r1 = false;
        if ((r7 & 8) == 0) goto L9;
        r6 = false;
    L9:
        if ((r7 & 16) == 0) goto L11;
        r1 = true;
    L11:
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "action");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r1;
    }
}
