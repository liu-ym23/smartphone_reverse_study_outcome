package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1VideotexString extends ASN1Primitive implements ASN1String {
    static final ASN1UniversalType TYPE = null;
    final byte[] contents;

    static {
        final Class<ASN1VideotexString> r1 = ASN1VideotexString.class;
        final int r2 = 21;
        TYPE = new AnonymousClass1(r1, r2);
    }

    ASN1VideotexString(byte[] r1, boolean r2) {
        if (r2 == false) goto L5;
        r1 = Arrays.clone(r1);
    L5:
        this.contents = r1;
    }

    static ASN1VideotexString createPrimitive(byte[] r2) {
        return new DERVideotexString(r2, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean asn1Equals(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(r3, ASN1VideotexString.class) == true) goto L6;
        return false;
    L6:
        ASN1VideotexString r4 = (ASN1VideotexString) ZeusTransformUtils.preCheckCast(r3, ASN1VideotexString.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.contents, r4.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 21, this.contents);
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
}
