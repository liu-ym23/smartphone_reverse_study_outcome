package org.bouncycastle.math.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.math.ec.endo.EndoUtil;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;

/* JADX INFO: loaded from: classes7.dex */
public class GLVMultiplier extends AbstractECMultiplier {
    protected final ECCurve curve;
    protected final GLVEndomorphism glvEndomorphism;

    public GLVMultiplier(ECCurve r3, GLVEndomorphism r4) {
        GLVEndomorphism r5 = (GLVEndomorphism) ZeusTransformUtils.wrapperContextForParams(r4, GLVEndomorphism.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        if (r3.getOrder() == null) goto L9;
        this.curve = r3;
        this.glvEndomorphism = r5;
        return;
    L9:
        throw new IllegalArgumentException("Need curve with known group order");
    }

    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint r3, BigInteger r4) {
        if (this.curve.equals(r3.getCurve()) == false) goto L11;
        BigInteger r0 = r3.getCurve().getOrder();
        BigInteger[] r5 = this.glvEndomorphism.decomposeScalar(r4.mod(r0));
        BigInteger r1 = r5[0];
        BigInteger r6 = r5[1];
        boolean r2 = this.glvEndomorphism.hasEfficientPointMap();
        GLVEndomorphism r7 = this.glvEndomorphism;
        if (r2 == false) goto L9;
        return ECAlgorithms.implShamirsTrickWNaf(r7, r3, r1, r6);
    L9:
        return ECAlgorithms.implShamirsTrickWNaf(r3, r1, EndoUtil.mapPoint(r7, r3), r6);
    L11:
        throw new IllegalStateException();
    }
}
