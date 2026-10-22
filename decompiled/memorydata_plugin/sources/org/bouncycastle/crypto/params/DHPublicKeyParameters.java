package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Objects;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
public class DHPublicKeyParameters extends DHKeyParameters {
    private static final BigInteger ONE = null;
    private static final BigInteger TWO = null;
    private BigInteger y;

    static {
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
    }

    public DHPublicKeyParameters(BigInteger r2, DHParameters r3) {
        super(false, r3);
        this.y = validate(r2, r3);
    }

    private static int legendre(BigInteger r7, BigInteger r8) {
        int r0 = r8.bitLength();
        int[] r9 = Nat.fromBigInteger(r0, r7);
        int[] r10 = Nat.fromBigInteger(r0, r8);
        int r1 = r10.length;
        int r2 = 0;
    L4:
        if (r9[0] == 0) goto L5;
        int r3 = Integers.numberOfTrailingZeros(r9[0]);
        if (r3 <= 0) goto L9;
        Nat.shiftDownBits(r1, r9, r3, 0);
        int r4 = r10[0];
        r2 = r2 ^ ((r3 << 1) & (r4 ^ (r4 >>> 1)));
    L9:
        int r5 = Nat.compare(r1, r9, r10);
        if (r5 == 0) goto L12;
        if (r5 >= 0) goto L17;
        r2 = r2 ^ (r9[0] & r10[0]);
        int[] r6 = r10;
        r10 = r9;
        r9 = r6;
    L17:
        int r11 = r1 - 1;
        if (r9[r11] != 0) goto L20;
        r1 = r11;
        goto L17
    L20:
        Nat.sub(r1, r9, r10, r9);
        goto L4
    L12:
        if (Nat.isOne(r1, r10) == true) goto L14;
        return 0;
    L14:
        return 1 - (r2 & 2);
    L5:
        Nat.shiftDownWord(r1, r9, 0);
        goto L4
    }

    private BigInteger validate(BigInteger r4, DHParameters r5) {
        Objects.requireNonNull(r4, "y value cannot be null");
        BigInteger r3 = r5.getP();
        BigInteger r0 = TWO;
        if (r4.compareTo(r0) < 0) goto L24;
        if (r4.compareTo(r3.subtract(r0)) > 0) goto L24;
        BigInteger r6 = r5.getQ();
        if (r6 != null) goto L10;
        return r4;
    L10:
        if (r3.testBit(0) == false) goto L19;
        if ((r3.bitLength() - 1) != r6.bitLength()) goto L19;
        if (r3.shiftRight(1).equals(r6) == false) goto L19;
        if (1 != legendre(r4, r3)) goto L22;
        return r4;
    L22:
        throw new IllegalArgumentException("Y value does not appear to be in correct group");
    L19:
        if (ONE.equals(r4.modPow(r6, r3)) == false) goto L22;
        return r4;
    L24:
        throw new IllegalArgumentException("invalid DH public key");
    }

    @Override // org.bouncycastle.crypto.params.DHKeyParameters
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, DHPublicKeyParameters.class) == true) goto L6;
        return false;
    L6:
        if (((DHPublicKeyParameters) ZeusTransformUtils.preCheckCast(r4, DHPublicKeyParameters.class, "com.obric.memorydata.plugin")).getY().equals(this.y) == true) goto L8;
        return false;
    L8:
        if (super.equals(r4) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public BigInteger getY() {
        return this.y;
    }

    @Override // org.bouncycastle.crypto.params.DHKeyParameters
    public int hashCode() {
        int r0 = this.y.hashCode();
        return super.hashCode() ^ r0;
    }
}
