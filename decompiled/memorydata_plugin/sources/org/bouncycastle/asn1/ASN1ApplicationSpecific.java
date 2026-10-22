package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1ApplicationSpecific extends ASN1TaggedObject implements ASN1ApplicationSpecificParser {
    final ASN1TaggedObject taggedObject;

    ASN1ApplicationSpecific(ASN1TaggedObject r5) {
        super(r5.explicitness, checkTagClass(r5.tagClass), r5.tagNo, r5.obj);
        this.taggedObject = r5;
    }

    private static int checkTagClass(int r1) {
        if (64 != r1) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r1, boolean r2) {
        this.taggedObject.encode(r1, r2);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return this.taggedObject.encodeConstructed();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return this.taggedObject.encodedLength(r1);
    }

    public ASN1TaggedObject getTaggedObject() {
        return this.taggedObject;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject
    public boolean hasContextTag(int r1) {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject
    ASN1Sequence rebuildConstructed(ASN1Primitive r1) {
        return this.taggedObject.rebuildConstructed(r1);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return new DERApplicationSpecific((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(this.taggedObject.toDERObject(), ASN1TaggedObject.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return new DLApplicationSpecific((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(this.taggedObject.toDLObject(), ASN1TaggedObject.class, "com.obric.memorydata.plugin"));
    }
}
