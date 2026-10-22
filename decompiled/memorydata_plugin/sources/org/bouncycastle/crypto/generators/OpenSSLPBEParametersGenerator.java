package org.bouncycastle.crypto.generators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;

/* JADX INFO: loaded from: classes7.dex */
public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {
    private final Digest digest;

    public OpenSSLPBEParametersGenerator() {
        this(DigestFactory.createMD5());
    }

    public OpenSSLPBEParametersGenerator(Digest r3) {
        this.digest = (Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin");
    }

    private byte[] generateDerivedKey(int r9) {
        int r0 = this.digest.getDigestSize();
        byte[] r1 = new byte[r0];
        byte[] r2 = new byte[r9];
        int r4 = 0;
    L3:
        this.digest.update(this.password, 0, this.password.length);
        this.digest.update(this.salt, 0, this.salt.length);
        this.digest.doFinal(r1, 0);
        if (r9 <= r0) goto L6;
        int r5 = r0;
    L7:
        System.arraycopy(r1, 0, r2, r4, r5);
        r4 = r4 + r5;
        r9 = r9 - r5;
        if (r9 == 0) goto L9;
        this.digest.reset();
        this.digest.update(r1, 0, r0);
        goto L3
    L9:
        return r2;
    L6:
        r5 = r9;
        goto L7
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int r1) {
        return generateDerivedParameters(r1);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r3) {
        int r4 = r3 / 8;
        return new KeyParameter(generateDerivedKey(r4), 0, r4);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r4, int r5) {
        int r6 = r4 / 8;
        int r7 = r5 / 8;
        byte[] r3 = generateDerivedKey(r6 + r7);
        return new ParametersWithIV(new KeyParameter(r3, 0, r6), r3, r6, r7);
    }
}
