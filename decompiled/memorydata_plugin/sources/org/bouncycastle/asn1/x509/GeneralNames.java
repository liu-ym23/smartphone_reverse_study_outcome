package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class GeneralNames extends ASN1Object {
    private final GeneralName[] names;

    private GeneralNames(ASN1Sequence r4) {
        this.names = new GeneralName[r4.size()];
        int r0 = 0;
    L4:
        if (r0 == r4.size()) goto L6;
        this.names[r0] = GeneralName.getInstance(r4.getObjectAt(r0));
        r0 = r0 + 1;
        goto L4
    }

    public GeneralNames(GeneralName r3) {
        this.names = new GeneralName[]{r3};
    }

    private static GeneralName[] copy(GeneralName[] r3) {
        GeneralName[] r0 = new GeneralName[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    public static GeneralNames getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, GeneralNames.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new GeneralNames(ASN1Sequence.getInstance(r2));
    L5:
        return (GeneralNames) ZeusTransformUtils.preCheckCast(r2, GeneralNames.class, "com.obric.memorydata.plugin");
    }

    public static GeneralNames getInstance(ASN1TaggedObject r1, boolean r2) {
        return new GeneralNames(ASN1Sequence.getInstance(r1, r2));
    }

    public GeneralName[] getNames() {
        return copy(this.names);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.names);
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append("GeneralNames:");
        r0.append(r1);
        int r2 = 0;
    L4:
        if (r2 == this.names.length) goto L7;
        r0.append("    ");
        r0.append(this.names[r2]);
        r0.append(r1);
        r2 = r2 + 1;
        goto L4
    L7:
        return r0.toString();
    }
}
