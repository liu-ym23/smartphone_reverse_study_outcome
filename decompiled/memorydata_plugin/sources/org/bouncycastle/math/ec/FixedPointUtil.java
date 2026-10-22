package org.bouncycastle.math.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class FixedPointUtil {
    public static int getCombSize(ECCurve r1) {
        BigInteger r0 = r1.getOrder();
        if (r0 != null) goto L6;
        return r1.getFieldSize() + 1;
    L6:
        return r0.bitLength();
    }

    public static FixedPointPreCompInfo precompute(final ECPoint r3) {
        final ECCurve r0 = r3.getCurve();
        return (FixedPointPreCompInfo) ZeusTransformUtils.preCheckCast(r0.precompute(r3, "bc_fixed_point", new AnonymousClass1(r0, r3)), FixedPointPreCompInfo.class, "com.obric.memorydata.plugin");
    }
}
