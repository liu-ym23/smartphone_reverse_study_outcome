package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1BMPString extends ASN1Primitive implements ASN1String {
    static final ASN1UniversalType TYPE = null;
    final char[] string;

    static {
        final Class<ASN1BMPString> r1 = ASN1BMPString.class;
        final int r2 = 30;
        TYPE = new AnonymousClass1(r1, r2);
    }

    ASN1BMPString(byte[] r6) {
        Objects.requireNonNull(r6, "'string' cannot be null");
        int r0 = r6.length;
        if ((r0 & 1) != 0) goto L10;
        int r1 = r0 / 2;
        char[] r2 = new char[r1];
        int r3 = 0;
    L5:
        if (r3 == r1) goto L7;
        int r4 = r3 * 2;
        int r5 = r6[r4] << 8;
        r2[r3] = (char) ((r6[r4 + 1] & 255) | r5);
        r3 = r3 + 1;
        goto L5
    L7:
        this.string = r2;
        return;
    L10:
        throw new IllegalArgumentException("malformed BMPString encoding encountered");
    }

    ASN1BMPString(char[] r2) {
        Objects.requireNonNull(r2, "'string' cannot be null");
        this.string = r2;
    }

    static ASN1BMPString createPrimitive(byte[] r1) {
        return new DERBMPString(r1);
    }

    static ASN1BMPString createPrimitive(char[] r1) {
        return new DERBMPString(r1);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean asn1Equals(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(r3, ASN1BMPString.class) == true) goto L6;
        return false;
    L6:
        ASN1BMPString r4 = (ASN1BMPString) ZeusTransformUtils.preCheckCast(r3, ASN1BMPString.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.string, r4.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final void encode(ASN1OutputStream r12, boolean r13) {
        int r0 = this.string.length;
        r12.writeIdentifier(r13, 30);
        r12.writeDL(r0 * 2);
        byte[] r1 = new byte[8];
        int r2 = r0 & (-4);
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L6;
        char[] r6 = this.string;
        char r7 = r6[r4];
        char r8 = r6[r4 + 1];
        char r9 = r6[r4 + 2];
        char r10 = r6[r4 + 3];
        r4 = r4 + 4;
        r1[0] = (byte) (r7 >> '\b');
        r1[1] = (byte) r7;
        r1[2] = (byte) (r8 >> '\b');
        r1[3] = (byte) r8;
        r1[4] = (byte) (r9 >> '\b');
        r1[5] = (byte) r9;
        r1[6] = (byte) (r10 >> '\b');
        r1[7] = (byte) r10;
        r12.write(r1, 0, 8);
        goto L4
    L6:
        if (r4 >= r0) goto L15;
        int r14 = 0;
    L8:
        char r3 = this.string[r4];
        r4 = r4 + 1;
        int r11 = r14 + 1;
        r1[r14] = (byte) (r3 >> '\b');
        r14 = r11 + 1;
        r1[r11] = (byte) r3;
        if (r4 < r0) goto L8;
        r12.write(r1, 0, r14);
        return;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, this.string.length * 2);
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public final String getString() {
        return new String(this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public final int hashCode() {
        return Arrays.hashCode(this.string);
    }

    public String toString() {
        return getString();
    }
}
