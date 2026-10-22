package org.bouncycastle.jce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes7.dex */
public class ECParameterSpec implements AlgorithmParameterSpec {
    private ECPoint G;
    private ECCurve curve;
    private BigInteger h;
    private BigInteger n;
    private byte[] seed;

    public ECParameterSpec(ECCurve r1, ECPoint r2, BigInteger r3) {
        this.curve = r1;
        this.G = r2.normalize();
        this.n = r3;
        this.h = BigInteger.valueOf(1);
        this.seed = null;
    }

    public ECParameterSpec(ECCurve r1, ECPoint r2, BigInteger r3, BigInteger r4, byte[] r5) {
        this.curve = r1;
        this.G = r2.normalize();
        this.n = r3;
        this.h = r4;
        this.seed = r5;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ECParameterSpec.class) == true) goto L5;
        return false;
    L5:
        ECParameterSpec r5 = (ECParameterSpec) ZeusTransformUtils.preCheckCast(r4, ECParameterSpec.class, "com.obric.memorydata.plugin");
        if (getCurve().equals(r5.getCurve()) == true) goto L8;
        return false;
    L8:
        if (getG().equals(r5.getG()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.G;
    }

    public BigInteger getH() {
        return this.h;
    }

    public BigInteger getN() {
        return this.n;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public int hashCode() {
        int r0 = getCurve().hashCode();
        return getG().hashCode() ^ r0;
    }
}
