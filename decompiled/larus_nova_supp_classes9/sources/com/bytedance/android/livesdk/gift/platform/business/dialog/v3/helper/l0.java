package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l0 {
    public final boolean a;
    public final int b;
    public final int c;
    public final vz1.e d;
    public final int e;
    public final int f;

    public l0() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l0) == false) goto L18;
        l0 r4 = (l0) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((((r1 * 31) + this.b) * 31) + this.c) * 31;
        vz1.e r3 = this.d;
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L10:
        return ((((r2 + r4) * 31) + this.e) * 31) + this.f;
    L8:
        r4 = 0;
        goto L10
    }

    public final String toString() {
        return "SaveSelectedStatus(needSelect=" + this.a + ", pagePos=" + this.b + ", pos=" + this.c + ", dialogIconModel=" + this.d + ", pageType=" + this.e + ", counterPosition=" + this.f + ")";
    }

    public /* synthetic */ l0(int r8) {
        this(false, -1, -1, null, 0, -1);
    }

    public l0(boolean r1, int r2, int r3, vz1.e r4, int r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
