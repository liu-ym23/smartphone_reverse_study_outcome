package com.bytedance.android.livesdk.chatroom.ui.framework;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o {
    public final boolean a;
    public final boolean b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof o) == false) goto L10;
        o r4 = (o) r3;
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
        return "ReloadEvent(streamStyleChanged=" + this.a + ", changeCameraInOneGroup=" + this.b + ")";
    }

    public o(boolean r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
