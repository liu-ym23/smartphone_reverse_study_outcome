package org.apache.commons.compress.compressors.lzw;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class LZWInputStream extends CompressorInputStream implements InputStreamStatistics {
    private byte[] characters;
    private int clearCode;
    private int codeSize;
    protected final BitInputStream in;
    private final byte[] oneByte;
    private byte[] outputStack;
    private int outputStackLocation;
    private int[] prefixes;
    private int previousCode;
    private byte previousCodeFirstChar;
    private int tableSize;

    public LZWInputStream(InputStream r3, ByteOrder r4) {
        this.oneByte = new byte[1];
        this.clearCode = -1;
        this.codeSize = 9;
        this.previousCode = -1;
        this.in = new BitInputStream(r3, r4);
    }

    private int readFromStack(byte[] r3, int r4, int r5) {
        int r0 = this.outputStack.length - this.outputStackLocation;
        if (r0 <= 0) goto L6;
        int r6 = Math.min(r0, r5);
        System.arraycopy(this.outputStack, this.outputStackLocation, r3, r4, r6);
        this.outputStackLocation += r6;
        return r6;
    L6:
        return 0;
    }

    public abstract int addEntry(int r1, byte r2);

    public int addEntry(int r2, byte r3, int r4) {
        int r0 = this.tableSize;
        if (r0 >= r4) goto L6;
        this.prefixes[r0] = r2;
        this.characters[r0] = r3;
        this.tableSize = r0 + 1;
        return r0;
    L6:
        return -1;
    }

    public int addRepeatOfPreviousCode() {
        int r0 = this.previousCode;
        if (r0 == (-1)) goto L7;
        return addEntry(r0, this.previousCodeFirstChar);
    L7:
        throw new IOException("The first code can't be a reference to its preceding code");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
    }

    public abstract int decompressNextSymbol();

    public int expandCodeToOutputStack(int r5, boolean r6) {
        int r0 = r5;
    L3:
        if (r0 < 0) goto L5;
        byte[] r1 = this.outputStack;
        int r2 = this.outputStackLocation - 1;
        this.outputStackLocation = r2;
        r1[r2] = this.characters[r0];
        r0 = this.prefixes[r0];
        goto L3
    L5:
        int r3 = this.previousCode;
        if (r3 == (-1)) goto L9;
        if (r6 == true) goto L9;
        addEntry(r3, this.outputStack[this.outputStackLocation]);
    L9:
        this.previousCode = r5;
        byte[] r7 = this.outputStack;
        int r8 = this.outputStackLocation;
        this.previousCodeFirstChar = r7[r8];
        return r8;
    }

    public int getClearCode() {
        return this.clearCode;
    }

    public int getCodeSize() {
        return this.codeSize;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.in.getBytesRead();
    }

    public int getPrefix(int r1) {
        return this.prefixes[r1];
    }

    public int getPrefixesLength() {
        return this.prefixes.length;
    }

    public int getTableSize() {
        return this.tableSize;
    }

    public void incrementCodeSize() {
        this.codeSize++;
    }

    public void initializeTables(int r3) {
        if (r3 <= 0) goto L9;
        int r4 = 1 << r3;
        this.prefixes = new int[r4];
        this.characters = new byte[r4];
        this.outputStack = new byte[r4];
        this.outputStackLocation = r4;
        int r5 = 0;
    L5:
        if (r5 >= 256) goto L7;
        this.prefixes[r5] = -1;
        this.characters[r5] = (byte) r5;
        r5 = r5 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new IllegalArgumentException("maxCodeSize is " + r3 + ", must be bigger than 0");
    }

    @Override // java.io.InputStream
    public int read() {
        int r0 = read(this.oneByte);
        if (r0 >= 0) goto L6;
        return r0;
    L6:
        return this.oneByte[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] r4, int r5, int r6) {
        if (r6 != 0) goto L5;
        return 0;
    L5:
        int r0 = readFromStack(r4, r5, r6);
    L6:
        int r1 = r6 - r0;
        if (r1 <= 0) goto L15;
        int r2 = decompressNextSymbol();
        if (r2 < 0) goto L10;
        r0 = r0 + readFromStack(r4, r5 + r0, r1);
        goto L6
    L10:
        if (r0 <= 0) goto L13;
        count(r0);
        return r0;
    L13:
        return r2;
    L15:
        count(r0);
        return r0;
    }

    public int readNextCode() {
        int r0 = this.codeSize;
        if (r0 > 31) goto L7;
        return (int) this.in.readBits(r0);
    L7:
        throw new IllegalArgumentException("Code size must not be bigger than 31");
    }

    public void setClearCode(int r2) {
        this.clearCode = 1 << (r2 - 1);
    }

    public void setPrefix(int r1, int r2) {
        this.prefixes[r1] = r2;
    }

    public void setTableSize(int r1) {
        this.tableSize = r1;
    }
}
