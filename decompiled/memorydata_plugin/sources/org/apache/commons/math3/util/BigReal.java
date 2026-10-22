package org.apache.commons.math3.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class BigReal implements Serializable, Comparable<BigReal>, FieldElement<BigReal> {
    public static final BigReal ONE = null;
    public static final BigReal ZERO = null;
    private static final long serialVersionUID = 4984534880991310382L;
    private final BigDecimal d;
    private RoundingMode roundingMode;
    private int scale;

    static {
        ZERO = new BigReal(BigDecimal.ZERO);
        ONE = new BigReal(BigDecimal.ONE);
    }

    public BigReal(double r2) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2);
    }

    public BigReal(double r2, MathContext r4) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2, r4);
    }

    public BigReal(int r2) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2);
    }

    public BigReal(int r2, MathContext r3) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2, r3);
    }

    public BigReal(long r2) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2);
    }

    public BigReal(long r2, MathContext r4) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2, r4);
    }

    public BigReal(String r2) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2);
    }

    public BigReal(String r2, MathContext r3) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2, r3);
    }

    public BigReal(BigDecimal r2) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = r2;
    }

    public BigReal(BigInteger r2) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2);
    }

    public BigReal(BigInteger r2, int r3) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2, r3);
    }

    public BigReal(BigInteger r2, int r3, MathContext r4) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2, r3, r4);
    }

    public BigReal(BigInteger r2, MathContext r3) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2, r3);
    }

    public BigReal(char[] r2) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2);
    }

    public BigReal(char[] r2, int r3, int r4) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2, r3, r4);
    }

    public BigReal(char[] r2, int r3, int r4, MathContext r5) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2, r3, r4, r5);
    }

    public BigReal(char[] r2, MathContext r3) {
        this.roundingMode = RoundingMode.HALF_UP;
        this.scale = 64;
        this.d = new BigDecimal(r2, r3);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ BigReal add(BigReal r3) {
        return add2((BigReal) ZeusTransformUtils.preCheckCast(r3, BigReal.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public BigReal add2(BigReal r2) {
        return new BigReal(this.d.add(r2.d));
    }

    public BigDecimal bigDecimalValue() {
        return this.d;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(BigReal r3) {
        return compareTo2((BigReal) ZeusTransformUtils.preCheckCast(r3, BigReal.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BigReal r1) {
        return this.d.compareTo(r1.d);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ BigReal divide(BigReal r3) {
        return divide2((BigReal) ZeusTransformUtils.preCheckCast(r3, BigReal.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public BigReal divide2(BigReal r4) {
        return new BigReal(this.d.divide(r4.d, this.scale, this.roundingMode));
    L5:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NOT_ALLOWED, new Object[0]);
    }

    public double doubleValue() {
        return this.d.doubleValue();
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, BigReal.class) == true) goto L9;
        return false;
    L9:
        return this.d.equals(((BigReal) ZeusTransformUtils.preCheckCast(r3, BigReal.class, "com.obric.memorydata.plugin")).d);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<BigReal> getField() {
        return BigRealField.getInstance();
    }

    public RoundingMode getRoundingMode() {
        return this.roundingMode;
    }

    public int getScale() {
        return this.scale;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ BigReal multiply(int r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ BigReal multiply(BigReal r3) {
        return multiply2((BigReal) ZeusTransformUtils.preCheckCast(r3, BigReal.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public BigReal multiply2(int r3) {
        return new BigReal(this.d.multiply(new BigDecimal(r3)));
    }

    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public BigReal multiply2(BigReal r2) {
        return new BigReal(this.d.multiply(r2.d));
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ BigReal negate() {
        return negate2();
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: negate, reason: avoid collision after fix types in other method */
    public BigReal negate2() {
        return new BigReal(this.d.negate());
    }

    public /* bridge */ /* synthetic */ Object reciprocal() {
        return m3126reciprocal();
    }

    /* JADX INFO: renamed from: reciprocal, reason: collision with other method in class */
    public BigReal m3126reciprocal() {
        return new BigReal(BigDecimal.ONE.divide(this.d, this.scale, this.roundingMode));
    L5:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NOT_ALLOWED, new Object[0]);
    }

    public void setRoundingMode(RoundingMode r1) {
        this.roundingMode = r1;
    }

    public void setScale(int r1) {
        this.scale = r1;
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ BigReal subtract(BigReal r3) {
        return subtract2((BigReal) ZeusTransformUtils.preCheckCast(r3, BigReal.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public BigReal subtract2(BigReal r2) {
        return new BigReal(this.d.subtract(r2.d));
    }
}
