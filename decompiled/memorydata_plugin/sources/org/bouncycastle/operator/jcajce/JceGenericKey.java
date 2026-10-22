package org.bouncycastle.operator.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Key;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.GenericKey;

/* JADX INFO: loaded from: classes7.dex */
public class JceGenericKey extends GenericKey {
    public JceGenericKey(AlgorithmIdentifier r3, Key r4) {
        super(r3, getRepresentation((Key) ZeusTransformUtils.wrapperContextForParams(r4, Key.class, "com.obric.memorydata.plugin")));
    }

    private static Object getRepresentation(Key r2) {
        Key r3 = (Key) ZeusTransformUtils.wrapperContextForParams(r2, Key.class, "com.obric.memorydata.plugin");
        byte[] r0 = r3.getEncoded();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r3;
    }
}
