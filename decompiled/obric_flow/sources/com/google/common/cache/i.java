package com.google.common.cache;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8721c;
    public final long d;
    public final long e;
    public final long f;

    public i(long r19, long r21, long r23, long r25, long r27, long r29) {
        boolean r16 = false;
        if (r19 < 0) goto L5;
        boolean r15 = true;
    L6:
        com.google.common.base.b0.i(r15);
        if (r21 < 0) goto L9;
        boolean r17 = true;
    L10:
        com.google.common.base.b0.i(r17);
        if (r23 < 0) goto L13;
        boolean r18 = true;
    L14:
        com.google.common.base.b0.i(r18);
        if (r25 < 0) goto L17;
        boolean r110 = true;
    L18:
        com.google.common.base.b0.i(r110);
        if (r27 < 0) goto L21;
        boolean r111 = true;
    L22:
        com.google.common.base.b0.i(r111);
        if (r29 < 0) goto L25;
        r16 = true;
    L25:
        com.google.common.base.b0.i(r16);
        this.f8719a = r19;
        this.f8720b = r21;
        this.f8721c = r23;
        this.d = r25;
        this.e = r27;
        this.f = r29;
        return;
    L21:
        r111 = false;
        goto L22
    L17:
        r110 = false;
        goto L18
    L13:
        r18 = false;
        goto L14
    L9:
        r17 = false;
        goto L10
    L5:
        r15 = false;
        goto L6
    }

    public final boolean equals(Object r10) {
        if ((r10 instanceof i) == false) goto L18;
        i r11 = (i) r10;
        long r5 = r11.f8719a;
        if (this.f8719a == r5) goto L7;
        return false;
    L7:
        if (this.f8720b == r11.f8720b) goto L9;
        return false;
    L9:
        if (this.f8721c == r11.f8721c) goto L11;
        return false;
    L11:
        if (this.d == r11.d) goto L13;
        return false;
    L13:
        if (this.e == r11.e) goto L15;
        return false;
    L15:
        if (this.f != r11.f) goto L24;
        return true;
    L24:
        return false;
    L18:
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f8719a), Long.valueOf(this.f8720b), Long.valueOf(this.f8721c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f)});
    }

    public final String toString() {
        com.google.common.base.w r5 = com.google.common.base.b0.E(this);
        r5.a(this.f8719a, "hitCount");
        r5.a(this.f8720b, "missCount");
        r5.a(this.f8721c, "loadSuccessCount");
        r5.a(this.d, "loadExceptionCount");
        r5.a(this.e, "totalLoadTime");
        r5.a(this.f, "evictionCount");
        return r5.toString();
    }
}
