package org.bouncycastle.crypto.params;

import java.util.Objects;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class ECDHUPublicParameters implements CipherParameters {
    private ECPublicKeyParameters ephemeralPublicKey;
    private ECPublicKeyParameters staticPublicKey;

    public ECDHUPublicParameters(ECPublicKeyParameters r3, ECPublicKeyParameters r4) {
        Objects.requireNonNull(r3, "staticPublicKey cannot be null");
        Objects.requireNonNull(r4, "ephemeralPublicKey cannot be null");
        if (r3.getParameters().equals(r4.getParameters()) == false) goto L7;
        this.staticPublicKey = r3;
        this.ephemeralPublicKey = r4;
        return;
    L7:
        throw new IllegalArgumentException("static and ephemeral public keys have different domain parameters");
    }

    public ECPublicKeyParameters getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public ECPublicKeyParameters getStaticPublicKey() {
        return this.staticPublicKey;
    }
}
