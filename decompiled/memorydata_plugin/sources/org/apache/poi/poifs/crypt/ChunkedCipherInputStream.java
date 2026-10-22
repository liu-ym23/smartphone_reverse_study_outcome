package org.apache.poi.poifs.crypt;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ChunkedCipherInputStream extends LittleEndianInputStream {
    private final byte[] chunk;
    private final int chunkBits;
    private boolean chunkIsValid;
    private final int chunkSize;
    private final Cipher cipher;
    private int lastIndex;
    private final byte[] plain;
    private long pos;
    private final long size;

    public ChunkedCipherInputStream(InputStream r7, long r8, int r10) {
        this(r7, r8, r10, 0);
    }

    public ChunkedCipherInputStream(InputStream r1, long r2, int r4, int r5) {
        super(r1);
        this.size = r2;
        this.pos = r5;
        this.chunkSize = r4;
        if (r4 != (-1)) goto L5;
        r4 = 4096;
    L5:
        long r3 = r4;
        byte[] r6 = IOUtils.safelyAllocate(r3, CryptoFunctions.MAX_RECORD_LENGTH);
        this.chunk = r6;
        this.plain = IOUtils.safelyAllocate(r3, CryptoFunctions.MAX_RECORD_LENGTH);
        int r7 = Integer.bitCount(r6.length - 1);
        this.chunkBits = r7;
        int r8 = (int) (this.pos >> r7);
        this.lastIndex = r8;
        this.cipher = initCipherForBlock(null, r8);
    }

    private void nextChunk() {
        boolean r2 = true;
        if (this.chunkSize == (-1)) goto L12;
        int r0 = (int) (this.pos >> this.chunkBits);
        initCipherForBlock(this.cipher, r0);
        int r4 = this.lastIndex;
        if (r4 == r0) goto L11;
        long r5 = (((long) r0) - ((long) r4)) << this.chunkBits;
        if (super.skip(r5) >= r5) goto L11;
        throw new EOFException("buffer underrun");
    L11:
        this.lastIndex = r0 + 1;
    L12:
        int r1 = (int) Math.min(this.size, this.chunk.length);
        int r6 = 0;
    L13:
        int r7 = super.read(this.plain, r6, r1 - r6);
        r6 = r6 + Math.max(0, r7);
        if (r7 == (-1)) goto L16;
        if (r6 < r1) goto L13;
    L16:
        if (r7 != (-1)) goto L24;
        long r8 = this.pos + ((long) r6);
        long r9 = this.size;
        if (r8 >= r9) goto L24;
        if (r9 >= 2147483647L) goto L24;
        throw new EOFException("buffer underrun");
    L24:
        System.arraycopy(this.plain, 0, this.chunk, 0, r6);
        if (r6 == this.chunkSize) goto L28;
        r2 = false;
    L28:
        invokeCipher(r6, r2);
    }

    private int read(byte[] r12, int r13, int r14, boolean r15) {
        if (remainingBytes() > 0) goto L6;
        return -1;
    L6:
        int r0 = getChunkMask();
        int r2 = 0;
    L7:
        if (r14 <= 0) goto L26;
        if (this.chunkIsValid == false) goto L27;
    L15:
        long r7 = r0;
        int r3 = (int) (((long) this.chunk.length) - (this.pos & r7));
        int r4 = remainingBytes();
        if (r4 == 0) goto L17;
        int r5 = Math.min(r4, Math.min(r3, r14));
        if (r15 == false) goto L21;
        byte[] r6 = this.plain;
    L22:
        System.arraycopy(r6, (int) (this.pos & r7), r12, r13, r5);
        r13 = r13 + r5;
        r14 = r14 - r5;
        long r8 = this.pos + ((long) r5);
        this.pos = r8;
        if ((r8 & r7) != 0) goto L25;
        this.chunkIsValid = false;
    L25:
        r2 = r2 + r5;
        goto L7
    L21:
        r6 = this.chunk;
        goto L22
    L17:
        return r2;
    L27:
        nextChunk();     // Catch: GeneralSecurityException -> L12
        this.chunkIsValid = true;     // Catch: GeneralSecurityException -> L12
    L12:
        e = move-exception;
        throw new EncryptedDocumentException(e.getMessage(), e);
    L26:
        return r2;
    }

    private int remainingBytes() {
        return (int) (this.size - this.pos);
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, java.io.FilterInputStream, java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        return remainingBytes();
    }

    public byte[] getChunk() {
        return this.chunk;
    }

    public int getChunkMask() {
        return this.chunk.length - 1;
    }

    public byte[] getPlain() {
        return this.plain;
    }

    public long getPos() {
        return this.pos;
    }

    public final Cipher initCipherForBlock(int r3) {
        if (this.chunkSize != (-1)) goto L7;
        this.chunkIsValid = false;
        return initCipherForBlock(this.cipher, r3);
    L7:
        throw new GeneralSecurityException("the cipher block can only be set for streaming encryption, e.g. CryptoAPI...");
    }

    public abstract Cipher initCipherForBlock(Cipher r1, int r2);

    public int invokeCipher(int r2, boolean r3) {
        if (r3 == false) goto L6;
        Cipher r4 = this.cipher;
        byte[] r1 = this.chunk;
        return r4.doFinal(r1, 0, r2, r1);
    L6:
        Cipher r5 = this.cipher;
        byte[] r6 = this.chunk;
        return r5.update(r6, 0, r2, r6);
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r1) {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new UnsupportedOperationException();     // Catch: Throwable -> L5
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        byte[] r1 = {0};
        if (read(r1) == 1) goto L7;
        return -1;
    L7:
        return r1[0] & 255;
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        return read(r2, r3, r4, false);
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] r5, int r6, int r7) {
        if (r7 > 0) goto L4;
        return;
    L4:
        int r1 = 0;
    L16:
        int r2 = read(r5, r6, r7, true);     // Catch: IOException -> L13
        r1 = r1 + Math.max(0, r2);     // Catch: IOException -> L13
        if (r2 <= (-1)) goto L9;
        if (r1 < r7) goto L16;
    L9:
        if (r1 < r7) goto L12;
        return;
    L12:
        throw new EOFException("buffer underrun");     // Catch: IOException -> L13
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new UnsupportedOperationException();     // Catch: Throwable -> L5
    }

    public void setNextRecordSize(int r1) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r5) {
        long r0 = this.pos;
        long r6 = Math.min(remainingBytes(), r5);
        if (((r0 ^ (this.pos + r6)) & ((long) (~getChunkMask()))) == 0) goto L5;
        this.chunkIsValid = false;
    L5:
        this.pos += r6;
        return r6;
    }
}
