package kw9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Integer e;
    public final String f;
    public final String g;
    public final String h;
    public final Integer i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;

    public e() {
        this(null, null, null, null, null, null, 262143);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
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
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L62;
        return false;
    L62:
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
        Integer r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (((((r15 + r17) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        Integer r19 = this.i;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (((((((((((((r18 + r20) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31;
        String r22 = this.p;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.q;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.r;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
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
        return "SheetDownloadParams(token=" + this.a + ", currentPage=" + this.b + ", previousPage=" + this.c + ", artifactMetaId=" + this.d + ", artifactType=" + this.e + ", aipptTaskId=" + this.f + ", presentationId=" + this.g + ", resourceId=" + this.h + ", resourceType=" + this.i + ", canvasType=" + this.j + ", userType=" + this.k + ", messageId=" + this.l + ", conversationId=" + this.m + ", botId=" + this.n + ", sectionId=" + this.o + ", artifactCreateMethod=" + this.p + ", clickFrom=" + this.q + ", spreadsheetVersion=" + this.r + ')';
    }

    public /* synthetic */ e(String r23, String r24, String r25, String r26, String r27, String r28, int r29) {
        if ((r29 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r29 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r29 & 32) == 0) goto L17;
        String r9 = "";
    L19:
        if ((r29 & 64) == 0) goto L21;
        String r10 = "";
    L23:
        if ((r29 & 128) == 0) goto L25;
        String r11 = "";
    L27:
        if ((r29 & 512) == 0) goto L29;
        String r13 = "";
    L31:
        if ((r29 & 1024) == 0) goto L33;
        String r14 = "";
    L35:
        if ((r29 & 2048) == 0) goto L37;
        String r15 = "";
    L39:
        if ((r29 & 4096) == 0) goto L41;
        String r16 = "";
    L43:
        if ((r29 & 8192) == 0) goto L45;
        String r17 = "";
    L47:
        if ((r29 & 16384) == 0) goto L49;
        String r18 = "";
    L51:
        if ((r29 & 65536) == 0) goto L53;
        String r20 = null;
    L54:
        this(r4, r5, r6, null, null, r9, r10, r11, null, r13, r14, r15, r16, r17, r18, null, r20, null);
        return;
    L53:
        r20 = r28;
        goto L54
    L49:
        r18 = null;
        goto L51
    L45:
        r17 = r27;
        goto L47
    L41:
        r16 = r26;
        goto L43
    L37:
        r15 = null;
        goto L39
    L33:
        r14 = null;
        goto L35
    L29:
        r13 = null;
        goto L31
    L25:
        r11 = null;
        goto L27
    L21:
        r10 = null;
        goto L23
    L17:
        r9 = null;
        goto L19
    L13:
        r6 = r25;
        goto L15
    L9:
        r5 = r24;
        goto L11
    L5:
        r4 = r23;
        goto L7
    }

    public e(String r11, String r12, String r13, String r14, Integer r15, String r16, String r17, String r18, Integer r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28) {
        Intrinsics.checkNotNullParameter(r17, "presentationId");
        Intrinsics.checkNotNullParameter(r18, "resourceId");
        Intrinsics.checkNotNullParameter(r20, "canvasType");
        Intrinsics.checkNotNullParameter(r21, "userType");
        Intrinsics.checkNotNullParameter(r22, "messageId");
        Intrinsics.checkNotNullParameter(r23, "conversationId");
        Intrinsics.checkNotNullParameter(r24, "botId");
        Intrinsics.checkNotNullParameter(r25, "sectionId");
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r21;
        this.l = r22;
        this.m = r23;
        this.n = r24;
        this.o = r25;
        this.p = r26;
        this.q = r27;
        this.r = r28;
    }
}
