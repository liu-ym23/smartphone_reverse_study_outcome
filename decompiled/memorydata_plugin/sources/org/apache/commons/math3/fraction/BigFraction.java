package org.apache.commons.math3.fraction;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class BigFraction extends Number implements Serializable, Comparable<BigFraction>, FieldElement<BigFraction> {
    public static final BigFraction FOUR_FIFTHS = null;
    public static final BigFraction MINUS_ONE = null;
    public static final BigFraction ONE = null;
    public static final BigFraction ONE_FIFTH = null;
    public static final BigFraction ONE_HALF = null;
    private static final BigInteger ONE_HUNDRED = null;
    public static final BigFraction ONE_QUARTER = null;
    public static final BigFraction ONE_THIRD = null;
    public static final BigFraction THREE_FIFTHS = null;
    public static final BigFraction THREE_QUARTERS = null;
    public static final BigFraction TWO = null;
    public static final BigFraction TWO_FIFTHS = null;
    public static final BigFraction TWO_QUARTERS = null;
    public static final BigFraction TWO_THIRDS = null;
    public static final BigFraction ZERO = null;
    private static final long serialVersionUID = -5630213147331578515L;
    private final BigInteger denominator;
    private final BigInteger numerator;

    static {
        TWO = new BigFraction(2);
        ONE = new BigFraction(1);
        ZERO = new BigFraction(0);
        MINUS_ONE = new BigFraction(-1);
        FOUR_FIFTHS = new BigFraction(4, 5);
        ONE_FIFTH = new BigFraction(1, 5);
        ONE_HALF = new BigFraction(1, 2);
        ONE_QUARTER = new BigFraction(1, 4);
        ONE_THIRD = new BigFraction(1, 3);
        THREE_FIFTHS = new BigFraction(3, 5);
        THREE_QUARTERS = new BigFraction(3, 4);
        TWO_FIFTHS = new BigFraction(2, 5);
        TWO_QUARTERS = new BigFraction(2, 4);
        TWO_THIRDS = new BigFraction(2, 3);
        ONE_HUNDRED = BigInteger.valueOf(100);
    }

    public BigFraction(double r9) {
        if (Double.isNaN(r9) == true) goto L27;
        if (Double.isInfinite(r9) == true) goto L25;
        long r10 = Double.doubleToLongBits(r9);
        long r0 = Long.MIN_VALUE & r10;
        long r2 = 9218868437227405312L & r10;
        long r11 = r10 & 4503599627370495L;
        if (r2 == 0) goto L10;
        r11 = r11 | 4503599627370496L;
    L10:
        if (r0 == 0) goto L12;
        r11 = -r11;
    L12:
        int r1 = ((int) (r2 >> 52)) - 1075;
    L14:
        if ((9007199254740990L & r11) == 0) goto L18;
        if ((1 & r11) != 0) goto L18;
        r11 = r11 >> 1;
        r1 = r1 + 1;
    L18:
        BigInteger r12 = BigInteger.valueOf(r11);
        if (r1 >= 0) goto L21;
        this.numerator = r12;
        BigInteger r13 = BigInteger.ZERO.flipBit(-r1);
    L22:
        this.denominator = r13;
        return;
    L21:
        this.numerator = r12.multiply(BigInteger.ZERO.flipBit(r1));
        r13 = BigInteger.ONE;
        goto L22
    L25:
        throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_VALUE_CONVERSION, new Object[0]);
    L27:
        throw new MathIllegalArgumentException(LocalizedFormats.NAN_VALUE_CONVERSION, new Object[0]);
    }

    public BigFraction(double r8, double r10, int r12) {
        this(r8, r10, Integer.MAX_VALUE, r12);
    }

    private BigFraction(double r35, double r37, int r39, int r40) {
        long r5 = (long) FastMath.floor(r35);
        if (FastMath.abs(r5) > 2147483647L) goto L41;
        if (FastMath.abs(r5 - r35) >= r37) goto L8;
        this.numerator = BigInteger.valueOf(r5);
        this.denominator = BigInteger.ONE;
        return;
    L8:
        double r19 = r35;
        boolean r14 = false;
        long r15 = 1;
        long r17 = 1;
        int r13 = 0;
        long r11 = 0;
        long r7 = r5;
    L9:
        r13 = r13 + 1;
        double r22 = 1.0d / (r19 - r5);
        long r9 = (long) FastMath.floor(r22);
        long r28 = r5;
        long r6 = (r9 * r7) + r15;
        long r30 = r7;
        long r8 = (r9 * r17) + r11;
        if (r6 > 2147483647L) goto L26;
        if (r8 > 2147483647L) goto L26;
        long r26 = r9;
        long r32 = r11;
        double r10 = r6 / r8;
        if (r13 < r40) goto L17;
    L21:
        r14 = true;
        r26 = r28;
        r11 = r32;
    L22:
        if (r14 == true) goto L29;
        r5 = r26;
        r7 = r30;
    L29:
        if (r13 >= r40) goto L37;
        if (r8 >= r39) goto L33;
        this.numerator = BigInteger.valueOf(r6);
        BigInteger r1 = BigInteger.valueOf(r8);
    L34:
        this.denominator = r1;
        return;
    L33:
        this.numerator = BigInteger.valueOf(r30);
        r1 = BigInteger.valueOf(r17);
        goto L34
    L37:
        throw new FractionConversionException(r35, r40);
    L17:
        if (FastMath.abs(r10 - r35) <= r37) goto L21;
        if (r8 >= r39) goto L21;
        r11 = r17;
        r19 = r22;
        r15 = r30;
        r30 = r6;
        r17 = r8;
    L26:
        if (r37 != 0.0d) goto L39;
        if (FastMath.abs(r17) < r39) goto L29;
    L39:
        throw new FractionConversionException(r35, r6, r8);
    L41:
        throw new FractionConversionException(r35, r5, 1);
    }

    public BigFraction(double r8, int r10) {
        this(r8, 0.0d, r10, 100);
    }

    public BigFraction(int r3) {
        this(BigInteger.valueOf(r3), BigInteger.ONE);
    }

    public BigFraction(int r3, int r4) {
        this(BigInteger.valueOf(r3), BigInteger.valueOf(r4));
    }

    public BigFraction(long r1) {
        this(BigInteger.valueOf(r1), BigInteger.ONE);
    }

    public BigFraction(long r1, long r3) {
        this(BigInteger.valueOf(r1), BigInteger.valueOf(r3));
    }

    public BigFraction(BigInteger r2) {
        this(r2, BigInteger.ONE);
    }

    public BigFraction(BigInteger r4, BigInteger r5) {
        MathUtils.checkNotNull(r4, LocalizedFormats.NUMERATOR, new Object[0]);
        MathUtils.checkNotNull(r5, LocalizedFormats.DENOMINATOR, new Object[0]);
        if (r5.signum() == 0) goto L16;
        if (r4.signum() != 0) goto L7;
        this.numerator = BigInteger.ZERO;
        this.denominator = BigInteger.ONE;
        return;
    L7:
        BigInteger r0 = r4.gcd(r5);
        if (BigInteger.ONE.compareTo(r0) >= 0) goto L11;
        r4 = r4.divide(r0);
        r5 = r5.divide(r0);
    L11:
        if (r5.signum() != (-1)) goto L13;
        r4 = r4.negate();
        r5 = r5.negate();
    L13:
        this.numerator = r4;
        this.denominator = r5;
        return;
    L16:
        throw new ZeroException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    }

    public static BigFraction getReducedFraction(int r1, int r2) {
        if (r1 != 0) goto L6;
        return ZERO;
    L6:
        return new BigFraction(r1, r2);
    }

    public BigFraction abs() {
        if (this.numerator.signum() != 1) goto L6;
        return this;
    L6:
        return negate2();
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ BigFraction add(BigFraction r3) {
        return add2((BigFraction) ZeusTransformUtils.preCheckCast(r3, BigFraction.class, "com.obric.memorydata.plugin"));
    }

    public BigFraction add(int r3) {
        return add(BigInteger.valueOf(r3));
    }

    public BigFraction add(long r1) {
        return add(BigInteger.valueOf(r1));
    }

    public BigFraction add(BigInteger r4) {
        MathUtils.checkNotNull(r4);
        if (this.numerator.signum() != 0) goto L7;
        return new BigFraction(r4);
    L7:
        if (r4.signum() != 0) goto L10;
        return this;
    L10:
        return new BigFraction(this.numerator.add(this.denominator.multiply(r4)), this.denominator);
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public BigFraction add2(BigFraction r4) {
        if (r4 == null) goto L20;
        if (r4.numerator.signum() != 0) goto L7;
        return this;
    L7:
        if (this.numerator.signum() != 0) goto L10;
        return r4;
    L10:
        if (this.denominator.equals(r4.denominator) == false) goto L12;
        BigInteger r5 = this.numerator.add(r4.numerator);
        BigInteger r3 = this.denominator;
    L14:
        if (r5.signum() != 0) goto L18;
        return ZERO;
    L18:
        return new BigFraction(r5, r3);
    L12:
        BigInteger r0 = this.numerator.multiply(r4.denominator).add(r4.numerator.multiply(this.denominator));
        r3 = this.denominator.multiply(r4.denominator);
        r5 = r0;
        goto L14
    L20:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    public BigDecimal bigDecimalValue() {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator));
    }

    public BigDecimal bigDecimalValue(int r3) {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator), r3);
    }

    public BigDecimal bigDecimalValue(int r3, int r4) {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator), r3, r4);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(BigFraction r3) {
        return compareTo2((BigFraction) ZeusTransformUtils.preCheckCast(r3, BigFraction.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BigFraction r3) {
        int r0 = this.numerator.signum();
        int r1 = r3.numerator.signum();
        if (r0 == r1) goto L8;
        if (r0 <= r1) goto L6;
        return 1;
    L6:
        return -1;
    L8:
        if (r0 != 0) goto L12;
        return 0;
    L12:
        return this.numerator.multiply(r3.denominator).compareTo(this.denominator.multiply(r3.numerator));
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ BigFraction divide(BigFraction r3) {
        return divide2((BigFraction) ZeusTransformUtils.preCheckCast(r3, BigFraction.class, "com.obric.memorydata.plugin"));
    }

    public BigFraction divide(int r3) {
        return divide(BigInteger.valueOf(r3));
    }

    public BigFraction divide(long r1) {
        return divide(BigInteger.valueOf(r1));
    }

    public BigFraction divide(BigInteger r3) {
        if (r3 == null) goto L15;
        if (r3.signum() == 0) goto L13;
        if (this.numerator.signum() != 0) goto L11;
        return ZERO;
    L11:
        return new BigFraction(this.numerator, this.denominator.multiply(r3));
    L13:
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    L15:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public BigFraction divide2(BigFraction r3) {
        if (r3 == null) goto L15;
        if (r3.numerator.signum() == 0) goto L13;
        if (this.numerator.signum() != 0) goto L11;
        return ZERO;
    L11:
        return multiply2(r3.m3122reciprocal());
    L13:
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    L15:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        double r0 = this.numerator.doubleValue() / this.denominator.doubleValue();
        if (Double.isNaN(r0) == false) goto L6;
        int r1 = FastMath.max(this.numerator.bitLength(), this.denominator.bitLength()) - FastMath.getExponent(Double.MAX_VALUE);
        return this.numerator.shiftRight(r1).doubleValue() / this.denominator.shiftRight(r1).doubleValue();
    L6:
        return r0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BigFraction.class) == false) goto L13;
        BigFraction r6 = ((BigFraction) ZeusTransformUtils.preCheckCast(r5, BigFraction.class, "com.obric.memorydata.plugin")).reduce();
        BigFraction r4 = reduce();
        if (r4.numerator.equals(r6.numerator) == false) goto L13;
        if (r4.denominator.equals(r6.denominator) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        float r0 = this.numerator.floatValue() / this.denominator.floatValue();
        if (Double.isNaN(r0) == false) goto L6;
        int r1 = FastMath.max(this.numerator.bitLength(), this.denominator.bitLength()) - FastMath.getExponent(Float.MAX_VALUE);
        return this.numerator.shiftRight(r1).floatValue() / this.denominator.shiftRight(r1).floatValue();
    L6:
        return r0;
    }

    public BigInteger getDenominator() {
        return this.denominator;
    }

    public int getDenominatorAsInt() {
        return this.denominator.intValue();
    }

    public long getDenominatorAsLong() {
        return this.denominator.longValue();
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Field<BigFraction> getField() {
        return getField2();
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: getField, reason: avoid collision after fix types in other method */
    public Field<BigFraction> getField2() {
        return BigFractionField.getInstance();
    }

    public BigInteger getNumerator() {
        return this.numerator;
    }

    public int getNumeratorAsInt() {
        return this.numerator.intValue();
    }

    public long getNumeratorAsLong() {
        return this.numerator.longValue();
    }

    public int hashCode() {
        return ((this.numerator.hashCode() + 629) * 37) + this.denominator.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.numerator.divide(this.denominator).intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.numerator.divide(this.denominator).longValue();
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ BigFraction multiply(int r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ BigFraction multiply(BigFraction r3) {
        return multiply2((BigFraction) ZeusTransformUtils.preCheckCast(r3, BigFraction.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public BigFraction multiply2(int r3) {
        if (r3 == 0) goto L9;
        if (this.numerator.signum() == 0) goto L9;
        return multiply(BigInteger.valueOf(r3));
    L9:
        return ZERO;
    }

    public BigFraction multiply(long r3) {
        if (r3 == 0) goto L10;
        if (this.numerator.signum() == 0) goto L10;
        return multiply(BigInteger.valueOf(r3));
    L10:
        return ZERO;
    }

    public BigFraction multiply(BigInteger r3) {
        if (r3 == null) goto L13;
        if (this.numerator.signum() == 0) goto L11;
        if (r3.signum() == 0) goto L11;
        return new BigFraction(r3.multiply(this.numerator), this.denominator);
    L11:
        return ZERO;
    L13:
        throw new NullArgumentException();
    }

    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public BigFraction multiply2(BigFraction r4) {
        if (r4 == null) goto L13;
        if (this.numerator.signum() == 0) goto L11;
        if (r4.numerator.signum() == 0) goto L11;
        return new BigFraction(this.numerator.multiply(r4.numerator), this.denominator.multiply(r4.denominator));
    L11:
        return ZERO;
    L13:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ BigFraction negate() {
        return negate2();
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: negate, reason: avoid collision after fix types in other method */
    public BigFraction negate2() {
        return new BigFraction(this.numerator.negate(), this.denominator);
    }

    public double percentageValue() {
        return multiply(ONE_HUNDRED).doubleValue();
    }

    public double pow(double r5) {
        return FastMath.pow(this.numerator.doubleValue(), r5) / FastMath.pow(this.denominator.doubleValue(), r5);
    }

    public BigFraction pow(int r3) {
        if (r3 != 0) goto L6;
        return ONE;
    L6:
        if (this.numerator.signum() != 0) goto L9;
        return this;
    L9:
        if (r3 >= 0) goto L13;
        int r4 = -r3;
        return new BigFraction(this.denominator.pow(r4), this.numerator.pow(r4));
    L13:
        return new BigFraction(this.numerator.pow(r3), this.denominator.pow(r3));
    }

    public BigFraction pow(long r3) {
        if (r3 != 0) goto L7;
        return ONE;
    L7:
        if (this.numerator.signum() != 0) goto L9;
        return this;
    L9:
        if (r3 >= 0) goto L13;
        long r4 = -r3;
        return new BigFraction(ArithmeticUtils.pow(this.denominator, r4), ArithmeticUtils.pow(this.numerator, r4));
    L13:
        return new BigFraction(ArithmeticUtils.pow(this.numerator, r3), ArithmeticUtils.pow(this.denominator, r3));
    }

    public BigFraction pow(BigInteger r3) {
        if (r3.signum() != 0) goto L7;
        return ONE;
    L7:
        if (this.numerator.signum() != 0) goto L10;
        return this;
    L10:
        if (r3.signum() != (-1)) goto L14;
        BigInteger r4 = r3.negate();
        return new BigFraction(ArithmeticUtils.pow(this.denominator, r4), ArithmeticUtils.pow(this.numerator, r4));
    L14:
        return new BigFraction(ArithmeticUtils.pow(this.numerator, r3), ArithmeticUtils.pow(this.denominator, r3));
    }

    public /* bridge */ /* synthetic */ Object reciprocal() {
        return m3122reciprocal();
    }

    /* JADX INFO: renamed from: reciprocal, reason: collision with other method in class */
    public BigFraction m3122reciprocal() {
        return new BigFraction(this.denominator, this.numerator);
    }

    public BigFraction reduce() {
        BigInteger r0 = this.numerator.gcd(this.denominator);
        if (BigInteger.ONE.compareTo(r0) < 0) goto L5;
        return this;
    L5:
        return new BigFraction(this.numerator.divide(r0), this.denominator.divide(r0));
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ BigFraction subtract(BigFraction r3) {
        return subtract2((BigFraction) ZeusTransformUtils.preCheckCast(r3, BigFraction.class, "com.obric.memorydata.plugin"));
    }

    public BigFraction subtract(int r3) {
        return subtract(BigInteger.valueOf(r3));
    }

    public BigFraction subtract(long r1) {
        return subtract(BigInteger.valueOf(r1));
    }

    public BigFraction subtract(BigInteger r4) {
        if (r4 == null) goto L13;
        if (r4.signum() != 0) goto L7;
        return this;
    L7:
        if (this.numerator.signum() != 0) goto L11;
        return new BigFraction(r4.negate());
    L11:
        return new BigFraction(this.numerator.subtract(this.denominator.multiply(r4)), this.denominator);
    L13:
        throw new NullArgumentException();
    }

    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public BigFraction subtract2(BigFraction r4) {
        if (r4 == null) goto L17;
        if (r4.numerator.signum() != 0) goto L7;
        return this;
    L7:
        if (this.numerator.signum() != 0) goto L11;
        return r4.negate2();
    L11:
        if (this.denominator.equals(r4.denominator) == false) goto L13;
        BigInteger r5 = this.numerator.subtract(r4.numerator);
        BigInteger r3 = this.denominator;
    L15:
        return new BigFraction(r5, r3);
    L13:
        BigInteger r0 = this.numerator.multiply(r4.denominator).subtract(r4.numerator.multiply(this.denominator));
        r3 = this.denominator.multiply(r4.denominator);
        r5 = r0;
        goto L15
    L17:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    public String toString() {
        if (BigInteger.ONE.equals(this.denominator) == false) goto L6;
        return this.numerator.toString();
    L6:
        if (BigInteger.ZERO.equals(this.numerator) == false) goto L9;
        return "0";
    L9:
        return this.numerator + " / " + this.denominator;
    }
}
