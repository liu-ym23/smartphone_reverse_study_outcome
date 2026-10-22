package org.bouncycastle.asn1.bc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SecretKeyData extends ASN1Object {
    private final ASN1ObjectIdentifier keyAlgorithm;
    private final ASN1OctetString keyBytes;

    public SecretKeyData(ASN1ObjectIdentifier r1, byte[] r2) {
        this.keyAlgorithm = r1;
        this.keyBytes = new DEROctetString(Arrays.clone(r2));
    }

    private SecretKeyData(ASN1Sequence r2) {
        this.keyAlgorithm = ASN1ObjectIdentifier.getInstance(r2.getObjectAt(0));
        this.keyBytes = ASN1OctetString.getInstance(r2.getObjectAt(1));
    }

    public static SecretKeyData getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, SecretKeyData.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new SecretKeyData(ASN1Sequence.getInstance(r2));
    L5:
        return (SecretKeyData) ZeusTransformUtils.preCheckCast(r2, SecretKeyData.class, "com.obric.memorydata.plugin");
    }

    public ASN1ObjectIdentifier getKeyAlgorithm() {
        return this.keyAlgorithm;
    }

    public byte[] getKeyBytes() {
        return Arrays.clone(this.keyBytes.getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.keyAlgorithm);
        r0.add(this.keyBytes);
        return new DERSequence(r0);
    }
}
