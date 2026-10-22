package org.bouncycastle.crypto.params;

import java.util.Objects;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

/* JADX INFO: loaded from: classes7.dex */
public class ECDHUPrivateParameters implements CipherParameters {
    private ECPrivateKeyParameters ephemeralPrivateKey;
    private ECPublicKeyParameters ephemeralPublicKey;
    private ECPrivateKeyParameters staticPrivateKey;

    public ECDHUPrivateParameters(ECPrivateKeyParameters r4, ECPrivateKeyParameters r5, ECPublicKeyParameters r6) {
        Objects.requireNonNull(r4, "staticPrivateKey cannot be null");
        Objects.requireNonNull(r5, "ephemeralPrivateKey cannot be null");
        ECDomainParameters r0 = r4.getParameters();
        if (r0.equals(r5.getParameters()) == false) goto L13;
        if (r6 != null) goto L7;
        r6 = new ECPublicKeyParameters(new FixedPointCombMultiplier().multiply(r0.getG(), r5.getD()), r0);
    L8:
        this.staticPrivateKey = r4;
        this.ephemeralPrivateKey = r5;
        this.ephemeralPublicKey = r6;
        return;
    L7:
        if (r0.equals(r6.getParameters()) == true) goto L8;
        throw new IllegalArgumentException("ephemeral public key has different domain parameters");
    L13:
        throw new IllegalArgumentException("static and ephemeral private keys have different domain parameters");
    }

    public ECPrivateKeyParameters getEphemeralPrivateKey() {
        return this.ephemeralPrivateKey;
    }

    public ECPrivateKeyParameters getStaticPrivateKey() {
        return this.staticPrivateKey;
    }
}
