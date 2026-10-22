package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int r5) {
        return this.buffer[r5];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int r5) {
        if (this.buffer[r5] == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int r5) {
        return Double.longBitsToDouble(getLong(r5));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int r5) {
        return Float.intBitsToFloat(getInt(r5));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int r5) {
        byte[] r10 = this.buffer;
        int r11 = ((r10[r5 + 3] << 24) | ((r10[r5 + 2] & UByte.MAX_VALUE) << 16)) | ((r10[r5 + 1] & UByte.MAX_VALUE) << 8);
        return (r10[r5] & UByte.MAX_VALUE) | r11;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int r10) {
        byte[] r11 = this.buffer;
        long r5 = ((((long) r11[r10]) & 255) | ((((long) r11[r10 + 1]) & 255) << 8)) | ((((long) r11[r10 + 2]) & 255) << 16);
        long r12 = r5 | ((((long) r11[r10 + 3]) & 255) << 24);
        long r13 = r12 | ((((long) r11[r10 + 4]) & 255) << 32);
        int r14 = r10 + 6;
        long r15 = r13 | ((((long) r11[r10 + 5]) & 255) << 40);
        long r16 = r15 | ((((long) r11[r14]) & 255) << 48);
        return (((long) r11[r10 + 7]) << 56) | r16;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int r5) {
        byte[] r10 = this.buffer;
        int r11 = r10[r5 + 1] << 8;
        return (short) ((r10[r5] & UByte.MAX_VALUE) | r11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int r5, int r10) {
        return Utf8Safe.decodeUtf8Array(this.buffer, r5, r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] r5, int r10, int r11) {
        set(this.writePos, r5, r10, r11);
        this.writePos += r11;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean r5) {
        setBoolean(this.writePos, r5);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double r5) {
        setDouble(this.writePos, r5);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float r5) {
        setFloat(this.writePos, r5);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int r5) {
        setInt(this.writePos, r5);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long r5) {
        setLong(this.writePos, r5);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short r5) {
        setShort(this.writePos, r5);
        this.writePos += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int r5) {
        byte[] r10 = this.buffer;
        if (r10.length <= r5) goto L5;
        return true;
    L5:
        int r11 = r10.length;
        this.buffer = Arrays.copyOf(r10, r11 + (r11 >> 1));
        return true;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r5, byte r10) {
        requestCapacity(r5 + 1);
        this.buffer[r5] = r10;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int r5, boolean r10) {
        set(r5, r10 ? 1 : 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int r5, double r10) {
        requestCapacity(r5 + 8);
        long r11 = Double.doubleToRawLongBits(r10);
        int r12 = (int) r11;
        byte[] r13 = this.buffer;
        r13[r5] = (byte) (r12 & 255);
        r13[r5 + 1] = (byte) ((r12 >> 8) & 255);
        r13[r5 + 2] = (byte) ((r12 >> 16) & 255);
        r13[r5 + 3] = (byte) ((r12 >> 24) & 255);
        int r14 = (int) (r11 >> 32);
        r13[r5 + 4] = (byte) (r14 & 255);
        int r15 = r5 + 6;
        r13[r5 + 5] = (byte) ((r14 >> 8) & 255);
        r13[r15] = (byte) ((r14 >> 16) & 255);
        r13[r5 + 7] = (byte) ((r14 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int r5, float r10) {
        requestCapacity(r5 + 4);
        int r11 = Float.floatToRawIntBits(r10);
        byte[] r12 = this.buffer;
        r12[r5] = (byte) (r11 & 255);
        int r13 = r5 + 2;
        r12[r5 + 1] = (byte) ((r11 >> 8) & 255);
        r12[r13] = (byte) ((r11 >> 16) & 255);
        r12[r5 + 3] = (byte) ((r11 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int r5, int r10) {
        requestCapacity(r5 + 4);
        byte[] r11 = this.buffer;
        r11[r5] = (byte) (r10 & 255);
        int r12 = r5 + 2;
        r11[r5 + 1] = (byte) ((r10 >> 8) & 255);
        r11[r12] = (byte) ((r10 >> 16) & 255);
        r11[r5 + 3] = (byte) ((r10 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int r5, long r10) {
        requestCapacity(r5 + 8);
        int r11 = (int) r10;
        byte[] r12 = this.buffer;
        r12[r5] = (byte) (r11 & 255);
        r12[r5 + 1] = (byte) ((r11 >> 8) & 255);
        r12[r5 + 2] = (byte) ((r11 >> 16) & 255);
        r12[r5 + 3] = (byte) ((r11 >> 24) & 255);
        int r13 = (int) (r10 >> 32);
        r12[r5 + 4] = (byte) (r13 & 255);
        int r14 = r5 + 6;
        r12[r5 + 5] = (byte) ((r13 >> 8) & 255);
        r12[r14] = (byte) ((r13 >> 16) & 255);
        r12[r5 + 7] = (byte) ((r13 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int r5, short r10) {
        requestCapacity(r5 + 2);
        byte[] r11 = this.buffer;
        r11[r5] = (byte) (r10 & 255);
        r11[r5 + 1] = (byte) ((r10 >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(int r5) {
        this(new byte[r5]);
    }

    public ArrayReadWriteBuf(byte[] r5) {
        this.buffer = r5;
        this.writePos = 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte r5) {
        set(this.writePos, r5);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r5, byte[] r10, int r11, int r12) {
        requestCapacity((r12 - r11) + r5);
        System.arraycopy(r10, r11, this.buffer, r5, r12);
    }

    public ArrayReadWriteBuf(byte[] r5, int r10) {
        this.buffer = r5;
        this.writePos = r10;
    }
}
