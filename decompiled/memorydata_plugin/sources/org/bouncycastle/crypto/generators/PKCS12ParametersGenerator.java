package org.bouncycastle.crypto.generators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes7.dex */
public class PKCS12ParametersGenerator extends PBEParametersGenerator {
    private Digest digest;
    private int u;
    private int v;

    public PKCS12ParametersGenerator(Digest r3) {
        Digest r4 = (Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin");
        this.digest = r4;
        if (ZeusTransformUtils.instanceOf(r4, ExtendedDigest.class) == false) goto L7;
        this.u = r4.getDigestSize();
        this.v = ((ExtendedDigest) ZeusTransformUtils.preCheckCast(r4, ExtendedDigest.class, "com.obric.memorydata.plugin")).getByteLength();
        return;
    L7:
        throw new IllegalArgumentException("Digest " + r4.getAlgorithmName() + " unsupported");
    }

    private void adjust(byte[] r5, int r6, byte[] r7) {
        int r4 = ((r7[r7.length - 1] & 255) + (r5[(r7.length + r6) - 1] & 255)) + 1;
        r5[(r7.length + r6) - 1] = (byte) r4;
        int r8 = r4 >>> 8;
        int r0 = r7.length - 2;
    L3:
        if (r0 < 0) goto L5;
        int r2 = r6 + r0;
        int r9 = r8 + ((r7[r0] & 255) + (r5[r2] & 255));
        r5[r2] = (byte) r9;
        r8 = r9 >>> 8;
        r0 = r0 - 1;
        goto L3
    }

    private byte[] generateDerivedKey(int r17, int r18) {
        int r2 = this.v;
        byte[] r3 = new byte[r2];
        byte[] r4 = new byte[r18];
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r6 == r2) goto L5;
        r3[r6] = (byte) r17;
        r6 = r6 + 1;
        goto L3
    L5:
        int r7 = 1;
        if (this.salt != null) goto L8;
    L12:
        byte[] r8 = new byte[0];
    L14:
        if (this.password != null) goto L16;
    L20:
        byte[] r9 = new byte[0];
    L21:
        int r10 = r8.length + r9.length;
        byte[] r11 = new byte[r10];
        System.arraycopy(r8, 0, r11, 0, r8.length);
        System.arraycopy(r9, 0, r11, r8.length, r9.length);
        int r12 = this.v;
        byte[] r13 = new byte[r12];
        int r14 = this.u;
        int r15 = ((r18 + r14) - 1) / r14;
        byte[] r16 = new byte[r14];
        int r19 = 1;
    L22:
        if (r19 > r15) goto L38;
        this.digest.update(r3, r5, r2);
        this.digest.update(r11, r5, r10);
        this.digest.doFinal(r16, r5);
        int r110 = r7;
    L25:
        if (r110 >= this.iterationCount) goto L27;
        this.digest.update(r16, r5, r14);
        this.digest.doFinal(r16, r5);
        r110 = r110 + 1;
        goto L25
    L27:
        int r20 = r5;
    L28:
        if (r20 == r12) goto L30;
        r13[r20] = r16[r20 % r14];
        r20 = r20 + 1;
        goto L28
    L30:
        int r21 = r5;
    L31:
        int r111 = this.v;
        if (r21 == (r10 / r111)) goto L34;
        adjust(r11, r111 * r21, r13);
        r21 = r21 + 1;
        goto L31
    L34:
        if (r19 != r15) goto L36;
        int r22 = r19 - 1;
        int r23 = this.u;
        int r112 = r22 * r23;
        int r24 = r18 - (r22 * r23);
        int r25 = 0;
        System.arraycopy(r16, 0, r4, r112, r24);
    L37:
        r19 = r19 + 1;
        r5 = r25;
        r7 = 1;
        goto L22
    L36:
        r25 = 0;
        System.arraycopy(r16, 0, r4, (r19 - 1) * this.u, r14);
        goto L37
    L38:
        return r4;
    L16:
        if (this.password.length == 0) goto L20;
        int r26 = this.v;
        int r27 = this.password.length;
        int r113 = this.v;
        int r28 = r26 * (((r27 + r113) - 1) / r113);
        r9 = new byte[r28];
        int r114 = 0;
    L18:
        if (r114 == r28) goto L21;
        r9[r114] = this.password[r114 % this.password.length];
        r114 = r114 + 1;
        goto L18
    L8:
        if (this.salt.length == 0) goto L12;
        int r29 = this.v;
        int r30 = this.salt.length;
        int r31 = this.v;
        int r32 = r29 * (((r30 + r31) - 1) / r31);
        r8 = new byte[r32];
        int r33 = 0;
    L10:
        if (r33 == r32) goto L14;
        r8[r33] = this.salt[r33 % this.salt.length];
        r33 = r33 + 1;
        goto L10
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int r3) {
        int r4 = r3 / 8;
        return new KeyParameter(generateDerivedKey(3, r4), 0, r4);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r3) {
        int r4 = r3 / 8;
        return new KeyParameter(generateDerivedKey(1, r4), 0, r4);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r5, int r6) {
        int r7 = r5 / 8;
        int r8 = r6 / 8;
        byte[] r0 = generateDerivedKey(1, r7);
        byte[] r4 = generateDerivedKey(2, r8);
        return new ParametersWithIV(new KeyParameter(r0, 0, r7), r4, 0, r8);
    }
}
