package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v {
    public final long a;
    public final long b;
    public final long c;
    public final String d;
    public final String e;
    public final boolean f;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof v) == true) goto L8;
        return false;
    L8:
        v r11 = (v) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r10 = this.b;
        int r11 = (r1 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = this.c;
        int r13 = (((((r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L5;
        int r14 = 1231;
    L7:
        return r13 + r14;
    L5:
        r14 = 1237;
        goto L7
    }

    public final String toString() {
        return "WidgetPerformanceTraceConfig(startTime=" + this.a + ", widgetResourceLoadDuration=" + this.b + ", manifestResourceLoadDuration=" + this.c + ", widgetId=" + this.d + ", widgetInstanceId=" + this.e + ", isAppColdLaunch=" + this.f + ')';
    }

    public v(long r10, long r11, long r12, String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "widgetId");
        Intrinsics.checkNotNullParameter(r14, "widgetInstanceId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
    }
}
