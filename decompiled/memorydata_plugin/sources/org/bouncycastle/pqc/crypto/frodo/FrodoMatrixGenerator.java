package org.bouncycastle.pqc.crypto.frodo;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;

/* JADX INFO: loaded from: classes7.dex */
abstract class FrodoMatrixGenerator {
    int n;
    int q;

    static class Aes128MatrixGenerator extends FrodoMatrixGenerator {
        BufferedBlockCipher cipher;

        public Aes128MatrixGenerator(int r1, int r2) {
            super(r1, r2);
            this.cipher = new BufferedBlockCipher(new AESEngine());
        }
    }

    static class Shake128MatrixGenerator extends FrodoMatrixGenerator {
        public Shake128MatrixGenerator(int r1, int r2) {
            super(r1, r2);
        }
    }

    public FrodoMatrixGenerator(int r1, int r2) {
        this.n = r1;
        this.q = r2;
    }
}
