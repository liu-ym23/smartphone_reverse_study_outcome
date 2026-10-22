package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    /* JADX INFO: renamed from: com.google.protobuf.BinaryReader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
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

        public SafeHeapReader(ByteBuffer r2, boolean r3) {
            super(null);
            this.bufferIsImmutable = r3;
            this.buffer = r2.array();
            int r4 = r2.arrayOffset() + r2.position();
            this.pos = r4;
            this.initialPos = r4;
            this.limit = r2.arrayOffset() + r2.limit();
        }

        private boolean isAtEnd() {
            if (this.pos != this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        private byte readByte() {
            int r0 = this.pos;
            if (r0 == this.limit) goto L7;
            byte[] r1 = this.buffer;
            this.pos = r0 + 1;
            return r1[r0];
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private Object readField(WireFormat.FieldType r2, Class<?> r3, ExtensionRegistryLite r4) {
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r2.ordinal()]) {
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
            return readMessage(r3, r4);
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

        private <T> T readGroup(Schema<T> r3, ExtensionRegistryLite r4) {
            Schema<T> r5 = (Schema) ZeusTransformUtils.wrapperContextForParams(r3, Schema.class, "com.obric.memorydata.plugin");
            T r0 = r5.newInstance();
            mergeGroupField(r0, r5, r4);
            r5.makeImmutable(r0);
            return r0;
        }

        private int readLittleEndian32() {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int r0 = this.pos;
            byte[] r1 = this.buffer;
            this.pos = r0 + 4;
            return (((r1[r0] & 255) | ((r1[r0 + 1] & 255) << 8)) | ((r1[r0 + 2] & 255) << 16)) | ((r1[r0 + 3] & 255) << 24);
        }

        private long readLittleEndian64() {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private long readLittleEndian64_NoCheck() {
            int r0 = this.pos;
            byte[] r1 = this.buffer;
            this.pos = r0 + 8;
            long r2 = ((((((((long) r1[r0]) & 255) | ((((long) r1[r0 + 1]) & 255) << 8)) | ((((long) r1[r0 + 2]) & 255) << 16)) | ((((long) r1[r0 + 3]) & 255) << 24)) | ((((long) r1[r0 + 4]) & 255) << 32)) | ((((long) r1[r0 + 5]) & 255) << 40)) | ((((long) r1[r0 + 6]) & 255) << 48);
            return ((((long) r1[r0 + 7]) & 255) << 56) | r2;
        }

        private <T> T readMessage(Schema<T> r3, ExtensionRegistryLite r4) {
            Schema<T> r5 = (Schema) ZeusTransformUtils.wrapperContextForParams(r3, Schema.class, "com.obric.memorydata.plugin");
            T r0 = r5.newInstance();
            mergeMessageField(r0, r5, r4);
            r5.makeImmutable(r0);
            return r0;
        }

        private int readVarint32() {
            int r0 = this.pos;
            int r1 = this.limit;
            if (r1 == r0) goto L40;
            byte[] r2 = this.buffer;
            int r3 = r0 + 1;
            byte r4 = r2[r0];
            if (r4 < 0) goto L9;
            this.pos = r3;
            return r4;
        L9:
            if ((r1 - r3) < 9) goto L11;
            int r5 = r3 + 1;
            int r6 = r4 ^ (r2[r3] << 7);
            if (r6 >= 0) goto L15;
            int r7 = r6 ^ (-128);
        L37:
            this.pos = r5;
            return r7;
        L15:
            int r8 = r5 + 1;
            int r9 = r6 ^ (r2[r5] << 14);
            if (r9 < 0) goto L19;
            r7 = r9 ^ 16256;
        L18:
            r5 = r8;
            goto L37
        L19:
            r5 = r8 + 1;
            int r10 = r9 ^ (r2[r8] << 21);
            if (r10 >= 0) goto L22;
            r7 = r10 ^ (-2080896);
            goto L37
        L22:
            r8 = r5 + 1;
            byte r11 = r2[r5];
            r7 = (r10 ^ (r11 << 28)) ^ 266354560;
            if (r11 >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L37;
            r8 = r5 + 1;
            if (r2[r5] >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L37;
            r8 = r5 + 1;
            if (r2[r5] >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L37;
            throw InvalidProtocolBufferException.malformedVarint();
        L11:
            return (int) readVarint64SlowPath();
        L40:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private long readVarint64SlowPath() {
            long r0 = 0;
            int r2 = 0;
        L4:
            if (r2 >= 64) goto L10;
            byte r3 = readByte();
            r0 = r0 | (((long) (r3 & ByteCompanionObject.MAX_VALUE)) << r2);
            if ((r3 & 128) == 0) goto L7;
            r2 = r2 + 7;
            goto L4
        L7:
            return r0;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void requireBytes(int r2) {
            if (r2 < 0) goto L7;
            if (r2 > (this.limit - this.pos)) goto L7;
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void requirePosition(int r1) {
            if (this.pos != r1) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void requireWireType(int r1) {
            if (WireFormat.getTagWireType(this.tag) != r1) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        private void skipBytes(int r2) {
            requireBytes(r2);
            this.pos += r2;
        }

        private void skipGroup() {
            int r0 = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
        L4:
            if (getFieldNumber() == Integer.MAX_VALUE) goto L8;
            if (skipField() == true) goto L4;
        L8:
            if (this.tag != this.endGroupTag) goto L12;
            this.endGroupTag = r0;
            return;
        L12:
            throw InvalidProtocolBufferException.parseFailure();
        }

        private void skipVarint() {
            int r0 = this.limit;
            int r1 = this.pos;
            if ((r0 - r1) < 10) goto L11;
            byte[] r2 = this.buffer;
            int r3 = 0;
        L5:
            if (r3 >= 10) goto L11;
            int r4 = r1 + 1;
            if (r2[r1] >= 0) goto L8;
            r3 = r3 + 1;
            r1 = r4;
            goto L5
        L8:
            this.pos = r4;
            return;
        L11:
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            if (readByte() >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void verifyPackedFixed32Length(int r1) {
            requireBytes(r1);
            if ((r1 & 3) != 0) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.parseFailure();
        }

        private void verifyPackedFixed64Length(int r1) {
            requireBytes(r1);
            if ((r1 & 7) != 0) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.parseFailure();
        }

        @Override // com.google.protobuf.Reader
        public int getFieldNumber() {
            if (isAtEnd() == false) goto L5;
            return Integer.MAX_VALUE;
        L5:
            int r0 = readVarint32();
            this.tag = r0;
            if (r0 != this.endGroupTag) goto L9;
            return Integer.MAX_VALUE;
        L9:
            return WireFormat.getTagFieldNumber(r0);
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
        public <T> void mergeGroupField(T r4, Schema<T> r5, ExtensionRegistryLite r6) {
            Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            int r0 = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            r7.mergeFrom(r4, this, r6);     // Catch: Throwable -> L9
            if (this.tag != this.endGroupTag) goto L8;
            this.endGroupTag = r0;
            return;
        L8:
            throw InvalidProtocolBufferException.parseFailure();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            this.endGroupTag = r0;
            throw th;
        }

        @Override // com.google.protobuf.Reader
        public <T> void mergeMessageField(T r4, Schema<T> r5, ExtensionRegistryLite r6) {
            Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            int r0 = readVarint32();
            requireBytes(r0);
            int r1 = this.limit;
            int r2 = this.pos + r0;
            this.limit = r2;
            r7.mergeFrom(r4, this, r6);     // Catch: Throwable -> L9
            if (this.pos != r2) goto L8;
            this.limit = r1;
            return;
        L8:
            throw InvalidProtocolBufferException.parseFailure();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            this.limit = r1;
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
        public void readBoolList(List<Boolean> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, BooleanArrayList.class) == false) goto L24;
            BooleanArrayList r0 = (BooleanArrayList) ZeusTransformUtils.preCheckCast(r7, BooleanArrayList.class, "com.obric.memorydata.plugin");
            int r8 = WireFormat.getTagWireType(this.tag);
            if (r8 == 0) goto L17;
            if (r8 != 2) goto L16;
            int r1 = this.pos + readVarint32();
        L9:
            if (this.pos >= r1) goto L35;
            if (readVarint32() == 0) goto L13;
            boolean r9 = true;
        L14:
            r0.addBoolean(r9);
            goto L9
        L13:
            r9 = false;
        L35:
            requirePosition(r1);
            return;
        L16:
            throw InvalidProtocolBufferException.invalidWireType();
        L17:
            r0.addBoolean(readBool());
            if (isAtEnd() == true) goto L19;
            int r10 = this.pos;
            if (readVarint32() == this.tag) goto L17;
            this.pos = r10;
            return;
        L19:
            return;
        L24:
            int r2 = WireFormat.getTagWireType(this.tag);
            if (r2 == 0) goto L39;
            if (r2 != 2) goto L38;
            r1 = this.pos + readVarint32();
        L29:
            if (this.pos >= r1) goto L35;
            if (readVarint32() == 0) goto L33;
            boolean r3 = true;
        L34:
            r7.add(Boolean.valueOf(r3));
            goto L29
        L33:
            r3 = false;
            goto L34
        L38:
            throw InvalidProtocolBufferException.invalidWireType();
        L39:
            r7.add(Boolean.valueOf(readBool()));
            if (isAtEnd() == true) goto L41;
            int r4 = this.pos;
            if (readVarint32() == this.tag) goto L39;
            this.pos = r4;
            return;
        }

        @Override // com.google.protobuf.Reader
        public ByteString readBytes() {
            requireWireType(2);
            int r0 = readVarint32();
            if (r0 == 0) goto L5;
            requireBytes(r0);
            if (this.bufferIsImmutable == false) goto L9;
            ByteString r1 = ByteString.wrap(this.buffer, this.pos, r0);
        L10:
            this.pos += r0;
            return r1;
        L9:
            r1 = ByteString.copyFrom(this.buffer, this.pos, r0);
            goto L10
        L5:
            return ByteString.EMPTY;
        }

        @Override // com.google.protobuf.Reader
        public void readBytesList(List<ByteString> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (WireFormat.getTagWireType(this.tag) != 2) goto L12;
        L4:
            r5.add(readBytes());
            if (isAtEnd() == true) goto L6;
            int r0 = this.pos;
            if (readVarint32() == this.tag) goto L4;
            this.pos = r0;
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
        public void readDoubleList(List<Double> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, DoubleArrayList.class) == false) goto L20;
            DoubleArrayList r0 = (DoubleArrayList) ZeusTransformUtils.preCheckCast(r6, DoubleArrayList.class, "com.obric.memorydata.plugin");
            int r7 = WireFormat.getTagWireType(this.tag);
            if (r7 == 1) goto L13;
            if (r7 != 2) goto L12;
            int r8 = readVarint32();
            verifyPackedFixed64Length(r8);
            int r1 = this.pos + r8;
        L9:
            if (this.pos >= r1) goto L27;
            r0.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r0.addDouble(readDouble());
            if (isAtEnd() == true) goto L15;
            int r9 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r9;
            return;
        L15:
            return;
        L20:
            int r2 = WireFormat.getTagWireType(this.tag);
            if (r2 == 1) goto L30;
            if (r2 != 2) goto L29;
            int r3 = readVarint32();
            verifyPackedFixed64Length(r3);
            int r4 = this.pos + r3;
        L25:
            if (this.pos >= r4) goto L45;
            r6.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r6.add(Double.valueOf(readDouble()));
            if (isAtEnd() == true) goto L32;
            int r10 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r10;
            return;
        }

        @Override // com.google.protobuf.Reader
        public int readEnum() {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public void readEnumList(List<Integer> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, IntArrayList.class) == false) goto L20;
            IntArrayList r0 = (IntArrayList) ZeusTransformUtils.preCheckCast(r5, IntArrayList.class, "com.obric.memorydata.plugin");
            int r6 = WireFormat.getTagWireType(this.tag);
            if (r6 == 0) goto L13;
            if (r6 != 2) goto L12;
            int r7 = readVarint32();
            int r1 = this.pos + r7;
        L9:
            if (this.pos >= r1) goto L27;
            r0.addInt(readVarint32());
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r0.addInt(readEnum());
            if (isAtEnd() == true) goto L15;
            int r8 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r8;
            return;
        L15:
            return;
        L20:
            int r2 = WireFormat.getTagWireType(this.tag);
            if (r2 == 0) goto L30;
            if (r2 != 2) goto L29;
            int r3 = readVarint32();
            int r9 = this.pos + r3;
        L25:
            if (this.pos >= r9) goto L45;
            r5.add(Integer.valueOf(readVarint32()));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r5.add(Integer.valueOf(readEnum()));
            if (isAtEnd() == true) goto L32;
            int r10 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r10;
            return;
        }

        @Override // com.google.protobuf.Reader
        public int readFixed32() {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.protobuf.Reader
        public void readFixed32List(List<Integer> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L20;
            IntArrayList r7 = (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.memorydata.plugin");
            int r0 = WireFormat.getTagWireType(this.tag);
            if (r0 == 2) goto L16;
            if (r0 != 5) goto L15;
        L7:
            r7.addInt(readFixed32());
            if (isAtEnd() == true) goto L9;
            int r1 = this.pos;
            if (readVarint32() == this.tag) goto L7;
            this.pos = r1;
            return;
        L9:
            return;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L16:
            int r2 = readVarint32();
            verifyPackedFixed32Length(r2);
            int r3 = this.pos + r2;
        L18:
            if (this.pos >= r3) goto L36;
            r7.addInt(readLittleEndian32_NoCheck());
            goto L18
        L36:
            return;
        L20:
            int r4 = WireFormat.getTagWireType(this.tag);
            if (r4 == 2) goto L32;
            if (r4 != 5) goto L31;
        L23:
            r6.add(Integer.valueOf(readFixed32()));
            if (isAtEnd() == true) goto L25;
            int r8 = this.pos;
            if (readVarint32() == this.tag) goto L23;
            this.pos = r8;
            return;
        L25:
            return;
        L31:
            throw InvalidProtocolBufferException.invalidWireType();
        L32:
            int r9 = readVarint32();
            verifyPackedFixed32Length(r9);
            int r10 = this.pos + r9;
        L34:
            if (this.pos >= r10) goto L45;
            r6.add(Integer.valueOf(readLittleEndian32_NoCheck()));
            goto L34
        }

        @Override // com.google.protobuf.Reader
        public long readFixed64() {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.protobuf.Reader
        public void readFixed64List(List<Long> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L20;
            LongArrayList r0 = (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin");
            int r7 = WireFormat.getTagWireType(this.tag);
            if (r7 == 1) goto L13;
            if (r7 != 2) goto L12;
            int r8 = readVarint32();
            verifyPackedFixed64Length(r8);
            int r1 = this.pos + r8;
        L9:
            if (this.pos >= r1) goto L27;
            r0.addLong(readLittleEndian64_NoCheck());
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r0.addLong(readFixed64());
            if (isAtEnd() == true) goto L15;
            int r9 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r9;
            return;
        L15:
            return;
        L20:
            int r2 = WireFormat.getTagWireType(this.tag);
            if (r2 == 1) goto L30;
            if (r2 != 2) goto L29;
            int r3 = readVarint32();
            verifyPackedFixed64Length(r3);
            int r4 = this.pos + r3;
        L25:
            if (this.pos >= r4) goto L45;
            r6.add(Long.valueOf(readLittleEndian64_NoCheck()));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r6.add(Long.valueOf(readFixed64()));
            if (isAtEnd() == true) goto L32;
            int r10 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r10;
            return;
        }

        @Override // com.google.protobuf.Reader
        public float readFloat() {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        @Override // com.google.protobuf.Reader
        public void readFloatList(List<Float> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, FloatArrayList.class) == false) goto L20;
            FloatArrayList r7 = (FloatArrayList) ZeusTransformUtils.preCheckCast(r6, FloatArrayList.class, "com.obric.memorydata.plugin");
            int r0 = WireFormat.getTagWireType(this.tag);
            if (r0 == 2) goto L16;
            if (r0 != 5) goto L15;
        L7:
            r7.addFloat(readFloat());
            if (isAtEnd() == true) goto L9;
            int r1 = this.pos;
            if (readVarint32() == this.tag) goto L7;
            this.pos = r1;
            return;
        L9:
            return;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L16:
            int r2 = readVarint32();
            verifyPackedFixed32Length(r2);
            int r3 = this.pos + r2;
        L18:
            if (this.pos >= r3) goto L36;
            r7.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
            goto L18
        L36:
            return;
        L20:
            int r4 = WireFormat.getTagWireType(this.tag);
            if (r4 == 2) goto L32;
            if (r4 != 5) goto L31;
        L23:
            r6.add(Float.valueOf(readFloat()));
            if (isAtEnd() == true) goto L25;
            int r8 = this.pos;
            if (readVarint32() == this.tag) goto L23;
            this.pos = r8;
            return;
        L25:
            return;
        L31:
            throw InvalidProtocolBufferException.invalidWireType();
        L32:
            int r9 = readVarint32();
            verifyPackedFixed32Length(r9);
            int r10 = this.pos + r9;
        L34:
            if (this.pos >= r10) goto L45;
            r6.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
            goto L34
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> T readGroup(Class<T> r2, ExtensionRegistryLite r3) {
            requireWireType(3);
            return (T) readGroup(Protobuf.getInstance().schemaFor(r2), r3);
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> T readGroupBySchemaWithCheck(Schema<T> r3, ExtensionRegistryLite r4) {
            Schema<T> r5 = (Schema) ZeusTransformUtils.wrapperContextForParams(r3, Schema.class, "com.obric.memorydata.plugin");
            requireWireType(3);
            return (T) readGroup(r5, r4);
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> r4, Schema<T> r5, ExtensionRegistryLite r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Schema<T> r8 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            if (WireFormat.getTagWireType(this.tag) != 3) goto L13;
            int r0 = this.tag;
        L5:
            r7.add(readGroup(r8, r6));
            if (isAtEnd() == true) goto L7;
            int r1 = this.pos;
            if (readVarint32() == r0) goto L5;
            this.pos = r1;
            return;
        L7:
            return;
        L13:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> r3, Class<T> r4, ExtensionRegistryLite r5) {
            readGroupList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), Protobuf.getInstance().schemaFor(r4), r5);
        }

        @Override // com.google.protobuf.Reader
        public int readInt32() {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.protobuf.Reader
        public void readInt32List(List<Integer> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, IntArrayList.class) == false) goto L20;
            IntArrayList r0 = (IntArrayList) ZeusTransformUtils.preCheckCast(r5, IntArrayList.class, "com.obric.memorydata.plugin");
            int r6 = WireFormat.getTagWireType(this.tag);
            if (r6 == 0) goto L13;
            if (r6 != 2) goto L12;
            int r7 = readVarint32();
            int r1 = this.pos + r7;
        L9:
            if (this.pos >= r1) goto L27;
            r0.addInt(readVarint32());
        L27:
            requirePosition(r1);
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r0.addInt(readInt32());
            if (isAtEnd() == true) goto L15;
            int r8 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r8;
            return;
        L15:
            return;
        L20:
            int r2 = WireFormat.getTagWireType(this.tag);
            if (r2 == 0) goto L31;
            if (r2 != 2) goto L30;
            int r3 = readVarint32();
            r1 = this.pos + r3;
        L25:
            if (this.pos >= r1) goto L27;
            r5.add(Integer.valueOf(readVarint32()));
            goto L25
        L30:
            throw InvalidProtocolBufferException.invalidWireType();
        L31:
            r5.add(Integer.valueOf(readInt32()));
            if (isAtEnd() == true) goto L33;
            int r9 = this.pos;
            if (readVarint32() == this.tag) goto L31;
            this.pos = r9;
            return;
        }

        @Override // com.google.protobuf.Reader
        public long readInt64() {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.protobuf.Reader
        public void readInt64List(List<Long> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L20;
            LongArrayList r0 = (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin");
            int r7 = WireFormat.getTagWireType(this.tag);
            if (r7 == 0) goto L13;
            if (r7 != 2) goto L12;
            int r8 = readVarint32();
            int r1 = this.pos + r8;
        L9:
            if (this.pos >= r1) goto L27;
            r0.addLong(readVarint64());
        L27:
            requirePosition(r1);
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r0.addLong(readInt64());
            if (isAtEnd() == true) goto L15;
            int r9 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r9;
            return;
        L15:
            return;
        L20:
            int r2 = WireFormat.getTagWireType(this.tag);
            if (r2 == 0) goto L31;
            if (r2 != 2) goto L30;
            int r3 = readVarint32();
            r1 = this.pos + r3;
        L25:
            if (this.pos >= r1) goto L27;
            r6.add(Long.valueOf(readVarint64()));
            goto L25
        L30:
            throw InvalidProtocolBufferException.invalidWireType();
        L31:
            r6.add(Long.valueOf(readInt64()));
            if (isAtEnd() == true) goto L33;
            int r4 = this.pos;
            if (readVarint32() == this.tag) goto L31;
            this.pos = r4;
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public <K, V> void readMap(Map<K, V> r8, MapEntryLite.Metadata<K, V> r9, ExtensionRegistryLite r10) {
            Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
            requireWireType(2);
            int r1 = readVarint32();
            requireBytes(r1);
            int r2 = this.limit;
            this.limit = this.pos + r1;
            Object r3 = r9.defaultKey;     // Catch: Throwable -> L26
            Object r4 = r9.defaultValue;     // Catch: Throwable -> L26
        L4:
            int r5 = getFieldNumber();     // Catch: Throwable -> L26
            if (r5 == Integer.MAX_VALUE) goto L6;
            if (r5 != 1) goto L11;
            r3 = readField(r9.keyType, null, null);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L20 Throwable -> L26
            goto L4
        L11:
            if (r5 == 2) goto L17;
        L20:
            e = move-exception;
            if (skipField() == true) goto L4;
            throw new InvalidProtocolBufferException("Unable to parse map entry.", e);     // Catch: Throwable -> L26
        L13:
            if (skipField() == true) goto L4;
            throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L20 Throwable -> L26
        L17:
            r4 = readField(r9.valueType, r9.defaultValue.getClass(), r10);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L20 Throwable -> L26
            goto L4
        L6:
            r11.put(r3, r4);     // Catch: Throwable -> L26
            this.limit = r2;
            return;
        L26:
            th = move-exception;
            this.limit = r2;
            throw th;
        }

        @Override // com.google.protobuf.Reader
        public <T> T readMessage(Class<T> r2, ExtensionRegistryLite r3) {
            requireWireType(2);
            return (T) readMessage(Protobuf.getInstance().schemaFor(r2), r3);
        }

        @Override // com.google.protobuf.Reader
        public <T> T readMessageBySchemaWithCheck(Schema<T> r3, ExtensionRegistryLite r4) {
            Schema<T> r5 = (Schema) ZeusTransformUtils.wrapperContextForParams(r3, Schema.class, "com.obric.memorydata.plugin");
            requireWireType(2);
            return (T) readMessage(r5, r4);
        }

        @Override // com.google.protobuf.Reader
        public <T> void readMessageList(List<T> r4, Schema<T> r5, ExtensionRegistryLite r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Schema<T> r8 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
            if (WireFormat.getTagWireType(this.tag) != 2) goto L13;
            int r0 = this.tag;
        L5:
            r7.add(readMessage(r8, r6));
            if (isAtEnd() == true) goto L7;
            int r1 = this.pos;
            if (readVarint32() == r0) goto L5;
            this.pos = r1;
            return;
        L7:
            return;
        L13:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.Reader
        public <T> void readMessageList(List<T> r3, Class<T> r4, ExtensionRegistryLite r5) {
            readMessageList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), Protobuf.getInstance().schemaFor(r4), r5);
        }

        @Override // com.google.protobuf.Reader
        public int readSFixed32() {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.protobuf.Reader
        public void readSFixed32List(List<Integer> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L20;
            IntArrayList r7 = (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.memorydata.plugin");
            int r0 = WireFormat.getTagWireType(this.tag);
            if (r0 == 2) goto L16;
            if (r0 != 5) goto L15;
        L7:
            r7.addInt(readSFixed32());
            if (isAtEnd() == true) goto L9;
            int r1 = this.pos;
            if (readVarint32() == this.tag) goto L7;
            this.pos = r1;
            return;
        L9:
            return;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L16:
            int r2 = readVarint32();
            verifyPackedFixed32Length(r2);
            int r3 = this.pos + r2;
        L18:
            if (this.pos >= r3) goto L36;
            r7.addInt(readLittleEndian32_NoCheck());
            goto L18
        L36:
            return;
        L20:
            int r4 = WireFormat.getTagWireType(this.tag);
            if (r4 == 2) goto L32;
            if (r4 != 5) goto L31;
        L23:
            r6.add(Integer.valueOf(readSFixed32()));
            if (isAtEnd() == true) goto L25;
            int r8 = this.pos;
            if (readVarint32() == this.tag) goto L23;
            this.pos = r8;
            return;
        L25:
            return;
        L31:
            throw InvalidProtocolBufferException.invalidWireType();
        L32:
            int r9 = readVarint32();
            verifyPackedFixed32Length(r9);
            int r10 = this.pos + r9;
        L34:
            if (this.pos >= r10) goto L45;
            r6.add(Integer.valueOf(readLittleEndian32_NoCheck()));
            goto L34
        }

        @Override // com.google.protobuf.Reader
        public long readSFixed64() {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.protobuf.Reader
        public void readSFixed64List(List<Long> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L20;
            LongArrayList r0 = (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin");
            int r7 = WireFormat.getTagWireType(this.tag);
            if (r7 == 1) goto L13;
            if (r7 != 2) goto L12;
            int r8 = readVarint32();
            verifyPackedFixed64Length(r8);
            int r1 = this.pos + r8;
        L9:
            if (this.pos >= r1) goto L27;
            r0.addLong(readLittleEndian64_NoCheck());
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r0.addLong(readSFixed64());
            if (isAtEnd() == true) goto L15;
            int r9 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r9;
            return;
        L15:
            return;
        L20:
            int r2 = WireFormat.getTagWireType(this.tag);
            if (r2 == 1) goto L30;
            if (r2 != 2) goto L29;
            int r3 = readVarint32();
            verifyPackedFixed64Length(r3);
            int r4 = this.pos + r3;
        L25:
            if (this.pos >= r4) goto L45;
            r6.add(Long.valueOf(readLittleEndian64_NoCheck()));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r6.add(Long.valueOf(readSFixed64()));
            if (isAtEnd() == true) goto L32;
            int r10 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r10;
            return;
        }

        @Override // com.google.protobuf.Reader
        public int readSInt32() {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        @Override // com.google.protobuf.Reader
        public void readSInt32List(List<Integer> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, IntArrayList.class) == false) goto L20;
            IntArrayList r0 = (IntArrayList) ZeusTransformUtils.preCheckCast(r5, IntArrayList.class, "com.obric.memorydata.plugin");
            int r6 = WireFormat.getTagWireType(this.tag);
            if (r6 == 0) goto L13;
            if (r6 != 2) goto L12;
            int r7 = readVarint32();
            int r1 = this.pos + r7;
        L9:
            if (this.pos >= r1) goto L27;
            r0.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r0.addInt(readSInt32());
            if (isAtEnd() == true) goto L15;
            int r8 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r8;
            return;
        L15:
            return;
        L20:
            int r2 = WireFormat.getTagWireType(this.tag);
            if (r2 == 0) goto L30;
            if (r2 != 2) goto L29;
            int r3 = readVarint32();
            int r9 = this.pos + r3;
        L25:
            if (this.pos >= r9) goto L45;
            r5.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r5.add(Integer.valueOf(readSInt32()));
            if (isAtEnd() == true) goto L32;
            int r10 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r10;
            return;
        }

        @Override // com.google.protobuf.Reader
        public long readSInt64() {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        @Override // com.google.protobuf.Reader
        public void readSInt64List(List<Long> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L20;
            LongArrayList r0 = (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin");
            int r7 = WireFormat.getTagWireType(this.tag);
            if (r7 == 0) goto L13;
            if (r7 != 2) goto L12;
            int r8 = readVarint32();
            int r1 = this.pos + r8;
        L9:
            if (this.pos >= r1) goto L27;
            r0.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r0.addLong(readSInt64());
            if (isAtEnd() == true) goto L15;
            int r9 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r9;
            return;
        L15:
            return;
        L20:
            int r2 = WireFormat.getTagWireType(this.tag);
            if (r2 == 0) goto L30;
            if (r2 != 2) goto L29;
            int r3 = readVarint32();
            int r4 = this.pos + r3;
        L25:
            if (this.pos >= r4) goto L45;
            r6.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r6.add(Long.valueOf(readSInt64()));
            if (isAtEnd() == true) goto L32;
            int r10 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r10;
            return;
        }

        @Override // com.google.protobuf.Reader
        public String readString() {
            return readStringInternal(false);
        }

        public String readStringInternal(boolean r5) {
            requireWireType(2);
            int r0 = readVarint32();
            if (r0 != 0) goto L6;
            return "";
        L6:
            requireBytes(r0);
            if (r5 == false) goto L13;
            byte[] r6 = this.buffer;
            int r1 = this.pos;
            if (Utf8.isValidUtf8(r6, r1, r1 + r0) == true) goto L13;
            throw InvalidProtocolBufferException.invalidUtf8();
        L13:
            String r7 = new String(this.buffer, this.pos, r0, Internal.UTF_8);
            this.pos += r0;
            return r7;
        }

        @Override // com.google.protobuf.Reader
        public void readStringList(List<String> r3) {
            readStringListInternal((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), false);
        }

        public void readStringListInternal(List<String> r4, boolean r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (WireFormat.getTagWireType(this.tag) != 2) goto L23;
            if (ZeusTransformUtils.instanceOf(r6, LazyStringList.class) == false) goto L15;
            if (r5 == true) goto L15;
            LazyStringList r0 = (LazyStringList) ZeusTransformUtils.preCheckCast(r6, LazyStringList.class, "com.obric.memorydata.plugin");
        L8:
            r0.add(readBytes());
            if (isAtEnd() == true) goto L10;
            int r7 = this.pos;
            if (readVarint32() == this.tag) goto L8;
            this.pos = r7;
            return;
        L10:
            return;
        L15:
            r6.add(readStringInternal(r5));
            if (isAtEnd() == true) goto L17;
            int r1 = this.pos;
            if (readVarint32() == this.tag) goto L15;
            this.pos = r1;
            return;
        L17:
            return;
        L23:
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.Reader
        public void readStringListRequireUtf8(List<String> r3) {
            readStringListInternal((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), true);
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
        public void readUInt32List(List<Integer> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, IntArrayList.class) == false) goto L20;
            IntArrayList r0 = (IntArrayList) ZeusTransformUtils.preCheckCast(r5, IntArrayList.class, "com.obric.memorydata.plugin");
            int r6 = WireFormat.getTagWireType(this.tag);
            if (r6 == 0) goto L13;
            if (r6 != 2) goto L12;
            int r7 = readVarint32();
            int r1 = this.pos + r7;
        L9:
            if (this.pos >= r1) goto L27;
            r0.addInt(readVarint32());
            goto L9
        L27:
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r0.addInt(readUInt32());
            if (isAtEnd() == true) goto L15;
            int r8 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r8;
            return;
        L15:
            return;
        L20:
            int r2 = WireFormat.getTagWireType(this.tag);
            if (r2 == 0) goto L30;
            if (r2 != 2) goto L29;
            int r3 = readVarint32();
            int r9 = this.pos + r3;
        L25:
            if (this.pos >= r9) goto L45;
            r5.add(Integer.valueOf(readVarint32()));
            goto L25
        L45:
            return;
        L29:
            throw InvalidProtocolBufferException.invalidWireType();
        L30:
            r5.add(Integer.valueOf(readUInt32()));
            if (isAtEnd() == true) goto L32;
            int r10 = this.pos;
            if (readVarint32() == this.tag) goto L30;
            this.pos = r10;
            return;
        }

        @Override // com.google.protobuf.Reader
        public long readUInt64() {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.protobuf.Reader
        public void readUInt64List(List<Long> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L20;
            LongArrayList r0 = (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin");
            int r7 = WireFormat.getTagWireType(this.tag);
            if (r7 == 0) goto L13;
            if (r7 != 2) goto L12;
            int r8 = readVarint32();
            int r1 = this.pos + r8;
        L9:
            if (this.pos >= r1) goto L27;
            r0.addLong(readVarint64());
        L27:
            requirePosition(r1);
            return;
        L12:
            throw InvalidProtocolBufferException.invalidWireType();
        L13:
            r0.addLong(readUInt64());
            if (isAtEnd() == true) goto L15;
            int r9 = this.pos;
            if (readVarint32() == this.tag) goto L13;
            this.pos = r9;
            return;
        L15:
            return;
        L20:
            int r2 = WireFormat.getTagWireType(this.tag);
            if (r2 == 0) goto L31;
            if (r2 != 2) goto L30;
            int r3 = readVarint32();
            r1 = this.pos + r3;
        L25:
            if (this.pos >= r1) goto L27;
            r6.add(Long.valueOf(readVarint64()));
            goto L25
        L30:
            throw InvalidProtocolBufferException.invalidWireType();
        L31:
            r6.add(Long.valueOf(readUInt64()));
            if (isAtEnd() == true) goto L33;
            int r4 = this.pos;
            if (readVarint32() == this.tag) goto L31;
            this.pos = r4;
            return;
        }

        public long readVarint64() {
            int r0 = this.pos;
            int r1 = this.limit;
            if (r1 == r0) goto L48;
            byte[] r2 = this.buffer;
            int r3 = r0 + 1;
            byte r4 = r2[r0];
            if (r4 < 0) goto L9;
            this.pos = r3;
            return r4;
        L9:
            if ((r1 - r3) < 9) goto L11;
            int r5 = r3 + 1;
            int r6 = r4 ^ (r2[r3] << 7);
            if (r6 >= 0) goto L16;
            int r7 = r6 ^ (-128);
        L15:
            long r8 = r7;
        L45:
            this.pos = r5;
            return r8;
        L16:
            int r9 = r5 + 1;
            int r10 = r6 ^ (r2[r5] << 14);
            if (r10 < 0) goto L19;
            r5 = r9;
            r8 = r10 ^ 16256;
            goto L45
        L19:
            r5 = r9 + 1;
            int r11 = r10 ^ (r2[r9] << 21);
            if (r11 >= 0) goto L22;
            r7 = r11 ^ (-2080896);
            goto L15
        L22:
            long r12 = r11;
            int r13 = r5 + 1;
            long r14 = r12 ^ (((long) r2[r5]) << 28);
            if (r14 < 0) goto L26;
            long r15 = 266354560;
        L25:
            r8 = r14 ^ r15;
            r5 = r13;
            goto L45
        L26:
            r5 = r13 + 1;
            long r16 = r14 ^ (((long) r2[r13]) << 35);
            if (r16 >= 0) goto L30;
            long r17 = -34093383808L;
        L29:
            r8 = r16 ^ r17;
            goto L45
        L30:
            r13 = r5 + 1;
            r14 = r16 ^ (((long) r2[r5]) << 42);
            if (r14 < 0) goto L33;
            r15 = 4363953127296L;
            goto L25
        L33:
            r5 = r13 + 1;
            r16 = r14 ^ (((long) r2[r13]) << 49);
            if (r16 >= 0) goto L36;
            r17 = -558586000294016L;
            goto L29
        L36:
            int r18 = r5 + 1;
            long r19 = (r16 ^ (((long) r2[r5]) << 56)) ^ 71499008037633920L;
            if (r19 >= 0) goto L43;
            r5 = r18 + 1;
            if (r2[r18] < 0) goto L42;
        L44:
            r8 = r19;
            goto L45
        L42:
            throw InvalidProtocolBufferException.malformedVarint();
        L43:
            r5 = r18;
            goto L44
        L11:
            return readVarint64SlowPath();
        L48:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.Reader
        public boolean skipField() {
            if (isAtEnd() == true) goto L27;
            int r0 = this.tag;
            if (r0 == this.endGroupTag) goto L29;
            int r1 = WireFormat.getTagWireType(r0);
            if (r1 == 0) goto L25;
            if (r1 != 1) goto L11;
            int r2 = 8;
        L17:
            skipBytes(r2);
            return true;
        L11:
            if (r1 != 2) goto L13;
            r2 = readVarint32();
            goto L17
        L13:
            if (r1 != 3) goto L15;
            skipGroup();
            return true;
        L15:
            if (r1 != 5) goto L20;
            r2 = 4;
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

    /* synthetic */ BinaryReader(AnonymousClass1 r1) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer r1, boolean r2) {
        if (r1.hasArray() == false) goto L7;
        return new SafeHeapReader(r1, r2);
    L7:
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    public abstract int getTotalBytesRead();

    @Override // com.google.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return false;
    }
}
