package org.bouncycastle.math.ec.endo;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes7.dex */
public abstract class EndoUtil {
    private static BigInteger calculateB(BigInteger r1, BigInteger r2, int r3) {
        if (r2.signum() >= 0) goto L5;
        boolean r0 = true;
    L6:
        BigInteger r4 = r1.multiply(r2.abs());
        boolean r5 = r4.testBit(r3 - 1);
        BigInteger r6 = r4.shiftRight(r3);
        if (r5 == false) goto L9;
        r6 = r6.add(ECConstants.ONE);
    L9:
        if (r0 == true) goto L11;
        return r6;
    L11:
        return r6.negate();
    L5:
        r0 = false;
        goto L6
    }

    public static BigInteger[] decomposeScalar(ScalarSplitParameters r4, BigInteger r5) {
        int r0 = r4.getBits();
        BigInteger r1 = calculateB(r5, r4.getG1(), r0);
        BigInteger r2 = calculateB(r5, r4.getG2(), r0);
        return new BigInteger[]{r5.subtract(r1.multiply(r4.getV1A()).add(r2.multiply(r4.getV2A()))), r1.multiply(r4.getV1B()).add(r2.multiply(r4.getV2B())).negate()};
    }

    public static ECPoint mapPoint(ECEndomorphism r3, final ECPoint r4) {
        final ECEndomorphism r5 = (ECEndomorphism) ZeusTransformUtils.wrapperContextForParams(r3, ECEndomorphism.class, "com.obric.memorydata.plugin");
        return ((EndoPreCompInfo) ZeusTransformUtils.preCheckCast(r4.getCurve().precompute(r4, "bc_endo", new AnonymousClass1(r5, r4)), EndoPreCompInfo.class, "com.obric.memorydata.plugin")).getMappedPoint();
    }
}
