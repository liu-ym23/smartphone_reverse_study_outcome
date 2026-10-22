package org.bouncycastle.crypto.agreement;

import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.constraints.ConstraintUtils;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.ECKeyParameters;

/* JADX INFO: loaded from: classes7.dex */
class Utils {
    static CryptoServiceProperties getDefaultProperties(String r3, ECKeyParameters r4) {
        return new DefaultServiceProperties(r3, ConstraintUtils.bitsOfSecurityFor(r4.getParameters().getCurve()), r4, CryptoServicePurpose.AGREEMENT);
    }
}
