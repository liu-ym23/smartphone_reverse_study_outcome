package org.bouncycastle.math.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class WTauNafMultiplier extends AbstractECMultiplier {
    public WTauNafMultiplier() {
    }

    private static ECPoint.AbstractF2m multiplyFromWTnaf(final ECPoint.AbstractF2m r7, byte[] r8) {
        ECCurve.AbstractF2m r0 = (ECCurve.AbstractF2m) ZeusTransformUtils.preCheckCast(r7.getCurve(), ECCurve.AbstractF2m.class, "com.obric.memorydata.plugin");
        final byte r1 = r0.getA().toBigInteger().byteValue();
        ECPoint.AbstractF2m[] r2 = ((WTauNafPreCompInfo) ZeusTransformUtils.preCheckCast(r0.precompute(r7, "bc_wtnaf", new AnonymousClass1(r7, r1)), WTauNafPreCompInfo.class, "com.obric.memorydata.plugin")).getPreComp();
        ECPoint.AbstractF2m[] r3 = new ECPoint.AbstractF2m[r2.length];
        int r4 = 0;
    L4:
        if (r4 >= r2.length) goto L6;
        r3[r4] = (ECPoint.AbstractF2m) ZeusTransformUtils.preCheckCast(r2[r4].negate(), ECPoint.AbstractF2m.class, "com.obric.memorydata.plugin");
        r4 = r4 + 1;
        goto L4
    L6:
        ECPoint.AbstractF2m r9 = (ECPoint.AbstractF2m) ZeusTransformUtils.preCheckCast(r7.getCurve().getInfinity(), ECPoint.AbstractF2m.class, "com.obric.memorydata.plugin");
        int r5 = r8.length - 1;
        int r6 = 0;
    L7:
        if (r5 < 0) goto L16;
        r6 = r6 + 1;
        byte r10 = r8[r5];
        if (r10 == 0) goto L15;
        ECPoint.AbstractF2m r11 = r9.tauPow(r6);
        if (r10 <= 0) goto L13;
        ECPoint.AbstractF2m r12 = r2[r10 >>> 1];
    L14:
        r9 = (ECPoint.AbstractF2m) ZeusTransformUtils.preCheckCast(r11.add(r12), ECPoint.AbstractF2m.class, "com.obric.memorydata.plugin");
        r6 = 0;
        goto L15
    L13:
        r12 = r3[(-r10) >>> 1];
    L15:
        r5 = r5 - 1;
        goto L7
    L16:
        if (r6 > 0) goto L18;
        return r9;
    L18:
        return r9.tauPow(r6);
    }

    private ECPoint.AbstractF2m multiplyWTnaf(ECPoint.AbstractF2m r7, ZTauElement r8, byte r9, byte r10) {
        if (r9 != 0) goto L4;
        ZTauElement[] r6 = Tnaf.alpha0;
    L5:
        BigInteger r4 = Tnaf.getTw(r10, 4);
        BigInteger r3 = BigInteger.valueOf(16);
        return multiplyFromWTnaf(r7, Tnaf.tauAdicWNaf(r10, r8, (byte) 4, r3, r4, r6));
    L4:
        r6 = Tnaf.alpha1;
        goto L5
    }

    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint r10, BigInteger r11) {
        if (ZeusTransformUtils.instanceOf(r10, ECPoint.AbstractF2m.class) == false) goto L7;
        ECPoint.AbstractF2m r12 = (ECPoint.AbstractF2m) ZeusTransformUtils.preCheckCast(r10, ECPoint.AbstractF2m.class, "com.obric.memorydata.plugin");
        ECCurve.AbstractF2m r0 = (ECCurve.AbstractF2m) ZeusTransformUtils.preCheckCast(r12.getCurve(), ECCurve.AbstractF2m.class, "com.obric.memorydata.plugin");
        int r2 = r0.getFieldSize();
        byte r7 = r0.getA().toBigInteger().byteValue();
        byte r8 = Tnaf.getMu(r7);
        return multiplyWTnaf(r12, Tnaf.partModReduction(r11, r2, r7, r0.getSi(), r8, (byte) 10), r7, r8);
    L7:
        throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be used in WTauNafMultiplier");
    }
}
