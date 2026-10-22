package com.bytedance.android.livesdk.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public final boolean a;
    public final int b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L10;
        e r4 = (e) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (r1 * 31) + this.b;
    }

    public final String toString() {
        return "BottomCardEvent(isShow=" + this.a + ", height=" + this.b + ")";
    }

    public e(boolean r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
