package com.larus.bmhome.chat.component.share;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatShareBottomComponent$c {
    public final String a;
    public final String b;
    public final String c;
    public final int d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatShareBottomComponent$c) == true) goto L8;
        return false;
    L8:
        ChatShareBottomComponent$c r6 = (ChatShareBottomComponent$c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
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
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + this.c.hashCode()) * 31) + this.d;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProduceIdInfo(rawProduceId=" + this.a + ", encodedProduceId=" + this.b + ", sourceType=" + this.c + ", messageCount=" + this.d + ')';
    }

    public ChatShareBottomComponent$c(String r2, String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "sourceType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
