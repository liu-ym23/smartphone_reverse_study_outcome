package com.bytedance.badger.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z {
    public final boolean a;
    public final boolean b;

    public z(boolean r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
    L18:
        return true;
    L5:
        if ((r5 instanceof z) == false) goto L17;
        z r6 = (z) r5;
        if (this.a != r6.a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L17;
        if (this.b != r6.b) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L17;
    L14:
        r7 = false;
        goto L15
    L9:
        r1 = false;
    L17:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        if (r4 == true) goto L10;
        r1 = r4;
    L10:
        return r3 + r1;
    }

    public final String toString() {
        return "DeviceSupportInfo(isSupportProvider=" + this.a + ", isSupportService=" + this.b + ")";
    }
}
