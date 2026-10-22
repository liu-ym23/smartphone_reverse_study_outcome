package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameters;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes7.dex */
class SpecUtil {
    static AlgorithmParameterSpec extractSpec(AlgorithmParameters r2, Class[] r3) {
        return r2.getParameterSpec(AlgorithmParameterSpec.class);
    L4:
        int r0 = 0;
    L6:
        if (r0 == r3.length) goto L13;
        if (r3[r0] == null) goto L12;
        return r2.getParameterSpec(r3[r0]);
    L12:
        r0 = r0 + 1;
        goto L6
    L13:
        return null;
    }
}
