package com.larus.bmhome.clarification;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z1 {
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;
    public final boolean g;
    public final String h;
    public final boolean i;
    public final int j;
    public final List<ResourceItemBean> k;
    public final i l;
    public final hk9.a m;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z1) == true) goto L8;
        return false;
    L8:
        z1 r6 = (z1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f) * 31;
        int r2 = 1231;
        if (this.g == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.h.hashCode()) * 31;
        if (this.i == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (((((((r3 + r2) * 31) + this.j) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31;
        hk9.a r5 = this.m;
        if (r5 != null) goto L13;
        int r6 = 0;
    L15:
        return r4 + r6;
    L13:
        r6 = r5.hashCode();
        goto L15
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ClarificationPageState(questionId=" + this.a + ", index=" + this.b + ", inputText=" + this.c + ", inputMethod=" + this.d + ", selectionStart=" + this.e + ", selectionEnd=" + this.f + ", isSpeakMode=" + this.g + ", attachmentLocalMsgId=" + this.h + ", hasAttachment=" + this.i + ", attachmentCount=" + this.j + ", attachmentItems=" + this.k + ", answerDraft=" + this.l + ", blockContainer=" + this.m + ')';
    }

    public static z1 a(z1 r18, String r19, String r20, int r21, int r22, boolean r23, boolean r24, int r25, List r26, i r27, hk9.a r28, int r29) {
        String r3 = null;
        if ((r29 & 1) == 0) goto L5;
        String r5 = r18.a;
    L7:
        if ((r29 & 2) == 0) goto L9;
        int r6 = r18.b;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r7 = r18.c;
    L15:
        if ((r29 & 8) == 0) goto L17;
        String r8 = r18.d;
    L19:
        if ((r29 & 16) == 0) goto L21;
        int r9 = r18.e;
    L23:
        if ((r29 & 32) == 0) goto L25;
        int r10 = r18.f;
    L27:
        if ((r29 & 64) == 0) goto L29;
        boolean r11 = r18.g;
    L31:
        if ((r29 & 128) == 0) goto L33;
        r3 = r18.h;
    L33:
        String r12 = r3;
        if ((r29 & 256) == 0) goto L36;
        boolean r13 = r18.i;
    L38:
        if ((r29 & 512) == 0) goto L40;
        int r14 = r18.j;
    L42:
        if ((r29 & 1024) == 0) goto L44;
        List r15 = r18.k;
    L46:
        if ((r29 & 2048) == 0) goto L48;
        i r2 = r18.l;
    L50:
        if ((r29 & 4096) == 0) goto L52;
        hk9.a r17 = r18.m;
    L53:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r5, "questionId");
        Intrinsics.checkNotNullParameter(r7, "inputText");
        Intrinsics.checkNotNullParameter(r8, "inputMethod");
        Intrinsics.checkNotNullParameter(r12, "attachmentLocalMsgId");
        Intrinsics.checkNotNullParameter(r15, "attachmentItems");
        Intrinsics.checkNotNullParameter(r2, "answerDraft");
        return new z1(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r17);
    L52:
        r17 = r28;
        goto L53
    L48:
        r2 = r27;
        goto L50
    L44:
        r15 = r26;
        goto L46
    L40:
        r14 = r25;
        goto L42
    L36:
        r13 = r24;
        goto L38
    L29:
        r11 = r23;
        goto L31
    L25:
        r10 = r22;
        goto L27
    L21:
        r9 = r21;
        goto L23
    L17:
        r8 = r20;
        goto L19
    L13:
        r7 = r19;
        goto L15
    L9:
        r6 = 0;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public z1(String r2, int r3, String r4, String r5, int r6, int r7, boolean r8, String r9, boolean r10, int r11, List<ResourceItemBean> r12, i r13, hk9.a r14) {
        Intrinsics.checkNotNullParameter(r2, "questionId");
        Intrinsics.checkNotNullParameter(r4, "inputText");
        Intrinsics.checkNotNullParameter(r5, "inputMethod");
        Intrinsics.checkNotNullParameter(r9, "attachmentLocalMsgId");
        Intrinsics.checkNotNullParameter(r12, "attachmentItems");
        Intrinsics.checkNotNullParameter(r13, "answerDraft");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }
}
