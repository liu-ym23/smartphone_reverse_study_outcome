package org.bouncycastle.crypto.prng.drbg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class HMacSP800DRBG implements SP80090DRBG {
    private byte[] _K;
    private byte[] _V;
    private EntropySource _entropySource;
    private Mac _hMac;
    private long _reseedCounter;
    private int _securityStrength;

    public HMacSP800DRBG(Mac r3, int r4, EntropySource r5, byte[] r6, byte[] r7) {
        Mac r8 = (Mac) ZeusTransformUtils.wrapperContextForParams(r3, Mac.class, "com.obric.memorydata.plugin");
        EntropySource r9 = (EntropySource) ZeusTransformUtils.wrapperContextForParams(r5, EntropySource.class, "com.obric.memorydata.plugin");
        if (r4 > Utils.getMaxSecurityStrength(r8)) goto L11;
        if (r9.entropySize() < r4) goto L9;
        this._securityStrength = r4;
        this._entropySource = r9;
        this._hMac = r8;
        byte[] r10 = Arrays.concatenate(getEntropy(), r7, r6);
        byte[] r11 = new byte[r8.getMacSize()];
        this._K = r11;
        byte[] r12 = new byte[r11.length];
        this._V = r12;
        Arrays.fill(r12, (byte) 1);
        hmac_DRBG_Update(r10);
        this._reseedCounter = 1;
        return;
    L9:
        throw new IllegalArgumentException("Not enough entropy for security strength required");
    L11:
        throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
    }

    private byte[] getEntropy() {
        byte[] r0 = this._entropySource.getEntropy();
        if (r0.length < ((this._securityStrength + 7) / 8)) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private void hmac_DRBG_Update(byte[] r2) {
        hmac_DRBG_Update_Func(r2, (byte) 0);
        if (r2 == null) goto L6;
        hmac_DRBG_Update_Func(r2, (byte) 1);
        return;
    }

    private void hmac_DRBG_Update_Func(byte[] r5, byte r6) {
        this._hMac.init(new KeyParameter(this._K));
        Mac r0 = this._hMac;
        byte[] r1 = this._V;
        r0.update(r1, 0, r1.length);
        this._hMac.update(r6);
        if (r5 == null) goto L5;
        this._hMac.update(r5, 0, r5.length);
    L5:
        this._hMac.doFinal(this._K, 0);
        this._hMac.init(new KeyParameter(this._K));
        Mac r7 = this._hMac;
        byte[] r8 = this._V;
        r7.update(r8, 0, r8.length);
        this._hMac.doFinal(this._V, 0);
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] r9, byte[] r10, boolean r11) {
        int r0 = r9.length * 8;
        if (r0 > 262144) goto L21;
        if (this._reseedCounter <= 140737488355328L) goto L8;
        return -1;
    L8:
        if (r11 == false) goto L10;
        reseed(r10);
        r10 = null;
    L10:
        if (r10 == null) goto L12;
        hmac_DRBG_Update(r10);
    L12:
        int r12 = r9.length;
        byte[] r1 = new byte[r12];
        int r2 = r9.length / this._V.length;
        this._hMac.init(new KeyParameter(this._K));
        int r4 = 0;
    L13:
        if (r4 >= r2) goto L15;
        Mac r5 = this._hMac;
        byte[] r6 = this._V;
        r5.update(r6, 0, r6.length);
        this._hMac.doFinal(this._V, 0);
        byte[] r7 = this._V;
        System.arraycopy(r7, 0, r1, r7.length * r4, r7.length);
        r4 = r4 + 1;
        goto L13
    L15:
        byte[] r8 = this._V;
        if ((r8.length * r2) >= r12) goto L18;
        this._hMac.update(r8, 0, r8.length);
        this._hMac.doFinal(this._V, 0);
        byte[] r13 = this._V;
        System.arraycopy(r13, 0, r1, r13.length * r2, r12 - (r2 * r13.length));
    L18:
        hmac_DRBG_Update(r10);
        this._reseedCounter++;
        System.arraycopy(r1, 0, r9, 0, r9.length);
        return r0;
    L21:
        throw new IllegalArgumentException("Number of bits per request limited to 262144");
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] r3) {
        hmac_DRBG_Update(Arrays.concatenate(getEntropy(), r3));
        this._reseedCounter = 1;
    }
}
