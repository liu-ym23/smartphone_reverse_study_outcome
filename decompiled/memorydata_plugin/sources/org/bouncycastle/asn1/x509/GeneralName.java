package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1IA5String;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;

/* JADX INFO: loaded from: classes7.dex */
public class GeneralName extends ASN1Object implements ASN1Choice {
    private ASN1Encodable obj;
    private int tag;

    public GeneralName(int r3, ASN1Encodable r4) {
        this.obj = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        this.tag = r3;
    }

    public GeneralName(X500Name r1) {
        this.obj = r1;
        this.tag = 4;
    }

    public static GeneralName getInstance(Object r4) {
        if (r4 == null) goto L32;
        if (ZeusTransformUtils.instanceOf(r4, GeneralName.class) == true) goto L32;
        if (ZeusTransformUtils.instanceOf(r4, ASN1TaggedObject.class) == false) goto L24;
        ASN1TaggedObject r5 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r4, ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        int r0 = r5.getTagNo();
        switch(r0) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L22;
            case 4: goto L18;
            case 5: goto L22;
            case 6: goto L20;
            case 7: goto L16;
            case 8: goto L14;
            default: goto L12;
        };
    L12:
        throw new IllegalArgumentException("unknown tag: " + r0);
    L14:
        return new GeneralName(r0, ASN1ObjectIdentifier.getInstance(r5, false));
    L16:
        return new GeneralName(r0, ASN1OctetString.getInstance(r5, false));
    L18:
        return new GeneralName(r0, X500Name.getInstance(r5, true));
    L20:
        return new GeneralName(r0, ASN1IA5String.getInstance(r5, false));
    L22:
        return new GeneralName(r0, ASN1Sequence.getInstance(r5, false));
    L24:
        if ((r4 instanceof byte[]) == false) goto L30;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
    L28:
        throw new IllegalArgumentException("unable to parse encoded general name");
    L30:
        throw new IllegalArgumentException("unknown object in getInstance: " + r4.getClass().getName());
    L32:
        return (GeneralName) ZeusTransformUtils.preCheckCast(r4, GeneralName.class, "com.obric.memorydata.plugin");
    }

    public ASN1Encodable getName() {
        return this.obj;
    }

    public int getTagNo() {
        return this.tag;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.tag != 4) goto L5;
        boolean r0 = true;
    L7:
        return new DERTaggedObject(r0, this.tag, this.obj);
    L5:
        r0 = false;
        goto L7
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        r0.append(this.tag);
        r0.append(": ");
        int r1 = this.tag;
        if (r1 != 1) goto L5;
    L12:
        String r3 = ASN1IA5String.getInstance(this.obj).getString();
    L13:
        r0.append(r3);
        return r0.toString();
    L5:
        if (r1 == 2) goto L12;
        if (r1 != 4) goto L9;
        r3 = X500Name.getInstance(this.obj).toString();
        goto L13
    L9:
        if (r1 == 6) goto L12;
        r3 = this.obj.toString();
        goto L13
    }
}
