package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    public ArrayReadWriteBuf(int r10) {
        this(new byte[r10]);
    }

    public ArrayReadWriteBuf(byte[] r10) {
        this.buffer = r10;
        this.writePos = 0;
    }

    public ArrayReadWriteBuf(byte[] r10, int r11) {
        this.buffer = r10;
        this.writePos = r11;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int r10) {
        return this.buffer[r10];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int r10) {
        if (this.buffer[r10] == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int r10) {
        return Double.longBitsToDouble(getLong(r10));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int r10) {
        return Float.intBitsToFloat(getInt(r10));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int r10) {
        byte[] r11 = this.buffer;
        int r12 = ((r11[r10 + 3] << 24) | ((r11[r10 + 2] & 255) << 16)) | ((r11[r10 + 1] & 255) << 8);
        return (r11[r10] & 255) | r12;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int r10) {
        byte[] r11 = this.buffer;
        int r12 = r10 + 1;
        long r13 = ((long) r11[r10]) & 255;
        int r14 = r12 + 1;
        int r15 = r14 + 1;
        long r16 = (r13 | ((((long) r11[r12]) & 255) << 8)) | ((((long) r11[r14]) & 255) << 16);
        int r17 = r15 + 1;
        long r18 = r16 | ((((long) r11[r15]) & 255) << 24);
        int r19 = r17 + 1;
        long r20 = r18 | ((((long) r11[r17]) & 255) << 32);
        int r21 = r19 + 1;
        long r22 = r20 | ((((long) r11[r19]) & 255) << 40);
        int r23 = r21 + 1;
        long r24 = r22 | ((255 & ((long) r11[r21])) << 48);
        return (((long) r11[r23]) << 56) | r24;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int r10) {
        byte[] r11 = this.buffer;
        int r12 = r11[r10 + 1] << 8;
        return (short) ((r11[r10] & 255) | r12);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int r10, int r11) {
        return Utf8Safe.decodeUtf8Array(this.buffer, r10, r11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte r10) {
        set(this.writePos, r10);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] r10, int r11, int r12) {
        set(this.writePos, r10, r11, r12);
        this.writePos += r12;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean r10) {
        setBoolean(this.writePos, r10);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double r10) {
        setDouble(this.writePos, r10);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float r10) {
        setFloat(this.writePos, r10);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int r10) {
        setInt(this.writePos, r10);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long r10) {
        setLong(this.writePos, r10);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short r10) {
        setShort(this.writePos, r10);
        this.writePos += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int r10) {
        byte[] r11 = this.buffer;
        if (r11.length <= r10) goto L5;
        return true;
    L5:
        int r12 = r11.length;
        this.buffer = Arrays.copyOf(r11, r12 + (r12 >> 1));
        return true;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r10, byte r11) {
        requestCapacity(r10 + 1);
        this.buffer[r10] = r11;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r10, byte[] r11, int r12, int r13) {
        requestCapacity((r13 - r12) + r10);
        System.arraycopy(r11, r12, this.buffer, r10, r13);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int r10, boolean r11) {
        set(r10, r11 ? 1 : 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int r10, double r11) {
        requestCapacity(r10 + 8);
        long r12 = Double.doubleToRawLongBits(r11);
        int r13 = (int) r12;
        byte[] r14 = this.buffer;
        int r15 = r10 + 1;
        r14[r10] = (byte) (r13 & 255);
        int r16 = r15 + 1;
        r14[r15] = (byte) ((r13 >> 8) & 255);
        int r17 = r16 + 1;
        r14[r16] = (byte) ((r13 >> 16) & 255);
        int r18 = r17 + 1;
        r14[r17] = (byte) ((r13 >> 24) & 255);
        int r19 = (int) (r12 >> 32);
        int r20 = r18 + 1;
        r14[r18] = (byte) (r19 & 255);
        int r21 = r20 + 1;
        r14[r20] = (byte) ((r19 >> 8) & 255);
        r14[r21] = (byte) ((r19 >> 16) & 255);
        r14[r21 + 1] = (byte) ((r19 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int r10, float r11) {
        requestCapacity(r10 + 4);
        int r12 = Float.floatToRawIntBits(r11);
        byte[] r13 = this.buffer;
        int r14 = r10 + 1;
        r13[r10] = (byte) (r12 & 255);
        int r15 = r14 + 1;
        r13[r14] = (byte) ((r12 >> 8) & 255);
        r13[r15] = (byte) ((r12 >> 16) & 255);
        r13[r15 + 1] = (byte) ((r12 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int r10, int r11) {
        requestCapacity(r10 + 4);
        byte[] r12 = this.buffer;
        int r13 = r10 + 1;
        r12[r10] = (byte) (r11 & 255);
        int r14 = r13 + 1;
        r12[r13] = (byte) ((r11 >> 8) & 255);
        r12[r14] = (byte) ((r11 >> 16) & 255);
        r12[r14 + 1] = (byte) ((r11 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int r10, long r11) {
        requestCapacity(r10 + 8);
        int r12 = (int) r11;
        byte[] r13 = this.buffer;
        int r14 = r10 + 1;
        r13[r10] = (byte) (r12 & 255);
        int r15 = r14 + 1;
        r13[r14] = (byte) ((r12 >> 8) & 255);
        int r16 = r15 + 1;
        r13[r15] = (byte) ((r12 >> 16) & 255);
        int r17 = r16 + 1;
        r13[r16] = (byte) ((r12 >> 24) & 255);
        int r18 = (int) (r11 >> 32);
        int r19 = r17 + 1;
        r13[r17] = (byte) (r18 & 255);
        int r20 = r19 + 1;
        r13[r19] = (byte) ((r18 >> 8) & 255);
        r13[r20] = (byte) ((r18 >> 16) & 255);
        r13[r20 + 1] = (byte) ((r18 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int r10, short r11) {
        requestCapacity(r10 + 2);
        byte[] r12 = this.buffer;
        r12[r10] = (byte) (r11 & 255);
        r12[r10 + 1] = (byte) ((r11 >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }
}
