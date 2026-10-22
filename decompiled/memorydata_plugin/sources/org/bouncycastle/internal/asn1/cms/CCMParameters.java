package org.bouncycastle.internal.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class CCMParameters extends ASN1Object {
    private int icvLen;
    private byte[] nonce;

    private CCMParameters(ASN1Sequence r3) {
        this.nonce = ASN1OctetString.getInstance(r3.getObjectAt(0)).getOctets();
        if (r3.size() != 2) goto L5;
        int r4 = ASN1Integer.getInstance(r3.getObjectAt(1)).intValueExact();
    L6:
        this.icvLen = r4;
        return;
    L5:
        r4 = 12;
        goto L6
    }

    public static CCMParameters getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, CCMParameters.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new CCMParameters(ASN1Sequence.getInstance(r2));
    L5:
        return (CCMParameters) ZeusTransformUtils.preCheckCast(r2, CCMParameters.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(new DEROctetString(this.nonce));
        if (this.icvLen == 12) goto L6;
        r0.add(new ASN1Integer(this.icvLen));
    L6:
        return new DERSequence(r0);
    }
}
