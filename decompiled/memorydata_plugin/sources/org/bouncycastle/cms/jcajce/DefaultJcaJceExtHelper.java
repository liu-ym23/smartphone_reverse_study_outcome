package org.bouncycastle.cms.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.PrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.operator.jcajce.JceAsymmetricKeyUnwrapper;

/* JADX INFO: loaded from: classes7.dex */
class DefaultJcaJceExtHelper extends DefaultJcaJceHelper implements JcaJceExtHelper {
    DefaultJcaJceExtHelper() {
    }

    @Override // org.bouncycastle.cms.jcajce.JcaJceExtHelper
    public JceAsymmetricKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier r2, PrivateKey r3) {
        return new JceAsymmetricKeyUnwrapper(r2, CMSUtils.cleanPrivateKey((PrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, PrivateKey.class, "com.obric.memorydata.plugin")));
    }
}
