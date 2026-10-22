package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class DSAParameters implements CipherParameters {
    private BigInteger g;
    private BigInteger p;
    private BigInteger q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger r1, BigInteger r2, BigInteger r3) {
        this.g = r3;
        this.p = r1;
        this.q = r2;
    }

    public DSAParameters(BigInteger r1, BigInteger r2, BigInteger r3, DSAValidationParameters r4) {
        this.g = r3;
        this.p = r1;
        this.q = r2;
        this.validation = r4;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, DSAParameters.class) == true) goto L5;
        return false;
    L5:
        DSAParameters r5 = (DSAParameters) ZeusTransformUtils.preCheckCast(r4, DSAParameters.class, "com.obric.memorydata.plugin");
        if (r5.getP().equals(this.p) == true) goto L8;
        return false;
    L8:
        if (r5.getQ().equals(this.q) == true) goto L10;
        return false;
    L10:
        if (r5.getG().equals(this.g) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public BigInteger getG() {
        return this.g;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        int r0 = getP().hashCode() ^ getQ().hashCode();
        return getG().hashCode() ^ r0;
    }
}
