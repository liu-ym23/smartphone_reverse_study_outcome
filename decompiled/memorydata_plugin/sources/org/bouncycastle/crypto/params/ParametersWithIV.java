package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class ParametersWithIV implements CipherParameters {
    private byte[] iv;
    private CipherParameters parameters;

    public ParametersWithIV(CipherParameters r3, byte[] r4) {
        this((CipherParameters) ZeusTransformUtils.wrapperContextForParams(r3, CipherParameters.class, "com.obric.memorydata.plugin"), r4, 0, r4.length);
    }

    public ParametersWithIV(CipherParameters r3, byte[] r4, int r5, int r6) {
        CipherParameters r7 = (CipherParameters) ZeusTransformUtils.wrapperContextForParams(r3, CipherParameters.class, "com.obric.memorydata.plugin");
        byte[] r0 = new byte[r6];
        this.iv = r0;
        this.parameters = r7;
        System.arraycopy(r4, r5, r0, 0, r6);
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
