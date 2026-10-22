package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\rH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000eH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000fH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u0001*\u00020\u0001H\u0087\n¨\u0006\u0011"}, d2 = {"dec", "Ljava/math/BigDecimal;", "div", "other", "inc", "minus", "plus", "rem", "times", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "unaryMinus", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__BigDecimalsKt {
    public NumbersKt__BigDecimalsKt() {
    }

    private static final BigDecimal dec(BigDecimal r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        BigDecimal r2 = r1.subtract(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(r2, "subtract(...)");
        return r2;
    }

    private static final BigDecimal div(BigDecimal r1, BigDecimal r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigDecimal r3 = r1.divide(r2, RoundingMode.HALF_EVEN);
        Intrinsics.checkNotNullExpressionValue(r3, "divide(...)");
        return r3;
    }

    private static final BigDecimal inc(BigDecimal r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        BigDecimal r2 = r1.add(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(r2, "add(...)");
        return r2;
    }

    private static final BigDecimal minus(BigDecimal r1, BigDecimal r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigDecimal r3 = r1.subtract(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "subtract(...)");
        return r3;
    }

    private static final BigDecimal plus(BigDecimal r1, BigDecimal r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigDecimal r3 = r1.add(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "add(...)");
        return r3;
    }

    private static final BigDecimal rem(BigDecimal r1, BigDecimal r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigDecimal r3 = r1.remainder(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "remainder(...)");
        return r3;
    }

    private static final BigDecimal times(BigDecimal r1, BigDecimal r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        BigDecimal r3 = r1.multiply(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "multiply(...)");
        return r3;
    }

    private static final BigDecimal toBigDecimal(double r1) {
        return new BigDecimal(String.valueOf(r1));
    }

    private static final BigDecimal toBigDecimal(double r1, MathContext r3) {
        Intrinsics.checkNotNullParameter(r3, "mathContext");
        return new BigDecimal(String.valueOf(r1), r3);
    }

    private static final BigDecimal toBigDecimal(float r1) {
        return new BigDecimal(String.valueOf(r1));
    }

    private static final BigDecimal toBigDecimal(float r1, MathContext r2) {
        Intrinsics.checkNotNullParameter(r2, "mathContext");
        return new BigDecimal(String.valueOf(r1), r2);
    }

    private static final BigDecimal toBigDecimal(int r2) {
        BigDecimal r3 = BigDecimal.valueOf(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "valueOf(...)");
        return r3;
    }

    private static final BigDecimal toBigDecimal(int r1, MathContext r2) {
        Intrinsics.checkNotNullParameter(r2, "mathContext");
        return new BigDecimal(r1, r2);
    }

    private static final BigDecimal toBigDecimal(long r0) {
        BigDecimal r1 = BigDecimal.valueOf(r0);
        Intrinsics.checkNotNullExpressionValue(r1, "valueOf(...)");
        return r1;
    }

    private static final BigDecimal toBigDecimal(long r1, MathContext r3) {
        Intrinsics.checkNotNullParameter(r3, "mathContext");
        return new BigDecimal(r1, r3);
    }

    private static final BigDecimal unaryMinus(BigDecimal r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        BigDecimal r2 = r1.negate();
        Intrinsics.checkNotNullExpressionValue(r2, "negate(...)");
        return r2;
    }
}
