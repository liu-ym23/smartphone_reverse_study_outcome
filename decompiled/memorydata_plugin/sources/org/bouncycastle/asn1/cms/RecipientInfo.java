package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;

/* JADX INFO: loaded from: classes7.dex */
public class RecipientInfo extends ASN1Object implements ASN1Choice {
    ASN1Encodable info;

    public RecipientInfo(ASN1Primitive r1) {
        this.info = r1;
    }

    public static RecipientInfo getInstance(Object r3) {
        if (r3 == null) goto L18;
        if (ZeusTransformUtils.instanceOf(r3, RecipientInfo.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r3, ASN1Sequence.class) == false) goto L12;
        return new RecipientInfo((ASN1Sequence) ZeusTransformUtils.preCheckCast(r3, ASN1Sequence.class, "com.obric.memorydata.plugin"));
    L12:
        if (ZeusTransformUtils.instanceOf(r3, ASN1TaggedObject.class) == false) goto L16;
        return new RecipientInfo((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r3, ASN1TaggedObject.class, "com.obric.memorydata.plugin"));
    L16:
        throw new IllegalArgumentException("unknown object in factory: " + r3.getClass().getName());
    L18:
        return (RecipientInfo) ZeusTransformUtils.preCheckCast(r3, RecipientInfo.class, "com.obric.memorydata.plugin");
    }

    private KEKRecipientInfo getKEKInfo(ASN1TaggedObject r1) {
        if (r1.isExplicit() == false) goto L7;
        boolean r0 = true;
    L6:
        return KEKRecipientInfo.getInstance(r1, r0);
    L7:
        r0 = false;
        goto L6
    }

    public ASN1Encodable getInfo() {
        if (ZeusTransformUtils.instanceOf(this.info, ASN1TaggedObject.class) == false) goto L23;
        ASN1TaggedObject r0 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(this.info, ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        int r1 = r0.getTagNo();
        if (r1 == 1) goto L21;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L17;
        if (r1 != 4) goto L15;
        return OtherRecipientInfo.getInstance(r0, false);
    L15:
        throw new IllegalStateException("unknown tag");
    L17:
        return PasswordRecipientInfo.getInstance(r0, false);
    L19:
        return getKEKInfo(r0);
    L21:
        return KeyAgreeRecipientInfo.getInstance(r0, false);
    L23:
        return KeyTransRecipientInfo.getInstance(this.info);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.info.toASN1Primitive();
    }
}
