package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final int e;
    public final String f;
    public final String g;
    public final int h;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r11.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r11 = this.d;
        return ((((((((r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h;
    }

    public final String toString() {
        return "BaseAppPreloadResource(payload=" + this.a + ", source=" + this.b + ", cacheElapsedTime=" + this.c + ", requestStart=" + this.d + ", apiCode=" + this.e + ", errorMsg=" + this.f + ", xttLogId=" + this.g + ", schemaVersion=" + this.h + ')';
    }

    public b(String r10, String r11, long r12, long r13, int r14, String r15, String r16, int r17) {
        Intrinsics.checkNotNullParameter(r10, "payload");
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r15, "errorMsg");
        Intrinsics.checkNotNullParameter(r16, "xttLogId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
    }
}
