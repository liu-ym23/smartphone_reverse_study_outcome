package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class NumbersKt__BigDecimalsKt {
    public NumbersKt__BigDecimalsKt() {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal dec(BigDecimal r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        BigDecimal r11 = r10.subtract(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(r11, "this.subtract(BigDecimal.ONE)");
        return r11;
    }

    @InlineOnly
    private static final BigDecimal div(BigDecimal r10, BigDecimal r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigDecimal r12 = r10.divide(r11, RoundingMode.HALF_EVEN);
        Intrinsics.checkNotNullExpressionValue(r12, "this.divide(other, RoundingMode.HALF_EVEN)");
        return r12;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal inc(BigDecimal r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        BigDecimal r11 = r10.add(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(r11, "this.add(BigDecimal.ONE)");
        return r11;
    }

    @InlineOnly
    private static final BigDecimal minus(BigDecimal r10, BigDecimal r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigDecimal r12 = r10.subtract(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.subtract(other)");
        return r12;
    }

    @InlineOnly
    private static final BigDecimal plus(BigDecimal r10, BigDecimal r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigDecimal r12 = r10.add(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        return r12;
    }

    @InlineOnly
    private static final BigDecimal rem(BigDecimal r10, BigDecimal r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigDecimal r12 = r10.remainder(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.remainder(other)");
        return r12;
    }

    @InlineOnly
    private static final BigDecimal times(BigDecimal r10, BigDecimal r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        BigDecimal r12 = r10.multiply(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.multiply(other)");
        return r12;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(double r10) {
        return new BigDecimal(String.valueOf(r10));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(double r10, MathContext r11) {
        Intrinsics.checkNotNullParameter(r11, "mathContext");
        return new BigDecimal(String.valueOf(r10), r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(float r10) {
        return new BigDecimal(String.valueOf(r10));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(float r10, MathContext r11) {
        Intrinsics.checkNotNullParameter(r11, "mathContext");
        return new BigDecimal(String.valueOf(r10), r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(int r10) {
        BigDecimal r11 = BigDecimal.valueOf(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "valueOf(this.toLong())");
        return r11;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(int r10, MathContext r11) {
        Intrinsics.checkNotNullParameter(r11, "mathContext");
        return new BigDecimal(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(long r10) {
        BigDecimal r11 = BigDecimal.valueOf(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "valueOf(this)");
        return r11;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(long r10, MathContext r11) {
        Intrinsics.checkNotNullParameter(r11, "mathContext");
        return new BigDecimal(r10, r11);
    }

    @InlineOnly
    private static final BigDecimal unaryMinus(BigDecimal r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        BigDecimal r11 = r10.negate();
        Intrinsics.checkNotNullExpressionValue(r11, "this.negate()");
        return r11;
    }
}
