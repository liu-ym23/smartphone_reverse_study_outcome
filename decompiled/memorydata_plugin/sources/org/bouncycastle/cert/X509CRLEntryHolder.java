package org.bouncycastle.cert;

import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.TBSCertList;

/* JADX INFO: loaded from: classes7.dex */
public class X509CRLEntryHolder {
    private GeneralNames ca;
    private TBSCertList.CRLEntry entry;

    X509CRLEntryHolder(TBSCertList.CRLEntry r1, boolean r2, GeneralNames r3) {
        this.entry = r1;
        this.ca = r3;
        if (r2 == true) goto L5;
        return;
    L5:
        if (r1.hasExtensions() == false) goto L11;
        Extension r4 = r1.getExtensions().getExtension(Extension.certificateIssuer);
        if (r4 == null) goto L12;
        this.ca = GeneralNames.getInstance(r4.getParsedValue());
        return;
    L12:
        return;
    }

    public GeneralNames getCertificateIssuer() {
        return this.ca;
    }
}
