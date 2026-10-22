package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u {
    public final long a;
    public final long b;
    public final String c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof u) == true) goto L8;
        return false;
    L8:
        u r11 = (u) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r10 = this.b;
        return ((r1 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "ScriptEvaluationTiming(startTime=" + this.a + ", endTime=" + this.b + ", moduleName=" + this.c + ')';
    }

    public u(long r10, long r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "moduleName");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
