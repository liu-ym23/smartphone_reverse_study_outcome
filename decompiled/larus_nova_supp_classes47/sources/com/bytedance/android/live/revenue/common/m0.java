package com.bytedance.android.live.revenue.common;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m0 {
    public final fr2.e a;
    public final boolean b;
    public final Map<String, Object> c;
    public final fr2.p d;
    public final boolean e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m0) == false) goto L16;
        m0 r4 = (m0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        fr2.e r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        Map<String, Object> r8 = this.c;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        fr2.p r12 = this.d;
        if (r12 == null) goto L16;
        r1 = r12.hashCode();
    L16:
        int r13 = (r10 + r1) * 31;
        boolean r14 = this.e;
        if (r14 == true) goto L21;
        r5 = r14;
    L21:
        return r13 + r5;
    L12:
        r9 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RtcData(client=" + this.a + ", isEngineOn=" + this.b + ", remoteMap=" + this.c + ", liveCore=" + this.d + ", hasLinkAudience4Stop=" + this.e + ")";
    }

    public m0(fr2.e r2, boolean r3, Map<String, Object> r4, fr2.p r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "remoteMap");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
