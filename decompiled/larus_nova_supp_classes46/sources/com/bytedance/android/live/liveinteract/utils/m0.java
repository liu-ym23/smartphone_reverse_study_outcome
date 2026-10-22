package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m0 {
    public final String a;
    public final int b;
    public final boolean c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final String g;
    public final IRoom h;
    public final String i;
    public final Long j;
    public final String k;
    public final String l;
    public final Long m;
    public final String n;
    public final Map<String, String> o;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m0) == false) goto L36;
        m0 r4 = (m0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
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
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r4.o) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        boolean r4 = this.c;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        boolean r11 = this.e;
        ?? r12 = r11;
        if (r11 == false) goto L16;
        r12 = 1;
    L16:
        int r13 = (r10 + r12) * 31;
        boolean r14 = this.f;
        if (r14 == true) goto L20;
        r5 = r14;
    L20:
        int r15 = (r13 + r5) * 31;
        String r16 = this.g;
        if (r16 == null) goto L23;
        int r17 = r16.hashCode();
    L24:
        int r18 = (r15 + r17) * 31;
        IRoom r19 = this.h;
        if (r19 == null) goto L27;
        int r20 = r19.hashCode();
    L28:
        int r21 = (r18 + r20) * 31;
        String r22 = this.i;
        if (r22 == null) goto L31;
        int r23 = r22.hashCode();
    L32:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.j;
        if (r25 == null) goto L35;
        int r26 = r25.hashCode();
    L36:
        int r27 = (r24 + r26) * 31;
        String r28 = this.k;
        if (r28 == null) goto L39;
        int r29 = r28.hashCode();
    L40:
        int r30 = (r27 + r29) * 31;
        String r31 = this.l;
        if (r31 == null) goto L43;
        int r32 = r31.hashCode();
    L44:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.m;
        if (r34 == null) goto L47;
        int r35 = r34.hashCode();
    L48:
        int r36 = (r33 + r35) * 31;
        String r37 = this.n;
        if (r37 == null) goto L51;
        int r38 = r37.hashCode();
    L52:
        int r39 = (r36 + r38) * 31;
        Map<String, String> r40 = this.o;
        if (r40 == null) goto L56;
        r1 = r40.hashCode();
    L56:
        return r39 + r1;
    L51:
        r38 = 0;
        goto L52
    L47:
        r35 = 0;
        goto L48
    L43:
        r32 = 0;
        goto L44
    L39:
        r29 = 0;
        goto L40
    L35:
        r26 = 0;
        goto L36
    L31:
        r23 = 0;
        goto L32
    L27:
        r20 = 0;
        goto L28
    L23:
        r17 = 0;
        goto L24
    L12:
        r9 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LogParamsWithPk(connectionType=" + this.a + ", applySource=" + this.b + ", isAutoJoin=" + this.c + ", linkCnt=" + this.d + ", isFollowApply=" + this.e + ", isCameraOpen=" + this.f + ", isQuickInvite=" + this.g + ", room=" + this.h + ", functionType=" + this.i + ", waitTime=" + this.j + ", overType=" + this.k + ", breakPage=" + this.l + ", connectionDuration=" + this.m + ", cameraDuration=" + this.n + ", logMap=" + this.o + ")";
    }

    public /* synthetic */ m0(String r20, int r21, boolean r22, String r23, boolean r24, boolean r25, String r26, IRoom r27, String r28, Long r29, Map r30, int r31) {
        if ((r31 & 256) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r31 & 512) == 0) goto L9;
        Long r13 = null;
    L11:
        if ((r31 & 1024) == 0) goto L13;
        String r14 = "";
    L15:
        if ((r31 & 2048) == 0) goto L17;
        String r15 = "";
    L19:
        if ((r31 & 4096) == 0) goto L21;
        Long r16 = 0L;
    L23:
        if ((r31 & 16384) == 0) goto L25;
        Map r18 = null;
    L26:
        this(r20, r21, r22, r23, r24, r25, r26, r27, r12, r13, r14, r15, r16, null, r18);
        return;
    L25:
        r18 = r30;
        goto L26
    L21:
        r16 = null;
        goto L23
    L17:
        r15 = null;
        goto L19
    L13:
        r14 = null;
        goto L15
    L9:
        r13 = r29;
        goto L11
    L5:
        r12 = r28;
        goto L7
    }

    public m0(String r5, int r6, boolean r7, String r8, boolean r9, boolean r10, String r11, IRoom r12, String r13, Long r14, String r15, String r16, Long r17, String r18, Map<String, String> r19) {
        Intrinsics.checkNotNullParameter(r8, "linkCnt");
        Intrinsics.checkNotNullParameter(r11, "isQuickInvite");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r16;
        this.m = r17;
        this.n = r18;
        this.o = r19;
    }
}
