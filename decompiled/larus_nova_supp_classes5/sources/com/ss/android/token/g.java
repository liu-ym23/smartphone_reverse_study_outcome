package com.ss.android.token;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g {
    public final String a;
    public final String b;
    public final long c;
    public final List<o> d;
    public final List<o> e;
    public final boolean f;
    public final int g;
    public final Object h;
    public final boolean i;

    public final boolean equals(Object r8) {
        if (this != r8) goto L5;
    L38:
        return true;
    L5:
        if ((r8 instanceof g) == false) goto L37;
        g r9 = (g) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == false) goto L37;
        if (Intrinsics.areEqual(this.b, r9.b) == false) goto L37;
        if (this.c != r9.c) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L37;
        if (Intrinsics.areEqual(this.d, r9.d) == false) goto L37;
        if (Intrinsics.areEqual(this.e, r9.e) == false) goto L37;
        if (this.f != r9.f) goto L22;
        boolean r2 = true;
    L23:
        if (r2 == false) goto L37;
        if (this.g != r9.g) goto L27;
        boolean r3 = true;
    L28:
        if (r3 == false) goto L37;
        if (Intrinsics.areEqual(this.h, r9.h) == false) goto L37;
        if (this.i != r9.i) goto L34;
        boolean r10 = true;
    L35:
        if (r10 == false) goto L37;
    L34:
        r10 = false;
        goto L35
    L27:
        r3 = false;
        goto L28
    L22:
        r2 = false;
        goto L23
    L13:
        r1 = false;
    L37:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.c;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        List<o> r9 = this.d;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        List<o> r12 = this.e;
        if (r12 == null) goto L17;
        int r13 = r12.hashCode();
    L18:
        int r14 = (r11 + r13) * 31;
        boolean r15 = this.f;
        ?? r16 = 1;
        ?? r17 = r15;
        if (r15 == false) goto L21;
        r17 = 1;
    L21:
        int r18 = (((r14 + r17) * 31) + this.g) * 31;
        Object r19 = this.h;
        if (r19 == null) goto L24;
        r1 = r19.hashCode();
    L24:
        int r20 = (r18 + r1) * 31;
        boolean r21 = this.i;
        if (r21 == true) goto L29;
        r16 = r21;
    L29:
        return r20 + r16;
    L17:
        r13 = 0;
        goto L18
    L13:
        r10 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ResponseData(url=" + this.a + ", path=" + this.b + ", requestStartTime=" + this.c + ", originalRequestHeaders=" + this.d + ", responseHeaders=" + this.e + ", isSuccess=" + this.f + ", responseCode=" + this.g + ", body=" + this.h + ", isMainProcess=" + this.i + ")";
    }

    public g(String r1, String r2, long r3, List<o> r5, List<o> r6, boolean r7, int r8, Object r9, boolean r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
