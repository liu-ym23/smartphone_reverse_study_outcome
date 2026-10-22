package org.bouncycastle.pqc.crypto.cmce;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class CMCEPrivateKeyParameters extends CMCEKeyParameters {
    private final byte[] privateKey;

    public CMCEPrivateKeyParameters(CMCEParameters r2, byte[] r3, byte[] r4, byte[] r5, byte[] r6, byte[] r7) {
        super(true, r2);
        byte[] r8 = new byte[(((r3.length + r4.length) + r5.length) + r6.length) + r7.length];
        this.privateKey = r8;
        System.arraycopy(r3, 0, r8, 0, r3.length);
        int r1 = r3.length + 0;
        System.arraycopy(r4, 0, r8, r1, r4.length);
        int r9 = r1 + r4.length;
        System.arraycopy(r5, 0, r8, r9, r5.length);
        int r10 = r9 + r5.length;
        System.arraycopy(r6, 0, r8, r10, r6.length);
        System.arraycopy(r7, 0, r8, r10 + r6.length, r7.length);
    }

    public byte[] getAlpha() {
        return Arrays.copyOfRange(this.privateKey, (getParameters().getT() * 2) + 40, this.privateKey.length - 32);
    }

    public byte[] getC() {
        return Arrays.copyOfRange(this.privateKey, 32, 40);
    }

    public byte[] getDelta() {
        return Arrays.copyOfRange(this.privateKey, 0, 32);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.privateKey);
    }

    public byte[] getG() {
        return Arrays.copyOfRange(this.privateKey, 40, (getParameters().getT() * 2) + 40);
    }

    public byte[] getS() {
        byte[] r2 = this.privateKey;
        return Arrays.copyOfRange(r2, r2.length - 32, r2.length);
    }

    public byte[] reconstructPublicKey() {
        CMCEEngine r0 = getParameters().getEngine();
        byte[] r1 = new byte[r0.getPublicKeySize()];
        r0.generate_public_key_from_private_key(this.privateKey);
        return r1;
    }
}
