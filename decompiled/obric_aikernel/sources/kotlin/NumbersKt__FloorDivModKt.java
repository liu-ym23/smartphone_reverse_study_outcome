package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;

/* JADX INFO: loaded from: classes2.dex */
class NumbersKt__FloorDivModKt extends NumbersKt__BigIntegersKt {
    public NumbersKt__FloorDivModKt() {
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(byte r10, byte r11) {
        int r12 = r10 / r11;
        if ((r10 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(byte r10, int r11) {
        int r12 = r10 / r11;
        if ((r10 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(byte r10, short r11) {
        int r12 = r10 / r11;
        if ((r10 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(int r10, byte r11) {
        int r12 = r10 / r11;
        if ((r10 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(int r10, int r11) {
        int r12 = r10 / r11;
        if ((r10 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(int r10, short r11) {
        int r12 = r10 / r11;
        if ((r10 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(short r10, byte r11) {
        int r12 = r10 / r11;
        if ((r10 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(short r10, int r11) {
        int r12 = r10 / r11;
        if ((r10 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(short r10, short r11) {
        int r12 = r10 / r11;
        if ((r10 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(byte r10, long r11) {
        long r12 = r10;
        long r13 = r12 / r11;
        if ((r12 ^ r11) < 0) goto L5;
        return r13;
    L5:
        if ((r11 * r13) != r12) goto L7;
        return r13;
    L7:
        return r13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(int r10, long r11) {
        long r12 = r10;
        long r13 = r12 / r11;
        if ((r12 ^ r11) < 0) goto L5;
        return r13;
    L5:
        if ((r11 * r13) != r12) goto L7;
        return r13;
    L7:
        return r13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long r10, byte r11) {
        long r12 = r11;
        long r13 = r10 / r12;
        if ((r10 ^ r12) < 0) goto L5;
        return r13;
    L5:
        if ((r12 * r13) != r10) goto L7;
        return r13;
    L7:
        return r13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long r10, int r11) {
        long r12 = r11;
        long r13 = r10 / r12;
        if ((r10 ^ r12) < 0) goto L5;
        return r13;
    L5:
        if ((r12 * r13) != r10) goto L7;
        return r13;
    L7:
        return r13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long r10, long r11) {
        long r12 = r10 / r11;
        if ((r10 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long r10, short r11) {
        long r12 = r11;
        long r13 = r10 / r12;
        if ((r10 ^ r12) < 0) goto L5;
        return r13;
    L5:
        if ((r12 * r13) != r10) goto L7;
        return r13;
    L7:
        return r13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(short r10, long r11) {
        long r12 = r10;
        long r13 = r12 / r11;
        if ((r12 ^ r11) < 0) goto L5;
        return r13;
    L5:
        if ((r11 * r13) != r12) goto L7;
        return r13;
    L7:
        return r13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(byte r10, byte r11) {
        int r12 = r10 % r11;
        return (byte) (r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(int r10, byte r11) {
        int r12 = r10 % r11;
        return (byte) (r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(long r10, byte r11) {
        long r12 = r11;
        long r13 = r10 % r12;
        return (byte) (r13 + (r12 & (((r13 ^ r12) & ((-r13) | r13)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(short r10, byte r11) {
        int r12 = r10 % r11;
        return (byte) (r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double mod(double r10, double r11) {
        double r12 = r10 % r11;
        boolean r13 = true;
        if (r12 != 0.0d) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        return r12;
    L8:
        if (Math.signum(r12) == Math.signum(r11)) goto L11;
        r13 = false;
    L11:
        if (r13 == false) goto L13;
        return r12;
    L13:
        return r12 + r11;
    L5:
        r14 = false;
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double mod(double r10, float r11) {
        double r12 = r11;
        double r13 = r10 % r12;
        boolean r14 = true;
        if (r13 != 0.0d) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L8;
        return r13;
    L8:
        if (Math.signum(r13) == Math.signum(r12)) goto L11;
        r14 = false;
    L11:
        if (r14 == false) goto L13;
        return r13;
    L13:
        return r13 + r12;
    L5:
        r15 = false;
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double mod(float r10, double r11) {
        double r12 = ((double) r10) % r11;
        boolean r13 = true;
        if (r12 != 0.0d) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        return r12;
    L8:
        if (Math.signum(r12) == Math.signum(r11)) goto L11;
        r13 = false;
    L11:
        if (r13 == false) goto L13;
        return r12;
    L13:
        return r12 + r11;
    L5:
        r14 = false;
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final float mod(float r10, float r11) {
        float r12 = r10 % r11;
        boolean r13 = true;
        if (r12 != 0.0f) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        return r12;
    L8:
        if (Math.signum(r12) == Math.signum(r11)) goto L11;
        r13 = false;
    L11:
        if (r13 == false) goto L13;
        return r12;
    L13:
        return r12 + r11;
    L5:
        r14 = false;
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(byte r10, int r11) {
        int r12 = r10 % r11;
        return r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(int r10, int r11) {
        int r12 = r10 % r11;
        return r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(long r10, int r11) {
        long r12 = r11;
        long r13 = r10 % r12;
        return (int) (r13 + (r12 & (((r13 ^ r12) & ((-r13) | r13)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(short r10, int r11) {
        int r12 = r10 % r11;
        return r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(byte r10, long r11) {
        long r12 = ((long) r10) % r11;
        return r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(int r10, long r11) {
        long r12 = ((long) r10) % r11;
        return r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(long r10, long r11) {
        long r12 = r10 % r11;
        return r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(short r10, long r11) {
        long r12 = ((long) r10) % r11;
        return r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(byte r10, short r11) {
        int r12 = r10 % r11;
        return (short) (r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(int r10, short r11) {
        int r12 = r10 % r11;
        return (short) (r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(long r10, short r11) {
        long r12 = r11;
        long r13 = r10 % r12;
        return (short) (r13 + (r12 & (((r13 ^ r12) & ((-r13) | r13)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(short r10, short r11) {
        int r12 = r10 % r11;
        return (short) (r12 + (r11 & (((r12 ^ r11) & ((-r12) | r12)) >> 31)));
    }
}
