package org.bouncycastle.crypto.constraints;

import org.bouncycastle.math.ec.ECCurve;

/* JADX INFO: loaded from: classes7.dex */
public class ConstraintUtils {
    public static int bitsOfSecurityFor(ECCurve r1) {
        int r2 = (r1.getFieldSize() + 1) / 2;
        if (r2 > 256) goto L5;
        return r2;
    L5:
        return 256;
    }
}
