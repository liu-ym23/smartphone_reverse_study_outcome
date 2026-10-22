package org.msgpack.core.buffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
public class OutputStreamBufferOutput implements MessageBufferOutput {
    private MessageBuffer buffer;
    private OutputStream out;

    public OutputStreamBufferOutput(OutputStream r2) {
        this(r2, 8192);
    }

    public OutputStreamBufferOutput(OutputStream r3, int r4) {
        this.out = (OutputStream) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3, "output is null"), OutputStream.class, "com.obric.memorydata.plugin");
        this.buffer = MessageBuffer.allocate(r4);
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void add(byte[] r1, int r2, int r3) {
        write(r1, r2, r3);
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
    public MessageBuffer next(int r2) {
        if (this.buffer.size() >= r2) goto L6;
        this.buffer = MessageBuffer.allocate(r2);
    L6:
        return this.buffer;
    }

    public OutputStream reset(OutputStream r2) {
        OutputStream r0 = this.out;
        this.out = r2;
        return r0;
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void write(byte[] r1, int r2, int r3) {
        this.out.write(r1, r2, r3);
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void writeBuffer(int r3) {
        write(this.buffer.array(), this.buffer.arrayOffset(), r3);
    }
}
