package cy8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v {
    public final Long a;
    public final Long b;
    public final Integer c;
    public final Integer d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final Long i;
    public final List<l> j;
    public final j k;
    public final String l;
    public final String m;
    public final List<j> n;

    public v() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r6 = (v) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        List<l> r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        j r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        List<j> r40 = this.n;
        if (r40 == null) goto L59;
        r1 = r40.hashCode();
    L59:
        return r39 + r1;
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasSSERequestBody(canvasId=" + this.a + ", canvasSubId=" + this.b + ", canvasType=" + this.c + ", generateType=" + this.d + ", localId=" + this.e + ", sendMsgId=" + this.f + ", replyMsgId=" + this.g + ", conversationId=" + this.h + ", seqStart=" + this.i + ", instructionTab=" + this.j + ", originImage=" + this.k + ", prompt=" + this.l + ", displayPromptPerRound=" + this.m + ", refImages=" + this.n + ')';
    }

    public /* synthetic */ v(Long r19, Long r20, Integer r21, Integer r22, String r23, String r24, String r25, String r26, List r27, j r28, String r29, String r30, List r31, int r32) {
        if ((r32 & 1) == 0) goto L5;
        Long r4 = null;
    L7:
        if ((r32 & 2) == 0) goto L9;
        Long r5 = null;
    L11:
        if ((r32 & 4) == 0) goto L13;
        Integer r6 = null;
    L15:
        if ((r32 & 8) == 0) goto L17;
        Integer r7 = null;
    L19:
        if ((r32 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r32 & 32) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r32 & 64) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r11 = null;
    L35:
        if ((r32 & 512) == 0) goto L37;
        List r13 = null;
    L39:
        if ((r32 & 1024) == 0) goto L41;
        j r14 = null;
    L43:
        if ((r32 & 2048) == 0) goto L45;
        String r15 = null;
    L47:
        if ((r32 & 4096) == 0) goto L49;
        String r16 = null;
    L51:
        if ((r32 & 8192) == 0) goto L53;
        List r17 = null;
    L54:
        this(r4, r5, r6, r7, r8, r9, r10, r11, null, r13, r14, r15, r16, r17);
        return;
    L53:
        r17 = r31;
        goto L54
    L49:
        r16 = r30;
        goto L51
    L45:
        r15 = r29;
        goto L47
    L41:
        r14 = r28;
        goto L43
    L37:
        r13 = r27;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L29:
        r10 = r25;
        goto L31
    L25:
        r9 = r24;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public v(Long r1, Long r2, Integer r3, Integer r4, String r5, String r6, String r7, String r8, Long r9, List<l> r10, j r11, String r12, String r13, List<j> r14) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }
}
