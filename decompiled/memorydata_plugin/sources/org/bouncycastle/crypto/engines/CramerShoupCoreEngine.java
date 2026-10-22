package org.bouncycastle.crypto.engines;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class CramerShoupCoreEngine {
    private static final BigInteger ONE = null;

    public static class CramerShoupCiphertextException extends Exception {
        private static final long serialVersionUID = -6360977166495345076L;

        public CramerShoupCiphertextException(String r1) {
            super(r1);
        }
    }

    static {
        ONE = BigInteger.valueOf(1);
    }
}
