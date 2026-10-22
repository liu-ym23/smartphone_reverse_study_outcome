package com.google.protobuf;

import java.util.Objects;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class ArrayDecoders {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    /* JADX INFO: renamed from: com.google.protobuf.ArrayDecoders$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r10 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r10;
            r10[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
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

    static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;
        public int recursionDepth;

        Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        Registers(ExtensionRegistryLite r10) {
            Objects.requireNonNull(r10);
            this.extensionRegistry = r10;
        }
    }

    static {
    }

    private ArrayDecoders() {
    }

    private static void checkRecursionLimit(int r10) {
        if (r10 >= recursionLimit) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0029 -> B:4:0x0010). Please report as a decompilation issue!!! */
    static int decodeBoolList(int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        BooleanArrayList r16 = (BooleanArrayList) r14;
        int r17 = decodeVarint64(r11, r12, r15);
        if (r15.long1 == 0) goto L5;
    L4:
        boolean r18 = true;
    L6:
        r16.addBoolean(r18);
        if (r17 >= r13) goto L14;
        int r19 = decodeVarint32(r11, r17, r15);
        if (r10 != r15.int1) goto L14;
        r17 = decodeVarint64(r11, r19, r15);
        if (r15.long1 != 0) goto L4;
    L5:
        r18 = false;
    L14:
        return r17;
    L15:
        r18 = false;
        goto L6
    }

    static int decodeBytes(byte[] r10, int r11, Registers r12) {
        int r13 = decodeVarint32(r10, r11, r12);
        int r14 = r12.int1;
        if (r14 < 0) goto L14;
        if (r14 > (r10.length - r13)) goto L12;
        if (r14 != 0) goto L9;
        r12.object1 = ByteString.EMPTY;
        return r13;
    L9:
        r12.object1 = ByteString.copyFrom(r10, r13, r14);
        return r13 + r14;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    L14:
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0033 -> B:7:0x000e). Please report as a decompilation issue!!! */
    static int decodeBytesList(int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        int r16 = decodeVarint32(r11, r12, r15);
        int r17 = r15.int1;
        if (r17 < 0) goto L27;
        if (r17 > (r11.length - r16)) goto L25;
        if (r17 != 0) goto L8;
    L7:
        r14.add(ByteString.EMPTY);
    L9:
        if (r16 >= r13) goto L23;
        int r18 = decodeVarint32(r11, r16, r15);
        if (r10 != r15.int1) goto L23;
        r16 = decodeVarint32(r11, r18, r15);
        int r19 = r15.int1;
        if (r19 < 0) goto L22;
        if (r19 > (r11.length - r16)) goto L20;
        if (r19 == 0) goto L7;
    L8:
        r14.add(ByteString.copyFrom(r11, r16, r19));
        r16 = r16 + r19;
        goto L9
    L20:
        throw InvalidProtocolBufferException.truncatedMessage();
    L22:
        throw InvalidProtocolBufferException.negativeSize();
    L23:
        return r16;
    L28:
        r14.add(ByteString.copyFrom(r11, r16, r17));
        r16 = r16 + r17;
        goto L9
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static double decodeDouble(byte[] r10, int r11) {
        return Double.longBitsToDouble(decodeFixed64(r10, r11));
    }

    static int decodeDoubleList(int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        DoubleArrayList r16 = (DoubleArrayList) r14;
        r16.addDouble(decodeDouble(r11, r12));
        int r17 = r12 + 8;
    L3:
        if (r17 >= r13) goto L8;
        int r18 = decodeVarint32(r11, r17, r15);
        if (r10 != r15.int1) goto L8;
        r16.addDouble(decodeDouble(r11, r18));
        r17 = r18 + 8;
    L8:
        return r17;
    }

    static int decodeExtension(int r10, byte[] r11, int r12, int r13, GeneratedMessageLite.ExtendableMessage<?, ?> r14, GeneratedMessageLite.GeneratedExtension<?, ?> r15, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> r16, Registers r17) {
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> r18 = r14.extensions;
        int r19 = r10 >>> 3;
        if (r15.descriptor.isRepeated() == true) goto L5;
    L21:
        Object r20 = null;
        if (r15.getLiteType() != WireFormat.FieldType.ENUM) goto L28;
        r12 = decodeVarint32(r11, r12, r17);
        if (r15.descriptor.getEnumType().findValueByNumber(r17.int1) != null) goto L61;
        SchemaUtil.storeUnknownEnum(r14, r19, r17.int1, null, r16);
        return r12;
    L61:
        int r21 = r17.int1;
    L62:
        r20 = Integer.valueOf(r21);
    L70:
        if (r15.isRepeated() == false) goto L72;
        r18.addRepeatedField(r15.descriptor, r20);
    L74:
        return r12;
    L72:
        r18.setField(r15.descriptor, r20);
        goto L74
    L28:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r15.getLiteType().ordinal()]) {
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
        Schema r22 = Protobuf.getInstance().schemaFor(r15.getMessageDefaultInstance().getClass());
        if (r15.isRepeated() == false) goto L33;
        int r23 = decodeMessageField(r22, r11, r12, r13, r17);
        r18.addRepeatedField(r15.descriptor, r17.object1);
        return r23;
    L33:
        Object r24 = r18.getField(r15.descriptor);
        if (r24 != null) goto L37;
        r24 = r22.newInstance();
        r18.setField(r15.descriptor, r24);
    L37:
        return mergeMessageField(r24, r22, r11, r12, r13, r17);
    L38:
        int r25 = (r19 << 3) | 4;
        Schema r26 = Protobuf.getInstance().schemaFor(r15.getMessageDefaultInstance().getClass());
        if (r15.isRepeated() == false) goto L41;
        int r27 = decodeGroupField(r26, r11, r12, r13, r25, r17);
        r18.addRepeatedField(r15.descriptor, r17.object1);
        return r27;
    L41:
        Object r28 = r18.getField(r15.descriptor);
        if (r28 != null) goto L45;
        r28 = r26.newInstance();
        r18.setField(r15.descriptor, r28);
    L45:
        return mergeGroupField(r28, r26, r11, r12, r13, r25, r17);
    L46:
        r12 = decodeString(r11, r12, r17);
    L48:
        r20 = r17.object1;
        goto L70
    L47:
        r12 = decodeBytes(r11, r12, r17);
        goto L48
    L51:
        r12 = decodeVarint64(r11, r12, r17);
        long r29 = CodedInputStream.decodeZigZag64(r17.long1);
    L64:
        r20 = Long.valueOf(r29);
        goto L70
    L52:
        r12 = decodeVarint32(r11, r12, r17);
        r21 = CodedInputStream.decodeZigZag32(r17.int1);
        goto L62
    L53:
        r12 = decodeVarint64(r11, r12, r17);
        if (r17.long1 == 0) goto L56;
        boolean r30 = true;
    L57:
        r20 = Boolean.valueOf(r30);
        goto L70
    L56:
        r30 = false;
        goto L57
    L58:
        r20 = Integer.valueOf(decodeFixed32(r11, r12));
    L66:
        r12 = r12 + 4;
        goto L70
    L59:
        r20 = Long.valueOf(decodeFixed64(r11, r12));
    L68:
        r12 = r12 + 8;
        goto L70
    L60:
        r12 = decodeVarint32(r11, r12, r17);
        goto L61
    L63:
        r12 = decodeVarint64(r11, r12, r17);
        r29 = r17.long1;
        goto L64
    L65:
        r20 = Float.valueOf(decodeFloat(r11, r12));
        goto L66
    L67:
        r20 = Double.valueOf(decodeDouble(r11, r12));
        goto L68
    L50:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (r15.descriptor.isPacked() == false) goto L21;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r15.getLiteType().ordinal()]) {
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
        Internal.ProtobufList r31 = new IntArrayList();
        int r32 = decodePackedVarint32List(r11, r12, r31, r17);
        SchemaUtil.filterUnknownEnumList(r14, r19, r31, r15.descriptor.getEnumType(), null, r16);
    L20:
        r18.setField(r15.descriptor, r31);
        return r32;
    L11:
        r31 = new LongArrayList();
        r32 = decodePackedSInt64List(r11, r12, r31, r17);
        goto L20
    L12:
        r31 = new IntArrayList();
        r32 = decodePackedSInt32List(r11, r12, r31, r17);
        goto L20
    L13:
        r31 = new BooleanArrayList();
        r32 = decodePackedBoolList(r11, r12, r31, r17);
        goto L20
    L14:
        r31 = new IntArrayList();
        r32 = decodePackedFixed32List(r11, r12, r31, r17);
        goto L20
    L15:
        r31 = new LongArrayList();
        r32 = decodePackedFixed64List(r11, r12, r31, r17);
        goto L20
    L16:
        r31 = new IntArrayList();
        r32 = decodePackedVarint32List(r11, r12, r31, r17);
        goto L20
    L17:
        r31 = new LongArrayList();
        r32 = decodePackedVarint64List(r11, r12, r31, r17);
        goto L20
    L18:
        r31 = new FloatArrayList();
        r32 = decodePackedFloatList(r11, r12, r31, r17);
        goto L20
    L19:
        r31 = new DoubleArrayList();
        r32 = decodePackedDoubleList(r11, r12, r31, r17);
        goto L20
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r15.descriptor.getLiteType());
    }

    static int decodeExtensionOrUnknownField(int r10, byte[] r11, int r12, int r13, Object r14, MessageLite r15, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> r16, Registers r17) {
        ExtensionRegistryLite r18 = r17.extensionRegistry;
        GeneratedMessageLite.GeneratedExtension r19 = r18.findLiteExtensionByNumber(r15, r10 >>> 3);
        if (r19 == null) goto L5;
        GeneratedMessageLite.ExtendableMessage r20 = (GeneratedMessageLite.ExtendableMessage) r14;
        r20.ensureExtensionsAreMutable();
        return decodeExtension(r10, r11, r12, r13, r20, r19, r16, r17);
    L5:
        return decodeUnknownField(r10, r11, r12, r13, MessageSchema.getMutableUnknownFields(r14), r17);
    }

    static int decodeFixed32(byte[] r10, int r11) {
        int r12 = ((r10[r11] & 255) | ((r10[r11 + 1] & 255) << 8)) | ((r10[r11 + 2] & 255) << 16);
        return ((r10[r11 + 3] & 255) << 24) | r12;
    }

    static int decodeFixed32List(int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        IntArrayList r16 = (IntArrayList) r14;
        r16.addInt(decodeFixed32(r11, r12));
        int r17 = r12 + 4;
    L3:
        if (r17 >= r13) goto L8;
        int r18 = decodeVarint32(r11, r17, r15);
        if (r10 != r15.int1) goto L8;
        r16.addInt(decodeFixed32(r11, r18));
        r17 = r18 + 4;
    L8:
        return r17;
    }

    static long decodeFixed64(byte[] r10, int r11) {
        long r12 = ((((((((long) r10[r11]) & 255) | ((((long) r10[r11 + 1]) & 255) << 8)) | ((((long) r10[r11 + 2]) & 255) << 16)) | ((((long) r10[r11 + 3]) & 255) << 24)) | ((((long) r10[r11 + 4]) & 255) << 32)) | ((((long) r10[r11 + 5]) & 255) << 40)) | ((((long) r10[r11 + 6]) & 255) << 48);
        return ((((long) r10[r11 + 7]) & 255) << 56) | r12;
    }

    static int decodeFixed64List(int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        LongArrayList r16 = (LongArrayList) r14;
        r16.addLong(decodeFixed64(r11, r12));
        int r17 = r12 + 8;
    L3:
        if (r17 >= r13) goto L8;
        int r18 = decodeVarint32(r11, r17, r15);
        if (r10 != r15.int1) goto L8;
        r16.addLong(decodeFixed64(r11, r18));
        r17 = r18 + 8;
    L8:
        return r17;
    }

    static float decodeFloat(byte[] r10, int r11) {
        return Float.intBitsToFloat(decodeFixed32(r10, r11));
    }

    static int decodeFloatList(int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        FloatArrayList r16 = (FloatArrayList) r14;
        r16.addFloat(decodeFloat(r11, r12));
        int r17 = r12 + 4;
    L3:
        if (r17 >= r13) goto L8;
        int r18 = decodeVarint32(r11, r17, r15);
        if (r10 != r15.int1) goto L8;
        r16.addFloat(decodeFloat(r11, r18));
        r17 = r18 + 4;
    L8:
        return r17;
    }

    static <T> int decodeGroupField(Schema<T> r10, byte[] r11, int r12, int r13, int r14, Registers r15) {
        T r16 = r10.newInstance();
        int r17 = mergeGroupField(r16, r10, r11, r12, r13, r14, r15);
        r10.makeImmutable(r16);
        r15.object1 = r16;
        return r17;
    }

    static int decodeGroupList(Schema<?> r10, int r11, byte[] r12, int r13, int r14, Internal.ProtobufList<Object> r15, Registers r16) {
        int r17 = (r11 & (-8)) | 4;
        int r18 = decodeGroupField(r10, r12, r13, r14, r17, r16);
    L3:
        r15.add(r16.object1);
        if (r18 >= r14) goto L9;
        int r19 = decodeVarint32(r12, r18, r16);
        if (r11 != r16.int1) goto L9;
        r18 = decodeGroupField(r10, r12, r19, r14, r17, r16);
    L9:
        return r18;
    }

    static <T> int decodeMessageField(Schema<T> r10, byte[] r11, int r12, int r13, Registers r14) {
        T r15 = r10.newInstance();
        int r16 = mergeMessageField(r15, r10, r11, r12, r13, r14);
        r10.makeImmutable(r15);
        r14.object1 = r15;
        return r16;
    }

    static int decodeMessageList(Schema<?> r10, int r11, byte[] r12, int r13, int r14, Internal.ProtobufList<?> r15, Registers r16) {
        int r17 = decodeMessageField(r10, r12, r13, r14, r16);
    L3:
        r15.add(r16.object1);
        if (r17 >= r14) goto L9;
        int r18 = decodeVarint32(r12, r17, r16);
        if (r11 != r16.int1) goto L9;
        r17 = decodeMessageField(r10, r12, r18, r14, r16);
    L9:
        return r17;
    }

    static int decodePackedBoolList(byte[] r10, int r11, Internal.ProtobufList<?> r12, Registers r13) {
        BooleanArrayList r14 = (BooleanArrayList) r12;
        int r15 = decodeVarint32(r10, r11, r13);
        int r16 = r13.int1 + r15;
    L3:
        if (r15 >= r16) goto L9;
        r15 = decodeVarint64(r10, r15, r13);
        if (r13.long1 == 0) goto L7;
        boolean r17 = true;
    L8:
        r14.addBoolean(r17);
        goto L3
    L7:
        r17 = false;
        goto L8
    L9:
        if (r15 != r16) goto L12;
        return r15;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedDoubleList(byte[] r10, int r11, Internal.ProtobufList<?> r12, Registers r13) {
        DoubleArrayList r14 = (DoubleArrayList) r12;
        int r15 = decodeVarint32(r10, r11, r13);
        int r16 = r13.int1;
        int r17 = r15 + r16;
        if (r17 > r10.length) goto L12;
        r14.ensureCapacity(r14.size() + (r16 / 8));
    L5:
        if (r15 >= r17) goto L7;
        r14.addDouble(decodeDouble(r10, r15));
        r15 = r15 + 8;
        goto L5
    L7:
        if (r15 != r17) goto L10;
        return r15;
    L10:
        throw InvalidProtocolBufferException.truncatedMessage();
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed32List(byte[] r10, int r11, Internal.ProtobufList<?> r12, Registers r13) {
        IntArrayList r14 = (IntArrayList) r12;
        int r15 = decodeVarint32(r10, r11, r13);
        int r16 = r13.int1;
        int r17 = r15 + r16;
        if (r17 > r10.length) goto L12;
        r14.ensureCapacity(r14.size() + (r16 / 4));
    L5:
        if (r15 >= r17) goto L7;
        r14.addInt(decodeFixed32(r10, r15));
        r15 = r15 + 4;
        goto L5
    L7:
        if (r15 != r17) goto L10;
        return r15;
    L10:
        throw InvalidProtocolBufferException.truncatedMessage();
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed64List(byte[] r10, int r11, Internal.ProtobufList<?> r12, Registers r13) {
        LongArrayList r14 = (LongArrayList) r12;
        int r15 = decodeVarint32(r10, r11, r13);
        int r16 = r13.int1;
        int r17 = r15 + r16;
        if (r17 > r10.length) goto L12;
        r14.ensureCapacity(r14.size() + (r16 / 8));
    L5:
        if (r15 >= r17) goto L7;
        r14.addLong(decodeFixed64(r10, r15));
        r15 = r15 + 8;
        goto L5
    L7:
        if (r15 != r17) goto L10;
        return r15;
    L10:
        throw InvalidProtocolBufferException.truncatedMessage();
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFloatList(byte[] r10, int r11, Internal.ProtobufList<?> r12, Registers r13) {
        FloatArrayList r14 = (FloatArrayList) r12;
        int r15 = decodeVarint32(r10, r11, r13);
        int r16 = r13.int1;
        int r17 = r15 + r16;
        if (r17 > r10.length) goto L12;
        r14.ensureCapacity(r14.size() + (r16 / 4));
    L5:
        if (r15 >= r17) goto L7;
        r14.addFloat(decodeFloat(r10, r15));
        r15 = r15 + 4;
        goto L5
    L7:
        if (r15 != r17) goto L10;
        return r15;
    L10:
        throw InvalidProtocolBufferException.truncatedMessage();
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt32List(byte[] r10, int r11, Internal.ProtobufList<?> r12, Registers r13) {
        IntArrayList r14 = (IntArrayList) r12;
        int r15 = decodeVarint32(r10, r11, r13);
        int r16 = r13.int1 + r15;
    L3:
        if (r15 >= r16) goto L5;
        r15 = decodeVarint32(r10, r15, r13);
        r14.addInt(CodedInputStream.decodeZigZag32(r13.int1));
        goto L3
    L5:
        if (r15 != r16) goto L8;
        return r15;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt64List(byte[] r10, int r11, Internal.ProtobufList<?> r12, Registers r13) {
        LongArrayList r14 = (LongArrayList) r12;
        int r15 = decodeVarint32(r10, r11, r13);
        int r16 = r13.int1 + r15;
    L3:
        if (r15 >= r16) goto L5;
        r15 = decodeVarint64(r10, r15, r13);
        r14.addLong(CodedInputStream.decodeZigZag64(r13.long1));
        goto L3
    L5:
        if (r15 != r16) goto L8;
        return r15;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedVarint32List(byte[] r10, int r11, Internal.ProtobufList<?> r12, Registers r13) {
        IntArrayList r14 = (IntArrayList) r12;
        int r15 = decodeVarint32(r10, r11, r13);
        int r16 = r13.int1 + r15;
    L3:
        if (r15 >= r16) goto L5;
        r15 = decodeVarint32(r10, r15, r13);
        r14.addInt(r13.int1);
        goto L3
    L5:
        if (r15 != r16) goto L8;
        return r15;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedVarint64List(byte[] r10, int r11, Internal.ProtobufList<?> r12, Registers r13) {
        LongArrayList r14 = (LongArrayList) r12;
        int r15 = decodeVarint32(r10, r11, r13);
        int r16 = r13.int1 + r15;
    L3:
        if (r15 >= r16) goto L5;
        r15 = decodeVarint64(r10, r15, r13);
        r14.addLong(r13.long1);
        goto L3
    L5:
        if (r15 != r16) goto L8;
        return r15;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodeSInt32List(int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        IntArrayList r16 = (IntArrayList) r14;
        int r17 = decodeVarint32(r11, r12, r15);
    L3:
        r16.addInt(CodedInputStream.decodeZigZag32(r15.int1));
        if (r17 >= r13) goto L9;
        int r18 = decodeVarint32(r11, r17, r15);
        if (r10 != r15.int1) goto L9;
        r17 = decodeVarint32(r11, r18, r15);
    L9:
        return r17;
    }

    static int decodeSInt64List(int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        LongArrayList r16 = (LongArrayList) r14;
        int r17 = decodeVarint64(r11, r12, r15);
    L3:
        r16.addLong(CodedInputStream.decodeZigZag64(r15.long1));
        if (r17 >= r13) goto L9;
        int r18 = decodeVarint32(r11, r17, r15);
        if (r10 != r15.int1) goto L9;
        r17 = decodeVarint64(r11, r18, r15);
    L9:
        return r17;
    }

    static int decodeString(byte[] r10, int r11, Registers r12) {
        int r13 = decodeVarint32(r10, r11, r12);
        int r14 = r12.int1;
        if (r14 < 0) goto L10;
        if (r14 != 0) goto L7;
        r12.object1 = "";
        return r13;
    L7:
        r12.object1 = new String(r10, r13, r14, Internal.UTF_8);
        return r13 + r14;
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002e -> B:6:0x000c). Please report as a decompilation issue!!! */
    static int decodeStringList(int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        int r16 = decodeVarint32(r11, r12, r15);
        int r17 = r15.int1;
        if (r17 < 0) goto L22;
        if (r17 != 0) goto L23;
    L6:
        r14.add("");
    L9:
        if (r16 >= r13) goto L20;
        int r18 = decodeVarint32(r11, r16, r15);
        if (r10 != r15.int1) goto L20;
        r16 = decodeVarint32(r11, r18, r15);
        int r19 = r15.int1;
        if (r19 < 0) goto L19;
        if (r19 == 0) goto L6;
        r14.add(new String(r11, r16, r19, Internal.UTF_8));
        r16 = r16 + r19;
        goto L9
    L19:
        throw InvalidProtocolBufferException.negativeSize();
    L20:
        return r16;
    L23:
        r14.add(new String(r11, r16, r17, Internal.UTF_8));
        r16 = r16 + r17;
        goto L9
    L22:
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0036 -> B:6:0x000c). Please report as a decompilation issue!!! */
    static int decodeStringListRequireUtf8(int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        int r16 = decodeVarint32(r11, r12, r15);
        int r17 = r15.int1;
        if (r17 < 0) goto L30;
        if (r17 != 0) goto L7;
    L6:
        r14.add("");
    L11:
        if (r16 >= r13) goto L26;
        int r18 = decodeVarint32(r11, r16, r15);
        if (r10 != r15.int1) goto L26;
        r16 = decodeVarint32(r11, r18, r15);
        int r19 = r15.int1;
        if (r19 < 0) goto L25;
        if (r19 == 0) goto L6;
        int r20 = r16 + r19;
        if (Utf8.isValidUtf8(r11, r16, r20) == false) goto L23;
        r14.add(new String(r11, r16, r19, Internal.UTF_8));
        r16 = r20;
        goto L11
    L23:
        throw InvalidProtocolBufferException.invalidUtf8();
    L25:
        throw InvalidProtocolBufferException.negativeSize();
    L26:
        return r16;
    L7:
        int r21 = r16 + r17;
        if (Utf8.isValidUtf8(r11, r16, r21) == false) goto L28;
        r14.add(new String(r11, r16, r17, Internal.UTF_8));
        r16 = r21;
        goto L11
    L28:
        throw InvalidProtocolBufferException.invalidUtf8();
    L30:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeStringRequireUtf8(byte[] r10, int r11, Registers r12) {
        int r13 = decodeVarint32(r10, r11, r12);
        int r14 = r12.int1;
        if (r14 < 0) goto L10;
        if (r14 != 0) goto L7;
        r12.object1 = "";
        return r13;
    L7:
        r12.object1 = Utf8.decodeUtf8(r10, r13, r14);
        return r13 + r14;
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeUnknownField(int r10, byte[] r11, int r12, int r13, UnknownFieldSetLite r14, Registers r15) {
        if (WireFormat.getTagFieldNumber(r10) == 0) goto L49;
        int r16 = WireFormat.getTagWireType(r10);
        if (r16 != 0) goto L7;
        int r17 = decodeVarint64(r11, r12, r15);
        r14.storeField(r10, Long.valueOf(r15.long1));
        return r17;
    L7:
        if (r16 != 1) goto L9;
        r14.storeField(r10, Long.valueOf(decodeFixed64(r11, r12)));
        return r12 + 8;
    L9:
        if (r16 != 2) goto L11;
        int r18 = decodeVarint32(r11, r12, r15);
        int r19 = r15.int1;
        if (r19 < 0) goto L43;
        if (r19 > (r11.length - r18)) goto L41;
        if (r19 != 0) goto L37;
        Object r110 = ByteString.EMPTY;
    L38:
        r14.storeField(r10, r110);
        return r18 + r19;
    L37:
        r110 = ByteString.copyFrom(r11, r18, r19);
        goto L38
    L41:
        throw InvalidProtocolBufferException.truncatedMessage();
    L43:
        throw InvalidProtocolBufferException.negativeSize();
    L11:
        if (r16 != 3) goto L13;
        UnknownFieldSetLite r20 = UnknownFieldSetLite.newInstance();
        int r21 = (r10 & (-8)) | 4;
        int r22 = 0;
        int r23 = r15.recursionDepth + 1;
        r15.recursionDepth = r23;
        checkRecursionLimit(r23);
    L19:
        if (r12 >= r13) goto L24;
        int r24 = decodeVarint32(r11, r12, r15);
        int r111 = r15.int1;
        r22 = r111;
        if (r111 == r21) goto L22;
        int r25 = decodeUnknownField(r22, r11, r24, r13, r20, r15);
        r22 = r111;
        r12 = r25;
        goto L19
    L22:
        r12 = r24;
    L24:
        r15.recursionDepth--;
        if (r12 > r13) goto L30;
        if (r22 != r21) goto L30;
        r14.storeField(r10, r20);
        return r12;
    L30:
        throw InvalidProtocolBufferException.parseFailure();
    L13:
        if (r16 != 5) goto L17;
        r14.storeField(r10, Integer.valueOf(decodeFixed32(r11, r12)));
        return r12 + 4;
    L17:
        throw InvalidProtocolBufferException.invalidTag();
    L49:
        throw InvalidProtocolBufferException.invalidTag();
    }

    static int decodeVarint32(int r10, byte[] r11, int r12, Registers r13) {
        int r14 = r10 & 127;
        int r15 = r12 + 1;
        byte r16 = r11[r12];
        if (r16 < 0) goto L7;
        int r17 = r16 << 7;
    L5:
        r13.int1 = r14 | r17;
        return r15;
    L7:
        int r18 = r14 | ((r16 & ByteCompanionObject.MAX_VALUE) << 7);
        int r19 = r15 + 1;
        byte r20 = r11[r15];
        if (r20 < 0) goto L12;
        int r21 = r20 << 14;
    L10:
        r13.int1 = r18 | r21;
        return r19;
    L12:
        r14 = r18 | ((r20 & ByteCompanionObject.MAX_VALUE) << 14);
        r15 = r19 + 1;
        byte r22 = r11[r19];
        if (r22 < 0) goto L15;
        r17 = r22 << 21;
        goto L5
    L15:
        r18 = r14 | ((r22 & ByteCompanionObject.MAX_VALUE) << 21);
        r19 = r15 + 1;
        byte r23 = r11[r15];
        if (r23 < 0) goto L18;
        r21 = r23 << 28;
        goto L10
    L18:
        int r24 = r18 | ((r23 & ByteCompanionObject.MAX_VALUE) << 28);
    L19:
        int r25 = r19 + 1;
        if (r11[r19] >= 0) goto L22;
        r19 = r25;
        goto L19
    L22:
        r13.int1 = r24;
        return r25;
    }

    static int decodeVarint32(byte[] r10, int r11, Registers r12) {
        int r13 = r11 + 1;
        byte r14 = r10[r11];
        if (r14 < 0) goto L7;
        r12.int1 = r14;
        return r13;
    L7:
        return decodeVarint32(r14, r10, r13, r12);
    }

    static int decodeVarint32List(int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        IntArrayList r16 = (IntArrayList) r14;
        int r17 = decodeVarint32(r11, r12, r15);
    L3:
        r16.addInt(r15.int1);
        if (r17 >= r13) goto L9;
        int r18 = decodeVarint32(r11, r17, r15);
        if (r10 != r15.int1) goto L9;
        r17 = decodeVarint32(r11, r18, r15);
    L9:
        return r17;
    }

    static int decodeVarint64(long r10, byte[] r11, int r12, Registers r13) {
        int r14 = r12 + 1;
        byte r15 = r11[r12];
        long r16 = (r10 & 127) | (((long) (r15 & ByteCompanionObject.MAX_VALUE)) << 7);
        int r17 = 7;
    L3:
        if (r15 >= 0) goto L5;
        int r18 = r14 + 1;
        byte r19 = r11[r14];
        r17 = r17 + 7;
        r16 = r16 | (((long) (r19 & ByteCompanionObject.MAX_VALUE)) << r17);
        r14 = r18;
        r15 = r19;
        goto L3
    L5:
        r13.long1 = r16;
        return r14;
    }

    static int decodeVarint64(byte[] r10, int r11, Registers r12) {
        int r13 = r11 + 1;
        long r14 = r10[r11];
        if (r14 < 0) goto L7;
        r12.long1 = r14;
        return r13;
    L7:
        return decodeVarint64(r14, r10, r13, r12);
    }

    static int decodeVarint64List(int r10, byte[] r11, int r12, int r13, Internal.ProtobufList<?> r14, Registers r15) {
        LongArrayList r16 = (LongArrayList) r14;
        int r17 = decodeVarint64(r11, r12, r15);
    L3:
        r16.addLong(r15.long1);
        if (r17 >= r13) goto L9;
        int r18 = decodeVarint32(r11, r17, r15);
        if (r10 != r15.int1) goto L9;
        r17 = decodeVarint64(r11, r18, r15);
    L9:
        return r17;
    }

    static <T> int mergeGroupField(Object r10, Schema<T> r11, byte[] r12, int r13, int r14, int r15, Registers r16) {
        MessageSchema r17 = (MessageSchema) r11;
        int r18 = r16.recursionDepth + 1;
        r16.recursionDepth = r18;
        checkRecursionLimit(r18);
        int r19 = r17.parseMessage(r10, r12, r13, r14, r15, r16);
        r16.recursionDepth--;
        r16.object1 = r10;
        return r19;
    }

    static <T> int mergeMessageField(Object r10, Schema<T> r11, byte[] r12, int r13, int r14, Registers r15) {
        int r16 = r13 + 1;
        int r17 = r12[r13];
        if (r17 >= 0) goto L5;
        r16 = decodeVarint32(r17, r12, r16, r15);
        r17 = r15.int1;
    L5:
        int r18 = r16;
        if (r17 < 0) goto L12;
        if (r17 > (r14 - r18)) goto L12;
        int r19 = r15.recursionDepth + 1;
        r15.recursionDepth = r19;
        checkRecursionLimit(r19);
        int r20 = r17 + r18;
        r11.mergeFrom(r10, r12, r18, r20, r15);
        r15.recursionDepth--;
        r15.object1 = r10;
        return r20;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static void setRecursionLimit(int r10) {
        recursionLimit = r10;
    }

    static int skipField(int r10, byte[] r11, int r12, int r13, Registers r14) {
        if (WireFormat.getTagFieldNumber(r10) == 0) goto L36;
        int r15 = WireFormat.getTagWireType(r10);
        if (r15 == 0) goto L34;
        if (r15 == 1) goto L32;
        if (r15 == 2) goto L30;
        if (r15 != 3) goto L13;
        int r16 = (r10 & (-8)) | 4;
        int r17 = 0;
    L19:
        if (r12 >= r13) goto L24;
        r12 = decodeVarint32(r11, r12, r14);
        r17 = r14.int1;
        if (r17 == r16) goto L24;
        r12 = skipField(r17, r11, r12, r13, r14);
    L24:
        if (r12 > r13) goto L28;
        if (r17 != r16) goto L28;
        return r12;
    L28:
        throw InvalidProtocolBufferException.parseFailure();
    L13:
        if (r15 != 5) goto L17;
        return r12 + 4;
    L17:
        throw InvalidProtocolBufferException.invalidTag();
    L30:
        return decodeVarint32(r11, r12, r14) + r14.int1;
    L32:
        return r12 + 8;
    L34:
        return decodeVarint64(r11, r12, r14);
    L36:
        throw InvalidProtocolBufferException.invalidTag();
    }
}
