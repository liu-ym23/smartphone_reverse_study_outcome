package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import com.bytedance.android.live.broadcastgame.api.xplay.LittleWindowPos;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public final LittleWindowPos a;
    public final boolean b;
    public final boolean c;
    public final float d;
    public final float e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L16;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Float.compare(this.d, r4.d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.e, r4.e) == 0) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        LittleWindowPos r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.b;
        ?? r4 = 1;
        ?? r5 = r3;
        if (r3 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r2 + r5) * 31;
        boolean r7 = this.c;
        if (r7 == true) goto L14;
        r4 = r7;
    L14:
        return ((((r6 + r4) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e);
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "LittleWindowState(position=" + this.a + ", small=" + this.b + ", isCustom=" + this.c + ", x=" + this.d + ", y=" + this.e + ")";
    }

    public /* synthetic */ g(LittleWindowPos r7, boolean r8) {
        this(r7, r8, false, 0.0f, 0.0f);
    }

    public static g a(g r6, LittleWindowPos r7, boolean r8, int r9) {
        if ((r9 & 1) == 0) goto L5;
        r7 = r6.a;
    L5:
        LittleWindowPos r1 = r7;
        if ((r9 & 2) == 0) goto L8;
        r8 = r6.b;
    L8:
        boolean r2 = r8;
        if ((r9 & 4) == 0) goto L11;
        boolean r3 = r6.c;
    L13:
        if ((r9 & 8) == 0) goto L15;
        float r4 = r6.d;
    L17:
        if ((r9 & 16) == 0) goto L19;
        float r5 = r6.e;
    L20:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "position");
        return new g(r1, r2, r3, r4, r5);
    L19:
        r5 = 0.0f;
        goto L20
    L15:
        r4 = 0.0f;
        goto L17
    L11:
        r3 = false;
        goto L13
    }

    public g(LittleWindowPos r2, boolean r3, boolean r4, float r5, float r6) {
        Intrinsics.checkNotNullParameter(r2, "position");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
