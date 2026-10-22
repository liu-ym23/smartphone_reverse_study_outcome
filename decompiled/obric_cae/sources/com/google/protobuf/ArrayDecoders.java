package com.google.protobuf;

import com.qualcomm.qti.qesdk.QesdkUtils;
import com.sdk.bwdl.StateMachine.BWDLCommandBuilder;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class ArrayDecoders {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    /* JADX INFO: renamed from: com.google.protobuf.ArrayDecoders$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r8 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r8;
            r8[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    public static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;
        public int recursionDepth;

        public Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        public Registers(ExtensionRegistryLite r8) {
            if (r8 == null) goto L7;
            this.extensionRegistry = r8;
            return;
        L7:
            throw null;
        }
    }

    private ArrayDecoders() {
    }

    private static void checkRecursionLimit(int r8) {
        if (r8 >= recursionLimit) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0029 -> B:4:0x0010). Please report as a decompilation issue!!! */
    public static int decodeBoolList(int r8, byte[] r10, int r11, int r12, Internal.ProtobufList<?> r13, Registers r14) {
        BooleanArrayList r15 = (BooleanArrayList) r13;
        int r16 = decodeVarint64(r10, r11, r14);
        if (r14.long1 == 0) goto L5;
    L4:
        boolean r17 = true;
    L6:
        r15.addBoolean(r17);
        if (r16 >= r12) goto L14;
        int r18 = decodeVarint32(r10, r16, r14);
        if (r8 != r14.int1) goto L14;
        r16 = decodeVarint64(r10, r18, r14);
        if (r14.long1 != 0) goto L4;
    L5:
        r17 = false;
    L14:
        return r16;
    L15:
        r17 = false;
        goto L6
    }

    public static int decodeBytes(byte[] r8, int r10, Registers r11) {
        int r12 = decodeVarint32(r8, r10, r11);
        int r13 = r11.int1;
        if (r13 < 0) goto L14;
        if (r13 > (r8.length - r12)) goto L12;
        if (r13 != 0) goto L9;
        r11.object1 = ByteString.EMPTY;
        return r12;
    L9:
        r11.object1 = ByteString.copyFrom(r8, r12, r13);
        return r12 + r13;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    L14:
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0033 -> B:7:0x000e). Please report as a decompilation issue!!! */
    public static int decodeBytesList(int r8, byte[] r10, int r11, int r12, Internal.ProtobufList<?> r13, Registers r14) {
        int r15 = decodeVarint32(r10, r11, r14);
        int r16 = r14.int1;
        if (r16 < 0) goto L27;
        if (r16 > (r10.length - r15)) goto L25;
        if (r16 != 0) goto L8;
    L7:
        r13.add(ByteString.EMPTY);
    L9:
        if (r15 >= r12) goto L23;
        int r17 = decodeVarint32(r10, r15, r14);
        if (r8 != r14.int1) goto L23;
        r15 = decodeVarint32(r10, r17, r14);
        int r18 = r14.int1;
        if (r18 < 0) goto L22;
        if (r18 > (r10.length - r15)) goto L20;
        if (r18 == 0) goto L7;
    L8:
        r13.add(ByteString.copyFrom(r10, r15, r18));
        r15 = r15 + r18;
        goto L9
    L20:
        throw InvalidProtocolBufferException.truncatedMessage();
    L22:
        throw InvalidProtocolBufferException.negativeSize();
    L23:
        return r15;
    L28:
        r13.add(ByteString.copyFrom(r10, r15, r16));
        r15 = r15 + r16;
        goto L9
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.negativeSize();
    }

    public static double decodeDouble(byte[] r8, int r10) {
        return Double.longBitsToDouble(decodeFixed64(r8, r10));
    }

    public static int decodeDoubleList(int r8, byte[] r10, int r11, int r12, Internal.ProtobufList<?> r13, Registers r14) {
        DoubleArrayList r15 = (DoubleArrayList) r13;
        r15.addDouble(decodeDouble(r10, r11));
        int r16 = r11 + 8;
    L3:
        if (r16 >= r12) goto L8;
        int r17 = decodeVarint32(r10, r16, r14);
        if (r8 != r14.int1) goto L8;
        r15.addDouble(decodeDouble(r10, r17));
        r16 = r17 + 8;
    L8:
        return r16;
    }

    public static int decodeExtension(int r8, byte[] r10, int r11, int r12, GeneratedMessageLite.ExtendableMessage<?, ?> r13, GeneratedMessageLite.GeneratedExtension<?, ?> r14, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> r15, Registers r16) {
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> r17 = r13.extensions;
        int r18 = r8 >>> 3;
        if (r14.descriptor.isRepeated() == true) goto L5;
    L21:
        Object r19 = null;
        if (r14.getLiteType() != WireFormat.FieldType.ENUM) goto L28;
        r11 = decodeVarint32(r10, r11, r16);
        if (r14.descriptor.getEnumType().findValueByNumber(r16.int1) != null) goto L61;
        SchemaUtil.storeUnknownEnum(r13, r18, r16.int1, null, r15);
        return r11;
    L61:
        int r20 = r16.int1;
    L62:
        r19 = Integer.valueOf(r20);
    L70:
        if (r14.isRepeated() == false) goto L72;
        r17.addRepeatedField(r14.descriptor, r19);
    L74:
        return r11;
    L72:
        r17.setField(r14.descriptor, r19);
        goto L74
    L28:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r14.getLiteType().ordinal()]) {
            case 1: goto L67;
            case 2: goto L65;
            case 3: goto L63;
            case 4: goto L63;
            case 5: goto L60;
            case 6: goto L60;
            case 7: goto L59;
            case 8: goto L59;
            case 9: goto L58;
            case 10: goto L58;
            case 11: goto L53;
            case 12: goto L52;
            case 13: goto L51;
            case 14: goto L50;
            case 15: goto L47;
            case 16: goto L46;
            case 17: goto L38;
            case 18: goto L30;
            default: goto L70;
        };
    L30:
        Schema r21 = Protobuf.getInstance().schemaFor(r14.getMessageDefaultInstance().getClass());
        if (r14.isRepeated() == false) goto L33;
        int r22 = decodeMessageField(r21, r10, r11, r12, r16);
        r17.addRepeatedField(r14.descriptor, r16.object1);
        return r22;
    L33:
        Object r23 = r17.getField(r14.descriptor);
        if (r23 != null) goto L37;
        r23 = r21.newInstance();
        r17.setField(r14.descriptor, r23);
    L37:
        return mergeMessageField(r23, r21, r10, r11, r12, r16);
    L38:
        int r24 = (r18 << 3) | 4;
        Schema r25 = Protobuf.getInstance().schemaFor(r14.getMessageDefaultInstance().getClass());
        if (r14.isRepeated() == false) goto L41;
        int r26 = decodeGroupField(r25, r10, r11, r12, r24, r16);
        r17.addRepeatedField(r14.descriptor, r16.object1);
        return r26;
    L41:
        Object r27 = r17.getField(r14.descriptor);
        if (r27 != null) goto L45;
        r27 = r25.newInstance();
        r17.setField(r14.descriptor, r27);
    L45:
        return mergeGroupField(r27, r25, r10, r11, r12, r24, r16);
    L46:
        r11 = decodeString(r10, r11, r16);
    L48:
        r19 = r16.object1;
        goto L70
    L47:
        r11 = decodeBytes(r10, r11, r16);
        goto L48
    L51:
        r11 = decodeVarint64(r10, r11, r16);
        long r28 = CodedInputStream.decodeZigZag64(r16.long1);
    L64:
        r19 = Long.valueOf(r28);
        goto L70
    L52:
        r11 = decodeVarint32(r10, r11, r16);
        r20 = CodedInputStream.decodeZigZag32(r16.int1);
        goto L62
    L53:
        r11 = decodeVarint64(r10, r11, r16);
        if (r16.long1 == 0) goto L56;
        boolean r29 = true;
    L57:
        r19 = Boolean.valueOf(r29);
        goto L70
    L56:
        r29 = false;
        goto L57
    L58:
        r19 = Integer.valueOf(decodeFixed32(r10, r11));
    L66:
        r11 = r11 + 4;
        goto L70
    L59:
        r19 = Long.valueOf(decodeFixed64(r10, r11));
    L68:
        r11 = r11 + 8;
        goto L70
    L60:
        r11 = decodeVarint32(r10, r11, r16);
        goto L61
    L63:
        r11 = decodeVarint64(r10, r11, r16);
        r28 = r16.long1;
        goto L64
    L65:
        r19 = Float.valueOf(decodeFloat(r10, r11));
        goto L66
    L67:
        r19 = Double.valueOf(decodeDouble(r10, r11));
        goto L68
    L50:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (r14.descriptor.isPacked() == false) goto L21;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r14.getLiteType().ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            default: goto L9;
        };
    L10:
        Internal.ProtobufList r30 = new IntArrayList();
        int r31 = decodePackedVarint32List(r10, r11, r30, r16);
        SchemaUtil.filterUnknownEnumList(r13, r18, r30, r14.descriptor.getEnumType(), null, r15);
    L20:
        r17.setField(r14.descriptor, r30);
        return r31;
    L11:
        r30 = new LongArrayList();
        r31 = decodePackedSInt64List(r10, r11, r30, r16);
        goto L20
    L12:
        r30 = new IntArrayList();
        r31 = decodePackedSInt32List(r10, r11, r30, r16);
        goto L20
    L13:
        r30 = new BooleanArrayList();
        r31 = decodePackedBoolList(r10, r11, r30, r16);
        goto L20
    L14:
        r30 = new IntArrayList();
        r31 = decodePackedFixed32List(r10, r11, r30, r16);
        goto L20
    L15:
        r30 = new LongArrayList();
        r31 = decodePackedFixed64List(r10, r11, r30, r16);
        goto L20
    L16:
        r30 = new IntArrayList();
        r31 = decodePackedVarint32List(r10, r11, r30, r16);
        goto L20
    L17:
        r30 = new LongArrayList();
        r31 = decodePackedVarint64List(r10, r11, r30, r16);
        goto L20
    L18:
        r30 = new FloatArrayList();
        r31 = decodePackedFloatList(r10, r11, r30, r16);
        goto L20
    L19:
        r30 = new DoubleArrayList();
        r31 = decodePackedDoubleList(r10, r11, r30, r16);
        goto L20
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r14.descriptor.getLiteType());
    }

    public static int decodeExtensionOrUnknownField(int r8, byte[] r10, int r11, int r12, Object r13, MessageLite r14, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> r15, Registers r16) {
        ExtensionRegistryLite r17 = r16.extensionRegistry;
        GeneratedMessageLite.GeneratedExtension r18 = r17.findLiteExtensionByNumber(r14, r8 >>> 3);
        if (r18 == null) goto L5;
        GeneratedMessageLite.ExtendableMessage r19 = (GeneratedMessageLite.ExtendableMessage) r13;
        r19.ensureExtensionsAreMutable();
        return decodeExtension(r8, r10, r11, r12, r19, r18, r15, r16);
    L5:
        return decodeUnknownField(r8, r10, r11, r12, MessageSchema.getMutableUnknownFields(r13), r16);
    }

    public static int decodeFixed32(byte[] r8, int r10) {
        int r11 = ((r8[r10] & 255) | ((r8[r10 + 1] & 255) << 8)) | ((r8[r10 + 2] & 255) << 16);
        return ((r8[r10 + 3] & 255) << 24) | r11;
    }

    public static int decodeFixed32List(int r8, byte[] r10, int r11, int r12, Internal.ProtobufList<?> r13, Registers r14) {
        IntArrayList r15 = (IntArrayList) r13;
        r15.addInt(decodeFixed32(r10, r11));
        int r16 = r11 + 4;
    L3:
        if (r16 >= r12) goto L8;
        int r17 = decodeVarint32(r10, r16, r14);
        if (r8 != r14.int1) goto L8;
        r15.addInt(decodeFixed32(r10, r17));
        r16 = r17 + 4;
    L8:
        return r16;
    }

    public static long decodeFixed64(byte[] r8, int r10) {
        long r11 = ((((((((long) r8[r10]) & 255) | ((((long) r8[r10 + 1]) & 255) << 8)) | ((((long) r8[r10 + 2]) & 255) << 16)) | ((((long) r8[r10 + 3]) & 255) << 24)) | ((((long) r8[r10 + 4]) & 255) << 32)) | ((((long) r8[r10 + 5]) & 255) << 40)) | ((((long) r8[r10 + 6]) & 255) << 48);
        return ((((long) r8[r10 + 7]) & 255) << 56) | r11;
    }

    public static int decodeFixed64List(int r8, byte[] r10, int r11, int r12, Internal.ProtobufList<?> r13, Registers r14) {
        LongArrayList r15 = (LongArrayList) r13;
        r15.addLong(decodeFixed64(r10, r11));
        int r16 = r11 + 8;
    L3:
        if (r16 >= r12) goto L8;
        int r17 = decodeVarint32(r10, r16, r14);
        if (r8 != r14.int1) goto L8;
        r15.addLong(decodeFixed64(r10, r17));
        r16 = r17 + 8;
    L8:
        return r16;
    }

    public static float decodeFloat(byte[] r8, int r10) {
        return Float.intBitsToFloat(decodeFixed32(r8, r10));
    }

    public static int decodeFloatList(int r8, byte[] r10, int r11, int r12, Internal.ProtobufList<?> r13, Registers r14) {
        FloatArrayList r15 = (FloatArrayList) r13;
        r15.addFloat(decodeFloat(r10, r11));
        int r16 = r11 + 4;
    L3:
        if (r16 >= r12) goto L8;
        int r17 = decodeVarint32(r10, r16, r14);
        if (r8 != r14.int1) goto L8;
        r15.addFloat(decodeFloat(r10, r17));
        r16 = r17 + 4;
    L8:
        return r16;
    }

    public static <T> int decodeGroupField(Schema<T> r8, byte[] r10, int r11, int r12, int r13, Registers r14) {
        T r15 = r8.newInstance();
        int r16 = mergeGroupField(r15, r8, r10, r11, r12, r13, r14);
        r8.makeImmutable(r15);
        r14.object1 = r15;
        return r16;
    }

    public static int decodeGroupList(Schema<?> r8, int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<Object> r14, Registers r15) {
        int r16 = (r10 & (-8)) | 4;
        int r17 = decodeGroupField(r8, r11, r12, r13, r16, r15);
    L3:
        r14.add(r15.object1);
        if (r17 >= r13) goto L9;
        int r18 = decodeVarint32(r11, r17, r15);
        if (r10 != r15.int1) goto L9;
        r17 = decodeGroupField(r8, r11, r18, r13, r16, r15);
    L9:
        return r17;
    }

    public static <T> int decodeMessageField(Schema<T> r8, byte[] r10, int r11, int r12, Registers r13) {
        T r14 = r8.newInstance();
        int r15 = mergeMessageField(r14, r8, r10, r11, r12, r13);
        r8.makeImmutable(r14);
        r13.object1 = r14;
        return r15;
    }

    public static int decodeMessageList(Schema<?> r8, int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        int r16 = decodeMessageField(r8, r11, r12, r13, r15);
    L3:
        r14.add(r15.object1);
        if (r16 >= r13) goto L9;
        int r17 = decodeVarint32(r11, r16, r15);
        if (r10 != r15.int1) goto L9;
        r16 = decodeMessageField(r8, r11, r17, r13, r15);
    L9:
        return r16;
    }

    public static int decodePackedBoolList(byte[] r8, int r10, Internal.ProtobufList<?> r11, Registers r12) {
        BooleanArrayList r13 = (BooleanArrayList) r11;
        int r14 = decodeVarint32(r8, r10, r12);
        int r15 = r12.int1 + r14;
    L3:
        if (r14 >= r15) goto L9;
        r14 = decodeVarint64(r8, r14, r12);
        if (r12.long1 == 0) goto L7;
        boolean r16 = true;
    L8:
        r13.addBoolean(r16);
        goto L3
    L7:
        r16 = false;
        goto L8
    L9:
        if (r14 != r15) goto L12;
        return r14;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedDoubleList(byte[] r8, int r10, Internal.ProtobufList<?> r11, Registers r12) {
        DoubleArrayList r13 = (DoubleArrayList) r11;
        int r14 = decodeVarint32(r8, r10, r12);
        int r15 = r12.int1;
        int r16 = r14 + r15;
        if (r16 > r8.length) goto L12;
        int r17 = r15 / 8;
        r13.ensureCapacity(r17 + r13.size());
    L5:
        if (r14 >= r16) goto L7;
        r13.addDouble(decodeDouble(r8, r14));
        r14 = r14 + 8;
        goto L5
    L7:
        if (r14 != r16) goto L10;
        return r14;
    L10:
        throw InvalidProtocolBufferException.truncatedMessage();
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed32List(byte[] r8, int r10, Internal.ProtobufList<?> r11, Registers r12) {
        IntArrayList r13 = (IntArrayList) r11;
        int r14 = decodeVarint32(r8, r10, r12);
        int r15 = r12.int1;
        int r16 = r14 + r15;
        if (r16 > r8.length) goto L12;
        int r17 = r15 / 4;
        r13.ensureCapacity(r17 + r13.size());
    L5:
        if (r14 >= r16) goto L7;
        r13.addInt(decodeFixed32(r8, r14));
        r14 = r14 + 4;
        goto L5
    L7:
        if (r14 != r16) goto L10;
        return r14;
    L10:
        throw InvalidProtocolBufferException.truncatedMessage();
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed64List(byte[] r8, int r10, Internal.ProtobufList<?> r11, Registers r12) {
        LongArrayList r13 = (LongArrayList) r11;
        int r14 = decodeVarint32(r8, r10, r12);
        int r15 = r12.int1;
        int r16 = r14 + r15;
        if (r16 > r8.length) goto L12;
        int r17 = r15 / 8;
        r13.ensureCapacity(r17 + r13.size());
    L5:
        if (r14 >= r16) goto L7;
        r13.addLong(decodeFixed64(r8, r14));
        r14 = r14 + 8;
        goto L5
    L7:
        if (r14 != r16) goto L10;
        return r14;
    L10:
        throw InvalidProtocolBufferException.truncatedMessage();
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFloatList(byte[] r8, int r10, Internal.ProtobufList<?> r11, Registers r12) {
        FloatArrayList r13 = (FloatArrayList) r11;
        int r14 = decodeVarint32(r8, r10, r12);
        int r15 = r12.int1;
        int r16 = r14 + r15;
        if (r16 > r8.length) goto L12;
        int r17 = r15 / 4;
        r13.ensureCapacity(r17 + r13.size());
    L5:
        if (r14 >= r16) goto L7;
        r13.addFloat(decodeFloat(r8, r14));
        r14 = r14 + 4;
        goto L5
    L7:
        if (r14 != r16) goto L10;
        return r14;
    L10:
        throw InvalidProtocolBufferException.truncatedMessage();
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt32List(byte[] r8, int r10, Internal.ProtobufList<?> r11, Registers r12) {
        IntArrayList r13 = (IntArrayList) r11;
        int r14 = decodeVarint32(r8, r10, r12);
        int r15 = r12.int1 + r14;
    L3:
        if (r14 >= r15) goto L5;
        r14 = decodeVarint32(r8, r14, r12);
        r13.addInt(CodedInputStream.decodeZigZag32(r12.int1));
        goto L3
    L5:
        if (r14 != r15) goto L8;
        return r14;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt64List(byte[] r8, int r10, Internal.ProtobufList<?> r11, Registers r12) {
        LongArrayList r13 = (LongArrayList) r11;
        int r14 = decodeVarint32(r8, r10, r12);
        int r15 = r12.int1 + r14;
    L3:
        if (r14 >= r15) goto L5;
        r14 = decodeVarint64(r8, r14, r12);
        r13.addLong(CodedInputStream.decodeZigZag64(r12.long1));
        goto L3
    L5:
        if (r14 != r15) goto L8;
        return r14;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint32List(byte[] r8, int r10, Internal.ProtobufList<?> r11, Registers r12) {
        IntArrayList r13 = (IntArrayList) r11;
        int r14 = decodeVarint32(r8, r10, r12);
        int r15 = r12.int1 + r14;
    L3:
        if (r14 >= r15) goto L5;
        r14 = decodeVarint32(r8, r14, r12);
        r13.addInt(r12.int1);
        goto L3
    L5:
        if (r14 != r15) goto L8;
        return r14;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint64List(byte[] r8, int r10, Internal.ProtobufList<?> r11, Registers r12) {
        LongArrayList r13 = (LongArrayList) r11;
        int r14 = decodeVarint32(r8, r10, r12);
        int r15 = r12.int1 + r14;
    L3:
        if (r14 >= r15) goto L5;
        r14 = decodeVarint64(r8, r14, r12);
        r13.addLong(r12.long1);
        goto L3
    L5:
        if (r14 != r15) goto L8;
        return r14;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodeSInt32List(int r8, byte[] r10, int r11, int r12, Internal.ProtobufList<?> r13, Registers r14) {
        IntArrayList r15 = (IntArrayList) r13;
        int r16 = decodeVarint32(r10, r11, r14);
    L3:
        r15.addInt(CodedInputStream.decodeZigZag32(r14.int1));
        if (r16 >= r12) goto L9;
        int r17 = decodeVarint32(r10, r16, r14);
        if (r8 != r14.int1) goto L9;
        r16 = decodeVarint32(r10, r17, r14);
    L9:
        return r16;
    }

    public static int decodeSInt64List(int r8, byte[] r10, int r11, int r12, Internal.ProtobufList<?> r13, Registers r14) {
        LongArrayList r15 = (LongArrayList) r13;
        int r16 = decodeVarint64(r10, r11, r14);
    L3:
        r15.addLong(CodedInputStream.decodeZigZag64(r14.long1));
        if (r16 >= r12) goto L9;
        int r17 = decodeVarint32(r10, r16, r14);
        if (r8 != r14.int1) goto L9;
        r16 = decodeVarint64(r10, r17, r14);
    L9:
        return r16;
    }

    public static int decodeString(byte[] r8, int r10, Registers r11) {
        int r12 = decodeVarint32(r8, r10, r11);
        int r13 = r11.int1;
        if (r13 < 0) goto L10;
        if (r13 != 0) goto L7;
        r11.object1 = "";
        return r12;
    L7:
        r11.object1 = new String(r8, r12, r13, Internal.UTF_8);
        return r12 + r13;
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002e -> B:6:0x000c). Please report as a decompilation issue!!! */
    public static int decodeStringList(int r8, byte[] r10, int r11, int r12, Internal.ProtobufList<?> r13, Registers r14) {
        int r15 = decodeVarint32(r10, r11, r14);
        int r16 = r14.int1;
        if (r16 < 0) goto L22;
        if (r16 != 0) goto L23;
    L6:
        r13.add("");
    L9:
        if (r15 >= r12) goto L20;
        int r17 = decodeVarint32(r10, r15, r14);
        if (r8 != r14.int1) goto L20;
        r15 = decodeVarint32(r10, r17, r14);
        int r18 = r14.int1;
        if (r18 < 0) goto L19;
        if (r18 == 0) goto L6;
        r13.add(new String(r10, r15, r18, Internal.UTF_8));
        r15 = r15 + r18;
        goto L9
    L19:
        throw InvalidProtocolBufferException.negativeSize();
    L20:
        return r15;
    L23:
        r13.add(new String(r10, r15, r16, Internal.UTF_8));
        r15 = r15 + r16;
        goto L9
    L22:
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0036 -> B:6:0x000c). Please report as a decompilation issue!!! */
    public static int decodeStringListRequireUtf8(int r8, byte[] r10, int r11, int r12, Internal.ProtobufList<?> r13, Registers r14) {
        int r15 = decodeVarint32(r10, r11, r14);
        int r16 = r14.int1;
        if (r16 < 0) goto L30;
        if (r16 != 0) goto L7;
    L6:
        r13.add("");
    L11:
        if (r15 >= r12) goto L26;
        int r17 = decodeVarint32(r10, r15, r14);
        if (r8 != r14.int1) goto L26;
        r15 = decodeVarint32(r10, r17, r14);
        int r18 = r14.int1;
        if (r18 < 0) goto L25;
        if (r18 == 0) goto L6;
        int r19 = r15 + r18;
        if (Utf8.isValidUtf8(r10, r15, r19) == false) goto L23;
        r13.add(new String(r10, r15, r18, Internal.UTF_8));
        r15 = r19;
        goto L11
    L23:
        throw InvalidProtocolBufferException.invalidUtf8();
    L25:
        throw InvalidProtocolBufferException.negativeSize();
    L26:
        return r15;
    L7:
        int r20 = r15 + r16;
        if (Utf8.isValidUtf8(r10, r15, r20) == false) goto L28;
        r13.add(new String(r10, r15, r16, Internal.UTF_8));
        r15 = r20;
        goto L11
    L28:
        throw InvalidProtocolBufferException.invalidUtf8();
    L30:
        throw InvalidProtocolBufferException.negativeSize();
    }

    public static int decodeStringRequireUtf8(byte[] r8, int r10, Registers r11) {
        int r12 = decodeVarint32(r8, r10, r11);
        int r13 = r11.int1;
        if (r13 < 0) goto L10;
        if (r13 != 0) goto L7;
        r11.object1 = "";
        return r12;
    L7:
        r11.object1 = Utf8.decodeUtf8(r8, r12, r13);
        return r12 + r13;
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    public static int decodeUnknownField(int r10, byte[] r11, int r12, int r13, UnknownFieldSetLite r14, Registers r15) {
        if (WireFormat.getTagFieldNumber(r10) == 0) goto L49;
        int r8 = WireFormat.getTagWireType(r10);
        if (r8 != 0) goto L7;
        int r16 = decodeVarint64(r11, r12, r15);
        r14.storeField(r10, Long.valueOf(r15.long1));
        return r16;
    L7:
        if (r8 != 1) goto L9;
        r14.storeField(r10, Long.valueOf(decodeFixed64(r11, r12)));
        return r12 + 8;
    L9:
        if (r8 != 2) goto L11;
        int r17 = decodeVarint32(r11, r12, r15);
        int r18 = r15.int1;
        if (r18 < 0) goto L43;
        if (r18 > (r11.length - r17)) goto L41;
        if (r18 != 0) goto L37;
        Object r19 = ByteString.EMPTY;
    L38:
        r14.storeField(r10, r19);
        return r17 + r18;
    L37:
        r19 = ByteString.copyFrom(r11, r17, r18);
        goto L38
    L41:
        throw InvalidProtocolBufferException.truncatedMessage();
    L43:
        throw InvalidProtocolBufferException.negativeSize();
    L11:
        if (r8 != 3) goto L13;
        UnknownFieldSetLite r20 = UnknownFieldSetLite.newInstance();
        int r21 = (r10 & (-8)) | 4;
        int r22 = r15.recursionDepth + 1;
        r15.recursionDepth = r22;
        checkRecursionLimit(r22);
        int r23 = 0;
    L19:
        if (r12 >= r13) goto L24;
        int r24 = decodeVarint32(r11, r12, r15);
        int r110 = r15.int1;
        r23 = r110;
        if (r110 == r21) goto L22;
        int r25 = decodeUnknownField(r23, r11, r24, r13, r20, r15);
        r23 = r110;
        r12 = r25;
        goto L19
    L22:
        r12 = r24;
    L24:
        r15.recursionDepth--;
        if (r12 > r13) goto L30;
        if (r23 != r21) goto L30;
        r14.storeField(r10, r20);
        return r12;
    L30:
        throw InvalidProtocolBufferException.parseFailure();
    L13:
        if (r8 != 5) goto L17;
        r14.storeField(r10, Integer.valueOf(decodeFixed32(r11, r12)));
        return r12 + 4;
    L17:
        throw InvalidProtocolBufferException.invalidTag();
    L49:
        throw InvalidProtocolBufferException.invalidTag();
    }

    public static int decodeVarint32(int r8, byte[] r10, int r11, Registers r12) {
        int r13 = r8 & QesdkUtils.LIMITS.INT_8_UPPER;
        int r14 = r11 + 1;
        byte r15 = r10[r11];
        if (r15 < 0) goto L7;
        int r16 = r15 << 7;
    L5:
        r12.int1 = r13 | r16;
        return r14;
    L7:
        int r17 = r13 | ((r15 & 127) << 7);
        int r18 = r14 + 1;
        byte r19 = r10[r14];
        if (r19 < 0) goto L12;
        int r20 = r19 << 14;
    L10:
        r12.int1 = r17 | r20;
        return r18;
    L12:
        r13 = r17 | ((r19 & 127) << 14);
        r14 = r18 + 1;
        byte r21 = r10[r18];
        if (r21 < 0) goto L15;
        r16 = r21 << BWDLCommandBuilder.CHANNEL_CONFIG_REQ;
        goto L5
    L15:
        r17 = r13 | ((r21 & 127) << 21);
        r18 = r14 + 1;
        byte r22 = r10[r14];
        if (r22 < 0) goto L18;
        r20 = r22 << 28;
        goto L10
    L18:
        int r23 = r17 | ((r22 & 127) << 28);
    L19:
        int r24 = r18 + 1;
        if (r10[r18] >= 0) goto L22;
        r18 = r24;
        goto L19
    L22:
        r12.int1 = r23;
        return r24;
    }

    public static int decodeVarint32List(int r8, byte[] r10, int r11, int r12, Internal.ProtobufList<?> r13, Registers r14) {
        IntArrayList r15 = (IntArrayList) r13;
        int r16 = decodeVarint32(r10, r11, r14);
    L3:
        r15.addInt(r14.int1);
        if (r16 >= r12) goto L9;
        int r17 = decodeVarint32(r10, r16, r14);
        if (r8 != r14.int1) goto L9;
        r16 = decodeVarint32(r10, r17, r14);
    L9:
        return r16;
    }

    public static int decodeVarint64(long r8, byte[] r10, int r11, Registers r12) {
        int r13 = r11 + 1;
        byte r14 = r10[r11];
        long r15 = (r8 & 127) | (((long) (r14 & 127)) << 7);
        int r16 = 7;
    L3:
        if (r14 >= 0) goto L5;
        int r17 = r13 + 1;
        byte r18 = r10[r13];
        r16 = r16 + 7;
        r15 = r15 | (((long) (r18 & 127)) << r16);
        r13 = r17;
        r14 = r18;
        goto L3
    L5:
        r12.long1 = r15;
        return r13;
    }

    public static int decodeVarint64List(int r8, byte[] r10, int r11, int r12, Internal.ProtobufList<?> r13, Registers r14) {
        LongArrayList r15 = (LongArrayList) r13;
        int r16 = decodeVarint64(r10, r11, r14);
    L3:
        r15.addLong(r14.long1);
        if (r16 >= r12) goto L9;
        int r17 = decodeVarint32(r10, r16, r14);
        if (r8 != r14.int1) goto L9;
        r16 = decodeVarint64(r10, r17, r14);
    L9:
        return r16;
    }

    public static <T> int mergeGroupField(Object r8, Schema<T> r10, byte[] r11, int r12, int r13, int r14, Registers r15) {
        MessageSchema r16 = (MessageSchema) r10;
        int r17 = r15.recursionDepth + 1;
        r15.recursionDepth = r17;
        checkRecursionLimit(r17);
        int r18 = r16.parseMessage(r8, r11, r12, r13, r14, r15);
        r15.recursionDepth--;
        r15.object1 = r8;
        return r18;
    }

    public static <T> int mergeMessageField(Object r8, Schema<T> r10, byte[] r11, int r12, int r13, Registers r14) {
        int r15 = r12 + 1;
        int r16 = r11[r12];
        if (r16 >= 0) goto L5;
        r15 = decodeVarint32(r16, r11, r15, r14);
        r16 = r14.int1;
    L5:
        int r17 = r15;
        if (r16 < 0) goto L12;
        if (r16 > (r13 - r17)) goto L12;
        int r18 = r14.recursionDepth + 1;
        r14.recursionDepth = r18;
        checkRecursionLimit(r18);
        int r19 = r16 + r17;
        r10.mergeFrom(r8, r11, r17, r19, r14);
        r14.recursionDepth--;
        r14.object1 = r8;
        return r19;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static void setRecursionLimit(int r8) {
        recursionLimit = r8;
    }

    public static int skipField(int r8, byte[] r10, int r11, int r12, Registers r13) {
        if (WireFormat.getTagFieldNumber(r8) == 0) goto L36;
        int r14 = WireFormat.getTagWireType(r8);
        if (r14 == 0) goto L34;
        if (r14 == 1) goto L32;
        if (r14 == 2) goto L30;
        if (r14 != 3) goto L13;
        int r15 = (r8 & (-8)) | 4;
        int r16 = 0;
    L19:
        if (r11 >= r12) goto L24;
        r11 = decodeVarint32(r10, r11, r13);
        r16 = r13.int1;
        if (r16 == r15) goto L24;
        r11 = skipField(r16, r10, r11, r12, r13);
    L24:
        if (r11 > r12) goto L28;
        if (r16 != r15) goto L28;
        return r11;
    L28:
        throw InvalidProtocolBufferException.parseFailure();
    L13:
        if (r14 != 5) goto L17;
        return r11 + 4;
    L17:
        throw InvalidProtocolBufferException.invalidTag();
    L30:
        return decodeVarint32(r10, r11, r13) + r13.int1;
    L32:
        return r11 + 8;
    L34:
        return decodeVarint64(r10, r11, r13);
    L36:
        throw InvalidProtocolBufferException.invalidTag();
    }

    public static int decodeVarint32(byte[] r8, int r10, Registers r11) {
        int r12 = r10 + 1;
        byte r13 = r8[r10];
        if (r13 < 0) goto L7;
        r11.int1 = r13;
        return r12;
    L7:
        return decodeVarint32(r13, r8, r12, r11);
    }

    public static int decodeVarint64(byte[] r8, int r10, Registers r11) {
        int r12 = r10 + 1;
        long r13 = r8[r10];
        if (r13 < 0) goto L7;
        r11.long1 = r13;
        return r12;
    L7:
        return decodeVarint64(r13, r8, r12, r11);
    }
}
