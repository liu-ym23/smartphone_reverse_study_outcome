package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class ASN1ObjectDescriptor extends ASN1Primitive {
    static final ASN1UniversalType TYPE = null;
    private final ASN1GraphicString baseGraphicString;

    static {
        final Class<ASN1ObjectDescriptor> r1 = ASN1ObjectDescriptor.class;
        final int r2 = 7;
        TYPE = new AnonymousClass1(r1, r2);
    }

    public ASN1ObjectDescriptor(ASN1GraphicString r2) {
        Objects.requireNonNull(r2, "'baseGraphicString' cannot be null");
        this.baseGraphicString = r2;
    }

    static ASN1ObjectDescriptor createPrimitive(byte[] r1) {
        return new ASN1ObjectDescriptor(ASN1GraphicString.createPrimitive(r1));
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(r3, ASN1ObjectDescriptor.class) == true) goto L6;
        return false;
    L6:
        ASN1ObjectDescriptor r4 = (ASN1ObjectDescriptor) ZeusTransformUtils.preCheckCast(r3, ASN1ObjectDescriptor.class, "com.obric.memorydata.plugin");
        return this.baseGraphicString.asn1Equals(r4.baseGraphicString);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeIdentifier(r3, 7);
        this.baseGraphicString.encode(r2, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return this.baseGraphicString.encodedLength(r1);
    }

    public ASN1GraphicString getBaseGraphicString() {
        return this.baseGraphicString;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return ~this.baseGraphicString.hashCode();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        ASN1GraphicString r0 = (ASN1GraphicString) ZeusTransformUtils.preCheckCast(this.baseGraphicString.toDERObject(), ASN1GraphicString.class, "com.obric.memorydata.plugin");
        if (r0 != this.baseGraphicString) goto L6;
        return this;
    L6:
        return new ASN1ObjectDescriptor(r0);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        ASN1GraphicString r0 = (ASN1GraphicString) ZeusTransformUtils.preCheckCast(this.baseGraphicString.toDLObject(), ASN1GraphicString.class, "com.obric.memorydata.plugin");
        if (r0 != this.baseGraphicString) goto L6;
        return this;
    L6:
        return new ASN1ObjectDescriptor(r0);
    }
}
