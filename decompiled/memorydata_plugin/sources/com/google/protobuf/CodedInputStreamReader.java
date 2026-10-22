package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
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

    private CodedInputStreamReader(CodedInputStream r3) {
        this.nextTag = 0;
        CodedInputStream r4 = (CodedInputStream) ZeusTransformUtils.preCheckCast(Internal.checkNotNull(r3, "input"), CodedInputStream.class, "com.obric.memorydata.plugin");
        this.input = r4;
        r4.wrapper = this;
    }

    public static CodedInputStreamReader forCodedInput(CodedInputStream r1) {
        if (r1.wrapper == null) goto L7;
        return r1.wrapper;
    L7:
        return new CodedInputStreamReader(r1);
    }

    private <T> void mergeGroupFieldInternal(T r4, Schema<T> r5, ExtensionRegistryLite r6) {
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

    private <T> void mergeMessageFieldInternal(T r4, Schema<T> r5, ExtensionRegistryLite r6) {
        Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
        int r0 = this.input.readUInt32();
        this.input.checkRecursionLimit();
        int r1 = this.input.pushLimit(r0);
        this.input.messageDepth++;
        r7.mergeFrom(r4, this, r6);
        this.input.checkLastTagWas(0);
        this.input.messageDepth--;
        this.input.popLimit(r1);
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
        mergeGroupFieldInternal(r0, r5, r4);
        r5.makeImmutable(r0);
        return r0;
    }

    private <T> T readMessage(Schema<T> r3, ExtensionRegistryLite r4) {
        Schema<T> r5 = (Schema) ZeusTransformUtils.wrapperContextForParams(r3, Schema.class, "com.obric.memorydata.plugin");
        T r0 = r5.newInstance();
        mergeMessageFieldInternal(r0, r5, r4);
        r5.makeImmutable(r0);
        return r0;
    }

    private void requirePosition(int r1) {
        if (this.input.getTotalBytesRead() != r1) goto L6;
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

    private void verifyPackedFixed32Length(int r1) {
        if ((r1 & 3) != 0) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.parseFailure();
    }

    private void verifyPackedFixed64Length(int r1) {
        if ((r1 & 7) != 0) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.protobuf.Reader
    public int getFieldNumber() {
        int r0 = this.nextTag;
        if (r0 == 0) goto L5;
        this.tag = r0;
        this.nextTag = 0;
    L6:
        int r1 = this.tag;
        if (r1 != 0) goto L9;
        return Integer.MAX_VALUE;
    L9:
        if (r1 != this.endGroupTag) goto L12;
        return Integer.MAX_VALUE;
    L12:
        return WireFormat.getTagFieldNumber(r1);
    L5:
        this.tag = this.input.readTag();
        goto L6
    }

    @Override // com.google.protobuf.Reader
    public int getTag() {
        return this.tag;
    }

    @Override // com.google.protobuf.Reader
    public <T> void mergeGroupField(T r3, Schema<T> r4, ExtensionRegistryLite r5) {
        Schema<T> r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
        requireWireType(3);
        mergeGroupFieldInternal(r3, r6, r5);
    }

    @Override // com.google.protobuf.Reader
    public <T> void mergeMessageField(T r3, Schema<T> r4, ExtensionRegistryLite r5) {
        Schema<T> r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
        requireWireType(2);
        mergeMessageFieldInternal(r3, r6, r5);
    }

    @Override // com.google.protobuf.Reader
    public boolean readBool() {
        requireWireType(0);
        return this.input.readBool();
    }

    @Override // com.google.protobuf.Reader
    public void readBoolList(List<Boolean> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, BooleanArrayList.class) == false) goto L20;
        BooleanArrayList r0 = (BooleanArrayList) ZeusTransformUtils.preCheckCast(r5, BooleanArrayList.class, "com.obric.memorydata.plugin");
        int r6 = WireFormat.getTagWireType(this.tag);
        if (r6 == 0) goto L13;
        if (r6 != 2) goto L12;
        int r7 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r7;
    L8:
        r0.addBoolean(this.input.readBool());
        if (this.input.getTotalBytesRead() < r1) goto L8;
    L26:
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addBoolean(this.input.readBool());
        if (this.input.isAtEnd() == true) goto L15;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L13;
        this.nextTag = r8;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.input.readUInt32();
        r1 = this.input.getTotalBytesRead() + r3;
    L24:
        r5.add(Boolean.valueOf(this.input.readBool()));
        if (this.input.getTotalBytesRead() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r5.add(Boolean.valueOf(this.input.readBool()));
        if (this.input.isAtEnd() == true) goto L32;
        int r9 = this.input.readTag();
        if (r9 == this.tag) goto L30;
        this.nextTag = r9;
        return;
    }

    @Override // com.google.protobuf.Reader
    public ByteString readBytes() {
        requireWireType(2);
        return this.input.readBytes();
    }

    @Override // com.google.protobuf.Reader
    public void readBytesList(List<ByteString> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (WireFormat.getTagWireType(this.tag) != 2) goto L12;
    L4:
        r4.add(readBytes());
        if (this.input.isAtEnd() == true) goto L6;
        int r0 = this.input.readTag();
        if (r0 == this.tag) goto L4;
        this.nextTag = r0;
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
    public void readDoubleList(List<Double> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, DoubleArrayList.class) == false) goto L20;
        DoubleArrayList r0 = (DoubleArrayList) ZeusTransformUtils.preCheckCast(r6, DoubleArrayList.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.getTagWireType(this.tag);
        if (r7 == 1) goto L13;
        if (r7 != 2) goto L12;
        int r8 = this.input.readUInt32();
        verifyPackedFixed64Length(r8);
        int r1 = this.input.getTotalBytesRead() + r8;
    L8:
        r0.addDouble(this.input.readDouble());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addDouble(this.input.readDouble());
        if (this.input.isAtEnd() == true) goto L15;
        int r9 = this.input.readTag();
        if (r9 == this.tag) goto L13;
        this.nextTag = r9;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 1) goto L29;
        if (r2 != 2) goto L28;
        int r3 = this.input.readUInt32();
        verifyPackedFixed64Length(r3);
        int r4 = this.input.getTotalBytesRead() + r3;
    L24:
        r6.add(Double.valueOf(this.input.readDouble()));
        if (this.input.getTotalBytesRead() < r4) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        r6.add(Double.valueOf(this.input.readDouble()));
        if (this.input.isAtEnd() == true) goto L31;
        int r10 = this.input.readTag();
        if (r10 == this.tag) goto L29;
        this.nextTag = r10;
        return;
    }

    @Override // com.google.protobuf.Reader
    public int readEnum() {
        requireWireType(0);
        return this.input.readEnum();
    }

    @Override // com.google.protobuf.Reader
    public void readEnumList(List<Integer> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, IntArrayList.class) == false) goto L20;
        IntArrayList r0 = (IntArrayList) ZeusTransformUtils.preCheckCast(r5, IntArrayList.class, "com.obric.memorydata.plugin");
        int r6 = WireFormat.getTagWireType(this.tag);
        if (r6 == 0) goto L13;
        if (r6 != 2) goto L12;
        int r7 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r7;
    L8:
        r0.addInt(this.input.readEnum());
        if (this.input.getTotalBytesRead() < r1) goto L8;
    L26:
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addInt(this.input.readEnum());
        if (this.input.isAtEnd() == true) goto L15;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L13;
        this.nextTag = r8;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.input.readUInt32();
        r1 = this.input.getTotalBytesRead() + r3;
    L24:
        r5.add(Integer.valueOf(this.input.readEnum()));
        if (this.input.getTotalBytesRead() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r5.add(Integer.valueOf(this.input.readEnum()));
        if (this.input.isAtEnd() == true) goto L32;
        int r9 = this.input.readTag();
        if (r9 == this.tag) goto L30;
        this.nextTag = r9;
        return;
    }

    @Override // com.google.protobuf.Reader
    public int readFixed32() {
        requireWireType(5);
        return this.input.readFixed32();
    }

    @Override // com.google.protobuf.Reader
    public void readFixed32List(List<Integer> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L20;
        IntArrayList r0 = (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.getTagWireType(this.tag);
        if (r7 == 2) goto L16;
        if (r7 != 5) goto L15;
    L7:
        r0.addInt(this.input.readFixed32());
        if (this.input.isAtEnd() == true) goto L9;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L7;
        this.nextTag = r8;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r9 = this.input.readUInt32();
        verifyPackedFixed32Length(r9);
        int r1 = this.input.getTotalBytesRead() + r9;
    L17:
        r0.addInt(this.input.readFixed32());
        if (this.input.getTotalBytesRead() < r1) goto L17;
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 2) goto L32;
        if (r2 != 5) goto L31;
    L23:
        r6.add(Integer.valueOf(this.input.readFixed32()));
        if (this.input.isAtEnd() == true) goto L25;
        int r3 = this.input.readTag();
        if (r3 == this.tag) goto L23;
        this.nextTag = r3;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r4 = this.input.readUInt32();
        verifyPackedFixed32Length(r4);
        int r10 = this.input.getTotalBytesRead() + r4;
    L33:
        r6.add(Integer.valueOf(this.input.readFixed32()));
        if (this.input.getTotalBytesRead() < r10) goto L33;
    }

    @Override // com.google.protobuf.Reader
    public long readFixed64() {
        requireWireType(1);
        return this.input.readFixed64();
    }

    @Override // com.google.protobuf.Reader
    public void readFixed64List(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L20;
        LongArrayList r0 = (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.getTagWireType(this.tag);
        if (r7 == 1) goto L13;
        if (r7 != 2) goto L12;
        int r8 = this.input.readUInt32();
        verifyPackedFixed64Length(r8);
        int r1 = this.input.getTotalBytesRead() + r8;
    L8:
        r0.addLong(this.input.readFixed64());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addLong(this.input.readFixed64());
        if (this.input.isAtEnd() == true) goto L15;
        int r9 = this.input.readTag();
        if (r9 == this.tag) goto L13;
        this.nextTag = r9;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 1) goto L29;
        if (r2 != 2) goto L28;
        int r3 = this.input.readUInt32();
        verifyPackedFixed64Length(r3);
        int r4 = this.input.getTotalBytesRead() + r3;
    L24:
        r6.add(Long.valueOf(this.input.readFixed64()));
        if (this.input.getTotalBytesRead() < r4) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        r6.add(Long.valueOf(this.input.readFixed64()));
        if (this.input.isAtEnd() == true) goto L31;
        int r10 = this.input.readTag();
        if (r10 == this.tag) goto L29;
        this.nextTag = r10;
        return;
    }

    @Override // com.google.protobuf.Reader
    public float readFloat() {
        requireWireType(5);
        return this.input.readFloat();
    }

    @Override // com.google.protobuf.Reader
    public void readFloatList(List<Float> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, FloatArrayList.class) == false) goto L20;
        FloatArrayList r0 = (FloatArrayList) ZeusTransformUtils.preCheckCast(r6, FloatArrayList.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.getTagWireType(this.tag);
        if (r7 == 2) goto L16;
        if (r7 != 5) goto L15;
    L7:
        r0.addFloat(this.input.readFloat());
        if (this.input.isAtEnd() == true) goto L9;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L7;
        this.nextTag = r8;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r9 = this.input.readUInt32();
        verifyPackedFixed32Length(r9);
        int r1 = this.input.getTotalBytesRead() + r9;
    L17:
        r0.addFloat(this.input.readFloat());
        if (this.input.getTotalBytesRead() < r1) goto L17;
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 2) goto L32;
        if (r2 != 5) goto L31;
    L23:
        r6.add(Float.valueOf(this.input.readFloat()));
        if (this.input.isAtEnd() == true) goto L25;
        int r3 = this.input.readTag();
        if (r3 == this.tag) goto L23;
        this.nextTag = r3;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r4 = this.input.readUInt32();
        verifyPackedFixed32Length(r4);
        int r10 = this.input.getTotalBytesRead() + r4;
    L33:
        r6.add(Float.valueOf(this.input.readFloat()));
        if (this.input.getTotalBytesRead() < r10) goto L33;
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
    public <T> void readGroupList(List<T> r3, Schema<T> r4, ExtensionRegistryLite r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Schema<T> r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
        if (WireFormat.getTagWireType(this.tag) != 3) goto L15;
        int r0 = this.tag;
    L5:
        r6.add(readGroup(r7, r5));
        if (this.input.isAtEnd() == true) goto L20;
        if (this.nextTag != 0) goto L21;
        int r1 = this.input.readTag();
        if (r1 == r0) goto L5;
        this.nextTag = r1;
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
    public <T> void readGroupList(List<T> r3, Class<T> r4, ExtensionRegistryLite r5) {
        readGroupList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), Protobuf.getInstance().schemaFor(r4), r5);
    }

    @Override // com.google.protobuf.Reader
    public int readInt32() {
        requireWireType(0);
        return this.input.readInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readInt32List(List<Integer> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, IntArrayList.class) == false) goto L20;
        IntArrayList r0 = (IntArrayList) ZeusTransformUtils.preCheckCast(r5, IntArrayList.class, "com.obric.memorydata.plugin");
        int r6 = WireFormat.getTagWireType(this.tag);
        if (r6 == 0) goto L13;
        if (r6 != 2) goto L12;
        int r7 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r7;
    L8:
        r0.addInt(this.input.readInt32());
        if (this.input.getTotalBytesRead() < r1) goto L8;
    L26:
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addInt(this.input.readInt32());
        if (this.input.isAtEnd() == true) goto L15;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L13;
        this.nextTag = r8;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.input.readUInt32();
        r1 = this.input.getTotalBytesRead() + r3;
    L24:
        r5.add(Integer.valueOf(this.input.readInt32()));
        if (this.input.getTotalBytesRead() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r5.add(Integer.valueOf(this.input.readInt32()));
        if (this.input.isAtEnd() == true) goto L32;
        int r9 = this.input.readTag();
        if (r9 == this.tag) goto L30;
        this.nextTag = r9;
        return;
    }

    @Override // com.google.protobuf.Reader
    public long readInt64() {
        requireWireType(0);
        return this.input.readInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readInt64List(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L20;
        LongArrayList r0 = (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.getTagWireType(this.tag);
        if (r7 == 0) goto L13;
        if (r7 != 2) goto L12;
        int r8 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r8;
    L8:
        r0.addLong(this.input.readInt64());
        if (this.input.getTotalBytesRead() < r1) goto L8;
    L26:
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addLong(this.input.readInt64());
        if (this.input.isAtEnd() == true) goto L15;
        int r9 = this.input.readTag();
        if (r9 == this.tag) goto L13;
        this.nextTag = r9;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.input.readUInt32();
        r1 = this.input.getTotalBytesRead() + r3;
    L24:
        r6.add(Long.valueOf(this.input.readInt64()));
        if (this.input.getTotalBytesRead() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r6.add(Long.valueOf(this.input.readInt64()));
        if (this.input.isAtEnd() == true) goto L32;
        int r4 = this.input.readTag();
        if (r4 == this.tag) goto L30;
        this.nextTag = r4;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    public <K, V> void readMap(Map<K, V> r8, MapEntryLite.Metadata<K, V> r9, ExtensionRegistryLite r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        requireWireType(2);
        int r1 = this.input.readUInt32();
        int r2 = this.input.pushLimit(r1);
        Object r3 = r9.defaultKey;
        Object r4 = r9.defaultValue;
    L31:
        int r5 = getFieldNumber();     // Catch: Throwable -> L28
        if (r5 == Integer.MAX_VALUE) goto L25;
        if (this.input.isAtEnd() == true) goto L25;
        if (r5 != 1) goto L10;
        r3 = readField(r9.keyType, null, null);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L28
        goto L31
    L10:
        if (r5 == 2) goto L16;
    L19:
        e = move-exception;
        if (skipField() == true) goto L31;
        throw new InvalidProtocolBufferException("Unable to parse map entry.", e);     // Catch: Throwable -> L28
    L12:
        if (skipField() == true) goto L31;
        throw new InvalidProtocolBufferException("Unable to parse map entry.");     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L28
    L16:
        r4 = readField(r9.valueType, r9.defaultValue.getClass(), r10);     // Catch: InvalidProtocolBufferException.InvalidWireTypeException -> L19 Throwable -> L28
    L25:
        r11.put(r3, r4);     // Catch: Throwable -> L28
        this.input.popLimit(r2);
        return;
    L28:
        th = move-exception;
        this.input.popLimit(r2);
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
    public <T> void readMessageList(List<T> r3, Schema<T> r4, ExtensionRegistryLite r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Schema<T> r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
        if (WireFormat.getTagWireType(this.tag) != 2) goto L15;
        int r0 = this.tag;
    L5:
        r6.add(readMessage(r7, r5));
        if (this.input.isAtEnd() == true) goto L20;
        if (this.nextTag != 0) goto L21;
        int r1 = this.input.readTag();
        if (r1 == r0) goto L5;
        this.nextTag = r1;
        return;
    L21:
        return;
    L20:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.protobuf.Reader
    public <T> void readMessageList(List<T> r3, Class<T> r4, ExtensionRegistryLite r5) {
        readMessageList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), Protobuf.getInstance().schemaFor(r4), r5);
    }

    @Override // com.google.protobuf.Reader
    public int readSFixed32() {
        requireWireType(5);
        return this.input.readSFixed32();
    }

    @Override // com.google.protobuf.Reader
    public void readSFixed32List(List<Integer> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L20;
        IntArrayList r0 = (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.getTagWireType(this.tag);
        if (r7 == 2) goto L16;
        if (r7 != 5) goto L15;
    L7:
        r0.addInt(this.input.readSFixed32());
        if (this.input.isAtEnd() == true) goto L9;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L7;
        this.nextTag = r8;
        return;
    L9:
        return;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L16:
        int r9 = this.input.readUInt32();
        verifyPackedFixed32Length(r9);
        int r1 = this.input.getTotalBytesRead() + r9;
    L17:
        r0.addInt(this.input.readSFixed32());
        if (this.input.getTotalBytesRead() < r1) goto L17;
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 2) goto L32;
        if (r2 != 5) goto L31;
    L23:
        r6.add(Integer.valueOf(this.input.readSFixed32()));
        if (this.input.isAtEnd() == true) goto L25;
        int r3 = this.input.readTag();
        if (r3 == this.tag) goto L23;
        this.nextTag = r3;
        return;
    L25:
        return;
    L31:
        throw InvalidProtocolBufferException.invalidWireType();
    L32:
        int r4 = this.input.readUInt32();
        verifyPackedFixed32Length(r4);
        int r10 = this.input.getTotalBytesRead() + r4;
    L33:
        r6.add(Integer.valueOf(this.input.readSFixed32()));
        if (this.input.getTotalBytesRead() < r10) goto L33;
    }

    @Override // com.google.protobuf.Reader
    public long readSFixed64() {
        requireWireType(1);
        return this.input.readSFixed64();
    }

    @Override // com.google.protobuf.Reader
    public void readSFixed64List(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L20;
        LongArrayList r0 = (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.getTagWireType(this.tag);
        if (r7 == 1) goto L13;
        if (r7 != 2) goto L12;
        int r8 = this.input.readUInt32();
        verifyPackedFixed64Length(r8);
        int r1 = this.input.getTotalBytesRead() + r8;
    L8:
        r0.addLong(this.input.readSFixed64());
        if (this.input.getTotalBytesRead() < r1) goto L8;
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addLong(this.input.readSFixed64());
        if (this.input.isAtEnd() == true) goto L15;
        int r9 = this.input.readTag();
        if (r9 == this.tag) goto L13;
        this.nextTag = r9;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 1) goto L29;
        if (r2 != 2) goto L28;
        int r3 = this.input.readUInt32();
        verifyPackedFixed64Length(r3);
        int r4 = this.input.getTotalBytesRead() + r3;
    L24:
        r6.add(Long.valueOf(this.input.readSFixed64()));
        if (this.input.getTotalBytesRead() < r4) goto L24;
        return;
    L28:
        throw InvalidProtocolBufferException.invalidWireType();
    L29:
        r6.add(Long.valueOf(this.input.readSFixed64()));
        if (this.input.isAtEnd() == true) goto L31;
        int r10 = this.input.readTag();
        if (r10 == this.tag) goto L29;
        this.nextTag = r10;
        return;
    }

    @Override // com.google.protobuf.Reader
    public int readSInt32() {
        requireWireType(0);
        return this.input.readSInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readSInt32List(List<Integer> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, IntArrayList.class) == false) goto L20;
        IntArrayList r0 = (IntArrayList) ZeusTransformUtils.preCheckCast(r5, IntArrayList.class, "com.obric.memorydata.plugin");
        int r6 = WireFormat.getTagWireType(this.tag);
        if (r6 == 0) goto L13;
        if (r6 != 2) goto L12;
        int r7 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r7;
    L8:
        r0.addInt(this.input.readSInt32());
        if (this.input.getTotalBytesRead() < r1) goto L8;
    L26:
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addInt(this.input.readSInt32());
        if (this.input.isAtEnd() == true) goto L15;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L13;
        this.nextTag = r8;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.input.readUInt32();
        r1 = this.input.getTotalBytesRead() + r3;
    L24:
        r5.add(Integer.valueOf(this.input.readSInt32()));
        if (this.input.getTotalBytesRead() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r5.add(Integer.valueOf(this.input.readSInt32()));
        if (this.input.isAtEnd() == true) goto L32;
        int r9 = this.input.readTag();
        if (r9 == this.tag) goto L30;
        this.nextTag = r9;
        return;
    }

    @Override // com.google.protobuf.Reader
    public long readSInt64() {
        requireWireType(0);
        return this.input.readSInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readSInt64List(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L20;
        LongArrayList r0 = (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.getTagWireType(this.tag);
        if (r7 == 0) goto L13;
        if (r7 != 2) goto L12;
        int r8 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r8;
    L8:
        r0.addLong(this.input.readSInt64());
        if (this.input.getTotalBytesRead() < r1) goto L8;
    L26:
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addLong(this.input.readSInt64());
        if (this.input.isAtEnd() == true) goto L15;
        int r9 = this.input.readTag();
        if (r9 == this.tag) goto L13;
        this.nextTag = r9;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.input.readUInt32();
        r1 = this.input.getTotalBytesRead() + r3;
    L24:
        r6.add(Long.valueOf(this.input.readSInt64()));
        if (this.input.getTotalBytesRead() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r6.add(Long.valueOf(this.input.readSInt64()));
        if (this.input.isAtEnd() == true) goto L32;
        int r4 = this.input.readTag();
        if (r4 == this.tag) goto L30;
        this.nextTag = r4;
        return;
    }

    @Override // com.google.protobuf.Reader
    public String readString() {
        requireWireType(2);
        return this.input.readString();
    }

    @Override // com.google.protobuf.Reader
    public void readStringList(List<String> r3) {
        readStringListInternal((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), false);
    }

    public void readStringListInternal(List<String> r4, boolean r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (WireFormat.getTagWireType(this.tag) != 2) goto L26;
        if (ZeusTransformUtils.instanceOf(r6, LazyStringList.class) == false) goto L15;
        if (r5 == true) goto L15;
        LazyStringList r0 = (LazyStringList) ZeusTransformUtils.preCheckCast(r6, LazyStringList.class, "com.obric.memorydata.plugin");
    L8:
        r0.add(readBytes());
        if (this.input.isAtEnd() == true) goto L10;
        int r7 = this.input.readTag();
        if (r7 == this.tag) goto L8;
        this.nextTag = r7;
        return;
    L10:
        return;
    L15:
        if (r5 == false) goto L17;
        String r1 = readStringRequireUtf8();
    L18:
        r6.add(r1);
        if (this.input.isAtEnd() == true) goto L20;
        int r2 = this.input.readTag();
        if (r2 == this.tag) goto L15;
        this.nextTag = r2;
        return;
    L20:
        return;
    L17:
        r1 = readString();
        goto L18
    L26:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.protobuf.Reader
    public void readStringListRequireUtf8(List<String> r3) {
        readStringListInternal((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), true);
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
    public void readUInt32List(List<Integer> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, IntArrayList.class) == false) goto L20;
        IntArrayList r0 = (IntArrayList) ZeusTransformUtils.preCheckCast(r5, IntArrayList.class, "com.obric.memorydata.plugin");
        int r6 = WireFormat.getTagWireType(this.tag);
        if (r6 == 0) goto L13;
        if (r6 != 2) goto L12;
        int r7 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r7;
    L8:
        r0.addInt(this.input.readUInt32());
        if (this.input.getTotalBytesRead() < r1) goto L8;
    L26:
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addInt(this.input.readUInt32());
        if (this.input.isAtEnd() == true) goto L15;
        int r8 = this.input.readTag();
        if (r8 == this.tag) goto L13;
        this.nextTag = r8;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.input.readUInt32();
        r1 = this.input.getTotalBytesRead() + r3;
    L24:
        r5.add(Integer.valueOf(this.input.readUInt32()));
        if (this.input.getTotalBytesRead() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r5.add(Integer.valueOf(this.input.readUInt32()));
        if (this.input.isAtEnd() == true) goto L32;
        int r9 = this.input.readTag();
        if (r9 == this.tag) goto L30;
        this.nextTag = r9;
        return;
    }

    @Override // com.google.protobuf.Reader
    public long readUInt64() {
        requireWireType(0);
        return this.input.readUInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readUInt64List(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L20;
        LongArrayList r0 = (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.memorydata.plugin");
        int r7 = WireFormat.getTagWireType(this.tag);
        if (r7 == 0) goto L13;
        if (r7 != 2) goto L12;
        int r8 = this.input.readUInt32();
        int r1 = this.input.getTotalBytesRead() + r8;
    L8:
        r0.addLong(this.input.readUInt64());
        if (this.input.getTotalBytesRead() < r1) goto L8;
    L26:
        requirePosition(r1);
        return;
    L12:
        throw InvalidProtocolBufferException.invalidWireType();
    L13:
        r0.addLong(this.input.readUInt64());
        if (this.input.isAtEnd() == true) goto L15;
        int r9 = this.input.readTag();
        if (r9 == this.tag) goto L13;
        this.nextTag = r9;
        return;
    L15:
        return;
    L20:
        int r2 = WireFormat.getTagWireType(this.tag);
        if (r2 == 0) goto L30;
        if (r2 != 2) goto L29;
        int r3 = this.input.readUInt32();
        r1 = this.input.getTotalBytesRead() + r3;
    L24:
        r6.add(Long.valueOf(this.input.readUInt64()));
        if (this.input.getTotalBytesRead() < r1) goto L24;
    L29:
        throw InvalidProtocolBufferException.invalidWireType();
    L30:
        r6.add(Long.valueOf(this.input.readUInt64()));
        if (this.input.isAtEnd() == true) goto L32;
        int r4 = this.input.readTag();
        if (r4 == this.tag) goto L30;
        this.nextTag = r4;
        return;
    }

    @Override // com.google.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return this.input.shouldDiscardUnknownFields();
    }

    @Override // com.google.protobuf.Reader
    public boolean skipField() {
        if (this.input.isAtEnd() == true) goto L9;
        int r0 = this.tag;
        if (r0 != this.endGroupTag) goto L8;
        return false;
    L8:
        return this.input.skipField(r0);
    L9:
        return false;
    }
}
