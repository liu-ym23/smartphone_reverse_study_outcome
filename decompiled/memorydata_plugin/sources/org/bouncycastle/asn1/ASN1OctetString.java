package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Objects;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1OctetString extends ASN1Primitive implements ASN1OctetStringParser {
    static final byte[] EMPTY_OCTETS = null;
    static final ASN1UniversalType TYPE = null;
    byte[] string;

    static {
        final Class<ASN1OctetString> r1 = ASN1OctetString.class;
        final int r2 = 4;
        TYPE = new AnonymousClass1(r1, r2);
        EMPTY_OCTETS = new byte[0];
    }

    public ASN1OctetString(byte[] r2) {
        Objects.requireNonNull(r2, "'string' cannot be null");
        this.string = r2;
    }

    static ASN1OctetString createPrimitive(byte[] r1) {
        return new DEROctetString(r1);
    }

    public static ASN1OctetString getInstance(Object r4) {
        if (r4 != null) goto L5;
    L23:
        Object r5 = ZeusTransformUtils.preCheckCast(r4, ASN1OctetString.class, "com.obric.memorydata.plugin");
    L13:
        return (ASN1OctetString) r5;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ASN1OctetString.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, ASN1Encodable.class) == false) goto L15;
        ASN1Primitive r0 = ((ASN1Encodable) ZeusTransformUtils.preCheckCast(r4, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive();
        if (ZeusTransformUtils.instanceOf(r0, ASN1OctetString.class) == false) goto L22;
        r5 = ZeusTransformUtils.preCheckCast(r0, ASN1OctetString.class, "com.obric.memorydata.plugin");
    L22:
        throw new IllegalArgumentException("illegal object in getInstance: " + r4.getClass().getName());
    L15:
        if ((r4 instanceof byte[]) == false) goto L22;
        return (ASN1OctetString) ZeusTransformUtils.preCheckCast(TYPE.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")), ASN1OctetString.class, "com.obric.memorydata.plugin");
    L18:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e.getMessage());
    }

    public static ASN1OctetString getInstance(ASN1TaggedObject r1, boolean r2) {
        return (ASN1OctetString) ZeusTransformUtils.preCheckCast(TYPE.getContextInstance(r1, r2), ASN1OctetString.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(r3, ASN1OctetString.class) == true) goto L6;
        return false;
    L6:
        ASN1OctetString r4 = (ASN1OctetString) ZeusTransformUtils.preCheckCast(r3, ASN1OctetString.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.string, r4.string);
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    @Override // org.bouncycastle.asn1.ASN1OctetStringParser
    public InputStream getOctetStream() {
        return new ByteArrayInputStream(this.string);
    }

    public byte[] getOctets() {
        return this.string;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return new DEROctetString(this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return new DEROctetString(this.string);
    }

    public String toString() {
        return "#" + Strings.fromByteArray(Hex.encode(this.string));
    }
}
