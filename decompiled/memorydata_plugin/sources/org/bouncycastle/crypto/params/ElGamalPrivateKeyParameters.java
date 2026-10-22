package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class ElGamalPrivateKeyParameters extends ElGamalKeyParameters {
    private BigInteger x;

    @Override // org.bouncycastle.crypto.params.ElGamalKeyParameters
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ElGamalPrivateKeyParameters.class) == true) goto L6;
        return false;
    L6:
        if (((ElGamalPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r4, ElGamalPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getX().equals(this.x) == true) goto L9;
        return false;
    L9:
        return super.equals(r4);
    }

    public BigInteger getX() {
        return this.x;
    }

    @Override // org.bouncycastle.crypto.params.ElGamalKeyParameters
    public int hashCode() {
        return getX().hashCode();
    }
}
