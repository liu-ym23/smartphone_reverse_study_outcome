package com.obric.assistant.cocreationreview;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s5 {
    public final String a;
    public final String b;
    public final ModuleKey c;
    public final Vote d;
    public final Set<String> e;
    public final String f;
    public final String g;
    public final List<CocreationUserFeedbackAttachment> h;
    public final List<b5> i;
    public final Integer j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s5) == true) goto L8;
        return false;
    L8:
        s5 r6 = (s5) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        Integer r1 = this.j;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "SubmitAnnotationRequest(requestId=" + this.a + ", recordId=" + this.b + ", businessId=" + this.c + ", vote=" + this.d + ", reasons=" + this.e + ", comment=" + this.f + ", businessPayload=" + this.g + ", attachments=" + this.h + ", feedbackMedia=" + this.i + ", feedbackValue=" + this.j + ')';
    }

    public s5(String r2, String r3, ModuleKey r4, Vote r5, Set<String> r6, String r7, String r8, List<CocreationUserFeedbackAttachment> r9, List<b5> r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r2, "requestId");
        Intrinsics.checkNotNullParameter(r3, "recordId");
        Intrinsics.checkNotNullParameter(r4, "businessId");
        Intrinsics.checkNotNullParameter(r5, "vote");
        Intrinsics.checkNotNullParameter(r6, "reasons");
        Intrinsics.checkNotNullParameter(r7, "comment");
        Intrinsics.checkNotNullParameter(r8, "businessPayload");
        Intrinsics.checkNotNullParameter(r9, "attachments");
        Intrinsics.checkNotNullParameter(r10, "feedbackMedia");
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
    }
}
