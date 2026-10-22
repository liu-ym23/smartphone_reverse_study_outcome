package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;
import okhttp3.HttpUrl;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1Sequence extends ASN1Primitive implements Iterable<ASN1Encodable> {
    static final ASN1UniversalType TYPE = null;
    ASN1Encodable[] elements;

    static {
        final Class<ASN1Sequence> r1 = ASN1Sequence.class;
        final int r2 = 16;
        TYPE = new AnonymousClass1(r1, r2);
    }

    public ASN1Sequence() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
    }

    public ASN1Sequence(ASN1Encodable r3) {
        ASN1Encodable r4 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "'element' cannot be null");
        this.elements = new ASN1Encodable[]{r4};
    }

    public ASN1Sequence(ASN1EncodableVector r2) {
        Objects.requireNonNull(r2, "'elementVector' cannot be null");
        this.elements = r2.takeElements();
    }

    public ASN1Sequence(ASN1Encodable[] r2) {
        if (Arrays.isNullOrContainsNull(r2) == true) goto L7;
        this.elements = ASN1EncodableVector.cloneElements(r2);
        return;
    L7:
        throw new NullPointerException("'elements' cannot be null, or contain null");
    }

    ASN1Sequence(ASN1Encodable[] r1, boolean r2) {
        if (r2 == false) goto L5;
        r1 = ASN1EncodableVector.cloneElements(r1);
    L5:
        this.elements = r1;
    }

    public static ASN1Sequence getInstance(Object r4) {
        if (r4 != null) goto L5;
    L23:
        Object r5 = ZeusTransformUtils.preCheckCast(r4, ASN1Sequence.class, "com.obric.memorydata.plugin");
    L13:
        return (ASN1Sequence) r5;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ASN1Sequence.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, ASN1Encodable.class) == false) goto L15;
        ASN1Primitive r0 = ((ASN1Encodable) ZeusTransformUtils.preCheckCast(r4, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive();
        if (ZeusTransformUtils.instanceOf(r0, ASN1Sequence.class) == false) goto L22;
        r5 = ZeusTransformUtils.preCheckCast(r0, ASN1Sequence.class, "com.obric.memorydata.plugin");
    L22:
        throw new IllegalArgumentException("unknown object in getInstance: " + r4.getClass().getName());
    L15:
        if ((r4 instanceof byte[]) == false) goto L22;
        return (ASN1Sequence) ZeusTransformUtils.preCheckCast(TYPE.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")), ASN1Sequence.class, "com.obric.memorydata.plugin");
    L18:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
    }

    public static ASN1Sequence getInstance(ASN1TaggedObject r1, boolean r2) {
        return (ASN1Sequence) ZeusTransformUtils.preCheckCast(TYPE.getContextInstance(r1, r2), ASN1Sequence.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r6) {
        if (ZeusTransformUtils.instanceOf(r6, ASN1Sequence.class) == true) goto L5;
        return false;
    L5:
        ASN1Sequence r7 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r6, ASN1Sequence.class, "com.obric.memorydata.plugin");
        int r0 = size();
        if (r7.size() == r0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L16;
        ASN1Primitive r3 = this.elements[r1].toASN1Primitive();
        ASN1Primitive r4 = r7.elements[r1].toASN1Primitive();
        if (r3 == r4) goto L15;
        if (r3.asn1Equals(r4) == true) goto L15;
        return false;
    L15:
        r1 = r1 + 1;
        goto L9
    L16:
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return true;
    }

    ASN1BitString[] getConstructedBitStrings() {
        int r0 = size();
        ASN1BitString[] r1 = new ASN1BitString[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = ASN1BitString.getInstance(this.elements[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    ASN1OctetString[] getConstructedOctetStrings() {
        int r0 = size();
        ASN1OctetString[] r1 = new ASN1OctetString[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = ASN1OctetString.getInstance(this.elements[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public ASN1Encodable getObjectAt(int r1) {
        return this.elements[r1];
    }

    public Enumeration getObjects() {
        return new AnonymousClass2(this);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        int r0 = this.elements.length;
        int r1 = r0 + 1;
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L6;
        r1 = (r1 * 257) ^ this.elements[r0].toASN1Primitive().hashCode();
        goto L3
    L6:
        return r1;
    }

    @Override // java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(this.elements);
    }

    public int size() {
        return this.elements.length;
    }

    abstract ASN1BitString toASN1BitString();

    abstract ASN1External toASN1External();

    abstract ASN1OctetString toASN1OctetString();

    abstract ASN1Set toASN1Set();

    ASN1Encodable[] toArrayInternal() {
        return this.elements;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return new DERSequence(this.elements, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return new DLSequence(this.elements, false);
    }

    public String toString() {
        int r0 = size();
        if (r0 != 0) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        StringBuffer r1 = new StringBuffer();
        r1.append('[');
        int r2 = 0;
    L7:
        r1.append(this.elements[r2]);
        r2 = r2 + 1;
        if (r2 >= r0) goto L9;
        r1.append(", ");
        goto L7
    L9:
        r1.append(']');
        return r1.toString();
    }
}
