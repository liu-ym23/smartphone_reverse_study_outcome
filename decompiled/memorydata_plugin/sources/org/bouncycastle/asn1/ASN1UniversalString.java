package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1UniversalString extends ASN1Primitive implements ASN1String {
    static final ASN1UniversalType TYPE = null;
    private static final char[] table = null;
    final byte[] contents;

    static {
        final Class<ASN1UniversalString> r1 = ASN1UniversalString.class;
        final int r2 = 28;
        TYPE = new AnonymousClass1(r1, r2);
        table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    ASN1UniversalString(byte[] r1, boolean r2) {
        if (r2 == false) goto L5;
        r1 = Arrays.clone(r1);
    L5:
        this.contents = r1;
    }

    static ASN1UniversalString createPrimitive(byte[] r2) {
        return new DERUniversalString(r2, false);
    }

    private static void encodeHexByte(StringBuffer r2, int r3) {
        char[] r0 = table;
        r2.append(r0[(r3 >>> 4) & 15]);
        r2.append(r0[r3 & 15]);
    }

    private static void encodeHexDL(StringBuffer r5, int r6) {
        if (r6 >= 128) goto L6;
        encodeHexByte(r5, r6);
        return;
    L6:
        byte[] r2 = new byte[5];
        int r3 = 5;
    L7:
        r3 = r3 - 1;
        r2[r3] = (byte) r6;
        r6 = r6 >>> 8;
        if (r6 != 0) goto L7;
        int r7 = 5 - r3;
        int r4 = r3 - 1;
        r2[r4] = (byte) (r7 | 128);
    L10:
        int r8 = r4 + 1;
        encodeHexByte(r5, r2[r4]);
        if (r8 >= 5) goto L12;
        r4 = r8;
        goto L10
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean asn1Equals(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(r3, ASN1UniversalString.class) == true) goto L6;
        return false;
    L6:
        ASN1UniversalString r4 = (ASN1UniversalString) ZeusTransformUtils.preCheckCast(r3, ASN1UniversalString.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.contents, r4.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 28, this.contents);
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
        int r0 = this.contents.length;
        StringBuffer r1 = new StringBuffer(((ASN1OutputStream.getLengthOfDL(r0) + r0) * 2) + 3);
        r1.append("#1C");
        encodeHexDL(r1, r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        encodeHexByte(r1, this.contents[r2]);
        r2 = r2 + 1;
        goto L3
    L6:
        return r1.toString();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return getString();
    }
}
