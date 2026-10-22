package org.bouncycastle.asn1.x500;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.style.BCStyle;

/* JADX INFO: loaded from: classes7.dex */
public class X500Name extends ASN1Object implements ASN1Choice {
    private static X500NameStyle defaultStyle;
    private int hashCodeValue;
    private boolean isHashCodeCalculated;
    private DERSequence rdnSeq;
    private RDN[] rdns;
    private X500NameStyle style;

    static {
        defaultStyle = BCStyle.INSTANCE;
    }

    private X500Name(ASN1Sequence r2) {
        this(defaultStyle, r2);
    }

    private X500Name(X500NameStyle r8, ASN1Sequence r9) {
        this.style = (X500NameStyle) ZeusTransformUtils.wrapperContextForParams(r8, X500NameStyle.class, "com.obric.memorydata.plugin");
        this.rdns = new RDN[r9.size()];
        Enumeration r10 = r9.getObjects();
        int r3 = 0;
        boolean r2 = true;
    L4:
        if (r10.hasMoreElements() == false) goto L10;
        Object r4 = r10.nextElement();
        RDN r5 = RDN.getInstance(r4);
        if (r5 != r4) goto L8;
        boolean r6 = true;
    L9:
        r2 = r2 & r6;
        this.rdns[r3] = r5;
        r3 = r3 + 1;
        goto L4
    L8:
        r6 = false;
        goto L9
    L10:
        if (r2 == false) goto L12;
        DERSequence r11 = DERSequence.convert(r9);
    L13:
        this.rdnSeq = r11;
        return;
    L12:
        r11 = new DERSequence(this.rdns);
        goto L13
    }

    public X500Name(X500NameStyle r3, X500Name r4) {
        this.style = (X500NameStyle) ZeusTransformUtils.wrapperContextForParams(r3, X500NameStyle.class, "com.obric.memorydata.plugin");
        this.rdns = r4.rdns;
        this.rdnSeq = r4.rdnSeq;
    }

    public static X500Name getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, X500Name.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new X500Name(ASN1Sequence.getInstance(r2));
    L5:
        return (X500Name) ZeusTransformUtils.preCheckCast(r2, X500Name.class, "com.obric.memorydata.plugin");
    }

    public static X500Name getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, true));
    }

    public static X500Name getInstance(X500NameStyle r3, Object r4) {
        X500NameStyle r5 = (X500NameStyle) ZeusTransformUtils.wrapperContextForParams(r3, X500NameStyle.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, X500Name.class) == true) goto L5;
        if (r4 != null) goto L8;
        return null;
    L8:
        return new X500Name(r5, ASN1Sequence.getInstance(r4));
    L5:
        return new X500Name(r5, (X500Name) ZeusTransformUtils.preCheckCast(r4, X500Name.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, X500Name.class) == false) goto L8;
    L10:
        ASN1Primitive r1 = ((ASN1Encodable) ZeusTransformUtils.preCheckCast(r6, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive();
        if (toASN1Primitive().equals(r1) == false) goto L16;
        return true;
    L16:
        return this.style.areEqual(this, new X500Name(ASN1Sequence.getInstance(((ASN1Encodable) ZeusTransformUtils.preCheckCast(r6, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive())));
    L15:
        return false;
    L8:
        if (ZeusTransformUtils.instanceOf(r6, ASN1Sequence.class) == true) goto L10;
        return false;
    }

    public RDN[] getRDNs() {
        return (RDN[]) ZeusTransformUtils.preCheckCast((RDN[]) ZeusTransformUtils.preCheckCast(this.rdns.clone(), RDN[].class, "com.obric.memorydata.plugin"), RDN[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        if (this.isHashCodeCalculated == true) goto L5;
        this.isHashCodeCalculated = true;
        int r0 = this.style.calculateHashCode(this);
        this.hashCodeValue = r0;
        return r0;
    L5:
        return this.hashCodeValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.rdnSeq;
    }

    public String toString() {
        return this.style.toString(this);
    }
}
