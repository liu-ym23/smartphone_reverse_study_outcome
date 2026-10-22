package com.bytedance.android.live.effect.common;

import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final boolean e;

    public d() {
        this(false, 31);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L16;
        d r4 = (d) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        boolean r1 = this.d;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.e;
        if (r5 == true) goto L10;
        r2 = r5;
    L10:
        return r4 + r2;
    }

    public final String toString() {
        return "AdjustBarStyleConfig(barColor=" + this.a + ", bgColor=" + this.b + ", circleColor=" + this.c + ", enableTitle=" + this.d + ", enableSingeAdjust=" + this.e + ")";
    }

    public d(boolean r5, int r6) {
        if ((r6 & 1) == 0) goto L5;
        int r0 = s1.h(2131107419);
    L7:
        if ((r6 & 2) == 0) goto L9;
        int r2 = s1.h(2131107403);
    L11:
        if ((r6 & 4) == 0) goto L13;
        int r3 = s1.h(2131107402);
    L15:
        if ((r6 & 8) == 0) goto L17;
        r5 = false;
    L17:
        this.a = r0;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = false;
        return;
    L13:
        r3 = 0;
        goto L15
    L9:
        r2 = 0;
        goto L11
    L5:
        r0 = 0;
        goto L7
    }
}
