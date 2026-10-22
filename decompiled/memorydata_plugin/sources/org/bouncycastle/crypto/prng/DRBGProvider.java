package org.bouncycastle.crypto.prng;

import org.bouncycastle.crypto.prng.drbg.SP80090DRBG;

/* JADX INFO: loaded from: classes7.dex */
interface DRBGProvider {
    SP80090DRBG get(EntropySource r1);

    String getAlgorithm();
}
