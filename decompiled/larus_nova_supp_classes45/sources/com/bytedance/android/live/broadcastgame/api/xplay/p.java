package com.bytedance.android.live.broadcastgame.api.xplay;

import android.content.Context;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p {
    public final Context a;
    public final long b;
    public final String c;
    public final boolean d;
    public final String e;
    public final XplayScene f;
    public final String g;
    public final l h;
    public final DataCenter i;
    public s j;
    public final j k;
    public final boolean l;
    public final boolean m;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof p) == false) goto L32;
        p r7 = (p) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
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
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
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
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L28;
        return false;
    L28:
        if (this.l == r7.l) goto L30;
        return false;
    L30:
        if (this.m == r7.m) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        Context r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        boolean r8 = this.d;
        ?? r9 = 1;
        ?? r11 = r8;
        if (r8 == false) goto L13;
        r11 = 1;
    L13:
        int r12 = (r7 + r11) * 31;
        String r13 = this.e;
        if (r13 == null) goto L16;
        int r14 = r13.hashCode();
    L17:
        int r15 = (r12 + r14) * 31;
        XplayScene r16 = this.f;
        if (r16 == null) goto L20;
        int r17 = r16.hashCode();
    L21:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 == null) goto L24;
        int r21 = r19.hashCode();
    L25:
        int r22 = (r18 + r21) * 31;
        l r23 = this.h;
        if (r23 == null) goto L28;
        int r24 = r23.hashCode();
    L29:
        int r25 = (r22 + r24) * 31;
        DataCenter r26 = this.i;
        if (r26 == null) goto L32;
        int r27 = r26.hashCode();
    L33:
        int r28 = (r25 + r27) * 31;
        s r29 = this.j;
        if (r29 == null) goto L36;
        int r31 = r29.hashCode();
    L37:
        int r32 = (r28 + r31) * 31;
        j r33 = this.k;
        if (r33 == null) goto L40;
        r1 = r33.hashCode();
    L40:
        int r34 = (r32 + r1) * 31;
        boolean r35 = this.l;
        ?? r36 = r35;
        if (r35 == false) goto L43;
        r36 = 1;
    L43:
        int r37 = (r34 + r36) * 31;
        boolean r38 = this.m;
        if (r38 == true) goto L48;
        r9 = r38;
    L48:
        return r37 + r9;
    L36:
        r31 = 0;
        goto L37
    L32:
        r27 = 0;
        goto L33
    L28:
        r24 = 0;
        goto L29
    L24:
        r21 = 0;
        goto L25
    L20:
        r17 = 0;
        goto L21
    L16:
        r14 = 0;
        goto L17
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "XplayNewEnv(context=" + this.a + ", roomId=" + this.b + ", roomOwnerUserId=" + this.c + ", isAnchor=" + this.d + ", userId=" + this.e + ", scene=" + this.f + ", openId=" + this.g + ", xplayGameItem=" + this.h + ", dataCenter=" + this.i + ", startExtra=" + this.j + ", alogExtra=" + this.k + ", showSeiDelay=" + this.l + ", isSwitchGame=" + this.m + ")";
    }

    public final Context getContext() {
        return this.a;
    }

    public p(Context r15, long r16, String r18, boolean r19, String r21, XplayScene r22, String r23, l r24, DataCenter r25, s r26, j r27, boolean r28, boolean r29, int r210) {
        if ((r210 & 64) == 0) goto L5;
        String r7 = "";
    L6:
        j r9 = null;
        if ((r210 & 512) == 0) goto L9;
        s r8 = null;
    L11:
        if ((r210 & RomUtils.SZ) != 0) goto L14;
        r9 = r27;
    L14:
        boolean r11 = false;
        if ((r210 & 2048) == 0) goto L17;
        boolean r12 = false;
    L19:
        if ((r210 & 4096) != 0) goto L22;
        r11 = r29;
    L22:
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r18, "roomOwnerUserId");
        Intrinsics.checkNotNullParameter(r21, "userId");
        Intrinsics.checkNotNullParameter(r22, "scene");
        Intrinsics.checkNotNullParameter(r24, "xplayGameItem");
        this.a = r15;
        this.b = r16;
        this.c = r18;
        this.d = r19;
        this.e = r21;
        this.f = r22;
        this.g = r7;
        this.h = r24;
        this.i = r25;
        this.j = r8;
        this.k = r9;
        this.l = r12;
        this.m = r11;
        return;
    L17:
        r12 = r28;
        goto L19
    L9:
        r8 = r26;
        goto L11
    L5:
        r7 = r23;
        goto L6
    }
}
