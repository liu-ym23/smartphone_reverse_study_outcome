package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;

/* JADX INFO: loaded from: classes7.dex */
public interface GOST3410PrivateKey extends PrivateKey, GOST3410Key {
    BigInteger getX();
}
