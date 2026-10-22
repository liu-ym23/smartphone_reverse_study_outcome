package org.bouncycastle.asn1.cryptopro;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class GOST3410PublicKeyAlgParameters extends ASN1Object {
    private ASN1ObjectIdentifier digestParamSet;
    private ASN1ObjectIdentifier encryptionParamSet;
    private ASN1ObjectIdentifier publicKeyParamSet;

    public GOST3410PublicKeyAlgParameters(ASN1ObjectIdentifier r1, ASN1ObjectIdentifier r2) {
        this.publicKeyParamSet = r1;
        this.digestParamSet = r2;
        this.encryptionParamSet = null;
    }

    public GOST3410PublicKeyAlgParameters(ASN1ObjectIdentifier r1, ASN1ObjectIdentifier r2, ASN1ObjectIdentifier r3) {
        this.publicKeyParamSet = r1;
        this.digestParamSet = r2;
        this.encryptionParamSet = r3;
    }

    private GOST3410PublicKeyAlgParameters(ASN1Sequence r4) {
        this.publicKeyParamSet = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r4.getObjectAt(0), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        this.digestParamSet = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r4.getObjectAt(1), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r4.size() <= 2) goto L6;
        this.encryptionParamSet = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r4.getObjectAt(2), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        return;
    }

    public static GOST3410PublicKeyAlgParameters getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, GOST3410PublicKeyAlgParameters.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new GOST3410PublicKeyAlgParameters(ASN1Sequence.getInstance(r2));
    L5:
        return (GOST3410PublicKeyAlgParameters) ZeusTransformUtils.preCheckCast(r2, GOST3410PublicKeyAlgParameters.class, "com.obric.memorydata.plugin");
    }

    public ASN1ObjectIdentifier getDigestParamSet() {
        return this.digestParamSet;
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.encryptionParamSet;
    }

    public ASN1ObjectIdentifier getPublicKeyParamSet() {
        return this.publicKeyParamSet;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.publicKeyParamSet);
        r0.add(this.digestParamSet);
        ASN1ObjectIdentifier r2 = this.encryptionParamSet;
        if (r2 == null) goto L6;
        r0.add(r2);
    L6:
        return new DERSequence(r0);
    }
}
