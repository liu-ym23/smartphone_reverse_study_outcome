package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1Integer extends ASN1Primitive {
    static final ASN1UniversalType TYPE = null;
    private final byte[] bytes;
    private final int start;

    static {
        final Class<ASN1Integer> r1 = ASN1Integer.class;
        final int r2 = 2;
        TYPE = new AnonymousClass1(r1, r2);
    }

    public ASN1Integer(long r1) {
        this.bytes = BigInteger.valueOf(r1).toByteArray();
        this.start = 0;
    }

    public ASN1Integer(BigInteger r1) {
        this.bytes = r1.toByteArray();
        this.start = 0;
    }

    ASN1Integer(byte[] r2, boolean r3) {
        if (isMalformed(r2) == true) goto L10;
        if (r3 == false) goto L6;
        byte[] r4 = Arrays.clone(r2);
    L7:
        this.bytes = r4;
        this.start = signBytesToSkip(r2);
        return;
    L6:
        r4 = r2;
        goto L7
    L10:
        throw new IllegalArgumentException("malformed integer");
    }

    static ASN1Integer createPrimitive(byte[] r2) {
        return new ASN1Integer(r2, false);
    }

    public static ASN1Integer getInstance(Object r4) {
        if (r4 == null) goto L17;
        if (ZeusTransformUtils.instanceOf(r4, ASN1Integer.class) == true) goto L17;
        if ((r4 instanceof byte[]) == false) goto L15;
        return (ASN1Integer) ZeusTransformUtils.preCheckCast(TYPE.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")), ASN1Integer.class, "com.obric.memorydata.plugin");
    L11:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L15:
        throw new IllegalArgumentException("illegal object in getInstance: " + r4.getClass().getName());
    L17:
        return (ASN1Integer) ZeusTransformUtils.preCheckCast(r4, ASN1Integer.class, "com.obric.memorydata.plugin");
    }

    public static ASN1Integer getInstance(ASN1TaggedObject r1, boolean r2) {
        return (ASN1Integer) ZeusTransformUtils.preCheckCast(TYPE.getContextInstance(r1, r2), ASN1Integer.class, "com.obric.memorydata.plugin");
    }

    static int intValue(byte[] r2, int r3, int r4) {
        int r0 = r2.length;
        int r5 = Math.max(r3, r0 - 4);
        int r6 = r4 & r2[r5];
    L3:
        r5 = r5 + 1;
        if (r5 >= r0) goto L6;
        r6 = (r6 << 8) | (r2[r5] & 255);
        goto L3
    L6:
        return r6;
    }

    static boolean isMalformed(byte[] r3) {
        int r0 = r3.length;
        if (r0 != 0) goto L5;
        return true;
    L5:
        if (r0 != 1) goto L7;
        return false;
    L7:
        if (r3[0] != (r3[1] >> 7)) goto L12;
        if (Properties.isOverrideSet("org.bouncycastle.asn1.allow_unsafe_integer") == true) goto L12;
        return true;
    L12:
        return false;
    }

    static long longValue(byte[] r5, int r6, int r7) {
        int r0 = r5.length;
        int r8 = Math.max(r6, r0 - 8);
        long r1 = r7 & r5[r8];
    L3:
        r8 = r8 + 1;
        if (r8 >= r0) goto L6;
        r1 = (r1 << 8) | ((long) (r5[r8] & 255));
        goto L3
    L6:
        return r1;
    }

    static int signBytesToSkip(byte[] r5) {
        int r0 = r5.length - 1;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L7;
        int r3 = r1 + 1;
        if (r5[r1] != (r5[r3] >> 7)) goto L7;
        r1 = r3;
    L7:
        return r1;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(r3, ASN1Integer.class) == true) goto L6;
        return false;
    L6:
        ASN1Integer r4 = (ASN1Integer) ZeusTransformUtils.preCheckCast(r3, ASN1Integer.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.bytes, r4.bytes);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 2, this.bytes);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, this.bytes.length);
    }

    public BigInteger getPositiveValue() {
        return new BigInteger(1, this.bytes);
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public boolean hasValue(int r4) {
        byte[] r0 = this.bytes;
        int r1 = r0.length;
        int r3 = this.start;
        if ((r1 - r3) <= 4) goto L5;
    L7:
        return false;
    L5:
        if (intValue(r0, r3, -1) != r4) goto L7;
        return true;
    }

    public boolean hasValue(BigInteger r4) {
        if (r4 != null) goto L4;
    L8:
        return false;
    L4:
        if (intValue(this.bytes, this.start, -1) != r4.intValue()) goto L8;
        if (getValue().equals(r4) == false) goto L8;
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }

    public int intPositiveValueExact() {
        byte[] r0 = this.bytes;
        int r1 = r0.length;
        int r3 = this.start;
        int r2 = r1 - r3;
        if (r2 > 4) goto L10;
        if (r2 != 4) goto L8;
        if ((r0[r3] & 128) != 0) goto L10;
    L8:
        return intValue(r0, r3, 255);
    L10:
        throw new ArithmeticException("ASN.1 Integer out of positive int range");
    }

    public int intValueExact() {
        byte[] r0 = this.bytes;
        int r1 = r0.length;
        int r3 = this.start;
        if ((r1 - r3) > 4) goto L7;
        return intValue(r0, r3, -1);
    L7:
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    public long longValueExact() {
        byte[] r0 = this.bytes;
        int r1 = r0.length;
        int r3 = this.start;
        if ((r1 - r3) > 8) goto L7;
        return longValue(r0, r3, -1);
    L7:
        throw new ArithmeticException("ASN.1 Integer out of long range");
    }

    public String toString() {
        return getValue().toString();
    }
}
