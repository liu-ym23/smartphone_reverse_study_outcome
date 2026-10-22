package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;

/* JADX INFO: loaded from: classes7.dex */
public interface ElGamalPublicKey extends DHPublicKey, ElGamalKey {
    BigInteger getY();
}
