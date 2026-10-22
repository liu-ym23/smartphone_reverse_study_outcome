package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public final long a;
    public final String b;
    public final AppletPerformanceNavigationType c;
    public final String d;
    public final Long e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof p) == true) goto L8;
        return false;
    L8:
        p r11 = (p) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
        AppletPerformanceNavigationType r10 = this.c;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r1 + r12) * 31;
        String r14 = this.d;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.e;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "PagePerformanceTraceConfig(startTime=" + this.a + ", path=" + this.b + ", navigationType=" + this.c + ", referrerPath=" + this.d + ", referrerTraceId=" + this.e + ')';
    }

    public /* synthetic */ p(long r10, String r11, AppletPerformanceNavigationType r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        this(r10, r11, r12, null, null);
    }

    public p(long r10, String r11, AppletPerformanceNavigationType r12, String r13, Long r14) {
        Intrinsics.checkNotNullParameter(r11, "path");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
