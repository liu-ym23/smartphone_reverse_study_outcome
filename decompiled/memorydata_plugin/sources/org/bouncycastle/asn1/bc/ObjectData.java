package org.bouncycastle.asn1.bc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class ObjectData extends ASN1Object {
    private final String comment;
    private final ASN1GeneralizedTime creationDate;
    private final ASN1OctetString data;
    private final String identifier;
    private final ASN1GeneralizedTime lastModifiedDate;
    private final BigInteger type;

    public ObjectData(BigInteger r1, String r2, Date r3, Date r4, byte[] r5, String r6) {
        this.type = r1;
        this.identifier = r2;
        this.creationDate = new DERGeneralizedTime(r3);
        this.lastModifiedDate = new DERGeneralizedTime(r4);
        this.data = new DEROctetString(Arrays.clone(r5));
        this.comment = r6;
    }

    private ObjectData(ASN1Sequence r3) {
        this.type = ASN1Integer.getInstance(r3.getObjectAt(0)).getValue();
        this.identifier = ASN1UTF8String.getInstance(r3.getObjectAt(1)).getString();
        this.creationDate = ASN1GeneralizedTime.getInstance(r3.getObjectAt(2));
        this.lastModifiedDate = ASN1GeneralizedTime.getInstance(r3.getObjectAt(3));
        this.data = ASN1OctetString.getInstance(r3.getObjectAt(4));
        if (r3.size() != 6) goto L5;
        String r4 = ASN1UTF8String.getInstance(r3.getObjectAt(5)).getString();
    L6:
        this.comment = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static ObjectData getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ObjectData.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new ObjectData(ASN1Sequence.getInstance(r2));
    L5:
        return (ObjectData) ZeusTransformUtils.preCheckCast(r2, ObjectData.class, "com.obric.memorydata.plugin");
    }

    public ASN1GeneralizedTime getCreationDate() {
        return this.creationDate;
    }

    public byte[] getData() {
        return Arrays.clone(this.data.getOctets());
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public ASN1GeneralizedTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public BigInteger getType() {
        return this.type;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(6);
        r0.add(new ASN1Integer(this.type));
        r0.add(new DERUTF8String(this.identifier));
        r0.add(this.creationDate);
        r0.add(this.lastModifiedDate);
        r0.add(this.data);
        if (this.comment == null) goto L6;
        r0.add(new DERUTF8String(this.comment));
    L6:
        return new DERSequence(r0);
    }
}
