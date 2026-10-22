package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int[] EMPTY_INT_ARRAY = null;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final Unsafe UNSAFE = null;
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;

    /* JADX INFO: renamed from: com.google.protobuf.MessageSchema$1, reason: invalid class name */
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
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    static {
        EMPTY_INT_ARRAY = new int[0];
        UNSAFE = UnsafeUtil.getUnsafe();
    }

    private MessageSchema(int[] r8, Object[] r10, int r11, int r12, MessageLite r13, boolean r14, int[] r15, int r16, int r17, NewInstanceSchema r18, ListFieldSchema r19, UnknownFieldSchema<?, ?> r110, ExtensionSchema<?> r111, MapFieldSchema r112) {
        this.buffer = r8;
        this.objects = r10;
        this.minFieldNumber = r11;
        this.maxFieldNumber = r12;
        this.lite = r13 instanceof GeneratedMessageLite;
        if (r111 != null) goto L5;
    L7:
        boolean r20 = false;
    L8:
        this.hasExtensions = r20;
        this.useCachedSizeField = r14;
        this.intArray = r15;
        this.checkInitializedCount = r16;
        this.repeatedFieldOffsetStart = r17;
        this.newInstanceSchema = r18;
        this.listFieldSchema = r19;
        this.unknownFieldSchema = r110;
        this.extensionSchema = r111;
        this.defaultInstance = r13;
        this.mapFieldSchema = r112;
        return;
    L5:
        if (r111.hasExtensions(r13) == false) goto L7;
        r20 = true;
        goto L8
    }

    private boolean arePresentForEquals(T r8, T r10, int r11) {
        if (isFieldPresent(r8, r11) != isFieldPresent(r10, r11)) goto L5;
        return true;
    L5:
        return false;
    }

    private static <T> boolean booleanAt(T r8, long r10) {
        return UnsafeUtil.getBoolean(r8, r10);
    }

    private static void checkMutable(Object r8) {
        if (isMutable(r8) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Mutating immutable message: " + r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] r15, int r16, int r17, MapEntryLite.Metadata<K, V> r18, Map<K, V> r19, ArrayDecoders.Registers r20) {
        int r8 = ArrayDecoders.decodeVarint32(r15, r16, r20);
        int r10 = r20.int1;
        if (r10 < 0) goto L30;
        if (r10 > (r17 - r8)) goto L30;
        int r11 = r8 + r10;
        K r12 = r18.defaultKey;
        Object r13 = r12;
        Object r14 = r18.defaultValue;
    L7:
        if (r8 >= r11) goto L24;
        int r21 = r8 + 1;
        int r22 = r15[r8];
        if (r22 >= 0) goto L11;
        int r23 = ArrayDecoders.decodeVarint32(r22, r15, r21, r20);
        int r24 = r23;
        r22 = r20.int1;
    L12:
        int r25 = r22 >>> 3;
        int r26 = r22 & 7;
        if (r25 != 1) goto L15;
        if (r26 != r18.keyType.getWireType()) goto L23;
        r8 = decodeMapEntryValue(r15, r24, r17, r18.keyType, null, r20);
        r13 = r20.object1;
    L23:
        r8 = ArrayDecoders.skipField(r22, r15, r24, r17, r20);
        goto L7
    L15:
        if (r25 != 2) goto L23;
        if (r26 != r18.valueType.getWireType()) goto L23;
        r8 = decodeMapEntryValue(r15, r24, r17, r18.valueType, r18.defaultValue.getClass(), r20);
        r14 = r20.object1;
        goto L7
    L11:
        r24 = r21;
        goto L12
    L24:
        if (r8 != r11) goto L28;
        r19.put(r13, r14);
        return r11;
    L28:
        throw InvalidProtocolBufferException.parseFailure();
    L30:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private int decodeMapEntryValue(byte[] r8, int r10, int r11, WireFormat.FieldType r12, Class<?> r13, ArrayDecoders.Registers r14) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r12.ordinal()]) {
            case 1: goto L22;
            case 2: goto L32;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L12;
            case 12: goto L10;
            case 13: goto L10;
            case 14: goto L28;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L27;
            default: goto L5;
        };
    L7:
        int r15 = ArrayDecoders.decodeVarint64(r8, r10, r14);
        long r16 = CodedInputStream.decodeZigZag64(r14.long1);
    L11:
        Object r17 = Long.valueOf(r16);
    L14:
        r14.object1 = r17;
        return r15;
    L8:
        r15 = ArrayDecoders.decodeVarint32(r8, r10, r14);
        int r18 = CodedInputStream.decodeZigZag32(r14.int1);
    L13:
        r17 = Integer.valueOf(r18);
        goto L14
    L10:
        r15 = ArrayDecoders.decodeVarint64(r8, r10, r14);
        r16 = r14.long1;
        goto L11
    L12:
        r15 = ArrayDecoders.decodeVarint32(r8, r10, r14);
        r18 = r14.int1;
        goto L13
    L15:
        Object r19 = Float.valueOf(ArrayDecoders.decodeFloat(r8, r10));
    L18:
        r14.object1 = r19;
        return r10 + 4;
    L16:
        Object r20 = Long.valueOf(ArrayDecoders.decodeFixed64(r8, r10));
    L20:
        r14.object1 = r20;
        return r10 + 8;
    L17:
        r19 = Integer.valueOf(ArrayDecoders.decodeFixed32(r8, r10));
        goto L18
    L19:
        r20 = Double.valueOf(ArrayDecoders.decodeDouble(r8, r10));
        goto L20
    L22:
        r15 = ArrayDecoders.decodeVarint64(r8, r10, r14);
        if (r14.long1 == 0) goto L25;
        boolean r21 = true;
    L26:
        r17 = Boolean.valueOf(r21);
        goto L14
    L25:
        r21 = false;
        goto L26
    L5:
        throw new RuntimeException("unsupported field type.");
    L27:
        return ArrayDecoders.decodeStringRequireUtf8(r8, r10, r14);
    L28:
        return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(r13), r8, r10, r11, r14);
    L32:
        return ArrayDecoders.decodeBytes(r8, r10, r14);
    }

    private static <T> double doubleAt(T r8, long r10) {
        return UnsafeUtil.getDouble(r8, r10);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object r10, int r11, UB r12, UnknownFieldSchema<UT, UB> r13, Object r14) {
        int r8 = numberAt(r11);
        Object r15 = UnsafeUtil.getObject(r10, offset(typeAndOffsetAt(r11)));
        if (r15 != null) goto L5;
        return r12;
    L5:
        Internal.EnumVerifier r16 = getEnumFieldVerifier(r11);
        if (r16 != null) goto L9;
        return r12;
    L9:
        return (UB) filterUnknownEnumMap(r11, r8, this.mapFieldSchema.forMutableMapData(r15), r16, r12, r13, r14);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int r8, int r10, Map<K, V> r11, Internal.EnumVerifier r12, UB r13, UnknownFieldSchema<UT, UB> r14, Object r15) {
        MapEntryLite.Metadata<?, ?> r16 = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(r8));
        Iterator<Map.Entry<K, V>> r17 = r11.entrySet().iterator();
    L4:
        if (r17.hasNext() == false) goto L15;
        Map.Entry<K, V> r18 = r17.next();
        if (r12.isInRange(((Integer) r18.getValue()).intValue()) == true) goto L4;
        if (r13 != null) goto L9;
        r13 = r14.getBuilderFromMessage(r15);
    L9:
        ByteString.CodedBuilder r19 = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(r16, r18.getKey(), r18.getValue()));
        CodedOutputStream r20 = r19.getCodedOutput();
        MapEntryLite.writeTo(r20, r16, r18.getKey(), r18.getValue());     // Catch: IOException -> L12
        UB r21 = r13;
        r14.addLengthDelimited(r21, r10, r19.build());
        r17.remove();
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    L15:
        return r13;
    }

    private static <T> float floatAt(T r8, long r10) {
        return UnsafeUtil.getFloat(r8, r10);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int r8) {
        return (Internal.EnumVerifier) this.objects[((r8 / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int r8) {
        return this.objects[(r8 / 3) * 2];
    }

    private Schema getMessageFieldSchema(int r8) {
        int r10 = (r8 / 3) * 2;
        Schema r11 = (Schema) this.objects[r10];
        if (r11 == null) goto L5;
        return r11;
    L5:
        Schema<T> r12 = Protobuf.getInstance().schemaFor((Class) this.objects[r10 + 1]);
        this.objects[r10] = r12;
        return r12;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object r8) {
        GeneratedMessageLite r10 = (GeneratedMessageLite) r8;
        UnknownFieldSetLite r11 = r10.unknownFields;
        if (r11 != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        UnknownFieldSetLite r12 = UnknownFieldSetLite.newInstance();
        r10.unknownFields = r12;
        return r12;
    L6:
        return r11;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> r8, T r10) {
        return r8.getSerializedSize(r8.getFromMessage(r10));
    }

    private static <T> int intAt(T r8, long r10) {
        return UnsafeUtil.getInt(r8, r10);
    }

    private static boolean isEnforceUtf8(int r8) {
        if ((r8 & ENFORCE_UTF8_MASK) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isFieldPresent(T r8, int r10) {
        int r11 = presenceMaskAndOffsetAt(r10);
        long r12 = 1048575 & r11;
        if (r12 != 1048575) goto L83;
        int r13 = typeAndOffsetAt(r10);
        long r14 = offset(r13);
        switch(type(r13)) {
            case 0: goto L79;
            case 1: goto L75;
            case 2: goto L71;
            case 3: goto L67;
            case 4: goto L63;
            case 5: goto L59;
            case 6: goto L55;
            case 7: goto L53;
            case 8: goto L42;
            case 9: goto L39;
            case 10: goto L37;
            case 11: goto L33;
            case 12: goto L29;
            case 13: goto L25;
            case 14: goto L21;
            case 15: goto L17;
            case 16: goto L13;
            case 17: goto L9;
            default: goto L7;
        };
    L42:
        Object r15 = UnsafeUtil.getObject(r8, r14);
        if ((r15 instanceof String) == false) goto L47;
        return !((String) r15).isEmpty();
    L47:
        if ((r15 instanceof ByteString) == false) goto L51;
        return !ByteString.EMPTY.equals(r15);
    L51:
        throw new IllegalArgumentException();
    L7:
        throw new IllegalArgumentException();
    L9:
        if (UnsafeUtil.getObject(r8, r14) != null) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (UnsafeUtil.getLong(r8, r14) != 0) goto L15;
        return false;
    L15:
        return true;
    L17:
        if (UnsafeUtil.getInt(r8, r14) != 0) goto L19;
        return false;
    L19:
        return true;
    L21:
        if (UnsafeUtil.getLong(r8, r14) != 0) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (UnsafeUtil.getInt(r8, r14) != 0) goto L27;
        return false;
    L27:
        return true;
    L29:
        if (UnsafeUtil.getInt(r8, r14) != 0) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (UnsafeUtil.getInt(r8, r14) != 0) goto L35;
        return false;
    L35:
        return true;
    L37:
        return !ByteString.EMPTY.equals(UnsafeUtil.getObject(r8, r14));
    L39:
        if (UnsafeUtil.getObject(r8, r14) != null) goto L41;
        return false;
    L41:
        return true;
    L53:
        return UnsafeUtil.getBoolean(r8, r14);
    L55:
        if (UnsafeUtil.getInt(r8, r14) != 0) goto L57;
        return false;
    L57:
        return true;
    L59:
        if (UnsafeUtil.getLong(r8, r14) != 0) goto L61;
        return false;
    L61:
        return true;
    L63:
        if (UnsafeUtil.getInt(r8, r14) != 0) goto L65;
        return false;
    L65:
        return true;
    L67:
        if (UnsafeUtil.getLong(r8, r14) != 0) goto L69;
        return false;
    L69:
        return true;
    L71:
        if (UnsafeUtil.getLong(r8, r14) != 0) goto L73;
        return false;
    L73:
        return true;
    L75:
        if (Float.floatToRawIntBits(UnsafeUtil.getFloat(r8, r14)) != 0) goto L77;
        return false;
    L77:
        return true;
    L79:
        if (Double.doubleToRawLongBits(UnsafeUtil.getDouble(r8, r14)) != 0) goto L81;
        return false;
    L81:
        return true;
    L83:
        if (((1 << (r11 >>> 20)) & UnsafeUtil.getInt(r8, r12)) != 0) goto L85;
        return false;
    L85:
        return true;
    }

    private static boolean isLegacyEnumIsClosed(int r8) {
        if ((r8 & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object r8, int r10, int r11) {
        List r12 = (List) UnsafeUtil.getObject(r8, offset(r10));
        if (r12.isEmpty() == false) goto L5;
        return true;
    L5:
        Schema r13 = getMessageFieldSchema(r11);
        int r14 = 0;
    L7:
        if (r14 >= r12.size()) goto L12;
        if (r13.isInitialized(r12.get(r14)) == false) goto L10;
        r14 = r14 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.protobuf.Schema] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private boolean isMapInitialized(T r8, int r10, int r11) {
        Map<?, ?> r12 = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(r8, offset(r10)));
        if (r12.isEmpty() == false) goto L5;
        return true;
    L5:
        Object r13 = getMapFieldDefaultEntry(r11);
        if (this.mapFieldSchema.forMapMetadata(r13).valueType.getJavaType() == WireFormat.JavaType.MESSAGE) goto L8;
        return true;
    L8:
        Iterator<?> r14 = r12.values().iterator();
        ?? r15 = 0;
    L10:
        if (r14.hasNext() == false) goto L18;
        Object r16 = r14.next();
        r15 = r15;
        if (r15 != 0) goto L15;
        r15 = Protobuf.getInstance().schemaFor(r16.getClass());
    L15:
        if (r15.isInitialized(r16) == true) goto L10;
        return false;
    L18:
        return true;
    }

    private static boolean isMutable(Object r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if ((r8 instanceof GeneratedMessageLite) == true) goto L8;
        return true;
    L8:
        return ((GeneratedMessageLite) r8).isMutable();
    }

    private boolean isOneofCaseEqual(T r8, T r10, int r11) {
        long r12 = presenceMaskAndOffsetAt(r11) & 1048575;
        if (UnsafeUtil.getInt(r8, r12) != UnsafeUtil.getInt(r10, r12)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isOneofPresent(T r8, int r10, int r11) {
        if (UnsafeUtil.getInt(r8, presenceMaskAndOffsetAt(r11) & 1048575) != r10) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isRequired(int r8) {
        if ((r8 & REQUIRED_MASK) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static <T> long longAt(T r8, long r10) {
        return UnsafeUtil.getLong(r8, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> r19, ExtensionSchema<ET> r20, T r21, Reader r22, ExtensionRegistryLite r23) {
        UnknownFieldSchema r8 = r19;
        T r15 = r21;
        ExtensionRegistryLite r10 = r23;
        Object r11 = null;
        Object r12 = null;
    L236:
        int r13 = r22.getFieldNumber();     // Catch: Throwable -> L213
        int r14 = positionForFieldNumber(r13);     // Catch: Throwable -> L213
        if (r14 < 0) goto L7;
        T r16 = r15;
        int r17 = typeAndOffsetAt(r14);     // Catch: Throwable -> L211
        switch(type(r17)) {
            case 0: goto L167;
            case 1: goto L166;
            case 2: goto L165;
            case 3: goto L164;
            case 4: goto L163;
            case 5: goto L162;
            case 6: goto L161;
            case 7: goto L160;
            case 8: goto L159;
            case 9: goto L158;
            case 10: goto L157;
            case 11: goto L156;
            case 12: goto L149;
            case 13: goto L148;
            case 14: goto L147;
            case 15: goto L146;
            case 16: goto L144;
            case 17: goto L142;
            case 18: goto L141;
            case 19: goto L140;
            case 20: goto L139;
            case 21: goto L138;
            case 22: goto L137;
            case 23: goto L136;
            case 24: goto L135;
            case 25: goto L134;
            case 26: goto L133;
            case 27: goto L132;
            case 28: goto L131;
            case 29: goto L130;
            case 30: goto L129;
            case 31: goto L128;
            case 32: goto L127;
            case 33: goto L126;
            case 34: goto L125;
            case 35: goto L123;
            case 36: goto L121;
            case 37: goto L119;
            case 38: goto L117;
            case 39: goto L115;
            case 40: goto L113;
            case 41: goto L111;
            case 42: goto L109;
            case 43: goto L107;
            case 44: goto L105;
            case 45: goto L103;
            case 46: goto L101;
            case 47: goto L99;
            case 48: goto L97;
            case 49: goto L91;
            case 50: goto L87;
            case 51: goto L83;
            case 52: goto L82;
            case 53: goto L81;
            case 54: goto L80;
            case 55: goto L79;
            case 56: goto L78;
            case 57: goto L77;
            case 58: goto L76;
            case 59: goto L74;
            case 60: goto L73;
            case 61: goto L72;
            case 62: goto L71;
            case 63: goto L64;
            case 64: goto L63;
            case 65: goto L62;
            case 66: goto L60;
            case 67: goto L59;
            case 68: goto L240;
            default: goto L53;
        };
    L53:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        if (r11 == null) goto L238;
        r11 = r11;
    L229:
        if (r8.mergeOneFieldFrom(r11, r22, 0) == false) goto L177;
    L208:
        r10 = r10;
        r8 = r8;
        r15 = r16;
        goto L236
    L177:
        int r18 = this.checkInitializedCount;
        Object r24 = r11;
    L179:
        if (r18 >= this.repeatedFieldOffsetStart) goto L181;
        r24 = filterMapUnknownEnumValues(r21, this.intArray[r18], r24, r19, r21);
        r18 = r18 + 1;
        goto L179
    L181:
        if (r24 == null) goto L263;
        r8.setBuilderToMessage(r16, r24);
        return;
    L263:
        return;
    L209:
        th = th;
    L217:
        int r25 = this.checkInitializedCount;
        Object r26 = r11;
    L219:
        if (r25 >= this.repeatedFieldOffsetStart) goto L221;
        r26 = filterMapUnknownEnumValues(r21, this.intArray[r25], r26, r19, r21);
        r25 = r25 + 1;
        goto L219
    L221:
        if (r26 == null) goto L223;
        r8.setBuilderToMessage(r16, r26);
    L223:
        throw th;
    L187:
        if (r8.shouldDiscardUnknownFields(r22) == true) goto L189;
        if (r11 != null) goto L200;
        r11 = r8.getBuilderFromMessage(r16);     // Catch: Throwable -> L209
    L200:
        if (r8.mergeOneFieldFrom(r11, r22, 0) == true) goto L208;
        int r27 = this.checkInitializedCount;
        Object r28 = r11;
    L203:
        if (r27 >= this.repeatedFieldOffsetStart) goto L205;
        r28 = filterMapUnknownEnumValues(r21, this.intArray[r27], r28, r19, r21);
        r27 = r27 + 1;
        goto L203
    L205:
        if (r28 == null) goto L265;
        r8.setBuilderToMessage(r16, r28);
        return;
    L265:
        return;
    L189:
        if (r22.skipField() == true) goto L208;
        int r29 = this.checkInitializedCount;
        Object r30 = r11;
    L192:
        if (r29 >= this.repeatedFieldOffsetStart) goto L194;
        r30 = filterMapUnknownEnumValues(r21, this.intArray[r29], r30, r19, r21);
        r29 = r29 + 1;
        goto L192
    L194:
        if (r30 == null) goto L264;
        r8.setBuilderToMessage(r16, r30);
        return;
    L264:
        return;
    L238:
        r11 = r8.getBuilderFromMessage(r16);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L229
    L170:
        th = th;
    L171:
        r11 = r11;
    L172:
        r11 = r11;
        goto L187
    L59:
        UnsafeUtil.putObject(r16, offset(r17), Long.valueOf(r22.readSInt64()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
    L61:
        setOneofPresent(r16, r13, r14);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
    L75:
        r11 = r11;
        r10 = r10;
    L90:
        r8 = r8;
    L169:
        r11 = r11;
        goto L208
    L60:
        UnsafeUtil.putObject(r16, offset(r17), Integer.valueOf(r22.readSInt32()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L62:
        UnsafeUtil.putObject(r16, offset(r17), Long.valueOf(r22.readSFixed64()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L63:
        UnsafeUtil.putObject(r16, offset(r17), Integer.valueOf(r22.readSFixed32()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L64:
        int r31 = r22.readEnum();     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        Internal.EnumVerifier r110 = getEnumFieldVerifier(r14);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        if (r110 != null) goto L67;
    L70:
        UnsafeUtil.putObject(r16, offset(r17), Integer.valueOf(r31));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L67:
        if (r110.isInRange(r31) == true) goto L70;
        r11 = SchemaUtil.storeUnknownEnum(r16, r13, r31, r11, r8);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        r10 = r10;
        r8 = r8;
        goto L208
    L71:
        UnsafeUtil.putObject(r16, offset(r17), Integer.valueOf(r22.readUInt32()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L72:
        UnsafeUtil.putObject(r16, offset(r17), r22.readBytes());     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L73:
        MessageLite r32 = (MessageLite) mutableOneofMessageFieldForMerge(r16, r13, r14);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        r22.mergeMessageField(r32, getMessageFieldSchema(r14), r10);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
    L58:
        storeOneofMessageField(r16, r13, r14, r32);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L75
    L74:
        readString(r16, r17, r22);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L76:
        UnsafeUtil.putObject(r16, offset(r17), Boolean.valueOf(r22.readBool()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L77:
        UnsafeUtil.putObject(r16, offset(r17), Integer.valueOf(r22.readFixed32()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L78:
        UnsafeUtil.putObject(r16, offset(r17), Long.valueOf(r22.readFixed64()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L79:
        UnsafeUtil.putObject(r16, offset(r17), Integer.valueOf(r22.readInt32()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L80:
        UnsafeUtil.putObject(r16, offset(r17), Long.valueOf(r22.readUInt64()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L81:
        UnsafeUtil.putObject(r16, offset(r17), Long.valueOf(r22.readInt64()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L82:
        UnsafeUtil.putObject(r16, offset(r17), Float.valueOf(r22.readFloat()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L83:
        UnsafeUtil.putObject(r16, offset(r17), Double.valueOf(r22.readDouble()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L87:
        r11 = r11;
        r10 = r10;
        mergeMap(r21, r14, getMapFieldDefaultEntry(r14), r23, r22);     // Catch: Throwable -> L94 InvalidProtocolBufferException.InvalidWireTypeException -> L96
    L96:
        r8 = r8;
    L94:
        th = th;
        r8 = r8;
        goto L171
        goto L185
    L91:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        readGroupList(r21, offset(r17), r22, getMessageFieldSchema(r14), r23);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L97:
        List<Long> r33 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L98:
        r22.readSInt64List(r33);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L99:
        List<Integer> r34 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L100:
        r22.readSInt32List(r34);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L101:
        List<Long> r35 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L102:
        r22.readSFixed64List(r35);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L103:
        List<Integer> r36 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L104:
        r22.readSFixed32List(r36);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L105:
        List<Integer> r37 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        r22.readEnumList(r37);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        Internal.EnumVerifier r38 = getEnumFieldVerifier(r14);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L106:
        r11 = SchemaUtil.filterUnknownEnumList(r21, r13, r37, r38, r11, r19);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L208
    L107:
        List<Integer> r39 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L108:
        r22.readUInt32List(r39);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L109:
        List<Boolean> r40 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L110:
        r22.readBoolList(r40);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L111:
        List<Integer> r41 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L112:
        r22.readFixed32List(r41);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L113:
        List<Long> r42 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L114:
        r22.readFixed64List(r42);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L115:
        List<Integer> r43 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L116:
        r22.readInt32List(r43);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L117:
        List<Long> r44 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L118:
        r22.readUInt64List(r44);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L119:
        List<Long> r45 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L120:
        r22.readInt64List(r45);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L121:
        List<Float> r46 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L122:
        r22.readFloatList(r46);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L123:
        List<Double> r47 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L124:
        r22.readDoubleList(r47);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L125:
        r33 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L98
    L126:
        r34 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L100
    L127:
        r35 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L102
    L128:
        r36 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L104
    L129:
        r37 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        r22.readEnumList(r37);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        r38 = getEnumFieldVerifier(r14);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L106
    L130:
        r39 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L108
    L131:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        r22.readBytesList(this.listFieldSchema.mutableListAt(r16, offset(r17)));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L132:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        readMessageList(r21, r17, r22, getMessageFieldSchema(r14), r23);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L133:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        readStringList(r16, r17, r22);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L134:
        r40 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L110
    L135:
        r41 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L112
    L136:
        r42 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L114
    L137:
        r43 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L116
    L138:
        r44 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L118
    L139:
        r45 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L120
    L140:
        r46 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L122
    L141:
        r47 = this.listFieldSchema.mutableListAt(r16, offset(r17));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L124
    L142:
        r10 = r10;
        MessageLite r48 = (MessageLite) mutableMessageFieldForMerge(r16, r14);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        r22.mergeGroupField(r48, getMessageFieldSchema(r14), r10);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L143:
        storeMessageField(r16, r14, r48);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L144:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putLong(r16, offset(r17), r22.readSInt64());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L145:
        setFieldPresent(r16, r14);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L146:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putInt(r16, offset(r17), r22.readSInt32());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L147:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putLong(r16, offset(r17), r22.readSFixed64());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L148:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putInt(r16, offset(r17), r22.readSFixed32());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L149:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        int r49 = r22.readEnum();     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        Internal.EnumVerifier r50 = getEnumFieldVerifier(r14);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        if (r50 != null) goto L152;
    L155:
        UnsafeUtil.putInt(r16, offset(r17), r49);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L152:
        if (r50.isInRange(r49) == true) goto L155;
        r11 = SchemaUtil.storeUnknownEnum(r16, r13, r49, r11, r8);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L208
    L156:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putInt(r16, offset(r17), r22.readUInt32());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L157:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putObject(r16, offset(r17), r22.readBytes());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L158:
        r10 = r10;
        r48 = (MessageLite) mutableMessageFieldForMerge(r16, r14);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        r22.mergeMessageField(r48, getMessageFieldSchema(r14), r10);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L143
    L159:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        readString(r16, r17, r22);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L160:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putBoolean(r16, offset(r17), r22.readBool());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L161:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putInt(r16, offset(r17), r22.readFixed32());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L162:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putLong(r16, offset(r17), r22.readFixed64());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L163:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putInt(r16, offset(r17), r22.readInt32());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L164:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putLong(r16, offset(r17), r22.readUInt64());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L165:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putLong(r16, offset(r17), r22.readInt64());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L166:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putFloat(r16, offset(r17), r22.readFloat());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L167:
        r11 = r11;
        r10 = r10;
        r8 = r8;
        UnsafeUtil.putDouble(r16, offset(r17), r22.readDouble());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L240:
        r32 = (MessageLite) mutableOneofMessageFieldForMerge(r16, r13, r14);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        r22.mergeGroupField(r32, getMessageFieldSchema(r14), r10);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
    L85:
        th = th;
    L216:
        r8 = r8;
    L185:
        r10 = r10;
        r8 = r8;
    L211:
        th = th;
        goto L216
    L7:
        if (r13 == Integer.MAX_VALUE) goto L8;
        if (this.hasExtensions == true) goto L18;
        Object r111 = null;
    L19:
        if (r111 == null) goto L27;
        if (r12 != null) goto L23;
        Object r51 = r20.getMutableExtensions(r21);     // Catch: Throwable -> L47
    L24:
        T r52 = r15;
        r11 = r20.parseExtension(r21, r22, r111, r23, r51, r11, r19);     // Catch: Throwable -> L45
        r12 = r51;
    L26:
        r15 = r52;
    L45:
        th = th;
        r16 = r52;
        goto L216
    L23:
        r51 = r12;
        goto L24
    L27:
        r52 = r15;
        if (r8.shouldDiscardUnknownFields(r22) == true) goto L30;
        if (r11 != null) goto L35;
        r11 = r8.getBuilderFromMessage(r52);     // Catch: Throwable -> L45
    L35:
        if (r8.mergeOneFieldFrom(r11, r22, 0) == true) goto L26;
    L37:
        int r53 = this.checkInitializedCount;
        Object r54 = r11;
    L39:
        if (r53 >= this.repeatedFieldOffsetStart) goto L41;
        r54 = filterMapUnknownEnumValues(r21, this.intArray[r53], r54, r19, r21);
        r53 = r53 + 1;
        r52 = r52;
        goto L39
    L41:
        T r112 = r52;
        if (r54 == null) goto L262;
        r8.setBuilderToMessage(r112, r54);
        return;
    L262:
        return;
    L30:
        if (r22.skipField() == false) goto L37;
    L18:
        r111 = r20.findExtensionByNumber(r10, this.defaultInstance, r13);     // Catch: Throwable -> L47
    L47:
        th = th;
    L215:
        r16 = r15;
        goto L216
    L8:
        int r55 = this.checkInitializedCount;
        Object r56 = r11;
    L10:
        if (r55 >= this.repeatedFieldOffsetStart) goto L12;
        r56 = filterMapUnknownEnumValues(r21, this.intArray[r55], r56, r19, r21);
        r55 = r55 + 1;
        goto L10
    L12:
        if (r56 == null) goto L261;
        r8.setBuilderToMessage(r15, r56);
        return;
    L261:
        return;
    L213:
        th = th;
        goto L215
    }

    private final <K, V> void mergeMap(Object r8, int r10, Object r11, ExtensionRegistryLite r12, Reader r13) {
        long r14 = offset(typeAndOffsetAt(r10));
        Object r15 = UnsafeUtil.getObject(r8, r14);
        if (r15 != null) goto L6;
        r15 = this.mapFieldSchema.newMapField(r11);
        UnsafeUtil.putObject(r8, r14, r15);
    L8:
        r13.readMap(this.mapFieldSchema.forMutableMapData(r15), this.mapFieldSchema.forMapMetadata(r11), r12);
        return;
    L6:
        if (this.mapFieldSchema.isImmutable(r15) == false) goto L8;
        Object r16 = this.mapFieldSchema.newMapField(r11);
        this.mapFieldSchema.mergeFrom(r16, r15);
        UnsafeUtil.putObject(r8, r14, r16);
        r15 = r16;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T r8, T r10, int r11) {
        if (isFieldPresent(r10, r11) == true) goto L5;
        return;
    L5:
        long r12 = offset(typeAndOffsetAt(r11));
        Unsafe r13 = UNSAFE;
        Object r14 = r13.getObject(r10, r12);
        if (r14 == null) goto L21;
        Schema r15 = getMessageFieldSchema(r11);
        if (isFieldPresent(r8, r11) == false) goto L10;
        Object r16 = r13.getObject(r8, r12);
        if (isMutable(r16) == true) goto L18;
        Object r17 = r15.newInstance();
        r15.mergeFrom(r17, r16);
        r13.putObject(r8, r12, r17);
        r16 = r17;
    L18:
        r15.mergeFrom(r16, r14);
        return;
    L10:
        if (isMutable(r14) == true) goto L12;
        r13.putObject(r8, r12, r14);
    L13:
        setFieldPresent(r8, r11);
        return;
    L12:
        Object r18 = r15.newInstance();
        r15.mergeFrom(r18, r14);
        r13.putObject(r8, r12, r18);
        goto L13
    L21:
        throw new IllegalStateException("Source subfield " + numberAt(r11) + " is present but null: " + r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T r8, T r10, int r11) {
        int r12 = numberAt(r11);
        if (isOneofPresent(r10, r12, r11) == true) goto L5;
        return;
    L5:
        long r13 = offset(typeAndOffsetAt(r11));
        Unsafe r14 = UNSAFE;
        Object r15 = r14.getObject(r10, r13);
        if (r15 == null) goto L21;
        Schema r16 = getMessageFieldSchema(r11);
        if (isOneofPresent(r8, r12, r11) == false) goto L10;
        Object r17 = r14.getObject(r8, r13);
        if (isMutable(r17) == true) goto L18;
        Object r18 = r16.newInstance();
        r16.mergeFrom(r18, r17);
        r14.putObject(r8, r13, r18);
        r17 = r18;
    L18:
        r16.mergeFrom(r17, r15);
        return;
    L10:
        if (isMutable(r15) == true) goto L12;
        r14.putObject(r8, r13, r15);
    L13:
        setOneofPresent(r8, r12, r11);
        return;
    L12:
        Object r19 = r16.newInstance();
        r16.mergeFrom(r19, r15);
        r14.putObject(r8, r13, r19);
        goto L13
    L21:
        throw new IllegalStateException("Source subfield " + numberAt(r11) + " is present but null: " + r10);
    }

    private void mergeSingleField(T r8, T r10, int r11) {
        int r12 = typeAndOffsetAt(r11);
        long r13 = offset(r12);
        int r14 = numberAt(r11);
        switch(type(r12)) {
            case 0: goto L61;
            case 1: goto L58;
            case 2: goto L55;
            case 3: goto L52;
            case 4: goto L49;
            case 5: goto L46;
            case 6: goto L43;
            case 7: goto L40;
            case 8: goto L37;
            case 9: goto L35;
            case 10: goto L33;
            case 11: goto L30;
            case 12: goto L27;
            case 13: goto L24;
            case 14: goto L21;
            case 15: goto L18;
            case 16: goto L15;
            case 17: goto L35;
            case 18: goto L13;
            case 19: goto L13;
            case 20: goto L13;
            case 21: goto L13;
            case 22: goto L13;
            case 23: goto L13;
            case 24: goto L13;
            case 25: goto L13;
            case 26: goto L13;
            case 27: goto L13;
            case 28: goto L13;
            case 29: goto L13;
            case 30: goto L13;
            case 31: goto L13;
            case 32: goto L13;
            case 33: goto L13;
            case 34: goto L13;
            case 35: goto L13;
            case 36: goto L13;
            case 37: goto L13;
            case 38: goto L13;
            case 39: goto L13;
            case 40: goto L13;
            case 41: goto L13;
            case 42: goto L13;
            case 43: goto L13;
            case 44: goto L13;
            case 45: goto L13;
            case 46: goto L13;
            case 47: goto L13;
            case 48: goto L13;
            case 49: goto L13;
            case 50: goto L12;
            case 51: goto L10;
            case 52: goto L10;
            case 53: goto L10;
            case 54: goto L10;
            case 55: goto L10;
            case 56: goto L10;
            case 57: goto L10;
            case 58: goto L10;
            case 59: goto L10;
            case 60: goto L8;
            case 61: goto L6;
            case 62: goto L6;
            case 63: goto L6;
            case 64: goto L6;
            case 65: goto L6;
            case 66: goto L6;
            case 67: goto L6;
            case 68: goto L8;
            default: goto L88;
        };
    L8:
        mergeOneofMessage(r8, r10, r11);
        return;
    L12:
        SchemaUtil.mergeMap(this.mapFieldSchema, r8, r10, r13);
        return;
    L13:
        this.listFieldSchema.mergeListsAt(r8, r10, r13);
        return;
    L35:
        mergeMessage(r8, r10, r11);
        return;
    L88:
        return;
    L6:
        if (isOneofPresent(r10, r14, r11) == false) goto L65;
    L11:
        UnsafeUtil.putObject(r8, r13, UnsafeUtil.getObject(r10, r13));
        setOneofPresent(r8, r14, r11);
        return;
    L65:
        return;
    L10:
        if (isOneofPresent(r10, r14, r11) == true) goto L11;
        return;
    L15:
        if (isFieldPresent(r10, r11) == false) goto L71;
    L56:
        UnsafeUtil.putLong(r8, r13, UnsafeUtil.getLong(r10, r13));
    L63:
        setFieldPresent(r8, r11);
        return;
    L71:
        return;
    L18:
        if (isFieldPresent(r10, r11) == false) goto L72;
    L50:
        UnsafeUtil.putInt(r8, r13, UnsafeUtil.getInt(r10, r13));
        goto L63
    L72:
        return;
    L21:
        if (isFieldPresent(r10, r11) == true) goto L56;
        return;
    L24:
        if (isFieldPresent(r10, r11) == true) goto L50;
        return;
    L27:
        if (isFieldPresent(r10, r11) == true) goto L50;
        return;
    L30:
        if (isFieldPresent(r10, r11) == true) goto L50;
        return;
    L33:
        if (isFieldPresent(r10, r11) == false) goto L77;
    L38:
        UnsafeUtil.putObject(r8, r13, UnsafeUtil.getObject(r10, r13));
        goto L63
    L77:
        return;
    L37:
        if (isFieldPresent(r10, r11) == true) goto L38;
        return;
    L40:
        if (isFieldPresent(r10, r11) == false) goto L80;
        UnsafeUtil.putBoolean(r8, r13, UnsafeUtil.getBoolean(r10, r13));
        goto L63
    L80:
        return;
    L43:
        if (isFieldPresent(r10, r11) == true) goto L50;
        return;
    L46:
        if (isFieldPresent(r10, r11) == true) goto L56;
        return;
    L49:
        if (isFieldPresent(r10, r11) == true) goto L50;
        return;
    L52:
        if (isFieldPresent(r10, r11) == true) goto L56;
        return;
    L55:
        if (isFieldPresent(r10, r11) == true) goto L56;
        return;
    L58:
        if (isFieldPresent(r10, r11) == false) goto L86;
        UnsafeUtil.putFloat(r8, r13, UnsafeUtil.getFloat(r10, r13));
        goto L63
    L86:
        return;
    L61:
        if (isFieldPresent(r10, r11) == false) goto L87;
        UnsafeUtil.putDouble(r8, r13, UnsafeUtil.getDouble(r10, r13));
        goto L63
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T r8, int r10) {
        Schema r11 = getMessageFieldSchema(r10);
        long r12 = offset(typeAndOffsetAt(r10));
        if (isFieldPresent(r8, r10) == false) goto L5;
        Object r13 = UNSAFE.getObject(r8, r12);
        if (isMutable(r13) == false) goto L9;
        return r13;
    L9:
        Object r14 = r11.newInstance();
        if (r13 == null) goto L12;
        r11.mergeFrom(r14, r13);
    L12:
        return r14;
    L5:
        return r11.newInstance();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T r8, int r10, int r11) {
        Schema r12 = getMessageFieldSchema(r11);
        if (isOneofPresent(r8, r10, r11) == false) goto L5;
        Object r13 = UNSAFE.getObject(r8, offset(typeAndOffsetAt(r11)));
        if (isMutable(r13) == false) goto L9;
        return r13;
    L9:
        Object r14 = r12.newInstance();
        if (r13 == null) goto L12;
        r12.mergeFrom(r14, r13);
    L12:
        return r14;
    L5:
        return r12.newInstance();
    }

    public static <T> MessageSchema<T> newSchema(Class<T> r8, MessageInfo r10, NewInstanceSchema r11, ListFieldSchema r12, UnknownFieldSchema<?, ?> r13, ExtensionSchema<?> r14, MapFieldSchema r15) {
        if ((r10 instanceof RawMessageInfo) == false) goto L7;
        return newSchemaForRawMessageInfo((RawMessageInfo) r10, r11, r12, r13, r14, r15);
    L7:
        return newSchemaForMessageInfo((StructuralMessageInfo) r10, r11, r12, r13, r14, r15);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo r19, NewInstanceSchema r20, ListFieldSchema r21, UnknownFieldSchema<?, ?> r22, ExtensionSchema<?> r23, MapFieldSchema r24) {
        FieldInfo[] r8 = r19.getFields();
        if (r8.length != 0) goto L5;
        int r10 = 0;
        int r11 = 0;
    L6:
        int r12 = r8.length;
        int[] r13 = new int[r12 * 3];
        Object[] r14 = new Object[r12 * 2];
        int r15 = r8.length;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
    L8:
        if (r16 >= r15) goto L18;
        FieldInfo r110 = r8[r16];
        if (r110.getType() != FieldType.MAP) goto L13;
        r17 = r17 + 1;
    L17:
        r16 = r16 + 1;
        goto L8
    L13:
        if (r110.getType().id() < 18) goto L17;
        if (r110.getType().id() > 49) goto L17;
        r18 = r18 + 1;
        goto L17
    L18:
        int[] r25 = null;
        if (r17 <= 0) goto L21;
        int[] r26 = new int[r17];
    L22:
        if (r18 <= 0) goto L24;
        r25 = new int[r18];
    L24:
        int[] r27 = r19.getCheckInitialized();
        if (r27 != null) goto L27;
        r27 = EMPTY_INT_ARRAY;
    L27:
        int r28 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
    L29:
        if (r28 >= r8.length) goto L45;
        FieldInfo r29 = r8[r28];
        int r115 = r29.getFieldNumber();
        storeFieldData(r29, r13, r111, r14);
        if (r112 >= r27.length) goto L36;
        if (r27[r112] != r115) goto L36;
        r27[r112] = r111;
        r112 = r112 + 1;
    L36:
        if (r29.getType() != FieldType.MAP) goto L40;
        r26[r113] = r111;
        r113 = r113 + 1;
    L44:
        r28 = r28 + 1;
        r111 = r111 + 3;
        goto L29
    L40:
        if (r29.getType().id() < 18) goto L44;
        if (r29.getType().id() > 49) goto L44;
        r25[r114] = (int) UnsafeUtil.objectFieldOffset(r29.getField());
        r114 = r114 + 1;
        goto L44
    L45:
        if (r26 != null) goto L47;
        r26 = EMPTY_INT_ARRAY;
    L47:
        if (r25 != null) goto L49;
        r25 = EMPTY_INT_ARRAY;
    L49:
        int r30 = (r27.length + r26.length) + r25.length;
        if (r30 <= 0) goto L52;
        int[] r31 = new int[r30];
        System.arraycopy(r27, 0, r31, 0, r27.length);
        System.arraycopy(r26, 0, r31, r27.length, r26.length);
        System.arraycopy(r25, 0, r31, r27.length + r26.length, r25.length);
    L54:
        return new MessageSchema(r13, r14, r10, r11, r19.getDefaultInstance(), true, r31, r27.length, r27.length + r26.length, r20, r21, r22, r23, r24);
    L52:
        r31 = EMPTY_INT_ARRAY;
        goto L54
    L21:
        r26 = null;
        goto L22
    L5:
        r10 = r8[0].getFieldNumber();
        r11 = r8[r8.length - 1].getFieldNumber();
        goto L6
    }

    public static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo r33, NewInstanceSchema r34, ListFieldSchema r35, UnknownFieldSchema<?, ?> r36, ExtensionSchema<?> r37, MapFieldSchema r38) {
        String r8 = r33.getStringInfo();
        int r10 = r8.length();
        char r11 = 55296;
        if (r8.charAt(0) < 55296) goto L8;
        int r12 = 1;
    L5:
        int r13 = r12 + 1;
        if (r8.charAt(r12) < 55296) goto L9;
        r12 = r13;
    L9:
        int r14 = r13 + 1;
        int r15 = r8.charAt(r13);
        if (r15 < 55296) goto L16;
        int r16 = r15 & 8191;
        int r17 = 13;
    L12:
        int r18 = r14 + 1;
        char r19 = r8.charAt(r14);
        if (r19 < 55296) goto L15;
        r16 = r16 | ((r19 & 8191) << r17);
        r17 = r17 + 13;
        r14 = r18;
        goto L12
    L15:
        r15 = r16 | (r19 << r17);
        r14 = r18;
    L16:
        if (r15 != 0) goto L18;
        int r20 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
        int[] r115 = EMPTY_INT_ARRAY;
        int r21 = 0;
    L75:
        Unsafe r22 = UNSAFE;
        Object[] r116 = r33.getObjects();
        Class<?> r23 = r33.getDefaultInstance().getClass();
        int[] r24 = new int[r110 * 3];
        Object[] r117 = new Object[r110 * 2];
        int r118 = r114 + r111;
        int r25 = r114;
        int r26 = r118;
        int r119 = 0;
        int r27 = 0;
    L76:
        if (r14 >= r10) goto L204;
        int r28 = r14 + 1;
        int r29 = r8.charAt(r14);
        if (r29 < r11) goto L84;
        int r30 = r29 & 8191;
        int r31 = r28;
        int r210 = 13;
    L80:
        int r211 = r31 + 1;
        char r32 = r8.charAt(r31);
        if (r32 < r11) goto L83;
        r30 = r30 | ((r32 & 8191) << r210);
        r210 = r210 + 13;
        r31 = r211;
        goto L80
    L83:
        r29 = r30 | (r32 << r210);
        int r39 = r211;
    L85:
        int r212 = r39 + 1;
        int r40 = r8.charAt(r39);
        if (r40 < r11) goto L92;
        int r41 = r40 & 8191;
        int r42 = r212;
        int r213 = 13;
    L88:
        int r214 = r42 + 1;
        char r43 = r8.charAt(r42);
        int r215 = r10;
        if (r43 < 55296) goto L91;
        r41 = r41 | ((r43 & 8191) << r213);
        r213 = r213 + 13;
        r42 = r214;
        r10 = r215;
        goto L88
    L91:
        r40 = r41 | (r43 << r213);
        int r44 = r214;
    L93:
        int r45 = r40 & 255;
        int r216 = r113;
        if ((r40 & 1024) == 0) goto L96;
        r115[r119] = r27;
        r119 = r119 + 1;
    L96:
        int r217 = r119;
        if (r45 < 51) goto L128;
        int r120 = r44 + 1;
        int r46 = r8.charAt(r44);
        char r121 = 55296;
        if (r46 < 55296) goto L105;
        int r47 = r46 & 8191;
        int r310 = 13;
    L101:
        int r311 = r120 + 1;
        char r122 = r8.charAt(r120);
        if (r122 < r121) goto L104;
        r47 = r47 | ((r122 & 8191) << r310);
        r310 = r310 + 13;
        r120 = r311;
        r121 = 55296;
        goto L101
    L104:
        r46 = r47 | (r122 << r310);
        r120 = r311;
    L105:
        int r123 = r45 - 51;
        int r312 = r120;
        if (r123 != 9) goto L108;
    L117:
        int r124 = r20 + 1;
        r117[((r27 / 3) * 2) + 1] = r116[r20];
    L118:
        r20 = r124;
    L119:
        int r48 = r46 * 2;
        Object r125 = r116[r48];
        if ((r125 instanceof java.lang.reflect.Field) == false) goto L122;
        java.lang.reflect.Field r126 = (java.lang.reflect.Field) r125;
    L123:
        int r127 = r112;
        int r128 = (int) r22.objectFieldOffset(r126);
        int r49 = r48 + 1;
        Object r129 = r116[r49];
        int r218 = r20;
        if ((r129 instanceof java.lang.reflect.Field) == false) goto L126;
        java.lang.reflect.Field r130 = (java.lang.reflect.Field) r129;
    L127:
        int r50 = (int) r22.objectFieldOffset(r130);
        r116 = r116;
        int r131 = r218;
        int r219 = r312;
        int r220 = r127;
        int r132 = r128;
        int r51 = 0;
    L190:
        int r133 = r27 + 1;
        r24[r27] = r29;
        int r52 = r133 + 1;
        String r221 = r8;
        if ((r40 & 512) == 0) goto L193;
        int r53 = ENFORCE_UTF8_MASK;
    L194:
        Class<?> r222 = r23;
        if ((r40 & 256) == 0) goto L197;
        int r54 = REQUIRED_MASK;
    L198:
        int r55 = r53 | r54;
        if ((r40 & 2048) == 0) goto L201;
        int r56 = Integer.MIN_VALUE;
    L202:
        r24[r133] = ((r55 | r56) | (r45 << 20)) | r132;
        int r57 = r52 + 1;
        r24[r52] = (r51 << 20) | r50;
        r20 = r131;
        r116 = r116;
        r113 = r216;
        r23 = r222;
        r112 = r220;
        r10 = r215;
        r14 = r219;
        r119 = r217;
        r11 = 55296;
        r27 = r57;
        r8 = r221;
        goto L76
    L201:
        r56 = 0;
        goto L202
    L197:
        r54 = 0;
        goto L198
    L193:
        r53 = 0;
        goto L194
    L126:
        r130 = reflectField(r23, (String) r129);
        r116[r49] = r130;
        goto L127
    L122:
        r126 = reflectField(r23, (String) r125);
        r116[r48] = r126;
        goto L123
    L108:
        if (r123 == 17) goto L117;
        if (r123 != 12) goto L119;
        if (r33.getSyntax().equals(ProtoSyntax.PROTO2) == false) goto L115;
    L116:
        r124 = r20 + 1;
        r117[((r27 / 3) * 2) + 1] = r116[r20];
        goto L118
    L115:
        if ((r40 & 2048) == 0) goto L119;
    L128:
        int r134 = r112;
        r131 = r20 + 1;
        java.lang.reflect.Field r58 = reflectField(r23, (String) r116[r20]);
        if (r45 != 9) goto L131;
    L161:
        r220 = r134;
        r117[((r27 / 3) * 2) + 1] = r58.getType();
    L163:
        int r59 = (int) r22.objectFieldOffset(r58);
        if ((r40 & 4096) == 0) goto L166;
        boolean r135 = true;
    L167:
        if (r135 == true) goto L169;
    L183:
        int r136 = 1048575;
        r219 = r44;
        r51 = 0;
    L185:
        if (r45 >= 18) goto L187;
    L189:
        int r313 = r136;
        r132 = r59;
        r50 = r313;
        goto L190
    L187:
        if (r45 > 49) goto L189;
        r115[r26] = r59;
        r26 = r26 + 1;
        goto L189
    L169:
        if (r45 > 17) goto L183;
        int r137 = r44 + 1;
        int r60 = r8.charAt(r44);
        if (r60 < 55296) goto L177;
        int r61 = r60 & 8191;
        int r223 = 13;
    L173:
        r219 = r137 + 1;
        char r138 = r8.charAt(r137);
        if (r138 < 55296) goto L176;
        r61 = r61 | ((r138 & 8191) << r223);
        r223 = r223 + 13;
        r137 = r219;
        goto L173
    L176:
        r60 = r61 | (r138 << r223);
    L178:
        int r224 = (r60 / 32) + (r21 * 2);
        Object r139 = r116[r224];
        if ((r139 instanceof java.lang.reflect.Field) == false) goto L181;
        java.lang.reflect.Field r140 = (java.lang.reflect.Field) r139;
    L182:
        r136 = (int) r22.objectFieldOffset(r140);
        r51 = r60 % 32;
        goto L185
    L181:
        r140 = reflectField(r23, (String) r139);
        r116[r224] = r140;
        goto L182
    L177:
        r219 = r137;
        goto L178
    L166:
        r135 = false;
        goto L167
    L131:
        if (r45 == 17) goto L161;
        if (r45 != 27) goto L136;
    L159:
        r220 = r134;
        int r225 = r131 + 1;
        r117[((r27 / 3) * 2) + 1] = r116[r131];
    L160:
        r131 = r225;
        goto L163
    L136:
        if (r45 == 49) goto L159;
        if (r45 != 12) goto L141;
    L152:
        r220 = r134;
        if (r33.getSyntax() != ProtoSyntax.PROTO2) goto L155;
    L158:
        r225 = r131 + 1;
        r117[((r27 / 3) * 2) + 1] = r116[r131];
        goto L160
    L155:
        if ((r40 & 2048) == 0) goto L163;
    L141:
        if (r45 == 30) goto L152;
        if (r45 == 44) goto L152;
        if (r45 != 50) goto L151;
        int r141 = r25 + 1;
        r115[r25] = r27;
        int r226 = (r27 / 3) * 2;
        int r227 = r131 + 1;
        r117[r226] = r116[r131];
        if ((r40 & 2048) == 0) goto L150;
        r131 = r227 + 1;
        r117[r226 + 1] = r116[r227];
        r25 = r141;
        r220 = r134;
        goto L163
    L150:
        r25 = r141;
        r131 = r227;
        r220 = r134;
        goto L163
    L151:
        r220 = r134;
        goto L163
    L92:
        r215 = r10;
        r44 = r212;
        goto L93
    L84:
        r39 = r28;
        goto L85
    L204:
        return new MessageSchema(r24, r117, r112, r113, r33.getDefaultInstance(), false, r115, r114, r118, r34, r35, r36, r37, r38);
    L18:
        int r62 = r14 + 1;
        int r63 = r8.charAt(r14);
        if (r63 < 55296) goto L25;
        int r64 = r63 & 8191;
        int r65 = 13;
    L21:
        int r66 = r62 + 1;
        char r67 = r8.charAt(r62);
        if (r67 < 55296) goto L24;
        r64 = r64 | ((r67 & 8191) << r65);
        r65 = r65 + 13;
        r62 = r66;
        goto L21
    L24:
        r63 = r64 | (r67 << r65);
        r62 = r66;
    L25:
        int r68 = r62 + 1;
        int r69 = r8.charAt(r62);
        if (r69 < 55296) goto L32;
        int r70 = r69 & 8191;
        int r71 = 13;
    L28:
        int r142 = r68 + 1;
        char r72 = r8.charAt(r68);
        if (r72 < 55296) goto L31;
        r70 = r70 | ((r72 & 8191) << r71);
        r71 = r71 + 13;
        r68 = r142;
        goto L28
    L31:
        r69 = r70 | (r72 << r71);
        r68 = r142;
    L32:
        int r73 = r68 + 1;
        int r74 = r8.charAt(r68);
        if (r74 < 55296) goto L39;
        int r75 = r74 & 8191;
        int r143 = 13;
    L35:
        int r144 = r73 + 1;
        char r76 = r8.charAt(r73);
        if (r76 < 55296) goto L38;
        r75 = r75 | ((r76 & 8191) << r143);
        r143 = r143 + 13;
        r73 = r144;
        goto L35
    L38:
        r74 = r75 | (r76 << r143);
        r73 = r144;
    L39:
        int r145 = r73 + 1;
        int r77 = r8.charAt(r73);
        if (r77 < 55296) goto L46;
        int r78 = r77 & 8191;
        int r146 = 13;
    L42:
        int r147 = r145 + 1;
        char r148 = r8.charAt(r145);
        if (r148 < 55296) goto L45;
        r78 = r78 | ((r148 & 8191) << r146);
        r146 = r146 + 13;
        r145 = r147;
        goto L42
    L45:
        r77 = r78 | (r148 << r146);
        r145 = r147;
    L46:
        int r149 = r145 + 1;
        r110 = r8.charAt(r145);
        if (r110 < 55296) goto L53;
        int r150 = r110 & 8191;
        int r151 = 13;
    L49:
        int r152 = r149 + 1;
        char r153 = r8.charAt(r149);
        if (r153 < 55296) goto L52;
        r150 = r150 | ((r153 & 8191) << r151);
        r151 = r151 + 13;
        r149 = r152;
        goto L49
    L52:
        r110 = r150 | (r153 << r151);
        r149 = r152;
    L53:
        int r154 = r149 + 1;
        r111 = r8.charAt(r149);
        if (r111 < 55296) goto L60;
        int r155 = r111 & 8191;
        int r156 = 13;
    L56:
        int r157 = r154 + 1;
        char r158 = r8.charAt(r154);
        if (r158 < 55296) goto L59;
        r155 = r155 | ((r158 & 8191) << r156);
        r156 = r156 + 13;
        r154 = r157;
        goto L56
    L59:
        r111 = r155 | (r158 << r156);
        r154 = r157;
    L60:
        int r159 = r154 + 1;
        int r160 = r8.charAt(r154);
        if (r160 < 55296) goto L67;
        int r161 = r160 & 8191;
        int r162 = 13;
    L63:
        int r163 = r159 + 1;
        char r164 = r8.charAt(r159);
        if (r164 < 55296) goto L66;
        r161 = r161 | ((r164 & 8191) << r162);
        r162 = r162 + 13;
        r159 = r163;
        goto L63
    L66:
        r160 = r161 | (r164 << r162);
        r159 = r163;
    L67:
        int r165 = r159 + 1;
        int r166 = r8.charAt(r159);
        if (r166 < 55296) goto L74;
        int r167 = r166 & 8191;
        int r168 = 13;
    L70:
        int r169 = r165 + 1;
        char r170 = r8.charAt(r165);
        if (r170 < 55296) goto L73;
        r167 = r167 | ((r170 & 8191) << r168);
        r168 = r168 + 13;
        r165 = r169;
        goto L70
    L73:
        r166 = r167 | (r170 << r168);
        r165 = r169;
    L74:
        int[] r171 = new int[(r166 + r111) + r160];
        int r172 = (r63 * 2) + r69;
        r21 = r63;
        r114 = r166;
        r14 = r165;
        r113 = r77;
        r112 = r74;
        r20 = r172;
        r115 = r171;
        goto L75
    L8:
        r13 = 1;
        goto L9
    }

    private int numberAt(int r8) {
        return this.buffer[r8];
    }

    private static long offset(int r8) {
        return r8 & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T r8, long r10) {
        return ((Boolean) UnsafeUtil.getObject(r8, r10)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T r8, long r10) {
        return ((Double) UnsafeUtil.getObject(r8, r10)).doubleValue();
    }

    private static <T> float oneofFloatAt(T r8, long r10) {
        return ((Float) UnsafeUtil.getObject(r8, r10)).floatValue();
    }

    private static <T> int oneofIntAt(T r8, long r10) {
        return ((Integer) UnsafeUtil.getObject(r8, r10)).intValue();
    }

    private static <T> long oneofLongAt(T r8, long r10) {
        return ((Long) UnsafeUtil.getObject(r8, r10)).longValue();
    }

    private <K, V> int parseMapField(T r10, byte[] r11, int r12, int r13, int r14, long r15, ArrayDecoders.Registers r17) {
        Unsafe r8 = UNSAFE;
        Object r16 = getMapFieldDefaultEntry(r14);
        Object r18 = r8.getObject(r10, r15);
        if (this.mapFieldSchema.isImmutable(r18) == false) goto L6;
        Object r19 = this.mapFieldSchema.newMapField(r16);
        this.mapFieldSchema.mergeFrom(r19, r18);
        r8.putObject(r10, r15, r19);
        r18 = r19;
    L6:
        return decodeMapEntry(r11, r12, r13, this.mapFieldSchema.forMapMetadata(r16), this.mapFieldSchema.forMutableMapData(r18), r17);
    }

    private int parseOneofField(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, ArrayDecoders.Registers r29) {
        Unsafe r11 = UNSAFE;
        long r12 = this.buffer[r28 + 2] & 1048575;
        switch(r25) {
            case 51: goto L60;
            case 52: goto L56;
            case 53: goto L52;
            case 54: goto L52;
            case 55: goto L49;
            case 56: goto L47;
            case 57: goto L44;
            case 58: goto L38;
            case 59: goto L26;
            case 60: goto L23;
            case 61: goto L21;
            case 62: goto L49;
            case 63: goto L12;
            case 64: goto L44;
            case 65: goto L47;
            case 66: goto L10;
            case 67: goto L8;
            case 68: goto L6;
            default: goto L96;
        };
    L8:
        if (r23 != 0) goto L83;
        int r8 = ArrayDecoders.decodeVarint64(r18, r19, r29);
        long r10 = CodedInputStream.decodeZigZag64(r29.long1);
    L54:
        Object r13 = Long.valueOf(r10);
    L55:
        r11.putObject(r17, r26, r13);
    L63:
        r11.putInt(r17, r12, r22);
        return r8;
    L83:
        return r19;
    L10:
        if (r23 != 0) goto L84;
        r8 = ArrayDecoders.decodeVarint32(r18, r19, r29);
        int r14 = CodedInputStream.decodeZigZag32(r29.int1);
    L51:
        r13 = Integer.valueOf(r14);
        goto L55
    L84:
        return r19;
    L12:
        if (r23 != 0) goto L85;
        int r15 = ArrayDecoders.decodeVarint32(r18, r19, r29);
        int r16 = r29.int1;
        Internal.EnumVerifier r27 = getEnumFieldVerifier(r28);
        if (r27 != null) goto L16;
    L19:
        r11.putObject(r17, r26, Integer.valueOf(r16));
        r11.putInt(r17, r12, r22);
    L80:
        return r15;
    L16:
        if (r27.isInRange(r16) == true) goto L19;
        getMutableUnknownFields(r17).storeField(r21, Long.valueOf(r16));
        goto L80
    L85:
        return r19;
    L21:
        if (r23 != 2) goto L86;
        r8 = ArrayDecoders.decodeBytes(r18, r19, r29);
        r13 = r29.object1;
        goto L55
    L86:
        return r19;
    L23:
        if (r23 != 2) goto L87;
        Object r110 = mutableOneofMessageFieldForMerge(r17, r22, r28);
        int r30 = ArrayDecoders.mergeMessageField(r110, getMessageFieldSchema(r28), r18, r19, r20, r29);
    L25:
        storeOneofMessageField(r17, r22, r28, r110);
        return r30;
    L87:
        return r19;
    L26:
        if (r23 != 2) goto L88;
        r8 = ArrayDecoders.decodeVarint32(r18, r19, r29);
        int r31 = r29.int1;
        if (r31 != 0) goto L31;
        r13 = "";
        goto L55
    L31:
        if ((r24 & ENFORCE_UTF8_MASK) != 0) goto L33;
    L37:
        r11.putObject(r17, r26, new String(r18, r8, r31, Internal.UTF_8));
        r8 = r8 + r31;
        goto L63
    L33:
        if (Utf8.isValidUtf8(r18, r8, r8 + r31) == true) goto L37;
        throw InvalidProtocolBufferException.invalidUtf8();
    L88:
        return r19;
    L38:
        if (r23 != 0) goto L89;
        r8 = ArrayDecoders.decodeVarint64(r18, r19, r29);
        if (r29.long1 == 0) goto L42;
        boolean r111 = true;
    L43:
        r13 = Boolean.valueOf(r111);
        goto L55
    L42:
        r111 = false;
        goto L43
    L89:
        return r19;
    L44:
        if (r23 != 5) goto L90;
        Object r32 = Integer.valueOf(ArrayDecoders.decodeFixed32(r18, r19));
    L58:
        r11.putObject(r17, r26, r32);
        r8 = r19 + 4;
        goto L63
    L90:
        return r19;
    L49:
        if (r23 != 0) goto L92;
        r8 = ArrayDecoders.decodeVarint32(r18, r19, r29);
        r14 = r29.int1;
        goto L51
    L92:
        return r19;
    L52:
        if (r23 != 0) goto L93;
        r8 = ArrayDecoders.decodeVarint64(r18, r19, r29);
        r10 = r29.long1;
        goto L54
    L93:
        return r19;
    L56:
        if (r23 != 5) goto L94;
        r32 = Float.valueOf(ArrayDecoders.decodeFloat(r18, r19));
        goto L58
    L94:
        return r19;
    L6:
        if (r23 != 3) goto L65;
        r110 = mutableOneofMessageFieldForMerge(r17, r22, r28);
        r30 = ArrayDecoders.mergeGroupField(r110, getMessageFieldSchema(r28), r18, r19, r20, (r21 & (-8)) | 4, r29);
        goto L25
    L65:
        return r19;
    L47:
        if (r23 != 1) goto L91;
        Object r33 = Long.valueOf(ArrayDecoders.decodeFixed64(r18, r19));
    L62:
        r11.putObject(r17, r26, r33);
        r8 = r19 + 8;
        goto L63
    L91:
        return r19;
    L60:
        if (r23 != 1) goto L95;
        r33 = Double.valueOf(ArrayDecoders.decodeDouble(r18, r19));
        goto L62
    L95:
        return r19;
    L96:
        return r19;
    }

    private int parseRepeatedField(T r14, byte[] r15, int r16, int r17, int r18, int r19, int r20, int r21, long r22, int r24, long r25, ArrayDecoders.Registers r27) {
        Unsafe r10 = UNSAFE;
        Internal.ProtobufList r11 = (Internal.ProtobufList) r10.getObject(r14, r25);
        if (r11.isModifiable() == true) goto L6;
        r11 = r11.mutableCopyWithCapacity(r11.size() * 2);
        r10.putObject(r14, r25, r11);
    L6:
        switch(r24) {
            case 18: goto L57;
            case 19: goto L53;
            case 20: goto L49;
            case 21: goto L49;
            case 22: goto L45;
            case 23: goto L41;
            case 24: goto L37;
            case 25: goto L33;
            case 26: goto L28;
            case 27: goto L26;
            case 28: goto L24;
            case 29: goto L45;
            case 30: goto L19;
            case 31: goto L37;
            case 32: goto L41;
            case 33: goto L15;
            case 34: goto L11;
            case 35: goto L57;
            case 36: goto L53;
            case 37: goto L49;
            case 38: goto L49;
            case 39: goto L45;
            case 40: goto L41;
            case 41: goto L37;
            case 42: goto L33;
            case 43: goto L45;
            case 44: goto L19;
            case 45: goto L37;
            case 46: goto L41;
            case 47: goto L15;
            case 48: goto L11;
            case 49: goto L9;
            default: goto L114;
        };
    L11:
        if (r20 == 2) goto L78;
        if (r20 != 0) goto L101;
        return ArrayDecoders.decodeSInt64List(r18, r15, r16, r17, r11, r27);
    L101:
        return r16;
    L78:
        return ArrayDecoders.decodePackedSInt64List(r15, r16, r11, r27);
    L15:
        if (r20 == 2) goto L80;
        if (r20 != 0) goto L102;
        return ArrayDecoders.decodeSInt32List(r18, r15, r16, r17, r11, r27);
    L102:
        return r16;
    L80:
        return ArrayDecoders.decodePackedSInt32List(r15, r16, r11, r27);
    L19:
        if (r20 != 2) goto L21;
        int r8 = ArrayDecoders.decodePackedVarint32List(r15, r16, r11, r27);
    L23:
        Internal.ProtobufList r110 = r11;
        SchemaUtil.filterUnknownEnumList(r14, r19, r110, getEnumFieldVerifier(r21), null, this.unknownFieldSchema);
        return r8;
    L21:
        if (r20 != 0) goto L103;
        r8 = ArrayDecoders.decodeVarint32List(r18, r15, r16, r17, r11, r27);
        goto L23
    L103:
        return r16;
    L24:
        if (r20 != 2) goto L104;
        return ArrayDecoders.decodeBytesList(r18, r15, r16, r17, r11, r27);
    L104:
        return r16;
    L26:
        if (r20 != 2) goto L105;
        return ArrayDecoders.decodeMessageList(getMessageFieldSchema(r21), r18, r15, r16, r17, r11, r27);
    L105:
        return r16;
    L28:
        if (r20 != 2) goto L106;
        long r12 = r22 & 536870912;
        Internal.ProtobufList r23 = r11;
        if (r12 != 0) goto L86;
        return ArrayDecoders.decodeStringList(r18, r15, r16, r17, r23, r27);
    L86:
        return ArrayDecoders.decodeStringListRequireUtf8(r18, r15, r16, r17, r23, r27);
    L106:
        return r16;
    L33:
        if (r20 == 2) goto L87;
        if (r20 != 0) goto L107;
        return ArrayDecoders.decodeBoolList(r18, r15, r16, r17, r11, r27);
    L107:
        return r16;
    L87:
        return ArrayDecoders.decodePackedBoolList(r15, r16, r11, r27);
    L37:
        if (r20 == 2) goto L89;
        if (r20 != 5) goto L108;
        return ArrayDecoders.decodeFixed32List(r18, r15, r16, r17, r11, r27);
    L108:
        return r16;
    L89:
        return ArrayDecoders.decodePackedFixed32List(r15, r16, r11, r27);
    L41:
        if (r20 == 2) goto L91;
        if (r20 != 1) goto L109;
        return ArrayDecoders.decodeFixed64List(r18, r15, r16, r17, r11, r27);
    L109:
        return r16;
    L91:
        return ArrayDecoders.decodePackedFixed64List(r15, r16, r11, r27);
    L45:
        if (r20 == 2) goto L93;
        if (r20 != 0) goto L110;
        return ArrayDecoders.decodeVarint32List(r18, r15, r16, r17, r11, r27);
    L110:
        return r16;
    L93:
        return ArrayDecoders.decodePackedVarint32List(r15, r16, r11, r27);
    L49:
        if (r20 == 2) goto L95;
        if (r20 != 0) goto L111;
        return ArrayDecoders.decodeVarint64List(r18, r15, r16, r17, r11, r27);
    L111:
        return r16;
    L95:
        return ArrayDecoders.decodePackedVarint64List(r15, r16, r11, r27);
    L53:
        if (r20 == 2) goto L97;
        if (r20 != 5) goto L112;
        return ArrayDecoders.decodeFloatList(r18, r15, r16, r17, r11, r27);
    L112:
        return r16;
    L97:
        return ArrayDecoders.decodePackedFloatList(r15, r16, r11, r27);
    L57:
        if (r20 == 2) goto L99;
        if (r20 != 1) goto L113;
        return ArrayDecoders.decodeDoubleList(r18, r15, r16, r17, r11, r27);
    L113:
        return r16;
    L99:
        return ArrayDecoders.decodePackedDoubleList(r15, r16, r11, r27);
    L9:
        if (r20 != 3) goto L62;
        return ArrayDecoders.decodeGroupList(getMessageFieldSchema(r21), r18, r15, r16, r17, r11, r27);
    L62:
        return r16;
    L114:
        return r16;
    }

    private int positionForFieldNumber(int r8) {
        if (r8 >= this.minFieldNumber) goto L5;
        return -1;
    L5:
        if (r8 <= this.maxFieldNumber) goto L7;
        return -1;
    L7:
        return slowPositionForFieldNumber(r8, 0);
    }

    private int presenceMaskAndOffsetAt(int r8) {
        return this.buffer[r8 + 2];
    }

    private <E> void readGroupList(Object r8, long r10, Reader r11, Schema<E> r12, ExtensionRegistryLite r13) {
        r11.readGroupList(this.listFieldSchema.mutableListAt(r8, r10), r12, r13);
    }

    private <E> void readMessageList(Object r8, int r10, Reader r11, Schema<E> r12, ExtensionRegistryLite r13) {
        long r14 = offset(r10);
        r11.readMessageList(this.listFieldSchema.mutableListAt(r8, r14), r12, r13);
    }

    private void readString(Object r8, int r10, Reader r11) {
        if (isEnforceUtf8(r10) == false) goto L6;
        long r12 = offset(r10);
        Object r13 = r11.readStringRequireUtf8();
    L5:
        UnsafeUtil.putObject(r8, r12, r13);
        return;
    L6:
        boolean r14 = this.lite;
        r12 = offset(r10);
        if (r14 == false) goto L9;
        r13 = r11.readString();
        goto L5
    L9:
        r13 = r11.readBytes();
        goto L5
    }

    private void readStringList(Object r8, int r10, Reader r11) {
        boolean r12 = isEnforceUtf8(r10);
        ListFieldSchema r13 = this.listFieldSchema;
        if (r12 == false) goto L5;
        r11.readStringListRequireUtf8(r13.mutableListAt(r8, offset(r10)));
        return;
    L5:
        r11.readStringList(r13.mutableListAt(r8, offset(r10)));
    }

    private static java.lang.reflect.Field reflectField(Class<?> r8, String r10) {
        return r8.getDeclaredField(r10);
    L4:
        e = move-exception;
        java.lang.reflect.Field[] r11 = r8.getDeclaredFields();
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        java.lang.reflect.Field r14 = r11[r13];
        if (r10.equals(r14.getName()) == true) goto L9;
        r13 = r13 + 1;
        goto L6
    L9:
        return r14;
    L11:
        StringBuilder r15 = defpackage.b.h("Field ", r10, " for ");
        r15.append(r8.getName());
        r15.append(" not found. Known fields are ");
        r15.append(Arrays.toString(r11));
        throw new RuntimeException(r15.toString(), e);
    }

    private void setFieldPresent(T r8, int r10) {
        int r11 = presenceMaskAndOffsetAt(r10);
        long r12 = 1048575 & r11;
        if (r12 != 1048575) goto L5;
        return;
    L5:
        UnsafeUtil.putInt(r8, r12, (1 << (r11 >>> 20)) | UnsafeUtil.getInt(r8, r12));
    }

    private void setOneofPresent(T r8, int r10, int r11) {
        UnsafeUtil.putInt(r8, presenceMaskAndOffsetAt(r11) & 1048575, r10);
    }

    private int slowPositionForFieldNumber(int r8, int r10) {
        int r11 = (this.buffer.length / 3) - 1;
    L3:
        if (r10 > r11) goto L10;
        int r12 = (r11 + r10) >>> 1;
        int r13 = r12 * 3;
        int r14 = numberAt(r13);
        if (r8 == r14) goto L6;
        if (r8 < r14) goto L8;
        r10 = r12 + 1;
        goto L3
    L8:
        r11 = r12 - 1;
        goto L3
    L6:
        return r13;
    L10:
        return -1;
    }

    private static void storeFieldData(FieldInfo r8, int[] r10, int r11, Object[] r12) {
        OneofInfo r13 = r8.getOneof();
        int r14 = 0;
        if (r13 == null) goto L6;
        int r15 = r8.getType().id() + 51;
        int r16 = (int) UnsafeUtil.objectFieldOffset(r13.getValueField());
        java.lang.reflect.Field r17 = r13.getCaseField();
    L5:
        int r18 = (int) UnsafeUtil.objectFieldOffset(r17);
        int r19 = 0;
    L19:
        r10[r11] = r8.getFieldNumber();
        int r20 = r11 + 1;
        if (r8.isEnforceUtf8() == false) goto L22;
        int r21 = ENFORCE_UTF8_MASK;
    L24:
        if (r8.isRequired() == false) goto L26;
        r14 = REQUIRED_MASK;
    L26:
        r10[r20] = ((r14 | r21) | (r15 << 20)) | r16;
        r10[r11 + 2] = r18 | (r19 << 20);
        Class<?> r22 = r8.getMessageFieldClass();
        if (r8.getMapDefaultEntry() == null) goto L34;
        int r110 = (r11 / 3) * 2;
        r12[r110] = r8.getMapDefaultEntry();
        if (r22 == null) goto L32;
        r12[r110 + 1] = r22;
        return;
    L32:
        if (r8.getEnumVerifier() == null) goto L41;
        r12[r110 + 1] = r8.getEnumVerifier();
        return;
    L41:
        return;
    L34:
        if (r22 == null) goto L37;
        r12[((r11 / 3) * 2) + 1] = r22;
        return;
    L37:
        if (r8.getEnumVerifier() == null) goto L44;
        r12[((r11 / 3) * 2) + 1] = r8.getEnumVerifier();
        return;
    L44:
        return;
    L22:
        r21 = 0;
        goto L24
    L6:
        FieldType r23 = r8.getType();
        r16 = (int) UnsafeUtil.objectFieldOffset(r8.getField());
        r15 = r23.id();
        if (r23.isList() == true) goto L16;
        if (r23.isMap() == true) goto L16;
        java.lang.reflect.Field r24 = r8.getPresenceField();
        if (r24 != null) goto L13;
        r18 = 1048575;
    L14:
        r19 = Integer.numberOfTrailingZeros(r8.getPresenceMask());
        goto L19
    L13:
        r18 = (int) UnsafeUtil.objectFieldOffset(r24);
    L16:
        if (r8.getCachedSizeField() != null) goto L18;
        r18 = 0;
        r19 = 0;
        goto L19
    L18:
        r17 = r8.getCachedSizeField();
        goto L5
    }

    private void storeMessageField(T r8, int r10, Object r11) {
        UNSAFE.putObject(r8, offset(typeAndOffsetAt(r10)), r11);
        setFieldPresent(r8, r10);
    }

    private void storeOneofMessageField(T r8, int r10, int r11, Object r12) {
        UNSAFE.putObject(r8, offset(typeAndOffsetAt(r11)), r12);
        setOneofPresent(r8, r10, r11);
    }

    private static int type(int r8) {
        return (r8 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int r8) {
        return this.buffer[r8 + 1];
    }

    private void writeFieldsInAscendingOrder(T r22, Writer r23) {
        if (this.hasExtensions == false) goto L7;
        FieldSet<T> r8 = this.extensionSchema.getExtensions(r22);
        if (r8.isEmpty() == true) goto L7;
        Iterator r10 = r8.iterator();
        Map.Entry<?, ?> r11 = (Map.Entry) r10.next();
        Iterator r12 = r10;
    L8:
        int r13 = this.buffer.length;
        Unsafe r14 = UNSAFE;
        int r15 = 1048575;
        int r16 = 1048575;
        int r17 = 0;
        int r18 = 0;
    L9:
        if (r18 >= r13) goto L175;
        int r19 = typeAndOffsetAt(r18);
        int r20 = numberAt(r18);
        int r21 = type(r19);
        if (r21 > 17) goto L19;
        int r24 = this.buffer[r18 + 2];
        int r110 = r24 & r15;
        Map.Entry<?, ?> r111 = r11;
        if (r110 == r16) goto L18;
        if (r110 != r15) goto L16;
        r17 = 0;
    L17:
        r16 = r110;
        goto L18
    L16:
        r17 = r14.getInt(r22, r110);
    L18:
        int r25 = 1 << (r24 >>> 20);
        int r26 = r16;
        int r112 = r25;
        Map.Entry<?, ?> r113 = r111;
    L20:
        int r114 = r17;
    L21:
        if (r113 == null) goto L28;
        if (this.extensionSchema.extensionNumber(r113) > r20) goto L28;
        this.extensionSchema.serializeExtension(r23, r113);
        if (r12.hasNext() == true) goto L26;
        r113 = null;
        goto L21
    L26:
        r113 = (Map.Entry) r12.next();
    L28:
        long r27 = offset(r19);
        switch(r21) {
            case 0: goto L170;
            case 1: goto L167;
            case 2: goto L164;
            case 3: goto L161;
            case 4: goto L158;
            case 5: goto L155;
            case 6: goto L152;
            case 7: goto L149;
            case 8: goto L146;
            case 9: goto L143;
            case 10: goto L140;
            case 11: goto L137;
            case 12: goto L134;
            case 13: goto L131;
            case 14: goto L128;
            case 15: goto L125;
            case 16: goto L122;
            case 17: goto L119;
            case 18: goto L117;
            case 19: goto L116;
            case 20: goto L115;
            case 21: goto L114;
            case 22: goto L113;
            case 23: goto L112;
            case 24: goto L111;
            case 25: goto L110;
            case 26: goto L109;
            case 27: goto L108;
            case 28: goto L107;
            case 29: goto L106;
            case 30: goto L105;
            case 31: goto L104;
            case 32: goto L103;
            case 33: goto L102;
            case 34: goto L101;
            case 35: goto L100;
            case 36: goto L99;
            case 37: goto L98;
            case 38: goto L97;
            case 39: goto L96;
            case 40: goto L95;
            case 41: goto L94;
            case 42: goto L93;
            case 43: goto L92;
            case 44: goto L91;
            case 45: goto L90;
            case 46: goto L89;
            case 47: goto L88;
            case 48: goto L87;
            case 49: goto L86;
            case 50: goto L85;
            case 51: goto L83;
            case 52: goto L80;
            case 53: goto L77;
            case 54: goto L74;
            case 55: goto L71;
            case 56: goto L68;
            case 57: goto L65;
            case 58: goto L62;
            case 59: goto L59;
            case 60: goto L56;
            case 61: goto L53;
            case 62: goto L50;
            case 63: goto L47;
            case 64: goto L44;
            case 65: goto L41;
            case 66: goto L38;
            case 67: goto L35;
            case 68: goto L32;
            default: goto L30;
        };
    L30:
        int r28 = r13;
        Map.Entry<?, ?> r115 = r113;
    L173:
        r18 = r18 + 3;
        r16 = r26;
        r11 = r115;
        r17 = r114;
        r13 = r28;
        r15 = 1048575;
        goto L9
    L85:
        writeMapHelper(r23, r20, r14.getObject(r22, r27), r18);
        goto L30
    L86:
        SchemaUtil.writeGroupList(numberAt(r18), (List) r14.getObject(r22, r27), r23, getMessageFieldSchema(r18));
        goto L30
    L87:
        SchemaUtil.writeSInt64List(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L88:
        SchemaUtil.writeSInt32List(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L89:
        SchemaUtil.writeSFixed64List(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L90:
        SchemaUtil.writeSFixed32List(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L91:
        SchemaUtil.writeEnumList(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L92:
        SchemaUtil.writeUInt32List(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L93:
        SchemaUtil.writeBoolList(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L94:
        SchemaUtil.writeFixed32List(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L95:
        SchemaUtil.writeFixed64List(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L96:
        SchemaUtil.writeInt32List(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L97:
        SchemaUtil.writeUInt64List(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L98:
        SchemaUtil.writeInt64List(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L99:
        SchemaUtil.writeFloatList(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L100:
        SchemaUtil.writeDoubleList(numberAt(r18), (List) r14.getObject(r22, r27), r23, true);
        goto L30
    L101:
        boolean r29 = false;
        SchemaUtil.writeSInt64List(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
    L118:
        r28 = r13;
        r115 = r113;
        goto L173
    L102:
        r29 = false;
        SchemaUtil.writeSInt32List(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L103:
        r29 = false;
        SchemaUtil.writeSFixed64List(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L104:
        r29 = false;
        SchemaUtil.writeSFixed32List(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L105:
        r29 = false;
        SchemaUtil.writeEnumList(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L106:
        r29 = false;
        SchemaUtil.writeUInt32List(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L107:
        SchemaUtil.writeBytesList(numberAt(r18), (List) r14.getObject(r22, r27), r23);
        goto L30
    L108:
        SchemaUtil.writeMessageList(numberAt(r18), (List) r14.getObject(r22, r27), r23, getMessageFieldSchema(r18));
        goto L30
    L109:
        SchemaUtil.writeStringList(numberAt(r18), (List) r14.getObject(r22, r27), r23);
        goto L30
    L110:
        r29 = false;
        SchemaUtil.writeBoolList(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L111:
        r29 = false;
        SchemaUtil.writeFixed32List(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L112:
        r29 = false;
        SchemaUtil.writeFixed64List(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L113:
        r29 = false;
        SchemaUtil.writeInt32List(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L114:
        r29 = false;
        SchemaUtil.writeUInt64List(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L115:
        r29 = false;
        SchemaUtil.writeInt64List(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L116:
        r29 = false;
        SchemaUtil.writeFloatList(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L117:
        r29 = false;
        SchemaUtil.writeDoubleList(numberAt(r18), (List) r14.getObject(r22, r27), r23, false);
        goto L118
    L119:
        r115 = r113;
        r28 = r13;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeGroup(r20, r14.getObject(r22, r27), getMessageFieldSchema(r18));
        goto L173
    L122:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeSInt64(r20, r14.getLong(r22, r27));
        goto L173
    L125:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeSInt32(r20, r14.getInt(r22, r27));
        goto L173
    L128:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeSFixed64(r20, r14.getLong(r22, r27));
        goto L173
    L131:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeSFixed32(r20, r14.getInt(r22, r27));
        goto L173
    L134:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeEnum(r20, r14.getInt(r22, r27));
        goto L173
    L137:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeUInt32(r20, r14.getInt(r22, r27));
        goto L173
    L140:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeBytes(r20, (ByteString) r14.getObject(r22, r27));
        goto L173
    L143:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeMessage(r20, r14.getObject(r22, r27), getMessageFieldSchema(r18));
        goto L173
    L146:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        writeString(r20, r14.getObject(r22, r27), r23);
        goto L173
    L149:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeBool(r20, booleanAt(r22, r27));
        goto L173
    L152:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeFixed32(r20, r14.getInt(r22, r27));
        goto L173
    L155:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeFixed64(r20, r14.getLong(r22, r27));
        goto L173
    L158:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeInt32(r20, r14.getInt(r22, r27));
        goto L173
    L161:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeUInt64(r20, r14.getLong(r22, r27));
        goto L173
    L164:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeInt64(r20, r14.getLong(r22, r27));
        goto L173
    L167:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeFloat(r20, floatAt(r22, r27));
        goto L173
    L170:
        r28 = r13;
        r115 = r113;
        if (isFieldPresent(r22, r18, r26, r114, r112) == false) goto L173;
        r23.writeDouble(r20, doubleAt(r22, r27));
        goto L173
    L32:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeGroup(r20, r14.getObject(r22, r27), getMessageFieldSchema(r18));
        goto L30
    L35:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeSInt64(r20, oneofLongAt(r22, r27));
        goto L30
    L38:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeSInt32(r20, oneofIntAt(r22, r27));
        goto L30
    L41:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeSFixed64(r20, oneofLongAt(r22, r27));
        goto L30
    L44:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeSFixed32(r20, oneofIntAt(r22, r27));
        goto L30
    L47:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeEnum(r20, oneofIntAt(r22, r27));
        goto L30
    L50:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeUInt32(r20, oneofIntAt(r22, r27));
        goto L30
    L53:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeBytes(r20, (ByteString) r14.getObject(r22, r27));
        goto L30
    L56:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeMessage(r20, r14.getObject(r22, r27), getMessageFieldSchema(r18));
        goto L30
    L59:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        writeString(r20, r14.getObject(r22, r27), r23);
        goto L30
    L62:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeBool(r20, oneofBooleanAt(r22, r27));
        goto L30
    L65:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeFixed32(r20, oneofIntAt(r22, r27));
        goto L30
    L68:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeFixed64(r20, oneofLongAt(r22, r27));
        goto L30
    L71:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeInt32(r20, oneofIntAt(r22, r27));
        goto L30
    L74:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeUInt64(r20, oneofLongAt(r22, r27));
        goto L30
    L77:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeInt64(r20, oneofLongAt(r22, r27));
        goto L30
    L80:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeFloat(r20, oneofFloatAt(r22, r27));
        goto L30
    L83:
        if (isOneofPresent(r22, r20, r18) == false) goto L30;
        r23.writeDouble(r20, oneofDoubleAt(r22, r27));
        goto L30
    L19:
        r26 = r16;
        r113 = r11;
        r112 = 0;
    L175:
        if (r11 == null) goto L180;
        this.extensionSchema.serializeExtension(r23, r11);
        if (r12.hasNext() == true) goto L178;
        r11 = null;
        goto L175
    L178:
        r11 = (Map.Entry) r12.next();
        goto L175
    L180:
        writeUnknownInMessageTo(this.unknownFieldSchema, r22, r23);
        return;
    L7:
        r11 = null;
        r12 = null;
        goto L8
    }

    private void writeFieldsInDescendingOrder(T r11, Writer r12) {
        writeUnknownInMessageTo(this.unknownFieldSchema, r11, r12);
        if (this.hasExtensions == false) goto L7;
        FieldSet<T> r8 = this.extensionSchema.getExtensions(r11);
        if (r8.isEmpty() == true) goto L7;
        Iterator r10 = r8.descendingIterator();
        Map.Entry<?, ?> r13 = (Map.Entry) r10.next();
    L8:
        int r14 = this.buffer.length - 3;
    L9:
        if (r14 < 0) goto L177;
        int r15 = typeAndOffsetAt(r14);
        int r16 = numberAt(r14);
    L11:
        if (r13 == null) goto L19;
        if (this.extensionSchema.extensionNumber(r13) <= r16) goto L19;
        this.extensionSchema.serializeExtension(r12, r13);
        if (r10.hasNext() == true) goto L16;
        r13 = null;
        goto L11
    L16:
        r13 = (Map.Entry) r10.next();
    L19:
        switch(type(r15)) {
            case 0: goto L173;
            case 1: goto L169;
            case 2: goto L165;
            case 3: goto L161;
            case 4: goto L157;
            case 5: goto L153;
            case 6: goto L149;
            case 7: goto L145;
            case 8: goto L142;
            case 9: goto L139;
            case 10: goto L136;
            case 11: goto L132;
            case 12: goto L128;
            case 13: goto L124;
            case 14: goto L120;
            case 15: goto L116;
            case 16: goto L112;
            case 17: goto L109;
            case 18: goto L107;
            case 19: goto L106;
            case 20: goto L105;
            case 21: goto L104;
            case 22: goto L103;
            case 23: goto L102;
            case 24: goto L101;
            case 25: goto L100;
            case 26: goto L99;
            case 27: goto L98;
            case 28: goto L97;
            case 29: goto L96;
            case 30: goto L95;
            case 31: goto L94;
            case 32: goto L93;
            case 33: goto L92;
            case 34: goto L91;
            case 35: goto L90;
            case 36: goto L89;
            case 37: goto L88;
            case 38: goto L87;
            case 39: goto L86;
            case 40: goto L85;
            case 41: goto L84;
            case 42: goto L83;
            case 43: goto L82;
            case 44: goto L81;
            case 45: goto L80;
            case 46: goto L79;
            case 47: goto L78;
            case 48: goto L77;
            case 49: goto L76;
            case 50: goto L75;
            case 51: goto L73;
            case 52: goto L70;
            case 53: goto L67;
            case 54: goto L64;
            case 55: goto L61;
            case 56: goto L58;
            case 57: goto L55;
            case 58: goto L52;
            case 59: goto L49;
            case 60: goto L46;
            case 61: goto L43;
            case 62: goto L40;
            case 63: goto L37;
            case 64: goto L34;
            case 65: goto L31;
            case 66: goto L28;
            case 67: goto L25;
            case 68: goto L22;
            default: goto L176;
        };
    L75:
        writeMapHelper(r12, r16, UnsafeUtil.getObject(r11, offset(r15)), r14);
        goto L176
    L76:
        SchemaUtil.writeGroupList(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, getMessageFieldSchema(r14));
        goto L176
    L77:
        SchemaUtil.writeSInt64List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L78:
        SchemaUtil.writeSInt32List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L79:
        SchemaUtil.writeSFixed64List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L80:
        SchemaUtil.writeSFixed32List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L81:
        SchemaUtil.writeEnumList(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L82:
        SchemaUtil.writeUInt32List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L83:
        SchemaUtil.writeBoolList(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L84:
        SchemaUtil.writeFixed32List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L85:
        SchemaUtil.writeFixed64List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L86:
        SchemaUtil.writeInt32List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L87:
        SchemaUtil.writeUInt64List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L88:
        SchemaUtil.writeInt64List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L89:
        SchemaUtil.writeFloatList(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L90:
        SchemaUtil.writeDoubleList(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, true);
        goto L176
    L91:
        SchemaUtil.writeSInt64List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L92:
        SchemaUtil.writeSInt32List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L93:
        SchemaUtil.writeSFixed64List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L94:
        SchemaUtil.writeSFixed32List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L95:
        SchemaUtil.writeEnumList(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L96:
        SchemaUtil.writeUInt32List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L97:
        SchemaUtil.writeBytesList(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12);
        goto L176
    L98:
        SchemaUtil.writeMessageList(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, getMessageFieldSchema(r14));
        goto L176
    L99:
        SchemaUtil.writeStringList(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12);
        goto L176
    L100:
        SchemaUtil.writeBoolList(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L101:
        SchemaUtil.writeFixed32List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L102:
        SchemaUtil.writeFixed64List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L103:
        SchemaUtil.writeInt32List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L104:
        SchemaUtil.writeUInt64List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L105:
        SchemaUtil.writeInt64List(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L106:
        SchemaUtil.writeFloatList(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L107:
        SchemaUtil.writeDoubleList(r16, (List) UnsafeUtil.getObject(r11, offset(r15)), r12, false);
        goto L176
    L22:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
    L110:
        r12.writeGroup(r16, UnsafeUtil.getObject(r11, offset(r15)), getMessageFieldSchema(r14));
        goto L176
    L25:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        long r17 = oneofLongAt(r11, offset(r15));
    L114:
        r12.writeSInt64(r16, r17);
        goto L176
    L28:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        int r18 = oneofIntAt(r11, offset(r15));
    L118:
        r12.writeSInt32(r16, r18);
        goto L176
    L31:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        long r19 = oneofLongAt(r11, offset(r15));
    L122:
        r12.writeSFixed64(r16, r19);
        goto L176
    L34:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        int r20 = oneofIntAt(r11, offset(r15));
    L126:
        r12.writeSFixed32(r16, r20);
        goto L176
    L37:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        int r21 = oneofIntAt(r11, offset(r15));
    L130:
        r12.writeEnum(r16, r21);
        goto L176
    L40:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        int r22 = oneofIntAt(r11, offset(r15));
    L134:
        r12.writeUInt32(r16, r22);
        goto L176
    L43:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
    L137:
        r12.writeBytes(r16, (ByteString) UnsafeUtil.getObject(r11, offset(r15)));
        goto L176
    L46:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
    L140:
        r12.writeMessage(r16, UnsafeUtil.getObject(r11, offset(r15)), getMessageFieldSchema(r14));
        goto L176
    L49:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
    L143:
        writeString(r16, UnsafeUtil.getObject(r11, offset(r15)), r12);
        goto L176
    L52:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        boolean r23 = oneofBooleanAt(r11, offset(r15));
    L147:
        r12.writeBool(r16, r23);
        goto L176
    L55:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        int r24 = oneofIntAt(r11, offset(r15));
    L151:
        r12.writeFixed32(r16, r24);
        goto L176
    L58:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        long r25 = oneofLongAt(r11, offset(r15));
    L155:
        r12.writeFixed64(r16, r25);
        goto L176
    L61:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        int r26 = oneofIntAt(r11, offset(r15));
    L159:
        r12.writeInt32(r16, r26);
        goto L176
    L64:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        long r27 = oneofLongAt(r11, offset(r15));
    L163:
        r12.writeUInt64(r16, r27);
        goto L176
    L67:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        long r28 = oneofLongAt(r11, offset(r15));
    L167:
        r12.writeInt64(r16, r28);
        goto L176
    L70:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        float r29 = oneofFloatAt(r11, offset(r15));
    L171:
        r12.writeFloat(r16, r29);
        goto L176
    L73:
        if (isOneofPresent(r11, r16, r14) == false) goto L176;
        double r30 = oneofDoubleAt(r11, offset(r15));
    L175:
        r12.writeDouble(r16, r30);
        goto L176
    L109:
        if (isFieldPresent(r11, r14) == false) goto L176;
    L112:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r17 = longAt(r11, offset(r15));
        goto L114
    L116:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r18 = intAt(r11, offset(r15));
        goto L118
    L120:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r19 = longAt(r11, offset(r15));
        goto L122
    L124:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r20 = intAt(r11, offset(r15));
        goto L126
    L128:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r21 = intAt(r11, offset(r15));
        goto L130
    L132:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r22 = intAt(r11, offset(r15));
        goto L134
    L136:
        if (isFieldPresent(r11, r14) == false) goto L176;
    L139:
        if (isFieldPresent(r11, r14) == false) goto L176;
    L142:
        if (isFieldPresent(r11, r14) == false) goto L176;
    L145:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r23 = booleanAt(r11, offset(r15));
        goto L147
    L149:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r24 = intAt(r11, offset(r15));
        goto L151
    L153:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r25 = longAt(r11, offset(r15));
        goto L155
    L157:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r26 = intAt(r11, offset(r15));
        goto L159
    L161:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r27 = longAt(r11, offset(r15));
        goto L163
    L165:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r28 = longAt(r11, offset(r15));
        goto L167
    L169:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r29 = floatAt(r11, offset(r15));
        goto L171
    L173:
        if (isFieldPresent(r11, r14) == false) goto L176;
        r30 = doubleAt(r11, offset(r15));
    L176:
        r14 = r14 - 3;
    L177:
        if (r13 == null) goto L182;
        this.extensionSchema.serializeExtension(r12, r13);
        if (r10.hasNext() == true) goto L180;
        r13 = null;
        goto L177
    L180:
        r13 = (Map.Entry) r10.next();
        goto L177
    L182:
        return;
    L7:
        r10 = null;
        r13 = null;
        goto L8
    }

    private <K, V> void writeMapHelper(Writer r8, int r10, Object r11, int r12) {
        if (r11 == null) goto L5;
        r8.writeMap(r10, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(r12)), this.mapFieldSchema.forMapData(r11));
        return;
    }

    private void writeString(int r8, Object r10, Writer r11) {
        if ((r10 instanceof String) == false) goto L5;
        r11.writeString(r8, (String) r10);
        return;
    L5:
        r11.writeBytes(r8, (ByteString) r10);
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> r8, T r10, Writer r11) {
        r8.writeTo(r8.getFromMessage(r10), r11);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T r8, T r10) {
        int r11 = this.buffer.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (equals(r8, r10, r12) == false) goto L6;
        r12 = r12 + 3;
        goto L3
    L6:
        return false;
    L9:
        if (this.unknownFieldSchema.getFromMessage(r8).equals(this.unknownFieldSchema.getFromMessage(r10)) == true) goto L12;
        return false;
    L12:
        if (this.hasExtensions == true) goto L14;
        return true;
    L14:
        return this.extensionSchema.getExtensions(r8).equals(this.extensionSchema.getExtensions(r10));
    }

    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v193 */
    /* JADX WARN: Type inference failed for: r0v195 */
    /* JADX WARN: Type inference failed for: r0v197 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v76 */
    /* JADX WARN: Type inference failed for: r1v77 */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v16 */
    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T r19) {
        Unsafe r8 = UNSAFE;
        ?? r10 = 0;
        int r11 = 1048575;
        ?? r12 = 0;
        int r13 = 0;
        int r14 = 0;
        int r15 = 1048575;
    L4:
        if (r13 >= this.buffer.length) goto L233;
        int r16 = typeAndOffsetAt(r13);
        int r17 = type(r16);
        int r18 = numberAt(r13);
        int r20 = this.buffer[r13 + 2];
        int r21 = r20 & r11;
        int r22 = r15;
        ?? r23 = r12;
        if (r17 > 17) goto L13;
        if (r21 == r15) goto L12;
        if (r21 != r11) goto L10;
        ?? r24 = r10;
    L11:
        r23 = r24;
        r22 = r21 == true ? 1 : 0;
        goto L12
    L10:
        r24 = r8.getInt(r19, r21 == true ? 1 : 0);
    L12:
        int r110 = r22;
        ?? r111 = r23;
        ?? r112 = 1 << (r20 >>> 20);
    L14:
        long r25 = offset(r16);
        if (r17 < FieldType.DOUBLE_LIST_PACKED.id()) goto L19;
        ?? r26 = r21;
        if (r17 > FieldType.SINT64_LIST_PACKED.id()) goto L19;
    L20:
        ?? r27 = r26;
        switch(r17) {
            case 0: goto L228;
            case 1: goto L225;
            case 2: goto L222;
            case 3: goto L219;
            case 4: goto L216;
            case 5: goto L213;
            case 6: goto L211;
            case 7: goto L206;
            case 8: goto L199;
            case 9: goto L195;
            case 10: goto L192;
            case 11: goto L189;
            case 12: goto L186;
            case 13: goto L183;
            case 14: goto L180;
            case 15: goto L177;
            case 16: goto L174;
            case 17: goto L171;
            case 18: goto L167;
            case 19: goto L166;
            case 20: goto L165;
            case 21: goto L164;
            case 22: goto L163;
            case 23: goto L167;
            case 24: goto L166;
            case 25: goto L162;
            case 26: goto L161;
            case 27: goto L160;
            case 28: goto L159;
            case 29: goto L158;
            case 30: goto L157;
            case 31: goto L166;
            case 32: goto L167;
            case 33: goto L156;
            case 34: goto L155;
            case 35: goto L149;
            case 36: goto L144;
            case 37: goto L139;
            case 38: goto L134;
            case 39: goto L129;
            case 40: goto L124;
            case 41: goto L119;
            case 42: goto L114;
            case 43: goto L109;
            case 44: goto L104;
            case 45: goto L99;
            case 46: goto L94;
            case 47: goto L89;
            case 48: goto L84;
            case 49: goto L83;
            case 50: goto L82;
            case 51: goto L79;
            case 52: goto L76;
            case 53: goto L73;
            case 54: goto L70;
            case 55: goto L67;
            case 56: goto L64;
            case 57: goto L61;
            case 58: goto L58;
            case 59: goto L51;
            case 60: goto L48;
            case 61: goto L45;
            case 62: goto L42;
            case 63: goto L39;
            case 64: goto L36;
            case 65: goto L33;
            case 66: goto L30;
            case 67: goto L27;
            case 68: goto L24;
            default: goto L169;
        };
    L82:
        int r28 = this.mapFieldSchema.getSerializedSize(r18, r8.getObject(r19, r25), getMapFieldDefaultEntry(r13));
    L168:
        r14 = r14 + r28;
        goto L169
    L83:
        r28 = SchemaUtil.computeSizeGroupList(r18, (List) r8.getObject(r19, r25), getMessageFieldSchema(r13));
        goto L168
    L84:
        int r29 = SchemaUtil.computeSizeSInt64ListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == true) goto L153;
    L154:
        r14 = r14 + ((CodedOutputStream.computeUInt32SizeNoTag(r29) + CodedOutputStream.computeTagSize(r18)) + r29);
    L153:
        r8.putInt(r19, r27 == true ? 1 : 0, r29);
        goto L154
    L89:
        r29 = SchemaUtil.computeSizeSInt32ListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L94:
        r29 = SchemaUtil.computeSizeFixed64ListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L99:
        r29 = SchemaUtil.computeSizeFixed32ListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L104:
        r29 = SchemaUtil.computeSizeEnumListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L109:
        r29 = SchemaUtil.computeSizeUInt32ListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L114:
        r29 = SchemaUtil.computeSizeBoolListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L119:
        r29 = SchemaUtil.computeSizeFixed32ListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L124:
        r29 = SchemaUtil.computeSizeFixed64ListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L129:
        r29 = SchemaUtil.computeSizeInt32ListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L134:
        r29 = SchemaUtil.computeSizeUInt64ListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L139:
        r29 = SchemaUtil.computeSizeInt64ListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L144:
        r29 = SchemaUtil.computeSizeFixed32ListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L149:
        r29 = SchemaUtil.computeSizeFixed64ListNoTag((List) r8.getObject(r19, r25));
        if (r29 <= 0) goto L169;
        if (this.useCachedSizeField == false) goto L154;
    L155:
        r28 = SchemaUtil.computeSizeSInt64List(r18, (List) r8.getObject(r19, r25), r10);
        goto L168
    L156:
        r28 = SchemaUtil.computeSizeSInt32List(r18, (List) r8.getObject(r19, r25), r10);
        goto L168
    L157:
        r28 = SchemaUtil.computeSizeEnumList(r18, (List) r8.getObject(r19, r25), r10);
        goto L168
    L158:
        r28 = SchemaUtil.computeSizeUInt32List(r18, (List) r8.getObject(r19, r25), r10);
        goto L168
    L159:
        r28 = SchemaUtil.computeSizeByteStringList(r18, (List) r8.getObject(r19, r25));
        goto L168
    L160:
        r28 = SchemaUtil.computeSizeMessageList(r18, (List) r8.getObject(r19, r25), getMessageFieldSchema(r13));
        goto L168
    L161:
        r28 = SchemaUtil.computeSizeStringList(r18, (List) r8.getObject(r19, r25));
        goto L168
    L162:
        r28 = SchemaUtil.computeSizeBoolList(r18, (List) r8.getObject(r19, r25), r10);
        goto L168
    L163:
        r28 = SchemaUtil.computeSizeInt32List(r18, (List) r8.getObject(r19, r25), r10);
        goto L168
    L164:
        r28 = SchemaUtil.computeSizeUInt64List(r18, (List) r8.getObject(r19, r25), r10);
        goto L168
    L165:
        r28 = SchemaUtil.computeSizeInt64List(r18, (List) r8.getObject(r19, r25), r10);
        goto L168
    L166:
        r28 = SchemaUtil.computeSizeFixed32List(r18, (List) r8.getObject(r19, r25), r10);
        goto L168
    L167:
        r28 = SchemaUtil.computeSizeFixed64List(r18, (List) r8.getObject(r19, r25), r10);
        goto L168
    L213:
        ?? r113 = r10;
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L232;
        int r30 = CodedOutputStream.computeFixed64Size(r18, 0);
        r113 = r113;
    L231:
        r14 = r14 + r30;
    L232:
        r13 = r13 + 3;
        r15 = r110;
        r10 = r113;
        r12 = r111;
        r11 = 1048575;
        goto L4
    L216:
        r113 = r10;
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L232;
        r30 = CodedOutputStream.computeInt32Size(r18, r8.getInt(r19, r25));
        r113 = r113;
        goto L231
    L219:
        r113 = r10;
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L232;
        r30 = CodedOutputStream.computeUInt64Size(r18, r8.getLong(r19, r25));
        r113 = r113;
        goto L231
    L222:
        r113 = r10;
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L232;
        r30 = CodedOutputStream.computeInt64Size(r18, r8.getLong(r19, r25));
        r113 = r113;
        goto L231
    L225:
        r113 = r10;
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L232;
        r30 = CodedOutputStream.computeFloatSize(r18, 0.0f);
        r113 = r113;
        goto L231
    L228:
        r113 = r10;
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L232;
        r30 = CodedOutputStream.computeDoubleSize(r18, 0.0d);
        r113 = r113;
    L169:
        r113 = r10;
        goto L232
    L24:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r28 = SchemaUtil.computeGroupSize(r18, (MessageLite) r8.getObject(r19, r25), getMessageFieldSchema(r13));
        goto L168
    L27:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        int r31 = CodedOutputStream.computeSInt64Size(r18, oneofLongAt(r19, r25));
    L81:
        r14 = r14 + r31;
        goto L169
    L30:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeSInt32Size(r18, oneofIntAt(r19, r25));
        goto L81
    L33:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeSFixed64Size(r18, 0);
        goto L81
    L36:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeSFixed32Size(r18, r10);
        goto L81
    L39:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeEnumSize(r18, oneofIntAt(r19, r25));
        goto L81
    L42:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeUInt32Size(r18, oneofIntAt(r19, r25));
        goto L81
    L45:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeBytesSize(r18, (ByteString) r8.getObject(r19, r25));
        goto L81
    L48:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r28 = SchemaUtil.computeSizeMessage(r18, r8.getObject(r19, r25), getMessageFieldSchema(r13));
        goto L168
    L51:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        Object r32 = r8.getObject(r19, r25);
        if ((r32 instanceof ByteString) == false) goto L55;
        int r33 = CodedOutputStream.computeBytesSize(r18, (ByteString) r32);
    L56:
        r14 = r33 + r14;
        goto L169
    L55:
        r33 = CodedOutputStream.computeStringSize(r18, (String) r32);
        goto L56
    L58:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeBoolSize(r18, true);
        goto L81
    L61:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeFixed32Size(r18, r10);
        goto L81
    L64:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeFixed64Size(r18, 0);
        goto L81
    L67:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeInt32Size(r18, oneofIntAt(r19, r25));
        goto L81
    L70:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeUInt64Size(r18, oneofLongAt(r19, r25));
        goto L81
    L73:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeInt64Size(r18, oneofLongAt(r19, r25));
        goto L81
    L76:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeFloatSize(r18, 0.0f);
        goto L81
    L79:
        if (isOneofPresent(r19, r18, r13) == false) goto L169;
        r31 = CodedOutputStream.computeDoubleSize(r18, 0.0d);
        goto L81
    L171:
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L209;
        int r34 = SchemaUtil.computeGroupSize(r18, (MessageLite) r8.getObject(r19, r25), getMessageFieldSchema(r13));
    L197:
        r14 = r14 + r34;
    L209:
        r113 = 0;
        goto L232
    L174:
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L209;
        int r35 = CodedOutputStream.computeSInt64Size(r18, r8.getLong(r19, r25));
    L208:
        r14 = r14 + r35;
        goto L209
    L177:
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L209;
        r35 = CodedOutputStream.computeSInt32Size(r18, r8.getInt(r19, r25));
        goto L208
    L180:
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L209;
        r35 = CodedOutputStream.computeSFixed64Size(r18, 0);
        goto L208
    L183:
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L209;
        r14 = r14 + CodedOutputStream.computeSFixed32Size(r18, 0);
        goto L209
    L186:
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L209;
        r35 = CodedOutputStream.computeEnumSize(r18, r8.getInt(r19, r25));
        goto L208
    L189:
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L209;
        r35 = CodedOutputStream.computeUInt32Size(r18, r8.getInt(r19, r25));
        goto L208
    L192:
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L209;
        r35 = CodedOutputStream.computeBytesSize(r18, (ByteString) r8.getObject(r19, r25));
        goto L208
    L195:
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L209;
        r34 = SchemaUtil.computeSizeMessage(r18, r8.getObject(r19, r25), getMessageFieldSchema(r13));
        goto L197
    L199:
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L209;
        Object r36 = r8.getObject(r19, r25);
        if ((r36 instanceof ByteString) == false) goto L203;
        int r37 = CodedOutputStream.computeBytesSize(r18, (ByteString) r36);
    L204:
        r14 = r37 + r14;
        goto L209
    L203:
        r37 = CodedOutputStream.computeStringSize(r18, (String) r36);
        goto L204
    L206:
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L209;
        r35 = CodedOutputStream.computeBoolSize(r18, true);
        goto L208
    L211:
        if (isFieldPresent(r19, r13, r110 == true ? 1 : 0, r111 == true ? 1 : 0, r112 == true ? 1 : 0) == false) goto L209;
        r113 = 0;
        r30 = CodedOutputStream.computeFixed32Size(r18, 0);
    L19:
        r26 = r10;
        goto L20
    L13:
        r110 = r15 == true ? 1 : 0;
        r111 = r12 == true ? 1 : 0;
        r112 = r10;
        goto L14
    L233:
        int r114 = r14 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, r19);
        if (this.hasExtensions == true) goto L236;
        return r114;
    L236:
        return r114 + this.extensionSchema.getExtensions(r19).getSerializedSize();
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T r10) {
        int r8 = this.buffer.length;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r8) goto L83;
        int r13 = typeAndOffsetAt(r11);
        int r14 = numberAt(r11);
        long r15 = offset(r13);
        int r16 = 37;
        switch(type(r13)) {
            case 0: goto L78;
            case 1: goto L76;
            case 2: goto L75;
            case 3: goto L75;
            case 4: goto L73;
            case 5: goto L75;
            case 6: goto L73;
            case 7: goto L71;
            case 8: goto L70;
            case 9: goto L66;
            case 10: goto L64;
            case 11: goto L73;
            case 12: goto L73;
            case 13: goto L73;
            case 14: goto L75;
            case 15: goto L73;
            case 16: goto L75;
            case 17: goto L61;
            case 18: goto L64;
            case 19: goto L64;
            case 20: goto L64;
            case 21: goto L64;
            case 22: goto L64;
            case 23: goto L64;
            case 24: goto L64;
            case 25: goto L64;
            case 26: goto L64;
            case 27: goto L64;
            case 28: goto L64;
            case 29: goto L64;
            case 30: goto L64;
            case 31: goto L64;
            case 32: goto L64;
            case 33: goto L64;
            case 34: goto L64;
            case 35: goto L64;
            case 36: goto L64;
            case 37: goto L64;
            case 38: goto L64;
            case 39: goto L64;
            case 40: goto L64;
            case 41: goto L64;
            case 42: goto L64;
            case 43: goto L64;
            case 44: goto L64;
            case 45: goto L64;
            case 46: goto L64;
            case 47: goto L64;
            case 48: goto L64;
            case 49: goto L64;
            case 50: goto L64;
            case 51: goto L59;
            case 52: goto L56;
            case 53: goto L53;
            case 54: goto L50;
            case 55: goto L47;
            case 56: goto L44;
            case 57: goto L41;
            case 58: goto L38;
            case 59: goto L35;
            case 60: goto L32;
            case 61: goto L29;
            case 62: goto L26;
            case 63: goto L23;
            case 64: goto L20;
            case 65: goto L17;
            case 66: goto L14;
            case 67: goto L11;
            case 68: goto L8;
            default: goto L82;
        };
    L61:
        Object r17 = UnsafeUtil.getObject(r10, r15);
        if (r17 != null) goto L68;
    L69:
        r12 = (r12 * 53) + r16;
    L68:
        r16 = r17.hashCode();
    L64:
        int r18 = r12 * 53;
        Object r19 = UnsafeUtil.getObject(r10, r15);
    L65:
        int r20 = r19.hashCode();
    L81:
        r12 = r20 + r18;
        goto L82
    L66:
        r17 = UnsafeUtil.getObject(r10, r15);
        if (r17 == null) goto L69;
    L70:
        r18 = r12 * 53;
        r20 = ((String) UnsafeUtil.getObject(r10, r15)).hashCode();
        goto L81
    L71:
        r18 = r12 * 53;
        boolean r21 = UnsafeUtil.getBoolean(r10, r15);
    L72:
        r20 = Internal.hashBoolean(r21);
        goto L81
    L73:
        int r22 = r12 * 53;
        int r23 = UnsafeUtil.getInt(r10, r15);
    L74:
        r12 = r22 + r23;
        goto L82
    L75:
        r18 = r12 * 53;
        long r24 = UnsafeUtil.getLong(r10, r15);
    L80:
        r20 = Internal.hashLong(r24);
        goto L81
    L76:
        r18 = r12 * 53;
        float r25 = UnsafeUtil.getFloat(r10, r15);
    L77:
        r20 = Float.floatToIntBits(r25);
        goto L81
    L78:
        r18 = r12 * 53;
        double r26 = UnsafeUtil.getDouble(r10, r15);
    L79:
        r24 = Double.doubleToLongBits(r26);
        goto L80
    L8:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L33:
        r19 = UnsafeUtil.getObject(r10, r15);
        r18 = r12 * 53;
        goto L65
    L11:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L54:
        r18 = r12 * 53;
        r24 = oneofLongAt(r10, r15);
        goto L80
    L14:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L48:
        r22 = r12 * 53;
        r23 = oneofIntAt(r10, r15);
        goto L74
    L17:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L20:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L23:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L26:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L29:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L32:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L35:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L38:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
        r18 = r12 * 53;
        r21 = oneofBooleanAt(r10, r15);
        goto L72
    L41:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L44:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L47:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L50:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L53:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
    L56:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
        r18 = r12 * 53;
        r25 = oneofFloatAt(r10, r15);
        goto L77
    L59:
        if (isOneofPresent(r10, r14, r11) == false) goto L82;
        r18 = r12 * 53;
        r26 = oneofDoubleAt(r10, r15);
    L82:
        r11 = r11 + 3;
        goto L3
    L83:
        int r27 = this.unknownFieldSchema.getFromMessage(r10).hashCode() + (r12 * 53);
        if (this.hasExtensions == true) goto L86;
        return r27;
    L86:
        return (r27 * 53) + this.extensionSchema.getExtensions(r10).hashCode();
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T r18) {
        int r8 = 1048575;
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= this.checkInitializedCount) goto L49;
        int r12 = this.intArray[r11];
        int r13 = numberAt(r12);
        int r14 = typeAndOffsetAt(r12);
        int r15 = this.buffer[r12 + 2];
        int r16 = r15 & 1048575;
        int r17 = 1 << (r15 >>> 20);
        if (r16 == r8) goto L10;
        if (r16 == 1048575) goto L9;
        r10 = UNSAFE.getInt(r18, r16);
    L9:
        int r19 = r10;
        int r110 = r16;
    L12:
        if (isRequired(r14) == true) goto L14;
    L16:
        int r20 = type(r14);
        if (r20 == 9) goto L43;
        if (r20 == 17) goto L43;
        if (r20 == 27) goto L40;
        if (r20 == 60) goto L35;
        if (r20 == 68) goto L35;
        if (r20 == 49) goto L40;
        if (r20 != 50) goto L47;
        if (isMapInitialized(r18, r14, r12) == true) goto L47;
        return false;
    L47:
        r11 = r11 + 1;
        r8 = r110;
        r10 = r19;
    L35:
        if (isOneofPresent(r18, r13, r12) == false) goto L47;
        if (isInitialized(r18, r14, getMessageFieldSchema(r12)) == true) goto L47;
        return false;
    L40:
        if (isListInitialized(r18, r14, r12) == true) goto L47;
        return false;
    L43:
        if (isFieldPresent(r18, r12, r110, r19, r17) == false) goto L47;
        if (isInitialized(r18, r14, getMessageFieldSchema(r12)) == true) goto L47;
        return false;
    L14:
        if (isFieldPresent(r18, r12, r110, r19, r17) == true) goto L16;
        return false;
    L10:
        r110 = r8;
        r19 = r10;
        goto L12
    L49:
        if (this.hasExtensions == true) goto L51;
    L53:
        return true;
    L51:
        if (this.extensionSchema.getExtensions(r18).isInitialized() == true) goto L53;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Schema
    public void makeImmutable(T r8) {
        if (isMutable(r8) == true) goto L6;
        return;
    L6:
        if ((r8 instanceof GeneratedMessageLite) == false) goto L8;
        GeneratedMessageLite r10 = (GeneratedMessageLite) r8;
        r10.clearMemoizedSerializedSize();
        r10.clearMemoizedHashCode();
        r10.markImmutable();
    L8:
        int r11 = this.buffer.length;
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L29;
        int r13 = typeAndOffsetAt(r12);
        long r14 = offset(r13);
        int r15 = type(r13);
        if (r15 == 9) goto L26;
        if (r15 == 60) goto L23;
        if (r15 == 68) goto L23;
        switch(r15) {
            case 17: goto L26;
            case 18: goto L21;
            case 19: goto L21;
            case 20: goto L21;
            case 21: goto L21;
            case 22: goto L21;
            case 23: goto L21;
            case 24: goto L21;
            case 25: goto L21;
            case 26: goto L21;
            case 27: goto L21;
            case 28: goto L21;
            case 29: goto L21;
            case 30: goto L21;
            case 31: goto L21;
            case 32: goto L21;
            case 33: goto L21;
            case 34: goto L21;
            case 35: goto L21;
            case 36: goto L21;
            case 37: goto L21;
            case 38: goto L21;
            case 39: goto L21;
            case 40: goto L21;
            case 41: goto L21;
            case 42: goto L21;
            case 43: goto L21;
            case 44: goto L21;
            case 45: goto L21;
            case 46: goto L21;
            case 47: goto L21;
            case 48: goto L21;
            case 49: goto L21;
            case 50: goto L18;
            default: goto L28;
        };
    L18:
        Unsafe r16 = UNSAFE;
        Object r17 = r16.getObject(r8, r14);
        if (r17 == null) goto L28;
        r16.putObject(r8, r14, this.mapFieldSchema.toImmutable(r17));
        goto L28
    L21:
        this.listFieldSchema.makeImmutableListAt(r8, r14);
    L28:
        r12 = r12 + 3;
    L23:
        if (isOneofPresent(r8, numberAt(r12), r12) == false) goto L28;
    L27:
        getMessageFieldSchema(r12).makeImmutable(UNSAFE.getObject(r8, r14));
    L26:
        if (isFieldPresent(r8, r12) == false) goto L28;
    L29:
        this.unknownFieldSchema.makeImmutable(r8);
        if (this.hasExtensions == false) goto L41;
        this.extensionSchema.makeImmutable(r8);
        return;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r8, Reader r10, ExtensionRegistryLite r11) {
        if (r11 == null) goto L6;
        checkMutable(r8);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, r8, r10, r11);
        return;
    L6:
        throw null;
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @CanIgnoreReturnValue
    public int parseMessage(T r28, byte[] r29, int r30, int r31, int r32, ArrayDecoders.Registers r33) {
        MessageSchema<T> r15 = this;
        T r14 = r28;
        byte[] r12 = r29;
        r31 = r31;
        r32 = r32;
        ArrayDecoders.Registers r10 = r33;
        checkMutable(r28);
        Unsafe r11 = UNSAFE;
        int r8 = r30;
        int r13 = 0;
        int r16 = 0;
        int r17 = 0;
        int r18 = -1;
        int r19 = 1048575;
    L3:
        if (r8 >= r31) goto L135;
        int r20 = r8 + 1;
        byte r21 = r12[r8];
        if (r21 >= 0) goto L7;
        int r22 = ArrayDecoders.decodeVarint32(r21, r12, r20, r10);
        int r23 = r10.int1;
        r20 = r22;
    L8:
        int r24 = r23 >>> 3;
        int r25 = r23 & 7;
        if (r24 <= r18) goto L11;
        int r26 = r15.positionForFieldNumber(r24, r13 / 3);
    L12:
        int r27 = r26;
        if (r27 == (-1)) goto L14;
        int r34 = r15.buffer[r27 + 1];
        int r35 = type(r34);
        long r110 = offset(r34);
        int r111 = r23;
        if (r35 <= 17) goto L17;
        int r210 = r24;
        int r112 = r19;
        int r113 = r17;
        if (r35 == 27) goto L96;
        int r211 = r112;
        if (r35 > 49) goto L112;
        int r36 = r20;
        Unsafe r212 = r11;
        int r213 = r27;
        int r114 = r111;
        r8 = parseRepeatedField(r28, r29, r20, r31, r111, r210, r25, r27, r34, r35, r110, r33);
        if (r8 == r36) goto L124;
    L111:
        r15 = this;
        r14 = r28;
        r12 = r29;
        r32 = r32;
        r10 = r33;
        r16 = r114;
        r17 = r113;
        r13 = r213;
        r19 = r211;
        r18 = r210;
        r11 = r212;
    L124:
        int r37 = r8;
    L120:
        int r38 = r114;
    L125:
        if (r38 != r32) goto L129;
        if (r32 == 0) goto L129;
        int r39 = 1048575;
        MessageSchema<T> r115 = this;
        int r40 = r37;
        r17 = r113;
        int r41 = r211;
    L136:
        if (r41 == r39) goto L138;
        T r42 = r28;
        r212.putInt(r42, r41, r17);
    L139:
        int r116 = r115.checkInitializedCount;
        UnknownFieldSetLite r43 = null;
    L141:
        if (r116 >= r115.repeatedFieldOffsetStart) goto L143;
        r43 = (UnknownFieldSetLite) filterMapUnknownEnumValues(r28, r115.intArray[r116], r43, r115.unknownFieldSchema, r28);
        r116 = r116 + 1;
        goto L141
    L143:
        if (r43 == null) goto L146;
        r115.unknownFieldSchema.setBuilderToMessage(r42, r43);
    L146:
        if (r32 != 0) goto L151;
        if (r40 != r31) goto L150;
    L153:
        return r40;
    L150:
        throw InvalidProtocolBufferException.parseFailure();
    L151:
        if (r40 > r31) goto L155;
        if (r38 == r32) goto L153;
    L155:
        throw InvalidProtocolBufferException.parseFailure();
    L138:
        r42 = r28;
    L129:
        if (this.hasExtensions == true) goto L131;
    L133:
        r8 = ArrayDecoders.decodeUnknownField(r38, r29, r37, r31, getMutableUnknownFields(r28), r33);
    L134:
        r14 = r28;
        r12 = r29;
        r16 = r38;
        r15 = this;
        r10 = r33;
        r17 = r113;
        r13 = r213;
        r19 = r211;
        r18 = r210;
        r11 = r212;
        r32 = r32;
        goto L3
    L131:
        if (r33.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) goto L133;
        r8 = ArrayDecoders.decodeExtensionOrUnknownField(r38, r29, r37, r31, r28, this.defaultInstance, this.unknownFieldSchema, r33);
        goto L134
    L112:
        int r117 = r20;
        r212 = r11;
        r213 = r27;
        r114 = r111;
        if (r35 == 50) goto L115;
        r8 = parseOneofField(r28, r29, r117, r31, r114, r210, r25, r34, r35, r110, r213, r33);
        if (r8 == r117) goto L124;
    L115:
        if (r25 != 2) goto L119;
        r8 = parseMapField(r28, r29, r117, r31, r213, r110, r33);
        if (r8 == r117) goto L124;
    L119:
        r37 = r117;
        goto L120
    L96:
        if (r25 != 2) goto L106;
        Internal.ProtobufList r44 = (Internal.ProtobufList) r11.getObject(r14, r110);
        if (r44.isModifiable() == true) goto L104;
        int r45 = r44.size();
        if (r45 != 0) goto L102;
        int r46 = 10;
    L103:
        r44 = r44.mutableCopyWithCapacity(r46);
        r11.putObject(r14, r110, r44);
        goto L104
    L102:
        r46 = r45 * 2;
    L104:
        r8 = ArrayDecoders.decodeMessageList(r15.getMessageFieldSchema(r27), r111, r29, r20, r31, r44, r33);
        r32 = r32;
        r13 = r27;
        r16 = r111;
        r17 = r113;
        r19 = r112;
        r18 = r210;
        r12 = r29;
        goto L3
    L106:
        r211 = r112;
        r117 = r20;
        r212 = r11;
        r213 = r27;
        r114 = r111;
        goto L119
    L17:
        int r47 = r15.buffer[r27 + 2];
        int r118 = 1 << (r47 >>> 20);
        int r119 = 1048575;
        int r48 = r47 & 1048575;
        if (r48 == r19) goto L25;
        if (r19 == 1048575) goto L21;
        r11.putInt(r14, r19, r17);
        r119 = 1048575;
    L21:
        if (r48 != r119) goto L23;
        int r49 = 0;
    L24:
        r211 = r48;
        int r120 = r49;
    L27:
        switch(r35) {
            case 0: goto L87;
            case 1: goto L83;
            case 2: goto L79;
            case 3: goto L79;
            case 4: goto L75;
            case 5: goto L72;
            case 6: goto L69;
            case 7: goto L62;
            case 8: goto L56;
            case 9: goto L53;
            case 10: goto L49;
            case 11: goto L75;
            case 12: goto L39;
            case 13: goto L69;
            case 14: goto L72;
            case 15: goto L36;
            case 16: goto L33;
            case 17: goto L30;
            default: goto L28;
        };
    L39:
        byte[] r50 = r29;
        r210 = r24;
        int r51 = r27;
        int r121 = r111;
        byte r122 = -1;
        if (r25 != 0) goto L92;
        r8 = ArrayDecoders.decodeVarint32(r50, r20, r10);
        int r52 = r10.int1;
        Internal.EnumVerifier r53 = r15.getEnumFieldVerifier(r51);
        if (isLegacyEnumIsClosed(r34) == false) goto L48;
        if (r53 == null) goto L48;
        if (r53.isInRange(r52) == true) goto L48;
        getMutableUnknownFields(r28).storeField(r121, Long.valueOf(r52));
        r32 = r32;
        r13 = r51;
        r17 = r120;
        r16 = r121;
        r19 = r211;
        r18 = r210;
        r12 = r50;
    L48:
        r11.putInt(r14, r110, r52);
    L90:
        r17 = r120 | r118;
        r13 = r51;
        r12 = r50;
    L91:
        r16 = r121;
        r19 = r211;
        r18 = r210;
    L92:
        r32 = r32;
        r37 = r20;
        r213 = r51;
        r212 = r11;
        r113 = r120;
        r38 = r121;
        goto L125
    L28:
        r210 = r24;
        r51 = r27;
        r121 = r111;
        r122 = -1;
        goto L92
    L30:
        if (r25 != 3) goto L32;
        Object r54 = r15.mutableMessageFieldForMerge(r14, r27);
        r210 = r24;
        r121 = r111;
        r8 = ArrayDecoders.mergeGroupField(r54, r15.getMessageFieldSchema(r27), r29, r20, r31, (r24 << 3) | 4, r33);
        r15.storeMessageField(r14, r27, r54);
        r17 = r120 | r118;
        r12 = r29;
        r13 = r27;
        goto L91
    L32:
        r210 = r24;
        r121 = r111;
        r122 = -1;
        r51 = r27;
        goto L92
    L33:
        r210 = r24;
        r51 = r27;
        r121 = r111;
        r122 = -1;
        byte[] r55 = r29;
        if (r25 != 0) goto L92;
        int r56 = ArrayDecoders.decodeVarint64(r55, r20, r10);
        long r123 = CodedInputStream.decodeZigZag64(r10.long1);
    L82:
        r11.putLong(r28, r110, r123);
        r17 = r120 | r118;
        r13 = r51;
        r12 = r55;
        r8 = r56;
        goto L91
    L36:
        r50 = r29;
        r210 = r24;
        r51 = r27;
        r121 = r111;
        r122 = -1;
        if (r25 != 0) goto L92;
        r8 = ArrayDecoders.decodeVarint32(r50, r20, r10);
        int r57 = CodedInputStream.decodeZigZag32(r10.int1);
    L78:
        r11.putInt(r14, r110, r57);
        goto L90
    L49:
        r50 = r29;
        r210 = r24;
        r51 = r27;
        r121 = r111;
        long r58 = r110;
        r122 = -1;
        if (r25 != 2) goto L92;
        r8 = ArrayDecoders.decodeBytes(r50, r20, r10);
    L52:
        r11.putObject(r14, r58, r10.object1);
        goto L90
    L53:
        r50 = r29;
        r210 = r24;
        r51 = r27;
        r121 = r111;
        r122 = -1;
        if (r25 != 2) goto L92;
        Object r59 = r15.mutableMessageFieldForMerge(r14, r51);
        r8 = ArrayDecoders.mergeMessageField(r59, r15.getMessageFieldSchema(r51), r29, r20, r31, r33);
        r15.storeMessageField(r14, r51, r59);
        goto L90
    L56:
        r50 = r29;
        r210 = r24;
        r51 = r27;
        r121 = r111;
        r58 = r110;
        r122 = -1;
        if (r25 != 2) goto L92;
        if (isEnforceUtf8(r34) == false) goto L61;
        r8 = ArrayDecoders.decodeStringRequireUtf8(r50, r20, r10);
        goto L52
    L61:
        r8 = ArrayDecoders.decodeString(r50, r20, r10);
        goto L52
    L62:
        r50 = r29;
        r210 = r24;
        r51 = r27;
        r121 = r111;
        r122 = -1;
        if (r25 != 0) goto L92;
        r8 = ArrayDecoders.decodeVarint64(r50, r20, r10);
        if (r10.long1 == 0) goto L67;
        boolean r60 = true;
    L68:
        UnsafeUtil.putBoolean(r14, r110, r60);
        goto L90
    L67:
        r60 = false;
        goto L68
    L69:
        r50 = r29;
        r210 = r24;
        r51 = r27;
        r121 = r111;
        r122 = -1;
        if (r25 != 5) goto L92;
        r11.putInt(r14, r110, ArrayDecoders.decodeFixed32(r50, r20));
    L86:
        r8 = r20 + 4;
        goto L90
    L72:
        r50 = r29;
        r210 = r24;
        r51 = r27;
        r121 = r111;
        r122 = -1;
        if (r25 != 1) goto L92;
        r11.putLong(r28, r110, ArrayDecoders.decodeFixed64(r50, r20));
        r8 = r20 + 8;
        goto L90
    L75:
        r50 = r29;
        r210 = r24;
        r51 = r27;
        r121 = r111;
        r122 = -1;
        if (r25 != 0) goto L92;
        r8 = ArrayDecoders.decodeVarint32(r50, r20, r10);
        r57 = r10.int1;
        goto L78
    L79:
        r55 = r29;
        r210 = r24;
        r51 = r27;
        r121 = r111;
        r122 = -1;
        if (r25 != 0) goto L92;
        r56 = ArrayDecoders.decodeVarint64(r55, r20, r10);
        r123 = r10.long1;
        goto L82
    L83:
        r50 = r29;
        r210 = r24;
        r51 = r27;
        r121 = r111;
        r122 = -1;
        if (r25 != 5) goto L92;
        UnsafeUtil.putFloat(r14, r110, ArrayDecoders.decodeFloat(r50, r20));
        goto L86
    L87:
        r50 = r29;
        r210 = r24;
        r51 = r27;
        r121 = r111;
        r122 = -1;
        if (r25 != 1) goto L92;
        UnsafeUtil.putDouble(r14, r110, ArrayDecoders.decodeDouble(r50, r20));
        r8 = r20 + 8;
        goto L90
    L23:
        r49 = r11.getInt(r14, r48);
        goto L24
    L25:
        r120 = r17;
        r211 = r19;
        goto L27
    L14:
        r210 = r24;
        r37 = r20;
        r38 = r23;
        r113 = r17;
        r211 = r19;
        r212 = r11;
        r32 = r32;
        r213 = 0;
        goto L125
    L11:
        r26 = r15.positionForFieldNumber(r24);
        goto L12
    L7:
        r23 = r21;
        goto L8
    L135:
        int r214 = r19;
        r212 = r11;
        r32 = r32;
        r115 = r15;
        r40 = r8;
        r38 = r16;
        r41 = r214;
        r39 = 1048575;
        goto L136
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T r8, Writer r10) {
        if (r10.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L5;
        writeFieldsInDescendingOrder(r8, r10);
        return;
    L5:
        writeFieldsInAscendingOrder(r8, r10);
    }

    private boolean equals(T r8, T r10, int r11) {
        int r12 = typeAndOffsetAt(r11);
        long r13 = offset(r12);
        switch(type(r12)) {
            case 0: goto L116;
            case 1: goto L110;
            case 2: goto L104;
            case 3: goto L98;
            case 4: goto L92;
            case 5: goto L86;
            case 6: goto L80;
            case 7: goto L74;
            case 8: goto L68;
            case 9: goto L62;
            case 10: goto L56;
            case 11: goto L50;
            case 12: goto L44;
            case 13: goto L38;
            case 14: goto L32;
            case 15: goto L26;
            case 16: goto L20;
            case 17: goto L14;
            case 18: goto L12;
            case 19: goto L12;
            case 20: goto L12;
            case 21: goto L12;
            case 22: goto L12;
            case 23: goto L12;
            case 24: goto L12;
            case 25: goto L12;
            case 26: goto L12;
            case 27: goto L12;
            case 28: goto L12;
            case 29: goto L12;
            case 30: goto L12;
            case 31: goto L12;
            case 32: goto L12;
            case 33: goto L12;
            case 34: goto L12;
            case 35: goto L12;
            case 36: goto L12;
            case 37: goto L12;
            case 38: goto L12;
            case 39: goto L12;
            case 40: goto L12;
            case 41: goto L12;
            case 42: goto L12;
            case 43: goto L12;
            case 44: goto L12;
            case 45: goto L12;
            case 46: goto L12;
            case 47: goto L12;
            case 48: goto L12;
            case 49: goto L12;
            case 50: goto L12;
            case 51: goto L6;
            case 52: goto L6;
            case 53: goto L6;
            case 54: goto L6;
            case 55: goto L6;
            case 56: goto L6;
            case 57: goto L6;
            case 58: goto L6;
            case 59: goto L6;
            case 60: goto L6;
            case 61: goto L6;
            case 62: goto L6;
            case 63: goto L6;
            case 64: goto L6;
            case 65: goto L6;
            case 66: goto L6;
            case 67: goto L6;
            case 68: goto L6;
            default: goto L4;
        };
    L4:
        return true;
    L6:
        if (isOneofCaseEqual(r8, r10, r11) == true) goto L8;
        return false;
    L8:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r8, r13), UnsafeUtil.getObject(r10, r13)) == true) goto L10;
        return false;
    L10:
        return true;
    L12:
        return SchemaUtil.safeEquals(UnsafeUtil.getObject(r8, r13), UnsafeUtil.getObject(r10, r13));
    L14:
        if (arePresentForEquals(r8, r10, r11) == true) goto L16;
        return false;
    L16:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r8, r13), UnsafeUtil.getObject(r10, r13)) == true) goto L18;
        return false;
    L18:
        return true;
    L20:
        if (arePresentForEquals(r8, r10, r11) == true) goto L22;
        return false;
    L22:
        if (UnsafeUtil.getLong(r8, r13) == UnsafeUtil.getLong(r10, r13)) goto L24;
        return false;
    L24:
        return true;
    L26:
        if (arePresentForEquals(r8, r10, r11) == true) goto L28;
        return false;
    L28:
        if (UnsafeUtil.getInt(r8, r13) == UnsafeUtil.getInt(r10, r13)) goto L30;
        return false;
    L30:
        return true;
    L32:
        if (arePresentForEquals(r8, r10, r11) == true) goto L34;
        return false;
    L34:
        if (UnsafeUtil.getLong(r8, r13) == UnsafeUtil.getLong(r10, r13)) goto L36;
        return false;
    L36:
        return true;
    L38:
        if (arePresentForEquals(r8, r10, r11) == true) goto L40;
        return false;
    L40:
        if (UnsafeUtil.getInt(r8, r13) == UnsafeUtil.getInt(r10, r13)) goto L42;
        return false;
    L42:
        return true;
    L44:
        if (arePresentForEquals(r8, r10, r11) == true) goto L46;
        return false;
    L46:
        if (UnsafeUtil.getInt(r8, r13) == UnsafeUtil.getInt(r10, r13)) goto L48;
        return false;
    L48:
        return true;
    L50:
        if (arePresentForEquals(r8, r10, r11) == true) goto L52;
        return false;
    L52:
        if (UnsafeUtil.getInt(r8, r13) == UnsafeUtil.getInt(r10, r13)) goto L54;
        return false;
    L54:
        return true;
    L56:
        if (arePresentForEquals(r8, r10, r11) == true) goto L58;
        return false;
    L58:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r8, r13), UnsafeUtil.getObject(r10, r13)) == true) goto L60;
        return false;
    L60:
        return true;
    L62:
        if (arePresentForEquals(r8, r10, r11) == true) goto L64;
        return false;
    L64:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r8, r13), UnsafeUtil.getObject(r10, r13)) == true) goto L66;
        return false;
    L66:
        return true;
    L68:
        if (arePresentForEquals(r8, r10, r11) == true) goto L70;
        return false;
    L70:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r8, r13), UnsafeUtil.getObject(r10, r13)) == true) goto L72;
        return false;
    L72:
        return true;
    L74:
        if (arePresentForEquals(r8, r10, r11) == true) goto L76;
        return false;
    L76:
        if (UnsafeUtil.getBoolean(r8, r13) == UnsafeUtil.getBoolean(r10, r13)) goto L78;
        return false;
    L78:
        return true;
    L80:
        if (arePresentForEquals(r8, r10, r11) == true) goto L82;
        return false;
    L82:
        if (UnsafeUtil.getInt(r8, r13) == UnsafeUtil.getInt(r10, r13)) goto L84;
        return false;
    L84:
        return true;
    L86:
        if (arePresentForEquals(r8, r10, r11) == true) goto L88;
        return false;
    L88:
        if (UnsafeUtil.getLong(r8, r13) == UnsafeUtil.getLong(r10, r13)) goto L90;
        return false;
    L90:
        return true;
    L92:
        if (arePresentForEquals(r8, r10, r11) == true) goto L94;
        return false;
    L94:
        if (UnsafeUtil.getInt(r8, r13) == UnsafeUtil.getInt(r10, r13)) goto L96;
        return false;
    L96:
        return true;
    L98:
        if (arePresentForEquals(r8, r10, r11) == true) goto L100;
        return false;
    L100:
        if (UnsafeUtil.getLong(r8, r13) == UnsafeUtil.getLong(r10, r13)) goto L102;
        return false;
    L102:
        return true;
    L104:
        if (arePresentForEquals(r8, r10, r11) == true) goto L106;
        return false;
    L106:
        if (UnsafeUtil.getLong(r8, r13) == UnsafeUtil.getLong(r10, r13)) goto L108;
        return false;
    L108:
        return true;
    L110:
        if (arePresentForEquals(r8, r10, r11) == true) goto L112;
        return false;
    L112:
        if (Float.floatToIntBits(UnsafeUtil.getFloat(r8, r13)) == Float.floatToIntBits(UnsafeUtil.getFloat(r10, r13))) goto L114;
        return false;
    L114:
        return true;
    L116:
        if (arePresentForEquals(r8, r10, r11) == true) goto L118;
        return false;
    L118:
        if (Double.doubleToLongBits(UnsafeUtil.getDouble(r8, r13)) == Double.doubleToLongBits(UnsafeUtil.getDouble(r10, r13))) goto L120;
        return false;
    L120:
        return true;
    }

    private boolean isFieldPresent(T r8, int r10, int r11, int r12, int r13) {
        if (r11 != 1048575) goto L7;
        return isFieldPresent(r8, r10);
    L7:
        if ((r12 & r13) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object r8, int r10, Schema r11) {
        return r11.isInitialized(UnsafeUtil.getObject(r8, offset(r10)));
    }

    private int positionForFieldNumber(int r8, int r10) {
        if (r8 >= this.minFieldNumber) goto L5;
        return -1;
    L5:
        if (r8 <= this.maxFieldNumber) goto L7;
        return -1;
    L7:
        return slowPositionForFieldNumber(r8, r10);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r8, T r10) {
        checkMutable(r8);
        if (r10 == null) goto L13;
        int r11 = 0;
    L6:
        if (r11 >= this.buffer.length) goto L8;
        mergeSingleField(r8, r10, r11);
        r11 = r11 + 3;
        goto L6
    L8:
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, r8, r10);
        if (this.hasExtensions == false) goto L15;
        SchemaUtil.mergeExtensions(this.extensionSchema, r8, r10);
        return;
    L15:
        return;
    L13:
        throw null;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r8, byte[] r10, int r11, int r12, ArrayDecoders.Registers r13) {
        parseMessage(r8, r10, r11, r12, 0, r13);
    }
}
