package com.google.protobuf;

import com.qualcomm.qti.qesdk.QesdkUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private static final Logger logger = null;
    private boolean serializationDeterministic;
    Object wrapper;

    /* JADX INFO: renamed from: com.google.protobuf.CodedOutputStream$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        public AbstractBufferedEncoder(int r8) {
            super(null);
            if (r8 < 0) goto L7;
            byte[] r10 = new byte[Math.max(r8, 20)];
            this.buffer = r10;
            this.limit = r10.length;
            return;
        L7:
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final void buffer(byte r8) {
            int r10 = this.position;
            this.buffer[r10] = r8;
            this.position = r10 + 1;
            this.totalBytesWritten++;
        }

        public final void bufferFixed32NoTag(int r8) {
            int r10 = this.position;
            byte[] r11 = this.buffer;
            int r12 = r10 + 1;
            r11[r10] = (byte) r8;
            int r13 = r12 + 1;
            r11[r12] = (byte) (r8 >> 8);
            int r14 = r13 + 1;
            r11[r13] = (byte) (r8 >> 16);
            r11[r14] = (byte) (r8 >> 24);
            this.position = r14 + 1;
            this.totalBytesWritten += 4;
        }

        public final void bufferFixed64NoTag(long r8) {
            int r10 = this.position;
            byte[] r11 = this.buffer;
            int r12 = r10 + 1;
            r11[r10] = (byte) r8;
            int r13 = r12 + 1;
            r11[r12] = (byte) (r8 >> 8);
            int r14 = r13 + 1;
            r11[r13] = (byte) (r8 >> 16);
            int r15 = r14 + 1;
            r11[r14] = (byte) (r8 >> 24);
            int r16 = r15 + 1;
            r11[r15] = (byte) (r8 >> 32);
            int r17 = r16 + 1;
            r11[r16] = (byte) (r8 >> 40);
            int r18 = r17 + 1;
            r11[r17] = (byte) (r8 >> 48);
            r11[r18] = (byte) (r8 >> 56);
            this.position = r18 + 1;
            this.totalBytesWritten += 8;
        }

        public final void bufferInt32NoTag(int r8) {
            if (r8 < 0) goto L4;
            bufferUInt32NoTag(r8);
            return;
        L4:
            bufferUInt64NoTag(r8);
        }

        public final void bufferTag(int r8, int r10) {
            bufferUInt32NoTag(WireFormat.makeTag(r8, r10));
        }

        public final void bufferUInt32NoTag(int r8) {
            if (CodedOutputStream.access$100() == false) goto L11;
            long r10 = this.position;
        L6:
            if ((r8 & QesdkUtils.LIMITS.INT_8_LOWER) == 0) goto L7;
            byte[] r11 = this.buffer;
            int r12 = this.position;
            this.position = r12 + 1;
            UnsafeUtil.putByte(r11, r12, (byte) (r8 | 128));
            r8 = r8 >>> 7;
            goto L6
        L7:
            byte[] r13 = this.buffer;
            int r14 = this.position;
            this.position = r14 + 1;
            UnsafeUtil.putByte(r13, r14, (byte) r8);
            this.totalBytesWritten += (int) (((long) this.position) - r10);
            return;
        L11:
            if ((r8 & QesdkUtils.LIMITS.INT_8_LOWER) == 0) goto L12;
            byte[] r15 = this.buffer;
            int r16 = this.position;
            this.position = r16 + 1;
            r15[r16] = (byte) (r8 | 128);
            this.totalBytesWritten++;
            r8 = r8 >>> 7;
            goto L11
        L12:
            byte[] r17 = this.buffer;
            int r18 = this.position;
            this.position = r18 + 1;
            r17[r18] = (byte) r8;
            this.totalBytesWritten++;
        }

        public final void bufferUInt64NoTag(long r12) {
            if (CodedOutputStream.access$100() == false) goto L11;
            long r8 = this.position;
        L6:
            if ((r12 & (-128)) == 0) goto L7;
            byte[] r10 = this.buffer;
            int r11 = this.position;
            this.position = r11 + 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((int) r12) | 128));
            r12 = r12 >>> 7;
            goto L6
        L7:
            byte[] r13 = this.buffer;
            int r14 = this.position;
            this.position = r14 + 1;
            UnsafeUtil.putByte(r13, r14, (byte) r12);
            this.totalBytesWritten += (int) (((long) this.position) - r8);
            return;
        L11:
            if ((r12 & (-128)) == 0) goto L12;
            byte[] r15 = this.buffer;
            int r16 = this.position;
            this.position = r16 + 1;
            r15[r16] = (byte) (((int) r12) | 128);
            this.totalBytesWritten++;
            r12 = r12 >>> 7;
            goto L11
        L12:
            byte[] r17 = this.buffer;
            int r18 = this.position;
            this.position = r18 + 1;
            r17[r18] = (byte) r12;
            this.totalBytesWritten++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    public static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        public ArrayEncoder(byte[] r8, int r10, int r11) {
            super(null);
            if (r8 == null) goto L11;
            int r12 = r10 + r11;
            if (((r10 | r11) | (r8.length - r12)) < 0) goto L9;
            this.buffer = r8;
            this.offset = r10;
            this.position = r10;
            this.limit = r12;
            return;
        L9:
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r8.length), Integer.valueOf(r10), Integer.valueOf(r11)}));
        L11:
            throw new NullPointerException("buffer");
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte r8) {
            int r10 = this.position;
            int r11 = r10 + 1;
            this.buffer[r10] = r8;     // Catch: IndexOutOfBoundsException -> L8
            this.position = r11;
            return;
        L8:
            e = e;
            r10 = r11;
        L12:
            throw new OutOfSpaceException(r10, this.limit, 1, e);
        L10:
            e = e;
            goto L12
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int r8, boolean r10) {
            writeTag(r8, 0);
            write(r10 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int r8, byte[] r10) {
            writeByteArray(r8, r10, 0, r10.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] r8, int r10, int r11) {
            writeUInt32NoTag(r11);
            write(r8, r10, r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteBuffer(int r8, ByteBuffer r10) {
            writeTag(r8, 2);
            writeUInt32NoTag(r10.capacity());
            writeRawBytes(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int r8, ByteString r10) {
            writeTag(r8, 2);
            writeBytesNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString r8) {
            writeUInt32NoTag(r8.size());
            r8.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int r8, int r10) {
            writeTag(r8, 5);
            writeFixed32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int r8) {
            int r10 = this.position;
            byte[] r11 = this.buffer;     // Catch: IndexOutOfBoundsException -> L6
            r11[r10] = (byte) r8;     // Catch: IndexOutOfBoundsException -> L6
            r11[r10 + 1] = (byte) (r8 >> 8);     // Catch: IndexOutOfBoundsException -> L6
            r11[r10 + 2] = (byte) (r8 >> 16);     // Catch: IndexOutOfBoundsException -> L6
            r11[r10 + 3] = (byte) (r8 >> 24);     // Catch: IndexOutOfBoundsException -> L6
            this.position = r10 + 4;
            return;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(r10, this.limit, 4, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int r8, long r10) {
            writeTag(r8, 1);
            writeFixed64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long r8) {
            int r10 = this.position;
            byte[] r11 = this.buffer;     // Catch: IndexOutOfBoundsException -> L6
            r11[r10] = (byte) r8;     // Catch: IndexOutOfBoundsException -> L6
            r11[r10 + 1] = (byte) (r8 >> 8);     // Catch: IndexOutOfBoundsException -> L6
            r11[r10 + 2] = (byte) (r8 >> 16);     // Catch: IndexOutOfBoundsException -> L6
            r11[r10 + 3] = (byte) (r8 >> 24);     // Catch: IndexOutOfBoundsException -> L6
            r11[r10 + 4] = (byte) (r8 >> 32);     // Catch: IndexOutOfBoundsException -> L6
            r11[r10 + 5] = (byte) (r8 >> 40);     // Catch: IndexOutOfBoundsException -> L6
            r11[r10 + 6] = (byte) (r8 >> 48);     // Catch: IndexOutOfBoundsException -> L6
            r11[r10 + 7] = (byte) (r8 >> 56);     // Catch: IndexOutOfBoundsException -> L6
            this.position = r10 + 8;
            return;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(r10, this.limit, 8, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int r8, int r10) {
            writeTag(r8, 0);
            writeInt32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int r8) {
            if (r8 < 0) goto L4;
            writeUInt32NoTag(r8);
            return;
        L4:
            writeUInt64NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer r8) {
            write(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int r8, MessageLite r10) {
            writeTag(r8, 2);
            writeMessageNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite r8) {
            writeUInt32NoTag(r8.getSerializedSize());
            r8.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int r8, MessageLite r10) {
            writeTag(1, 3);
            writeUInt32(2, r8);
            writeMessage(3, r10);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer r8) {
            if (r8.hasArray() == false) goto L5;
            write(r8.array(), r8.arrayOffset(), r8.capacity());
            return;
        L5:
            ByteBuffer r10 = r8.duplicate();
            Java8Compatibility.clear(r10);
            write(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int r8, ByteString r10) {
            writeTag(1, 3);
            writeUInt32(2, r8);
            writeBytes(3, r10);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int r8, String r10) {
            writeTag(r8, 2);
            writeStringNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeStringNoTag(String r8) {
            int r10 = this.position;
            int r11 = CodedOutputStream.computeUInt32SizeNoTag(r8.length() * 3);     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            int r12 = CodedOutputStream.computeUInt32SizeNoTag(r8.length());     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            if (r12 != r11) goto L7;
            int r13 = r10 + r12;     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            this.position = r13;     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            int r14 = Utf8.encode(r8, this.buffer, r13, spaceLeft());     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            this.position = r10;     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            writeUInt32NoTag((r14 - r10) - r12);     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
        L6:
            this.position = r14;     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
        L17:
            return;
        L7:
            writeUInt32NoTag(Utf8.encodedLength(r8));     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            r14 = Utf8.encode(r8, this.buffer, this.position, spaceLeft());     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
        L12:
            e = move-exception;
            this.position = r10;
            inefficientWriteStringNoTag(r8, e);
            return;
        L9:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int r8, int r10) {
            writeUInt32NoTag(WireFormat.makeTag(r8, r10));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int r8, int r10) {
            writeTag(r8, 0);
            writeUInt32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int r8) {
            int r10 = this.position;
        L4:
            if ((r8 & QesdkUtils.LIMITS.INT_8_LOWER) == 0) goto L5;
        L16:
            e = e;
        L18:
            throw new OutOfSpaceException(r10, this.limit, 1, e);
        L11:
            int r11 = r10 + 1;
            this.buffer[r10] = (byte) (r8 | 128);     // Catch: IndexOutOfBoundsException -> L14
            r8 = r8 >>> 7;
            r10 = r11;
        L14:
            e = e;
            r10 = r11;
            goto L18
        L5:
            r11 = r10 + 1;
            this.buffer[r10] = (byte) r8;     // Catch: IndexOutOfBoundsException -> L14
            this.position = r11;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int r8, long r10) {
            writeTag(r8, 0);
            writeUInt64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long r11) {
            int r8 = this.position;
            if (CodedOutputStream.access$100() == false) goto L11;
            if (spaceLeft() < 10) goto L11;
        L7:
            if ((r11 & (-128)) == 0) goto L8;
            UnsafeUtil.putByte(this.buffer, r8, (byte) (((int) r11) | 128));
            r11 = r11 >>> 7;
            r8 = r8 + 1;
            goto L7
        L8:
            int r10 = r8 + 1;
            UnsafeUtil.putByte(this.buffer, r8, (byte) r11);
        L15:
            this.position = r10;
            return;
        L11:
            if ((r11 & (-128)) == 0) goto L12;
        L25:
            e = e;
        L27:
            throw new OutOfSpaceException(r8, this.limit, 1, e);
        L20:
            int r12 = r8 + 1;
            this.buffer[r8] = (byte) (((int) r11) | 128);     // Catch: IndexOutOfBoundsException -> L23
            r11 = r11 >>> 7;
            r8 = r12;
        L23:
            e = e;
            r8 = r12;
            goto L27
        L12:
            r10 = r8 + 1;
            this.buffer[r8] = (byte) r11;     // Catch: IndexOutOfBoundsException -> L17
        L17:
            e = e;
            r8 = r10;
            goto L27
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(ByteBuffer r8) {
            int r10 = r8.remaining();
            r8.get(this.buffer, this.position, r10);     // Catch: IndexOutOfBoundsException -> L5
            this.position += r10;     // Catch: IndexOutOfBoundsException -> L5
            return;
        L5:
            e = move-exception;
            throw new OutOfSpaceException(this.position, this.limit, r10, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int r8, byte[] r10, int r11, int r12) {
            writeTag(r8, 2);
            writeByteArrayNoTag(r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(byte[] r8, int r10, int r11) {
            write(r8, r10, r11);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte[] r8, int r10, int r11) {
            System.arraycopy(r8, r10, this.buffer, this.position, r11);     // Catch: IndexOutOfBoundsException -> L5
            this.position += r11;
            return;
        L5:
            e = move-exception;
            throw new OutOfSpaceException(this.position, this.limit, r11, e);
        }
    }

    public static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        public ByteOutputEncoder(ByteOutput r8, int r10) {
            super(r10);
            if (r8 == null) goto L7;
            this.out = r8;
            return;
        L7:
            throw new NullPointerException("out");
        }

        private void doFlush() {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int r8) {
            if ((this.limit - this.position) >= r8) goto L6;
            doFlush();
            return;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            if (this.position <= 0) goto L6;
            doFlush();
            return;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte r8) {
            if (this.position != this.limit) goto L5;
            doFlush();
        L5:
            buffer(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r8, boolean r10) {
            flushIfNotAvailable(11);
            bufferTag(r8, 0);
            buffer(r10 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r8, byte[] r10) {
            writeByteArray(r8, r10, 0, r10.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r8, int r10, int r11) {
            writeUInt32NoTag(r11);
            write(r8, r10, r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r8, ByteBuffer r10) {
            writeTag(r8, 2);
            writeUInt32NoTag(r10.capacity());
            writeRawBytes(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r8, ByteString r10) {
            writeTag(r8, 2);
            writeBytesNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r8) {
            writeUInt32NoTag(r8.size());
            r8.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r8, int r10) {
            flushIfNotAvailable(14);
            bufferTag(r8, 5);
            bufferFixed32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r8) {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r8, long r10) {
            flushIfNotAvailable(18);
            bufferTag(r8, 1);
            bufferFixed64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r8) {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r8, int r10) {
            flushIfNotAvailable(20);
            bufferTag(r8, 0);
            bufferInt32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r8) {
            if (r8 < 0) goto L4;
            writeUInt32NoTag(r8);
            return;
        L4:
            writeUInt64NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r8) {
            flush();
            int r10 = r8.remaining();
            this.out.writeLazy(r8);
            this.totalBytesWritten += r10;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r8, MessageLite r10) {
            writeTag(r8, 2);
            writeMessageNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r8) {
            writeUInt32NoTag(r8.getSerializedSize());
            r8.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r8, MessageLite r10) {
            writeTag(1, 3);
            writeUInt32(2, r8);
            writeMessage(3, r10);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r8) {
            if (r8.hasArray() == false) goto L5;
            write(r8.array(), r8.arrayOffset(), r8.capacity());
            return;
        L5:
            ByteBuffer r10 = r8.duplicate();
            Java8Compatibility.clear(r10);
            write(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r8, ByteString r10) {
            writeTag(1, 3);
            writeUInt32(2, r8);
            writeBytes(3, r10);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r8, String r10) {
            writeTag(r8, 2);
            writeStringNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r8) {
            int r10 = r8.length() * 3;
            int r11 = CodedOutputStream.computeUInt32SizeNoTag(r10);
            int r12 = r11 + r10;
            int r13 = this.limit;
            if (r12 <= r13) goto L7;
            byte[] r14 = new byte[r10];
            int r15 = Utf8.encode(r8, r14, 0, r10);
            writeUInt32NoTag(r15);
            writeLazy(r14, 0, r15);
            return;
        L7:
            if (r12 <= (r13 - this.position)) goto L9;
            doFlush();
        L9:
            int r16 = this.position;
            int r17 = CodedOutputStream.computeUInt32SizeNoTag(r8.length());     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            if (r17 != r11) goto L13;
            int r18 = r16 + r17;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = r18;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            int r19 = Utf8.encode(r8, this.buffer, r18, this.limit - r18);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = r16;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            int r20 = (r19 - r16) - r17;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            bufferUInt32NoTag(r20);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = r19;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.totalBytesWritten += r20;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
        L21:
            return;
        L13:
            int r21 = Utf8.encodedLength(r8);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            bufferUInt32NoTag(r21);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = Utf8.encode(r8, this.buffer, this.position, r21);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.totalBytesWritten += r21;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
        L18:
            e = move-exception;
            this.totalBytesWritten -= this.position - r16;
            this.position = r16;
            inefficientWriteStringNoTag(r8, e);
            return;
        L15:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r8, int r10) {
            writeUInt32NoTag(WireFormat.makeTag(r8, r10));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r8, int r10) {
            flushIfNotAvailable(20);
            bufferTag(r8, 0);
            bufferUInt32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r8) {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r8, long r10) {
            flushIfNotAvailable(20);
            bufferTag(r8, 0);
            bufferUInt64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r8) {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r8) {
            flush();
            int r10 = r8.remaining();
            this.out.write(r8);
            this.totalBytesWritten += r10;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r8, byte[] r10, int r11, int r12) {
            writeTag(r8, 2);
            writeByteArrayNoTag(r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r8, int r10, int r11) {
            flush();
            this.out.writeLazy(r8, r10, r11);
            this.totalBytesWritten += r11;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r8, int r10, int r11) {
            flush();
            this.out.write(r8, r10, r11);
            this.totalBytesWritten += r11;
        }
    }

    public static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        public HeapNioEncoder(ByteBuffer r8) {
            byte[] r10 = r8.array();
            int r11 = r8.arrayOffset();
            super(r10, r8.position() + r11, r8.remaining());
            this.byteBuffer = r8;
            this.initialPosition = r8.position();
        }

        @Override // com.google.protobuf.CodedOutputStream.ArrayEncoder, com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.byteBuffer, this.initialPosition + getTotalBytesWritten());
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(int r8, int r10, int r11) {
            this(r8, r10, r11, null);
        }

        public OutOfSpaceException(int r8, int r10, int r11, Throwable r12) {
            this(r8, r10, r11, r12);
        }

        public OutOfSpaceException(long r8, long r10, int r12) {
            this(r8, r10, r12, null);
        }

        public OutOfSpaceException(long r8, long r10, int r11, Throwable r12) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(r8), Long.valueOf(r10), Integer.valueOf(r11)}), r12);
        }

        public OutOfSpaceException(String r8) {
            super(defpackage.b.c("CodedOutputStream was writing to a flat byte array and ran out of space.: ", r8));
        }

        public OutOfSpaceException(String r8, Throwable r10) {
            super(defpackage.b.c("CodedOutputStream was writing to a flat byte array and ran out of space.: ", r8), r10);
        }

        public OutOfSpaceException(Throwable r8) {
            super(MESSAGE, r8);
        }
    }

    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        public OutputStreamEncoder(OutputStream r8, int r10) {
            super(r10);
            if (r8 == null) goto L7;
            this.out = r8;
            return;
        L7:
            throw new NullPointerException("out");
        }

        private void doFlush() {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int r8) {
            if ((this.limit - this.position) >= r8) goto L6;
            doFlush();
            return;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            if (this.position <= 0) goto L6;
            doFlush();
            return;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte r8) {
            if (this.position != this.limit) goto L5;
            doFlush();
        L5:
            buffer(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r8, boolean r10) {
            flushIfNotAvailable(11);
            bufferTag(r8, 0);
            buffer(r10 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r8, byte[] r10) {
            writeByteArray(r8, r10, 0, r10.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r8, int r10, int r11) {
            writeUInt32NoTag(r11);
            write(r8, r10, r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r8, ByteBuffer r10) {
            writeTag(r8, 2);
            writeUInt32NoTag(r10.capacity());
            writeRawBytes(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r8, ByteString r10) {
            writeTag(r8, 2);
            writeBytesNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r8) {
            writeUInt32NoTag(r8.size());
            r8.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r8, int r10) {
            flushIfNotAvailable(14);
            bufferTag(r8, 5);
            bufferFixed32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r8) {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r8, long r10) {
            flushIfNotAvailable(18);
            bufferTag(r8, 1);
            bufferFixed64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r8) {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r8, int r10) {
            flushIfNotAvailable(20);
            bufferTag(r8, 0);
            bufferInt32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r8) {
            if (r8 < 0) goto L4;
            writeUInt32NoTag(r8);
            return;
        L4:
            writeUInt64NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r8) {
            write(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r8, MessageLite r10) {
            writeTag(r8, 2);
            writeMessageNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r8) {
            writeUInt32NoTag(r8.getSerializedSize());
            r8.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r8, MessageLite r10) {
            writeTag(1, 3);
            writeUInt32(2, r8);
            writeMessage(3, r10);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r8) {
            if (r8.hasArray() == false) goto L5;
            write(r8.array(), r8.arrayOffset(), r8.capacity());
            return;
        L5:
            ByteBuffer r10 = r8.duplicate();
            Java8Compatibility.clear(r10);
            write(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r8, ByteString r10) {
            writeTag(1, 3);
            writeUInt32(2, r8);
            writeBytes(3, r10);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r8, String r10) {
            writeTag(r8, 2);
            writeStringNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r8) {
            int r10 = r8.length() * 3;     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r11 = CodedOutputStream.computeUInt32SizeNoTag(r10);     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r12 = r11 + r10;     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r13 = this.limit;     // Catch: Utf8.UnpairedSurrogateException -> L22
            if (r12 <= r13) goto L7;
            byte[] r14 = new byte[r10];     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r15 = Utf8.encode(r8, r14, 0, r10);     // Catch: Utf8.UnpairedSurrogateException -> L22
            writeUInt32NoTag(r15);     // Catch: Utf8.UnpairedSurrogateException -> L22
            writeLazy(r14, 0, r15);     // Catch: Utf8.UnpairedSurrogateException -> L22
            return;
        L7:
            if (r12 <= (r13 - this.position)) goto L9;
            doFlush();     // Catch: Utf8.UnpairedSurrogateException -> L22
        L9:
            int r16 = CodedOutputStream.computeUInt32SizeNoTag(r8.length());     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r17 = this.position;     // Catch: Utf8.UnpairedSurrogateException -> L22
            if (r16 != r11) goto L13;
            int r18 = r17 + r16;
            this.position = r18;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            int r19 = Utf8.encode(r8, this.buffer, r18, this.limit - r18);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.position = r17;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            int r20 = (r19 - r17) - r16;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            bufferUInt32NoTag(r20);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.position = r19;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L14:
            this.totalBytesWritten += r20;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L28:
            return;
        L13:
            r20 = Utf8.encodedLength(r8);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            bufferUInt32NoTag(r20);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.position = Utf8.encode(r8, this.buffer, this.position, r20);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L19:
            e = move-exception;
            this.totalBytesWritten -= this.position - r17;     // Catch: Utf8.UnpairedSurrogateException -> L22
            this.position = r17;     // Catch: Utf8.UnpairedSurrogateException -> L22
            throw e;     // Catch: Utf8.UnpairedSurrogateException -> L22
        L16:
            e = move-exception;
            throw new OutOfSpaceException(e);     // Catch: Utf8.UnpairedSurrogateException -> L22
        L22:
            e = move-exception;
            inefficientWriteStringNoTag(r8, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r8, int r10) {
            writeUInt32NoTag(WireFormat.makeTag(r8, r10));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r8, int r10) {
            flushIfNotAvailable(20);
            bufferTag(r8, 0);
            bufferUInt32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r8) {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r8, long r10) {
            flushIfNotAvailable(20);
            bufferTag(r8, 0);
            bufferUInt64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r8) {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r8) {
            int r10 = r8.remaining();
            int r11 = this.limit;
            int r12 = this.position;
            if ((r11 - r12) < r10) goto L6;
            r8.get(this.buffer, r12, r10);
            this.position += r10;
        L5:
            this.totalBytesWritten += r10;
            return;
        L6:
            int r13 = r11 - r12;
            r8.get(this.buffer, r12, r13);
            r10 = r10 - r13;
            this.position = this.limit;
            this.totalBytesWritten += r13;
            doFlush();
        L7:
            int r14 = this.limit;
            if (r10 <= r14) goto L10;
            r8.get(this.buffer, 0, r14);
            this.out.write(this.buffer, 0, this.limit);
            int r15 = this.limit;
            r10 = r10 - r15;
            this.totalBytesWritten += r15;
            goto L7
        L10:
            r8.get(this.buffer, 0, r10);
            this.position = r10;
            goto L5
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r8, byte[] r10, int r11, int r12) {
            writeTag(r8, 2);
            writeByteArrayNoTag(r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r8, int r10, int r11) {
            write(r8, r10, r11);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r8, int r10, int r11) {
            int r12 = this.limit;
            int r13 = this.position;
            if ((r12 - r13) < r11) goto L6;
            System.arraycopy(r8, r10, this.buffer, r13, r11);
            this.position += r11;
        L5:
            this.totalBytesWritten += r11;
            return;
        L6:
            int r14 = r12 - r13;
            System.arraycopy(r8, r10, this.buffer, r13, r14);
            int r15 = r10 + r14;
            r11 = r11 - r14;
            this.position = this.limit;
            this.totalBytesWritten += r14;
            doFlush();
            if (r11 > this.limit) goto L9;
            System.arraycopy(r8, r15, this.buffer, 0, r11);
            this.position = r11;
            goto L5
        L9:
            this.out.write(r8, r15, r11);
            goto L5
        }
    }

    public static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        public SafeDirectNioEncoder(ByteBuffer r8) {
            super(null);
            this.originalBuffer = r8;
            this.buffer = r8.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = r8.position();
        }

        private void encode(String r8) {
            Utf8.encodeUtf8(r8, this.buffer);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.originalBuffer, this.buffer.position());
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.buffer.remaining();
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte r8) {
            this.buffer.put(r8);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit(), 1, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r8, boolean r10) {
            writeTag(r8, 0);
            write(r10 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r8, byte[] r10) {
            writeByteArray(r8, r10, 0, r10.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r8, int r10, int r11) {
            writeUInt32NoTag(r11);
            write(r8, r10, r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r8, ByteBuffer r10) {
            writeTag(r8, 2);
            writeUInt32NoTag(r10.capacity());
            writeRawBytes(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r8, ByteString r10) {
            writeTag(r8, 2);
            writeBytesNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r8) {
            writeUInt32NoTag(r8.size());
            r8.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r8, int r10) {
            writeTag(r8, 5);
            writeFixed32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r8) {
            this.buffer.putInt(r8);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit(), 4, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r8, long r10) {
            writeTag(r8, 1);
            writeFixed64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r8) {
            this.buffer.putLong(r8);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit(), 8, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r8, int r10) {
            writeTag(r8, 0);
            writeInt32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r8) {
            if (r8 < 0) goto L4;
            writeUInt32NoTag(r8);
            return;
        L4:
            writeUInt64NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r8) {
            write(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r8, MessageLite r10) {
            writeTag(r8, 2);
            writeMessageNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r8) {
            writeUInt32NoTag(r8.getSerializedSize());
            r8.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r8, MessageLite r10) {
            writeTag(1, 3);
            writeUInt32(2, r8);
            writeMessage(3, r10);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r8) {
            if (r8.hasArray() == false) goto L5;
            write(r8.array(), r8.arrayOffset(), r8.capacity());
            return;
        L5:
            ByteBuffer r10 = r8.duplicate();
            Java8Compatibility.clear(r10);
            write(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r8, ByteString r10) {
            writeTag(1, 3);
            writeUInt32(2, r8);
            writeBytes(3, r10);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r8, String r10) {
            writeTag(r8, 2);
            writeStringNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r8) {
            int r10 = this.buffer.position();
            int r11 = CodedOutputStream.computeUInt32SizeNoTag(r8.length() * 3);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            int r12 = CodedOutputStream.computeUInt32SizeNoTag(r8.length());     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            if (r12 != r11) goto L6;
            int r13 = this.buffer.position() + r12;     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            Java8Compatibility.position(this.buffer, r13);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            encode(r8);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            int r14 = this.buffer.position();     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            Java8Compatibility.position(this.buffer, r10);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            writeUInt32NoTag(r14 - r13);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            Java8Compatibility.position(this.buffer, r14);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
        L14:
            return;
        L6:
            writeUInt32NoTag(Utf8.encodedLength(r8));     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            encode(r8);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
        L11:
            e = move-exception;
            Java8Compatibility.position(this.buffer, r10);
            inefficientWriteStringNoTag(r8, e);
            return;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r8, int r10) {
            writeUInt32NoTag(WireFormat.makeTag(r8, r10));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r8, int r10) {
            writeTag(r8, 0);
            writeUInt32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r8) {
        L3:
            if ((r8 & QesdkUtils.LIMITS.INT_8_LOWER) == 0) goto L4;
            this.buffer.put((byte) (r8 | 128));     // Catch: BufferOverflowException -> L8
            r8 = r8 >>> 7;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            this.buffer.put((byte) r8);     // Catch: BufferOverflowException -> L8
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r8, long r10) {
            writeTag(r8, 0);
            writeUInt64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r8) {
        L3:
            if (((-128) & r8) == 0) goto L4;
            this.buffer.put((byte) (((int) r8) | 128));     // Catch: BufferOverflowException -> L8
            r8 = r8 >>> 7;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            this.buffer.put((byte) r8);     // Catch: BufferOverflowException -> L8
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r8) {
            this.buffer.put(r8);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r8, byte[] r10, int r11, int r12) {
            writeTag(r8, 2);
            writeByteArrayNoTag(r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r8, int r10, int r11) {
            write(r8, r10, r11);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r8, int r10, int r11) {
            this.buffer.put(r8, r10, r11);     // Catch: BufferOverflowException -> L4 IndexOutOfBoundsException -> L7
            return;
        L7:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }
    }

    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        public UnsafeDirectNioEncoder(ByteBuffer r8) {
            super(null);
            this.originalBuffer = r8;
            this.buffer = r8.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long r10 = UnsafeUtil.addressOffset(r8);
            this.address = r10;
            long r11 = ((long) r8.position()) + r10;
            this.initialPosition = r11;
            long r12 = r10 + ((long) r8.limit());
            this.limit = r12;
            this.oneVarintLimit = r12 - 10;
            this.position = r11;
        }

        private int bufferPos(long r8) {
            return (int) (r8 - this.address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void repositionBuffer(long r8) {
            Java8Compatibility.position(this.buffer, bufferPos(r8));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.originalBuffer, bufferPos(this.position));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte r11) {
            long r8 = this.position;
            if (r8 >= this.limit) goto L7;
            this.position = 1 + r8;
            UnsafeUtil.putByte(r8, r11);
            return;
        L7:
            throw new OutOfSpaceException(this.position, this.limit, 1);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r8, boolean r10) {
            writeTag(r8, 0);
            write(r10 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r8, byte[] r10) {
            writeByteArray(r8, r10, 0, r10.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r8, int r10, int r11) {
            writeUInt32NoTag(r11);
            write(r8, r10, r11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r8, ByteBuffer r10) {
            writeTag(r8, 2);
            writeUInt32NoTag(r10.capacity());
            writeRawBytes(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r8, ByteString r10) {
            writeTag(r8, 2);
            writeBytesNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r8) {
            writeUInt32NoTag(r8.size());
            r8.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r8, int r10) {
            writeTag(r8, 5);
            writeFixed32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r8) {
            this.buffer.putInt(bufferPos(this.position), r8);     // Catch: IndexOutOfBoundsException -> L5
            this.position += 4;
            return;
        L5:
            e = move-exception;
            throw new OutOfSpaceException(this.position, this.limit, 4, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r8, long r10) {
            writeTag(r8, 1);
            writeFixed64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r8) {
            this.buffer.putLong(bufferPos(this.position), r8);     // Catch: IndexOutOfBoundsException -> L5
            this.position += 8;
            return;
        L5:
            e = move-exception;
            throw new OutOfSpaceException(this.position, this.limit, 8, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r8, int r10) {
            writeTag(r8, 0);
            writeInt32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r8) {
            if (r8 < 0) goto L4;
            writeUInt32NoTag(r8);
            return;
        L4:
            writeUInt64NoTag(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r8) {
            write(r8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r8, MessageLite r10) {
            writeTag(r8, 2);
            writeMessageNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r8) {
            writeUInt32NoTag(r8.getSerializedSize());
            r8.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r8, MessageLite r10) {
            writeTag(1, 3);
            writeUInt32(2, r8);
            writeMessage(3, r10);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r8) {
            if (r8.hasArray() == false) goto L5;
            write(r8.array(), r8.arrayOffset(), r8.capacity());
            return;
        L5:
            ByteBuffer r10 = r8.duplicate();
            Java8Compatibility.clear(r10);
            write(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r8, ByteString r10) {
            writeTag(1, 3);
            writeUInt32(2, r8);
            writeBytes(3, r10);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r8, String r10) {
            writeTag(r8, 2);
            writeStringNoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r8) {
            long r10 = this.position;
            int r11 = CodedOutputStream.computeUInt32SizeNoTag(r8.length() * 3);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            int r12 = CodedOutputStream.computeUInt32SizeNoTag(r8.length());     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            if (r12 != r11) goto L6;
            int r13 = bufferPos(this.position) + r12;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            Java8Compatibility.position(this.buffer, r13);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            Utf8.encodeUtf8(r8, this.buffer);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            int r14 = this.buffer.position() - r13;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            writeUInt32NoTag(r14);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            this.position += (long) r14;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
        L17:
            return;
        L6:
            int r15 = Utf8.encodedLength(r8);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            writeUInt32NoTag(r15);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            repositionBuffer(this.position);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            Utf8.encodeUtf8(r8, this.buffer);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            this.position += (long) r15;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
        L14:
            e = move-exception;
            this.position = r10;
            repositionBuffer(r10);
            inefficientWriteStringNoTag(r8, e);
            return;
        L11:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r8, int r10) {
            writeUInt32NoTag(WireFormat.makeTag(r8, r10));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r8, int r10) {
            writeTag(r8, 0);
            writeUInt32NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r8) {
            long r10 = this.position;
            if (r10 > this.oneVarintLimit) goto L9;
        L5:
            if ((r8 & QesdkUtils.LIMITS.INT_8_LOWER) == 0) goto L6;
            UnsafeUtil.putByte(r10, (byte) (r8 | 128));
            r8 = r8 >>> 7;
            r10 = r10 + 1;
        L6:
            long r11 = 1 + r10;
            UnsafeUtil.putByte(r10, (byte) r8);
            this.position = r11;
            return;
        L9:
            if (r10 >= this.limit) goto L17;
            if ((r8 & QesdkUtils.LIMITS.INT_8_LOWER) == 0) goto L6;
            UnsafeUtil.putByte(r10, (byte) (r8 | 128));
            r8 = r8 >>> 7;
            r10 = r10 + 1;
            goto L9
        L17:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(r10), Long.valueOf(this.limit), 1}));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r8, long r10) {
            writeTag(r8, 0);
            writeUInt64NoTag(r10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r18) {
            long r8 = this.position;
            if (r8 > this.oneVarintLimit) goto L9;
            long r11 = r8;
            long r10 = r18;
        L6:
            if ((r10 & (-128)) == 0) goto L7;
            UnsafeUtil.putByte(r11, (byte) (((int) r10) | 128));
            r10 = r10 >>> 7;
            r11 = r11 + 1;
            goto L6
        L7:
            long r12 = 1 + r11;
            UnsafeUtil.putByte(r11, (byte) r10);
        L15:
            this.position = r12;
            return;
        L9:
            long r13 = r8;
            long r14 = r18;
        L11:
            if (r13 >= this.limit) goto L19;
            if ((r14 & (-128)) == 0) goto L14;
            UnsafeUtil.putByte(r13, (byte) (((int) r14) | 128));
            r14 = r14 >>> 7;
            r13 = r13 + 1;
            goto L11
        L14:
            r12 = 1 + r13;
            UnsafeUtil.putByte(r13, (byte) r14);
            goto L15
        L19:
            throw new OutOfSpaceException(r13, this.limit, 1);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r8) {
            int r10 = r8.remaining();     // Catch: BufferOverflowException -> L4
            repositionBuffer(this.position);     // Catch: BufferOverflowException -> L4
            this.buffer.put(r8);     // Catch: BufferOverflowException -> L4
            this.position += (long) r10;     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r8, byte[] r10, int r11, int r12) {
            writeTag(r8, 2);
            writeByteArrayNoTag(r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r8, int r10, int r11) {
            write(r8, r10, r11);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r12, int r13, int r14) {
            if (r12 == null) goto L12;
            if (r13 < 0) goto L12;
            if (r14 < 0) goto L12;
            if ((r12.length - r14) < r13) goto L12;
            long r10 = r14;
            long r8 = this.limit - r10;
            long r11 = this.position;
            if (r8 < r11) goto L12;
            UnsafeUtil.copyMemory(r12, r13, r11, r10);
            this.position += r10;
            return;
        L12:
            if (r12 != null) goto L16;
            throw new NullPointerException("value");
        L16:
            throw new OutOfSpaceException(this.position, this.limit, r14);
        }
    }

    static {
        logger = Logger.getLogger(CodedOutputStream.class.getName());
        HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();
    }

    private CodedOutputStream() {
    }

    public /* synthetic */ CodedOutputStream(AnonymousClass1 r8) {
        this();
    }

    public static /* synthetic */ boolean access$100() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static int computeBoolSize(int r8, boolean r10) {
        int r11 = computeTagSize(r8);
        return computeBoolSizeNoTag(r10) + r11;
    }

    public static int computeBoolSizeNoTag(boolean r8) {
        return 1;
    }

    public static int computeByteArraySize(int r8, byte[] r10) {
        int r11 = computeTagSize(r8);
        return computeByteArraySizeNoTag(r10) + r11;
    }

    public static int computeByteArraySizeNoTag(byte[] r8) {
        return computeLengthDelimitedFieldSize(r8.length);
    }

    public static int computeByteBufferSize(int r8, ByteBuffer r10) {
        int r11 = computeTagSize(r8);
        return computeByteBufferSizeNoTag(r10) + r11;
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer r8) {
        return computeLengthDelimitedFieldSize(r8.capacity());
    }

    public static int computeBytesSize(int r8, ByteString r10) {
        int r11 = computeTagSize(r8);
        return computeBytesSizeNoTag(r10) + r11;
    }

    public static int computeBytesSizeNoTag(ByteString r8) {
        return computeLengthDelimitedFieldSize(r8.size());
    }

    public static int computeDoubleSize(int r8, double r10) {
        int r11 = computeTagSize(r8);
        return computeDoubleSizeNoTag(r10) + r11;
    }

    public static int computeDoubleSizeNoTag(double r8) {
        return 8;
    }

    public static int computeEnumSize(int r8, int r10) {
        int r11 = computeTagSize(r8);
        return computeEnumSizeNoTag(r10) + r11;
    }

    public static int computeEnumSizeNoTag(int r8) {
        return computeInt32SizeNoTag(r8);
    }

    public static int computeFixed32Size(int r8, int r10) {
        int r11 = computeTagSize(r8);
        return computeFixed32SizeNoTag(r10) + r11;
    }

    public static int computeFixed32SizeNoTag(int r8) {
        return 4;
    }

    public static int computeFixed64Size(int r8, long r10) {
        int r11 = computeTagSize(r8);
        return computeFixed64SizeNoTag(r10) + r11;
    }

    public static int computeFixed64SizeNoTag(long r8) {
        return 8;
    }

    public static int computeFloatSize(int r8, float r10) {
        int r11 = computeTagSize(r8);
        return computeFloatSizeNoTag(r10) + r11;
    }

    public static int computeFloatSizeNoTag(float r8) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int r8, MessageLite r10) {
        int r11 = computeTagSize(r8) * 2;
        return r10.getSerializedSize() + r11;
    }

    @InlineMe(replacement = "value.getSerializedSize()")
    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite r8) {
        return r8.getSerializedSize();
    }

    public static int computeInt32Size(int r8, int r10) {
        int r11 = computeTagSize(r8);
        return computeInt32SizeNoTag(r10) + r11;
    }

    public static int computeInt32SizeNoTag(int r8) {
        return computeUInt64SizeNoTag(r8);
    }

    public static int computeInt64Size(int r8, long r10) {
        int r11 = computeTagSize(r8);
        return computeInt64SizeNoTag(r10) + r11;
    }

    public static int computeInt64SizeNoTag(long r8) {
        return computeUInt64SizeNoTag(r8);
    }

    @InlineMe(replacement = "value.computeMessageSetExtensionSize(fieldNumber)")
    @Deprecated
    public static int computeLazyFieldMessageSetExtensionSize(int r8, LazyFieldLite r10) {
        return r10.computeMessageSetExtensionSize(r8);
    }

    @InlineMe(replacement = "value.computeSize(fieldNumber)")
    @Deprecated
    public static int computeLazyFieldSize(int r8, LazyFieldLite r10) {
        return r10.computeSize(r8);
    }

    @InlineMe(replacement = "value.computeSizeNoTag()")
    @Deprecated
    public static int computeLazyFieldSizeNoTag(LazyFieldLite r8) {
        return r8.computeSizeNoTag();
    }

    public static int computeLengthDelimitedFieldSize(int r8) {
        return computeUInt32SizeNoTag(r8) + r8;
    }

    public static int computeMessageSetExtensionSize(int r8, MessageLite r10) {
        int r11 = computeTagSize(1) * 2;
        int r12 = computeUInt32Size(2, r8) + r11;
        return computeMessageSize(3, r10) + r12;
    }

    public static int computeMessageSize(int r8, MessageLite r10) {
        int r11 = computeTagSize(r8);
        return computeMessageSizeNoTag(r10) + r11;
    }

    public static int computeMessageSizeNoTag(MessageLite r8) {
        return computeLengthDelimitedFieldSize(r8.getSerializedSize());
    }

    public static int computePreferredBufferSize(int r8) {
        if (r8 <= 4096) goto L5;
        return 4096;
    L5:
        return r8;
    }

    public static int computeRawMessageSetExtensionSize(int r8, ByteString r10) {
        int r11 = computeTagSize(1) * 2;
        int r12 = computeUInt32Size(2, r8) + r11;
        return computeBytesSize(3, r10) + r12;
    }

    @InlineMe(imports = {"com.google.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt32SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint32Size(int r8) {
        return computeUInt32SizeNoTag(r8);
    }

    @InlineMe(imports = {"com.google.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt64SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint64Size(long r8) {
        return computeUInt64SizeNoTag(r8);
    }

    public static int computeSFixed32Size(int r8, int r10) {
        int r11 = computeTagSize(r8);
        return computeSFixed32SizeNoTag(r10) + r11;
    }

    public static int computeSFixed32SizeNoTag(int r8) {
        return 4;
    }

    public static int computeSFixed64Size(int r8, long r10) {
        int r11 = computeTagSize(r8);
        return computeSFixed64SizeNoTag(r10) + r11;
    }

    public static int computeSFixed64SizeNoTag(long r8) {
        return 8;
    }

    public static int computeSInt32Size(int r8, int r10) {
        int r11 = computeTagSize(r8);
        return computeSInt32SizeNoTag(r10) + r11;
    }

    public static int computeSInt32SizeNoTag(int r8) {
        return computeUInt32SizeNoTag(encodeZigZag32(r8));
    }

    public static int computeSInt64Size(int r8, long r10) {
        int r11 = computeTagSize(r8);
        return computeSInt64SizeNoTag(r10) + r11;
    }

    public static int computeSInt64SizeNoTag(long r8) {
        return computeUInt64SizeNoTag(encodeZigZag64(r8));
    }

    public static int computeStringSize(int r8, String r10) {
        int r11 = computeTagSize(r8);
        return computeStringSizeNoTag(r10) + r11;
    }

    public static int computeStringSizeNoTag(String r8) {
        int r10 = Utf8.encodedLength(r8);     // Catch: Utf8.UnpairedSurrogateException -> L4
    L6:
        return computeLengthDelimitedFieldSize(r10);
    L4:
        r10 = r8.getBytes(Internal.UTF_8).length;
        goto L6
    }

    public static int computeTagSize(int r8) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(r8, 0));
    }

    public static int computeUInt32Size(int r8, int r10) {
        int r11 = computeTagSize(r8);
        return computeUInt32SizeNoTag(r10) + r11;
    }

    public static int computeUInt32SizeNoTag(int r8) {
        return (352 - (Integer.numberOfLeadingZeros(r8) * 9)) >>> 6;
    }

    public static int computeUInt64Size(int r8, long r10) {
        int r11 = computeTagSize(r8);
        return computeUInt64SizeNoTag(r10) + r11;
    }

    public static int computeUInt64SizeNoTag(long r8) {
        return (640 - (Long.numberOfLeadingZeros(r8) * 9)) >>> 6;
    }

    public static int encodeZigZag32(int r8) {
        int r10 = r8 << 1;
        return (r8 >> 31) ^ r10;
    }

    public static long encodeZigZag64(long r8) {
        long r10 = r8 << 1;
        return (r8 >> 63) ^ r10;
    }

    public static CodedOutputStream newInstance(ByteOutput r8, int r10) {
        if (r10 < 0) goto L6;
        return new ByteOutputEncoder(r8, r10);
    L6:
        throw new IllegalArgumentException("bufferSize must be positive");
    }

    public static CodedOutputStream newSafeInstance(ByteBuffer r8) {
        return new SafeDirectNioEncoder(r8);
    }

    public static CodedOutputStream newUnsafeInstance(ByteBuffer r8) {
        return new UnsafeDirectNioEncoder(r8);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public abstract void flush();

    public abstract int getTotalBytesWritten();

    public final void inefficientWriteStringNoTag(String r8, Utf8.UnpairedSurrogateException r10) {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", r10);
        byte[] r11 = r8.getBytes(Internal.UTF_8);
        writeUInt32NoTag(r11.length);     // Catch: IndexOutOfBoundsException -> L5
        writeLazy(r11, 0, r11.length);     // Catch: IndexOutOfBoundsException -> L5
        return;
    L5:
        e = move-exception;
        throw new OutOfSpaceException(e);
    }

    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte r8);

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(ByteBuffer r8);

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte[] r8, int r10, int r11);

    public abstract void writeBool(int r8, boolean r10);

    public final void writeBoolNoTag(boolean r8) {
        write(r8 ? 1 : 0);
    }

    public abstract void writeByteArray(int r8, byte[] r10);

    public abstract void writeByteArray(int r8, byte[] r10, int r11, int r12);

    public final void writeByteArrayNoTag(byte[] r8) {
        writeByteArrayNoTag(r8, 0, r8.length);
    }

    public abstract void writeByteArrayNoTag(byte[] r8, int r10, int r11);

    public abstract void writeByteBuffer(int r8, ByteBuffer r10);

    public abstract void writeBytes(int r8, ByteString r10);

    public abstract void writeBytesNoTag(ByteString r8);

    public final void writeDouble(int r8, double r10) {
        writeFixed64(r8, Double.doubleToRawLongBits(r10));
    }

    public final void writeDoubleNoTag(double r8) {
        writeFixed64NoTag(Double.doubleToRawLongBits(r8));
    }

    public final void writeEnum(int r8, int r10) {
        writeInt32(r8, r10);
    }

    public final void writeEnumNoTag(int r8) {
        writeInt32NoTag(r8);
    }

    public abstract void writeFixed32(int r8, int r10);

    public abstract void writeFixed32NoTag(int r8);

    public abstract void writeFixed64(int r8, long r10);

    public abstract void writeFixed64NoTag(long r8);

    public final void writeFloat(int r8, float r10) {
        writeFixed32(r8, Float.floatToRawIntBits(r10));
    }

    public final void writeFloatNoTag(float r8) {
        writeFixed32NoTag(Float.floatToRawIntBits(r8));
    }

    @Deprecated
    public final void writeGroup(int r8, MessageLite r10) {
        writeTag(r8, 3);
        writeGroupNoTag(r10);
        writeTag(r8, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite r8) {
        r8.writeTo(this);
    }

    public abstract void writeInt32(int r8, int r10);

    public abstract void writeInt32NoTag(int r8);

    public final void writeInt64(int r8, long r10) {
        writeUInt64(r8, r10);
    }

    public final void writeInt64NoTag(long r8) {
        writeUInt64NoTag(r8);
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer r8);

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(byte[] r8, int r10, int r11);

    public abstract void writeMessage(int r8, MessageLite r10);

    public abstract void writeMessageNoTag(MessageLite r8);

    public abstract void writeMessageSetExtension(int r8, MessageLite r10);

    public final void writeRawByte(byte r8) {
        write(r8);
    }

    public final void writeRawBytes(ByteString r8) {
        r8.writeTo(this);
    }

    public abstract void writeRawBytes(ByteBuffer r8);

    @InlineMe(replacement = "this.writeFixed32NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian32(int r8) {
        writeFixed32NoTag(r8);
    }

    @InlineMe(replacement = "this.writeFixed64NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian64(long r8) {
        writeFixed64NoTag(r8);
    }

    public abstract void writeRawMessageSetExtension(int r8, ByteString r10);

    @InlineMe(replacement = "this.writeUInt32NoTag(value)")
    @Deprecated
    public final void writeRawVarint32(int r8) {
        writeUInt32NoTag(r8);
    }

    @InlineMe(replacement = "this.writeUInt64NoTag(value)")
    @Deprecated
    public final void writeRawVarint64(long r8) {
        writeUInt64NoTag(r8);
    }

    public final void writeSFixed32(int r8, int r10) {
        writeFixed32(r8, r10);
    }

    public final void writeSFixed32NoTag(int r8) {
        writeFixed32NoTag(r8);
    }

    public final void writeSFixed64(int r8, long r10) {
        writeFixed64(r8, r10);
    }

    public final void writeSFixed64NoTag(long r8) {
        writeFixed64NoTag(r8);
    }

    public final void writeSInt32(int r8, int r10) {
        writeUInt32(r8, encodeZigZag32(r10));
    }

    public final void writeSInt32NoTag(int r8) {
        writeUInt32NoTag(encodeZigZag32(r8));
    }

    public final void writeSInt64(int r8, long r10) {
        writeUInt64(r8, encodeZigZag64(r10));
    }

    public final void writeSInt64NoTag(long r8) {
        writeUInt64NoTag(encodeZigZag64(r8));
    }

    public abstract void writeString(int r8, String r10);

    public abstract void writeStringNoTag(String r8);

    public abstract void writeTag(int r8, int r10);

    public abstract void writeUInt32(int r8, int r10);

    public abstract void writeUInt32NoTag(int r8);

    public abstract void writeUInt64(int r8, long r10);

    public abstract void writeUInt64NoTag(long r8);

    public static CodedOutputStream newInstance(OutputStream r8) {
        return newInstance(r8, 4096);
    }

    public final void writeRawByte(int r8) {
        write((byte) r8);
    }

    public final void writeRawBytes(byte[] r8) {
        write(r8, 0, r8.length);
    }

    public static CodedOutputStream newInstance(OutputStream r8, int r10) {
        return new OutputStreamEncoder(r8, r10);
    }

    public final void writeRawBytes(byte[] r8, int r10, int r11) {
        write(r8, r10, r11);
    }

    public static CodedOutputStream newInstance(ByteBuffer r8) {
        if (r8.hasArray() == false) goto L7;
        return new HeapNioEncoder(r8);
    L7:
        if (r8.isDirect() == false) goto L16;
        if (r8.isReadOnly() == true) goto L16;
        if (UnsafeDirectNioEncoder.isSupported() == false) goto L14;
        return newUnsafeInstance(r8);
    L14:
        return newSafeInstance(r8);
    L16:
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer r8, int r10) {
        return newInstance(r8);
    }

    public static CodedOutputStream newInstance(byte[] r8) {
        return newInstance(r8, 0, r8.length);
    }

    public static CodedOutputStream newInstance(byte[] r8, int r10, int r11) {
        return new ArrayEncoder(r8, r10, r11);
    }
}
