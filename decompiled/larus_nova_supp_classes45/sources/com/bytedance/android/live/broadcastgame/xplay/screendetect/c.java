package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final boolean a;
    public final long b;
    public final String c;
    public final long d;
    public final String e;
    public final String f;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L18;
        c r7 = (c) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L28;
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
        long r2 = this.b;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        String r4 = this.c;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        long r7 = this.d;
        int r8 = (((r3 + r6) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        String r9 = this.e;
        if (r9 == null) goto L12;
        int r11 = r9.hashCode();
    L13:
        int r12 = (r8 + r11) * 31;
        String r13 = this.f;
        if (r13 == null) goto L17;
        r5 = r13.hashCode();
    L17:
        return r12 + r5;
    L12:
        r11 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "ScreenDetectorParams(isAnchor=" + this.a + ", roomId=" + this.b + ", anchorId=" + this.c + ", gameId=" + this.d + ", appId=" + this.e + ", gameName=" + this.f + ")";
    }

    public c(boolean r2, long r3, String r5, long r6, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        Intrinsics.checkNotNullParameter(r8, "appId");
        Intrinsics.checkNotNullParameter(r9, "gameName");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r8;
        this.f = r9;
    }
}
