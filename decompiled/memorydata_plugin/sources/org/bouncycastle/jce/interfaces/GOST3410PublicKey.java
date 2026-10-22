package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes7.dex */
public interface GOST3410PublicKey extends PublicKey, GOST3410Key {
    BigInteger getY();
}
