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
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream r10, byte[] r11) {
        this.totalBytesWritten = 0;
        this.output = r10;
        this.buffer = r11;
        this.position = 0;
        this.limit = r11.length;
    }

    public static int computeBoolSize(int r10, boolean r11) {
        return computeTagSize(r10) + computeBoolSizeNoTag(r11);
    }

    public static int computeBoolSizeNoTag(boolean r10) {
        return 1;
    }

    public static int computeByteArraySizeNoTag(byte[] r10) {
        return computeRawVarint32Size(r10.length) + r10.length;
    }

    public static int computeBytesSize(int r10, ByteString r11) {
        return computeTagSize(r10) + computeBytesSizeNoTag(r11);
    }

    public static int computeBytesSizeNoTag(ByteString r10) {
        return computeRawVarint32Size(r10.size()) + r10.size();
    }

    public static int computeDoubleSize(int r10, double r11) {
        return computeTagSize(r10) + computeDoubleSizeNoTag(r11);
    }

    public static int computeDoubleSizeNoTag(double r10) {
        return 8;
    }

    public static int computeEnumSize(int r10, int r11) {
        return computeTagSize(r10) + computeEnumSizeNoTag(r11);
    }

    public static int computeEnumSizeNoTag(int r10) {
        return computeInt32SizeNoTag(r10);
    }

    public static int computeFixed32SizeNoTag(int r10) {
        return 4;
    }

    public static int computeFixed64SizeNoTag(long r10) {
        return 8;
    }

    public static int computeFloatSize(int r10, float r11) {
        return computeTagSize(r10) + computeFloatSizeNoTag(r11);
    }

    public static int computeFloatSizeNoTag(float r10) {
        return 4;
    }

    public static int computeGroupSizeNoTag(MessageLite r10) {
        return r10.getSerializedSize();
    }

    public static int computeInt32Size(int r10, int r11) {
        return computeTagSize(r10) + computeInt32SizeNoTag(r11);
    }

    public static int computeInt32SizeNoTag(int r10) {
        if (r10 >= 0) goto L4;
        return 10;
    L4:
        return computeRawVarint32Size(r10);
    }

    public static int computeInt64SizeNoTag(long r10) {
        return computeRawVarint64Size(r10);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite r10) {
        int r11 = r10.getSerializedSize();
        return computeRawVarint32Size(r11) + r11;
    }

    public static int computeMessageSize(int r10, MessageLite r11) {
        return computeTagSize(r10) + computeMessageSizeNoTag(r11);
    }

    public static int computeMessageSizeNoTag(MessageLite r10) {
        int r11 = r10.getSerializedSize();
        return computeRawVarint32Size(r11) + r11;
    }

    static int computePreferredBufferSize(int r10) {
        if (r10 <= 4096) goto L5;
        return 4096;
    L5:
        return r10;
    }

    public static int computeRawVarint32Size(int r10) {
        if ((r10 & (-128)) != 0) goto L7;
        return 1;
    L7:
        if ((r10 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r10) != 0) goto L15;
        return 3;
    L15:
        if ((r10 & (-268435456)) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public static int computeRawVarint64Size(long r10) {
        if (((-128) & r10) != 0) goto L7;
        return 1;
    L7:
        if (((-16384) & r10) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r10) != 0) goto L15;
        return 3;
    L15:
        if (((-268435456) & r10) != 0) goto L19;
        return 4;
    L19:
        if (((-34359738368L) & r10) != 0) goto L23;
        return 5;
    L23:
        if (((-4398046511104L) & r10) != 0) goto L27;
        return 6;
    L27:
        if (((-562949953421312L) & r10) != 0) goto L31;
        return 7;
    L31:
        if (((-72057594037927936L) & r10) != 0) goto L35;
        return 8;
    L35:
        if ((r10 & Long.MIN_VALUE) != 0) goto L38;
        return 9;
    L38:
        return 10;
    }

    public static int computeSFixed32SizeNoTag(int r10) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long r10) {
        return 8;
    }

    public static int computeSInt32SizeNoTag(int r10) {
        return computeRawVarint32Size(encodeZigZag32(r10));
    }

    public static int computeSInt64Size(int r10, long r11) {
        return computeTagSize(r10) + computeSInt64SizeNoTag(r11);
    }

    public static int computeSInt64SizeNoTag(long r10) {
        return computeRawVarint64Size(encodeZigZag64(r10));
    }

    public static int computeStringSizeNoTag(String r10) {
        byte[] r11 = r10.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L5
        return computeRawVarint32Size(r11.length) + r11.length;
    L5:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported.", e);
    }

    public static int computeTagSize(int r10) {
        return computeRawVarint32Size(WireFormat.makeTag(r10, 0));
    }

    public static int computeUInt32SizeNoTag(int r10) {
        return computeRawVarint32Size(r10);
    }

    public static int computeUInt64SizeNoTag(long r10) {
        return computeRawVarint64Size(r10);
    }

    public static int encodeZigZag32(int r10) {
        int r11 = r10 << 1;
        return (r10 >> 31) ^ r11;
    }

    public static long encodeZigZag64(long r10) {
        long r11 = r10 << 1;
        return (r10 >> 63) ^ r11;
    }

    public static CodedOutputStream newInstance(OutputStream r10, int r11) {
        return new CodedOutputStream(r10, new byte[r11]);
    }

    private void refreshBuffer() {
        OutputStream r10 = this.output;
        if (r10 == null) goto L7;
        r10.write(this.buffer, 0, this.position);
        this.position = 0;
        return;
    L7:
        throw new OutOfSpaceException();
    }

    public void flush() {
        if (this.output == null) goto L6;
        refreshBuffer();
        return;
    }

    public void writeBool(int r10, boolean r11) {
        writeTag(r10, 0);
        writeBoolNoTag(r11);
    }

    public void writeBoolNoTag(boolean r10) {
        writeRawByte(r10 ? 1 : 0);
    }

    public void writeByteArrayNoTag(byte[] r10) {
        writeRawVarint32(r10.length);
        writeRawBytes(r10);
    }

    public void writeBytes(int r10, ByteString r11) {
        writeTag(r10, 2);
        writeBytesNoTag(r11);
    }

    public void writeBytesNoTag(ByteString r10) {
        writeRawVarint32(r10.size());
        writeRawBytes(r10);
    }

    public void writeDouble(int r10, double r11) {
        writeTag(r10, 1);
        writeDoubleNoTag(r11);
    }

    public void writeDoubleNoTag(double r10) {
        writeRawLittleEndian64(Double.doubleToRawLongBits(r10));
    }

    public void writeEnum(int r10, int r11) {
        writeTag(r10, 0);
        writeEnumNoTag(r11);
    }

    public void writeEnumNoTag(int r10) {
        writeInt32NoTag(r10);
    }

    public void writeFixed32NoTag(int r10) {
        writeRawLittleEndian32(r10);
    }

    public void writeFixed64NoTag(long r10) {
        writeRawLittleEndian64(r10);
    }

    public void writeFloat(int r10, float r11) {
        writeTag(r10, 5);
        writeFloatNoTag(r11);
    }

    public void writeFloatNoTag(float r10) {
        writeRawLittleEndian32(Float.floatToRawIntBits(r10));
    }

    public void writeGroup(int r10, MessageLite r11) {
        writeTag(r10, 3);
        writeGroupNoTag(r11);
        writeTag(r10, 4);
    }

    public void writeGroupNoTag(MessageLite r10) {
        r10.writeTo(this);
    }

    public void writeInt32(int r10, int r11) {
        writeTag(r10, 0);
        writeInt32NoTag(r11);
    }

    public void writeInt32NoTag(int r10) {
        if (r10 < 0) goto L4;
        writeRawVarint32(r10);
        return;
    L4:
        writeRawVarint64(r10);
    }

    public void writeInt64NoTag(long r10) {
        writeRawVarint64(r10);
    }

    public void writeMessage(int r10, MessageLite r11) {
        writeTag(r10, 2);
        writeMessageNoTag(r11);
    }

    public void writeMessageNoTag(MessageLite r10) {
        writeRawVarint32(r10.getSerializedSize());
        r10.writeTo(this);
    }

    public void writeMessageSetExtension(int r10, MessageLite r11) {
        writeTag(1, 3);
        writeUInt32(2, r10);
        writeMessage(3, r11);
        writeTag(1, 4);
    }

    public void writeRawByte(byte r10) {
        if (this.position != this.limit) goto L5;
        refreshBuffer();
    L5:
        byte[] r11 = this.buffer;
        int r12 = this.position;
        this.position = r12 + 1;
        r11[r12] = r10;
        this.totalBytesWritten++;
    }

    public void writeRawByte(int r10) {
        writeRawByte((byte) r10);
    }

    public void writeRawBytes(ByteString r10) {
        writeRawBytes(r10, 0, r10.size());
    }

    public void writeRawBytes(ByteString r10, int r11, int r12) {
        int r13 = this.limit;
        int r14 = this.position;
        if ((r13 - r14) < r12) goto L6;
        r10.copyTo(this.buffer, r11, r14, r12);
        this.position += r12;
    L5:
        this.totalBytesWritten += r12;
        return;
    L6:
        int r15 = r13 - r14;
        r10.copyTo(this.buffer, r11, r14, r15);
        int r16 = r11 + r15;
        r12 = r12 - r15;
        this.position = this.limit;
        this.totalBytesWritten += r15;
        refreshBuffer();
        if (r12 > this.limit) goto L9;
        r10.copyTo(this.buffer, r16, 0, r12);
        this.position = r12;
        goto L5
    L9:
        r10.writeTo(this.output, r16, r12);
        goto L5
    }

    public void writeRawBytes(byte[] r10) {
        writeRawBytes(r10, 0, r10.length);
    }

    public void writeRawBytes(byte[] r10, int r11, int r12) {
        int r13 = this.limit;
        int r14 = this.position;
        if ((r13 - r14) < r12) goto L6;
        System.arraycopy(r10, r11, this.buffer, r14, r12);
        this.position += r12;
    L5:
        this.totalBytesWritten += r12;
        return;
    L6:
        int r15 = r13 - r14;
        System.arraycopy(r10, r11, this.buffer, r14, r15);
        int r16 = r11 + r15;
        r12 = r12 - r15;
        this.position = this.limit;
        this.totalBytesWritten += r15;
        refreshBuffer();
        if (r12 > this.limit) goto L9;
        System.arraycopy(r10, r16, this.buffer, 0, r12);
        this.position = r12;
        goto L5
    L9:
        this.output.write(r10, r16, r12);
        goto L5
    }

    public void writeRawLittleEndian32(int r10) {
        writeRawByte(r10 & 255);
        writeRawByte((r10 >> 8) & 255);
        writeRawByte((r10 >> 16) & 255);
        writeRawByte((r10 >> 24) & 255);
    }

    public void writeRawLittleEndian64(long r10) {
        writeRawByte(((int) r10) & 255);
        writeRawByte(((int) (r10 >> 8)) & 255);
        writeRawByte(((int) (r10 >> 16)) & 255);
        writeRawByte(((int) (r10 >> 24)) & 255);
        writeRawByte(((int) (r10 >> 32)) & 255);
        writeRawByte(((int) (r10 >> 40)) & 255);
        writeRawByte(((int) (r10 >> 48)) & 255);
        writeRawByte(((int) (r10 >> 56)) & 255);
    }

    public void writeRawVarint32(int r10) {
    L3:
        if ((r10 & (-128)) == 0) goto L4;
        writeRawByte((r10 & 127) | 128);
        r10 = r10 >>> 7;
        goto L3
    L4:
        writeRawByte(r10);
    }

    public void writeRawVarint64(long r10) {
    L3:
        if (((-128) & r10) == 0) goto L4;
        writeRawByte((((int) r10) & 127) | 128);
        r10 = r10 >>> 7;
        goto L3
    L4:
        writeRawByte((int) r10);
    }

    public void writeSFixed32NoTag(int r10) {
        writeRawLittleEndian32(r10);
    }

    public void writeSFixed64NoTag(long r10) {
        writeRawLittleEndian64(r10);
    }

    public void writeSInt32NoTag(int r10) {
        writeRawVarint32(encodeZigZag32(r10));
    }

    public void writeSInt64(int r10, long r11) {
        writeTag(r10, 0);
        writeSInt64NoTag(r11);
    }

    public void writeSInt64NoTag(long r10) {
        writeRawVarint64(encodeZigZag64(r10));
    }

    public void writeStringNoTag(String r10) {
        byte[] r11 = r10.getBytes("UTF-8");
        writeRawVarint32(r11.length);
        writeRawBytes(r11);
    }

    public void writeTag(int r10, int r11) {
        writeRawVarint32(WireFormat.makeTag(r10, r11));
    }

    public void writeUInt32(int r10, int r11) {
        writeTag(r10, 0);
        writeUInt32NoTag(r11);
    }

    public void writeUInt32NoTag(int r10) {
        writeRawVarint32(r10);
    }

    public void writeUInt64NoTag(long r10) {
        writeRawVarint64(r10);
    }
}
