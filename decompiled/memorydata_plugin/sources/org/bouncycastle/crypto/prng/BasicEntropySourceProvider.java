package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes7.dex */
public class BasicEntropySourceProvider implements EntropySourceProvider {
    private final boolean _predictionResistant;
    private final SecureRandom _sr;

    public BasicEntropySourceProvider(SecureRandom r1, boolean r2) {
        this._sr = r1;
        this._predictionResistant = r2;
    }

    static /* synthetic */ SecureRandom access$100(BasicEntropySourceProvider r0) {
        return r0._sr;
    }

    @Override // org.bouncycastle.crypto.prng.EntropySourceProvider
    public EntropySource get(final int r2) {
        return new AnonymousClass1(this, r2);
    }
}
