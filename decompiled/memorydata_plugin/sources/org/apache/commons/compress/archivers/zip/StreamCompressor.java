package org.apache.commons.compress.archivers.zip;

import java.io.Closeable;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes6.dex */
public abstract class StreamCompressor implements Closeable {
    private final CRC32 crc;
    private final Deflater def;
    private final byte[] outputBuffer;
    private final byte[] readerBuf;
    private long sourcePayloadLength;
    private long totalWrittenToOutputStream;
    private long writtenToOutputStreamForLastEntry;

    private static final class OutputStreamCompressor extends StreamCompressor {
        private final OutputStream os;

        public OutputStreamCompressor(Deflater r1, OutputStream r2) {
            super(r1);
            this.os = r2;
        }

        @Override // org.apache.commons.compress.archivers.zip.StreamCompressor
        public void writeOut(byte[] r1, int r2, int r3) {
            this.os.write(r1, r2, r3);
        }
    }

    StreamCompressor(Deflater r3) {
        this.crc = new CRC32();
        this.outputBuffer = new byte[4096];
        this.readerBuf = new byte[4096];
        this.def = r3;
    }

    static StreamCompressor create(OutputStream r1, Deflater r2) {
        return new OutputStreamCompressor(r2, r1);
    }

    private void deflateUntilInputIsNeeded() {
    L3:
        if (this.def.needsInput() == true) goto L5;
        deflate();
        goto L3
    }

    private void writeDeflated(byte[] r6, int r7, int r8) {
        if (r8 > 0) goto L4;
        return;
    L4:
        if (this.def.finished() == false) goto L6;
        return;
    L6:
        if (r8 > 8192) goto L9;
        Deflater r0 = this.def;
    L8:
        r0.setInput(r6, r7, r8);
        deflateUntilInputIsNeeded();
        return;
    L9:
        int r1 = r8 / 8192;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L12;
        this.def.setInput(r6, (r2 * 8192) + r7, 8192);
        deflateUntilInputIsNeeded();
        r2 = r2 + 1;
        goto L10
    L12:
        int r3 = r1 * 8192;
        if (r3 >= r8) goto L19;
        r0 = this.def;
        r7 = r7 + r3;
        r8 = r8 - r3;
        goto L8
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.def.end();
    }

    void deflate() {
        Deflater r0 = this.def;
        byte[] r1 = this.outputBuffer;
        int r2 = r0.deflate(r1, 0, r1.length);
        if (r2 <= 0) goto L6;
        writeCounted(this.outputBuffer, 0, r2);
        return;
    }

    void flushDeflater() {
        this.def.finish();
    L4:
        if (this.def.finished() == true) goto L6;
        deflate();
        goto L4
    }

    public long getBytesRead() {
        return this.sourcePayloadLength;
    }

    public long getCrc32() {
        return this.crc.getValue();
    }

    public long getTotalBytesWritten() {
        return this.totalWrittenToOutputStream;
    }

    void reset() {
        this.crc.reset();
        this.def.reset();
        this.sourcePayloadLength = 0;
        this.writtenToOutputStreamForLastEntry = 0;
    }

    long write(byte[] r4, int r5, int r6, int r7) {
        long r0 = this.writtenToOutputStreamForLastEntry;
        this.crc.update(r4, r5, r6);
        if (r7 != 8) goto L5;
        writeDeflated(r4, r5, r6);
    L6:
        this.sourcePayloadLength += (long) r6;
        return this.writtenToOutputStreamForLastEntry - r0;
    L5:
        writeCounted(r4, r5, r6);
        goto L6
    }

    public void writeCounted(byte[] r3) {
        writeCounted(r3, 0, r3.length);
    }

    public void writeCounted(byte[] r3, int r4, int r5) {
        writeOut(r3, r4, r5);
        long r0 = r5;
        this.writtenToOutputStreamForLastEntry += r0;
        this.totalWrittenToOutputStream += r0;
    }

    public abstract void writeOut(byte[] r1, int r2, int r3);
}
