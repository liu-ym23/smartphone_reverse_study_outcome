package org.apache.commons.compress.compressors.lz4;

import java.util.zip.Checksum;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
public class XXHash32 implements Checksum {
    private final byte[] buffer;
    private final byte[] oneByte;
    private int pos;
    private final int seed;
    private final int[] state;
    private int totalLen;

    private static int getInt(byte[] r2, int r3) {
        return (int) (ByteUtils.fromLittleEndian(r2, r3, 4) & 4294967295L);
    }

    private void initializeState() {
        int[] r0 = this.state;
        int r5 = this.seed;
        r0[0] = (r5 - 1640531535) - 2048144777;
        r0[1] = (-2048144777) + r5;
        r0[2] = r5;
        r0[3] = r5 - (-1640531535);
    }

    private void process(byte[] r13, int r14) {
        int[] r0 = this.state;
        int r2 = r0[0];
        int r4 = r0[1];
        int r6 = r0[2];
        int r1 = r0[3];
        int r3 = Integer.rotateLeft(r2 + (getInt(r13, r14) * (-2048144777)), 13) * (-1640531535);
        int r5 = Integer.rotateLeft(r4 + (getInt(r13, r14 + 4) * (-2048144777)), 13) * (-1640531535);
        int r7 = Integer.rotateLeft(r6 + (getInt(r13, r14 + 8) * (-2048144777)), 13) * (-1640531535);
        int r15 = Integer.rotateLeft(r1 + (getInt(r13, r14 + 12) * (-2048144777)), 13) * (-1640531535);
        int[] r16 = this.state;
        r16[0] = r3;
        r16[1] = r5;
        r16[2] = r7;
        r16[3] = r15;
        this.pos = 0;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        int r1 = 0;
        if (this.totalLen <= 16) goto L5;
        int r0 = ((Integer.rotateLeft(this.state[0], 1) + Integer.rotateLeft(this.state[1], 7)) + Integer.rotateLeft(this.state[2], 12)) + Integer.rotateLeft(this.state[3], 18);
    L6:
        int r2 = r0 + this.totalLen;
        int r3 = this.pos - 4;
    L8:
        if (r1 > r3) goto L11;
        r2 = Integer.rotateLeft(r2 + (getInt(this.buffer, r1) * (-1028477379)), 17) * 668265263;
        r1 = r1 + 4;
    L11:
        if (r1 >= this.pos) goto L13;
        r2 = Integer.rotateLeft(r2 + ((this.buffer[r1] & 255) * 374761393), 11) * (-1640531535);
        r1 = r1 + 1;
        goto L11
    L13:
        int r6 = ((r2 >>> 15) ^ r2) * (-2048144777);
        int r7 = (r6 ^ (r6 >>> 13)) * (-1028477379);
        return ((long) (r7 ^ (r7 >>> 16))) & 4294967295L;
    L5:
        r0 = this.state[2] + 374761393;
        goto L6
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        initializeState();
        this.totalLen = 0;
        this.pos = 0;
    }

    @Override // java.util.zip.Checksum
    public void update(int r3) {
        byte[] r0 = this.oneByte;
        r0[0] = (byte) (r3 & 255);
        update(r0, 0, 1);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] r5, int r6, int r7) {
        if (r7 > 0) goto L4;
        return;
    L4:
        this.totalLen += r7;
        int r0 = r6 + r7;
        int r1 = this.pos;
        if ((r1 + r7) >= 16) goto L9;
        System.arraycopy(r5, r6, this.buffer, r1, r7);
        this.pos += r7;
        return;
    L9:
        if (r1 <= 0) goto L11;
        int r2 = 16 - r1;
        System.arraycopy(r5, r6, this.buffer, r1, r2);
        process(this.buffer, 0);
        r6 = r6 + r2;
    L11:
        int r3 = r0 - 16;
    L12:
        if (r6 > r3) goto L14;
        process(r5, r6);
        r6 = r6 + 16;
        goto L12
    L14:
        if (r6 >= r0) goto L18;
        int r4 = r0 - r6;
        this.pos = r4;
        System.arraycopy(r5, r6, this.buffer, 0, r4);
        return;
    }
}
