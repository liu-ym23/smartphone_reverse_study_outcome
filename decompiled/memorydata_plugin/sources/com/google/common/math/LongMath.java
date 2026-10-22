package com.google.common.math;

import com.bytedance.crash.constants.Constants;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.google.common.base.n;
import com.obric.aikernel.core.data.IdlErrors;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
public final class LongMath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f4738a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final long[] f4739b = null;
    static final long[] c = null;
    static final long[] d = null;
    static final int[] e = null;
    static final int[] f = null;
    private static final long[][] g = null;

    /* JADX INFO: renamed from: com.google.common.math.LongMath$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4740a = null;

        static {
            int[] r0 = new int[RoundingMode.values().length];
            f4740a = r0;
            r0[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f4740a[RoundingMode.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f4740a[RoundingMode.FLOOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f4740a[RoundingMode.UP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f4740a[RoundingMode.CEILING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f4740a[RoundingMode.HALF_DOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f4740a[RoundingMode.HALF_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f4740a[RoundingMode.HALF_EVEN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    private static abstract enum MillerRabinTester extends Enum<MillerRabinTester> {
        private static final /* synthetic */ MillerRabinTester[] $VALUES = null;
        public static final MillerRabinTester LARGE = null;
        public static final MillerRabinTester SMALL = null;

        private static /* synthetic */ MillerRabinTester[] $values() {
            return new MillerRabinTester[]{SMALL, LARGE};
        }

        static {
            final String r1 = "SMALL";
            final int r2 = 0;
            SMALL = new AnonymousClass1(r1, r2);
            final String r3 = "LARGE";
            final int r4 = 1;
            LARGE = new AnonymousClass2(r3, r4);
            $VALUES = $values();
        }

        private MillerRabinTester(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ MillerRabinTester(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private long powMod(long r10, long r12, long r14) {
            long r3 = 1;
        L4:
            if (r12 == 0) goto L9;
            if ((r12 & 1) == 0) goto L8;
            r3 = mulMod(r3, r10, r14);
        L8:
            r10 = squareMod(r10, r14);
            r12 = r12 >> 1;
            goto L4
        L9:
            return r3;
        }

        static boolean test(long r2, long r4) {
            if (r4 > 3037000499L) goto L5;
            MillerRabinTester r0 = SMALL;
        L7:
            return r0.testWitness(r2, r4);
        L5:
            r0 = LARGE;
            goto L7
        }

        private boolean testWitness(long r16, long r18) {
            long r11 = r18 - 1;
            int r13 = Long.numberOfTrailingZeros(r11);
            long r3 = r11 >> r13;
            long r1 = r16 % r18;
            if (r1 != 0) goto L5;
            return true;
        L5:
            long r0 = powMod(r1, r3, r18);
            if (r0 != 1) goto L8;
            return true;
        L8:
            int r4 = 0;
        L10:
            if (r0 == r11) goto L15;
            r4 = r4 + 1;
            if (r4 == r13) goto L13;
            r0 = squareMod(r0, r18);
            goto L10
        L13:
            return false;
        L15:
            return true;
        }

        public static MillerRabinTester valueOf(String r2) {
            return (MillerRabinTester) ZeusTransformUtils.preCheckCast(Enum.valueOf(MillerRabinTester.class, r2), MillerRabinTester.class, "com.obric.memorydata.plugin");
        }

        public static MillerRabinTester[] values() {
            return (MillerRabinTester[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MillerRabinTester[].class, "com.obric.memorydata.plugin");
        }

        abstract long mulMod(long r1, long r3, long r5);

        abstract long squareMod(long r1, long r3);
    }

    static {
        f4738a = new byte[]{19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
        f4739b = new long[]{1, 10, 100, 1000, 10000, 100000, TimeUtils.NANOSECONDS_PER_MILLISECOND, StackLeakChecker.CHECK_INTERVAL_10_SEC, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
        c = new long[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
        d = new long[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
        e = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
        f = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, Constants.UPLOAD_DISASTER_ESCAPE, 169, 139, IdlErrors.E_RejectInferDeviceOverheat, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
        g = new long[][]{new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};
    }

    public static long a(long r12, long r14) {
        int r0 = ((Long.numberOfLeadingZeros(r12) + Long.numberOfLeadingZeros(~r12)) + Long.numberOfLeadingZeros(r14)) + Long.numberOfLeadingZeros(~r14);
        if (r0 <= 65) goto L7;
        return r12 * r14;
    L7:
        if (r0 < 64) goto L9;
        boolean r4 = true;
    L10:
        e.a(r4, "checkedMultiply", r12, r14);
        if (r12 < 0) goto L13;
        boolean r1 = true;
    L15:
        if (r14 == Long.MIN_VALUE) goto L17;
        boolean r5 = true;
    L18:
        e.a(r1 | r5, "checkedMultiply", r12, r14);
        long r6 = r12 * r14;
        if (r12 != 0) goto L21;
    L24:
        boolean r7 = true;
    L25:
        e.a(r7, "checkedMultiply", r12, r14);
        return r6;
    L21:
        if ((r6 / r12) == r14) goto L24;
        r7 = false;
        goto L25
    L17:
        r5 = false;
        goto L18
    L13:
        r1 = false;
        goto L15
    L9:
        r4 = false;
        goto L10
    }

    public static long a(long r9, long r11, RoundingMode r13) {
        n.a(r13);
        long r0 = r9 / r11;
        long r2 = r9 - (r11 * r0);
        if (r2 != 0) goto L5;
        return r0;
    L5:
        boolean r10 = true;
        int r12 = ((int) ((r9 ^ r11) >> 63)) | 1;
        switch(AnonymousClass1.f4740a[r13.ordinal()]) {
            case 1: goto L24;
            case 2: goto L28;
            case 3: goto L22;
            case 4: goto L29;
            case 5: goto L20;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        long r3 = Math.abs(r2);
        long r4 = r3 - (Math.abs(r11) - r3);
        if (r4 == 0) goto L12;
        if (r4 <= 0) goto L28;
    L12:
        if (r13 == RoundingMode.HALF_UP) goto L29;
        if (r13 != RoundingMode.HALF_EVEN) goto L28;
        if ((1 & r0) == 0) goto L28;
    L20:
        if (r12 <= 0) goto L28;
    L22:
        if (r12 >= 0) goto L28;
    L24:
        if (r2 == 0) goto L27;
        r10 = false;
    L27:
        e.a(r10);
    L28:
        r10 = false;
    L29:
        if (r10 == true) goto L31;
        return r0;
    L31:
        return r0 + ((long) r12);
    L8:
        throw new AssertionError();
    }
}
