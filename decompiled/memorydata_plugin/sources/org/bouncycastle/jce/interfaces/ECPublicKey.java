package org.bouncycastle.jce.interfaces;

import java.security.PublicKey;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes7.dex */
public interface ECPublicKey extends PublicKey, ECKey {
    ECPoint getQ();
}
