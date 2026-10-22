package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class ElGamalParameters implements CipherParameters {
    private BigInteger g;
    private int l;
    private BigInteger p;

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ElGamalParameters.class) == true) goto L5;
        return false;
    L5:
        ElGamalParameters r5 = (ElGamalParameters) ZeusTransformUtils.preCheckCast(r4, ElGamalParameters.class, "com.obric.memorydata.plugin");
        if (r5.getP().equals(this.p) == true) goto L8;
        return false;
    L8:
        if (r5.getG().equals(this.g) == true) goto L10;
        return false;
    L10:
        if (r5.getL() != this.l) goto L15;
        return true;
    L15:
        return false;
    }

    public BigInteger getG() {
        return this.g;
    }

    public int getL() {
        return this.l;
    }

    public BigInteger getP() {
        return this.p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.l;
    }
}
