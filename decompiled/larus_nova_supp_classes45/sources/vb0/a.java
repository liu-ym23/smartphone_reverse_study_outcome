package vb0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final Long a;
    public final Long b;
    public final Long c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final String g;
    public final String h;
    public final Boolean i;
    public final boolean j;

    public a() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L26;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
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
        if (this.j == r4.j) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        Long r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r11 = this.d;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        Long r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.f;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        String r21 = this.g;
        if (r21 == null) goto L29;
        int r22 = r21.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        String r24 = this.h;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        Boolean r27 = this.i;
        if (r27 == null) goto L37;
        r1 = r27.hashCode();
    L37:
        int r28 = (r26 + r1) * 31;
        boolean r29 = this.j;
        ?? r31 = r29;
        if (r29 == false) goto L41;
        r31 = 1;
    L41:
        return r28 + r31;
    L33:
        r25 = 0;
        goto L34
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSongUIState(orderSongUnReadNum=" + this.a + ", applyListenUnreadNum=" + this.b + ", applySingUnreadNum=" + this.c + ", multiChorusUnreadNum=" + this.d + ", applyUnreadNum=" + this.e + ", applyTotalNum=" + this.f + ", infoLynxUrl=" + this.g + ", highScoreSongCount=" + this.h + ", isRequestRecommendApi=" + this.i + ", isOrderSongDialogShown=" + this.j + ")";
    }

    public /* synthetic */ a(int r14) {
        this(0L, 0L, 0L, 0L, 0L, 0L, null, null, null, false);
    }

    public a(Long r1, Long r2, Long r3, Long r4, Long r5, Long r6, String r7, String r8, Boolean r9, boolean r11) {
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
    }

    public static a a(a r11, Long r12, Long r13, Long r14, Long r15, Long r16, Long r17, String r18, String r19, Boolean r21, boolean r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        Long r2 = r11.a;
    L7:
        if ((r23 & 2) == 0) goto L9;
        Long r3 = r11.b;
    L11:
        if ((r23 & 4) == 0) goto L13;
        Long r4 = r11.c;
    L15:
        if ((r23 & 8) == 0) goto L17;
        Long r5 = r11.d;
    L19:
        if ((r23 & 16) == 0) goto L21;
        Long r6 = r11.e;
    L23:
        if ((r23 & 32) == 0) goto L25;
        Long r7 = r11.f;
    L27:
        if ((r23 & 64) == 0) goto L29;
        String r8 = r11.g;
    L31:
        if ((r23 & 128) == 0) goto L33;
        String r9 = r11.h;
    L35:
        if ((r23 & 256) == 0) goto L37;
        Boolean r110 = r11.i;
    L39:
        if ((r23 & 512) == 0) goto L41;
        boolean r1 = r11.j;
    L42:
        r11.getClass();
        return new a(r2, r3, r4, r5, r6, r7, r8, r9, r110, r1);
    L41:
        r1 = r22;
        goto L42
    L37:
        r110 = r21;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }
}
