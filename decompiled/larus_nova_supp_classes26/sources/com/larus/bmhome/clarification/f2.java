package com.larus.bmhome.clarification;

import com.larus.im.bean.message.block.InteractionAskBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f2 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final InteractionAskBlock e;
    public final String f;
    public final ClarificationSubmissionStatus g;
    public final String h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f2) == true) goto L8;
        return false;
    L8:
        f2 r6 = (f2) r5;
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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        String r5 = this.h;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ClarificationSubmission(conversationId=" + this.a + ", messageId=" + this.b + ", blockId=" + this.c + ", clarifyId=" + this.d + ", interactionAskBlock=" + this.e + ", interactionAskBlockJson=" + this.f + ", status=" + this.g + ", reason=" + this.h + ')';
    }

    public f2(String r2, String r3, String r4, String r5, InteractionAskBlock r6, String r7, ClarificationSubmissionStatus r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "blockId");
        Intrinsics.checkNotNullParameter(r6, "interactionAskBlock");
        Intrinsics.checkNotNullParameter(r7, "interactionAskBlockJson");
        Intrinsics.checkNotNullParameter(r8, "status");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
