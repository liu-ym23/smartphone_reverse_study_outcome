package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import javax.crypto.interfaces.DHPrivateKey;

/* JADX INFO: loaded from: classes7.dex */
public interface ElGamalPrivateKey extends DHPrivateKey, ElGamalKey {
    BigInteger getX();
}
