package com.bytedance.android.ec.core.frontier;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final String a;
    public final String b;

    public c() {
        this(null, null);
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public final boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L17:
        return false;
    L8:
        if ((r10 instanceof c) == false) goto L17;
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L13;
    L15:
        return false;
    L13:
        if (Intrinsics.areEqual(this.b, r11.b) == false) goto L15;
        return true;
    }

    public c(String r1, String r10) {
        this.a = r1;
        this.b = r10;
    }
}
