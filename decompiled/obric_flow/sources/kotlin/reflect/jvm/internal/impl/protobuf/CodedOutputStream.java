package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes3.dex */
public final class CodedOutputStream {
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int position;
    private int totalBytesWritten;

    public static class OutOfSpaceException extends IOException {
        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream r5, byte[] r10) {
        this.totalBytesWritten = 0;
        this.output = r5;
        this.buffer = r10;
        this.position = 0;
        this.limit = r10.length;
    }

    public static int computeBoolSize(int r5, boolean r10) {
        int r11 = computeTagSize(r5);
        return computeBoolSizeNoTag(r10) + r11;
    }

    public static int computeBoolSizeNoTag(boolean r5) {
        return 1;
    }

    public static int computeByteArraySizeNoTag(byte[] r5) {
        return computeRawVarint32Size(r5.length) + r5.length;
    }

    public static int computeBytesSize(int r5, ByteString r10) {
        int r11 = computeTagSize(r5);
        return computeBytesSizeNoTag(r10) + r11;
    }

    public static int computeBytesSizeNoTag(ByteString r5) {
        int r10 = computeRawVarint32Size(r5.size());
        return r5.size() + r10;
    }

    public static int computeDoubleSize(int r5, double r10) {
        int r11 = computeTagSize(r5);
        return computeDoubleSizeNoTag(r10) + r11;
    }

    public static int computeDoubleSizeNoTag(double r5) {
        return 8;
    }

    public static int computeEnumSize(int r5, int r10) {
        int r11 = computeTagSize(r5);
        return computeEnumSizeNoTag(r10) + r11;
    }

    public static int computeEnumSizeNoTag(int r5) {
        return computeInt32SizeNoTag(r5);
    }

    public static int computeFixed32SizeNoTag(int r5) {
        return 4;
    }

    public static int computeFixed64SizeNoTag(long r5) {
        return 8;
    }

    public static int computeFloatSize(int r5, float r10) {
        int r11 = computeTagSize(r5);
        return computeFloatSizeNoTag(r10) + r11;
    }

    public static int computeFloatSizeNoTag(float r5) {
        return 4;
    }

    public static int computeGroupSizeNoTag(MessageLite r5) {
        return r5.getSerializedSize();
    }

    public static int computeInt32Size(int r5, int r10) {
        int r11 = computeTagSize(r5);
        return computeInt32SizeNoTag(r10) + r11;
    }

    public static int computeInt32SizeNoTag(int r5) {
        if (r5 >= 0) goto L4;
        return 10;
    L4:
        return computeRawVarint32Size(r5);
    }

    public static int computeInt64SizeNoTag(long r5) {
        return computeRawVarint64Size(r5);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite r5) {
        int r10 = r5.getSerializedSize();
        return computeRawVarint32Size(r10) + r10;
    }

    public static int computeMessageSize(int r5, MessageLite r10) {
        int r11 = computeTagSize(r5);
        return computeMessageSizeNoTag(r10) + r11;
    }

    public static int computeMessageSizeNoTag(MessageLite r5) {
        int r10 = r5.getSerializedSize();
        return computeRawVarint32Size(r10) + r10;
    }

    public static int computePreferredBufferSize(int r5) {
        if (r5 <= 4096) goto L5;
        return 4096;
    L5:
        return r5;
    }

    public static int computeRawVarint32Size(int r5) {
        if ((r5 & (-128)) != 0) goto L7;
        return 1;
    L7:
        if ((r5 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r5) != 0) goto L15;
        return 3;
    L15:
        if ((r5 & (-268435456)) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public static int computeRawVarint64Size(long r5) {
        if (((-128) & r5) != 0) goto L7;
        return 1;
    L7:
        if (((-16384) & r5) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r5) != 0) goto L15;
        return 3;
    L15:
        if (((-268435456) & r5) != 0) goto L19;
        return 4;
    L19:
        if (((-34359738368L) & r5) != 0) goto L23;
        return 5;
    L23:
        if (((-4398046511104L) & r5) != 0) goto L27;
        return 6;
    L27:
        if (((-562949953421312L) & r5) != 0) goto L31;
        return 7;
    L31:
        if (((-72057594037927936L) & r5) != 0) goto L35;
        return 8;
    L35:
        if ((r5 & Long.MIN_VALUE) != 0) goto L38;
        return 9;
    L38:
        return 10;
    }

    public static int computeSFixed32SizeNoTag(int r5) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long r5) {
        return 8;
    }

    public static int computeSInt32SizeNoTag(int r5) {
        return computeRawVarint32Size(encodeZigZag32(r5));
    }

    public static int computeSInt64Size(int r5, long r10) {
        int r11 = computeTagSize(r5);
        return computeSInt64SizeNoTag(r10) + r11;
    }

    public static int computeSInt64SizeNoTag(long r5) {
        return computeRawVarint64Size(encodeZigZag64(r5));
    }

    public static int computeStringSizeNoTag(String r5) {
        byte[] r10 = r5.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L5
        return computeRawVarint32Size(r10.length) + r10.length;
    L5:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported.", e);
    }

    public static int computeTagSize(int r5) {
        return computeRawVarint32Size(WireFormat.makeTag(r5, 0));
    }

    public static int computeUInt32SizeNoTag(int r5) {
        return computeRawVarint32Size(r5);
    }

    public static int computeUInt64SizeNoTag(long r5) {
        return computeRawVarint64Size(r5);
    }

    public static int encodeZigZag32(int r5) {
        int r10 = r5 << 1;
        return (r5 >> 31) ^ r10;
    }

    public static long encodeZigZag64(long r5) {
        long r10 = r5 << 1;
        return (r5 >> 63) ^ r10;
    }

    public static CodedOutputStream newInstance(OutputStream r5, int r10) {
        return new CodedOutputStream(r5, new byte[r10]);
    }

    private void refreshBuffer() throws IOException {
        OutputStream r5 = this.output;
        if (r5 == null) goto L7;
        r5.write(this.buffer, 0, this.position);
        this.position = 0;
        return;
    L7:
        throw new OutOfSpaceException();
    }

    public void flush() throws IOException {
        if (this.output == null) goto L6;
        refreshBuffer();
        return;
    }

    public void writeBool(int r5, boolean r10) throws IOException {
        writeTag(r5, 0);
        writeBoolNoTag(r10);
    }

    public void writeBoolNoTag(boolean r5) throws IOException {
        writeRawByte(r5 ? 1 : 0);
    }

    public void writeByteArrayNoTag(byte[] r5) throws IOException {
        writeRawVarint32(r5.length);
        writeRawBytes(r5);
    }

    public void writeBytes(int r5, ByteString r10) throws IOException {
        writeTag(r5, 2);
        writeBytesNoTag(r10);
    }

    public void writeBytesNoTag(ByteString r5) throws IOException {
        writeRawVarint32(r5.size());
        writeRawBytes(r5);
    }

    public void writeDouble(int r5, double r10) throws IOException {
        writeTag(r5, 1);
        writeDoubleNoTag(r10);
    }

    public void writeDoubleNoTag(double r5) throws IOException {
        writeRawLittleEndian64(Double.doubleToRawLongBits(r5));
    }

    public void writeEnum(int r5, int r10) throws IOException {
        writeTag(r5, 0);
        writeEnumNoTag(r10);
    }

    public void writeEnumNoTag(int r5) throws IOException {
        writeInt32NoTag(r5);
    }

    public void writeFixed32NoTag(int r5) throws IOException {
        writeRawLittleEndian32(r5);
    }

    public void writeFixed64NoTag(long r5) throws IOException {
        writeRawLittleEndian64(r5);
    }

    public void writeFloat(int r5, float r10) throws IOException {
        writeTag(r5, 5);
        writeFloatNoTag(r10);
    }

    public void writeFloatNoTag(float r5) throws IOException {
        writeRawLittleEndian32(Float.floatToRawIntBits(r5));
    }

    public void writeGroup(int r5, MessageLite r10) throws IOException {
        writeTag(r5, 3);
        writeGroupNoTag(r10);
        writeTag(r5, 4);
    }

    public void writeGroupNoTag(MessageLite r5) throws IOException {
        r5.writeTo(this);
    }

    public void writeInt32(int r5, int r10) throws IOException {
        writeTag(r5, 0);
        writeInt32NoTag(r10);
    }

    public void writeInt32NoTag(int r5) throws IOException {
        if (r5 < 0) goto L4;
        writeRawVarint32(r5);
        return;
    L4:
        writeRawVarint64(r5);
    }

    public void writeInt64NoTag(long r5) throws IOException {
        writeRawVarint64(r5);
    }

    public void writeMessage(int r5, MessageLite r10) throws IOException {
        writeTag(r5, 2);
        writeMessageNoTag(r10);
    }

    public void writeMessageNoTag(MessageLite r5) throws IOException {
        writeRawVarint32(r5.getSerializedSize());
        r5.writeTo(this);
    }

    public void writeMessageSetExtension(int r5, MessageLite r10) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, r5);
        writeMessage(3, r10);
        writeTag(1, 4);
    }

    public void writeRawByte(byte r5) throws IOException {
        if (this.position != this.limit) goto L5;
        refreshBuffer();
    L5:
        byte[] r10 = this.buffer;
        int r11 = this.position;
        this.position = r11 + 1;
        r10[r11] = r5;
        this.totalBytesWritten++;
    }

    public void writeRawBytes(ByteString r5) throws IOException {
        writeRawBytes(r5, 0, r5.size());
    }

    public void writeRawLittleEndian32(int r5) throws IOException {
        writeRawByte(r5 & 255);
        writeRawByte((r5 >> 8) & 255);
        writeRawByte((r5 >> 16) & 255);
        writeRawByte((r5 >> 24) & 255);
    }

    public void writeRawLittleEndian64(long r5) throws IOException {
        writeRawByte(((int) r5) & 255);
        writeRawByte(((int) (r5 >> 8)) & 255);
        writeRawByte(((int) (r5 >> 16)) & 255);
        writeRawByte(((int) (r5 >> 24)) & 255);
        writeRawByte(((int) (r5 >> 32)) & 255);
        writeRawByte(((int) (r5 >> 40)) & 255);
        writeRawByte(((int) (r5 >> 48)) & 255);
        writeRawByte(((int) (r5 >> 56)) & 255);
    }

    public void writeRawVarint32(int r5) throws IOException {
    L3:
        if ((r5 & (-128)) == 0) goto L4;
        writeRawByte((r5 & 127) | 128);
        r5 = r5 >>> 7;
        goto L3
    L4:
        writeRawByte(r5);
    }

    public void writeRawVarint64(long r5) throws IOException {
    L3:
        if (((-128) & r5) == 0) goto L4;
        writeRawByte((((int) r5) & 127) | 128);
        r5 = r5 >>> 7;
        goto L3
    L4:
        writeRawByte((int) r5);
    }

    public void writeSFixed32NoTag(int r5) throws IOException {
        writeRawLittleEndian32(r5);
    }

    public void writeSFixed64NoTag(long r5) throws IOException {
        writeRawLittleEndian64(r5);
    }

    public void writeSInt32NoTag(int r5) throws IOException {
        writeRawVarint32(encodeZigZag32(r5));
    }

    public void writeSInt64(int r5, long r10) throws IOException {
        writeTag(r5, 0);
        writeSInt64NoTag(r10);
    }

    public void writeSInt64NoTag(long r5) throws IOException {
        writeRawVarint64(encodeZigZag64(r5));
    }

    public void writeStringNoTag(String r5) throws IOException {
        byte[] r10 = r5.getBytes("UTF-8");
        writeRawVarint32(r10.length);
        writeRawBytes(r10);
    }

    public void writeTag(int r5, int r10) throws IOException {
        writeRawVarint32(WireFormat.makeTag(r5, r10));
    }

    public void writeUInt32(int r5, int r10) throws IOException {
        writeTag(r5, 0);
        writeUInt32NoTag(r10);
    }

    public void writeUInt32NoTag(int r5) throws IOException {
        writeRawVarint32(r5);
    }

    public void writeUInt64NoTag(long r5) throws IOException {
        writeRawVarint64(r5);
    }

    public void writeRawBytes(byte[] r5) throws IOException {
        writeRawBytes(r5, 0, r5.length);
    }

    public void writeRawBytes(byte[] r5, int r10, int r11) throws IOException {
        int r12 = this.limit;
        int r13 = this.position;
        if ((r12 - r13) < r11) goto L5;
        System.arraycopy(r5, r10, this.buffer, r13, r11);
        this.position += r11;
        this.totalBytesWritten += r11;
        return;
    L5:
        int r14 = r12 - r13;
        System.arraycopy(r5, r10, this.buffer, r13, r14);
        int r15 = r10 + r14;
        int r16 = r11 - r14;
        this.position = this.limit;
        this.totalBytesWritten += r14;
        refreshBuffer();
        if (r16 > this.limit) goto L8;
        System.arraycopy(r5, r15, this.buffer, 0, r16);
        this.position = r16;
    L9:
        this.totalBytesWritten += r16;
        return;
    L8:
        this.output.write(r5, r15, r16);
        goto L9
    }

    public void writeRawByte(int r5) throws IOException {
        writeRawByte((byte) r5);
    }

    public void writeRawBytes(ByteString r5, int r10, int r11) throws IOException {
        int r12 = this.limit;
        int r13 = this.position;
        if ((r12 - r13) < r11) goto L5;
        r5.copyTo(this.buffer, r10, r13, r11);
        this.position += r11;
        this.totalBytesWritten += r11;
        return;
    L5:
        int r14 = r12 - r13;
        r5.copyTo(this.buffer, r10, r13, r14);
        int r15 = r10 + r14;
        int r16 = r11 - r14;
        this.position = this.limit;
        this.totalBytesWritten += r14;
        refreshBuffer();
        if (r16 > this.limit) goto L8;
        r5.copyTo(this.buffer, r15, 0, r16);
        this.position = r16;
    L9:
        this.totalBytesWritten += r16;
        return;
    L8:
        r5.writeTo(this.output, r15, r16);
        goto L9
    }
}
