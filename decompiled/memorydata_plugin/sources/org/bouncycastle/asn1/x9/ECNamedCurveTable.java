package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.anssi.ANSSINamedCurves;
import org.bouncycastle.asn1.cryptlib.CryptlibObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.gm.GMNamedCurves;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.crypto.ec.CustomNamedCurves;

/* JADX INFO: loaded from: classes7.dex */
public class ECNamedCurveTable {
    public static X9ECParametersHolder getByNameLazy(String r1) {
        X9ECParametersHolder r0 = X962NamedCurves.getByNameLazy(r1);
        if (r0 != null) goto L5;
        r0 = SECNamedCurves.getByNameLazy(r1);
    L5:
        if (r0 != null) goto L7;
        r0 = NISTNamedCurves.getByNameLazy(r1);
    L7:
        if (r0 != null) goto L9;
        r0 = TeleTrusTNamedCurves.getByNameLazy(r1);
    L9:
        if (r0 != null) goto L11;
        r0 = ANSSINamedCurves.getByNameLazy(r1);
    L11:
        if (r0 != null) goto L13;
        r0 = ECGOST3410NamedCurves.getByNameLazy(r1);
    L13:
        if (r0 == null) goto L15;
        return r0;
    L15:
        return GMNamedCurves.getByNameLazy(r1);
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier r1) {
        X9ECParameters r0 = X962NamedCurves.getByOID(r1);
        if (r0 != null) goto L5;
        r0 = SECNamedCurves.getByOID(r1);
    L5:
        if (r0 != null) goto L7;
        r0 = TeleTrusTNamedCurves.getByOID(r1);
    L7:
        if (r0 != null) goto L9;
        r0 = ANSSINamedCurves.getByOID(r1);
    L9:
        if (r0 != null) goto L11;
        r0 = ECGOST3410NamedCurves.getByOIDX9(r1);
    L11:
        if (r0 == null) goto L13;
        return r0;
    L13:
        return GMNamedCurves.getByOID(r1);
    }

    public static X9ECParametersHolder getByOIDLazy(ASN1ObjectIdentifier r1) {
        X9ECParametersHolder r0 = X962NamedCurves.getByOIDLazy(r1);
        if (r0 != null) goto L5;
        r0 = SECNamedCurves.getByOIDLazy(r1);
    L5:
        if (r0 != null) goto L7;
        r0 = TeleTrusTNamedCurves.getByOIDLazy(r1);
    L7:
        if (r0 != null) goto L9;
        r0 = ANSSINamedCurves.getByOIDLazy(r1);
    L9:
        if (r0 != null) goto L11;
        r0 = ECGOST3410NamedCurves.getByOIDLazy(r1);
    L11:
        if (r0 == null) goto L13;
        return r0;
    L13:
        return GMNamedCurves.getByOIDLazy(r1);
    }

    public static String getName(ASN1ObjectIdentifier r1) {
        String r0 = X962NamedCurves.getName(r1);
        if (r0 != null) goto L5;
        r0 = SECNamedCurves.getName(r1);
    L5:
        if (r0 != null) goto L7;
        r0 = NISTNamedCurves.getName(r1);
    L7:
        if (r0 != null) goto L9;
        r0 = TeleTrusTNamedCurves.getName(r1);
    L9:
        if (r0 != null) goto L11;
        r0 = ANSSINamedCurves.getName(r1);
    L11:
        if (r0 != null) goto L13;
        r0 = ECGOST3410NamedCurves.getName(r1);
    L13:
        if (r0 != null) goto L15;
        r0 = GMNamedCurves.getName(r1);
    L15:
        if (r0 == null) goto L17;
        return r0;
    L17:
        return CustomNamedCurves.getName(r1);
    }

    public static ASN1ObjectIdentifier getOID(String r2) {
        ASN1ObjectIdentifier r0 = X962NamedCurves.getOID(r2);
        if (r0 != null) goto L5;
        r0 = SECNamedCurves.getOID(r2);
    L5:
        if (r0 != null) goto L7;
        r0 = NISTNamedCurves.getOID(r2);
    L7:
        if (r0 != null) goto L9;
        r0 = TeleTrusTNamedCurves.getOID(r2);
    L9:
        if (r0 != null) goto L11;
        r0 = ANSSINamedCurves.getOID(r2);
    L11:
        if (r0 != null) goto L13;
        r0 = ECGOST3410NamedCurves.getOID(r2);
    L13:
        if (r0 != null) goto L15;
        r0 = GMNamedCurves.getOID(r2);
    L15:
        if (r0 == null) goto L17;
        return r0;
    L17:
        if (r2.equals("curve25519") == true) goto L19;
        return r0;
    L19:
        return CryptlibObjectIdentifiers.curvey25519;
    }
}
