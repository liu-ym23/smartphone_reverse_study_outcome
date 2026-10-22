package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1External extends ASN1Primitive {
    static final ASN1UniversalType TYPE = null;
    ASN1Primitive dataValueDescriptor;
    ASN1ObjectIdentifier directReference;
    int encoding;
    ASN1Primitive externalContent;
    ASN1Integer indirectReference;

    static {
        final Class<ASN1External> r1 = ASN1External.class;
        final int r2 = 8;
        TYPE = new AnonymousClass1(r1, r2);
    }

    ASN1External(ASN1ObjectIdentifier r1, ASN1Integer r2, ASN1Primitive r3, int r4, ASN1Primitive r5) {
        this.directReference = r1;
        this.indirectReference = r2;
        this.dataValueDescriptor = r3;
        this.encoding = checkEncoding(r4);
        this.externalContent = checkExternalContent(r4, r5);
    }

    ASN1External(ASN1Sequence r6) {
        int r0 = 0;
        ASN1Primitive r1 = getObjFromSequence(r6, 0);
        if (ZeusTransformUtils.instanceOf(r1, ASN1ObjectIdentifier.class) == false) goto L6;
        this.directReference = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r1, ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        r1 = getObjFromSequence(r6, 1);
        r0 = 1;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, ASN1Integer.class) == false) goto L9;
        this.indirectReference = (ASN1Integer) ZeusTransformUtils.preCheckCast(r1, ASN1Integer.class, "com.obric.memorydata.plugin");
        r0 = r0 + 1;
        r1 = getObjFromSequence(r6, r0);
    L9:
        if (ZeusTransformUtils.instanceOf(r1, ASN1TaggedObject.class) == true) goto L12;
        this.dataValueDescriptor = r1;
        r0 = r0 + 1;
        r1 = getObjFromSequence(r6, r0);
    L12:
        if (r6.size() != (r0 + 1)) goto L20;
        if (ZeusTransformUtils.instanceOf(r1, ASN1TaggedObject.class) == false) goto L18;
        ASN1TaggedObject r7 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r1, ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        this.encoding = checkEncoding(r7.getTagNo());
        this.externalContent = getExternalContent(r7);
        return;
    L18:
        throw new IllegalArgumentException("No tagged object found in sequence. Structure doesn't seem to be of type External");
    L20:
        throw new IllegalArgumentException("input sequence too large");
    }

    private static int checkEncoding(int r3) {
        if (r3 < 0) goto L7;
        if (r3 > 2) goto L7;
        return r3;
    L7:
        throw new IllegalArgumentException("invalid encoding value: " + r3);
    }

    private static ASN1Primitive checkExternalContent(int r1, ASN1Primitive r2) {
        if (r1 != 1) goto L5;
        ASN1UniversalType r3 = ASN1OctetString.TYPE;
    L9:
        return r3.checkedCast(r2);
    L5:
        if (r1 == 2) goto L7;
        return r2;
    L7:
        r3 = ASN1BitString.TYPE;
        goto L9
    }

    private static ASN1Primitive getExternalContent(ASN1TaggedObject r5) {
        int r0 = r5.getTagClass();
        int r1 = r5.getTagNo();
        if (128 != r0) goto L18;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L14;
        if (r1 != 2) goto L12;
        return ASN1BitString.getInstance(r5, false);
    L12:
        throw new IllegalArgumentException("invalid tag: " + ASN1Util.getTagText(r0, r1));
    L14:
        return ASN1OctetString.getInstance(r5, false);
    L16:
        return r5.getExplicitBaseObject().toASN1Primitive();
    L18:
        throw new IllegalArgumentException("invalid tag: " + ASN1Util.getTagText(r0, r1));
    }

    private static ASN1Primitive getObjFromSequence(ASN1Sequence r1, int r2) {
        if (r1.size() <= r2) goto L7;
        return r1.getObjectAt(r2).toASN1Primitive();
    L7:
        throw new IllegalArgumentException("too few objects in input sequence");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ASN1External.class) == true) goto L8;
        return false;
    L8:
        ASN1External r6 = (ASN1External) ZeusTransformUtils.preCheckCast(r5, ASN1External.class, "com.obric.memorydata.plugin");
        if (Objects.areEqual(this.directReference, r6.directReference) == false) goto L20;
        if (Objects.areEqual(this.indirectReference, r6.indirectReference) == false) goto L20;
        if (Objects.areEqual(this.dataValueDescriptor, r6.dataValueDescriptor) == false) goto L20;
        if (this.encoding != r6.encoding) goto L20;
        if (this.externalContent.equals(r6.externalContent) == false) goto L20;
        return true;
    L20:
        return false;
    }

    abstract ASN1Sequence buildSequence();

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeIdentifier(r3, 40);
        buildSequence().encode(r2, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return buildSequence().encodedLength(r1);
    }

    public ASN1Primitive getDataValueDescriptor() {
        return this.dataValueDescriptor;
    }

    public ASN1ObjectIdentifier getDirectReference() {
        return this.directReference;
    }

    public int getEncoding() {
        return this.encoding;
    }

    public ASN1Primitive getExternalContent() {
        return this.externalContent;
    }

    public ASN1Integer getIndirectReference() {
        return this.indirectReference;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        int r0 = ((Objects.hashCode(this.directReference) ^ Objects.hashCode(this.indirectReference)) ^ Objects.hashCode(this.dataValueDescriptor)) ^ this.encoding;
        return this.externalContent.hashCode() ^ r0;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return new DERExternal(this.directReference, this.indirectReference, this.dataValueDescriptor, this.encoding, this.externalContent);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return new DLExternal(this.directReference, this.indirectReference, this.dataValueDescriptor, this.encoding, this.externalContent);
    }
}
