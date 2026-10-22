package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CryptoServicePurpose;

/* JADX INFO: loaded from: classes7.dex */
class Utils {
    static CryptoServicePurpose getPurpose(boolean r0) {
        if (r0 == false) goto L5;
        return CryptoServicePurpose.ENCRYPTION;
    L5:
        return CryptoServicePurpose.DECRYPTION;
    }
}
