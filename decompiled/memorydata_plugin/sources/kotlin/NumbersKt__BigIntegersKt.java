package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\u0087\b\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\rH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f¨\u0006\u0019"}, d2 = {"and", "Ljava/math/BigInteger;", "other", "dec", "div", "inc", "inv", "minus", "or", "plus", "rem", "shl", "n", "", "shr", "times", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "toBigInteger", "", "unaryMinus", "xor", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    public NumbersKt__BigIntegersKt() {
    }

    private static final BigInteger and(BigInteger r1, BigInteger r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigInteger r3 = r1.and(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "and(...)");
        return r3;
    }

    private static final BigInteger dec(BigInteger r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        BigInteger r2 = r1.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(r2, "subtract(...)");
        return r2;
    }

    private static final BigInteger div(BigInteger r1, BigInteger r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigInteger r3 = r1.divide(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "divide(...)");
        return r3;
    }

    private static final BigInteger inc(BigInteger r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        BigInteger r2 = r1.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(r2, "add(...)");
        return r2;
    }

    private static final BigInteger inv(BigInteger r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        BigInteger r2 = r1.not();
        Intrinsics.checkNotNullExpressionValue(r2, "not(...)");
        return r2;
    }

    private static final BigInteger minus(BigInteger r1, BigInteger r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigInteger r3 = r1.subtract(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "subtract(...)");
        return r3;
    }

    private static final BigInteger or(BigInteger r1, BigInteger r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigInteger r3 = r1.or(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "or(...)");
        return r3;
    }

    private static final BigInteger plus(BigInteger r1, BigInteger r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigInteger r3 = r1.add(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "add(...)");
        return r3;
    }

    private static final BigInteger rem(BigInteger r1, BigInteger r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigInteger r3 = r1.remainder(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "remainder(...)");
        return r3;
    }

    private static final BigInteger shl(BigInteger r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        BigInteger r3 = r1.shiftLeft(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "shiftLeft(...)");
        return r3;
    }

    private static final BigInteger shr(BigInteger r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        BigInteger r3 = r1.shiftRight(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "shiftRight(...)");
        return r3;
    }

    private static final BigInteger times(BigInteger r1, BigInteger r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigInteger r3 = r1.multiply(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "multiply(...)");
        return r3;
    }

    private static final BigDecimal toBigDecimal(BigInteger r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new BigDecimal(r1);
    }

    private static final BigDecimal toBigDecimal(BigInteger r1, int r2, MathContext r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "mathContext");
        return new BigDecimal(r1, r2, r3);
    }

    static /* synthetic */ BigDecimal toBigDecimal$default(BigInteger r0, int r1, MathContext r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = MathContext.UNLIMITED;
        Intrinsics.checkNotNullExpressionValue(r2, "UNLIMITED");
    L8:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r2, "mathContext");
        return new BigDecimal(r0, r1, r2);
    }

    private static final BigInteger toBigInteger(int r2) {
        BigInteger r3 = BigInteger.valueOf(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "valueOf(...)");
        return r3;
    }

    private static final BigInteger toBigInteger(long r0) {
        BigInteger r1 = BigInteger.valueOf(r0);
        Intrinsics.checkNotNullExpressionValue(r1, "valueOf(...)");
        return r1;
    }

    private static final BigInteger unaryMinus(BigInteger r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        BigInteger r2 = r1.negate();
        Intrinsics.checkNotNullExpressionValue(r2, "negate(...)");
        return r2;
    }

    private static final BigInteger xor(BigInteger r1, BigInteger r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigInteger r3 = r1.xor(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "xor(...)");
        return r3;
    }
}
