package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1UTF8String extends ASN1Primitive implements ASN1String {
    static final ASN1UniversalType TYPE = null;
    final byte[] contents;

    static {
        final Class<ASN1UTF8String> r1 = ASN1UTF8String.class;
        final int r2 = 12;
        TYPE = new AnonymousClass1(r1, r2);
    }

    ASN1UTF8String(String r2) {
        this(Strings.toUTF8ByteArray(r2), false);
    }

    ASN1UTF8String(byte[] r1, boolean r2) {
        if (r2 == false) goto L5;
        r1 = Arrays.clone(r1);
    L5:
        this.contents = r1;
    }

    static ASN1UTF8String createPrimitive(byte[] r2) {
        return new DERUTF8String(r2, false);
    }

    public static ASN1UTF8String getInstance(Object r5) {
        if (r5 != null) goto L5;
    L23:
        Object r6 = ZeusTransformUtils.preCheckCast(r5, ASN1UTF8String.class, "com.obric.memorydata.plugin");
    L13:
        return (ASN1UTF8String) r6;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, ASN1UTF8String.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r5, ASN1Encodable.class) == false) goto L15;
        ASN1Primitive r3 = ((ASN1Encodable) ZeusTransformUtils.preCheckCast(r5, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive();
        if (ZeusTransformUtils.instanceOf(r3, ASN1UTF8String.class) == false) goto L15;
        r6 = ZeusTransformUtils.preCheckCast(r3, ASN1UTF8String.class, "com.obric.memorydata.plugin");
    L15:
        if ((r5 instanceof byte[]) == false) goto L22;
        return (ASN1UTF8String) ZeusTransformUtils.preCheckCast(TYPE.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r5, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")), ASN1UTF8String.class, "com.obric.memorydata.plugin");
    L18:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L22:
        throw new IllegalArgumentException("illegal object in getInstance: " + r5.getClass().getName());
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean asn1Equals(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(r3, ASN1UTF8String.class) == true) goto L6;
        return false;
    L6:
        ASN1UTF8String r4 = (ASN1UTF8String) ZeusTransformUtils.preCheckCast(r3, ASN1UTF8String.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.contents, r4.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 12, this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, this.contents.length);
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public final String getString() {
        return Strings.fromUTF8ByteArray(this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return getString();
    }
}
