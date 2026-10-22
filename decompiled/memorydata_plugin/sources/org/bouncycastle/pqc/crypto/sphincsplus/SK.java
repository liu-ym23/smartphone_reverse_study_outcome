package org.bouncycastle.pqc.crypto.sphincsplus;

/* JADX INFO: loaded from: classes7.dex */
class SK {
    final byte[] prf;
    final byte[] seed;

    SK(byte[] r1, byte[] r2) {
        this.seed = r1;
        this.prf = r2;
    }
}
