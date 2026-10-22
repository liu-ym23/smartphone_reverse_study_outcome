package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;

/* JADX INFO: loaded from: classes7.dex */
public interface NHPrivateKey extends PrivateKey, NHKey {
    short[] getSecretData();
}
