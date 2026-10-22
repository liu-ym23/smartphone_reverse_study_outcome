package com.google.protobuf;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private static final Logger logger = null;
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;

    /* JADX INFO: renamed from: com.google.protobuf.CodedOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        AbstractBufferedEncoder(int r2) {
            super(null);
            if (r2 < 0) goto L7;
            byte[] r3 = new byte[Math.max(r2, 20)];
            this.buffer = r3;
            this.limit = r3.length;
            return;
        L7:
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        final void buffer(byte r3) {
            int r0 = this.position;
            this.buffer[r0] = r3;
            this.position = r0 + 1;
            this.totalBytesWritten++;
        }

        final void bufferFixed32NoTag(int r5) {
            int r0 = this.position;
            byte[] r1 = this.buffer;
            int r2 = r0 + 1;
            r1[r0] = (byte) r5;
            int r3 = r2 + 1;
            r1[r2] = (byte) (r5 >> 8);
            int r4 = r3 + 1;
            r1[r3] = (byte) (r5 >> 16);
            r1[r4] = (byte) (r5 >> 24);
            this.position = r4 + 1;
            this.totalBytesWritten += 4;
        }

        final void bufferFixed64NoTag(long r7) {
            int r0 = this.position;
            byte[] r1 = this.buffer;
            int r2 = r0 + 1;
            r1[r0] = (byte) r7;
            int r3 = r2 + 1;
            r1[r2] = (byte) (r7 >> 8);
            int r4 = r3 + 1;
            r1[r3] = (byte) (r7 >> 16);
            int r5 = r4 + 1;
            r1[r4] = (byte) (r7 >> 24);
            int r6 = r5 + 1;
            r1[r5] = (byte) (r7 >> 32);
            int r8 = r6 + 1;
            r1[r6] = (byte) (r7 >> 40);
            int r9 = r8 + 1;
            r1[r8] = (byte) (r7 >> 48);
            r1[r9] = (byte) (r7 >> 56);
            this.position = r9 + 1;
            this.totalBytesWritten += 8;
        }

        final void bufferInt32NoTag(int r3) {
            if (r3 < 0) goto L4;
            bufferUInt32NoTag(r3);
            return;
        L4:
            bufferUInt64NoTag(r3);
        }

        final void bufferTag(int r1, int r2) {
            bufferUInt32NoTag(WireFormat.makeTag(r1, r2));
        }

        final void bufferUInt32NoTag(int r7) {
            if (CodedOutputStream.access$100() == false) goto L11;
            long r0 = this.position;
        L6:
            if ((r7 & (-128)) == 0) goto L7;
            byte[] r2 = this.buffer;
            int r3 = this.position;
            this.position = r3 + 1;
            UnsafeUtil.putByte(r2, r3, (byte) (r7 | 128));
            r7 = r7 >>> 7;
            goto L6
        L7:
            byte[] r4 = this.buffer;
            int r5 = this.position;
            this.position = r5 + 1;
            UnsafeUtil.putByte(r4, r5, (byte) r7);
            this.totalBytesWritten += (int) (((long) this.position) - r0);
            return;
        L11:
            if ((r7 & (-128)) == 0) goto L12;
            byte[] r1 = this.buffer;
            int r6 = this.position;
            this.position = r6 + 1;
            r1[r6] = (byte) (r7 | 128);
            this.totalBytesWritten++;
            r7 = r7 >>> 7;
            goto L11
        L12:
            byte[] r8 = this.buffer;
            int r9 = this.position;
            this.position = r9 + 1;
            r8[r9] = (byte) r7;
            this.totalBytesWritten++;
        }

        final void bufferUInt64NoTag(long r12) {
            if (CodedOutputStream.access$100() == false) goto L11;
            long r6 = this.position;
        L6:
            if ((r12 & (-128)) == 0) goto L7;
            byte[] r0 = this.buffer;
            int r8 = this.position;
            this.position = r8 + 1;
            UnsafeUtil.putByte(r0, r8, (byte) (((int) r12) | 128));
            r12 = r12 >>> 7;
            goto L6
        L7:
            byte[] r1 = this.buffer;
            int r2 = this.position;
            this.position = r2 + 1;
            UnsafeUtil.putByte(r1, r2, (byte) r12);
            this.totalBytesWritten += (int) (((long) this.position) - r6);
            return;
        L11:
            if ((r12 & (-128)) == 0) goto L12;
            byte[] r3 = this.buffer;
            int r7 = this.position;
            this.position = r7 + 1;
            r3[r7] = (byte) (((int) r12) | 128);
            this.totalBytesWritten++;
            r12 = r12 >>> 7;
            goto L11
        L12:
            byte[] r4 = this.buffer;
            int r5 = this.position;
            this.position = r5 + 1;
            r4[r5] = (byte) r12;
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

    private static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        ArrayEncoder(byte[] r4, int r5, int r6) {
            super(null);
            Objects.requireNonNull(r4, "buffer");
            int r2 = r5 + r6;
            if (((r5 | r6) | (r4.length - r2)) < 0) goto L7;
            this.buffer = r4;
            this.offset = r5;
            this.position = r5;
            this.limit = r2;
            return;
        L7:
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r4.length), Integer.valueOf(r5), Integer.valueOf(r6)}));
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
        public final void write(byte r4) {
            int r0 = this.position;
            int r2 = r0 + 1;
            this.buffer[r0] = r4;     // Catch: IndexOutOfBoundsException -> L8
            this.position = r2;
            return;
        L8:
            e = e;
            r0 = r2;
        L12:
            throw new OutOfSpaceException(r0, this.limit, 1, e);
        L10:
            e = e;
            goto L12
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(ByteBuffer r4) {
            int r0 = r4.remaining();
            r4.get(this.buffer, this.position, r0);     // Catch: IndexOutOfBoundsException -> L5
            this.position += r0;     // Catch: IndexOutOfBoundsException -> L5
            return;
        L5:
            e = move-exception;
            throw new OutOfSpaceException(this.position, this.limit, r0, e);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte[] r3, int r4, int r5) {
            System.arraycopy(r3, r4, this.buffer, this.position, r5);     // Catch: IndexOutOfBoundsException -> L5
            this.position += r5;
            return;
        L5:
            e = move-exception;
            throw new OutOfSpaceException(this.position, this.limit, r5, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int r2, boolean r3) {
            writeTag(r2, 0);
            write(r3 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int r3, byte[] r4) {
            writeByteArray(r3, r4, 0, r4.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int r2, byte[] r3, int r4, int r5) {
            writeTag(r2, 2);
            writeByteArrayNoTag(r3, r4, r5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] r1, int r2, int r3) {
            writeUInt32NoTag(r3);
            write(r1, r2, r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteBuffer(int r2, ByteBuffer r3) {
            writeTag(r2, 2);
            writeUInt32NoTag(r3.capacity());
            writeRawBytes(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int r2, ByteString r3) {
            writeTag(r2, 2);
            writeBytesNoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString r2) {
            writeUInt32NoTag(r2.size());
            r2.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int r2, int r3) {
            writeTag(r2, 5);
            writeFixed32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int r6) {
            int r0 = this.position;
            byte[] r2 = this.buffer;     // Catch: IndexOutOfBoundsException -> L6
            r2[r0] = (byte) r6;     // Catch: IndexOutOfBoundsException -> L6
            r2[r0 + 1] = (byte) (r6 >> 8);     // Catch: IndexOutOfBoundsException -> L6
            r2[r0 + 2] = (byte) (r6 >> 16);     // Catch: IndexOutOfBoundsException -> L6
            r2[r0 + 3] = (byte) (r6 >> 24);     // Catch: IndexOutOfBoundsException -> L6
            this.position = r0 + 4;
            return;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(r0, this.limit, 4, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int r2, long r3) {
            writeTag(r2, 1);
            writeFixed64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long r7) {
            int r0 = this.position;
            byte[] r2 = this.buffer;     // Catch: IndexOutOfBoundsException -> L6
            r2[r0] = (byte) r7;     // Catch: IndexOutOfBoundsException -> L6
            r2[r0 + 1] = (byte) (r7 >> 8);     // Catch: IndexOutOfBoundsException -> L6
            r2[r0 + 2] = (byte) (r7 >> 16);     // Catch: IndexOutOfBoundsException -> L6
            r2[r0 + 3] = (byte) (r7 >> 24);     // Catch: IndexOutOfBoundsException -> L6
            r2[r0 + 4] = (byte) (r7 >> 32);     // Catch: IndexOutOfBoundsException -> L6
            r2[r0 + 5] = (byte) (r7 >> 40);     // Catch: IndexOutOfBoundsException -> L6
            r2[r0 + 6] = (byte) (r7 >> 48);     // Catch: IndexOutOfBoundsException -> L6
            r2[r0 + 7] = (byte) (r7 >> 56);     // Catch: IndexOutOfBoundsException -> L6
            this.position = r0 + 8;
            return;
        L6:
            e = move-exception;
            throw new OutOfSpaceException(r0, this.limit, 8, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int r2, int r3) {
            writeTag(r2, 0);
            writeInt32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int r3) {
            if (r3 < 0) goto L4;
            writeUInt32NoTag(r3);
            return;
        L4:
            writeUInt64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer r1) {
            write(r1);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(byte[] r1, int r2, int r3) {
            write(r1, r2, r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int r3, MessageLite r4) {
            MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
            writeTag(r3, 2);
            writeMessageNoTag(r5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void writeMessage(int r3, MessageLite r4, Schema r5) {
            MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
            Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            writeTag(r3, 2);
            writeUInt32NoTag(((AbstractMessageLite) ZeusTransformUtils.preCheckCast(r6, AbstractMessageLite.class, "com.obric.memorydata.plugin")).getSerializedSize(r7));
            r7.writeTo(r6, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite r3) {
            MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            writeUInt32NoTag(r4.getSerializedSize());
            r4.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void writeMessageNoTag(MessageLite r3, Schema r4) {
            MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
            writeUInt32NoTag(((AbstractMessageLite) ZeusTransformUtils.preCheckCast(r5, AbstractMessageLite.class, "com.obric.memorydata.plugin")).getSerializedSize(r6));
            r6.writeTo(r5, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int r4, MessageLite r5) {
            MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r5, MessageLite.class, "com.obric.memorydata.plugin");
            writeTag(1, 3);
            writeUInt32(2, r4);
            writeMessage(3, r6);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer r3) {
            if (r3.hasArray() == false) goto L5;
            write(r3.array(), r3.arrayOffset(), r3.capacity());
            return;
        L5:
            ByteBuffer r4 = r3.duplicate();
            Java8Compatibility.clear(r4);
            write(r4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int r4, ByteString r5) {
            writeTag(1, 3);
            writeUInt32(2, r4);
            writeBytes(3, r5);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int r2, String r3) {
            writeTag(r2, 2);
            writeStringNoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeStringNoTag(String r6) {
            int r0 = this.position;
            int r1 = computeUInt32SizeNoTag(r6.length() * 3);     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            int r2 = computeUInt32SizeNoTag(r6.length());     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            if (r2 != r1) goto L7;
            int r3 = r0 + r2;     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            this.position = r3;     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            int r4 = Utf8.encode(r6, this.buffer, r3, spaceLeft());     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            this.position = r0;     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            writeUInt32NoTag((r4 - r0) - r2);     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
        L6:
            this.position = r4;     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
        L17:
            return;
        L7:
            writeUInt32NoTag(Utf8.encodedLength(r6));     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
            r4 = Utf8.encode(r6, this.buffer, this.position, spaceLeft());     // Catch: IndexOutOfBoundsException -> L9 Utf8.UnpairedSurrogateException -> L12
        L12:
            e = move-exception;
            this.position = r0;
            inefficientWriteStringNoTag(r6, e);
            return;
        L9:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int r1, int r2) {
            writeUInt32NoTag(WireFormat.makeTag(r1, r2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int r2, int r3) {
            writeTag(r2, 0);
            writeUInt32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int r5) {
            int r0 = this.position;
        L4:
            if ((r5 & (-128)) == 0) goto L5;
        L16:
            e = e;
        L18:
            throw new OutOfSpaceException(r0, this.limit, 1, e);
        L11:
            int r2 = r0 + 1;
            this.buffer[r0] = (byte) (r5 | 128);     // Catch: IndexOutOfBoundsException -> L14
            r5 = r5 >>> 7;
            r0 = r2;
        L14:
            e = e;
            r0 = r2;
            goto L18
        L5:
            r2 = r0 + 1;
            this.buffer[r0] = (byte) r5;     // Catch: IndexOutOfBoundsException -> L14
            this.position = r2;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int r2, long r3) {
            writeTag(r2, 0);
            writeUInt64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long r11) {
            int r0 = this.position;
            if (CodedOutputStream.access$100() == false) goto L11;
            if (spaceLeft() < 10) goto L11;
        L7:
            if ((r11 & (-128)) == 0) goto L8;
            UnsafeUtil.putByte(this.buffer, r0, (byte) (((int) r11) | 128));
            r11 = r11 >>> 7;
            r0 = r0 + 1;
            goto L7
        L8:
            int r2 = r0 + 1;
            UnsafeUtil.putByte(this.buffer, r0, (byte) r11);
        L15:
            this.position = r2;
            return;
        L11:
            if ((r11 & (-128)) == 0) goto L12;
        L25:
            e = e;
        L27:
            throw new OutOfSpaceException(r0, this.limit, 1, e);
        L20:
            int r7 = r0 + 1;
            this.buffer[r0] = (byte) (((int) r11) | 128);     // Catch: IndexOutOfBoundsException -> L23
            r11 = r11 >>> 7;
            r0 = r7;
        L23:
            e = e;
            r0 = r7;
            goto L27
        L12:
            r2 = r0 + 1;
            this.buffer[r0] = (byte) r11;     // Catch: IndexOutOfBoundsException -> L17
        L17:
            e = e;
            r0 = r2;
            goto L27
        }
    }

    private static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        ByteOutputEncoder(ByteOutput r1, int r2) {
            super(r2);
            Objects.requireNonNull(r1, "out");
            this.out = r1;
        }

        private void doFlush() {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int r3) {
            if ((this.limit - this.position) >= r3) goto L6;
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
        public void write(byte r3) {
            if (this.position != this.limit) goto L5;
            doFlush();
        L5:
            buffer(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r3) {
            flush();
            int r0 = r3.remaining();
            this.out.write(r3);
            this.totalBytesWritten += r0;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r2, int r3, int r4) {
            flush();
            this.out.write(r2, r3, r4);
            this.totalBytesWritten += r4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r2, boolean r3) {
            flushIfNotAvailable(11);
            bufferTag(r2, 0);
            buffer(r3 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r3, byte[] r4) {
            writeByteArray(r3, r4, 0, r4.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r2, byte[] r3, int r4, int r5) {
            writeTag(r2, 2);
            writeByteArrayNoTag(r3, r4, r5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r1, int r2, int r3) {
            writeUInt32NoTag(r3);
            write(r1, r2, r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r2, ByteBuffer r3) {
            writeTag(r2, 2);
            writeUInt32NoTag(r3.capacity());
            writeRawBytes(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r2, ByteString r3) {
            writeTag(r2, 2);
            writeBytesNoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r2) {
            writeUInt32NoTag(r2.size());
            r2.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r2, int r3) {
            flushIfNotAvailable(14);
            bufferTag(r2, 5);
            bufferFixed32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r2) {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(r2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r2, long r3) {
            flushIfNotAvailable(18);
            bufferTag(r2, 1);
            bufferFixed64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r2) {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(r2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r2, int r3) {
            flushIfNotAvailable(20);
            bufferTag(r2, 0);
            bufferInt32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r3) {
            if (r3 < 0) goto L4;
            writeUInt32NoTag(r3);
            return;
        L4:
            writeUInt64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r3) {
            flush();
            int r0 = r3.remaining();
            this.out.writeLazy(r3);
            this.totalBytesWritten += r0;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r2, int r3, int r4) {
            flush();
            this.out.writeLazy(r2, r3, r4);
            this.totalBytesWritten += r4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r3, MessageLite r4) {
            MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
            writeTag(r3, 2);
            writeMessageNoTag(r5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessage(int r3, MessageLite r4, Schema r5) {
            MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
            Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            writeTag(r3, 2);
            writeMessageNoTag(r6, r7);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r3) {
            MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            writeUInt32NoTag(r4.getSerializedSize());
            r4.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite r3, Schema r4) {
            MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
            writeUInt32NoTag(((AbstractMessageLite) ZeusTransformUtils.preCheckCast(r5, AbstractMessageLite.class, "com.obric.memorydata.plugin")).getSerializedSize(r6));
            r6.writeTo(r5, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r4, MessageLite r5) {
            MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r5, MessageLite.class, "com.obric.memorydata.plugin");
            writeTag(1, 3);
            writeUInt32(2, r4);
            writeMessage(3, r6);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r3) {
            if (r3.hasArray() == false) goto L5;
            write(r3.array(), r3.arrayOffset(), r3.capacity());
            return;
        L5:
            ByteBuffer r4 = r3.duplicate();
            Java8Compatibility.clear(r4);
            write(r4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r4, ByteString r5) {
            writeTag(1, 3);
            writeUInt32(2, r4);
            writeBytes(3, r5);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r2, String r3) {
            writeTag(r2, 2);
            writeStringNoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r7) {
            int r0 = r7.length() * 3;
            int r1 = computeUInt32SizeNoTag(r0);
            int r2 = r1 + r0;
            if (r2 <= this.limit) goto L7;
            byte[] r3 = new byte[r0];
            int r8 = Utf8.encode(r7, r3, 0, r0);
            writeUInt32NoTag(r8);
            writeLazy(r3, 0, r8);
            return;
        L7:
            if (r2 <= (this.limit - this.position)) goto L9;
            doFlush();
        L9:
            int r4 = this.position;
            int r5 = computeUInt32SizeNoTag(r7.length());     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            if (r5 != r1) goto L13;
            this.position = r4 + r5;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            int r6 = Utf8.encode(r7, this.buffer, this.position, this.limit - this.position);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = r4;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            int r9 = (r6 - r4) - r5;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            bufferUInt32NoTag(r9);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = r6;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.totalBytesWritten += r9;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
        L21:
            return;
        L13:
            int r10 = Utf8.encodedLength(r7);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            bufferUInt32NoTag(r10);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = Utf8.encode(r7, this.buffer, this.position, r10);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.totalBytesWritten += r10;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
        L18:
            e = move-exception;
            this.totalBytesWritten -= this.position - r4;
            this.position = r4;
            inefficientWriteStringNoTag(r7, e);
            return;
        L15:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r1, int r2) {
            writeUInt32NoTag(WireFormat.makeTag(r1, r2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r2, int r3) {
            flushIfNotAvailable(20);
            bufferTag(r2, 0);
            bufferUInt32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r2) {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(r2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r2, long r3) {
            flushIfNotAvailable(20);
            bufferTag(r2, 0);
            bufferUInt64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r2) {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(r2);
        }
    }

    private static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        HeapNioEncoder(ByteBuffer r4) {
            super(r4.array(), r4.arrayOffset() + r4.position(), r4.remaining());
            this.byteBuffer = r4;
            this.initialPosition = r4.position();
        }

        @Override // com.google.protobuf.CodedOutputStream.ArrayEncoder, com.google.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.byteBuffer, this.initialPosition + getTotalBytesWritten());
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(int r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        OutOfSpaceException(int r8, int r9, int r10, Throwable r11) {
            this(r8, r9, r10, r11);
        }

        OutOfSpaceException(long r8, long r10, int r12) {
            this(r8, r10, r12, null);
        }

        OutOfSpaceException(long r3, long r5, int r7, Throwable r8) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(r3), Long.valueOf(r5), Integer.valueOf(r7)}), r8);
        }

        OutOfSpaceException(String r3) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + r3);
        }

        OutOfSpaceException(String r3, Throwable r4) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + r3, r4);
        }

        OutOfSpaceException(Throwable r2) {
            super(MESSAGE, r2);
        }
    }

    private static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        OutputStreamEncoder(OutputStream r1, int r2) {
            super(r2);
            Objects.requireNonNull(r1, "out");
            this.out = r1;
        }

        private void doFlush() {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int r3) {
            if ((this.limit - this.position) >= r3) goto L6;
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
        public void write(byte r3) {
            if (this.position != this.limit) goto L5;
            doFlush();
        L5:
            buffer(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r6) {
            int r0 = r6.remaining();
            if ((this.limit - this.position) < r0) goto L6;
            r6.get(this.buffer, this.position, r0);
            this.position += r0;
        L5:
            this.totalBytesWritten += r0;
            return;
        L6:
            int r1 = this.limit - this.position;
            r6.get(this.buffer, this.position, r1);
            r0 = r0 - r1;
            this.position = this.limit;
            this.totalBytesWritten += r1;
            doFlush();
        L8:
            if (r0 <= this.limit) goto L10;
            r6.get(this.buffer, 0, this.limit);
            this.out.write(this.buffer, 0, this.limit);
            r0 = r0 - this.limit;
            this.totalBytesWritten += this.limit;
            goto L8
        L10:
            r6.get(this.buffer, 0, r0);
            this.position = r0;
            goto L5
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r4, int r5, int r6) {
            if ((this.limit - this.position) < r6) goto L6;
            System.arraycopy(r4, r5, this.buffer, this.position, r6);
            this.position += r6;
        L5:
            this.totalBytesWritten += r6;
            return;
        L6:
            int r0 = this.limit - this.position;
            System.arraycopy(r4, r5, this.buffer, this.position, r0);
            int r7 = r5 + r0;
            r6 = r6 - r0;
            this.position = this.limit;
            this.totalBytesWritten += r0;
            doFlush();
            if (r6 > this.limit) goto L9;
            System.arraycopy(r4, r7, this.buffer, 0, r6);
            this.position = r6;
            goto L5
        L9:
            this.out.write(r4, r7, r6);
            goto L5
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r2, boolean r3) {
            flushIfNotAvailable(11);
            bufferTag(r2, 0);
            buffer(r3 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r3, byte[] r4) {
            writeByteArray(r3, r4, 0, r4.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r2, byte[] r3, int r4, int r5) {
            writeTag(r2, 2);
            writeByteArrayNoTag(r3, r4, r5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r1, int r2, int r3) {
            writeUInt32NoTag(r3);
            write(r1, r2, r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r2, ByteBuffer r3) {
            writeTag(r2, 2);
            writeUInt32NoTag(r3.capacity());
            writeRawBytes(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r2, ByteString r3) {
            writeTag(r2, 2);
            writeBytesNoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r2) {
            writeUInt32NoTag(r2.size());
            r2.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r2, int r3) {
            flushIfNotAvailable(14);
            bufferTag(r2, 5);
            bufferFixed32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r2) {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(r2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r2, long r3) {
            flushIfNotAvailable(18);
            bufferTag(r2, 1);
            bufferFixed64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r2) {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(r2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r2, int r3) {
            flushIfNotAvailable(20);
            bufferTag(r2, 0);
            bufferInt32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r3) {
            if (r3 < 0) goto L4;
            writeUInt32NoTag(r3);
            return;
        L4:
            writeUInt64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r1) {
            write(r1);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r1, int r2, int r3) {
            write(r1, r2, r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r3, MessageLite r4) {
            MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
            writeTag(r3, 2);
            writeMessageNoTag(r5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessage(int r3, MessageLite r4, Schema r5) {
            MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
            Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            writeTag(r3, 2);
            writeMessageNoTag(r6, r7);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r3) {
            MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            writeUInt32NoTag(r4.getSerializedSize());
            r4.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite r3, Schema r4) {
            MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
            writeUInt32NoTag(((AbstractMessageLite) ZeusTransformUtils.preCheckCast(r5, AbstractMessageLite.class, "com.obric.memorydata.plugin")).getSerializedSize(r6));
            r6.writeTo(r5, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r4, MessageLite r5) {
            MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r5, MessageLite.class, "com.obric.memorydata.plugin");
            writeTag(1, 3);
            writeUInt32(2, r4);
            writeMessage(3, r6);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r3) {
            if (r3.hasArray() == false) goto L5;
            write(r3.array(), r3.arrayOffset(), r3.capacity());
            return;
        L5:
            ByteBuffer r4 = r3.duplicate();
            Java8Compatibility.clear(r4);
            write(r4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r4, ByteString r5) {
            writeTag(1, 3);
            writeUInt32(2, r4);
            writeBytes(3, r5);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r2, String r3) {
            writeTag(r2, 2);
            writeStringNoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r7) {
            int r0 = r7.length() * 3;     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r1 = computeUInt32SizeNoTag(r0);     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r2 = r1 + r0;     // Catch: Utf8.UnpairedSurrogateException -> L22
            if (r2 <= this.limit) goto L7;
            byte[] r3 = new byte[r0];     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r4 = Utf8.encode(r7, r3, 0, r0);     // Catch: Utf8.UnpairedSurrogateException -> L22
            writeUInt32NoTag(r4);     // Catch: Utf8.UnpairedSurrogateException -> L22
            writeLazy(r3, 0, r4);     // Catch: Utf8.UnpairedSurrogateException -> L22
            return;
        L7:
            if (r2 <= (this.limit - this.position)) goto L9;
            doFlush();     // Catch: Utf8.UnpairedSurrogateException -> L22
        L9:
            int r5 = computeUInt32SizeNoTag(r7.length());     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r6 = this.position;     // Catch: Utf8.UnpairedSurrogateException -> L22
            if (r5 == r1) goto L12;
            int r8 = Utf8.encodedLength(r7);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            bufferUInt32NoTag(r8);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.position = Utf8.encode(r7, this.buffer, this.position, r8);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L14:
            this.totalBytesWritten += r8;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L28:
            return;
        L12:
            this.position = r6 + r5;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            int r9 = Utf8.encode(r7, this.buffer, this.position, this.limit - this.position);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.position = r6;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            r8 = (r9 - r6) - r5;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            bufferUInt32NoTag(r8);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.position = r9;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L19:
            e = move-exception;
            this.totalBytesWritten -= this.position - r6;     // Catch: Utf8.UnpairedSurrogateException -> L22
            this.position = r6;     // Catch: Utf8.UnpairedSurrogateException -> L22
            throw e;     // Catch: Utf8.UnpairedSurrogateException -> L22
        L16:
            e = move-exception;
            throw new OutOfSpaceException(e);     // Catch: Utf8.UnpairedSurrogateException -> L22
        L22:
            e = move-exception;
            inefficientWriteStringNoTag(r7, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r1, int r2) {
            writeUInt32NoTag(WireFormat.makeTag(r1, r2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r2, int r3) {
            flushIfNotAvailable(20);
            bufferTag(r2, 0);
            bufferUInt32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r2) {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(r2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r2, long r3) {
            flushIfNotAvailable(20);
            bufferTag(r2, 0);
            bufferUInt64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r2) {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(r2);
        }
    }

    private static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        SafeDirectNioEncoder(ByteBuffer r3) {
            super(null);
            this.originalBuffer = r3;
            this.buffer = r3.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = r3.position();
        }

        private void encode(String r1) {
            Utf8.encodeUtf8(r1, this.buffer);     // Catch: IndexOutOfBoundsException -> L4
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
        public void write(byte r4) {
            this.buffer.put(r4);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit(), 1, e);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r1) {
            this.buffer.put(r1);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r1, int r2, int r3) {
            this.buffer.put(r1, r2, r3);     // Catch: BufferOverflowException -> L4 IndexOutOfBoundsException -> L7
            return;
        L7:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r2, boolean r3) {
            writeTag(r2, 0);
            write(r3 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r3, byte[] r4) {
            writeByteArray(r3, r4, 0, r4.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r2, byte[] r3, int r4, int r5) {
            writeTag(r2, 2);
            writeByteArrayNoTag(r3, r4, r5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r1, int r2, int r3) {
            writeUInt32NoTag(r3);
            write(r1, r2, r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r2, ByteBuffer r3) {
            writeTag(r2, 2);
            writeUInt32NoTag(r3.capacity());
            writeRawBytes(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r2, ByteString r3) {
            writeTag(r2, 2);
            writeBytesNoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r2) {
            writeUInt32NoTag(r2.size());
            r2.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r2, int r3) {
            writeTag(r2, 5);
            writeFixed32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int r4) {
            this.buffer.putInt(r4);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit(), 4, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int r2, long r3) {
            writeTag(r2, 1);
            writeFixed64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long r3) {
            this.buffer.putLong(r3);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit(), 8, e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int r2, int r3) {
            writeTag(r2, 0);
            writeInt32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r3) {
            if (r3 < 0) goto L4;
            writeUInt32NoTag(r3);
            return;
        L4:
            writeUInt64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r1) {
            write(r1);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r1, int r2, int r3) {
            write(r1, r2, r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r3, MessageLite r4) {
            MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
            writeTag(r3, 2);
            writeMessageNoTag(r5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessage(int r3, MessageLite r4, Schema r5) {
            MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
            Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            writeTag(r3, 2);
            writeMessageNoTag(r6, r7);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r3) {
            MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            writeUInt32NoTag(r4.getSerializedSize());
            r4.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite r3, Schema r4) {
            MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
            writeUInt32NoTag(((AbstractMessageLite) ZeusTransformUtils.preCheckCast(r5, AbstractMessageLite.class, "com.obric.memorydata.plugin")).getSerializedSize(r6));
            r6.writeTo(r5, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r4, MessageLite r5) {
            MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r5, MessageLite.class, "com.obric.memorydata.plugin");
            writeTag(1, 3);
            writeUInt32(2, r4);
            writeMessage(3, r6);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r3) {
            if (r3.hasArray() == false) goto L5;
            write(r3.array(), r3.arrayOffset(), r3.capacity());
            return;
        L5:
            ByteBuffer r4 = r3.duplicate();
            Java8Compatibility.clear(r4);
            write(r4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r4, ByteString r5) {
            writeTag(1, 3);
            writeUInt32(2, r4);
            writeBytes(3, r5);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r2, String r3) {
            writeTag(r2, 2);
            writeStringNoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r5) {
            int r0 = this.buffer.position();
            int r1 = computeUInt32SizeNoTag(r5.length() * 3);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            int r2 = computeUInt32SizeNoTag(r5.length());     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            if (r2 != r1) goto L6;
            int r3 = this.buffer.position() + r2;     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            Java8Compatibility.position(this.buffer, r3);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            encode(r5);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            int r4 = this.buffer.position();     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            Java8Compatibility.position(this.buffer, r0);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            writeUInt32NoTag(r4 - r3);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            Java8Compatibility.position(this.buffer, r4);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
        L14:
            return;
        L6:
            writeUInt32NoTag(Utf8.encodedLength(r5));     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            encode(r5);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
        L11:
            e = move-exception;
            Java8Compatibility.position(this.buffer, r0);
            inefficientWriteStringNoTag(r5, e);
            return;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int r1, int r2) {
            writeUInt32NoTag(WireFormat.makeTag(r1, r2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r2, int r3) {
            writeTag(r2, 0);
            writeUInt32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r3) {
        L3:
            if ((r3 & (-128)) == 0) goto L4;
            this.buffer.put((byte) (r3 | 128));     // Catch: BufferOverflowException -> L8
            r3 = r3 >>> 7;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            this.buffer.put((byte) r3);     // Catch: BufferOverflowException -> L8
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r2, long r3) {
            writeTag(r2, 0);
            writeUInt64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r5) {
        L3:
            if (((-128) & r5) == 0) goto L4;
            this.buffer.put((byte) (((int) r5) | 128));     // Catch: BufferOverflowException -> L8
            r5 = r5 >>> 7;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            this.buffer.put((byte) r5);     // Catch: BufferOverflowException -> L8
        }
    }

    private static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        UnsafeDirectNioEncoder(ByteBuffer r7) {
            super(null);
            this.originalBuffer = r7;
            this.buffer = r7.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long r0 = UnsafeUtil.addressOffset(r7);
            this.address = r0;
            long r2 = ((long) r7.position()) + r0;
            this.initialPosition = r2;
            long r1 = r0 + ((long) r7.limit());
            this.limit = r1;
            this.oneVarintLimit = r1 - 10;
            this.position = r2;
        }

        private int bufferPos(long r3) {
            return (int) (r3 - this.address);
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void repositionBuffer(long r2) {
            Java8Compatibility.position(this.buffer, bufferPos(r2));
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
            long r0 = this.position;
            if (r0 >= this.limit) goto L7;
            this.position = 1 + r0;
            UnsafeUtil.putByte(r0, r11);
            return;
        L7:
            throw new OutOfSpaceException(this.position, this.limit, 1);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer r6) {
            int r0 = r6.remaining();     // Catch: BufferOverflowException -> L4
            repositionBuffer(this.position);     // Catch: BufferOverflowException -> L4
            this.buffer.put(r6);     // Catch: BufferOverflowException -> L4
            this.position += (long) r0;     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] r12, int r13, int r14) {
            if (r12 == null) goto L12;
            if (r13 < 0) goto L12;
            if (r14 < 0) goto L12;
            if ((r12.length - r14) < r13) goto L12;
            long r9 = r14;
            long r0 = this.limit - r9;
            long r5 = this.position;
            if (r0 < r5) goto L12;
            UnsafeUtil.copyMemory(r12, r13, r5, r9);
            this.position += r9;
            return;
        L12:
            Objects.requireNonNull(r12, EventBody.KEY_VALUE);
            throw new OutOfSpaceException(this.position, this.limit, r14);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int r2, boolean r3) {
            writeTag(r2, 0);
            write(r3 ? 1 : 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r3, byte[] r4) {
            writeByteArray(r3, r4, 0, r4.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int r2, byte[] r3, int r4, int r5) {
            writeTag(r2, 2);
            writeByteArrayNoTag(r3, r4, r5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] r1, int r2, int r3) {
            writeUInt32NoTag(r3);
            write(r1, r2, r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int r2, ByteBuffer r3) {
            writeTag(r2, 2);
            writeUInt32NoTag(r3.capacity());
            writeRawBytes(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int r2, ByteString r3) {
            writeTag(r2, 2);
            writeBytesNoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString r2) {
            writeUInt32NoTag(r2.size());
            r2.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int r2, int r3) {
            writeTag(r2, 5);
            writeFixed32NoTag(r3);
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
        public void writeFixed64(int r2, long r3) {
            writeTag(r2, 1);
            writeFixed64NoTag(r3);
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
        public void writeInt32(int r2, int r3) {
            writeTag(r2, 0);
            writeInt32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int r3) {
            if (r3 < 0) goto L4;
            writeUInt32NoTag(r3);
            return;
        L4:
            writeUInt64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r1) {
            write(r1);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r1, int r2, int r3) {
            write(r1, r2, r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int r3, MessageLite r4) {
            MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
            writeTag(r3, 2);
            writeMessageNoTag(r5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessage(int r3, MessageLite r4, Schema r5) {
            MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
            Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            writeTag(r3, 2);
            writeMessageNoTag(r6, r7);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite r3) {
            MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            writeUInt32NoTag(r4.getSerializedSize());
            r4.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite r3, Schema r4) {
            MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
            writeUInt32NoTag(((AbstractMessageLite) ZeusTransformUtils.preCheckCast(r5, AbstractMessageLite.class, "com.obric.memorydata.plugin")).getSerializedSize(r6));
            r6.writeTo(r5, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int r4, MessageLite r5) {
            MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r5, MessageLite.class, "com.obric.memorydata.plugin");
            writeTag(1, 3);
            writeUInt32(2, r4);
            writeMessage(3, r6);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer r3) {
            if (r3.hasArray() == false) goto L5;
            write(r3.array(), r3.arrayOffset(), r3.capacity());
            return;
        L5:
            ByteBuffer r4 = r3.duplicate();
            Java8Compatibility.clear(r4);
            write(r4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int r4, ByteString r5) {
            writeTag(1, 3);
            writeUInt32(2, r4);
            writeBytes(3, r5);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int r2, String r3) {
            writeTag(r2, 2);
            writeStringNoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String r8) {
            long r0 = this.position;
            int r2 = computeUInt32SizeNoTag(r8.length() * 3);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            int r3 = computeUInt32SizeNoTag(r8.length());     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            if (r3 != r2) goto L6;
            int r4 = bufferPos(this.position) + r3;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            Java8Compatibility.position(this.buffer, r4);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            Utf8.encodeUtf8(r8, this.buffer);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            int r5 = this.buffer.position() - r4;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            writeUInt32NoTag(r5);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            this.position += (long) r5;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
        L17:
            return;
        L6:
            int r6 = Utf8.encodedLength(r8);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            writeUInt32NoTag(r6);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            repositionBuffer(this.position);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            Utf8.encodeUtf8(r8, this.buffer);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            this.position += (long) r6;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
        L14:
            e = move-exception;
            this.position = r0;
            repositionBuffer(r0);
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
        public void writeTag(int r1, int r2) {
            writeUInt32NoTag(WireFormat.makeTag(r1, r2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int r2, int r3) {
            writeTag(r2, 0);
            writeUInt32NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int r8) {
            long r0 = this.position;
            if (r0 > this.oneVarintLimit) goto L9;
        L5:
            if ((r8 & (-128)) == 0) goto L6;
            UnsafeUtil.putByte(r0, (byte) (r8 | 128));
            r8 = r8 >>> 7;
            r0 = r0 + 1;
        L6:
            long r3 = 1 + r0;
            UnsafeUtil.putByte(r0, (byte) r8);
            this.position = r3;
            return;
        L9:
            if (r0 >= this.limit) goto L17;
            if ((r8 & (-128)) == 0) goto L6;
            UnsafeUtil.putByte(r0, (byte) (r8 | 128));
            r8 = r8 >>> 7;
            r0 = r0 + 1;
            goto L9
        L17:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(r0), Long.valueOf(this.limit), 1}));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int r2, long r3) {
            writeTag(r2, 0);
            writeUInt64NoTag(r3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long r18) {
            long r1 = this.position;
            if (r1 > this.oneVarintLimit) goto L9;
            long r11 = r1;
            long r2 = r18;
        L6:
            if ((r2 & (-128)) == 0) goto L7;
            UnsafeUtil.putByte(r11, (byte) (((int) r2) | 128));
            r2 = r2 >>> 7;
            r11 = r11 + 1;
            goto L6
        L7:
            long r9 = 1 + r11;
            UnsafeUtil.putByte(r11, (byte) r2);
        L15:
            this.position = r9;
            return;
        L9:
            long r12 = r1;
            long r3 = r18;
        L11:
            if (r12 >= this.limit) goto L19;
            if ((r3 & (-128)) == 0) goto L14;
            UnsafeUtil.putByte(r12, (byte) (((int) r3) | 128));
            r3 = r3 >>> 7;
            r12 = r12 + 1;
            goto L11
        L14:
            r9 = 1 + r12;
            UnsafeUtil.putByte(r12, (byte) r3);
            goto L15
        L19:
            throw new OutOfSpaceException(r12, this.limit, 1);
        }
    }

    static {
        logger = Logger.getLogger(CodedOutputStream.class.getName());
        HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();
    }

    private CodedOutputStream() {
    }

    /* synthetic */ CodedOutputStream(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$100() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static int computeBoolSize(int r0, boolean r1) {
        return computeTagSize(r0) + computeBoolSizeNoTag(r1);
    }

    public static int computeBoolSizeNoTag(boolean r0) {
        return 1;
    }

    public static int computeByteArraySize(int r0, byte[] r1) {
        return computeTagSize(r0) + computeByteArraySizeNoTag(r1);
    }

    public static int computeByteArraySizeNoTag(byte[] r0) {
        return computeLengthDelimitedFieldSize(r0.length);
    }

    public static int computeByteBufferSize(int r0, ByteBuffer r1) {
        return computeTagSize(r0) + computeByteBufferSizeNoTag(r1);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer r0) {
        return computeLengthDelimitedFieldSize(r0.capacity());
    }

    public static int computeBytesSize(int r0, ByteString r1) {
        return computeTagSize(r0) + computeBytesSizeNoTag(r1);
    }

    public static int computeBytesSizeNoTag(ByteString r0) {
        return computeLengthDelimitedFieldSize(r0.size());
    }

    public static int computeDoubleSize(int r0, double r1) {
        return computeTagSize(r0) + computeDoubleSizeNoTag(r1);
    }

    public static int computeDoubleSizeNoTag(double r0) {
        return 8;
    }

    public static int computeEnumSize(int r0, int r1) {
        return computeTagSize(r0) + computeEnumSizeNoTag(r1);
    }

    public static int computeEnumSizeNoTag(int r0) {
        return computeInt32SizeNoTag(r0);
    }

    public static int computeFixed32Size(int r0, int r1) {
        return computeTagSize(r0) + computeFixed32SizeNoTag(r1);
    }

    public static int computeFixed32SizeNoTag(int r0) {
        return 4;
    }

    public static int computeFixed64Size(int r0, long r1) {
        return computeTagSize(r0) + computeFixed64SizeNoTag(r1);
    }

    public static int computeFixed64SizeNoTag(long r0) {
        return 8;
    }

    public static int computeFloatSize(int r0, float r1) {
        return computeTagSize(r0) + computeFloatSizeNoTag(r1);
    }

    public static int computeFloatSizeNoTag(float r0) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int r2, MessageLite r3) {
        MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
        return (computeTagSize(r2) * 2) + r4.getSerializedSize();
    }

    @Deprecated
    static int computeGroupSize(int r2, MessageLite r3, Schema r4) {
        MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
        Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
        return (computeTagSize(r2) * 2) + computeGroupSizeNoTag(r5, r6);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite r2) {
        return ((MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.memorydata.plugin")).getSerializedSize();
    }

    @Deprecated
    static int computeGroupSizeNoTag(MessageLite r2, Schema r3) {
        MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.memorydata.plugin");
        Schema r5 = (Schema) ZeusTransformUtils.wrapperContextForParams(r3, Schema.class, "com.obric.memorydata.plugin");
        return ((AbstractMessageLite) ZeusTransformUtils.preCheckCast(r4, AbstractMessageLite.class, "com.obric.memorydata.plugin")).getSerializedSize(r5);
    }

    public static int computeInt32Size(int r0, int r1) {
        return computeTagSize(r0) + computeInt32SizeNoTag(r1);
    }

    public static int computeInt32SizeNoTag(int r2) {
        return computeUInt64SizeNoTag(r2);
    }

    public static int computeInt64Size(int r0, long r1) {
        return computeTagSize(r0) + computeInt64SizeNoTag(r1);
    }

    public static int computeInt64SizeNoTag(long r0) {
        return computeUInt64SizeNoTag(r0);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int r2, LazyFieldLite r3) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, r2)) + computeLazyFieldSize(3, r3);
    }

    public static int computeLazyFieldSize(int r0, LazyFieldLite r1) {
        return computeTagSize(r0) + computeLazyFieldSizeNoTag(r1);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite r0) {
        return computeLengthDelimitedFieldSize(r0.getSerializedSize());
    }

    static int computeLengthDelimitedFieldSize(int r1) {
        return computeUInt32SizeNoTag(r1) + r1;
    }

    public static int computeMessageSetExtensionSize(int r2, MessageLite r3) {
        MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, r2)) + computeMessageSize(3, r4);
    }

    public static int computeMessageSize(int r2, MessageLite r3) {
        MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
        return computeTagSize(r2) + computeMessageSizeNoTag(r4);
    }

    static int computeMessageSize(int r2, MessageLite r3, Schema r4) {
        MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
        Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
        return computeTagSize(r2) + computeMessageSizeNoTag(r5, r6);
    }

    public static int computeMessageSizeNoTag(MessageLite r2) {
        return computeLengthDelimitedFieldSize(((MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.memorydata.plugin")).getSerializedSize());
    }

    static int computeMessageSizeNoTag(MessageLite r2, Schema r3) {
        MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r2, MessageLite.class, "com.obric.memorydata.plugin");
        Schema r5 = (Schema) ZeusTransformUtils.wrapperContextForParams(r3, Schema.class, "com.obric.memorydata.plugin");
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) ZeusTransformUtils.preCheckCast(r4, AbstractMessageLite.class, "com.obric.memorydata.plugin")).getSerializedSize(r5));
    }

    static int computePreferredBufferSize(int r1) {
        if (r1 <= 4096) goto L5;
        return 4096;
    L5:
        return r1;
    }

    public static int computeRawMessageSetExtensionSize(int r2, ByteString r3) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, r2)) + computeBytesSize(3, r3);
    }

    @Deprecated
    public static int computeRawVarint32Size(int r0) {
        return computeUInt32SizeNoTag(r0);
    }

    @Deprecated
    public static int computeRawVarint64Size(long r0) {
        return computeUInt64SizeNoTag(r0);
    }

    public static int computeSFixed32Size(int r0, int r1) {
        return computeTagSize(r0) + computeSFixed32SizeNoTag(r1);
    }

    public static int computeSFixed32SizeNoTag(int r0) {
        return 4;
    }

    public static int computeSFixed64Size(int r0, long r1) {
        return computeTagSize(r0) + computeSFixed64SizeNoTag(r1);
    }

    public static int computeSFixed64SizeNoTag(long r0) {
        return 8;
    }

    public static int computeSInt32Size(int r0, int r1) {
        return computeTagSize(r0) + computeSInt32SizeNoTag(r1);
    }

    public static int computeSInt32SizeNoTag(int r0) {
        return computeUInt32SizeNoTag(encodeZigZag32(r0));
    }

    public static int computeSInt64Size(int r0, long r1) {
        return computeTagSize(r0) + computeSInt64SizeNoTag(r1);
    }

    public static int computeSInt64SizeNoTag(long r0) {
        return computeUInt64SizeNoTag(encodeZigZag64(r0));
    }

    public static int computeStringSize(int r0, String r1) {
        return computeTagSize(r0) + computeStringSizeNoTag(r1);
    }

    public static int computeStringSizeNoTag(String r1) {
        int r2 = Utf8.encodedLength(r1);     // Catch: Utf8.UnpairedSurrogateException -> L4
    L6:
        return computeLengthDelimitedFieldSize(r2);
    L4:
        r2 = r1.getBytes(Internal.UTF_8).length;
        goto L6
    }

    public static int computeTagSize(int r1) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(r1, 0));
    }

    public static int computeUInt32Size(int r0, int r1) {
        return computeTagSize(r0) + computeUInt32SizeNoTag(r1);
    }

    public static int computeUInt32SizeNoTag(int r0) {
        return (352 - (Integer.numberOfLeadingZeros(r0) * 9)) >>> 6;
    }

    public static int computeUInt64Size(int r0, long r1) {
        return computeTagSize(r0) + computeUInt64SizeNoTag(r1);
    }

    public static int computeUInt64SizeNoTag(long r0) {
        return (640 - (Long.numberOfLeadingZeros(r0) * 9)) >>> 6;
    }

    public static int encodeZigZag32(int r1) {
        int r0 = r1 << 1;
        return (r1 >> 31) ^ r0;
    }

    public static long encodeZigZag64(long r3) {
        long r0 = r3 << 1;
        return (r3 >> 63) ^ r0;
    }

    static CodedOutputStream newInstance(ByteOutput r1, int r2) {
        if (r2 < 0) goto L6;
        return new ByteOutputEncoder(r1, r2);
    L6:
        throw new IllegalArgumentException("bufferSize must be positive");
    }

    public static CodedOutputStream newInstance(OutputStream r1) {
        return newInstance(r1, 4096);
    }

    public static CodedOutputStream newInstance(OutputStream r1, int r2) {
        return new OutputStreamEncoder(r1, r2);
    }

    public static CodedOutputStream newInstance(ByteBuffer r1) {
        if (r1.hasArray() == false) goto L7;
        return new HeapNioEncoder(r1);
    L7:
        if (r1.isDirect() == false) goto L16;
        if (r1.isReadOnly() == true) goto L16;
        if (UnsafeDirectNioEncoder.isSupported() == false) goto L14;
        return newUnsafeInstance(r1);
    L14:
        return newSafeInstance(r1);
    L16:
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer r0, int r1) {
        return newInstance(r0);
    }

    public static CodedOutputStream newInstance(byte[] r2) {
        return newInstance(r2, 0, r2.length);
    }

    public static CodedOutputStream newInstance(byte[] r1, int r2, int r3) {
        return new ArrayEncoder(r1, r2, r3);
    }

    static CodedOutputStream newSafeInstance(ByteBuffer r1) {
        return new SafeDirectNioEncoder(r1);
    }

    static CodedOutputStream newUnsafeInstance(ByteBuffer r1) {
        return new UnsafeDirectNioEncoder(r1);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public abstract void flush();

    public abstract int getTotalBytesWritten();

    final void inefficientWriteStringNoTag(String r4, Utf8.UnpairedSurrogateException r5) {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", r5);
        byte[] r6 = r4.getBytes(Internal.UTF_8);
        writeUInt32NoTag(r6.length);     // Catch: IndexOutOfBoundsException -> L5
        writeLazy(r6, 0, r6.length);     // Catch: IndexOutOfBoundsException -> L5
        return;
    L5:
        e = move-exception;
        throw new OutOfSpaceException(e);
    }

    boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte r1);

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(ByteBuffer r1);

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte[] r1, int r2, int r3);

    public abstract void writeBool(int r1, boolean r2);

    public final void writeBoolNoTag(boolean r1) {
        write(r1 ? 1 : 0);
    }

    public abstract void writeByteArray(int r1, byte[] r2);

    public abstract void writeByteArray(int r1, byte[] r2, int r3, int r4);

    public final void writeByteArrayNoTag(byte[] r3) {
        writeByteArrayNoTag(r3, 0, r3.length);
    }

    abstract void writeByteArrayNoTag(byte[] r1, int r2, int r3);

    public abstract void writeByteBuffer(int r1, ByteBuffer r2);

    public abstract void writeBytes(int r1, ByteString r2);

    public abstract void writeBytesNoTag(ByteString r1);

    public final void writeDouble(int r1, double r2) {
        writeFixed64(r1, Double.doubleToRawLongBits(r2));
    }

    public final void writeDoubleNoTag(double r1) {
        writeFixed64NoTag(Double.doubleToRawLongBits(r1));
    }

    public final void writeEnum(int r1, int r2) {
        writeInt32(r1, r2);
    }

    public final void writeEnumNoTag(int r1) {
        writeInt32NoTag(r1);
    }

    public abstract void writeFixed32(int r1, int r2);

    public abstract void writeFixed32NoTag(int r1);

    public abstract void writeFixed64(int r1, long r2);

    public abstract void writeFixed64NoTag(long r1);

    public final void writeFloat(int r1, float r2) {
        writeFixed32(r1, Float.floatToRawIntBits(r2));
    }

    public final void writeFloatNoTag(float r1) {
        writeFixed32NoTag(Float.floatToRawIntBits(r1));
    }

    @Deprecated
    public final void writeGroup(int r3, MessageLite r4) {
        MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
        writeTag(r3, 3);
        writeGroupNoTag(r5);
        writeTag(r3, 4);
    }

    @Deprecated
    final void writeGroup(int r3, MessageLite r4, Schema r5) {
        MessageLite r6 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r4, MessageLite.class, "com.obric.memorydata.plugin");
        Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
        writeTag(r3, 3);
        writeGroupNoTag(r6, r7);
        writeTag(r3, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite r3) {
        ((MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin")).writeTo(this);
    }

    @Deprecated
    final void writeGroupNoTag(MessageLite r3, Schema r4) {
        MessageLite r5 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
        ((Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin")).writeTo(r5, this.wrapper);
    }

    public abstract void writeInt32(int r1, int r2);

    public abstract void writeInt32NoTag(int r1);

    public final void writeInt64(int r1, long r2) {
        writeUInt64(r1, r2);
    }

    public final void writeInt64NoTag(long r1) {
        writeUInt64NoTag(r1);
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer r1);

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(byte[] r1, int r2, int r3);

    public abstract void writeMessage(int r1, MessageLite r2);

    abstract void writeMessage(int r1, MessageLite r2, Schema r3);

    public abstract void writeMessageNoTag(MessageLite r1);

    abstract void writeMessageNoTag(MessageLite r1, Schema r2);

    public abstract void writeMessageSetExtension(int r1, MessageLite r2);

    public final void writeRawByte(byte r1) {
        write(r1);
    }

    public final void writeRawByte(int r1) {
        write((byte) r1);
    }

    public final void writeRawBytes(ByteString r1) {
        r1.writeTo(this);
    }

    public abstract void writeRawBytes(ByteBuffer r1);

    public final void writeRawBytes(byte[] r3) {
        write(r3, 0, r3.length);
    }

    public final void writeRawBytes(byte[] r1, int r2, int r3) {
        write(r1, r2, r3);
    }

    @Deprecated
    public final void writeRawLittleEndian32(int r1) {
        writeFixed32NoTag(r1);
    }

    @Deprecated
    public final void writeRawLittleEndian64(long r1) {
        writeFixed64NoTag(r1);
    }

    public abstract void writeRawMessageSetExtension(int r1, ByteString r2);

    @Deprecated
    public final void writeRawVarint32(int r1) {
        writeUInt32NoTag(r1);
    }

    @Deprecated
    public final void writeRawVarint64(long r1) {
        writeUInt64NoTag(r1);
    }

    public final void writeSFixed32(int r1, int r2) {
        writeFixed32(r1, r2);
    }

    public final void writeSFixed32NoTag(int r1) {
        writeFixed32NoTag(r1);
    }

    public final void writeSFixed64(int r1, long r2) {
        writeFixed64(r1, r2);
    }

    public final void writeSFixed64NoTag(long r1) {
        writeFixed64NoTag(r1);
    }

    public final void writeSInt32(int r1, int r2) {
        writeUInt32(r1, encodeZigZag32(r2));
    }

    public final void writeSInt32NoTag(int r1) {
        writeUInt32NoTag(encodeZigZag32(r1));
    }

    public final void writeSInt64(int r1, long r2) {
        writeUInt64(r1, encodeZigZag64(r2));
    }

    public final void writeSInt64NoTag(long r1) {
        writeUInt64NoTag(encodeZigZag64(r1));
    }

    public abstract void writeString(int r1, String r2);

    public abstract void writeStringNoTag(String r1);

    public abstract void writeTag(int r1, int r2);

    public abstract void writeUInt32(int r1, int r2);

    public abstract void writeUInt32NoTag(int r1);

    public abstract void writeUInt64(int r1, long r2);

    public abstract void writeUInt64NoTag(long r1);
}
