package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;

/* JADX INFO: loaded from: classes7.dex */
public class FixedPointCombMultiplier extends AbstractECMultiplier {
    public FixedPointCombMultiplier() {
    }

    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint r10, BigInteger r11) {
        ECCurve r9 = r10.getCurve();
        int r0 = FixedPointUtil.getCombSize(r9);
        if (r11.bitLength() > r0) goto L13;
        FixedPointPreCompInfo r12 = FixedPointUtil.precompute(r10);
        ECLookupTable r1 = r12.getLookupTable();
        int r2 = r12.getWidth();
        int r3 = ((r0 + r2) - 1) / r2;
        ECPoint r13 = r9.getInfinity();
        int r4 = r2 * r3;
        int[] r14 = Nat.fromBigInteger(r4, r11);
        int r5 = r4 - 1;
        int r6 = 0;
    L5:
        if (r6 >= r3) goto L11;
        int r7 = r5 - r6;
        int r8 = 0;
    L7:
        if (r7 < 0) goto L9;
        int r15 = r14[r7 >>> 5] >>> (r7 & 31);
        r8 = ((r8 ^ (r15 >>> 1)) << 1) ^ r15;
        r7 = r7 - r3;
        goto L7
    L9:
        r13 = r13.twicePlus(r1.lookup(r8));
        r6 = r6 + 1;
        goto L5
    L11:
        return r13.add(r12.getOffset());
    L13:
        throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
    }
}
