package org.bouncycastle.crypto.constraints;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultServiceProperties implements CryptoServiceProperties {
    private final String algorithm;
    private final int bitsOfSecurity;
    private final Object params;
    private final CryptoServicePurpose purpose;

    public DefaultServiceProperties(String r3, int r4) {
        this(r3, r4, null, CryptoServicePurpose.ANY);
    }

    public DefaultServiceProperties(String r1, int r2, Object r3, CryptoServicePurpose r4) {
        this.algorithm = r1;
        this.bitsOfSecurity = r2;
        this.params = r3;
        if (ZeusTransformUtils.instanceOf(r3, CryptoServicePurpose.class) == true) goto L7;
        this.purpose = r4;
        return;
    L7:
        throw new IllegalArgumentException("params should not be CryptoServicePurpose");
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public String getServiceName() {
        return this.algorithm;
    }
}
