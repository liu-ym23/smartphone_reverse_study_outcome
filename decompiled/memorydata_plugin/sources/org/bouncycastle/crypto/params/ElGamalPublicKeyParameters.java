package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class ElGamalPublicKeyParameters extends ElGamalKeyParameters {
    private BigInteger y;

    @Override // org.bouncycastle.crypto.params.ElGamalKeyParameters
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ElGamalPublicKeyParameters.class) == true) goto L6;
        return false;
    L6:
        if (((ElGamalPublicKeyParameters) ZeusTransformUtils.preCheckCast(r4, ElGamalPublicKeyParameters.class, "com.obric.memorydata.plugin")).getY().equals(this.y) == true) goto L8;
        return false;
    L8:
        if (super.equals(r4) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public BigInteger getY() {
        return this.y;
    }

    @Override // org.bouncycastle.crypto.params.ElGamalKeyParameters
    public int hashCode() {
        int r0 = this.y.hashCode();
        return super.hashCode() ^ r0;
    }
}
