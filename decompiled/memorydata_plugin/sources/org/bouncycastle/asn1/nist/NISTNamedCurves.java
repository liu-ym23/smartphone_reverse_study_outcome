package org.bouncycastle.asn1.nist;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class NISTNamedCurves {
    static final Hashtable names = null;
    static final Hashtable objIds = null;

    static {
        objIds = new Hashtable();
        names = new Hashtable();
        defineCurve("B-571", SECObjectIdentifiers.sect571r1);
        defineCurve("B-409", SECObjectIdentifiers.sect409r1);
        defineCurve("B-283", SECObjectIdentifiers.sect283r1);
        defineCurve("B-233", SECObjectIdentifiers.sect233r1);
        defineCurve("B-163", SECObjectIdentifiers.sect163r2);
        defineCurve("K-571", SECObjectIdentifiers.sect571k1);
        defineCurve("K-409", SECObjectIdentifiers.sect409k1);
        defineCurve("K-283", SECObjectIdentifiers.sect283k1);
        defineCurve("K-233", SECObjectIdentifiers.sect233k1);
        defineCurve("K-163", SECObjectIdentifiers.sect163k1);
        defineCurve("P-521", SECObjectIdentifiers.secp521r1);
        defineCurve("P-384", SECObjectIdentifiers.secp384r1);
        defineCurve("P-256", SECObjectIdentifiers.secp256r1);
        defineCurve("P-224", SECObjectIdentifiers.secp224r1);
        defineCurve("P-192", SECObjectIdentifiers.secp192r1);
    }

    static void defineCurve(String r1, ASN1ObjectIdentifier r2) {
        objIds.put(r1, r2);
        names.put(r2, r1);
    }

    public static X9ECParametersHolder getByNameLazy(String r0) {
        ASN1ObjectIdentifier r1 = getOID(r0);
        if (r1 != null) goto L7;
        return null;
    L7:
        return SECNamedCurves.getByOIDLazy(r1);
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier r1) {
        if (names.containsKey(r1) == true) goto L7;
        return null;
    L7:
        return SECNamedCurves.getByOID(r1);
    }

    public static String getName(ASN1ObjectIdentifier r2) {
        return (String) ZeusTransformUtils.preCheckCast(names.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    public static ASN1ObjectIdentifier getOID(String r2) {
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(objIds.get(Strings.toUpperCase(r2)), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }
}
