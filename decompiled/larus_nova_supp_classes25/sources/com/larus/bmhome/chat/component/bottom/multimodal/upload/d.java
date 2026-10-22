package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public final boolean a;
    public final String b;
    public final String c;
    public final n d;
    public final UplinkFileEntity e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final boolean j;
    public final boolean k;
    public final String l;
    public final Boolean m;
    public final mr9.c n;
    public final String o;
    public final Long p;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
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
        if (this.j == r6.j) goto L39;
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
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
        String r3 = this.c;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((r2 + r5) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r7 = this.f;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.h;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.i;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.j == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        if (this.k == true) goto L34;
        r1 = 1237;
    L34:
        int r21 = (r20 + r1) * 31;
        String r22 = this.l;
        if (r22 != null) goto L37;
        int r23 = 0;
    L38:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.m;
        if (r25 != null) goto L41;
        int r26 = 0;
    L42:
        int r27 = (r24 + r26) * 31;
        mr9.c r28 = this.n;
        if (r28 != null) goto L45;
        int r29 = 0;
    L46:
        int r30 = (r27 + r29) * 31;
        String r31 = this.o;
        if (r31 != null) goto L49;
        int r32 = 0;
    L50:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.p;
        if (r34 == null) goto L55;
        r4 = r34.hashCode();
    L55:
        return r33 + r4;
    L49:
        r32 = r31.hashCode();
        goto L50
    L45:
        r29 = r28.hashCode();
        goto L46
    L41:
        r26 = r25.hashCode();
        goto L42
    L37:
        r23 = r22.hashCode();
        goto L38
    L29:
        r19 = 1237;
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
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "FileUploadParam(limitUploaderCount=" + this.a + ", localPath=" + this.b + ", fileName=" + this.c + ", listener=" + this.d + ", entity=" + this.e + ", conversationId=" + this.f + ", botId=" + this.g + ", sectionId=" + this.h + ", localSendMsgId=" + this.i + ", skippedAttachment=" + this.j + ", enableResourceCenter=" + this.k + ", originPath=" + this.l + ", originPathIsUri=" + this.m + ", instantUploadPolicy=" + this.n + ", uploadSourceScene=" + this.o + ", uploadFileSize=" + this.p + ')';
    }

    public d(boolean r18, String r19, String r20, m r21, UplinkFileEntity r22, String r23, String r24, String r25, String r26, boolean r27, boolean r28, String r29, Boolean r30, mr9.c r31, String r32, Long r33, int r34) {
        Long r6 = null;
        if ((r34 & 32) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r34 & 64) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r34 & 128) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r34 & 256) == 0) goto L17;
        String r9 = null;
    L18:
        boolean r11 = false;
        if ((r34 & 512) == 0) goto L21;
        boolean r10 = false;
    L23:
        if ((r34 & 1024) != 0) goto L27;
        r11 = r28;
    L27:
        if ((r34 & 2048) == 0) goto L29;
        String r12 = null;
    L31:
        if ((r34 & 4096) == 0) goto L33;
        Boolean r13 = null;
    L35:
        if ((r34 & 8192) == 0) goto L37;
        mr9.c r14 = null;
    L39:
        if ((r34 & 16384) == 0) goto L41;
        String r15 = null;
    L43:
        if ((r34 & 32768) != 0) goto L46;
        r6 = r33;
    L46:
        Intrinsics.checkNotNullParameter(r19, "localPath");
        Intrinsics.checkNotNullParameter(r21, "listener");
        Intrinsics.checkNotNullParameter(r22, "entity");
        this.a = r18;
        this.b = r19;
        this.c = r20;
        this.d = r21;
        this.e = r22;
        this.f = r5;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
        this.o = r15;
        this.p = r6;
        return;
    L41:
        r15 = r32;
        goto L43
    L37:
        r14 = r31;
        goto L39
    L33:
        r13 = r30;
        goto L35
    L29:
        r12 = r29;
        goto L31
    L21:
        r10 = r27;
        goto L23
    L17:
        r9 = r26;
        goto L18
    L13:
        r8 = r25;
        goto L15
    L9:
        r7 = r24;
        goto L11
    L5:
        r5 = r23;
        goto L7
    }
}
