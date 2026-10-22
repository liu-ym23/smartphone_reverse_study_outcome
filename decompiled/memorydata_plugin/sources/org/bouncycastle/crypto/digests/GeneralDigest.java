package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes7.dex */
public abstract class GeneralDigest implements ExtendedDigest, Memoable {
    private long byteCount;
    protected final CryptoServicePurpose purpose;
    private final byte[] xBuf;
    private int xBufOff;

    public GeneralDigest(CryptoServicePurpose r2) {
        this.xBuf = new byte[4];
        this.purpose = r2;
        this.xBufOff = 0;
    }

    public GeneralDigest(GeneralDigest r2) {
        this.xBuf = new byte[4];
        this.purpose = r2.purpose;
        copyIn(r2);
    }

    public void copyIn(GeneralDigest r5) {
        byte[] r0 = r5.xBuf;
        System.arraycopy(r0, 0, this.xBuf, 0, r0.length);
        this.xBufOff = r5.xBufOff;
        this.byteCount = r5.byteCount;
    }

    public void finish() {
        long r0 = this.byteCount << 3;
        byte r2 = -128;
    L3:
        update(r2);
        if (this.xBufOff == 0) goto L6;
        r2 = 0;
        goto L3
    L6:
        processLength(r0);
        processBlock();
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    public abstract void processBlock();

    public abstract void processLength(long r1);

    public abstract void processWord(byte[] r1, int r2);

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.byteCount = 0;
        this.xBufOff = 0;
        int r1 = 0;
    L3:
        byte[] r2 = this.xBuf;
        if (r1 >= r2.length) goto L6;
        r2[r1] = 0;
        r1 = r1 + 1;
        goto L3
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r5) {
        byte[] r0 = this.xBuf;
        int r1 = this.xBufOff;
        int r2 = r1 + 1;
        this.xBufOff = r2;
        r0[r1] = r5;
        if (r2 != r0.length) goto L5;
        processWord(r0, 0);
        this.xBufOff = 0;
    L5:
        this.byteCount++;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r7, int r8, int r9) {
        int r0 = 0;
        int r10 = Math.max(0, r9);
        if (this.xBufOff == 0) goto L11;
        int r1 = 0;
    L5:
        if (r1 >= r10) goto L10;
        byte[] r2 = this.xBuf;
        int r3 = this.xBufOff;
        int r4 = r3 + 1;
        this.xBufOff = r4;
        int r5 = r1 + 1;
        r2[r3] = r7[r1 + r8];
        if (r4 == 4) goto L8;
        r1 = r5;
        goto L5
    L8:
        processWord(r2, 0);
        this.xBufOff = 0;
        r0 = r5;
        goto L11
    L10:
        r0 = r1;
    L11:
        int r6 = r10 - 3;
    L12:
        if (r0 >= r6) goto L14;
        processWord(r7, r8 + r0);
        r0 = r0 + 4;
    L14:
        if (r0 >= r10) goto L16;
        byte[] r11 = this.xBuf;
        int r12 = this.xBufOff;
        this.xBufOff = r12 + 1;
        r11[r12] = r7[r0 + r8];
        r0 = r0 + 1;
        goto L14
    L16:
        this.byteCount += (long) r10;
    }
}
