package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final boolean a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final Long j;
    public final int k;
    public final boolean l;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L30;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r4.k) goto L28;
        return false;
    L28:
        if (this.l == r4.l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
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
        String r4 = this.b;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        String r8 = this.c;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r11 = (r7 + r9) * 31;
        String r12 = this.d;
        if (r12 == null) goto L16;
        int r13 = r12.hashCode();
    L17:
        int r14 = (r11 + r13) * 31;
        String r15 = this.e;
        if (r15 == null) goto L20;
        int r16 = r15.hashCode();
    L21:
        int r17 = (r14 + r16) * 31;
        String r18 = this.f;
        if (r18 == null) goto L24;
        int r19 = r18.hashCode();
    L25:
        int r21 = (r17 + r19) * 31;
        String r22 = this.g;
        if (r22 == null) goto L28;
        int r23 = r22.hashCode();
    L29:
        int r24 = (r21 + r23) * 31;
        String r25 = this.h;
        if (r25 == null) goto L32;
        int r26 = r25.hashCode();
    L33:
        int r27 = (r24 + r26) * 31;
        String r28 = this.i;
        if (r28 == null) goto L36;
        int r29 = r28.hashCode();
    L37:
        int r31 = (r27 + r29) * 31;
        Long r32 = this.j;
        if (r32 == null) goto L40;
        r5 = r32.hashCode();
    L40:
        int r33 = (((r31 + r5) * 31) + this.k) * 31;
        boolean r34 = this.l;
        if (r34 == true) goto L45;
        r1 = r34;
    L45:
        return r33 + r1;
    L36:
        r29 = 0;
        goto L37
    L32:
        r26 = 0;
        goto L33
    L28:
        r23 = 0;
        goto L29
    L24:
        r19 = 0;
        goto L25
    L20:
        r16 = 0;
        goto L21
    L16:
        r13 = 0;
        goto L17
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "GameIntroCardInfo(show=" + this.a + ", icon=" + this.b + ", backImage=" + this.c + ", appName=" + this.d + ", title=" + this.e + ", description=" + this.f + ", btnText=" + this.g + ", backColor=" + this.h + ", url=" + this.i + ", duration=" + this.j + ", manualCloseTime=" + this.k + ", autoLaunch=" + this.l + ")";
    }

    public static a a(a r17, String r18, String r19, String r21, int r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        boolean r5 = r17.a;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r6 = r17.b;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r7 = r17.c;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r8 = r17.d;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r9 = r17.e;
    L23:
        if ((r23 & 32) == 0) goto L25;
        String r11 = r17.f;
    L27:
        if ((r23 & 64) == 0) goto L29;
        String r12 = r17.g;
    L31:
        if ((r23 & 128) == 0) goto L33;
        String r13 = r17.h;
    L35:
        if ((r23 & 256) == 0) goto L37;
        String r14 = r17.i;
    L39:
        if ((r23 & 512) == 0) goto L41;
        Long r15 = r17.j;
    L43:
        if ((r23 & RomUtils.SZ) == 0) goto L45;
        int r16 = r17.k;
    L47:
        if ((r23 & 2048) == 0) goto L49;
        boolean r110 = r17.l;
    L50:
        r17.getClass();
        return new a(r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r110);
    L49:
        r110 = false;
        goto L50
    L45:
        r16 = r22;
        goto L47
    L41:
        r15 = null;
        goto L43
    L37:
        r14 = r21;
        goto L39
    L33:
        r13 = null;
        goto L35
    L29:
        r12 = null;
        goto L31
    L25:
        r11 = null;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = r18;
        goto L11
    L5:
        r5 = false;
        goto L7
    }

    public a(boolean r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, Long r11, int r12, boolean r13) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
