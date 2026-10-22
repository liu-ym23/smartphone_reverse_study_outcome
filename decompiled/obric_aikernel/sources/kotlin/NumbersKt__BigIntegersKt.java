package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    public NumbersKt__BigIntegersKt() {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger and(BigInteger r10, BigInteger r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigInteger r12 = r10.and(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.and(other)");
        return r12;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger dec(BigInteger r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        BigInteger r11 = r10.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(r11, "this.subtract(BigInteger.ONE)");
        return r11;
    }

    @InlineOnly
    private static final BigInteger div(BigInteger r10, BigInteger r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigInteger r12 = r10.divide(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.divide(other)");
        return r12;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger inc(BigInteger r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        BigInteger r11 = r10.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(r11, "this.add(BigInteger.ONE)");
        return r11;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger inv(BigInteger r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        BigInteger r11 = r10.not();
        Intrinsics.checkNotNullExpressionValue(r11, "this.not()");
        return r11;
    }

    @InlineOnly
    private static final BigInteger minus(BigInteger r10, BigInteger r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigInteger r12 = r10.subtract(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.subtract(other)");
        return r12;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger or(BigInteger r10, BigInteger r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigInteger r12 = r10.or(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.or(other)");
        return r12;
    }

    @InlineOnly
    private static final BigInteger plus(BigInteger r10, BigInteger r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigInteger r12 = r10.add(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        return r12;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final BigInteger rem(BigInteger r10, BigInteger r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigInteger r12 = r10.remainder(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.remainder(other)");
        return r12;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger shl(BigInteger r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        BigInteger r12 = r10.shiftLeft(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.shiftLeft(n)");
        return r12;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger shr(BigInteger r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        BigInteger r12 = r10.shiftRight(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.shiftRight(n)");
        return r12;
    }

    @InlineOnly
    private static final BigInteger times(BigInteger r10, BigInteger r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigInteger r12 = r10.multiply(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.multiply(other)");
        return r12;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(BigInteger r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new BigDecimal(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(BigInteger r10, int r11, MathContext r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "mathContext");
        return new BigDecimal(r10, r11, r12);
    }

    static /* synthetic */ BigDecimal toBigDecimal$default(BigInteger r10, int r11, MathContext r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = MathContext.UNLIMITED;
        Intrinsics.checkNotNullExpressionValue(r12, "UNLIMITED");
    L8:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "mathContext");
        return new BigDecimal(r10, r11, r12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(int r10) {
        BigInteger r11 = BigInteger.valueOf(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "valueOf(this.toLong())");
        return r11;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(long r10) {
        BigInteger r11 = BigInteger.valueOf(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "valueOf(this)");
        return r11;
    }

    @InlineOnly
    private static final BigInteger unaryMinus(BigInteger r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        BigInteger r11 = r10.negate();
        Intrinsics.checkNotNullExpressionValue(r11, "this.negate()");
        return r11;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger xor(BigInteger r10, BigInteger r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigInteger r12 = r10.xor(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.xor(other)");
        return r12;
    }
}
