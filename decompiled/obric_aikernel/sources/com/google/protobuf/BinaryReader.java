package com.google.protobuf;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    /* JADX INFO: renamed from: com.google.protobuf.BinaryReader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r10 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r10;
            r10[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
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

    private static final class SafeHeapReader extends BinaryReader {
        private final byte[] buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;
        private int limit;
        private int pos;
        private int tag;

        public SafeHeapReader(ByteBuffer r10, boolean r11) {
            super(null);
            this.bufferIsImmutable = r11;
            this.buffer = r10.array();
            int r12 = r10.arrayOffset() + r10.position();
            this.pos = r12;
            this.initialPos = r12;
            this.limit = r10.arrayOffset() + r10.limit();
        }

        private boolean isAtEnd() {
            if (this.pos != this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        private byte readByte() {
            int r10 = this.pos;
            if (r10 == this.limit) goto L7;
            byte[] r11 = this.buffer;
            this.pos = r10 + 1;
            return r11[r10];
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private Object readField(WireFormat.FieldType r10, Class<?> r11, ExtensionRegistryLite r12) {
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r10.ordinal()]) {
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
            return readMessage(r11, r12);
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

        private <T> T readGroup(Schema<T> r10, ExtensionRegistryLite r11) {
            T r12 = r10.newInstance();
            mergeGroupField(r12, r10, r11);
            r10.makeImmutable(r12);
            return r12;
        }

        private int readLittleEndian32() {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int r10 = this.pos;
            byte[] r11 = this.buffer;
            this.pos = r10 + 4;
            return (((r11[r10] & 255) | ((r11[r10 + 1] & 255) << 8)) | ((r11[r10 + 2] & 255) << 16)) | ((r11[r10 + 3] & 255) << 24);
        }

        private long readLittleEndian64() {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private long readLittleEndian64_NoCheck() {
            int r10 = this.pos;
            byte[] r11 = this.buffer;
            this.pos = r10 + 8;
            long r12 = ((((((((long) r11[r10]) & 255) | ((((long) r11[r10 + 1]) & 255) << 8)) | ((((long) r11[r10 + 2]) & 255) << 16)) | ((((long) r11[r10 + 3]) & 255) << 24)) | ((((long) r11[r10 + 4]) & 255) << 32)) | ((((long) r11[r10 + 5]) & 255) << 40)) | ((((long) r11[r10 + 6]) & 255) << 48);
            return ((((long) r11[r10 + 7]) & 255) << 56) | r12;
        }

        private <T> T readMessage(Schema<T> r10, ExtensionRegistryLite r11) {
            T r12 = r10.newInstance();
            mergeMessageField(r12, r10, r11);
            r10.makeImmutable(r12);
            return r12;
        }

        private int readVarint32() {
            int r10 = this.pos;
            int r11 = this.limit;
            if (r11 == r10) goto L40;
            byte[] r12 = this.buffer;
            int r13 = r10 + 1;
            byte r14 = r12[r10];
            if (r14 < 0) goto L9;
            this.pos = r13;
            return r14;
        L9:
            if ((r11 - r13) < 9) goto L11;
            int r15 = r13 + 1;
            int r16 = r14 ^ (r12[r13] << 7);
            if (r16 >= 0) goto L15;
            int r17 = r16 ^ (-128);
        L37:
            this.pos = r15;
            return r17;
        L15:
            int r18 = r15 + 1;
            int r19 = r16 ^ (r12[r15] << 14);
            if (r19 < 0) goto L19;
            r17 = r19 ^ 16256;
        L18:
            r15 = r18;
            goto L37
        L19:
            r15 = r18 + 1;
            int r20 = r19 ^ (r12[r18] << 21);
            if (r20 >= 0) goto L22;
            r17 = r20 ^ (-2080896);
            goto L37
        L22:
            r18 = r15 + 1;
            byte r21 = r12[r15];
            r17 = (r20 ^ (r21 << 28)) ^ 266354560;
            if (r21 >= 0) goto L18;
            r15 = r18 + 1;
            if (r12[r18] >= 0) goto L37;
            r18 = r15 + 1;
            if (r12[r15] >= 0) goto L18;
            r15 = r18 + 1;
            if (r12[r18] >= 0) goto L37;
            r18 = r15 + 1;
            if (r12[r15] >= 0) goto L18;
            r15 = r18 + 1;
            if (r12[r18] >= 0) goto L37;
            throw InvalidProtocolBufferException.malformedVarint();
        L11:
            return (int) readVarint64SlowPath();
        L40:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private long readVarint64SlowPath() {
            long r10 = 0;
            int r11 = 0;
        L4:
            if (r11 >= 64) goto L10;
            byte r12 = readByte();
            r10 = r10 | (((long) (r12 & ByteCompanionObject.MAX_VALUE)) << r11);
            if ((r12 & 128) == 0) goto L7;
            r11 = r11 + 7;
            goto L4
        L7:
            return r10;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void requireBytes(int r10) {
            if (r10 < 0) goto L7;
            if (r10 > (this.limit - this.pos)) goto L7;
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void requirePosition(int r10) {
            if (this.pos != r10) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void requireWireType(int r10) {
            if (WireFormat.getTagWireType(this.tag) != r10) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        private void skipBytes(int r10) {
            requireBytes(r10);
            this.pos += r10;
        }

        private void skipGroup() {
            int r10 = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
        L4:
            if (getFieldNumber() == Integer.MAX_VALUE) goto L8;
            if (skipField() == true) goto L4;
        L8:
            if (this.tag != this.endGroupTag) goto L12;
            this.endGroupTag = r10;
            return;
        L12:
            throw InvalidProtocolBufferException.parseFailure();
        }

        private void skipVarint() {
            int r10 = this.limit;
            int r11 = this.pos;
            if ((r10 - r11) < 10) goto L11;
            byte[] r12 = this.buffer;
            int r13 = 0;
        L5:
            if (r13 >= 10) goto L11;
            int r14 = r11 + 1;
            if (r12[r11] >= 0) goto L8;
            r13 = r13 + 1;
            r11 = r14;
            goto L5
        L8:
            this.pos = r14;
            return;
        L11:
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() {
            int r10 = 0;
        L4:
            if (r10 >= 10) goto L10;
            if (readByte() >= 0) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void verifyPackedFixed32Length(int r10) {
            requireBytes(r10);
            if ((r10 & 3) != 0) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.parseFailure();
        }

        private void verifyPackedFixed64Length(int r10) {
            requireBytes(r10);
            if ((r10 & 7) != 0) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.parseFailure();
        }

        @Override // com.google.protobuf.Reader
        public int getFieldNumber() {
            if (isAtEnd() == false) goto L5;
            return Integer.MAX_VALUE;
        L5:
            int r10 = readVarint32();
            this.tag = r10;
            if (r10 != this.endGroupTag) goto L9;
            return Integer.MAX_VALUE;
        L9:
            return WireFormat.getTagFieldNumber(r10);
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
        public <T> void mergeGroupField(T r10, Schema<T> r11, ExtensionRegistryLite r12) {
            int r13 = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            r11.mergeFrom(r10, this, r12);     // Catch: Throwable -> L9
            if (this.tag != this.endGroupTag) goto L8;
            this.endGroupTag = r13;
            return;
        L8:
            throw InvalidProtocolBufferException.parseFailure();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            this.endGroupTag = r13;
            throw th;
        }

        @Override // com.google.protobuf.Reader
        public <T> void mergeMessageField(T r10, Schema<T> r11, ExtensionRegistryLite r12) {
            int r13 = readVarint32();
            requireBytes(r13);
            int r14 = this.limit;
            int r15 = this.pos + r13;
            this.limit = r15;
            r11.mergeFrom(r10, this, r12);     // Catch: Throwable -> L9
            if (this.pos != r15) goto L8;
            this.limit = r14;
            return;
        L8:
            throw InvalidProtocolBufferException.parseFailure();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            this.limit = r14;
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
        public void readBoolList(List<Boolean> r10) {
            if ((r10 instanceof BooleanArrayList) == false) goto L24;
            BooleanArrayList r11 = (BooleanArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 0) goto L17;
            if (r12 != 2) goto L16;
            int r13 = this.pos + readVarint32();
        L9:
            if (this.pos >= r13) goto L35;
            if (readVarint32() == 0) goto L13;
            boolean r14 = true;
        L14:
            r11.addBoolean(r14);
            goto L9
        L13:
            r14 = false;
        L35:
            requirePosition(r13);
            return;
        L16:
            throw InvalidProtocolBufferException.invalidWireType();
        L17:
            r11.addBoolean(readBool());
            if (isAtEnd() == true) goto L19;
            int r15 = this.pos;
            if (readVarint32() == this.tag) goto L17;
            this.pos = r15;
            return;
        L19:
            return;
        L24:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 0) goto L39;
            if (r16 != 2) goto L38;
            r13 = this.pos + readVarint32();
        L29:
            if (this.pos >= r13) goto L35;
            if (readVarint32() == 0) goto L33;
            boolean r17 = true;
        L34:
            r10.add(Boolean.valueOf(r17));
            goto L29
        L33:
            r17 = false;
            goto L34
        L38:
            throw InvalidProtocolBufferException.invalidWireType();
        L39:
            r10.add(Boolean.valueOf(readBool()));
            if (isAtEnd() == true) goto L41;
            int r18 = this.pos;
            if (readVarint32() == this.tag) goto L39;
            this.pos = r18;
            return;
        }

        @Override // com.google.protobuf.Reader
        public ByteString readBytes() {
            requireWireType(2);
            int r10 = readVarint32();
            if (r10 == 0) goto L5;
            requireBytes(r10);
            if (this.bufferIsImmutable == false) goto L9;
            ByteString r11 = ByteString.wrap(this.buffer, this.pos, r10);
        L10:
            this.pos += r10;
            return r11;
        L9:
            r11 = ByteString.copyFrom(this.buffer, this.pos, r10);
            goto L10
        L5:
            return ByteString.EMPTY;
        }

        @Override // com.google.protobuf.Reader
        public void readBytesList(List<ByteString> r10) {
            if (WireFormat.getTagWireType(this.tag) != 2) goto L12;
        L4:
            r10.add(readBytes());
            if (isAtEnd() == true) goto L6;
            int r11 = this.pos;
            if (readVarint32() == this.tag) goto L4;
            this.pos = r11;
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
        public void readDoubleList(List<Double> r10) {
            if ((r10 instanceof DoubleArrayList) == false) goto L20;
            DoubleArrayList r11 = (DoubleArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 1) goto L13;
            if (r12 != 2) goto L12;
            int r13 = readVarint32();
            verifyPackedFixed64Length(r13);
            int r14 = this.pos + r13;
        L9:
            if (this.pos >= r14) goto L27;
            r11.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r11.addDouble(readDouble());
            if (isAtEnd() == true) goto L15;
            int r15 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r15;
            return;
        L15:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 1) goto L30;
            if (r16 != 2) goto L29;
            int r17 = readVarint32();
            verifyPackedFixed64Length(r17);
            int r18 = this.pos + r17;
        L25:
            if (this.pos >= r18) goto L45;
            r10.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r10.add(Double.valueOf(readDouble()));
            if (isAtEnd() == true) goto L32;
            int r19 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r19;
            return;
        }

        @Override // com.google.protobuf.Reader
        public int readEnum() {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public void readEnumList(List<Integer> r10) {
            if ((r10 instanceof IntArrayList) == false) goto L20;
            IntArrayList r11 = (IntArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 0) goto L13;
            if (r12 != 2) goto L12;
            int r13 = readVarint32();
            int r14 = this.pos + r13;
        L9:
            if (this.pos >= r14) goto L27;
            r11.addInt(readVarint32());
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r11.addInt(readEnum());
            if (isAtEnd() == true) goto L15;
            int r15 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r15;
            return;
        L15:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 0) goto L30;
            if (r16 != 2) goto L29;
            int r17 = readVarint32();
            int r18 = this.pos + r17;
        L25:
            if (this.pos >= r18) goto L45;
            r10.add(Integer.valueOf(readVarint32()));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r10.add(Integer.valueOf(readEnum()));
            if (isAtEnd() == true) goto L32;
            int r19 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r19;
            return;
        }

        @Override // com.google.protobuf.Reader
        public int readFixed32() {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.protobuf.Reader
        public void readFixed32List(List<Integer> r10) {
            if ((r10 instanceof IntArrayList) == false) goto L20;
            IntArrayList r11 = (IntArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 2) goto L16;
            if (r12 != 5) goto L15;
        L7:
            r11.addInt(readFixed32());
            if (isAtEnd() == true) goto L9;
            int r13 = this.pos;
            if (readVarint32() == this.tag) goto L7;
            this.pos = r13;
            return;
        L9:
            return;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L16:
            int r14 = readVarint32();
            verifyPackedFixed32Length(r14);
            int r15 = this.pos + r14;
        L18:
            if (this.pos >= r15) goto L36;
            r11.addInt(readLittleEndian32_NoCheck());
            goto L18
        L36:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 2) goto L32;
            if (r16 != 5) goto L31;
        L23:
            r10.add(Integer.valueOf(readFixed32()));
            if (isAtEnd() == true) goto L25;
            int r17 = this.pos;
            if (readVarint32() == this.tag) goto L23;
            this.pos = r17;
            return;
        L25:
            return;
        L31:
            throw InvalidProtocolBufferException.invalidWireType();
        L32:
            int r18 = readVarint32();
            verifyPackedFixed32Length(r18);
            int r19 = this.pos + r18;
        L34:
            if (this.pos >= r19) goto L45;
            r10.add(Integer.valueOf(readLittleEndian32_NoCheck()));
            goto L34
        }

        @Override // com.google.protobuf.Reader
        public long readFixed64() {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.protobuf.Reader
        public void readFixed64List(List<Long> r10) {
            if ((r10 instanceof LongArrayList) == false) goto L20;
            LongArrayList r11 = (LongArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 1) goto L13;
            if (r12 != 2) goto L12;
            int r13 = readVarint32();
            verifyPackedFixed64Length(r13);
            int r14 = this.pos + r13;
        L9:
            if (this.pos >= r14) goto L27;
            r11.addLong(readLittleEndian64_NoCheck());
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r11.addLong(readFixed64());
            if (isAtEnd() == true) goto L15;
            int r15 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r15;
            return;
        L15:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 1) goto L30;
            if (r16 != 2) goto L29;
            int r17 = readVarint32();
            verifyPackedFixed64Length(r17);
            int r18 = this.pos + r17;
        L25:
            if (this.pos >= r18) goto L45;
            r10.add(Long.valueOf(readLittleEndian64_NoCheck()));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r10.add(Long.valueOf(readFixed64()));
            if (isAtEnd() == true) goto L32;
            int r19 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r19;
            return;
        }

        @Override // com.google.protobuf.Reader
        public float readFloat() {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        @Override // com.google.protobuf.Reader
        public void readFloatList(List<Float> r10) {
            if ((r10 instanceof FloatArrayList) == false) goto L20;
            FloatArrayList r11 = (FloatArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 2) goto L16;
            if (r12 != 5) goto L15;
        L7:
            r11.addFloat(readFloat());
            if (isAtEnd() == true) goto L9;
            int r13 = this.pos;
            if (readVarint32() == this.tag) goto L7;
            this.pos = r13;
            return;
        L9:
            return;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L16:
            int r14 = readVarint32();
            verifyPackedFixed32Length(r14);
            int r15 = this.pos + r14;
        L18:
            if (this.pos >= r15) goto L36;
            r11.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
            goto L18
        L36:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 2) goto L32;
            if (r16 != 5) goto L31;
        L23:
            r10.add(Float.valueOf(readFloat()));
            if (isAtEnd() == true) goto L25;
            int r17 = this.pos;
            if (readVarint32() == this.tag) goto L23;
            this.pos = r17;
            return;
        L25:
            return;
        L31:
            throw InvalidProtocolBufferException.invalidWireType();
        L32:
            int r18 = readVarint32();
            verifyPackedFixed32Length(r18);
            int r19 = this.pos + r18;
        L34:
            if (this.pos >= r19) goto L45;
            r10.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
            goto L34
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> T readGroup(Class<T> r10, ExtensionRegistryLite r11) {
            requireWireType(3);
            return (T) readGroup(Protobuf.getInstance().schemaFor(r10), r11);
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> T readGroupBySchemaWithCheck(Schema<T> r10, ExtensionRegistryLite r11) {
            requireWireType(3);
            return (T) readGroup(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> r10, Schema<T> r11, ExtensionRegistryLite r12) {
            if (WireFormat.getTagWireType(this.tag) != 3) goto L13;
            int r13 = this.tag;
        L5:
            r10.add(readGroup(r11, r12));
            if (isAtEnd() == true) goto L7;
            int r14 = this.pos;
            if (readVarint32() == r13) goto L5;
            this.pos = r14;
            return;
        L7:
            return;
        L13:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> r10, Class<T> r11, ExtensionRegistryLite r12) {
            readGroupList(r10, Protobuf.getInstance().schemaFor(r11), r12);
        }

        @Override // com.google.protobuf.Reader
        public int readInt32() {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public void readInt32List(List<Integer> r10) {
            if ((r10 instanceof IntArrayList) == false) goto L20;
            IntArrayList r11 = (IntArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 0) goto L13;
            if (r12 != 2) goto L12;
            int r13 = readVarint32();
            int r14 = this.pos + r13;
        L9:
            if (this.pos >= r14) goto L27;
            r11.addInt(readVarint32());
        L27:
            requirePosition(r14);
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r11.addInt(readInt32());
            if (isAtEnd() == true) goto L15;
            int r15 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r15;
            return;
        L15:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 0) goto L31;
            if (r16 != 2) goto L30;
            int r17 = readVarint32();
            r14 = this.pos + r17;
        L25:
            if (this.pos >= r14) goto L27;
            r10.add(Integer.valueOf(readVarint32()));
            goto L25
        L30:
            throw InvalidProtocolBufferException.invalidWireType();
        L31:
            r10.add(Integer.valueOf(readInt32()));
            if (isAtEnd() == true) goto L33;
            int r18 = this.pos;
            if (readVarint32() == this.tag) goto L31;
            this.pos = r18;
            return;
        }

        @Override // com.google.protobuf.Reader
        public long readInt64() {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.protobuf.Reader
        public void readInt64List(List<Long> r10) {
            if ((r10 instanceof LongArrayList) == false) goto L20;
            LongArrayList r11 = (LongArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 0) goto L13;
            if (r12 != 2) goto L12;
            int r13 = readVarint32();
            int r14 = this.pos + r13;
        L9:
            if (this.pos >= r14) goto L27;
            r11.addLong(readVarint64());
        L27:
            requirePosition(r14);
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r11.addLong(readInt64());
            if (isAtEnd() == true) goto L15;
            int r15 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r15;
            return;
        L15:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 0) goto L31;
            if (r16 != 2) goto L30;
            int r17 = readVarint32();
            r14 = this.pos + r17;
        L25:
            if (this.pos >= r14) goto L27;
            r10.add(Long.valueOf(readVarint64()));
            goto L25
        L30:
            throw InvalidProtocolBufferException.invalidWireType();
        L31:
            r10.add(Long.valueOf(readInt64()));
            if (isAtEnd() == true) goto L33;
            int r18 = this.pos;
            if (readVarint32() == this.tag) goto L31;
            this.pos = r18;
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public <K, V> void readMap(Map<K, V> r10, MapEntryLite.Metadata<K, V> r11, ExtensionRegistryLite r12) {
            requireWireType(2);
            int r13 = readVarint32();
            requireBytes(r13);
            int r14 = this.limit;
            this.limit = this.pos + r13;
            Object r15 = r11.defaultKey;     // Catch: Throwable -> L26
            Object r16 = r11.defaultValue;     // Catch: Throwable -> L26
        L4:
            int r17 = getFieldNumber();     // Catch: Throwable -> L26
            if (r17 == Integer.MAX_VALUE) goto L6;
            if (r17 != 1) goto L11;
            r15 = readField(r11.keyType, null, null);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L20 Throwable -> L26
            goto L4
        L11:
            if (r17 == 2) goto L17;
        L20:
            e = move-exception;
            if (skipField() == true) goto L4;
            throw new InvalidProtocolBufferException("Unable to parse map entry.", e);     // Catch: Throwable -> L26
        L13:
            if (skipField() == true) goto L4;
            throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L20 Throwable -> L26
        L17:
            r16 = readField(r11.valueType, r11.defaultValue.getClass(), r12);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L20 Throwable -> L26
            goto L4
        L6:
            r10.put(r15, r16);     // Catch: Throwable -> L26
            this.limit = r14;
            return;
        L26:
            th = move-exception;
            this.limit = r14;
            throw th;
        }

        @Override // com.google.protobuf.Reader
        public <T> T readMessage(Class<T> r10, ExtensionRegistryLite r11) {
            requireWireType(2);
            return (T) readMessage(Protobuf.getInstance().schemaFor(r10), r11);
        }

        @Override // com.google.protobuf.Reader
        public <T> T readMessageBySchemaWithCheck(Schema<T> r10, ExtensionRegistryLite r11) {
            requireWireType(2);
            return (T) readMessage(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public <T> void readMessageList(List<T> r10, Schema<T> r11, ExtensionRegistryLite r12) {
            if (WireFormat.getTagWireType(this.tag) != 2) goto L13;
            int r13 = this.tag;
        L5:
            r10.add(readMessage(r11, r12));
            if (isAtEnd() == true) goto L7;
            int r14 = this.pos;
            if (readVarint32() == r13) goto L5;
            this.pos = r14;
            return;
        L7:
            return;
        L13:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.Reader
        public <T> void readMessageList(List<T> r10, Class<T> r11, ExtensionRegistryLite r12) {
            readMessageList(r10, Protobuf.getInstance().schemaFor(r11), r12);
        }

        @Override // com.google.protobuf.Reader
        public int readSFixed32() {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.protobuf.Reader
        public void readSFixed32List(List<Integer> r10) {
            if ((r10 instanceof IntArrayList) == false) goto L20;
            IntArrayList r11 = (IntArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 2) goto L16;
            if (r12 != 5) goto L15;
        L7:
            r11.addInt(readSFixed32());
            if (isAtEnd() == true) goto L9;
            int r13 = this.pos;
            if (readVarint32() == this.tag) goto L7;
            this.pos = r13;
            return;
        L9:
            return;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L16:
            int r14 = readVarint32();
            verifyPackedFixed32Length(r14);
            int r15 = this.pos + r14;
        L18:
            if (this.pos >= r15) goto L36;
            r11.addInt(readLittleEndian32_NoCheck());
            goto L18
        L36:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 2) goto L32;
            if (r16 != 5) goto L31;
        L23:
            r10.add(Integer.valueOf(readSFixed32()));
            if (isAtEnd() == true) goto L25;
            int r17 = this.pos;
            if (readVarint32() == this.tag) goto L23;
            this.pos = r17;
            return;
        L25:
            return;
        L31:
            throw InvalidProtocolBufferException.invalidWireType();
        L32:
            int r18 = readVarint32();
            verifyPackedFixed32Length(r18);
            int r19 = this.pos + r18;
        L34:
            if (this.pos >= r19) goto L45;
            r10.add(Integer.valueOf(readLittleEndian32_NoCheck()));
            goto L34
        }

        @Override // com.google.protobuf.Reader
        public long readSFixed64() {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.protobuf.Reader
        public void readSFixed64List(List<Long> r10) {
            if ((r10 instanceof LongArrayList) == false) goto L20;
            LongArrayList r11 = (LongArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 1) goto L13;
            if (r12 != 2) goto L12;
            int r13 = readVarint32();
            verifyPackedFixed64Length(r13);
            int r14 = this.pos + r13;
        L9:
            if (this.pos >= r14) goto L27;
            r11.addLong(readLittleEndian64_NoCheck());
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r11.addLong(readSFixed64());
            if (isAtEnd() == true) goto L15;
            int r15 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r15;
            return;
        L15:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 1) goto L30;
            if (r16 != 2) goto L29;
            int r17 = readVarint32();
            verifyPackedFixed64Length(r17);
            int r18 = this.pos + r17;
        L25:
            if (this.pos >= r18) goto L45;
            r10.add(Long.valueOf(readLittleEndian64_NoCheck()));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r10.add(Long.valueOf(readSFixed64()));
            if (isAtEnd() == true) goto L32;
            int r19 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r19;
            return;
        }

        @Override // com.google.protobuf.Reader
        public int readSInt32() {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        @Override // com.google.protobuf.Reader
        public void readSInt32List(List<Integer> r10) {
            if ((r10 instanceof IntArrayList) == false) goto L20;
            IntArrayList r11 = (IntArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 0) goto L13;
            if (r12 != 2) goto L12;
            int r13 = readVarint32();
            int r14 = this.pos + r13;
        L9:
            if (this.pos >= r14) goto L27;
            r11.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r11.addInt(readSInt32());
            if (isAtEnd() == true) goto L15;
            int r15 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r15;
            return;
        L15:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 0) goto L30;
            if (r16 != 2) goto L29;
            int r17 = readVarint32();
            int r18 = this.pos + r17;
        L25:
            if (this.pos >= r18) goto L45;
            r10.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r10.add(Integer.valueOf(readSInt32()));
            if (isAtEnd() == true) goto L32;
            int r19 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r19;
            return;
        }

        @Override // com.google.protobuf.Reader
        public long readSInt64() {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        @Override // com.google.protobuf.Reader
        public void readSInt64List(List<Long> r10) {
            if ((r10 instanceof LongArrayList) == false) goto L20;
            LongArrayList r11 = (LongArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 0) goto L13;
            if (r12 != 2) goto L12;
            int r13 = readVarint32();
            int r14 = this.pos + r13;
        L9:
            if (this.pos >= r14) goto L27;
            r11.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r11.addLong(readSInt64());
            if (isAtEnd() == true) goto L15;
            int r15 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r15;
            return;
        L15:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 0) goto L30;
            if (r16 != 2) goto L29;
            int r17 = readVarint32();
            int r18 = this.pos + r17;
        L25:
            if (this.pos >= r18) goto L45;
            r10.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r10.add(Long.valueOf(readSInt64()));
            if (isAtEnd() == true) goto L32;
            int r19 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r19;
            return;
        }

        @Override // com.google.protobuf.Reader
        public String readString() {
            return readStringInternal(false);
        }

        public String readStringInternal(boolean r10) {
            requireWireType(2);
            int r11 = readVarint32();
            if (r11 != 0) goto L6;
            return "";
        L6:
            requireBytes(r11);
            if (r10 == false) goto L13;
            byte[] r12 = this.buffer;
            int r13 = this.pos;
            if (Utf8.isValidUtf8(r12, r13, r13 + r11) == true) goto L13;
            throw InvalidProtocolBufferException.invalidUtf8();
        L13:
            String r14 = new String(this.buffer, this.pos, r11, Internal.UTF_8);
            this.pos += r11;
            return r14;
        }

        @Override // com.google.protobuf.Reader
        public void readStringList(List<String> r10) {
            readStringListInternal(r10, false);
        }

        public void readStringListInternal(List<String> r10, boolean r11) {
            if (WireFormat.getTagWireType(this.tag) != 2) goto L23;
            if ((r10 instanceof LazyStringList) == false) goto L15;
            if (r11 == true) goto L15;
            LazyStringList r12 = (LazyStringList) r10;
        L8:
            r12.add(readBytes());
            if (isAtEnd() == true) goto L10;
            int r13 = this.pos;
            if (readVarint32() == this.tag) goto L8;
            this.pos = r13;
            return;
        L10:
            return;
        L15:
            r10.add(readStringInternal(r11));
            if (isAtEnd() == true) goto L17;
            int r14 = this.pos;
            if (readVarint32() == this.tag) goto L15;
            this.pos = r14;
            return;
        L17:
            return;
        L23:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.Reader
        public void readStringListRequireUtf8(List<String> r10) {
            readStringListInternal(r10, true);
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
        public void readUInt32List(List<Integer> r10) {
            if ((r10 instanceof IntArrayList) == false) goto L20;
            IntArrayList r11 = (IntArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 0) goto L13;
            if (r12 != 2) goto L12;
            int r13 = readVarint32();
            int r14 = this.pos + r13;
        L9:
            if (this.pos >= r14) goto L27;
            r11.addInt(readVarint32());
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r11.addInt(readUInt32());
            if (isAtEnd() == true) goto L15;
            int r15 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r15;
            return;
        L15:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 0) goto L30;
            if (r16 != 2) goto L29;
            int r17 = readVarint32();
            int r18 = this.pos + r17;
        L25:
            if (this.pos >= r18) goto L45;
            r10.add(Integer.valueOf(readVarint32()));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r10.add(Integer.valueOf(readUInt32()));
            if (isAtEnd() == true) goto L32;
            int r19 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r19;
            return;
        }

        @Override // com.google.protobuf.Reader
        public long readUInt64() {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.protobuf.Reader
        public void readUInt64List(List<Long> r10) {
            if ((r10 instanceof LongArrayList) == false) goto L20;
            LongArrayList r11 = (LongArrayList) r10;
            int r12 = WireFormat.getTagWireType(this.tag);
            if (r12 == 0) goto L13;
            if (r12 != 2) goto L12;
            int r13 = readVarint32();
            int r14 = this.pos + r13;
        L9:
            if (this.pos >= r14) goto L27;
            r11.addLong(readVarint64());
        L27:
            requirePosition(r14);
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r11.addLong(readUInt64());
            if (isAtEnd() == true) goto L15;
            int r15 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r15;
            return;
        L15:
            return;
        L20:
            int r16 = WireFormat.getTagWireType(this.tag);
            if (r16 == 0) goto L31;
            if (r16 != 2) goto L30;
            int r17 = readVarint32();
            r14 = this.pos + r17;
        L25:
            if (this.pos >= r14) goto L27;
            r10.add(Long.valueOf(readVarint64()));
            goto L25
        L30:
            throw InvalidProtocolBufferException.invalidWireType();
        L31:
            r10.add(Long.valueOf(readUInt64()));
            if (isAtEnd() == true) goto L33;
            int r18 = this.pos;
            if (readVarint32() == this.tag) goto L31;
            this.pos = r18;
            return;
        }

        public long readVarint64() {
            int r10 = this.pos;
            int r11 = this.limit;
            if (r11 == r10) goto L48;
            byte[] r12 = this.buffer;
            int r13 = r10 + 1;
            byte r14 = r12[r10];
            if (r14 < 0) goto L9;
            this.pos = r13;
            return r14;
        L9:
            if ((r11 - r13) < 9) goto L11;
            int r15 = r13 + 1;
            int r16 = r14 ^ (r12[r13] << 7);
            if (r16 >= 0) goto L16;
            int r17 = r16 ^ (-128);
        L15:
            long r18 = r17;
        L45:
            this.pos = r15;
            return r18;
        L16:
            int r19 = r15 + 1;
            int r20 = r16 ^ (r12[r15] << 14);
            if (r20 < 0) goto L19;
            r15 = r19;
            r18 = r20 ^ 16256;
            goto L45
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
            goto L45
        L26:
            r15 = r23 + 1;
            long r26 = r24 ^ (((long) r12[r23]) << 35);
            if (r26 >= 0) goto L30;
            long r27 = -34093383808L;
        L29:
            r18 = r26 ^ r27;
            goto L45
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
            if (r29 >= 0) goto L43;
            r15 = r28 + 1;
            if (r12[r28] < 0) goto L42;
        L44:
            r18 = r29;
            goto L45
        L42:
            throw InvalidProtocolBufferException.malformedVarint();
        L43:
            r15 = r28;
            goto L44
        L11:
            return readVarint64SlowPath();
        L48:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.Reader
        public boolean skipField() {
            if (isAtEnd() == true) goto L27;
            int r10 = this.tag;
            if (r10 == this.endGroupTag) goto L29;
            int r11 = WireFormat.getTagWireType(r10);
            if (r11 == 0) goto L25;
            if (r11 != 1) goto L11;
            int r12 = 8;
        L17:
            skipBytes(r12);
            return true;
        L11:
            if (r11 != 2) goto L13;
            r12 = readVarint32();
            goto L17
        L13:
            if (r11 != 3) goto L15;
            skipGroup();
            return true;
        L15:
            if (r11 != 5) goto L20;
            r12 = 4;
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
    }

    private BinaryReader() {
    }

    /* synthetic */ BinaryReader(AnonymousClass1 r10) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer r10, boolean r11) {
        if (r10.hasArray() == false) goto L7;
        return new SafeHeapReader(r10, r11);
    L7:
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    public abstract int getTotalBytesRead();

    @Override // com.google.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return false;
    }
}
