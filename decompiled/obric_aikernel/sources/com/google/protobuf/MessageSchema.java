package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
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

    private MessageSchema(int[] r10, Object[] r11, int r12, int r13, MessageLite r14, boolean r15, int[] r16, int r17, int r18, NewInstanceSchema r19, ListFieldSchema r110, UnknownFieldSchema<?, ?> r111, ExtensionSchema<?> r112, MapFieldSchema r113) {
        this.buffer = r10;
        this.objects = r11;
        this.minFieldNumber = r12;
        this.maxFieldNumber = r13;
        this.lite = r14 instanceof GeneratedMessageLite;
        if (r112 != null) goto L5;
    L7:
        boolean r20 = false;
    L8:
        this.hasExtensions = r20;
        this.useCachedSizeField = r15;
        this.intArray = r16;
        this.checkInitializedCount = r17;
        this.repeatedFieldOffsetStart = r18;
        this.newInstanceSchema = r19;
        this.listFieldSchema = r110;
        this.unknownFieldSchema = r111;
        this.extensionSchema = r112;
        this.defaultInstance = r14;
        this.mapFieldSchema = r113;
        return;
    L5:
        if (r112.hasExtensions(r14) == false) goto L7;
        r20 = true;
        goto L8
    }

    private boolean arePresentForEquals(T r10, T r11, int r12) {
        if (isFieldPresent(r10, r12) != isFieldPresent(r11, r12)) goto L5;
        return true;
    L5:
        return false;
    }

    private static <T> boolean booleanAt(T r10, long r11) {
        return UnsafeUtil.getBoolean(r10, r11);
    }

    private static void checkMutable(Object r10) {
        if (isMutable(r10) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Mutating immutable message: " + r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] r15, int r16, int r17, MapEntryLite.Metadata<K, V> r18, Map<K, V> r19, ArrayDecoders.Registers r20) {
        int r10 = ArrayDecoders.decodeVarint32(r15, r16, r20);
        int r11 = r20.int1;
        if (r11 < 0) goto L30;
        if (r11 > (r17 - r10)) goto L30;
        int r12 = r10 + r11;
        K r13 = r18.defaultKey;
        Object r14 = r13;
        Object r110 = r18.defaultValue;
    L7:
        if (r10 >= r12) goto L24;
        int r21 = r10 + 1;
        int r22 = r15[r10];
        if (r22 >= 0) goto L11;
        int r23 = ArrayDecoders.decodeVarint32(r22, r15, r21, r20);
        int r24 = r23;
        r22 = r20.int1;
    L12:
        int r25 = r22 >>> 3;
        int r26 = r22 & 7;
        if (r25 != 1) goto L15;
        if (r26 != r18.keyType.getWireType()) goto L23;
        r10 = decodeMapEntryValue(r15, r24, r17, r18.keyType, null, r20);
        r14 = r20.object1;
    L23:
        r10 = ArrayDecoders.skipField(r22, r15, r24, r17, r20);
        goto L7
    L15:
        if (r25 != 2) goto L23;
        if (r26 != r18.valueType.getWireType()) goto L23;
        r10 = decodeMapEntryValue(r15, r24, r17, r18.valueType, r18.defaultValue.getClass(), r20);
        r110 = r20.object1;
        goto L7
    L11:
        r24 = r21;
        goto L12
    L24:
        if (r10 != r12) goto L28;
        r19.put(r14, r110);
        return r12;
    L28:
        throw InvalidProtocolBufferException.parseFailure();
    L30:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private int decodeMapEntryValue(byte[] r10, int r11, int r12, WireFormat.FieldType r13, Class<?> r14, ArrayDecoders.Registers r15) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r13.ordinal()]) {
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
        int r16 = ArrayDecoders.decodeVarint64(r10, r11, r15);
        long r17 = CodedInputStream.decodeZigZag64(r15.long1);
    L11:
        Object r18 = Long.valueOf(r17);
    L14:
        r15.object1 = r18;
        return r16;
    L8:
        r16 = ArrayDecoders.decodeVarint32(r10, r11, r15);
        int r19 = CodedInputStream.decodeZigZag32(r15.int1);
    L13:
        r18 = Integer.valueOf(r19);
        goto L14
    L10:
        r16 = ArrayDecoders.decodeVarint64(r10, r11, r15);
        r17 = r15.long1;
        goto L11
    L12:
        r16 = ArrayDecoders.decodeVarint32(r10, r11, r15);
        r19 = r15.int1;
        goto L13
    L15:
        Object r20 = Float.valueOf(ArrayDecoders.decodeFloat(r10, r11));
    L18:
        r15.object1 = r20;
        return r11 + 4;
    L16:
        Object r21 = Long.valueOf(ArrayDecoders.decodeFixed64(r10, r11));
    L20:
        r15.object1 = r21;
        return r11 + 8;
    L17:
        r20 = Integer.valueOf(ArrayDecoders.decodeFixed32(r10, r11));
        goto L18
    L19:
        r21 = Double.valueOf(ArrayDecoders.decodeDouble(r10, r11));
        goto L20
    L22:
        r16 = ArrayDecoders.decodeVarint64(r10, r11, r15);
        if (r15.long1 == 0) goto L25;
        boolean r22 = true;
    L26:
        r18 = Boolean.valueOf(r22);
        goto L14
    L25:
        r22 = false;
        goto L26
    L5:
        throw new RuntimeException("unsupported field type.");
    L27:
        return ArrayDecoders.decodeStringRequireUtf8(r10, r11, r15);
    L28:
        return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(r14), r10, r11, r12, r15);
    L32:
        return ArrayDecoders.decodeBytes(r10, r11, r15);
    }

    private static <T> double doubleAt(T r10, long r11) {
        return UnsafeUtil.getDouble(r10, r11);
    }

    private boolean equals(T r10, T r11, int r12) {
        int r13 = typeAndOffsetAt(r12);
        long r14 = offset(r13);
        switch(type(r13)) {
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
        if (isOneofCaseEqual(r10, r11, r12) == true) goto L8;
        return false;
    L8:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r10, r14), UnsafeUtil.getObject(r11, r14)) == true) goto L10;
        return false;
    L10:
        return true;
    L12:
        return SchemaUtil.safeEquals(UnsafeUtil.getObject(r10, r14), UnsafeUtil.getObject(r11, r14));
    L14:
        if (arePresentForEquals(r10, r11, r12) == true) goto L16;
        return false;
    L16:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r10, r14), UnsafeUtil.getObject(r11, r14)) == true) goto L18;
        return false;
    L18:
        return true;
    L20:
        if (arePresentForEquals(r10, r11, r12) == true) goto L22;
        return false;
    L22:
        if (UnsafeUtil.getLong(r10, r14) == UnsafeUtil.getLong(r11, r14)) goto L24;
        return false;
    L24:
        return true;
    L26:
        if (arePresentForEquals(r10, r11, r12) == true) goto L28;
        return false;
    L28:
        if (UnsafeUtil.getInt(r10, r14) == UnsafeUtil.getInt(r11, r14)) goto L30;
        return false;
    L30:
        return true;
    L32:
        if (arePresentForEquals(r10, r11, r12) == true) goto L34;
        return false;
    L34:
        if (UnsafeUtil.getLong(r10, r14) == UnsafeUtil.getLong(r11, r14)) goto L36;
        return false;
    L36:
        return true;
    L38:
        if (arePresentForEquals(r10, r11, r12) == true) goto L40;
        return false;
    L40:
        if (UnsafeUtil.getInt(r10, r14) == UnsafeUtil.getInt(r11, r14)) goto L42;
        return false;
    L42:
        return true;
    L44:
        if (arePresentForEquals(r10, r11, r12) == true) goto L46;
        return false;
    L46:
        if (UnsafeUtil.getInt(r10, r14) == UnsafeUtil.getInt(r11, r14)) goto L48;
        return false;
    L48:
        return true;
    L50:
        if (arePresentForEquals(r10, r11, r12) == true) goto L52;
        return false;
    L52:
        if (UnsafeUtil.getInt(r10, r14) == UnsafeUtil.getInt(r11, r14)) goto L54;
        return false;
    L54:
        return true;
    L56:
        if (arePresentForEquals(r10, r11, r12) == true) goto L58;
        return false;
    L58:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r10, r14), UnsafeUtil.getObject(r11, r14)) == true) goto L60;
        return false;
    L60:
        return true;
    L62:
        if (arePresentForEquals(r10, r11, r12) == true) goto L64;
        return false;
    L64:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r10, r14), UnsafeUtil.getObject(r11, r14)) == true) goto L66;
        return false;
    L66:
        return true;
    L68:
        if (arePresentForEquals(r10, r11, r12) == true) goto L70;
        return false;
    L70:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r10, r14), UnsafeUtil.getObject(r11, r14)) == true) goto L72;
        return false;
    L72:
        return true;
    L74:
        if (arePresentForEquals(r10, r11, r12) == true) goto L76;
        return false;
    L76:
        if (UnsafeUtil.getBoolean(r10, r14) == UnsafeUtil.getBoolean(r11, r14)) goto L78;
        return false;
    L78:
        return true;
    L80:
        if (arePresentForEquals(r10, r11, r12) == true) goto L82;
        return false;
    L82:
        if (UnsafeUtil.getInt(r10, r14) == UnsafeUtil.getInt(r11, r14)) goto L84;
        return false;
    L84:
        return true;
    L86:
        if (arePresentForEquals(r10, r11, r12) == true) goto L88;
        return false;
    L88:
        if (UnsafeUtil.getLong(r10, r14) == UnsafeUtil.getLong(r11, r14)) goto L90;
        return false;
    L90:
        return true;
    L92:
        if (arePresentForEquals(r10, r11, r12) == true) goto L94;
        return false;
    L94:
        if (UnsafeUtil.getInt(r10, r14) == UnsafeUtil.getInt(r11, r14)) goto L96;
        return false;
    L96:
        return true;
    L98:
        if (arePresentForEquals(r10, r11, r12) == true) goto L100;
        return false;
    L100:
        if (UnsafeUtil.getLong(r10, r14) == UnsafeUtil.getLong(r11, r14)) goto L102;
        return false;
    L102:
        return true;
    L104:
        if (arePresentForEquals(r10, r11, r12) == true) goto L106;
        return false;
    L106:
        if (UnsafeUtil.getLong(r10, r14) == UnsafeUtil.getLong(r11, r14)) goto L108;
        return false;
    L108:
        return true;
    L110:
        if (arePresentForEquals(r10, r11, r12) == true) goto L112;
        return false;
    L112:
        if (Float.floatToIntBits(UnsafeUtil.getFloat(r10, r14)) == Float.floatToIntBits(UnsafeUtil.getFloat(r11, r14))) goto L114;
        return false;
    L114:
        return true;
    L116:
        if (arePresentForEquals(r10, r11, r12) == true) goto L118;
        return false;
    L118:
        if (Double.doubleToLongBits(UnsafeUtil.getDouble(r10, r14)) == Double.doubleToLongBits(UnsafeUtil.getDouble(r11, r14))) goto L120;
        return false;
    L120:
        return true;
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object r10, int r11, UB r12, UnknownFieldSchema<UT, UB> r13, Object r14) {
        int r15 = numberAt(r11);
        Object r16 = UnsafeUtil.getObject(r10, offset(typeAndOffsetAt(r11)));
        if (r16 != null) goto L5;
        return r12;
    L5:
        Internal.EnumVerifier r17 = getEnumFieldVerifier(r11);
        if (r17 != null) goto L9;
        return r12;
    L9:
        return (UB) filterUnknownEnumMap(r11, r15, this.mapFieldSchema.forMutableMapData(r16), r17, r12, r13, r14);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int r10, int r11, Map<K, V> r12, Internal.EnumVerifier r13, UB r14, UnknownFieldSchema<UT, UB> r15, Object r16) {
        MapEntryLite.Metadata<?, ?> r17 = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(r10));
        Iterator<Map.Entry<K, V>> r18 = r12.entrySet().iterator();
    L4:
        if (r18.hasNext() == false) goto L15;
        Map.Entry<K, V> r19 = r18.next();
        if (r13.isInRange(((Integer) r19.getValue()).intValue()) == true) goto L4;
        if (r14 != null) goto L9;
        r14 = r15.getBuilderFromMessage(r16);
    L9:
        ByteString.CodedBuilder r20 = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(r17, r19.getKey(), r19.getValue()));
        CodedOutputStream r21 = r20.getCodedOutput();
        MapEntryLite.writeTo(r21, r17, r19.getKey(), r19.getValue());     // Catch: IOException -> L12
        UB r22 = r14;
        r15.addLengthDelimited(r22, r11, r20.build());
        r18.remove();
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    L15:
        return r14;
    }

    private static <T> float floatAt(T r10, long r11) {
        return UnsafeUtil.getFloat(r10, r11);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int r10) {
        return (Internal.EnumVerifier) this.objects[((r10 / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int r10) {
        return this.objects[(r10 / 3) * 2];
    }

    private Schema getMessageFieldSchema(int r10) {
        int r11 = (r10 / 3) * 2;
        Schema r12 = (Schema) this.objects[r11];
        if (r12 == null) goto L5;
        return r12;
    L5:
        Schema<T> r13 = Protobuf.getInstance().schemaFor((Class) this.objects[r11 + 1]);
        this.objects[r11] = r13;
        return r13;
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object r10) {
        GeneratedMessageLite r11 = (GeneratedMessageLite) r10;
        UnknownFieldSetLite r12 = r11.unknownFields;
        if (r12 != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        UnknownFieldSetLite r13 = UnknownFieldSetLite.newInstance();
        r11.unknownFields = r13;
        return r13;
    L6:
        return r12;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> r10, T r11) {
        return r10.getSerializedSize(r10.getFromMessage(r11));
    }

    private static <T> int intAt(T r10, long r11) {
        return UnsafeUtil.getInt(r10, r11);
    }

    private static boolean isEnforceUtf8(int r10) {
        if ((r10 & ENFORCE_UTF8_MASK) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isFieldPresent(T r10, int r11) {
        int r12 = presenceMaskAndOffsetAt(r11);
        long r13 = 1048575 & r12;
        if (r13 != 1048575) goto L83;
        int r14 = typeAndOffsetAt(r11);
        long r15 = offset(r14);
        switch(type(r14)) {
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
        Object r16 = UnsafeUtil.getObject(r10, r15);
        if ((r16 instanceof String) == false) goto L47;
        return !((String) r16).isEmpty();
    L47:
        if ((r16 instanceof ByteString) == false) goto L51;
        return !ByteString.EMPTY.equals(r16);
    L51:
        throw new IllegalArgumentException();
    L7:
        throw new IllegalArgumentException();
    L9:
        if (UnsafeUtil.getObject(r10, r15) != null) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (UnsafeUtil.getLong(r10, r15) != 0) goto L15;
        return false;
    L15:
        return true;
    L17:
        if (UnsafeUtil.getInt(r10, r15) != 0) goto L19;
        return false;
    L19:
        return true;
    L21:
        if (UnsafeUtil.getLong(r10, r15) != 0) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (UnsafeUtil.getInt(r10, r15) != 0) goto L27;
        return false;
    L27:
        return true;
    L29:
        if (UnsafeUtil.getInt(r10, r15) != 0) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (UnsafeUtil.getInt(r10, r15) != 0) goto L35;
        return false;
    L35:
        return true;
    L37:
        return !ByteString.EMPTY.equals(UnsafeUtil.getObject(r10, r15));
    L39:
        if (UnsafeUtil.getObject(r10, r15) != null) goto L41;
        return false;
    L41:
        return true;
    L53:
        return UnsafeUtil.getBoolean(r10, r15);
    L55:
        if (UnsafeUtil.getInt(r10, r15) != 0) goto L57;
        return false;
    L57:
        return true;
    L59:
        if (UnsafeUtil.getLong(r10, r15) != 0) goto L61;
        return false;
    L61:
        return true;
    L63:
        if (UnsafeUtil.getInt(r10, r15) != 0) goto L65;
        return false;
    L65:
        return true;
    L67:
        if (UnsafeUtil.getLong(r10, r15) != 0) goto L69;
        return false;
    L69:
        return true;
    L71:
        if (UnsafeUtil.getLong(r10, r15) != 0) goto L73;
        return false;
    L73:
        return true;
    L75:
        if (Float.floatToRawIntBits(UnsafeUtil.getFloat(r10, r15)) != 0) goto L77;
        return false;
    L77:
        return true;
    L79:
        if (Double.doubleToRawLongBits(UnsafeUtil.getDouble(r10, r15)) != 0) goto L81;
        return false;
    L81:
        return true;
    L83:
        if (((1 << (r12 >>> 20)) & UnsafeUtil.getInt(r10, r13)) != 0) goto L85;
        return false;
    L85:
        return true;
    }

    private boolean isFieldPresent(T r10, int r11, int r12, int r13, int r14) {
        if (r12 != 1048575) goto L7;
        return isFieldPresent(r10, r11);
    L7:
        if ((r13 & r14) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object r10, int r11, Schema r12) {
        return r12.isInitialized(UnsafeUtil.getObject(r10, offset(r11)));
    }

    private static boolean isLegacyEnumIsClosed(int r10) {
        if ((r10 & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object r10, int r11, int r12) {
        List r13 = (List) UnsafeUtil.getObject(r10, offset(r11));
        if (r13.isEmpty() == false) goto L5;
        return true;
    L5:
        Schema r14 = getMessageFieldSchema(r12);
        int r15 = 0;
    L7:
        if (r15 >= r13.size()) goto L12;
        if (r14.isInitialized(r13.get(r15)) == false) goto L10;
        r15 = r15 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.google.protobuf.Schema] */
    private boolean isMapInitialized(T r10, int r11, int r12) {
        Map<?, ?> r13 = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(r10, offset(r11)));
        if (r13.isEmpty() == false) goto L5;
        return true;
    L5:
        Object r14 = getMapFieldDefaultEntry(r12);
        if (this.mapFieldSchema.forMapMetadata(r14).valueType.getJavaType() == WireFormat.JavaType.MESSAGE) goto L8;
        return true;
    L8:
        ?? r15 = 0;
        Iterator<?> r16 = r13.values().iterator();
    L10:
        if (r16.hasNext() == false) goto L18;
        Object r17 = r16.next();
        r15 = r15;
        if (r15 != 0) goto L15;
        r15 = Protobuf.getInstance().schemaFor(r17.getClass());
    L15:
        if (r15.isInitialized(r17) == true) goto L10;
        return false;
    L18:
        return true;
    }

    private static boolean isMutable(Object r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if ((r10 instanceof GeneratedMessageLite) == true) goto L8;
        return true;
    L8:
        return ((GeneratedMessageLite) r10).isMutable();
    }

    private boolean isOneofCaseEqual(T r10, T r11, int r12) {
        long r13 = presenceMaskAndOffsetAt(r12) & 1048575;
        if (UnsafeUtil.getInt(r10, r13) != UnsafeUtil.getInt(r11, r13)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isOneofPresent(T r10, int r11, int r12) {
        if (UnsafeUtil.getInt(r10, presenceMaskAndOffsetAt(r12) & 1048575) != r11) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isRequired(int r10) {
        if ((r10 & REQUIRED_MASK) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static <T> long longAt(T r10, long r11) {
        return UnsafeUtil.getLong(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> r19, ExtensionSchema<ET> r20, T r21, Reader r22, ExtensionRegistryLite r23) {
        UnknownFieldSchema r10 = r19;
        T r15 = r21;
        ExtensionRegistryLite r11 = r23;
        Object r12 = null;
        Object r13 = null;
    L236:
        int r14 = r22.getFieldNumber();     // Catch: Throwable -> L213
        int r16 = positionForFieldNumber(r14);     // Catch: Throwable -> L213
        if (r16 < 0) goto L7;
        T r17 = r15;
        int r18 = typeAndOffsetAt(r16);     // Catch: Throwable -> L211
        switch(type(r18)) {
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
        r12 = r12;
        r11 = r11;
        r10 = r10;
        if (r12 == null) goto L238;
        r12 = r12;
    L229:
        if (r10.mergeOneFieldFrom(r12, r22, 0) == false) goto L177;
    L208:
        r11 = r11;
        r10 = r10;
        r15 = r17;
        goto L236
    L177:
        int r24 = this.checkInitializedCount;
        Object r25 = r12;
    L179:
        if (r24 >= this.repeatedFieldOffsetStart) goto L181;
        r25 = filterMapUnknownEnumValues(r21, this.intArray[r24], r25, r19, r21);
        r24 = r24 + 1;
        goto L179
    L181:
        if (r25 == null) goto L263;
        r10.setBuilderToMessage(r17, r25);
        return;
    L263:
        return;
    L209:
        th = th;
    L217:
        int r26 = this.checkInitializedCount;
        Object r27 = r12;
    L219:
        if (r26 >= this.repeatedFieldOffsetStart) goto L221;
        r27 = filterMapUnknownEnumValues(r21, this.intArray[r26], r27, r19, r21);
        r26 = r26 + 1;
        goto L219
    L221:
        if (r27 == null) goto L223;
        r10.setBuilderToMessage(r17, r27);
    L223:
        throw th;
    L187:
        if (r10.shouldDiscardUnknownFields(r22) == true) goto L189;
        if (r12 != null) goto L200;
        r12 = r10.getBuilderFromMessage(r17);     // Catch: Throwable -> L209
    L200:
        if (r10.mergeOneFieldFrom(r12, r22, 0) == true) goto L208;
        int r28 = this.checkInitializedCount;
        Object r29 = r12;
    L203:
        if (r28 >= this.repeatedFieldOffsetStart) goto L205;
        r29 = filterMapUnknownEnumValues(r21, this.intArray[r28], r29, r19, r21);
        r28 = r28 + 1;
        goto L203
    L205:
        if (r29 == null) goto L265;
        r10.setBuilderToMessage(r17, r29);
        return;
    L265:
        return;
    L189:
        if (r22.skipField() == true) goto L208;
        int r30 = this.checkInitializedCount;
        Object r31 = r12;
    L192:
        if (r30 >= this.repeatedFieldOffsetStart) goto L194;
        r31 = filterMapUnknownEnumValues(r21, this.intArray[r30], r31, r19, r21);
        r30 = r30 + 1;
        goto L192
    L194:
        if (r31 == null) goto L264;
        r10.setBuilderToMessage(r17, r31);
        return;
    L264:
        return;
    L238:
        r12 = r10.getBuilderFromMessage(r17);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L229
    L170:
        th = th;
    L171:
        r12 = r12;
    L172:
        r12 = r12;
        goto L187
    L59:
        UnsafeUtil.putObject(r17, offset(r18), Long.valueOf(r22.readSInt64()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
    L61:
        setOneofPresent(r17, r14, r16);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
    L75:
        r12 = r12;
        r11 = r11;
    L90:
        r10 = r10;
    L169:
        r12 = r12;
        goto L208
    L60:
        UnsafeUtil.putObject(r17, offset(r18), Integer.valueOf(r22.readSInt32()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L62:
        UnsafeUtil.putObject(r17, offset(r18), Long.valueOf(r22.readSFixed64()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L63:
        UnsafeUtil.putObject(r17, offset(r18), Integer.valueOf(r22.readSFixed32()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L64:
        int r32 = r22.readEnum();     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        Internal.EnumVerifier r110 = getEnumFieldVerifier(r16);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        if (r110 != null) goto L67;
    L70:
        UnsafeUtil.putObject(r17, offset(r18), Integer.valueOf(r32));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L67:
        if (r110.isInRange(r32) == true) goto L70;
        r12 = SchemaUtil.storeUnknownEnum(r17, r14, r32, r12, r10);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        r11 = r11;
        r10 = r10;
        goto L208
    L71:
        UnsafeUtil.putObject(r17, offset(r18), Integer.valueOf(r22.readUInt32()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L72:
        UnsafeUtil.putObject(r17, offset(r18), r22.readBytes());     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L73:
        MessageLite r33 = (MessageLite) mutableOneofMessageFieldForMerge(r17, r14, r16);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        r22.mergeMessageField(r33, getMessageFieldSchema(r16), r11);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
    L58:
        storeOneofMessageField(r17, r14, r16, r33);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L75
    L74:
        readString(r17, r18, r22);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L76:
        UnsafeUtil.putObject(r17, offset(r18), Boolean.valueOf(r22.readBool()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L77:
        UnsafeUtil.putObject(r17, offset(r18), Integer.valueOf(r22.readFixed32()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L78:
        UnsafeUtil.putObject(r17, offset(r18), Long.valueOf(r22.readFixed64()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L79:
        UnsafeUtil.putObject(r17, offset(r18), Integer.valueOf(r22.readInt32()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L80:
        UnsafeUtil.putObject(r17, offset(r18), Long.valueOf(r22.readUInt64()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L81:
        UnsafeUtil.putObject(r17, offset(r18), Long.valueOf(r22.readInt64()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L82:
        UnsafeUtil.putObject(r17, offset(r18), Float.valueOf(r22.readFloat()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L83:
        UnsafeUtil.putObject(r17, offset(r18), Double.valueOf(r22.readDouble()));     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        goto L61
    L87:
        r12 = r12;
        r11 = r11;
        mergeMap(r21, r16, getMapFieldDefaultEntry(r16), r23, r22);     // Catch: Throwable -> L94 InvalidProtocolBufferException.InvalidWireTypeException -> L96
    L96:
        r10 = r10;
    L94:
        th = th;
        r10 = r10;
        goto L171
        goto L185
    L91:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        readGroupList(r21, offset(r18), r22, getMessageFieldSchema(r16), r23);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L97:
        List<Long> r34 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L98:
        r22.readSInt64List(r34);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L99:
        List<Integer> r35 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L100:
        r22.readSInt32List(r35);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L101:
        List<Long> r36 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L102:
        r22.readSFixed64List(r36);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L103:
        List<Integer> r37 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L104:
        r22.readSFixed32List(r37);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L105:
        List<Integer> r38 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        r22.readEnumList(r38);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        Internal.EnumVerifier r39 = getEnumFieldVerifier(r16);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L106:
        r12 = SchemaUtil.filterUnknownEnumList(r21, r14, r38, r39, r12, r19);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L208
    L107:
        List<Integer> r40 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L108:
        r22.readUInt32List(r40);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L109:
        List<Boolean> r41 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L110:
        r22.readBoolList(r41);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L111:
        List<Integer> r42 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L112:
        r22.readFixed32List(r42);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L113:
        List<Long> r43 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L114:
        r22.readFixed64List(r43);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L115:
        List<Integer> r44 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L116:
        r22.readInt32List(r44);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L117:
        List<Long> r45 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L118:
        r22.readUInt64List(r45);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L119:
        List<Long> r46 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L120:
        r22.readInt64List(r46);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L121:
        List<Float> r47 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L122:
        r22.readFloatList(r47);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L123:
        List<Double> r48 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L124:
        r22.readDoubleList(r48);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L125:
        r34 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L98
    L126:
        r35 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L100
    L127:
        r36 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L102
    L128:
        r37 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L104
    L129:
        r38 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        r22.readEnumList(r38);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        r39 = getEnumFieldVerifier(r16);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L106
    L130:
        r40 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L108
    L131:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        r22.readBytesList(this.listFieldSchema.mutableListAt(r17, offset(r18)));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L132:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        readMessageList(r21, r18, r22, getMessageFieldSchema(r16), r23);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L133:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        readStringList(r17, r18, r22);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L134:
        r41 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L110
    L135:
        r42 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L112
    L136:
        r43 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L114
    L137:
        r44 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L116
    L138:
        r45 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L118
    L139:
        r46 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L120
    L140:
        r47 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L122
    L141:
        r48 = this.listFieldSchema.mutableListAt(r17, offset(r18));     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L124
    L142:
        r11 = r11;
        MessageLite r49 = (MessageLite) mutableMessageFieldForMerge(r17, r16);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        r22.mergeGroupField(r49, getMessageFieldSchema(r16), r11);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L143:
        storeMessageField(r17, r16, r49);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L144:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putLong(r17, offset(r18), r22.readSInt64());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
    L145:
        setFieldPresent(r17, r16);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L169
    L146:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putInt(r17, offset(r18), r22.readSInt32());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L147:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putLong(r17, offset(r18), r22.readSFixed64());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L148:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putInt(r17, offset(r18), r22.readSFixed32());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L149:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        int r50 = r22.readEnum();     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        Internal.EnumVerifier r51 = getEnumFieldVerifier(r16);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        if (r51 != null) goto L152;
    L155:
        UnsafeUtil.putInt(r17, offset(r18), r50);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L152:
        if (r51.isInRange(r50) == true) goto L155;
        r12 = SchemaUtil.storeUnknownEnum(r17, r14, r50, r12, r10);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L208
    L156:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putInt(r17, offset(r18), r22.readUInt32());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L157:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putObject(r17, offset(r18), r22.readBytes());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L158:
        r11 = r11;
        r49 = (MessageLite) mutableMessageFieldForMerge(r17, r16);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        r22.mergeMessageField(r49, getMessageFieldSchema(r16), r11);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L143
    L159:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        readString(r17, r18, r22);     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L160:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putBoolean(r17, offset(r18), r22.readBool());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L161:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putInt(r17, offset(r18), r22.readFixed32());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L162:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putLong(r17, offset(r18), r22.readFixed64());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L163:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putInt(r17, offset(r18), r22.readInt32());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L164:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putLong(r17, offset(r18), r22.readUInt64());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L165:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putLong(r17, offset(r18), r22.readInt64());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L166:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putFloat(r17, offset(r18), r22.readFloat());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L167:
        r12 = r12;
        r11 = r11;
        r10 = r10;
        UnsafeUtil.putDouble(r17, offset(r18), r22.readDouble());     // Catch: Throwable -> L170 InvalidProtocolBufferException.InvalidWireTypeException -> L225
        goto L145
    L240:
        r33 = (MessageLite) mutableOneofMessageFieldForMerge(r17, r14, r16);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
        r22.mergeGroupField(r33, getMessageFieldSchema(r16), r11);     // Catch: Throwable -> L85 InvalidProtocolBufferException.InvalidWireTypeException -> L226
    L85:
        th = th;
    L216:
        r10 = r10;
    L185:
        r11 = r11;
        r10 = r10;
    L211:
        th = th;
        goto L216
    L7:
        if (r14 == Integer.MAX_VALUE) goto L8;
        if (this.hasExtensions == true) goto L18;
        Object r111 = null;
    L19:
        if (r111 == null) goto L27;
        if (r13 != null) goto L23;
        Object r52 = r20.getMutableExtensions(r21);     // Catch: Throwable -> L47
    L24:
        T r53 = r15;
        r12 = r20.parseExtension(r21, r22, r111, r23, r52, r12, r19);     // Catch: Throwable -> L45
        r13 = r52;
    L26:
        r15 = r53;
    L45:
        th = th;
        r17 = r53;
        goto L216
    L23:
        r52 = r13;
        goto L24
    L27:
        r53 = r15;
        if (r10.shouldDiscardUnknownFields(r22) == true) goto L30;
        if (r12 != null) goto L35;
        r12 = r10.getBuilderFromMessage(r53);     // Catch: Throwable -> L45
    L35:
        if (r10.mergeOneFieldFrom(r12, r22, 0) == true) goto L26;
    L37:
        int r54 = this.checkInitializedCount;
        Object r55 = r12;
    L39:
        if (r54 >= this.repeatedFieldOffsetStart) goto L41;
        r55 = filterMapUnknownEnumValues(r21, this.intArray[r54], r55, r19, r21);
        r54 = r54 + 1;
        r53 = r53;
        goto L39
    L41:
        T r112 = r53;
        if (r55 == null) goto L262;
        r10.setBuilderToMessage(r112, r55);
        return;
    L262:
        return;
    L30:
        if (r22.skipField() == false) goto L37;
    L18:
        r111 = r20.findExtensionByNumber(r11, this.defaultInstance, r14);     // Catch: Throwable -> L47
    L47:
        th = th;
    L215:
        r17 = r15;
        goto L216
    L8:
        int r56 = this.checkInitializedCount;
        Object r57 = r12;
    L10:
        if (r56 >= this.repeatedFieldOffsetStart) goto L12;
        r57 = filterMapUnknownEnumValues(r21, this.intArray[r56], r57, r19, r21);
        r56 = r56 + 1;
        goto L10
    L12:
        if (r57 == null) goto L261;
        r10.setBuilderToMessage(r15, r57);
        return;
    L261:
        return;
    L213:
        th = th;
        goto L215
    }

    private final <K, V> void mergeMap(Object r10, int r11, Object r12, ExtensionRegistryLite r13, Reader r14) {
        long r15 = offset(typeAndOffsetAt(r11));
        Object r16 = UnsafeUtil.getObject(r10, r15);
        if (r16 != null) goto L6;
        r16 = this.mapFieldSchema.newMapField(r12);
        UnsafeUtil.putObject(r10, r15, r16);
    L8:
        r14.readMap(this.mapFieldSchema.forMutableMapData(r16), this.mapFieldSchema.forMapMetadata(r12), r13);
        return;
    L6:
        if (this.mapFieldSchema.isImmutable(r16) == false) goto L8;
        Object r17 = this.mapFieldSchema.newMapField(r12);
        this.mapFieldSchema.mergeFrom(r17, r16);
        UnsafeUtil.putObject(r10, r15, r17);
        r16 = r17;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T r10, T r11, int r12) {
        if (isFieldPresent(r11, r12) == true) goto L5;
        return;
    L5:
        long r13 = offset(typeAndOffsetAt(r12));
        Unsafe r14 = UNSAFE;
        Object r15 = r14.getObject(r11, r13);
        if (r15 == null) goto L21;
        Schema r16 = getMessageFieldSchema(r12);
        if (isFieldPresent(r10, r12) == false) goto L10;
        Object r17 = r14.getObject(r10, r13);
        if (isMutable(r17) == true) goto L18;
        Object r18 = r16.newInstance();
        r16.mergeFrom(r18, r17);
        r14.putObject(r10, r13, r18);
        r17 = r18;
    L18:
        r16.mergeFrom(r17, r15);
        return;
    L10:
        if (isMutable(r15) == true) goto L12;
        r14.putObject(r10, r13, r15);
    L13:
        setFieldPresent(r10, r12);
        return;
    L12:
        Object r19 = r16.newInstance();
        r16.mergeFrom(r19, r15);
        r14.putObject(r10, r13, r19);
        goto L13
    L21:
        throw new IllegalStateException("Source subfield " + numberAt(r12) + " is present but null: " + r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T r10, T r11, int r12) {
        int r13 = numberAt(r12);
        if (isOneofPresent(r11, r13, r12) == true) goto L5;
        return;
    L5:
        long r14 = offset(typeAndOffsetAt(r12));
        Unsafe r15 = UNSAFE;
        Object r16 = r15.getObject(r11, r14);
        if (r16 == null) goto L21;
        Schema r17 = getMessageFieldSchema(r12);
        if (isOneofPresent(r10, r13, r12) == false) goto L10;
        Object r18 = r15.getObject(r10, r14);
        if (isMutable(r18) == true) goto L18;
        Object r19 = r17.newInstance();
        r17.mergeFrom(r19, r18);
        r15.putObject(r10, r14, r19);
        r18 = r19;
    L18:
        r17.mergeFrom(r18, r16);
        return;
    L10:
        if (isMutable(r16) == true) goto L12;
        r15.putObject(r10, r14, r16);
    L13:
        setOneofPresent(r10, r13, r12);
        return;
    L12:
        Object r20 = r17.newInstance();
        r17.mergeFrom(r20, r16);
        r15.putObject(r10, r14, r20);
        goto L13
    L21:
        throw new IllegalStateException("Source subfield " + numberAt(r12) + " is present but null: " + r11);
    }

    private void mergeSingleField(T r10, T r11, int r12) {
        int r13 = typeAndOffsetAt(r12);
        long r14 = offset(r13);
        int r15 = numberAt(r12);
        switch(type(r13)) {
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
        mergeOneofMessage(r10, r11, r12);
        return;
    L12:
        SchemaUtil.mergeMap(this.mapFieldSchema, r10, r11, r14);
        return;
    L13:
        this.listFieldSchema.mergeListsAt(r10, r11, r14);
        return;
    L35:
        mergeMessage(r10, r11, r12);
        return;
    L88:
        return;
    L6:
        if (isOneofPresent(r11, r15, r12) == false) goto L65;
    L11:
        UnsafeUtil.putObject(r10, r14, UnsafeUtil.getObject(r11, r14));
        setOneofPresent(r10, r15, r12);
        return;
    L65:
        return;
    L10:
        if (isOneofPresent(r11, r15, r12) == true) goto L11;
        return;
    L15:
        if (isFieldPresent(r11, r12) == false) goto L71;
    L56:
        UnsafeUtil.putLong(r10, r14, UnsafeUtil.getLong(r11, r14));
    L63:
        setFieldPresent(r10, r12);
        return;
    L71:
        return;
    L18:
        if (isFieldPresent(r11, r12) == false) goto L72;
    L50:
        UnsafeUtil.putInt(r10, r14, UnsafeUtil.getInt(r11, r14));
        goto L63
    L72:
        return;
    L21:
        if (isFieldPresent(r11, r12) == true) goto L56;
        return;
    L24:
        if (isFieldPresent(r11, r12) == true) goto L50;
        return;
    L27:
        if (isFieldPresent(r11, r12) == true) goto L50;
        return;
    L30:
        if (isFieldPresent(r11, r12) == true) goto L50;
        return;
    L33:
        if (isFieldPresent(r11, r12) == false) goto L77;
    L38:
        UnsafeUtil.putObject(r10, r14, UnsafeUtil.getObject(r11, r14));
        goto L63
    L77:
        return;
    L37:
        if (isFieldPresent(r11, r12) == true) goto L38;
        return;
    L40:
        if (isFieldPresent(r11, r12) == false) goto L80;
        UnsafeUtil.putBoolean(r10, r14, UnsafeUtil.getBoolean(r11, r14));
        goto L63
    L80:
        return;
    L43:
        if (isFieldPresent(r11, r12) == true) goto L50;
        return;
    L46:
        if (isFieldPresent(r11, r12) == true) goto L56;
        return;
    L49:
        if (isFieldPresent(r11, r12) == true) goto L50;
        return;
    L52:
        if (isFieldPresent(r11, r12) == true) goto L56;
        return;
    L55:
        if (isFieldPresent(r11, r12) == true) goto L56;
        return;
    L58:
        if (isFieldPresent(r11, r12) == false) goto L86;
        UnsafeUtil.putFloat(r10, r14, UnsafeUtil.getFloat(r11, r14));
        goto L63
    L86:
        return;
    L61:
        if (isFieldPresent(r11, r12) == false) goto L87;
        UnsafeUtil.putDouble(r10, r14, UnsafeUtil.getDouble(r11, r14));
        goto L63
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T r10, int r11) {
        Schema r12 = getMessageFieldSchema(r11);
        long r13 = offset(typeAndOffsetAt(r11));
        if (isFieldPresent(r10, r11) == false) goto L5;
        Object r14 = UNSAFE.getObject(r10, r13);
        if (isMutable(r14) == false) goto L9;
        return r14;
    L9:
        Object r15 = r12.newInstance();
        if (r14 == null) goto L12;
        r12.mergeFrom(r15, r14);
    L12:
        return r15;
    L5:
        return r12.newInstance();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T r10, int r11, int r12) {
        Schema r13 = getMessageFieldSchema(r12);
        if (isOneofPresent(r10, r11, r12) == false) goto L5;
        Object r14 = UNSAFE.getObject(r10, offset(typeAndOffsetAt(r12)));
        if (isMutable(r14) == false) goto L9;
        return r14;
    L9:
        Object r15 = r13.newInstance();
        if (r14 == null) goto L12;
        r13.mergeFrom(r15, r14);
    L12:
        return r15;
    L5:
        return r13.newInstance();
    }

    static <T> MessageSchema<T> newSchema(Class<T> r10, MessageInfo r11, NewInstanceSchema r12, ListFieldSchema r13, UnknownFieldSchema<?, ?> r14, ExtensionSchema<?> r15, MapFieldSchema r16) {
        if ((r11 instanceof RawMessageInfo) == false) goto L7;
        return newSchemaForRawMessageInfo((RawMessageInfo) r11, r12, r13, r14, r15, r16);
    L7:
        return newSchemaForMessageInfo((StructuralMessageInfo) r11, r12, r13, r14, r15, r16);
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo r19, NewInstanceSchema r20, ListFieldSchema r21, UnknownFieldSchema<?, ?> r22, ExtensionSchema<?> r23, MapFieldSchema r24) {
        FieldInfo[] r10 = r19.getFields();
        if (r10.length != 0) goto L5;
        int r11 = 0;
        int r12 = 0;
    L6:
        int r13 = r10.length;
        int[] r14 = new int[r13 * 3];
        Object[] r15 = new Object[r13 * 2];
        int r16 = r10.length;
        int r17 = 0;
        int r18 = 0;
        int r25 = 0;
    L8:
        if (r17 >= r16) goto L18;
        FieldInfo r110 = r10[r17];
        if (r110.getType() != FieldType.MAP) goto L13;
        r18 = r18 + 1;
    L17:
        r17 = r17 + 1;
        goto L8
    L13:
        if (r110.getType().id() < 18) goto L17;
        if (r110.getType().id() > 49) goto L17;
        r25 = r25 + 1;
        goto L17
    L18:
        int[] r26 = null;
        if (r18 <= 0) goto L21;
        int[] r27 = new int[r18];
    L22:
        if (r25 <= 0) goto L24;
        r26 = new int[r25];
    L24:
        int[] r28 = r19.getCheckInitialized();
        if (r28 != null) goto L27;
        r28 = EMPTY_INT_ARRAY;
    L27:
        int r29 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
    L29:
        if (r29 >= r10.length) goto L45;
        FieldInfo r30 = r10[r29];
        int r115 = r30.getFieldNumber();
        storeFieldData(r30, r14, r111, r15);
        if (r112 >= r28.length) goto L36;
        if (r28[r112] != r115) goto L36;
        r28[r112] = r111;
        r112 = r112 + 1;
    L36:
        if (r30.getType() != FieldType.MAP) goto L40;
        r27[r113] = r111;
        r113 = r113 + 1;
    L44:
        r29 = r29 + 1;
        r111 = r111 + 3;
        goto L29
    L40:
        if (r30.getType().id() < 18) goto L44;
        if (r30.getType().id() > 49) goto L44;
        r26[r114] = (int) UnsafeUtil.objectFieldOffset(r30.getField());
        r114 = r114 + 1;
        goto L44
    L45:
        if (r27 != null) goto L47;
        r27 = EMPTY_INT_ARRAY;
    L47:
        if (r26 != null) goto L49;
        r26 = EMPTY_INT_ARRAY;
    L49:
        int r31 = (r28.length + r27.length) + r26.length;
        if (r31 <= 0) goto L52;
        int[] r32 = new int[r31];
        System.arraycopy(r28, 0, r32, 0, r28.length);
        System.arraycopy(r27, 0, r32, r28.length, r27.length);
        System.arraycopy(r26, 0, r32, r28.length + r27.length, r26.length);
    L54:
        return new MessageSchema(r14, r15, r11, r12, r19.getDefaultInstance(), true, r32, r28.length, r28.length + r27.length, r20, r21, r22, r23, r24);
    L52:
        r32 = EMPTY_INT_ARRAY;
        goto L54
    L21:
        r27 = null;
        goto L22
    L5:
        r11 = r10[0].getFieldNumber();
        r12 = r10[r10.length - 1].getFieldNumber();
        goto L6
    }

    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo r34, NewInstanceSchema r35, ListFieldSchema r36, UnknownFieldSchema<?, ?> r37, ExtensionSchema<?> r38, MapFieldSchema r39) {
        String r10 = r34.getStringInfo();
        int r11 = r10.length();
        char r12 = 55296;
        if (r10.charAt(0) < 55296) goto L8;
        int r13 = 1;
    L5:
        int r14 = r13 + 1;
        if (r10.charAt(r13) < 55296) goto L9;
        r13 = r14;
    L9:
        int r15 = r14 + 1;
        int r16 = r10.charAt(r14);
        if (r16 < 55296) goto L16;
        int r17 = r16 & 8191;
        int r18 = 13;
    L12:
        int r19 = r15 + 1;
        char r20 = r10.charAt(r15);
        if (r20 < 55296) goto L15;
        r17 = r17 | ((r20 & 8191) << r18);
        r18 = r18 + 13;
        r15 = r19;
        goto L12
    L15:
        r16 = r17 | (r20 << r18);
        r15 = r19;
    L16:
        if (r16 != 0) goto L18;
        int r21 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
        int[] r115 = EMPTY_INT_ARRAY;
        int r22 = 0;
    L75:
        Unsafe r23 = UNSAFE;
        Object[] r116 = r34.getObjects();
        Class<?> r24 = r34.getDefaultInstance().getClass();
        int[] r25 = new int[r110 * 3];
        Object[] r117 = new Object[r110 * 2];
        int r118 = r114 + r111;
        int r26 = r114;
        int r27 = r118;
        int r119 = 0;
        int r28 = 0;
    L76:
        if (r15 >= r11) goto L204;
        int r29 = r15 + 1;
        int r30 = r10.charAt(r15);
        if (r30 < r12) goto L84;
        int r31 = r30 & 8191;
        int r32 = r29;
        int r210 = 13;
    L80:
        int r211 = r32 + 1;
        char r33 = r10.charAt(r32);
        if (r33 < r12) goto L83;
        r31 = r31 | ((r33 & 8191) << r210);
        r210 = r210 + 13;
        r32 = r211;
        goto L80
    L83:
        r30 = r31 | (r33 << r210);
        int r40 = r211;
    L85:
        int r212 = r40 + 1;
        int r41 = r10.charAt(r40);
        if (r41 < r12) goto L92;
        int r42 = r41 & 8191;
        int r43 = r212;
        int r213 = 13;
    L88:
        int r214 = r43 + 1;
        char r44 = r10.charAt(r43);
        int r215 = r11;
        if (r44 < 55296) goto L91;
        r42 = r42 | ((r44 & 8191) << r213);
        r213 = r213 + 13;
        r43 = r214;
        r11 = r215;
        goto L88
    L91:
        r41 = r42 | (r44 << r213);
        int r45 = r214;
    L93:
        int r46 = r41 & 255;
        int r216 = r113;
        if ((r41 & 1024) == 0) goto L96;
        r115[r119] = r28;
        r119 = r119 + 1;
    L96:
        int r217 = r119;
        if (r46 < 51) goto L128;
        int r120 = r45 + 1;
        int r47 = r10.charAt(r45);
        char r121 = 55296;
        if (r47 < 55296) goto L105;
        int r48 = r47 & 8191;
        int r310 = 13;
    L101:
        int r311 = r120 + 1;
        char r122 = r10.charAt(r120);
        if (r122 < r121) goto L104;
        r48 = r48 | ((r122 & 8191) << r310);
        r310 = r310 + 13;
        r120 = r311;
        r121 = 55296;
        goto L101
    L104:
        r47 = r48 | (r122 << r310);
        r120 = r311;
    L105:
        int r123 = r46 - 51;
        int r312 = r120;
        if (r123 != 9) goto L108;
    L117:
        int r124 = r21 + 1;
        r117[((r28 / 3) * 2) + 1] = r116[r21];
    L118:
        r21 = r124;
    L119:
        int r49 = r47 * 2;
        Object r125 = r116[r49];
        if ((r125 instanceof java.lang.reflect.Field) == false) goto L122;
        java.lang.reflect.Field r126 = (java.lang.reflect.Field) r125;
    L123:
        int r127 = r112;
        int r128 = (int) r23.objectFieldOffset(r126);
        int r50 = r49 + 1;
        Object r129 = r116[r50];
        int r218 = r21;
        if ((r129 instanceof java.lang.reflect.Field) == false) goto L126;
        java.lang.reflect.Field r130 = (java.lang.reflect.Field) r129;
    L127:
        int r51 = (int) r23.objectFieldOffset(r130);
        r10 = r10;
        int r52 = r128;
        r116 = r116;
        int r131 = r218;
        int r219 = r312;
        int r53 = 0;
        int r220 = r127;
    L190:
        int r132 = r28 + 1;
        r25[r28] = r30;
        int r54 = r132 + 1;
        if ((r41 & 512) == 0) goto L193;
        int r133 = ENFORCE_UTF8_MASK;
    L194:
        Class<?> r221 = r24;
        if ((r41 & 256) == 0) goto L197;
        int r55 = REQUIRED_MASK;
    L198:
        int r56 = r55 | r133;
        if ((r41 & 2048) == 0) goto L201;
        int r57 = Integer.MIN_VALUE;
    L202:
        r25[r132] = r52 | ((r56 | r57) | (r46 << 20));
        int r58 = r54 + 1;
        r25[r54] = (r53 << 20) | r51;
        r21 = r131;
        r116 = r116;
        r24 = r221;
        r113 = r216;
        r112 = r220;
        r11 = r215;
        r15 = r219;
        r119 = r217;
        r12 = 55296;
        r28 = r58;
        r10 = r10;
        goto L76
    L201:
        r57 = 0;
        goto L202
    L197:
        r55 = 0;
        goto L198
    L193:
        r133 = 0;
        goto L194
    L126:
        r130 = reflectField(r24, (String) r129);
        r116[r50] = r130;
        goto L127
    L122:
        r126 = reflectField(r24, (String) r125);
        r116[r49] = r126;
        goto L123
    L108:
        if (r123 == 17) goto L117;
        if (r123 != 12) goto L119;
        if (r34.getSyntax().equals(ProtoSyntax.PROTO2) == false) goto L115;
    L116:
        r124 = r21 + 1;
        r117[((r28 / 3) * 2) + 1] = r116[r21];
        goto L118
    L115:
        if ((r41 & 2048) == 0) goto L119;
    L128:
        int r134 = r112;
        r131 = r21 + 1;
        java.lang.reflect.Field r59 = reflectField(r24, (String) r116[r21]);
        if (r46 != 9) goto L131;
    L161:
        r220 = r134;
        r117[((r28 / 3) * 2) + 1] = r59.getType();
    L163:
        int r60 = (int) r23.objectFieldOffset(r59);
        if ((r41 & 4096) == 0) goto L166;
        boolean r135 = true;
    L167:
        if (r135 == true) goto L169;
    L183:
        int r61 = 1048575;
        r219 = r45;
        r53 = 0;
    L185:
        if (r46 >= 18) goto L187;
    L189:
        r51 = r61;
        r52 = r60;
        goto L190
    L187:
        if (r46 > 49) goto L189;
        r115[r27] = r60;
        r27 = r27 + 1;
        goto L189
    L169:
        if (r46 > 17) goto L183;
        int r136 = r45 + 1;
        int r62 = r10.charAt(r45);
        if (r62 < 55296) goto L177;
        int r63 = r62 & 8191;
        int r222 = 13;
    L173:
        r219 = r136 + 1;
        char r137 = r10.charAt(r136);
        if (r137 < 55296) goto L176;
        r63 = r63 | ((r137 & 8191) << r222);
        r222 = r222 + 13;
        r136 = r219;
        goto L173
    L176:
        r62 = r63 | (r137 << r222);
    L178:
        int r138 = (r22 * 2) + (r62 / 32);
        Object r139 = r116[r138];
        if ((r139 instanceof java.lang.reflect.Field) == false) goto L181;
        java.lang.reflect.Field r140 = (java.lang.reflect.Field) r139;
    L182:
        r61 = (int) r23.objectFieldOffset(r140);
        r53 = r62 % 32;
        goto L185
    L181:
        r140 = reflectField(r24, (String) r139);
        r116[r138] = r140;
        goto L182
    L177:
        r219 = r136;
        goto L178
    L166:
        r135 = false;
        goto L167
    L131:
        if (r46 == 17) goto L161;
        if (r46 != 27) goto L136;
    L159:
        r220 = r134;
        int r223 = r131 + 1;
        r117[((r28 / 3) * 2) + 1] = r116[r131];
    L160:
        r131 = r223;
        goto L163
    L136:
        if (r46 == 49) goto L159;
        if (r46 != 12) goto L141;
    L152:
        r220 = r134;
        if (r34.getSyntax() != ProtoSyntax.PROTO2) goto L155;
    L158:
        r223 = r131 + 1;
        r117[((r28 / 3) * 2) + 1] = r116[r131];
        goto L160
    L155:
        if ((r41 & 2048) == 0) goto L163;
    L141:
        if (r46 == 30) goto L152;
        if (r46 == 44) goto L152;
        if (r46 != 50) goto L151;
        int r141 = r26 + 1;
        r115[r26] = r28;
        int r224 = (r28 / 3) * 2;
        int r225 = r131 + 1;
        r117[r224] = r116[r131];
        if ((r41 & 2048) == 0) goto L150;
        r131 = r225 + 1;
        r117[r224 + 1] = r116[r225];
        r26 = r141;
        r220 = r134;
        goto L163
    L150:
        r26 = r141;
        r131 = r225;
        r220 = r134;
        goto L163
    L151:
        r220 = r134;
        goto L163
    L92:
        r215 = r11;
        r45 = r212;
        goto L93
    L84:
        r40 = r29;
        goto L85
    L204:
        return new MessageSchema(r25, r117, r112, r113, r34.getDefaultInstance(), false, r115, r114, r118, r35, r36, r37, r38, r39);
    L18:
        int r64 = r15 + 1;
        int r65 = r10.charAt(r15);
        if (r65 < 55296) goto L25;
        int r66 = r65 & 8191;
        int r67 = 13;
    L21:
        int r68 = r64 + 1;
        char r69 = r10.charAt(r64);
        if (r69 < 55296) goto L24;
        r66 = r66 | ((r69 & 8191) << r67);
        r67 = r67 + 13;
        r64 = r68;
        goto L21
    L24:
        r65 = r66 | (r69 << r67);
        r64 = r68;
    L25:
        int r70 = r64 + 1;
        int r71 = r10.charAt(r64);
        if (r71 < 55296) goto L32;
        int r72 = r71 & 8191;
        int r73 = 13;
    L28:
        int r142 = r70 + 1;
        char r74 = r10.charAt(r70);
        if (r74 < 55296) goto L31;
        r72 = r72 | ((r74 & 8191) << r73);
        r73 = r73 + 13;
        r70 = r142;
        goto L28
    L31:
        r71 = r72 | (r74 << r73);
        r70 = r142;
    L32:
        int r75 = r70 + 1;
        int r76 = r10.charAt(r70);
        if (r76 < 55296) goto L39;
        int r77 = r76 & 8191;
        int r143 = 13;
    L35:
        int r144 = r75 + 1;
        char r78 = r10.charAt(r75);
        if (r78 < 55296) goto L38;
        r77 = r77 | ((r78 & 8191) << r143);
        r143 = r143 + 13;
        r75 = r144;
        goto L35
    L38:
        r76 = r77 | (r78 << r143);
        r75 = r144;
    L39:
        int r145 = r75 + 1;
        int r79 = r10.charAt(r75);
        if (r79 < 55296) goto L46;
        int r80 = r79 & 8191;
        int r146 = 13;
    L42:
        int r147 = r145 + 1;
        char r148 = r10.charAt(r145);
        if (r148 < 55296) goto L45;
        r80 = r80 | ((r148 & 8191) << r146);
        r146 = r146 + 13;
        r145 = r147;
        goto L42
    L45:
        r79 = r80 | (r148 << r146);
        r145 = r147;
    L46:
        int r149 = r145 + 1;
        r110 = r10.charAt(r145);
        if (r110 < 55296) goto L53;
        int r150 = r110 & 8191;
        int r151 = 13;
    L49:
        int r152 = r149 + 1;
        char r153 = r10.charAt(r149);
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
        r111 = r10.charAt(r149);
        if (r111 < 55296) goto L60;
        int r155 = r111 & 8191;
        int r156 = 13;
    L56:
        int r157 = r154 + 1;
        char r158 = r10.charAt(r154);
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
        int r160 = r10.charAt(r154);
        if (r160 < 55296) goto L67;
        int r161 = r160 & 8191;
        int r162 = 13;
    L63:
        int r163 = r159 + 1;
        char r164 = r10.charAt(r159);
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
        int r166 = r10.charAt(r159);
        if (r166 < 55296) goto L74;
        int r167 = r166 & 8191;
        int r168 = 13;
    L70:
        int r169 = r165 + 1;
        char r170 = r10.charAt(r165);
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
        int r172 = (r65 * 2) + r71;
        r22 = r65;
        r114 = r166;
        r15 = r165;
        r113 = r79;
        r112 = r76;
        r21 = r172;
        r115 = r171;
        goto L75
    L8:
        r14 = 1;
        goto L9
    }

    private int numberAt(int r10) {
        return this.buffer[r10];
    }

    private static long offset(int r10) {
        return r10 & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T r10, long r11) {
        return ((Boolean) UnsafeUtil.getObject(r10, r11)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T r10, long r11) {
        return ((Double) UnsafeUtil.getObject(r10, r11)).doubleValue();
    }

    private static <T> float oneofFloatAt(T r10, long r11) {
        return ((Float) UnsafeUtil.getObject(r10, r11)).floatValue();
    }

    private static <T> int oneofIntAt(T r10, long r11) {
        return ((Integer) UnsafeUtil.getObject(r10, r11)).intValue();
    }

    private static <T> long oneofLongAt(T r10, long r11) {
        return ((Long) UnsafeUtil.getObject(r10, r11)).longValue();
    }

    private <K, V> int parseMapField(T r10, byte[] r11, int r12, int r13, int r14, long r15, ArrayDecoders.Registers r17) {
        Unsafe r16 = UNSAFE;
        Object r18 = getMapFieldDefaultEntry(r14);
        Object r19 = r16.getObject(r10, r15);
        if (this.mapFieldSchema.isImmutable(r19) == false) goto L6;
        Object r20 = this.mapFieldSchema.newMapField(r18);
        this.mapFieldSchema.mergeFrom(r20, r19);
        r16.putObject(r10, r15, r20);
        r19 = r20;
    L6:
        return decodeMapEntry(r11, r12, r13, this.mapFieldSchema.forMapMetadata(r18), this.mapFieldSchema.forMutableMapData(r19), r17);
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
        int r10 = ArrayDecoders.decodeVarint64(r18, r19, r29);
        long r13 = CodedInputStream.decodeZigZag64(r29.long1);
    L54:
        Object r14 = Long.valueOf(r13);
    L55:
        r11.putObject(r17, r26, r14);
    L63:
        r11.putInt(r17, r12, r22);
        return r10;
    L83:
        return r19;
    L10:
        if (r23 != 0) goto L84;
        r10 = ArrayDecoders.decodeVarint32(r18, r19, r29);
        int r15 = CodedInputStream.decodeZigZag32(r29.int1);
    L51:
        r14 = Integer.valueOf(r15);
        goto L55
    L84:
        return r19;
    L12:
        if (r23 != 0) goto L85;
        int r16 = ArrayDecoders.decodeVarint32(r18, r19, r29);
        int r27 = r29.int1;
        Internal.EnumVerifier r30 = getEnumFieldVerifier(r28);
        if (r30 != null) goto L16;
    L19:
        r11.putObject(r17, r26, Integer.valueOf(r27));
        r11.putInt(r17, r12, r22);
    L80:
        return r16;
    L16:
        if (r30.isInRange(r27) == true) goto L19;
        getMutableUnknownFields(r17).storeField(r21, Long.valueOf(r27));
        goto L80
    L85:
        return r19;
    L21:
        if (r23 != 2) goto L86;
        r10 = ArrayDecoders.decodeBytes(r18, r19, r29);
        r14 = r29.object1;
        goto L55
    L86:
        return r19;
    L23:
        if (r23 != 2) goto L87;
        Object r110 = mutableOneofMessageFieldForMerge(r17, r22, r28);
        int r31 = ArrayDecoders.mergeMessageField(r110, getMessageFieldSchema(r28), r18, r19, r20, r29);
    L25:
        storeOneofMessageField(r17, r22, r28, r110);
        return r31;
    L87:
        return r19;
    L26:
        if (r23 != 2) goto L88;
        r10 = ArrayDecoders.decodeVarint32(r18, r19, r29);
        int r32 = r29.int1;
        if (r32 != 0) goto L31;
        r14 = "";
        goto L55
    L31:
        if ((r24 & ENFORCE_UTF8_MASK) != 0) goto L33;
    L37:
        r11.putObject(r17, r26, new String(r18, r10, r32, Internal.UTF_8));
        r10 = r10 + r32;
        goto L63
    L33:
        if (Utf8.isValidUtf8(r18, r10, r10 + r32) == true) goto L37;
        throw InvalidProtocolBufferException.invalidUtf8();
    L88:
        return r19;
    L38:
        if (r23 != 0) goto L89;
        r10 = ArrayDecoders.decodeVarint64(r18, r19, r29);
        if (r29.long1 == 0) goto L42;
        boolean r111 = true;
    L43:
        r14 = Boolean.valueOf(r111);
        goto L55
    L42:
        r111 = false;
        goto L43
    L89:
        return r19;
    L44:
        if (r23 != 5) goto L90;
        Object r33 = Integer.valueOf(ArrayDecoders.decodeFixed32(r18, r19));
    L58:
        r11.putObject(r17, r26, r33);
        r10 = r19 + 4;
        goto L63
    L90:
        return r19;
    L49:
        if (r23 != 0) goto L92;
        r10 = ArrayDecoders.decodeVarint32(r18, r19, r29);
        r15 = r29.int1;
        goto L51
    L92:
        return r19;
    L52:
        if (r23 != 0) goto L93;
        r10 = ArrayDecoders.decodeVarint64(r18, r19, r29);
        r13 = r29.long1;
        goto L54
    L93:
        return r19;
    L56:
        if (r23 != 5) goto L94;
        r33 = Float.valueOf(ArrayDecoders.decodeFloat(r18, r19));
        goto L58
    L94:
        return r19;
    L6:
        if (r23 != 3) goto L65;
        r110 = mutableOneofMessageFieldForMerge(r17, r22, r28);
        r31 = ArrayDecoders.mergeGroupField(r110, getMessageFieldSchema(r28), r18, r19, r20, (r21 & (-8)) | 4, r29);
        goto L25
    L65:
        return r19;
    L47:
        if (r23 != 1) goto L91;
        Object r34 = Long.valueOf(ArrayDecoders.decodeFixed64(r18, r19));
    L62:
        r11.putObject(r17, r26, r34);
        r10 = r19 + 8;
        goto L63
    L91:
        return r19;
    L60:
        if (r23 != 1) goto L95;
        r34 = Double.valueOf(ArrayDecoders.decodeDouble(r18, r19));
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
        int r12 = ArrayDecoders.decodePackedVarint32List(r15, r16, r11, r27);
    L23:
        Internal.ProtobufList r110 = r11;
        SchemaUtil.filterUnknownEnumList(r14, r19, r110, getEnumFieldVerifier(r21), null, this.unknownFieldSchema);
        return r12;
    L21:
        if (r20 != 0) goto L103;
        r12 = ArrayDecoders.decodeVarint32List(r18, r15, r16, r17, r11, r27);
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
        long r13 = r22 & 536870912;
        Internal.ProtobufList r23 = r11;
        if (r13 != 0) goto L86;
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

    private int positionForFieldNumber(int r10) {
        if (r10 >= this.minFieldNumber) goto L5;
        return -1;
    L5:
        if (r10 <= this.maxFieldNumber) goto L7;
        return -1;
    L7:
        return slowPositionForFieldNumber(r10, 0);
    }

    private int positionForFieldNumber(int r10, int r11) {
        if (r10 >= this.minFieldNumber) goto L5;
        return -1;
    L5:
        if (r10 <= this.maxFieldNumber) goto L7;
        return -1;
    L7:
        return slowPositionForFieldNumber(r10, r11);
    }

    private int presenceMaskAndOffsetAt(int r10) {
        return this.buffer[r10 + 2];
    }

    private <E> void readGroupList(Object r10, long r11, Reader r12, Schema<E> r13, ExtensionRegistryLite r14) {
        r12.readGroupList(this.listFieldSchema.mutableListAt(r10, r11), r13, r14);
    }

    private <E> void readMessageList(Object r10, int r11, Reader r12, Schema<E> r13, ExtensionRegistryLite r14) {
        long r15 = offset(r11);
        r12.readMessageList(this.listFieldSchema.mutableListAt(r10, r15), r13, r14);
    }

    private void readString(Object r10, int r11, Reader r12) {
        if (isEnforceUtf8(r11) == false) goto L6;
        long r13 = offset(r11);
        Object r14 = r12.readStringRequireUtf8();
    L5:
        UnsafeUtil.putObject(r10, r13, r14);
        return;
    L6:
        boolean r15 = this.lite;
        r13 = offset(r11);
        if (r15 == false) goto L9;
        r14 = r12.readString();
        goto L5
    L9:
        r14 = r12.readBytes();
        goto L5
    }

    private void readStringList(Object r10, int r11, Reader r12) {
        boolean r13 = isEnforceUtf8(r11);
        ListFieldSchema r14 = this.listFieldSchema;
        if (r13 == false) goto L5;
        r12.readStringListRequireUtf8(r14.mutableListAt(r10, offset(r11)));
        return;
    L5:
        r12.readStringList(r14.mutableListAt(r10, offset(r11)));
    }

    private static java.lang.reflect.Field reflectField(Class<?> r10, String r11) {
        return r10.getDeclaredField(r11);
    L4:
        e = move-exception;
        java.lang.reflect.Field[] r12 = r10.getDeclaredFields();
        int r13 = r12.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L12;
        java.lang.reflect.Field r15 = r12[r14];
        if (r11.equals(r15.getName()) == true) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        return r15;
    L12:
        throw new RuntimeException("Field " + r11 + " for " + r10.getName() + " not found. Known fields are " + Arrays.toString(r12), e);
    }

    private void setFieldPresent(T r10, int r11) {
        int r12 = presenceMaskAndOffsetAt(r11);
        long r13 = 1048575 & r12;
        if (r13 != 1048575) goto L5;
        return;
    L5:
        UnsafeUtil.putInt(r10, r13, (1 << (r12 >>> 20)) | UnsafeUtil.getInt(r10, r13));
    }

    private void setOneofPresent(T r10, int r11, int r12) {
        UnsafeUtil.putInt(r10, presenceMaskAndOffsetAt(r12) & 1048575, r11);
    }

    private int slowPositionForFieldNumber(int r10, int r11) {
        int r12 = (this.buffer.length / 3) - 1;
    L3:
        if (r11 > r12) goto L10;
        int r13 = (r12 + r11) >>> 1;
        int r14 = r13 * 3;
        int r15 = numberAt(r14);
        if (r10 == r15) goto L6;
        if (r10 < r15) goto L8;
        r11 = r13 + 1;
        goto L3
    L8:
        r12 = r13 - 1;
        goto L3
    L6:
        return r14;
    L10:
        return -1;
    }

    private static void storeFieldData(FieldInfo r10, int[] r11, int r12, Object[] r13) {
        OneofInfo r14 = r10.getOneof();
        int r15 = 0;
        if (r14 == null) goto L6;
        int r16 = r10.getType().id() + 51;
        int r17 = (int) UnsafeUtil.objectFieldOffset(r14.getValueField());
        java.lang.reflect.Field r18 = r14.getCaseField();
    L5:
        int r19 = (int) UnsafeUtil.objectFieldOffset(r18);
        int r20 = 0;
    L19:
        r11[r12] = r10.getFieldNumber();
        int r21 = r12 + 1;
        if (r10.isEnforceUtf8() == false) goto L22;
        int r22 = ENFORCE_UTF8_MASK;
    L24:
        if (r10.isRequired() == false) goto L26;
        r15 = REQUIRED_MASK;
    L26:
        r11[r21] = ((r15 | r22) | (r16 << 20)) | r17;
        r11[r12 + 2] = r19 | (r20 << 20);
        Class<?> r23 = r10.getMessageFieldClass();
        if (r10.getMapDefaultEntry() == null) goto L34;
        int r110 = (r12 / 3) * 2;
        r13[r110] = r10.getMapDefaultEntry();
        if (r23 == null) goto L32;
        r13[r110 + 1] = r23;
        return;
    L32:
        if (r10.getEnumVerifier() == null) goto L41;
        r13[r110 + 1] = r10.getEnumVerifier();
        return;
    L41:
        return;
    L34:
        if (r23 == null) goto L37;
        r13[((r12 / 3) * 2) + 1] = r23;
        return;
    L37:
        if (r10.getEnumVerifier() == null) goto L44;
        r13[((r12 / 3) * 2) + 1] = r10.getEnumVerifier();
        return;
    L44:
        return;
    L22:
        r22 = 0;
        goto L24
    L6:
        FieldType r24 = r10.getType();
        r17 = (int) UnsafeUtil.objectFieldOffset(r10.getField());
        r16 = r24.id();
        if (r24.isList() == true) goto L16;
        if (r24.isMap() == true) goto L16;
        java.lang.reflect.Field r25 = r10.getPresenceField();
        if (r25 != null) goto L13;
        r19 = 1048575;
    L14:
        r20 = Integer.numberOfTrailingZeros(r10.getPresenceMask());
        goto L19
    L13:
        r19 = (int) UnsafeUtil.objectFieldOffset(r25);
    L16:
        if (r10.getCachedSizeField() != null) goto L18;
        r19 = 0;
        r20 = 0;
        goto L19
    L18:
        r18 = r10.getCachedSizeField();
        goto L5
    }

    private void storeMessageField(T r10, int r11, Object r12) {
        UNSAFE.putObject(r10, offset(typeAndOffsetAt(r11)), r12);
        setFieldPresent(r10, r11);
    }

    private void storeOneofMessageField(T r10, int r11, int r12, Object r13) {
        UNSAFE.putObject(r10, offset(typeAndOffsetAt(r12)), r13);
        setOneofPresent(r10, r11, r12);
    }

    private static int type(int r10) {
        return (r10 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int r10) {
        return this.buffer[r10 + 1];
    }

    private void writeFieldsInAscendingOrder(T r22, Writer r23) {
        if (this.hasExtensions == false) goto L7;
        FieldSet<T> r10 = this.extensionSchema.getExtensions(r22);
        if (r10.isEmpty() == true) goto L7;
        Iterator r11 = r10.iterator();
        Map.Entry<?, ?> r12 = (Map.Entry) r11.next();
        Iterator r13 = r11;
    L8:
        int r14 = this.buffer.length;
        Unsafe r15 = UNSAFE;
        int r16 = 1048575;
        int r17 = 1048575;
        int r18 = 0;
        int r19 = 0;
    L9:
        if (r19 >= r14) goto L175;
        int r20 = typeAndOffsetAt(r19);
        int r21 = numberAt(r19);
        int r24 = type(r20);
        if (r24 > 17) goto L19;
        int r25 = this.buffer[r19 + 2];
        int r110 = r25 & r16;
        Map.Entry<?, ?> r111 = r12;
        if (r110 == r17) goto L18;
        if (r110 != r16) goto L16;
        r18 = 0;
    L17:
        r17 = r110;
        goto L18
    L16:
        r18 = r15.getInt(r22, r110);
    L18:
        int r26 = 1 << (r25 >>> 20);
        int r27 = r17;
        int r112 = r26;
        Map.Entry<?, ?> r113 = r111;
    L20:
        int r114 = r18;
    L21:
        if (r113 == null) goto L28;
        if (this.extensionSchema.extensionNumber(r113) > r21) goto L28;
        this.extensionSchema.serializeExtension(r23, r113);
        if (r13.hasNext() == true) goto L26;
        r113 = null;
        goto L21
    L26:
        r113 = (Map.Entry) r13.next();
    L28:
        long r28 = offset(r20);
        switch(r24) {
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
        int r29 = r14;
        Map.Entry<?, ?> r115 = r113;
    L173:
        r19 = r19 + 3;
        r17 = r27;
        r12 = r115;
        r18 = r114;
        r14 = r29;
        r16 = 1048575;
        goto L9
    L85:
        writeMapHelper(r23, r21, r15.getObject(r22, r28), r19);
        goto L30
    L86:
        SchemaUtil.writeGroupList(numberAt(r19), (List) r15.getObject(r22, r28), r23, getMessageFieldSchema(r19));
        goto L30
    L87:
        SchemaUtil.writeSInt64List(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L88:
        SchemaUtil.writeSInt32List(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L89:
        SchemaUtil.writeSFixed64List(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L90:
        SchemaUtil.writeSFixed32List(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L91:
        SchemaUtil.writeEnumList(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L92:
        SchemaUtil.writeUInt32List(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L93:
        SchemaUtil.writeBoolList(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L94:
        SchemaUtil.writeFixed32List(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L95:
        SchemaUtil.writeFixed64List(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L96:
        SchemaUtil.writeInt32List(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L97:
        SchemaUtil.writeUInt64List(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L98:
        SchemaUtil.writeInt64List(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L99:
        SchemaUtil.writeFloatList(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L100:
        SchemaUtil.writeDoubleList(numberAt(r19), (List) r15.getObject(r22, r28), r23, true);
        goto L30
    L101:
        boolean r30 = false;
        SchemaUtil.writeSInt64List(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
    L118:
        r29 = r14;
        r115 = r113;
        goto L173
    L102:
        r30 = false;
        SchemaUtil.writeSInt32List(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L103:
        r30 = false;
        SchemaUtil.writeSFixed64List(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L104:
        r30 = false;
        SchemaUtil.writeSFixed32List(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L105:
        r30 = false;
        SchemaUtil.writeEnumList(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L106:
        r30 = false;
        SchemaUtil.writeUInt32List(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L107:
        SchemaUtil.writeBytesList(numberAt(r19), (List) r15.getObject(r22, r28), r23);
        goto L30
    L108:
        SchemaUtil.writeMessageList(numberAt(r19), (List) r15.getObject(r22, r28), r23, getMessageFieldSchema(r19));
        goto L30
    L109:
        SchemaUtil.writeStringList(numberAt(r19), (List) r15.getObject(r22, r28), r23);
        goto L30
    L110:
        r30 = false;
        SchemaUtil.writeBoolList(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L111:
        r30 = false;
        SchemaUtil.writeFixed32List(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L112:
        r30 = false;
        SchemaUtil.writeFixed64List(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L113:
        r30 = false;
        SchemaUtil.writeInt32List(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L114:
        r30 = false;
        SchemaUtil.writeUInt64List(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L115:
        r30 = false;
        SchemaUtil.writeInt64List(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L116:
        r30 = false;
        SchemaUtil.writeFloatList(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L117:
        r30 = false;
        SchemaUtil.writeDoubleList(numberAt(r19), (List) r15.getObject(r22, r28), r23, false);
        goto L118
    L119:
        r115 = r113;
        r29 = r14;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeGroup(r21, r15.getObject(r22, r28), getMessageFieldSchema(r19));
        goto L173
    L122:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeSInt64(r21, r15.getLong(r22, r28));
        goto L173
    L125:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeSInt32(r21, r15.getInt(r22, r28));
        goto L173
    L128:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeSFixed64(r21, r15.getLong(r22, r28));
        goto L173
    L131:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeSFixed32(r21, r15.getInt(r22, r28));
        goto L173
    L134:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeEnum(r21, r15.getInt(r22, r28));
        goto L173
    L137:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeUInt32(r21, r15.getInt(r22, r28));
        goto L173
    L140:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeBytes(r21, (ByteString) r15.getObject(r22, r28));
        goto L173
    L143:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeMessage(r21, r15.getObject(r22, r28), getMessageFieldSchema(r19));
        goto L173
    L146:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        writeString(r21, r15.getObject(r22, r28), r23);
        goto L173
    L149:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeBool(r21, booleanAt(r22, r28));
        goto L173
    L152:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeFixed32(r21, r15.getInt(r22, r28));
        goto L173
    L155:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeFixed64(r21, r15.getLong(r22, r28));
        goto L173
    L158:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeInt32(r21, r15.getInt(r22, r28));
        goto L173
    L161:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeUInt64(r21, r15.getLong(r22, r28));
        goto L173
    L164:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeInt64(r21, r15.getLong(r22, r28));
        goto L173
    L167:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeFloat(r21, floatAt(r22, r28));
        goto L173
    L170:
        r29 = r14;
        r115 = r113;
        if (isFieldPresent(r22, r19, r27, r114, r112) == false) goto L173;
        r23.writeDouble(r21, doubleAt(r22, r28));
        goto L173
    L32:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeGroup(r21, r15.getObject(r22, r28), getMessageFieldSchema(r19));
        goto L30
    L35:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeSInt64(r21, oneofLongAt(r22, r28));
        goto L30
    L38:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeSInt32(r21, oneofIntAt(r22, r28));
        goto L30
    L41:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeSFixed64(r21, oneofLongAt(r22, r28));
        goto L30
    L44:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeSFixed32(r21, oneofIntAt(r22, r28));
        goto L30
    L47:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeEnum(r21, oneofIntAt(r22, r28));
        goto L30
    L50:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeUInt32(r21, oneofIntAt(r22, r28));
        goto L30
    L53:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeBytes(r21, (ByteString) r15.getObject(r22, r28));
        goto L30
    L56:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeMessage(r21, r15.getObject(r22, r28), getMessageFieldSchema(r19));
        goto L30
    L59:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        writeString(r21, r15.getObject(r22, r28), r23);
        goto L30
    L62:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeBool(r21, oneofBooleanAt(r22, r28));
        goto L30
    L65:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeFixed32(r21, oneofIntAt(r22, r28));
        goto L30
    L68:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeFixed64(r21, oneofLongAt(r22, r28));
        goto L30
    L71:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeInt32(r21, oneofIntAt(r22, r28));
        goto L30
    L74:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeUInt64(r21, oneofLongAt(r22, r28));
        goto L30
    L77:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeInt64(r21, oneofLongAt(r22, r28));
        goto L30
    L80:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeFloat(r21, oneofFloatAt(r22, r28));
        goto L30
    L83:
        if (isOneofPresent(r22, r21, r19) == false) goto L30;
        r23.writeDouble(r21, oneofDoubleAt(r22, r28));
        goto L30
    L19:
        r27 = r17;
        r113 = r12;
        r112 = 0;
    L175:
        if (r12 == null) goto L180;
        this.extensionSchema.serializeExtension(r23, r12);
        if (r13.hasNext() == true) goto L178;
        r12 = null;
        goto L175
    L178:
        r12 = (Map.Entry) r13.next();
        goto L175
    L180:
        writeUnknownInMessageTo(this.unknownFieldSchema, r22, r23);
        return;
    L7:
        r12 = null;
        r13 = null;
        goto L8
    }

    private void writeFieldsInDescendingOrder(T r11, Writer r12) {
        writeUnknownInMessageTo(this.unknownFieldSchema, r11, r12);
        if (this.hasExtensions == false) goto L7;
        FieldSet<T> r10 = this.extensionSchema.getExtensions(r11);
        if (r10.isEmpty() == true) goto L7;
        Iterator r13 = r10.descendingIterator();
        Map.Entry<?, ?> r14 = (Map.Entry) r13.next();
    L8:
        int r15 = this.buffer.length - 3;
    L9:
        if (r15 < 0) goto L177;
        int r16 = typeAndOffsetAt(r15);
        int r17 = numberAt(r15);
    L11:
        if (r14 == null) goto L19;
        if (this.extensionSchema.extensionNumber(r14) <= r17) goto L19;
        this.extensionSchema.serializeExtension(r12, r14);
        if (r13.hasNext() == true) goto L16;
        r14 = null;
        goto L11
    L16:
        r14 = (Map.Entry) r13.next();
    L19:
        switch(type(r16)) {
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
        writeMapHelper(r12, r17, UnsafeUtil.getObject(r11, offset(r16)), r15);
        goto L176
    L76:
        SchemaUtil.writeGroupList(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, getMessageFieldSchema(r15));
        goto L176
    L77:
        SchemaUtil.writeSInt64List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L78:
        SchemaUtil.writeSInt32List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L79:
        SchemaUtil.writeSFixed64List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L80:
        SchemaUtil.writeSFixed32List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L81:
        SchemaUtil.writeEnumList(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L82:
        SchemaUtil.writeUInt32List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L83:
        SchemaUtil.writeBoolList(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L84:
        SchemaUtil.writeFixed32List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L85:
        SchemaUtil.writeFixed64List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L86:
        SchemaUtil.writeInt32List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L87:
        SchemaUtil.writeUInt64List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L88:
        SchemaUtil.writeInt64List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L89:
        SchemaUtil.writeFloatList(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L90:
        SchemaUtil.writeDoubleList(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, true);
        goto L176
    L91:
        SchemaUtil.writeSInt64List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L92:
        SchemaUtil.writeSInt32List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L93:
        SchemaUtil.writeSFixed64List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L94:
        SchemaUtil.writeSFixed32List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L95:
        SchemaUtil.writeEnumList(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L96:
        SchemaUtil.writeUInt32List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L97:
        SchemaUtil.writeBytesList(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12);
        goto L176
    L98:
        SchemaUtil.writeMessageList(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, getMessageFieldSchema(r15));
        goto L176
    L99:
        SchemaUtil.writeStringList(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12);
        goto L176
    L100:
        SchemaUtil.writeBoolList(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L101:
        SchemaUtil.writeFixed32List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L102:
        SchemaUtil.writeFixed64List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L103:
        SchemaUtil.writeInt32List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L104:
        SchemaUtil.writeUInt64List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L105:
        SchemaUtil.writeInt64List(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L106:
        SchemaUtil.writeFloatList(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L107:
        SchemaUtil.writeDoubleList(numberAt(r15), (List) UnsafeUtil.getObject(r11, offset(r16)), r12, false);
        goto L176
    L22:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
    L110:
        r12.writeGroup(r17, UnsafeUtil.getObject(r11, offset(r16)), getMessageFieldSchema(r15));
        goto L176
    L25:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        long r18 = oneofLongAt(r11, offset(r16));
    L114:
        r12.writeSInt64(r17, r18);
        goto L176
    L28:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        int r19 = oneofIntAt(r11, offset(r16));
    L118:
        r12.writeSInt32(r17, r19);
        goto L176
    L31:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        long r20 = oneofLongAt(r11, offset(r16));
    L122:
        r12.writeSFixed64(r17, r20);
        goto L176
    L34:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        int r21 = oneofIntAt(r11, offset(r16));
    L126:
        r12.writeSFixed32(r17, r21);
        goto L176
    L37:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        int r22 = oneofIntAt(r11, offset(r16));
    L130:
        r12.writeEnum(r17, r22);
        goto L176
    L40:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        int r23 = oneofIntAt(r11, offset(r16));
    L134:
        r12.writeUInt32(r17, r23);
        goto L176
    L43:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
    L137:
        r12.writeBytes(r17, (ByteString) UnsafeUtil.getObject(r11, offset(r16)));
        goto L176
    L46:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
    L140:
        r12.writeMessage(r17, UnsafeUtil.getObject(r11, offset(r16)), getMessageFieldSchema(r15));
        goto L176
    L49:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
    L143:
        writeString(r17, UnsafeUtil.getObject(r11, offset(r16)), r12);
        goto L176
    L52:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        boolean r24 = oneofBooleanAt(r11, offset(r16));
    L147:
        r12.writeBool(r17, r24);
        goto L176
    L55:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        int r25 = oneofIntAt(r11, offset(r16));
    L151:
        r12.writeFixed32(r17, r25);
        goto L176
    L58:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        long r26 = oneofLongAt(r11, offset(r16));
    L155:
        r12.writeFixed64(r17, r26);
        goto L176
    L61:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        int r27 = oneofIntAt(r11, offset(r16));
    L159:
        r12.writeInt32(r17, r27);
        goto L176
    L64:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        long r28 = oneofLongAt(r11, offset(r16));
    L163:
        r12.writeUInt64(r17, r28);
        goto L176
    L67:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        long r29 = oneofLongAt(r11, offset(r16));
    L167:
        r12.writeInt64(r17, r29);
        goto L176
    L70:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        float r30 = oneofFloatAt(r11, offset(r16));
    L171:
        r12.writeFloat(r17, r30);
        goto L176
    L73:
        if (isOneofPresent(r11, r17, r15) == false) goto L176;
        double r31 = oneofDoubleAt(r11, offset(r16));
    L175:
        r12.writeDouble(r17, r31);
        goto L176
    L109:
        if (isFieldPresent(r11, r15) == false) goto L176;
    L112:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r18 = longAt(r11, offset(r16));
        goto L114
    L116:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r19 = intAt(r11, offset(r16));
        goto L118
    L120:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r20 = longAt(r11, offset(r16));
        goto L122
    L124:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r21 = intAt(r11, offset(r16));
        goto L126
    L128:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r22 = intAt(r11, offset(r16));
        goto L130
    L132:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r23 = intAt(r11, offset(r16));
        goto L134
    L136:
        if (isFieldPresent(r11, r15) == false) goto L176;
    L139:
        if (isFieldPresent(r11, r15) == false) goto L176;
    L142:
        if (isFieldPresent(r11, r15) == false) goto L176;
    L145:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r24 = booleanAt(r11, offset(r16));
        goto L147
    L149:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r25 = intAt(r11, offset(r16));
        goto L151
    L153:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r26 = longAt(r11, offset(r16));
        goto L155
    L157:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r27 = intAt(r11, offset(r16));
        goto L159
    L161:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r28 = longAt(r11, offset(r16));
        goto L163
    L165:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r29 = longAt(r11, offset(r16));
        goto L167
    L169:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r30 = floatAt(r11, offset(r16));
        goto L171
    L173:
        if (isFieldPresent(r11, r15) == false) goto L176;
        r31 = doubleAt(r11, offset(r16));
    L176:
        r15 = r15 - 3;
    L177:
        if (r14 == null) goto L182;
        this.extensionSchema.serializeExtension(r12, r14);
        if (r13.hasNext() == true) goto L180;
        r14 = null;
        goto L177
    L180:
        r14 = (Map.Entry) r13.next();
        goto L177
    L182:
        return;
    L7:
        r13 = null;
        r14 = null;
        goto L8
    }

    private <K, V> void writeMapHelper(Writer r10, int r11, Object r12, int r13) {
        if (r12 == null) goto L5;
        r10.writeMap(r11, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(r13)), this.mapFieldSchema.forMapData(r12));
        return;
    }

    private void writeString(int r10, Object r11, Writer r12) {
        if ((r11 instanceof String) == false) goto L5;
        r12.writeString(r10, (String) r11);
        return;
    L5:
        r12.writeBytes(r10, (ByteString) r11);
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> r10, T r11, Writer r12) {
        r10.writeTo(r10.getFromMessage(r11), r12);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T r10, T r11) {
        int r12 = this.buffer.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (equals(r10, r11, r13) == false) goto L6;
        r13 = r13 + 3;
        goto L3
    L6:
        return false;
    L9:
        if (this.unknownFieldSchema.getFromMessage(r10).equals(this.unknownFieldSchema.getFromMessage(r11)) == true) goto L12;
        return false;
    L12:
        if (this.hasExtensions == true) goto L14;
        return true;
    L14:
        return this.extensionSchema.getExtensions(r10).equals(this.extensionSchema.getExtensions(r11));
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v189 */
    /* JADX WARN: Type inference failed for: r0v191 */
    /* JADX WARN: Type inference failed for: r0v193 */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v2 */
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
    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T r19) {
        Unsafe r10 = UNSAFE;
        int r11 = 1048575;
        ?? r12 = 0;
        int r13 = 1048575;
        ?? r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r15 >= this.buffer.length) goto L229;
        int r17 = typeAndOffsetAt(r15);
        int r18 = type(r17);
        int r110 = numberAt(r15);
        int r20 = this.buffer[r15 + 2];
        int r21 = r20 & r11;
        int r22 = r13;
        ?? r23 = r14;
        if (r18 > 17) goto L13;
        if (r21 == r13) goto L12;
        if (r21 != r11) goto L10;
        ?? r24 = r12;
    L11:
        r23 = r24;
        r22 = r21 == true ? 1 : 0;
        goto L12
    L10:
        r24 = r10.getInt(r19, r21 == true ? 1 : 0);
    L12:
        int r111 = r22;
        ?? r112 = r23;
        ?? r113 = 1 << (r20 >>> 20);
    L14:
        long r25 = offset(r17);
        if (r18 < FieldType.DOUBLE_LIST_PACKED.id()) goto L19;
        ?? r26 = r21;
        if (r18 > FieldType.SINT64_LIST_PACKED.id()) goto L19;
    L20:
        ?? r27 = r26;
        switch(r18) {
            case 0: goto L224;
            case 1: goto L221;
            case 2: goto L218;
            case 3: goto L215;
            case 4: goto L212;
            case 5: goto L209;
            case 6: goto L207;
            case 7: goto L202;
            case 8: goto L196;
            case 9: goto L193;
            case 10: goto L190;
            case 11: goto L187;
            case 12: goto L184;
            case 13: goto L181;
            case 14: goto L178;
            case 15: goto L175;
            case 16: goto L172;
            case 17: goto L169;
            case 18: goto L165;
            case 19: goto L164;
            case 20: goto L163;
            case 21: goto L162;
            case 22: goto L161;
            case 23: goto L165;
            case 24: goto L164;
            case 25: goto L160;
            case 26: goto L159;
            case 27: goto L158;
            case 28: goto L157;
            case 29: goto L156;
            case 30: goto L155;
            case 31: goto L164;
            case 32: goto L165;
            case 33: goto L154;
            case 34: goto L153;
            case 35: goto L147;
            case 36: goto L142;
            case 37: goto L137;
            case 38: goto L132;
            case 39: goto L127;
            case 40: goto L122;
            case 41: goto L117;
            case 42: goto L112;
            case 43: goto L107;
            case 44: goto L102;
            case 45: goto L97;
            case 46: goto L92;
            case 47: goto L87;
            case 48: goto L82;
            case 49: goto L81;
            case 50: goto L80;
            case 51: goto L78;
            case 52: goto L75;
            case 53: goto L72;
            case 54: goto L69;
            case 55: goto L66;
            case 56: goto L63;
            case 57: goto L60;
            case 58: goto L57;
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
            default: goto L167;
        };
    L80:
        int r28 = this.mapFieldSchema.getSerializedSize(r110, r10.getObject(r19, r25), getMapFieldDefaultEntry(r15));
    L166:
        r16 = r16 + r28;
        goto L167
    L81:
        r28 = SchemaUtil.computeSizeGroupList(r110, (List) r10.getObject(r19, r25), getMessageFieldSchema(r15));
        goto L166
    L82:
        int r29 = SchemaUtil.computeSizeSInt64ListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == true) goto L151;
    L152:
        r28 = (CodedOutputStream.computeTagSize(r110) + CodedOutputStream.computeUInt32SizeNoTag(r29)) + r29;
    L151:
        r10.putInt(r19, r27 == true ? 1 : 0, r29);
        goto L152
    L87:
        r29 = SchemaUtil.computeSizeSInt32ListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L92:
        r29 = SchemaUtil.computeSizeFixed64ListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L97:
        r29 = SchemaUtil.computeSizeFixed32ListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L102:
        r29 = SchemaUtil.computeSizeEnumListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L107:
        r29 = SchemaUtil.computeSizeUInt32ListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L112:
        r29 = SchemaUtil.computeSizeBoolListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L117:
        r29 = SchemaUtil.computeSizeFixed32ListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L122:
        r29 = SchemaUtil.computeSizeFixed64ListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L127:
        r29 = SchemaUtil.computeSizeInt32ListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L132:
        r29 = SchemaUtil.computeSizeUInt64ListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L137:
        r29 = SchemaUtil.computeSizeInt64ListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L142:
        r29 = SchemaUtil.computeSizeFixed32ListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L147:
        r29 = SchemaUtil.computeSizeFixed64ListNoTag((List) r10.getObject(r19, r25));
        if (r29 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L153:
        r28 = SchemaUtil.computeSizeSInt64List(r110, (List) r10.getObject(r19, r25), r12);
        goto L166
    L154:
        r28 = SchemaUtil.computeSizeSInt32List(r110, (List) r10.getObject(r19, r25), r12);
        goto L166
    L155:
        r28 = SchemaUtil.computeSizeEnumList(r110, (List) r10.getObject(r19, r25), r12);
        goto L166
    L156:
        r28 = SchemaUtil.computeSizeUInt32List(r110, (List) r10.getObject(r19, r25), r12);
        goto L166
    L157:
        r28 = SchemaUtil.computeSizeByteStringList(r110, (List) r10.getObject(r19, r25));
        goto L166
    L158:
        r28 = SchemaUtil.computeSizeMessageList(r110, (List) r10.getObject(r19, r25), getMessageFieldSchema(r15));
        goto L166
    L159:
        r28 = SchemaUtil.computeSizeStringList(r110, (List) r10.getObject(r19, r25));
        goto L166
    L160:
        r28 = SchemaUtil.computeSizeBoolList(r110, (List) r10.getObject(r19, r25), r12);
        goto L166
    L161:
        r28 = SchemaUtil.computeSizeInt32List(r110, (List) r10.getObject(r19, r25), r12);
        goto L166
    L162:
        r28 = SchemaUtil.computeSizeUInt64List(r110, (List) r10.getObject(r19, r25), r12);
        goto L166
    L163:
        r28 = SchemaUtil.computeSizeInt64List(r110, (List) r10.getObject(r19, r25), r12);
        goto L166
    L164:
        r28 = SchemaUtil.computeSizeFixed32List(r110, (List) r10.getObject(r19, r25), r12);
        goto L166
    L165:
        r28 = SchemaUtil.computeSizeFixed64List(r110, (List) r10.getObject(r19, r25), r12);
        goto L166
    L209:
        ?? r114 = r12;
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L228;
        int r30 = CodedOutputStream.computeFixed64Size(r110, 0);
        r114 = r114;
    L227:
        r16 = r16 + r30;
    L228:
        r15 = r15 + 3;
        r13 = r111;
        r12 = r114;
        r14 = r112;
        r11 = 1048575;
        goto L4
    L212:
        r114 = r12;
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L228;
        r30 = CodedOutputStream.computeInt32Size(r110, r10.getInt(r19, r25));
        r114 = r114;
        goto L227
    L215:
        r114 = r12;
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L228;
        r30 = CodedOutputStream.computeUInt64Size(r110, r10.getLong(r19, r25));
        r114 = r114;
        goto L227
    L218:
        r114 = r12;
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L228;
        r30 = CodedOutputStream.computeInt64Size(r110, r10.getLong(r19, r25));
        r114 = r114;
        goto L227
    L221:
        r114 = r12;
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L228;
        r30 = CodedOutputStream.computeFloatSize(r110, 0.0f);
        r114 = r114;
        goto L227
    L224:
        r114 = r12;
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L228;
        r30 = CodedOutputStream.computeDoubleSize(r110, 0.0d);
        r114 = r114;
    L167:
        r114 = r12;
        goto L228
    L24:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeGroupSize(r110, (MessageLite) r10.getObject(r19, r25), getMessageFieldSchema(r15));
        goto L166
    L27:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeSInt64Size(r110, oneofLongAt(r19, r25));
        goto L166
    L30:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeSInt32Size(r110, oneofIntAt(r19, r25));
        goto L166
    L33:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeSFixed64Size(r110, 0);
        goto L166
    L36:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeSFixed32Size(r110, r12);
        goto L166
    L39:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeEnumSize(r110, oneofIntAt(r19, r25));
        goto L166
    L42:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeUInt32Size(r110, oneofIntAt(r19, r25));
        goto L166
    L45:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeBytesSize(r110, (ByteString) r10.getObject(r19, r25));
        goto L166
    L48:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = SchemaUtil.computeSizeMessage(r110, r10.getObject(r19, r25), getMessageFieldSchema(r15));
        goto L166
    L51:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        Object r31 = r10.getObject(r19, r25);
        if ((r31 instanceof ByteString) == false) goto L55;
        r28 = CodedOutputStream.computeBytesSize(r110, (ByteString) r31);
        goto L166
    L55:
        r28 = CodedOutputStream.computeStringSize(r110, (String) r31);
        goto L166
    L57:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeBoolSize(r110, true);
        goto L166
    L60:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeFixed32Size(r110, r12);
        goto L166
    L63:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeFixed64Size(r110, 0);
        goto L166
    L66:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeInt32Size(r110, oneofIntAt(r19, r25));
        goto L166
    L69:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeUInt64Size(r110, oneofLongAt(r19, r25));
        goto L166
    L72:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeInt64Size(r110, oneofLongAt(r19, r25));
        goto L166
    L75:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeFloatSize(r110, 0.0f);
        goto L166
    L78:
        if (isOneofPresent(r19, r110, r15) == false) goto L167;
        r28 = CodedOutputStream.computeDoubleSize(r110, 0.0d);
        goto L166
    L169:
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L205;
        int r32 = CodedOutputStream.computeGroupSize(r110, (MessageLite) r10.getObject(r19, r25), getMessageFieldSchema(r15));
    L204:
        r16 = r16 + r32;
    L205:
        r114 = 0;
        goto L228
    L172:
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L205;
        r32 = CodedOutputStream.computeSInt64Size(r110, r10.getLong(r19, r25));
        goto L204
    L175:
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L205;
        r32 = CodedOutputStream.computeSInt32Size(r110, r10.getInt(r19, r25));
        goto L204
    L178:
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L205;
        r32 = CodedOutputStream.computeSFixed64Size(r110, 0);
        goto L204
    L181:
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L205;
        r16 = r16 + CodedOutputStream.computeSFixed32Size(r110, 0);
        goto L205
    L184:
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L205;
        r32 = CodedOutputStream.computeEnumSize(r110, r10.getInt(r19, r25));
        goto L204
    L187:
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L205;
        r32 = CodedOutputStream.computeUInt32Size(r110, r10.getInt(r19, r25));
        goto L204
    L190:
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L205;
        r32 = CodedOutputStream.computeBytesSize(r110, (ByteString) r10.getObject(r19, r25));
        goto L204
    L193:
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L205;
        r32 = SchemaUtil.computeSizeMessage(r110, r10.getObject(r19, r25), getMessageFieldSchema(r15));
        goto L204
    L196:
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L205;
        Object r33 = r10.getObject(r19, r25);
        if ((r33 instanceof ByteString) == false) goto L200;
        r32 = CodedOutputStream.computeBytesSize(r110, (ByteString) r33);
        goto L204
    L200:
        r32 = CodedOutputStream.computeStringSize(r110, (String) r33);
        goto L204
    L202:
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L205;
        r32 = CodedOutputStream.computeBoolSize(r110, true);
        goto L204
    L207:
        if (isFieldPresent(r19, r15, r111 == true ? 1 : 0, r112 == true ? 1 : 0, r113 == true ? 1 : 0) == false) goto L205;
        r114 = 0;
        r30 = CodedOutputStream.computeFixed32Size(r110, 0);
    L19:
        r26 = r12;
        goto L20
    L13:
        r111 = r13 == true ? 1 : 0;
        r112 = r14 == true ? 1 : 0;
        r113 = r12;
        goto L14
    L229:
        int r115 = r16 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, r19);
        if (this.hasExtensions == true) goto L232;
        return r115;
    L232:
        return r115 + this.extensionSchema.getExtensions(r19).getSerializedSize();
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T r10) {
        int r11 = this.buffer.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L82;
        int r14 = typeAndOffsetAt(r12);
        int r15 = numberAt(r12);
        long r16 = offset(r14);
        int r17 = 37;
        switch(type(r14)) {
            case 0: goto L77;
            case 1: goto L75;
            case 2: goto L74;
            case 3: goto L74;
            case 4: goto L73;
            case 5: goto L74;
            case 6: goto L73;
            case 7: goto L71;
            case 8: goto L70;
            case 9: goto L66;
            case 10: goto L64;
            case 11: goto L73;
            case 12: goto L73;
            case 13: goto L73;
            case 14: goto L74;
            case 15: goto L73;
            case 16: goto L74;
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
            default: goto L81;
        };
    L61:
        Object r18 = UnsafeUtil.getObject(r10, r16);
        if (r18 != null) goto L68;
    L69:
        r13 = (r13 * 53) + r17;
    L68:
        r17 = r18.hashCode();
    L64:
        int r19 = r13 * 53;
        Object r20 = UnsafeUtil.getObject(r10, r16);
    L65:
        int r21 = r20.hashCode();
    L80:
        r13 = r19 + r21;
        goto L81
    L66:
        r18 = UnsafeUtil.getObject(r10, r16);
        if (r18 == null) goto L69;
    L70:
        r19 = r13 * 53;
        r21 = ((String) UnsafeUtil.getObject(r10, r16)).hashCode();
        goto L80
    L71:
        r19 = r13 * 53;
        boolean r22 = UnsafeUtil.getBoolean(r10, r16);
    L72:
        r21 = Internal.hashBoolean(r22);
        goto L80
    L73:
        r19 = r13 * 53;
        r21 = UnsafeUtil.getInt(r10, r16);
        goto L80
    L74:
        r19 = r13 * 53;
        long r23 = UnsafeUtil.getLong(r10, r16);
    L79:
        r21 = Internal.hashLong(r23);
        goto L80
    L75:
        r19 = r13 * 53;
        float r24 = UnsafeUtil.getFloat(r10, r16);
    L76:
        r21 = Float.floatToIntBits(r24);
        goto L80
    L77:
        r19 = r13 * 53;
        double r25 = UnsafeUtil.getDouble(r10, r16);
    L78:
        r23 = Double.doubleToLongBits(r25);
        goto L79
    L8:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L33:
        r20 = UnsafeUtil.getObject(r10, r16);
        r19 = r13 * 53;
        goto L65
    L11:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L54:
        r19 = r13 * 53;
        r23 = oneofLongAt(r10, r16);
        goto L79
    L14:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L48:
        r19 = r13 * 53;
        r21 = oneofIntAt(r10, r16);
        goto L80
    L17:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L20:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L23:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L26:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L29:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L32:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L35:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L38:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
        r19 = r13 * 53;
        r22 = oneofBooleanAt(r10, r16);
        goto L72
    L41:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L44:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L47:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L50:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L53:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
    L56:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
        r19 = r13 * 53;
        r24 = oneofFloatAt(r10, r16);
        goto L76
    L59:
        if (isOneofPresent(r10, r15, r12) == false) goto L81;
        r19 = r13 * 53;
        r25 = oneofDoubleAt(r10, r16);
    L81:
        r12 = r12 + 3;
        goto L3
    L82:
        int r26 = (r13 * 53) + this.unknownFieldSchema.getFromMessage(r10).hashCode();
        if (this.hasExtensions == true) goto L85;
        return r26;
    L85:
        return (r26 * 53) + this.extensionSchema.getExtensions(r10).hashCode();
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T r18) {
        int r10 = 1048575;
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= this.checkInitializedCount) goto L49;
        int r13 = this.intArray[r12];
        int r14 = numberAt(r13);
        int r15 = typeAndOffsetAt(r13);
        int r16 = this.buffer[r13 + 2];
        int r17 = r16 & 1048575;
        int r19 = 1 << (r16 >>> 20);
        if (r17 == r10) goto L10;
        if (r17 == 1048575) goto L9;
        r11 = UNSAFE.getInt(r18, r17);
    L9:
        int r110 = r11;
        int r111 = r17;
    L12:
        if (isRequired(r15) == true) goto L14;
    L16:
        int r20 = type(r15);
        if (r20 == 9) goto L43;
        if (r20 == 17) goto L43;
        if (r20 == 27) goto L40;
        if (r20 == 60) goto L35;
        if (r20 == 68) goto L35;
        if (r20 == 49) goto L40;
        if (r20 != 50) goto L47;
        if (isMapInitialized(r18, r15, r13) == true) goto L47;
        return false;
    L47:
        r12 = r12 + 1;
        r10 = r111;
        r11 = r110;
    L35:
        if (isOneofPresent(r18, r14, r13) == false) goto L47;
        if (isInitialized(r18, r15, getMessageFieldSchema(r13)) == true) goto L47;
        return false;
    L40:
        if (isListInitialized(r18, r15, r13) == true) goto L47;
        return false;
    L43:
        if (isFieldPresent(r18, r13, r111, r110, r19) == false) goto L47;
        if (isInitialized(r18, r15, getMessageFieldSchema(r13)) == true) goto L47;
        return false;
    L14:
        if (isFieldPresent(r18, r13, r111, r110, r19) == true) goto L16;
        return false;
    L10:
        r111 = r10;
        r110 = r11;
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
    public void makeImmutable(T r10) {
        if (isMutable(r10) == true) goto L6;
        return;
    L6:
        if ((r10 instanceof GeneratedMessageLite) == false) goto L8;
        GeneratedMessageLite r11 = (GeneratedMessageLite) r10;
        r11.clearMemoizedSerializedSize();
        r11.clearMemoizedHashCode();
        r11.markImmutable();
    L8:
        int r12 = this.buffer.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L29;
        int r14 = typeAndOffsetAt(r13);
        long r15 = offset(r14);
        int r16 = type(r14);
        if (r16 == 9) goto L26;
        if (r16 == 60) goto L23;
        if (r16 == 68) goto L23;
        switch(r16) {
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
        Unsafe r17 = UNSAFE;
        Object r18 = r17.getObject(r10, r15);
        if (r18 == null) goto L28;
        r17.putObject(r10, r15, this.mapFieldSchema.toImmutable(r18));
        goto L28
    L21:
        this.listFieldSchema.makeImmutableListAt(r10, r15);
    L28:
        r13 = r13 + 3;
    L23:
        if (isOneofPresent(r10, numberAt(r13), r13) == false) goto L28;
    L27:
        getMessageFieldSchema(r13).makeImmutable(UNSAFE.getObject(r10, r15));
    L26:
        if (isFieldPresent(r10, r13) == false) goto L28;
    L29:
        this.unknownFieldSchema.makeImmutable(r10);
        if (this.hasExtensions == false) goto L41;
        this.extensionSchema.makeImmutable(r10);
        return;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r10, Reader r11, ExtensionRegistryLite r12) {
        Objects.requireNonNull(r12);
        checkMutable(r10);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, r10, r11, r12);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r10, T r11) {
        checkMutable(r10);
        Objects.requireNonNull(r11);
        int r12 = 0;
    L4:
        if (r12 >= this.buffer.length) goto L6;
        mergeSingleField(r10, r11, r12);
        r12 = r12 + 3;
        goto L4
    L6:
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, r10, r11);
        if (this.hasExtensions == false) goto L11;
        SchemaUtil.mergeExtensions(this.extensionSchema, r10, r11);
        return;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r10, byte[] r11, int r12, int r13, ArrayDecoders.Registers r14) {
        parseMessage(r10, r11, r12, r13, 0, r14);
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @CanIgnoreReturnValue
    int parseMessage(T r28, byte[] r29, int r30, int r31, int r32, ArrayDecoders.Registers r33) {
        MessageSchema<T> r15 = this;
        T r14 = r28;
        byte[] r12 = r29;
        r31 = r31;
        r32 = r32;
        ArrayDecoders.Registers r10 = r33;
        checkMutable(r28);
        Unsafe r11 = UNSAFE;
        int r13 = r30;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = -1;
        int r20 = 1048575;
    L3:
        if (r13 >= r31) goto L135;
        int r21 = r13 + 1;
        byte r22 = r12[r13];
        if (r22 >= 0) goto L7;
        int r23 = ArrayDecoders.decodeVarint32(r22, r12, r21, r10);
        int r24 = r10.int1;
        r21 = r23;
    L8:
        int r25 = r24 >>> 3;
        int r26 = r24 & 7;
        if (r25 <= r19) goto L11;
        int r27 = r15.positionForFieldNumber(r25, r16 / 3);
    L12:
        int r34 = r27;
        if (r34 == (-1)) goto L14;
        int r35 = r15.buffer[r34 + 1];
        int r36 = type(r35);
        long r110 = offset(r35);
        int r111 = r24;
        if (r36 <= 17) goto L17;
        int r210 = r25;
        int r112 = r20;
        int r113 = r18;
        if (r36 == 27) goto L96;
        int r211 = r112;
        if (r36 > 49) goto L112;
        int r37 = r21;
        Unsafe r212 = r11;
        int r213 = r34;
        int r114 = r111;
        r13 = parseRepeatedField(r28, r29, r21, r31, r111, r210, r26, r34, r35, r36, r110, r33);
        if (r13 == r37) goto L124;
    L111:
        r15 = this;
        r14 = r28;
        r12 = r29;
        r32 = r32;
        r10 = r33;
        r17 = r114;
        r18 = r113;
        r16 = r213;
        r20 = r211;
        r19 = r210;
        r11 = r212;
    L124:
        int r38 = r13;
    L120:
        int r39 = r114;
    L125:
        if (r39 != r32) goto L129;
        if (r32 == 0) goto L129;
        int r40 = 1048575;
        MessageSchema<T> r115 = this;
        int r41 = r38;
        r18 = r113;
        int r42 = r211;
    L136:
        if (r42 == r40) goto L138;
        T r43 = r28;
        r212.putInt(r43, r42, r18);
    L139:
        UnknownFieldSetLite r44 = null;
        int r116 = r115.checkInitializedCount;
    L141:
        if (r116 >= r115.repeatedFieldOffsetStart) goto L143;
        r44 = (UnknownFieldSetLite) filterMapUnknownEnumValues(r28, r115.intArray[r116], r44, r115.unknownFieldSchema, r28);
        r116 = r116 + 1;
        goto L141
    L143:
        if (r44 == null) goto L146;
        r115.unknownFieldSchema.setBuilderToMessage(r43, r44);
    L146:
        if (r32 != 0) goto L151;
        if (r41 != r31) goto L150;
    L153:
        return r41;
    L150:
        throw InvalidProtocolBufferException.parseFailure();
    L151:
        if (r41 > r31) goto L155;
        if (r39 == r32) goto L153;
    L155:
        throw InvalidProtocolBufferException.parseFailure();
    L138:
        r43 = r28;
    L129:
        if (this.hasExtensions == true) goto L131;
    L133:
        r13 = ArrayDecoders.decodeUnknownField(r39, r29, r38, r31, getMutableUnknownFields(r28), r33);
    L134:
        r14 = r28;
        r12 = r29;
        r17 = r39;
        r15 = this;
        r10 = r33;
        r18 = r113;
        r16 = r213;
        r20 = r211;
        r19 = r210;
        r11 = r212;
        r32 = r32;
        goto L3
    L131:
        if (r33.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) goto L133;
        r13 = ArrayDecoders.decodeExtensionOrUnknownField(r39, r29, r38, r31, r28, this.defaultInstance, this.unknownFieldSchema, r33);
        goto L134
    L112:
        int r117 = r21;
        r212 = r11;
        r213 = r34;
        r114 = r111;
        if (r36 == 50) goto L115;
        r13 = parseOneofField(r28, r29, r117, r31, r114, r210, r26, r35, r36, r110, r213, r33);
        if (r13 == r117) goto L124;
    L115:
        if (r26 != 2) goto L119;
        r13 = parseMapField(r28, r29, r117, r31, r213, r110, r33);
        if (r13 == r117) goto L124;
    L119:
        r38 = r117;
        goto L120
    L96:
        if (r26 != 2) goto L106;
        Internal.ProtobufList r45 = (Internal.ProtobufList) r11.getObject(r14, r110);
        if (r45.isModifiable() == true) goto L104;
        int r46 = r45.size();
        if (r46 != 0) goto L102;
        int r47 = 10;
    L103:
        r45 = r45.mutableCopyWithCapacity(r47);
        r11.putObject(r14, r110, r45);
        goto L104
    L102:
        r47 = r46 * 2;
    L104:
        r13 = ArrayDecoders.decodeMessageList(r15.getMessageFieldSchema(r34), r111, r29, r21, r31, r45, r33);
        r32 = r32;
        r16 = r34;
        r17 = r111;
        r18 = r113;
        r20 = r112;
        r19 = r210;
        r12 = r29;
        goto L3
    L106:
        r211 = r112;
        r117 = r21;
        r212 = r11;
        r213 = r34;
        r114 = r111;
        goto L119
    L17:
        int r48 = r15.buffer[r34 + 2];
        int r118 = 1 << (r48 >>> 20);
        int r119 = 1048575;
        int r49 = r48 & 1048575;
        if (r49 == r20) goto L25;
        if (r20 == 1048575) goto L21;
        r11.putInt(r14, r20, r18);
        r119 = 1048575;
    L21:
        if (r49 != r119) goto L23;
        int r50 = 0;
    L24:
        r211 = r49;
        int r120 = r50;
    L27:
        switch(r36) {
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
        byte[] r51 = r29;
        r210 = r25;
        int r52 = r34;
        int r121 = r111;
        byte r122 = -1;
        if (r26 != 0) goto L92;
        r13 = ArrayDecoders.decodeVarint32(r51, r21, r10);
        int r53 = r10.int1;
        Internal.EnumVerifier r54 = r15.getEnumFieldVerifier(r52);
        if (isLegacyEnumIsClosed(r35) == false) goto L48;
        if (r54 == null) goto L48;
        if (r54.isInRange(r53) == true) goto L48;
        getMutableUnknownFields(r28).storeField(r121, Long.valueOf(r53));
        r32 = r32;
        r16 = r52;
        r18 = r120;
        r17 = r121;
        r19 = r210;
        r12 = r51;
        r20 = r211;
    L48:
        r11.putInt(r14, r110, r53);
    L90:
        r18 = r120 | r118;
        r12 = r51;
    L91:
        r16 = r52;
        r17 = r121;
        r20 = r211;
        r19 = r210;
    L92:
        r38 = r21;
        r213 = r52;
        r212 = r11;
        r113 = r120;
        r39 = r121;
        r32 = r32;
        goto L125
    L28:
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r122 = -1;
        goto L92
    L30:
        if (r26 != 3) goto L32;
        Object r55 = r15.mutableMessageFieldForMerge(r14, r34);
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r13 = ArrayDecoders.mergeGroupField(r55, r15.getMessageFieldSchema(r34), r29, r21, r31, (r25 << 3) | 4, r33);
        r15.storeMessageField(r14, r52, r55);
        r18 = r120 | r118;
        r12 = r29;
        goto L91
    L32:
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r122 = -1;
        goto L92
    L33:
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r122 = -1;
        byte[] r56 = r29;
        if (r26 != 0) goto L92;
        int r57 = ArrayDecoders.decodeVarint64(r56, r21, r10);
        long r123 = CodedInputStream.decodeZigZag64(r10.long1);
    L82:
        r11.putLong(r28, r110, r123);
        r18 = r120 | r118;
        r12 = r56;
        r13 = r57;
        goto L91
    L36:
        r51 = r29;
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r122 = -1;
        if (r26 != 0) goto L92;
        r13 = ArrayDecoders.decodeVarint32(r51, r21, r10);
        int r58 = CodedInputStream.decodeZigZag32(r10.int1);
    L78:
        r11.putInt(r14, r110, r58);
        goto L90
    L49:
        r51 = r29;
        r210 = r25;
        r52 = r34;
        r121 = r111;
        long r59 = r110;
        r122 = -1;
        if (r26 != 2) goto L92;
        r13 = ArrayDecoders.decodeBytes(r51, r21, r10);
    L52:
        r11.putObject(r14, r59, r10.object1);
        goto L90
    L53:
        r51 = r29;
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r122 = -1;
        if (r26 != 2) goto L92;
        Object r60 = r15.mutableMessageFieldForMerge(r14, r52);
        r13 = ArrayDecoders.mergeMessageField(r60, r15.getMessageFieldSchema(r52), r29, r21, r31, r33);
        r15.storeMessageField(r14, r52, r60);
        goto L90
    L56:
        r51 = r29;
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r59 = r110;
        r122 = -1;
        if (r26 != 2) goto L92;
        if (isEnforceUtf8(r35) == false) goto L61;
        r13 = ArrayDecoders.decodeStringRequireUtf8(r51, r21, r10);
        goto L52
    L61:
        r13 = ArrayDecoders.decodeString(r51, r21, r10);
        goto L52
    L62:
        r51 = r29;
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r122 = -1;
        if (r26 != 0) goto L92;
        r13 = ArrayDecoders.decodeVarint64(r51, r21, r10);
        if (r10.long1 == 0) goto L67;
        boolean r61 = true;
    L68:
        UnsafeUtil.putBoolean(r14, r110, r61);
        goto L90
    L67:
        r61 = false;
        goto L68
    L69:
        r51 = r29;
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r122 = -1;
        if (r26 != 5) goto L92;
        r11.putInt(r14, r110, ArrayDecoders.decodeFixed32(r51, r21));
    L86:
        r13 = r21 + 4;
        goto L90
    L72:
        r51 = r29;
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r122 = -1;
        if (r26 != 1) goto L92;
        r11.putLong(r28, r110, ArrayDecoders.decodeFixed64(r51, r21));
        r13 = r21 + 8;
        goto L90
    L75:
        r51 = r29;
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r122 = -1;
        if (r26 != 0) goto L92;
        r13 = ArrayDecoders.decodeVarint32(r51, r21, r10);
        r58 = r10.int1;
        goto L78
    L79:
        r56 = r29;
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r122 = -1;
        if (r26 != 0) goto L92;
        r57 = ArrayDecoders.decodeVarint64(r56, r21, r10);
        r123 = r10.long1;
        goto L82
    L83:
        r51 = r29;
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r122 = -1;
        if (r26 != 5) goto L92;
        UnsafeUtil.putFloat(r14, r110, ArrayDecoders.decodeFloat(r51, r21));
        goto L86
    L87:
        r51 = r29;
        r210 = r25;
        r52 = r34;
        r121 = r111;
        r122 = -1;
        if (r26 != 1) goto L92;
        UnsafeUtil.putDouble(r14, r110, ArrayDecoders.decodeDouble(r51, r21));
        r13 = r21 + 8;
        goto L90
    L23:
        r50 = r11.getInt(r14, r49);
        goto L24
    L25:
        r120 = r18;
        r211 = r20;
        goto L27
    L14:
        r210 = r25;
        r38 = r21;
        r39 = r24;
        r113 = r18;
        r211 = r20;
        r212 = r11;
        r32 = r32;
        r213 = 0;
        goto L125
    L11:
        r27 = r15.positionForFieldNumber(r25);
        goto L12
    L7:
        r24 = r22;
        goto L8
    L135:
        int r214 = r20;
        r212 = r11;
        r32 = r32;
        r115 = r15;
        r41 = r13;
        r39 = r17;
        r42 = r214;
        r40 = 1048575;
        goto L136
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T r10, Writer r11) {
        if (r11.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L5;
        writeFieldsInDescendingOrder(r10, r11);
        return;
    L5:
        writeFieldsInAscendingOrder(r10, r11);
    }
}
