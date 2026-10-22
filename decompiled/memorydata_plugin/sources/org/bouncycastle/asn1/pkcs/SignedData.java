package org.bouncycastle.asn1.pkcs;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes7.dex */
public class SignedData extends ASN1Object implements PKCSObjectIdentifiers {
    private ASN1Set certificates;
    private ContentInfo contentInfo;
    private ASN1Set crls;
    private ASN1Set digestAlgorithms;
    private ASN1Set signerInfos;
    private ASN1Integer version;

    public SignedData(ASN1Integer r1, ASN1Set r2, ContentInfo r3, ASN1Set r4, ASN1Set r5, ASN1Set r6) {
        this.version = r1;
        this.digestAlgorithms = r2;
        this.contentInfo = r3;
        this.certificates = r4;
        this.crls = r5;
        this.signerInfos = r6;
    }

    public SignedData(ASN1Sequence r6) {
        Enumeration r7 = r6.getObjects();
        this.version = (ASN1Integer) ZeusTransformUtils.preCheckCast(r7.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin");
        this.digestAlgorithms = (ASN1Set) ZeusTransformUtils.preCheckCast(r7.nextElement(), ASN1Set.class, "com.obric.memorydata.plugin");
        this.contentInfo = ContentInfo.getInstance(r7.nextElement());
    L4:
        if (r7.hasMoreElements() == false) goto L16;
        ASN1Primitive r0 = (ASN1Primitive) ZeusTransformUtils.preCheckCast(r7.nextElement(), ASN1Primitive.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, ASN1TaggedObject.class) == true) goto L7;
        this.signerInfos = (ASN1Set) ZeusTransformUtils.preCheckCast(r0, ASN1Set.class, "com.obric.memorydata.plugin");
        goto L4
    L7:
        ASN1TaggedObject r1 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r0, ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        int r2 = r1.getTagNo();
        if (r2 != 0) goto L10;
        this.certificates = ASN1Set.getInstance(r1, false);
        goto L4
    L10:
        if (r2 != 1) goto L13;
        this.crls = ASN1Set.getInstance(r1, false);
        goto L4
    L13:
        throw new IllegalArgumentException("unknown tag value " + r1.getTagNo());
    }

    public static SignedData getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, SignedData.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new SignedData(ASN1Sequence.getInstance(r2));
    L5:
        return (SignedData) ZeusTransformUtils.preCheckCast(r2, SignedData.class, "com.obric.memorydata.plugin");
    }

    public ASN1Set getCRLs() {
        return this.crls;
    }

    public ASN1Set getCertificates() {
        return this.certificates;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(6);
        r0.add(this.version);
        r0.add(this.digestAlgorithms);
        r0.add(this.contentInfo);
        if (this.certificates == null) goto L6;
        r0.add(new DERTaggedObject(false, 0, this.certificates));
    L6:
        if (this.crls == null) goto L8;
        r0.add(new DERTaggedObject(false, 1, this.crls));
    L8:
        r0.add(this.signerInfos);
        return new BERSequence(r0);
    }
}
