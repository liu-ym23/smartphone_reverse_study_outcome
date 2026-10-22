package com.google.protobuf;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
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
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r10 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r10;
            r10[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
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

    private static final class SafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private int limitMinusOne;
        private int pos;

        SafeDirectWriter(BufferAllocator r10, int r11) {
            super(r10, r11, null);
            nextBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private void nextBuffer(int r10) {
            nextBuffer(newDirectBuffer(r10));
        }

        private void nextBuffer(AllocatedBuffer r10) {
            if (r10.hasNioBuffer() == false) goto L11;
            ByteBuffer r11 = r10.nioBuffer();
            if (r11.isDirect() == false) goto L9;
            finishCurrentBuffer();
            this.buffers.addFirst(r10);
            this.buffer = r11;
            Java8Compatibility.limit(r11, r11.capacity());
            Java8Compatibility.position(this.buffer, 0);
            this.buffer.order(ByteOrder.LITTLE_ENDIAN);
            int r12 = this.buffer.limit() - 1;
            this.limitMinusOne = r12;
            this.pos = r12;
            return;
        L9:
            throw new RuntimeException("Allocator returned non-direct buffer");
        L11:
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        private void writeVarint32FiveBytes(int r10) {
            ByteBuffer r11 = this.buffer;
            int r12 = this.pos;
            this.pos = r12 - 1;
            r11.put(r12, (byte) (r10 >>> 28));
            int r13 = this.pos - 4;
            this.pos = r13;
            this.buffer.putInt(r13 + 1, ((r10 & 127) | 128) | ((((((r10 >>> 21) & 127) | 128) << 24) | ((((r10 >>> 14) & 127) | 128) << 16)) | ((((r10 >>> 7) & 127) | 128) << 8)));
        }

        private void writeVarint32FourBytes(int r10) {
            int r11 = this.pos - 4;
            this.pos = r11;
            this.buffer.putInt(r11 + 1, ((r10 & 127) | 128) | ((((266338304 & r10) << 3) | (((2080768 & r10) | 2097152) << 2)) | (((r10 & 16256) | 16384) << 1)));
        }

        private void writeVarint32OneByte(int r10) {
            ByteBuffer r11 = this.buffer;
            int r12 = this.pos;
            this.pos = r12 - 1;
            r11.put(r12, (byte) r10);
        }

        private void writeVarint32ThreeBytes(int r10) {
            int r11 = this.pos - 3;
            this.pos = r11;
            this.buffer.putInt(r11, (((r10 & 127) | 128) << 8) | (((2080768 & r10) << 10) | (((r10 & 16256) | 16384) << 9)));
        }

        private void writeVarint32TwoBytes(int r10) {
            int r11 = this.pos - 2;
            this.pos = r11;
            this.buffer.putShort(r11 + 1, (short) (((r10 & 127) | 128) | ((r10 & 16256) << 1)));
        }

        private void writeVarint64EightBytes(long r10) {
            int r11 = this.pos - 8;
            this.pos = r11;
            this.buffer.putLong(r11 + 1, ((r10 & 127) | 128) | ((((((((71494644084506624L & r10) << 7) | (((558551906910208L & r10) | 562949953421312L) << 6)) | (((4363686772736L & r10) | 4398046511104L) << 5)) | (((34091302912L & r10) | 34359738368L) << 4)) | (((266338304 & r10) | 268435456) << 3)) | (((2080768 & r10) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2)) | (((16256 & r10) | PlaybackStateCompat.ACTION_PREPARE) << 1)));
        }

        private void writeVarint64EightBytesWithSign(long r10) {
            int r11 = this.pos - 8;
            this.pos = r11;
            this.buffer.putLong(r11 + 1, ((r10 & 127) | 128) | (((((((((71494644084506624L & r10) | 72057594037927936L) << 7) | (((558551906910208L & r10) | 562949953421312L) << 6)) | (((4363686772736L & r10) | 4398046511104L) << 5)) | (((34091302912L & r10) | 34359738368L) << 4)) | (((266338304 & r10) | 268435456) << 3)) | (((2080768 & r10) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2)) | (((16256 & r10) | PlaybackStateCompat.ACTION_PREPARE) << 1)));
        }

        private void writeVarint64FiveBytes(long r10) {
            int r11 = this.pos - 5;
            this.pos = r11;
            this.buffer.putLong(r11 - 2, (((r10 & 127) | 128) << 24) | (((((34091302912L & r10) << 28) | (((266338304 & r10) | 268435456) << 27)) | (((2080768 & r10) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 26)) | (((16256 & r10) | PlaybackStateCompat.ACTION_PREPARE) << 25)));
        }

        private void writeVarint64FourBytes(long r10) {
            writeVarint32FourBytes((int) r10);
        }

        private void writeVarint64NineBytes(long r10) {
            ByteBuffer r11 = this.buffer;
            int r12 = this.pos;
            this.pos = r12 - 1;
            r11.put(r12, (byte) (r10 >>> 56));
            writeVarint64EightBytesWithSign(r10 & 72057594037927935L);
        }

        private void writeVarint64OneByte(long r10) {
            writeVarint32OneByte((int) r10);
        }

        private void writeVarint64SevenBytes(long r10) {
            int r11 = this.pos - 7;
            this.pos = r11;
            this.buffer.putLong(r11, (((r10 & 127) | 128) << 8) | (((((((558551906910208L & r10) << 14) | (((4363686772736L & r10) | 4398046511104L) << 13)) | (((34091302912L & r10) | 34359738368L) << 12)) | (((266338304 & r10) | 268435456) << 11)) | (((2080768 & r10) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 10)) | (((16256 & r10) | PlaybackStateCompat.ACTION_PREPARE) << 9)));
        }

        private void writeVarint64SixBytes(long r10) {
            int r11 = this.pos - 6;
            this.pos = r11;
            this.buffer.putLong(r11 - 1, (((r10 & 127) | 128) << 16) | ((((((4363686772736L & r10) << 21) | (((34091302912L & r10) | 34359738368L) << 20)) | (((266338304 & r10) | 268435456) << 19)) | (((2080768 & r10) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 18)) | (((16256 & r10) | PlaybackStateCompat.ACTION_PREPARE) << 17)));
        }

        private void writeVarint64TenBytes(long r10) {
            ByteBuffer r11 = this.buffer;
            int r12 = this.pos;
            this.pos = r12 - 1;
            r11.put(r12, (byte) (r10 >>> 63));
            ByteBuffer r13 = this.buffer;
            int r14 = this.pos;
            this.pos = r14 - 1;
            r13.put(r14, (byte) (((r10 >>> 56) & 127) | 128));
            writeVarint64EightBytesWithSign(r10 & 72057594037927935L);
        }

        private void writeVarint64ThreeBytes(long r10) {
            writeVarint32ThreeBytes((int) r10);
        }

        private void writeVarint64TwoBytes(long r10) {
            writeVarint32TwoBytes((int) r10);
        }

        @Override // com.google.protobuf.BinaryWriter
        void finishCurrentBuffer() {
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
        void requireSpace(int r10) {
            if (spaceLeft() >= r10) goto L6;
            nextBuffer(r10);
            return;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte r10) {
            ByteBuffer r11 = this.buffer;
            int r12 = this.pos;
            this.pos = r12 - 1;
            r11.put(r12, r10);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer r10) {
            int r11 = r10.remaining();
            if (spaceLeft() >= r11) goto L5;
            nextBuffer(r11);
        L5:
            int r12 = this.pos - r11;
            this.pos = r12;
            Java8Compatibility.position(this.buffer, r12 + 1);
            this.buffer.put(r10);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] r10, int r11, int r12) {
            if (spaceLeft() >= r12) goto L5;
            nextBuffer(r12);
        L5:
            int r13 = this.pos - r12;
            this.pos = r13;
            Java8Compatibility.position(this.buffer, r13 + 1);
            this.buffer.put(r10, r11, r12);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int r10, boolean r11) {
            requireSpace(6);
            write(r11 ? 1 : 0);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeBool(boolean r10) {
            write(r10 ? 1 : 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int r10, ByteString r11) {
            r11.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(r11.size());
            writeTag(r10, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int r10) {
            writeTag(r10, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed32(int r10) {
            int r11 = this.pos - 4;
            this.pos = r11;
            this.buffer.putInt(r11 + 1, r10);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int r10, int r11) {
            requireSpace(9);
            writeFixed32(r11);
            writeTag(r10, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int r10, long r11) {
            requireSpace(13);
            writeFixed64(r11);
            writeTag(r10, 1);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed64(long r10) {
            int r11 = this.pos - 8;
            this.pos = r11;
            this.buffer.putLong(r11 + 1, r10);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeGroup(int r10, Object r11) {
            writeTag(r10, 4);
            Protobuf.getInstance().writeTo(r11, this);
            writeTag(r10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r10, Object r11, Schema r12) {
            writeTag(r10, 4);
            r12.writeTo(r11, this);
            writeTag(r10, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeInt32(int r10) {
            if (r10 < 0) goto L4;
            writeVarint32(r10);
            return;
        L4:
            writeVarint64(r10);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int r10, int r11) {
            requireSpace(15);
            writeInt32(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r10) {
            int r11 = r10.remaining();
            if (spaceLeft() >= r11) goto L6;
            this.totalDoneBytes += r11;
            this.buffers.addFirst(AllocatedBuffer.wrap(r10));
            nextBuffer();
            return;
        L6:
            int r12 = this.pos - r11;
            this.pos = r12;
            Java8Compatibility.position(this.buffer, r12 + 1);
            this.buffer.put(r10);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r10, int r11, int r12) {
            if (spaceLeft() >= r12) goto L6;
            this.totalDoneBytes += r12;
            this.buffers.addFirst(AllocatedBuffer.wrap(r10, r11, r12));
            nextBuffer();
            return;
        L6:
            int r13 = this.pos - r12;
            this.pos = r13;
            Java8Compatibility.position(this.buffer, r13 + 1);
            this.buffer.put(r10, r11, r12);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r10, Object r11) {
            int r12 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(r11, this);
            int r13 = getTotalBytesWritten() - r12;
            requireSpace(10);
            writeVarint32(r13);
            writeTag(r10, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r10, Object r11, Schema r12) {
            int r13 = getTotalBytesWritten();
            r12.writeTo(r11, this);
            int r14 = getTotalBytesWritten() - r13;
            requireSpace(10);
            writeVarint32(r14);
            writeTag(r10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt32(int r10) {
            writeVarint32(CodedOutputStream.encodeZigZag32(r10));
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int r10, int r11) {
            requireSpace(10);
            writeSInt32(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int r10, long r11) {
            requireSpace(15);
            writeSInt64(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt64(long r10) {
            writeVarint64(CodedOutputStream.encodeZigZag64(r10));
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int r10) {
            writeTag(r10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int r10, String r11) {
            int r12 = getTotalBytesWritten();
            writeString(r11);
            int r13 = getTotalBytesWritten() - r12;
            requireSpace(10);
            writeVarint32(r13);
            writeTag(r10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeString(String r10) {
            requireSpace(r10.length());
            int r11 = r10.length() - 1;
            this.pos -= r11;
        L4:
            if (r11 < 0) goto L9;
            char r12 = r10.charAt(r11);
            if (r12 >= 128) goto L9;
            this.buffer.put(this.pos + r11, (byte) r12);
            r11 = r11 - 1;
        L9:
            if (r11 != (-1)) goto L12;
            this.pos--;
            return;
        L12:
            this.pos += r11;
        L13:
            if (r11 < 0) goto L42;
            char r13 = r10.charAt(r11);
            if (r13 >= 128) goto L20;
            int r14 = this.pos;
            if (r14 < 0) goto L20;
            ByteBuffer r15 = this.buffer;
            this.pos = r14 - 1;
            r15.put(r14, (byte) r13);
        L41:
            r11 = r11 - 1;
        L20:
            if (r13 >= 2048) goto L25;
            int r16 = this.pos;
            if (r16 <= 0) goto L25;
            ByteBuffer r17 = this.buffer;
            this.pos = r16 - 1;
            r17.put(r16, (byte) ((r13 & '?') | 128));
            ByteBuffer r18 = this.buffer;
            int r19 = this.pos;
            this.pos = r19 - 1;
            int r20 = (r13 >>> 6) | 960;
        L37:
            r18.put(r19, (byte) r20);
        L25:
            if (r13 >= 55296) goto L27;
        L28:
            int r21 = this.pos;
            if (r21 <= 1) goto L32;
            ByteBuffer r22 = this.buffer;
            this.pos = r21 - 1;
            r22.put(r21, (byte) ((r13 & '?') | 128));
            ByteBuffer r23 = this.buffer;
            int r24 = this.pos;
            this.pos = r24 - 1;
            r23.put(r24, (byte) (((r13 >>> 6) & 63) | 128));
            r18 = this.buffer;
            r19 = this.pos;
            this.pos = r19 - 1;
            r20 = (r13 >>> '\f') | 480;
        L32:
            if (this.pos <= 2) goto L40;
            if (r11 == 0) goto L39;
            char r25 = r10.charAt(r11 - 1);
            if (Character.isSurrogatePair(r25, r13) == false) goto L39;
            r11 = r11 - 1;
            int r26 = Character.toCodePoint(r25, r13);
            ByteBuffer r27 = this.buffer;
            int r28 = this.pos;
            this.pos = r28 - 1;
            r27.put(r28, (byte) ((r26 & 63) | 128));
            ByteBuffer r29 = this.buffer;
            int r30 = this.pos;
            this.pos = r30 - 1;
            r29.put(r30, (byte) (((r26 >>> 6) & 63) | 128));
            ByteBuffer r31 = this.buffer;
            int r32 = this.pos;
            this.pos = r32 - 1;
            r31.put(r32, (byte) (((r26 >>> 12) & 63) | 128));
            r18 = this.buffer;
            r19 = this.pos;
            this.pos = r19 - 1;
            r20 = (r26 >>> 18) | 240;
        L39:
            throw new Utf8.UnpairedSurrogateException(r11 - 1, r11);
        L40:
            requireSpace(r11);
            r11 = r11 + 1;
            goto L41
        L27:
            if (57343 >= r13) goto L32;
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int r10, int r11) {
            writeVarint32(WireFormat.makeTag(r10, r11));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int r10, int r11) {
            requireSpace(10);
            writeVarint32(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int r10, long r11) {
            requireSpace(15);
            writeVarint64(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint32(int r10) {
            if ((r10 & (-128)) != 0) goto L6;
            writeVarint32OneByte(r10);
            return;
        L6:
            if ((r10 & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(r10);
            return;
        L9:
            if (((-2097152) & r10) != 0) goto L12;
            writeVarint32ThreeBytes(r10);
            return;
        L12:
            if (((-268435456) & r10) != 0) goto L14;
            writeVarint32FourBytes(r10);
            return;
        L14:
            writeVarint32FiveBytes(r10);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint64(long r10) {
            switch(BinaryWriter.access$200(r10)) {
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
            writeVarint64TenBytes(r10);
            return;
        L6:
            writeVarint64NineBytes(r10);
            return;
        L7:
            writeVarint64EightBytes(r10);
            return;
        L8:
            writeVarint64SevenBytes(r10);
            return;
        L9:
            writeVarint64SixBytes(r10);
            return;
        L10:
            writeVarint64FiveBytes(r10);
            return;
        L11:
            writeVarint64FourBytes(r10);
            return;
        L12:
            writeVarint64ThreeBytes(r10);
            return;
        L13:
            writeVarint64TwoBytes(r10);
            return;
        L14:
            writeVarint64OneByte(r10);
            return;
        }
    }

    private static final class SafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private int limit;
        private int limitMinusOne;
        private int offset;
        private int offsetMinusOne;
        private int pos;

        SafeHeapWriter(BufferAllocator r10, int r11) {
            super(r10, r11, null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int r10) {
            nextBuffer(newHeapBuffer(r10));
        }

        private void nextBuffer(AllocatedBuffer r10) {
            if (r10.hasArray() == false) goto L7;
            finishCurrentBuffer();
            this.buffers.addFirst(r10);
            this.allocatedBuffer = r10;
            this.buffer = r10.array();
            int r11 = r10.arrayOffset();
            this.limit = r10.limit() + r11;
            int r12 = r11 + r10.position();
            this.offset = r12;
            this.offsetMinusOne = r12 - 1;
            int r13 = this.limit - 1;
            this.limitMinusOne = r13;
            this.pos = r13;
            return;
        L7:
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        private void writeVarint32FiveBytes(int r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >>> 28);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (((r10 >>> 21) & 127) | 128);
            int r15 = r14 - 1;
            this.pos = r15;
            r11[r14] = (byte) (((r10 >>> 14) & 127) | 128);
            int r16 = r15 - 1;
            this.pos = r16;
            r11[r15] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r16 - 1;
            r11[r16] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint32FourBytes(int r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >>> 21);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (((r10 >>> 14) & 127) | 128);
            int r15 = r14 - 1;
            this.pos = r15;
            r11[r14] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r15 - 1;
            r11[r15] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint32OneByte(int r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            this.pos = r12 - 1;
            r11[r12] = (byte) r10;
        }

        private void writeVarint32ThreeBytes(int r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >>> 14);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r14 - 1;
            r11[r14] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint32TwoBytes(int r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >>> 7);
            this.pos = r13 - 1;
            r11[r13] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64EightBytes(long r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >>> 49);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (((r10 >>> 42) & 127) | 128);
            int r15 = r14 - 1;
            this.pos = r15;
            r11[r14] = (byte) (((r10 >>> 35) & 127) | 128);
            int r16 = r15 - 1;
            this.pos = r16;
            r11[r15] = (byte) (((r10 >>> 28) & 127) | 128);
            int r17 = r16 - 1;
            this.pos = r17;
            r11[r16] = (byte) (((r10 >>> 21) & 127) | 128);
            int r18 = r17 - 1;
            this.pos = r18;
            r11[r17] = (byte) (((r10 >>> 14) & 127) | 128);
            int r19 = r18 - 1;
            this.pos = r19;
            r11[r18] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r19 - 1;
            r11[r19] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64FiveBytes(long r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >>> 28);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (((r10 >>> 21) & 127) | 128);
            int r15 = r14 - 1;
            this.pos = r15;
            r11[r14] = (byte) (((r10 >>> 14) & 127) | 128);
            int r16 = r15 - 1;
            this.pos = r16;
            r11[r15] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r16 - 1;
            r11[r16] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64FourBytes(long r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >>> 21);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (((r10 >>> 14) & 127) | 128);
            int r15 = r14 - 1;
            this.pos = r15;
            r11[r14] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r15 - 1;
            r11[r15] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64NineBytes(long r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >>> 56);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (((r10 >>> 49) & 127) | 128);
            int r15 = r14 - 1;
            this.pos = r15;
            r11[r14] = (byte) (((r10 >>> 42) & 127) | 128);
            int r16 = r15 - 1;
            this.pos = r16;
            r11[r15] = (byte) (((r10 >>> 35) & 127) | 128);
            int r17 = r16 - 1;
            this.pos = r17;
            r11[r16] = (byte) (((r10 >>> 28) & 127) | 128);
            int r18 = r17 - 1;
            this.pos = r18;
            r11[r17] = (byte) (((r10 >>> 21) & 127) | 128);
            int r19 = r18 - 1;
            this.pos = r19;
            r11[r18] = (byte) (((r10 >>> 14) & 127) | 128);
            int r20 = r19 - 1;
            this.pos = r20;
            r11[r19] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r20 - 1;
            r11[r20] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64OneByte(long r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            this.pos = r12 - 1;
            r11[r12] = (byte) r10;
        }

        private void writeVarint64SevenBytes(long r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >>> 42);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (((r10 >>> 35) & 127) | 128);
            int r15 = r14 - 1;
            this.pos = r15;
            r11[r14] = (byte) (((r10 >>> 28) & 127) | 128);
            int r16 = r15 - 1;
            this.pos = r16;
            r11[r15] = (byte) (((r10 >>> 21) & 127) | 128);
            int r17 = r16 - 1;
            this.pos = r17;
            r11[r16] = (byte) (((r10 >>> 14) & 127) | 128);
            int r18 = r17 - 1;
            this.pos = r18;
            r11[r17] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r18 - 1;
            r11[r18] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64SixBytes(long r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >>> 35);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (((r10 >>> 28) & 127) | 128);
            int r15 = r14 - 1;
            this.pos = r15;
            r11[r14] = (byte) (((r10 >>> 21) & 127) | 128);
            int r16 = r15 - 1;
            this.pos = r16;
            r11[r15] = (byte) (((r10 >>> 14) & 127) | 128);
            int r17 = r16 - 1;
            this.pos = r17;
            r11[r16] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r17 - 1;
            r11[r17] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64TenBytes(long r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >>> 63);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (((r10 >>> 56) & 127) | 128);
            int r15 = r14 - 1;
            this.pos = r15;
            r11[r14] = (byte) (((r10 >>> 49) & 127) | 128);
            int r16 = r15 - 1;
            this.pos = r16;
            r11[r15] = (byte) (((r10 >>> 42) & 127) | 128);
            int r17 = r16 - 1;
            this.pos = r17;
            r11[r16] = (byte) (((r10 >>> 35) & 127) | 128);
            int r18 = r17 - 1;
            this.pos = r18;
            r11[r17] = (byte) (((r10 >>> 28) & 127) | 128);
            int r19 = r18 - 1;
            this.pos = r19;
            r11[r18] = (byte) (((r10 >>> 21) & 127) | 128);
            int r20 = r19 - 1;
            this.pos = r20;
            r11[r19] = (byte) (((r10 >>> 14) & 127) | 128);
            int r21 = r20 - 1;
            this.pos = r21;
            r11[r20] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r21 - 1;
            r11[r21] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64ThreeBytes(long r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (((int) r10) >>> 14);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r14 - 1;
            r11[r14] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64TwoBytes(long r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >>> 7);
            this.pos = r13 - 1;
            r11[r13] = (byte) ((((int) r10) & 127) | 128);
        }

        int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        @Override // com.google.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.allocatedBuffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            AllocatedBuffer r10 = this.allocatedBuffer;
            r10.position((this.pos - r10.arrayOffset()) + 1);
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
        void requireSpace(int r10) {
            if (spaceLeft() >= r10) goto L6;
            nextBuffer(r10);
            return;
        }

        int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            this.pos = r12 - 1;
            r11[r12] = r10;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer r10) {
            int r11 = r10.remaining();
            if (spaceLeft() >= r11) goto L5;
            nextBuffer(r11);
        L5:
            int r12 = this.pos - r11;
            this.pos = r12;
            r10.get(this.buffer, r12 + 1, r11);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] r10, int r11, int r12) {
            if (spaceLeft() >= r12) goto L5;
            nextBuffer(r12);
        L5:
            int r13 = this.pos - r12;
            this.pos = r13;
            System.arraycopy(r10, r11, this.buffer, r13 + 1, r12);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int r10, boolean r11) {
            requireSpace(6);
            write(r11 ? 1 : 0);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeBool(boolean r10) {
            write(r10 ? 1 : 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int r10, ByteString r11) {
            r11.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(r11.size());
            writeTag(r10, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int r10) {
            writeTag(r10, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed32(int r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >> 24);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (r10 >> 16);
            int r15 = r14 - 1;
            this.pos = r15;
            r11[r14] = (byte) (r10 >> 8);
            this.pos = r15 - 1;
            r11[r15] = (byte) r10;
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int r10, int r11) {
            requireSpace(9);
            writeFixed32(r11);
            writeTag(r10, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int r10, long r11) {
            requireSpace(13);
            writeFixed64(r11);
            writeTag(r10, 1);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed64(long r10) {
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (r10 >> 56);
            int r14 = r13 - 1;
            this.pos = r14;
            r11[r13] = (byte) (r10 >> 48);
            int r15 = r14 - 1;
            this.pos = r15;
            r11[r14] = (byte) (r10 >> 40);
            int r16 = r15 - 1;
            this.pos = r16;
            r11[r15] = (byte) (r10 >> 32);
            int r17 = r16 - 1;
            this.pos = r17;
            r11[r16] = (byte) (r10 >> 24);
            int r18 = r17 - 1;
            this.pos = r18;
            r11[r17] = (byte) (r10 >> 16);
            int r19 = r18 - 1;
            this.pos = r19;
            r11[r18] = (byte) (r10 >> 8);
            this.pos = r19 - 1;
            r11[r19] = (byte) r10;
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeGroup(int r10, Object r11) {
            writeTag(r10, 4);
            Protobuf.getInstance().writeTo(r11, this);
            writeTag(r10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r10, Object r11, Schema r12) {
            writeTag(r10, 4);
            r12.writeTo(r11, this);
            writeTag(r10, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeInt32(int r10) {
            if (r10 < 0) goto L4;
            writeVarint32(r10);
            return;
        L4:
            writeVarint64(r10);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int r10, int r11) {
            requireSpace(15);
            writeInt32(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r10) {
            int r11 = r10.remaining();
            if (spaceLeft() >= r11) goto L5;
            this.totalDoneBytes += r11;
            this.buffers.addFirst(AllocatedBuffer.wrap(r10));
            nextBuffer();
        L5:
            int r12 = this.pos - r11;
            this.pos = r12;
            r10.get(this.buffer, r12 + 1, r11);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r10, int r11, int r12) {
            if (spaceLeft() >= r12) goto L6;
            this.totalDoneBytes += r12;
            this.buffers.addFirst(AllocatedBuffer.wrap(r10, r11, r12));
            nextBuffer();
            return;
        L6:
            int r13 = this.pos - r12;
            this.pos = r13;
            System.arraycopy(r10, r11, this.buffer, r13 + 1, r12);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r10, Object r11) {
            int r12 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(r11, this);
            int r13 = getTotalBytesWritten() - r12;
            requireSpace(10);
            writeVarint32(r13);
            writeTag(r10, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r10, Object r11, Schema r12) {
            int r13 = getTotalBytesWritten();
            r12.writeTo(r11, this);
            int r14 = getTotalBytesWritten() - r13;
            requireSpace(10);
            writeVarint32(r14);
            writeTag(r10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt32(int r10) {
            writeVarint32(CodedOutputStream.encodeZigZag32(r10));
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int r10, int r11) {
            requireSpace(10);
            writeSInt32(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int r10, long r11) {
            requireSpace(15);
            writeSInt64(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt64(long r10) {
            writeVarint64(CodedOutputStream.encodeZigZag64(r10));
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int r10) {
            writeTag(r10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int r10, String r11) {
            int r12 = getTotalBytesWritten();
            writeString(r11);
            int r13 = getTotalBytesWritten() - r12;
            requireSpace(10);
            writeVarint32(r13);
            writeTag(r10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeString(String r10) {
            requireSpace(r10.length());
            int r11 = r10.length() - 1;
            this.pos -= r11;
        L4:
            if (r11 < 0) goto L9;
            char r12 = r10.charAt(r11);
            if (r12 >= 128) goto L9;
            this.buffer[this.pos + r11] = (byte) r12;
            r11 = r11 - 1;
        L9:
            if (r11 != (-1)) goto L12;
            this.pos--;
            return;
        L12:
            this.pos += r11;
        L13:
            if (r11 < 0) goto L41;
            char r13 = r10.charAt(r11);
            if (r13 >= 128) goto L20;
            int r14 = this.pos;
            if (r14 <= this.offsetMinusOne) goto L20;
            byte[] r15 = this.buffer;
            this.pos = r14 - 1;
            r15[r14] = (byte) r13;
        L40:
            r11 = r11 - 1;
        L20:
            if (r13 >= 2048) goto L25;
            int r16 = this.pos;
            if (r16 <= this.offset) goto L25;
            byte[] r17 = this.buffer;
            int r18 = r16 - 1;
            this.pos = r18;
            r17[r16] = (byte) ((r13 & '?') | 128);
            this.pos = r18 - 1;
            r17[r18] = (byte) ((r13 >>> 6) | 960);
        L25:
            if (r13 >= 55296) goto L27;
        L28:
            int r19 = this.pos;
            if (r19 <= (this.offset + 1)) goto L32;
            byte[] r20 = this.buffer;
            int r21 = r19 - 1;
            this.pos = r21;
            r20[r19] = (byte) ((r13 & '?') | 128);
            int r22 = r21 - 1;
            this.pos = r22;
            r20[r21] = (byte) (((r13 >>> 6) & 63) | 128);
            this.pos = r22 - 1;
            r20[r22] = (byte) ((r13 >>> '\f') | 480);
        L32:
            if (this.pos <= (this.offset + 2)) goto L39;
            if (r11 == 0) goto L38;
            char r23 = r10.charAt(r11 - 1);
            if (Character.isSurrogatePair(r23, r13) == false) goto L38;
            r11 = r11 - 1;
            int r24 = Character.toCodePoint(r23, r13);
            byte[] r25 = this.buffer;
            int r26 = this.pos;
            int r27 = r26 - 1;
            this.pos = r27;
            r25[r26] = (byte) ((r24 & 63) | 128);
            int r28 = r27 - 1;
            this.pos = r28;
            r25[r27] = (byte) (((r24 >>> 6) & 63) | 128);
            int r29 = r28 - 1;
            this.pos = r29;
            r25[r28] = (byte) (((r24 >>> 12) & 63) | 128);
            this.pos = r29 - 1;
            r25[r29] = (byte) ((r24 >>> 18) | 240);
        L38:
            throw new Utf8.UnpairedSurrogateException(r11 - 1, r11);
        L39:
            requireSpace(r11);
            r11 = r11 + 1;
            goto L40
        L27:
            if (57343 >= r13) goto L32;
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int r10, int r11) {
            writeVarint32(WireFormat.makeTag(r10, r11));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int r10, int r11) {
            requireSpace(10);
            writeVarint32(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int r10, long r11) {
            requireSpace(15);
            writeVarint64(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint32(int r10) {
            if ((r10 & (-128)) != 0) goto L6;
            writeVarint32OneByte(r10);
            return;
        L6:
            if ((r10 & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(r10);
            return;
        L9:
            if (((-2097152) & r10) != 0) goto L12;
            writeVarint32ThreeBytes(r10);
            return;
        L12:
            if (((-268435456) & r10) != 0) goto L14;
            writeVarint32FourBytes(r10);
            return;
        L14:
            writeVarint32FiveBytes(r10);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint64(long r10) {
            switch(BinaryWriter.access$200(r10)) {
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
            writeVarint64TenBytes(r10);
            return;
        L6:
            writeVarint64NineBytes(r10);
            return;
        L7:
            writeVarint64EightBytes(r10);
            return;
        L8:
            writeVarint64SevenBytes(r10);
            return;
        L9:
            writeVarint64SixBytes(r10);
            return;
        L10:
            writeVarint64FiveBytes(r10);
            return;
        L11:
            writeVarint64FourBytes(r10);
            return;
        L12:
            writeVarint64ThreeBytes(r10);
            return;
        L13:
            writeVarint64TwoBytes(r10);
            return;
        L14:
            writeVarint64OneByte(r10);
            return;
        }
    }

    private static final class UnsafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private long bufferOffset;
        private long limitMinusOne;
        private long pos;

        UnsafeDirectWriter(BufferAllocator r10, int r11) {
            super(r10, r11, null);
            nextBuffer();
        }

        static /* synthetic */ boolean access$000() {
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

        private void nextBuffer(int r10) {
            nextBuffer(newDirectBuffer(r10));
        }

        private void nextBuffer(AllocatedBuffer r10) {
            if (r10.hasNioBuffer() == false) goto L11;
            ByteBuffer r11 = r10.nioBuffer();
            if (r11.isDirect() == false) goto L9;
            finishCurrentBuffer();
            this.buffers.addFirst(r10);
            this.buffer = r11;
            Java8Compatibility.limit(r11, r11.capacity());
            Java8Compatibility.position(this.buffer, 0);
            long r12 = UnsafeUtil.addressOffset(this.buffer);
            this.bufferOffset = r12;
            long r13 = r12 + ((long) (this.buffer.limit() - 1));
            this.limitMinusOne = r13;
            this.pos = r13;
            return;
        L9:
            throw new RuntimeException("Allocator returned non-direct buffer");
        L11:
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        private void writeVarint32FiveBytes(int r10) {
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (r10 >>> 28));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r10 >>> 21) & 127) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (((r10 >>> 14) & 127) | 128));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) (((r10 >>> 7) & 127) | 128));
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r15, (byte) ((r10 & 127) | 128));
        }

        private void writeVarint32FourBytes(int r10) {
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (r10 >>> 21));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r10 >>> 14) & 127) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (((r10 >>> 7) & 127) | 128));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) ((r10 & 127) | 128));
        }

        private void writeVarint32OneByte(int r10) {
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) r10);
        }

        private void writeVarint32ThreeBytes(int r10) {
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (r10 >>> 14));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r10 >>> 7) & 127) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) ((r10 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int r10) {
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (r10 >>> 7));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) ((r10 & 127) | 128));
        }

        private void writeVarint64EightBytes(long r11) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r11 >>> 49));
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

        private void writeVarint64FiveBytes(long r11) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r11 >>> 28));
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

        private void writeVarint64FourBytes(long r11) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r11 >>> 21));
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

        private void writeVarint64NineBytes(long r11) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r11 >>> 56));
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

        private void writeVarint64OneByte(long r10) {
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) r10);
        }

        private void writeVarint64SevenBytes(long r11) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r11 >>> 42));
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

        private void writeVarint64SixBytes(long r11) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r11 >>> 35));
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

        private void writeVarint64TenBytes(long r11) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (r11 >>> 63));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r11 >>> 56) & 127) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (((r11 >>> 49) & 127) | 128));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) (((r11 >>> 42) & 127) | 128));
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r15, (byte) (((r11 >>> 35) & 127) | 128));
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r16, (byte) (((r11 >>> 28) & 127) | 128));
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r17, (byte) (((r11 >>> 21) & 127) | 128));
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r18, (byte) (((r11 >>> 14) & 127) | 128));
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r19, (byte) (((r11 >>> 7) & 127) | 128));
            long r20 = this.pos;
            this.pos = r20 - 1;
            UnsafeUtil.putByte(r20, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long r11) {
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) (((int) r11) >>> 14));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (((r11 >>> 7) & 127) | 128));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64TwoBytes(long r10) {
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (r10 >>> 7));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) ((((int) r10) & 127) | 128));
        }

        @Override // com.google.protobuf.BinaryWriter
        void finishCurrentBuffer() {
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
        void requireSpace(int r10) {
            if (spaceLeft() >= r10) goto L6;
            nextBuffer(r10);
            return;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte r10) {
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, r10);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer r10) {
            int r11 = r10.remaining();
            if (spaceLeft() >= r11) goto L5;
            nextBuffer(r11);
        L5:
            this.pos -= (long) r11;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(r10);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] r10, int r11, int r12) {
            if (spaceLeft() >= r12) goto L5;
            nextBuffer(r12);
        L5:
            this.pos -= (long) r12;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(r10, r11, r12);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int r10, boolean r11) {
            requireSpace(6);
            write(r11 ? 1 : 0);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeBool(boolean r10) {
            write(r10 ? 1 : 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int r10, ByteString r11) {
            r11.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(r11.size());
            writeTag(r10, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int r10) {
            writeTag(r10, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed32(int r10) {
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (r10 >> 24));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (r10 >> 16));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (r10 >> 8));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) r10);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int r10, int r11) {
            requireSpace(9);
            writeFixed32(r11);
            writeTag(r10, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int r10, long r11) {
            requireSpace(13);
            writeFixed64(r11);
            writeTag(r10, 1);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed64(long r10) {
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (r10 >> 56));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) (r10 >> 48));
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r13, (byte) (r10 >> 40));
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r14, (byte) (r10 >> 32));
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r15, (byte) (r10 >> 24));
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r16, (byte) (r10 >> 16));
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r17, (byte) (r10 >> 8));
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r18, (byte) r10);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r10, Object r11) {
            writeTag(r10, 4);
            Protobuf.getInstance().writeTo(r11, this);
            writeTag(r10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r10, Object r11, Schema r12) {
            writeTag(r10, 4);
            r12.writeTo(r11, this);
            writeTag(r10, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeInt32(int r10) {
            if (r10 < 0) goto L4;
            writeVarint32(r10);
            return;
        L4:
            writeVarint64(r10);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int r10, int r11) {
            requireSpace(15);
            writeInt32(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r10) {
            int r11 = r10.remaining();
            if (spaceLeft() >= r11) goto L6;
            this.totalDoneBytes += r11;
            this.buffers.addFirst(AllocatedBuffer.wrap(r10));
            nextBuffer();
            return;
        L6:
            this.pos -= (long) r11;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(r10);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r10, int r11, int r12) {
            if (spaceLeft() >= r12) goto L6;
            this.totalDoneBytes += r12;
            this.buffers.addFirst(AllocatedBuffer.wrap(r10, r11, r12));
            nextBuffer();
            return;
        L6:
            this.pos -= (long) r12;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(r10, r11, r12);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r10, Object r11) {
            int r12 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(r11, this);
            int r13 = getTotalBytesWritten() - r12;
            requireSpace(10);
            writeVarint32(r13);
            writeTag(r10, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r10, Object r11, Schema r12) {
            int r13 = getTotalBytesWritten();
            r12.writeTo(r11, this);
            int r14 = getTotalBytesWritten() - r13;
            requireSpace(10);
            writeVarint32(r14);
            writeTag(r10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt32(int r10) {
            writeVarint32(CodedOutputStream.encodeZigZag32(r10));
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int r10, int r11) {
            requireSpace(10);
            writeSInt32(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int r10, long r11) {
            requireSpace(15);
            writeSInt64(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt64(long r10) {
            writeVarint64(CodedOutputStream.encodeZigZag64(r10));
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int r10) {
            writeTag(r10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int r10, String r11) {
            int r12 = getTotalBytesWritten();
            writeString(r11);
            int r13 = getTotalBytesWritten() - r12;
            requireSpace(10);
            writeVarint32(r13);
            writeTag(r10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeString(String r13) {
            requireSpace(r13.length());
            int r10 = r13.length();
        L3:
            r10 = r10 - 1;
            if (r10 < 0) goto L9;
            char r11 = r13.charAt(r10);
            if (r11 >= 128) goto L9;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) r11);
        L9:
            if (r10 != (-1)) goto L11;
            return;
        L11:
            if (r10 < 0) goto L40;
            char r14 = r13.charAt(r10);
            if (r14 >= 128) goto L18;
            long r15 = this.pos;
            if (r15 < this.bufferOffset) goto L18;
            this.pos = r15 - 1;
            int r16 = r14;
        L35:
            UnsafeUtil.putByte(r15, (byte) r16);
        L39:
            r10 = r10 - 1;
        L18:
            if (r14 >= 2048) goto L23;
            long r17 = this.pos;
            if (r17 <= this.bufferOffset) goto L23;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r17, (byte) ((r14 & '?') | 128));
            r15 = this.pos;
            this.pos = r15 - 1;
            r16 = (r14 >>> 6) | 960;
        L23:
            if (r14 >= 55296) goto L25;
        L26:
            long r18 = this.pos;
            if (r18 <= (this.bufferOffset + 1)) goto L30;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r18, (byte) ((r14 & '?') | 128));
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r19, (byte) (((r14 >>> 6) & 63) | 128));
            r15 = this.pos;
            this.pos = r15 - 1;
            r16 = (r14 >>> '\f') | 480;
        L30:
            if (this.pos <= (this.bufferOffset + 2)) goto L38;
            if (r10 == 0) goto L37;
            char r20 = r13.charAt(r10 - 1);
            if (Character.isSurrogatePair(r20, r14) == false) goto L37;
            r10 = r10 - 1;
            int r21 = Character.toCodePoint(r20, r14);
            long r22 = this.pos;
            this.pos = r22 - 1;
            UnsafeUtil.putByte(r22, (byte) ((r21 & 63) | 128));
            long r23 = this.pos;
            this.pos = r23 - 1;
            UnsafeUtil.putByte(r23, (byte) (((r21 >>> 6) & 63) | 128));
            long r24 = this.pos;
            this.pos = r24 - 1;
            UnsafeUtil.putByte(r24, (byte) (((r21 >>> 12) & 63) | 128));
            r15 = this.pos;
            this.pos = r15 - 1;
            r16 = (r21 >>> 18) | 240;
        L37:
            throw new Utf8.UnpairedSurrogateException(r10 - 1, r10);
        L38:
            requireSpace(r10);
            r10 = r10 + 1;
            goto L39
        L25:
            if (57343 >= r14) goto L30;
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int r10, int r11) {
            writeVarint32(WireFormat.makeTag(r10, r11));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int r10, int r11) {
            requireSpace(10);
            writeVarint32(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int r10, long r11) {
            requireSpace(15);
            writeVarint64(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint32(int r10) {
            if ((r10 & (-128)) != 0) goto L6;
            writeVarint32OneByte(r10);
            return;
        L6:
            if ((r10 & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(r10);
            return;
        L9:
            if (((-2097152) & r10) != 0) goto L12;
            writeVarint32ThreeBytes(r10);
            return;
        L12:
            if (((-268435456) & r10) != 0) goto L14;
            writeVarint32FourBytes(r10);
            return;
        L14:
            writeVarint32FiveBytes(r10);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint64(long r10) {
            switch(BinaryWriter.access$200(r10)) {
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
            writeVarint64TenBytes(r10);
            return;
        L6:
            writeVarint64NineBytes(r10);
            return;
        L7:
            writeVarint64EightBytes(r10);
            return;
        L8:
            writeVarint64SevenBytes(r10);
            return;
        L9:
            writeVarint64SixBytes(r10);
            return;
        L10:
            writeVarint64FiveBytes(r10);
            return;
        L11:
            writeVarint64FourBytes(r10);
            return;
        L12:
            writeVarint64ThreeBytes(r10);
            return;
        L13:
            writeVarint64TwoBytes(r10);
            return;
        L14:
            writeVarint64OneByte(r10);
            return;
        }
    }

    private static final class UnsafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private long limit;
        private long limitMinusOne;
        private long offset;
        private long offsetMinusOne;
        private long pos;

        UnsafeHeapWriter(BufferAllocator r10, int r11) {
            super(r10, r11, null);
            nextBuffer();
        }

        private int arrayPos() {
            return (int) this.pos;
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int r10) {
            nextBuffer(newHeapBuffer(r10));
        }

        private void nextBuffer(AllocatedBuffer r10) {
            if (r10.hasArray() == false) goto L7;
            finishCurrentBuffer();
            this.buffers.addFirst(r10);
            this.allocatedBuffer = r10;
            this.buffer = r10.array();
            long r11 = r10.arrayOffset();
            this.limit = ((long) r10.limit()) + r11;
            long r12 = r11 + ((long) r10.position());
            this.offset = r12;
            this.offsetMinusOne = r12 - 1;
            long r13 = this.limit - 1;
            this.limitMinusOne = r13;
            this.pos = r13;
            return;
        L7:
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        private void writeVarint32FiveBytes(int r10) {
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) (r10 >>> 28));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (((r10 >>> 21) & 127) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (((r10 >>> 14) & 127) | 128));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) (((r10 >>> 7) & 127) | 128));
            byte[] r19 = this.buffer;
            long r20 = this.pos;
            this.pos = r20 - 1;
            UnsafeUtil.putByte(r19, r20, (byte) ((r10 & 127) | 128));
        }

        private void writeVarint32FourBytes(int r10) {
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) (r10 >>> 21));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (((r10 >>> 14) & 127) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (((r10 >>> 7) & 127) | 128));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) ((r10 & 127) | 128));
        }

        private void writeVarint32OneByte(int r10) {
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) r10);
        }

        private void writeVarint32ThreeBytes(int r10) {
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) (r10 >>> 14));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (((r10 >>> 7) & 127) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) ((r10 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int r10) {
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) (r10 >>> 7));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) ((r10 & 127) | 128));
        }

        private void writeVarint64EightBytes(long r12) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r12 >>> 49));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (((r12 >>> 42) & 127) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (((r12 >>> 35) & 127) | 128));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r19 = this.buffer;
            long r20 = this.pos;
            this.pos = r20 - 1;
            UnsafeUtil.putByte(r19, r20, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r21 = this.buffer;
            long r22 = this.pos;
            this.pos = r22 - 1;
            UnsafeUtil.putByte(r21, r22, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r23 = this.buffer;
            long r24 = this.pos;
            this.pos = r24 - 1;
            UnsafeUtil.putByte(r23, r24, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r25 = this.buffer;
            long r26 = this.pos;
            this.pos = r26 - 1;
            UnsafeUtil.putByte(r25, r26, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long r12) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r12 >>> 28));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r19 = this.buffer;
            long r20 = this.pos;
            this.pos = r20 - 1;
            UnsafeUtil.putByte(r19, r20, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64FourBytes(long r12) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r12 >>> 21));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64NineBytes(long r12) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r12 >>> 56));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (((r12 >>> 49) & 127) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (((r12 >>> 42) & 127) | 128));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) (((r12 >>> 35) & 127) | 128));
            byte[] r19 = this.buffer;
            long r20 = this.pos;
            this.pos = r20 - 1;
            UnsafeUtil.putByte(r19, r20, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r21 = this.buffer;
            long r22 = this.pos;
            this.pos = r22 - 1;
            UnsafeUtil.putByte(r21, r22, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r23 = this.buffer;
            long r24 = this.pos;
            this.pos = r24 - 1;
            UnsafeUtil.putByte(r23, r24, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r25 = this.buffer;
            long r26 = this.pos;
            this.pos = r26 - 1;
            UnsafeUtil.putByte(r25, r26, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r27 = this.buffer;
            long r28 = this.pos;
            this.pos = r28 - 1;
            UnsafeUtil.putByte(r27, r28, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64OneByte(long r10) {
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) r10);
        }

        private void writeVarint64SevenBytes(long r12) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r12 >>> 42));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (((r12 >>> 35) & 127) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r19 = this.buffer;
            long r20 = this.pos;
            this.pos = r20 - 1;
            UnsafeUtil.putByte(r19, r20, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r21 = this.buffer;
            long r22 = this.pos;
            this.pos = r22 - 1;
            UnsafeUtil.putByte(r21, r22, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r23 = this.buffer;
            long r24 = this.pos;
            this.pos = r24 - 1;
            UnsafeUtil.putByte(r23, r24, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64SixBytes(long r12) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r12 >>> 35));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r19 = this.buffer;
            long r20 = this.pos;
            this.pos = r20 - 1;
            UnsafeUtil.putByte(r19, r20, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r21 = this.buffer;
            long r22 = this.pos;
            this.pos = r22 - 1;
            UnsafeUtil.putByte(r21, r22, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64TenBytes(long r12) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (r12 >>> 63));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (((r12 >>> 56) & 127) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (((r12 >>> 49) & 127) | 128));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) (((r12 >>> 42) & 127) | 128));
            byte[] r19 = this.buffer;
            long r20 = this.pos;
            this.pos = r20 - 1;
            UnsafeUtil.putByte(r19, r20, (byte) (((r12 >>> 35) & 127) | 128));
            byte[] r21 = this.buffer;
            long r22 = this.pos;
            this.pos = r22 - 1;
            UnsafeUtil.putByte(r21, r22, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r23 = this.buffer;
            long r24 = this.pos;
            this.pos = r24 - 1;
            UnsafeUtil.putByte(r23, r24, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r25 = this.buffer;
            long r26 = this.pos;
            this.pos = r26 - 1;
            UnsafeUtil.putByte(r25, r26, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r27 = this.buffer;
            long r28 = this.pos;
            this.pos = r28 - 1;
            UnsafeUtil.putByte(r27, r28, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r29 = this.buffer;
            long r30 = this.pos;
            this.pos = r30 - 1;
            UnsafeUtil.putByte(r29, r30, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long r12) {
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((int) r12) >>> 14));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64TwoBytes(long r10) {
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) (r10 >>> 7));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) ((((int) r10) & 127) | 128));
        }

        int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        @Override // com.google.protobuf.BinaryWriter
        void finishCurrentBuffer() {
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
        void requireSpace(int r10) {
            if (spaceLeft() >= r10) goto L6;
            nextBuffer(r10);
            return;
        }

        int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte r10) {
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, r10);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer r10) {
            int r11 = r10.remaining();
            requireSpace(r11);
            this.pos -= (long) r11;
            r10.get(this.buffer, arrayPos() + 1, r11);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] r10, int r11, int r12) {
            if (r11 < 0) goto L9;
            if ((r11 + r12) > r10.length) goto L9;
            requireSpace(r12);
            this.pos -= (long) r12;
            System.arraycopy(r10, r11, this.buffer, arrayPos() + 1, r12);
            return;
        L9:
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r10.length), Integer.valueOf(r11), Integer.valueOf(r12)}));
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int r10, boolean r11) {
            requireSpace(6);
            write(r11 ? 1 : 0);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeBool(boolean r10) {
            write(r10 ? 1 : 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int r10, ByteString r11) {
            r11.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(r11.size());
            writeTag(r10, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int r10) {
            writeTag(r10, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed32(int r10) {
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) (r10 >> 24));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (r10 >> 16));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (r10 >> 8));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) r10);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int r10, int r11) {
            requireSpace(9);
            writeFixed32(r11);
            writeTag(r10, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int r10, long r11) {
            requireSpace(13);
            writeFixed64(r11);
            writeTag(r10, 1);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed64(long r10) {
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) (r10 >> 56));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (r10 >> 48));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (r10 >> 40));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) (r10 >> 32));
            byte[] r19 = this.buffer;
            long r20 = this.pos;
            this.pos = r20 - 1;
            UnsafeUtil.putByte(r19, r20, (byte) (r10 >> 24));
            byte[] r21 = this.buffer;
            long r22 = this.pos;
            this.pos = r22 - 1;
            UnsafeUtil.putByte(r21, r22, (byte) (r10 >> 16));
            byte[] r23 = this.buffer;
            long r24 = this.pos;
            this.pos = r24 - 1;
            UnsafeUtil.putByte(r23, r24, (byte) (r10 >> 8));
            byte[] r25 = this.buffer;
            long r26 = this.pos;
            this.pos = r26 - 1;
            UnsafeUtil.putByte(r25, r26, (byte) r10);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r10, Object r11) {
            writeTag(r10, 4);
            Protobuf.getInstance().writeTo(r11, this);
            writeTag(r10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r10, Object r11, Schema r12) {
            writeTag(r10, 4);
            r12.writeTo(r11, this);
            writeTag(r10, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeInt32(int r10) {
            if (r10 < 0) goto L4;
            writeVarint32(r10);
            return;
        L4:
            writeVarint64(r10);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int r10, int r11) {
            requireSpace(15);
            writeInt32(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r10) {
            int r11 = r10.remaining();
            if (spaceLeft() >= r11) goto L5;
            this.totalDoneBytes += r11;
            this.buffers.addFirst(AllocatedBuffer.wrap(r10));
            nextBuffer();
        L5:
            this.pos -= (long) r11;
            r10.get(this.buffer, arrayPos() + 1, r11);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r10, int r11, int r12) {
            if (r11 < 0) goto L13;
            if ((r11 + r12) > r10.length) goto L13;
            if (spaceLeft() >= r12) goto L10;
            this.totalDoneBytes += r12;
            this.buffers.addFirst(AllocatedBuffer.wrap(r10, r11, r12));
            nextBuffer();
            return;
        L10:
            this.pos -= (long) r12;
            System.arraycopy(r10, r11, this.buffer, arrayPos() + 1, r12);
            return;
        L13:
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r10.length), Integer.valueOf(r11), Integer.valueOf(r12)}));
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r10, Object r11) {
            int r12 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(r11, this);
            int r13 = getTotalBytesWritten() - r12;
            requireSpace(10);
            writeVarint32(r13);
            writeTag(r10, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r10, Object r11, Schema r12) {
            int r13 = getTotalBytesWritten();
            r12.writeTo(r11, this);
            int r14 = getTotalBytesWritten() - r13;
            requireSpace(10);
            writeVarint32(r14);
            writeTag(r10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt32(int r10) {
            writeVarint32(CodedOutputStream.encodeZigZag32(r10));
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int r10, int r11) {
            requireSpace(10);
            writeSInt32(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int r10, long r11) {
            requireSpace(15);
            writeSInt64(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt64(long r10) {
            writeVarint64(CodedOutputStream.encodeZigZag64(r10));
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int r10) {
            writeTag(r10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int r10, String r11) {
            int r12 = getTotalBytesWritten();
            writeString(r11);
            int r13 = getTotalBytesWritten() - r12;
            requireSpace(10);
            writeVarint32(r13);
            writeTag(r10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeString(String r13) {
            requireSpace(r13.length());
            int r10 = r13.length();
        L3:
            r10 = r10 - 1;
            if (r10 < 0) goto L9;
            char r11 = r13.charAt(r10);
            if (r11 >= 128) goto L9;
            byte[] r12 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r12, r14, (byte) r11);
        L9:
            if (r10 != (-1)) goto L11;
            return;
        L11:
            if (r10 < 0) goto L39;
            char r15 = r13.charAt(r10);
            if (r15 >= 128) goto L18;
            long r16 = this.pos;
            if (r16 <= this.offsetMinusOne) goto L18;
            byte[] r17 = this.buffer;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r17, r16, (byte) r15);
        L38:
            r10 = r10 - 1;
        L18:
            if (r15 >= 2048) goto L23;
            long r18 = this.pos;
            if (r18 <= this.offset) goto L23;
            byte[] r19 = this.buffer;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r19, r18, (byte) ((r15 & '?') | 128));
            byte[] r20 = this.buffer;
            long r21 = this.pos;
            this.pos = r21 - 1;
            UnsafeUtil.putByte(r20, r21, (byte) ((r15 >>> 6) | 960));
        L23:
            if (r15 >= 55296) goto L25;
        L26:
            long r22 = this.pos;
            if (r22 <= (this.offset + 1)) goto L30;
            byte[] r23 = this.buffer;
            this.pos = r22 - 1;
            UnsafeUtil.putByte(r23, r22, (byte) ((r15 & '?') | 128));
            byte[] r24 = this.buffer;
            long r25 = this.pos;
            this.pos = r25 - 1;
            UnsafeUtil.putByte(r24, r25, (byte) (((r15 >>> 6) & 63) | 128));
            byte[] r26 = this.buffer;
            long r27 = this.pos;
            this.pos = r27 - 1;
            UnsafeUtil.putByte(r26, r27, (byte) ((r15 >>> '\f') | 480));
        L30:
            if (this.pos <= (this.offset + 2)) goto L37;
            if (r10 == 0) goto L36;
            char r28 = r13.charAt(r10 - 1);
            if (Character.isSurrogatePair(r28, r15) == false) goto L36;
            r10 = r10 - 1;
            int r29 = Character.toCodePoint(r28, r15);
            byte[] r30 = this.buffer;
            long r31 = this.pos;
            this.pos = r31 - 1;
            UnsafeUtil.putByte(r30, r31, (byte) ((r29 & 63) | 128));
            byte[] r32 = this.buffer;
            long r33 = this.pos;
            this.pos = r33 - 1;
            UnsafeUtil.putByte(r32, r33, (byte) (((r29 >>> 6) & 63) | 128));
            byte[] r34 = this.buffer;
            long r35 = this.pos;
            this.pos = r35 - 1;
            UnsafeUtil.putByte(r34, r35, (byte) (((r29 >>> 12) & 63) | 128));
            byte[] r36 = this.buffer;
            long r37 = this.pos;
            this.pos = r37 - 1;
            UnsafeUtil.putByte(r36, r37, (byte) ((r29 >>> 18) | 240));
        L36:
            throw new Utf8.UnpairedSurrogateException(r10 - 1, r10);
        L37:
            requireSpace(r10);
            r10 = r10 + 1;
            goto L38
        L25:
            if (57343 >= r15) goto L30;
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int r10, int r11) {
            writeVarint32(WireFormat.makeTag(r10, r11));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int r10, int r11) {
            requireSpace(10);
            writeVarint32(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int r10, long r11) {
            requireSpace(15);
            writeVarint64(r11);
            writeTag(r10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint32(int r10) {
            if ((r10 & (-128)) != 0) goto L6;
            writeVarint32OneByte(r10);
            return;
        L6:
            if ((r10 & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(r10);
            return;
        L9:
            if (((-2097152) & r10) != 0) goto L12;
            writeVarint32ThreeBytes(r10);
            return;
        L12:
            if (((-268435456) & r10) != 0) goto L14;
            writeVarint32FourBytes(r10);
            return;
        L14:
            writeVarint32FiveBytes(r10);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint64(long r10) {
            switch(BinaryWriter.access$200(r10)) {
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
            writeVarint64TenBytes(r10);
            return;
        L6:
            writeVarint64NineBytes(r10);
            return;
        L7:
            writeVarint64EightBytes(r10);
            return;
        L8:
            writeVarint64SevenBytes(r10);
            return;
        L9:
            writeVarint64SixBytes(r10);
            return;
        L10:
            writeVarint64FiveBytes(r10);
            return;
        L11:
            writeVarint64FourBytes(r10);
            return;
        L12:
            writeVarint64ThreeBytes(r10);
            return;
        L13:
            writeVarint64TwoBytes(r10);
            return;
        L14:
            writeVarint64OneByte(r10);
            return;
        }
    }

    private BinaryWriter(BufferAllocator r10, int r11) {
        this.buffers = new ArrayDeque(4);
        if (r11 <= 0) goto L7;
        this.alloc = (BufferAllocator) Internal.checkNotNull(r10, "alloc");
        this.chunkSize = r11;
        return;
    L7:
        throw new IllegalArgumentException("chunkSize must be > 0");
    }

    /* synthetic */ BinaryWriter(BufferAllocator r10, int r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    static /* synthetic */ byte access$200(long r10) {
        return computeUInt64SizeNoTag(r10);
    }

    private static byte computeUInt64SizeNoTag(long r10) {
        if (((-128) & r10) != 0) goto L7;
        return 1;
    L7:
        if (r10 >= 0) goto L11;
        return 10;
    L11:
        if (((-34359738368L) & r10) == 0) goto L13;
        byte r11 = (byte) 6;
        r10 = r10 >>> 28;
    L15:
        if (((-2097152) & r10) == 0) goto L18;
        r11 = (byte) (r11 + 2);
        r10 = r10 >>> 14;
    L18:
        if ((r10 & (-16384)) != 0) goto L20;
        return r11;
    L20:
        return (byte) (r11 + 1);
    L13:
        r11 = 2;
        goto L15
    }

    static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.access$000();
    }

    static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    public static BinaryWriter newDirectInstance(BufferAllocator r10) {
        return newDirectInstance(r10, 4096);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator r10, int r11) {
        if (isUnsafeDirectSupported() == false) goto L6;
        return newUnsafeDirectInstance(r10, r11);
    L6:
        return newSafeDirectInstance(r10, r11);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator r10) {
        return newHeapInstance(r10, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator r10, int r11) {
        if (isUnsafeHeapSupported() == false) goto L6;
        return newUnsafeHeapInstance(r10, r11);
    L6:
        return newSafeHeapInstance(r10, r11);
    }

    static BinaryWriter newSafeDirectInstance(BufferAllocator r10, int r11) {
        return new SafeDirectWriter(r10, r11);
    }

    static BinaryWriter newSafeHeapInstance(BufferAllocator r10, int r11) {
        return new SafeHeapWriter(r10, r11);
    }

    static BinaryWriter newUnsafeDirectInstance(BufferAllocator r10, int r11) {
        if (isUnsafeDirectSupported() == false) goto L7;
        return new UnsafeDirectWriter(r10, r11);
    L7:
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    static BinaryWriter newUnsafeHeapInstance(BufferAllocator r10, int r11) {
        if (isUnsafeHeapSupported() == false) goto L7;
        return new UnsafeHeapWriter(r10, r11);
    L7:
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private void writeBoolList_Internal(int r10, BooleanArrayList r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace(r11.size() + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeBool(r11.getBoolean(r14));
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeBool(r10, r11.getBoolean(r15));
        r15 = r15 - 1;
        goto L8
    }

    private void writeBoolList_Internal(int r10, List<Boolean> r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace(r11.size() + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeBool(r11.get(r14).booleanValue());
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeBool(r10, r11.get(r15).booleanValue());
        r15 = r15 - 1;
        goto L8
    }

    private void writeDoubleList_Internal(int r10, DoubleArrayList r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 8) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeFixed64(Double.doubleToRawLongBits(r11.getDouble(r14)));
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeDouble(r10, r11.getDouble(r15));
        r15 = r15 - 1;
        goto L8
    }

    private void writeDoubleList_Internal(int r10, List<Double> r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 8) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeFixed64(Double.doubleToRawLongBits(r11.get(r14).doubleValue()));
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeDouble(r10, r11.get(r15).doubleValue());
        r15 = r15 - 1;
        goto L8
    }

    private void writeFixed32List_Internal(int r10, IntArrayList r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 4) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeFixed32(r11.getInt(r14));
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeFixed32(r10, r11.getInt(r15));
        r15 = r15 - 1;
        goto L8
    }

    private void writeFixed32List_Internal(int r10, List<Integer> r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 4) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeFixed32(r11.get(r14).intValue());
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeFixed32(r10, r11.get(r15).intValue());
        r15 = r15 - 1;
        goto L8
    }

    private void writeFixed64List_Internal(int r10, LongArrayList r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 8) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeFixed64(r11.getLong(r14));
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeFixed64(r10, r11.getLong(r15));
        r15 = r15 - 1;
        goto L8
    }

    private void writeFixed64List_Internal(int r10, List<Long> r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 8) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeFixed64(r11.get(r14).longValue());
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeFixed64(r10, r11.get(r15).longValue());
        r15 = r15 - 1;
        goto L8
    }

    private void writeFloatList_Internal(int r10, FloatArrayList r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 4) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeFixed32(Float.floatToRawIntBits(r11.getFloat(r14)));
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeFloat(r10, r11.getFloat(r15));
        r15 = r15 - 1;
        goto L8
    }

    private void writeFloatList_Internal(int r10, List<Float> r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 4) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeFixed32(Float.floatToRawIntBits(r11.get(r14).floatValue()));
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeFloat(r10, r11.get(r15).floatValue());
        r15 = r15 - 1;
        goto L8
    }

    private void writeInt32List_Internal(int r10, IntArrayList r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 10) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeInt32(r11.getInt(r14));
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeInt32(r10, r11.getInt(r15));
        r15 = r15 - 1;
        goto L8
    }

    private void writeInt32List_Internal(int r10, List<Integer> r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 10) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeInt32(r11.get(r14).intValue());
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeInt32(r10, r11.get(r15).intValue());
        r15 = r15 - 1;
        goto L8
    }

    private void writeLazyString(int r10, Object r11) {
        if ((r11 instanceof String) == false) goto L5;
        writeString(r10, (String) r11);
        return;
    L5:
        writeBytes(r10, (ByteString) r11);
    }

    static final void writeMapEntryField(Writer r10, int r11, WireFormat.FieldType r12, Object r13) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r12.ordinal()]) {
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
        r10.writeBytes(r11, (ByteString) r13);
        return;
    L16:
        r10.writeMessage(r11, r13);
        return;
    L17:
        r10.writeDouble(r11, ((Double) r13).doubleValue());
        return;
    L18:
        r10.writeFloat(r11, ((Float) r13).floatValue());
        return;
    L19:
        r10.writeUInt64(r11, ((Long) r13).longValue());
        return;
    L20:
        r10.writeUInt32(r11, ((Integer) r13).intValue());
        return;
    L21:
        r10.writeString(r11, (String) r13);
        return;
    L22:
        r10.writeSInt64(r11, ((Long) r13).longValue());
        return;
    L23:
        r10.writeSInt32(r11, ((Integer) r13).intValue());
        return;
    L24:
        r10.writeSFixed64(r11, ((Long) r13).longValue());
        return;
    L25:
        r10.writeSFixed32(r11, ((Integer) r13).intValue());
        return;
    L26:
        r10.writeInt64(r11, ((Long) r13).longValue());
        return;
    L27:
        r10.writeInt32(r11, ((Integer) r13).intValue());
        return;
    L28:
        r10.writeFixed64(r11, ((Long) r13).longValue());
        return;
    L29:
        r10.writeFixed32(r11, ((Integer) r13).intValue());
        return;
    L30:
        r10.writeBool(r11, ((Boolean) r13).booleanValue());
        return;
    L5:
        throw new IllegalArgumentException("Unsupported map value type for: " + r12);
    L7:
        if ((r13 instanceof Internal.EnumLite) == false) goto L11;
        int r14 = ((Internal.EnumLite) r13).getNumber();
    L9:
        r10.writeEnum(r11, r14);
        return;
    L11:
        if ((r13 instanceof Integer) == false) goto L14;
        r14 = ((Integer) r13).intValue();
        goto L9
    L14:
        throw new IllegalArgumentException("Unexpected type for enum in map.");
    }

    private void writeSInt32List_Internal(int r10, IntArrayList r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 5) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeSInt32(r11.getInt(r14));
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeSInt32(r10, r11.getInt(r15));
        r15 = r15 - 1;
        goto L8
    }

    private void writeSInt32List_Internal(int r10, List<Integer> r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 5) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeSInt32(r11.get(r14).intValue());
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeSInt32(r10, r11.get(r15).intValue());
        r15 = r15 - 1;
        goto L8
    }

    private void writeSInt64List_Internal(int r10, LongArrayList r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 10) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeSInt64(r11.getLong(r14));
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeSInt64(r10, r11.getLong(r15));
        r15 = r15 - 1;
        goto L8
    }

    private void writeSInt64List_Internal(int r10, List<Long> r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 10) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeSInt64(r11.get(r14).longValue());
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeSInt64(r10, r11.get(r15).longValue());
        r15 = r15 - 1;
        goto L8
    }

    private void writeUInt32List_Internal(int r10, IntArrayList r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 5) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeVarint32(r11.getInt(r14));
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeUInt32(r10, r11.getInt(r15));
        r15 = r15 - 1;
        goto L8
    }

    private void writeUInt32List_Internal(int r10, List<Integer> r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 5) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeVarint32(r11.get(r14).intValue());
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeUInt32(r10, r11.get(r15).intValue());
        r15 = r15 - 1;
        goto L8
    }

    private void writeUInt64List_Internal(int r10, LongArrayList r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 10) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeVarint64(r11.getLong(r14));
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeUInt64(r10, r11.getLong(r15));
        r15 = r15 - 1;
        goto L8
    }

    private void writeUInt64List_Internal(int r10, List<Long> r11, boolean r12) {
        if (r12 == false) goto L7;
        requireSpace((r11.size() * 10) + 10);
        int r13 = getTotalBytesWritten();
        int r14 = r11.size() - 1;
    L4:
        if (r14 < 0) goto L6;
        writeVarint64(r11.get(r14).longValue());
        r14 = r14 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r13);
        writeTag(r10, 2);
        return;
    L7:
        int r15 = r11.size() - 1;
    L8:
        if (r15 < 0) goto L13;
        writeUInt64(r10, r11.get(r15).longValue());
        r15 = r15 - 1;
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

    abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    final AllocatedBuffer newDirectBuffer() {
        return this.alloc.allocateDirectBuffer(this.chunkSize);
    }

    final AllocatedBuffer newDirectBuffer(int r10) {
        return this.alloc.allocateDirectBuffer(Math.max(r10, this.chunkSize));
    }

    final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    final AllocatedBuffer newHeapBuffer(int r10) {
        return this.alloc.allocateHeapBuffer(Math.max(r10, this.chunkSize));
    }

    abstract void requireSpace(int r10);

    abstract void writeBool(boolean r10);

    @Override // com.google.protobuf.Writer
    public final void writeBoolList(int r10, List<Boolean> r11, boolean r12) {
        if ((r11 instanceof BooleanArrayList) == false) goto L5;
        writeBoolList_Internal(r10, (BooleanArrayList) r11, r12);
        return;
    L5:
        writeBoolList_Internal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public final void writeBytesList(int r10, List<ByteString> r11) {
        int r12 = r11.size() - 1;
    L3:
        if (r12 < 0) goto L5;
        writeBytes(r10, r11.get(r12));
        r12 = r12 - 1;
        goto L3
    }

    @Override // com.google.protobuf.Writer
    public final void writeDouble(int r10, double r11) {
        writeFixed64(r10, Double.doubleToRawLongBits(r11));
    }

    @Override // com.google.protobuf.Writer
    public final void writeDoubleList(int r10, List<Double> r11, boolean r12) {
        if ((r11 instanceof DoubleArrayList) == false) goto L5;
        writeDoubleList_Internal(r10, (DoubleArrayList) r11, r12);
        return;
    L5:
        writeDoubleList_Internal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public final void writeEnum(int r10, int r11) {
        writeInt32(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public final void writeEnumList(int r10, List<Integer> r11, boolean r12) {
        writeInt32List(r10, r11, r12);
    }

    abstract void writeFixed32(int r10);

    @Override // com.google.protobuf.Writer
    public final void writeFixed32List(int r10, List<Integer> r11, boolean r12) {
        if ((r11 instanceof IntArrayList) == false) goto L5;
        writeFixed32List_Internal(r10, (IntArrayList) r11, r12);
        return;
    L5:
        writeFixed32List_Internal(r10, r11, r12);
    }

    abstract void writeFixed64(long r10);

    @Override // com.google.protobuf.Writer
    public final void writeFixed64List(int r10, List<Long> r11, boolean r12) {
        if ((r11 instanceof LongArrayList) == false) goto L5;
        writeFixed64List_Internal(r10, (LongArrayList) r11, r12);
        return;
    L5:
        writeFixed64List_Internal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public final void writeFloat(int r10, float r11) {
        writeFixed32(r10, Float.floatToRawIntBits(r11));
    }

    @Override // com.google.protobuf.Writer
    public final void writeFloatList(int r10, List<Float> r11, boolean r12) {
        if ((r11 instanceof FloatArrayList) == false) goto L5;
        writeFloatList_Internal(r10, (FloatArrayList) r11, r12);
        return;
    L5:
        writeFloatList_Internal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int r10, List<?> r11) {
        int r12 = r11.size() - 1;
    L3:
        if (r12 < 0) goto L5;
        writeGroup(r10, r11.get(r12));
        r12 = r12 - 1;
        goto L3
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int r10, List<?> r11, Schema r12) {
        int r13 = r11.size() - 1;
    L3:
        if (r13 < 0) goto L5;
        writeGroup(r10, r11.get(r13), r12);
        r13 = r13 - 1;
        goto L3
    }

    abstract void writeInt32(int r10);

    @Override // com.google.protobuf.Writer
    public final void writeInt32List(int r10, List<Integer> r11, boolean r12) {
        if ((r11 instanceof IntArrayList) == false) goto L5;
        writeInt32List_Internal(r10, (IntArrayList) r11, r12);
        return;
    L5:
        writeInt32List_Internal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt64(int r10, long r11) {
        writeUInt64(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt64List(int r10, List<Long> r11, boolean r12) {
        writeUInt64List(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int r10, MapEntryLite.Metadata<K, V> r11, Map<K, V> r12) {
        Iterator<Map.Entry<K, V>> r13 = r12.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry<K, V> r14 = r13.next();
        int r15 = getTotalBytesWritten();
        writeMapEntryField(this, 2, r11.valueType, r14.getValue());
        writeMapEntryField(this, 1, r11.keyType, r14.getKey());
        writeVarint32(getTotalBytesWritten() - r15);
        writeTag(r10, 2);
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageList(int r10, List<?> r11) {
        int r12 = r11.size() - 1;
    L3:
        if (r12 < 0) goto L5;
        writeMessage(r10, r11.get(r12));
        r12 = r12 - 1;
        goto L3
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageList(int r10, List<?> r11, Schema r12) {
        int r13 = r11.size() - 1;
    L3:
        if (r13 < 0) goto L5;
        writeMessage(r10, r11.get(r13), r12);
        r13 = r13 - 1;
        goto L3
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int r10, Object r11) {
        writeTag(1, 4);
        if ((r11 instanceof ByteString) == false) goto L5;
        writeBytes(3, (ByteString) r11);
    L6:
        writeUInt32(2, r10);
        writeTag(1, 3);
        return;
    L5:
        writeMessage(3, r11);
        goto L6
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed32(int r10, int r11) {
        writeFixed32(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed32List(int r10, List<Integer> r11, boolean r12) {
        writeFixed32List(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed64(int r10, long r11) {
        writeFixed64(r10, r11);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed64List(int r10, List<Long> r11, boolean r12) {
        writeFixed64List(r10, r11, r12);
    }

    abstract void writeSInt32(int r10);

    @Override // com.google.protobuf.Writer
    public final void writeSInt32List(int r10, List<Integer> r11, boolean r12) {
        if ((r11 instanceof IntArrayList) == false) goto L5;
        writeSInt32List_Internal(r10, (IntArrayList) r11, r12);
        return;
    L5:
        writeSInt32List_Internal(r10, r11, r12);
    }

    abstract void writeSInt64(long r10);

    @Override // com.google.protobuf.Writer
    public final void writeSInt64List(int r10, List<Long> r11, boolean r12) {
        if ((r11 instanceof LongArrayList) == false) goto L5;
        writeSInt64List_Internal(r10, (LongArrayList) r11, r12);
        return;
    L5:
        writeSInt64List_Internal(r10, r11, r12);
    }

    abstract void writeString(String r10);

    @Override // com.google.protobuf.Writer
    public final void writeStringList(int r10, List<String> r11) {
        if ((r11 instanceof LazyStringList) == false) goto L7;
        LazyStringList r12 = (LazyStringList) r11;
        int r13 = r11.size() - 1;
    L5:
        if (r13 < 0) goto L10;
        writeLazyString(r10, r12.getRaw(r13));
        r13 = r13 - 1;
        goto L5
    L10:
        return;
    L7:
        int r14 = r11.size() - 1;
    L8:
        if (r14 < 0) goto L13;
        writeString(r10, r11.get(r14));
        r14 = r14 - 1;
        goto L8
    }

    abstract void writeTag(int r10, int r11);

    @Override // com.google.protobuf.Writer
    public final void writeUInt32List(int r10, List<Integer> r11, boolean r12) {
        if ((r11 instanceof IntArrayList) == false) goto L5;
        writeUInt32List_Internal(r10, (IntArrayList) r11, r12);
        return;
    L5:
        writeUInt32List_Internal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Writer
    public final void writeUInt64List(int r10, List<Long> r11, boolean r12) {
        if ((r11 instanceof LongArrayList) == false) goto L5;
        writeUInt64List_Internal(r10, (LongArrayList) r11, r12);
        return;
    L5:
        writeUInt64List_Internal(r10, r11, r12);
    }

    abstract void writeVarint32(int r10);

    abstract void writeVarint64(long r10);
}
