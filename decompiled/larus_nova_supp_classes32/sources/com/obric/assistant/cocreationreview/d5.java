package com.obric.assistant.cocreationreview;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d5 {
    public final String a;
    public final String b;
    public final String c;
    public final List<String> d;
    public final a5 e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final int k;
    public final boolean l;
    public final boolean m;
    public final List<b5> n;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d5) == true) goto L8;
        return false;
    L8:
        d5 r6 = (d5) r5;
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
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k) * 31;
        int r2 = 1231;
        if (this.l == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.m == true) goto L11;
        r2 = 1237;
    L11:
        return ((r3 + r2) * 31) + this.n.hashCode();
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "FeedbackPanelTemplate(recordId=" + this.a + ", title=" + this.b + ", reasonsTitle=" + this.c + ", reasons=" + this.d + ", feedback=" + this.e + ", placeholder=" + this.f + ", emptyReasonsText=" + this.g + ", submitText=" + this.h + ", submittingText=" + this.i + ", incompleteText=" + this.j + ", maxCommentLength=" + this.k + ", submitting=" + this.l + ", mediaEnabled=" + this.m + ", media=" + this.n + ')';
    }

    public /* synthetic */ d5(String r16, String r17, List r18, a5 r19, String r20, String r21, String r22, boolean r23, boolean r24, List r25, int r26) {
        if ((r26 & 1024) == 0) goto L5;
        int r11 = 500;
    L7:
        if ((r26 & 2048) == 0) goto L9;
        boolean r12 = false;
    L11:
        if ((r26 & 4096) == 0) goto L13;
        boolean r13 = false;
    L15:
        if ((r26 & 8192) == 0) goto L17;
        List r14 = CollectionsKt.emptyList();
    L18:
        this(r16, "反馈", r17, r18, r19, r20, r21, "提交", "提交中...", r22, r11, r12, r13, r14);
        return;
    L17:
        r14 = r25;
        goto L18
    L13:
        r13 = r24;
        goto L15
    L9:
        r12 = r23;
        goto L11
    L5:
        r11 = 0;
        goto L7
    }

    public d5(String r2, String r3, String r4, List<String> r5, a5 r6, String r7, String r8, String r9, String r10, String r11, int r12, boolean r13, boolean r14, List<b5> r15) {
        Intrinsics.checkNotNullParameter(r2, "recordId");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "reasonsTitle");
        Intrinsics.checkNotNullParameter(r5, "reasons");
        Intrinsics.checkNotNullParameter(r6, "feedback");
        Intrinsics.checkNotNullParameter(r7, "placeholder");
        Intrinsics.checkNotNullParameter(r8, "emptyReasonsText");
        Intrinsics.checkNotNullParameter(r9, "submitText");
        Intrinsics.checkNotNullParameter(r10, "submittingText");
        Intrinsics.checkNotNullParameter(r11, "incompleteText");
        Intrinsics.checkNotNullParameter(r15, "media");
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
        this.n = r15;
    }
}
