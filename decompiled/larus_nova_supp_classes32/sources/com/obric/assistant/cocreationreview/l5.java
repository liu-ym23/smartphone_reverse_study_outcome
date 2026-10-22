package com.obric.assistant.cocreationreview;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l5 {
    public final ModuleKey a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final String f;
    public final List<String> g;
    public final List<String> h;
    public final String i;
    public final String j;
    public final String k;
    public final boolean l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l5) == true) goto L8;
        return false;
    L8:
        l5 r6 = (l5) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
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
        if (this.l == r6.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        if (this.l == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ModuleMeta(key=" + this.a + ", label=" + this.b + ", shortLabel=" + this.c + ", iconRes=" + this.d + ", accentColor=" + this.e + ", description=" + this.f + ", positiveReasons=" + this.g + ", negativeReasons=" + this.h + ", feedbackPlaceholder=" + this.i + ", positiveFeedbackPlaceholder=" + this.j + ", negativeFeedbackPlaceholder=" + this.k + ", feedbackMediaEnabled=" + this.l + ')';
    }

    public /* synthetic */ l5(ModuleKey r17, String r18, String r19, int r20, int r21, String r22, List r23, List r24, String r25, boolean r26, int r27) {
        if ((r27 & 512) == 0) goto L5;
        String r13 = "可以补充说明这条内容好在哪里，例如记得准确、分类合适、内容有价值或执行路径合理。";
    L7:
        if ((r27 & 1024) == 0) goto L9;
        String r14 = r25;
    L11:
        if ((r27 & 2048) == 0) goto L13;
        boolean r15 = false;
    L14:
        this(r17, r18, r19, r20, r21, r22, r23, r24, r25, r13, r14, r15);
        return;
    L13:
        r15 = r26;
        goto L14
    L9:
        r14 = null;
        goto L11
    L5:
        r13 = null;
        goto L7
    }

    public l5(ModuleKey r2, String r3, String r4, int r5, int r6, String r7, List<String> r8, List<String> r9, String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "label");
        Intrinsics.checkNotNullParameter(r4, "shortLabel");
        Intrinsics.checkNotNullParameter(r7, "description");
        Intrinsics.checkNotNullParameter(r8, "positiveReasons");
        Intrinsics.checkNotNullParameter(r9, "negativeReasons");
        Intrinsics.checkNotNullParameter(r10, "feedbackPlaceholder");
        Intrinsics.checkNotNullParameter(r11, "positiveFeedbackPlaceholder");
        Intrinsics.checkNotNullParameter(r12, "negativeFeedbackPlaceholder");
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
    }
}
