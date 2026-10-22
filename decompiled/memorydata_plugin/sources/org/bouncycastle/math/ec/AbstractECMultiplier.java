package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractECMultiplier implements ECMultiplier {
    public AbstractECMultiplier() {
    }

    public ECPoint checkResult(ECPoint r1) {
        return ECAlgorithms.implCheckResult(r1);
    }

    @Override // org.bouncycastle.math.ec.ECMultiplier
    public ECPoint multiply(ECPoint r3, BigInteger r4) {
        int r0 = r4.signum();
        if (r0 == 0) goto L14;
        if (r3.isInfinity() == true) goto L14;
        ECPoint r5 = multiplyPositive(r3, r4.abs());
        if (r0 > 0) goto L12;
        r5 = r5.negate();
    L12:
        return checkResult(r5);
    L14:
        return r3.getCurve().getInfinity();
    }

    public abstract ECPoint multiplyPositive(ECPoint r1, BigInteger r2);
}
