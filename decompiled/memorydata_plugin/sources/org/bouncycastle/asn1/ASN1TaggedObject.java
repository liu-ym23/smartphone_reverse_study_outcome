package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1TaggedObject extends ASN1Primitive implements ASN1TaggedObjectParser {
    final int explicitness;
    final ASN1Encodable obj;
    final int tagClass;
    final int tagNo;

    ASN1TaggedObject(int r3, int r4, int r5, ASN1Encodable r6) {
        ASN1Encodable r7 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r6, ASN1Encodable.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r7, "'obj' cannot be null");
        if (r4 == 0) goto L12;
        if ((r4 & 192) != r4) goto L12;
        if (ZeusTransformUtils.instanceOf(r7, ASN1Choice.class) == false) goto L9;
        r3 = 1;
    L9:
        this.explicitness = r3;
        this.tagClass = r4;
        this.tagNo = r5;
        this.obj = r7;
        return;
    L12:
        throw new IllegalArgumentException("invalid tag class: " + r4);
    }

    public ASN1TaggedObject(boolean r3, int r4, int r5, ASN1Encodable r6) {
        ASN1Encodable r7 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r6, ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L5;
        int r8 = 1;
    L6:
        this(r8, r4, r5, r7);
        return;
    L5:
        r8 = 2;
        goto L6
    }

    public ASN1TaggedObject(boolean r3, int r4, ASN1Encodable r5) {
        this(r3, 128, r4, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r5, ASN1Encodable.class, "com.obric.memorydata.plugin"));
    }

    private static ASN1TaggedObject checkedCast(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(r3, ASN1TaggedObject.class) == false) goto L7;
        return (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r3, ASN1TaggedObject.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalStateException("unexpected object: " + r3.getClass().getName());
    }

    static ASN1Primitive createConstructedDL(int r3, int r4, ASN1EncodableVector r5) {
        boolean r2 = true;
        if (r5.size() == 1) goto L7;
        r2 = false;
    L7:
        if (r2 == false) goto L9;
        DLTaggedObject r0 = new DLTaggedObject(3, r3, r4, r5.get(0));
    L11:
        if (r3 == 64) goto L14;
        return r0;
    L14:
        return new DLApplicationSpecific(r0);
    L9:
        r0 = new DLTaggedObject(4, r3, r4, DLFactory.createSequence(r5));
        goto L11
    }

    static ASN1Primitive createConstructedIL(int r3, int r4, ASN1EncodableVector r5) {
        boolean r2 = true;
        if (r5.size() == 1) goto L7;
        r2 = false;
    L7:
        if (r2 == false) goto L9;
        BERTaggedObject r0 = new BERTaggedObject(3, r3, r4, r5.get(0));
    L11:
        if (r3 == 64) goto L14;
        return r0;
    L14:
        return new BERApplicationSpecific(r0);
    L9:
        r0 = new BERTaggedObject(4, r3, r4, BERFactory.createSequence(r5));
        goto L11
    }

    static ASN1Primitive createPrimitive(int r2, int r3, byte[] r4) {
        DLTaggedObject r0 = new DLTaggedObject(4, r2, r3, new DEROctetString(r4));
        if (r2 == 64) goto L6;
        return r0;
    L6:
        return new DLApplicationSpecific(r0);
    }

    public static ASN1TaggedObject getInstance(Object r4) {
        if (r4 != null) goto L5;
    L23:
        Object r5 = ZeusTransformUtils.preCheckCast(r4, ASN1TaggedObject.class, "com.obric.memorydata.plugin");
    L13:
        return (ASN1TaggedObject) r5;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ASN1TaggedObject.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, ASN1Encodable.class) == false) goto L15;
        ASN1Primitive r0 = ((ASN1Encodable) ZeusTransformUtils.preCheckCast(r4, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive();
        if (ZeusTransformUtils.instanceOf(r0, ASN1TaggedObject.class) == false) goto L22;
        r5 = ZeusTransformUtils.preCheckCast(r0, ASN1TaggedObject.class, "com.obric.memorydata.plugin");
    L22:
        throw new IllegalArgumentException("unknown object in getInstance: " + r4.getClass().getName());
    L15:
        if ((r4 instanceof byte[]) == false) goto L22;
        return checkedCast(fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
    L18:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e.getMessage());
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject r2, boolean r3) {
        if (128 != r2.getTagClass()) goto L10;
        if (r3 == false) goto L8;
        return r2.getExplicitBaseTagged();
    L8:
        throw new IllegalArgumentException("this method not valid for implicitly tagged tagged objects");
    L10:
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    final boolean asn1Equals(ASN1Primitive r5) {
        if (ZeusTransformUtils.instanceOf(r5, ASN1TaggedObject.class) == true) goto L5;
        return false;
    L5:
        ASN1TaggedObject r6 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r5, ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        if (this.tagNo == r6.tagNo) goto L8;
    L26:
        return false;
    L8:
        if (this.tagClass != r6.tagClass) goto L26;
        if (this.explicitness != r6.explicitness) goto L13;
    L15:
        ASN1Primitive r0 = this.obj.toASN1Primitive();
        ASN1Primitive r1 = r6.obj.toASN1Primitive();
        if (r0 != r1) goto L20;
        return true;
    L20:
        if (isExplicit() == true) goto L25;
        return Arrays.areEqual(getEncoded(), r6.getEncoded());
    L23:
        return false;
    L25:
        return r0.asn1Equals(r1);
    L13:
        if (isExplicit() == r6.isExplicit()) goto L15;
        return false;
    }

    public ASN1Object getBaseObject() {
        boolean r0 = ZeusTransformUtils.instanceOf(this.obj, ASN1Object.class);
        ASN1Encodable r2 = this.obj;
        if (r0 == false) goto L6;
        return (ASN1Object) ZeusTransformUtils.preCheckCast(r2, ASN1Object.class, "com.obric.memorydata.plugin");
    L6:
        return r2.toASN1Primitive();
    }

    public ASN1Primitive getBaseUniversal(boolean r2, int r3) {
        ASN1UniversalType r0 = ASN1UniversalTypes.get(r3);
        if (r0 == null) goto L7;
        return getBaseUniversal(r2, r0);
    L7:
        throw new IllegalArgumentException("unsupported UNIVERSAL tag number: " + r3);
    }

    ASN1Primitive getBaseUniversal(boolean r3, ASN1UniversalType r4) {
        if (r3 == false) goto L11;
        if (isExplicit() == false) goto L9;
        return r4.checkedCast(this.obj.toASN1Primitive());
    L9:
        throw new IllegalStateException("object explicit - implicit expected.");
    L11:
        if (1 == this.explicitness) goto L27;
        ASN1Primitive r5 = this.obj.toASN1Primitive();
        int r0 = this.explicitness;
        if (r0 == 3) goto L25;
        if (r0 == 4) goto L19;
        return r4.checkedCast(r5);
    L19:
        if (ZeusTransformUtils.instanceOf(r5, ASN1Sequence.class) == false) goto L23;
        return r4.fromImplicitConstructed((ASN1Sequence) ZeusTransformUtils.preCheckCast(r5, ASN1Sequence.class, "com.obric.memorydata.plugin"));
    L23:
        return r4.fromImplicitPrimitive((DEROctetString) ZeusTransformUtils.preCheckCast(r5, DEROctetString.class, "com.obric.memorydata.plugin"));
    L25:
        return r4.fromImplicitConstructed(rebuildConstructed(r5));
    L27:
        throw new IllegalStateException("object explicit - implicit expected.");
    }

    public ASN1Object getExplicitBaseObject() {
        if (isExplicit() == false) goto L10;
        boolean r0 = ZeusTransformUtils.instanceOf(this.obj, ASN1Object.class);
        ASN1Encodable r2 = this.obj;
        if (r0 == false) goto L8;
        return (ASN1Object) ZeusTransformUtils.preCheckCast(r2, ASN1Object.class, "com.obric.memorydata.plugin");
    L8:
        return r2.toASN1Primitive();
    L10:
        throw new IllegalStateException("object implicit - explicit expected.");
    }

    public ASN1TaggedObject getExplicitBaseTagged() {
        if (isExplicit() == false) goto L7;
        return checkedCast(this.obj.toASN1Primitive());
    L7:
        throw new IllegalStateException("object implicit - explicit expected.");
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final ASN1Primitive getLoadedObject() {
        return this;
    }

    public ASN1Primitive getObject() {
        if (128 != getTagClass()) goto L7;
        return this.obj.toASN1Primitive();
    L7:
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }

    public int getTagClass() {
        return this.tagClass;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    public boolean hasContextTag(int r3) {
        if (this.tagClass == 128) goto L5;
    L7:
        return false;
    L5:
        if (this.tagNo != r3) goto L7;
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        int r0 = (this.tagClass * 7919) ^ this.tagNo;
        if (isExplicit() == false) goto L5;
        int r1 = 15;
    L6:
        int r2 = this.obj.toASN1Primitive().hashCode();
        return r2 ^ (r0 ^ r1);
    L5:
        r1 = 240;
        goto L6
    }

    public boolean isExplicit() {
        int r2 = this.explicitness;
        if (r2 != 1) goto L5;
    L8:
        return true;
    L5:
        if (r2 == 3) goto L8;
        return false;
    }

    boolean isParsed() {
        int r1 = this.explicitness;
        if (r1 != 3) goto L5;
        return true;
    L5:
        if (r1 == 4) goto L10;
        return false;
    L10:
        return true;
    }

    abstract ASN1Sequence rebuildConstructed(ASN1Primitive r1);

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return new DERTaggedObject(this.explicitness, this.tagClass, this.tagNo, this.obj);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return new DLTaggedObject(this.explicitness, this.tagClass, this.tagNo, this.obj);
    }

    public String toString() {
        return ASN1Util.getTagText(this.tagClass, this.tagNo) + this.obj;
    }
}
