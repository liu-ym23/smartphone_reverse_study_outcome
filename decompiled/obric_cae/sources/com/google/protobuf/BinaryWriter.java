package com.google.protobuf;

import com.obric.cae.smartNetwork.networkRateLimit.TrafficControlConfig;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
abstract class BinaryWriter extends ByteOutput implements Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int MAP_KEY_NUMBER = 1;
    private static final int MAP_VALUE_NUMBER = 2;
    private final BufferAllocator alloc;
    final ArrayDeque<AllocatedBuffer> buffers;
    private final int chunkSize;
    int totalDoneBytes;

    /* JADX INFO: renamed from: com.google.protobuf.BinaryWriter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r8 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r8;
            r8[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    public static final class SafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private int limitMinusOne;
        private int pos;

        public SafeDirectWriter(BufferAllocator r8, int r10) {
            super(r8, r10, null);
            nextBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        private void writeVarint32FiveBytes(int r8) {
            ByteBuffer r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10.put(r11, (byte) (r8 >>> 28));
            int r12 = this.pos - 4;
            this.pos = r12;
            this.buffer.putInt(r12 + 1, ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128) | ((((((r8 >>> 21) & QesdkUtils.LIMITS.INT_8_UPPER) | 128) << 24) | ((((r8 >>> 14) & QesdkUtils.LIMITS.INT_8_UPPER) | 128) << 16)) | ((((r8 >>> 7) & QesdkUtils.LIMITS.INT_8_UPPER) | 128) << 8)));
        }

        private void writeVarint32FourBytes(int r8) {
            int r10 = this.pos - 4;
            this.pos = r10;
            this.buffer.putInt(r10 + 1, ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128) | ((((266338304 & r8) << 3) | (((2080768 & r8) | TrafficControlConfig.DEFAULT_UNLIMITED_RATE) << 2)) | (((r8 & 16256) | 16384) << 1)));
        }

        private void writeVarint32OneByte(int r8) {
            ByteBuffer r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10.put(r11, (byte) r8);
        }

        private void writeVarint32ThreeBytes(int r8) {
            int r10 = this.pos - 3;
            this.pos = r10;
            this.buffer.putInt(r10, (((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128) << 8) | (((2080768 & r8) << 10) | (((r8 & 16256) | 16384) << 9)));
        }

        private void writeVarint32TwoBytes(int r8) {
            int r10 = this.pos - 2;
            this.pos = r10;
            this.buffer.putShort(r10 + 1, (short) (((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128) | ((r8 & 16256) << 1)));
        }

        private void writeVarint64EightBytes(long r10) {
            int r8 = this.pos - 8;
            this.pos = r8;
            this.buffer.putLong(r8 + 1, ((r10 & 127) | 128) | ((((((((71494644084506624L & r10) << 7) | (((558551906910208L & r10) | 562949953421312L) << 6)) | (((4363686772736L & r10) | 4398046511104L) << 5)) | (((34091302912L & r10) | 34359738368L) << 4)) | (((266338304 & r10) | 268435456) << 3)) | (((2080768 & r10) | 2097152) << 2)) | (((16256 & r10) | 16384) << 1)));
        }

        private void writeVarint64EightBytesWithSign(long r10) {
            int r8 = this.pos - 8;
            this.pos = r8;
            this.buffer.putLong(r8 + 1, ((r10 & 127) | 128) | (((((((((71494644084506624L & r10) | 72057594037927936L) << 7) | (((558551906910208L & r10) | 562949953421312L) << 6)) | (((4363686772736L & r10) | 4398046511104L) << 5)) | (((34091302912L & r10) | 34359738368L) << 4)) | (((266338304 & r10) | 268435456) << 3)) | (((2080768 & r10) | 2097152) << 2)) | (((16256 & r10) | 16384) << 1)));
        }

        private void writeVarint64FiveBytes(long r8) {
            int r10 = this.pos - 5;
            this.pos = r10;
            this.buffer.putLong(r10 - 2, (((r8 & 127) | 128) << 24) | (((((34091302912L & r8) << 28) | (((266338304 & r8) | 268435456) << 27)) | (((2080768 & r8) | 2097152) << 26)) | (((16256 & r8) | 16384) << 25)));
        }

        private void writeVarint64FourBytes(long r8) {
            writeVarint32FourBytes((int) r8);
        }

        private void writeVarint64NineBytes(long r8) {
            ByteBuffer r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10.put(r11, (byte) (r8 >>> 56));
            writeVarint64EightBytesWithSign(r8 & 72057594037927935L);
        }

        private void writeVarint64OneByte(long r8) {
            writeVarint32OneByte((int) r8);
        }

        private void writeVarint64SevenBytes(long r8) {
            int r10 = this.pos - 7;
            this.pos = r10;
            this.buffer.putLong(r10, (((r8 & 127) | 128) << 8) | (((((((558551906910208L & r8) << 14) | (((4363686772736L & r8) | 4398046511104L) << 13)) | (((34091302912L & r8) | 34359738368L) << 12)) | (((266338304 & r8) | 268435456) << 11)) | (((2080768 & r8) | 2097152) << 10)) | (((16256 & r8) | 16384) << 9)));
        }

        private void writeVarint64SixBytes(long r8) {
            int r10 = this.pos - 6;
            this.pos = r10;
            this.buffer.putLong(r10 - 1, (((r8 & 127) | 128) << 16) | ((((((4363686772736L & r8) << 21) | (((34091302912L & r8) | 34359738368L) << 20)) | (((266338304 & r8) | 268435456) << 19)) | (((2080768 & r8) | 2097152) << 18)) | (((16256 & r8) | 16384) << 17)));
        }

        private void writeVarint64TenBytes(long r8) {
            ByteBuffer r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10.put(r11, (byte) (r8 >>> 63));
            ByteBuffer r12 = this.buffer;
            int r13 = this.pos;
            this.pos = r13 - 1;
            r12.put(r13, (byte) (((r8 >>> 56) & 127) | 128));
            writeVarint64EightBytesWithSign(r8 & 72057594037927935L);
        }

        private void writeVarint64ThreeBytes(long r8) {
            writeVarint32ThreeBytes((int) r8);
        }

        private void writeVarint64TwoBytes(long r8) {
            writeVarint32TwoBytes((int) r8);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.buffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            Java8Compatibility.position(this.buffer, this.pos + 1);
            this.buffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
            return;
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.google.protobuf.BinaryWriter
        public void requireSpace(int r8) {
            if (spaceLeft() >= r8) goto L6;
            nextBuffer(r8);
            return;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte r8) {
            ByteBuffer r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10.put(r11, r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int r8, boolean r10) {
            requireSpace(6);
            write(r10 ? 1 : 0);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int r8, ByteString r10) {
            r10.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(r10.size());
            writeTag(r8, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int r8) {
            writeTag(r8, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed32(int r8) {
            int r10 = this.pos - 4;
            this.pos = r10;
            this.buffer.putInt(r10 + 1, r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int r8, long r10) {
            requireSpace(13);
            writeFixed64(r10);
            writeTag(r8, 1);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeGroup(int r8, Object r10) {
            writeTag(r8, 4);
            Protobuf.getInstance().writeTo(r10, this);
            writeTag(r8, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeInt32(int r8) {
            if (r8 < 0) goto L4;
            writeVarint32(r8);
            return;
        L4:
            writeVarint64(r8);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r8) {
            int r10 = r8.remaining();
            if (spaceLeft() >= r10) goto L6;
            this.totalDoneBytes += r10;
            this.buffers.addFirst(AllocatedBuffer.wrap(r8));
            nextBuffer();
            return;
        L6:
            int r11 = this.pos - r10;
            this.pos = r11;
            Java8Compatibility.position(this.buffer, r11 + 1);
            this.buffer.put(r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r8, Object r10) {
            int r11 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(r10, this);
            int r12 = getTotalBytesWritten() - r11;
            requireSpace(10);
            writeVarint32(r12);
            writeTag(r8, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt32(int r8) {
            writeVarint32(CodedOutputStream.encodeZigZag32(r8));
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int r8, long r10) {
            requireSpace(15);
            writeSInt64(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int r8) {
            writeTag(r8, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int r8, String r10) {
            int r11 = getTotalBytesWritten();
            writeString(r10);
            int r12 = getTotalBytesWritten() - r11;
            requireSpace(10);
            writeVarint32(r12);
            writeTag(r8, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeTag(int r8, int r10) {
            writeVarint32(WireFormat.makeTag(r8, r10));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int r8, int r10) {
            requireSpace(10);
            writeVarint32(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int r8, long r10) {
            requireSpace(15);
            writeVarint64(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint32(int r8) {
            if ((r8 & QesdkUtils.LIMITS.INT_8_LOWER) != 0) goto L6;
            writeVarint32OneByte(r8);
            return;
        L6:
            if ((r8 & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(r8);
            return;
        L9:
            if (((-2097152) & r8) != 0) goto L12;
            writeVarint32ThreeBytes(r8);
            return;
        L12:
            if (((-268435456) & r8) != 0) goto L14;
            writeVarint32FourBytes(r8);
            return;
        L14:
            writeVarint32FiveBytes(r8);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint64(long r8) {
            switch(BinaryWriter.access$200(r8)) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            writeVarint64TenBytes(r8);
            return;
        L6:
            writeVarint64NineBytes(r8);
            return;
        L7:
            writeVarint64EightBytes(r8);
            return;
        L8:
            writeVarint64SevenBytes(r8);
            return;
        L9:
            writeVarint64SixBytes(r8);
            return;
        L10:
            writeVarint64FiveBytes(r8);
            return;
        L11:
            writeVarint64FourBytes(r8);
            return;
        L12:
            writeVarint64ThreeBytes(r8);
            return;
        L13:
            writeVarint64TwoBytes(r8);
            return;
        L14:
            writeVarint64OneByte(r8);
            return;
        }

        private void nextBuffer(int r8) {
            nextBuffer(newDirectBuffer(r8));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer r8) {
            int r10 = r8.remaining();
            if (spaceLeft() >= r10) goto L5;
            nextBuffer(r10);
        L5:
            int r11 = this.pos - r10;
            this.pos = r11;
            Java8Compatibility.position(this.buffer, r11 + 1);
            this.buffer.put(r8);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeBool(boolean r8) {
            write(r8 ? 1 : 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int r8, int r10) {
            requireSpace(9);
            writeFixed32(r10);
            writeTag(r8, 5);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed64(long r8) {
            int r10 = this.pos - 8;
            this.pos = r10;
            this.buffer.putLong(r10 + 1, r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r8, Object r10, Schema r11) {
            writeTag(r8, 4);
            r11.writeTo(r10, this);
            writeTag(r8, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int r8, int r10) {
            requireSpace(15);
            writeInt32(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r8, int r10, int r11) {
            if (spaceLeft() >= r11) goto L6;
            this.totalDoneBytes += r11;
            this.buffers.addFirst(AllocatedBuffer.wrap(r8, r10, r11));
            nextBuffer();
            return;
        L6:
            int r12 = this.pos - r11;
            this.pos = r12;
            Java8Compatibility.position(this.buffer, r12 + 1);
            this.buffer.put(r8, r10, r11);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r8, Object r10, Schema r11) {
            int r12 = getTotalBytesWritten();
            r11.writeTo(r10, this);
            int r13 = getTotalBytesWritten() - r12;
            requireSpace(10);
            writeVarint32(r13);
            writeTag(r8, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int r8, int r10) {
            requireSpace(10);
            writeSInt32(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt64(long r8) {
            writeVarint64(CodedOutputStream.encodeZigZag64(r8));
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeString(String r10) {
            requireSpace(r10.length());
            int r8 = r10.length() - 1;
            this.pos -= r8;
        L4:
            if (r8 < 0) goto L9;
            char r11 = r10.charAt(r8);
            if (r11 >= 128) goto L9;
            this.buffer.put(this.pos + r8, (byte) r11);
            r8 = r8 - 1;
        L9:
            if (r8 != (-1)) goto L12;
            this.pos--;
            return;
        L12:
            this.pos += r8;
        L13:
            if (r8 < 0) goto L42;
            char r12 = r10.charAt(r8);
            if (r12 >= 128) goto L20;
            int r13 = this.pos;
            if (r13 < 0) goto L20;
            ByteBuffer r14 = this.buffer;
            this.pos = r13 - 1;
            r14.put(r13, (byte) r12);
        L41:
            r8 = r8 - 1;
        L20:
            if (r12 >= 2048) goto L25;
            int r15 = this.pos;
            if (r15 <= 0) goto L25;
            ByteBuffer r16 = this.buffer;
            this.pos = r15 - 1;
            r16.put(r15, (byte) ((r12 & '?') | 128));
            ByteBuffer r17 = this.buffer;
            int r18 = this.pos;
            this.pos = r18 - 1;
            int r19 = (r12 >>> 6) | 960;
        L37:
            r17.put(r18, (byte) r19);
        L25:
            if (r12 >= 55296) goto L27;
        L28:
            int r20 = this.pos;
            if (r20 <= 1) goto L32;
            ByteBuffer r21 = this.buffer;
            this.pos = r20 - 1;
            r21.put(r20, (byte) ((r12 & '?') | 128));
            ByteBuffer r22 = this.buffer;
            int r23 = this.pos;
            this.pos = r23 - 1;
            r22.put(r23, (byte) (((r12 >>> 6) & 63) | 128));
            r17 = this.buffer;
            r18 = this.pos;
            this.pos = r18 - 1;
            r19 = (r12 >>> '\f') | 480;
        L32:
            if (this.pos <= 2) goto L40;
            if (r8 == 0) goto L39;
            char r24 = r10.charAt(r8 - 1);
            if (Character.isSurrogatePair(r24, r12) == false) goto L39;
            r8 = r8 - 1;
            int r25 = Character.toCodePoint(r24, r12);
            ByteBuffer r26 = this.buffer;
            int r27 = this.pos;
            this.pos = r27 - 1;
            r26.put(r27, (byte) ((r25 & 63) | 128));
            ByteBuffer r28 = this.buffer;
            int r29 = this.pos;
            this.pos = r29 - 1;
            r28.put(r29, (byte) (((r25 >>> 6) & 63) | 128));
            ByteBuffer r30 = this.buffer;
            int r31 = this.pos;
            this.pos = r31 - 1;
            r30.put(r31, (byte) (((r25 >>> 12) & 63) | 128));
            r17 = this.buffer;
            r18 = this.pos;
            this.pos = r18 - 1;
            r19 = (r25 >>> 18) | 240;
        L39:
            throw new Utf8.UnpairedSurrogateException(r8 - 1, r8);
        L40:
            requireSpace(r8);
            r8 = r8 + 1;
            goto L41
        L27:
            if (57343 >= r12) goto L32;
        }

        private void nextBuffer(AllocatedBuffer r8) {
            if (r8.hasNioBuffer() == false) goto L11;
            ByteBuffer r10 = r8.nioBuffer();
            if (r10.isDirect() == false) goto L9;
            finishCurrentBuffer();
            this.buffers.addFirst(r8);
            this.buffer = r10;
            Java8Compatibility.limit(r10, r10.capacity());
            Java8Compatibility.position(this.buffer, 0);
            this.buffer.order(ByteOrder.LITTLE_ENDIAN);
            int r11 = this.buffer.limit() - 1;
            this.limitMinusOne = r11;
            this.pos = r11;
            return;
        L9:
            throw new RuntimeException("Allocator returned non-direct buffer");
        L11:
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] r8, int r10, int r11) {
            if (spaceLeft() >= r11) goto L5;
            nextBuffer(r11);
        L5:
            int r12 = this.pos - r11;
            this.pos = r12;
            Java8Compatibility.position(this.buffer, r12 + 1);
            this.buffer.put(r8, r10, r11);
        }
    }

    public static final class SafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private int limit;
        private int limitMinusOne;
        private int offset;
        private int offsetMinusOne;
        private int pos;

        public SafeHeapWriter(BufferAllocator r8, int r10) {
            super(r8, r10, null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int r8) {
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r10[r11] = (byte) (r8 >>> 28);
            int r13 = r12 - 1;
            r10[r12] = (byte) (((r8 >>> 21) & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
            int r14 = r13 - 1;
            r10[r13] = (byte) (((r8 >>> 14) & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
            int r15 = r14 - 1;
            r10[r14] = (byte) (((r8 >>> 7) & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
            this.pos = r15 - 1;
            r10[r15] = (byte) ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
        }

        private void writeVarint32FourBytes(int r8) {
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r10[r11] = (byte) (r8 >>> 21);
            int r13 = r12 - 1;
            r10[r12] = (byte) (((r8 >>> 14) & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
            int r14 = r13 - 1;
            r10[r13] = (byte) (((r8 >>> 7) & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
            this.pos = r14 - 1;
            r10[r14] = (byte) ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
        }

        private void writeVarint32OneByte(int r8) {
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10[r11] = (byte) r8;
        }

        private void writeVarint32ThreeBytes(int r8) {
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r10[r11] = (byte) (r8 >>> 14);
            int r13 = r12 - 1;
            r10[r12] = (byte) (((r8 >>> 7) & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
            this.pos = r13 - 1;
            r10[r13] = (byte) ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
        }

        private void writeVarint32TwoBytes(int r8) {
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r10[r11] = (byte) (r8 >>> 7);
            this.pos = r12 - 1;
            r10[r12] = (byte) ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
        }

        private void writeVarint64EightBytes(long r10) {
            byte[] r8 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r8[r11] = (byte) (r10 >>> 49);
            int r13 = r12 - 1;
            r8[r12] = (byte) (((r10 >>> 42) & 127) | 128);
            int r14 = r13 - 1;
            r8[r13] = (byte) (((r10 >>> 35) & 127) | 128);
            int r15 = r14 - 1;
            r8[r14] = (byte) (((r10 >>> 28) & 127) | 128);
            int r16 = r15 - 1;
            r8[r15] = (byte) (((r10 >>> 21) & 127) | 128);
            int r17 = r16 - 1;
            r8[r16] = (byte) (((r10 >>> 14) & 127) | 128);
            int r18 = r17 - 1;
            r8[r17] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r18 - 1;
            r8[r18] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64FiveBytes(long r10) {
            byte[] r8 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r8[r11] = (byte) (r10 >>> 28);
            int r13 = r12 - 1;
            r8[r12] = (byte) (((r10 >>> 21) & 127) | 128);
            int r14 = r13 - 1;
            r8[r13] = (byte) (((r10 >>> 14) & 127) | 128);
            int r15 = r14 - 1;
            r8[r14] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r15 - 1;
            r8[r15] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64FourBytes(long r10) {
            byte[] r8 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r8[r11] = (byte) (r10 >>> 21);
            int r13 = r12 - 1;
            r8[r12] = (byte) (((r10 >>> 14) & 127) | 128);
            int r14 = r13 - 1;
            r8[r13] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r14 - 1;
            r8[r14] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64NineBytes(long r10) {
            byte[] r8 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r8[r11] = (byte) (r10 >>> 56);
            int r13 = r12 - 1;
            r8[r12] = (byte) (((r10 >>> 49) & 127) | 128);
            int r14 = r13 - 1;
            r8[r13] = (byte) (((r10 >>> 42) & 127) | 128);
            int r15 = r14 - 1;
            r8[r14] = (byte) (((r10 >>> 35) & 127) | 128);
            int r16 = r15 - 1;
            r8[r15] = (byte) (((r10 >>> 28) & 127) | 128);
            int r17 = r16 - 1;
            r8[r16] = (byte) (((r10 >>> 21) & 127) | 128);
            int r18 = r17 - 1;
            r8[r17] = (byte) (((r10 >>> 14) & 127) | 128);
            int r19 = r18 - 1;
            r8[r18] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r19 - 1;
            r8[r19] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64OneByte(long r8) {
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10[r11] = (byte) r8;
        }

        private void writeVarint64SevenBytes(long r10) {
            byte[] r8 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r8[r11] = (byte) (r10 >>> 42);
            int r13 = r12 - 1;
            r8[r12] = (byte) (((r10 >>> 35) & 127) | 128);
            int r14 = r13 - 1;
            r8[r13] = (byte) (((r10 >>> 28) & 127) | 128);
            int r15 = r14 - 1;
            r8[r14] = (byte) (((r10 >>> 21) & 127) | 128);
            int r16 = r15 - 1;
            r8[r15] = (byte) (((r10 >>> 14) & 127) | 128);
            int r17 = r16 - 1;
            r8[r16] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r17 - 1;
            r8[r17] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64SixBytes(long r10) {
            byte[] r8 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r8[r11] = (byte) (r10 >>> 35);
            int r13 = r12 - 1;
            r8[r12] = (byte) (((r10 >>> 28) & 127) | 128);
            int r14 = r13 - 1;
            r8[r13] = (byte) (((r10 >>> 21) & 127) | 128);
            int r15 = r14 - 1;
            r8[r14] = (byte) (((r10 >>> 14) & 127) | 128);
            int r16 = r15 - 1;
            r8[r15] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r16 - 1;
            r8[r16] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64TenBytes(long r10) {
            byte[] r8 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r8[r11] = (byte) (r10 >>> 63);
            int r13 = r12 - 1;
            r8[r12] = (byte) (((r10 >>> 56) & 127) | 128);
            int r14 = r13 - 1;
            r8[r13] = (byte) (((r10 >>> 49) & 127) | 128);
            int r15 = r14 - 1;
            r8[r14] = (byte) (((r10 >>> 42) & 127) | 128);
            int r16 = r15 - 1;
            r8[r15] = (byte) (((r10 >>> 35) & 127) | 128);
            int r17 = r16 - 1;
            r8[r16] = (byte) (((r10 >>> 28) & 127) | 128);
            int r18 = r17 - 1;
            r8[r17] = (byte) (((r10 >>> 21) & 127) | 128);
            int r19 = r18 - 1;
            r8[r18] = (byte) (((r10 >>> 14) & 127) | 128);
            int r20 = r19 - 1;
            r8[r19] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r20 - 1;
            r8[r20] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64ThreeBytes(long r10) {
            byte[] r8 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r8[r11] = (byte) (((int) r10) >>> 14);
            int r13 = r12 - 1;
            r8[r12] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r13 - 1;
            r8[r13] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64TwoBytes(long r8) {
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r10[r11] = (byte) (r8 >>> 7);
            this.pos = r12 - 1;
            r10[r12] = (byte) ((((int) r8) & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
        }

        public int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        @Override // com.google.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.allocatedBuffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            AllocatedBuffer r8 = this.allocatedBuffer;
            r8.position((this.pos - r8.arrayOffset()) + 1);
            this.allocatedBuffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
            return;
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.google.protobuf.BinaryWriter
        public void requireSpace(int r8) {
            if (spaceLeft() >= r8) goto L6;
            nextBuffer(r8);
            return;
        }

        public int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte r8) {
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            r10[r11] = r8;
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int r8, boolean r10) {
            requireSpace(6);
            write(r10 ? 1 : 0);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int r8, ByteString r10) {
            r10.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(r10.size());
            writeTag(r8, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int r8) {
            writeTag(r8, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed32(int r8) {
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r10[r11] = (byte) (r8 >> 24);
            int r13 = r12 - 1;
            r10[r12] = (byte) (r8 >> 16);
            int r14 = r13 - 1;
            r10[r13] = (byte) (r8 >> 8);
            this.pos = r14 - 1;
            r10[r14] = (byte) r8;
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int r8, long r10) {
            requireSpace(13);
            writeFixed64(r10);
            writeTag(r8, 1);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeGroup(int r8, Object r10) {
            writeTag(r8, 4);
            Protobuf.getInstance().writeTo(r10, this);
            writeTag(r8, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeInt32(int r8) {
            if (r8 < 0) goto L4;
            writeVarint32(r8);
            return;
        L4:
            writeVarint64(r8);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r8) {
            int r10 = r8.remaining();
            if (spaceLeft() >= r10) goto L5;
            this.totalDoneBytes += r10;
            this.buffers.addFirst(AllocatedBuffer.wrap(r8));
            nextBuffer();
        L5:
            int r11 = this.pos - r10;
            this.pos = r11;
            r8.get(this.buffer, r11 + 1, r10);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r8, Object r10) {
            int r11 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(r10, this);
            int r12 = getTotalBytesWritten() - r11;
            requireSpace(10);
            writeVarint32(r12);
            writeTag(r8, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt32(int r8) {
            writeVarint32(CodedOutputStream.encodeZigZag32(r8));
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int r8, long r10) {
            requireSpace(15);
            writeSInt64(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int r8) {
            writeTag(r8, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int r8, String r10) {
            int r11 = getTotalBytesWritten();
            writeString(r10);
            int r12 = getTotalBytesWritten() - r11;
            requireSpace(10);
            writeVarint32(r12);
            writeTag(r8, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeTag(int r8, int r10) {
            writeVarint32(WireFormat.makeTag(r8, r10));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int r8, int r10) {
            requireSpace(10);
            writeVarint32(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int r8, long r10) {
            requireSpace(15);
            writeVarint64(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint32(int r8) {
            if ((r8 & QesdkUtils.LIMITS.INT_8_LOWER) != 0) goto L6;
            writeVarint32OneByte(r8);
            return;
        L6:
            if ((r8 & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(r8);
            return;
        L9:
            if (((-2097152) & r8) != 0) goto L12;
            writeVarint32ThreeBytes(r8);
            return;
        L12:
            if (((-268435456) & r8) != 0) goto L14;
            writeVarint32FourBytes(r8);
            return;
        L14:
            writeVarint32FiveBytes(r8);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint64(long r8) {
            switch(BinaryWriter.access$200(r8)) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            writeVarint64TenBytes(r8);
            return;
        L6:
            writeVarint64NineBytes(r8);
            return;
        L7:
            writeVarint64EightBytes(r8);
            return;
        L8:
            writeVarint64SevenBytes(r8);
            return;
        L9:
            writeVarint64SixBytes(r8);
            return;
        L10:
            writeVarint64FiveBytes(r8);
            return;
        L11:
            writeVarint64FourBytes(r8);
            return;
        L12:
            writeVarint64ThreeBytes(r8);
            return;
        L13:
            writeVarint64TwoBytes(r8);
            return;
        L14:
            writeVarint64OneByte(r8);
            return;
        }

        private void nextBuffer(int r8) {
            nextBuffer(newHeapBuffer(r8));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer r8) {
            int r10 = r8.remaining();
            if (spaceLeft() >= r10) goto L5;
            nextBuffer(r10);
        L5:
            int r11 = this.pos - r10;
            this.pos = r11;
            r8.get(this.buffer, r11 + 1, r10);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeBool(boolean r8) {
            write(r8 ? 1 : 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int r8, int r10) {
            requireSpace(9);
            writeFixed32(r10);
            writeTag(r8, 5);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed64(long r8) {
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            int r12 = r11 - 1;
            r10[r11] = (byte) (r8 >> 56);
            int r13 = r12 - 1;
            r10[r12] = (byte) (r8 >> 48);
            int r14 = r13 - 1;
            r10[r13] = (byte) (r8 >> 40);
            int r15 = r14 - 1;
            r10[r14] = (byte) (r8 >> 32);
            int r16 = r15 - 1;
            r10[r15] = (byte) (r8 >> 24);
            int r17 = r16 - 1;
            r10[r16] = (byte) (r8 >> 16);
            int r18 = r17 - 1;
            r10[r17] = (byte) (r8 >> 8);
            this.pos = r18 - 1;
            r10[r18] = (byte) r8;
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r8, Object r10, Schema r11) {
            writeTag(r8, 4);
            r11.writeTo(r10, this);
            writeTag(r8, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int r8, int r10) {
            requireSpace(15);
            writeInt32(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r8, int r10, int r11) {
            if (spaceLeft() >= r11) goto L6;
            this.totalDoneBytes += r11;
            this.buffers.addFirst(AllocatedBuffer.wrap(r8, r10, r11));
            nextBuffer();
            return;
        L6:
            int r12 = this.pos - r11;
            this.pos = r12;
            System.arraycopy(r8, r10, this.buffer, r12 + 1, r11);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r8, Object r10, Schema r11) {
            int r12 = getTotalBytesWritten();
            r11.writeTo(r10, this);
            int r13 = getTotalBytesWritten() - r12;
            requireSpace(10);
            writeVarint32(r13);
            writeTag(r8, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int r8, int r10) {
            requireSpace(10);
            writeSInt32(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt64(long r8) {
            writeVarint64(CodedOutputStream.encodeZigZag64(r8));
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeString(String r10) {
            requireSpace(r10.length());
            int r8 = r10.length() - 1;
            this.pos -= r8;
        L4:
            if (r8 < 0) goto L9;
            char r11 = r10.charAt(r8);
            if (r11 >= 128) goto L9;
            this.buffer[this.pos + r8] = (byte) r11;
            r8 = r8 - 1;
        L9:
            if (r8 != (-1)) goto L12;
            this.pos--;
            return;
        L12:
            this.pos += r8;
        L13:
            if (r8 < 0) goto L41;
            char r12 = r10.charAt(r8);
            if (r12 >= 128) goto L20;
            int r13 = this.pos;
            if (r13 <= this.offsetMinusOne) goto L20;
            byte[] r14 = this.buffer;
            this.pos = r13 - 1;
            r14[r13] = (byte) r12;
        L40:
            r8 = r8 - 1;
        L20:
            if (r12 >= 2048) goto L25;
            int r15 = this.pos;
            if (r15 <= this.offset) goto L25;
            byte[] r16 = this.buffer;
            int r17 = r15 - 1;
            r16[r15] = (byte) ((r12 & '?') | 128);
            this.pos = r17 - 1;
            r16[r17] = (byte) ((r12 >>> 6) | 960);
        L25:
            if (r12 >= 55296) goto L27;
        L28:
            int r18 = this.pos;
            if (r18 <= (this.offset + 1)) goto L32;
            byte[] r19 = this.buffer;
            int r20 = r18 - 1;
            r19[r18] = (byte) ((r12 & '?') | 128);
            int r21 = r20 - 1;
            r19[r20] = (byte) (((r12 >>> 6) & 63) | 128);
            this.pos = r21 - 1;
            r19[r21] = (byte) ((r12 >>> '\f') | 480);
        L32:
            if (this.pos <= (this.offset + 2)) goto L39;
            if (r8 == 0) goto L38;
            char r22 = r10.charAt(r8 - 1);
            if (Character.isSurrogatePair(r22, r12) == false) goto L38;
            r8 = r8 - 1;
            int r23 = Character.toCodePoint(r22, r12);
            byte[] r24 = this.buffer;
            int r25 = this.pos;
            int r26 = r25 - 1;
            r24[r25] = (byte) ((r23 & 63) | 128);
            int r27 = r26 - 1;
            r24[r26] = (byte) (((r23 >>> 6) & 63) | 128);
            int r28 = r27 - 1;
            r24[r27] = (byte) (((r23 >>> 12) & 63) | 128);
            this.pos = r28 - 1;
            r24[r28] = (byte) ((r23 >>> 18) | 240);
        L38:
            throw new Utf8.UnpairedSurrogateException(r8 - 1, r8);
        L39:
            requireSpace(r8);
            r8 = r8 + 1;
            goto L40
        L27:
            if (57343 >= r12) goto L32;
        }

        private void nextBuffer(AllocatedBuffer r8) {
            if (r8.hasArray() == false) goto L7;
            finishCurrentBuffer();
            this.buffers.addFirst(r8);
            this.allocatedBuffer = r8;
            this.buffer = r8.array();
            int r10 = r8.arrayOffset();
            this.limit = r8.limit() + r10;
            int r11 = r10 + r8.position();
            this.offset = r11;
            this.offsetMinusOne = r11 - 1;
            int r12 = this.limit - 1;
            this.limitMinusOne = r12;
            this.pos = r12;
            return;
        L7:
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] r8, int r10, int r11) {
            if (spaceLeft() >= r11) goto L5;
            nextBuffer(r11);
        L5:
            int r12 = this.pos - r11;
            this.pos = r12;
            System.arraycopy(r8, r10, this.buffer, r12 + 1, r11);
        }
    }

    public static final class UnsafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private long bufferOffset;
        private long limitMinusOne;
        private long pos;

        public UnsafeDirectWriter(BufferAllocator r8, int r10) {
            super(r8, r10, null);
            nextBuffer();
        }

        public static /* synthetic */ boolean access$000() {
            return isSupported();
        }

        private int bufferPos() {
            return (int) (this.pos - this.bufferOffset);
        }

        private int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        private static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        private void writeVarint32FiveBytes(int r8) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r8 >>> 28));
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (((r8 >>> 21) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r8 >>> 14) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (((r8 >>> 7) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
        }

        private void writeVarint32FourBytes(int r8) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r8 >>> 21));
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (((r8 >>> 14) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r8 >>> 7) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
        }

        private void writeVarint32OneByte(int r8) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) r8);
        }

        private void writeVarint32ThreeBytes(int r8) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r8 >>> 14));
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (((r8 >>> 7) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
        }

        private void writeVarint32TwoBytes(int r8) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r8 >>> 7));
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
        }

        private void writeVarint64EightBytes(long r11) {
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) (r11 >>> 49));
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (((r11 >>> 42) & 127) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r11 >>> 35) & 127) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (((r11 >>> 28) & 127) | 128));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) (((r11 >>> 21) & 127) | 128));
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r15, (byte) (((r11 >>> 14) & 127) | 128));
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r16, (byte) (((r11 >>> 7) & 127) | 128));
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r17, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long r11) {
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) (r11 >>> 28));
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (((r11 >>> 21) & 127) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r11 >>> 14) & 127) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (((r11 >>> 7) & 127) | 128));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64FourBytes(long r11) {
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) (r11 >>> 21));
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (((r11 >>> 14) & 127) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r11 >>> 7) & 127) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64NineBytes(long r11) {
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) (r11 >>> 56));
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (((r11 >>> 49) & 127) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r11 >>> 42) & 127) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (((r11 >>> 35) & 127) | 128));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) (((r11 >>> 28) & 127) | 128));
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r15, (byte) (((r11 >>> 21) & 127) | 128));
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r16, (byte) (((r11 >>> 14) & 127) | 128));
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r17, (byte) (((r11 >>> 7) & 127) | 128));
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r18, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64OneByte(long r8) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) r8);
        }

        private void writeVarint64SevenBytes(long r11) {
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) (r11 >>> 42));
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (((r11 >>> 35) & 127) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r11 >>> 28) & 127) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (((r11 >>> 21) & 127) | 128));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) (((r11 >>> 14) & 127) | 128));
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r15, (byte) (((r11 >>> 7) & 127) | 128));
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r16, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64SixBytes(long r11) {
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) (r11 >>> 35));
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (((r11 >>> 28) & 127) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r11 >>> 21) & 127) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (((r11 >>> 14) & 127) | 128));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) (((r11 >>> 7) & 127) | 128));
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r15, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64TenBytes(long r11) {
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) (r11 >>> 63));
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (((r11 >>> 56) & 127) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r11 >>> 49) & 127) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (((r11 >>> 42) & 127) | 128));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) (((r11 >>> 35) & 127) | 128));
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r15, (byte) (((r11 >>> 28) & 127) | 128));
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r16, (byte) (((r11 >>> 21) & 127) | 128));
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r17, (byte) (((r11 >>> 14) & 127) | 128));
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r18, (byte) (((r11 >>> 7) & 127) | 128));
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r19, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long r11) {
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) (((int) r11) >>> 14));
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (((r11 >>> 7) & 127) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64TwoBytes(long r8) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r8 >>> 7));
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) ((((int) r8) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
        }

        @Override // com.google.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.buffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
            return;
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.google.protobuf.BinaryWriter
        public void requireSpace(int r8) {
            if (spaceLeft() >= r8) goto L6;
            nextBuffer(r8);
            return;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte r8) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int r8, boolean r10) {
            requireSpace(6);
            write(r10 ? 1 : 0);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int r8, ByteString r10) {
            r10.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(r10.size());
            writeTag(r8, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int r8) {
            writeTag(r8, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed32(int r8) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r8 >> 24));
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (r8 >> 16));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (r8 >> 8));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int r8, long r10) {
            requireSpace(13);
            writeFixed64(r10);
            writeTag(r8, 1);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r8, Object r10) {
            writeTag(r8, 4);
            Protobuf.getInstance().writeTo(r10, this);
            writeTag(r8, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeInt32(int r8) {
            if (r8 < 0) goto L4;
            writeVarint32(r8);
            return;
        L4:
            writeVarint64(r8);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r8) {
            int r10 = r8.remaining();
            if (spaceLeft() >= r10) goto L6;
            this.totalDoneBytes += r10;
            this.buffers.addFirst(AllocatedBuffer.wrap(r8));
            nextBuffer();
            return;
        L6:
            this.pos -= (long) r10;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r8, Object r10) {
            int r11 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(r10, this);
            int r12 = getTotalBytesWritten() - r11;
            requireSpace(10);
            writeVarint32(r12);
            writeTag(r8, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt32(int r8) {
            writeVarint32(CodedOutputStream.encodeZigZag32(r8));
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int r8, long r10) {
            requireSpace(15);
            writeSInt64(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int r8) {
            writeTag(r8, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int r8, String r10) {
            int r11 = getTotalBytesWritten();
            writeString(r10);
            int r12 = getTotalBytesWritten() - r11;
            requireSpace(10);
            writeVarint32(r12);
            writeTag(r8, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeTag(int r8, int r10) {
            writeVarint32(WireFormat.makeTag(r8, r10));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int r8, int r10) {
            requireSpace(10);
            writeVarint32(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int r8, long r10) {
            requireSpace(15);
            writeVarint64(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint32(int r8) {
            if ((r8 & QesdkUtils.LIMITS.INT_8_LOWER) != 0) goto L6;
            writeVarint32OneByte(r8);
            return;
        L6:
            if ((r8 & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(r8);
            return;
        L9:
            if (((-2097152) & r8) != 0) goto L12;
            writeVarint32ThreeBytes(r8);
            return;
        L12:
            if (((-268435456) & r8) != 0) goto L14;
            writeVarint32FourBytes(r8);
            return;
        L14:
            writeVarint32FiveBytes(r8);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint64(long r8) {
            switch(BinaryWriter.access$200(r8)) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            writeVarint64TenBytes(r8);
            return;
        L6:
            writeVarint64NineBytes(r8);
            return;
        L7:
            writeVarint64EightBytes(r8);
            return;
        L8:
            writeVarint64SevenBytes(r8);
            return;
        L9:
            writeVarint64SixBytes(r8);
            return;
        L10:
            writeVarint64FiveBytes(r8);
            return;
        L11:
            writeVarint64FourBytes(r8);
            return;
        L12:
            writeVarint64ThreeBytes(r8);
            return;
        L13:
            writeVarint64TwoBytes(r8);
            return;
        L14:
            writeVarint64OneByte(r8);
            return;
        }

        private void nextBuffer(int r8) {
            nextBuffer(newDirectBuffer(r8));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer r8) {
            int r10 = r8.remaining();
            if (spaceLeft() >= r10) goto L5;
            nextBuffer(r10);
        L5:
            this.pos -= (long) r10;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(r8);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeBool(boolean r8) {
            write(r8 ? 1 : 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int r8, int r10) {
            requireSpace(9);
            writeFixed32(r10);
            writeTag(r8, 5);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed64(long r8) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r8 >> 56));
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (r8 >> 48));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (r8 >> 40));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (r8 >> 32));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) (r8 >> 24));
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r15, (byte) (r8 >> 16));
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r16, (byte) (r8 >> 8));
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r17, (byte) r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r8, Object r10, Schema r11) {
            writeTag(r8, 4);
            r11.writeTo(r10, this);
            writeTag(r8, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int r8, int r10) {
            requireSpace(15);
            writeInt32(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r8, int r10, int r11) {
            if (spaceLeft() >= r11) goto L6;
            this.totalDoneBytes += r11;
            this.buffers.addFirst(AllocatedBuffer.wrap(r8, r10, r11));
            nextBuffer();
            return;
        L6:
            this.pos -= (long) r11;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(r8, r10, r11);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r8, Object r10, Schema r11) {
            int r12 = getTotalBytesWritten();
            r11.writeTo(r10, this);
            int r13 = getTotalBytesWritten() - r12;
            requireSpace(10);
            writeVarint32(r13);
            writeTag(r8, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int r8, int r10) {
            requireSpace(10);
            writeSInt32(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt64(long r8) {
            writeVarint64(CodedOutputStream.encodeZigZag64(r8));
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeString(String r13) {
            requireSpace(r13.length());
            int r8 = r13.length();
        L3:
            r8 = r8 - 1;
            if (r8 < 0) goto L9;
            char r10 = r13.charAt(r8);
            if (r10 >= 128) goto L9;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) r10);
        L9:
            if (r8 != (-1)) goto L11;
            return;
        L11:
            if (r8 < 0) goto L40;
            char r12 = r13.charAt(r8);
            if (r12 >= 128) goto L18;
            long r14 = this.pos;
            if (r14 < this.bufferOffset) goto L18;
            this.pos = r14 - 1;
            int r15 = r12;
        L35:
            UnsafeUtil.putByte(r14, (byte) r15);
        L39:
            r8 = r8 - 1;
        L18:
            if (r12 >= 2048) goto L23;
            long r16 = this.pos;
            if (r16 <= this.bufferOffset) goto L23;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r16, (byte) ((r12 & '?') | 128));
            r14 = this.pos;
            this.pos = r14 - 1;
            r15 = (r12 >>> 6) | 960;
        L23:
            if (r12 >= 55296) goto L25;
        L26:
            long r17 = this.pos;
            if (r17 <= (this.bufferOffset + 1)) goto L30;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r17, (byte) ((r12 & '?') | 128));
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r18, (byte) (((r12 >>> 6) & 63) | 128));
            r14 = this.pos;
            this.pos = r14 - 1;
            r15 = (r12 >>> '\f') | 480;
        L30:
            if (this.pos <= (this.bufferOffset + 2)) goto L38;
            if (r8 == 0) goto L37;
            char r19 = r13.charAt(r8 - 1);
            if (Character.isSurrogatePair(r19, r12) == false) goto L37;
            r8 = r8 - 1;
            int r20 = Character.toCodePoint(r19, r12);
            long r21 = this.pos;
            this.pos = r21 - 1;
            UnsafeUtil.putByte(r21, (byte) ((r20 & 63) | 128));
            long r22 = this.pos;
            this.pos = r22 - 1;
            UnsafeUtil.putByte(r22, (byte) (((r20 >>> 6) & 63) | 128));
            long r23 = this.pos;
            this.pos = r23 - 1;
            UnsafeUtil.putByte(r23, (byte) (((r20 >>> 12) & 63) | 128));
            r14 = this.pos;
            this.pos = r14 - 1;
            r15 = (r20 >>> 18) | 240;
        L37:
            throw new Utf8.UnpairedSurrogateException(r8 - 1, r8);
        L38:
            requireSpace(r8);
            r8 = r8 + 1;
            goto L39
        L25:
            if (57343 >= r12) goto L30;
        }

        private void nextBuffer(AllocatedBuffer r8) {
            if (r8.hasNioBuffer() == false) goto L11;
            ByteBuffer r10 = r8.nioBuffer();
            if (r10.isDirect() == false) goto L9;
            finishCurrentBuffer();
            this.buffers.addFirst(r8);
            this.buffer = r10;
            Java8Compatibility.limit(r10, r10.capacity());
            Java8Compatibility.position(this.buffer, 0);
            long r11 = UnsafeUtil.addressOffset(this.buffer);
            this.bufferOffset = r11;
            long r12 = r11 + ((long) (this.buffer.limit() - 1));
            this.limitMinusOne = r12;
            this.pos = r12;
            return;
        L9:
            throw new RuntimeException("Allocator returned non-direct buffer");
        L11:
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] r8, int r10, int r11) {
            if (spaceLeft() >= r11) goto L5;
            nextBuffer(r11);
        L5:
            this.pos -= (long) r11;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(r8, r10, r11);
        }
    }

    public static final class UnsafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private long limit;
        private long limitMinusOne;
        private long offset;
        private long offsetMinusOne;
        private long pos;

        public UnsafeHeapWriter(BufferAllocator r8, int r10) {
            super(r8, r10, null);
            nextBuffer();
        }

        private int arrayPos() {
            return (int) this.pos;
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int r8) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r8 >>> 28));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (((r8 >>> 21) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((r8 >>> 14) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) (((r8 >>> 7) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
            byte[] r18 = this.buffer;
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r18, r19, (byte) ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
        }

        private void writeVarint32FourBytes(int r8) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r8 >>> 21));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (((r8 >>> 14) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((r8 >>> 7) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
        }

        private void writeVarint32OneByte(int r8) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) r8);
        }

        private void writeVarint32ThreeBytes(int r8) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r8 >>> 14));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (((r8 >>> 7) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
        }

        private void writeVarint32TwoBytes(int r8) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r8 >>> 7));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) ((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
        }

        private void writeVarint64EightBytes(long r12) {
            byte[] r8 = this.buffer;
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r8, r10, (byte) (r12 >>> 49));
            byte[] r11 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r11, r13, (byte) (((r12 >>> 42) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((r12 >>> 35) & 127) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r18 = this.buffer;
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r18, r19, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r20 = this.buffer;
            long r21 = this.pos;
            this.pos = r21 - 1;
            UnsafeUtil.putByte(r20, r21, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r22 = this.buffer;
            long r23 = this.pos;
            this.pos = r23 - 1;
            UnsafeUtil.putByte(r22, r23, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r24 = this.buffer;
            long r25 = this.pos;
            this.pos = r25 - 1;
            UnsafeUtil.putByte(r24, r25, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long r12) {
            byte[] r8 = this.buffer;
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r8, r10, (byte) (r12 >>> 28));
            byte[] r11 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r11, r13, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r18 = this.buffer;
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r18, r19, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64FourBytes(long r12) {
            byte[] r8 = this.buffer;
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r8, r10, (byte) (r12 >>> 21));
            byte[] r11 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r11, r13, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64NineBytes(long r12) {
            byte[] r8 = this.buffer;
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r8, r10, (byte) (r12 >>> 56));
            byte[] r11 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r11, r13, (byte) (((r12 >>> 49) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((r12 >>> 42) & 127) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) (((r12 >>> 35) & 127) | 128));
            byte[] r18 = this.buffer;
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r18, r19, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r20 = this.buffer;
            long r21 = this.pos;
            this.pos = r21 - 1;
            UnsafeUtil.putByte(r20, r21, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r22 = this.buffer;
            long r23 = this.pos;
            this.pos = r23 - 1;
            UnsafeUtil.putByte(r22, r23, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r24 = this.buffer;
            long r25 = this.pos;
            this.pos = r25 - 1;
            UnsafeUtil.putByte(r24, r25, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r26 = this.buffer;
            long r27 = this.pos;
            this.pos = r27 - 1;
            UnsafeUtil.putByte(r26, r27, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64OneByte(long r8) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) r8);
        }

        private void writeVarint64SevenBytes(long r12) {
            byte[] r8 = this.buffer;
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r8, r10, (byte) (r12 >>> 42));
            byte[] r11 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r11, r13, (byte) (((r12 >>> 35) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r18 = this.buffer;
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r18, r19, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r20 = this.buffer;
            long r21 = this.pos;
            this.pos = r21 - 1;
            UnsafeUtil.putByte(r20, r21, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r22 = this.buffer;
            long r23 = this.pos;
            this.pos = r23 - 1;
            UnsafeUtil.putByte(r22, r23, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64SixBytes(long r12) {
            byte[] r8 = this.buffer;
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r8, r10, (byte) (r12 >>> 35));
            byte[] r11 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r11, r13, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r18 = this.buffer;
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r18, r19, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r20 = this.buffer;
            long r21 = this.pos;
            this.pos = r21 - 1;
            UnsafeUtil.putByte(r20, r21, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64TenBytes(long r12) {
            byte[] r8 = this.buffer;
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r8, r10, (byte) (r12 >>> 63));
            byte[] r11 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r11, r13, (byte) (((r12 >>> 56) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((r12 >>> 49) & 127) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) (((r12 >>> 42) & 127) | 128));
            byte[] r18 = this.buffer;
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r18, r19, (byte) (((r12 >>> 35) & 127) | 128));
            byte[] r20 = this.buffer;
            long r21 = this.pos;
            this.pos = r21 - 1;
            UnsafeUtil.putByte(r20, r21, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r22 = this.buffer;
            long r23 = this.pos;
            this.pos = r23 - 1;
            UnsafeUtil.putByte(r22, r23, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r24 = this.buffer;
            long r25 = this.pos;
            this.pos = r25 - 1;
            UnsafeUtil.putByte(r24, r25, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r26 = this.buffer;
            long r27 = this.pos;
            this.pos = r27 - 1;
            UnsafeUtil.putByte(r26, r27, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r28 = this.buffer;
            long r29 = this.pos;
            this.pos = r29 - 1;
            UnsafeUtil.putByte(r28, r29, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long r12) {
            byte[] r8 = this.buffer;
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r8, r10, (byte) (((int) r12) >>> 14));
            byte[] r11 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r11, r13, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64TwoBytes(long r8) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r8 >>> 7));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) ((((int) r8) & QesdkUtils.LIMITS.INT_8_UPPER) | 128));
        }

        public int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.allocatedBuffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            this.allocatedBuffer.position((arrayPos() - this.allocatedBuffer.arrayOffset()) + 1);
            this.allocatedBuffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
            return;
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.google.protobuf.BinaryWriter
        public void requireSpace(int r8) {
            if (spaceLeft() >= r8) goto L6;
            nextBuffer(r8);
            return;
        }

        public int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte r8) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int r8, boolean r10) {
            requireSpace(6);
            write(r10 ? 1 : 0);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int r8, ByteString r10) {
            r10.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(r10.size());
            writeTag(r8, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int r8) {
            writeTag(r8, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed32(int r8) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r8 >> 24));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (r8 >> 16));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (r8 >> 8));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int r8, long r10) {
            requireSpace(13);
            writeFixed64(r10);
            writeTag(r8, 1);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r8, Object r10) {
            writeTag(r8, 4);
            Protobuf.getInstance().writeTo(r10, this);
            writeTag(r8, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeInt32(int r8) {
            if (r8 < 0) goto L4;
            writeVarint32(r8);
            return;
        L4:
            writeVarint64(r8);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r8) {
            int r10 = r8.remaining();
            if (spaceLeft() >= r10) goto L5;
            this.totalDoneBytes += r10;
            this.buffers.addFirst(AllocatedBuffer.wrap(r8));
            nextBuffer();
        L5:
            this.pos -= (long) r10;
            r8.get(this.buffer, arrayPos() + 1, r10);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r8, Object r10) {
            int r11 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(r10, this);
            int r12 = getTotalBytesWritten() - r11;
            requireSpace(10);
            writeVarint32(r12);
            writeTag(r8, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt32(int r8) {
            writeVarint32(CodedOutputStream.encodeZigZag32(r8));
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int r8, long r10) {
            requireSpace(15);
            writeSInt64(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int r8) {
            writeTag(r8, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int r8, String r10) {
            int r11 = getTotalBytesWritten();
            writeString(r10);
            int r12 = getTotalBytesWritten() - r11;
            requireSpace(10);
            writeVarint32(r12);
            writeTag(r8, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeTag(int r8, int r10) {
            writeVarint32(WireFormat.makeTag(r8, r10));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int r8, int r10) {
            requireSpace(10);
            writeVarint32(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int r8, long r10) {
            requireSpace(15);
            writeVarint64(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint32(int r8) {
            if ((r8 & QesdkUtils.LIMITS.INT_8_LOWER) != 0) goto L6;
            writeVarint32OneByte(r8);
            return;
        L6:
            if ((r8 & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(r8);
            return;
        L9:
            if (((-2097152) & r8) != 0) goto L12;
            writeVarint32ThreeBytes(r8);
            return;
        L12:
            if (((-268435456) & r8) != 0) goto L14;
            writeVarint32FourBytes(r8);
            return;
        L14:
            writeVarint32FiveBytes(r8);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint64(long r8) {
            switch(BinaryWriter.access$200(r8)) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            writeVarint64TenBytes(r8);
            return;
        L6:
            writeVarint64NineBytes(r8);
            return;
        L7:
            writeVarint64EightBytes(r8);
            return;
        L8:
            writeVarint64SevenBytes(r8);
            return;
        L9:
            writeVarint64SixBytes(r8);
            return;
        L10:
            writeVarint64FiveBytes(r8);
            return;
        L11:
            writeVarint64FourBytes(r8);
            return;
        L12:
            writeVarint64ThreeBytes(r8);
            return;
        L13:
            writeVarint64TwoBytes(r8);
            return;
        L14:
            writeVarint64OneByte(r8);
            return;
        }

        private void nextBuffer(int r8) {
            nextBuffer(newHeapBuffer(r8));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer r8) {
            int r10 = r8.remaining();
            requireSpace(r10);
            this.pos -= (long) r10;
            r8.get(this.buffer, arrayPos() + 1, r10);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeBool(boolean r8) {
            write(r8 ? 1 : 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int r8, int r10) {
            requireSpace(9);
            writeFixed32(r10);
            writeTag(r8, 5);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed64(long r8) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r8 >> 56));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (r8 >> 48));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (r8 >> 40));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) (r8 >> 32));
            byte[] r18 = this.buffer;
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r18, r19, (byte) (r8 >> 24));
            byte[] r20 = this.buffer;
            long r21 = this.pos;
            this.pos = r21 - 1;
            UnsafeUtil.putByte(r20, r21, (byte) (r8 >> 16));
            byte[] r22 = this.buffer;
            long r23 = this.pos;
            this.pos = r23 - 1;
            UnsafeUtil.putByte(r22, r23, (byte) (r8 >> 8));
            byte[] r24 = this.buffer;
            long r25 = this.pos;
            this.pos = r25 - 1;
            UnsafeUtil.putByte(r24, r25, (byte) r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r8, Object r10, Schema r11) {
            writeTag(r8, 4);
            r11.writeTo(r10, this);
            writeTag(r8, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int r8, int r10) {
            requireSpace(15);
            writeInt32(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r8, int r10, int r11) {
            if (r10 < 0) goto L12;
            if ((r10 + r11) > r8.length) goto L12;
            if (spaceLeft() >= r11) goto L9;
            this.totalDoneBytes += r11;
            this.buffers.addFirst(AllocatedBuffer.wrap(r8, r10, r11));
            nextBuffer();
            return;
        L9:
            this.pos -= (long) r11;
            System.arraycopy(r8, r10, this.buffer, arrayPos() + 1, r11);
            return;
        L12:
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r8.length), Integer.valueOf(r10), Integer.valueOf(r11)}));
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r8, Object r10, Schema r11) {
            int r12 = getTotalBytesWritten();
            r11.writeTo(r10, this);
            int r13 = getTotalBytesWritten() - r12;
            requireSpace(10);
            writeVarint32(r13);
            writeTag(r8, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int r8, int r10) {
            requireSpace(10);
            writeSInt32(r10);
            writeTag(r8, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt64(long r8) {
            writeVarint64(CodedOutputStream.encodeZigZag64(r8));
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeString(String r13) {
            requireSpace(r13.length());
            int r8 = r13.length();
        L3:
            r8 = r8 - 1;
            if (r8 < 0) goto L9;
            char r10 = r13.charAt(r8);
            if (r10 >= 128) goto L9;
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) r10);
        L9:
            if (r8 != (-1)) goto L11;
            return;
        L11:
            if (r8 < 0) goto L39;
            char r14 = r13.charAt(r8);
            if (r14 >= 128) goto L18;
            long r15 = this.pos;
            if (r15 <= this.offsetMinusOne) goto L18;
            byte[] r16 = this.buffer;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r16, r15, (byte) r14);
        L38:
            r8 = r8 - 1;
        L18:
            if (r14 >= 2048) goto L23;
            long r17 = this.pos;
            if (r17 <= this.offset) goto L23;
            byte[] r18 = this.buffer;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r18, r17, (byte) ((r14 & '?') | 128));
            byte[] r19 = this.buffer;
            long r20 = this.pos;
            this.pos = r20 - 1;
            UnsafeUtil.putByte(r19, r20, (byte) ((r14 >>> 6) | 960));
        L23:
            if (r14 >= 55296) goto L25;
        L26:
            long r21 = this.pos;
            if (r21 <= (this.offset + 1)) goto L30;
            byte[] r22 = this.buffer;
            this.pos = r21 - 1;
            UnsafeUtil.putByte(r22, r21, (byte) ((r14 & '?') | 128));
            byte[] r23 = this.buffer;
            long r24 = this.pos;
            this.pos = r24 - 1;
            UnsafeUtil.putByte(r23, r24, (byte) (((r14 >>> 6) & 63) | 128));
            byte[] r25 = this.buffer;
            long r26 = this.pos;
            this.pos = r26 - 1;
            UnsafeUtil.putByte(r25, r26, (byte) ((r14 >>> '\f') | 480));
        L30:
            if (this.pos <= (this.offset + 2)) goto L37;
            if (r8 == 0) goto L36;
            char r27 = r13.charAt(r8 - 1);
            if (Character.isSurrogatePair(r27, r14) == false) goto L36;
            r8 = r8 - 1;
            int r28 = Character.toCodePoint(r27, r14);
            byte[] r29 = this.buffer;
            long r30 = this.pos;
            this.pos = r30 - 1;
            UnsafeUtil.putByte(r29, r30, (byte) ((r28 & 63) | 128));
            byte[] r31 = this.buffer;
            long r32 = this.pos;
            this.pos = r32 - 1;
            UnsafeUtil.putByte(r31, r32, (byte) (((r28 >>> 6) & 63) | 128));
            byte[] r33 = this.buffer;
            long r34 = this.pos;
            this.pos = r34 - 1;
            UnsafeUtil.putByte(r33, r34, (byte) (((r28 >>> 12) & 63) | 128));
            byte[] r35 = this.buffer;
            long r36 = this.pos;
            this.pos = r36 - 1;
            UnsafeUtil.putByte(r35, r36, (byte) ((r28 >>> 18) | 240));
        L36:
            throw new Utf8.UnpairedSurrogateException(r8 - 1, r8);
        L37:
            requireSpace(r8);
            r8 = r8 + 1;
            goto L38
        L25:
            if (57343 >= r14) goto L30;
        }

        private void nextBuffer(AllocatedBuffer r8) {
            if (r8.hasArray() == false) goto L7;
            finishCurrentBuffer();
            this.buffers.addFirst(r8);
            this.allocatedBuffer = r8;
            this.buffer = r8.array();
            long r10 = r8.arrayOffset();
            this.limit = ((long) r8.limit()) + r10;
            long r11 = r10 + ((long) r8.position());
            this.offset = r11;
            this.offsetMinusOne = r11 - 1;
            long r12 = this.limit - 1;
            this.limitMinusOne = r12;
            this.pos = r12;
            return;
        L7:
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] r8, int r10, int r11) {
            if (r10 < 0) goto L8;
            if ((r10 + r11) > r8.length) goto L8;
            requireSpace(r11);
            this.pos -= (long) r11;
            System.arraycopy(r8, r10, this.buffer, arrayPos() + 1, r11);
            return;
        L8:
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r8.length), Integer.valueOf(r10), Integer.valueOf(r11)}));
        }
    }

    private BinaryWriter(BufferAllocator r8, int r10) {
        this.buffers = new ArrayDeque(4);
        if (r10 <= 0) goto L7;
        this.alloc = (BufferAllocator) Internal.checkNotNull(r8, "alloc");
        this.chunkSize = r10;
        return;
    L7:
        throw new IllegalArgumentException("chunkSize must be > 0");
    }

    public static /* synthetic */ byte access$200(long r8) {
        return computeUInt64SizeNoTag(r8);
    }

    private static byte computeUInt64SizeNoTag(long r8) {
        if (((-128) & r8) != 0) goto L7;
        return 1;
    L7:
        if (r8 >= 0) goto L11;
        return 10;
    L11:
        if (((-34359738368L) & r8) == 0) goto L13;
        byte r10 = (byte) 6;
        r8 = r8 >>> 28;
    L15:
        if (((-2097152) & r8) == 0) goto L18;
        r10 = (byte) (r10 + 2);
        r8 = r8 >>> 14;
    L18:
        if ((r8 & (-16384)) != 0) goto L20;
        return r10;
    L20:
        return (byte) (r10 + 1);
    L13:
        r10 = 2;
        goto L15
    }

    public static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.access$000();
    }

    public static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    public static BinaryWriter newDirectInstance(BufferAllocator r8) {
        return newDirectInstance(r8, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator r8) {
        return newHeapInstance(r8, 4096);
    }

    public static BinaryWriter newSafeDirectInstance(BufferAllocator r8, int r10) {
        return new SafeDirectWriter(r8, r10);
    }

    public static BinaryWriter newSafeHeapInstance(BufferAllocator r8, int r10) {
        return new SafeHeapWriter(r8, r10);
    }

    public static BinaryWriter newUnsafeDirectInstance(BufferAllocator r8, int r10) {
        if (isUnsafeDirectSupported() == false) goto L7;
        return new UnsafeDirectWriter(r8, r10);
    L7:
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    public static BinaryWriter newUnsafeHeapInstance(BufferAllocator r8, int r10) {
        if (isUnsafeHeapSupported() == false) goto L7;
        return new UnsafeHeapWriter(r8, r10);
    L7:
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private void writeBoolList_Internal(int r8, BooleanArrayList r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace(r10.size() + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeBool(r10.getBoolean(r13));
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeBool(r8, r10.getBoolean(r14));
        r14 = r14 - 1;
        goto L8
    }

    private void writeDoubleList_Internal(int r8, DoubleArrayList r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 8) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeFixed64(Double.doubleToRawLongBits(r10.getDouble(r13)));
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeDouble(r8, r10.getDouble(r14));
        r14 = r14 - 1;
        goto L8
    }

    private void writeFixed32List_Internal(int r8, IntArrayList r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 4) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeFixed32(r10.getInt(r13));
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeFixed32(r8, r10.getInt(r14));
        r14 = r14 - 1;
        goto L8
    }

    private void writeFixed64List_Internal(int r8, LongArrayList r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 8) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeFixed64(r10.getLong(r13));
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeFixed64(r8, r10.getLong(r14));
        r14 = r14 - 1;
        goto L8
    }

    private void writeFloatList_Internal(int r8, FloatArrayList r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 4) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeFixed32(Float.floatToRawIntBits(r10.getFloat(r13)));
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeFloat(r8, r10.getFloat(r14));
        r14 = r14 - 1;
        goto L8
    }

    private void writeInt32List_Internal(int r8, IntArrayList r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 10) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeInt32(r10.getInt(r13));
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeInt32(r8, r10.getInt(r14));
        r14 = r14 - 1;
        goto L8
    }

    private void writeLazyString(int r8, Object r10) {
        if ((r10 instanceof String) == false) goto L5;
        writeString(r8, (String) r10);
        return;
    L5:
        writeBytes(r8, (ByteString) r10);
    }

    public static final void writeMapEntryField(Writer r8, int r10, WireFormat.FieldType r11, Object r12) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.ordinal()]) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L18;
            case 14: goto L17;
            case 15: goto L16;
            case 16: goto L15;
            case 17: goto L7;
            default: goto L5;
        };
    L15:
        r8.writeBytes(r10, (ByteString) r12);
        return;
    L16:
        r8.writeMessage(r10, r12);
        return;
    L17:
        r8.writeDouble(r10, ((Double) r12).doubleValue());
        return;
    L18:
        r8.writeFloat(r10, ((Float) r12).floatValue());
        return;
    L19:
        r8.writeUInt64(r10, ((Long) r12).longValue());
        return;
    L20:
        r8.writeUInt32(r10, ((Integer) r12).intValue());
        return;
    L21:
        r8.writeString(r10, (String) r12);
        return;
    L22:
        r8.writeSInt64(r10, ((Long) r12).longValue());
        return;
    L23:
        r8.writeSInt32(r10, ((Integer) r12).intValue());
        return;
    L24:
        r8.writeSFixed64(r10, ((Long) r12).longValue());
        return;
    L25:
        r8.writeSFixed32(r10, ((Integer) r12).intValue());
        return;
    L26:
        r8.writeInt64(r10, ((Long) r12).longValue());
        return;
    L27:
        r8.writeInt32(r10, ((Integer) r12).intValue());
        return;
    L28:
        r8.writeFixed64(r10, ((Long) r12).longValue());
        return;
    L29:
        r8.writeFixed32(r10, ((Integer) r12).intValue());
        return;
    L30:
        r8.writeBool(r10, ((Boolean) r12).booleanValue());
        return;
    L5:
        throw new IllegalArgumentException("Unsupported map value type for: " + r11);
    L7:
        if ((r12 instanceof Internal.EnumLite) == false) goto L11;
        int r13 = ((Internal.EnumLite) r12).getNumber();
    L9:
        r8.writeEnum(r10, r13);
        return;
    L11:
        if ((r12 instanceof Integer) == false) goto L14;
        r13 = ((Integer) r12).intValue();
        goto L9
    L14:
        throw new IllegalArgumentException("Unexpected type for enum in map.");
    }

    private void writeSInt32List_Internal(int r8, IntArrayList r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 5) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeSInt32(r10.getInt(r13));
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeSInt32(r8, r10.getInt(r14));
        r14 = r14 - 1;
        goto L8
    }

    private void writeSInt64List_Internal(int r8, LongArrayList r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 10) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeSInt64(r10.getLong(r13));
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeSInt64(r8, r10.getLong(r14));
        r14 = r14 - 1;
        goto L8
    }

    private void writeUInt32List_Internal(int r8, IntArrayList r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 5) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeVarint32(r10.getInt(r13));
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeUInt32(r8, r10.getInt(r14));
        r14 = r14 - 1;
        goto L8
    }

    private void writeUInt64List_Internal(int r8, LongArrayList r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 10) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeVarint64(r10.getLong(r13));
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeUInt64(r8, r10.getLong(r14));
        r14 = r14 - 1;
        goto L8
    }

    @CanIgnoreReturnValue
    public final Queue<AllocatedBuffer> complete() {
        finishCurrentBuffer();
        return this.buffers;
    }

    @Override // com.google.protobuf.Writer
    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    public abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    public final AllocatedBuffer newDirectBuffer() {
        return this.alloc.allocateDirectBuffer(this.chunkSize);
    }

    public final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    public abstract void requireSpace(int r8);

    public abstract void writeBool(boolean r8);

    @Override // com.google.protobuf.Writer
    public final void writeBoolList(int r8, List<Boolean> r10, boolean r11) {
        if ((r10 instanceof BooleanArrayList) == false) goto L5;
        writeBoolList_Internal(r8, (BooleanArrayList) r10, r11);
        return;
    L5:
        writeBoolList_Internal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public final void writeBytesList(int r8, List<ByteString> r10) {
        int r11 = r10.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        writeBytes(r8, r10.get(r11));
        r11 = r11 - 1;
        goto L3
    }

    @Override // com.google.protobuf.Writer
    public final void writeDouble(int r8, double r10) {
        writeFixed64(r8, Double.doubleToRawLongBits(r10));
    }

    @Override // com.google.protobuf.Writer
    public final void writeDoubleList(int r8, List<Double> r10, boolean r11) {
        if ((r10 instanceof DoubleArrayList) == false) goto L5;
        writeDoubleList_Internal(r8, (DoubleArrayList) r10, r11);
        return;
    L5:
        writeDoubleList_Internal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public final void writeEnum(int r8, int r10) {
        writeInt32(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public final void writeEnumList(int r8, List<Integer> r10, boolean r11) {
        writeInt32List(r8, r10, r11);
    }

    public abstract void writeFixed32(int r8);

    @Override // com.google.protobuf.Writer
    public final void writeFixed32List(int r8, List<Integer> r10, boolean r11) {
        if ((r10 instanceof IntArrayList) == false) goto L5;
        writeFixed32List_Internal(r8, (IntArrayList) r10, r11);
        return;
    L5:
        writeFixed32List_Internal(r8, r10, r11);
    }

    public abstract void writeFixed64(long r8);

    @Override // com.google.protobuf.Writer
    public final void writeFixed64List(int r8, List<Long> r10, boolean r11) {
        if ((r10 instanceof LongArrayList) == false) goto L5;
        writeFixed64List_Internal(r8, (LongArrayList) r10, r11);
        return;
    L5:
        writeFixed64List_Internal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public final void writeFloat(int r8, float r10) {
        writeFixed32(r8, Float.floatToRawIntBits(r10));
    }

    @Override // com.google.protobuf.Writer
    public final void writeFloatList(int r8, List<Float> r10, boolean r11) {
        if ((r10 instanceof FloatArrayList) == false) goto L5;
        writeFloatList_Internal(r8, (FloatArrayList) r10, r11);
        return;
    L5:
        writeFloatList_Internal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int r8, List<?> r10) {
        int r11 = r10.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        writeGroup(r8, r10.get(r11));
        r11 = r11 - 1;
        goto L3
    }

    public abstract void writeInt32(int r8);

    @Override // com.google.protobuf.Writer
    public final void writeInt32List(int r8, List<Integer> r10, boolean r11) {
        if ((r10 instanceof IntArrayList) == false) goto L5;
        writeInt32List_Internal(r8, (IntArrayList) r10, r11);
        return;
    L5:
        writeInt32List_Internal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt64(int r8, long r10) {
        writeUInt64(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt64List(int r8, List<Long> r10, boolean r11) {
        writeUInt64List(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int r8, MapEntryLite.Metadata<K, V> r10, Map<K, V> r11) {
        Iterator<Map.Entry<K, V>> r12 = r11.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<K, V> r13 = r12.next();
        int r14 = getTotalBytesWritten();
        writeMapEntryField(this, 2, r10.valueType, r13.getValue());
        writeMapEntryField(this, 1, r10.keyType, r13.getKey());
        writeVarint32(getTotalBytesWritten() - r14);
        writeTag(r8, 2);
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageList(int r8, List<?> r10) {
        int r11 = r10.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        writeMessage(r8, r10.get(r11));
        r11 = r11 - 1;
        goto L3
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int r8, Object r10) {
        writeTag(1, 4);
        if ((r10 instanceof ByteString) == false) goto L5;
        writeBytes(3, (ByteString) r10);
    L6:
        writeUInt32(2, r8);
        writeTag(1, 3);
        return;
    L5:
        writeMessage(3, r10);
        goto L6
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed32(int r8, int r10) {
        writeFixed32(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed32List(int r8, List<Integer> r10, boolean r11) {
        writeFixed32List(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed64(int r8, long r10) {
        writeFixed64(r8, r10);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed64List(int r8, List<Long> r10, boolean r11) {
        writeFixed64List(r8, r10, r11);
    }

    public abstract void writeSInt32(int r8);

    @Override // com.google.protobuf.Writer
    public final void writeSInt32List(int r8, List<Integer> r10, boolean r11) {
        if ((r10 instanceof IntArrayList) == false) goto L5;
        writeSInt32List_Internal(r8, (IntArrayList) r10, r11);
        return;
    L5:
        writeSInt32List_Internal(r8, r10, r11);
    }

    public abstract void writeSInt64(long r8);

    @Override // com.google.protobuf.Writer
    public final void writeSInt64List(int r8, List<Long> r10, boolean r11) {
        if ((r10 instanceof LongArrayList) == false) goto L5;
        writeSInt64List_Internal(r8, (LongArrayList) r10, r11);
        return;
    L5:
        writeSInt64List_Internal(r8, r10, r11);
    }

    public abstract void writeString(String r8);

    @Override // com.google.protobuf.Writer
    public final void writeStringList(int r8, List<String> r10) {
        if ((r10 instanceof LazyStringList) == false) goto L7;
        LazyStringList r11 = (LazyStringList) r10;
        int r12 = r10.size() - 1;
    L5:
        if (r12 < 0) goto L10;
        writeLazyString(r8, r11.getRaw(r12));
        r12 = r12 - 1;
        goto L5
    L10:
        return;
    L7:
        int r13 = r10.size() - 1;
    L8:
        if (r13 < 0) goto L13;
        writeString(r8, r10.get(r13));
        r13 = r13 - 1;
        goto L8
    }

    public abstract void writeTag(int r8, int r10);

    @Override // com.google.protobuf.Writer
    public final void writeUInt32List(int r8, List<Integer> r10, boolean r11) {
        if ((r10 instanceof IntArrayList) == false) goto L5;
        writeUInt32List_Internal(r8, (IntArrayList) r10, r11);
        return;
    L5:
        writeUInt32List_Internal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public final void writeUInt64List(int r8, List<Long> r10, boolean r11) {
        if ((r10 instanceof LongArrayList) == false) goto L5;
        writeUInt64List_Internal(r8, (LongArrayList) r10, r11);
        return;
    L5:
        writeUInt64List_Internal(r8, r10, r11);
    }

    public abstract void writeVarint32(int r8);

    public abstract void writeVarint64(long r8);

    public /* synthetic */ BinaryWriter(BufferAllocator r8, int r10, AnonymousClass1 r11) {
        this(r8, r10);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator r8, int r10) {
        if (isUnsafeDirectSupported() == false) goto L6;
        return newUnsafeDirectInstance(r8, r10);
    L6:
        return newSafeDirectInstance(r8, r10);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator r8, int r10) {
        if (isUnsafeHeapSupported() == false) goto L6;
        return newUnsafeHeapInstance(r8, r10);
    L6:
        return newSafeHeapInstance(r8, r10);
    }

    private void writeBoolList_Internal(int r8, List<Boolean> r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace(r10.size() + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeBool(r10.get(r13).booleanValue());
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeBool(r8, r10.get(r14).booleanValue());
        r14 = r14 - 1;
        goto L8
    }

    private void writeDoubleList_Internal(int r8, List<Double> r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 8) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeFixed64(Double.doubleToRawLongBits(r10.get(r13).doubleValue()));
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeDouble(r8, r10.get(r14).doubleValue());
        r14 = r14 - 1;
        goto L8
    }

    private void writeFixed32List_Internal(int r8, List<Integer> r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 4) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeFixed32(r10.get(r13).intValue());
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeFixed32(r8, r10.get(r14).intValue());
        r14 = r14 - 1;
        goto L8
    }

    private void writeFixed64List_Internal(int r8, List<Long> r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 8) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeFixed64(r10.get(r13).longValue());
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeFixed64(r8, r10.get(r14).longValue());
        r14 = r14 - 1;
        goto L8
    }

    private void writeFloatList_Internal(int r8, List<Float> r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 4) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeFixed32(Float.floatToRawIntBits(r10.get(r13).floatValue()));
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeFloat(r8, r10.get(r14).floatValue());
        r14 = r14 - 1;
        goto L8
    }

    private void writeInt32List_Internal(int r8, List<Integer> r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 10) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeInt32(r10.get(r13).intValue());
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeInt32(r8, r10.get(r14).intValue());
        r14 = r14 - 1;
        goto L8
    }

    private void writeSInt32List_Internal(int r8, List<Integer> r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 5) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeSInt32(r10.get(r13).intValue());
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeSInt32(r8, r10.get(r14).intValue());
        r14 = r14 - 1;
        goto L8
    }

    private void writeSInt64List_Internal(int r8, List<Long> r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 10) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeSInt64(r10.get(r13).longValue());
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeSInt64(r8, r10.get(r14).longValue());
        r14 = r14 - 1;
        goto L8
    }

    private void writeUInt32List_Internal(int r8, List<Integer> r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 5) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeVarint32(r10.get(r13).intValue());
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeUInt32(r8, r10.get(r14).intValue());
        r14 = r14 - 1;
        goto L8
    }

    private void writeUInt64List_Internal(int r8, List<Long> r10, boolean r11) {
        if (r11 == false) goto L7;
        requireSpace((r10.size() * 10) + 10);
        int r12 = getTotalBytesWritten();
        int r13 = r10.size() - 1;
    L4:
        if (r13 < 0) goto L6;
        writeVarint64(r10.get(r13).longValue());
        r13 = r13 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r12);
        writeTag(r8, 2);
        return;
    L7:
        int r14 = r10.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeUInt64(r8, r10.get(r14).longValue());
        r14 = r14 - 1;
        goto L8
    }

    public final AllocatedBuffer newDirectBuffer(int r8) {
        return this.alloc.allocateDirectBuffer(Math.max(r8, this.chunkSize));
    }

    public final AllocatedBuffer newHeapBuffer(int r8) {
        return this.alloc.allocateHeapBuffer(Math.max(r8, this.chunkSize));
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int r8, List<?> r10, Schema r11) {
        int r12 = r10.size() - 1;
    L3:
        if (r12 < 0) goto L5;
        writeGroup(r8, r10.get(r12), r11);
        r12 = r12 - 1;
        goto L3
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageList(int r8, List<?> r10, Schema r11) {
        int r12 = r10.size() - 1;
    L3:
        if (r12 < 0) goto L5;
        writeMessage(r8, r10.get(r12), r11);
        r12 = r12 - 1;
        goto L3
    }
}
