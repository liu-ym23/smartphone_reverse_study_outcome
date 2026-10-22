package com.google.protobuf;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
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

    private CodedInputStreamReader(CodedInputStream r10) {
        this.nextTag = 0;
        CodedInputStream r11 = (CodedInputStream) Internal.checkNotNull(r10, "input");
        this.input = r11;
        r11.wrapper = this;
    }

    public static CodedInputStreamReader forCodedInput(CodedInputStream r10) {
        CodedInputStreamReader r11 = r10.wrapper;
        if (r11 == null) goto L6;
        return r11;
    L6:
        return new CodedInputStreamReader(r10);
    }

    private <T> void mergeGroupFieldInternal(T r10, Schema<T> r11, ExtensionRegistryLite r12) {
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

    private <T> void mergeMessageFieldInternal(T r10, Schema<T> r11, ExtensionRegistryLite r12) {
        int r13 = this.input.readUInt32();
        this.input.checkRecursionLimit();
        int r14 = this.input.pushLimit(r13);
        this.input.messageDepth++;
        r11.mergeFrom(r10, this, r12);
        this.input.checkLastTagWas(0);
        CodedInputStream r15 = this.input;
        r15.messageDepth--;
        r15.popLimit(r14);
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
        mergeGroupFieldInternal(r12, r10, r11);
        r10.makeImmutable(r12);
        return r12;
    }

    private <T> T readMessage(Schema<T> r10, ExtensionRegistryLite r11) {
        T r12 = r10.newInstance();
        mergeMessageFieldInternal(r12, r10, r11);
        r10.makeImmutable(r12);
        return r12;
    }

    private void requirePosition(int r10) {
        if (this.input.getTotalBytesRead() != r10) goto L6;
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

    private void verifyPackedFixed32Length(int r10) {
        if ((r10 & 3) != 0) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.parseFailure();
    }

    private void verifyPackedFixed64Length(int r10) {
        if ((r10 & 7) != 0) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.protobuf.Reader
    public int getFieldNumber() {
        int r10 = this.nextTag;
        if (r10 == 0) goto L5;
        this.tag = r10;
        this.nextTag = 0;
    L6:
        int r11 = this.tag;
        if (r11 != 0) goto L9;
        return Integer.MAX_VALUE;
    L9:
        if (r11 != this.endGroupTag) goto L12;
        return Integer.MAX_VALUE;
    L12:
        return WireFormat.getTagFieldNumber(r11);
    L5:
        this.tag = this.input.readTag();
        goto L6
    }

    @Override // com.google.protobuf.Reader
    public int getTag() {
        return this.tag;
    }

    @Override // com.google.protobuf.Reader
    public <T> void mergeGroupField(T r10, Schema<T> r11, ExtensionRegistryLite r12) {
        requireWireType(3);
        mergeGroupFieldInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Reader
    public <T> void mergeMessageField(T r10, Schema<T> r11, ExtensionRegistryLite r12) {
        requireWireType(2);
        mergeMessageFieldInternal(r10, r11, r12);
    }

    @Override // com.google.protobuf.Reader
    public boolean readBool() {
        requireWireType(0);
        return this.input.readBool();
    }

    @Override // com.google.protobuf.Reader
    public void readBoolList(List<Boolean> r10) {
        if ((r10 instanceof BooleanArrayList) == false) goto L20;
        BooleanArrayList r11 = (BooleanArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 0) goto L13;
        if (r12 != 2) goto L12;
        int r13 = this.input.readUInt32();
        int r14 = this.input.getTotalBytesRead() + r13;
    L8:
        r11.addBoolean(this.input.readBool());
        if (this.input.getTotalBytesRead() < r14) goto L8;
    L26:
        requirePosition(r14);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r11.addBoolean(this.input.readBool());
        if (this.input.isAtEnd() == true) goto L15;
        int r15 = this.input.readTag();
        if (r15 == this.tag) goto L13;
        this.nextTag = r15;
        return;
    L15:
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 0) goto L30;
        if (r16 != 2) goto L29;
        int r17 = this.input.readUInt32();
        r14 = this.input.getTotalBytesRead() + r17;
    L24:
        r10.add(Boolean.valueOf(this.input.readBool()));
        if (this.input.getTotalBytesRead() < r14) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r10.add(Boolean.valueOf(this.input.readBool()));
        if (this.input.isAtEnd() == true) goto L32;
        int r18 = this.input.readTag();
        if (r18 == this.tag) goto L30;
        this.nextTag = r18;
        return;
    }

    @Override // com.google.protobuf.Reader
    public ByteString readBytes() {
        requireWireType(2);
        return this.input.readBytes();
    }

    @Override // com.google.protobuf.Reader
    public void readBytesList(List<ByteString> r10) {
        if (WireFormat.getTagWireType(this.tag) != 2) goto L12;
    L4:
        r10.add(readBytes());
        if (this.input.isAtEnd() == true) goto L6;
        int r11 = this.input.readTag();
        if (r11 == this.tag) goto L4;
        this.nextTag = r11;
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
    public void readDoubleList(List<Double> r10) {
        if ((r10 instanceof DoubleArrayList) == false) goto L20;
        DoubleArrayList r11 = (DoubleArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 1) goto L13;
        if (r12 != 2) goto L12;
        int r13 = this.input.readUInt32();
        verifyPackedFixed64Length(r13);
        int r14 = this.input.getTotalBytesRead() + r13;
    L8:
        r11.addDouble(this.input.readDouble());
        if (this.input.getTotalBytesRead() < r14) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r11.addDouble(this.input.readDouble());
        if (this.input.isAtEnd() == true) goto L15;
        int r15 = this.input.readTag();
        if (r15 == this.tag) goto L13;
        this.nextTag = r15;
        return;
    L15:
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 1) goto L29;
        if (r16 != 2) goto L28;
        int r17 = this.input.readUInt32();
        verifyPackedFixed64Length(r17);
        int r18 = this.input.getTotalBytesRead() + r17;
    L24:
        r10.add(Double.valueOf(this.input.readDouble()));
        if (this.input.getTotalBytesRead() < r18) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        r10.add(Double.valueOf(this.input.readDouble()));
        if (this.input.isAtEnd() == true) goto L31;
        int r19 = this.input.readTag();
        if (r19 == this.tag) goto L29;
        this.nextTag = r19;
        return;
    }

    @Override // com.google.protobuf.Reader
    public int readEnum() {
        requireWireType(0);
        return this.input.readEnum();
    }

    @Override // com.google.protobuf.Reader
    public void readEnumList(List<Integer> r10) {
        if ((r10 instanceof IntArrayList) == false) goto L20;
        IntArrayList r11 = (IntArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 0) goto L13;
        if (r12 != 2) goto L12;
        int r13 = this.input.readUInt32();
        int r14 = this.input.getTotalBytesRead() + r13;
    L8:
        r11.addInt(this.input.readEnum());
        if (this.input.getTotalBytesRead() < r14) goto L8;
    L26:
        requirePosition(r14);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r11.addInt(this.input.readEnum());
        if (this.input.isAtEnd() == true) goto L15;
        int r15 = this.input.readTag();
        if (r15 == this.tag) goto L13;
        this.nextTag = r15;
        return;
    L15:
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 0) goto L30;
        if (r16 != 2) goto L29;
        int r17 = this.input.readUInt32();
        r14 = this.input.getTotalBytesRead() + r17;
    L24:
        r10.add(Integer.valueOf(this.input.readEnum()));
        if (this.input.getTotalBytesRead() < r14) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r10.add(Integer.valueOf(this.input.readEnum()));
        if (this.input.isAtEnd() == true) goto L32;
        int r18 = this.input.readTag();
        if (r18 == this.tag) goto L30;
        this.nextTag = r18;
        return;
    }

    @Override // com.google.protobuf.Reader
    public int readFixed32() {
        requireWireType(5);
        return this.input.readFixed32();
    }

    @Override // com.google.protobuf.Reader
    public void readFixed32List(List<Integer> r10) {
        if ((r10 instanceof IntArrayList) == false) goto L20;
        IntArrayList r11 = (IntArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 2) goto L16;
        if (r12 != 5) goto L15;
    L7:
        r11.addInt(this.input.readFixed32());
        if (this.input.isAtEnd() == true) goto L9;
        int r13 = this.input.readTag();
        if (r13 == this.tag) goto L7;
        this.nextTag = r13;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r14 = this.input.readUInt32();
        verifyPackedFixed32Length(r14);
        int r15 = this.input.getTotalBytesRead() + r14;
    L17:
        r11.addInt(this.input.readFixed32());
        if (this.input.getTotalBytesRead() < r15) goto L17;
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 2) goto L32;
        if (r16 != 5) goto L31;
    L23:
        r10.add(Integer.valueOf(this.input.readFixed32()));
        if (this.input.isAtEnd() == true) goto L25;
        int r17 = this.input.readTag();
        if (r17 == this.tag) goto L23;
        this.nextTag = r17;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r18 = this.input.readUInt32();
        verifyPackedFixed32Length(r18);
        int r19 = this.input.getTotalBytesRead() + r18;
    L33:
        r10.add(Integer.valueOf(this.input.readFixed32()));
        if (this.input.getTotalBytesRead() < r19) goto L33;
    }

    @Override // com.google.protobuf.Reader
    public long readFixed64() {
        requireWireType(1);
        return this.input.readFixed64();
    }

    @Override // com.google.protobuf.Reader
    public void readFixed64List(List<Long> r10) {
        if ((r10 instanceof LongArrayList) == false) goto L20;
        LongArrayList r11 = (LongArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 1) goto L13;
        if (r12 != 2) goto L12;
        int r13 = this.input.readUInt32();
        verifyPackedFixed64Length(r13);
        int r14 = this.input.getTotalBytesRead() + r13;
    L8:
        r11.addLong(this.input.readFixed64());
        if (this.input.getTotalBytesRead() < r14) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r11.addLong(this.input.readFixed64());
        if (this.input.isAtEnd() == true) goto L15;
        int r15 = this.input.readTag();
        if (r15 == this.tag) goto L13;
        this.nextTag = r15;
        return;
    L15:
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 1) goto L29;
        if (r16 != 2) goto L28;
        int r17 = this.input.readUInt32();
        verifyPackedFixed64Length(r17);
        int r18 = this.input.getTotalBytesRead() + r17;
    L24:
        r10.add(Long.valueOf(this.input.readFixed64()));
        if (this.input.getTotalBytesRead() < r18) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        r10.add(Long.valueOf(this.input.readFixed64()));
        if (this.input.isAtEnd() == true) goto L31;
        int r19 = this.input.readTag();
        if (r19 == this.tag) goto L29;
        this.nextTag = r19;
        return;
    }

    @Override // com.google.protobuf.Reader
    public float readFloat() {
        requireWireType(5);
        return this.input.readFloat();
    }

    @Override // com.google.protobuf.Reader
    public void readFloatList(List<Float> r10) {
        if ((r10 instanceof FloatArrayList) == false) goto L20;
        FloatArrayList r11 = (FloatArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 2) goto L16;
        if (r12 != 5) goto L15;
    L7:
        r11.addFloat(this.input.readFloat());
        if (this.input.isAtEnd() == true) goto L9;
        int r13 = this.input.readTag();
        if (r13 == this.tag) goto L7;
        this.nextTag = r13;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r14 = this.input.readUInt32();
        verifyPackedFixed32Length(r14);
        int r15 = this.input.getTotalBytesRead() + r14;
    L17:
        r11.addFloat(this.input.readFloat());
        if (this.input.getTotalBytesRead() < r15) goto L17;
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 2) goto L32;
        if (r16 != 5) goto L31;
    L23:
        r10.add(Float.valueOf(this.input.readFloat()));
        if (this.input.isAtEnd() == true) goto L25;
        int r17 = this.input.readTag();
        if (r17 == this.tag) goto L23;
        this.nextTag = r17;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r18 = this.input.readUInt32();
        verifyPackedFixed32Length(r18);
        int r19 = this.input.getTotalBytesRead() + r18;
    L33:
        r10.add(Float.valueOf(this.input.readFloat()));
        if (this.input.getTotalBytesRead() < r19) goto L33;
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
        if (WireFormat.getTagWireType(this.tag) != 3) goto L15;
        int r13 = this.tag;
    L5:
        r10.add(readGroup(r11, r12));
        if (this.input.isAtEnd() == true) goto L20;
        if (this.nextTag != 0) goto L21;
        int r14 = this.input.readTag();
        if (r14 == r13) goto L5;
        this.nextTag = r14;
        return;
    L21:
        return;
    L20:
        return;
    L15:
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
        return this.input.readInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readInt32List(List<Integer> r10) {
        if ((r10 instanceof IntArrayList) == false) goto L20;
        IntArrayList r11 = (IntArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 0) goto L13;
        if (r12 != 2) goto L12;
        int r13 = this.input.readUInt32();
        int r14 = this.input.getTotalBytesRead() + r13;
    L8:
        r11.addInt(this.input.readInt32());
        if (this.input.getTotalBytesRead() < r14) goto L8;
    L26:
        requirePosition(r14);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r11.addInt(this.input.readInt32());
        if (this.input.isAtEnd() == true) goto L15;
        int r15 = this.input.readTag();
        if (r15 == this.tag) goto L13;
        this.nextTag = r15;
        return;
    L15:
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 0) goto L30;
        if (r16 != 2) goto L29;
        int r17 = this.input.readUInt32();
        r14 = this.input.getTotalBytesRead() + r17;
    L24:
        r10.add(Integer.valueOf(this.input.readInt32()));
        if (this.input.getTotalBytesRead() < r14) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r10.add(Integer.valueOf(this.input.readInt32()));
        if (this.input.isAtEnd() == true) goto L32;
        int r18 = this.input.readTag();
        if (r18 == this.tag) goto L30;
        this.nextTag = r18;
        return;
    }

    @Override // com.google.protobuf.Reader
    public long readInt64() {
        requireWireType(0);
        return this.input.readInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readInt64List(List<Long> r10) {
        if ((r10 instanceof LongArrayList) == false) goto L20;
        LongArrayList r11 = (LongArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 0) goto L13;
        if (r12 != 2) goto L12;
        int r13 = this.input.readUInt32();
        int r14 = this.input.getTotalBytesRead() + r13;
    L8:
        r11.addLong(this.input.readInt64());
        if (this.input.getTotalBytesRead() < r14) goto L8;
    L26:
        requirePosition(r14);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r11.addLong(this.input.readInt64());
        if (this.input.isAtEnd() == true) goto L15;
        int r15 = this.input.readTag();
        if (r15 == this.tag) goto L13;
        this.nextTag = r15;
        return;
    L15:
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 0) goto L30;
        if (r16 != 2) goto L29;
        int r17 = this.input.readUInt32();
        r14 = this.input.getTotalBytesRead() + r17;
    L24:
        r10.add(Long.valueOf(this.input.readInt64()));
        if (this.input.getTotalBytesRead() < r14) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r10.add(Long.valueOf(this.input.readInt64()));
        if (this.input.isAtEnd() == true) goto L32;
        int r18 = this.input.readTag();
        if (r18 == this.tag) goto L30;
        this.nextTag = r18;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    public <K, V> void readMap(Map<K, V> r10, MapEntryLite.Metadata<K, V> r11, ExtensionRegistryLite r12) {
        requireWireType(2);
        int r13 = this.input.readUInt32();
        int r14 = this.input.pushLimit(r13);
        Object r15 = r11.defaultKey;
        Object r16 = r11.defaultValue;
    L31:
        int r17 = getFieldNumber();     // Catch: Throwable -> L28
        if (r17 == Integer.MAX_VALUE) goto L25;
        if (this.input.isAtEnd() == true) goto L25;
        if (r17 != 1) goto L10;
        r15 = readField(r11.keyType, null, null);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L28
        goto L31
    L10:
        if (r17 == 2) goto L16;
    L19:
        e = move-exception;
        if (skipField() == true) goto L31;
        throw new InvalidProtocolBufferException("Unable to parse map entry.", e);     // Catch: Throwable -> L28
    L12:
        if (skipField() == true) goto L31;
        throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L28
    L16:
        r16 = readField(r11.valueType, r11.defaultValue.getClass(), r12);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L28
    L25:
        r10.put(r15, r16);     // Catch: Throwable -> L28
        this.input.popLimit(r14);
        return;
    L28:
        th = move-exception;
        this.input.popLimit(r14);
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
        if (WireFormat.getTagWireType(this.tag) != 2) goto L15;
        int r13 = this.tag;
    L5:
        r10.add(readMessage(r11, r12));
        if (this.input.isAtEnd() == true) goto L20;
        if (this.nextTag != 0) goto L21;
        int r14 = this.input.readTag();
        if (r14 == r13) goto L5;
        this.nextTag = r14;
        return;
    L21:
        return;
    L20:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.protobuf.Reader
    public <T> void readMessageList(List<T> r10, Class<T> r11, ExtensionRegistryLite r12) {
        readMessageList(r10, Protobuf.getInstance().schemaFor(r11), r12);
    }

    @Override // com.google.protobuf.Reader
    public int readSFixed32() {
        requireWireType(5);
        return this.input.readSFixed32();
    }

    @Override // com.google.protobuf.Reader
    public void readSFixed32List(List<Integer> r10) {
        if ((r10 instanceof IntArrayList) == false) goto L20;
        IntArrayList r11 = (IntArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 2) goto L16;
        if (r12 != 5) goto L15;
    L7:
        r11.addInt(this.input.readSFixed32());
        if (this.input.isAtEnd() == true) goto L9;
        int r13 = this.input.readTag();
        if (r13 == this.tag) goto L7;
        this.nextTag = r13;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r14 = this.input.readUInt32();
        verifyPackedFixed32Length(r14);
        int r15 = this.input.getTotalBytesRead() + r14;
    L17:
        r11.addInt(this.input.readSFixed32());
        if (this.input.getTotalBytesRead() < r15) goto L17;
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 2) goto L32;
        if (r16 != 5) goto L31;
    L23:
        r10.add(Integer.valueOf(this.input.readSFixed32()));
        if (this.input.isAtEnd() == true) goto L25;
        int r17 = this.input.readTag();
        if (r17 == this.tag) goto L23;
        this.nextTag = r17;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r18 = this.input.readUInt32();
        verifyPackedFixed32Length(r18);
        int r19 = this.input.getTotalBytesRead() + r18;
    L33:
        r10.add(Integer.valueOf(this.input.readSFixed32()));
        if (this.input.getTotalBytesRead() < r19) goto L33;
    }

    @Override // com.google.protobuf.Reader
    public long readSFixed64() {
        requireWireType(1);
        return this.input.readSFixed64();
    }

    @Override // com.google.protobuf.Reader
    public void readSFixed64List(List<Long> r10) {
        if ((r10 instanceof LongArrayList) == false) goto L20;
        LongArrayList r11 = (LongArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 1) goto L13;
        if (r12 != 2) goto L12;
        int r13 = this.input.readUInt32();
        verifyPackedFixed64Length(r13);
        int r14 = this.input.getTotalBytesRead() + r13;
    L8:
        r11.addLong(this.input.readSFixed64());
        if (this.input.getTotalBytesRead() < r14) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r11.addLong(this.input.readSFixed64());
        if (this.input.isAtEnd() == true) goto L15;
        int r15 = this.input.readTag();
        if (r15 == this.tag) goto L13;
        this.nextTag = r15;
        return;
    L15:
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 1) goto L29;
        if (r16 != 2) goto L28;
        int r17 = this.input.readUInt32();
        verifyPackedFixed64Length(r17);
        int r18 = this.input.getTotalBytesRead() + r17;
    L24:
        r10.add(Long.valueOf(this.input.readSFixed64()));
        if (this.input.getTotalBytesRead() < r18) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        r10.add(Long.valueOf(this.input.readSFixed64()));
        if (this.input.isAtEnd() == true) goto L31;
        int r19 = this.input.readTag();
        if (r19 == this.tag) goto L29;
        this.nextTag = r19;
        return;
    }

    @Override // com.google.protobuf.Reader
    public int readSInt32() {
        requireWireType(0);
        return this.input.readSInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readSInt32List(List<Integer> r10) {
        if ((r10 instanceof IntArrayList) == false) goto L20;
        IntArrayList r11 = (IntArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 0) goto L13;
        if (r12 != 2) goto L12;
        int r13 = this.input.readUInt32();
        int r14 = this.input.getTotalBytesRead() + r13;
    L8:
        r11.addInt(this.input.readSInt32());
        if (this.input.getTotalBytesRead() < r14) goto L8;
    L26:
        requirePosition(r14);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r11.addInt(this.input.readSInt32());
        if (this.input.isAtEnd() == true) goto L15;
        int r15 = this.input.readTag();
        if (r15 == this.tag) goto L13;
        this.nextTag = r15;
        return;
    L15:
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 0) goto L30;
        if (r16 != 2) goto L29;
        int r17 = this.input.readUInt32();
        r14 = this.input.getTotalBytesRead() + r17;
    L24:
        r10.add(Integer.valueOf(this.input.readSInt32()));
        if (this.input.getTotalBytesRead() < r14) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r10.add(Integer.valueOf(this.input.readSInt32()));
        if (this.input.isAtEnd() == true) goto L32;
        int r18 = this.input.readTag();
        if (r18 == this.tag) goto L30;
        this.nextTag = r18;
        return;
    }

    @Override // com.google.protobuf.Reader
    public long readSInt64() {
        requireWireType(0);
        return this.input.readSInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readSInt64List(List<Long> r10) {
        if ((r10 instanceof LongArrayList) == false) goto L20;
        LongArrayList r11 = (LongArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 0) goto L13;
        if (r12 != 2) goto L12;
        int r13 = this.input.readUInt32();
        int r14 = this.input.getTotalBytesRead() + r13;
    L8:
        r11.addLong(this.input.readSInt64());
        if (this.input.getTotalBytesRead() < r14) goto L8;
    L26:
        requirePosition(r14);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r11.addLong(this.input.readSInt64());
        if (this.input.isAtEnd() == true) goto L15;
        int r15 = this.input.readTag();
        if (r15 == this.tag) goto L13;
        this.nextTag = r15;
        return;
    L15:
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 0) goto L30;
        if (r16 != 2) goto L29;
        int r17 = this.input.readUInt32();
        r14 = this.input.getTotalBytesRead() + r17;
    L24:
        r10.add(Long.valueOf(this.input.readSInt64()));
        if (this.input.getTotalBytesRead() < r14) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r10.add(Long.valueOf(this.input.readSInt64()));
        if (this.input.isAtEnd() == true) goto L32;
        int r18 = this.input.readTag();
        if (r18 == this.tag) goto L30;
        this.nextTag = r18;
        return;
    }

    @Override // com.google.protobuf.Reader
    public String readString() {
        requireWireType(2);
        return this.input.readString();
    }

    @Override // com.google.protobuf.Reader
    public void readStringList(List<String> r10) {
        readStringListInternal(r10, false);
    }

    public void readStringListInternal(List<String> r10, boolean r11) {
        if (WireFormat.getTagWireType(this.tag) != 2) goto L26;
        if ((r10 instanceof LazyStringList) == false) goto L15;
        if (r11 == true) goto L15;
        LazyStringList r12 = (LazyStringList) r10;
    L8:
        r12.add(readBytes());
        if (this.input.isAtEnd() == true) goto L10;
        int r13 = this.input.readTag();
        if (r13 == this.tag) goto L8;
        this.nextTag = r13;
        return;
    L10:
        return;
    L15:
        if (r11 == false) goto L17;
        String r14 = readStringRequireUtf8();
    L18:
        r10.add(r14);
        if (this.input.isAtEnd() == true) goto L20;
        int r15 = this.input.readTag();
        if (r15 == this.tag) goto L15;
        this.nextTag = r15;
        return;
    L20:
        return;
    L17:
        r14 = readString();
        goto L18
    L26:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.protobuf.Reader
    public void readStringListRequireUtf8(List<String> r10) {
        readStringListInternal(r10, true);
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
    public void readUInt32List(List<Integer> r10) {
        if ((r10 instanceof IntArrayList) == false) goto L20;
        IntArrayList r11 = (IntArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 0) goto L13;
        if (r12 != 2) goto L12;
        int r13 = this.input.readUInt32();
        int r14 = this.input.getTotalBytesRead() + r13;
    L8:
        r11.addInt(this.input.readUInt32());
        if (this.input.getTotalBytesRead() < r14) goto L8;
    L26:
        requirePosition(r14);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r11.addInt(this.input.readUInt32());
        if (this.input.isAtEnd() == true) goto L15;
        int r15 = this.input.readTag();
        if (r15 == this.tag) goto L13;
        this.nextTag = r15;
        return;
    L15:
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 0) goto L30;
        if (r16 != 2) goto L29;
        int r17 = this.input.readUInt32();
        r14 = this.input.getTotalBytesRead() + r17;
    L24:
        r10.add(Integer.valueOf(this.input.readUInt32()));
        if (this.input.getTotalBytesRead() < r14) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r10.add(Integer.valueOf(this.input.readUInt32()));
        if (this.input.isAtEnd() == true) goto L32;
        int r18 = this.input.readTag();
        if (r18 == this.tag) goto L30;
        this.nextTag = r18;
        return;
    }

    @Override // com.google.protobuf.Reader
    public long readUInt64() {
        requireWireType(0);
        return this.input.readUInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readUInt64List(List<Long> r10) {
        if ((r10 instanceof LongArrayList) == false) goto L20;
        LongArrayList r11 = (LongArrayList) r10;
        int r12 = WireFormat.getTagWireType(this.tag);
        if (r12 == 0) goto L13;
        if (r12 != 2) goto L12;
        int r13 = this.input.readUInt32();
        int r14 = this.input.getTotalBytesRead() + r13;
    L8:
        r11.addLong(this.input.readUInt64());
        if (this.input.getTotalBytesRead() < r14) goto L8;
    L26:
        requirePosition(r14);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r11.addLong(this.input.readUInt64());
        if (this.input.isAtEnd() == true) goto L15;
        int r15 = this.input.readTag();
        if (r15 == this.tag) goto L13;
        this.nextTag = r15;
        return;
    L15:
        return;
    L20:
        int r16 = WireFormat.getTagWireType(this.tag);
        if (r16 == 0) goto L30;
        if (r16 != 2) goto L29;
        int r17 = this.input.readUInt32();
        r14 = this.input.getTotalBytesRead() + r17;
    L24:
        r10.add(Long.valueOf(this.input.readUInt64()));
        if (this.input.getTotalBytesRead() < r14) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r10.add(Long.valueOf(this.input.readUInt64()));
        if (this.input.isAtEnd() == true) goto L32;
        int r18 = this.input.readTag();
        if (r18 == this.tag) goto L30;
        this.nextTag = r18;
        return;
    }

    @Override // com.google.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return this.input.shouldDiscardUnknownFields();
    }

    @Override // com.google.protobuf.Reader
    public boolean skipField() {
        if (this.input.isAtEnd() == true) goto L9;
        int r10 = this.tag;
        if (r10 != this.endGroupTag) goto L8;
        return false;
    L8:
        return this.input.skipField(r10);
    L9:
        return false;
    }
}
