package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.pqc.legacy.crypto.qtesla.QTESLASecurityCategory;

/* JADX INFO: loaded from: classes7.dex */
public class QTESLAParameterSpec implements AlgorithmParameterSpec {
    public static final String PROVABLY_SECURE_I = null;
    public static final String PROVABLY_SECURE_III = null;
    private String securityCategory;

    static {
        PROVABLY_SECURE_I = QTESLASecurityCategory.getName(5);
        PROVABLY_SECURE_III = QTESLASecurityCategory.getName(6);
    }

    public QTESLAParameterSpec(String r1) {
        this.securityCategory = r1;
    }
}
