package org.bouncycastle.pqc.jcajce.provider.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

/* JADX INFO: loaded from: classes7.dex */
public class KeyUtil {
    public static byte[] getEncodedSubjectPublicKeyInfo(AlgorithmIdentifier r2, ASN1Encodable r3) {
        return getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(r2, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin")));
    L5:
        return null;
    }

    public static byte[] getEncodedSubjectPublicKeyInfo(SubjectPublicKeyInfo r1) {
        return r1.getEncoded("DER");
    L4:
        return null;
    }
}
