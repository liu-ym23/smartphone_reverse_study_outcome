package com.ss.android.lark.im.sdk.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final String a;
    public final String b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "GetUnreadAtMeParam(chatId=" + this.a + ", threadId=" + this.b + ", atAll=" + this.c + ')';
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        this.a = r2;
        this.b = null;
        this.c = false;
    }
}
