package org.bouncycastle.asn1.pkcs;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
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
public class EncryptedPrivateKeyInfo extends ASN1Object {
    private AlgorithmIdentifier algId;
    private ASN1OctetString data;

    private EncryptedPrivateKeyInfo(ASN1Sequence r2) {
        Enumeration r3 = r2.getObjects();
        this.algId = AlgorithmIdentifier.getInstance(r3.nextElement());
        this.data = ASN1OctetString.getInstance(r3.nextElement());
    }

    public EncryptedPrivateKeyInfo(AlgorithmIdentifier r1, byte[] r2) {
        this.algId = r1;
        this.data = new DEROctetString(Arrays.clone(r2));
    }

    public static EncryptedPrivateKeyInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, EncryptedPrivateKeyInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new EncryptedPrivateKeyInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (EncryptedPrivateKeyInfo) ZeusTransformUtils.preCheckCast(r2, EncryptedPrivateKeyInfo.class, "com.obric.memorydata.plugin");
    }

    public byte[] getEncryptedData() {
        return Arrays.clone(this.data.getOctets());
    }

    public AlgorithmIdentifier getEncryptionAlgorithm() {
        return this.algId;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.algId);
        r0.add(this.data);
        return new DERSequence(r0);
    }
}
