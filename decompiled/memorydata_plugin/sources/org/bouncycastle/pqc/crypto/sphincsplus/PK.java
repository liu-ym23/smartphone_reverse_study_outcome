package org.bouncycastle.pqc.crypto.sphincsplus;

/* JADX INFO: loaded from: classes7.dex */
class PK {
    final byte[] root;
    final byte[] seed;

    PK(byte[] r1, byte[] r2) {
        this.seed = r1;
        this.root = r2;
    }
}
