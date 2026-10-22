package org.msgpack.core.buffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayBufferOutput implements MessageBufferOutput {
    private final int bufferSize;
    private MessageBuffer lastBuffer;
    private final List<MessageBuffer> list;

    public ArrayBufferOutput() {
        this(8192);
    }

    public ArrayBufferOutput(int r10) {
        this.bufferSize = r10;
        this.list = new ArrayList();
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void add(byte[] r10, int r11, int r12) {
        MessageBuffer r13 = MessageBuffer.wrap(r10, r11, r12);
        this.list.add(r13);
    }

    public void clear() {
        this.list.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int getSize() {
        Iterator<MessageBuffer> r10 = this.list.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 + r10.next().size();
        goto L4
    L6:
        return r11;
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public MessageBuffer next(int r10) {
        MessageBuffer r11 = this.lastBuffer;
        if (r11 != null) goto L5;
    L8:
        MessageBuffer r12 = MessageBuffer.allocate(Math.max(this.bufferSize, r10));
        this.lastBuffer = r12;
        return r12;
    L5:
        if (r11.size() <= r10) goto L8;
        return this.lastBuffer;
    }

    public List<MessageBuffer> toBufferList() {
        return new ArrayList(this.list);
    }

    public byte[] toByteArray() {
        byte[] r10 = new byte[getSize()];
        Iterator<MessageBuffer> r11 = this.list.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        MessageBuffer r13 = r11.next();
        r13.getBytes(0, r10, r12, r13.size());
        r12 = r12 + r13.size();
        goto L4
    L6:
        return r10;
    }

    public MessageBuffer toMessageBuffer() {
        if (this.list.size() != 1) goto L7;
        return this.list.get(0);
    L7:
        if (this.list.isEmpty() == false) goto L11;
        return MessageBuffer.allocate(0);
    L11:
        return MessageBuffer.wrap(toByteArray());
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void write(byte[] r10, int r11, int r12) {
        MessageBuffer r13 = MessageBuffer.allocate(r12);
        r13.putBytes(0, r10, r11, r12);
        this.list.add(r13);
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void writeBuffer(int r10) {
        this.list.add(this.lastBuffer.slice(0, r10));
        if ((this.lastBuffer.size() - r10) <= (this.bufferSize / 4)) goto L5;
        MessageBuffer r11 = this.lastBuffer;
        MessageBuffer r12 = r11.slice(r10, r11.size() - r10);
    L6:
        this.lastBuffer = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }
}
