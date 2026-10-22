package com.bytedance.crash.protector;

/* JADX INFO: loaded from: classes2.dex */
public class BufferWriter {
    private byte[] buf;
    private int index;

    public BufferWriter() {
        this(512);
    }

    public BufferWriter(int r2) {
        this.buf = null;
        this.index = 0;
        if (r2 <= 0) goto L6;
        this.buf = new byte[r2];
        return;
    }

    private void ensureSpace(int r4) {
        if (remaining() >= r4) goto L6;
        int r0 = this.buf.length;
        byte[] r5 = new byte[r0 + Math.max(r0, r4)];
        System.arraycopy(this.buf, 0, r5, 0, this.index);
        this.buf = r5;
        return;
    }

    public void align(int r6) {
        int r0 = this.index;
        int r1 = ((((r0 + r6) - 1) / r6) * r6) - r0;
        ensureSpace(r1);
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        byte[] r3 = this.buf;
        int r4 = this.index;
        this.index = r4 + 1;
        r3[r4] = 0;
        r2 = r2 + 1;
        goto L3
    }

    public byte[] data() {
        return this.buf;
    }

    public int position() {
        return this.index;
    }

    public int prependInt32(int r2) {
        align(4);
        int r0 = position();
        writeInt32(r2);
        return r0;
    }

    public int remaining() {
        return this.buf.length - this.index;
    }

    public void setPosition(int r1) {
        this.index = r1;
    }

    public void write(byte[] r3) {
        write(r3, 0, r3.length);
    }

    public void write(byte[] r3, int r4, int r5) {
        ensureSpace(r5);
        System.arraycopy(r3, r4, this.buf, this.index, r5);
        this.index += r5;
    }

    public void writeBoolean(boolean r1) {
        writeByte(r1 ? 1 : 0);
    }

    public void writeByte(int r4) {
        ensureSpace(1);
        byte[] r0 = this.buf;
        int r1 = this.index;
        this.index = r1 + 1;
        r0[r1] = (byte) (r4 & 255);
    }

    public void writeDouble(double r1) {
        writeInt64(Double.doubleToLongBits(r1));
    }

    public void writeFloat(float r1) {
        writeInt32(Float.floatToIntBits(r1));
    }

    public void writeInt16(int r5) {
        align(2);
        ensureSpace(2);
        byte[] r0 = this.buf;
        int r1 = this.index;
        int r2 = r1 + 1;
        this.index = r2;
        r0[r1] = (byte) (r5 & 255);
        this.index = r2 + 1;
        r0[r2] = (byte) ((r5 >>> 8) & 255);
    }

    public void writeInt32(int r5) {
        align(4);
        ensureSpace(4);
        byte[] r0 = this.buf;
        int r1 = this.index;
        int r2 = r1 + 1;
        this.index = r2;
        r0[r1] = (byte) (r5 & 255);
        int r3 = r2 + 1;
        this.index = r3;
        r0[r2] = (byte) ((r5 >>> 8) & 255);
        int r4 = r3 + 1;
        this.index = r4;
        r0[r3] = (byte) ((r5 >>> 16) & 255);
        this.index = r4 + 1;
        r0[r4] = (byte) ((r5 >>> 24) & 255);
    }

    public void writeInt32At(int r2, int r3) {
        int r0 = this.index;
        this.index = r2;
        writeInt32(r3);
        this.index = r0;
    }

    public void writeInt64(long r5) {
        align(8);
        writeInt32((int) (r5 & 4294967295L));
        writeInt32((int) ((r5 >>> 32) & 4294967295L));
    }

    public void writeString(String r1) {
        writeString(r1.getBytes());
    }

    public void writeString(byte[] r3) {
        writeUleb128(r3.length);
        write(r3);
        writeByte(0);
    }

    public void writeUleb128(long r6) {
        ensureSpace(10);
    L3:
        byte r0 = (byte) (127 & r6);
        r6 = r6 >>> 7;
        if (r6 == 0) goto L6;
        r0 = (byte) (r0 | 128);
    L6:
        byte[] r2 = this.buf;
        int r3 = this.index;
        this.index = r3 + 1;
        r2[r3] = r0;
        if (r6 != 0) goto L3;
    }
}
