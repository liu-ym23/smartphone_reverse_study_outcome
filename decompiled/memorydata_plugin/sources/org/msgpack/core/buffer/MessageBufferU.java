package org.msgpack.core.buffer;

import java.nio.ByteBuffer;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
public class MessageBufferU extends MessageBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ByteBuffer wrap;

    static {
    }

    private MessageBufferU(Object r1, long r2, int r4, ByteBuffer r5) {
        super(r1, r2, r4);
        this.wrap = r5;
    }

    MessageBufferU(ByteBuffer r1) {
        super(r1);
        this.wrap = r1.slice();
    }

    MessageBufferU(byte[] r1, int r2, int r3) {
        super(r1, r2, r3);
        this.wrap = ByteBuffer.wrap(r1, r2, r3).slice();
    }

    private void resetBufferPosition() {
        this.wrap.position(0);
        this.wrap.limit(this.size);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public byte[] array() {
        if (hasArray() == true) goto L7;
        return null;
    L7:
        return this.wrap.array();
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void copyTo(int r2, MessageBuffer r3, int r4, int r5) {
        this.wrap.position(r2);     // Catch: Throwable -> L5
        r3.putByteBuffer(r4, this.wrap, r5);     // Catch: Throwable -> L5
        resetBufferPosition();
        return;
    L5:
        th = move-exception;
        resetBufferPosition();
        throw th;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public boolean getBoolean(int r1) {
        if (this.wrap.get(r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public byte getByte(int r1) {
        return this.wrap.get(r1);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void getBytes(int r2, int r3, ByteBuffer r4) {
        this.wrap.position(r2);     // Catch: Throwable -> L5
        this.wrap.limit(r2 + r3);     // Catch: Throwable -> L5
        r4.put(this.wrap);     // Catch: Throwable -> L5
        resetBufferPosition();
        return;
    L5:
        th = move-exception;
        resetBufferPosition();
        throw th;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void getBytes(int r2, byte[] r3, int r4, int r5) {
        this.wrap.position(r2);     // Catch: Throwable -> L5
        this.wrap.get(r3, r4, r5);     // Catch: Throwable -> L5
        resetBufferPosition();
        return;
    L5:
        th = move-exception;
        resetBufferPosition();
        throw th;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public double getDouble(int r1) {
        return this.wrap.getDouble(r1);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public float getFloat(int r1) {
        return this.wrap.getFloat(r1);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public int getInt(int r1) {
        return this.wrap.getInt(r1);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public long getLong(int r1) {
        return this.wrap.getLong(r1);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public short getShort(int r1) {
        return this.wrap.getShort(r1);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public boolean hasArray() {
        return !this.wrap.isDirect();
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putBoolean(int r1, boolean r2) {
        this.wrap.put(r1, r2 ? 1 : 0);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putByte(int r1, byte r2) {
        this.wrap.put(r1, r2);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putByteBuffer(int r4, ByteBuffer r5, int r6) {
        if (r5.hasArray() == false) goto L5;
        putBytes(r4, r5.array(), r5.position() + r5.arrayOffset(), r6);
        r5.position(r5.position() + r6);
        return;
    L5:
        int r0 = r5.limit();
        r5.limit(r5.position() + r6);     // Catch: Throwable -> L9
        this.wrap.position(r4);     // Catch: Throwable -> L9
        this.wrap.put(r5);     // Catch: Throwable -> L9
        r5.limit(r0);
        return;
    L9:
        th = move-exception;
        r5.limit(r0);
        throw th;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putBytes(int r2, byte[] r3, int r4, int r5) {
        this.wrap.position(r2);     // Catch: Throwable -> L5
        this.wrap.put(r3, r4, r5);     // Catch: Throwable -> L5
        resetBufferPosition();
        return;
    L5:
        th = move-exception;
        resetBufferPosition();
        throw th;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putDouble(int r1, double r2) {
        this.wrap.putDouble(r1, r2);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putFloat(int r1, float r2) {
        this.wrap.putFloat(r1, r2);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putInt(int r1, int r2) {
        this.wrap.putInt(r1, r2);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putLong(int r1, long r2) {
        this.wrap.putLong(r1, r2);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putMessageBuffer(int r1, MessageBuffer r2, int r3, int r4) {
        putByteBuffer(r1, r2.sliceAsByteBuffer(r3, r4), r4);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putShort(int r1, short r2) {
        this.wrap.putShort(r1, r2);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public /* bridge */ /* synthetic */ MessageBuffer slice(int r1, int r2) {
        return slice(r1, r2);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public MessageBufferU slice(int r9, int r10) {
        if (r9 == 0) goto L4;
    L6:
        int r0 = r9 + r10;
        if (r0 > size()) goto L9;
        boolean r1 = true;
    L10:
        Preconditions.checkArgument(r1);
        this.wrap.position(r9);     // Catch: Throwable -> L14
        this.wrap.limit(r0);     // Catch: Throwable -> L14
        MessageBufferU r2 = new MessageBufferU(this.base, r9 + this.address, r10, this.wrap.slice());     // Catch: Throwable -> L14
        resetBufferPosition();
        return r2;
    L14:
        th = move-exception;
        resetBufferPosition();
        throw th;
    L9:
        r1 = false;
        goto L10
    L4:
        if (r10 != size()) goto L6;
        return this;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public ByteBuffer sliceAsByteBuffer() {
        return sliceAsByteBuffer(0, this.size);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public ByteBuffer sliceAsByteBuffer(int r2, int r3) {
        this.wrap.position(r2);     // Catch: Throwable -> L5
        this.wrap.limit(r2 + r3);     // Catch: Throwable -> L5
        ByteBuffer r4 = this.wrap.slice();     // Catch: Throwable -> L5
        resetBufferPosition();
        return r4;
    L5:
        th = move-exception;
        resetBufferPosition();
        throw th;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public byte[] toByteArray() {
        int r0 = size();
        byte[] r1 = new byte[r0];
        getBytes(0, r1, 0, r0);
        return r1;
    }
}
