package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1Enumerated extends ASN1Primitive {
    static final ASN1UniversalType TYPE = null;
    private static final ASN1Enumerated[] cache = null;
    private final byte[] contents;
    private final int start;

    static {
        final Class<ASN1Enumerated> r1 = ASN1Enumerated.class;
        final int r2 = 10;
        TYPE = new AnonymousClass1(r1, r2);
        cache = new ASN1Enumerated[12];
    }

    public ASN1Enumerated(int r3) {
        if (r3 < 0) goto L7;
        this.contents = BigInteger.valueOf(r3).toByteArray();
        this.start = 0;
        return;
    L7:
        throw new IllegalArgumentException("enumerated must be non-negative");
    }

    public ASN1Enumerated(BigInteger r2) {
        if (r2.signum() < 0) goto L7;
        this.contents = r2.toByteArray();
        this.start = 0;
        return;
    L7:
        throw new IllegalArgumentException("enumerated must be non-negative");
    }

    ASN1Enumerated(byte[] r2, boolean r3) {
        if (ASN1Integer.isMalformed(r2) == true) goto L14;
        if ((r2[0] & 128) != 0) goto L12;
        if (r3 == false) goto L8;
        byte[] r4 = Arrays.clone(r2);
    L9:
        this.contents = r4;
        this.start = ASN1Integer.signBytesToSkip(r2);
        return;
    L8:
        r4 = r2;
        goto L9
    L12:
        throw new IllegalArgumentException("enumerated must be non-negative");
    L14:
        throw new IllegalArgumentException("malformed enumerated");
    }

    static ASN1Enumerated createPrimitive(byte[] r3, boolean r4) {
        if (r3.length <= 1) goto L7;
        return new ASN1Enumerated(r3, r4);
    L7:
        if (r3.length == 0) goto L17;
        int r0 = r3[0] & 255;
        ASN1Enumerated[] r1 = cache;
        if (r0 >= r1.length) goto L11;
        ASN1Enumerated r2 = r1[r0];
        if (r2 != null) goto L18;
        ASN1Enumerated r5 = new ASN1Enumerated(r3, r4);
        r1[r0] = r5;
        return r5;
    L18:
        return r2;
    L11:
        return new ASN1Enumerated(r3, r4);
    L17:
        throw new IllegalArgumentException("ENUMERATED has zero length");
    }

    public static ASN1Enumerated getInstance(Object r4) {
        if (r4 == null) goto L17;
        if (ZeusTransformUtils.instanceOf(r4, ASN1Enumerated.class) == true) goto L17;
        if ((r4 instanceof byte[]) == false) goto L15;
        return (ASN1Enumerated) ZeusTransformUtils.preCheckCast(TYPE.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")), ASN1Enumerated.class, "com.obric.memorydata.plugin");
    L11:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L15:
        throw new IllegalArgumentException("illegal object in getInstance: " + r4.getClass().getName());
    L17:
        return (ASN1Enumerated) ZeusTransformUtils.preCheckCast(r4, ASN1Enumerated.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(r3, ASN1Enumerated.class) == true) goto L6;
        return false;
    L6:
        ASN1Enumerated r4 = (ASN1Enumerated) ZeusTransformUtils.preCheckCast(r3, ASN1Enumerated.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.contents, r4.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 10, this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, this.contents.length);
    }

    public BigInteger getValue() {
        return new BigInteger(this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public int intValueExact() {
        byte[] r0 = this.contents;
        int r1 = r0.length;
        int r3 = this.start;
        if ((r1 - r3) > 4) goto L7;
        return ASN1Integer.intValue(r0, r3, -1);
    L7:
        throw new ArithmeticException("ASN.1 Enumerated out of int range");
    }
}
