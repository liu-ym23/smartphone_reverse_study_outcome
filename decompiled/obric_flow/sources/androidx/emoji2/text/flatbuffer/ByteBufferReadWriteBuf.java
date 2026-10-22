package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer buffer;

    public ByteBufferReadWriteBuf(ByteBuffer r5) {
        this.buffer = r5;
        r5.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer.array();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int r5) {
        return this.buffer.get(r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int r5) {
        if (get(r5) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int r5) {
        return this.buffer.getDouble(r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int r5) {
        return this.buffer.getFloat(r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int r5) {
        return this.buffer.getInt(r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int r5) {
        return this.buffer.getLong(r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int r5) {
        return this.buffer.getShort(r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int r5, int r10) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, r5, r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.buffer.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] r5, int r10, int r11) {
        this.buffer.put(r5, r10, r11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean r5) {
        this.buffer.put(r5 ? 1 : 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double r5) {
        this.buffer.putDouble(r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float r5) {
        this.buffer.putFloat(r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int r5) {
        this.buffer.putInt(r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long r5) {
        this.buffer.putLong(r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short r5) {
        this.buffer.putShort(r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int r5) {
        if (r5 > this.buffer.limit()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r5, byte r10) {
        requestCapacity(r5 + 1);
        this.buffer.put(r5, r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int r5, boolean r10) {
        set(r5, r10 ? 1 : 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int r5, double r10) {
        requestCapacity(r5 + 8);
        this.buffer.putDouble(r5, r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int r5, float r10) {
        requestCapacity(r5 + 4);
        this.buffer.putFloat(r5, r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int r5, int r10) {
        requestCapacity(r5 + 4);
        this.buffer.putInt(r5, r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int r5, long r10) {
        requestCapacity(r5 + 8);
        this.buffer.putLong(r5, r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int r5, short r10) {
        requestCapacity(r5 + 2);
        this.buffer.putShort(r5, r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.buffer.position();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte r5) {
        this.buffer.put(r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r5, byte[] r10, int r11, int r12) {
        requestCapacity((r12 - r11) + r5);
        int r13 = this.buffer.position();
        this.buffer.position(r5);
        this.buffer.put(r10, r11, r12);
        this.buffer.position(r13);
    }
}
