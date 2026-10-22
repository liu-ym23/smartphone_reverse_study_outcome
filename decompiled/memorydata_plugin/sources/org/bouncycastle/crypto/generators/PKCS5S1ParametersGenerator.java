package org.bouncycastle.crypto.generators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes7.dex */
public class PKCS5S1ParametersGenerator extends PBEParametersGenerator {
    private Digest digest;

    public PKCS5S1ParametersGenerator(Digest r3) {
        this.digest = (Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin");
    }

    private byte[] generateDerivedKey() {
        int r0 = this.digest.getDigestSize();
        byte[] r1 = new byte[r0];
        this.digest.update(this.password, 0, this.password.length);
        this.digest.update(this.salt, 0, this.salt.length);
        this.digest.doFinal(r1, 0);
        int r2 = 1;
    L4:
        if (r2 >= this.iterationCount) goto L6;
        this.digest.update(r1, 0, r0);
        this.digest.doFinal(r1, 0);
        r2 = r2 + 1;
        goto L4
    L6:
        return r1;
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int r1) {
        return generateDerivedParameters(r1);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r3) {
        int r4 = r3 / 8;
        if (r4 > this.digest.getDigestSize()) goto L7;
        return new KeyParameter(generateDerivedKey(), 0, r4);
    L7:
        throw new IllegalArgumentException("Can't generate a derived key " + r4 + " bytes long.");
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r4, int r5) {
        int r6 = r4 / 8;
        int r7 = r5 / 8;
        int r0 = r6 + r7;
        if (r0 > this.digest.getDigestSize()) goto L7;
        byte[] r3 = generateDerivedKey();
        return new ParametersWithIV(new KeyParameter(r3, 0, r6), r3, r6, r7);
    L7:
        throw new IllegalArgumentException("Can't generate a derived key " + r0 + " bytes long.");
    }
}
