package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class DHPrivateKeyParameters extends DHKeyParameters {
    private BigInteger x;

    public DHPrivateKeyParameters(BigInteger r2, DHParameters r3) {
        super(true, r3);
        this.x = r2;
    }

    @Override // org.bouncycastle.crypto.params.DHKeyParameters
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, DHPrivateKeyParameters.class) == true) goto L6;
        return false;
    L6:
        if (((DHPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r4, DHPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getX().equals(this.x) == true) goto L8;
        return false;
    L8:
        if (super.equals(r4) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public BigInteger getX() {
        return this.x;
    }

    @Override // org.bouncycastle.crypto.params.DHKeyParameters
    public int hashCode() {
        int r0 = this.x.hashCode();
        return super.hashCode() ^ r0;
    }
}
