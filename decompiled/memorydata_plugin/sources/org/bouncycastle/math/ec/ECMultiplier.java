package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public interface ECMultiplier {
    ECPoint multiply(ECPoint r1, BigInteger r2);
}
