package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1Primitive extends ASN1Object {
    ASN1Primitive() {
    }

    public static ASN1Primitive fromByteArray(byte[] r1) {
        ASN1InputStream r0 = new ASN1InputStream(r1);
        ASN1Primitive r2 = r0.readObject();     // Catch: ClassCastException -> L8
        if (r0.available() != 0) goto L7;
        return r2;
    L7:
        throw new IOException("Extra data detected in stream");     // Catch: ClassCastException -> L8
    L9:
        throw new IOException("cannot recognise object in stream");
    }

    abstract boolean asn1Equals(ASN1Primitive r1);

    abstract void encode(ASN1OutputStream r1, boolean r2);

    abstract boolean encodeConstructed();

    @Override // org.bouncycastle.asn1.ASN1Object
    public void encodeTo(OutputStream r2) {
        ASN1OutputStream r3 = ASN1OutputStream.create(r2);
        r3.writePrimitive(this, true);
        r3.flushInternal();
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public void encodeTo(OutputStream r1, String r2) {
        ASN1OutputStream r3 = ASN1OutputStream.create(r1, r2);
        r3.writePrimitive(this, true);
        r3.flushInternal();
    }

    abstract int encodedLength(boolean r1);

    @Override // org.bouncycastle.asn1.ASN1Object
    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ASN1Encodable.class) == true) goto L8;
    L10:
        return false;
    L8:
        if (asn1Equals(((ASN1Encodable) ZeusTransformUtils.preCheckCast(r4, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive()) == false) goto L10;
        return true;
    }

    public final boolean equals(ASN1Encodable r3) {
        ASN1Encodable r4 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (this == r4) goto L9;
        if (r4 != null) goto L6;
    L8:
        return false;
    L6:
        if (asn1Equals(r4.toASN1Primitive()) == false) goto L8;
    L9:
        return true;
    }

    public final boolean equals(ASN1Primitive r1) {
        if (this != r1) goto L4;
    L7:
        return true;
    L4:
        if (asn1Equals(r1) == true) goto L7;
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public abstract int hashCode();

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public final ASN1Primitive toASN1Primitive() {
        return this;
    }

    ASN1Primitive toDERObject() {
        return this;
    }

    ASN1Primitive toDLObject() {
        return this;
    }
}
