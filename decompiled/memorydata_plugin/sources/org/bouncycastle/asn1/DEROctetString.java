package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class DEROctetString extends ASN1OctetString {
    public DEROctetString(ASN1Encodable r3) {
        super(((ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive().getEncoded("DER"));
    }

    public DEROctetString(byte[] r1) {
        super(r1);
    }

    static void encode(ASN1OutputStream r6, boolean r7, byte[] r8, int r9, int r10) {
        r6.writeEncodingDL(r7, 4, r8, r9, r10);
    }

    static int encodedLength(boolean r0, int r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r0, r1);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 4, this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, this.string.length);
    }

    @Override // org.bouncycastle.asn1.ASN1OctetString, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1OctetString, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
