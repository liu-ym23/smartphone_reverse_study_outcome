package org.bouncycastle.math.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
class SimpleBigDecimal {
    private final BigInteger bigInt;
    private final int scale;

    public SimpleBigDecimal(BigInteger r1, int r2) {
        if (r2 < 0) goto L7;
        this.bigInt = r1;
        this.scale = r2;
        return;
    L7:
        throw new IllegalArgumentException("scale may not be negative");
    }

    private void checkScale(SimpleBigDecimal r1) {
        if (this.scale != r1.scale) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
    }

    public SimpleBigDecimal add(SimpleBigDecimal r3) {
        checkScale(r3);
        return new SimpleBigDecimal(this.bigInt.add(r3.bigInt), this.scale);
    }

    public SimpleBigDecimal adjustScale(int r3) {
        if (r3 < 0) goto L9;
        if (r3 != this.scale) goto L7;
        return this;
    L7:
        return new SimpleBigDecimal(this.bigInt.shiftLeft(r3 - this.scale), r3);
    L9:
        throw new IllegalArgumentException("scale may not be negative");
    }

    public int compareTo(BigInteger r2) {
        return this.bigInt.compareTo(r2.shiftLeft(this.scale));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SimpleBigDecimal.class) == true) goto L8;
        return false;
    L8:
        SimpleBigDecimal r6 = (SimpleBigDecimal) ZeusTransformUtils.preCheckCast(r5, SimpleBigDecimal.class, "com.obric.memorydata.plugin");
        if (this.bigInt.equals(r6.bigInt) == false) goto L14;
        if (this.scale != r6.scale) goto L14;
        return true;
    L14:
        return false;
    }

    public BigInteger floor() {
        return this.bigInt.shiftRight(this.scale);
    }

    public int getScale() {
        return this.scale;
    }

    public int hashCode() {
        int r0 = this.bigInt.hashCode();
        return this.scale ^ r0;
    }

    public SimpleBigDecimal negate() {
        return new SimpleBigDecimal(this.bigInt.negate(), this.scale);
    }

    public BigInteger round() {
        return add(new SimpleBigDecimal(ECConstants.ONE, 1).adjustScale(this.scale)).floor();
    }

    public SimpleBigDecimal subtract(BigInteger r4) {
        return new SimpleBigDecimal(this.bigInt.subtract(r4.shiftLeft(this.scale)), this.scale);
    }

    public SimpleBigDecimal subtract(SimpleBigDecimal r1) {
        return add(r1.negate());
    }

    public String toString() {
        if (this.scale == 0) goto L5;
        BigInteger r0 = floor();
        BigInteger r1 = this.bigInt.subtract(r0.shiftLeft(this.scale));
        if (this.bigInt.signum() != (-1)) goto L10;
        r1 = ECConstants.ONE.shiftLeft(this.scale).subtract(r1);
    L10:
        if (r0.signum() == (-1)) goto L12;
    L14:
        String r2 = r0.toString();
        char[] r3 = new char[this.scale];
        String r4 = r1.toString(2);
        int r5 = r4.length();
        int r7 = this.scale - r5;
        int r6 = 0;
        int r8 = 0;
    L15:
        if (r8 >= r7) goto L17;
        r3[r8] = '0';
        r8 = r8 + 1;
    L17:
        if (r6 >= r5) goto L19;
        r3[r7 + r6] = r4.charAt(r6);
        r6 = r6 + 1;
        goto L17
    L19:
        String r9 = new String(r3);
        StringBuffer r10 = new StringBuffer(r2);
        r10.append(".");
        r10.append(r9);
        return r10.toString();
    L12:
        if (r1.equals(ECConstants.ZERO) == true) goto L14;
        r0 = r0.add(ECConstants.ONE);
        goto L14
    L5:
        return this.bigInt.toString();
    }
}
