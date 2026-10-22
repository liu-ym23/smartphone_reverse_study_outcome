package com.bytedance.crash.protector;

/* JADX INFO: loaded from: classes.dex */
public class BufferWriter {
    private byte[] buf;
    private int index;

    public BufferWriter() {
        this(512);
    }

    public BufferWriter(int r10) {
        this.buf = null;
        this.index = 0;
        if (r10 <= 0) goto L6;
        this.buf = new byte[r10];
        return;
    }

    private void ensureSpace(int r10) {
        if (remaining() >= r10) goto L6;
        int r11 = this.buf.length;
        byte[] r12 = new byte[r11 + Math.max(r11, r10)];
        System.arraycopy(this.buf, 0, r12, 0, this.index);
        this.buf = r12;
        return;
    }

    public void align(int r10) {
        int r11 = this.index;
        int r12 = ((((r11 + r10) - 1) / r10) * r10) - r11;
        ensureSpace(r12);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        byte[] r14 = this.buf;
        int r15 = this.index;
        this.index = r15 + 1;
        r14[r15] = 0;
        r13 = r13 + 1;
        goto L3
    }

    public byte[] data() {
        return this.buf;
    }

    public int position() {
        return this.index;
    }

    public int prependInt32(int r10) {
        align(4);
        int r11 = position();
        writeInt32(r10);
        return r11;
    }

    public int remaining() {
        return this.buf.length - this.index;
    }

    public void setPosition(int r10) {
        this.index = r10;
    }

    public void write(byte[] r10) {
        write(r10, 0, r10.length);
    }

    public void write(byte[] r10, int r11, int r12) {
        ensureSpace(r12);
        System.arraycopy(r10, r11, this.buf, this.index, r12);
        this.index += r12;
    }

    public void writeBoolean(boolean r10) {
        writeByte(r10 ? 1 : 0);
    }

    public void writeByte(int r10) {
        ensureSpace(1);
        byte[] r11 = this.buf;
        int r12 = this.index;
        this.index = r12 + 1;
        r11[r12] = (byte) (r10 & 255);
    }

    public void writeDouble(double r10) {
        writeInt64(Double.doubleToLongBits(r10));
    }

    public void writeFloat(float r10) {
        writeInt32(Float.floatToIntBits(r10));
    }

    public void writeInt16(int r10) {
        align(2);
        ensureSpace(2);
        byte[] r11 = this.buf;
        int r12 = this.index;
        int r13 = r12 + 1;
        this.index = r13;
        r11[r12] = (byte) (r10 & 255);
        this.index = r13 + 1;
        r11[r13] = (byte) ((r10 >>> 8) & 255);
    }

    public void writeInt32(int r10) {
        align(4);
        ensureSpace(4);
        byte[] r11 = this.buf;
        int r12 = this.index;
        int r13 = r12 + 1;
        this.index = r13;
        r11[r12] = (byte) (r10 & 255);
        int r14 = r13 + 1;
        this.index = r14;
        r11[r13] = (byte) ((r10 >>> 8) & 255);
        int r15 = r14 + 1;
        this.index = r15;
        r11[r14] = (byte) ((r10 >>> 16) & 255);
        this.index = r15 + 1;
        r11[r15] = (byte) ((r10 >>> 24) & 255);
    }

    public void writeInt32At(int r10, int r11) {
        int r12 = this.index;
        this.index = r10;
        writeInt32(r11);
        this.index = r12;
    }

    public void writeInt64(long r10) {
        align(8);
        writeInt32((int) (r10 & 4294967295L));
        writeInt32((int) ((r10 >>> 32) & 4294967295L));
    }

    public void writeString(String r10) {
        writeString(r10.getBytes());
    }

    public void writeString(byte[] r10) {
        writeUleb128(r10.length);
        write(r10);
        writeByte(0);
    }

    public void writeUleb128(long r10) {
        ensureSpace(10);
    L3:
        byte r11 = (byte) (127 & r10);
        r10 = r10 >>> 7;
        if (r10 == 0) goto L6;
        r11 = (byte) (r11 | 128);
    L6:
        byte[] r12 = this.buf;
        int r13 = this.index;
        this.index = r13 + 1;
        r12[r13] = r11;
        if (r10 != 0) goto L3;
    }
}
