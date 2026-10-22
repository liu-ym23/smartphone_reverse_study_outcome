package kba;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static long a(long r2) {
        long r3 = (r2 * (-7046029254386353131L)) + 1366960921;
        long r4 = (r3 ^ (r3 >>> 30)) * (-4658895280553007687L);
        long r5 = (r4 ^ (r4 >>> 27)) * (-7723592293110705685L);
        return r5 ^ (r5 >>> 31);
    }

    public static float b(long r20) {
        long r2 = RangesKt.coerceAtLeast(r20, 0);
        long r6 = r2 / 220;
        long r3 = r2 % 220;
        long r4 = 0;
        long r8 = r6;
    L3:
        long r10 = a(r4);
        boolean r12 = true;
        long r13 = 2;
        if (r10 < 0) goto L6;
        long r11 = r10 % 2;
    L11:
        long r14 = (r11 + 1) + 4;
        if (r8 < r14) goto L14;
        r8 = r8 - r14;
        r4 = r4 + r14;
        goto L3
    L14:
        if (r8 >= 4) goto L17;
        r12 = false;
    L17:
        float r0 = 0.06f;
        if (r12 == false) goto L20;
        return 0.06f;
    L20:
        float r1 = (((float) ((a(r6) >>> 11) / 9.007199254740991E15d)) * 0.5f) + 0.45f;
        if (r3 > 45) goto L23;
        r1 = (r1 - 0.06f) * (r3 / 45.0f);
    L25:
        return r1 + r0;
    L23:
        r0 = (0.06f - r1) * RangesKt.coerceIn((r3 - 45) / 130.0f, 0.0f, 1.0f);
        goto L25
    L6:
        long r15 = r10 - ((((r10 >>> 1) / 2) << 1) * 2);
        if ((Long.MIN_VALUE ^ r15) >= (-9223372036854775806L)) goto L10;
        r13 = 0;
    L10:
        r11 = r15 - r13;
        goto L11
    }
}
