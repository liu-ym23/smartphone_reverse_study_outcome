package org.msgpack.core.buffer;

import java.nio.ByteBuffer;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class MessageBufferBE extends MessageBuffer {
    private MessageBufferBE(Object r10, long r11, int r12) {
        super(r10, r11, r12);
    }

    MessageBufferBE(ByteBuffer r10) {
        super(r10);
    }

    MessageBufferBE(byte[] r10, int r11, int r12) {
        super(r10, r11, r12);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public double getDouble(int r10) {
        return MessageBuffer.unsafe.getDouble(this.base, this.address + ((long) r10));
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public float getFloat(int r10) {
        return MessageBuffer.unsafe.getFloat(this.base, this.address + ((long) r10));
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public int getInt(int r10) {
        return MessageBuffer.unsafe.getInt(this.base, this.address + ((long) r10));
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public long getLong(int r10) {
        return MessageBuffer.unsafe.getLong(this.base, this.address + ((long) r10));
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public short getShort(int r10) {
        return MessageBuffer.unsafe.getShort(this.base, this.address + ((long) r10));
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putDouble(int r10, double r11) {
        MessageBuffer.unsafe.putDouble(this.base, this.address + ((long) r10), r11);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putInt(int r10, int r11) {
        MessageBuffer.unsafe.putInt(this.base, this.address + ((long) r10), r11);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putLong(int r10, long r11) {
        MessageBuffer.unsafe.putLong(this.base, this.address + ((long) r10), r11);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putShort(int r10, short r11) {
        MessageBuffer.unsafe.putShort(this.base, this.address + ((long) r10), r11);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public /* bridge */ /* synthetic */ MessageBuffer slice(int r10, int r11) {
        return slice(r10, r11);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public MessageBufferBE slice(int r10, int r11) {
        if (r10 != 0) goto L7;
        if (r11 != size()) goto L7;
        return this;
    L7:
        if ((r10 + r11) > size()) goto L9;
        boolean r12 = true;
    L10:
        Preconditions.checkArgument(r12);
        return new MessageBufferBE(this.base, this.address + ((long) r10), r11);
    L9:
        r12 = false;
        goto L10
    }
}
