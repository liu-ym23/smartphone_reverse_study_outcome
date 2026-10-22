package com.larus.uaigc.chat.notification;

import java.security.SecureRandom;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final int a;
    public final double b;
    public final double c;
    public int d;

    public final int a(double r11) {
        int r0 = this.d;
        int r1 = this.a;
        if (r0 < r1) goto L5;
        return r1;
    L5:
        double r2 = (new SecureRandom().nextDouble() - 0.5d) * ((double) 2);
        int r12 = RangesKt.coerceIn((int) ((((double) this.a) * (((double) 1) - Math.exp((-this.b) * Math.pow(r11, this.c)))) + r2), this.d, this.a);
        if (r12 <= this.d) goto L9;
        this.d = r12;
    L9:
        return this.d;
    }

    public a(double r4, int r6) {
        if ((r6 & 1) == 0) goto L5;
        int r0 = 99;
    L7:
        if ((r6 & 2) == 0) goto L10;
        r4 = 0.03d;
    L10:
        if ((r6 & 4) == 0) goto L12;
        double r1 = 0.7d;
    L13:
        this.a = r0;
        this.b = r4;
        this.c = r1;
        return;
    L12:
        r1 = 0.0d;
        goto L13
    L5:
        r0 = 0;
        goto L7
    }
}
