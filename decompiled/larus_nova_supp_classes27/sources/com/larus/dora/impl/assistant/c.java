package com.larus.dora.impl.assistant;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        String r4 = this.c;
        int r5 = 0;
        if (r4 != null) goto L13;
        int r6 = 0;
    L14:
        int r7 = (r3 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L19;
        r5 = r8.hashCode();
    L19:
        return r7 + r5;
    L13:
        r6 = r4.hashCode();
        goto L14
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "AssistantWifiStateResult(success=" + this.a + ", enabled=" + this.b + ", errorCode=" + this.c + ", errorMsg=" + this.d + ')';
    }

    public c(boolean r1, boolean r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
