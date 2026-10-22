package org.bouncycastle.crypto.prng;

import android.support.v4.media.session.PlaybackStateCompat;
import org.bouncycastle.crypto.BlockCipher;

/* JADX INFO: loaded from: classes7.dex */
public class X931RNG {
    private final byte[] DT;
    private final byte[] I;
    private final byte[] R;
    private byte[] V;
    private final BlockCipher engine;
    private final EntropySource entropySource;
    private long reseedCounter;

    private void increment(byte[] r2) {
        int r1 = r2.length - 1;
    L3:
        if (r1 < 0) goto L8;
        byte r0 = (byte) (r2[r1] + 1);
        r2[r1] = r0;
        if (r0 != 0) goto L11;
        r1 = r1 - 1;
        goto L3
    L11:
        return;
    }

    private static boolean isTooLarge(byte[] r0, int r1) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length <= r1) goto L6;
        return true;
    }

    private void process(byte[] r5, byte[] r6, byte[] r7) {
        int r1 = 0;
    L4:
        if (r1 == r5.length) goto L6;
        r5[r1] = (byte) (r6[r1] ^ r7[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        this.engine.processBlock(r5, 0, r5, 0);
    }

    int generate(byte[] r8, boolean r9) {
        int r0 = this.R.length;
        long r3 = this.reseedCounter;
        if (r0 != 8) goto L13;
        if (r3 <= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) goto L8;
        return -1;
    L8:
        if (isTooLarge(r8, 512) == true) goto L11;
    L17:
        if (r9 == false) goto L19;
    L20:
        byte[] r10 = this.entropySource.getEntropy();
        this.V = r10;
        if (r10.length != this.engine.getBlockSize()) goto L31;
    L22:
        int r11 = r8.length / this.R.length;
        int r1 = 0;
    L23:
        if (r1 >= r11) goto L25;
        this.engine.processBlock(this.DT, 0, this.I, 0);
        process(this.R, this.I, this.V);
        process(this.V, this.R, this.I);
        byte[] r4 = this.R;
        System.arraycopy(r4, 0, r8, r4.length * r1, r4.length);
        increment(this.DT);
        r1 = r1 + 1;
        goto L23
    L25:
        int r2 = r8.length - (this.R.length * r11);
        if (r2 <= 0) goto L28;
        this.engine.processBlock(this.DT, 0, this.I, 0);
        process(this.R, this.I, this.V);
        process(this.V, this.R, this.I);
        byte[] r5 = this.R;
        System.arraycopy(r5, 0, r8, r11 * r5.length, r2);
        increment(this.DT);
    L28:
        this.reseedCounter++;
        return r8.length * 8;
    L31:
        throw new IllegalStateException("Insufficient entropy returned");
    L19:
        if (this.V != null) goto L22;
    L11:
        throw new IllegalArgumentException("Number of bits per request limited to 4096");
    L13:
        if (r3 <= 8388608) goto L16;
        return -1;
    L16:
        if (isTooLarge(r8, 32768) == false) goto L17;
        throw new IllegalArgumentException("Number of bits per request limited to 262144");
    }

    EntropySource getEntropySource() {
        return this.entropySource;
    }

    void reseed() {
        byte[] r0 = this.entropySource.getEntropy();
        this.V = r0;
        if (r0.length != this.engine.getBlockSize()) goto L7;
        this.reseedCounter = 1;
        return;
    L7:
        throw new IllegalStateException("Insufficient entropy returned");
    }
}
