package org.msgpack.core.buffer;

import java.io.OutputStream;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class OutputStreamBufferOutput implements MessageBufferOutput {
    private MessageBuffer buffer;
    private OutputStream out;

    public OutputStreamBufferOutput(OutputStream r10) {
        this(r10, 8192);
    }

    public OutputStreamBufferOutput(OutputStream r10, int r11) {
        this.out = (OutputStream) Preconditions.checkNotNull(r10, "output is null");
        this.buffer = MessageBuffer.allocate(r11);
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void add(byte[] r10, int r11, int r12) {
        write(r10, r11, r12);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.out.flush();
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public MessageBuffer next(int r10) {
        if (this.buffer.size() >= r10) goto L6;
        this.buffer = MessageBuffer.allocate(r10);
    L6:
        return this.buffer;
    }

    public OutputStream reset(OutputStream r10) {
        OutputStream r11 = this.out;
        this.out = r10;
        return r11;
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void write(byte[] r10, int r11, int r12) {
        this.out.write(r10, r11, r12);
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void writeBuffer(int r10) {
        write(this.buffer.array(), this.buffer.arrayOffset(), r10);
    }
}
