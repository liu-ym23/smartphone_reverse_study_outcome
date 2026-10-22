package org.bouncycastle.asn1.bc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class EncryptedSecretKeyData extends ASN1Object {
    private final ASN1OctetString encryptedKeyData;
    private final AlgorithmIdentifier keyEncryptionAlgorithm;

    private EncryptedSecretKeyData(ASN1Sequence r2) {
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r2.getObjectAt(0));
        this.encryptedKeyData = ASN1OctetString.getInstance(r2.getObjectAt(1));
    }

    public EncryptedSecretKeyData(AlgorithmIdentifier r1, byte[] r2) {
        this.keyEncryptionAlgorithm = r1;
        this.encryptedKeyData = new DEROctetString(Arrays.clone(r2));
    }

    public static EncryptedSecretKeyData getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, EncryptedSecretKeyData.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new EncryptedSecretKeyData(ASN1Sequence.getInstance(r2));
    L5:
        return (EncryptedSecretKeyData) ZeusTransformUtils.preCheckCast(r2, EncryptedSecretKeyData.class, "com.obric.memorydata.plugin");
    }

    public byte[] getEncryptedKeyData() {
        return Arrays.clone(this.encryptedKeyData.getOctets());
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.keyEncryptionAlgorithm);
        r0.add(this.encryptedKeyData);
        return new DERSequence(r0);
    }
}
