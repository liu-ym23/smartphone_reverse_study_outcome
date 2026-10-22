package com.ss.android.lark.conditional.access.auth.v2.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i {
    public final boolean a;
    public Long b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        Long r2 = this.b;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "IPClearInfo(controlByIp=" + this.a + ", initialTime=" + this.b + ')';
    }

    public i(boolean r1, Long r2) {
        this.a = r1;
        this.b = r2;
    }
}
