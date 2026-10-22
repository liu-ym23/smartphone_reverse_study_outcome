package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import android.net.Uri;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final Uri a;
    public final Map<String, Object> b;
    public final f c;
    public final boolean d;
    public final Pair<Integer, Integer> e;
    public double f;

    public d() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof d) == false) goto L18;
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r6.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L16;
        return false;
    L16:
        if (Double.compare(this.f, r6.f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public final int hashCode() {
        Uri r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        f r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.d;
        ?? r12 = r10;
        if (r10 == false) goto L17;
        r12 = 1;
    L17:
        int r13 = (r9 + r12) * 31;
        Pair<Integer, Integer> r14 = this.e;
        if (r14 == null) goto L20;
        r1 = r14.hashCode();
    L20:
        int r15 = (r13 + r1) * 31;
        long r16 = Double.doubleToLongBits(this.f);
        return r15 + ((int) (r16 ^ (r16 >>> 32)));
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LoadConfig(url=" + this.a + ", initData=" + this.b + ", lifecycle=" + this.c + ", allowFallback=" + this.d + ", initSize=" + this.e + ", startTime=" + this.f + ")";
    }

    public d(Uri r3, Map r4, f r5, Pair r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 16) == 0) goto L11;
        r6 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "url");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = false;
        this.e = r6;
        this.f = 0.0d;
    }
}
