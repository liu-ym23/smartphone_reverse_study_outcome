package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class DHKeyParameters extends AsymmetricKeyParameter {
    private DHParameters params;

    public DHKeyParameters(boolean r1, DHParameters r2) {
        super(r1);
        this.params = r2;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, DHKeyParameters.class) == true) goto L5;
        return false;
    L5:
        DHKeyParameters r5 = (DHKeyParameters) ZeusTransformUtils.preCheckCast(r4, DHKeyParameters.class, "com.obric.memorydata.plugin");
        DHParameters r3 = this.params;
        if (r3 != null) goto L12;
        if (r5.getParameters() != null) goto L13;
        return true;
    L13:
        return false;
    L12:
        return r3.equals(r5.getParameters());
    }

    public DHParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        int r0 = !isPrivate() ? 1 : 0;
        DHParameters r1 = this.params;
        if (r1 != null) goto L5;
        return r0;
    L5:
        return r0 ^ r1.hashCode();
    }
}
