package org.bouncycastle.asn1.bc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.x509.Certificate;

/* JADX INFO: loaded from: classes7.dex */
public class EncryptedPrivateKeyData extends ASN1Object {
    private final Certificate[] certificateChain;
    private final EncryptedPrivateKeyInfo encryptedPrivateKeyInfo;

    private EncryptedPrivateKeyData(ASN1Sequence r4) {
        int r0 = 0;
        this.encryptedPrivateKeyInfo = EncryptedPrivateKeyInfo.getInstance(r4.getObjectAt(0));
        ASN1Sequence r5 = ASN1Sequence.getInstance(r4.getObjectAt(1));
        this.certificateChain = new Certificate[r5.size()];
    L3:
        Certificate[] r1 = this.certificateChain;
        if (r0 == r1.length) goto L6;
        r1[r0] = Certificate.getInstance(r5.getObjectAt(r0));
        r0 = r0 + 1;
        goto L3
    }

    public EncryptedPrivateKeyData(EncryptedPrivateKeyInfo r2, Certificate[] r3) {
        this.encryptedPrivateKeyInfo = r2;
        Certificate[] r4 = new Certificate[r3.length];
        this.certificateChain = r4;
        System.arraycopy(r3, 0, r4, 0, r3.length);
    }

    public static EncryptedPrivateKeyData getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, EncryptedPrivateKeyData.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new EncryptedPrivateKeyData(ASN1Sequence.getInstance(r2));
    L5:
        return (EncryptedPrivateKeyData) ZeusTransformUtils.preCheckCast(r2, EncryptedPrivateKeyData.class, "com.obric.memorydata.plugin");
    }

    public Certificate[] getCertificateChain() {
        Certificate[] r3 = this.certificateChain;
        Certificate[] r0 = new Certificate[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    public EncryptedPrivateKeyInfo getEncryptedPrivateKeyInfo() {
        return this.encryptedPrivateKeyInfo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.encryptedPrivateKeyInfo);
        r0.add(new DERSequence(this.certificateChain));
        return new DERSequence(r0);
    }
}
