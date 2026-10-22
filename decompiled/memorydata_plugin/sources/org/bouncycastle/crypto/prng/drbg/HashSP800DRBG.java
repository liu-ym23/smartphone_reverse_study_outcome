package org.bouncycastle.crypto.prng.drbg;

import com.bytedance.crypto.utils.CryptoConst;
import com.ss.bduploader.UploadKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Hashtable;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
public class HashSP800DRBG implements SP80090DRBG {
    private static final byte[] ONE = null;
    private static final Hashtable seedlens = null;
    private byte[] _C;
    private byte[] _V;
    private Digest _digest;
    private EntropySource _entropySource;
    private long _reseedCounter;
    private int _securityStrength;
    private int _seedLength;

    static {
        ONE = new byte[]{1};
        Hashtable r0 = new Hashtable();
        seedlens = r0;
        r0.put("SHA-1", Integers.valueOf(UploadKeys.KeyIsEnd2EndEncryptionPublicKey));
        r0.put("SHA-224", Integers.valueOf(UploadKeys.KeyIsEnd2EndEncryptionPublicKey));
        r0.put(CryptoConst.ALGORITHM_SHA256, Integers.valueOf(UploadKeys.KeyIsEnd2EndEncryptionPublicKey));
        r0.put("SHA-512/256", Integers.valueOf(UploadKeys.KeyIsEnd2EndEncryptionPublicKey));
        r0.put("SHA-512/224", Integers.valueOf(UploadKeys.KeyIsEnd2EndEncryptionPublicKey));
        r0.put("SHA-384", Integers.valueOf(888));
        r0.put("SHA-512", Integers.valueOf(888));
    }

    public HashSP800DRBG(Digest r3, int r4, EntropySource r5, byte[] r6, byte[] r7) {
        Digest r8 = (Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin");
        EntropySource r9 = (EntropySource) ZeusTransformUtils.wrapperContextForParams(r5, EntropySource.class, "com.obric.memorydata.plugin");
        if (r4 > Utils.getMaxSecurityStrength(r8)) goto L11;
        if (r9.entropySize() < r4) goto L9;
        this._digest = r8;
        this._entropySource = r9;
        this._securityStrength = r4;
        this._seedLength = ((Integer) ZeusTransformUtils.preCheckCast(seedlens.get(r8.getAlgorithmName()), Integer.class, "com.obric.memorydata.plugin")).intValue();
        byte[] r10 = Arrays.concatenate(getEntropy(), r7, r6);
        byte[] r11 = Utils.hash_df(this._digest, r10, this._seedLength);
        this._V = r11;
        byte[] r12 = new byte[r11.length + 1];
        System.arraycopy(r11, 0, r12, 1, r11.length);
        this._C = Utils.hash_df(this._digest, r12, this._seedLength);
        this._reseedCounter = 1;
        return;
    L9:
        throw new IllegalArgumentException("Not enough entropy for security strength required");
    L11:
        throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
    }

    private void addTo(byte[] r7, byte[] r8) {
        int r2 = 0;
        int r1 = 1;
    L4:
        if (r1 > r8.length) goto L10;
        int r3 = ((r7[r7.length - r1] & 255) + (r8[r8.length - r1] & 255)) + r2;
        if (r3 <= 255) goto L8;
        r2 = 1;
    L9:
        r7[r7.length - r1] = (byte) r3;
        r1 = r1 + 1;
        goto L4
    L8:
        r2 = 0;
        goto L9
    L10:
        int r9 = r8.length + 1;
    L12:
        if (r9 > r7.length) goto L18;
        int r4 = (r7[r7.length - r9] & 255) + r2;
        if (r4 <= 255) goto L16;
        r2 = 1;
    L17:
        r7[r7.length - r9] = (byte) r4;
        r9 = r9 + 1;
        goto L12
    L16:
        r2 = 0;
        goto L17
    }

    private void doHash(byte[] r4, byte[] r5) {
        this._digest.update(r4, 0, r4.length);
        this._digest.doFinal(r5, 0);
    }

    private byte[] getEntropy() {
        byte[] r0 = this._entropySource.getEntropy();
        if (r0.length < ((this._securityStrength + 7) / 8)) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private byte[] hash(byte[] r2) {
        byte[] r0 = new byte[this._digest.getDigestSize()];
        doHash(r2, r0);
        return r0;
    }

    private byte[] hashgen(byte[] r9, int r10) {
        int r11 = r10 / 8;
        int r0 = r11 / this._digest.getDigestSize();
        byte[] r1 = new byte[r9.length];
        System.arraycopy(r9, 0, r1, 0, r9.length);
        byte[] r12 = new byte[r11];
        int r2 = this._digest.getDigestSize();
        byte[] r4 = new byte[r2];
        int r5 = 0;
    L3:
        if (r5 > r0) goto L8;
        doHash(r1, r4);
        int r6 = r5 * r2;
        int r7 = r11 - r6;
        if (r7 <= r2) goto L7;
        r7 = r2;
    L7:
        System.arraycopy(r4, 0, r12, r6, r7);
        addTo(r1, ONE);
        r5 = r5 + 1;
        goto L3
    L8:
        return r12;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] r11, byte[] r12, boolean r13) {
        int r0 = r11.length * 8;
        if (r0 > 262144) goto L16;
        if (this._reseedCounter <= 140737488355328L) goto L8;
        return -1;
    L8:
        if (r13 == false) goto L11;
        reseed(r12);
        r12 = null;
    L11:
        if (r12 == null) goto L13;
        byte[] r4 = this._V;
        byte[] r5 = new byte[(r4.length + 1) + r12.length];
        r5[0] = 2;
        System.arraycopy(r4, 0, r5, 1, r4.length);
        System.arraycopy(r12, 0, r5, this._V.length + 1, r12.length);
        addTo(this._V, hash(r5));
    L13:
        byte[] r14 = hashgen(this._V, r0);
        byte[] r6 = this._V;
        byte[] r7 = new byte[r6.length + 1];
        System.arraycopy(r6, 0, r7, 1, r6.length);
        r7[0] = 3;
        addTo(this._V, hash(r7));
        addTo(this._V, this._C);
        long r8 = this._reseedCounter;
        addTo(this._V, new byte[]{(byte) (r8 >> 24), (byte) (r8 >> 16), (byte) (r8 >> 8), (byte) r8});
        this._reseedCounter++;
        System.arraycopy(r14, 0, r11, 0, r11.length);
        return r0;
    L16:
        throw new IllegalArgumentException("Number of bits per request limited to 262144");
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] r5) {
        byte[] r0 = getEntropy();
        byte[] r6 = Arrays.concatenate(ONE, this._V, r0, r5);
        byte[] r7 = Utils.hash_df(this._digest, r6, this._seedLength);
        this._V = r7;
        byte[] r1 = new byte[r7.length + 1];
        r1[0] = 0;
        System.arraycopy(r7, 0, r1, 1, r7.length);
        this._C = Utils.hash_df(this._digest, r1, this._seedLength);
        this._reseedCounter = 1;
    }
}
