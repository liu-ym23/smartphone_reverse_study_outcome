package org.bouncycastle.crypto.generators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;

/* JADX INFO: loaded from: classes7.dex */
public class PKCS5S2ParametersGenerator extends PBEParametersGenerator {
    private Mac hMac;
    private byte[] state;

    public PKCS5S2ParametersGenerator() {
        this(DigestFactory.createSHA1());
    }

    public PKCS5S2ParametersGenerator(Digest r3) {
        HMac r0 = new HMac((Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin"));
        this.hMac = r0;
        this.state = new byte[r0.getMacSize()];
    }

    private void F(byte[] r5, int r6, byte[] r7, byte[] r8, int r9) {
        if (r6 == 0) goto L15;
        if (r5 == null) goto L6;
        this.hMac.update(r5, 0, r5.length);
    L6:
        this.hMac.update(r7, 0, r7.length);
        this.hMac.doFinal(this.state, 0);
        byte[] r10 = this.state;
        System.arraycopy(r10, 0, r8, r9, r10.length);
        int r11 = 1;
    L7:
        if (r11 >= r6) goto L13;
        Mac r12 = this.hMac;
        byte[] r1 = this.state;
        r12.update(r1, 0, r1.length);
        this.hMac.doFinal(this.state, 0);
        int r13 = 0;
    L9:
        byte[] r2 = this.state;
        if (r13 == r2.length) goto L12;
        int r3 = r9 + r13;
        r8[r3] = (byte) (r2[r13] ^ r8[r3]);
        r13 = r13 + 1;
        goto L9
    L12:
        r11 = r11 + 1;
        goto L7
    L13:
        return;
    L15:
        throw new IllegalArgumentException("iteration count must be at least 1.");
    }

    private byte[] generateDerivedKey(int r13) {
        int r0 = this.hMac.getMacSize();
        int r14 = ((r13 + r0) - 1) / r0;
        byte[] r2 = new byte[4];
        byte[] r9 = new byte[r14 * r0];
        this.hMac.init(new KeyParameter(this.password));
        int r11 = 1;
        int r10 = 0;
    L3:
        if (r11 > r14) goto L9;
        int r3 = 3;
    L5:
        byte r4 = (byte) (r2[r3] + 1);
        r2[r3] = r4;
        if (r4 != 0) goto L8;
        r3 = r3 - 1;
        goto L5
    L8:
        F(this.salt, this.iterationCount, r2, r9, r10);
        r10 = r10 + r0;
        r11 = r11 + 1;
        goto L3
    L9:
        return r9;
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
