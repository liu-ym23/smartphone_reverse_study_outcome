package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1EncodableVector {
    static final ASN1Encodable[] EMPTY_ELEMENTS = null;
    private boolean copyOnWrite;
    private int elementCount;
    private ASN1Encodable[] elements;

    static {
        EMPTY_ELEMENTS = new ASN1Encodable[0];
    }

    public ASN1EncodableVector() {
        this(10);
    }

    public ASN1EncodableVector(int r1) {
        if (r1 < 0) goto L10;
        if (r1 != 0) goto L6;
        ASN1Encodable[] r2 = EMPTY_ELEMENTS;
    L7:
        this.elements = r2;
        this.elementCount = 0;
        this.copyOnWrite = false;
        return;
    L6:
        r2 = new ASN1Encodable[r1];
        goto L7
    L10:
        throw new IllegalArgumentException("'initialCapacity' must not be negative");
    }

    static ASN1Encodable[] cloneElements(ASN1Encodable[] r2) {
        if (r2.length >= 1) goto L6;
        return EMPTY_ELEMENTS;
    L6:
        return (ASN1Encodable[]) ZeusTransformUtils.preCheckCast((ASN1Encodable[]) ZeusTransformUtils.preCheckCast(r2.clone(), ASN1Encodable[].class, "com.obric.memorydata.plugin"), ASN1Encodable[].class, "com.obric.memorydata.plugin");
    }

    private void reallocate(int r4) {
        ASN1Encodable[] r5 = new ASN1Encodable[Math.max(this.elements.length, r4 + (r4 >> 1))];
        System.arraycopy(this.elements, 0, r5, 0, this.elementCount);
        this.elements = r5;
        this.copyOnWrite = false;
    }

    public void add(ASN1Encodable r4) {
        ASN1Encodable r5 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5, "'element' cannot be null");
        int r0 = this.elements.length;
        boolean r2 = true;
        int r1 = this.elementCount + 1;
        if (r1 > r0) goto L7;
        r2 = false;
    L7:
        if ((this.copyOnWrite | r2) == false) goto L9;
        reallocate(r1);
    L9:
        this.elements[this.elementCount] = r5;
        this.elementCount = r1;
    }

    ASN1Encodable[] copyElements() {
        int r0 = this.elementCount;
        if (r0 == 0) goto L5;
        ASN1Encodable[] r1 = new ASN1Encodable[r0];
        System.arraycopy(this.elements, 0, r1, 0, r0);
        return r1;
    L5:
        return EMPTY_ELEMENTS;
    }

    public ASN1Encodable get(int r3) {
        if (r3 >= this.elementCount) goto L7;
        return this.elements[r3];
    L7:
        throw new ArrayIndexOutOfBoundsException(r3 + " >= " + this.elementCount);
    }

    public int size() {
        return this.elementCount;
    }

    ASN1Encodable[] takeElements() {
        int r0 = this.elementCount;
        if (r0 == 0) goto L5;
        ASN1Encodable[] r1 = this.elements;
        if (r1.length != r0) goto L10;
        this.copyOnWrite = true;
        return r1;
    L10:
        ASN1Encodable[] r3 = new ASN1Encodable[r0];
        System.arraycopy(r1, 0, r3, 0, r0);
        return r3;
    L5:
        return EMPTY_ELEMENTS;
    }
}
