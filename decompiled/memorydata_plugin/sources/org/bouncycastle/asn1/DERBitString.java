package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class DERBitString extends ASN1BitString {
    public DERBitString(ASN1Encodable r3) {
        super(((ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive().getEncoded("DER"), 0);
    }

    public DERBitString(byte[] r2) {
        this(r2, 0);
    }

    public DERBitString(byte[] r1, int r2) {
        super(r1, r2);
    }

    DERBitString(byte[] r1, boolean r2) {
        super(r1, r2);
    }

    public static DERBitString convert(ASN1BitString r2) {
        return (DERBitString) ZeusTransformUtils.preCheckCast(r2.toDERObject(), DERBitString.class, "com.obric.memorydata.plugin");
    }

    static DERBitString fromOctetString(ASN1OctetString r2) {
        return new DERBitString(r2.getOctets(), true);
    }

    public static DERBitString getInstance(Object r4) {
        if (r4 == null) goto L21;
        if (ZeusTransformUtils.instanceOf(r4, DERBitString.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r4, ASN1BitString.class) == false) goto L12;
        return convert((ASN1BitString) ZeusTransformUtils.preCheckCast(r4, ASN1BitString.class, "com.obric.memorydata.plugin"));
    L12:
        if ((r4 instanceof byte[]) == false) goto L19;
        return convert((ASN1BitString) ZeusTransformUtils.preCheckCast(fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")), ASN1BitString.class, "com.obric.memorydata.plugin"));
    L15:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L19:
        throw new IllegalArgumentException("illegal object in getInstance: " + r4.getClass().getName());
    L21:
        return (DERBitString) ZeusTransformUtils.preCheckCast(r4, DERBitString.class, "com.obric.memorydata.plugin");
    }

    public static DERBitString getInstance(ASN1TaggedObject r0, boolean r1) {
        ASN1Primitive r2 = r0.getObject();
        if (r1 == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r2, DERBitString.class) == true) goto L10;
        return fromOctetString(ASN1OctetString.getInstance(r2));
    L10:
        return getInstance(r2);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r11, boolean r12) {
        int r0 = this.contents[0] & 255;
        int r8 = this.contents.length - 1;
        byte r2 = this.contents[r8];
        byte r9 = (byte) ((255 << r0) & this.contents[r8]);
        if (r2 != r9) goto L5;
        r11.writeEncodingDL(r12, 3, this.contents);
        return;
    L5:
        r11.writeEncodingDL(r12, 3, this.contents, 0, r8, r9);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, this.contents.length);
    }

    @Override // org.bouncycastle.asn1.ASN1BitString, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1BitString, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
