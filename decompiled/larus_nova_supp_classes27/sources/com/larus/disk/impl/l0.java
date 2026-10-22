package com.larus.disk.impl;

import java.util.concurrent.TimeUnit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l0 {
    public static final long a = 0;
    public static final long b = 0;
    public static final long c = 0;
    public static final /* synthetic */ int d = 0;

    public static final long a(long r5, long r7) {
        if ((com.larus.dora.impl.ota.g2.j0.G2_OTA_RECOVERY_BLOCK_FOREVER - r5) >= r7) goto L6;
        return com.larus.dora.impl.ota.g2.j0.G2_OTA_RECOVERY_BLOCK_FOREVER;
    L6:
        return r5 + r7;
    }

    static {
        TimeUnit r0 = TimeUnit.DAYS;
        a = r0.toMillis(7);
        b = r0.toMillis(30);
        c = r0.toMillis(1);
    }

    public static final k0 b(long r12, long r14, long r16, long r18) {
        boolean r0 = false;
        long r1 = 0;
        if (r12 <= 0) goto L5;
        long r3 = RangesKt.coerceAtLeast(r14, 0);
        if (r12 < r18) goto L9;
        r0 = true;
    L9:
        long r5 = RangesKt.coerceAtLeast(r16 - r12, 0);
        if (r0 == true) goto L12;
    L14:
        long r8 = 0;
    L15:
        if (r0 == false) goto L20;
        if (r5 > b) goto L20;
        r1 = r3;
    L20:
        return new k0(r3, r8, r1, 1);
    L12:
        if (r5 > a) goto L14;
        r8 = r3;
        goto L15
    L5:
        return new k0(0);
    }
}
