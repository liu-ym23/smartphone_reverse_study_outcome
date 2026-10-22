package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class GLVTypeBParameters {
    protected final BigInteger beta;
    protected final BigInteger lambda;
    protected final ScalarSplitParameters splitParams;

    public GLVTypeBParameters(BigInteger r1, BigInteger r2, ScalarSplitParameters r3) {
        this.beta = r1;
        this.lambda = r2;
        this.splitParams = r3;
    }

    public BigInteger getBeta() {
        return this.beta;
    }

    public ScalarSplitParameters getSplitParams() {
        return this.splitParams;
    }
}
