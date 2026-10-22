package org.apache.poi.poifs.filesystem;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class DocumentInputStream extends InputStream implements LittleEndianInput {
    private ByteBuffer _buffer;
    private boolean _closed;
    private int _current_block_count;
    private int _current_offset;
    private Iterator<ByteBuffer> _data;
    private final POIFSDocument _document;
    private final int _document_size;
    private int _marked_offset;
    private int _marked_offset_count;

    public DocumentInputStream(DocumentEntry r5) {
        DocumentEntry r6 = (DocumentEntry) ZeusTransformUtils.wrapperContextForParams(r5, DocumentEntry.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, DocumentNode.class) == false) goto L7;
        this._current_offset = 0;
        this._current_block_count = 0;
        this._marked_offset = 0;
        this._marked_offset_count = 0;
        this._document_size = r6.getSize();
        this._closed = false;
        DocumentNode r7 = (DocumentNode) ZeusTransformUtils.preCheckCast(r6, DocumentNode.class, "com.obric.memorydata.plugin");
        POIFSDocument r2 = new POIFSDocument((DocumentProperty) ZeusTransformUtils.preCheckCast(r7.getProperty(), DocumentProperty.class, "com.obric.memorydata.plugin"), ((DirectoryNode) ZeusTransformUtils.preCheckCast(r7.getParent(), DirectoryNode.class, "com.obric.memorydata.plugin")).getFileSystem());
        this._document = r2;
        this._data = r2.getBlockIterator();
        return;
    L7:
        throw new IOException("Cannot open internal document storage, " + r6 + " not a Document Node");
    }

    private boolean atEOD() {
        if (this._current_offset != this._document_size) goto L5;
        return true;
    L5:
        return false;
    }

    private void checkAvaliable(int r4) {
        if (this._closed == true) goto L10;
        if (r4 > (this._document_size - this._current_offset)) goto L8;
        return;
    L8:
        throw new IllegalStateException("Buffer underrun - requested " + r4 + " bytes but " + (this._document_size - this._current_offset) + " was available");
    L10:
        throw new IllegalStateException("cannot perform requested operation on a closed stream");
    }

    private void dieIfClosed() {
        if (this._closed == true) goto L6;
        return;
    L6:
        throw new IOException("cannot perform requested operation on a closed stream");
    }

    private int remainingBytes() {
        if (this._closed == true) goto L7;
        return this._document_size - this._current_offset;
    L7:
        throw new IllegalStateException("cannot perform requested operation on a closed stream");
    }

    @Override // java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        return remainingBytes();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this._closed = true;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
        this._marked_offset = this._current_offset;     // Catch: Throwable -> L6
        this._marked_offset_count = Math.max(0, this._current_block_count - 1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        dieIfClosed();
        if (atEOD() == false) goto L5;
        return -1;
    L5:
        byte[] r2 = new byte[1];
        if (read(r2, 0, 1) != (-1)) goto L9;
        return -1;
    L9:
        return r2[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        dieIfClosed();
        if (r3 == null) goto L20;
        if (r4 < 0) goto L18;
        if (r5 < 0) goto L18;
        if (r3.length < (r4 + r5)) goto L18;
        if (r5 != 0) goto L12;
        return 0;
    L12:
        if (atEOD() == false) goto L15;
        return -1;
    L15:
        int r6 = Math.min(remainingBytes(), r5);
        readFully(r3, r4, r6);
        return r6;
    L18:
        throw new IndexOutOfBoundsException("can't read past buffer boundaries");
    L20:
        throw new IllegalArgumentException("buffer must not be null");
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        return (byte) readUByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] r3) {
        readFully(r3, 0, r3.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] r5, int r6, int r7) {
        if (r7 < 0) goto L13;
        checkAvaliable(r7);
        int r0 = 0;
    L4:
        if (r0 >= r7) goto L11;
        ByteBuffer r1 = this._buffer;
        if (r1 != null) goto L8;
    L9:
        this._current_block_count++;
        this._buffer = (ByteBuffer) ZeusTransformUtils.preCheckCast(this._data.next(), ByteBuffer.class, "com.obric.memorydata.plugin");
    L10:
        int r2 = Math.min(r7 - r0, this._buffer.remaining());
        this._buffer.get(r5, r6 + r0, r2);
        this._current_offset += r2;
        r0 = r0 + r2;
        goto L4
    L8:
        if (r1.remaining() != 0) goto L10;
    L11:
        return;
    L13:
        throw new IllegalArgumentException("Can't read negative number of bytes, but had: " + r7);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkAvaliable(4);
        byte[] r1 = new byte[4];
        readFully(r1, 0, 4);
        return LittleEndian.getInt(r1);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        checkAvaliable(8);
        byte[] r1 = new byte[8];
        readFully(r1, 0, 8);
        return LittleEndian.getLong(r1, 0);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] r1, int r2, int r3) {
        readFully(r1, r2, r3);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        checkAvaliable(2);
        byte[] r1 = new byte[2];
        readFully(r1, 0, 2);
        return LittleEndian.getShort(r1);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        checkAvaliable(1);
        byte[] r1 = new byte[1];
        readFully(r1, 0, 1);
        if (r1[0] < 0) goto L7;
        return r1[0];
    L7:
        return r1[0] + 256;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        checkAvaliable(2);
        byte[] r1 = new byte[2];
        readFully(r1, 0, 2);
        return LittleEndian.getUShort(r1);
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        int r0 = this._marked_offset;     // Catch: Throwable -> L20
        if (r0 != 0) goto L10;
        int r1 = this._marked_offset_count;     // Catch: Throwable -> L20
        if (r1 != 0) goto L10;
        this._current_block_count = r1;     // Catch: Throwable -> L20
        this._current_offset = r0;     // Catch: Throwable -> L20
        this._data = this._document.getBlockIterator();     // Catch: Throwable -> L20
        this._buffer = null;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L10:
        this._data = this._document.getBlockIterator();     // Catch: Throwable -> L20
        int r2 = 0;
        this._current_offset = 0;     // Catch: Throwable -> L20
    L11:
        int r3 = this._marked_offset_count;     // Catch: Throwable -> L20
        if (r2 >= r3) goto L14;
        ByteBuffer r4 = (ByteBuffer) ZeusTransformUtils.preCheckCast(this._data.next(), ByteBuffer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        this._buffer = r4;     // Catch: Throwable -> L20
        this._current_offset += r4.remaining();     // Catch: Throwable -> L20
        r2 = r2 + 1;     // Catch: Throwable -> L20
        goto L11
    L14:
        this._current_block_count = r3;     // Catch: Throwable -> L20
        if (this._current_offset == this._marked_offset) goto L17;
        ByteBuffer r5 = (ByteBuffer) ZeusTransformUtils.preCheckCast(this._data.next(), ByteBuffer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        this._buffer = r5;     // Catch: Throwable -> L20
        this._current_block_count++;     // Catch: Throwable -> L20
        r5.position(r5.position() + (this._marked_offset - this._current_offset));     // Catch: Throwable -> L20
    L17:
        this._current_offset = this._marked_offset;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public long skip(long r6) {
        dieIfClosed();
        if (r6 >= 0) goto L5;
        return 0;
    L5:
        int r0 = this._current_offset;
        long r1 = ((long) r0) + r6;
        if (r1 >= r0) goto L9;
        int r7 = this._document_size;
    L8:
        r1 = r7;
    L12:
        long r2 = r1 - ((long) r0);
        readFully(IOUtils.safelyAllocate(r2, Integer.MAX_VALUE));
        return r2;
    L9:
        r7 = this._document_size;
        if (r1 <= r7) goto L12;
        goto L12
    }
}
