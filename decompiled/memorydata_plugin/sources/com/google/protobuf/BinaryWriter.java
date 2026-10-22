package com.google.protobuf;

import android.support.v4.media.session.PlaybackStateCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
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
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
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

        SafeDirectWriter(BufferAllocator r2, int r3) {
            super(r2, r3, null);
            nextBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private void nextBuffer(int r1) {
            nextBuffer(newDirectBuffer(r1));
        }

        private void nextBuffer(AllocatedBuffer r3) {
            if (r3.hasNioBuffer() == false) goto L11;
            ByteBuffer r0 = r3.nioBuffer();
            if (r0.isDirect() == false) goto L9;
            finishCurrentBuffer();
            this.buffers.addFirst(r3);
            this.buffer = r0;
            Java8Compatibility.limit(r0, r0.capacity());
            Java8Compatibility.position(this.buffer, 0);
            this.buffer.order(ByteOrder.LITTLE_ENDIAN);
            int r4 = this.buffer.limit() - 1;
            this.limitMinusOne = r4;
            this.pos = r4;
            return;
        L9:
            throw new RuntimeException("Allocator returned non-direct buffer");
        L11:
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        private void writeVarint32FiveBytes(int r4) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, (byte) (r4 >>> 28));
            int r2 = this.pos - 4;
            this.pos = r2;
            this.buffer.putInt(r2 + 1, ((r4 & 127) | 128) | ((((((r4 >>> 21) & 127) | 128) << 24) | ((((r4 >>> 14) & 127) | 128) << 16)) | ((((r4 >>> 7) & 127) | 128) << 8)));
        }

        private void writeVarint32FourBytes(int r5) {
            int r0 = this.pos - 4;
            this.pos = r0;
            this.buffer.putInt(r0 + 1, ((r5 & 127) | 128) | ((((266338304 & r5) << 3) | (((2080768 & r5) | 2097152) << 2)) | (((r5 & 16256) | 16384) << 1)));
        }

        private void writeVarint32OneByte(int r4) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, (byte) r4);
        }

        private void writeVarint32ThreeBytes(int r4) {
            int r0 = this.pos - 3;
            this.pos = r0;
            this.buffer.putInt(r0, (((r4 & 127) | 128) << 8) | (((2080768 & r4) << 10) | (((r4 & 16256) | 16384) << 9)));
        }

        private void writeVarint32TwoBytes(int r3) {
            int r0 = this.pos - 2;
            this.pos = r0;
            this.buffer.putShort(r0 + 1, (short) (((r3 & 127) | 128) | ((r3 & 16256) << 1)));
        }

        private void writeVarint64EightBytes(long r9) {
            int r0 = this.pos - 8;
            this.pos = r0;
            this.buffer.putLong(r0 + 1, ((r9 & 127) | 128) | ((((((((71494644084506624L & r9) << 7) | (((558551906910208L & r9) | 562949953421312L) << 6)) | (((4363686772736L & r9) | 4398046511104L) << 5)) | (((34091302912L & r9) | 34359738368L) << 4)) | (((266338304 & r9) | 268435456) << 3)) | (((2080768 & r9) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2)) | (((16256 & r9) | 16384) << 1)));
        }

        private void writeVarint64EightBytesWithSign(long r9) {
            int r0 = this.pos - 8;
            this.pos = r0;
            this.buffer.putLong(r0 + 1, ((r9 & 127) | 128) | (((((((((71494644084506624L & r9) | 72057594037927936L) << 7) | (((558551906910208L & r9) | 562949953421312L) << 6)) | (((4363686772736L & r9) | 4398046511104L) << 5)) | (((34091302912L & r9) | 34359738368L) << 4)) | (((266338304 & r9) | 268435456) << 3)) | (((2080768 & r9) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2)) | (((16256 & r9) | 16384) << 1)));
        }

        private void writeVarint64FiveBytes(long r8) {
            int r0 = this.pos - 5;
            this.pos = r0;
            this.buffer.putLong(r0 - 2, (((r8 & 127) | 128) << 24) | (((((34091302912L & r8) << 28) | (((266338304 & r8) | 268435456) << 27)) | (((2080768 & r8) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 26)) | (((16256 & r8) | 16384) << 25)));
        }

        private void writeVarint64FourBytes(long r1) {
            writeVarint32FourBytes((int) r1);
        }

        private void writeVarint64NineBytes(long r5) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, (byte) (r5 >>> 56));
            writeVarint64EightBytesWithSign(r5 & 72057594037927935L);
        }

        private void writeVarint64OneByte(long r1) {
            writeVarint32OneByte((int) r1);
        }

        private void writeVarint64SevenBytes(long r8) {
            int r0 = this.pos - 7;
            this.pos = r0;
            this.buffer.putLong(r0, (((r8 & 127) | 128) << 8) | (((((((558551906910208L & r8) << 14) | (((4363686772736L & r8) | 4398046511104L) << 13)) | (((34091302912L & r8) | 34359738368L) << 12)) | (((266338304 & r8) | 268435456) << 11)) | (((2080768 & r8) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 10)) | (((16256 & r8) | 16384) << 9)));
        }

        private void writeVarint64SixBytes(long r8) {
            int r0 = this.pos - 6;
            this.pos = r0;
            this.buffer.putLong(r0 - 1, (((r8 & 127) | 128) << 16) | ((((((4363686772736L & r8) << 21) | (((34091302912L & r8) | 34359738368L) << 20)) | (((266338304 & r8) | 268435456) << 19)) | (((2080768 & r8) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 18)) | (((16256 & r8) | 16384) << 17)));
        }

        private void writeVarint64TenBytes(long r7) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, (byte) (r7 >>> 63));
            ByteBuffer r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2.put(r3, (byte) (((r7 >>> 56) & 127) | 128));
            writeVarint64EightBytesWithSign(r7 & 72057594037927935L);
        }

        private void writeVarint64ThreeBytes(long r1) {
            writeVarint32ThreeBytes((int) r1);
        }

        private void writeVarint64TwoBytes(long r1) {
            writeVarint32TwoBytes((int) r1);
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
        void requireSpace(int r2) {
            if (spaceLeft() >= r2) goto L6;
            nextBuffer(r2);
            return;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte r4) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, r4);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer r3) {
            int r0 = r3.remaining();
            if (spaceLeft() >= r0) goto L5;
            nextBuffer(r0);
        L5:
            int r1 = this.pos - r0;
            this.pos = r1;
            Java8Compatibility.position(this.buffer, r1 + 1);
            this.buffer.put(r3);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] r3, int r4, int r5) {
            if (spaceLeft() >= r5) goto L5;
            nextBuffer(r5);
        L5:
            int r0 = this.pos - r5;
            this.pos = r0;
            Java8Compatibility.position(this.buffer, r0 + 1);
            this.buffer.put(r3, r4, r5);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int r2, boolean r3) {
            requireSpace(6);
            write(r3 ? 1 : 0);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeBool(boolean r1) {
            write(r1 ? 1 : 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int r2, ByteString r3) {
            r3.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(r3.size());
            writeTag(r2, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int r2) {
            writeTag(r2, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed32(int r2) {
            int r0 = this.pos - 4;
            this.pos = r0;
            this.buffer.putInt(r0 + 1, r2);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int r2, int r3) {
            requireSpace(9);
            writeFixed32(r3);
            writeTag(r2, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int r2, long r3) {
            requireSpace(13);
            writeFixed64(r3);
            writeTag(r2, 1);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed64(long r2) {
            int r0 = this.pos - 8;
            this.pos = r0;
            this.buffer.putLong(r0 + 1, r2);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeGroup(int r2, Object r3) {
            writeTag(r2, 4);
            Protobuf.getInstance().writeTo(r3, this);
            writeTag(r2, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r3, Object r4, Schema r5) {
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            writeTag(r3, 4);
            r6.writeTo(r4, this);
            writeTag(r3, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeInt32(int r3) {
            if (r3 < 0) goto L4;
            writeVarint32(r3);
            return;
        L4:
            writeVarint64(r3);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int r2, int r3) {
            requireSpace(15);
            writeInt32(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r3) {
            int r0 = r3.remaining();
            if (spaceLeft() >= r0) goto L6;
            this.totalDoneBytes += r0;
            this.buffers.addFirst(AllocatedBuffer.wrap(r3));
            nextBuffer();
            return;
        L6:
            int r1 = this.pos - r0;
            this.pos = r1;
            Java8Compatibility.position(this.buffer, r1 + 1);
            this.buffer.put(r3);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r3, int r4, int r5) {
            if (spaceLeft() >= r5) goto L6;
            this.totalDoneBytes += r5;
            this.buffers.addFirst(AllocatedBuffer.wrap(r3, r4, r5));
            nextBuffer();
            return;
        L6:
            int r0 = this.pos - r5;
            this.pos = r0;
            Java8Compatibility.position(this.buffer, r0 + 1);
            this.buffer.put(r3, r4, r5);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r3, Object r4) {
            int r0 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(r4, this);
            int r5 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r5);
            writeTag(r3, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r3, Object r4, Schema r5) {
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            int r0 = getTotalBytesWritten();
            r6.writeTo(r4, this);
            int r7 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r7);
            writeTag(r3, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt32(int r1) {
            writeVarint32(CodedOutputStream.encodeZigZag32(r1));
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int r2, int r3) {
            requireSpace(10);
            writeSInt32(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int r2, long r3) {
            requireSpace(15);
            writeSInt64(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt64(long r1) {
            writeVarint64(CodedOutputStream.encodeZigZag64(r1));
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int r2) {
            writeTag(r2, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int r2, String r3) {
            int r0 = getTotalBytesWritten();
            writeString(r3);
            int r4 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r4);
            writeTag(r2, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeString(String r9) {
            requireSpace(r9.length());
            int r0 = r9.length() - 1;
            this.pos -= r0;
        L4:
            if (r0 < 0) goto L9;
            char r3 = r9.charAt(r0);
            if (r3 >= 128) goto L9;
            this.buffer.put(this.pos + r0, (byte) r3);
            r0 = r0 - 1;
        L9:
            if (r0 != (-1)) goto L12;
            this.pos--;
            return;
        L12:
            this.pos += r0;
        L13:
            if (r0 < 0) goto L42;
            char r4 = r9.charAt(r0);
            if (r4 >= 128) goto L20;
            int r5 = this.pos;
            if (r5 < 0) goto L20;
            ByteBuffer r6 = this.buffer;
            this.pos = r5 - 1;
            r6.put(r5, (byte) r4);
        L41:
            r0 = r0 - 1;
        L20:
            if (r4 >= 2048) goto L25;
            int r7 = this.pos;
            if (r7 <= 0) goto L25;
            ByteBuffer r8 = this.buffer;
            this.pos = r7 - 1;
            r8.put(r7, (byte) ((r4 & '?') | 128));
            ByteBuffer r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 - 1;
            int r12 = (r4 >>> 6) | 960;
        L37:
            r10.put(r11, (byte) r12);
        L25:
            if (r4 >= 55296) goto L27;
        L28:
            int r13 = this.pos;
            if (r13 <= 1) goto L32;
            ByteBuffer r14 = this.buffer;
            this.pos = r13 - 1;
            r14.put(r13, (byte) ((r4 & '?') | 128));
            ByteBuffer r15 = this.buffer;
            int r16 = this.pos;
            this.pos = r16 - 1;
            r15.put(r16, (byte) (((r4 >>> 6) & 63) | 128));
            r10 = this.buffer;
            r11 = this.pos;
            this.pos = r11 - 1;
            r12 = (r4 >>> '\f') | 480;
        L32:
            if (this.pos <= 2) goto L40;
            if (r0 == 0) goto L39;
            char r17 = r9.charAt(r0 - 1);
            if (Character.isSurrogatePair(r17, r4) == false) goto L39;
            r0 = r0 - 1;
            int r18 = Character.toCodePoint(r17, r4);
            ByteBuffer r19 = this.buffer;
            int r20 = this.pos;
            this.pos = r20 - 1;
            r19.put(r20, (byte) ((r18 & 63) | 128));
            ByteBuffer r21 = this.buffer;
            int r22 = this.pos;
            this.pos = r22 - 1;
            r21.put(r22, (byte) (((r18 >>> 6) & 63) | 128));
            ByteBuffer r23 = this.buffer;
            int r24 = this.pos;
            this.pos = r24 - 1;
            r23.put(r24, (byte) (((r18 >>> 12) & 63) | 128));
            r10 = this.buffer;
            r11 = this.pos;
            this.pos = r11 - 1;
            r12 = (r18 >>> 18) | 240;
        L39:
            throw new Utf8.UnpairedSurrogateException(r0 - 1, r0);
        L40:
            requireSpace(r0);
            r0 = r0 + 1;
            goto L41
        L27:
            if (57343 >= r4) goto L32;
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int r1, int r2) {
            writeVarint32(WireFormat.makeTag(r1, r2));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int r2, int r3) {
            requireSpace(10);
            writeVarint32(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int r2, long r3) {
            requireSpace(15);
            writeVarint64(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint32(int r2) {
            if ((r2 & (-128)) != 0) goto L6;
            writeVarint32OneByte(r2);
            return;
        L6:
            if ((r2 & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(r2);
            return;
        L9:
            if (((-2097152) & r2) != 0) goto L12;
            writeVarint32ThreeBytes(r2);
            return;
        L12:
            if (((-268435456) & r2) != 0) goto L14;
            writeVarint32FourBytes(r2);
            return;
        L14:
            writeVarint32FiveBytes(r2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint64(long r2) {
            switch(BinaryWriter.access$200(r2)) {
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
            writeVarint64TenBytes(r2);
            return;
        L6:
            writeVarint64NineBytes(r2);
            return;
        L7:
            writeVarint64EightBytes(r2);
            return;
        L8:
            writeVarint64SevenBytes(r2);
            return;
        L9:
            writeVarint64SixBytes(r2);
            return;
        L10:
            writeVarint64FiveBytes(r2);
            return;
        L11:
            writeVarint64FourBytes(r2);
            return;
        L12:
            writeVarint64ThreeBytes(r2);
            return;
        L13:
            writeVarint64TwoBytes(r2);
            return;
        L14:
            writeVarint64OneByte(r2);
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

        SafeHeapWriter(BufferAllocator r2, int r3) {
            super(r2, r3, null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int r1) {
            nextBuffer(newHeapBuffer(r1));
        }

        private void nextBuffer(AllocatedBuffer r3) {
            if (r3.hasArray() == false) goto L7;
            finishCurrentBuffer();
            this.buffers.addFirst(r3);
            this.allocatedBuffer = r3;
            this.buffer = r3.array();
            int r0 = r3.arrayOffset();
            this.limit = r3.limit() + r0;
            int r1 = r0 + r3.position();
            this.offset = r1;
            this.offsetMinusOne = r1 - 1;
            int r4 = this.limit - 1;
            this.limitMinusOne = r4;
            this.pos = r4;
            return;
        L7:
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        private void writeVarint32FiveBytes(int r5) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r5 >>> 28);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (((r5 >>> 21) & 127) | 128);
            int r4 = r3 - 1;
            this.pos = r4;
            r0[r3] = (byte) (((r5 >>> 14) & 127) | 128);
            int r6 = r4 - 1;
            this.pos = r6;
            r0[r4] = (byte) (((r5 >>> 7) & 127) | 128);
            this.pos = r6 - 1;
            r0[r6] = (byte) ((r5 & 127) | 128);
        }

        private void writeVarint32FourBytes(int r5) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r5 >>> 21);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (((r5 >>> 14) & 127) | 128);
            int r4 = r3 - 1;
            this.pos = r4;
            r0[r3] = (byte) (((r5 >>> 7) & 127) | 128);
            this.pos = r4 - 1;
            r0[r4] = (byte) ((r5 & 127) | 128);
        }

        private void writeVarint32OneByte(int r4) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) r4;
        }

        private void writeVarint32ThreeBytes(int r5) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r5 >>> 14);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (((r5 >>> 7) & 127) | 128);
            this.pos = r3 - 1;
            r0[r3] = (byte) ((r5 & 127) | 128);
        }

        private void writeVarint32TwoBytes(int r5) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r5 >>> 7);
            this.pos = r2 - 1;
            r0[r2] = (byte) ((r5 & 127) | 128);
        }

        private void writeVarint64EightBytes(long r10) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r10 >>> 49);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (((r10 >>> 42) & 127) | 128);
            int r4 = r3 - 1;
            this.pos = r4;
            r0[r3] = (byte) (((r10 >>> 35) & 127) | 128);
            int r5 = r4 - 1;
            this.pos = r5;
            r0[r4] = (byte) (((r10 >>> 28) & 127) | 128);
            int r6 = r5 - 1;
            this.pos = r6;
            r0[r5] = (byte) (((r10 >>> 21) & 127) | 128);
            int r7 = r6 - 1;
            this.pos = r7;
            r0[r6] = (byte) (((r10 >>> 14) & 127) | 128);
            int r8 = r7 - 1;
            this.pos = r8;
            r0[r7] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r8 - 1;
            r0[r8] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64FiveBytes(long r10) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r10 >>> 28);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (((r10 >>> 21) & 127) | 128);
            int r4 = r3 - 1;
            this.pos = r4;
            r0[r3] = (byte) (((r10 >>> 14) & 127) | 128);
            int r5 = r4 - 1;
            this.pos = r5;
            r0[r4] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r5 - 1;
            r0[r5] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64FourBytes(long r10) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r10 >>> 21);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (((r10 >>> 14) & 127) | 128);
            int r4 = r3 - 1;
            this.pos = r4;
            r0[r3] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r4 - 1;
            r0[r4] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64NineBytes(long r10) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r10 >>> 56);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (((r10 >>> 49) & 127) | 128);
            int r4 = r3 - 1;
            this.pos = r4;
            r0[r3] = (byte) (((r10 >>> 42) & 127) | 128);
            int r5 = r4 - 1;
            this.pos = r5;
            r0[r4] = (byte) (((r10 >>> 35) & 127) | 128);
            int r6 = r5 - 1;
            this.pos = r6;
            r0[r5] = (byte) (((r10 >>> 28) & 127) | 128);
            int r7 = r6 - 1;
            this.pos = r7;
            r0[r6] = (byte) (((r10 >>> 21) & 127) | 128);
            int r8 = r7 - 1;
            this.pos = r8;
            r0[r7] = (byte) (((r10 >>> 14) & 127) | 128);
            int r9 = r8 - 1;
            this.pos = r9;
            r0[r8] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r9 - 1;
            r0[r9] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64OneByte(long r4) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) r4;
        }

        private void writeVarint64SevenBytes(long r10) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r10 >>> 42);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (((r10 >>> 35) & 127) | 128);
            int r4 = r3 - 1;
            this.pos = r4;
            r0[r3] = (byte) (((r10 >>> 28) & 127) | 128);
            int r5 = r4 - 1;
            this.pos = r5;
            r0[r4] = (byte) (((r10 >>> 21) & 127) | 128);
            int r6 = r5 - 1;
            this.pos = r6;
            r0[r5] = (byte) (((r10 >>> 14) & 127) | 128);
            int r7 = r6 - 1;
            this.pos = r7;
            r0[r6] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r7 - 1;
            r0[r7] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64SixBytes(long r10) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r10 >>> 35);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (((r10 >>> 28) & 127) | 128);
            int r4 = r3 - 1;
            this.pos = r4;
            r0[r3] = (byte) (((r10 >>> 21) & 127) | 128);
            int r5 = r4 - 1;
            this.pos = r5;
            r0[r4] = (byte) (((r10 >>> 14) & 127) | 128);
            int r6 = r5 - 1;
            this.pos = r6;
            r0[r5] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r6 - 1;
            r0[r6] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64TenBytes(long r10) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r10 >>> 63);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (((r10 >>> 56) & 127) | 128);
            int r4 = r3 - 1;
            this.pos = r4;
            r0[r3] = (byte) (((r10 >>> 49) & 127) | 128);
            int r5 = r4 - 1;
            this.pos = r5;
            r0[r4] = (byte) (((r10 >>> 42) & 127) | 128);
            int r6 = r5 - 1;
            this.pos = r6;
            r0[r5] = (byte) (((r10 >>> 35) & 127) | 128);
            int r7 = r6 - 1;
            this.pos = r7;
            r0[r6] = (byte) (((r10 >>> 28) & 127) | 128);
            int r8 = r7 - 1;
            this.pos = r8;
            r0[r7] = (byte) (((r10 >>> 21) & 127) | 128);
            int r9 = r8 - 1;
            this.pos = r9;
            r0[r8] = (byte) (((r10 >>> 14) & 127) | 128);
            int r11 = r9 - 1;
            this.pos = r11;
            r0[r9] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r11 - 1;
            r0[r11] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64ThreeBytes(long r10) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (((int) r10) >>> 14);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (((r10 >>> 7) & 127) | 128);
            this.pos = r3 - 1;
            r0[r3] = (byte) ((r10 & 127) | 128);
        }

        private void writeVarint64TwoBytes(long r6) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r6 >>> 7);
            this.pos = r2 - 1;
            r0[r2] = (byte) ((((int) r6) & 127) | 128);
        }

        int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        @Override // com.google.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.allocatedBuffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            AllocatedBuffer r0 = this.allocatedBuffer;
            r0.position((this.pos - r0.arrayOffset()) + 1);
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
        void requireSpace(int r2) {
            if (spaceLeft() >= r2) goto L6;
            nextBuffer(r2);
            return;
        }

        int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte r4) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = r4;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer r3) {
            int r0 = r3.remaining();
            if (spaceLeft() >= r0) goto L5;
            nextBuffer(r0);
        L5:
            int r1 = this.pos - r0;
            this.pos = r1;
            r3.get(this.buffer, r1 + 1, r0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] r2, int r3, int r4) {
            if (spaceLeft() >= r4) goto L5;
            nextBuffer(r4);
        L5:
            int r0 = this.pos - r4;
            this.pos = r0;
            System.arraycopy(r2, r3, this.buffer, r0 + 1, r4);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int r2, boolean r3) {
            requireSpace(6);
            write(r3 ? 1 : 0);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeBool(boolean r1) {
            write(r1 ? 1 : 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int r2, ByteString r3) {
            r3.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(r3.size());
            writeTag(r2, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int r2) {
            writeTag(r2, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed32(int r5) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r5 >> 24);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (r5 >> 16);
            int r4 = r3 - 1;
            this.pos = r4;
            r0[r3] = (byte) (r5 >> 8);
            this.pos = r4 - 1;
            r0[r4] = (byte) r5;
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int r2, int r3) {
            requireSpace(9);
            writeFixed32(r3);
            writeTag(r2, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int r2, long r3) {
            requireSpace(13);
            writeFixed64(r3);
            writeTag(r2, 1);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed64(long r6) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            this.pos = r2;
            r0[r1] = (byte) (r6 >> 56);
            int r3 = r2 - 1;
            this.pos = r3;
            r0[r2] = (byte) (r6 >> 48);
            int r4 = r3 - 1;
            this.pos = r4;
            r0[r3] = (byte) (r6 >> 40);
            int r5 = r4 - 1;
            this.pos = r5;
            r0[r4] = (byte) (r6 >> 32);
            int r7 = r5 - 1;
            this.pos = r7;
            r0[r5] = (byte) (r6 >> 24);
            int r8 = r7 - 1;
            this.pos = r8;
            r0[r7] = (byte) (r6 >> 16);
            int r9 = r8 - 1;
            this.pos = r9;
            r0[r8] = (byte) (r6 >> 8);
            this.pos = r9 - 1;
            r0[r9] = (byte) r6;
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeGroup(int r2, Object r3) {
            writeTag(r2, 4);
            Protobuf.getInstance().writeTo(r3, this);
            writeTag(r2, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r3, Object r4, Schema r5) {
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            writeTag(r3, 4);
            r6.writeTo(r4, this);
            writeTag(r3, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeInt32(int r3) {
            if (r3 < 0) goto L4;
            writeVarint32(r3);
            return;
        L4:
            writeVarint64(r3);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int r2, int r3) {
            requireSpace(15);
            writeInt32(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r4) {
            int r0 = r4.remaining();
            if (spaceLeft() >= r0) goto L5;
            this.totalDoneBytes += r0;
            this.buffers.addFirst(AllocatedBuffer.wrap(r4));
            nextBuffer();
        L5:
            int r1 = this.pos - r0;
            this.pos = r1;
            r4.get(this.buffer, r1 + 1, r0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r2, int r3, int r4) {
            if (spaceLeft() >= r4) goto L6;
            this.totalDoneBytes += r4;
            this.buffers.addFirst(AllocatedBuffer.wrap(r2, r3, r4));
            nextBuffer();
            return;
        L6:
            int r0 = this.pos - r4;
            this.pos = r0;
            System.arraycopy(r2, r3, this.buffer, r0 + 1, r4);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r3, Object r4) {
            int r0 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(r4, this);
            int r5 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r5);
            writeTag(r3, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r3, Object r4, Schema r5) {
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            int r0 = getTotalBytesWritten();
            r6.writeTo(r4, this);
            int r7 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r7);
            writeTag(r3, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt32(int r1) {
            writeVarint32(CodedOutputStream.encodeZigZag32(r1));
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int r2, int r3) {
            requireSpace(10);
            writeSInt32(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int r2, long r3) {
            requireSpace(15);
            writeSInt64(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt64(long r1) {
            writeVarint64(CodedOutputStream.encodeZigZag64(r1));
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int r2) {
            writeTag(r2, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int r2, String r3) {
            int r0 = getTotalBytesWritten();
            writeString(r3);
            int r4 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r4);
            writeTag(r2, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeString(String r9) {
            requireSpace(r9.length());
            int r0 = r9.length() - 1;
            this.pos -= r0;
        L4:
            if (r0 < 0) goto L9;
            char r2 = r9.charAt(r0);
            if (r2 >= 128) goto L9;
            this.buffer[this.pos + r0] = (byte) r2;
            r0 = r0 - 1;
        L9:
            if (r0 != (-1)) goto L12;
            this.pos--;
            return;
        L12:
            this.pos += r0;
        L13:
            if (r0 < 0) goto L41;
            char r3 = r9.charAt(r0);
            if (r3 >= 128) goto L20;
            int r4 = this.pos;
            if (r4 <= this.offsetMinusOne) goto L20;
            byte[] r5 = this.buffer;
            this.pos = r4 - 1;
            r5[r4] = (byte) r3;
        L40:
            r0 = r0 - 1;
        L20:
            if (r3 >= 2048) goto L25;
            int r6 = this.pos;
            if (r6 <= this.offset) goto L25;
            byte[] r7 = this.buffer;
            int r8 = r6 - 1;
            this.pos = r8;
            r7[r6] = (byte) ((r3 & '?') | 128);
            this.pos = r8 - 1;
            r7[r8] = (byte) ((r3 >>> 6) | 960);
        L25:
            if (r3 >= 55296) goto L27;
        L28:
            int r10 = this.pos;
            if (r10 <= (this.offset + 1)) goto L32;
            byte[] r11 = this.buffer;
            int r12 = r10 - 1;
            this.pos = r12;
            r11[r10] = (byte) ((r3 & '?') | 128);
            int r13 = r12 - 1;
            this.pos = r13;
            r11[r12] = (byte) (((r3 >>> 6) & 63) | 128);
            this.pos = r13 - 1;
            r11[r13] = (byte) ((r3 >>> '\f') | 480);
        L32:
            if (this.pos <= (this.offset + 2)) goto L39;
            if (r0 == 0) goto L38;
            char r14 = r9.charAt(r0 - 1);
            if (Character.isSurrogatePair(r14, r3) == false) goto L38;
            r0 = r0 - 1;
            int r15 = Character.toCodePoint(r14, r3);
            byte[] r16 = this.buffer;
            int r17 = this.pos;
            int r18 = r17 - 1;
            this.pos = r18;
            r16[r17] = (byte) ((r15 & 63) | 128);
            int r19 = r18 - 1;
            this.pos = r19;
            r16[r18] = (byte) (((r15 >>> 6) & 63) | 128);
            int r20 = r19 - 1;
            this.pos = r20;
            r16[r19] = (byte) (((r15 >>> 12) & 63) | 128);
            this.pos = r20 - 1;
            r16[r20] = (byte) ((r15 >>> 18) | 240);
        L38:
            throw new Utf8.UnpairedSurrogateException(r0 - 1, r0);
        L39:
            requireSpace(r0);
            r0 = r0 + 1;
            goto L40
        L27:
            if (57343 >= r3) goto L32;
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int r1, int r2) {
            writeVarint32(WireFormat.makeTag(r1, r2));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int r2, int r3) {
            requireSpace(10);
            writeVarint32(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int r2, long r3) {
            requireSpace(15);
            writeVarint64(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint32(int r2) {
            if ((r2 & (-128)) != 0) goto L6;
            writeVarint32OneByte(r2);
            return;
        L6:
            if ((r2 & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(r2);
            return;
        L9:
            if (((-2097152) & r2) != 0) goto L12;
            writeVarint32ThreeBytes(r2);
            return;
        L12:
            if (((-268435456) & r2) != 0) goto L14;
            writeVarint32FourBytes(r2);
            return;
        L14:
            writeVarint32FiveBytes(r2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint64(long r2) {
            switch(BinaryWriter.access$200(r2)) {
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
            writeVarint64TenBytes(r2);
            return;
        L6:
            writeVarint64NineBytes(r2);
            return;
        L7:
            writeVarint64EightBytes(r2);
            return;
        L8:
            writeVarint64SevenBytes(r2);
            return;
        L9:
            writeVarint64SixBytes(r2);
            return;
        L10:
            writeVarint64FiveBytes(r2);
            return;
        L11:
            writeVarint64FourBytes(r2);
            return;
        L12:
            writeVarint64ThreeBytes(r2);
            return;
        L13:
            writeVarint64TwoBytes(r2);
            return;
        L14:
            writeVarint64OneByte(r2);
            return;
        }
    }

    private static final class UnsafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private long bufferOffset;
        private long limitMinusOne;
        private long pos;

        UnsafeDirectWriter(BufferAllocator r2, int r3) {
            super(r2, r3, null);
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

        private void nextBuffer(int r1) {
            nextBuffer(newDirectBuffer(r1));
        }

        private void nextBuffer(AllocatedBuffer r5) {
            if (r5.hasNioBuffer() == false) goto L11;
            ByteBuffer r0 = r5.nioBuffer();
            if (r0.isDirect() == false) goto L9;
            finishCurrentBuffer();
            this.buffers.addFirst(r5);
            this.buffer = r0;
            Java8Compatibility.limit(r0, r0.capacity());
            Java8Compatibility.position(this.buffer, 0);
            long r1 = UnsafeUtil.addressOffset(this.buffer);
            this.bufferOffset = r1;
            long r2 = r1 + ((long) (this.buffer.limit() - 1));
            this.limitMinusOne = r2;
            this.pos = r2;
            return;
        L9:
            throw new RuntimeException("Allocator returned non-direct buffer");
        L11:
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        private void writeVarint32FiveBytes(int r7) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r7 >>> 28));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((r7 >>> 21) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((r7 >>> 14) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((r7 >>> 7) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) ((r7 & 127) | 128));
        }

        private void writeVarint32FourBytes(int r7) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r7 >>> 21));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((r7 >>> 14) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((r7 >>> 7) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) ((r7 & 127) | 128));
        }

        private void writeVarint32OneByte(int r5) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) r5);
        }

        private void writeVarint32ThreeBytes(int r7) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r7 >>> 14));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((r7 >>> 7) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) ((r7 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int r7) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r7 >>> 7));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) ((r7 & 127) | 128));
        }

        private void writeVarint64EightBytes(long r11) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r11 >>> 49));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((r11 >>> 42) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((r11 >>> 35) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((r11 >>> 28) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((r11 >>> 21) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((r11 >>> 14) & 127) | 128));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) (((r11 >>> 7) & 127) | 128));
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long r11) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r11 >>> 28));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((r11 >>> 21) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((r11 >>> 14) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((r11 >>> 7) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64FourBytes(long r11) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r11 >>> 21));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((r11 >>> 14) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((r11 >>> 7) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64NineBytes(long r11) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r11 >>> 56));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((r11 >>> 49) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((r11 >>> 42) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((r11 >>> 35) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((r11 >>> 28) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((r11 >>> 21) & 127) | 128));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) (((r11 >>> 14) & 127) | 128));
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) (((r11 >>> 7) & 127) | 128));
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64OneByte(long r5) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) r5);
        }

        private void writeVarint64SevenBytes(long r11) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r11 >>> 42));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((r11 >>> 35) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((r11 >>> 28) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((r11 >>> 21) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((r11 >>> 14) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((r11 >>> 7) & 127) | 128));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64SixBytes(long r11) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r11 >>> 35));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((r11 >>> 28) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((r11 >>> 21) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((r11 >>> 14) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((r11 >>> 7) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64TenBytes(long r11) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r11 >>> 63));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((r11 >>> 56) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((r11 >>> 49) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((r11 >>> 42) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((r11 >>> 35) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((r11 >>> 28) & 127) | 128));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) (((r11 >>> 21) & 127) | 128));
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) (((r11 >>> 14) & 127) | 128));
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) (((r11 >>> 7) & 127) | 128));
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r9, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long r11) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (((int) r11) >>> 14));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((r11 >>> 7) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) ((r11 & 127) | 128));
        }

        private void writeVarint64TwoBytes(long r7) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r7 >>> 7));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) ((((int) r7) & 127) | 128));
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
        void requireSpace(int r2) {
            if (spaceLeft() >= r2) goto L6;
            nextBuffer(r2);
            return;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte r5) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, r5);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer r6) {
            int r0 = r6.remaining();
            if (spaceLeft() >= r0) goto L5;
            nextBuffer(r0);
        L5:
            this.pos -= (long) r0;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(r6);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] r5, int r6, int r7) {
            if (spaceLeft() >= r7) goto L5;
            nextBuffer(r7);
        L5:
            this.pos -= (long) r7;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(r5, r6, r7);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int r2, boolean r3) {
            requireSpace(6);
            write(r3 ? 1 : 0);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeBool(boolean r1) {
            write(r1 ? 1 : 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int r2, ByteString r3) {
            r3.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(r3.size());
            writeTag(r2, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int r2) {
            writeTag(r2, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed32(int r7) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r7 >> 24));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (r7 >> 16));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (r7 >> 8));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) r7);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int r2, int r3) {
            requireSpace(9);
            writeFixed32(r3);
            writeTag(r2, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int r2, long r3) {
            requireSpace(13);
            writeFixed64(r3);
            writeTag(r2, 1);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed64(long r7) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (r7 >> 56));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (r7 >> 48));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (r7 >> 40));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (r7 >> 32));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (r7 >> 24));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (r7 >> 16));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) (r7 >> 8));
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) r7);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r2, Object r3) {
            writeTag(r2, 4);
            Protobuf.getInstance().writeTo(r3, this);
            writeTag(r2, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r3, Object r4, Schema r5) {
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            writeTag(r3, 4);
            r6.writeTo(r4, this);
            writeTag(r3, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeInt32(int r3) {
            if (r3 < 0) goto L4;
            writeVarint32(r3);
            return;
        L4:
            writeVarint64(r3);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int r2, int r3) {
            requireSpace(15);
            writeInt32(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r6) {
            int r0 = r6.remaining();
            if (spaceLeft() >= r0) goto L6;
            this.totalDoneBytes += r0;
            this.buffers.addFirst(AllocatedBuffer.wrap(r6));
            nextBuffer();
            return;
        L6:
            this.pos -= (long) r0;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(r6);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r5, int r6, int r7) {
            if (spaceLeft() >= r7) goto L6;
            this.totalDoneBytes += r7;
            this.buffers.addFirst(AllocatedBuffer.wrap(r5, r6, r7));
            nextBuffer();
            return;
        L6:
            this.pos -= (long) r7;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(r5, r6, r7);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r3, Object r4) {
            int r0 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(r4, this);
            int r5 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r5);
            writeTag(r3, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r3, Object r4, Schema r5) {
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            int r0 = getTotalBytesWritten();
            r6.writeTo(r4, this);
            int r7 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r7);
            writeTag(r3, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt32(int r1) {
            writeVarint32(CodedOutputStream.encodeZigZag32(r1));
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int r2, int r3) {
            requireSpace(10);
            writeSInt32(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int r2, long r3) {
            requireSpace(15);
            writeSInt64(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt64(long r1) {
            writeVarint64(CodedOutputStream.encodeZigZag64(r1));
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int r2) {
            writeTag(r2, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int r2, String r3) {
            int r0 = getTotalBytesWritten();
            writeString(r3);
            int r4 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r4);
            writeTag(r2, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeString(String r13) {
            requireSpace(r13.length());
            int r0 = r13.length();
        L3:
            r0 = r0 - 1;
            if (r0 < 0) goto L9;
            char r4 = r13.charAt(r0);
            if (r4 >= 128) goto L9;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) r4);
        L9:
            if (r0 != (-1)) goto L11;
            return;
        L11:
            if (r0 < 0) goto L40;
            char r6 = r13.charAt(r0);
            if (r6 >= 128) goto L18;
            long r7 = this.pos;
            if (r7 < this.bufferOffset) goto L18;
            this.pos = r7 - 1;
            int r8 = r6;
        L35:
            UnsafeUtil.putByte(r7, (byte) r8);
        L39:
            r0 = r0 - 1;
        L18:
            if (r6 >= 2048) goto L23;
            long r9 = this.pos;
            if (r9 <= this.bufferOffset) goto L23;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r9, (byte) ((r6 & '?') | 128));
            r7 = this.pos;
            this.pos = r7 - 1;
            r8 = (r6 >>> 6) | 960;
        L23:
            if (r6 >= 55296) goto L25;
        L26:
            long r10 = this.pos;
            if (r10 <= (this.bufferOffset + 1)) goto L30;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) ((r6 & '?') | 128));
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (((r6 >>> 6) & 63) | 128));
            r7 = this.pos;
            this.pos = r7 - 1;
            r8 = (r6 >>> '\f') | 480;
        L30:
            if (this.pos <= (this.bufferOffset + 2)) goto L38;
            if (r0 == 0) goto L37;
            char r12 = r13.charAt(r0 - 1);
            if (Character.isSurrogatePair(r12, r6) == false) goto L37;
            r0 = r0 - 1;
            int r14 = Character.toCodePoint(r12, r6);
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r15, (byte) ((r14 & 63) | 128));
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r16, (byte) (((r14 >>> 6) & 63) | 128));
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r17, (byte) (((r14 >>> 12) & 63) | 128));
            r7 = this.pos;
            this.pos = r7 - 1;
            r8 = (r14 >>> 18) | 240;
        L37:
            throw new Utf8.UnpairedSurrogateException(r0 - 1, r0);
        L38:
            requireSpace(r0);
            r0 = r0 + 1;
            goto L39
        L25:
            if (57343 >= r6) goto L30;
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int r1, int r2) {
            writeVarint32(WireFormat.makeTag(r1, r2));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int r2, int r3) {
            requireSpace(10);
            writeVarint32(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int r2, long r3) {
            requireSpace(15);
            writeVarint64(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint32(int r2) {
            if ((r2 & (-128)) != 0) goto L6;
            writeVarint32OneByte(r2);
            return;
        L6:
            if ((r2 & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(r2);
            return;
        L9:
            if (((-2097152) & r2) != 0) goto L12;
            writeVarint32ThreeBytes(r2);
            return;
        L12:
            if (((-268435456) & r2) != 0) goto L14;
            writeVarint32FourBytes(r2);
            return;
        L14:
            writeVarint32FiveBytes(r2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint64(long r2) {
            switch(BinaryWriter.access$200(r2)) {
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
            writeVarint64TenBytes(r2);
            return;
        L6:
            writeVarint64NineBytes(r2);
            return;
        L7:
            writeVarint64EightBytes(r2);
            return;
        L8:
            writeVarint64SevenBytes(r2);
            return;
        L9:
            writeVarint64SixBytes(r2);
            return;
        L10:
            writeVarint64FiveBytes(r2);
            return;
        L11:
            writeVarint64FourBytes(r2);
            return;
        L12:
            writeVarint64ThreeBytes(r2);
            return;
        L13:
            writeVarint64TwoBytes(r2);
            return;
        L14:
            writeVarint64OneByte(r2);
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

        UnsafeHeapWriter(BufferAllocator r2, int r3) {
            super(r2, r3, null);
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

        private void nextBuffer(int r1) {
            nextBuffer(newHeapBuffer(r1));
        }

        private void nextBuffer(AllocatedBuffer r5) {
            if (r5.hasArray() == false) goto L7;
            finishCurrentBuffer();
            this.buffers.addFirst(r5);
            this.allocatedBuffer = r5;
            this.buffer = r5.array();
            long r0 = r5.arrayOffset();
            this.limit = ((long) r5.limit()) + r0;
            long r1 = r0 + ((long) r5.position());
            this.offset = r1;
            this.offsetMinusOne = r1 - 1;
            long r2 = this.limit - 1;
            this.limitMinusOne = r2;
            this.pos = r2;
            return;
        L7:
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        private void writeVarint32FiveBytes(int r8) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r8 >>> 28));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((r8 >>> 21) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((r8 >>> 14) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((r8 >>> 7) & 127) | 128));
            byte[] r9 = this.buffer;
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r9, r10, (byte) ((r8 & 127) | 128));
        }

        private void writeVarint32FourBytes(int r8) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r8 >>> 21));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((r8 >>> 14) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((r8 >>> 7) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) ((r8 & 127) | 128));
        }

        private void writeVarint32OneByte(int r6) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) r6);
        }

        private void writeVarint32ThreeBytes(int r8) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r8 >>> 14));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((r8 >>> 7) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) ((r8 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int r8) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r8 >>> 7));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) ((r8 & 127) | 128));
        }

        private void writeVarint64EightBytes(long r12) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r12 >>> 49));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((r12 >>> 42) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((r12 >>> 35) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long r12) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r12 >>> 28));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64FourBytes(long r12) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r12 >>> 21));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64NineBytes(long r12) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r12 >>> 56));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((r12 >>> 49) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((r12 >>> 42) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((r12 >>> 35) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((r12 >>> 21) & 127) | 128));
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

        private void writeVarint64OneByte(long r6) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) r6);
        }

        private void writeVarint64SevenBytes(long r12) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r12 >>> 42));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((r12 >>> 35) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64SixBytes(long r12) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r12 >>> 35));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((r12 >>> 28) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((r12 >>> 21) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((r12 >>> 14) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64TenBytes(long r12) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r12 >>> 63));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((r12 >>> 56) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((r12 >>> 49) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((r12 >>> 42) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((r12 >>> 35) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((r12 >>> 28) & 127) | 128));
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

        private void writeVarint64ThreeBytes(long r12) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (((int) r12) >>> 14));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((r12 >>> 7) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) ((r12 & 127) | 128));
        }

        private void writeVarint64TwoBytes(long r8) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r8 >>> 7));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) ((((int) r8) & 127) | 128));
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
        void requireSpace(int r2) {
            if (spaceLeft() >= r2) goto L6;
            nextBuffer(r2);
            return;
        }

        int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte r6) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, r6);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer r6) {
            int r0 = r6.remaining();
            requireSpace(r0);
            this.pos -= (long) r0;
            r6.get(this.buffer, arrayPos() + 1, r0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] r6, int r7, int r8) {
            if (r7 < 0) goto L9;
            if ((r7 + r8) > r6.length) goto L9;
            requireSpace(r8);
            this.pos -= (long) r8;
            System.arraycopy(r6, r7, this.buffer, arrayPos() + 1, r8);
            return;
        L9:
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r6.length), Integer.valueOf(r7), Integer.valueOf(r8)}));
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int r2, boolean r3) {
            requireSpace(6);
            write(r3 ? 1 : 0);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeBool(boolean r1) {
            write(r1 ? 1 : 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int r2, ByteString r3) {
            r3.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(r3.size());
            writeTag(r2, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int r2) {
            writeTag(r2, 4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed32(int r8) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r8 >> 24));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (r8 >> 16));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (r8 >> 8));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int r2, int r3) {
            requireSpace(9);
            writeFixed32(r3);
            writeTag(r2, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int r2, long r3) {
            requireSpace(13);
            writeFixed64(r3);
            writeTag(r2, 1);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeFixed64(long r8) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (r8 >> 56));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (r8 >> 48));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (r8 >> 40));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (r8 >> 32));
            byte[] r9 = this.buffer;
            long r10 = this.pos;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r9, r10, (byte) (r8 >> 24));
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) (r8 >> 16));
            byte[] r13 = this.buffer;
            long r14 = this.pos;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r13, r14, (byte) (r8 >> 8));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) r8);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r2, Object r3) {
            writeTag(r2, 4);
            Protobuf.getInstance().writeTo(r3, this);
            writeTag(r2, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int r3, Object r4, Schema r5) {
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            writeTag(r3, 4);
            r6.writeTo(r4, this);
            writeTag(r3, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeInt32(int r3) {
            if (r3 < 0) goto L4;
            writeVarint32(r3);
            return;
        L4:
            writeVarint64(r3);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int r2, int r3) {
            requireSpace(15);
            writeInt32(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer r6) {
            int r0 = r6.remaining();
            if (spaceLeft() >= r0) goto L5;
            this.totalDoneBytes += r0;
            this.buffers.addFirst(AllocatedBuffer.wrap(r6));
            nextBuffer();
        L5:
            this.pos -= (long) r0;
            r6.get(this.buffer, arrayPos() + 1, r0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] r6, int r7, int r8) {
            if (r7 < 0) goto L13;
            if ((r7 + r8) > r6.length) goto L13;
            if (spaceLeft() >= r8) goto L10;
            this.totalDoneBytes += r8;
            this.buffers.addFirst(AllocatedBuffer.wrap(r6, r7, r8));
            nextBuffer();
            return;
        L10:
            this.pos -= (long) r8;
            System.arraycopy(r6, r7, this.buffer, arrayPos() + 1, r8);
            return;
        L13:
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r6.length), Integer.valueOf(r7), Integer.valueOf(r8)}));
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r3, Object r4) {
            int r0 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(r4, this);
            int r5 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r5);
            writeTag(r3, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int r3, Object r4, Schema r5) {
            Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            int r0 = getTotalBytesWritten();
            r6.writeTo(r4, this);
            int r7 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r7);
            writeTag(r3, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt32(int r1) {
            writeVarint32(CodedOutputStream.encodeZigZag32(r1));
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int r2, int r3) {
            requireSpace(10);
            writeSInt32(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int r2, long r3) {
            requireSpace(15);
            writeSInt64(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeSInt64(long r1) {
            writeVarint64(CodedOutputStream.encodeZigZag64(r1));
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int r2) {
            writeTag(r2, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int r2, String r3) {
            int r0 = getTotalBytesWritten();
            writeString(r3);
            int r4 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r4);
            writeTag(r2, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeString(String r13) {
            requireSpace(r13.length());
            int r0 = r13.length();
        L3:
            r0 = r0 - 1;
            if (r0 < 0) goto L9;
            char r4 = r13.charAt(r0);
            if (r4 >= 128) goto L9;
            byte[] r1 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r1, r5, (byte) r4);
        L9:
            if (r0 != (-1)) goto L11;
            return;
        L11:
            if (r0 < 0) goto L39;
            char r6 = r13.charAt(r0);
            if (r6 >= 128) goto L18;
            long r7 = this.pos;
            if (r7 <= this.offsetMinusOne) goto L18;
            byte[] r8 = this.buffer;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r8, r7, (byte) r6);
        L38:
            r0 = r0 - 1;
        L18:
            if (r6 >= 2048) goto L23;
            long r9 = this.pos;
            if (r9 <= this.offset) goto L23;
            byte[] r10 = this.buffer;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r10, r9, (byte) ((r6 & '?') | 128));
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) ((r6 >>> 6) | 960));
        L23:
            if (r6 >= 55296) goto L25;
        L26:
            long r14 = this.pos;
            if (r14 <= (this.offset + 1)) goto L30;
            byte[] r15 = this.buffer;
            this.pos = r14 - 1;
            UnsafeUtil.putByte(r15, r14, (byte) ((r6 & '?') | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) (((r6 >>> 6) & 63) | 128));
            byte[] r18 = this.buffer;
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r18, r19, (byte) ((r6 >>> '\f') | 480));
        L30:
            if (this.pos <= (this.offset + 2)) goto L37;
            if (r0 == 0) goto L36;
            char r20 = r13.charAt(r0 - 1);
            if (Character.isSurrogatePair(r20, r6) == false) goto L36;
            r0 = r0 - 1;
            int r21 = Character.toCodePoint(r20, r6);
            byte[] r22 = this.buffer;
            long r23 = this.pos;
            this.pos = r23 - 1;
            UnsafeUtil.putByte(r22, r23, (byte) ((r21 & 63) | 128));
            byte[] r24 = this.buffer;
            long r25 = this.pos;
            this.pos = r25 - 1;
            UnsafeUtil.putByte(r24, r25, (byte) (((r21 >>> 6) & 63) | 128));
            byte[] r26 = this.buffer;
            long r27 = this.pos;
            this.pos = r27 - 1;
            UnsafeUtil.putByte(r26, r27, (byte) (((r21 >>> 12) & 63) | 128));
            byte[] r28 = this.buffer;
            long r29 = this.pos;
            this.pos = r29 - 1;
            UnsafeUtil.putByte(r28, r29, (byte) ((r21 >>> 18) | 240));
        L36:
            throw new Utf8.UnpairedSurrogateException(r0 - 1, r0);
        L37:
            requireSpace(r0);
            r0 = r0 + 1;
            goto L38
        L25:
            if (57343 >= r6) goto L30;
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int r1, int r2) {
            writeVarint32(WireFormat.makeTag(r1, r2));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int r2, int r3) {
            requireSpace(10);
            writeVarint32(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int r2, long r3) {
            requireSpace(15);
            writeVarint64(r3);
            writeTag(r2, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint32(int r2) {
            if ((r2 & (-128)) != 0) goto L6;
            writeVarint32OneByte(r2);
            return;
        L6:
            if ((r2 & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(r2);
            return;
        L9:
            if (((-2097152) & r2) != 0) goto L12;
            writeVarint32ThreeBytes(r2);
            return;
        L12:
            if (((-268435456) & r2) != 0) goto L14;
            writeVarint32FourBytes(r2);
            return;
        L14:
            writeVarint32FiveBytes(r2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeVarint64(long r2) {
            switch(BinaryWriter.access$200(r2)) {
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
            writeVarint64TenBytes(r2);
            return;
        L6:
            writeVarint64NineBytes(r2);
            return;
        L7:
            writeVarint64EightBytes(r2);
            return;
        L8:
            writeVarint64SevenBytes(r2);
            return;
        L9:
            writeVarint64SixBytes(r2);
            return;
        L10:
            writeVarint64FiveBytes(r2);
            return;
        L11:
            writeVarint64FourBytes(r2);
            return;
        L12:
            writeVarint64ThreeBytes(r2);
            return;
        L13:
            writeVarint64TwoBytes(r2);
            return;
        L14:
            writeVarint64OneByte(r2);
            return;
        }
    }

    private BinaryWriter(BufferAllocator r3, int r4) {
        this.buffers = new ArrayDeque(4);
        if (r4 <= 0) goto L7;
        this.alloc = (BufferAllocator) ZeusTransformUtils.preCheckCast(Internal.checkNotNull(r3, "alloc"), BufferAllocator.class, "com.obric.memorydata.plugin");
        this.chunkSize = r4;
        return;
    L7:
        throw new IllegalArgumentException("chunkSize must be > 0");
    }

    /* synthetic */ BinaryWriter(BufferAllocator r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ byte access$200(long r0) {
        return computeUInt64SizeNoTag(r0);
    }

    private static byte computeUInt64SizeNoTag(long r6) {
        if (((-128) & r6) != 0) goto L7;
        return 1;
    L7:
        if (r6 >= 0) goto L11;
        return 10;
    L11:
        if (((-34359738368L) & r6) == 0) goto L13;
        byte r0 = (byte) 6;
        r6 = r6 >>> 28;
    L15:
        if (((-2097152) & r6) == 0) goto L18;
        r0 = (byte) (r0 + 2);
        r6 = r6 >>> 14;
    L18:
        if ((r6 & (-16384)) != 0) goto L20;
        return r0;
    L20:
        return (byte) (r0 + 1);
    L13:
        r0 = 2;
        goto L15
    }

    static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.access$000();
    }

    static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    public static BinaryWriter newDirectInstance(BufferAllocator r1) {
        return newDirectInstance(r1, 4096);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator r1, int r2) {
        if (isUnsafeDirectSupported() == false) goto L6;
        return newUnsafeDirectInstance(r1, r2);
    L6:
        return newSafeDirectInstance(r1, r2);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator r1) {
        return newHeapInstance(r1, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator r1, int r2) {
        if (isUnsafeHeapSupported() == false) goto L6;
        return newUnsafeHeapInstance(r1, r2);
    L6:
        return newSafeHeapInstance(r1, r2);
    }

    static BinaryWriter newSafeDirectInstance(BufferAllocator r1, int r2) {
        return new SafeDirectWriter(r1, r2);
    }

    static BinaryWriter newSafeHeapInstance(BufferAllocator r1, int r2) {
        return new SafeHeapWriter(r1, r2);
    }

    static BinaryWriter newUnsafeDirectInstance(BufferAllocator r1, int r2) {
        if (isUnsafeDirectSupported() == false) goto L7;
        return new UnsafeDirectWriter(r1, r2);
    L7:
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    static BinaryWriter newUnsafeHeapInstance(BufferAllocator r1, int r2) {
        if (isUnsafeHeapSupported() == false) goto L7;
        return new UnsafeHeapWriter(r1, r2);
    L7:
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private void writeBoolList_Internal(int r3, BooleanArrayList r4, boolean r5) {
        if (r5 == false) goto L7;
        requireSpace(r4.size() + 10);
        int r6 = getTotalBytesWritten();
        int r0 = r4.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeBool(r4.getBoolean(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(r3, 2);
        return;
    L7:
        int r7 = r4.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeBool(r3, r4.getBoolean(r7));
        r7 = r7 - 1;
        goto L8
    }

    private void writeBoolList_Internal(int r5, List<Boolean> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L8;
        requireSpace(r8.size() + 10);
        int r9 = getTotalBytesWritten();
        int r0 = r8.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        writeBool(((Boolean) ZeusTransformUtils.preCheckCast(r8.get(r0), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        r0 = r0 - 1;
        goto L5
    L7:
        writeVarint32(getTotalBytesWritten() - r9);
        writeTag(r5, 2);
        return;
    L8:
        int r10 = r8.size() - 1;
    L9:
        if (r10 < 0) goto L14;
        writeBool(r5, ((Boolean) ZeusTransformUtils.preCheckCast(r8.get(r10), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        r10 = r10 - 1;
        goto L9
    }

    private void writeDoubleList_Internal(int r4, DoubleArrayList r5, boolean r6) {
        if (r6 == false) goto L7;
        requireSpace((r5.size() * 8) + 10);
        int r7 = getTotalBytesWritten();
        int r0 = r5.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeFixed64(Double.doubleToRawLongBits(r5.getDouble(r0)));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r7);
        writeTag(r4, 2);
        return;
    L7:
        int r8 = r5.size() - 1;
    L8:
        if (r8 < 0) goto L13;
        writeDouble(r4, r5.getDouble(r8));
        r8 = r8 - 1;
        goto L8
    }

    private void writeDoubleList_Internal(int r5, List<Double> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L8;
        requireSpace((r8.size() * 8) + 10);
        int r9 = getTotalBytesWritten();
        int r0 = r8.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        writeFixed64(Double.doubleToRawLongBits(((Double) ZeusTransformUtils.preCheckCast(r8.get(r0), Double.class, "com.obric.memorydata.plugin")).doubleValue()));
        r0 = r0 - 1;
        goto L5
    L7:
        writeVarint32(getTotalBytesWritten() - r9);
        writeTag(r5, 2);
        return;
    L8:
        int r10 = r8.size() - 1;
    L9:
        if (r10 < 0) goto L14;
        writeDouble(r5, ((Double) ZeusTransformUtils.preCheckCast(r8.get(r10), Double.class, "com.obric.memorydata.plugin")).doubleValue());
        r10 = r10 - 1;
        goto L9
    }

    private void writeFixed32List_Internal(int r3, IntArrayList r4, boolean r5) {
        if (r5 == false) goto L7;
        requireSpace((r4.size() * 4) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = r4.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeFixed32(r4.getInt(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(r3, 2);
        return;
    L7:
        int r7 = r4.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeFixed32(r3, r4.getInt(r7));
        r7 = r7 - 1;
        goto L8
    }

    private void writeFixed32List_Internal(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L8;
        requireSpace((r8.size() * 4) + 10);
        int r9 = getTotalBytesWritten();
        int r0 = r8.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        writeFixed32(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 - 1;
        goto L5
    L7:
        writeVarint32(getTotalBytesWritten() - r9);
        writeTag(r5, 2);
        return;
    L8:
        int r10 = r8.size() - 1;
    L9:
        if (r10 < 0) goto L14;
        writeFixed32(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r10), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r10 = r10 - 1;
        goto L9
    }

    private void writeFixed64List_Internal(int r4, LongArrayList r5, boolean r6) {
        if (r6 == false) goto L7;
        requireSpace((r5.size() * 8) + 10);
        int r7 = getTotalBytesWritten();
        int r0 = r5.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeFixed64(r5.getLong(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r7);
        writeTag(r4, 2);
        return;
    L7:
        int r8 = r5.size() - 1;
    L8:
        if (r8 < 0) goto L13;
        writeFixed64(r4, r5.getLong(r8));
        r8 = r8 - 1;
        goto L8
    }

    private void writeFixed64List_Internal(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L8;
        requireSpace((r8.size() * 8) + 10);
        int r9 = getTotalBytesWritten();
        int r0 = r8.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        writeFixed64(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 - 1;
        goto L5
    L7:
        writeVarint32(getTotalBytesWritten() - r9);
        writeTag(r5, 2);
        return;
    L8:
        int r10 = r8.size() - 1;
    L9:
        if (r10 < 0) goto L14;
        writeFixed64(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r10), Long.class, "com.obric.memorydata.plugin")).longValue());
        r10 = r10 - 1;
        goto L9
    }

    private void writeFloatList_Internal(int r3, FloatArrayList r4, boolean r5) {
        if (r5 == false) goto L7;
        requireSpace((r4.size() * 4) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = r4.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeFixed32(Float.floatToRawIntBits(r4.getFloat(r0)));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(r3, 2);
        return;
    L7:
        int r7 = r4.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeFloat(r3, r4.getFloat(r7));
        r7 = r7 - 1;
        goto L8
    }

    private void writeFloatList_Internal(int r5, List<Float> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L8;
        requireSpace((r8.size() * 4) + 10);
        int r9 = getTotalBytesWritten();
        int r0 = r8.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        writeFixed32(Float.floatToRawIntBits(((Float) ZeusTransformUtils.preCheckCast(r8.get(r0), Float.class, "com.obric.memorydata.plugin")).floatValue()));
        r0 = r0 - 1;
        goto L5
    L7:
        writeVarint32(getTotalBytesWritten() - r9);
        writeTag(r5, 2);
        return;
    L8:
        int r10 = r8.size() - 1;
    L9:
        if (r10 < 0) goto L14;
        writeFloat(r5, ((Float) ZeusTransformUtils.preCheckCast(r8.get(r10), Float.class, "com.obric.memorydata.plugin")).floatValue());
        r10 = r10 - 1;
        goto L9
    }

    private void writeInt32List_Internal(int r3, IntArrayList r4, boolean r5) {
        if (r5 == false) goto L7;
        requireSpace((r4.size() * 10) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = r4.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeInt32(r4.getInt(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(r3, 2);
        return;
    L7:
        int r7 = r4.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeInt32(r3, r4.getInt(r7));
        r7 = r7 - 1;
        goto L8
    }

    private void writeInt32List_Internal(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L8;
        requireSpace((r8.size() * 10) + 10);
        int r9 = getTotalBytesWritten();
        int r0 = r8.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        writeInt32(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 - 1;
        goto L5
    L7:
        writeVarint32(getTotalBytesWritten() - r9);
        writeTag(r5, 2);
        return;
    L8:
        int r10 = r8.size() - 1;
    L9:
        if (r10 < 0) goto L14;
        writeInt32(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r10), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r10 = r10 - 1;
        goto L9
    }

    private void writeLazyString(int r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L5;
        writeString(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        writeBytes(r3, (ByteString) ZeusTransformUtils.preCheckCast(r4, ByteString.class, "com.obric.memorydata.plugin"));
    }

    static final void writeMapEntryField(Writer r3, int r4, WireFormat.FieldType r5, Object r6) {
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r3, Writer.class, "com.obric.memorydata.plugin");
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r5.ordinal()]) {
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
        r7.writeBytes(r4, (ByteString) ZeusTransformUtils.preCheckCast(r6, ByteString.class, "com.obric.memorydata.plugin"));
        return;
    L16:
        r7.writeMessage(r4, r6);
        return;
    L17:
        r7.writeDouble(r4, ((Double) ZeusTransformUtils.preCheckCast(r6, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L18:
        r7.writeFloat(r4, ((Float) ZeusTransformUtils.preCheckCast(r6, Float.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L19:
        r7.writeUInt64(r4, ((Long) ZeusTransformUtils.preCheckCast(r6, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L20:
        r7.writeUInt32(r4, ((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L21:
        r7.writeString(r4, (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"));
        return;
    L22:
        r7.writeSInt64(r4, ((Long) ZeusTransformUtils.preCheckCast(r6, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L23:
        r7.writeSInt32(r4, ((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L24:
        r7.writeSFixed64(r4, ((Long) ZeusTransformUtils.preCheckCast(r6, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L25:
        r7.writeSFixed32(r4, ((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L26:
        r7.writeInt64(r4, ((Long) ZeusTransformUtils.preCheckCast(r6, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L27:
        r7.writeInt32(r4, ((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L28:
        r7.writeFixed64(r4, ((Long) ZeusTransformUtils.preCheckCast(r6, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L29:
        r7.writeFixed32(r4, ((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L30:
        r7.writeBool(r4, ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L5:
        throw new IllegalArgumentException("Unsupported map value type for: " + r5);
    L7:
        if (ZeusTransformUtils.instanceOf(r6, Internal.EnumLite.class) == false) goto L11;
        int r8 = ((Internal.EnumLite) ZeusTransformUtils.preCheckCast(r6, Internal.EnumLite.class, "com.obric.memorydata.plugin")).getNumber();
    L9:
        r7.writeEnum(r4, r8);
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r6, Integer.class) == false) goto L14;
        r8 = ((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L9
    L14:
        throw new IllegalArgumentException("Unexpected type for enum in map.");
    }

    private void writeSInt32List_Internal(int r3, IntArrayList r4, boolean r5) {
        if (r5 == false) goto L7;
        requireSpace((r4.size() * 5) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = r4.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeSInt32(r4.getInt(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(r3, 2);
        return;
    L7:
        int r7 = r4.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeSInt32(r3, r4.getInt(r7));
        r7 = r7 - 1;
        goto L8
    }

    private void writeSInt32List_Internal(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L8;
        requireSpace((r8.size() * 5) + 10);
        int r9 = getTotalBytesWritten();
        int r0 = r8.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        writeSInt32(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 - 1;
        goto L5
    L7:
        writeVarint32(getTotalBytesWritten() - r9);
        writeTag(r5, 2);
        return;
    L8:
        int r10 = r8.size() - 1;
    L9:
        if (r10 < 0) goto L14;
        writeSInt32(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r10), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r10 = r10 - 1;
        goto L9
    }

    private void writeSInt64List_Internal(int r4, LongArrayList r5, boolean r6) {
        if (r6 == false) goto L7;
        requireSpace((r5.size() * 10) + 10);
        int r7 = getTotalBytesWritten();
        int r0 = r5.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeSInt64(r5.getLong(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r7);
        writeTag(r4, 2);
        return;
    L7:
        int r8 = r5.size() - 1;
    L8:
        if (r8 < 0) goto L13;
        writeSInt64(r4, r5.getLong(r8));
        r8 = r8 - 1;
        goto L8
    }

    private void writeSInt64List_Internal(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L8;
        requireSpace((r8.size() * 10) + 10);
        int r9 = getTotalBytesWritten();
        int r0 = r8.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        writeSInt64(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 - 1;
        goto L5
    L7:
        writeVarint32(getTotalBytesWritten() - r9);
        writeTag(r5, 2);
        return;
    L8:
        int r10 = r8.size() - 1;
    L9:
        if (r10 < 0) goto L14;
        writeSInt64(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r10), Long.class, "com.obric.memorydata.plugin")).longValue());
        r10 = r10 - 1;
        goto L9
    }

    private void writeUInt32List_Internal(int r3, IntArrayList r4, boolean r5) {
        if (r5 == false) goto L7;
        requireSpace((r4.size() * 5) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = r4.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeVarint32(r4.getInt(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(r3, 2);
        return;
    L7:
        int r7 = r4.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeUInt32(r3, r4.getInt(r7));
        r7 = r7 - 1;
        goto L8
    }

    private void writeUInt32List_Internal(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L8;
        requireSpace((r8.size() * 5) + 10);
        int r9 = getTotalBytesWritten();
        int r0 = r8.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        writeVarint32(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r0 = r0 - 1;
        goto L5
    L7:
        writeVarint32(getTotalBytesWritten() - r9);
        writeTag(r5, 2);
        return;
    L8:
        int r10 = r8.size() - 1;
    L9:
        if (r10 < 0) goto L14;
        writeUInt32(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r10), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r10 = r10 - 1;
        goto L9
    }

    private void writeUInt64List_Internal(int r4, LongArrayList r5, boolean r6) {
        if (r6 == false) goto L7;
        requireSpace((r5.size() * 10) + 10);
        int r7 = getTotalBytesWritten();
        int r0 = r5.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeVarint64(r5.getLong(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r7);
        writeTag(r4, 2);
        return;
    L7:
        int r8 = r5.size() - 1;
    L8:
        if (r8 < 0) goto L13;
        writeUInt64(r4, r5.getLong(r8));
        r8 = r8 - 1;
        goto L8
    }

    private void writeUInt64List_Internal(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L8;
        requireSpace((r8.size() * 10) + 10);
        int r9 = getTotalBytesWritten();
        int r0 = r8.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        writeVarint64(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.memorydata.plugin")).longValue());
        r0 = r0 - 1;
        goto L5
    L7:
        writeVarint32(getTotalBytesWritten() - r9);
        writeTag(r5, 2);
        return;
    L8:
        int r10 = r8.size() - 1;
    L9:
        if (r10 < 0) goto L14;
        writeUInt64(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r10), Long.class, "com.obric.memorydata.plugin")).longValue());
        r10 = r10 - 1;
        goto L9
    }

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

    final AllocatedBuffer newDirectBuffer(int r2) {
        return this.alloc.allocateDirectBuffer(Math.max(r2, this.chunkSize));
    }

    final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    final AllocatedBuffer newHeapBuffer(int r2) {
        return this.alloc.allocateHeapBuffer(Math.max(r2, this.chunkSize));
    }

    abstract void requireSpace(int r1);

    abstract void writeBool(boolean r1);

    @Override // com.google.protobuf.Writer
    public final void writeBoolList(int r3, List<Boolean> r4, boolean r5) {
        List<Boolean> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, BooleanArrayList.class) == false) goto L5;
        writeBoolList_Internal(r3, (BooleanArrayList) ZeusTransformUtils.preCheckCast(r6, BooleanArrayList.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        writeBoolList_Internal(r3, r6, r5);
    }

    @Override // com.google.protobuf.Writer
    public final void writeBytesList(int r5, List<ByteString> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        writeBytes(r5, (ByteString) ZeusTransformUtils.preCheckCast(r7.get(r0), ByteString.class, "com.obric.memorydata.plugin"));
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.google.protobuf.Writer
    public final void writeDouble(int r1, double r2) {
        writeFixed64(r1, Double.doubleToRawLongBits(r2));
    }

    @Override // com.google.protobuf.Writer
    public final void writeDoubleList(int r3, List<Double> r4, boolean r5) {
        List<Double> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, DoubleArrayList.class) == false) goto L5;
        writeDoubleList_Internal(r3, (DoubleArrayList) ZeusTransformUtils.preCheckCast(r6, DoubleArrayList.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        writeDoubleList_Internal(r3, r6, r5);
    }

    @Override // com.google.protobuf.Writer
    public final void writeEnum(int r1, int r2) {
        writeInt32(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public final void writeEnumList(int r3, List<Integer> r4, boolean r5) {
        writeInt32List(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5);
    }

    abstract void writeFixed32(int r1);

    @Override // com.google.protobuf.Writer
    public final void writeFixed32List(int r3, List<Integer> r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L5;
        writeFixed32List_Internal(r3, (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        writeFixed32List_Internal(r3, r6, r5);
    }

    abstract void writeFixed64(long r1);

    @Override // com.google.protobuf.Writer
    public final void writeFixed64List(int r3, List<Long> r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L5;
        writeFixed64List_Internal(r3, (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        writeFixed64List_Internal(r3, r6, r5);
    }

    @Override // com.google.protobuf.Writer
    public final void writeFloat(int r1, float r2) {
        writeFixed32(r1, Float.floatToRawIntBits(r2));
    }

    @Override // com.google.protobuf.Writer
    public final void writeFloatList(int r3, List<Float> r4, boolean r5) {
        List<Float> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, FloatArrayList.class) == false) goto L5;
        writeFloatList_Internal(r3, (FloatArrayList) ZeusTransformUtils.preCheckCast(r6, FloatArrayList.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        writeFloatList_Internal(r3, r6, r5);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int r3, List<?> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        writeGroup(r3, r5.get(r0));
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int r3, List<?> r4, Schema r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
        int r0 = r6.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        writeGroup(r3, r6.get(r0), r7);
        r0 = r0 - 1;
        goto L3
    }

    abstract void writeInt32(int r1);

    @Override // com.google.protobuf.Writer
    public final void writeInt32List(int r3, List<Integer> r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L5;
        writeInt32List_Internal(r3, (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        writeInt32List_Internal(r3, r6, r5);
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt64(int r1, long r2) {
        writeUInt64(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt64List(int r3, List<Long> r4, boolean r5) {
        writeUInt64List(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int r7, MapEntryLite.Metadata<K, V> r8, Map<K, V> r9) {
        Iterator<Map.Entry<K, V>> r10 = ((Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r2 = getTotalBytesWritten();
        writeMapEntryField(this, 2, r8.valueType, r0.getValue());
        writeMapEntryField(this, 1, r8.keyType, r0.getKey());
        writeVarint32(getTotalBytesWritten() - r2);
        writeTag(r7, 2);
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageList(int r3, List<?> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        writeMessage(r3, r5.get(r0));
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageList(int r3, List<?> r4, Schema r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
        int r0 = r6.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        writeMessage(r3, r6.get(r0), r7);
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int r5, Object r6) {
        writeTag(1, 4);
        if (ZeusTransformUtils.instanceOf(r6, ByteString.class) == false) goto L5;
        writeBytes(3, (ByteString) ZeusTransformUtils.preCheckCast(r6, ByteString.class, "com.obric.memorydata.plugin"));
    L6:
        writeUInt32(2, r5);
        writeTag(1, 3);
        return;
    L5:
        writeMessage(3, r6);
        goto L6
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed32(int r1, int r2) {
        writeFixed32(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed32List(int r3, List<Integer> r4, boolean r5) {
        writeFixed32List(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed64(int r1, long r2) {
        writeFixed64(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed64List(int r3, List<Long> r4, boolean r5) {
        writeFixed64List(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5);
    }

    abstract void writeSInt32(int r1);

    @Override // com.google.protobuf.Writer
    public final void writeSInt32List(int r3, List<Integer> r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L5;
        writeSInt32List_Internal(r3, (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        writeSInt32List_Internal(r3, r6, r5);
    }

    abstract void writeSInt64(long r1);

    @Override // com.google.protobuf.Writer
    public final void writeSInt64List(int r3, List<Long> r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L5;
        writeSInt64List_Internal(r3, (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        writeSInt64List_Internal(r3, r6, r5);
    }

    abstract void writeString(String r1);

    @Override // com.google.protobuf.Writer
    public final void writeStringList(int r5, List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, LazyStringList.class) == false) goto L7;
        LazyStringList r0 = (LazyStringList) ZeusTransformUtils.preCheckCast(r7, LazyStringList.class, "com.obric.memorydata.plugin");
        int r8 = r7.size() - 1;
    L5:
        if (r8 < 0) goto L10;
        writeLazyString(r5, r0.getRaw(r8));
        r8 = r8 - 1;
        goto L5
    L10:
        return;
    L7:
        int r1 = r7.size() - 1;
    L8:
        if (r1 < 0) goto L13;
        writeString(r5, (String) ZeusTransformUtils.preCheckCast(r7.get(r1), String.class, "com.obric.memorydata.plugin"));
        r1 = r1 - 1;
        goto L8
    }

    abstract void writeTag(int r1, int r2);

    @Override // com.google.protobuf.Writer
    public final void writeUInt32List(int r3, List<Integer> r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L5;
        writeUInt32List_Internal(r3, (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        writeUInt32List_Internal(r3, r6, r5);
    }

    @Override // com.google.protobuf.Writer
    public final void writeUInt64List(int r3, List<Long> r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L5;
        writeUInt64List_Internal(r3, (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        writeUInt64List_Internal(r3, r6, r5);
    }

    abstract void writeVarint32(int r1);

    abstract void writeVarint64(long r1);
}
