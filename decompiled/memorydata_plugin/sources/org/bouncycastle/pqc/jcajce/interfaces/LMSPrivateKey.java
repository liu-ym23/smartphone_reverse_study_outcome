package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;

/* JADX INFO: loaded from: classes7.dex */
public interface LMSPrivateKey extends PrivateKey, LMSKey {
    LMSPrivateKey extractKeyShard(int r1);

    long getIndex();

    long getUsagesRemaining();
}
