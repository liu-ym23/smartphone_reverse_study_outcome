package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer buffer;

    public ByteBufferReadWriteBuf(ByteBuffer r10) {
        this.buffer = r10;
        r10.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer.array();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int r10) {
        return this.buffer.get(r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int r10) {
        if (get(r10) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int r10) {
        return this.buffer.getDouble(r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int r10) {
        return this.buffer.getFloat(r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int r10) {
        return this.buffer.getInt(r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int r10) {
        return this.buffer.getLong(r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int r10) {
        return this.buffer.getShort(r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int r10, int r11) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, r10, r11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.buffer.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte r10) {
        this.buffer.put(r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] r10, int r11, int r12) {
        this.buffer.put(r10, r11, r12);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean r10) {
        this.buffer.put(r10 ? 1 : 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double r10) {
        this.buffer.putDouble(r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float r10) {
        this.buffer.putFloat(r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int r10) {
        this.buffer.putInt(r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long r10) {
        this.buffer.putLong(r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short r10) {
        this.buffer.putShort(r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int r10) {
        if (r10 > this.buffer.limit()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r10, byte r11) {
        requestCapacity(r10 + 1);
        this.buffer.put(r10, r11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r10, byte[] r11, int r12, int r13) {
        requestCapacity((r13 - r12) + r10);
        int r14 = this.buffer.position();
        this.buffer.position(r10);
        this.buffer.put(r11, r12, r13);
        this.buffer.position(r14);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int r10, boolean r11) {
        set(r10, r11 ? 1 : 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int r10, double r11) {
        requestCapacity(r10 + 8);
        this.buffer.putDouble(r10, r11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int r10, float r11) {
        requestCapacity(r10 + 4);
        this.buffer.putFloat(r10, r11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int r10, int r11) {
        requestCapacity(r10 + 4);
        this.buffer.putInt(r10, r11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int r10, long r11) {
        requestCapacity(r10 + 8);
        this.buffer.putLong(r10, r11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int r10, short r11) {
        requestCapacity(r10 + 2);
        this.buffer.putShort(r10, r11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.buffer.position();
    }
}
