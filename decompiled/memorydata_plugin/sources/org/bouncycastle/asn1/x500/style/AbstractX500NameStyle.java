package org.bouncycastle.asn1.x500.style;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractX500NameStyle implements X500NameStyle {
    public AbstractX500NameStyle() {
    }

    private int calcHashCode(ASN1Encodable r2) {
        return IETFUtils.canonicalString((ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r2, ASN1Encodable.class, "com.obric.memorydata.plugin")).hashCode();
    }

    public static Hashtable copyHashTable(Hashtable r4) {
        Hashtable r0 = new Hashtable();
        Enumeration r1 = r4.keys();
    L4:
        if (r1.hasMoreElements() == false) goto L6;
        Object r2 = r1.nextElement();
        r0.put(r2, r4.get(r2));
        goto L4
    L6:
        return r0;
    }

    private boolean foundMatch(boolean r5, RDN r6, RDN[] r7) {
        if (r5 == false) goto L13;
        int r8 = r7.length - 1;
    L5:
        if (r8 < 0) goto L23;
        if (r7[r8] == null) goto L12;
        if (rdnAreEqual(r6, r7[r8]) == false) goto L12;
        r7[r8] = null;
        return true;
    L12:
        r8 = r8 - 1;
    L23:
        return false;
    L13:
        int r9 = 0;
    L15:
        if (r9 == r7.length) goto L23;
        if (r7[r9] == null) goto L22;
        if (rdnAreEqual(r6, r7[r9]) == false) goto L22;
        r7[r9] = null;
        return true;
    L22:
        r9 = r9 + 1;
        goto L15
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public boolean areEqual(X500Name r6, X500Name r7) {
        RDN[] r8 = r6.getRDNs();
        RDN[] r9 = r7.getRDNs();
        if (r8.length == r9.length) goto L6;
        return false;
    L6:
        if (r8[0].getFirst() != null) goto L8;
    L10:
        boolean r0 = false;
    L11:
        int r3 = 0;
    L13:
        if (r3 == r8.length) goto L18;
        if (foundMatch(r0, r8[r3], r9) == false) goto L16;
        r3 = r3 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    L8:
        if (r9[0].getFirst() == null) goto L10;
        r0 = !r8[0].getFirst().getType().equals(r9[0].getFirst().getType());
        goto L11
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public int calculateHashCode(X500Name r7) {
        RDN[] r8 = r7.getRDNs();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 == r8.length) goto L13;
        if (r8[r1].isMultiValued() == false) goto L11;
        AttributeTypeAndValue[] r3 = r8[r1].getTypesAndValues();
        int r4 = 0;
    L9:
        if (r4 == r3.length) goto L12;
        r2 = (r2 ^ r3[r4].getType().hashCode()) ^ calcHashCode(r3[r4].getValue());
        r4 = r4 + 1;
    L12:
        r1 = r1 + 1;
        goto L4
    L11:
        r2 = (r2 ^ r8[r1].getFirst().getType().hashCode()) ^ calcHashCode(r8[r1].getFirst().getValue());
        goto L12
    L13:
        return r2;
    }

    public boolean rdnAreEqual(RDN r1, RDN r2) {
        return IETFUtils.rDNAreEqual(r1, r2);
    }
}
