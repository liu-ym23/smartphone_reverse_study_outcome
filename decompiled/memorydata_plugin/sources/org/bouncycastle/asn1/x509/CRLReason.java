package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
public class CRLReason extends ASN1Object {
    private static final String[] reasonString = null;
    private static final Hashtable table = null;
    private ASN1Enumerated value;

    static {
        reasonString = new String[]{"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};
        table = new Hashtable();
    }

    private CRLReason(int r2) {
        if (r2 < 0) goto L7;
        this.value = new ASN1Enumerated(r2);
        return;
    L7:
        throw new IllegalArgumentException("Invalid CRL reason : not in (0..MAX)");
    }

    public static CRLReason getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, CRLReason.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return lookup(ASN1Enumerated.getInstance(r2).intValueExact());
    L5:
        return (CRLReason) ZeusTransformUtils.preCheckCast(r2, CRLReason.class, "com.obric.memorydata.plugin");
    }

    public static CRLReason lookup(int r3) {
        Integer r0 = Integers.valueOf(r3);
        Hashtable r1 = table;
        if (r1.containsKey(r0) == true) goto L6;
        r1.put(r0, new CRLReason(r3));
    L6:
        return (CRLReason) ZeusTransformUtils.preCheckCast(r1.get(r0), CRLReason.class, "com.obric.memorydata.plugin");
    }

    public BigInteger getValue() {
        return this.value.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }

    public String toString() {
        int r2 = getValue().intValue();
        if (r2 >= 0) goto L5;
    L8:
        String r3 = "invalid";
    L10:
        return "CRLReason: " + r3;
    L5:
        if (r2 > 10) goto L8;
        r3 = reasonString[r2];
        goto L10
    }
}
