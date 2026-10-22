package org.bouncycastle.crypto.util;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
class SSHBuffer {
    private final byte[] buffer;
    private int pos;

    public SSHBuffer(byte[] r2) {
        this.pos = 0;
        this.buffer = r2;
    }

    public SSHBuffer(byte[] r4, byte[] r5) {
        int r0 = 0;
        this.pos = 0;
        this.buffer = r5;
    L4:
        if (r0 == r4.length) goto L10;
        if (r4[r0] != r5[r0]) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("magic-number incorrect");
    L10:
        this.pos += r4.length;
    }

    public boolean hasRemaining() {
        if (this.pos >= this.buffer.length) goto L5;
        return true;
    L5:
        return false;
    }

    public BigInteger readBigNumPositive() {
        int r0 = readU32();
        int r1 = this.pos;
        int r2 = r1 + r0;
        byte[] r3 = this.buffer;
        if (r2 > r3.length) goto L7;
        int r4 = r0 + r1;
        this.pos = r4;
        return new BigInteger(1, Arrays.copyOfRange(r3, r1, r4));
    L7:
        throw new IllegalArgumentException("not enough data for big num");
    }

    public byte[] readBlock() {
        int r0 = readU32();
        if (r0 == 0) goto L5;
        int r1 = this.pos;
        byte[] r2 = this.buffer;
        if (r1 > (r2.length - r0)) goto L11;
        int r3 = r0 + r1;
        this.pos = r3;
        return Arrays.copyOfRange(r2, r1, r3);
    L11:
        throw new IllegalArgumentException("not enough data for block");
    L5:
        return new byte[0];
    }

    public byte[] readPaddedBlock() {
        return readPaddedBlock(8);
    }

    public byte[] readPaddedBlock(int r6) {
        int r0 = readU32();
        if (r0 == 0) goto L5;
        int r1 = this.pos;
        byte[] r2 = this.buffer;
        if (r1 > (r2.length - r0)) goto L27;
        if ((r0 % r6) != 0) goto L25;
        int r3 = r1 + r0;
        this.pos = r3;
        if (r0 <= 0) goto L23;
        int r4 = r2[r3 - 1] & 255;
        if (r4 <= 0) goto L23;
        if (r4 >= r6) goto L23;
        r3 = r3 - r4;
        int r7 = 1;
        int r5 = r3;
    L16:
        if (r7 > r4) goto L23;
        if (r7 != (this.buffer[r5] & 255)) goto L21;
        r7 = r7 + 1;
        r5 = r5 + 1;
        goto L16
    L21:
        throw new IllegalArgumentException("incorrect padding");
    L23:
        return Arrays.copyOfRange(this.buffer, r1, r3);
    L25:
        throw new IllegalArgumentException("missing padding");
    L27:
        throw new IllegalArgumentException("not enough data for block");
    L5:
        return new byte[0];
    }

    public String readString() {
        return Strings.fromByteArray(readBlock());
    }

    public int readU32() {
        int r0 = this.pos;
        byte[] r1 = this.buffer;
        if (r0 > (r1.length - 4)) goto L7;
        int r2 = r0 + 1;
        this.pos = r2;
        int r3 = (r1[r0] & 255) << 24;
        int r4 = r2 + 1;
        this.pos = r4;
        int r5 = r3 | ((r1[r2] & 255) << 16);
        int r6 = r4 + 1;
        this.pos = r6;
        int r7 = r5 | ((r1[r4] & 255) << 8);
        this.pos = r6 + 1;
        return (r1[r6] & 255) | r7;
    L7:
        throw new IllegalArgumentException("4 bytes for U32 exceeds buffer.");
    }

    public void skipBlock() {
        int r0 = readU32();
        int r1 = this.pos;
        if (r1 > (this.buffer.length - r0)) goto L7;
        this.pos = r1 + r0;
        return;
    L7:
        throw new IllegalArgumentException("not enough data for block");
    }
}
