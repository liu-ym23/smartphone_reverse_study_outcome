package kw9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Integer f;
    public final String g;
    public final String h;
    public final String i;
    public final Integer j;
    public final boolean k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;

    public h() {
        this(null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 1048575);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
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
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (((((r18 + r20) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        Integer r22 = this.j;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        if (this.k == false) goto L37;
        int r25 = 1231;
    L38:
        int r26 = (((((((((((((r24 + r25) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31) + this.q.hashCode()) * 31;
        String r27 = this.r;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        String r30 = this.s;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        String r33 = this.t;
        if (r33 == null) goto L51;
        r1 = r33.hashCode();
    L51:
        return r32 + r1;
    L45:
        r31 = r30.hashCode();
        goto L46
    L41:
        r28 = r27.hashCode();
        goto L42
    L37:
        r25 = 1237;
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
        return "SlideDownloadParams(token=" + this.a + ", currentPage=" + this.b + ", previousPage=" + this.c + ", artifactMetaId=" + this.d + ", artifactVersionId=" + this.e + ", artifactType=" + this.f + ", aipptTaskId=" + this.g + ", presentationId=" + this.h + ", resourceId=" + this.i + ", resourceType=" + this.j + ", forceOfficeSdkDownload=" + this.k + ", canvasType=" + this.l + ", userType=" + this.m + ", messageId=" + this.n + ", conversationId=" + this.o + ", botId=" + this.p + ", sectionId=" + this.q + ", artifactCreateMethod=" + this.r + ", chatId=" + this.s + ", isGeneralAgent=" + this.t + ')';
    }

    public h(String r23, String r24, String r25, String r26, String r27, Integer r28, String r29, String r30, String r31, Integer r32, boolean r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, int r43) {
        if ((r43 & 1) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r43 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r43 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r43 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r43 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r43 & 32) == 0) goto L25;
        Integer r9 = null;
    L27:
        if ((r43 & 64) == 0) goto L29;
        String r10 = "";
    L31:
        if ((r43 & 128) == 0) goto L33;
        String r11 = "";
    L35:
        if ((r43 & 256) == 0) goto L37;
        String r12 = "";
    L39:
        if ((r43 & 512) == 0) goto L41;
        Integer r13 = null;
    L43:
        if ((r43 & 1024) == 0) goto L45;
        boolean r14 = false;
    L47:
        if ((r43 & 2048) == 0) goto L49;
        String r15 = "";
    L51:
        if ((r43 & 4096) == 0) goto L53;
        String r5 = "";
    L55:
        if ((r43 & 8192) == 0) goto L57;
        String r3 = "";
    L58:
        boolean r210 = r14;
        if ((r43 & 16384) == 0) goto L61;
        String r16 = "";
    L63:
        if ((r43 & 32768) == 0) goto L65;
        String r17 = "";
    L67:
        if ((r43 & 65536) == 0) goto L69;
        String r18 = "";
    L71:
        if ((r43 & 131072) == 0) goto L73;
        String r19 = null;
    L75:
        if ((r43 & 262144) == 0) goto L77;
        String r20 = null;
    L79:
        if ((r43 & 524288) == 0) goto L81;
        String r110 = null;
    L82:
        Intrinsics.checkNotNullParameter(r11, "presentationId");
        Intrinsics.checkNotNullParameter(r12, "resourceId");
        Intrinsics.checkNotNullParameter(r15, "canvasType");
        Intrinsics.checkNotNullParameter(r5, "userType");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r16, "conversationId");
        Intrinsics.checkNotNullParameter(r17, "botId");
        Intrinsics.checkNotNullParameter(r18, "sectionId");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r210;
        this.l = r15;
        this.m = r5;
        this.n = r3;
        this.o = r16;
        this.p = r17;
        this.q = r18;
        this.r = r19;
        this.s = r20;
        this.t = r110;
        return;
    L81:
        r110 = r42;
        goto L82
    L77:
        r20 = r41;
        goto L79
    L73:
        r19 = r40;
        goto L75
    L69:
        r18 = r39;
        goto L71
    L65:
        r17 = r38;
        goto L67
    L61:
        r16 = r37;
        goto L63
    L57:
        r3 = r36;
        goto L58
    L53:
        r5 = r35;
        goto L55
    L49:
        r15 = r34;
        goto L51
    L45:
        r14 = r33;
        goto L47
    L41:
        r13 = r32;
        goto L43
    L37:
        r12 = r31;
        goto L39
    L33:
        r11 = r30;
        goto L35
    L29:
        r10 = r29;
        goto L31
    L25:
        r9 = r28;
        goto L27
    L21:
        r8 = r27;
        goto L23
    L17:
        r7 = r26;
        goto L19
    L13:
        r6 = r25;
        goto L15
    L9:
        r4 = r24;
        goto L11
    L5:
        r2 = r23;
        goto L7
    }
}
