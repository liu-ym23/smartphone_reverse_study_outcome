package com.ss.android.lark.forwardv3.data.services;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public final String a;
    public final boolean b;
    public final String c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.c.hashCode()) * 31;
        if (this.d == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "SendTarget(chatId=" + this.a + ", isThreadTarget=" + this.b + ", parentId=" + this.c + ", isReplyInThread=" + this.d + ')';
    }

    public /* synthetic */ g(String r3) {
        this(r3, false, "", false);
    }

    public g(String r2, boolean r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r4, "parentId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
