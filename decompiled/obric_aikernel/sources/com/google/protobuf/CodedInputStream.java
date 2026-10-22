package com.google.protobuf;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int groupDepth;
    int messageDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    CodedInputStreamReader wrapper;

    /* JADX INFO: renamed from: com.google.protobuf.CodedInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private ArrayDecoder(byte[] r10, int r11, int r12, boolean r13) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = r10;
            this.limit = r12 + r11;
            this.pos = r11;
            this.startPos = r11;
            this.immutable = r13;
        }

        /* synthetic */ ArrayDecoder(byte[] r10, int r11, int r12, boolean r13, AnonymousClass1 r14) {
            this(r10, r11, r12, r13);
        }

        private void recomputeBufferSizeAfterLimit() {
            int r10 = this.limit + this.bufferSizeAfterLimit;
            this.limit = r10;
            int r11 = r10 - this.startPos;
            int r12 = this.currentLimit;
            if (r11 <= r12) goto L5;
            int r13 = r11 - r12;
            this.bufferSizeAfterLimit = r13;
            this.limit = r10 - r13;
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        private void skipRawVarint() {
            if ((this.limit - this.pos) < 10) goto L5;
            skipRawVarintFastPath();
            return;
        L5:
            skipRawVarintSlowPath();
        }

        private void skipRawVarintFastPath() {
            int r10 = 0;
        L4:
            if (r10 >= 10) goto L10;
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            this.pos = r12 + 1;
            if (r11[r12] >= 0) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() {
            int r10 = 0;
        L4:
            if (r10 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int r10) {
            if (this.lastTag != r10) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean r10) {
            this.enableAliasing = r10;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r10 = this.currentLimit;
            if (r10 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r10 - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() {
            if (this.pos != this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int r10) {
            this.currentLimit = r10;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int r10) {
            if (r10 < 0) goto L14;
            int r11 = r10 + getTotalBytesRead();
            if (r11 < 0) goto L12;
            int r12 = this.currentLimit;
            if (r11 > r12) goto L10;
            this.currentLimit = r11;
            recomputeBufferSizeAfterLimit();
            return r12;
        L10:
            throw InvalidProtocolBufferException.truncatedMessage();
        L12:
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L14:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() {
            int r10 = readRawVarint32();
            if (r10 <= 0) goto L14;
            int r11 = this.limit;
            int r12 = this.pos;
            if (r10 > (r11 - r12)) goto L14;
            if (this.immutable == false) goto L9;
        L11:
            ByteBuffer r13 = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, r12, r12 + r10));
        L12:
            this.pos += r10;
            return r13;
        L9:
            if (this.enableAliasing == false) goto L11;
            r13 = ByteBuffer.wrap(this.buffer, r12, r10).slice();
        L14:
            if (r10 == 0) goto L16;
            if (r10 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return Internal.EMPTY_BYTE_BUFFER;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() {
            int r10 = readRawVarint32();
            if (r10 <= 0) goto L14;
            int r11 = this.limit;
            int r12 = this.pos;
            if (r10 > (r11 - r12)) goto L14;
            if (this.immutable == true) goto L9;
        L11:
            ByteString r13 = ByteString.copyFrom(this.buffer, r12, r10);
        L12:
            this.pos += r10;
            return r13;
        L9:
            if (this.enableAliasing == false) goto L11;
            r13 = ByteString.wrap(this.buffer, r12, r10);
        L14:
            if (r10 != 0) goto L18;
            return ByteString.EMPTY;
        L18:
            return ByteString.wrap(readRawBytes(r10));
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int r10, Parser<T> r11, ExtensionRegistryLite r12) {
            checkRecursionLimit();
            this.groupDepth++;
            T r13 = r11.parsePartialFrom(this, r12);
            checkLastTagWas(WireFormat.makeTag(r10, 4));
            this.groupDepth--;
            return r13;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int r10, MessageLite.Builder r11, ExtensionRegistryLite r12) {
            checkRecursionLimit();
            this.groupDepth++;
            r11.mergeFrom(this, r12);
            checkLastTagWas(WireFormat.makeTag(r10, 4));
            this.groupDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> r10, ExtensionRegistryLite r11) {
            int r12 = readRawVarint32();
            checkRecursionLimit();
            int r13 = pushLimit(r12);
            this.messageDepth++;
            T r14 = r10.parsePartialFrom(this, r11);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r13);
            return r14;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder r10, ExtensionRegistryLite r11) {
            int r12 = readRawVarint32();
            checkRecursionLimit();
            int r13 = pushLimit(r12);
            this.messageDepth++;
            r10.mergeFrom(this, r11);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r13);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() {
            int r10 = this.pos;
            if (r10 == this.limit) goto L7;
            byte[] r11 = this.buffer;
            this.pos = r10 + 1;
            return r11[r10];
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int r10) {
            if (r10 <= 0) goto L7;
            int r11 = this.limit;
            int r12 = this.pos;
            if (r10 > (r11 - r12)) goto L7;
            int r13 = r10 + r12;
            this.pos = r13;
            return Arrays.copyOfRange(this.buffer, r12, r13);
        L7:
            if (r10 > 0) goto L14;
            if (r10 != 0) goto L12;
            return Internal.EMPTY_BYTE_ARRAY;
        L12:
            throw InvalidProtocolBufferException.negativeSize();
        L14:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            int r10 = this.pos;
            if ((this.limit - r10) < 4) goto L7;
            byte[] r11 = this.buffer;
            this.pos = r10 + 4;
            return (((r11[r10] & 255) | ((r11[r10 + 1] & 255) << 8)) | ((r11[r10 + 2] & 255) << 16)) | ((r11[r10 + 3] & 255) << 24);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            int r10 = this.pos;
            if ((this.limit - r10) < 8) goto L7;
            byte[] r11 = this.buffer;
            this.pos = r10 + 8;
            long r12 = ((((((((long) r11[r10]) & 255) | ((((long) r11[r10 + 1]) & 255) << 8)) | ((((long) r11[r10 + 2]) & 255) << 16)) | ((((long) r11[r10 + 3]) & 255) << 24)) | ((((long) r11[r10 + 4]) & 255) << 32)) | ((((long) r11[r10 + 5]) & 255) << 40)) | ((((long) r11[r10 + 6]) & 255) << 48);
            return ((((long) r11[r10 + 7]) & 255) << 56) | r12;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() {
            int r10 = this.pos;
            int r11 = this.limit;
            if (r11 == r10) goto L35;
            byte[] r12 = this.buffer;
            int r13 = r10 + 1;
            byte r14 = r12[r10];
            if (r14 < 0) goto L10;
            this.pos = r13;
            return r14;
        L10:
            if ((r11 - r13) < 9) goto L35;
            int r15 = r13 + 1;
            int r16 = r14 ^ (r12[r13] << 7);
            if (r16 >= 0) goto L15;
            int r17 = r16 ^ (-128);
        L36:
            this.pos = r15;
            return r17;
        L15:
            int r18 = r15 + 1;
            int r19 = r16 ^ (r12[r15] << 14);
            if (r19 < 0) goto L19;
            r17 = r19 ^ 16256;
        L18:
            r15 = r18;
            goto L36
        L19:
            r15 = r18 + 1;
            int r20 = r19 ^ (r12[r18] << 21);
            if (r20 >= 0) goto L22;
            r17 = r20 ^ (-2080896);
            goto L36
        L22:
            r18 = r15 + 1;
            byte r21 = r12[r15];
            r17 = (r20 ^ (r21 << 28)) ^ 266354560;
            if (r21 >= 0) goto L18;
            r15 = r18 + 1;
            if (r12[r18] >= 0) goto L36;
            r18 = r15 + 1;
            if (r12[r15] >= 0) goto L18;
            r15 = r18 + 1;
            if (r12[r18] >= 0) goto L36;
            r18 = r15 + 1;
            if (r12[r15] >= 0) goto L18;
            r15 = r18 + 1;
            if (r12[r18] >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() {
            int r10 = this.pos;
            int r11 = this.limit;
            if (r11 == r10) goto L41;
            byte[] r12 = this.buffer;
            int r13 = r10 + 1;
            byte r14 = r12[r10];
            if (r14 < 0) goto L10;
            this.pos = r13;
            return r14;
        L10:
            if ((r11 - r13) < 9) goto L41;
            int r15 = r13 + 1;
            int r16 = r14 ^ (r12[r13] << 7);
            if (r16 >= 0) goto L16;
            int r17 = r16 ^ (-128);
        L15:
            long r18 = r17;
        L44:
            this.pos = r15;
            return r18;
        L16:
            int r19 = r15 + 1;
            int r20 = r16 ^ (r12[r15] << 14);
            if (r20 < 0) goto L19;
            r15 = r19;
            r18 = r20 ^ 16256;
            goto L44
        L19:
            r15 = r19 + 1;
            int r21 = r20 ^ (r12[r19] << 21);
            if (r21 >= 0) goto L22;
            r17 = r21 ^ (-2080896);
            goto L15
        L22:
            long r22 = r21;
            int r23 = r15 + 1;
            long r24 = r22 ^ (((long) r12[r15]) << 28);
            if (r24 < 0) goto L26;
            long r25 = 266354560;
        L25:
            r18 = r24 ^ r25;
            r15 = r23;
            goto L44
        L26:
            r15 = r23 + 1;
            long r26 = r24 ^ (((long) r12[r23]) << 35);
            if (r26 >= 0) goto L30;
            long r27 = -34093383808L;
        L29:
            r18 = r26 ^ r27;
            goto L44
        L30:
            r23 = r15 + 1;
            r24 = r26 ^ (((long) r12[r15]) << 42);
            if (r24 < 0) goto L33;
            r25 = 4363953127296L;
            goto L25
        L33:
            r15 = r23 + 1;
            r26 = r24 ^ (((long) r12[r23]) << 49);
            if (r26 >= 0) goto L36;
            r27 = -558586000294016L;
            goto L29
        L36:
            int r28 = r15 + 1;
            long r29 = (r26 ^ (((long) r12[r15]) << 56)) ^ 71499008037633920L;
            if (r29 >= 0) goto L42;
            r15 = r28 + 1;
            if (r12[r28] < 0) goto L41;
        L43:
            r18 = r29;
            goto L44
        L42:
            r15 = r28;
        L41:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        long readRawVarint64SlowPath() {
            long r10 = 0;
            int r11 = 0;
        L4:
            if (r11 >= 64) goto L10;
            byte r12 = readRawByte();
            r10 = r10 | (((long) (r12 & ByteCompanionObject.MAX_VALUE)) << r11);
            if ((r12 & 128) == 0) goto L7;
            r11 = r11 + 7;
            goto L4
        L7:
            return r10;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() {
            int r10 = readRawVarint32();
            if (r10 <= 0) goto L8;
            int r11 = this.limit;
            int r12 = this.pos;
            if (r10 > (r11 - r12)) goto L8;
            String r13 = new String(this.buffer, r12, r10, Internal.UTF_8);
            this.pos += r10;
            return r13;
        L8:
            if (r10 != 0) goto L11;
            return "";
        L11:
            if (r10 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            int r10 = readRawVarint32();
            if (r10 <= 0) goto L8;
            int r11 = this.limit;
            int r12 = this.pos;
            if (r10 > (r11 - r12)) goto L8;
            String r13 = Utf8.decodeUtf8(this.buffer, r12, r10);
            this.pos += r10;
            return r13;
        L8:
            if (r10 != 0) goto L11;
            return "";
        L11:
            if (r10 > 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r10 = readRawVarint32();
            this.lastTag = r10;
            if (WireFormat.getTagFieldNumber(r10) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int r10, MessageLite.Builder r11) {
            readGroup(r10, r11, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r10) {
            int r11 = WireFormat.getTagWireType(r10);
            if (r11 == 0) goto L24;
            if (r11 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r11 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r11 == 3) goto L18;
            if (r11 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r11 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r10), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r10, CodedOutputStream r11) {
            int r12 = WireFormat.getTagWireType(r10);
            if (r12 == 0) goto L24;
            if (r12 != 1) goto L6;
            long r13 = readRawLittleEndian64();
            r11.writeUInt32NoTag(r10);
            r11.writeFixed64NoTag(r13);
            return true;
        L6:
            if (r12 != 2) goto L8;
            ByteString r14 = readBytes();
            r11.writeUInt32NoTag(r10);
            r11.writeBytesNoTag(r14);
            return true;
        L8:
            if (r12 == 3) goto L18;
            if (r12 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r12 != 5) goto L15;
            int r15 = readRawLittleEndian32();
            r11.writeUInt32NoTag(r10);
            r11.writeFixed32NoTag(r15);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            r11.writeUInt32NoTag(r10);
            skipMessage(r11);
            int r16 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r10), 4);
            checkLastTagWas(r16);
            r11.writeUInt32NoTag(r16);
            return true;
        L24:
            long r17 = readInt64();
            r11.writeUInt32NoTag(r10);
            r11.writeUInt64NoTag(r17);
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int r10) {
            if (r10 < 0) goto L7;
            int r11 = this.limit;
            int r12 = this.pos;
            if (r10 > (r11 - r12)) goto L7;
            this.pos = r12 + r10;
            return;
        L7:
            if (r10 >= 0) goto L11;
            throw InvalidProtocolBufferException.negativeSize();
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private final Iterable<ByteBuffer> input;
        private final Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> r10, int r11, boolean r12) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = r11;
            this.input = r10;
            this.iterator = r10.iterator();
            this.immutable = r12;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (r11 != 0) goto L5;
            this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
            this.currentByteBufferPos = 0;
            this.currentByteBufferStartPos = 0;
            this.currentByteBufferLimit = 0;
            this.currentAddress = 0;
            return;
        L5:
            tryGetNextByteBuffer();
        }

        /* synthetic */ IterableDirectByteBufferDecoder(Iterable r10, int r11, boolean r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private void getNextByteBuffer() {
            if (this.iterator.hasNext() == false) goto L7;
            tryGetNextByteBuffer();
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void readRawBytesTo(byte[] r12, int r13, int r14) {
            if (r14 >= 0) goto L4;
        L12:
            if (r14 > 0) goto L18;
            if (r14 != 0) goto L16;
            return;
        L16:
            throw InvalidProtocolBufferException.negativeSize();
        L18:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r14 > remaining()) goto L12;
            int r10 = r14;
        L6:
            if (r10 <= 0) goto L11;
            if (currentRemaining() != 0) goto L10;
            getNextByteBuffer();
        L10:
            int r11 = Math.min(r10, (int) currentRemaining());
            long r15 = r11;
            UnsafeUtil.copyMemory(this.currentByteBufferPos, r12, (r14 - r10) + r13, r15);
            r10 = r10 - r11;
            this.currentByteBufferPos += r15;
            goto L6
        }

        private void recomputeBufferSizeAfterLimit() {
            int r10 = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = r10;
            int r11 = r10 - this.startOffset;
            int r12 = this.currentLimit;
            if (r11 <= r12) goto L5;
            int r13 = r11 - r12;
            this.bufferSizeAfterCurrentLimit = r13;
            this.totalBufferSize = r10 - r13;
            return;
        L5:
            this.bufferSizeAfterCurrentLimit = 0;
        }

        private int remaining() {
            return (int) ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private void skipRawVarint() {
            int r10 = 0;
        L4:
            if (r10 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(int r10, int r11) {
            int r12 = this.currentByteBuffer.position();
            int r13 = this.currentByteBuffer.limit();
            ByteBuffer r14 = this.currentByteBuffer;
            r14.position(r10);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r14.limit(r11);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            ByteBuffer r15 = this.currentByteBuffer.slice();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r14.position(r12);
            r14.limit(r13);
            return r15;
        L6:
            th = move-exception;
            r14.position(r12);
            r14.limit(r13);
            throw th;
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();     // Catch: Throwable -> L6
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer r10 = this.iterator.next();
            this.currentByteBuffer = r10;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long r11 = r10.position();
            this.currentByteBufferPos = r11;
            this.currentByteBufferStartPos = r11;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            long r12 = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentAddress = r12;
            this.currentByteBufferPos += r12;
            this.currentByteBufferStartPos += r12;
            this.currentByteBufferLimit += r12;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int r10) {
            if (this.lastTag != r10) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean r10) {
            this.enableAliasing = r10;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r10 = this.currentLimit;
            if (r10 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r10 - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) ((((long) (this.totalBytesRead - this.startOffset)) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() {
            if (((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos) != this.totalBufferSize) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int r10) {
            this.currentLimit = r10;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int r10) {
            if (r10 < 0) goto L10;
            int r11 = r10 + getTotalBytesRead();
            int r12 = this.currentLimit;
            if (r11 > r12) goto L8;
            this.currentLimit = r11;
            recomputeBufferSizeAfterLimit();
            return r12;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() {
            int r10 = readRawVarint32();
            if (r10 <= 0) goto L14;
            long r11 = r10;
            if (r11 > currentRemaining()) goto L14;
            if (this.immutable == false) goto L9;
        L12:
            byte[] r12 = new byte[r10];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, r12, 0, r11);
            this.currentByteBufferPos += r11;
            return ByteBuffer.wrap(r12);
        L9:
            if (this.enableAliasing == false) goto L12;
            long r13 = this.currentByteBufferPos + r11;
            this.currentByteBufferPos = r13;
            long r14 = this.currentAddress;
            return slice((int) ((r13 - r14) - r11), (int) (r13 - r14));
        L14:
            if (r10 > 0) goto L16;
        L19:
            if (r10 == 0) goto L21;
            if (r10 >= 0) goto L26;
            throw InvalidProtocolBufferException.negativeSize();
        L26:
            throw InvalidProtocolBufferException.truncatedMessage();
        L21:
            return Internal.EMPTY_BYTE_BUFFER;
        L16:
            if (r10 > remaining()) goto L19;
            byte[] r15 = new byte[r10];
            readRawBytesTo(r15, 0, r10);
            return ByteBuffer.wrap(r15);
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() {
            int r10 = readRawVarint32();
            if (r10 <= 0) goto L14;
            long r11 = r10;
            long r12 = this.currentByteBufferLimit;
            long r13 = this.currentByteBufferPos;
            if (r11 > (r12 - r13)) goto L14;
            if (this.immutable == true) goto L9;
        L12:
            byte[] r14 = new byte[r10];
            UnsafeUtil.copyMemory(r13, r14, 0, r11);
            this.currentByteBufferPos += r11;
            return ByteString.wrap(r14);
        L9:
            if (this.enableAliasing == false) goto L12;
            int r15 = (int) (r13 - this.currentAddress);
            ByteString r16 = ByteString.wrap(slice(r15, r10 + r15));
            this.currentByteBufferPos += r11;
            return r16;
        L14:
            if (r10 > 0) goto L16;
        L31:
            if (r10 == 0) goto L33;
            if (r10 >= 0) goto L38;
            throw InvalidProtocolBufferException.negativeSize();
        L38:
            throw InvalidProtocolBufferException.truncatedMessage();
        L33:
            return ByteString.EMPTY;
        L16:
            if (r10 > remaining()) goto L31;
            if (this.immutable == true) goto L20;
        L29:
            byte[] r17 = new byte[r10];
            readRawBytesTo(r17, 0, r10);
            return ByteString.wrap(r17);
        L20:
            if (this.enableAliasing == false) goto L29;
            ArrayList r18 = new ArrayList();
        L22:
            if (r10 <= 0) goto L28;
            if (currentRemaining() != 0) goto L26;
            getNextByteBuffer();
        L26:
            int r19 = Math.min(r10, (int) currentRemaining());
            int r20 = (int) (this.currentByteBufferPos - this.currentAddress);
            r18.add(ByteString.wrap(slice(r20, r20 + r19)));
            r10 = r10 - r19;
            this.currentByteBufferPos += (long) r19;
            goto L22
        L28:
            return ByteString.copyFrom(r18);
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int r10, Parser<T> r11, ExtensionRegistryLite r12) {
            checkRecursionLimit();
            this.groupDepth++;
            T r13 = r11.parsePartialFrom(this, r12);
            checkLastTagWas(WireFormat.makeTag(r10, 4));
            this.groupDepth--;
            return r13;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int r10, MessageLite.Builder r11, ExtensionRegistryLite r12) {
            checkRecursionLimit();
            this.groupDepth++;
            r11.mergeFrom(this, r12);
            checkLastTagWas(WireFormat.makeTag(r10, 4));
            this.groupDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> r10, ExtensionRegistryLite r11) {
            int r12 = readRawVarint32();
            checkRecursionLimit();
            int r13 = pushLimit(r12);
            this.messageDepth++;
            T r14 = r10.parsePartialFrom(this, r11);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r13);
            return r14;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder r10, ExtensionRegistryLite r11) {
            int r12 = readRawVarint32();
            checkRecursionLimit();
            int r13 = pushLimit(r12);
            this.messageDepth++;
            r10.mergeFrom(this, r11);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r13);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() {
            if (currentRemaining() != 0) goto L5;
            getNextByteBuffer();
        L5:
            long r10 = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + r10;
            return UnsafeUtil.getByte(r10);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int r10) {
            if (r10 < 0) goto L7;
            long r11 = r10;
            if (r11 > currentRemaining()) goto L7;
            byte[] r12 = new byte[r10];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, r12, 0, r11);
            this.currentByteBufferPos += r11;
            return r12;
        L7:
            if (r10 >= 0) goto L9;
        L12:
            if (r10 > 0) goto L19;
            if (r10 != 0) goto L17;
            return Internal.EMPTY_BYTE_ARRAY;
        L17:
            throw InvalidProtocolBufferException.negativeSize();
        L19:
            throw InvalidProtocolBufferException.truncatedMessage();
        L9:
            if (r10 > remaining()) goto L12;
            byte[] r13 = new byte[r10];
            readRawBytesTo(r13, 0, r10);
            return r13;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            if (currentRemaining() < 4) goto L6;
            long r10 = this.currentByteBufferPos;
            this.currentByteBufferPos = 4 + r10;
            return (((UnsafeUtil.getByte(r10) & 255) | ((UnsafeUtil.getByte(1 + r10) & 255) << 8)) | ((UnsafeUtil.getByte(2 + r10) & 255) << 16)) | ((UnsafeUtil.getByte(r10 + 3) & 255) << 24);
        L6:
            int r11 = ((readRawByte() & 255) | ((readRawByte() & 255) << 8)) | ((readRawByte() & 255) << 16);
            return ((readRawByte() & 255) << 24) | r11;
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            if (currentRemaining() < 8) goto L6;
            long r13 = this.currentByteBufferPos;
            this.currentByteBufferPos = 8 + r13;
            return (((((((((long) UnsafeUtil.getByte(r13)) & 255) | ((((long) UnsafeUtil.getByte(1 + r13)) & 255) << 8)) | ((((long) UnsafeUtil.getByte(2 + r13)) & 255) << 16)) | ((((long) UnsafeUtil.getByte(3 + r13)) & 255) << 24)) | ((((long) UnsafeUtil.getByte(4 + r13)) & 255) << 32)) | ((((long) UnsafeUtil.getByte(5 + r13)) & 255) << 40)) | ((((long) UnsafeUtil.getByte(6 + r13)) & 255) << 48)) | ((((long) UnsafeUtil.getByte(r13 + 7)) & 255) << 56);
        L6:
            long r10 = ((((((((long) readRawByte()) & 255) | ((((long) readRawByte()) & 255) << 8)) | ((((long) readRawByte()) & 255) << 16)) | ((((long) readRawByte()) & 255) << 24)) | ((((long) readRawByte()) & 255) << 32)) | ((((long) readRawByte()) & 255) << 40)) | ((((long) readRawByte()) & 255) << 48);
            return ((((long) readRawByte()) & 255) << 56) | r10;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() {
            long r10 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit == r10) goto L35;
            long r11 = r10 + 1;
            byte r12 = UnsafeUtil.getByte(r10);
            if (r12 < 0) goto L10;
            this.currentByteBufferPos++;
            return r12;
        L10:
            if ((this.currentByteBufferLimit - this.currentByteBufferPos) < 10) goto L35;
            long r13 = r11 + 1;
            int r14 = r12 ^ (UnsafeUtil.getByte(r11) << 7);
            if (r14 >= 0) goto L15;
            int r15 = r14 ^ (-128);
        L36:
            this.currentByteBufferPos = r13;
            return r15;
        L15:
            long r16 = r13 + 1;
            int r17 = r14 ^ (UnsafeUtil.getByte(r13) << 14);
            if (r17 < 0) goto L19;
            r15 = r17 ^ 16256;
        L18:
            r13 = r16;
            goto L36
        L19:
            r13 = r16 + 1;
            int r18 = r17 ^ (UnsafeUtil.getByte(r16) << 21);
            if (r18 >= 0) goto L22;
            r15 = r18 ^ (-2080896);
            goto L36
        L22:
            r16 = r13 + 1;
            byte r19 = UnsafeUtil.getByte(r13);
            r15 = (r18 ^ (r19 << 28)) ^ 266354560;
            if (r19 >= 0) goto L18;
            r13 = r16 + 1;
            if (UnsafeUtil.getByte(r16) >= 0) goto L36;
            r16 = r13 + 1;
            if (UnsafeUtil.getByte(r13) >= 0) goto L18;
            r13 = r16 + 1;
            if (UnsafeUtil.getByte(r16) >= 0) goto L36;
            r16 = r13 + 1;
            if (UnsafeUtil.getByte(r13) >= 0) goto L18;
            r13 = r16 + 1;
            if (UnsafeUtil.getByte(r16) >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() {
            long r10 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit == r10) goto L42;
            long r11 = r10 + 1;
            byte r12 = UnsafeUtil.getByte(r10);
            if (r12 < 0) goto L10;
            this.currentByteBufferPos++;
            return r12;
        L10:
            if ((this.currentByteBufferLimit - this.currentByteBufferPos) < 10) goto L42;
            long r13 = r11 + 1;
            int r14 = r12 ^ (UnsafeUtil.getByte(r11) << 7);
            if (r14 >= 0) goto L16;
            int r15 = r14 ^ (-128);
        L15:
            long r16 = r15;
        L44:
            this.currentByteBufferPos = r13;
            return r16;
        L16:
            long r17 = r13 + 1;
            int r18 = r14 ^ (UnsafeUtil.getByte(r13) << 14);
            if (r18 < 0) goto L20;
            r16 = r18 ^ 16256;
        L19:
            r13 = r17;
            goto L44
        L20:
            r13 = r17 + 1;
            int r19 = r18 ^ (UnsafeUtil.getByte(r17) << 21);
            if (r19 >= 0) goto L23;
            r15 = r19 ^ (-2080896);
            goto L15
        L23:
            r17 = r13 + 1;
            long r20 = ((long) r19) ^ (((long) UnsafeUtil.getByte(r13)) << 28);
            if (r20 < 0) goto L27;
            long r21 = 266354560;
        L26:
            r16 = r20 ^ r21;
            goto L19
        L27:
            long r22 = r17 + 1;
            long r23 = r20 ^ (((long) UnsafeUtil.getByte(r17)) << 35);
            if (r23 >= 0) goto L31;
            long r24 = -34093383808L;
        L30:
            r16 = r23 ^ r24;
            r13 = r22;
            goto L44
        L31:
            r17 = r22 + 1;
            r20 = r23 ^ (((long) UnsafeUtil.getByte(r22)) << 42);
            if (r20 < 0) goto L34;
            r21 = 4363953127296L;
            goto L26
        L34:
            r22 = r17 + 1;
            r23 = r20 ^ (((long) UnsafeUtil.getByte(r17)) << 49);
            if (r23 >= 0) goto L37;
            r24 = -558586000294016L;
            goto L30
        L37:
            r17 = r22 + 1;
            r16 = (r23 ^ (((long) UnsafeUtil.getByte(r22)) << 56)) ^ 71499008037633920L;
            if (r16 >= 0) goto L19;
            long r25 = 1 + r17;
            if (UnsafeUtil.getByte(r17) < 0) goto L42;
            r13 = r25;
        L42:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        long readRawVarint64SlowPath() {
            long r10 = 0;
            int r11 = 0;
        L4:
            if (r11 >= 64) goto L10;
            byte r12 = readRawByte();
            r10 = r10 | (((long) (r12 & ByteCompanionObject.MAX_VALUE)) << r11);
            if ((r12 & 128) == 0) goto L7;
            r11 = r11 + 7;
            goto L4
        L7:
            return r10;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() {
            int r10 = readRawVarint32();
            if (r10 <= 0) goto L8;
            long r11 = r10;
            long r12 = this.currentByteBufferLimit;
            long r13 = this.currentByteBufferPos;
            if (r11 > (r12 - r13)) goto L8;
            byte[] r14 = new byte[r10];
            UnsafeUtil.copyMemory(r13, r14, 0, r11);
            String r15 = new String(r14, Internal.UTF_8);
            this.currentByteBufferPos += r11;
            return r15;
        L8:
            if (r10 > 0) goto L10;
        L13:
            if (r10 != 0) goto L16;
            return "";
        L16:
            if (r10 >= 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (r10 > remaining()) goto L13;
            byte[] r16 = new byte[r10];
            readRawBytesTo(r16, 0, r10);
            return new String(r16, Internal.UTF_8);
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            int r10 = readRawVarint32();
            if (r10 <= 0) goto L8;
            long r11 = r10;
            long r12 = this.currentByteBufferLimit;
            long r13 = this.currentByteBufferPos;
            if (r11 > (r12 - r13)) goto L8;
            String r14 = Utf8.decodeUtf8(this.currentByteBuffer, (int) (r13 - this.currentByteBufferStartPos), r10);
            this.currentByteBufferPos += r11;
            return r14;
        L8:
            if (r10 >= 0) goto L10;
        L13:
            if (r10 != 0) goto L16;
            return "";
        L16:
            if (r10 > 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (r10 > remaining()) goto L13;
            byte[] r15 = new byte[r10];
            readRawBytesTo(r15, 0, r10);
            return Utf8.decodeUtf8(r15, 0, r10);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r10 = readRawVarint32();
            this.lastTag = r10;
            if (WireFormat.getTagFieldNumber(r10) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int r10, MessageLite.Builder r11) {
            readGroup(r10, r11, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r10) {
            int r11 = WireFormat.getTagWireType(r10);
            if (r11 == 0) goto L24;
            if (r11 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r11 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r11 == 3) goto L18;
            if (r11 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r11 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r10), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r10, CodedOutputStream r11) {
            int r12 = WireFormat.getTagWireType(r10);
            if (r12 == 0) goto L24;
            if (r12 != 1) goto L6;
            long r13 = readRawLittleEndian64();
            r11.writeUInt32NoTag(r10);
            r11.writeFixed64NoTag(r13);
            return true;
        L6:
            if (r12 != 2) goto L8;
            ByteString r14 = readBytes();
            r11.writeUInt32NoTag(r10);
            r11.writeBytesNoTag(r14);
            return true;
        L8:
            if (r12 == 3) goto L18;
            if (r12 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r12 != 5) goto L15;
            int r15 = readRawLittleEndian32();
            r11.writeUInt32NoTag(r10);
            r11.writeFixed32NoTag(r15);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            r11.writeUInt32NoTag(r10);
            skipMessage(r11);
            int r16 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r10), 4);
            checkLastTagWas(r16);
            r11.writeUInt32NoTag(r16);
            return true;
        L24:
            long r17 = readInt64();
            r11.writeUInt32NoTag(r10);
            r11.writeUInt64NoTag(r17);
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int r10) {
            if (r10 >= 0) goto L4;
        L11:
            if (r10 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r10 > ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos)) goto L11;
        L5:
            if (r10 <= 0) goto L10;
            if (currentRemaining() != 0) goto L9;
            getNextByteBuffer();
        L9:
            int r11 = Math.min(r10, (int) currentRemaining());
            r10 = r10 - r11;
            this.currentByteBufferPos += (long) r11;
            goto L5
        }
    }

    private static final class StreamDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        private int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        private interface RefillCallback {
            void onRefill();
        }

        private class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos;
            final /* synthetic */ StreamDecoder this$0;

            private SkippedDataSink(StreamDecoder r10) {
                this.this$0 = r10;
                this.lastPos = StreamDecoder.access$500(r10);
            }

            ByteBuffer getSkippedData() {
                ByteArrayOutputStream r10 = this.byteArrayStream;
                if (r10 == null) goto L5;
                r10.write(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0));
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            L5:
                return ByteBuffer.wrap(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0) - this.lastPos);
            }

            @Override // com.google.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.byteArrayStream != null) goto L5;
                this.byteArrayStream = new ByteArrayOutputStream();
            L5:
                this.byteArrayStream.write(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0) - this.lastPos);
                this.lastPos = 0;
            }
        }

        private StreamDecoder(InputStream r10, int r11) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(r10, "input");
            this.input = r10;
            this.buffer = new byte[r11];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        /* synthetic */ StreamDecoder(InputStream r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        static /* synthetic */ int access$500(StreamDecoder r10) {
            return r10.pos;
        }

        static /* synthetic */ byte[] access$600(StreamDecoder r10) {
            return r10.buffer;
        }

        private static int available(InputStream r10) {
            return r10.available();
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private static int read(InputStream r10, byte[] r11, int r12, int r13) {
            return r10.read(r11, r12, r13);
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private ByteString readBytesSlowPath(int r10) {
            byte[] r11 = readRawBytesSlowPathOneChunk(r10);
            if (r11 != null) goto L5;
            int r12 = this.pos;
            int r13 = this.bufferSize;
            int r14 = r13 - r12;
            this.totalBytesRetired += r13;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> r15 = readRawBytesSlowPathRemainingChunks(r10 - r14);
            byte[] r16 = new byte[r10];
            System.arraycopy(this.buffer, r12, r16, 0, r14);
            Iterator<byte[]> r17 = r15.iterator();
        L8:
            if (r17.hasNext() == false) goto L11;
            byte[] r18 = r17.next();
            System.arraycopy(r18, 0, r16, r14, r18.length);
            r14 = r14 + r18.length;
            goto L8
        L11:
            return ByteString.wrap(r16);
        L5:
            return ByteString.copyFrom(r11);
        }

        private byte[] readRawBytesSlowPath(int r10, boolean r11) {
            byte[] r12 = readRawBytesSlowPathOneChunk(r10);
            if (r12 == null) goto L7;
            if (r11 == true) goto L6;
            return r12;
        L6:
            return (byte[]) r12.clone();
        L7:
            int r13 = this.pos;
            int r14 = this.bufferSize;
            int r15 = r14 - r13;
            this.totalBytesRetired += r14;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> r16 = readRawBytesSlowPathRemainingChunks(r10 - r15);
            byte[] r17 = new byte[r10];
            System.arraycopy(this.buffer, r13, r17, 0, r15);
            Iterator<byte[]> r18 = r16.iterator();
        L9:
            if (r18.hasNext() == false) goto L11;
            byte[] r19 = r18.next();
            System.arraycopy(r19, 0, r17, r15, r19.length);
            r15 = r15 + r19.length;
            goto L9
        L11:
            return r17;
        }

        private byte[] readRawBytesSlowPathOneChunk(int r10) {
            if (r10 == 0) goto L4;
            if (r10 < 0) goto L30;
            int r11 = this.totalBytesRetired;
            int r12 = this.pos;
            int r13 = (r11 + r12) + r10;
            if ((r13 - this.sizeLimit) > 0) goto L28;
            int r14 = this.currentLimit;
            if (r13 > r14) goto L25;
            int r15 = this.bufferSize - r12;
            int r16 = r10 - r15;
            if (r16 >= 4096) goto L13;
        L17:
            byte[] r17 = new byte[r10];
            System.arraycopy(this.buffer, this.pos, r17, 0, r15);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
        L18:
            if (r15 >= r10) goto L24;
            int r18 = read(this.input, r17, r15, r10 - r15);
            if (r18 == (-1)) goto L23;
            this.totalBytesRetired += r18;
            r15 = r15 + r18;
            goto L18
        L23:
            throw InvalidProtocolBufferException.truncatedMessage();
        L24:
            return r17;
        L13:
            if (r16 <= available(this.input)) goto L17;
            return null;
        L25:
            skipRawBytes((r14 - r11) - r12);
            throw InvalidProtocolBufferException.truncatedMessage();
        L28:
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L30:
            throw InvalidProtocolBufferException.negativeSize();
        L4:
            return Internal.EMPTY_BYTE_ARRAY;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int r10) {
            ArrayList r11 = new ArrayList();
        L3:
            if (r10 <= 0) goto L12;
            int r12 = Math.min(r10, 4096);
            byte[] r13 = new byte[r12];
            int r14 = 0;
        L5:
            if (r14 >= r12) goto L11;
            int r15 = this.input.read(r13, r14, r12 - r14);
            if (r15 == (-1)) goto L10;
            this.totalBytesRetired += r15;
            r14 = r14 + r15;
            goto L5
        L10:
            throw InvalidProtocolBufferException.truncatedMessage();
        L11:
            r10 = r10 - r12;
            r11.add(r13);
            goto L3
        L12:
            return r11;
        }

        private void recomputeBufferSizeAfterLimit() {
            int r10 = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = r10;
            int r11 = this.totalBytesRetired + r10;
            int r12 = this.currentLimit;
            if (r11 <= r12) goto L5;
            int r13 = r11 - r12;
            this.bufferSizeAfterLimit = r13;
            this.bufferSize = r10 - r13;
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        private void refillBuffer(int r10) {
            if (tryRefillBuffer(r10) == false) goto L5;
            return;
        L5:
            if (r10 <= ((this.sizeLimit - this.totalBytesRetired) - this.pos)) goto L9;
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private static long skip(InputStream r10, long r11) {
            return r10.skip(r11);
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private void skipRawBytesSlowPath(int r10) {
            if (r10 < 0) goto L33;
            int r11 = this.totalBytesRetired;
            int r12 = this.pos;
            int r13 = (r11 + r12) + r10;
            int r14 = this.currentLimit;
            if (r13 > r14) goto L30;
            int r15 = 0;
            if (this.refillCallback != null) goto L23;
            this.totalBytesRetired = r11 + r12;
            int r16 = this.bufferSize - r12;
            this.bufferSize = 0;
            this.pos = 0;
            r15 = r16;
        L8:
            if (r15 >= r10) goto L22;
            long r17 = r10 - r15;
            long r18 = skip(this.input, r17);     // Catch: Throwable -> L19
            if (r18 < 0) goto L18;
            if (r18 > r17) goto L18;
            if (r18 == 0) goto L22;
            r15 = r15 + ((int) r18);     // Catch: Throwable -> L19
        L18:
            throw new IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + r18 + "\nThe InputStream implementation is buggy.");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            this.totalBytesRetired += r15;
            recomputeBufferSizeAfterLimit();
            throw th;
        L22:
            this.totalBytesRetired += r15;
            recomputeBufferSizeAfterLimit();
        L23:
            if (r15 >= r10) goto L41;
            int r19 = this.bufferSize;
            int r20 = r19 - this.pos;
            this.pos = r19;
        L25:
            refillBuffer(1);
            int r21 = r10 - r20;
            int r22 = this.bufferSize;
            if (r21 <= r22) goto L28;
            r20 = r20 + r22;
            this.pos = r22;
            goto L25
        L28:
            this.pos = r21;
            return;
        L41:
            return;
        L30:
            skipRawBytes((r14 - r11) - r12);
            throw InvalidProtocolBufferException.truncatedMessage();
        L33:
            throw InvalidProtocolBufferException.negativeSize();
        }

        private void skipRawVarint() {
            if ((this.bufferSize - this.pos) < 10) goto L5;
            skipRawVarintFastPath();
            return;
        L5:
            skipRawVarintSlowPath();
        }

        private void skipRawVarintFastPath() {
            int r10 = 0;
        L4:
            if (r10 >= 10) goto L10;
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            this.pos = r12 + 1;
            if (r11[r12] >= 0) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() {
            int r10 = 0;
        L4:
            if (r10 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private boolean tryRefillBuffer(int r10) {
            int r11 = this.pos;
            if ((r11 + r10) <= this.bufferSize) goto L35;
            int r12 = this.sizeLimit;
            int r13 = this.totalBytesRetired;
            if (r10 <= ((r12 - r13) - r11)) goto L8;
            return false;
        L8:
            if (((r13 + r11) + r10) <= this.currentLimit) goto L10;
            return false;
        L10:
            RefillCallback r14 = this.refillCallback;
            if (r14 == null) goto L13;
            r14.onRefill();
        L13:
            int r15 = this.pos;
            if (r15 <= 0) goto L19;
            int r16 = this.bufferSize;
            if (r16 <= r15) goto L18;
            byte[] r17 = this.buffer;
            System.arraycopy(r17, r15, r17, 0, r16 - r15);
        L18:
            this.totalBytesRetired += r15;
            this.bufferSize -= r15;
            this.pos = 0;
        L19:
            InputStream r18 = this.input;
            byte[] r19 = this.buffer;
            int r20 = this.bufferSize;
            int r21 = read(r18, r19, r20, Math.min(r19.length - r20, (this.sizeLimit - this.totalBytesRetired) - r20));
            if (r21 == 0) goto L33;
            if (r21 < (-1)) goto L33;
            if (r21 > this.buffer.length) goto L33;
            if (r21 <= 0) goto L31;
            this.bufferSize += r21;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize < r10) goto L30;
            return true;
        L30:
            return tryRefillBuffer(r10);
        L31:
            return false;
        L33:
            throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + r21 + "\nThe InputStream implementation is buggy.");
        L35:
            throw new IllegalStateException("refillBuffer() called when " + r10 + " bytes were already available in buffer");
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int r10) {
            if (this.lastTag != r10) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean r10) {
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r10 = this.currentLimit;
            if (r10 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r10 - (this.totalBytesRetired + this.pos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() {
            if (this.pos == this.bufferSize) goto L5;
        L7:
            return false;
        L5:
            if (tryRefillBuffer(1) == true) goto L7;
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int r10) {
            this.currentLimit = r10;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int r10) {
            if (r10 < 0) goto L14;
            int r11 = r10 + (this.totalBytesRetired + this.pos);
            if (r11 < 0) goto L12;
            int r12 = this.currentLimit;
            if (r11 > r12) goto L10;
            this.currentLimit = r11;
            recomputeBufferSizeAfterLimit();
            return r12;
        L10:
            throw InvalidProtocolBufferException.truncatedMessage();
        L12:
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L14:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() {
            int r10 = readRawVarint32();
            int r11 = this.bufferSize;
            int r12 = this.pos;
            if (r10 > (r11 - r12)) goto L7;
            if (r10 <= 0) goto L7;
            byte[] r13 = Arrays.copyOfRange(this.buffer, r12, r12 + r10);
            this.pos += r10;
            return r13;
        L7:
            if (r10 < 0) goto L11;
            return readRawBytesSlowPath(r10, false);
        L11:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() {
            int r10 = readRawVarint32();
            int r11 = this.bufferSize;
            int r12 = this.pos;
            if (r10 > (r11 - r12)) goto L7;
            if (r10 <= 0) goto L7;
            ByteBuffer r13 = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, r12, r12 + r10));
            this.pos += r10;
            return r13;
        L7:
            if (r10 == 0) goto L9;
            if (r10 < 0) goto L14;
            return ByteBuffer.wrap(readRawBytesSlowPath(r10, true));
        L14:
            throw InvalidProtocolBufferException.negativeSize();
        L9:
            return Internal.EMPTY_BYTE_BUFFER;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() {
            int r10 = readRawVarint32();
            int r11 = this.bufferSize;
            int r12 = this.pos;
            if (r10 > (r11 - r12)) goto L7;
            if (r10 <= 0) goto L7;
            ByteString r13 = ByteString.copyFrom(this.buffer, r12, r10);
            this.pos += r10;
            return r13;
        L7:
            if (r10 == 0) goto L9;
            if (r10 < 0) goto L14;
            return readBytesSlowPath(r10);
        L14:
            throw InvalidProtocolBufferException.negativeSize();
        L9:
            return ByteString.EMPTY;
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int r10, Parser<T> r11, ExtensionRegistryLite r12) {
            checkRecursionLimit();
            this.groupDepth++;
            T r13 = r11.parsePartialFrom(this, r12);
            checkLastTagWas(WireFormat.makeTag(r10, 4));
            this.groupDepth--;
            return r13;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int r10, MessageLite.Builder r11, ExtensionRegistryLite r12) {
            checkRecursionLimit();
            this.groupDepth++;
            r11.mergeFrom(this, r12);
            checkLastTagWas(WireFormat.makeTag(r10, 4));
            this.groupDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> r10, ExtensionRegistryLite r11) {
            int r12 = readRawVarint32();
            checkRecursionLimit();
            int r13 = pushLimit(r12);
            this.messageDepth++;
            T r14 = r10.parsePartialFrom(this, r11);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r13);
            return r14;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder r10, ExtensionRegistryLite r11) {
            int r12 = readRawVarint32();
            checkRecursionLimit();
            int r13 = pushLimit(r12);
            this.messageDepth++;
            r10.mergeFrom(this, r11);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r13);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() {
            if (this.pos != this.bufferSize) goto L5;
            refillBuffer(1);
        L5:
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 + 1;
            return r10[r11];
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int r10) {
            int r11 = this.pos;
            if (r10 > (this.bufferSize - r11)) goto L8;
            if (r10 <= 0) goto L8;
            int r12 = r10 + r11;
            this.pos = r12;
            return Arrays.copyOfRange(this.buffer, r11, r12);
        L8:
            return readRawBytesSlowPath(r10, false);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            int r10 = this.pos;
            if ((this.bufferSize - r10) >= 4) goto L5;
            refillBuffer(4);
            r10 = this.pos;
        L5:
            byte[] r11 = this.buffer;
            this.pos = r10 + 4;
            return (((r11[r10] & 255) | ((r11[r10 + 1] & 255) << 8)) | ((r11[r10 + 2] & 255) << 16)) | ((r11[r10 + 3] & 255) << 24);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            int r10 = this.pos;
            if ((this.bufferSize - r10) >= 8) goto L5;
            refillBuffer(8);
            r10 = this.pos;
        L5:
            byte[] r11 = this.buffer;
            this.pos = r10 + 8;
            long r12 = ((((((((long) r11[r10]) & 255) | ((((long) r11[r10 + 1]) & 255) << 8)) | ((((long) r11[r10 + 2]) & 255) << 16)) | ((((long) r11[r10 + 3]) & 255) << 24)) | ((((long) r11[r10 + 4]) & 255) << 32)) | ((((long) r11[r10 + 5]) & 255) << 40)) | ((((long) r11[r10 + 6]) & 255) << 48);
            return ((((long) r11[r10 + 7]) & 255) << 56) | r12;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() {
            int r10 = this.pos;
            int r11 = this.bufferSize;
            if (r11 == r10) goto L35;
            byte[] r12 = this.buffer;
            int r13 = r10 + 1;
            byte r14 = r12[r10];
            if (r14 < 0) goto L10;
            this.pos = r13;
            return r14;
        L10:
            if ((r11 - r13) < 9) goto L35;
            int r15 = r13 + 1;
            int r16 = r14 ^ (r12[r13] << 7);
            if (r16 >= 0) goto L15;
            int r17 = r16 ^ (-128);
        L36:
            this.pos = r15;
            return r17;
        L15:
            int r18 = r15 + 1;
            int r19 = r16 ^ (r12[r15] << 14);
            if (r19 < 0) goto L19;
            r17 = r19 ^ 16256;
        L18:
            r15 = r18;
            goto L36
        L19:
            r15 = r18 + 1;
            int r20 = r19 ^ (r12[r18] << 21);
            if (r20 >= 0) goto L22;
            r17 = r20 ^ (-2080896);
            goto L36
        L22:
            r18 = r15 + 1;
            byte r21 = r12[r15];
            r17 = (r20 ^ (r21 << 28)) ^ 266354560;
            if (r21 >= 0) goto L18;
            r15 = r18 + 1;
            if (r12[r18] >= 0) goto L36;
            r18 = r15 + 1;
            if (r12[r15] >= 0) goto L18;
            r15 = r18 + 1;
            if (r12[r18] >= 0) goto L36;
            r18 = r15 + 1;
            if (r12[r15] >= 0) goto L18;
            r15 = r18 + 1;
            if (r12[r18] >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() {
            int r10 = this.pos;
            int r11 = this.bufferSize;
            if (r11 == r10) goto L41;
            byte[] r12 = this.buffer;
            int r13 = r10 + 1;
            byte r14 = r12[r10];
            if (r14 < 0) goto L10;
            this.pos = r13;
            return r14;
        L10:
            if ((r11 - r13) < 9) goto L41;
            int r15 = r13 + 1;
            int r16 = r14 ^ (r12[r13] << 7);
            if (r16 >= 0) goto L16;
            int r17 = r16 ^ (-128);
        L15:
            long r18 = r17;
        L44:
            this.pos = r15;
            return r18;
        L16:
            int r19 = r15 + 1;
            int r20 = r16 ^ (r12[r15] << 14);
            if (r20 < 0) goto L19;
            r15 = r19;
            r18 = r20 ^ 16256;
            goto L44
        L19:
            r15 = r19 + 1;
            int r21 = r20 ^ (r12[r19] << 21);
            if (r21 >= 0) goto L22;
            r17 = r21 ^ (-2080896);
            goto L15
        L22:
            long r22 = r21;
            int r23 = r15 + 1;
            long r24 = r22 ^ (((long) r12[r15]) << 28);
            if (r24 < 0) goto L26;
            long r25 = 266354560;
        L25:
            r18 = r24 ^ r25;
            r15 = r23;
            goto L44
        L26:
            r15 = r23 + 1;
            long r26 = r24 ^ (((long) r12[r23]) << 35);
            if (r26 >= 0) goto L30;
            long r27 = -34093383808L;
        L29:
            r18 = r26 ^ r27;
            goto L44
        L30:
            r23 = r15 + 1;
            r24 = r26 ^ (((long) r12[r15]) << 42);
            if (r24 < 0) goto L33;
            r25 = 4363953127296L;
            goto L25
        L33:
            r15 = r23 + 1;
            r26 = r24 ^ (((long) r12[r23]) << 49);
            if (r26 >= 0) goto L36;
            r27 = -558586000294016L;
            goto L29
        L36:
            int r28 = r15 + 1;
            long r29 = (r26 ^ (((long) r12[r15]) << 56)) ^ 71499008037633920L;
            if (r29 >= 0) goto L42;
            r15 = r28 + 1;
            if (r12[r28] < 0) goto L41;
        L43:
            r18 = r29;
            goto L44
        L42:
            r15 = r28;
        L41:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        long readRawVarint64SlowPath() {
            long r10 = 0;
            int r11 = 0;
        L4:
            if (r11 >= 64) goto L10;
            byte r12 = readRawByte();
            r10 = r10 | (((long) (r12 & ByteCompanionObject.MAX_VALUE)) << r11);
            if ((r12 & 128) == 0) goto L7;
            r11 = r11 + 7;
            goto L4
        L7:
            return r10;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() {
            int r10 = readRawVarint32();
            if (r10 <= 0) goto L8;
            int r11 = this.bufferSize;
            int r12 = this.pos;
            if (r10 > (r11 - r12)) goto L8;
            String r13 = new String(this.buffer, r12, r10, Internal.UTF_8);
            this.pos += r10;
            return r13;
        L8:
            if (r10 != 0) goto L11;
            return "";
        L11:
            if (r10 < 0) goto L19;
            if (r10 > this.bufferSize) goto L17;
            refillBuffer(r10);
            String r14 = new String(this.buffer, this.pos, r10, Internal.UTF_8);
            this.pos += r10;
            return r14;
        L17:
            return new String(readRawBytesSlowPath(r10, false), Internal.UTF_8);
        L19:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            int r10 = readRawVarint32();
            int r11 = this.pos;
            int r12 = this.bufferSize;
            if (r10 > (r12 - r11)) goto L6;
            if (r10 <= 0) goto L6;
            byte[] r13 = this.buffer;
            this.pos = r11 + r10;
        L15:
            return Utf8.decodeUtf8(r13, r11, r10);
        L6:
            if (r10 != 0) goto L9;
            return "";
        L9:
            if (r10 < 0) goto L17;
            if (r10 > r12) goto L12;
            refillBuffer(r10);
            r13 = this.buffer;
            this.pos = r10 + 0;
        L13:
            r11 = 0;
            goto L15
        L12:
            r13 = readRawBytesSlowPath(r10, false);
            goto L13
        L17:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r10 = readRawVarint32();
            this.lastTag = r10;
            if (WireFormat.getTagFieldNumber(r10) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int r10, MessageLite.Builder r11) {
            readGroup(r10, r11, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r10) {
            int r11 = WireFormat.getTagWireType(r10);
            if (r11 == 0) goto L24;
            if (r11 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r11 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r11 == 3) goto L18;
            if (r11 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r11 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r10), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r10, CodedOutputStream r11) {
            int r12 = WireFormat.getTagWireType(r10);
            if (r12 == 0) goto L24;
            if (r12 != 1) goto L6;
            long r13 = readRawLittleEndian64();
            r11.writeUInt32NoTag(r10);
            r11.writeFixed64NoTag(r13);
            return true;
        L6:
            if (r12 != 2) goto L8;
            ByteString r14 = readBytes();
            r11.writeUInt32NoTag(r10);
            r11.writeBytesNoTag(r14);
            return true;
        L8:
            if (r12 == 3) goto L18;
            if (r12 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r12 != 5) goto L15;
            int r15 = readRawLittleEndian32();
            r11.writeUInt32NoTag(r10);
            r11.writeFixed32NoTag(r15);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            r11.writeUInt32NoTag(r10);
            skipMessage(r11);
            int r16 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r10), 4);
            checkLastTagWas(r16);
            r11.writeUInt32NoTag(r16);
            return true;
        L24:
            long r17 = readInt64();
            r11.writeUInt32NoTag(r10);
            r11.writeUInt64NoTag(r17);
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int r10) {
            int r11 = this.bufferSize;
            int r12 = this.pos;
            if (r10 > (r11 - r12)) goto L6;
            if (r10 < 0) goto L6;
            this.pos = r12 + r10;
            return;
        L6:
            skipRawBytesSlowPath(r10);
        }
    }

    private static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        private UnsafeDirectNioDecoder(ByteBuffer r10, boolean r11) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = r10.duplicate();
            long r12 = UnsafeUtil.addressOffset(r10);
            this.address = r12;
            this.limit = ((long) r10.limit()) + r12;
            long r13 = r12 + ((long) r10.position());
            this.pos = r13;
            this.startPos = r13;
            this.immutable = r11;
        }

        /* synthetic */ UnsafeDirectNioDecoder(ByteBuffer r10, boolean r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private int bufferPos(long r10) {
            return (int) (r10 - this.address);
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void recomputeBufferSizeAfterLimit() {
            long r10 = this.limit + ((long) this.bufferSizeAfterLimit);
            this.limit = r10;
            int r11 = (int) (r10 - this.startPos);
            int r12 = this.currentLimit;
            if (r11 <= r12) goto L5;
            int r13 = r11 - r12;
            this.bufferSizeAfterLimit = r13;
            this.limit = r10 - ((long) r13);
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private void skipRawVarint() {
            if (remaining() < 10) goto L5;
            skipRawVarintFastPath();
            return;
        L5:
            skipRawVarintSlowPath();
        }

        private void skipRawVarintFastPath() {
            int r10 = 0;
        L4:
            if (r10 >= 10) goto L10;
            long r11 = this.pos;
            this.pos = 1 + r11;
            if (UnsafeUtil.getByte(r11) >= 0) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() {
            int r10 = 0;
        L4:
            if (r10 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(long r10, long r11) {
            int r12 = this.buffer.position();
            int r13 = this.buffer.limit();
            ByteBuffer r14 = this.buffer;
            r14.position(bufferPos(r10));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r14.limit(bufferPos(r11));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            ByteBuffer r15 = this.buffer.slice();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r14.position(r12);
            r14.limit(r13);
            return r15;
        L8:
            e = move-exception;
            InvalidProtocolBufferException r16 = InvalidProtocolBufferException.truncatedMessage();     // Catch: Throwable -> L6
            r16.initCause(e);     // Catch: Throwable -> L6
            throw r16;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            r14.position(r12);
            r14.limit(r13);
            throw th;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int r10) {
            if (this.lastTag != r10) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean r10) {
            this.enableAliasing = r10;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r10 = this.currentLimit;
            if (r10 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r10 - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() {
            if (this.pos != this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int r10) {
            this.currentLimit = r10;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int r10) {
            if (r10 < 0) goto L10;
            int r11 = r10 + getTotalBytesRead();
            int r12 = this.currentLimit;
            if (r11 > r12) goto L8;
            this.currentLimit = r11;
            recomputeBufferSizeAfterLimit();
            return r12;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() {
            int r10 = readRawVarint32();
            if (r10 > 0) goto L5;
        L14:
            if (r10 == 0) goto L16;
            if (r10 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return Internal.EMPTY_BYTE_BUFFER;
        L5:
            if (r10 > remaining()) goto L14;
            if (this.immutable == false) goto L9;
        L12:
            byte[] r11 = new byte[r10];
            long r12 = r10;
            UnsafeUtil.copyMemory(this.pos, r11, 0, r12);
            this.pos += r12;
            return ByteBuffer.wrap(r11);
        L9:
            if (this.enableAliasing == false) goto L12;
            long r13 = this.pos;
            long r14 = r10;
            ByteBuffer r15 = slice(r13, r13 + r14);
            this.pos += r14;
            return r15;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() {
            int r10 = readRawVarint32();
            if (r10 > 0) goto L5;
        L14:
            if (r10 == 0) goto L16;
            if (r10 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return ByteString.EMPTY;
        L5:
            if (r10 > remaining()) goto L14;
            if (this.immutable == true) goto L9;
        L12:
            byte[] r11 = new byte[r10];
            long r12 = r10;
            UnsafeUtil.copyMemory(this.pos, r11, 0, r12);
            this.pos += r12;
            return ByteString.wrap(r11);
        L9:
            if (this.enableAliasing == false) goto L12;
            long r13 = this.pos;
            long r14 = r10;
            ByteBuffer r15 = slice(r13, r13 + r14);
            this.pos += r14;
            return ByteString.wrap(r15);
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int r10, Parser<T> r11, ExtensionRegistryLite r12) {
            checkRecursionLimit();
            this.groupDepth++;
            T r13 = r11.parsePartialFrom(this, r12);
            checkLastTagWas(WireFormat.makeTag(r10, 4));
            this.groupDepth--;
            return r13;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int r10, MessageLite.Builder r11, ExtensionRegistryLite r12) {
            checkRecursionLimit();
            this.groupDepth++;
            r11.mergeFrom(this, r12);
            checkLastTagWas(WireFormat.makeTag(r10, 4));
            this.groupDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> r10, ExtensionRegistryLite r11) {
            int r12 = readRawVarint32();
            checkRecursionLimit();
            int r13 = pushLimit(r12);
            this.messageDepth++;
            T r14 = r10.parsePartialFrom(this, r11);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r13);
            return r14;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder r10, ExtensionRegistryLite r11) {
            int r12 = readRawVarint32();
            checkRecursionLimit();
            int r13 = pushLimit(r12);
            this.messageDepth++;
            r10.mergeFrom(this, r11);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r13);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() {
            long r10 = this.pos;
            if (r10 == this.limit) goto L7;
            this.pos = 1 + r10;
            return UnsafeUtil.getByte(r10);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int r10) {
            if (r10 >= 0) goto L4;
        L7:
            if (r10 > 0) goto L14;
            if (r10 != 0) goto L12;
            return Internal.EMPTY_BYTE_ARRAY;
        L12:
            throw InvalidProtocolBufferException.negativeSize();
        L14:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r10 > remaining()) goto L7;
            byte[] r11 = new byte[r10];
            long r12 = this.pos;
            long r13 = r10;
            slice(r12, r12 + r13).get(r11);
            this.pos += r13;
            return r11;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            long r10 = this.pos;
            if ((this.limit - r10) < 4) goto L7;
            this.pos = 4 + r10;
            return (((UnsafeUtil.getByte(r10) & 255) | ((UnsafeUtil.getByte(1 + r10) & 255) << 8)) | ((UnsafeUtil.getByte(2 + r10) & 255) << 16)) | ((UnsafeUtil.getByte(r10 + 3) & 255) << 24);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            long r10 = this.pos;
            if ((this.limit - r10) < 8) goto L7;
            this.pos = 8 + r10;
            long r11 = ((((((((long) UnsafeUtil.getByte(r10)) & 255) | ((((long) UnsafeUtil.getByte(1 + r10)) & 255) << 8)) | ((((long) UnsafeUtil.getByte(2 + r10)) & 255) << 16)) | ((((long) UnsafeUtil.getByte(3 + r10)) & 255) << 24)) | ((((long) UnsafeUtil.getByte(4 + r10)) & 255) << 32)) | ((((long) UnsafeUtil.getByte(5 + r10)) & 255) << 40)) | ((((long) UnsafeUtil.getByte(6 + r10)) & 255) << 48);
            return ((((long) UnsafeUtil.getByte(r10 + 7)) & 255) << 56) | r11;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() {
            long r10 = this.pos;
            if (this.limit == r10) goto L35;
            long r11 = r10 + 1;
            byte r12 = UnsafeUtil.getByte(r10);
            if (r12 < 0) goto L10;
            this.pos = r11;
            return r12;
        L10:
            if ((this.limit - r11) < 9) goto L35;
            long r13 = r11 + 1;
            int r14 = r12 ^ (UnsafeUtil.getByte(r11) << 7);
            if (r14 >= 0) goto L15;
            int r15 = r14 ^ (-128);
        L36:
            this.pos = r13;
            return r15;
        L15:
            long r16 = r13 + 1;
            int r17 = r14 ^ (UnsafeUtil.getByte(r13) << 14);
            if (r17 < 0) goto L19;
            r15 = r17 ^ 16256;
        L18:
            r13 = r16;
            goto L36
        L19:
            r13 = r16 + 1;
            int r18 = r17 ^ (UnsafeUtil.getByte(r16) << 21);
            if (r18 >= 0) goto L22;
            r15 = r18 ^ (-2080896);
            goto L36
        L22:
            r16 = r13 + 1;
            byte r19 = UnsafeUtil.getByte(r13);
            r15 = (r18 ^ (r19 << 28)) ^ 266354560;
            if (r19 >= 0) goto L18;
            r13 = r16 + 1;
            if (UnsafeUtil.getByte(r16) >= 0) goto L36;
            r16 = r13 + 1;
            if (UnsafeUtil.getByte(r13) >= 0) goto L18;
            r13 = r16 + 1;
            if (UnsafeUtil.getByte(r16) >= 0) goto L36;
            r16 = r13 + 1;
            if (UnsafeUtil.getByte(r13) >= 0) goto L18;
            r13 = r16 + 1;
            if (UnsafeUtil.getByte(r16) >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() {
            long r10 = this.pos;
            if (this.limit == r10) goto L42;
            long r11 = r10 + 1;
            byte r12 = UnsafeUtil.getByte(r10);
            if (r12 < 0) goto L10;
            this.pos = r11;
            return r12;
        L10:
            if ((this.limit - r11) < 9) goto L42;
            long r13 = r11 + 1;
            int r14 = r12 ^ (UnsafeUtil.getByte(r11) << 7);
            if (r14 >= 0) goto L16;
            int r15 = r14 ^ (-128);
        L15:
            long r16 = r15;
        L44:
            this.pos = r13;
            return r16;
        L16:
            long r17 = r13 + 1;
            int r18 = r14 ^ (UnsafeUtil.getByte(r13) << 14);
            if (r18 < 0) goto L20;
            r16 = r18 ^ 16256;
        L19:
            r13 = r17;
            goto L44
        L20:
            r13 = r17 + 1;
            int r19 = r18 ^ (UnsafeUtil.getByte(r17) << 21);
            if (r19 >= 0) goto L23;
            r15 = r19 ^ (-2080896);
            goto L15
        L23:
            r17 = r13 + 1;
            long r20 = ((long) r19) ^ (((long) UnsafeUtil.getByte(r13)) << 28);
            if (r20 < 0) goto L27;
            long r21 = 266354560;
        L26:
            r16 = r20 ^ r21;
            goto L19
        L27:
            long r22 = r17 + 1;
            long r23 = r20 ^ (((long) UnsafeUtil.getByte(r17)) << 35);
            if (r23 >= 0) goto L31;
            long r24 = -34093383808L;
        L30:
            r16 = r23 ^ r24;
            r13 = r22;
            goto L44
        L31:
            r17 = r22 + 1;
            r20 = r23 ^ (((long) UnsafeUtil.getByte(r22)) << 42);
            if (r20 < 0) goto L34;
            r21 = 4363953127296L;
            goto L26
        L34:
            r22 = r17 + 1;
            r23 = r20 ^ (((long) UnsafeUtil.getByte(r17)) << 49);
            if (r23 >= 0) goto L37;
            r24 = -558586000294016L;
            goto L30
        L37:
            r17 = r22 + 1;
            r16 = (r23 ^ (((long) UnsafeUtil.getByte(r22)) << 56)) ^ 71499008037633920L;
            if (r16 >= 0) goto L19;
            long r25 = 1 + r17;
            if (UnsafeUtil.getByte(r17) < 0) goto L42;
            r13 = r25;
        L42:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        long readRawVarint64SlowPath() {
            long r10 = 0;
            int r11 = 0;
        L4:
            if (r11 >= 64) goto L10;
            byte r12 = readRawByte();
            r10 = r10 | (((long) (r12 & ByteCompanionObject.MAX_VALUE)) << r11);
            if ((r12 & 128) == 0) goto L7;
            r11 = r11 + 7;
            goto L4
        L7:
            return r10;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() {
            int r10 = readRawVarint32();
            if (r10 > 0) goto L5;
        L8:
            if (r10 != 0) goto L11;
            return "";
        L11:
            if (r10 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r10 > remaining()) goto L8;
            byte[] r11 = new byte[r10];
            long r12 = r10;
            UnsafeUtil.copyMemory(this.pos, r11, 0, r12);
            String r13 = new String(r11, Internal.UTF_8);
            this.pos += r12;
            return r13;
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            int r10 = readRawVarint32();
            if (r10 > 0) goto L5;
        L8:
            if (r10 != 0) goto L11;
            return "";
        L11:
            if (r10 > 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r10 > remaining()) goto L8;
            String r11 = Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), r10);
            this.pos += (long) r10;
            return r11;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r10 = readRawVarint32();
            this.lastTag = r10;
            if (WireFormat.getTagFieldNumber(r10) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int r10, MessageLite.Builder r11) {
            readGroup(r10, r11, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r10) {
            int r11 = WireFormat.getTagWireType(r10);
            if (r11 == 0) goto L24;
            if (r11 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r11 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r11 == 3) goto L18;
            if (r11 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r11 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r10), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r10, CodedOutputStream r11) {
            int r12 = WireFormat.getTagWireType(r10);
            if (r12 == 0) goto L24;
            if (r12 != 1) goto L6;
            long r13 = readRawLittleEndian64();
            r11.writeUInt32NoTag(r10);
            r11.writeFixed64NoTag(r13);
            return true;
        L6:
            if (r12 != 2) goto L8;
            ByteString r14 = readBytes();
            r11.writeUInt32NoTag(r10);
            r11.writeBytesNoTag(r14);
            return true;
        L8:
            if (r12 == 3) goto L18;
            if (r12 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r12 != 5) goto L15;
            int r15 = readRawLittleEndian32();
            r11.writeUInt32NoTag(r10);
            r11.writeFixed32NoTag(r15);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            r11.writeUInt32NoTag(r10);
            skipMessage(r11);
            int r16 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r10), 4);
            checkLastTagWas(r16);
            r11.writeUInt32NoTag(r16);
            return true;
        L24:
            long r17 = readInt64();
            r11.writeUInt32NoTag(r10);
            r11.writeUInt64NoTag(r17);
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int r10) {
            if (r10 >= 0) goto L4;
        L7:
            if (r10 >= 0) goto L11;
            throw InvalidProtocolBufferException.negativeSize();
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r10 > remaining()) goto L7;
            this.pos += (long) r10;
        }
    }

    static {
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    /* synthetic */ CodedInputStream(AnonymousClass1 r10) {
        this();
    }

    public static int decodeZigZag32(int r10) {
        int r11 = r10 >>> 1;
        return (-(r10 & 1)) ^ r11;
    }

    public static long decodeZigZag64(long r10) {
        long r11 = r10 >>> 1;
        return (-(r10 & 1)) ^ r11;
    }

    public static CodedInputStream newInstance(InputStream r10) {
        return newInstance(r10, 4096);
    }

    public static CodedInputStream newInstance(InputStream r10, int r11) {
        if (r11 <= 0) goto L9;
        if (r10 != null) goto L7;
        return newInstance(Internal.EMPTY_BYTE_ARRAY);
    L7:
        return new StreamDecoder(r10, r11, null);
    L9:
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> r10) {
        if (UnsafeDirectNioDecoder.isSupported() == true) goto L7;
        return newInstance(new IterableByteBufferInputStream(r10));
    L7:
        return newInstance(r10, false);
    }

    static CodedInputStream newInstance(Iterable<ByteBuffer> r10, boolean r11) {
        Iterator<ByteBuffer> r12 = r10.iterator();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r12.hasNext() == false) goto L13;
        ByteBuffer r15 = r12.next();
        r14 = r14 + r15.remaining();
        if (r15.hasArray() == true) goto L7;
        if (r15.isDirect() == true) goto L10;
        r13 = r13 | 4;
        goto L4
    L10:
        r13 = r13 | 2;
        goto L4
    L7:
        r13 = r13 | 1;
        goto L4
    L13:
        if (r13 != 2) goto L17;
        return new IterableDirectByteBufferDecoder(r10, r14, r11, null);
    L17:
        return newInstance(new IterableByteBufferInputStream(r10));
    }

    public static CodedInputStream newInstance(ByteBuffer r10) {
        return newInstance(r10, false);
    }

    static CodedInputStream newInstance(ByteBuffer r10, boolean r11) {
        if (r10.hasArray() == false) goto L7;
        return newInstance(r10.array(), r10.arrayOffset() + r10.position(), r10.remaining(), r11);
    L7:
        if (r10.isDirect() == true) goto L9;
    L12:
        int r12 = r10.remaining();
        byte[] r13 = new byte[r12];
        r10.duplicate().get(r13);
        return newInstance(r13, 0, r12, true);
    L9:
        if (UnsafeDirectNioDecoder.isSupported() == false) goto L12;
        return new UnsafeDirectNioDecoder(r10, r11, null);
    }

    public static CodedInputStream newInstance(byte[] r10) {
        return newInstance(r10, 0, r10.length);
    }

    public static CodedInputStream newInstance(byte[] r10, int r11, int r12) {
        return newInstance(r10, r11, r12, false);
    }

    static CodedInputStream newInstance(byte[] r10, int r11, int r12, boolean r13) {
        ArrayDecoder r14 = new ArrayDecoder(r10, r11, r12, r13, null);
        r14.pushLimit(r12);     // Catch: InvalidProtocolBufferException -> L5
        return r14;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static int readRawVarint32(int r10, InputStream r11) {
        if ((r10 & 128) != 0) goto L5;
        return r10;
    L5:
        int r12 = r10 & 127;
        int r13 = 7;
    L7:
        if (r13 >= 32) goto L17;
        int r14 = r11.read();
        if (r14 == (-1)) goto L15;
        r12 = r12 | ((r14 & 127) << r13);
        if ((r14 & 128) == 0) goto L12;
        r13 = r13 + 7;
        goto L7
    L12:
        return r12;
    L15:
        throw InvalidProtocolBufferException.truncatedMessage();
    L17:
        if (r13 >= 64) goto L27;
        int r15 = r11.read();
        if (r15 == (-1)) goto L25;
        if ((r15 & 128) == 0) goto L22;
        r13 = r13 + 7;
        goto L17
    L22:
        return r12;
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(InputStream r10) {
        int r11 = r10.read();
        if (r11 == (-1)) goto L7;
        return readRawVarint32(r11, r10);
    L7:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public abstract void checkLastTagWas(int r10);

    public void checkRecursionLimit() {
        if ((this.messageDepth + this.groupDepth) >= this.recursionLimit) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public void checkValidEndTag() {
        if (this.groupDepth != 0) goto L6;
        checkLastTagWas(0);
        return;
    }

    final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    public abstract void enableAliasing(boolean r10);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd();

    public abstract void popLimit(int r10);

    public abstract int pushLimit(int r10);

    public abstract boolean readBool();

    public abstract byte[] readByteArray();

    public abstract ByteBuffer readByteBuffer();

    public abstract ByteString readBytes();

    public abstract double readDouble();

    public abstract int readEnum();

    public abstract int readFixed32();

    public abstract long readFixed64();

    public abstract float readFloat();

    public abstract <T extends MessageLite> T readGroup(int r10, Parser<T> r11, ExtensionRegistryLite r12);

    public abstract void readGroup(int r10, MessageLite.Builder r11, ExtensionRegistryLite r12);

    public abstract int readInt32();

    public abstract long readInt64();

    public abstract <T extends MessageLite> T readMessage(Parser<T> r10, ExtensionRegistryLite r11);

    public abstract void readMessage(MessageLite.Builder r10, ExtensionRegistryLite r11);

    public abstract byte readRawByte();

    public abstract byte[] readRawBytes(int r10);

    public abstract int readRawLittleEndian32();

    public abstract long readRawLittleEndian64();

    public abstract int readRawVarint32();

    public abstract long readRawVarint64();

    abstract long readRawVarint64SlowPath();

    public abstract int readSFixed32();

    public abstract long readSFixed64();

    public abstract int readSInt32();

    public abstract long readSInt64();

    public abstract String readString();

    public abstract String readStringRequireUtf8();

    public abstract int readTag();

    public abstract int readUInt32();

    public abstract long readUInt64();

    @Deprecated
    public abstract void readUnknownGroup(int r10, MessageLite.Builder r11);

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int r10) {
        if (r10 < 0) goto L6;
        int r11 = this.recursionLimit;
        this.recursionLimit = r10;
        return r11;
    L6:
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + r10);
    }

    public final int setSizeLimit(int r10) {
        if (r10 < 0) goto L6;
        int r11 = this.sizeLimit;
        this.sizeLimit = r10;
        return r11;
    L6:
        throw new IllegalArgumentException("Size limit cannot be negative: " + r10);
    }

    final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public abstract boolean skipField(int r10);

    @Deprecated
    public abstract boolean skipField(int r10, CodedOutputStream r11);

    public void skipMessage() {
    L2:
        int r10 = readTag();
        if (r10 == 0) goto L4;
        checkRecursionLimit();
        this.groupDepth++;
        boolean r11 = skipField(r10);
        this.groupDepth--;
        if (r11 == true) goto L2;
        return;
    }

    public void skipMessage(CodedOutputStream r10) {
    L2:
        int r11 = readTag();
        if (r11 == 0) goto L4;
        checkRecursionLimit();
        this.groupDepth++;
        boolean r12 = skipField(r11, r10);
        this.groupDepth--;
        if (r12 == true) goto L2;
        return;
    }

    public abstract void skipRawBytes(int r10);

    final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }
}
