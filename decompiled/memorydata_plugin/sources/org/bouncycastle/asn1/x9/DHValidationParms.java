package org.bouncycastle.asn1.x9;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class DHValidationParms extends ASN1Object {
    private ASN1Integer pgenCounter;
    private ASN1BitString seed;

    private DHValidationParms(ASN1Sequence r3) {
        if (r3.size() != 2) goto L7;
        this.seed = DERBitString.getInstance(r3.getObjectAt(0));
        this.pgenCounter = ASN1Integer.getInstance(r3.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r3.size());
    }

    public static DHValidationParms getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, DHValidationParms.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new DHValidationParms(ASN1Sequence.getInstance(r2));
    L5:
        return (DHValidationParms) ZeusTransformUtils.preCheckCast(r2, DHValidationParms.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.seed);
        r0.add(this.pgenCounter);
        return new DERSequence(r0);
    }
}
