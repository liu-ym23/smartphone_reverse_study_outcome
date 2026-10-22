package org.bouncycastle.jce;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

/* JADX INFO: loaded from: classes7.dex */
public class ECGOST3410NamedCurveTable {
    public static ECNamedCurveParameterSpec getParameterSpec(String r9) {
        X9ECParameters r0 = ECGOST3410NamedCurves.getByNameX9(r9);
        if (r0 == null) goto L11;
    L7:
        if (r0 != null) goto L10;
        return null;
    L10:
        return new ECNamedCurveParameterSpec(r9, r0.getCurve(), r0.getG(), r0.getN(), r0.getH(), r0.getSeed());
    L11:
        r0 = ECGOST3410NamedCurves.getByOIDX9(new ASN1ObjectIdentifier(r9));     // Catch: IllegalArgumentException -> L6
    L6:
        return null;
    }
}
