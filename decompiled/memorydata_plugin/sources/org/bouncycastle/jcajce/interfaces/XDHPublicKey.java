package org.bouncycastle.jcajce.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes7.dex */
public interface XDHPublicKey extends PublicKey, XDHKey {
    BigInteger getU();

    byte[] getUEncoding();
}
