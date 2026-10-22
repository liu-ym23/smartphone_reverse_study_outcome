package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1BitString extends ASN1Primitive implements ASN1BitStringParser, ASN1String {
    static final ASN1UniversalType TYPE = null;
    private static final char[] table = null;
    final byte[] contents;

    static {
        final Class<ASN1BitString> r1 = ASN1BitString.class;
        final int r2 = 3;
        TYPE = new AnonymousClass1(r1, r2);
        table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    ASN1BitString(byte[] r2, int r3) {
        Objects.requireNonNull(r2, "'data' cannot be null");
        if (r2.length != 0) goto L9;
        if (r3 == 0) goto L9;
        throw new IllegalArgumentException("zero length data with non-zero pad bits");
    L9:
        if (r3 > 7) goto L14;
        if (r3 < 0) goto L14;
        this.contents = Arrays.prepend(r2, (byte) r3);
        return;
    L14:
        throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
    }

    ASN1BitString(byte[] r3, boolean r4) {
        if (r4 == false) goto L19;
        Objects.requireNonNull(r3, "'contents' cannot be null");
        if (r3.length < 1) goto L18;
        int r5 = r3[0] & 255;
        if (r5 <= 0) goto L19;
        if (r3.length < 2) goto L16;
        if (r5 <= 7) goto L19;
        throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
    L16:
        throw new IllegalArgumentException("zero length data with non-zero pad bits");
    L18:
        throw new IllegalArgumentException("'contents' cannot be empty");
    L19:
        this.contents = r3;
    }

    static ASN1BitString createPrimitive(byte[] r6) {
        int r0 = r6.length;
        if (r0 < 1) goto L19;
        int r3 = r6[0] & 255;
        if (r3 <= 0) goto L17;
        if (r3 > 7) goto L15;
        if (r0 < 2) goto L15;
        byte r1 = r6[r0 - 1];
        if (r1 == ((byte) ((255 << r3) & r1))) goto L17;
        return new DLBitString(r6, false);
    L15:
        throw new IllegalArgumentException("invalid pad bits detected");
    L17:
        return new DERBitString(r6, false);
    L19:
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    public static ASN1BitString getInstance(Object r4) {
        if (r4 != null) goto L5;
    L23:
        Object r5 = ZeusTransformUtils.preCheckCast(r4, ASN1BitString.class, "com.obric.memorydata.plugin");
    L13:
        return (ASN1BitString) r5;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ASN1BitString.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, ASN1Encodable.class) == false) goto L15;
        ASN1Primitive r0 = ((ASN1Encodable) ZeusTransformUtils.preCheckCast(r4, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive();
        if (ZeusTransformUtils.instanceOf(r0, ASN1BitString.class) == false) goto L22;
        r5 = ZeusTransformUtils.preCheckCast(r0, ASN1BitString.class, "com.obric.memorydata.plugin");
    L22:
        throw new IllegalArgumentException("illegal object in getInstance: " + r4.getClass().getName());
    L15:
        if ((r4 instanceof byte[]) == false) goto L22;
        return (ASN1BitString) ZeusTransformUtils.preCheckCast(TYPE.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")), ASN1BitString.class, "com.obric.memorydata.plugin");
    L18:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct BIT STRING from byte[]: " + e.getMessage());
    }

    public static ASN1BitString getInstance(ASN1TaggedObject r1, boolean r2) {
        return (ASN1BitString) ZeusTransformUtils.preCheckCast(TYPE.getContextInstance(r1, r2), ASN1BitString.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r7) {
        if (ZeusTransformUtils.instanceOf(r7, ASN1BitString.class) == true) goto L5;
        return false;
    L5:
        ASN1BitString r8 = (ASN1BitString) ZeusTransformUtils.preCheckCast(r7, ASN1BitString.class, "com.obric.memorydata.plugin");
        byte[] r6 = this.contents;
        byte[] r9 = r8.contents;
        int r0 = r6.length;
        if (r9.length == r0) goto L9;
        return false;
    L9:
        if (r0 != 1) goto L11;
        return true;
    L11:
        int r1 = r0 - 1;
        int r3 = 0;
    L12:
        if (r3 >= r1) goto L17;
        if (r6[r3] != r9[r3]) goto L15;
        r3 = r3 + 1;
        goto L12
    L15:
        return false;
    L17:
        int r4 = 255 << (r6[0] & 255);
        if (((byte) (r6[r1] & r4)) == ((byte) (r9[r1] & r4))) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public InputStream getBitStream() {
        byte[] r3 = this.contents;
        return new ByteArrayInputStream(r3, 1, r3.length - 1);
    }

    public byte[] getBytes() {
        byte[] r4 = this.contents;
        if (r4.length == 1) goto L5;
        int r0 = r4[0] & 255;
        byte[] r5 = Arrays.copyOfRange(r4, 1, r4.length);
        int r3 = r5.length - 1;
        byte r1 = (byte) (255 << r0);
        r5[r3] = (byte) (r1 & r5[r3]);
        return r5;
    L5:
        return ASN1OctetString.EMPTY_OCTETS;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    public byte[] getOctets() {
        byte[] r2 = this.contents;
        if (r2[0] != 0) goto L7;
        return Arrays.copyOfRange(r2, 1, r2.length);
    L7:
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public int getPadBits() {
        return this.contents[0] & 255;
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public String getString() {
        byte[] r5 = getEncoded();     // Catch: IOException -> L9
        StringBuffer r0 = new StringBuffer((r5.length * 2) + 1);
        r0.append('#');
        int r1 = 0;
    L5:
        if (r1 == r5.length) goto L8;
        byte r2 = r5[r1];
        char[] r3 = table;
        r0.append(r3[(r2 >>> 4) & 15]);
        r0.append(r3[r2 & 15]);
        r1 = r1 + 1;
        goto L5
    L8:
        return r0.toString();
    L9:
        e = move-exception;
        throw new ASN1ParsingException("Internal error encoding BitString: " + e.getMessage(), e);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        byte[] r5 = this.contents;
        if (r5.length >= 2) goto L5;
        return 1;
    L5:
        int r2 = r5[0] & 255;
        int r4 = r5.length - 1;
        byte r1 = (byte) (r5[r4] & (255 << r2));
        return (Arrays.hashCode(r5, 0, r4) * 257) ^ r1;
    }

    public int intValue() {
        int r0 = Math.min(5, this.contents.length - 1);
        int r4 = 1;
        int r5 = 0;
    L4:
        if (r4 >= r0) goto L6;
        r5 = r5 | ((255 & this.contents[r4]) << ((r4 - 1) * 8));
        r4 = r4 + 1;
        goto L4
    L6:
        if (1 > r0) goto L11;
        if (r0 >= 5) goto L12;
        byte[] r8 = this.contents;
        return r5 | ((((byte) (r8[r0] & (255 << (r8[0] & 255)))) & 255) << ((r0 - 1) * 8));
    L12:
        return r5;
    L11:
        return r5;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return new DERBitString(this.contents, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return new DLBitString(this.contents, false);
    }

    public String toString() {
        return getString();
    }
}
