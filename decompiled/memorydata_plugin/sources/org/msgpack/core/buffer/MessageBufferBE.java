package org.msgpack.core.buffer;

import java.nio.ByteBuffer;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
public class MessageBufferBE extends MessageBuffer {
    private MessageBufferBE(Object r1, long r2, int r4) {
        super(r1, r2, r4);
    }

    MessageBufferBE(ByteBuffer r1) {
        super(r1);
    }

    MessageBufferBE(byte[] r1, int r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public double getDouble(int r5) {
        return unsafe.getDouble(this.base, this.address + ((long) r5));
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public float getFloat(int r5) {
        return unsafe.getFloat(this.base, this.address + ((long) r5));
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public int getInt(int r5) {
        return unsafe.getInt(this.base, this.address + ((long) r5));
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public long getLong(int r5) {
        return unsafe.getLong(this.base, this.address + ((long) r5));
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public short getShort(int r5) {
        return unsafe.getShort(this.base, this.address + ((long) r5));
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putDouble(int r7, double r8) {
        unsafe.putDouble(this.base, this.address + ((long) r7), r8);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putInt(int r5, int r6) {
        unsafe.putInt(this.base, this.address + ((long) r5), r6);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putLong(int r7, long r8) {
        unsafe.putLong(this.base, this.address + ((long) r7), r8);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putShort(int r5, short r6) {
        unsafe.putShort(this.base, this.address + ((long) r5), r6);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public /* bridge */ /* synthetic */ MessageBuffer slice(int r1, int r2) {
        return slice(r1, r2);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public MessageBufferBE slice(int r5, int r6) {
        if (r5 != 0) goto L7;
        if (r6 != size()) goto L7;
        return this;
    L7:
        if ((r5 + r6) > size()) goto L9;
        boolean r0 = true;
    L10:
        Preconditions.checkArgument(r0);
        return new MessageBufferBE(this.base, this.address + ((long) r5), r6);
    L9:
        r0 = false;
        goto L10
    }
}
