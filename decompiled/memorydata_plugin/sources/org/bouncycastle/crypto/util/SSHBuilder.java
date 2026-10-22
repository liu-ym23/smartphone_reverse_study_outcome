package org.bouncycastle.crypto.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
class SSHBuilder {
    private final ByteArrayOutputStream bos;

    SSHBuilder() {
        this.bos = new ByteArrayOutputStream();
    }

    public byte[] getBytes() {
        return this.bos.toByteArray();
    }

    public byte[] getPaddedBytes() {
        return getPaddedBytes(8);
    }

    public byte[] getPaddedBytes(int r3) {
        int r0 = this.bos.size() % r3;
        if (r0 == 0) goto L8;
        int r4 = r3 - r0;
        int r1 = 1;
    L5:
        if (r1 > r4) goto L8;
        this.bos.write(r1);
        r1 = r1 + 1;
    L8:
        return this.bos.toByteArray();
    }

    public void u32(int r3) {
        this.bos.write((r3 >>> 24) & 255);
        this.bos.write((r3 >>> 16) & 255);
        this.bos.write((r3 >>> 8) & 255);
        this.bos.write(r3 & 255);
    }

    public void writeBigNum(BigInteger r1) {
        writeBlock(r1.toByteArray());
    }

    public void writeBlock(byte[] r2) {
        u32(r2.length);
        this.bos.write(r2);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException(e.getMessage(), e);
    }

    public void writeBytes(byte[] r2) {
        this.bos.write(r2);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalStateException(e.getMessage(), e);
    }

    public void writeString(String r1) {
        writeBlock(Strings.toByteArray(r1));
    }
}
