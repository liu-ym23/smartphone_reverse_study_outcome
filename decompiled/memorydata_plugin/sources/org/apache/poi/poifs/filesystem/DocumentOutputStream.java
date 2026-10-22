package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.poifs.property.DocumentProperty;

/* JADX INFO: loaded from: classes7.dex */
public final class DocumentOutputStream extends OutputStream {
    private UnsynchronizedByteArrayOutputStream _buffer;
    private boolean _closed;
    private final POIFSDocument _document;
    private int _document_size;
    private final long _limit;
    private final DocumentProperty _property;
    private POIFSStream _stream;
    private OutputStream _stream_output;

    DocumentOutputStream(POIFSDocument r3, long r4) {
        this._document_size = 0;
        this._closed = false;
        this._buffer = new UnsynchronizedByteArrayOutputStream(4096);
        this._document = r3;
        r3.free();
        this._property = r3.getDocumentProperty();
        this._limit = r4;
    }

    private void checkBufferSize() {
        if (this._buffer.size() <= 4096) goto L6;
        byte[] r0 = this._buffer.toByteArray();
        this._buffer = null;
        write(r0, 0, r0.length);
        return;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        UnsynchronizedByteArrayOutputStream r0 = this._buffer;
        if (r0 == null) goto L5;
        this._document.replaceContents(r0.toInputStream());
    L6:
        this._closed = true;
        return;
    L5:
        this._stream_output.close();
        this._property.updateSize(this._document_size);
        this._property.setStartBlock(this._stream.getStartBlock());
        goto L6
    }

    public long size() {
        long r0 = this._document_size;
        UnsynchronizedByteArrayOutputStream r4 = this._buffer;
        if (r4 != null) goto L5;
        long r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r4.size();
        goto L7
    }

    @Override // java.io.OutputStream
    public void write(int r4) {
        write(new byte[]{(byte) r4}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r5, int r6, int r7) {
        if (this._closed == true) goto L20;
        if (this._limit > (-1)) goto L7;
    L11:
        UnsynchronizedByteArrayOutputStream r0 = this._buffer;
        if (r0 == null) goto L15;
        r0.write(r5, r6, r7);
        checkBufferSize();
        return;
    L15:
        if (this._stream != null) goto L17;
        POIFSStream r1 = new POIFSStream(this._document.getFileSystem());
        this._stream = r1;
        this._stream_output = r1.getOutputStream();
    L17:
        this._stream_output.write(r5, r6, r7);
        this._document_size += r7;
        return;
    L7:
        if ((size() + ((long) r7)) <= this._limit) goto L11;
        throw new IOException("tried to write too much data");
    L20:
        throw new IOException("cannot perform requested operation on a closed stream");
    }
}
