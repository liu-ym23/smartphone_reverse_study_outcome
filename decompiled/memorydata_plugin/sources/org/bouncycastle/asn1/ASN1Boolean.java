package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1Boolean extends ASN1Primitive {
    public static final ASN1Boolean FALSE = null;
    public static final ASN1Boolean TRUE = null;
    static final ASN1UniversalType TYPE = null;
    private final byte value;

    static {
        final Class<ASN1Boolean> r1 = ASN1Boolean.class;
        final int r2 = 1;
        TYPE = new AnonymousClass1(r1, r2);
        FALSE = new ASN1Boolean((byte) 0);
        TRUE = new ASN1Boolean((byte) -1);
    }

    private ASN1Boolean(byte r1) {
        this.value = r1;
    }

    static ASN1Boolean createPrimitive(byte[] r2) {
        if (r2.length != 1) goto L14;
        byte r3 = r2[0];
        if (r3 == (-1)) goto L12;
        if (r3 == 0) goto L10;
        return new ASN1Boolean(r3);
    L10:
        return FALSE;
    L12:
        return TRUE;
    L14:
        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
    }

    public static ASN1Boolean getInstance(Object r4) {
        if (r4 == null) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, ASN1Boolean.class) == true) goto L18;
        if ((r4 instanceof byte[]) == false) goto L16;
        return (ASN1Boolean) ZeusTransformUtils.preCheckCast(TYPE.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")), ASN1Boolean.class, "com.obric.memorydata.plugin");
    L12:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct boolean from byte[]: " + e.getMessage());
    L16:
        throw new IllegalArgumentException("illegal object in getInstance: " + r4.getClass().getName());
    L18:
        return (ASN1Boolean) ZeusTransformUtils.preCheckCast(r4, ASN1Boolean.class, "com.obric.memorydata.plugin");
    }

    public static ASN1Boolean getInstance(ASN1TaggedObject r1, boolean r2) {
        return (ASN1Boolean) ZeusTransformUtils.preCheckCast(TYPE.getContextInstance(r1, r2), ASN1Boolean.class, "com.obric.memorydata.plugin");
    }

    public static ASN1Boolean getInstance(boolean r0) {
        if (r0 == false) goto L5;
        return TRUE;
    L5:
        return FALSE;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r4) {
        if (ZeusTransformUtils.instanceOf(r4, ASN1Boolean.class) == true) goto L5;
        return false;
    L5:
        ASN1Boolean r5 = (ASN1Boolean) ZeusTransformUtils.preCheckCast(r4, ASN1Boolean.class, "com.obric.memorydata.plugin");
        if (isTrue() != r5.isTrue()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 1, this.value);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, 1);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return isTrue() ? 1 : 0;
    }

    public boolean isTrue() {
        if (this.value == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        if (isTrue() == false) goto L6;
        return TRUE;
    L6:
        return FALSE;
    }

    public String toString() {
        if (isTrue() == false) goto L5;
        return "TRUE";
    L5:
        return "FALSE";
    }
}
