package com.larus.bmhome.chat.messagetransfer;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final String a;
    public final String b;
    public final List<String> c;
    public final String d;
    public final String e;
    public final int f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
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
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((r0 + r2) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowHumanMergeForwardRequest(title=" + this.a + ", hostMessageRef=" + this.b + ", subMessageIds=" + this.c + ", forwardChatId=" + this.d + ", chatType=" + this.e + ", isLarkMsg=" + this.f + ')';
    }

    public f(String r2, String r3, List<String> r4, String r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r4, "subMessageIds");
        Intrinsics.checkNotNullParameter(r5, "forwardChatId");
        Intrinsics.checkNotNullParameter(r6, "chatType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
