package com.larus.avlink.gallery.processor;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public final boolean a;
    public final String b;
    public final String c;
    public final long d;
    public final Map<String, Object> e;
    public final boolean f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k) == true) goto L8;
        return false;
    L8:
        k r9 = (k) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r3 = this.d;
        int r4 = (((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.e.hashCode()) * 31;
        if (this.f == true) goto L11;
        r1 = 1237;
    L11:
        return r4 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ProcessResult(success=" + this.a + ", outputPath=" + this.b + ", error=" + this.c + ", durationMs=" + this.d + ", extras=" + this.e + ", isFallback=" + this.f + ')';
    }

    public final long a() {
        return this.d;
    }

    public final String b() {
        return this.c;
    }

    public final Map<String, Object> c() {
        return this.e;
    }

    public final String d() {
        return this.b;
    }

    public final boolean e() {
        return this.a;
    }

    public final boolean f() {
        return this.f;
    }

    public k(boolean r2, String r3, String r4, long r5, Map<String, ? extends Object> r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r3, "outputPath");
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r7, "extras");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
    }

    public /* synthetic */ k(boolean r11, String r12, String r13, long r14, Map r16, boolean r17, int r18) {
        if ((r18 & 2) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r18 & 4) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r18 & 8) == 0) goto L13;
        long r6 = 0;
    L15:
        if ((r18 & 16) == 0) goto L17;
        Map r8 = MapsKt.emptyMap();
    L19:
        if ((r18 & 32) == 0) goto L21;
        boolean r9 = false;
    L22:
        this(r11, r4, r5, r6, r8, r9);
        return;
    L21:
        r9 = r17;
        goto L22
    L17:
        r8 = r16;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }
}
