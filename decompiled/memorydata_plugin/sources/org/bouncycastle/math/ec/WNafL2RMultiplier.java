package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
public class WNafL2RMultiplier extends AbstractECMultiplier {
    public WNafL2RMultiplier() {
    }

    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint r10, BigInteger r11) {
        WNafPreCompInfo r9 = WNafUtil.precompute(r10, WNafUtil.getWindowSize(r11.bitLength()), true);
        ECPoint[] r1 = r9.getPreComp();
        ECPoint[] r2 = r9.getPreCompNeg();
        int r12 = r9.getWidth();
        int[] r13 = WNafUtil.generateCompactWindowNaf(r12, r11);
        ECPoint r14 = r10.getCurve().getInfinity();
        int r3 = r13.length;
        if (r3 <= 1) goto L13;
        r3 = r3 - 1;
        int r15 = r13[r3];
        int r5 = r15 >> 16;
        int r16 = r15 & 65535;
        int r6 = Math.abs(r5);
        if (r5 >= 0) goto L7;
        ECPoint[] r7 = r2;
    L9:
        if ((r6 << 2) >= (1 << r12)) goto L11;
        int r8 = 32 - Integers.numberOfLeadingZeros(r6);
        int r17 = r12 - r8;
        ECPoint r18 = r7[((1 << (r12 - 1)) - 1) >>> 1].add(r7[(((r6 ^ (1 << (r8 - 1))) << r17) + 1) >>> 1]);
        r16 = r16 - r17;
    L12:
        r14 = r18.timesPow2(r16);
        goto L13
    L11:
        r18 = r7[r6 >>> 1];
        goto L12
    L7:
        r7 = r1;
    L13:
        if (r3 <= 0) goto L19;
        r3 = r3 - 1;
        int r19 = r13[r3];
        int r20 = r19 >> 16;
        int r21 = r19 & 65535;
        int r22 = Math.abs(r20);
        if (r20 >= 0) goto L17;
        ECPoint[] r23 = r2;
    L18:
        r14 = r14.twicePlus(r23[r22 >>> 1]).timesPow2(r21);
        goto L13
    L17:
        r23 = r1;
        goto L18
    L19:
        return r14;
    }
}
