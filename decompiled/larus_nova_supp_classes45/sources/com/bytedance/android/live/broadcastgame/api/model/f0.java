package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 {
    public final String a;
    public final ReloadPanelType b;
    public final boolean c;
    public final boolean d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f0) == false) goto L14;
        f0 r4 = (f0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ReloadPanelType r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.c;
        ?? r7 = 1;
        ?? r8 = r6;
        if (r6 == false) goto L12;
        r8 = 1;
    L12:
        int r9 = (r5 + r8) * 31;
        boolean r11 = this.d;
        if (r11 == true) goto L17;
        r7 = r11;
    L17:
        return r9 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "id:" + this.a + " reload:" + this.b + " addRecentUsed:" + this.c + " runningState:" + this.d;
    }

    public f0(String r3, ReloadPanelType r4, boolean r5, boolean r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = ReloadPanelType.NOT_RELOAD;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = false;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = false;
    L11:
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "reloadPanel");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
