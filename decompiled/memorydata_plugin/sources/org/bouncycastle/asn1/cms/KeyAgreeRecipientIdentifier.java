package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes7.dex */
public class KeyAgreeRecipientIdentifier extends ASN1Object implements ASN1Choice {
    private IssuerAndSerialNumber issuerSerial;
    private RecipientKeyIdentifier rKeyID;

    public KeyAgreeRecipientIdentifier(IssuerAndSerialNumber r1) {
        this.issuerSerial = r1;
        this.rKeyID = null;
    }

    public KeyAgreeRecipientIdentifier(RecipientKeyIdentifier r2) {
        this.issuerSerial = null;
        this.rKeyID = r2;
    }

    public static KeyAgreeRecipientIdentifier getInstance(Object r3) {
        if (r3 == null) goto L20;
        if (ZeusTransformUtils.instanceOf(r3, KeyAgreeRecipientIdentifier.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r3, ASN1Sequence.class) == false) goto L12;
        return new KeyAgreeRecipientIdentifier(IssuerAndSerialNumber.getInstance(r3));
    L12:
        if (ZeusTransformUtils.instanceOf(r3, ASN1TaggedObject.class) == false) goto L18;
        if (((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r3, ASN1TaggedObject.class, "com.obric.memorydata.plugin")).getTagNo() != 0) goto L18;
        return new KeyAgreeRecipientIdentifier(RecipientKeyIdentifier.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r3, ASN1TaggedObject.class, "com.obric.memorydata.plugin"), false));
    L18:
        throw new IllegalArgumentException("Invalid KeyAgreeRecipientIdentifier: " + r3.getClass().getName());
    L20:
        return (KeyAgreeRecipientIdentifier) ZeusTransformUtils.preCheckCast(r3, KeyAgreeRecipientIdentifier.class, "com.obric.memorydata.plugin");
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        return this.issuerSerial;
    }

    public RecipientKeyIdentifier getRKeyID() {
        return this.rKeyID;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        IssuerAndSerialNumber r0 = this.issuerSerial;
        if (r0 == null) goto L7;
        return r0.toASN1Primitive();
    L7:
        return new DERTaggedObject(false, 0, this.rKeyID);
    }
}
