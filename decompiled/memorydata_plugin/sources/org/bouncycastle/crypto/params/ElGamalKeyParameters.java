package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class ElGamalKeyParameters extends AsymmetricKeyParameter {
    private ElGamalParameters params;

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ElGamalKeyParameters.class) == true) goto L5;
        return false;
    L5:
        ElGamalKeyParameters r5 = (ElGamalKeyParameters) ZeusTransformUtils.preCheckCast(r4, ElGamalKeyParameters.class, "com.obric.memorydata.plugin");
        ElGamalParameters r3 = this.params;
        if (r3 != null) goto L12;
        if (r5.getParameters() != null) goto L13;
        return true;
    L13:
        return false;
    L12:
        return r3.equals(r5.getParameters());
    }

    public ElGamalParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        ElGamalParameters r0 = this.params;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }
}
