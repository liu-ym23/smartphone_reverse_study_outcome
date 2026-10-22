package org.bouncycastle.crypto;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public interface BasicAgreement {
    BigInteger calculateAgreement(CipherParameters r1);

    void init(CipherParameters r1);
}
