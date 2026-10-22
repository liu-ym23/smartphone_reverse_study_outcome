package com.bytedance.ai.applet.app.foundation.performance;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s {
    public final boolean a;
    public final long b;
    public final long c;
    public final long d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof s) == true) goto L8;
        return false;
    L8:
        s r11 = (s) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.b;
        int r10 = ((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r11 = this.c;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        long r13 = this.d;
        return r12 + ((int) (r13 ^ (r13 >>> 32)));
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "PendingWidgetPerformanceTiming(isAppColdLaunch=" + this.a + ", bindingStartTime=" + this.b + ", widgetResourceLoadDuration=" + this.c + ", manifestResourceLoadDuration=" + this.d + ')';
    }

    public s(boolean r1, long r10, long r11, long r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
