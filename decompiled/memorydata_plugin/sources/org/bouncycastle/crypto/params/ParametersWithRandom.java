package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;

/* JADX INFO: loaded from: classes7.dex */
public class ParametersWithRandom implements CipherParameters {
    private CipherParameters parameters;
    private SecureRandom random;

    public ParametersWithRandom(CipherParameters r3, SecureRandom r4) {
        CipherParameters r5 = (CipherParameters) ZeusTransformUtils.wrapperContextForParams(r3, CipherParameters.class, "com.obric.memorydata.plugin");
        this.random = CryptoServicesRegistrar.getSecureRandom(r4);
        this.parameters = r5;
    }
}
