package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class OtherRecipientInfo extends ASN1Object {
    private ASN1ObjectIdentifier oriType;
    private ASN1Encodable oriValue;

    private OtherRecipientInfo(ASN1Sequence r2) {
        this.oriType = ASN1ObjectIdentifier.getInstance(r2.getObjectAt(0));
        this.oriValue = r2.getObjectAt(1);
    }

    public static OtherRecipientInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, OtherRecipientInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new OtherRecipientInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (OtherRecipientInfo) ZeusTransformUtils.preCheckCast(r2, OtherRecipientInfo.class, "com.obric.memorydata.plugin");
    }

    public static OtherRecipientInfo getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, r1));
    }

    public ASN1ObjectIdentifier getType() {
        return this.oriType;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.oriType);
        r0.add(this.oriValue);
        return new DERSequence(r0);
    }
}
