package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b¨\u0006\t"}, d2 = {"floorDiv", "", "", "other", "", "", "mod", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__FloorDivModKt extends NumbersKt__BigIntegersKt {
    public NumbersKt__FloorDivModKt() {
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(byte r5, byte r10) {
        int r11 = r5 / r10;
        if ((r5 ^ r10) < 0) goto L5;
        return r11;
    L5:
        if ((r10 * r11) != r5) goto L7;
        return r11;
    L7:
        return r11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(byte r5, byte r10) {
        int r11 = r5 % r10;
        return (byte) (r11 + (r10 & (((r11 ^ r10) & ((-r11) | r11)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(byte r5, short r10) {
        int r11 = r5 / r10;
        if ((r5 ^ r10) < 0) goto L5;
        return r11;
    L5:
        if ((r10 * r11) != r5) goto L7;
        return r11;
    L7:
        return r11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(byte r5, short r10) {
        int r11 = r5 % r10;
        return (short) (r11 + (r10 & (((r11 ^ r10) & ((-r11) | r11)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(byte r5, int r10) {
        int r11 = r5 / r10;
        if ((r5 ^ r10) < 0) goto L5;
        return r11;
    L5:
        if ((r10 * r11) != r5) goto L7;
        return r11;
    L7:
        return r11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(byte r5, int r10) {
        int r11 = r5 % r10;
        return r11 + (r10 & (((r11 ^ r10) & ((-r11) | r11)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(byte r10, long r11) {
        long r5 = r10;
        long r12 = r5 / r11;
        if ((r5 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r5) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(byte r10, long r11) {
        long r5 = ((long) r10) % r11;
        return r5 + (r11 & (((r5 ^ r11) & ((-r5) | r5)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(short r5, byte r10) {
        int r11 = r5 / r10;
        if ((r5 ^ r10) < 0) goto L5;
        return r11;
    L5:
        if ((r10 * r11) != r5) goto L7;
        return r11;
    L7:
        return r11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(short r5, byte r10) {
        int r11 = r5 % r10;
        return (byte) (r11 + (r10 & (((r11 ^ r10) & ((-r11) | r11)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(short r5, short r10) {
        int r11 = r5 / r10;
        if ((r5 ^ r10) < 0) goto L5;
        return r11;
    L5:
        if ((r10 * r11) != r5) goto L7;
        return r11;
    L7:
        return r11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(short r5, short r10) {
        int r11 = r5 % r10;
        return (short) (r11 + (r10 & (((r11 ^ r10) & ((-r11) | r11)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(short r5, int r10) {
        int r11 = r5 / r10;
        if ((r5 ^ r10) < 0) goto L5;
        return r11;
    L5:
        if ((r10 * r11) != r5) goto L7;
        return r11;
    L7:
        return r11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(short r5, int r10) {
        int r11 = r5 % r10;
        return r11 + (r10 & (((r11 ^ r10) & ((-r11) | r11)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(short r10, long r11) {
        long r5 = r10;
        long r12 = r5 / r11;
        if ((r5 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r5) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(short r10, long r11) {
        long r5 = ((long) r10) % r11;
        return r5 + (r11 & (((r5 ^ r11) & ((-r5) | r5)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(int r5, byte r10) {
        int r11 = r5 / r10;
        if ((r5 ^ r10) < 0) goto L5;
        return r11;
    L5:
        if ((r10 * r11) != r5) goto L7;
        return r11;
    L7:
        return r11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(int r5, byte r10) {
        int r11 = r5 % r10;
        return (byte) (r11 + (r10 & (((r11 ^ r10) & ((-r11) | r11)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(int r5, short r10) {
        int r11 = r5 / r10;
        if ((r5 ^ r10) < 0) goto L5;
        return r11;
    L5:
        if ((r10 * r11) != r5) goto L7;
        return r11;
    L7:
        return r11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(int r5, short r10) {
        int r11 = r5 % r10;
        return (short) (r11 + (r10 & (((r11 ^ r10) & ((-r11) | r11)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(int r5, int r10) {
        int r11 = r5 / r10;
        if ((r5 ^ r10) < 0) goto L5;
        return r11;
    L5:
        if ((r10 * r11) != r5) goto L7;
        return r11;
    L7:
        return r11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(int r5, int r10) {
        int r11 = r5 % r10;
        return r11 + (r10 & (((r11 ^ r10) & ((-r11) | r11)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(int r10, long r11) {
        long r5 = r10;
        long r12 = r5 / r11;
        if ((r5 ^ r11) < 0) goto L5;
        return r12;
    L5:
        if ((r11 * r12) != r5) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(int r10, long r11) {
        long r5 = ((long) r10) % r11;
        return r5 + (r11 & (((r5 ^ r11) & ((-r5) | r5)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long r10, byte r11) {
        long r5 = r11;
        long r12 = r10 / r5;
        if ((r10 ^ r5) < 0) goto L5;
        return r12;
    L5:
        if ((r5 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(long r10, byte r11) {
        long r5 = r11;
        long r12 = r10 % r5;
        return (byte) (r12 + (r5 & (((r12 ^ r5) & ((-r12) | r12)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long r10, short r11) {
        long r5 = r11;
        long r12 = r10 / r5;
        if ((r10 ^ r5) < 0) goto L5;
        return r12;
    L5:
        if ((r5 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(long r10, short r11) {
        long r5 = r11;
        long r12 = r10 % r5;
        return (short) (r12 + (r5 & (((r12 ^ r5) & ((-r12) | r12)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long r10, int r11) {
        long r5 = r11;
        long r12 = r10 / r5;
        if ((r10 ^ r5) < 0) goto L5;
        return r12;
    L5:
        if ((r5 * r12) != r10) goto L7;
        return r12;
    L7:
        return r12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(long r10, int r11) {
        long r5 = r11;
        long r12 = r10 % r5;
        return (int) (r12 + (r5 & (((r12 ^ r5) & ((-r12) | r12)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long r10, long r11) {
        long r5 = r10 / r11;
        if ((r10 ^ r11) < 0) goto L5;
        return r5;
    L5:
        if ((r11 * r5) != r10) goto L7;
        return r5;
    L7:
        return r5 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(long r5, long r10) {
        long r11 = r5 % r10;
        return r11 + (r10 & (((r11 ^ r10) & ((-r11) | r11)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final float mod(float r5, float r10) {
        float r11 = r5 % r10;
        if (r11 != 0.0f) goto L6;
        return r11;
    L6:
        if (Math.signum(r11) != Math.signum(r10)) goto L9;
        return r11;
    L9:
        return r11 + r10;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double mod(float r10, double r11) {
        double r5 = ((double) r10) % r11;
        if (r5 != 0.0d) goto L6;
        return r5;
    L6:
        if (Math.signum(r5) != Math.signum(r11)) goto L9;
        return r5;
    L9:
        return r5 + r11;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double mod(double r10, float r11) {
        double r5 = r11;
        double r12 = r10 % r5;
        if (r12 != 0.0d) goto L6;
        return r12;
    L6:
        if (Math.signum(r12) != Math.signum(r5)) goto L9;
        return r12;
    L9:
        return r12 + r5;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double mod(double r5, double r10) {
        double r11 = r5 % r10;
        if (r11 != 0.0d) goto L6;
        return r11;
    L6:
        if (Math.signum(r11) != Math.signum(r10)) goto L9;
        return r11;
    L9:
        return r11 + r10;
    }
}
