package com.google.common.math;

/* JADX INFO: loaded from: classes2.dex */
abstract enum LongMath$MillerRabinTester extends Enum<LongMath$MillerRabinTester> {
    public static final LongMath$MillerRabinTester LARGE = null;
    public static final LongMath$MillerRabinTester SMALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LongMath$MillerRabinTester[] f9302a = null;

    static {
        final String r5 = "SMALL";
        final int r10 = 0;
        LongMath$MillerRabinTester r11 = new AnonymousClass1(r5, r10);
        SMALL = r11;
        final String r12 = "LARGE";
        final int r13 = 1;
        LongMath$MillerRabinTester r14 = new AnonymousClass2(r12, r13);
        LARGE = r14;
        f9302a = new LongMath$MillerRabinTester[]{r11, r14};
    }

    public LongMath$MillerRabinTester(String r5, int r10, h r11) {
        super(r5, r10);
    }

    public static boolean test(long r20, long r22) {
        if (r22 > 3037000499L) goto L6;
        LongMath$MillerRabinTester r5 = SMALL;
    L5:
        LongMath$MillerRabinTester r10 = r5;
        r10.getClass();
        long r11 = 1;
        long r12 = r22 - 1;
        int r14 = Long.numberOfTrailingZeros(r12);
        long r13 = r12 >> r14;
        long r15 = r20 % r22;
        if (r15 == 0) goto L34;
        long r18 = r13;
        long r16 = r15;
        long r17 = 1;
    L12:
        if (r18 == 0) goto L19;
        if ((r18 & r11) == 0) goto L17;
        r17 = r10.mulMod(r17, r16, r22);
    L17:
        r16 = r10.squareMod(r16, r22);
        r18 = r18 >> 1;
        r11 = 1;
        goto L12
    L19:
        if (r17 == r11) goto L35;
        int r19 = 0;
    L23:
        if (r17 == r12) goto L36;
        r19 = r19 + 1;
        if (r19 == r14) goto L28;
        r17 = r10.squareMod(r17, r22);
        goto L23
    L28:
        return false;
    L36:
        return true;
    L35:
        return true;
    L34:
        return true;
    L6:
        r5 = LARGE;
        goto L5
    }

    public static LongMath$MillerRabinTester valueOf(String r5) {
        return (LongMath$MillerRabinTester) Enum.valueOf(LongMath$MillerRabinTester.class, r5);
    }

    public static LongMath$MillerRabinTester[] values() {
        return (LongMath$MillerRabinTester[]) f9302a.clone();
    }

    public abstract long mulMod(long r5, long r10, long r11);

    public abstract long squareMod(long r5, long r10);
}
