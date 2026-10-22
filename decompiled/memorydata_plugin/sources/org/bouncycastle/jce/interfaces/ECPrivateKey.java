package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;

/* JADX INFO: loaded from: classes7.dex */
public interface ECPrivateKey extends PrivateKey, ECKey {
    BigInteger getD();
}
