package org.msgpack.core.buffer;

import java.nio.ByteBuffer;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class MessageBufferU extends MessageBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ByteBuffer wrap;

    static {
    }

    private MessageBufferU(Object r10, long r11, int r12, ByteBuffer r13) {
        super(r10, r11, r12);
        this.wrap = r13;
    }

    MessageBufferU(ByteBuffer r10) {
        super(r10);
        this.wrap = r10.slice();
    }

    MessageBufferU(byte[] r10, int r11, int r12) {
        super(r10, r11, r12);
        this.wrap = ByteBuffer.wrap(r10, r11, r12).slice();
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
    public void copyTo(int r10, MessageBuffer r11, int r12, int r13) {
        this.wrap.position(r10);     // Catch: Throwable -> L5
        r11.putByteBuffer(r12, this.wrap, r13);     // Catch: Throwable -> L5
        resetBufferPosition();
        return;
    L5:
        th = move-exception;
        resetBufferPosition();
        throw th;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public boolean getBoolean(int r10) {
        if (this.wrap.get(r10) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public byte getByte(int r10) {
        return this.wrap.get(r10);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void getBytes(int r10, int r11, ByteBuffer r12) {
        this.wrap.position(r10);     // Catch: Throwable -> L5
        this.wrap.limit(r10 + r11);     // Catch: Throwable -> L5
        r12.put(this.wrap);     // Catch: Throwable -> L5
        resetBufferPosition();
        return;
    L5:
        th = move-exception;
        resetBufferPosition();
        throw th;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void getBytes(int r10, byte[] r11, int r12, int r13) {
        this.wrap.position(r10);     // Catch: Throwable -> L5
        this.wrap.get(r11, r12, r13);     // Catch: Throwable -> L5
        resetBufferPosition();
        return;
    L5:
        th = move-exception;
        resetBufferPosition();
        throw th;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public double getDouble(int r10) {
        return this.wrap.getDouble(r10);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public float getFloat(int r10) {
        return this.wrap.getFloat(r10);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public int getInt(int r10) {
        return this.wrap.getInt(r10);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public long getLong(int r10) {
        return this.wrap.getLong(r10);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public short getShort(int r10) {
        return this.wrap.getShort(r10);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public boolean hasArray() {
        return !this.wrap.isDirect();
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putBoolean(int r10, boolean r11) {
        this.wrap.put(r10, r11 ? 1 : 0);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putByte(int r10, byte r11) {
        this.wrap.put(r10, r11);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putByteBuffer(int r10, ByteBuffer r11, int r12) {
        if (r11.hasArray() == false) goto L5;
        putBytes(r10, r11.array(), r11.position() + r11.arrayOffset(), r12);
        r11.position(r11.position() + r12);
        return;
    L5:
        int r13 = r11.limit();
        r11.limit(r11.position() + r12);     // Catch: Throwable -> L9
        this.wrap.position(r10);     // Catch: Throwable -> L9
        this.wrap.put(r11);     // Catch: Throwable -> L9
        r11.limit(r13);
        return;
    L9:
        th = move-exception;
        r11.limit(r13);
        throw th;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putBytes(int r10, byte[] r11, int r12, int r13) {
        this.wrap.position(r10);     // Catch: Throwable -> L5
        this.wrap.put(r11, r12, r13);     // Catch: Throwable -> L5
        resetBufferPosition();
        return;
    L5:
        th = move-exception;
        resetBufferPosition();
        throw th;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putDouble(int r10, double r11) {
        this.wrap.putDouble(r10, r11);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putFloat(int r10, float r11) {
        this.wrap.putFloat(r10, r11);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putInt(int r10, int r11) {
        this.wrap.putInt(r10, r11);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putLong(int r10, long r11) {
        this.wrap.putLong(r10, r11);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putMessageBuffer(int r10, MessageBuffer r11, int r12, int r13) {
        putByteBuffer(r10, r11.sliceAsByteBuffer(r12, r13), r13);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putShort(int r10, short r11) {
        this.wrap.putShort(r10, r11);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public /* bridge */ /* synthetic */ MessageBuffer slice(int r10, int r11) {
        return slice(r10, r11);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public MessageBufferU slice(int r10, int r11) {
        if (r10 == 0) goto L4;
    L6:
        int r12 = r10 + r11;
        if (r12 > size()) goto L9;
        boolean r13 = true;
    L10:
        Preconditions.checkArgument(r13);
        this.wrap.position(r10);     // Catch: Throwable -> L14
        this.wrap.limit(r12);     // Catch: Throwable -> L14
        MessageBufferU r14 = new MessageBufferU(this.base, r10 + this.address, r11, this.wrap.slice());     // Catch: Throwable -> L14
        resetBufferPosition();
        return r14;
    L14:
        th = move-exception;
        resetBufferPosition();
        throw th;
    L9:
        r13 = false;
        goto L10
    L4:
        if (r11 != size()) goto L6;
        return this;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public ByteBuffer sliceAsByteBuffer() {
        return sliceAsByteBuffer(0, this.size);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public ByteBuffer sliceAsByteBuffer(int r10, int r11) {
        this.wrap.position(r10);     // Catch: Throwable -> L5
        this.wrap.limit(r10 + r11);     // Catch: Throwable -> L5
        ByteBuffer r12 = this.wrap.slice();     // Catch: Throwable -> L5
        resetBufferPosition();
        return r12;
    L5:
        th = move-exception;
        resetBufferPosition();
        throw th;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public byte[] toByteArray() {
        int r10 = size();
        byte[] r11 = new byte[r10];
        getBytes(0, r11, 0, r10);
        return r11;
    }
}
