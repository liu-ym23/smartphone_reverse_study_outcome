package com.bytedance.android.anniex.scene.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final String a;
    public final double b;
    public final long c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.b, r11.b) == 0) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = Double.doubleToLongBits(this.b);
        int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r11 = this.c;
        return r10 + ((int) (r11 ^ (r11 >>> 32)));
    }

    public final String toString() {
        return "UrlEntry(url=" + this.a + ", count=" + this.b + ", lastVisitTs=" + this.c + ')';
    }

    public c(String r10, double r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
