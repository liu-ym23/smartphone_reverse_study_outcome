package com.google.protobuf;

import com.qualcomm.qti.qesdk.QesdkUtils;
import com.sdk.bwdl.StateMachine.BWDLCommandBuilder;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int groupDepth;
    int messageDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    Object wrapper;

    /* JADX INFO: renamed from: com.google.protobuf.CodedInputStream$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$Utf8Validation = null;

        static {
            int[] r8 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r8;
            r8[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L77:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L55:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L71:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L79:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L59:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L63:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L89:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
        L51:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 9;     // Catch: NoSuchFieldError -> L36
        L83:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L37
        L85:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L38
        L65:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L39
        L73:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L40
        L53:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;     // Catch: NoSuchFieldError -> L41
        L61:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;     // Catch: NoSuchFieldError -> L42
        L87:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 16;     // Catch: NoSuchFieldError -> L43
        L49:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L44
        L81:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;     // Catch: NoSuchFieldError -> L45
        L23:
            int[] r10 = new int[WireFormat.Utf8Validation.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$Utf8Validation = r10;
            r10[WireFormat.Utf8Validation.LOOSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L46
        L69:
            $SwitchMap$com$google$protobuf$WireFormat$Utf8Validation[WireFormat.Utf8Validation.STRICT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L47
        L75:
            $SwitchMap$com$google$protobuf$WireFormat$Utf8Validation[WireFormat.Utf8Validation.LAZY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L48
            return;
        }
    }

    public static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private ArrayDecoder(byte[] r8, int r10, int r11, boolean r12) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = r8;
            this.limit = r11 + r10;
            this.pos = r10;
            this.startPos = r10;
            this.immutable = r12;
        }

        private void recomputeBufferSizeAfterLimit() {
            int r8 = this.limit + this.bufferSizeAfterLimit;
            this.limit = r8;
            int r10 = r8 - this.startPos;
            int r11 = this.currentLimit;
            if (r10 <= r11) goto L5;
            int r12 = r10 - r11;
            this.bufferSizeAfterLimit = r12;
            this.limit = r8 - r12;
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
            int r8 = 0;
        L4:
            if (r8 >= 10) goto L10;
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 + 1;
            if (r10[r11] >= 0) goto L7;
            r8 = r8 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() {
            int r8 = 0;
        L4:
            if (r8 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r8 = r8 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int r8) {
            if (this.lastTag != r8) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean r8) {
            this.enableAliasing = r8;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r8 = this.currentLimit;
            if (r8 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r8 - getTotalBytesRead();
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
        public void popLimit(int r8) {
            this.currentLimit = r8;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int r8) {
            if (r8 < 0) goto L14;
            int r10 = r8 + getTotalBytesRead();
            if (r10 < 0) goto L12;
            int r11 = this.currentLimit;
            if (r10 > r11) goto L10;
            this.currentLimit = r10;
            recomputeBufferSizeAfterLimit();
            return r11;
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
            int r8 = readRawVarint32();
            if (r8 <= 0) goto L14;
            int r10 = this.limit;
            int r11 = this.pos;
            if (r8 > (r10 - r11)) goto L14;
            if (this.immutable == false) goto L9;
        L11:
            ByteBuffer r12 = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, r11, r11 + r8));
        L12:
            this.pos += r8;
            return r12;
        L9:
            if (this.enableAliasing == false) goto L11;
            r12 = ByteBuffer.wrap(this.buffer, r11, r8).slice();
        L14:
            if (r8 == 0) goto L16;
            if (r8 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return Internal.EMPTY_BYTE_BUFFER;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() {
            int r8 = readRawVarint32();
            if (r8 <= 0) goto L14;
            int r10 = this.limit;
            int r11 = this.pos;
            if (r8 > (r10 - r11)) goto L14;
            if (this.immutable == true) goto L9;
        L11:
            ByteString r12 = ByteString.copyFrom(this.buffer, r11, r8);
        L12:
            this.pos += r8;
            return r12;
        L9:
            if (this.enableAliasing == false) goto L11;
            r12 = ByteString.wrap(this.buffer, r11, r8);
        L14:
            if (r8 != 0) goto L18;
            return ByteString.EMPTY;
        L18:
            return ByteString.wrap(readRawBytes(r8));
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
        public <T extends MessageLite> T readGroup(int r8, Parser<T> r10, ExtensionRegistryLite r11) {
            checkRecursionLimit();
            this.groupDepth++;
            T r12 = r10.parsePartialFrom(this, r11);
            checkLastTagWas(WireFormat.makeTag(r8, 4));
            this.groupDepth--;
            return r12;
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
        public <T extends MessageLite> T readMessage(Parser<T> r8, ExtensionRegistryLite r10) {
            int r11 = readRawVarint32();
            checkRecursionLimit();
            int r12 = pushLimit(r11);
            this.messageDepth++;
            T r13 = r8.parsePartialFrom(this, r10);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r12);
            return r13;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() {
            int r8 = this.pos;
            if (r8 == this.limit) goto L7;
            byte[] r10 = this.buffer;
            this.pos = r8 + 1;
            return r10[r8];
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int r8) {
            if (r8 <= 0) goto L7;
            int r10 = this.limit;
            int r11 = this.pos;
            if (r8 > (r10 - r11)) goto L7;
            int r12 = r8 + r11;
            this.pos = r12;
            return Arrays.copyOfRange(this.buffer, r11, r12);
        L7:
            if (r8 > 0) goto L14;
            if (r8 != 0) goto L12;
            return Internal.EMPTY_BYTE_ARRAY;
        L12:
            throw InvalidProtocolBufferException.negativeSize();
        L14:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            int r8 = this.pos;
            if ((this.limit - r8) < 4) goto L7;
            byte[] r10 = this.buffer;
            this.pos = r8 + 4;
            return (((r10[r8] & 255) | ((r10[r8 + 1] & 255) << 8)) | ((r10[r8 + 2] & 255) << 16)) | ((r10[r8 + 3] & 255) << 24);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            int r8 = this.pos;
            if ((this.limit - r8) < 8) goto L7;
            byte[] r10 = this.buffer;
            this.pos = r8 + 8;
            long r11 = ((((((((long) r10[r8]) & 255) | ((((long) r10[r8 + 1]) & 255) << 8)) | ((((long) r10[r8 + 2]) & 255) << 16)) | ((((long) r10[r8 + 3]) & 255) << 24)) | ((((long) r10[r8 + 4]) & 255) << 32)) | ((((long) r10[r8 + 5]) & 255) << 40)) | ((((long) r10[r8 + 6]) & 255) << 48);
            return ((((long) r10[r8 + 7]) & 255) << 56) | r11;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() {
            int r8 = this.pos;
            int r10 = this.limit;
            if (r10 == r8) goto L35;
            byte[] r11 = this.buffer;
            int r12 = r8 + 1;
            byte r13 = r11[r8];
            if (r13 < 0) goto L10;
            this.pos = r12;
            return r13;
        L10:
            if ((r10 - r12) < 9) goto L35;
            int r14 = r12 + 1;
            int r15 = r13 ^ (r11[r12] << 7);
            if (r15 >= 0) goto L15;
            int r16 = r15 ^ QesdkUtils.LIMITS.INT_8_LOWER;
        L36:
            this.pos = r14;
            return r16;
        L15:
            int r17 = r14 + 1;
            int r18 = r15 ^ (r11[r14] << 14);
            if (r18 < 0) goto L19;
            r16 = r18 ^ 16256;
        L18:
            r14 = r17;
            goto L36
        L19:
            r14 = r17 + 1;
            int r19 = r18 ^ (r11[r17] << BWDLCommandBuilder.CHANNEL_CONFIG_REQ);
            if (r19 >= 0) goto L22;
            r16 = r19 ^ (-2080896);
            goto L36
        L22:
            r17 = r14 + 1;
            byte r20 = r11[r14];
            r16 = (r19 ^ (r20 << 28)) ^ 266354560;
            if (r20 >= 0) goto L18;
            r14 = r17 + 1;
            if (r11[r17] >= 0) goto L36;
            r17 = r14 + 1;
            if (r11[r14] >= 0) goto L18;
            r14 = r17 + 1;
            if (r11[r17] >= 0) goto L36;
            r17 = r14 + 1;
            if (r11[r14] >= 0) goto L18;
            r14 = r17 + 1;
            if (r11[r17] >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() {
            int r8 = this.pos;
            int r10 = this.limit;
            if (r10 == r8) goto L41;
            byte[] r11 = this.buffer;
            int r12 = r8 + 1;
            byte r13 = r11[r8];
            if (r13 < 0) goto L10;
            this.pos = r12;
            return r13;
        L10:
            if ((r10 - r12) < 9) goto L41;
            int r14 = r12 + 1;
            int r15 = r13 ^ (r11[r12] << 7);
            if (r15 >= 0) goto L16;
            int r16 = r15 ^ QesdkUtils.LIMITS.INT_8_LOWER;
        L15:
            long r17 = r16;
        L44:
            this.pos = r14;
            return r17;
        L16:
            int r18 = r14 + 1;
            int r19 = r15 ^ (r11[r14] << 14);
            if (r19 < 0) goto L19;
            r14 = r18;
            r17 = r19 ^ 16256;
            goto L44
        L19:
            r14 = r18 + 1;
            int r20 = r19 ^ (r11[r18] << BWDLCommandBuilder.CHANNEL_CONFIG_REQ);
            if (r20 >= 0) goto L22;
            r16 = r20 ^ (-2080896);
            goto L15
        L22:
            long r21 = r20;
            int r22 = r14 + 1;
            long r23 = r21 ^ (((long) r11[r14]) << 28);
            if (r23 < 0) goto L26;
            long r24 = 266354560;
        L25:
            r17 = r23 ^ r24;
            r14 = r22;
            goto L44
        L26:
            r14 = r22 + 1;
            long r25 = r23 ^ (((long) r11[r22]) << 35);
            if (r25 >= 0) goto L30;
            long r26 = -34093383808L;
        L29:
            r17 = r25 ^ r26;
            goto L44
        L30:
            r22 = r14 + 1;
            r23 = r25 ^ (((long) r11[r14]) << 42);
            if (r23 < 0) goto L33;
            r24 = 4363953127296L;
            goto L25
        L33:
            r14 = r22 + 1;
            r25 = r23 ^ (((long) r11[r22]) << 49);
            if (r25 >= 0) goto L36;
            r26 = -558586000294016L;
            goto L29
        L36:
            int r27 = r14 + 1;
            long r28 = (r25 ^ (((long) r11[r14]) << 56)) ^ 71499008037633920L;
            if (r28 >= 0) goto L42;
            r14 = r27 + 1;
            if (r11[r27] < 0) goto L41;
        L43:
            r17 = r28;
            goto L44
        L42:
            r14 = r27;
        L41:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() {
            long r8 = 0;
            int r10 = 0;
        L4:
            if (r10 >= 64) goto L10;
            byte r11 = readRawByte();
            r8 = r8 | (((long) (r11 & 127)) << r10);
            if ((r11 & 128) == 0) goto L7;
            r10 = r10 + 7;
            goto L4
        L7:
            return r8;
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
            int r8 = readRawVarint32();
            if (r8 > 0) goto L5;
        L8:
            if (r8 != 0) goto L11;
            return "";
        L11:
            if (r8 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r8 > (this.limit - this.pos)) goto L8;
            String r10 = new String(this.buffer, this.pos, r8, Internal.UTF_8);
            this.pos += r8;
            return r10;
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            int r8 = readRawVarint32();
            if (r8 <= 0) goto L8;
            int r10 = this.limit;
            int r11 = this.pos;
            if (r8 > (r10 - r11)) goto L8;
            String r12 = Utf8.decodeUtf8(this.buffer, r11, r8);
            this.pos += r8;
            return r12;
        L8:
            if (r8 != 0) goto L11;
            return "";
        L11:
            if (r8 > 0) goto L15;
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
            int r8 = readRawVarint32();
            this.lastTag = r8;
            if (WireFormat.getTagFieldNumber(r8) == 0) goto L11;
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
        public void readUnknownGroup(int r8, MessageLite.Builder r10) {
            readGroup(r8, r10, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r8) {
            int r10 = WireFormat.getTagWireType(r8);
            if (r10 == 0) goto L24;
            if (r10 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r10 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r10 == 3) goto L18;
            if (r10 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r10 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r8), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int r8) {
            if (r8 < 0) goto L7;
            int r10 = this.limit;
            int r11 = this.pos;
            if (r8 > (r10 - r11)) goto L7;
            this.pos = r11 + r8;
            return;
        L7:
            if (r8 >= 0) goto L11;
            throw InvalidProtocolBufferException.negativeSize();
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public /* synthetic */ ArrayDecoder(byte[] r8, int r10, int r11, boolean r12, AnonymousClass1 r13) {
            this(r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int r8, MessageLite.Builder r10, ExtensionRegistryLite r11) {
            checkRecursionLimit();
            this.groupDepth++;
            r10.mergeFrom(this, r11);
            checkLastTagWas(WireFormat.makeTag(r8, 4));
            this.groupDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder r8, ExtensionRegistryLite r10) {
            int r11 = readRawVarint32();
            checkRecursionLimit();
            int r12 = pushLimit(r11);
            this.messageDepth++;
            r8.mergeFrom(this, r10);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r12);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r8, CodedOutputStream r10) {
            int r11 = WireFormat.getTagWireType(r8);
            if (r11 == 0) goto L24;
            if (r11 != 1) goto L6;
            long r12 = readRawLittleEndian64();
            r10.writeUInt32NoTag(r8);
            r10.writeFixed64NoTag(r12);
            return true;
        L6:
            if (r11 != 2) goto L8;
            ByteString r13 = readBytes();
            r10.writeUInt32NoTag(r8);
            r10.writeBytesNoTag(r13);
            return true;
        L8:
            if (r11 == 3) goto L18;
            if (r11 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r11 != 5) goto L15;
            int r14 = readRawLittleEndian32();
            r10.writeUInt32NoTag(r8);
            r10.writeFixed32NoTag(r14);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            r10.writeUInt32NoTag(r8);
            skipMessage(r10);
            int r15 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r8), 4);
            checkLastTagWas(r15);
            r10.writeUInt32NoTag(r15);
            return true;
        L24:
            long r16 = readInt64();
            r10.writeUInt32NoTag(r8);
            r10.writeUInt64NoTag(r16);
            return true;
        }
    }

    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {
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

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> r8, int r10, boolean r11) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = r10;
            this.input = r8;
            this.iterator = r8.iterator();
            this.immutable = r11;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (r10 != 0) goto L5;
            this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
            this.currentByteBufferPos = 0;
            this.currentByteBufferStartPos = 0;
            this.currentByteBufferLimit = 0;
            this.currentAddress = 0;
            return;
        L5:
            tryGetNextByteBuffer();
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
            int r8 = r14;
        L6:
            if (r8 <= 0) goto L11;
            if (currentRemaining() != 0) goto L10;
            getNextByteBuffer();
        L10:
            int r10 = Math.min(r8, (int) currentRemaining());
            long r11 = r10;
            UnsafeUtil.copyMemory(this.currentByteBufferPos, r12, (r14 - r8) + r13, r11);
            r8 = r8 - r10;
            this.currentByteBufferPos += r11;
            goto L6
        }

        private void recomputeBufferSizeAfterLimit() {
            int r8 = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = r8;
            int r10 = r8 - this.startOffset;
            int r11 = this.currentLimit;
            if (r10 <= r11) goto L5;
            int r12 = r10 - r11;
            this.bufferSizeAfterCurrentLimit = r12;
            this.totalBufferSize = r8 - r12;
            return;
        L5:
            this.bufferSizeAfterCurrentLimit = 0;
        }

        private int remaining() {
            return (int) ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private void skipRawVarint() {
            int r8 = 0;
        L4:
            if (r8 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r8 = r8 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(int r8, int r10) {
            int r11 = this.currentByteBuffer.position();
            int r12 = this.currentByteBuffer.limit();
            ByteBuffer r13 = this.currentByteBuffer;
            r13.position(r8);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r13.limit(r10);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            ByteBuffer r14 = this.currentByteBuffer.slice();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r13.position(r11);
            r13.limit(r12);
            return r14;
        L6:
            th = move-exception;
            r13.position(r11);
            r13.limit(r12);
            throw th;
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();     // Catch: Throwable -> L6
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer r8 = this.iterator.next();
            this.currentByteBuffer = r8;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long r10 = r8.position();
            this.currentByteBufferPos = r10;
            this.currentByteBufferStartPos = r10;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            long r11 = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentAddress = r11;
            this.currentByteBufferPos += r11;
            this.currentByteBufferStartPos += r11;
            this.currentByteBufferLimit += r11;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int r8) {
            if (this.lastTag != r8) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean r8) {
            this.enableAliasing = r8;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r8 = this.currentLimit;
            if (r8 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r8 - getTotalBytesRead();
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
        public void popLimit(int r8) {
            this.currentLimit = r8;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int r8) {
            if (r8 < 0) goto L10;
            int r10 = r8 + getTotalBytesRead();
            int r11 = this.currentLimit;
            if (r10 > r11) goto L8;
            this.currentLimit = r10;
            recomputeBufferSizeAfterLimit();
            return r11;
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
            int r8 = readRawVarint32();
            if (r8 <= 0) goto L14;
            long r10 = r8;
            if (r10 > currentRemaining()) goto L14;
            if (this.immutable == false) goto L9;
        L12:
            byte[] r11 = new byte[r8];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, r11, 0, r10);
            this.currentByteBufferPos += r10;
            return ByteBuffer.wrap(r11);
        L9:
            if (this.enableAliasing == false) goto L12;
            long r12 = this.currentByteBufferPos + r10;
            this.currentByteBufferPos = r12;
            long r13 = this.currentAddress;
            return slice((int) ((r12 - r13) - r10), (int) (r12 - r13));
        L14:
            if (r8 > 0) goto L16;
        L19:
            if (r8 == 0) goto L21;
            if (r8 >= 0) goto L26;
            throw InvalidProtocolBufferException.negativeSize();
        L26:
            throw InvalidProtocolBufferException.truncatedMessage();
        L21:
            return Internal.EMPTY_BYTE_BUFFER;
        L16:
            if (r8 > remaining()) goto L19;
            byte[] r14 = new byte[r8];
            readRawBytesTo(r14, 0, r8);
            return ByteBuffer.wrap(r14);
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() {
            int r8 = readRawVarint32();
            if (r8 <= 0) goto L14;
            long r10 = r8;
            long r11 = this.currentByteBufferLimit;
            long r12 = this.currentByteBufferPos;
            if (r10 > (r11 - r12)) goto L14;
            if (this.immutable == true) goto L9;
        L12:
            byte[] r13 = new byte[r8];
            UnsafeUtil.copyMemory(r12, r13, 0, r10);
            this.currentByteBufferPos += r10;
            return ByteString.wrap(r13);
        L9:
            if (this.enableAliasing == false) goto L12;
            int r14 = (int) (r12 - this.currentAddress);
            ByteString r15 = ByteString.wrap(slice(r14, r8 + r14));
            this.currentByteBufferPos += r10;
            return r15;
        L14:
            if (r8 > 0) goto L16;
        L31:
            if (r8 == 0) goto L33;
            if (r8 >= 0) goto L38;
            throw InvalidProtocolBufferException.negativeSize();
        L38:
            throw InvalidProtocolBufferException.truncatedMessage();
        L33:
            return ByteString.EMPTY;
        L16:
            if (r8 > remaining()) goto L31;
            if (this.immutable == true) goto L20;
        L29:
            byte[] r16 = new byte[r8];
            readRawBytesTo(r16, 0, r8);
            return ByteString.wrap(r16);
        L20:
            if (this.enableAliasing == false) goto L29;
            ArrayList r17 = new ArrayList();
        L22:
            if (r8 <= 0) goto L28;
            if (currentRemaining() != 0) goto L26;
            getNextByteBuffer();
        L26:
            int r18 = Math.min(r8, (int) currentRemaining());
            int r19 = (int) (this.currentByteBufferPos - this.currentAddress);
            r17.add(ByteString.wrap(slice(r19, r19 + r18)));
            r8 = r8 - r18;
            this.currentByteBufferPos += (long) r18;
            goto L22
        L28:
            return ByteString.copyFrom(r17);
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
        public <T extends MessageLite> T readGroup(int r8, Parser<T> r10, ExtensionRegistryLite r11) {
            checkRecursionLimit();
            this.groupDepth++;
            T r12 = r10.parsePartialFrom(this, r11);
            checkLastTagWas(WireFormat.makeTag(r8, 4));
            this.groupDepth--;
            return r12;
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
        public <T extends MessageLite> T readMessage(Parser<T> r8, ExtensionRegistryLite r10) {
            int r11 = readRawVarint32();
            checkRecursionLimit();
            int r12 = pushLimit(r11);
            this.messageDepth++;
            T r13 = r8.parsePartialFrom(this, r10);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r12);
            return r13;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() {
            if (currentRemaining() != 0) goto L5;
            getNextByteBuffer();
        L5:
            long r8 = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + r8;
            return UnsafeUtil.getByte(r8);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int r10) {
            if (r10 < 0) goto L7;
            long r8 = r10;
            if (r8 > currentRemaining()) goto L7;
            byte[] r11 = new byte[r10];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, r11, 0, r8);
            this.currentByteBufferPos += r8;
            return r11;
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
            byte[] r12 = new byte[r10];
            readRawBytesTo(r12, 0, r10);
            return r12;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            if (currentRemaining() < 4) goto L6;
            long r8 = this.currentByteBufferPos;
            this.currentByteBufferPos = 4 + r8;
            return (((UnsafeUtil.getByte(r8) & 255) | ((UnsafeUtil.getByte(1 + r8) & 255) << 8)) | ((UnsafeUtil.getByte(2 + r8) & 255) << 16)) | ((UnsafeUtil.getByte(r8 + 3) & 255) << 24);
        L6:
            int r10 = ((readRawByte() & 255) | ((readRawByte() & 255) << 8)) | ((readRawByte() & 255) << 16);
            return ((readRawByte() & 255) << 24) | r10;
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            if (currentRemaining() < 8) goto L6;
            long r13 = this.currentByteBufferPos;
            this.currentByteBufferPos = 8 + r13;
            return (((((((((long) UnsafeUtil.getByte(r13)) & 255) | ((((long) UnsafeUtil.getByte(1 + r13)) & 255) << 8)) | ((((long) UnsafeUtil.getByte(2 + r13)) & 255) << 16)) | ((((long) UnsafeUtil.getByte(3 + r13)) & 255) << 24)) | ((((long) UnsafeUtil.getByte(4 + r13)) & 255) << 32)) | ((((long) UnsafeUtil.getByte(5 + r13)) & 255) << 40)) | ((((long) UnsafeUtil.getByte(6 + r13)) & 255) << 48)) | ((((long) UnsafeUtil.getByte(r13 + 7)) & 255) << 56);
        L6:
            long r8 = ((((((((long) readRawByte()) & 255) | ((((long) readRawByte()) & 255) << 8)) | ((((long) readRawByte()) & 255) << 16)) | ((((long) readRawByte()) & 255) << 24)) | ((((long) readRawByte()) & 255) << 32)) | ((((long) readRawByte()) & 255) << 40)) | ((((long) readRawByte()) & 255) << 48);
            return ((((long) readRawByte()) & 255) << 56) | r8;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() {
            long r8 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit == r8) goto L35;
            long r10 = r8 + 1;
            byte r11 = UnsafeUtil.getByte(r8);
            if (r11 < 0) goto L10;
            this.currentByteBufferPos++;
            return r11;
        L10:
            if ((this.currentByteBufferLimit - this.currentByteBufferPos) < 10) goto L35;
            long r12 = r10 + 1;
            int r13 = r11 ^ (UnsafeUtil.getByte(r10) << 7);
            if (r13 >= 0) goto L15;
            int r14 = r13 ^ QesdkUtils.LIMITS.INT_8_LOWER;
        L36:
            this.currentByteBufferPos = r12;
            return r14;
        L15:
            long r15 = r12 + 1;
            int r16 = r13 ^ (UnsafeUtil.getByte(r12) << 14);
            if (r16 < 0) goto L19;
            r14 = r16 ^ 16256;
        L18:
            r12 = r15;
            goto L36
        L19:
            r12 = r15 + 1;
            int r17 = r16 ^ (UnsafeUtil.getByte(r15) << BWDLCommandBuilder.CHANNEL_CONFIG_REQ);
            if (r17 >= 0) goto L22;
            r14 = r17 ^ (-2080896);
            goto L36
        L22:
            r15 = r12 + 1;
            byte r18 = UnsafeUtil.getByte(r12);
            r14 = (r17 ^ (r18 << 28)) ^ 266354560;
            if (r18 >= 0) goto L18;
            r12 = r15 + 1;
            if (UnsafeUtil.getByte(r15) >= 0) goto L36;
            r15 = r12 + 1;
            if (UnsafeUtil.getByte(r12) >= 0) goto L18;
            r12 = r15 + 1;
            if (UnsafeUtil.getByte(r15) >= 0) goto L36;
            r15 = r12 + 1;
            if (UnsafeUtil.getByte(r12) >= 0) goto L18;
            r12 = r15 + 1;
            if (UnsafeUtil.getByte(r15) >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() {
            long r8 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit == r8) goto L42;
            long r10 = r8 + 1;
            byte r11 = UnsafeUtil.getByte(r8);
            if (r11 < 0) goto L10;
            this.currentByteBufferPos++;
            return r11;
        L10:
            if ((this.currentByteBufferLimit - this.currentByteBufferPos) < 10) goto L42;
            long r12 = r10 + 1;
            int r13 = r11 ^ (UnsafeUtil.getByte(r10) << 7);
            if (r13 >= 0) goto L16;
            int r14 = r13 ^ QesdkUtils.LIMITS.INT_8_LOWER;
        L15:
            long r15 = r14;
        L44:
            this.currentByteBufferPos = r12;
            return r15;
        L16:
            long r16 = r12 + 1;
            int r17 = r13 ^ (UnsafeUtil.getByte(r12) << 14);
            if (r17 < 0) goto L20;
            r15 = r17 ^ 16256;
        L19:
            r12 = r16;
            goto L44
        L20:
            r12 = r16 + 1;
            int r18 = r17 ^ (UnsafeUtil.getByte(r16) << BWDLCommandBuilder.CHANNEL_CONFIG_REQ);
            if (r18 >= 0) goto L23;
            r14 = r18 ^ (-2080896);
            goto L15
        L23:
            r16 = r12 + 1;
            long r19 = ((long) r18) ^ (((long) UnsafeUtil.getByte(r12)) << 28);
            if (r19 < 0) goto L27;
            long r20 = 266354560;
        L26:
            r15 = r19 ^ r20;
            goto L19
        L27:
            long r21 = r16 + 1;
            long r22 = r19 ^ (((long) UnsafeUtil.getByte(r16)) << 35);
            if (r22 >= 0) goto L31;
            long r23 = -34093383808L;
        L30:
            r15 = r22 ^ r23;
            r12 = r21;
            goto L44
        L31:
            r16 = r21 + 1;
            r19 = r22 ^ (((long) UnsafeUtil.getByte(r21)) << 42);
            if (r19 < 0) goto L34;
            r20 = 4363953127296L;
            goto L26
        L34:
            r21 = r16 + 1;
            r22 = r19 ^ (((long) UnsafeUtil.getByte(r16)) << 49);
            if (r22 >= 0) goto L37;
            r23 = -558586000294016L;
            goto L30
        L37:
            r16 = r21 + 1;
            r15 = (r22 ^ (((long) UnsafeUtil.getByte(r21)) << 56)) ^ 71499008037633920L;
            if (r15 >= 0) goto L19;
            long r24 = 1 + r16;
            if (UnsafeUtil.getByte(r16) < 0) goto L42;
            r12 = r24;
        L42:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() {
            long r8 = 0;
            int r10 = 0;
        L4:
            if (r10 >= 64) goto L10;
            byte r11 = readRawByte();
            r8 = r8 | (((long) (r11 & 127)) << r10);
            if ((r11 & 128) == 0) goto L7;
            r10 = r10 + 7;
            goto L4
        L7:
            return r8;
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
            int r8 = readRawVarint32();
            if (r8 <= 0) goto L8;
            long r10 = r8;
            long r11 = this.currentByteBufferLimit;
            long r12 = this.currentByteBufferPos;
            if (r10 > (r11 - r12)) goto L8;
            byte[] r13 = new byte[r8];
            UnsafeUtil.copyMemory(r12, r13, 0, r10);
            String r14 = new String(r13, Internal.UTF_8);
            this.currentByteBufferPos += r10;
            return r14;
        L8:
            if (r8 > 0) goto L10;
        L13:
            if (r8 != 0) goto L16;
            return "";
        L16:
            if (r8 >= 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (r8 > remaining()) goto L13;
            byte[] r15 = new byte[r8];
            readRawBytesTo(r15, 0, r8);
            return new String(r15, Internal.UTF_8);
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            int r8 = readRawVarint32();
            if (r8 <= 0) goto L8;
            long r10 = r8;
            long r11 = this.currentByteBufferLimit;
            long r12 = this.currentByteBufferPos;
            if (r10 > (r11 - r12)) goto L8;
            String r13 = Utf8.decodeUtf8(this.currentByteBuffer, (int) (r12 - this.currentByteBufferStartPos), r8);
            this.currentByteBufferPos += r10;
            return r13;
        L8:
            if (r8 >= 0) goto L10;
        L13:
            if (r8 != 0) goto L16;
            return "";
        L16:
            if (r8 > 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (r8 > remaining()) goto L13;
            byte[] r14 = new byte[r8];
            readRawBytesTo(r14, 0, r8);
            return Utf8.decodeUtf8(r14, 0, r8);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r8 = readRawVarint32();
            this.lastTag = r8;
            if (WireFormat.getTagFieldNumber(r8) == 0) goto L11;
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
        public void readUnknownGroup(int r8, MessageLite.Builder r10) {
            readGroup(r8, r10, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r8) {
            int r10 = WireFormat.getTagWireType(r8);
            if (r10 == 0) goto L24;
            if (r10 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r10 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r10 == 3) goto L18;
            if (r10 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r10 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r8), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int r8) {
            if (r8 >= 0) goto L4;
        L11:
            if (r8 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r8 > ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos)) goto L11;
        L5:
            if (r8 <= 0) goto L10;
            if (currentRemaining() != 0) goto L9;
            getNextByteBuffer();
        L9:
            int r10 = Math.min(r8, (int) currentRemaining());
            r8 = r8 - r10;
            this.currentByteBufferPos += (long) r10;
            goto L5
        }

        public /* synthetic */ IterableDirectByteBufferDecoder(Iterable r8, int r10, boolean r11, AnonymousClass1 r12) {
            this(r8, r10, r11);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int r8, MessageLite.Builder r10, ExtensionRegistryLite r11) {
            checkRecursionLimit();
            this.groupDepth++;
            r10.mergeFrom(this, r11);
            checkLastTagWas(WireFormat.makeTag(r8, 4));
            this.groupDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder r8, ExtensionRegistryLite r10) {
            int r11 = readRawVarint32();
            checkRecursionLimit();
            int r12 = pushLimit(r11);
            this.messageDepth++;
            r8.mergeFrom(this, r10);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r12);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r8, CodedOutputStream r10) {
            int r11 = WireFormat.getTagWireType(r8);
            if (r11 == 0) goto L24;
            if (r11 != 1) goto L6;
            long r12 = readRawLittleEndian64();
            r10.writeUInt32NoTag(r8);
            r10.writeFixed64NoTag(r12);
            return true;
        L6:
            if (r11 != 2) goto L8;
            ByteString r13 = readBytes();
            r10.writeUInt32NoTag(r8);
            r10.writeBytesNoTag(r13);
            return true;
        L8:
            if (r11 == 3) goto L18;
            if (r11 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r11 != 5) goto L15;
            int r14 = readRawLittleEndian32();
            r10.writeUInt32NoTag(r8);
            r10.writeFixed32NoTag(r14);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            r10.writeUInt32NoTag(r8);
            skipMessage(r10);
            int r15 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r8), 4);
            checkLastTagWas(r15);
            r10.writeUInt32NoTag(r15);
            return true;
        L24:
            long r16 = readInt64();
            r10.writeUInt32NoTag(r8);
            r10.writeUInt64NoTag(r16);
            return true;
        }
    }

    public static final class StreamDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        private int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        public interface RefillCallback {
            void onRefill();
        }

        public class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos;
            final /* synthetic */ StreamDecoder this$0;

            private SkippedDataSink(StreamDecoder r8) {
                this.this$0 = r8;
                this.lastPos = StreamDecoder.access$500(r8);
            }

            public ByteBuffer getSkippedData() {
                ByteArrayOutputStream r8 = this.byteArrayStream;
                if (r8 == null) goto L5;
                r8.write(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0));
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

        private StreamDecoder(InputStream r8, int r10) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(r8, QesdkUtils.TAGS.TAG_INPUT);
            this.input = r8;
            this.buffer = new byte[r10];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        public static /* synthetic */ int access$500(StreamDecoder r8) {
            return r8.pos;
        }

        public static /* synthetic */ byte[] access$600(StreamDecoder r8) {
            return r8.buffer;
        }

        private static int available(InputStream r8) {
            return r8.available();
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private static int read(InputStream r8, byte[] r10, int r11, int r12) {
            return r8.read(r10, r11, r12);
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private ByteString readBytesSlowPath(int r8) {
            byte[] r10 = readRawBytesSlowPathOneChunk(r8);
            if (r10 != null) goto L5;
            int r11 = this.pos;
            int r12 = this.bufferSize;
            int r13 = r12 - r11;
            this.totalBytesRetired += r12;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> r14 = readRawBytesSlowPathRemainingChunks(r8 - r13);
            byte[] r15 = new byte[r8];
            System.arraycopy(this.buffer, r11, r15, 0, r13);
            Iterator<byte[]> r16 = r14.iterator();
        L8:
            if (r16.hasNext() == false) goto L11;
            byte[] r17 = r16.next();
            System.arraycopy(r17, 0, r15, r13, r17.length);
            r13 = r13 + r17.length;
            goto L8
        L11:
            return ByteString.wrap(r15);
        L5:
            return ByteString.copyFrom(r10);
        }

        private byte[] readRawBytesSlowPath(int r8, boolean r10) {
            byte[] r11 = readRawBytesSlowPathOneChunk(r8);
            if (r11 == null) goto L7;
            if (r10 == true) goto L6;
            return r11;
        L6:
            return (byte[]) r11.clone();
        L7:
            int r12 = this.pos;
            int r13 = this.bufferSize;
            int r14 = r13 - r12;
            this.totalBytesRetired += r13;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> r15 = readRawBytesSlowPathRemainingChunks(r8 - r14);
            byte[] r16 = new byte[r8];
            System.arraycopy(this.buffer, r12, r16, 0, r14);
            Iterator<byte[]> r17 = r15.iterator();
        L9:
            if (r17.hasNext() == false) goto L11;
            byte[] r18 = r17.next();
            System.arraycopy(r18, 0, r16, r14, r18.length);
            r14 = r14 + r18.length;
            goto L9
        L11:
            return r16;
        }

        private byte[] readRawBytesSlowPathOneChunk(int r8) {
            if (r8 == 0) goto L4;
            if (r8 < 0) goto L30;
            int r10 = this.totalBytesRetired;
            int r11 = this.pos;
            int r12 = (r10 + r11) + r8;
            if ((r12 - this.sizeLimit) > 0) goto L28;
            int r13 = this.currentLimit;
            if (r12 > r13) goto L25;
            int r14 = this.bufferSize - r11;
            int r15 = r8 - r14;
            if (r15 >= 4096) goto L13;
        L17:
            byte[] r16 = new byte[r8];
            System.arraycopy(this.buffer, this.pos, r16, 0, r14);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
        L18:
            if (r14 >= r8) goto L24;
            int r17 = read(this.input, r16, r14, r8 - r14);
            if (r17 == (-1)) goto L23;
            this.totalBytesRetired += r17;
            r14 = r14 + r17;
            goto L18
        L23:
            throw InvalidProtocolBufferException.truncatedMessage();
        L24:
            return r16;
        L13:
            if (r15 <= available(this.input)) goto L17;
            return null;
        L25:
            skipRawBytes((r13 - r10) - r11);
            throw InvalidProtocolBufferException.truncatedMessage();
        L28:
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L30:
            throw InvalidProtocolBufferException.negativeSize();
        L4:
            return Internal.EMPTY_BYTE_ARRAY;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int r8) {
            ArrayList r10 = new ArrayList();
        L3:
            if (r8 <= 0) goto L12;
            int r11 = Math.min(r8, 4096);
            byte[] r12 = new byte[r11];
            int r13 = 0;
        L5:
            if (r13 >= r11) goto L11;
            int r14 = this.input.read(r12, r13, r11 - r13);
            if (r14 == (-1)) goto L10;
            this.totalBytesRetired += r14;
            r13 = r13 + r14;
            goto L5
        L10:
            throw InvalidProtocolBufferException.truncatedMessage();
        L11:
            r8 = r8 - r11;
            r10.add(r12);
            goto L3
        L12:
            return r10;
        }

        private void recomputeBufferSizeAfterLimit() {
            int r8 = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = r8;
            int r10 = this.totalBytesRetired + r8;
            int r11 = this.currentLimit;
            if (r10 <= r11) goto L5;
            int r12 = r10 - r11;
            this.bufferSizeAfterLimit = r12;
            this.bufferSize = r8 - r12;
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        private void refillBuffer(int r8) {
            if (tryRefillBuffer(r8) == false) goto L5;
            return;
        L5:
            if (r8 <= ((this.sizeLimit - this.totalBytesRetired) - this.pos)) goto L9;
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private static long skip(InputStream r8, long r10) {
            return r8.skip(r10);
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private void skipRawBytesSlowPath(int r10) {
            if (r10 < 0) goto L33;
            int r8 = this.totalBytesRetired;
            int r11 = this.pos;
            int r12 = (r8 + r11) + r10;
            int r13 = this.currentLimit;
            if (r12 > r13) goto L30;
            int r14 = 0;
            if (this.refillCallback != null) goto L23;
            this.totalBytesRetired = r8 + r11;
            int r15 = this.bufferSize - r11;
            this.bufferSize = 0;
            this.pos = 0;
            r14 = r15;
        L8:
            if (r14 >= r10) goto L22;
            long r16 = r10 - r14;
            long r17 = skip(this.input, r16);     // Catch: Throwable -> L19
            if (r17 < 0) goto L18;
            if (r17 > r16) goto L18;
            if (r17 == 0) goto L22;
            r14 = r14 + ((int) r17);     // Catch: Throwable -> L19
        L18:
            throw new IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + r17 + "\nThe InputStream implementation is buggy.");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            this.totalBytesRetired += r14;
            recomputeBufferSizeAfterLimit();
            throw th;
        L22:
            this.totalBytesRetired += r14;
            recomputeBufferSizeAfterLimit();
        L23:
            if (r14 >= r10) goto L41;
            int r18 = this.bufferSize;
            int r19 = r18 - this.pos;
            this.pos = r18;
        L25:
            refillBuffer(1);
            int r20 = r10 - r19;
            int r21 = this.bufferSize;
            if (r20 <= r21) goto L28;
            r19 = r19 + r21;
            this.pos = r21;
            goto L25
        L28:
            this.pos = r20;
            return;
        L41:
            return;
        L30:
            skipRawBytes((r13 - r8) - r11);
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
            int r8 = 0;
        L4:
            if (r8 >= 10) goto L10;
            byte[] r10 = this.buffer;
            int r11 = this.pos;
            this.pos = r11 + 1;
            if (r10[r11] >= 0) goto L7;
            r8 = r8 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() {
            int r8 = 0;
        L4:
            if (r8 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r8 = r8 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private boolean tryRefillBuffer(int r8) {
            int r10 = this.pos;
            if ((r10 + r8) <= this.bufferSize) goto L35;
            int r11 = this.sizeLimit;
            int r12 = this.totalBytesRetired;
            if (r8 <= ((r11 - r12) - r10)) goto L8;
            return false;
        L8:
            if (((r12 + r10) + r8) <= this.currentLimit) goto L10;
            return false;
        L10:
            RefillCallback r13 = this.refillCallback;
            if (r13 == null) goto L13;
            r13.onRefill();
        L13:
            int r14 = this.pos;
            if (r14 <= 0) goto L19;
            int r15 = this.bufferSize;
            if (r15 <= r14) goto L18;
            byte[] r16 = this.buffer;
            System.arraycopy(r16, r14, r16, 0, r15 - r14);
        L18:
            this.totalBytesRetired += r14;
            this.bufferSize -= r14;
            this.pos = 0;
        L19:
            InputStream r17 = this.input;
            byte[] r18 = this.buffer;
            int r19 = this.bufferSize;
            int r20 = read(r17, r18, r19, Math.min(r18.length - r19, (this.sizeLimit - this.totalBytesRetired) - r19));
            if (r20 == 0) goto L33;
            if (r20 < (-1)) goto L33;
            if (r20 > this.buffer.length) goto L33;
            if (r20 <= 0) goto L36;
            this.bufferSize += r20;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize < r8) goto L29;
        L30:
            return true;
        L29:
            if (tryRefillBuffer(r8) == true) goto L30;
            return false;
        L36:
            return false;
        L33:
            throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + r20 + "\nThe InputStream implementation is buggy.");
        L35:
            throw new IllegalStateException(android.aimedia.a.c("refillBuffer() called when ", r8, " bytes were already available in buffer"));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int r8) {
            if (this.lastTag != r8) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean r8) {
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r8 = this.currentLimit;
            if (r8 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r8 - (this.totalBytesRetired + this.pos);
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
        public void popLimit(int r8) {
            this.currentLimit = r8;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int r8) {
            if (r8 < 0) goto L14;
            int r10 = (this.totalBytesRetired + this.pos) + r8;
            if (r10 < 0) goto L12;
            int r11 = this.currentLimit;
            if (r10 > r11) goto L10;
            this.currentLimit = r10;
            recomputeBufferSizeAfterLimit();
            return r11;
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
            int r8 = readRawVarint32();
            int r10 = this.bufferSize;
            int r11 = this.pos;
            if (r8 > (r10 - r11)) goto L7;
            if (r8 <= 0) goto L7;
            byte[] r12 = Arrays.copyOfRange(this.buffer, r11, r11 + r8);
            this.pos += r8;
            return r12;
        L7:
            if (r8 < 0) goto L11;
            return readRawBytesSlowPath(r8, false);
        L11:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() {
            int r8 = readRawVarint32();
            int r10 = this.bufferSize;
            int r11 = this.pos;
            if (r8 > (r10 - r11)) goto L7;
            if (r8 <= 0) goto L7;
            ByteBuffer r12 = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, r11, r11 + r8));
            this.pos += r8;
            return r12;
        L7:
            if (r8 == 0) goto L9;
            if (r8 < 0) goto L14;
            return ByteBuffer.wrap(readRawBytesSlowPath(r8, true));
        L14:
            throw InvalidProtocolBufferException.negativeSize();
        L9:
            return Internal.EMPTY_BYTE_BUFFER;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() {
            int r8 = readRawVarint32();
            int r10 = this.bufferSize;
            int r11 = this.pos;
            if (r8 > (r10 - r11)) goto L7;
            if (r8 <= 0) goto L7;
            ByteString r12 = ByteString.copyFrom(this.buffer, r11, r8);
            this.pos += r8;
            return r12;
        L7:
            if (r8 == 0) goto L9;
            if (r8 < 0) goto L14;
            return readBytesSlowPath(r8);
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
        public <T extends MessageLite> T readGroup(int r8, Parser<T> r10, ExtensionRegistryLite r11) {
            checkRecursionLimit();
            this.groupDepth++;
            T r12 = r10.parsePartialFrom(this, r11);
            checkLastTagWas(WireFormat.makeTag(r8, 4));
            this.groupDepth--;
            return r12;
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
        public <T extends MessageLite> T readMessage(Parser<T> r8, ExtensionRegistryLite r10) {
            int r11 = readRawVarint32();
            checkRecursionLimit();
            int r12 = pushLimit(r11);
            this.messageDepth++;
            T r13 = r8.parsePartialFrom(this, r10);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r12);
            return r13;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() {
            if (this.pos != this.bufferSize) goto L5;
            refillBuffer(1);
        L5:
            byte[] r8 = this.buffer;
            int r10 = this.pos;
            this.pos = r10 + 1;
            return r8[r10];
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int r8) {
            int r10 = this.pos;
            if (r8 > (this.bufferSize - r10)) goto L8;
            if (r8 <= 0) goto L8;
            int r11 = r8 + r10;
            this.pos = r11;
            return Arrays.copyOfRange(this.buffer, r10, r11);
        L8:
            return readRawBytesSlowPath(r8, false);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            int r8 = this.pos;
            if ((this.bufferSize - r8) >= 4) goto L5;
            refillBuffer(4);
            r8 = this.pos;
        L5:
            byte[] r10 = this.buffer;
            this.pos = r8 + 4;
            return (((r10[r8] & 255) | ((r10[r8 + 1] & 255) << 8)) | ((r10[r8 + 2] & 255) << 16)) | ((r10[r8 + 3] & 255) << 24);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            int r8 = this.pos;
            if ((this.bufferSize - r8) >= 8) goto L5;
            refillBuffer(8);
            r8 = this.pos;
        L5:
            byte[] r10 = this.buffer;
            this.pos = r8 + 8;
            long r11 = ((((((((long) r10[r8]) & 255) | ((((long) r10[r8 + 1]) & 255) << 8)) | ((((long) r10[r8 + 2]) & 255) << 16)) | ((((long) r10[r8 + 3]) & 255) << 24)) | ((((long) r10[r8 + 4]) & 255) << 32)) | ((((long) r10[r8 + 5]) & 255) << 40)) | ((((long) r10[r8 + 6]) & 255) << 48);
            return ((((long) r10[r8 + 7]) & 255) << 56) | r11;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() {
            int r8 = this.pos;
            int r10 = this.bufferSize;
            if (r10 == r8) goto L35;
            byte[] r11 = this.buffer;
            int r12 = r8 + 1;
            byte r13 = r11[r8];
            if (r13 < 0) goto L10;
            this.pos = r12;
            return r13;
        L10:
            if ((r10 - r12) < 9) goto L35;
            int r14 = r12 + 1;
            int r15 = r13 ^ (r11[r12] << 7);
            if (r15 >= 0) goto L15;
            int r16 = r15 ^ QesdkUtils.LIMITS.INT_8_LOWER;
        L36:
            this.pos = r14;
            return r16;
        L15:
            int r17 = r14 + 1;
            int r18 = r15 ^ (r11[r14] << 14);
            if (r18 < 0) goto L19;
            r16 = r18 ^ 16256;
        L18:
            r14 = r17;
            goto L36
        L19:
            r14 = r17 + 1;
            int r19 = r18 ^ (r11[r17] << BWDLCommandBuilder.CHANNEL_CONFIG_REQ);
            if (r19 >= 0) goto L22;
            r16 = r19 ^ (-2080896);
            goto L36
        L22:
            r17 = r14 + 1;
            byte r20 = r11[r14];
            r16 = (r19 ^ (r20 << 28)) ^ 266354560;
            if (r20 >= 0) goto L18;
            r14 = r17 + 1;
            if (r11[r17] >= 0) goto L36;
            r17 = r14 + 1;
            if (r11[r14] >= 0) goto L18;
            r14 = r17 + 1;
            if (r11[r17] >= 0) goto L36;
            r17 = r14 + 1;
            if (r11[r14] >= 0) goto L18;
            r14 = r17 + 1;
            if (r11[r17] >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() {
            int r8 = this.pos;
            int r10 = this.bufferSize;
            if (r10 == r8) goto L41;
            byte[] r11 = this.buffer;
            int r12 = r8 + 1;
            byte r13 = r11[r8];
            if (r13 < 0) goto L10;
            this.pos = r12;
            return r13;
        L10:
            if ((r10 - r12) < 9) goto L41;
            int r14 = r12 + 1;
            int r15 = r13 ^ (r11[r12] << 7);
            if (r15 >= 0) goto L16;
            int r16 = r15 ^ QesdkUtils.LIMITS.INT_8_LOWER;
        L15:
            long r17 = r16;
        L44:
            this.pos = r14;
            return r17;
        L16:
            int r18 = r14 + 1;
            int r19 = r15 ^ (r11[r14] << 14);
            if (r19 < 0) goto L19;
            r14 = r18;
            r17 = r19 ^ 16256;
            goto L44
        L19:
            r14 = r18 + 1;
            int r20 = r19 ^ (r11[r18] << BWDLCommandBuilder.CHANNEL_CONFIG_REQ);
            if (r20 >= 0) goto L22;
            r16 = r20 ^ (-2080896);
            goto L15
        L22:
            long r21 = r20;
            int r22 = r14 + 1;
            long r23 = r21 ^ (((long) r11[r14]) << 28);
            if (r23 < 0) goto L26;
            long r24 = 266354560;
        L25:
            r17 = r23 ^ r24;
            r14 = r22;
            goto L44
        L26:
            r14 = r22 + 1;
            long r25 = r23 ^ (((long) r11[r22]) << 35);
            if (r25 >= 0) goto L30;
            long r26 = -34093383808L;
        L29:
            r17 = r25 ^ r26;
            goto L44
        L30:
            r22 = r14 + 1;
            r23 = r25 ^ (((long) r11[r14]) << 42);
            if (r23 < 0) goto L33;
            r24 = 4363953127296L;
            goto L25
        L33:
            r14 = r22 + 1;
            r25 = r23 ^ (((long) r11[r22]) << 49);
            if (r25 >= 0) goto L36;
            r26 = -558586000294016L;
            goto L29
        L36:
            int r27 = r14 + 1;
            long r28 = (r25 ^ (((long) r11[r14]) << 56)) ^ 71499008037633920L;
            if (r28 >= 0) goto L42;
            r14 = r27 + 1;
            if (r11[r27] < 0) goto L41;
        L43:
            r17 = r28;
            goto L44
        L42:
            r14 = r27;
        L41:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() {
            long r8 = 0;
            int r10 = 0;
        L4:
            if (r10 >= 64) goto L10;
            byte r11 = readRawByte();
            r8 = r8 | (((long) (r11 & 127)) << r10);
            if ((r11 & 128) == 0) goto L7;
            r10 = r10 + 7;
            goto L4
        L7:
            return r8;
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
            int r8 = readRawVarint32();
            if (r8 > 0) goto L5;
        L8:
            if (r8 != 0) goto L11;
            return "";
        L11:
            if (r8 < 0) goto L19;
            if (r8 > this.bufferSize) goto L17;
            refillBuffer(r8);
            String r10 = new String(this.buffer, this.pos, r8, Internal.UTF_8);
            this.pos += r8;
            return r10;
        L17:
            return new String(readRawBytesSlowPath(r8, false), Internal.UTF_8);
        L19:
            throw InvalidProtocolBufferException.negativeSize();
        L5:
            if (r8 > (this.bufferSize - this.pos)) goto L8;
            String r11 = new String(this.buffer, this.pos, r8, Internal.UTF_8);
            this.pos += r8;
            return r11;
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            int r8 = readRawVarint32();
            int r10 = this.pos;
            int r11 = this.bufferSize;
            if (r8 > (r11 - r10)) goto L7;
            if (r8 <= 0) goto L7;
            byte[] r12 = this.buffer;
            int r13 = r10 + r8;
        L6:
            this.pos = r13;
        L16:
            return Utf8.decodeUtf8(r12, r10, r8);
        L7:
            if (r8 != 0) goto L10;
            return "";
        L10:
            if (r8 < 0) goto L18;
            r10 = 0;
            if (r8 > r11) goto L14;
            refillBuffer(r8);
            r12 = this.buffer;
            r13 = r8 + 0;
            goto L6
        L14:
            r12 = readRawBytesSlowPath(r8, false);
            goto L16
        L18:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r8 = readRawVarint32();
            this.lastTag = r8;
            if (WireFormat.getTagFieldNumber(r8) == 0) goto L11;
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
        public void readUnknownGroup(int r8, MessageLite.Builder r10) {
            readGroup(r8, r10, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r8) {
            int r10 = WireFormat.getTagWireType(r8);
            if (r10 == 0) goto L24;
            if (r10 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r10 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r10 == 3) goto L18;
            if (r10 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r10 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r8), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int r8) {
            int r10 = this.bufferSize;
            int r11 = this.pos;
            if (r8 > (r10 - r11)) goto L6;
            if (r8 < 0) goto L6;
            this.pos = r11 + r8;
            return;
        L6:
            skipRawBytesSlowPath(r8);
        }

        public /* synthetic */ StreamDecoder(InputStream r8, int r10, AnonymousClass1 r11) {
            this(r8, r10);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int r8, MessageLite.Builder r10, ExtensionRegistryLite r11) {
            checkRecursionLimit();
            this.groupDepth++;
            r10.mergeFrom(this, r11);
            checkLastTagWas(WireFormat.makeTag(r8, 4));
            this.groupDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder r8, ExtensionRegistryLite r10) {
            int r11 = readRawVarint32();
            checkRecursionLimit();
            int r12 = pushLimit(r11);
            this.messageDepth++;
            r8.mergeFrom(this, r10);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r12);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r8, CodedOutputStream r10) {
            int r11 = WireFormat.getTagWireType(r8);
            if (r11 == 0) goto L24;
            if (r11 != 1) goto L6;
            long r12 = readRawLittleEndian64();
            r10.writeUInt32NoTag(r8);
            r10.writeFixed64NoTag(r12);
            return true;
        L6:
            if (r11 != 2) goto L8;
            ByteString r13 = readBytes();
            r10.writeUInt32NoTag(r8);
            r10.writeBytesNoTag(r13);
            return true;
        L8:
            if (r11 == 3) goto L18;
            if (r11 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r11 != 5) goto L15;
            int r14 = readRawLittleEndian32();
            r10.writeUInt32NoTag(r8);
            r10.writeFixed32NoTag(r14);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            r10.writeUInt32NoTag(r8);
            skipMessage(r10);
            int r15 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r8), 4);
            checkLastTagWas(r15);
            r10.writeUInt32NoTag(r15);
            return true;
        L24:
            long r16 = readInt64();
            r10.writeUInt32NoTag(r8);
            r10.writeUInt64NoTag(r16);
            return true;
        }
    }

    public static final class UnsafeDirectNioDecoder extends CodedInputStream {
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

        private UnsafeDirectNioDecoder(ByteBuffer r8, boolean r10) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = r8.duplicate();
            long r11 = UnsafeUtil.addressOffset(r8);
            this.address = r11;
            this.limit = ((long) r8.limit()) + r11;
            long r12 = r11 + ((long) r8.position());
            this.pos = r12;
            this.startPos = r12;
            this.immutable = r10;
        }

        private int bufferPos(long r8) {
            return (int) (r8 - this.address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void recomputeBufferSizeAfterLimit() {
            long r8 = this.limit + ((long) this.bufferSizeAfterLimit);
            this.limit = r8;
            int r10 = (int) (r8 - this.startPos);
            int r11 = this.currentLimit;
            if (r10 <= r11) goto L5;
            int r12 = r10 - r11;
            this.bufferSizeAfterLimit = r12;
            this.limit = r8 - ((long) r12);
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
            int r8 = 0;
        L4:
            if (r8 >= 10) goto L10;
            long r10 = this.pos;
            this.pos = 1 + r10;
            if (UnsafeUtil.getByte(r10) >= 0) goto L7;
            r8 = r8 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() {
            int r8 = 0;
        L4:
            if (r8 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r8 = r8 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(long r8, long r10) {
            int r11 = this.buffer.position();
            int r12 = this.buffer.limit();
            ByteBuffer r13 = this.buffer;
            r13.position(bufferPos(r8));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r13.limit(bufferPos(r10));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            ByteBuffer r14 = this.buffer.slice();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r13.position(r11);
            r13.limit(r12);
            return r14;
        L8:
            e = move-exception;
            InvalidProtocolBufferException r15 = InvalidProtocolBufferException.truncatedMessage();     // Catch: Throwable -> L6
            r15.initCause(e);     // Catch: Throwable -> L6
            throw r15;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            r13.position(r11);
            r13.limit(r12);
            throw th;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int r8) {
            if (this.lastTag != r8) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean r8) {
            this.enableAliasing = r8;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r8 = this.currentLimit;
            if (r8 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r8 - getTotalBytesRead();
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
        public void popLimit(int r8) {
            this.currentLimit = r8;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int r8) {
            if (r8 < 0) goto L10;
            int r10 = r8 + getTotalBytesRead();
            int r11 = this.currentLimit;
            if (r10 > r11) goto L8;
            this.currentLimit = r10;
            recomputeBufferSizeAfterLimit();
            return r11;
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
            int r8 = readRawVarint32();
            if (r8 > 0) goto L5;
        L14:
            if (r8 == 0) goto L16;
            if (r8 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return Internal.EMPTY_BYTE_BUFFER;
        L5:
            if (r8 > remaining()) goto L14;
            if (this.immutable == false) goto L9;
        L12:
            byte[] r10 = new byte[r8];
            long r11 = r8;
            UnsafeUtil.copyMemory(this.pos, r10, 0, r11);
            this.pos += r11;
            return ByteBuffer.wrap(r10);
        L9:
            if (this.enableAliasing == false) goto L12;
            long r12 = this.pos;
            long r13 = r8;
            ByteBuffer r14 = slice(r12, r12 + r13);
            this.pos += r13;
            return r14;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() {
            int r8 = readRawVarint32();
            if (r8 > 0) goto L5;
        L14:
            if (r8 == 0) goto L16;
            if (r8 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return ByteString.EMPTY;
        L5:
            if (r8 > remaining()) goto L14;
            if (this.immutable == true) goto L9;
        L12:
            byte[] r10 = new byte[r8];
            long r11 = r8;
            UnsafeUtil.copyMemory(this.pos, r10, 0, r11);
            this.pos += r11;
            return ByteString.wrap(r10);
        L9:
            if (this.enableAliasing == false) goto L12;
            long r12 = this.pos;
            long r13 = r8;
            ByteBuffer r14 = slice(r12, r12 + r13);
            this.pos += r13;
            return ByteString.wrap(r14);
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
        public <T extends MessageLite> T readGroup(int r8, Parser<T> r10, ExtensionRegistryLite r11) {
            checkRecursionLimit();
            this.groupDepth++;
            T r12 = r10.parsePartialFrom(this, r11);
            checkLastTagWas(WireFormat.makeTag(r8, 4));
            this.groupDepth--;
            return r12;
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
        public <T extends MessageLite> T readMessage(Parser<T> r8, ExtensionRegistryLite r10) {
            int r11 = readRawVarint32();
            checkRecursionLimit();
            int r12 = pushLimit(r11);
            this.messageDepth++;
            T r13 = r8.parsePartialFrom(this, r10);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r12);
            return r13;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() {
            long r8 = this.pos;
            if (r8 == this.limit) goto L7;
            this.pos = 1 + r8;
            return UnsafeUtil.getByte(r8);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int r8) {
            if (r8 >= 0) goto L4;
        L7:
            if (r8 > 0) goto L14;
            if (r8 != 0) goto L12;
            return Internal.EMPTY_BYTE_ARRAY;
        L12:
            throw InvalidProtocolBufferException.negativeSize();
        L14:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r8 > remaining()) goto L7;
            byte[] r10 = new byte[r8];
            long r11 = this.pos;
            long r12 = r8;
            slice(r11, r11 + r12).get(r10);
            this.pos += r12;
            return r10;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            long r8 = this.pos;
            if ((this.limit - r8) < 4) goto L7;
            this.pos = 4 + r8;
            return (((UnsafeUtil.getByte(r8) & 255) | ((UnsafeUtil.getByte(1 + r8) & 255) << 8)) | ((UnsafeUtil.getByte(2 + r8) & 255) << 16)) | ((UnsafeUtil.getByte(r8 + 3) & 255) << 24);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            long r8 = this.pos;
            if ((this.limit - r8) < 8) goto L7;
            this.pos = 8 + r8;
            long r10 = ((((((((long) UnsafeUtil.getByte(r8)) & 255) | ((((long) UnsafeUtil.getByte(1 + r8)) & 255) << 8)) | ((((long) UnsafeUtil.getByte(2 + r8)) & 255) << 16)) | ((((long) UnsafeUtil.getByte(3 + r8)) & 255) << 24)) | ((((long) UnsafeUtil.getByte(4 + r8)) & 255) << 32)) | ((((long) UnsafeUtil.getByte(5 + r8)) & 255) << 40)) | ((((long) UnsafeUtil.getByte(6 + r8)) & 255) << 48);
            return ((((long) UnsafeUtil.getByte(r8 + 7)) & 255) << 56) | r10;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() {
            long r8 = this.pos;
            if (this.limit == r8) goto L35;
            long r10 = r8 + 1;
            byte r11 = UnsafeUtil.getByte(r8);
            if (r11 < 0) goto L10;
            this.pos = r10;
            return r11;
        L10:
            if ((this.limit - r10) < 9) goto L35;
            long r12 = r10 + 1;
            int r13 = r11 ^ (UnsafeUtil.getByte(r10) << 7);
            if (r13 >= 0) goto L15;
            int r14 = r13 ^ QesdkUtils.LIMITS.INT_8_LOWER;
        L36:
            this.pos = r12;
            return r14;
        L15:
            long r15 = r12 + 1;
            int r16 = r13 ^ (UnsafeUtil.getByte(r12) << 14);
            if (r16 < 0) goto L19;
            r14 = r16 ^ 16256;
        L18:
            r12 = r15;
            goto L36
        L19:
            r12 = r15 + 1;
            int r17 = r16 ^ (UnsafeUtil.getByte(r15) << BWDLCommandBuilder.CHANNEL_CONFIG_REQ);
            if (r17 >= 0) goto L22;
            r14 = r17 ^ (-2080896);
            goto L36
        L22:
            r15 = r12 + 1;
            byte r18 = UnsafeUtil.getByte(r12);
            r14 = (r17 ^ (r18 << 28)) ^ 266354560;
            if (r18 >= 0) goto L18;
            r12 = r15 + 1;
            if (UnsafeUtil.getByte(r15) >= 0) goto L36;
            r15 = r12 + 1;
            if (UnsafeUtil.getByte(r12) >= 0) goto L18;
            r12 = r15 + 1;
            if (UnsafeUtil.getByte(r15) >= 0) goto L36;
            r15 = r12 + 1;
            if (UnsafeUtil.getByte(r12) >= 0) goto L18;
            r12 = r15 + 1;
            if (UnsafeUtil.getByte(r15) >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() {
            long r8 = this.pos;
            if (this.limit == r8) goto L42;
            long r10 = r8 + 1;
            byte r11 = UnsafeUtil.getByte(r8);
            if (r11 < 0) goto L10;
            this.pos = r10;
            return r11;
        L10:
            if ((this.limit - r10) < 9) goto L42;
            long r12 = r10 + 1;
            int r13 = r11 ^ (UnsafeUtil.getByte(r10) << 7);
            if (r13 >= 0) goto L16;
            int r14 = r13 ^ QesdkUtils.LIMITS.INT_8_LOWER;
        L15:
            long r15 = r14;
        L44:
            this.pos = r12;
            return r15;
        L16:
            long r16 = r12 + 1;
            int r17 = r13 ^ (UnsafeUtil.getByte(r12) << 14);
            if (r17 < 0) goto L20;
            r15 = r17 ^ 16256;
        L19:
            r12 = r16;
            goto L44
        L20:
            r12 = r16 + 1;
            int r18 = r17 ^ (UnsafeUtil.getByte(r16) << BWDLCommandBuilder.CHANNEL_CONFIG_REQ);
            if (r18 >= 0) goto L23;
            r14 = r18 ^ (-2080896);
            goto L15
        L23:
            r16 = r12 + 1;
            long r19 = ((long) r18) ^ (((long) UnsafeUtil.getByte(r12)) << 28);
            if (r19 < 0) goto L27;
            long r20 = 266354560;
        L26:
            r15 = r19 ^ r20;
            goto L19
        L27:
            long r21 = r16 + 1;
            long r22 = r19 ^ (((long) UnsafeUtil.getByte(r16)) << 35);
            if (r22 >= 0) goto L31;
            long r23 = -34093383808L;
        L30:
            r15 = r22 ^ r23;
            r12 = r21;
            goto L44
        L31:
            r16 = r21 + 1;
            r19 = r22 ^ (((long) UnsafeUtil.getByte(r21)) << 42);
            if (r19 < 0) goto L34;
            r20 = 4363953127296L;
            goto L26
        L34:
            r21 = r16 + 1;
            r22 = r19 ^ (((long) UnsafeUtil.getByte(r16)) << 49);
            if (r22 >= 0) goto L37;
            r23 = -558586000294016L;
            goto L30
        L37:
            r16 = r21 + 1;
            r15 = (r22 ^ (((long) UnsafeUtil.getByte(r21)) << 56)) ^ 71499008037633920L;
            if (r15 >= 0) goto L19;
            long r24 = 1 + r16;
            if (UnsafeUtil.getByte(r16) < 0) goto L42;
            r12 = r24;
        L42:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() {
            long r8 = 0;
            int r10 = 0;
        L4:
            if (r10 >= 64) goto L10;
            byte r11 = readRawByte();
            r8 = r8 | (((long) (r11 & 127)) << r10);
            if ((r11 & 128) == 0) goto L7;
            r10 = r10 + 7;
            goto L4
        L7:
            return r8;
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
            int r8 = readRawVarint32();
            if (r8 > 0) goto L5;
        L8:
            if (r8 != 0) goto L11;
            return "";
        L11:
            if (r8 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r8 > remaining()) goto L8;
            byte[] r10 = new byte[r8];
            long r11 = r8;
            UnsafeUtil.copyMemory(this.pos, r10, 0, r11);
            String r12 = new String(r10, Internal.UTF_8);
            this.pos += r11;
            return r12;
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            int r8 = readRawVarint32();
            if (r8 > 0) goto L5;
        L8:
            if (r8 != 0) goto L11;
            return "";
        L11:
            if (r8 > 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r8 > remaining()) goto L8;
            String r10 = Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), r8);
            this.pos += (long) r8;
            return r10;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r8 = readRawVarint32();
            this.lastTag = r8;
            if (WireFormat.getTagFieldNumber(r8) == 0) goto L11;
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
        public void readUnknownGroup(int r8, MessageLite.Builder r10) {
            readGroup(r8, r10, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r8) {
            int r10 = WireFormat.getTagWireType(r8);
            if (r10 == 0) goto L24;
            if (r10 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r10 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r10 == 3) goto L18;
            if (r10 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r10 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(r8), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int r8) {
            if (r8 >= 0) goto L4;
        L7:
            if (r8 >= 0) goto L11;
            throw InvalidProtocolBufferException.negativeSize();
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (r8 > remaining()) goto L7;
            this.pos += (long) r8;
        }

        public /* synthetic */ UnsafeDirectNioDecoder(ByteBuffer r8, boolean r10, AnonymousClass1 r11) {
            this(r8, r10);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int r8, MessageLite.Builder r10, ExtensionRegistryLite r11) {
            checkRecursionLimit();
            this.groupDepth++;
            r10.mergeFrom(this, r11);
            checkLastTagWas(WireFormat.makeTag(r8, 4));
            this.groupDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder r8, ExtensionRegistryLite r10) {
            int r11 = readRawVarint32();
            checkRecursionLimit();
            int r12 = pushLimit(r11);
            this.messageDepth++;
            r8.mergeFrom(this, r10);
            checkLastTagWas(0);
            this.messageDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r12);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int r8, CodedOutputStream r10) {
            int r11 = WireFormat.getTagWireType(r8);
            if (r11 == 0) goto L24;
            if (r11 != 1) goto L6;
            long r12 = readRawLittleEndian64();
            r10.writeUInt32NoTag(r8);
            r10.writeFixed64NoTag(r12);
            return true;
        L6:
            if (r11 != 2) goto L8;
            ByteString r13 = readBytes();
            r10.writeUInt32NoTag(r8);
            r10.writeBytesNoTag(r13);
            return true;
        L8:
            if (r11 == 3) goto L18;
            if (r11 != 4) goto L11;
            checkValidEndTag();
            return false;
        L11:
            if (r11 != 5) goto L15;
            int r14 = readRawLittleEndian32();
            r10.writeUInt32NoTag(r8);
            r10.writeFixed32NoTag(r14);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            r10.writeUInt32NoTag(r8);
            skipMessage(r10);
            int r15 = WireFormat.makeTag(WireFormat.getTagFieldNumber(r8), 4);
            checkLastTagWas(r15);
            r10.writeUInt32NoTag(r15);
            return true;
        L24:
            long r16 = readInt64();
            r10.writeUInt32NoTag(r8);
            r10.writeUInt64NoTag(r16);
            return true;
        }
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public static int decodeZigZag32(int r8) {
        int r10 = r8 >>> 1;
        return (-(r8 & 1)) ^ r10;
    }

    public static long decodeZigZag64(long r8) {
        long r10 = r8 >>> 1;
        return (-(r8 & 1)) ^ r10;
    }

    public static CodedInputStream newInstance(InputStream r8) {
        return newInstance(r8, 4096);
    }

    public static int readRawVarint32(int r8, InputStream r10) {
        if ((r8 & 128) != 0) goto L5;
        return r8;
    L5:
        int r11 = r8 & QesdkUtils.LIMITS.INT_8_UPPER;
        int r12 = 7;
    L7:
        if (r12 >= 32) goto L17;
        int r13 = r10.read();
        if (r13 == (-1)) goto L15;
        r11 = r11 | ((r13 & QesdkUtils.LIMITS.INT_8_UPPER) << r12);
        if ((r13 & 128) == 0) goto L12;
        r12 = r12 + 7;
        goto L7
    L12:
        return r11;
    L15:
        throw InvalidProtocolBufferException.truncatedMessage();
    L17:
        if (r12 >= 64) goto L27;
        int r14 = r10.read();
        if (r14 == (-1)) goto L25;
        if ((r14 & 128) == 0) goto L22;
        r12 = r12 + 7;
        goto L17
    L22:
        return r11;
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public abstract void checkLastTagWas(int r8);

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

    public final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    public abstract void enableAliasing(boolean r8);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd();

    public abstract void popLimit(int r8);

    public abstract int pushLimit(int r8);

    public abstract boolean readBool();

    public abstract byte[] readByteArray();

    public abstract ByteBuffer readByteBuffer();

    public abstract ByteString readBytes();

    public abstract double readDouble();

    public abstract int readEnum();

    public abstract int readFixed32();

    public abstract long readFixed64();

    public abstract float readFloat();

    public abstract <T extends MessageLite> T readGroup(int r8, Parser<T> r10, ExtensionRegistryLite r11);

    public abstract void readGroup(int r8, MessageLite.Builder r10, ExtensionRegistryLite r11);

    public abstract int readInt32();

    public abstract long readInt64();

    public abstract <T extends MessageLite> T readMessage(Parser<T> r8, ExtensionRegistryLite r10);

    public abstract void readMessage(MessageLite.Builder r8, ExtensionRegistryLite r10);

    public Object readPrimitiveField(WireFormat.FieldType r8, WireFormat.Utf8Validation r10) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r8.ordinal()]) {
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            case 6: goto L31;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L25;
            case 10: goto L23;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            case 17: goto L9;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalStateException("Unknown field type: " + r8);
    L7:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    L9:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    L11:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    L13:
        return readString(r10);
    L15:
        return Long.valueOf(readSInt64());
    L17:
        return Integer.valueOf(readSInt32());
    L19:
        return Long.valueOf(readSFixed64());
    L21:
        return Integer.valueOf(readSFixed32());
    L23:
        return Integer.valueOf(readUInt32());
    L25:
        return readBytes();
    L27:
        return Boolean.valueOf(readBool());
    L29:
        return Integer.valueOf(readFixed32());
    L31:
        return Long.valueOf(readFixed64());
    L33:
        return Integer.valueOf(readInt32());
    L35:
        return Long.valueOf(readUInt64());
    L37:
        return Long.valueOf(readInt64());
    L39:
        return Float.valueOf(readFloat());
    L41:
        return Double.valueOf(readDouble());
    }

    public abstract byte readRawByte();

    public abstract byte[] readRawBytes(int r8);

    public abstract int readRawLittleEndian32();

    public abstract long readRawLittleEndian64();

    public abstract int readRawVarint32();

    public abstract long readRawVarint64();

    public abstract long readRawVarint64SlowPath();

    public abstract int readSFixed32();

    public abstract long readSFixed64();

    public abstract int readSInt32();

    public abstract long readSInt64();

    public Object readString(WireFormat.Utf8Validation r8) {
        int r10 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$Utf8Validation[r8.ordinal()];
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L13;
        if (r10 != 3) goto L11;
        return readBytes();
    L11:
        throw new IllegalStateException("Unknown UTF8 validation: " + r8);
    L13:
        return readStringRequireUtf8();
    L15:
        return readString();
    }

    public abstract String readString();

    public abstract String readStringRequireUtf8();

    public abstract int readTag();

    public abstract int readUInt32();

    public abstract long readUInt64();

    @Deprecated
    public abstract void readUnknownGroup(int r8, MessageLite.Builder r10);

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int r8) {
        if (r8 < 0) goto L6;
        int r10 = this.recursionLimit;
        this.recursionLimit = r8;
        return r10;
    L6:
        throw new IllegalArgumentException(defpackage.a.d("Recursion limit cannot be negative: ", r8));
    }

    public final int setSizeLimit(int r8) {
        if (r8 < 0) goto L6;
        int r10 = this.sizeLimit;
        this.sizeLimit = r8;
        return r10;
    L6:
        throw new IllegalArgumentException(defpackage.a.d("Size limit cannot be negative: ", r8));
    }

    public final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public abstract boolean skipField(int r8);

    @Deprecated
    public abstract boolean skipField(int r8, CodedOutputStream r10);

    public void skipMessage() {
    L2:
        int r8 = readTag();
        if (r8 == 0) goto L4;
        checkRecursionLimit();
        this.groupDepth++;
        boolean r10 = skipField(r8);
        this.groupDepth--;
        if (r10 == true) goto L2;
        return;
    }

    public abstract void skipRawBytes(int r8);

    public final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    public /* synthetic */ CodedInputStream(AnonymousClass1 r8) {
        this();
    }

    public static CodedInputStream newInstance(InputStream r8, int r10) {
        if (r10 <= 0) goto L9;
        if (r8 != null) goto L7;
        return newInstance(Internal.EMPTY_BYTE_ARRAY);
    L7:
        return new StreamDecoder(r8, r10, null);
    L9:
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static int readRawVarint32(InputStream r8) {
        int r10 = r8.read();
        if (r10 == (-1)) goto L7;
        return readRawVarint32(r10, r8);
    L7:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public void skipMessage(CodedOutputStream r8) {
    L2:
        int r10 = readTag();
        if (r10 == 0) goto L4;
        checkRecursionLimit();
        this.groupDepth++;
        boolean r11 = skipField(r10, r8);
        this.groupDepth--;
        if (r11 == true) goto L2;
        return;
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> r8) {
        if (UnsafeDirectNioDecoder.isSupported() == true) goto L7;
        return newInstance(new IterableByteBufferInputStream(r8));
    L7:
        return newInstance(r8, false);
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> r8, boolean r10) {
        Iterator<ByteBuffer> r11 = r8.iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L13;
        ByteBuffer r14 = r11.next();
        r13 = r13 + r14.remaining();
        if (r14.hasArray() == true) goto L7;
        if (r14.isDirect() == true) goto L10;
        r12 = r12 | 4;
        goto L4
    L10:
        r12 = r12 | 2;
        goto L4
    L7:
        r12 = r12 | 1;
        goto L4
    L13:
        if (r12 != 2) goto L17;
        return new IterableDirectByteBufferDecoder(r8, r13, r10, null);
    L17:
        return newInstance(new IterableByteBufferInputStream(r8));
    }

    public static CodedInputStream newInstance(ByteBuffer r8) {
        return newInstance(r8, false);
    }

    public static CodedInputStream newInstance(ByteBuffer r8, boolean r10) {
        if (r8.hasArray() == false) goto L7;
        byte[] r11 = r8.array();
        int r12 = r8.arrayOffset();
        return newInstance(r11, r8.position() + r12, r8.remaining(), r10);
    L7:
        if (r8.isDirect() == true) goto L9;
    L12:
        int r13 = r8.remaining();
        byte[] r14 = new byte[r13];
        r8.duplicate().get(r14);
        return newInstance(r14, 0, r13, true);
    L9:
        if (UnsafeDirectNioDecoder.isSupported() == false) goto L12;
        return new UnsafeDirectNioDecoder(r8, r10, null);
    }

    public static CodedInputStream newInstance(byte[] r8) {
        return newInstance(r8, 0, r8.length);
    }

    public static CodedInputStream newInstance(byte[] r8, int r10, int r11) {
        return newInstance(r8, r10, r11, false);
    }

    public static CodedInputStream newInstance(byte[] r8, int r10, int r11, boolean r12) {
        ArrayDecoder r13 = new ArrayDecoder(r8, r10, r11, r12, null);
        r13.pushLimit(r11);     // Catch: InvalidProtocolBufferException -> L5
        return r13;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
