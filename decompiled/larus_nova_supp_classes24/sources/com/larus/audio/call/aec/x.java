package com.larus.audio.call.aec;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class x {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static byte[] a(byte[] r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "data");
        int r1 = 0;
        int r7 = RangesKt.coerceIn(r6, 0, r5.length);
        int r8 = r7 - (r7 % 4);
        if (r8 <= 0) goto L5;
        byte[] r0 = new byte[r8 / 2];
        int r2 = 0;
    L7:
        int r3 = r1 + 1;
        if (r3 >= r8) goto L10;
        r0[r2] = r5[r1];
        r0[r2 + 1] = r5[r3];
        r1 = r1 + 4;
        r2 = r2 + 2;
        goto L7
    L10:
        return r0;
    L5:
        return new byte[0];
    }
}
