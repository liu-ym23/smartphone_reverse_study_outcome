package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class RecipientKeyIdentifier extends ASN1Object {
    private ASN1GeneralizedTime date;
    private OtherKeyAttribute other;
    private ASN1OctetString subjectKeyIdentifier;

    private RecipientKeyIdentifier(ASN1Sequence r5) {
        this.subjectKeyIdentifier = ASN1OctetString.getInstance(r5.getObjectAt(0));
        int r0 = r5.size();
        if (r0 != 1) goto L5;
        return;
    L5:
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        this.date = ASN1GeneralizedTime.getInstance(r5.getObjectAt(1));
    L9:
        this.other = OtherKeyAttribute.getInstance(r5.getObjectAt(2));
        return;
    L11:
        throw new IllegalArgumentException("Invalid RecipientKeyIdentifier");
    L13:
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(1), ASN1GeneralizedTime.class) == false) goto L9;
        this.date = ASN1GeneralizedTime.getInstance(r5.getObjectAt(1));
    }

    public static RecipientKeyIdentifier getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, RecipientKeyIdentifier.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new RecipientKeyIdentifier(ASN1Sequence.getInstance(r2));
    L5:
        return (RecipientKeyIdentifier) ZeusTransformUtils.preCheckCast(r2, RecipientKeyIdentifier.class, "com.obric.memorydata.plugin");
    }

    public static RecipientKeyIdentifier getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, r1));
    }

    public ASN1OctetString getSubjectKeyIdentifier() {
        return this.subjectKeyIdentifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.subjectKeyIdentifier);
        ASN1GeneralizedTime r1 = this.date;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        OtherKeyAttribute r2 = this.other;
        if (r2 == null) goto L9;
        r0.add(r2);
    L9:
        return new DERSequence(r0);
    }
}
