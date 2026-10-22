package com.bytedance.android.live.broadcastgame.api.xplay;

import com.bytedance.android.live.broadcastgame.api.model.q0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l {
    public final int a;
    public final String b;
    public final String c;
    public final long d;
    public final String e;
    public final String f;
    public final int g;
    public final String h;
    public final String i;
    public final String j;
    public final boolean k;
    public final q0 l;
    public final List<Integer> m;
    public final String n;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof l) == false) goto L34;
        l r7 = (l) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
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
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r7.n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v43 */
    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        long r7 = this.d;
        int r8 = (((r4 + r6) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        String r9 = this.e;
        if (r9 == null) goto L13;
        int r11 = r9.hashCode();
    L14:
        int r12 = (r8 + r11) * 31;
        String r13 = this.f;
        if (r13 == null) goto L17;
        int r14 = r13.hashCode();
    L18:
        int r15 = (((r12 + r14) * 31) + this.g) * 31;
        String r16 = this.h;
        if (r16 == null) goto L21;
        int r17 = r16.hashCode();
    L22:
        int r18 = (r15 + r17) * 31;
        String r19 = this.i;
        if (r19 == null) goto L25;
        int r21 = r19.hashCode();
    L26:
        int r22 = (r18 + r21) * 31;
        String r23 = this.j;
        if (r23 == null) goto L29;
        int r24 = r23.hashCode();
    L30:
        int r25 = (r22 + r24) * 31;
        boolean r26 = this.k;
        ?? r27 = r26;
        if (r26 == false) goto L33;
        r27 = 1;
    L33:
        int r28 = (r25 + r27) * 31;
        q0 r29 = this.l;
        if (r29 == null) goto L36;
        int r31 = r29.hashCode();
    L37:
        int r32 = (r28 + r31) * 31;
        List<Integer> r33 = this.m;
        if (r33 == null) goto L40;
        int r34 = r33.hashCode();
    L41:
        int r35 = (r32 + r34) * 31;
        String r36 = this.n;
        if (r36 == null) goto L45;
        r2 = r36.hashCode();
    L45:
        return r35 + r2;
    L40:
        r34 = 0;
        goto L41
    L36:
        r31 = 0;
        goto L37
    L29:
        r24 = 0;
        goto L30
    L25:
        r21 = 0;
        goto L26
    L21:
        r17 = 0;
        goto L22
    L17:
        r14 = 0;
        goto L18
    L13:
        r11 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "XplayGameItem(interactId=" + this.a + ", appId=" + this.b + ", gameName=" + this.c + ", gameId=" + this.d + ", gameIconUrl=" + this.e + ", schema=" + this.f + ", businessType=" + this.g + ", developer=" + this.h + ", version=" + this.i + ", unityVersion=" + this.j + ", isDebugUnity=" + this.k + ", xplayInfo=" + this.l + ", supportLiveScene=" + this.m + ", playRule=" + this.n + ")";
    }

    public l(int r12, String r13, String r14, long r15, String r17, String r18, int r19, String r21, String r22, String r23, boolean r24, q0 r25, List<Integer> r26, String r27) {
        Intrinsics.checkNotNullParameter(r13, "appId");
        Intrinsics.checkNotNullParameter(r14, "gameName");
        Intrinsics.checkNotNullParameter(r17, "gameIconUrl");
        Intrinsics.checkNotNullParameter(r18, "schema");
        Intrinsics.checkNotNullParameter(r21, "developer");
        Intrinsics.checkNotNullParameter(r22, "version");
        Intrinsics.checkNotNullParameter(r23, "unityVersion");
        Intrinsics.checkNotNullParameter(r26, "supportLiveScene");
        Intrinsics.checkNotNullParameter(r27, "playRule");
        this.a = r12;
        this.b = r13;
        this.c = r14;
        this.d = r15;
        this.e = r17;
        this.f = r18;
        this.g = r19;
        this.h = r21;
        this.i = r22;
        this.j = r23;
        this.k = r24;
        this.l = r25;
        this.m = r26;
        this.n = r27;
    }
}
