package org.msgpack.core.buffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ArrayBufferOutput implements MessageBufferOutput {
    private final int bufferSize;
    private MessageBuffer lastBuffer;
    private final List<MessageBuffer> list;

    public ArrayBufferOutput() {
        this(8192);
    }

    public ArrayBufferOutput(int r1) {
        this.bufferSize = r1;
        this.list = new ArrayList();
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void add(byte[] r1, int r2, int r3) {
        MessageBuffer r4 = MessageBuffer.wrap(r1, r2, r3);
        this.list.add(r4);
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
        Iterator<MessageBuffer> r4 = this.list.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((MessageBuffer) ZeusTransformUtils.preCheckCast(r4.next(), MessageBuffer.class, "com.obric.memorydata.plugin")).size();
        goto L4
    L6:
        return r0;
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public MessageBuffer next(int r2) {
        MessageBuffer r0 = this.lastBuffer;
        if (r0 != null) goto L5;
    L8:
        MessageBuffer r3 = MessageBuffer.allocate(Math.max(this.bufferSize, r2));
        this.lastBuffer = r3;
        return r3;
    L5:
        if (r0.size() <= r2) goto L8;
        return this.lastBuffer;
    }

    public List<MessageBuffer> toBufferList() {
        return new ArrayList(this.list);
    }

    public byte[] toByteArray() {
        byte[] r0 = new byte[getSize()];
        Iterator<MessageBuffer> r6 = this.list.iterator();
        int r2 = 0;
    L4:
        if (r6.hasNext() == false) goto L6;
        MessageBuffer r3 = (MessageBuffer) ZeusTransformUtils.preCheckCast(r6.next(), MessageBuffer.class, "com.obric.memorydata.plugin");
        r3.getBytes(0, r0, r2, r3.size());
        r2 = r2 + r3.size();
        goto L4
    L6:
        return r0;
    }

    public MessageBuffer toMessageBuffer() {
        if (this.list.size() != 1) goto L7;
        return (MessageBuffer) ZeusTransformUtils.preCheckCast(this.list.get(0), MessageBuffer.class, "com.obric.memorydata.plugin");
    L7:
        if (this.list.isEmpty() == false) goto L11;
        return MessageBuffer.allocate(0);
    L11:
        return MessageBuffer.wrap(toByteArray());
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void write(byte[] r3, int r4, int r5) {
        MessageBuffer r0 = MessageBuffer.allocate(r5);
        r0.putBytes(0, r3, r4, r5);
        this.list.add(r0);
    }

    @Override // org.msgpack.core.buffer.MessageBufferOutput
    public void writeBuffer(int r4) {
        this.list.add(this.lastBuffer.slice(0, r4));
        if ((this.lastBuffer.size() - r4) <= (this.bufferSize / 4)) goto L5;
        MessageBuffer r0 = this.lastBuffer;
        MessageBuffer r5 = r0.slice(r4, r0.size() - r4);
    L6:
        this.lastBuffer = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }
}
