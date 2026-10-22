package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {
    private BigInteger dP;
    private BigInteger dQ;
    private BigInteger e;
    private BigInteger p;
    private BigInteger q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger r11, BigInteger r12, BigInteger r13, BigInteger r14, BigInteger r15, BigInteger r16, BigInteger r17, BigInteger r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, false);
    }

    public RSAPrivateCrtKeyParameters(BigInteger r2, BigInteger r3, BigInteger r4, BigInteger r5, BigInteger r6, BigInteger r7, BigInteger r8, BigInteger r9, boolean r10) {
        super(true, r2, r4, r10);
        this.e = r3;
        this.p = r5;
        this.q = r6;
        this.dP = r7;
        this.dQ = r8;
        this.qInv = r9;
    }

    public BigInteger getDP() {
        return this.dP;
    }

    public BigInteger getDQ() {
        return this.dQ;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getPublicExponent() {
        return this.e;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}
