package org.bouncycastle.pqc.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class CMCEPublicKey extends ASN1Object {
    private byte[] T;

    public CMCEPublicKey(ASN1Sequence r2) {
        this.T = Arrays.clone(ASN1OctetString.getInstance(r2.getObjectAt(0)).getOctets());
    }

    public CMCEPublicKey(byte[] r1) {
        this.T = r1;
    }

    public static CMCEPublicKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, CMCEPrivateKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new CMCEPublicKey(ASN1Sequence.getInstance(r2));
    L5:
        return (CMCEPublicKey) ZeusTransformUtils.preCheckCast(r2, CMCEPublicKey.class, "com.obric.memorydata.plugin");
    }

    public byte[] getT() {
        return Arrays.clone(this.T);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        r0.add(new DEROctetString(this.T));
        return new DERSequence(r0);
    }
}
