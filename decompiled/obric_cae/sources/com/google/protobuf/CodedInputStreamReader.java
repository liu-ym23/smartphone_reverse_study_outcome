package com.google.protobuf;

import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class CodedInputStreamReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;
    private static final int NEXT_TAG_UNSET = 0;
    private int endGroupTag;
    private final CodedInputStream input;
    private int nextTag;
    private int tag;

    /* JADX INFO: renamed from: com.google.protobuf.CodedInputStreamReader$1, reason: invalid class name */
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

    private CodedInputStreamReader(CodedInputStream r8) {
        this.nextTag = 0;
        CodedInputStream r10 = (CodedInputStream) Internal.checkNotNull(r8, QesdkUtils.TAGS.TAG_INPUT);
        this.input = r10;
        r10.wrapper = this;
    }

    public static CodedInputStreamReader forCodedInput(CodedInputStream r8) {
        Object r10 = r8.wrapper;
        if (r10 == null) goto L7;
        return (CodedInputStreamReader) r10;
    L7:
        return new CodedInputStreamReader(r8);
    }

    private <T> void mergeGroupFieldInternal(T r8, Schema<T> r10, ExtensionRegistryLite r11) {
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

    private <T> void mergeMessageFieldInternal(T r8, Schema<T> r10, ExtensionRegistryLite r11) {
        int r12 = this.input.readUInt32();
        this.input.checkRecursionLimit();
        int r13 = this.input.pushLimit(r12);
        this.input.messageDepth++;
        r10.mergeFrom(r8, this, r11);
        this.input.checkLastTagWas(0);
        CodedInputStream r14 = this.input;
        r14.messageDepth--;
        r14.popLimit(r13);
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
        throw new IllegalArgumentException("unsupported field type.");
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
        mergeGroupFieldInternal(r11, r8, r10);
        r8.makeImmutable(r11);
        return r11;
    }

    private <T> T readMessage(Schema<T> r8, ExtensionRegistryLite r10) {
        T r11 = r8.newInstance();
        mergeMessageFieldInternal(r11, r8, r10);
        r8.makeImmutable(r11);
        return r11;
    }

    private void requirePosition(int r8) {
        if (this.input.getTotalBytesRead() != r8) goto L6;
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

    private void verifyPackedFixed32Length(int r8) {
        if ((r8 & 3) != 0) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.parseFailure();
    }

    private void verifyPackedFixed64Length(int r8) {
        if ((r8 & 7) != 0) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.protobuf.Reader
    public int getFieldNumber() {
        int r8 = this.nextTag;
        if (r8 == 0) goto L5;
        this.tag = r8;
        this.nextTag = 0;
    L6:
        int r10 = this.tag;
        if (r10 != 0) goto L9;
        return Integer.MAX_VALUE;
    L9:
        if (r10 != this.endGroupTag) goto L12;
        return Integer.MAX_VALUE;
    L12:
        return WireFormat.getTagFieldNumber(r10);
    L5:
        this.tag = this.input.readTag();
        goto L6
    }

    @Override // com.google.protobuf.Reader
    public int getTag() {
        return this.tag;
    }

    @Override // com.google.protobuf.Reader
    public <T> void mergeGroupField(T r8, Schema<T> r10, ExtensionRegistryLite r11) {
        requireWireType(3);
        mergeGroupFieldInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Reader
    public <T> void mergeMessageField(T r8, Schema<T> r10, ExtensionRegistryLite r11) {
        requireWireType(2);
        mergeMessageFieldInternal(r8, r10, r11);
    }

    @Override // com.google.protobuf.Reader
    public boolean readBool() {
        requireWireType(0);
        return this.input.readBool();
    }

    @Override // com.google.protobuf.Reader
    public void readBoolList(List<Boolean> r8) {
        if ((r8 instanceof BooleanArrayList) == false) goto L20;
        BooleanArrayList r10 = (BooleanArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 0) goto L13;
        if (r11 != 2) goto L12;
        int r12 = this.input.readUInt32();
        int r13 = this.input.getTotalBytesRead() + r12;
    L8:
        r10.addBoolean(this.input.readBool());
        if (this.input.getTotalBytesRead() < r13) goto L8;
    L26:
        requirePosition(r13);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r10.addBoolean(this.input.readBool());
        if (this.input.isAtEnd() == true) goto L15;
        int r14 = this.input.readTag();
        if (r14 == this.tag) goto L13;
        this.nextTag = r14;
        return;
    L15:
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 0) goto L30;
        if (r15 != 2) goto L29;
        int r16 = this.input.readUInt32();
        r13 = this.input.getTotalBytesRead() + r16;
    L24:
        r8.add(Boolean.valueOf(this.input.readBool()));
        if (this.input.getTotalBytesRead() < r13) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r8.add(Boolean.valueOf(this.input.readBool()));
        if (this.input.isAtEnd() == true) goto L32;
        int r17 = this.input.readTag();
        if (r17 == this.tag) goto L30;
        this.nextTag = r17;
        return;
    }

    @Override // com.google.protobuf.Reader
    public ByteString readBytes() {
        requireWireType(2);
        return this.input.readBytes();
    }

    @Override // com.google.protobuf.Reader
    public void readBytesList(List<ByteString> r8) {
        if (WireFormat.getTagWireType(this.tag) != 2) goto L12;
    L4:
        r8.add(readBytes());
        if (this.input.isAtEnd() == true) goto L6;
        int r10 = this.input.readTag();
        if (r10 == this.tag) goto L4;
        this.nextTag = r10;
        return;
    L6:
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.protobuf.Reader
    public double readDouble() {
        requireWireType(1);
        return this.input.readDouble();
    }

    @Override // com.google.protobuf.Reader
    public void readDoubleList(List<Double> r8) {
        if ((r8 instanceof DoubleArrayList) == false) goto L20;
        DoubleArrayList r10 = (DoubleArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 1) goto L13;
        if (r11 != 2) goto L12;
        int r12 = this.input.readUInt32();
        verifyPackedFixed64Length(r12);
        int r13 = this.input.getTotalBytesRead() + r12;
    L8:
        r10.addDouble(this.input.readDouble());
        if (this.input.getTotalBytesRead() < r13) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r10.addDouble(this.input.readDouble());
        if (this.input.isAtEnd() == true) goto L15;
        int r14 = this.input.readTag();
        if (r14 == this.tag) goto L13;
        this.nextTag = r14;
        return;
    L15:
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 1) goto L29;
        if (r15 != 2) goto L28;
        int r16 = this.input.readUInt32();
        verifyPackedFixed64Length(r16);
        int r17 = this.input.getTotalBytesRead() + r16;
    L24:
        r8.add(Double.valueOf(this.input.readDouble()));
        if (this.input.getTotalBytesRead() < r17) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        r8.add(Double.valueOf(this.input.readDouble()));
        if (this.input.isAtEnd() == true) goto L31;
        int r18 = this.input.readTag();
        if (r18 == this.tag) goto L29;
        this.nextTag = r18;
        return;
    }

    @Override // com.google.protobuf.Reader
    public int readEnum() {
        requireWireType(0);
        return this.input.readEnum();
    }

    @Override // com.google.protobuf.Reader
    public void readEnumList(List<Integer> r8) {
        if ((r8 instanceof IntArrayList) == false) goto L20;
        IntArrayList r10 = (IntArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 0) goto L13;
        if (r11 != 2) goto L12;
        int r12 = this.input.readUInt32();
        int r13 = this.input.getTotalBytesRead() + r12;
    L8:
        r10.addInt(this.input.readEnum());
        if (this.input.getTotalBytesRead() < r13) goto L8;
    L26:
        requirePosition(r13);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r10.addInt(this.input.readEnum());
        if (this.input.isAtEnd() == true) goto L15;
        int r14 = this.input.readTag();
        if (r14 == this.tag) goto L13;
        this.nextTag = r14;
        return;
    L15:
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 0) goto L30;
        if (r15 != 2) goto L29;
        int r16 = this.input.readUInt32();
        r13 = this.input.getTotalBytesRead() + r16;
    L24:
        r8.add(Integer.valueOf(this.input.readEnum()));
        if (this.input.getTotalBytesRead() < r13) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r8.add(Integer.valueOf(this.input.readEnum()));
        if (this.input.isAtEnd() == true) goto L32;
        int r17 = this.input.readTag();
        if (r17 == this.tag) goto L30;
        this.nextTag = r17;
        return;
    }

    @Override // com.google.protobuf.Reader
    public int readFixed32() {
        requireWireType(5);
        return this.input.readFixed32();
    }

    @Override // com.google.protobuf.Reader
    public void readFixed32List(List<Integer> r8) {
        if ((r8 instanceof IntArrayList) == false) goto L20;
        IntArrayList r10 = (IntArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 2) goto L16;
        if (r11 != 5) goto L15;
    L7:
        r10.addInt(this.input.readFixed32());
        if (this.input.isAtEnd() == true) goto L9;
        int r12 = this.input.readTag();
        if (r12 == this.tag) goto L7;
        this.nextTag = r12;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r13 = this.input.readUInt32();
        verifyPackedFixed32Length(r13);
        int r14 = this.input.getTotalBytesRead() + r13;
    L17:
        r10.addInt(this.input.readFixed32());
        if (this.input.getTotalBytesRead() < r14) goto L17;
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 2) goto L32;
        if (r15 != 5) goto L31;
    L23:
        r8.add(Integer.valueOf(this.input.readFixed32()));
        if (this.input.isAtEnd() == true) goto L25;
        int r16 = this.input.readTag();
        if (r16 == this.tag) goto L23;
        this.nextTag = r16;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r17 = this.input.readUInt32();
        verifyPackedFixed32Length(r17);
        int r18 = this.input.getTotalBytesRead() + r17;
    L33:
        r8.add(Integer.valueOf(this.input.readFixed32()));
        if (this.input.getTotalBytesRead() < r18) goto L33;
    }

    @Override // com.google.protobuf.Reader
    public long readFixed64() {
        requireWireType(1);
        return this.input.readFixed64();
    }

    @Override // com.google.protobuf.Reader
    public void readFixed64List(List<Long> r8) {
        if ((r8 instanceof LongArrayList) == false) goto L20;
        LongArrayList r10 = (LongArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 1) goto L13;
        if (r11 != 2) goto L12;
        int r12 = this.input.readUInt32();
        verifyPackedFixed64Length(r12);
        int r13 = this.input.getTotalBytesRead() + r12;
    L8:
        r10.addLong(this.input.readFixed64());
        if (this.input.getTotalBytesRead() < r13) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r10.addLong(this.input.readFixed64());
        if (this.input.isAtEnd() == true) goto L15;
        int r14 = this.input.readTag();
        if (r14 == this.tag) goto L13;
        this.nextTag = r14;
        return;
    L15:
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 1) goto L29;
        if (r15 != 2) goto L28;
        int r16 = this.input.readUInt32();
        verifyPackedFixed64Length(r16);
        int r17 = this.input.getTotalBytesRead() + r16;
    L24:
        r8.add(Long.valueOf(this.input.readFixed64()));
        if (this.input.getTotalBytesRead() < r17) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        r8.add(Long.valueOf(this.input.readFixed64()));
        if (this.input.isAtEnd() == true) goto L31;
        int r18 = this.input.readTag();
        if (r18 == this.tag) goto L29;
        this.nextTag = r18;
        return;
    }

    @Override // com.google.protobuf.Reader
    public float readFloat() {
        requireWireType(5);
        return this.input.readFloat();
    }

    @Override // com.google.protobuf.Reader
    public void readFloatList(List<Float> r8) {
        if ((r8 instanceof FloatArrayList) == false) goto L20;
        FloatArrayList r10 = (FloatArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 2) goto L16;
        if (r11 != 5) goto L15;
    L7:
        r10.addFloat(this.input.readFloat());
        if (this.input.isAtEnd() == true) goto L9;
        int r12 = this.input.readTag();
        if (r12 == this.tag) goto L7;
        this.nextTag = r12;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r13 = this.input.readUInt32();
        verifyPackedFixed32Length(r13);
        int r14 = this.input.getTotalBytesRead() + r13;
    L17:
        r10.addFloat(this.input.readFloat());
        if (this.input.getTotalBytesRead() < r14) goto L17;
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 2) goto L32;
        if (r15 != 5) goto L31;
    L23:
        r8.add(Float.valueOf(this.input.readFloat()));
        if (this.input.isAtEnd() == true) goto L25;
        int r16 = this.input.readTag();
        if (r16 == this.tag) goto L23;
        this.nextTag = r16;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r17 = this.input.readUInt32();
        verifyPackedFixed32Length(r17);
        int r18 = this.input.getTotalBytesRead() + r17;
    L33:
        r8.add(Float.valueOf(this.input.readFloat()));
        if (this.input.getTotalBytesRead() < r18) goto L33;
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
        if (WireFormat.getTagWireType(this.tag) != 3) goto L15;
        int r12 = this.tag;
    L5:
        r8.add(readGroup(r10, r11));
        if (this.input.isAtEnd() == true) goto L20;
        if (this.nextTag != 0) goto L21;
        int r13 = this.input.readTag();
        if (r13 == r12) goto L5;
        this.nextTag = r13;
        return;
    L21:
        return;
    L20:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.protobuf.Reader
    public int readInt32() {
        requireWireType(0);
        return this.input.readInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readInt32List(List<Integer> r8) {
        if ((r8 instanceof IntArrayList) == false) goto L20;
        IntArrayList r10 = (IntArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 0) goto L13;
        if (r11 != 2) goto L12;
        int r12 = this.input.readUInt32();
        int r13 = this.input.getTotalBytesRead() + r12;
    L8:
        r10.addInt(this.input.readInt32());
        if (this.input.getTotalBytesRead() < r13) goto L8;
    L26:
        requirePosition(r13);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r10.addInt(this.input.readInt32());
        if (this.input.isAtEnd() == true) goto L15;
        int r14 = this.input.readTag();
        if (r14 == this.tag) goto L13;
        this.nextTag = r14;
        return;
    L15:
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 0) goto L30;
        if (r15 != 2) goto L29;
        int r16 = this.input.readUInt32();
        r13 = this.input.getTotalBytesRead() + r16;
    L24:
        r8.add(Integer.valueOf(this.input.readInt32()));
        if (this.input.getTotalBytesRead() < r13) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r8.add(Integer.valueOf(this.input.readInt32()));
        if (this.input.isAtEnd() == true) goto L32;
        int r17 = this.input.readTag();
        if (r17 == this.tag) goto L30;
        this.nextTag = r17;
        return;
    }

    @Override // com.google.protobuf.Reader
    public long readInt64() {
        requireWireType(0);
        return this.input.readInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readInt64List(List<Long> r8) {
        if ((r8 instanceof LongArrayList) == false) goto L20;
        LongArrayList r10 = (LongArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 0) goto L13;
        if (r11 != 2) goto L12;
        int r12 = this.input.readUInt32();
        int r13 = this.input.getTotalBytesRead() + r12;
    L8:
        r10.addLong(this.input.readInt64());
        if (this.input.getTotalBytesRead() < r13) goto L8;
    L26:
        requirePosition(r13);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r10.addLong(this.input.readInt64());
        if (this.input.isAtEnd() == true) goto L15;
        int r14 = this.input.readTag();
        if (r14 == this.tag) goto L13;
        this.nextTag = r14;
        return;
    L15:
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 0) goto L30;
        if (r15 != 2) goto L29;
        int r16 = this.input.readUInt32();
        r13 = this.input.getTotalBytesRead() + r16;
    L24:
        r8.add(Long.valueOf(this.input.readInt64()));
        if (this.input.getTotalBytesRead() < r13) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r8.add(Long.valueOf(this.input.readInt64()));
        if (this.input.isAtEnd() == true) goto L32;
        int r17 = this.input.readTag();
        if (r17 == this.tag) goto L30;
        this.nextTag = r17;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    public <K, V> void readMap(Map<K, V> r8, MapEntryLite.Metadata<K, V> r10, ExtensionRegistryLite r11) {
        requireWireType(2);
        int r12 = this.input.readUInt32();
        int r13 = this.input.pushLimit(r12);
        Object r14 = r10.defaultKey;
        Object r15 = r10.defaultValue;
    L31:
        int r16 = getFieldNumber();     // Catch: Throwable -> L28
        if (r16 == Integer.MAX_VALUE) goto L25;
        if (this.input.isAtEnd() == true) goto L25;
        if (r16 != 1) goto L10;
        r14 = readField(r10.keyType, null, null);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L28
        goto L31
    L10:
        if (r16 == 2) goto L16;
    L19:
        e = move-exception;
        if (skipField() == true) goto L31;
        throw new InvalidProtocolBufferException("Unable to parse map entry.", e);     // Catch: Throwable -> L28
    L12:
        if (skipField() == true) goto L31;
        throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L28
    L16:
        r15 = readField(r10.valueType, r10.defaultValue.getClass(), r11);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L28
    L25:
        r8.put(r14, r15);     // Catch: Throwable -> L28
        this.input.popLimit(r13);
        return;
    L28:
        th = move-exception;
        this.input.popLimit(r13);
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
        if (WireFormat.getTagWireType(this.tag) != 2) goto L15;
        int r12 = this.tag;
    L5:
        r8.add(readMessage(r10, r11));
        if (this.input.isAtEnd() == true) goto L20;
        if (this.nextTag != 0) goto L21;
        int r13 = this.input.readTag();
        if (r13 == r12) goto L5;
        this.nextTag = r13;
        return;
    L21:
        return;
    L20:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.protobuf.Reader
    public int readSFixed32() {
        requireWireType(5);
        return this.input.readSFixed32();
    }

    @Override // com.google.protobuf.Reader
    public void readSFixed32List(List<Integer> r8) {
        if ((r8 instanceof IntArrayList) == false) goto L20;
        IntArrayList r10 = (IntArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 2) goto L16;
        if (r11 != 5) goto L15;
    L7:
        r10.addInt(this.input.readSFixed32());
        if (this.input.isAtEnd() == true) goto L9;
        int r12 = this.input.readTag();
        if (r12 == this.tag) goto L7;
        this.nextTag = r12;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r13 = this.input.readUInt32();
        verifyPackedFixed32Length(r13);
        int r14 = this.input.getTotalBytesRead() + r13;
    L17:
        r10.addInt(this.input.readSFixed32());
        if (this.input.getTotalBytesRead() < r14) goto L17;
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 2) goto L32;
        if (r15 != 5) goto L31;
    L23:
        r8.add(Integer.valueOf(this.input.readSFixed32()));
        if (this.input.isAtEnd() == true) goto L25;
        int r16 = this.input.readTag();
        if (r16 == this.tag) goto L23;
        this.nextTag = r16;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r17 = this.input.readUInt32();
        verifyPackedFixed32Length(r17);
        int r18 = this.input.getTotalBytesRead() + r17;
    L33:
        r8.add(Integer.valueOf(this.input.readSFixed32()));
        if (this.input.getTotalBytesRead() < r18) goto L33;
    }

    @Override // com.google.protobuf.Reader
    public long readSFixed64() {
        requireWireType(1);
        return this.input.readSFixed64();
    }

    @Override // com.google.protobuf.Reader
    public void readSFixed64List(List<Long> r8) {
        if ((r8 instanceof LongArrayList) == false) goto L20;
        LongArrayList r10 = (LongArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 1) goto L13;
        if (r11 != 2) goto L12;
        int r12 = this.input.readUInt32();
        verifyPackedFixed64Length(r12);
        int r13 = this.input.getTotalBytesRead() + r12;
    L8:
        r10.addLong(this.input.readSFixed64());
        if (this.input.getTotalBytesRead() < r13) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r10.addLong(this.input.readSFixed64());
        if (this.input.isAtEnd() == true) goto L15;
        int r14 = this.input.readTag();
        if (r14 == this.tag) goto L13;
        this.nextTag = r14;
        return;
    L15:
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 1) goto L29;
        if (r15 != 2) goto L28;
        int r16 = this.input.readUInt32();
        verifyPackedFixed64Length(r16);
        int r17 = this.input.getTotalBytesRead() + r16;
    L24:
        r8.add(Long.valueOf(this.input.readSFixed64()));
        if (this.input.getTotalBytesRead() < r17) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        r8.add(Long.valueOf(this.input.readSFixed64()));
        if (this.input.isAtEnd() == true) goto L31;
        int r18 = this.input.readTag();
        if (r18 == this.tag) goto L29;
        this.nextTag = r18;
        return;
    }

    @Override // com.google.protobuf.Reader
    public int readSInt32() {
        requireWireType(0);
        return this.input.readSInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readSInt32List(List<Integer> r8) {
        if ((r8 instanceof IntArrayList) == false) goto L20;
        IntArrayList r10 = (IntArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 0) goto L13;
        if (r11 != 2) goto L12;
        int r12 = this.input.readUInt32();
        int r13 = this.input.getTotalBytesRead() + r12;
    L8:
        r10.addInt(this.input.readSInt32());
        if (this.input.getTotalBytesRead() < r13) goto L8;
    L26:
        requirePosition(r13);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r10.addInt(this.input.readSInt32());
        if (this.input.isAtEnd() == true) goto L15;
        int r14 = this.input.readTag();
        if (r14 == this.tag) goto L13;
        this.nextTag = r14;
        return;
    L15:
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 0) goto L30;
        if (r15 != 2) goto L29;
        int r16 = this.input.readUInt32();
        r13 = this.input.getTotalBytesRead() + r16;
    L24:
        r8.add(Integer.valueOf(this.input.readSInt32()));
        if (this.input.getTotalBytesRead() < r13) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r8.add(Integer.valueOf(this.input.readSInt32()));
        if (this.input.isAtEnd() == true) goto L32;
        int r17 = this.input.readTag();
        if (r17 == this.tag) goto L30;
        this.nextTag = r17;
        return;
    }

    @Override // com.google.protobuf.Reader
    public long readSInt64() {
        requireWireType(0);
        return this.input.readSInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readSInt64List(List<Long> r8) {
        if ((r8 instanceof LongArrayList) == false) goto L20;
        LongArrayList r10 = (LongArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 0) goto L13;
        if (r11 != 2) goto L12;
        int r12 = this.input.readUInt32();
        int r13 = this.input.getTotalBytesRead() + r12;
    L8:
        r10.addLong(this.input.readSInt64());
        if (this.input.getTotalBytesRead() < r13) goto L8;
    L26:
        requirePosition(r13);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r10.addLong(this.input.readSInt64());
        if (this.input.isAtEnd() == true) goto L15;
        int r14 = this.input.readTag();
        if (r14 == this.tag) goto L13;
        this.nextTag = r14;
        return;
    L15:
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 0) goto L30;
        if (r15 != 2) goto L29;
        int r16 = this.input.readUInt32();
        r13 = this.input.getTotalBytesRead() + r16;
    L24:
        r8.add(Long.valueOf(this.input.readSInt64()));
        if (this.input.getTotalBytesRead() < r13) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r8.add(Long.valueOf(this.input.readSInt64()));
        if (this.input.isAtEnd() == true) goto L32;
        int r17 = this.input.readTag();
        if (r17 == this.tag) goto L30;
        this.nextTag = r17;
        return;
    }

    @Override // com.google.protobuf.Reader
    public String readString() {
        requireWireType(2);
        return this.input.readString();
    }

    @Override // com.google.protobuf.Reader
    public void readStringList(List<String> r8) {
        readStringListInternal(r8, false);
    }

    public void readStringListInternal(List<String> r8, boolean r10) {
        if (WireFormat.getTagWireType(this.tag) != 2) goto L26;
        if ((r8 instanceof LazyStringList) == false) goto L15;
        if (r10 == true) goto L15;
        LazyStringList r11 = (LazyStringList) r8;
    L8:
        r11.add(readBytes());
        if (this.input.isAtEnd() == true) goto L10;
        int r12 = this.input.readTag();
        if (r12 == this.tag) goto L8;
        this.nextTag = r12;
        return;
    L10:
        return;
    L15:
        if (r10 == false) goto L17;
        String r13 = readStringRequireUtf8();
    L18:
        r8.add(r13);
        if (this.input.isAtEnd() == true) goto L20;
        int r14 = this.input.readTag();
        if (r14 == this.tag) goto L15;
        this.nextTag = r14;
        return;
    L20:
        return;
    L17:
        r13 = readString();
        goto L18
    L26:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.protobuf.Reader
    public void readStringListRequireUtf8(List<String> r8) {
        readStringListInternal(r8, true);
    }

    @Override // com.google.protobuf.Reader
    public String readStringRequireUtf8() {
        requireWireType(2);
        return this.input.readStringRequireUtf8();
    }

    @Override // com.google.protobuf.Reader
    public int readUInt32() {
        requireWireType(0);
        return this.input.readUInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readUInt32List(List<Integer> r8) {
        if ((r8 instanceof IntArrayList) == false) goto L20;
        IntArrayList r10 = (IntArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 0) goto L13;
        if (r11 != 2) goto L12;
        int r12 = this.input.readUInt32();
        int r13 = this.input.getTotalBytesRead() + r12;
    L8:
        r10.addInt(this.input.readUInt32());
        if (this.input.getTotalBytesRead() < r13) goto L8;
    L26:
        requirePosition(r13);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r10.addInt(this.input.readUInt32());
        if (this.input.isAtEnd() == true) goto L15;
        int r14 = this.input.readTag();
        if (r14 == this.tag) goto L13;
        this.nextTag = r14;
        return;
    L15:
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 0) goto L30;
        if (r15 != 2) goto L29;
        int r16 = this.input.readUInt32();
        r13 = this.input.getTotalBytesRead() + r16;
    L24:
        r8.add(Integer.valueOf(this.input.readUInt32()));
        if (this.input.getTotalBytesRead() < r13) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r8.add(Integer.valueOf(this.input.readUInt32()));
        if (this.input.isAtEnd() == true) goto L32;
        int r17 = this.input.readTag();
        if (r17 == this.tag) goto L30;
        this.nextTag = r17;
        return;
    }

    @Override // com.google.protobuf.Reader
    public long readUInt64() {
        requireWireType(0);
        return this.input.readUInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readUInt64List(List<Long> r8) {
        if ((r8 instanceof LongArrayList) == false) goto L20;
        LongArrayList r10 = (LongArrayList) r8;
        int r11 = WireFormat.getTagWireType(this.tag);
        if (r11 == 0) goto L13;
        if (r11 != 2) goto L12;
        int r12 = this.input.readUInt32();
        int r13 = this.input.getTotalBytesRead() + r12;
    L8:
        r10.addLong(this.input.readUInt64());
        if (this.input.getTotalBytesRead() < r13) goto L8;
    L26:
        requirePosition(r13);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r10.addLong(this.input.readUInt64());
        if (this.input.isAtEnd() == true) goto L15;
        int r14 = this.input.readTag();
        if (r14 == this.tag) goto L13;
        this.nextTag = r14;
        return;
    L15:
        return;
    L20:
        int r15 = WireFormat.getTagWireType(this.tag);
        if (r15 == 0) goto L30;
        if (r15 != 2) goto L29;
        int r16 = this.input.readUInt32();
        r13 = this.input.getTotalBytesRead() + r16;
    L24:
        r8.add(Long.valueOf(this.input.readUInt64()));
        if (this.input.getTotalBytesRead() < r13) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r8.add(Long.valueOf(this.input.readUInt64()));
        if (this.input.isAtEnd() == true) goto L32;
        int r17 = this.input.readTag();
        if (r17 == this.tag) goto L30;
        this.nextTag = r17;
        return;
    }

    @Override // com.google.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return this.input.shouldDiscardUnknownFields();
    }

    @Override // com.google.protobuf.Reader
    public boolean skipField() {
        if (this.input.isAtEnd() == true) goto L9;
        int r8 = this.tag;
        if (r8 != this.endGroupTag) goto L8;
        return false;
    L8:
        return this.input.skipField(r8);
    L9:
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
