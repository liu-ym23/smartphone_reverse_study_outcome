package org.bouncycastle.jcajce.interfaces;

import java.security.PublicKey;

/* JADX INFO: loaded from: classes7.dex */
public interface EdDSAPublicKey extends PublicKey, EdDSAKey {
    byte[] getPointEncoding();
}
