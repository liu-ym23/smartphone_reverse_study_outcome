package com.google.protobuf;

import com.qualcomm.qti.qesdk.QesdkUtils;
import com.sdk.bwdl.StateMachine.BWDLCommandBuilder;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    /* JADX INFO: renamed from: com.google.protobuf.BinaryReader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r8 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r8;
            r8[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    public static final class SafeHeapReader extends BinaryReader {
        private final byte[] buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;
        private int limit;
        private int pos;
        private int tag;

        public SafeHeapReader(ByteBuffer r8, boolean r10) {
            super(null);
            this.bufferIsImmutable = r10;
            this.buffer = r8.array();
            int r11 = r8.arrayOffset();
            int r12 = r8.position() + r11;
            this.pos = r12;
            this.initialPos = r12;
            int r13 = r8.arrayOffset();
            this.limit = r8.limit() + r13;
        }

        private boolean isAtEnd() {
            if (this.pos != this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        private byte readByte() {
            int r8 = this.pos;
            if (r8 == this.limit) goto L7;
            byte[] r10 = this.buffer;
            this.pos = r8 + 1;
            return r10[r8];
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private Object readField(WireFormat.FieldType r8, Class<?> r10, ExtensionRegistryLite r11) {
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r8.ordinal()]) {
                case 1: goto L39;
                case 2: goto L37;
                case 3: goto L35;
                case 4: goto L33;
                case 5: goto L31;
                case 6: goto L29;
                case 7: goto L27;
                case 8: goto L25;
                case 9: goto L23;
                case 10: goto L21;
                case 11: goto L19;
                case 12: goto L17;
                case 13: goto L15;
                case 14: goto L13;
                case 15: goto L11;
                case 16: goto L9;
                case 17: goto L7;
                default: goto L5;
            };
        L5:
            throw new RuntimeException("unsupported field type.");
        L7:
            return Long.valueOf(readUInt64());
        L9:
            return Integer.valueOf(readUInt32());
        L11:
            return readStringRequireUtf8();
        L13:
            return Long.valueOf(readSInt64());
        L15:
            return Integer.valueOf(readSInt32());
        L17:
            return Long.valueOf(readSFixed64());
        L19:
            return Integer.valueOf(readSFixed32());
        L21:
            return readMessage(r10, r11);
        L23:
            return Long.valueOf(readInt64());
        L25:
            return Integer.valueOf(readInt32());
        L27:
            return Float.valueOf(readFloat());
        L29:
            return Long.valueOf(readFixed64());
        L31:
            return Integer.valueOf(readFixed32());
        L33:
            return Integer.valueOf(readEnum());
        L35:
            return Double.valueOf(readDouble());
        L37:
            return readBytes();
        L39:
            return Boolean.valueOf(readBool());
        }

        private <T> T readGroup(Schema<T> r8, ExtensionRegistryLite r10) {
            T r11 = r8.newInstance();
            mergeGroupField(r11, r8, r10);
            r8.makeImmutable(r11);
            return r11;
        }

        private int readLittleEndian32() {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int r8 = this.pos;
            byte[] r10 = this.buffer;
            this.pos = r8 + 4;
            return (((r10[r8] & 255) | ((r10[r8 + 1] & 255) << 8)) | ((r10[r8 + 2] & 255) << 16)) | ((r10[r8 + 3] & 255) << 24);
        }

        private long readLittleEndian64() {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private long readLittleEndian64_NoCheck() {
            int r8 = this.pos;
            byte[] r10 = this.buffer;
            this.pos = r8 + 8;
            long r11 = ((((((((long) r10[r8]) & 255) | ((((long) r10[r8 + 1]) & 255) << 8)) | ((((long) r10[r8 + 2]) & 255) << 16)) | ((((long) r10[r8 + 3]) & 255) << 24)) | ((((long) r10[r8 + 4]) & 255) << 32)) | ((((long) r10[r8 + 5]) & 255) << 40)) | ((((long) r10[r8 + 6]) & 255) << 48);
            return ((((long) r10[r8 + 7]) & 255) << 56) | r11;
        }

        private <T> T readMessage(Schema<T> r8, ExtensionRegistryLite r10) {
            T r11 = r8.newInstance();
            mergeMessageField(r11, r8, r10);
            r8.makeImmutable(r11);
            return r11;
        }

        private int readVarint32() {
            int r8 = this.pos;
            int r10 = this.limit;
            if (r10 == r8) goto L40;
            byte[] r11 = this.buffer;
            int r12 = r8 + 1;
            byte r13 = r11[r8];
            if (r13 < 0) goto L9;
            this.pos = r12;
            return r13;
        L9:
            if ((r10 - r12) < 9) goto L11;
            int r14 = r12 + 1;
            int r15 = r13 ^ (r11[r12] << 7);
            if (r15 >= 0) goto L15;
            int r16 = r15 ^ QesdkUtils.LIMITS.INT_8_LOWER;
        L37:
            this.pos = r14;
            return r16;
        L15:
            int r17 = r14 + 1;
            int r18 = r15 ^ (r11[r14] << 14);
            if (r18 < 0) goto L19;
            r16 = r18 ^ 16256;
        L18:
            r14 = r17;
            goto L37
        L19:
            r14 = r17 + 1;
            int r19 = r18 ^ (r11[r17] << BWDLCommandBuilder.CHANNEL_CONFIG_REQ);
            if (r19 >= 0) goto L22;
            r16 = r19 ^ (-2080896);
            goto L37
        L22:
            r17 = r14 + 1;
            byte r20 = r11[r14];
            r16 = (r19 ^ (r20 << 28)) ^ 266354560;
            if (r20 >= 0) goto L18;
            r14 = r17 + 1;
            if (r11[r17] >= 0) goto L37;
            r17 = r14 + 1;
            if (r11[r14] >= 0) goto L18;
            r14 = r17 + 1;
            if (r11[r17] >= 0) goto L37;
            r17 = r14 + 1;
            if (r11[r14] >= 0) goto L18;
            r14 = r17 + 1;
            if (r11[r17] >= 0) goto L37;
            throw InvalidProtocolBufferException.malformedVarint();
        L11:
            return (int) readVarint64SlowPath();
        L40:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private long readVarint64SlowPath() {
            long r8 = 0;
            int r10 = 0;
        L4:
            if (r10 >= 64) goto L10;
            byte r11 = readByte();
            r8 = r8 | (((long) (r11 & 127)) << r10);
            if ((r11 & 128) == 0) goto L7;
            r10 = r10 + 7;
            goto L4
        L7:
            return r8;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void requireBytes(int r8) {
            if (r8 < 0) goto L7;
            if (r8 > (this.limit - this.pos)) goto L7;
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void requirePosition(int r8) {
            if (this.pos != r8) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void requireWireType(int r8) {
            if (WireFormat.getTagWireType(this.tag) != r8) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        private void skipBytes(int r8) {
            requireBytes(r8);
            this.pos += r8;
        }

        private void skipGroup() {
            int r8 = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
        L4:
            if (getFieldNumber() == Integer.MAX_VALUE) goto L8;
            if (skipField() == true) goto L4;
        L8:
            if (this.tag != this.endGroupTag) goto L12;
            this.endGroupTag = r8;
            return;
        L12:
            throw InvalidProtocolBufferException.parseFailure();
        }

        private void skipVarint() {
            int r8 = this.limit;
            int r10 = this.pos;
            if ((r8 - r10) < 10) goto L11;
            byte[] r11 = this.buffer;
            int r12 = 0;
        L5:
            if (r12 >= 10) goto L11;
            int r13 = r10 + 1;
            if (r11[r10] >= 0) goto L8;
            r12 = r12 + 1;
            r10 = r13;
            goto L5
        L8:
            this.pos = r13;
            return;
        L11:
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() {
            int r8 = 0;
        L4:
            if (r8 >= 10) goto L10;
            if (readByte() >= 0) goto L7;
            r8 = r8 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void verifyPackedFixed32Length(int r8) {
            requireBytes(r8);
            if ((r8 & 3) != 0) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.parseFailure();
        }

        private void verifyPackedFixed64Length(int r8) {
            requireBytes(r8);
            if ((r8 & 7) != 0) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.parseFailure();
        }

        @Override // com.google.protobuf.Reader
        public int getFieldNumber() {
            if (isAtEnd() == false) goto L5;
            return Integer.MAX_VALUE;
        L5:
            int r8 = readVarint32();
            this.tag = r8;
            if (r8 != this.endGroupTag) goto L9;
            return Integer.MAX_VALUE;
        L9:
            return WireFormat.getTagFieldNumber(r8);
        }

        @Override // com.google.protobuf.Reader
        public int getTag() {
            return this.tag;
        }

        @Override // com.google.protobuf.BinaryReader
        public int getTotalBytesRead() {
            return this.pos - this.initialPos;
        }

        @Override // com.google.protobuf.Reader
        public <T> void mergeGroupField(T r8, Schema<T> r10, ExtensionRegistryLite r11) {
            int r12 = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            r10.mergeFrom(r8, this, r11);     // Catch: Throwable -> L9
            if (this.tag != this.endGroupTag) goto L8;
            this.endGroupTag = r12;
            return;
        L8:
            throw InvalidProtocolBufferException.parseFailure();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            this.endGroupTag = r12;
            throw th;
        }

        @Override // com.google.protobuf.Reader
        public <T> void mergeMessageField(T r8, Schema<T> r10, ExtensionRegistryLite r11) {
            int r12 = readVarint32();
            requireBytes(r12);
            int r13 = this.limit;
            int r14 = this.pos + r12;
            this.limit = r14;
            r10.mergeFrom(r8, this, r11);     // Catch: Throwable -> L9
            if (this.pos != r14) goto L8;
            this.limit = r13;
            return;
        L8:
            throw InvalidProtocolBufferException.parseFailure();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            this.limit = r13;
            throw th;
        }

        @Override // com.google.protobuf.Reader
        public boolean readBool() {
            requireWireType(0);
            if (readVarint32() == 0) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // com.google.protobuf.Reader
        public void readBoolList(List<Boolean> r8) {
            if ((r8 instanceof BooleanArrayList) == false) goto L24;
            BooleanArrayList r10 = (BooleanArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 0) goto L17;
            if (r11 != 2) goto L16;
            int r12 = this.pos + readVarint32();
        L9:
            if (this.pos >= r12) goto L35;
            if (readVarint32() == 0) goto L13;
            boolean r13 = true;
        L14:
            r10.addBoolean(r13);
            goto L9
        L13:
            r13 = false;
        L35:
            requirePosition(r12);
            return;
        L16:
            throw InvalidProtocolBufferException.invalidWireType();
        L17:
            r10.addBoolean(readBool());
            if (isAtEnd() == true) goto L19;
            int r14 = this.pos;
            if (readVarint32() == this.tag) goto L17;
            this.pos = r14;
            return;
        L19:
            return;
        L24:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 0) goto L39;
            if (r15 != 2) goto L38;
            r12 = this.pos + readVarint32();
        L29:
            if (this.pos >= r12) goto L35;
            if (readVarint32() == 0) goto L33;
            boolean r16 = true;
        L34:
            r8.add(Boolean.valueOf(r16));
            goto L29
        L33:
            r16 = false;
            goto L34
        L38:
            throw InvalidProtocolBufferException.invalidWireType();
        L39:
            r8.add(Boolean.valueOf(readBool()));
            if (isAtEnd() == true) goto L41;
            int r17 = this.pos;
            if (readVarint32() == this.tag) goto L39;
            this.pos = r17;
            return;
        }

        @Override // com.google.protobuf.Reader
        public ByteString readBytes() {
            requireWireType(2);
            int r8 = readVarint32();
            if (r8 == 0) goto L5;
            requireBytes(r8);
            if (this.bufferIsImmutable == false) goto L9;
            ByteString r10 = ByteString.wrap(this.buffer, this.pos, r8);
        L10:
            this.pos += r8;
            return r10;
        L9:
            r10 = ByteString.copyFrom(this.buffer, this.pos, r8);
            goto L10
        L5:
            return ByteString.EMPTY;
        }

        @Override // com.google.protobuf.Reader
        public void readBytesList(List<ByteString> r8) {
            if (WireFormat.getTagWireType(this.tag) != 2) goto L12;
        L4:
            r8.add(readBytes());
            if (isAtEnd() == true) goto L6;
            int r10 = this.pos;
            if (readVarint32() == this.tag) goto L4;
            this.pos = r10;
            return;
        L6:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.Reader
        public double readDouble() {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        @Override // com.google.protobuf.Reader
        public void readDoubleList(List<Double> r8) {
            if ((r8 instanceof DoubleArrayList) == false) goto L20;
            DoubleArrayList r10 = (DoubleArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 1) goto L13;
            if (r11 != 2) goto L12;
            int r12 = readVarint32();
            verifyPackedFixed64Length(r12);
            int r13 = this.pos + r12;
        L9:
            if (this.pos >= r13) goto L27;
            r10.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r10.addDouble(readDouble());
            if (isAtEnd() == true) goto L15;
            int r14 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r14;
            return;
        L15:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 1) goto L30;
            if (r15 != 2) goto L29;
            int r16 = readVarint32();
            verifyPackedFixed64Length(r16);
            int r17 = this.pos + r16;
        L25:
            if (this.pos >= r17) goto L45;
            r8.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r8.add(Double.valueOf(readDouble()));
            if (isAtEnd() == true) goto L32;
            int r18 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r18;
            return;
        }

        @Override // com.google.protobuf.Reader
        public int readEnum() {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public void readEnumList(List<Integer> r8) {
            if ((r8 instanceof IntArrayList) == false) goto L20;
            IntArrayList r10 = (IntArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 0) goto L13;
            if (r11 != 2) goto L12;
            int r12 = readVarint32();
            int r13 = this.pos + r12;
        L9:
            if (this.pos >= r13) goto L27;
            r10.addInt(readVarint32());
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r10.addInt(readEnum());
            if (isAtEnd() == true) goto L15;
            int r14 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r14;
            return;
        L15:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 0) goto L30;
            if (r15 != 2) goto L29;
            int r16 = readVarint32();
            int r17 = this.pos + r16;
        L25:
            if (this.pos >= r17) goto L45;
            r8.add(Integer.valueOf(readVarint32()));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r8.add(Integer.valueOf(readEnum()));
            if (isAtEnd() == true) goto L32;
            int r18 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r18;
            return;
        }

        @Override // com.google.protobuf.Reader
        public int readFixed32() {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.protobuf.Reader
        public void readFixed32List(List<Integer> r8) {
            if ((r8 instanceof IntArrayList) == false) goto L20;
            IntArrayList r10 = (IntArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 2) goto L16;
            if (r11 != 5) goto L15;
        L7:
            r10.addInt(readFixed32());
            if (isAtEnd() == true) goto L9;
            int r12 = this.pos;
            if (readVarint32() == this.tag) goto L7;
            this.pos = r12;
            return;
        L9:
            return;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L16:
            int r13 = readVarint32();
            verifyPackedFixed32Length(r13);
            int r14 = this.pos + r13;
        L18:
            if (this.pos >= r14) goto L36;
            r10.addInt(readLittleEndian32_NoCheck());
            goto L18
        L36:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 2) goto L32;
            if (r15 != 5) goto L31;
        L23:
            r8.add(Integer.valueOf(readFixed32()));
            if (isAtEnd() == true) goto L25;
            int r16 = this.pos;
            if (readVarint32() == this.tag) goto L23;
            this.pos = r16;
            return;
        L25:
            return;
        L31:
            throw InvalidProtocolBufferException.invalidWireType();
        L32:
            int r17 = readVarint32();
            verifyPackedFixed32Length(r17);
            int r18 = this.pos + r17;
        L34:
            if (this.pos >= r18) goto L45;
            r8.add(Integer.valueOf(readLittleEndian32_NoCheck()));
            goto L34
        }

        @Override // com.google.protobuf.Reader
        public long readFixed64() {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.protobuf.Reader
        public void readFixed64List(List<Long> r8) {
            if ((r8 instanceof LongArrayList) == false) goto L20;
            LongArrayList r10 = (LongArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 1) goto L13;
            if (r11 != 2) goto L12;
            int r12 = readVarint32();
            verifyPackedFixed64Length(r12);
            int r13 = this.pos + r12;
        L9:
            if (this.pos >= r13) goto L27;
            r10.addLong(readLittleEndian64_NoCheck());
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r10.addLong(readFixed64());
            if (isAtEnd() == true) goto L15;
            int r14 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r14;
            return;
        L15:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 1) goto L30;
            if (r15 != 2) goto L29;
            int r16 = readVarint32();
            verifyPackedFixed64Length(r16);
            int r17 = this.pos + r16;
        L25:
            if (this.pos >= r17) goto L45;
            r8.add(Long.valueOf(readLittleEndian64_NoCheck()));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r8.add(Long.valueOf(readFixed64()));
            if (isAtEnd() == true) goto L32;
            int r18 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r18;
            return;
        }

        @Override // com.google.protobuf.Reader
        public float readFloat() {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        @Override // com.google.protobuf.Reader
        public void readFloatList(List<Float> r8) {
            if ((r8 instanceof FloatArrayList) == false) goto L20;
            FloatArrayList r10 = (FloatArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 2) goto L16;
            if (r11 != 5) goto L15;
        L7:
            r10.addFloat(readFloat());
            if (isAtEnd() == true) goto L9;
            int r12 = this.pos;
            if (readVarint32() == this.tag) goto L7;
            this.pos = r12;
            return;
        L9:
            return;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L16:
            int r13 = readVarint32();
            verifyPackedFixed32Length(r13);
            int r14 = this.pos + r13;
        L18:
            if (this.pos >= r14) goto L36;
            r10.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
            goto L18
        L36:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 2) goto L32;
            if (r15 != 5) goto L31;
        L23:
            r8.add(Float.valueOf(readFloat()));
            if (isAtEnd() == true) goto L25;
            int r16 = this.pos;
            if (readVarint32() == this.tag) goto L23;
            this.pos = r16;
            return;
        L25:
            return;
        L31:
            throw InvalidProtocolBufferException.invalidWireType();
        L32:
            int r17 = readVarint32();
            verifyPackedFixed32Length(r17);
            int r18 = this.pos + r17;
        L34:
            if (this.pos >= r18) goto L45;
            r8.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
            goto L34
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> T readGroupBySchemaWithCheck(Schema<T> r8, ExtensionRegistryLite r10) {
            requireWireType(3);
            return (T) readGroup(r8, r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> r8, Schema<T> r10, ExtensionRegistryLite r11) {
            if (WireFormat.getTagWireType(this.tag) != 3) goto L13;
            int r12 = this.tag;
        L5:
            r8.add(readGroup(r10, r11));
            if (isAtEnd() == true) goto L7;
            int r13 = this.pos;
            if (readVarint32() == r12) goto L5;
            this.pos = r13;
            return;
        L7:
            return;
        L13:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.Reader
        public int readInt32() {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public void readInt32List(List<Integer> r8) {
            if ((r8 instanceof IntArrayList) == false) goto L20;
            IntArrayList r10 = (IntArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 0) goto L13;
            if (r11 != 2) goto L12;
            int r12 = readVarint32();
            int r13 = this.pos + r12;
        L9:
            if (this.pos >= r13) goto L27;
            r10.addInt(readVarint32());
        L27:
            requirePosition(r13);
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r10.addInt(readInt32());
            if (isAtEnd() == true) goto L15;
            int r14 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r14;
            return;
        L15:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 0) goto L31;
            if (r15 != 2) goto L30;
            int r16 = readVarint32();
            r13 = this.pos + r16;
        L25:
            if (this.pos >= r13) goto L27;
            r8.add(Integer.valueOf(readVarint32()));
            goto L25
        L30:
            throw InvalidProtocolBufferException.invalidWireType();
        L31:
            r8.add(Integer.valueOf(readInt32()));
            if (isAtEnd() == true) goto L33;
            int r17 = this.pos;
            if (readVarint32() == this.tag) goto L31;
            this.pos = r17;
            return;
        }

        @Override // com.google.protobuf.Reader
        public long readInt64() {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.protobuf.Reader
        public void readInt64List(List<Long> r8) {
            if ((r8 instanceof LongArrayList) == false) goto L20;
            LongArrayList r10 = (LongArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 0) goto L13;
            if (r11 != 2) goto L12;
            int r12 = readVarint32();
            int r13 = this.pos + r12;
        L9:
            if (this.pos >= r13) goto L27;
            r10.addLong(readVarint64());
        L27:
            requirePosition(r13);
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r10.addLong(readInt64());
            if (isAtEnd() == true) goto L15;
            int r14 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r14;
            return;
        L15:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 0) goto L31;
            if (r15 != 2) goto L30;
            int r16 = readVarint32();
            r13 = this.pos + r16;
        L25:
            if (this.pos >= r13) goto L27;
            r8.add(Long.valueOf(readVarint64()));
            goto L25
        L30:
            throw InvalidProtocolBufferException.invalidWireType();
        L31:
            r8.add(Long.valueOf(readInt64()));
            if (isAtEnd() == true) goto L33;
            int r17 = this.pos;
            if (readVarint32() == this.tag) goto L31;
            this.pos = r17;
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public <K, V> void readMap(Map<K, V> r8, MapEntryLite.Metadata<K, V> r10, ExtensionRegistryLite r11) {
            requireWireType(2);
            int r12 = readVarint32();
            requireBytes(r12);
            int r13 = this.limit;
            this.limit = this.pos + r12;
            Object r14 = r10.defaultKey;     // Catch: Throwable -> L26
            Object r15 = r10.defaultValue;     // Catch: Throwable -> L26
        L4:
            int r16 = getFieldNumber();     // Catch: Throwable -> L26
            if (r16 == Integer.MAX_VALUE) goto L6;
            if (r16 != 1) goto L11;
            r14 = readField(r10.keyType, null, null);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L20 Throwable -> L26
            goto L4
        L11:
            if (r16 == 2) goto L17;
        L20:
            e = move-exception;
            if (skipField() == true) goto L4;
            throw new InvalidProtocolBufferException("Unable to parse map entry.", e);     // Catch: Throwable -> L26
        L13:
            if (skipField() == true) goto L4;
            throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L20 Throwable -> L26
        L17:
            r15 = readField(r10.valueType, r10.defaultValue.getClass(), r11);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L20 Throwable -> L26
            goto L4
        L6:
            r8.put(r14, r15);     // Catch: Throwable -> L26
            this.limit = r13;
            return;
        L26:
            th = move-exception;
            this.limit = r13;
            throw th;
        }

        @Override // com.google.protobuf.Reader
        public <T> T readMessageBySchemaWithCheck(Schema<T> r8, ExtensionRegistryLite r10) {
            requireWireType(2);
            return (T) readMessage(r8, r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public <T> void readMessageList(List<T> r8, Schema<T> r10, ExtensionRegistryLite r11) {
            if (WireFormat.getTagWireType(this.tag) != 2) goto L13;
            int r12 = this.tag;
        L5:
            r8.add(readMessage(r10, r11));
            if (isAtEnd() == true) goto L7;
            int r13 = this.pos;
            if (readVarint32() == r12) goto L5;
            this.pos = r13;
            return;
        L7:
            return;
        L13:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.Reader
        public int readSFixed32() {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.protobuf.Reader
        public void readSFixed32List(List<Integer> r8) {
            if ((r8 instanceof IntArrayList) == false) goto L20;
            IntArrayList r10 = (IntArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 2) goto L16;
            if (r11 != 5) goto L15;
        L7:
            r10.addInt(readSFixed32());
            if (isAtEnd() == true) goto L9;
            int r12 = this.pos;
            if (readVarint32() == this.tag) goto L7;
            this.pos = r12;
            return;
        L9:
            return;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L16:
            int r13 = readVarint32();
            verifyPackedFixed32Length(r13);
            int r14 = this.pos + r13;
        L18:
            if (this.pos >= r14) goto L36;
            r10.addInt(readLittleEndian32_NoCheck());
            goto L18
        L36:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 2) goto L32;
            if (r15 != 5) goto L31;
        L23:
            r8.add(Integer.valueOf(readSFixed32()));
            if (isAtEnd() == true) goto L25;
            int r16 = this.pos;
            if (readVarint32() == this.tag) goto L23;
            this.pos = r16;
            return;
        L25:
            return;
        L31:
            throw InvalidProtocolBufferException.invalidWireType();
        L32:
            int r17 = readVarint32();
            verifyPackedFixed32Length(r17);
            int r18 = this.pos + r17;
        L34:
            if (this.pos >= r18) goto L45;
            r8.add(Integer.valueOf(readLittleEndian32_NoCheck()));
            goto L34
        }

        @Override // com.google.protobuf.Reader
        public long readSFixed64() {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.protobuf.Reader
        public void readSFixed64List(List<Long> r8) {
            if ((r8 instanceof LongArrayList) == false) goto L20;
            LongArrayList r10 = (LongArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 1) goto L13;
            if (r11 != 2) goto L12;
            int r12 = readVarint32();
            verifyPackedFixed64Length(r12);
            int r13 = this.pos + r12;
        L9:
            if (this.pos >= r13) goto L27;
            r10.addLong(readLittleEndian64_NoCheck());
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r10.addLong(readSFixed64());
            if (isAtEnd() == true) goto L15;
            int r14 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r14;
            return;
        L15:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 1) goto L30;
            if (r15 != 2) goto L29;
            int r16 = readVarint32();
            verifyPackedFixed64Length(r16);
            int r17 = this.pos + r16;
        L25:
            if (this.pos >= r17) goto L45;
            r8.add(Long.valueOf(readLittleEndian64_NoCheck()));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r8.add(Long.valueOf(readSFixed64()));
            if (isAtEnd() == true) goto L32;
            int r18 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r18;
            return;
        }

        @Override // com.google.protobuf.Reader
        public int readSInt32() {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        @Override // com.google.protobuf.Reader
        public void readSInt32List(List<Integer> r8) {
            if ((r8 instanceof IntArrayList) == false) goto L20;
            IntArrayList r10 = (IntArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 0) goto L13;
            if (r11 != 2) goto L12;
            int r12 = readVarint32();
            int r13 = this.pos + r12;
        L9:
            if (this.pos >= r13) goto L27;
            r10.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r10.addInt(readSInt32());
            if (isAtEnd() == true) goto L15;
            int r14 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r14;
            return;
        L15:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 0) goto L30;
            if (r15 != 2) goto L29;
            int r16 = readVarint32();
            int r17 = this.pos + r16;
        L25:
            if (this.pos >= r17) goto L45;
            r8.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r8.add(Integer.valueOf(readSInt32()));
            if (isAtEnd() == true) goto L32;
            int r18 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r18;
            return;
        }

        @Override // com.google.protobuf.Reader
        public long readSInt64() {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        @Override // com.google.protobuf.Reader
        public void readSInt64List(List<Long> r8) {
            if ((r8 instanceof LongArrayList) == false) goto L20;
            LongArrayList r10 = (LongArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 0) goto L13;
            if (r11 != 2) goto L12;
            int r12 = readVarint32();
            int r13 = this.pos + r12;
        L9:
            if (this.pos >= r13) goto L27;
            r10.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r10.addLong(readSInt64());
            if (isAtEnd() == true) goto L15;
            int r14 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r14;
            return;
        L15:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 0) goto L30;
            if (r15 != 2) goto L29;
            int r16 = readVarint32();
            int r17 = this.pos + r16;
        L25:
            if (this.pos >= r17) goto L45;
            r8.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r8.add(Long.valueOf(readSInt64()));
            if (isAtEnd() == true) goto L32;
            int r18 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r18;
            return;
        }

        @Override // com.google.protobuf.Reader
        public String readString() {
            return readStringInternal(false);
        }

        public String readStringInternal(boolean r8) {
            requireWireType(2);
            int r10 = readVarint32();
            if (r10 != 0) goto L6;
            return "";
        L6:
            requireBytes(r10);
            if (r8 == false) goto L13;
            byte[] r11 = this.buffer;
            int r12 = this.pos;
            if (Utf8.isValidUtf8(r11, r12, r12 + r10) == true) goto L13;
            throw InvalidProtocolBufferException.invalidUtf8();
        L13:
            String r13 = new String(this.buffer, this.pos, r10, Internal.UTF_8);
            this.pos += r10;
            return r13;
        }

        @Override // com.google.protobuf.Reader
        public void readStringList(List<String> r8) {
            readStringListInternal(r8, false);
        }

        public void readStringListInternal(List<String> r8, boolean r10) {
            if (WireFormat.getTagWireType(this.tag) != 2) goto L23;
            if ((r8 instanceof LazyStringList) == false) goto L15;
            if (r10 == true) goto L15;
            LazyStringList r11 = (LazyStringList) r8;
        L8:
            r11.add(readBytes());
            if (isAtEnd() == true) goto L10;
            int r12 = this.pos;
            if (readVarint32() == this.tag) goto L8;
            this.pos = r12;
            return;
        L10:
            return;
        L15:
            r8.add(readStringInternal(r10));
            if (isAtEnd() == true) goto L17;
            int r13 = this.pos;
            if (readVarint32() == this.tag) goto L15;
            this.pos = r13;
            return;
        L17:
            return;
        L23:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.Reader
        public void readStringListRequireUtf8(List<String> r8) {
            readStringListInternal(r8, true);
        }

        @Override // com.google.protobuf.Reader
        public String readStringRequireUtf8() {
            return readStringInternal(true);
        }

        @Override // com.google.protobuf.Reader
        public int readUInt32() {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public void readUInt32List(List<Integer> r8) {
            if ((r8 instanceof IntArrayList) == false) goto L20;
            IntArrayList r10 = (IntArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 0) goto L13;
            if (r11 != 2) goto L12;
            int r12 = readVarint32();
            int r13 = this.pos + r12;
        L9:
            if (this.pos >= r13) goto L27;
            r10.addInt(readVarint32());
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r10.addInt(readUInt32());
            if (isAtEnd() == true) goto L15;
            int r14 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r14;
            return;
        L15:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 0) goto L30;
            if (r15 != 2) goto L29;
            int r16 = readVarint32();
            int r17 = this.pos + r16;
        L25:
            if (this.pos >= r17) goto L45;
            r8.add(Integer.valueOf(readVarint32()));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r8.add(Integer.valueOf(readUInt32()));
            if (isAtEnd() == true) goto L32;
            int r18 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r18;
            return;
        }

        @Override // com.google.protobuf.Reader
        public long readUInt64() {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.protobuf.Reader
        public void readUInt64List(List<Long> r8) {
            if ((r8 instanceof LongArrayList) == false) goto L20;
            LongArrayList r10 = (LongArrayList) r8;
            int r11 = WireFormat.getTagWireType(this.tag);
            if (r11 == 0) goto L13;
            if (r11 != 2) goto L12;
            int r12 = readVarint32();
            int r13 = this.pos + r12;
        L9:
            if (this.pos >= r13) goto L27;
            r10.addLong(readVarint64());
        L27:
            requirePosition(r13);
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r10.addLong(readUInt64());
            if (isAtEnd() == true) goto L15;
            int r14 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r14;
            return;
        L15:
            return;
        L20:
            int r15 = WireFormat.getTagWireType(this.tag);
            if (r15 == 0) goto L31;
            if (r15 != 2) goto L30;
            int r16 = readVarint32();
            r13 = this.pos + r16;
        L25:
            if (this.pos >= r13) goto L27;
            r8.add(Long.valueOf(readVarint64()));
            goto L25
        L30:
            throw InvalidProtocolBufferException.invalidWireType();
        L31:
            r8.add(Long.valueOf(readUInt64()));
            if (isAtEnd() == true) goto L33;
            int r17 = this.pos;
            if (readVarint32() == this.tag) goto L31;
            this.pos = r17;
            return;
        }

        public long readVarint64() {
            int r8 = this.pos;
            int r10 = this.limit;
            if (r10 == r8) goto L48;
            byte[] r11 = this.buffer;
            int r12 = r8 + 1;
            byte r13 = r11[r8];
            if (r13 < 0) goto L9;
            this.pos = r12;
            return r13;
        L9:
            if ((r10 - r12) < 9) goto L11;
            int r14 = r12 + 1;
            int r15 = r13 ^ (r11[r12] << 7);
            if (r15 >= 0) goto L16;
            int r16 = r15 ^ QesdkUtils.LIMITS.INT_8_LOWER;
        L15:
            long r17 = r16;
        L45:
            this.pos = r14;
            return r17;
        L16:
            int r18 = r14 + 1;
            int r19 = r15 ^ (r11[r14] << 14);
            if (r19 < 0) goto L19;
            r14 = r18;
            r17 = r19 ^ 16256;
            goto L45
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
            goto L45
        L26:
            r14 = r22 + 1;
            long r25 = r23 ^ (((long) r11[r22]) << 35);
            if (r25 >= 0) goto L30;
            long r26 = -34093383808L;
        L29:
            r17 = r25 ^ r26;
            goto L45
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
            if (r28 >= 0) goto L43;
            r14 = r27 + 1;
            if (r11[r27] < 0) goto L42;
        L44:
            r17 = r28;
            goto L45
        L42:
            throw InvalidProtocolBufferException.malformedVarint();
        L43:
            r14 = r27;
            goto L44
        L11:
            return readVarint64SlowPath();
        L48:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.Reader
        public boolean skipField() {
            if (isAtEnd() == true) goto L27;
            int r8 = this.tag;
            if (r8 == this.endGroupTag) goto L29;
            int r10 = WireFormat.getTagWireType(r8);
            if (r10 == 0) goto L25;
            if (r10 != 1) goto L11;
            int r11 = 8;
        L17:
            skipBytes(r11);
            return true;
        L11:
            if (r10 != 2) goto L13;
            r11 = readVarint32();
            goto L17
        L13:
            if (r10 != 3) goto L15;
            skipGroup();
            return true;
        L15:
            if (r10 != 5) goto L20;
            r11 = 4;
            goto L17
        L20:
            throw InvalidProtocolBufferException.invalidWireType();
        L25:
            skipVarint();
            return true;
        L29:
            return false;
        L27:
            return false;
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> T readGroup(Class<T> r8, ExtensionRegistryLite r10) {
            requireWireType(3);
            return (T) readGroup(Protobuf.getInstance().schemaFor(r8), r10);
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> r8, Class<T> r10, ExtensionRegistryLite r11) {
            readGroupList(r8, Protobuf.getInstance().schemaFor(r10), r11);
        }

        @Override // com.google.protobuf.Reader
        public <T> T readMessage(Class<T> r8, ExtensionRegistryLite r10) {
            requireWireType(2);
            return (T) readMessage(Protobuf.getInstance().schemaFor(r8), r10);
        }

        @Override // com.google.protobuf.Reader
        public <T> void readMessageList(List<T> r8, Class<T> r10, ExtensionRegistryLite r11) {
            readMessageList(r8, Protobuf.getInstance().schemaFor(r10), r11);
        }
    }

    private BinaryReader() {
    }

    public /* synthetic */ BinaryReader(AnonymousClass1 r8) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer r8, boolean r10) {
        if (r8.hasArray() == false) goto L7;
        return new SafeHeapReader(r8, r10);
    L7:
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    public abstract int getTotalBytesRead();

    @Override // com.google.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return false;
    }
}
