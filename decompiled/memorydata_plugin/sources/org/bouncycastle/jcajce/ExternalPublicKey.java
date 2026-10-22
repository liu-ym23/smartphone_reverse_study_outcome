package org.bouncycastle.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.security.PublicKey;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.bc.ExternalValue;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.util.MessageDigestUtils;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class ExternalPublicKey implements PublicKey {
    private final byte[] digest;
    private final AlgorithmIdentifier digestAlg;
    private final GeneralName location;

    public ExternalPublicKey(PublicKey r3, GeneralName r4, MessageDigest r5) {
        PublicKey r6 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.memorydata.plugin");
        this(r4, MessageDigestUtils.getDigestAlgID(r5.getAlgorithm()), r5.digest(r6.getEncoded()));
    }

    public ExternalPublicKey(ExternalValue r3) {
        this(r3.getLocation(), r3.getHashAlg(), r3.getHashVal().getBytes());
    }

    public ExternalPublicKey(GeneralName r1, AlgorithmIdentifier r2, byte[] r3) {
        this.location = r1;
        this.digestAlg = r2;
        this.digest = Arrays.clone(r3);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ExternalKey";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(BCObjectIdentifiers.external_value), new ExternalValue(this.location, this.digestAlg, this.digest)).getEncoded("DER");
    L4:
        e = move-exception;
        throw new IllegalStateException("unable to encode composite key: " + e.getMessage());
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }
}
