package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class SubjectPublicKeyInfo extends ASN1Object {
    private AlgorithmIdentifier algId;
    private ASN1BitString keyData;

    public SubjectPublicKeyInfo(ASN1Sequence r3) {
        if (r3.size() != 2) goto L7;
        Enumeration r4 = r3.getObjects();
        this.algId = AlgorithmIdentifier.getInstance(r4.nextElement());
        this.keyData = DERBitString.getInstance(r4.nextElement());
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r3.size());
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier r3, ASN1Encodable r4) {
        this.keyData = new DERBitString((ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin"));
        this.algId = r3;
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier r2, byte[] r3) {
        this.keyData = new DERBitString(r3);
        this.algId = r2;
    }

    public static SubjectPublicKeyInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, SubjectPublicKeyInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new SubjectPublicKeyInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (SubjectPublicKeyInfo) ZeusTransformUtils.preCheckCast(r2, SubjectPublicKeyInfo.class, "com.obric.memorydata.plugin");
    }

    public static SubjectPublicKeyInfo getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, r1));
    }

    public AlgorithmIdentifier getAlgorithm() {
        return this.algId;
    }

    public AlgorithmIdentifier getAlgorithmId() {
        return this.algId;
    }

    public ASN1BitString getPublicKeyData() {
        return this.keyData;
    }

    public ASN1Primitive parsePublicKey() {
        return ASN1Primitive.fromByteArray(this.keyData.getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.algId);
        r0.add(this.keyData);
        return new DERSequence(r0);
    }
}
