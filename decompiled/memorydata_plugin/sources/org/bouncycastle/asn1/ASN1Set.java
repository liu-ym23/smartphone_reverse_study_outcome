package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Objects;
import okhttp3.HttpUrl;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1Set extends ASN1Primitive implements Iterable<ASN1Encodable> {
    static final ASN1UniversalType TYPE = null;
    protected final ASN1Encodable[] elements;
    protected final boolean isSorted;

    static {
        final Class<ASN1Set> r1 = ASN1Set.class;
        final int r2 = 17;
        TYPE = new AnonymousClass1(r1, r2);
    }

    public ASN1Set() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
        this.isSorted = true;
    }

    public ASN1Set(ASN1EncodableVector r3, boolean r4) {
        Objects.requireNonNull(r3, "'elementVector' cannot be null");
        if (r4 == true) goto L5;
    L7:
        ASN1Encodable[] r5 = r3.takeElements();
    L8:
        this.elements = r5;
        if (r4 == false) goto L11;
    L14:
        boolean r6 = true;
    L15:
        this.isSorted = r6;
        return;
    L11:
        if (r5.length < 2) goto L14;
        r6 = false;
        goto L15
    L5:
        if (r3.size() < 2) goto L7;
        r5 = r3.copyElements();
        sort(r5);
        goto L8
    }

    ASN1Set(boolean r1, ASN1Encodable[] r2) {
        this.elements = r2;
        if (r1 == false) goto L5;
    L8:
        boolean r3 = true;
    L9:
        this.isSorted = r3;
        return;
    L5:
        if (r2.length < 2) goto L8;
        r3 = false;
        goto L9
    }

    private static byte[] getDEREncoded(ASN1Encodable r2) {
        return ((ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r2, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive().getEncoded("DER");
    L6:
        throw new IllegalArgumentException("cannot encode object added to SET");
    }

    public static ASN1Set getInstance(Object r4) {
        if (r4 != null) goto L5;
    L23:
        Object r5 = ZeusTransformUtils.preCheckCast(r4, ASN1Set.class, "com.obric.memorydata.plugin");
    L13:
        return (ASN1Set) r5;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ASN1Set.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, ASN1Encodable.class) == false) goto L15;
        ASN1Primitive r0 = ((ASN1Encodable) ZeusTransformUtils.preCheckCast(r4, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive();
        if (ZeusTransformUtils.instanceOf(r0, ASN1Set.class) == false) goto L22;
        r5 = ZeusTransformUtils.preCheckCast(r0, ASN1Set.class, "com.obric.memorydata.plugin");
    L22:
        throw new IllegalArgumentException("unknown object in getInstance: " + r4.getClass().getName());
    L15:
        if ((r4 instanceof byte[]) == false) goto L22;
        return (ASN1Set) ZeusTransformUtils.preCheckCast(TYPE.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")), ASN1Set.class, "com.obric.memorydata.plugin");
    L18:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct set from byte[]: " + e.getMessage());
    }

    public static ASN1Set getInstance(ASN1TaggedObject r1, boolean r2) {
        return (ASN1Set) ZeusTransformUtils.preCheckCast(TYPE.getContextInstance(r1, r2), ASN1Set.class, "com.obric.memorydata.plugin");
    }

    private static boolean lessThanOrEqual(byte[] r6, byte[] r7) {
        int r1 = r6[0] & MessagePack.Code.MAP32;
        int r2 = r7[0] & MessagePack.Code.MAP32;
        if (r1 == r2) goto L7;
        if (r1 < r2) goto L6;
        return false;
    L6:
        return true;
    L7:
        int r3 = Math.min(r6.length, r7.length) - 1;
        int r4 = 1;
    L8:
        if (r4 >= r3) goto L17;
        if (r6[r4] != r7[r4]) goto L12;
        r4 = r4 + 1;
        goto L8
    L12:
        if ((r6[r4] & 255) < (r7[r4] & 255)) goto L14;
        return false;
    L14:
        return true;
    L17:
        if ((r6[r3] & 255) <= (r7[r3] & 255)) goto L19;
        return false;
    L19:
        return true;
    }

    private static void sort(ASN1Encodable[] r14) {
        int r0 = r14.length;
        int r1 = 2;
        if (r0 >= 2) goto L5;
        return;
    L5:
        ASN1Encodable r2 = r14[0];
        ASN1Encodable r4 = r14[1];
        byte[] r5 = getDEREncoded(r2);
        byte[] r6 = getDEREncoded(r4);
        if (lessThanOrEqual(r6, r5) == false) goto L8;
        r4 = r2;
        r2 = r4;
        r6 = r5;
        r5 = r6;
    L8:
        if (r1 >= r0) goto L24;
        ASN1Encodable r7 = r14[r1];
        byte[] r8 = getDEREncoded(r7);
        if (lessThanOrEqual(r6, r8) == false) goto L13;
        r14[r1 - 2] = r2;
        r2 = r4;
        r5 = r6;
        r4 = r7;
        r6 = r8;
    L23:
        r1 = r1 + 1;
        goto L8
    L13:
        if (lessThanOrEqual(r5, r8) == false) goto L15;
        r14[r1 - 2] = r2;
        r2 = r7;
        r5 = r8;
        goto L23
    L15:
        int r9 = r1 - 1;
    L16:
        r9 = r9 - 1;
        if (r9 <= 0) goto L22;
        ASN1Encodable r10 = r14[r9 - 1];
        if (lessThanOrEqual(getDEREncoded(r10), r8) == true) goto L22;
        r14[r9] = r10;
    L22:
        r14[r9] = r7;
        goto L23
    L24:
        r14[r0 - 2] = r2;
        r14[r0 - 1] = r4;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r6) {
        if (ZeusTransformUtils.instanceOf(r6, ASN1Set.class) == true) goto L5;
        return false;
    L5:
        ASN1Set r7 = (ASN1Set) ZeusTransformUtils.preCheckCast(r6, ASN1Set.class, "com.obric.memorydata.plugin");
        int r0 = size();
        if (r7.size() == r0) goto L8;
        return false;
    L8:
        DERSet r5 = (DERSet) ZeusTransformUtils.preCheckCast(toDERObject(), DERSet.class, "com.obric.memorydata.plugin");
        DERSet r8 = (DERSet) ZeusTransformUtils.preCheckCast(r7.toDERObject(), DERSet.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L16;
        ASN1Primitive r3 = r5.elements[r1].toASN1Primitive();
        ASN1Primitive r4 = r8.elements[r1].toASN1Primitive();
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

    public ASN1Encodable getObjectAt(int r1) {
        return this.elements[r1];
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        int r0 = this.elements.length;
        int r1 = r0 + 1;
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L6;
        r1 = r1 + this.elements[r0].toASN1Primitive().hashCode();
        goto L3
    L6:
        return r1;
    }

    @Override // java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(toArray());
    }

    public int size() {
        return this.elements.length;
    }

    public ASN1Encodable[] toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        boolean r0 = this.isSorted;
        ASN1Encodable[] r2 = this.elements;
        if (r0 == true) goto L7;
        r2 = (ASN1Encodable[]) ZeusTransformUtils.preCheckCast((ASN1Encodable[]) ZeusTransformUtils.preCheckCast(r2.clone(), ASN1Encodable[].class, "com.obric.memorydata.plugin"), ASN1Encodable[].class, "com.obric.memorydata.plugin");
        sort(r2);
    L7:
        return new DERSet(true, r2);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return new DLSet(this.isSorted, this.elements);
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
