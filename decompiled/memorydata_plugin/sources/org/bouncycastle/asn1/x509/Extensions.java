package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class Extensions extends ASN1Object {
    private Hashtable extensions;
    private Vector ordering;

    private Extensions(ASN1Sequence r4) {
        this.extensions = new Hashtable();
        this.ordering = new Vector();
        Enumeration r5 = r4.getObjects();
    L4:
        if (r5.hasMoreElements() == false) goto L10;
        Extension r0 = Extension.getInstance(r5.nextElement());
        if (this.extensions.containsKey(r0.getExtnId()) == true) goto L9;
        this.extensions.put(r0.getExtnId(), r0);
        this.ordering.addElement(r0.getExtnId());
        goto L4
    L9:
        throw new IllegalArgumentException("repeated extension found: " + r0.getExtnId());
    }

    private ASN1ObjectIdentifier[] getExtensionOIDs(boolean r7) {
        Vector r0 = new Vector();
        int r1 = 0;
    L4:
        if (r1 == this.ordering.size()) goto L10;
        Object r2 = this.ordering.elementAt(r1);
        if (((Extension) ZeusTransformUtils.preCheckCast(this.extensions.get(r2), Extension.class, "com.obric.memorydata.plugin")).isCritical() != r7) goto L8;
        r0.addElement(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return toOidArray(r0);
    }

    public static Extensions getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Extensions.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new Extensions(ASN1Sequence.getInstance(r2));
    L5:
        return (Extensions) ZeusTransformUtils.preCheckCast(r2, Extensions.class, "com.obric.memorydata.plugin");
    }

    private ASN1ObjectIdentifier[] toOidArray(Vector r6) {
        int r5 = r6.size();
        ASN1ObjectIdentifier[] r0 = new ASN1ObjectIdentifier[r5];
        int r1 = 0;
    L3:
        if (r1 == r5) goto L5;
        r0[r1] = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r6.elementAt(r1), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public ASN1ObjectIdentifier[] getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    public Extension getExtension(ASN1ObjectIdentifier r2) {
        return (Extension) ZeusTransformUtils.preCheckCast(this.extensions.get(r2), Extension.class, "com.obric.memorydata.plugin");
    }

    public ASN1ObjectIdentifier[] getExtensionOIDs() {
        return toOidArray(this.ordering);
    }

    public ASN1ObjectIdentifier[] getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    public Enumeration oids() {
        return this.ordering.elements();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(this.ordering.size());
        Enumeration r1 = this.ordering.elements();
    L4:
        if (r1.hasMoreElements() == false) goto L7;
        ASN1ObjectIdentifier r2 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r1.nextElement(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        r0.add((Extension) ZeusTransformUtils.preCheckCast(this.extensions.get(r2), Extension.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        return new DERSequence(r0);
    }
}
