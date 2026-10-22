package org.bouncycastle.jcajce.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.AlgorithmParameters;
import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: loaded from: classes7.dex */
public class AlgorithmParametersUtils {
    public static void loadParameters(AlgorithmParameters r2, ASN1Encodable r3) {
        ASN1Encodable r4 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin");
        r2.init(r4.toASN1Primitive().getEncoded(), "ASN.1");     // Catch: Exception -> L5
        return;
    L5:
        r2.init(r4.toASN1Primitive().getEncoded());
    }
}
