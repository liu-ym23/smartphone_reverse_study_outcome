package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1IA5String extends ASN1Primitive implements ASN1String {
    static final ASN1UniversalType TYPE = null;
    final byte[] contents;

    static {
        final Class<ASN1IA5String> r1 = ASN1IA5String.class;
        final int r2 = 22;
        TYPE = new AnonymousClass1(r1, r2);
    }

    ASN1IA5String(String r2, boolean r3) {
        Objects.requireNonNull(r2, "'string' cannot be null");
        if (r3 == true) goto L5;
    L9:
        this.contents = Strings.toByteArray(r2);
        return;
    L5:
        if (isIA5String(r2) == true) goto L9;
        throw new IllegalArgumentException("'string' contains illegal characters");
    }

    ASN1IA5String(byte[] r1, boolean r2) {
        if (r2 == false) goto L5;
        r1 = Arrays.clone(r1);
    L5:
        this.contents = r1;
    }

    static ASN1IA5String createPrimitive(byte[] r2) {
        return new DERIA5String(r2, false);
    }

    public static ASN1IA5String getInstance(Object r5) {
        if (r5 != null) goto L5;
    L23:
        Object r6 = ZeusTransformUtils.preCheckCast(r5, ASN1IA5String.class, "com.obric.memorydata.plugin");
    L13:
        return (ASN1IA5String) r6;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, ASN1IA5String.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r5, ASN1Encodable.class) == false) goto L15;
        ASN1Primitive r3 = ((ASN1Encodable) ZeusTransformUtils.preCheckCast(r5, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive();
        if (ZeusTransformUtils.instanceOf(r3, ASN1IA5String.class) == false) goto L15;
        r6 = ZeusTransformUtils.preCheckCast(r3, ASN1IA5String.class, "com.obric.memorydata.plugin");
    L15:
        if ((r5 instanceof byte[]) == false) goto L22;
        return (ASN1IA5String) ZeusTransformUtils.preCheckCast(TYPE.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r5, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")), ASN1IA5String.class, "com.obric.memorydata.plugin");
    L18:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L22:
        throw new IllegalArgumentException("illegal object in getInstance: " + r5.getClass().getName());
    }

    public static ASN1IA5String getInstance(ASN1TaggedObject r1, boolean r2) {
        return (ASN1IA5String) ZeusTransformUtils.preCheckCast(TYPE.getContextInstance(r1, r2), ASN1IA5String.class, "com.obric.memorydata.plugin");
    }

    public static boolean isIA5String(String r4) {
        int r0 = r4.length() - 1;
    L3:
        if (r0 < 0) goto L9;
        if (r4.charAt(r0) > 127) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean asn1Equals(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(r3, ASN1IA5String.class) == true) goto L6;
        return false;
    L6:
        ASN1IA5String r4 = (ASN1IA5String) ZeusTransformUtils.preCheckCast(r3, ASN1IA5String.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.contents, r4.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 22, this.contents);
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
        return Strings.fromByteArray(this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return getString();
    }
}
