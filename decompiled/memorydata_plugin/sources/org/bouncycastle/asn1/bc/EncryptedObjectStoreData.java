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
public class EncryptedObjectStoreData extends ASN1Object {
    private final ASN1OctetString encryptedContent;
    private final AlgorithmIdentifier encryptionAlgorithm;

    private EncryptedObjectStoreData(ASN1Sequence r2) {
        this.encryptionAlgorithm = AlgorithmIdentifier.getInstance(r2.getObjectAt(0));
        this.encryptedContent = ASN1OctetString.getInstance(r2.getObjectAt(1));
    }

    public EncryptedObjectStoreData(AlgorithmIdentifier r1, byte[] r2) {
        this.encryptionAlgorithm = r1;
        this.encryptedContent = new DEROctetString(Arrays.clone(r2));
    }

    public static EncryptedObjectStoreData getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, EncryptedObjectStoreData.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new EncryptedObjectStoreData(ASN1Sequence.getInstance(r2));
    L5:
        return (EncryptedObjectStoreData) ZeusTransformUtils.preCheckCast(r2, EncryptedObjectStoreData.class, "com.obric.memorydata.plugin");
    }

    public ASN1OctetString getEncryptedContent() {
        return this.encryptedContent;
    }

    public AlgorithmIdentifier getEncryptionAlgorithm() {
        return this.encryptionAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.encryptionAlgorithm);
        r0.add(this.encryptedContent);
        return new DERSequence(r0);
    }
}
