package com.bytedance.android.live.broadcastgame;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z extends e10.a.C0226a {
    public static final a k = null;
    public final DataCenter a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof z) == false) goto L26;
        z r4 = (z) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
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
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L24;
        return false;
    L24:
        if (this.j == r4.j) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        DataCenter r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = ((r1 * 31) + this.b) * 31;
        boolean r3 = this.c;
        ?? r4 = 1;
        ?? r5 = r3;
        if (r3 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r2 + r5) * 31;
        boolean r7 = this.d;
        ?? r8 = r7;
        if (r7 == false) goto L12;
        r8 = 1;
    L12:
        int r9 = (((r6 + r8) * 31) + this.e) * 31;
        boolean r11 = this.f;
        ?? r12 = r11;
        if (r11 == false) goto L15;
        r12 = 1;
    L15:
        int r13 = (r9 + r12) * 31;
        boolean r14 = this.g;
        ?? r15 = r14;
        if (r14 == false) goto L18;
        r15 = 1;
    L18:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.h;
        if (r17 == true) goto L23;
        r4 = r17;
    L23:
        return ((((r16 + r4) * 31) + this.i) * 31) + this.j;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "SceneFilterContext(dataCenter=" + this.a + ", linkState=" + this.b + ", inPk=" + this.c + ", inMultiAnchorLink=" + this.d + ", anchorLinkNum=" + this.e + ", inAudienceLink=" + this.f + ", haveAudienceRealLinked=" + this.g + ", inMultiMode=" + this.h + ", interactScene=" + this.i + ", supportLiveMode=" + this.j + ")";
    }

    static {
        k = new a();
    }

    public z(DataCenter r2, int r3, boolean r4, boolean r5, int r6, boolean r7, boolean r8, boolean r9, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r11;
        this.j = r12;
    }
}
