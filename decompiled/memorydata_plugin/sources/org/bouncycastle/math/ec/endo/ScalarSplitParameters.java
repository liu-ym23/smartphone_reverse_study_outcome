package org.bouncycastle.math.ec.endo;

import com.bytedance.bdlocation.client.LocationInfoConst;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class ScalarSplitParameters {
    protected final int bits;
    protected final BigInteger g1;
    protected final BigInteger g2;
    protected final BigInteger v1A;
    protected final BigInteger v1B;
    protected final BigInteger v2A;
    protected final BigInteger v2B;

    public ScalarSplitParameters(BigInteger[] r3, BigInteger[] r4, BigInteger r5, BigInteger r6, int r7) {
        checkVector(r3, LocationInfoConst.LIBRA_PARAM_V1);
        checkVector(r4, LocationInfoConst.LIBRA_PARAM_V2);
        this.v1A = r3[0];
        this.v1B = r3[1];
        this.v2A = r4[0];
        this.v2B = r4[1];
        this.g1 = r5;
        this.g2 = r6;
        this.bits = r7;
    }

    private static void checkVector(BigInteger[] r2, String r3) {
        if (r2 == null) goto L11;
        if (r2.length != 2) goto L11;
        if (r2[0] == null) goto L11;
        if (r2[1] == null) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("'" + r3 + "' must consist of exactly 2 (non-null) values");
    }

    public int getBits() {
        return this.bits;
    }

    public BigInteger getG1() {
        return this.g1;
    }

    public BigInteger getG2() {
        return this.g2;
    }

    public BigInteger getV1A() {
        return this.v1A;
    }

    public BigInteger getV1B() {
        return this.v1B;
    }

    public BigInteger getV2A() {
        return this.v2A;
    }

    public BigInteger getV2B() {
        return this.v2B;
    }
}
