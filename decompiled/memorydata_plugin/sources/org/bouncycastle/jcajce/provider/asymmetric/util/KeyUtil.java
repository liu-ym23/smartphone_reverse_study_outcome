package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

/* JADX INFO: loaded from: classes7.dex */
public class KeyUtil {
    public static byte[] getEncodedPrivateKeyInfo(PrivateKeyInfo r1) {
        return r1.getEncoded("DER");
    L4:
        return null;
    }

    public static byte[] getEncodedPrivateKeyInfo(AlgorithmIdentifier r2, ASN1Encodable r3) {
        return getEncodedPrivateKeyInfo(new PrivateKeyInfo(r2, ((ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive()));
    L5:
        return null;
    }

    public static byte[] getEncodedSubjectPublicKeyInfo(AlgorithmIdentifier r2, ASN1Encodable r3) {
        return getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(r2, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin")));
    L5:
        return null;
    }

    public static byte[] getEncodedSubjectPublicKeyInfo(AlgorithmIdentifier r1, byte[] r2) {
        return getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(r1, r2));
    L4:
        return null;
    }

    public static byte[] getEncodedSubjectPublicKeyInfo(SubjectPublicKeyInfo r1) {
        return r1.getEncoded("DER");
    L4:
        return null;
    }
}
