package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
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
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
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

    private MessageSchema(int[] r9, Object[] r10, int r11, int r12, MessageLite r13, boolean r14, int[] r15, int r16, int r17, NewInstanceSchema r18, ListFieldSchema r19, UnknownFieldSchema<?, ?> r20, ExtensionSchema<?> r21, MapFieldSchema r22) {
        MessageLite r2 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r13, MessageLite.class, "com.obric.memorydata.plugin");
        NewInstanceSchema r4 = (NewInstanceSchema) ZeusTransformUtils.wrapperContextForParams(r18, NewInstanceSchema.class, "com.obric.memorydata.plugin");
        ListFieldSchema r5 = (ListFieldSchema) ZeusTransformUtils.wrapperContextForParams(r19, ListFieldSchema.class, "com.obric.memorydata.plugin");
        MapFieldSchema r3 = (MapFieldSchema) ZeusTransformUtils.wrapperContextForParams(r22, MapFieldSchema.class, "com.obric.memorydata.plugin");
        this.buffer = r9;
        this.objects = r10;
        this.minFieldNumber = r11;
        this.maxFieldNumber = r12;
        this.lite = ZeusTransformUtils.instanceOf(r2, GeneratedMessageLite.class);
        if (r21 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        this.hasExtensions = r6;
        this.useCachedSizeField = r14;
        this.intArray = r15;
        this.checkInitializedCount = r16;
        this.repeatedFieldOffsetStart = r17;
        this.newInstanceSchema = r4;
        this.listFieldSchema = r5;
        this.unknownFieldSchema = r20;
        this.extensionSchema = r21;
        this.defaultInstance = r2;
        this.mapFieldSchema = r3;
        return;
    L5:
        if (r21.hasExtensions(r2) == false) goto L7;
        r6 = true;
        goto L8
    }

    private boolean arePresentForEquals(T r1, T r2, int r3) {
        if (isFieldPresent(r1, r3) != isFieldPresent(r2, r3)) goto L5;
        return true;
    L5:
        return false;
    }

    private static <T> boolean booleanAt(T r0, long r1) {
        return UnsafeUtil.getBoolean(r0, r1);
    }

    private static void checkMutable(Object r3) {
        if (isMutable(r3) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Mutating immutable message: " + r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] r16, int r17, int r18, MapEntryLite.Metadata<K, V> r19, Map<K, V> r20, ArrayDecoders.Registers r21) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        int r0 = ArrayDecoders.decodeVarint32(r16, r17, r21);
        int r1 = r21.int1;
        if (r1 < 0) goto L30;
        if (r1 > (r18 - r0)) goto L30;
        int r12 = r0 + r1;
        K r2 = r19.defaultKey;
        Object r13 = r2;
        Object r14 = r19.defaultValue;
    L7:
        if (r0 >= r12) goto L24;
        int r3 = r0 + 1;
        int r4 = r16[r0];
        if (r4 >= 0) goto L11;
        int r5 = ArrayDecoders.decodeVarint32(r4, r16, r3, r21);
        int r6 = r5;
        r4 = r21.int1;
    L12:
        int r7 = r4 >>> 3;
        int r8 = r4 & 7;
        if (r7 != 1) goto L15;
        if (r8 != r19.keyType.getWireType()) goto L23;
        r0 = decodeMapEntryValue(r16, r6, r18, r19.keyType, null, r21);
        r13 = r21.object1;
    L23:
        r0 = ArrayDecoders.skipField(r4, r16, r6, r18, r21);
        goto L7
    L15:
        if (r7 != 2) goto L23;
        if (r8 != r19.valueType.getWireType()) goto L23;
        r0 = decodeMapEntryValue(r16, r6, r18, r19.valueType, r19.defaultValue.getClass(), r21);
        r14 = r21.object1;
        goto L7
    L11:
        r6 = r3;
        goto L12
    L24:
        if (r0 != r12) goto L28;
        r11.put(r13, r14);
        return r12;
    L28:
        throw InvalidProtocolBufferException.parseFailure();
    L30:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private int decodeMapEntryValue(byte[] r1, int r2, int r3, WireFormat.FieldType r4, Class<?> r5, ArrayDecoders.Registers r6) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r4.ordinal()]) {
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
        int r0 = ArrayDecoders.decodeVarint64(r1, r2, r6);
        long r7 = CodedInputStream.decodeZigZag64(r6.long1);
    L11:
        Object r8 = Long.valueOf(r7);
    L14:
        r6.object1 = r8;
        return r0;
    L8:
        r0 = ArrayDecoders.decodeVarint32(r1, r2, r6);
        int r9 = CodedInputStream.decodeZigZag32(r6.int1);
    L13:
        r8 = Integer.valueOf(r9);
        goto L14
    L10:
        r0 = ArrayDecoders.decodeVarint64(r1, r2, r6);
        r7 = r6.long1;
        goto L11
    L12:
        r0 = ArrayDecoders.decodeVarint32(r1, r2, r6);
        r9 = r6.int1;
        goto L13
    L15:
        Object r10 = Float.valueOf(ArrayDecoders.decodeFloat(r1, r2));
    L18:
        r6.object1 = r10;
        return r2 + 4;
    L16:
        Object r11 = Long.valueOf(ArrayDecoders.decodeFixed64(r1, r2));
    L20:
        r6.object1 = r11;
        return r2 + 8;
    L17:
        r10 = Integer.valueOf(ArrayDecoders.decodeFixed32(r1, r2));
        goto L18
    L19:
        r11 = Double.valueOf(ArrayDecoders.decodeDouble(r1, r2));
        goto L20
    L22:
        r0 = ArrayDecoders.decodeVarint64(r1, r2, r6);
        if (r6.long1 == 0) goto L25;
        boolean r12 = true;
    L26:
        r8 = Boolean.valueOf(r12);
        goto L14
    L25:
        r12 = false;
        goto L26
    L5:
        throw new RuntimeException("unsupported field type.");
    L27:
        return ArrayDecoders.decodeStringRequireUtf8(r1, r2, r6);
    L28:
        return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(r5), r1, r2, r3, r6);
    L32:
        return ArrayDecoders.decodeBytes(r1, r2, r6);
    }

    private static <T> double doubleAt(T r0, long r1) {
        return UnsafeUtil.getDouble(r0, r1);
    }

    private boolean equals(T r6, T r7, int r8) {
        int r0 = typeAndOffsetAt(r8);
        long r1 = offset(r0);
        switch(type(r0)) {
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
        if (isOneofCaseEqual(r6, r7, r8) == true) goto L8;
        return false;
    L8:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r6, r1), UnsafeUtil.getObject(r7, r1)) == true) goto L10;
        return false;
    L10:
        return true;
    L12:
        return SchemaUtil.safeEquals(UnsafeUtil.getObject(r6, r1), UnsafeUtil.getObject(r7, r1));
    L14:
        if (arePresentForEquals(r6, r7, r8) == true) goto L16;
        return false;
    L16:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r6, r1), UnsafeUtil.getObject(r7, r1)) == true) goto L18;
        return false;
    L18:
        return true;
    L20:
        if (arePresentForEquals(r6, r7, r8) == true) goto L22;
        return false;
    L22:
        if (UnsafeUtil.getLong(r6, r1) == UnsafeUtil.getLong(r7, r1)) goto L24;
        return false;
    L24:
        return true;
    L26:
        if (arePresentForEquals(r6, r7, r8) == true) goto L28;
        return false;
    L28:
        if (UnsafeUtil.getInt(r6, r1) == UnsafeUtil.getInt(r7, r1)) goto L30;
        return false;
    L30:
        return true;
    L32:
        if (arePresentForEquals(r6, r7, r8) == true) goto L34;
        return false;
    L34:
        if (UnsafeUtil.getLong(r6, r1) == UnsafeUtil.getLong(r7, r1)) goto L36;
        return false;
    L36:
        return true;
    L38:
        if (arePresentForEquals(r6, r7, r8) == true) goto L40;
        return false;
    L40:
        if (UnsafeUtil.getInt(r6, r1) == UnsafeUtil.getInt(r7, r1)) goto L42;
        return false;
    L42:
        return true;
    L44:
        if (arePresentForEquals(r6, r7, r8) == true) goto L46;
        return false;
    L46:
        if (UnsafeUtil.getInt(r6, r1) == UnsafeUtil.getInt(r7, r1)) goto L48;
        return false;
    L48:
        return true;
    L50:
        if (arePresentForEquals(r6, r7, r8) == true) goto L52;
        return false;
    L52:
        if (UnsafeUtil.getInt(r6, r1) == UnsafeUtil.getInt(r7, r1)) goto L54;
        return false;
    L54:
        return true;
    L56:
        if (arePresentForEquals(r6, r7, r8) == true) goto L58;
        return false;
    L58:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r6, r1), UnsafeUtil.getObject(r7, r1)) == true) goto L60;
        return false;
    L60:
        return true;
    L62:
        if (arePresentForEquals(r6, r7, r8) == true) goto L64;
        return false;
    L64:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r6, r1), UnsafeUtil.getObject(r7, r1)) == true) goto L66;
        return false;
    L66:
        return true;
    L68:
        if (arePresentForEquals(r6, r7, r8) == true) goto L70;
        return false;
    L70:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(r6, r1), UnsafeUtil.getObject(r7, r1)) == true) goto L72;
        return false;
    L72:
        return true;
    L74:
        if (arePresentForEquals(r6, r7, r8) == true) goto L76;
        return false;
    L76:
        if (UnsafeUtil.getBoolean(r6, r1) == UnsafeUtil.getBoolean(r7, r1)) goto L78;
        return false;
    L78:
        return true;
    L80:
        if (arePresentForEquals(r6, r7, r8) == true) goto L82;
        return false;
    L82:
        if (UnsafeUtil.getInt(r6, r1) == UnsafeUtil.getInt(r7, r1)) goto L84;
        return false;
    L84:
        return true;
    L86:
        if (arePresentForEquals(r6, r7, r8) == true) goto L88;
        return false;
    L88:
        if (UnsafeUtil.getLong(r6, r1) == UnsafeUtil.getLong(r7, r1)) goto L90;
        return false;
    L90:
        return true;
    L92:
        if (arePresentForEquals(r6, r7, r8) == true) goto L94;
        return false;
    L94:
        if (UnsafeUtil.getInt(r6, r1) == UnsafeUtil.getInt(r7, r1)) goto L96;
        return false;
    L96:
        return true;
    L98:
        if (arePresentForEquals(r6, r7, r8) == true) goto L100;
        return false;
    L100:
        if (UnsafeUtil.getLong(r6, r1) == UnsafeUtil.getLong(r7, r1)) goto L102;
        return false;
    L102:
        return true;
    L104:
        if (arePresentForEquals(r6, r7, r8) == true) goto L106;
        return false;
    L106:
        if (UnsafeUtil.getLong(r6, r1) == UnsafeUtil.getLong(r7, r1)) goto L108;
        return false;
    L108:
        return true;
    L110:
        if (arePresentForEquals(r6, r7, r8) == true) goto L112;
        return false;
    L112:
        if (Float.floatToIntBits(UnsafeUtil.getFloat(r6, r1)) == Float.floatToIntBits(UnsafeUtil.getFloat(r7, r1))) goto L114;
        return false;
    L114:
        return true;
    L116:
        if (arePresentForEquals(r6, r7, r8) == true) goto L118;
        return false;
    L118:
        if (Double.doubleToLongBits(UnsafeUtil.getDouble(r6, r1)) == Double.doubleToLongBits(UnsafeUtil.getDouble(r7, r1))) goto L120;
        return false;
    L120:
        return true;
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object r9, int r10, UB r11, UnknownFieldSchema<UT, UB> r12, Object r13) {
        int r2 = numberAt(r10);
        Object r14 = UnsafeUtil.getObject(r9, offset(typeAndOffsetAt(r10)));
        if (r14 != null) goto L5;
        return r11;
    L5:
        Internal.EnumVerifier r4 = getEnumFieldVerifier(r10);
        if (r4 != null) goto L9;
        return r11;
    L9:
        return (UB) filterUnknownEnumMap(r10, r2, this.mapFieldSchema.forMutableMapData(r14), r4, r11, r12, r13);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int r5, int r6, Map<K, V> r7, Internal.EnumVerifier r8, UB r9, UnknownFieldSchema<UT, UB> r10, Object r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Internal.EnumVerifier r13 = (Internal.EnumVerifier) ZeusTransformUtils.wrapperContextForParams(r8, Internal.EnumVerifier.class, "com.obric.memorydata.plugin");
        MapEntryLite.Metadata<?, ?> r4 = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(r5));
        Iterator<Map.Entry<K, V>> r14 = r12.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L15;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r13.isInRange(((Integer) ZeusTransformUtils.preCheckCast(r15.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue()) == true) goto L4;
        if (r9 != null) goto L9;
        r9 = r10.getBuilderFromMessage(r11);
    L9:
        ByteString.CodedBuilder r0 = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(r4, r15.getKey(), r15.getValue()));
        CodedOutputStream r2 = r0.getCodedOutput();
        MapEntryLite.writeTo(r2, r4, r15.getKey(), r15.getValue());     // Catch: IOException -> L12
        UB r16 = r9;
        r10.addLengthDelimited(r16, r6, r0.build());
        r14.remove();
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    L15:
        return r9;
    }

    private static <T> float floatAt(T r0, long r1) {
        return UnsafeUtil.getFloat(r0, r1);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int r2) {
        return (Internal.EnumVerifier) ZeusTransformUtils.preCheckCast(this.objects[((r2 / 3) * 2) + 1], Internal.EnumVerifier.class, "com.obric.memorydata.plugin");
    }

    private Object getMapFieldDefaultEntry(int r1) {
        return this.objects[(r1 / 3) * 2];
    }

    private Schema getMessageFieldSchema(int r5) {
        int r6 = (r5 / 3) * 2;
        Schema r0 = (Schema) ZeusTransformUtils.preCheckCast(this.objects[r6], Schema.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        Schema<T> r1 = Protobuf.getInstance().schemaFor((Class) ZeusTransformUtils.preCheckCast(this.objects[r6 + 1], Class.class, "com.obric.memorydata.plugin"));
        this.objects[r6] = r1;
        return r1;
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object r3) {
        UnknownFieldSetLite r0 = ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields;
        if (r0 != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        UnknownFieldSetLite r1 = UnknownFieldSetLite.newInstance();
        ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields = r1;
        return r1;
    L6:
        return r0;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> r1, T r2) {
        return r1.getSerializedSize(r1.getFromMessage(r2));
    }

    private static <T> int intAt(T r0, long r1) {
        return UnsafeUtil.getInt(r0, r1);
    }

    private static boolean isEnforceUtf8(int r1) {
        if ((r1 & 536870912) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isFieldPresent(T r7, int r8) {
        int r0 = presenceMaskAndOffsetAt(r8);
        long r1 = 1048575 & r0;
        if (r1 != 1048575) goto L83;
        int r6 = typeAndOffsetAt(r8);
        long r2 = offset(r6);
        switch(type(r6)) {
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
        Object r9 = UnsafeUtil.getObject(r7, r2);
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L47;
        return !((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin")).isEmpty();
    L47:
        if (ZeusTransformUtils.instanceOf(r9, ByteString.class) == false) goto L51;
        return !ByteString.EMPTY.equals(r9);
    L51:
        throw new IllegalArgumentException();
    L7:
        throw new IllegalArgumentException();
    L9:
        if (UnsafeUtil.getObject(r7, r2) != null) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (UnsafeUtil.getLong(r7, r2) != 0) goto L15;
        return false;
    L15:
        return true;
    L17:
        if (UnsafeUtil.getInt(r7, r2) != 0) goto L19;
        return false;
    L19:
        return true;
    L21:
        if (UnsafeUtil.getLong(r7, r2) != 0) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (UnsafeUtil.getInt(r7, r2) != 0) goto L27;
        return false;
    L27:
        return true;
    L29:
        if (UnsafeUtil.getInt(r7, r2) != 0) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (UnsafeUtil.getInt(r7, r2) != 0) goto L35;
        return false;
    L35:
        return true;
    L37:
        return !ByteString.EMPTY.equals(UnsafeUtil.getObject(r7, r2));
    L39:
        if (UnsafeUtil.getObject(r7, r2) != null) goto L41;
        return false;
    L41:
        return true;
    L53:
        return UnsafeUtil.getBoolean(r7, r2);
    L55:
        if (UnsafeUtil.getInt(r7, r2) != 0) goto L57;
        return false;
    L57:
        return true;
    L59:
        if (UnsafeUtil.getLong(r7, r2) != 0) goto L61;
        return false;
    L61:
        return true;
    L63:
        if (UnsafeUtil.getInt(r7, r2) != 0) goto L65;
        return false;
    L65:
        return true;
    L67:
        if (UnsafeUtil.getLong(r7, r2) != 0) goto L69;
        return false;
    L69:
        return true;
    L71:
        if (UnsafeUtil.getLong(r7, r2) != 0) goto L73;
        return false;
    L73:
        return true;
    L75:
        if (Float.floatToRawIntBits(UnsafeUtil.getFloat(r7, r2)) != 0) goto L77;
        return false;
    L77:
        return true;
    L79:
        if (Double.doubleToRawLongBits(UnsafeUtil.getDouble(r7, r2)) != 0) goto L81;
        return false;
    L81:
        return true;
    L83:
        if (((1 << (r0 >>> 20)) & UnsafeUtil.getInt(r7, r1)) != 0) goto L85;
        return false;
    L85:
        return true;
    }

    private boolean isFieldPresent(T r2, int r3, int r4, int r5, int r6) {
        if (r4 != 1048575) goto L7;
        return isFieldPresent(r2, r3);
    L7:
        if ((r5 & r6) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object r2, int r3, Schema r4) {
        return ((Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin")).isInitialized(UnsafeUtil.getObject(r2, offset(r3)));
    }

    private static boolean isLegacyEnumIsClosed(int r1) {
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object r3, int r4, int r5) {
        List r6 = (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r3, offset(r4)), List.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == false) goto L5;
        return true;
    L5:
        Schema r2 = getMessageFieldSchema(r5);
        int r7 = 0;
    L7:
        if (r7 >= r6.size()) goto L12;
        if (r2.isInitialized(r6.get(r7)) == false) goto L10;
        r7 = r7 + 1;
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
    private boolean isMapInitialized(T r4, int r5, int r6) {
        Map<?, ?> r7 = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(r4, offset(r5)));
        if (r7.isEmpty() == false) goto L5;
        return true;
    L5:
        Object r8 = getMapFieldDefaultEntry(r6);
        if (this.mapFieldSchema.forMapMetadata(r8).valueType.getJavaType() == WireFormat.JavaType.MESSAGE) goto L8;
        return true;
    L8:
        ?? r3 = 0;
        Iterator<?> r9 = r7.values().iterator();
    L10:
        if (r9.hasNext() == false) goto L18;
        Object r10 = r9.next();
        r3 = r3;
        if (r3 != 0) goto L15;
        r3 = Protobuf.getInstance().schemaFor(r10.getClass());
    L15:
        if (r3.isInitialized(r10) == true) goto L10;
        return false;
    L18:
        return true;
    }

    private static boolean isMutable(Object r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, GeneratedMessageLite.class) == true) goto L8;
        return true;
    L8:
        return ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).isMutable();
    }

    private boolean isOneofCaseEqual(T r3, T r4, int r5) {
        long r0 = presenceMaskAndOffsetAt(r5) & 1048575;
        if (UnsafeUtil.getInt(r3, r0) != UnsafeUtil.getInt(r4, r0)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isOneofPresent(T r3, int r4, int r5) {
        if (UnsafeUtil.getInt(r3, presenceMaskAndOffsetAt(r5) & 1048575) != r4) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isRequired(int r1) {
        if ((r1 & 268435456) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static <T> long longAt(T r0, long r1) {
        return UnsafeUtil.getLong(r0, r1);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 17561. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> r19, com.google.protobuf.ExtensionSchema<ET> r20, T r21, com.google.protobuf.Reader r22, com.google.protobuf.ExtensionRegistryLite r23) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: MOVE (r7v0 ?? I:??[OBJECT, ARRAY]) = (r19v0 com.google.protobuf.UnknownFieldSchema<UT, UB>) A[DECLARE_VAR] in method: com.google.protobuf.MessageSchema.mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB>, com.google.protobuf.ExtensionSchema<ET extends com.google.protobuf.FieldSet$FieldDescriptorLite<ET>>, T, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.mergeFromHelper(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object r5, int r6, Object r7, ExtensionRegistryLite r8, Reader r9) {
        Reader r10 = (Reader) ZeusTransformUtils.wrapperContextForParams(r9, Reader.class, "com.obric.memorydata.plugin");
        long r0 = offset(typeAndOffsetAt(r6));
        Object r11 = UnsafeUtil.getObject(r5, r0);
        if (r11 != null) goto L6;
        r11 = this.mapFieldSchema.newMapField(r7);
        UnsafeUtil.putObject(r5, r0, r11);
    L8:
        r10.readMap(this.mapFieldSchema.forMutableMapData(r11), this.mapFieldSchema.forMapMetadata(r7), r8);
        return;
    L6:
        if (this.mapFieldSchema.isImmutable(r11) == false) goto L8;
        Object r2 = this.mapFieldSchema.newMapField(r7);
        this.mapFieldSchema.mergeFrom(r2, r11);
        UnsafeUtil.putObject(r5, r0, r2);
        r11 = r2;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T r6, T r7, int r8) {
        if (isFieldPresent(r7, r8) == true) goto L5;
        return;
    L5:
        long r0 = offset(typeAndOffsetAt(r8));
        Unsafe r2 = UNSAFE;
        Object r3 = r2.getObject(r7, r0);
        if (r3 == null) goto L21;
        Schema r9 = getMessageFieldSchema(r8);
        if (isFieldPresent(r6, r8) == false) goto L10;
        Object r5 = r2.getObject(r6, r0);
        if (isMutable(r5) == true) goto L18;
        Object r10 = r9.newInstance();
        r9.mergeFrom(r10, r5);
        r2.putObject(r6, r0, r10);
        r5 = r10;
    L18:
        r9.mergeFrom(r5, r3);
        return;
    L10:
        if (isMutable(r3) == true) goto L12;
        r2.putObject(r6, r0, r3);
    L13:
        setFieldPresent(r6, r8);
        return;
    L12:
        Object r4 = r9.newInstance();
        r9.mergeFrom(r4, r3);
        r2.putObject(r6, r0, r4);
        goto L13
    L21:
        throw new IllegalStateException("Source subfield " + numberAt(r8) + " is present but null: " + r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T r7, T r8, int r9) {
        int r0 = numberAt(r9);
        if (isOneofPresent(r8, r0, r9) == true) goto L5;
        return;
    L5:
        long r1 = offset(typeAndOffsetAt(r9));
        Unsafe r3 = UNSAFE;
        Object r4 = r3.getObject(r8, r1);
        if (r4 == null) goto L21;
        Schema r10 = getMessageFieldSchema(r9);
        if (isOneofPresent(r7, r0, r9) == false) goto L10;
        Object r6 = r3.getObject(r7, r1);
        if (isMutable(r6) == true) goto L18;
        Object r11 = r10.newInstance();
        r10.mergeFrom(r11, r6);
        r3.putObject(r7, r1, r11);
        r6 = r11;
    L18:
        r10.mergeFrom(r6, r4);
        return;
    L10:
        if (isMutable(r4) == true) goto L12;
        r3.putObject(r7, r1, r4);
    L13:
        setOneofPresent(r7, r0, r9);
        return;
    L12:
        Object r5 = r10.newInstance();
        r10.mergeFrom(r5, r4);
        r3.putObject(r7, r1, r5);
        goto L13
    L21:
        throw new IllegalStateException("Source subfield " + numberAt(r9) + " is present but null: " + r8);
    }

    private void mergeSingleField(T r6, T r7, int r8) {
        int r0 = typeAndOffsetAt(r8);
        long r1 = offset(r0);
        int r3 = numberAt(r8);
        switch(type(r0)) {
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
        mergeOneofMessage(r6, r7, r8);
        return;
    L12:
        SchemaUtil.mergeMap(this.mapFieldSchema, r6, r7, r1);
        return;
    L13:
        this.listFieldSchema.mergeListsAt(r6, r7, r1);
        return;
    L35:
        mergeMessage(r6, r7, r8);
        return;
    L88:
        return;
    L6:
        if (isOneofPresent(r7, r3, r8) == false) goto L65;
    L11:
        UnsafeUtil.putObject(r6, r1, UnsafeUtil.getObject(r7, r1));
        setOneofPresent(r6, r3, r8);
        return;
    L65:
        return;
    L10:
        if (isOneofPresent(r7, r3, r8) == true) goto L11;
        return;
    L15:
        if (isFieldPresent(r7, r8) == false) goto L71;
    L56:
        UnsafeUtil.putLong(r6, r1, UnsafeUtil.getLong(r7, r1));
    L63:
        setFieldPresent(r6, r8);
        return;
    L71:
        return;
    L18:
        if (isFieldPresent(r7, r8) == false) goto L72;
    L50:
        UnsafeUtil.putInt(r6, r1, UnsafeUtil.getInt(r7, r1));
        goto L63
    L72:
        return;
    L21:
        if (isFieldPresent(r7, r8) == true) goto L56;
        return;
    L24:
        if (isFieldPresent(r7, r8) == true) goto L50;
        return;
    L27:
        if (isFieldPresent(r7, r8) == true) goto L50;
        return;
    L30:
        if (isFieldPresent(r7, r8) == true) goto L50;
        return;
    L33:
        if (isFieldPresent(r7, r8) == false) goto L77;
    L38:
        UnsafeUtil.putObject(r6, r1, UnsafeUtil.getObject(r7, r1));
        goto L63
    L77:
        return;
    L37:
        if (isFieldPresent(r7, r8) == true) goto L38;
        return;
    L40:
        if (isFieldPresent(r7, r8) == false) goto L80;
        UnsafeUtil.putBoolean(r6, r1, UnsafeUtil.getBoolean(r7, r1));
        goto L63
    L80:
        return;
    L43:
        if (isFieldPresent(r7, r8) == true) goto L50;
        return;
    L46:
        if (isFieldPresent(r7, r8) == true) goto L56;
        return;
    L49:
        if (isFieldPresent(r7, r8) == true) goto L50;
        return;
    L52:
        if (isFieldPresent(r7, r8) == true) goto L56;
        return;
    L55:
        if (isFieldPresent(r7, r8) == true) goto L56;
        return;
    L58:
        if (isFieldPresent(r7, r8) == false) goto L86;
        UnsafeUtil.putFloat(r6, r1, UnsafeUtil.getFloat(r7, r1));
        goto L63
    L86:
        return;
    L61:
        if (isFieldPresent(r7, r8) == false) goto L87;
        UnsafeUtil.putDouble(r6, r1, UnsafeUtil.getDouble(r7, r1));
        goto L63
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T r4, int r5) {
        Schema r0 = getMessageFieldSchema(r5);
        long r1 = offset(typeAndOffsetAt(r5));
        if (isFieldPresent(r4, r5) == false) goto L5;
        Object r3 = UNSAFE.getObject(r4, r1);
        if (isMutable(r3) == false) goto L9;
        return r3;
    L9:
        Object r6 = r0.newInstance();
        if (r3 == null) goto L12;
        r0.mergeFrom(r6, r3);
    L12:
        return r6;
    L5:
        return r0.newInstance();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T r4, int r5, int r6) {
        Schema r0 = getMessageFieldSchema(r6);
        if (isOneofPresent(r4, r5, r6) == false) goto L5;
        Object r3 = UNSAFE.getObject(r4, offset(typeAndOffsetAt(r6)));
        if (isMutable(r3) == false) goto L9;
        return r3;
    L9:
        Object r7 = r0.newInstance();
        if (r3 == null) goto L12;
        r0.mergeFrom(r7, r3);
    L12:
        return r7;
    L5:
        return r0.newInstance();
    }

    static <T> MessageSchema<T> newSchema(Class<T> r7, MessageInfo r8, NewInstanceSchema r9, ListFieldSchema r10, UnknownFieldSchema<?, ?> r11, ExtensionSchema<?> r12, MapFieldSchema r13) {
        MessageInfo r14 = (MessageInfo) ZeusTransformUtils.wrapperContextForParams(r8, MessageInfo.class, "com.obric.memorydata.plugin");
        NewInstanceSchema r2 = (NewInstanceSchema) ZeusTransformUtils.wrapperContextForParams(r9, NewInstanceSchema.class, "com.obric.memorydata.plugin");
        ListFieldSchema r3 = (ListFieldSchema) ZeusTransformUtils.wrapperContextForParams(r10, ListFieldSchema.class, "com.obric.memorydata.plugin");
        MapFieldSchema r6 = (MapFieldSchema) ZeusTransformUtils.wrapperContextForParams(r13, MapFieldSchema.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, RawMessageInfo.class) == false) goto L7;
        return newSchemaForRawMessageInfo((RawMessageInfo) ZeusTransformUtils.preCheckCast(r14, RawMessageInfo.class, "com.obric.memorydata.plugin"), r2, r3, r11, r12, r6);
    L7:
        return newSchemaForMessageInfo((StructuralMessageInfo) ZeusTransformUtils.preCheckCast(r14, StructuralMessageInfo.class, "com.obric.memorydata.plugin"), r2, r3, r11, r12, r6);
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo r20, NewInstanceSchema r21, ListFieldSchema r22, UnknownFieldSchema<?, ?> r23, ExtensionSchema<?> r24, MapFieldSchema r25) {
        NewInstanceSchema r12 = (NewInstanceSchema) ZeusTransformUtils.wrapperContextForParams(r21, NewInstanceSchema.class, "com.obric.memorydata.plugin");
        ListFieldSchema r13 = (ListFieldSchema) ZeusTransformUtils.wrapperContextForParams(r22, ListFieldSchema.class, "com.obric.memorydata.plugin");
        MapFieldSchema r16 = (MapFieldSchema) ZeusTransformUtils.wrapperContextForParams(r25, MapFieldSchema.class, "com.obric.memorydata.plugin");
        FieldInfo[] r0 = r20.getFields();
        if (r0.length != 0) goto L5;
        int r5 = 0;
        int r6 = 0;
    L6:
        int r1 = r0.length;
        int[] r3 = new int[r1 * 3];
        Object[] r4 = new Object[r1 * 2];
        int r2 = r0.length;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L8:
        if (r7 >= r2) goto L18;
        FieldInfo r14 = r0[r7];
        if (r14.getType() != FieldType.MAP) goto L13;
        r8 = r8 + 1;
    L17:
        r7 = r7 + 1;
        goto L8
    L13:
        if (r14.getType().id() < 18) goto L17;
        if (r14.getType().id() > 49) goto L17;
        r9 = r9 + 1;
        goto L17
    L18:
        int[] r10 = null;
        if (r8 <= 0) goto L21;
        int[] r11 = new int[r8];
    L22:
        if (r9 <= 0) goto L24;
        r10 = new int[r9];
    L24:
        int[] r15 = r20.getCheckInitialized();
        if (r15 != null) goto L27;
        r15 = EMPTY_INT_ARRAY;
    L27:
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        int r110 = 0;
        int r111 = 0;
    L29:
        if (r17 >= r0.length) goto L45;
        FieldInfo r112 = r0[r17];
        int r113 = r112.getFieldNumber();
        storeFieldData(r112, r3, r18, r4);
        FieldInfo[] r114 = r0;
        if (r19 >= r15.length) goto L36;
        if (r15[r19] != r113) goto L36;
        r15[r19] = r18;
        r19 = r19 + 1;
    L36:
        if (r112.getType() != FieldType.MAP) goto L40;
        r11[r110] = r18;
        r110 = r110 + 1;
    L44:
        r17 = r17 + 1;
        r18 = r18 + 3;
        r0 = r114;
        r12 = r12;
        goto L29
    L40:
        if (r112.getType().id() < 18) goto L44;
        if (r112.getType().id() > 49) goto L44;
        r10[r111] = (int) UnsafeUtil.objectFieldOffset(r112.getField());
        r111 = r111 + 1;
        goto L44
    L45:
        NewInstanceSchema r115 = r12;
        if (r11 != null) goto L48;
        r11 = EMPTY_INT_ARRAY;
    L48:
        if (r10 != null) goto L50;
        r10 = EMPTY_INT_ARRAY;
    L50:
        int r26 = (r15.length + r11.length) + r10.length;
        if (r26 <= 0) goto L53;
        int[] r27 = new int[r26];
        System.arraycopy(r15, 0, r27, 0, r15.length);
        System.arraycopy(r11, 0, r27, r15.length, r11.length);
        System.arraycopy(r10, 0, r27, r15.length + r11.length, r10.length);
    L55:
        return new MessageSchema(r3, r4, r5, r6, r20.getDefaultInstance(), true, r27, r15.length, r15.length + r11.length, r115, r13, r23, r24, r16);
    L53:
        r27 = EMPTY_INT_ARRAY;
        goto L55
    L21:
        r11 = null;
        goto L22
    L5:
        r5 = r0[0].getFieldNumber();
        r6 = r0[r0.length - 1].getFieldNumber();
        goto L6
    }

    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo r33, NewInstanceSchema r34, ListFieldSchema r35, UnknownFieldSchema<?, ?> r36, ExtensionSchema<?> r37, MapFieldSchema r38) {
        String r1 = "com.obric.memorydata.plugin";
        NewInstanceSchema r12 = (NewInstanceSchema) ZeusTransformUtils.wrapperContextForParams(r34, NewInstanceSchema.class, "com.obric.memorydata.plugin");
        ListFieldSchema r13 = (ListFieldSchema) ZeusTransformUtils.wrapperContextForParams(r35, ListFieldSchema.class, "com.obric.memorydata.plugin");
        MapFieldSchema r16 = (MapFieldSchema) ZeusTransformUtils.wrapperContextForParams(r38, MapFieldSchema.class, "com.obric.memorydata.plugin");
        String r0 = r33.getStringInfo();
        int r2 = r0.length();
        int r3 = 0;
        if (r0.charAt(0) < 55296) goto L8;
        int r4 = 1;
    L5:
        int r7 = r4 + 1;
        if (r0.charAt(r4) < 55296) goto L9;
        r4 = r7;
    L9:
        int r5 = r7 + 1;
        int r8 = r0.charAt(r7);
        if (r8 < 55296) goto L16;
        int r9 = r8 & 8191;
        int r10 = 13;
    L12:
        int r11 = r5 + 1;
        char r6 = r0.charAt(r5);
        if (r6 < 55296) goto L15;
        r9 = r9 | ((r6 & 8191) << r10);
        r10 = r10 + 13;
        r5 = r11;
        goto L12
    L15:
        r8 = r9 | (r6 << r10);
        r5 = r11;
    L16:
        if (r8 != 0) goto L18;
        int r14 = 0;
        int r15 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        int[] r110 = EMPTY_INT_ARRAY;
        int r20 = 0;
    L76:
        Unsafe r21 = UNSAFE;
        Object[] r111 = r33.getObjects();
        Class<?> r22 = r33.getDefaultInstance().getClass();
        int r112 = r5;
        int[] r23 = new int[r20 * 3];
        Object[] r24 = new Object[r20 * 2];
        int r25 = r18 + r14;
        int r26 = r18;
        int r27 = r112;
        int r28 = r25;
        int r113 = 0;
        int r29 = 0;
    L77:
        if (r27 >= r2) goto L205;
        int r210 = r27 + 1;
        int r30 = r0.charAt(r27);
        int r211 = r2;
        if (r30 < 55296) goto L85;
        int r31 = r30 & 8191;
        int r32 = r210;
        int r212 = 13;
    L81:
        int r213 = r32 + 1;
        char r39 = r0.charAt(r32);
        ListFieldSchema r214 = r13;
        if (r39 < 55296) goto L84;
        r31 = r31 | ((r39 & 8191) << r212);
        r212 = r212 + 13;
        r32 = r213;
        r13 = r214;
        goto L81
    L84:
        r30 = r31 | (r39 << r212);
        int r40 = r213;
    L86:
        int r114 = r40 + 1;
        int r41 = r0.charAt(r40);
        if (r41 < 55296) goto L93;
        int r42 = r41 & 8191;
        int r115 = r114;
        int r215 = 13;
    L89:
        int r216 = r115 + 1;
        char r116 = r0.charAt(r115);
        NewInstanceSchema r217 = r12;
        if (r116 < 55296) goto L92;
        r42 = r42 | ((r116 & 8191) << r215);
        r215 = r215 + 13;
        r115 = r216;
        r12 = r217;
        goto L89
    L92:
        r41 = r42 | (r116 << r215);
        int r117 = r216;
    L94:
        int r118 = r41 & 255;
        int r218 = r18;
        if ((r41 & 1024) == 0) goto L97;
        r110[r113] = r29;
        r113 = r113 + 1;
    L97:
        int r310 = r17;
        if (r118 < 51) goto L129;
        int r119 = r117 + 1;
        int r120 = r0.charAt(r117);
        char r121 = 55296;
        if (r120 < 55296) goto L106;
        int r122 = r120 & 8191;
        int r311 = 13;
    L102:
        int r312 = r119 + 1;
        char r123 = r0.charAt(r119);
        if (r123 < r121) goto L105;
        r122 = r122 | ((r123 & 8191) << r311);
        r311 = r311 + 13;
        r119 = r312;
        r121 = 55296;
        goto L102
    L105:
        r120 = r122 | (r123 << r311);
        r119 = r312;
    L106:
        int r124 = r118 - 51;
        int r313 = r119;
        if (r124 != 9) goto L109;
    L118:
        int r125 = r19 + 1;
        r24[((r29 / 3) * 2) + 1] = r111[r19];
    L119:
        r19 = r125;
    L120:
        int r126 = r120 * 2;
        Object r127 = r111[r126];
        if (ZeusTransformUtils.instanceOf(r127, java.lang.reflect.Field.class) == false) goto L123;
        java.lang.reflect.Field r128 = (java.lang.reflect.Field) ZeusTransformUtils.preCheckCast(r127, java.lang.reflect.Field.class, r1);
    L124:
        int r219 = r19;
        int r129 = (int) r21.objectFieldOffset(r128);
        int r130 = r126 + 1;
        Object r131 = r111[r130];
        if (ZeusTransformUtils.instanceOf(r131, java.lang.reflect.Field.class) == false) goto L127;
        java.lang.reflect.Field r132 = (java.lang.reflect.Field) ZeusTransformUtils.preCheckCast(r131, java.lang.reflect.Field.class, r1);
    L128:
        r19 = r219;
        int r220 = r313;
        int r221 = r15;
        int r43 = (int) r21.objectFieldOffset(r132);
        int r133 = 0;
    L191:
        int r134 = r29 + 1;
        r23[r29] = r30;
        int r44 = r134 + 1;
        String r314 = r0;
        if ((r41 & 512) == 0) goto L194;
        int r45 = 536870912;
    L195:
        String r222 = r1;
        if ((r41 & 256) == 0) goto L198;
        int r46 = 268435456;
    L199:
        int r47 = r45 | r46;
        if ((r41 & 2048) == 0) goto L202;
        int r48 = Integer.MIN_VALUE;
    L203:
        r23[r134] = ((r47 | r48) | (r118 << 20)) | r129;
        int r49 = r44 + 1;
        r23[r44] = (r133 << 20) | r43;
        r1 = r222;
        r18 = r218;
        r2 = r211;
        r15 = r221;
        r13 = r214;
        r12 = r217;
        r27 = r220;
        r17 = r310;
        r29 = r49;
        r0 = r314;
        goto L77
    L202:
        r48 = 0;
        goto L203
    L198:
        r46 = 0;
        goto L199
    L194:
        r45 = 0;
        goto L195
    L127:
        java.lang.reflect.Field r135 = reflectField(r22, (String) ZeusTransformUtils.preCheckCast(r131, String.class, r1));
        r111[r130] = r135;
        r132 = r135;
        goto L128
    L123:
        r128 = reflectField(r22, (String) ZeusTransformUtils.preCheckCast(r127, String.class, r1));
        r111[r126] = r128;
        goto L124
    L109:
        if (r124 == 17) goto L118;
        if (r124 != 12) goto L120;
        if (r33.getSyntax().equals(ProtoSyntax.PROTO2) == false) goto L116;
    L117:
        r125 = r19 + 1;
        r24[((r29 / 3) * 2) + 1] = r111[r19];
        goto L119
    L116:
        if ((r41 & 2048) == 0) goto L120;
    L129:
        int r136 = r19 + 1;
        java.lang.reflect.Field r137 = reflectField(r22, (String) ZeusTransformUtils.preCheckCast(r111[r19], String.class, r1));
        if (r118 != 9) goto L132;
    L162:
        r221 = r15;
        boolean r138 = true;
        r24[((r29 / 3) * 2) + 1] = r137.getType();
    L163:
        int r315 = r136;
    L164:
        r129 = (int) r21.objectFieldOffset(r137);
        if ((r41 & 4096) == 0) goto L167;
        boolean r139 = r138;
    L168:
        if (r139 == true) goto L170;
    L184:
        r43 = 1048575;
        r220 = r117;
        r133 = 0;
    L186:
        if (r118 >= 18) goto L188;
    L190:
        r19 = r315;
        goto L191
    L188:
        if (r118 > 49) goto L190;
        r110[r28] = r129;
        r19 = r315;
        r28 = r28 + 1;
        goto L191
    L170:
        if (r118 > 17) goto L184;
        int r50 = r117 + 1;
        int r140 = r0.charAt(r117);
        if (r140 < 55296) goto L178;
        int r141 = r140 & 8191;
        int r142 = 13;
    L174:
        r220 = r50 + 1;
        char r51 = r0.charAt(r50);
        if (r51 < 55296) goto L177;
        r141 = r141 | ((r51 & 8191) << r142);
        r142 = r142 + 13;
        r50 = r220;
        goto L174
    L177:
        r140 = r141 | (r51 << r142);
    L179:
        int r52 = (r3 * 2) + (r140 / 32);
        Object r143 = r111[r52];
        if (ZeusTransformUtils.instanceOf(r143, java.lang.reflect.Field.class) == false) goto L182;
        java.lang.reflect.Field r53 = (java.lang.reflect.Field) ZeusTransformUtils.preCheckCast(r143, java.lang.reflect.Field.class, r1);
    L183:
        r43 = (int) r21.objectFieldOffset(r53);
        r133 = r140 % 32;
        goto L186
    L182:
        java.lang.reflect.Field r144 = reflectField(r22, (String) ZeusTransformUtils.preCheckCast(r143, String.class, r1));
        r111[r52] = r144;
        r53 = r144;
        goto L183
    L178:
        r220 = r50;
        goto L179
    L167:
        r139 = false;
        goto L168
    L132:
        if (r118 == 17) goto L162;
        if (r118 != 27) goto L137;
    L160:
        r221 = r15;
        r138 = true;
        int r223 = r136 + 1;
        r24[((r29 / 3) * 2) + 1] = r111[r136];
    L161:
        r315 = r223;
        goto L164
    L137:
        if (r118 == 49) goto L160;
        if (r118 != 12) goto L142;
    L153:
        r221 = r15;
        if (r33.getSyntax() != ProtoSyntax.PROTO2) goto L156;
    L159:
        r138 = true;
        r223 = r136 + 1;
        r24[((r29 / 3) * 2) + 1] = r111[r136];
        goto L161
    L156:
        if ((r41 & 2048) != 0) goto L159;
    L158:
        r138 = true;
        goto L163
    L142:
        if (r118 == 30) goto L153;
        if (r118 == 44) goto L153;
        if (r118 != 50) goto L152;
        int r145 = r26 + 1;
        r110[r26] = r29;
        int r224 = (r29 / 3) * 2;
        int r225 = r136 + 1;
        r24[r224] = r111[r136];
        if ((r41 & 2048) == 0) goto L151;
        int r146 = r225 + 1;
        r24[r224 + 1] = r111[r225];
        r221 = r15;
        r315 = r146;
        r26 = r145;
        r138 = true;
        goto L164
    L151:
        r26 = r145;
        r315 = r225;
        r138 = true;
        r221 = r15;
        goto L164
    L152:
        r221 = r15;
        goto L158
    L93:
        r217 = r12;
        r117 = r114;
        goto L94
    L85:
        r214 = r13;
        r40 = r210;
        goto L86
    L205:
        return new MessageSchema(r23, r24, r15, r17, r33.getDefaultInstance(), false, r110, r18, r25, r12, r13, r36, r37, r16);
    L18:
        int r54 = r5 + 1;
        int r55 = r0.charAt(r5);
        if (r55 < 55296) goto L25;
        int r56 = r55 & 8191;
        int r57 = 13;
    L21:
        int r147 = r54 + 1;
        char r58 = r0.charAt(r54);
        if (r58 < 55296) goto L24;
        r56 = r56 | ((r58 & 8191) << r57);
        r57 = r57 + 13;
        r54 = r147;
        goto L21
    L24:
        r55 = r56 | (r58 << r57);
        r54 = r147;
    L25:
        int r59 = r54 + 1;
        int r60 = r0.charAt(r54);
        if (r60 < 55296) goto L32;
        int r61 = r60 & 8191;
        int r148 = 13;
    L28:
        int r149 = r59 + 1;
        char r62 = r0.charAt(r59);
        if (r62 < 55296) goto L31;
        r61 = r61 | ((r62 & 8191) << r148);
        r148 = r148 + 13;
        r59 = r149;
        goto L28
    L31:
        r60 = r61 | (r62 << r148);
        r59 = r149;
    L32:
        int r150 = r59 + 1;
        r15 = r0.charAt(r59);
        if (r15 < 55296) goto L39;
        int r63 = r15 & 8191;
        int r151 = 13;
    L35:
        int r152 = r150 + 1;
        char r153 = r0.charAt(r150);
        if (r153 < 55296) goto L38;
        r63 = r63 | ((r153 & 8191) << r151);
        r151 = r151 + 13;
        r150 = r152;
        goto L35
    L38:
        r15 = r63 | (r153 << r151);
        r150 = r152;
    L39:
        int r154 = r150 + 1;
        r17 = r0.charAt(r150);
        if (r17 < 55296) goto L46;
        int r155 = r17 & 8191;
        int r156 = 13;
    L42:
        int r157 = r154 + 1;
        char r158 = r0.charAt(r154);
        if (r158 < 55296) goto L45;
        r155 = r155 | ((r158 & 8191) << r156);
        r156 = r156 + 13;
        r154 = r157;
        goto L42
    L45:
        r17 = r155 | (r158 << r156);
        r154 = r157;
    L46:
        int r159 = r154 + 1;
        int r160 = r0.charAt(r154);
        if (r160 < 55296) goto L53;
        int r161 = r160 & 8191;
        int r162 = 13;
    L49:
        int r163 = r159 + 1;
        char r164 = r0.charAt(r159);
        if (r164 < 55296) goto L52;
        r161 = r161 | ((r164 & 8191) << r162);
        r162 = r162 + 13;
        r159 = r163;
        goto L49
    L52:
        r160 = r161 | (r164 << r162);
        r159 = r163;
    L53:
        int r165 = r159 + 1;
        int r166 = r0.charAt(r159);
        if (r166 < 55296) goto L60;
        int r167 = r166 & 8191;
        int r168 = 13;
    L56:
        int r169 = r165 + 1;
        char r170 = r0.charAt(r165);
        if (r170 < 55296) goto L59;
        r167 = r167 | ((r170 & 8191) << r168);
        r168 = r168 + 13;
        r165 = r169;
        goto L56
    L59:
        r166 = r167 | (r170 << r168);
        r165 = r169;
    L60:
        int r171 = r165 + 1;
        int r172 = r0.charAt(r165);
        if (r172 < 55296) goto L67;
        int r173 = r172 & 8191;
        int r64 = r171;
        int r174 = 13;
    L63:
        int r175 = r64 + 1;
        char r65 = r0.charAt(r64);
        if (r65 < 55296) goto L66;
        r173 = r173 | ((r65 & 8191) << r174);
        r174 = r174 + 13;
        r64 = r175;
        goto L63
    L66:
        r172 = r173 | (r65 << r174);
        int r66 = r175;
    L68:
        int r176 = r66 + 1;
        int r67 = r0.charAt(r66);
        if (r67 < 55296) goto L75;
        int r68 = r67 & 8191;
        int r69 = r176;
        int r177 = 13;
    L71:
        int r178 = r69 + 1;
        char r70 = r0.charAt(r69);
        if (r70 < 55296) goto L74;
        r68 = r68 | ((r70 & 8191) << r177);
        r177 = r177 + 13;
        r69 = r178;
        goto L71
    L74:
        r67 = r68 | (r70 << r177);
        r176 = r178;
    L75:
        int[] r71 = new int[(r67 + r166) + r172];
        r19 = (r55 * 2) + r60;
        r20 = r160;
        r110 = r71;
        r14 = r166;
        r18 = r67;
        r3 = r55;
        r5 = r176;
        goto L76
    L67:
        r66 = r171;
        goto L68
    L8:
        r7 = 1;
        goto L9
    }

    private int numberAt(int r1) {
        return this.buffer[r1];
    }

    private static long offset(int r2) {
        return r2 & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T r0, long r1) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r0, r1), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static <T> double oneofDoubleAt(T r0, long r1) {
        return ((Double) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r0, r1), Double.class, "com.obric.memorydata.plugin")).doubleValue();
    }

    private static <T> float oneofFloatAt(T r0, long r1) {
        return ((Float) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r0, r1), Float.class, "com.obric.memorydata.plugin")).floatValue();
    }

    private static <T> int oneofIntAt(T r0, long r1) {
        return ((Integer) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r0, r1), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    private static <T> long oneofLongAt(T r0, long r1) {
        return ((Long) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r0, r1), Long.class, "com.obric.memorydata.plugin")).longValue();
    }

    private <K, V> int parseMapField(T r10, byte[] r11, int r12, int r13, int r14, long r15, ArrayDecoders.Registers r17) {
        Unsafe r4 = UNSAFE;
        Object r5 = getMapFieldDefaultEntry(r14);
        Object r6 = r4.getObject(r10, r15);
        if (this.mapFieldSchema.isImmutable(r6) == false) goto L6;
        Object r7 = this.mapFieldSchema.newMapField(r5);
        this.mapFieldSchema.mergeFrom(r7, r6);
        r4.putObject(r10, r15, r7);
        r6 = r7;
    L6:
        return decodeMapEntry(r11, r12, r13, this.mapFieldSchema.forMapMetadata(r5), this.mapFieldSchema.forMutableMapData(r6), r17);
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
        int r0 = ArrayDecoders.decodeVarint64(r18, r19, r29);
        long r2 = CodedInputStream.decodeZigZag64(r29.long1);
    L54:
        Object r3 = Long.valueOf(r2);
    L55:
        r11.putObject(r17, r26, r3);
    L63:
        r11.putInt(r17, r12, r22);
        return r0;
    L83:
        return r19;
    L10:
        if (r23 != 0) goto L84;
        r0 = ArrayDecoders.decodeVarint32(r18, r19, r29);
        int r4 = CodedInputStream.decodeZigZag32(r29.int1);
    L51:
        r3 = Integer.valueOf(r4);
        goto L55
    L84:
        return r19;
    L12:
        if (r23 != 0) goto L85;
        int r5 = ArrayDecoders.decodeVarint32(r18, r19, r29);
        int r6 = r29.int1;
        Internal.EnumVerifier r1 = getEnumFieldVerifier(r28);
        if (r1 != null) goto L16;
    L19:
        r11.putObject(r17, r26, Integer.valueOf(r6));
        r11.putInt(r17, r12, r22);
    L80:
        return r5;
    L16:
        if (r1.isInRange(r6) == true) goto L19;
        getMutableUnknownFields(r17).storeField(r21, Long.valueOf(r6));
        goto L80
    L85:
        return r19;
    L21:
        if (r23 != 2) goto L86;
        r0 = ArrayDecoders.decodeBytes(r18, r19, r29);
        r3 = r29.object1;
        goto L55
    L86:
        return r19;
    L23:
        if (r23 != 2) goto L87;
        Object r13 = mutableOneofMessageFieldForMerge(r17, r22, r28);
        int r7 = ArrayDecoders.mergeMessageField(r13, getMessageFieldSchema(r28), r18, r19, r20, r29);
    L25:
        storeOneofMessageField(r17, r22, r28, r13);
        return r7;
    L87:
        return r19;
    L26:
        if (r23 != 2) goto L88;
        r0 = ArrayDecoders.decodeVarint32(r18, r19, r29);
        int r8 = r29.int1;
        if (r8 != 0) goto L31;
        r3 = "";
        goto L55
    L31:
        if ((r24 & 536870912) != 0) goto L33;
    L37:
        r11.putObject(r17, r26, new String(r18, r0, r8, Internal.UTF_8));
        r0 = r0 + r8;
        goto L63
    L33:
        if (Utf8.isValidUtf8(r18, r0, r0 + r8) == true) goto L37;
        throw InvalidProtocolBufferException.invalidUtf8();
    L88:
        return r19;
    L38:
        if (r23 != 0) goto L89;
        r0 = ArrayDecoders.decodeVarint64(r18, r19, r29);
        if (r29.long1 == 0) goto L42;
        boolean r15 = true;
    L43:
        r3 = Boolean.valueOf(r15);
        goto L55
    L42:
        r15 = false;
        goto L43
    L89:
        return r19;
    L44:
        if (r23 != 5) goto L90;
        Object r9 = Integer.valueOf(ArrayDecoders.decodeFixed32(r18, r19));
    L58:
        r11.putObject(r17, r26, r9);
        r0 = r19 + 4;
        goto L63
    L90:
        return r19;
    L49:
        if (r23 != 0) goto L92;
        r0 = ArrayDecoders.decodeVarint32(r18, r19, r29);
        r4 = r29.int1;
        goto L51
    L92:
        return r19;
    L52:
        if (r23 != 0) goto L93;
        r0 = ArrayDecoders.decodeVarint64(r18, r19, r29);
        r2 = r29.long1;
        goto L54
    L93:
        return r19;
    L56:
        if (r23 != 5) goto L94;
        r9 = Float.valueOf(ArrayDecoders.decodeFloat(r18, r19));
        goto L58
    L94:
        return r19;
    L6:
        if (r23 != 3) goto L65;
        r13 = mutableOneofMessageFieldForMerge(r17, r22, r28);
        r7 = ArrayDecoders.mergeGroupField(r13, getMessageFieldSchema(r28), r18, r19, r20, (r21 & (-8)) | 4, r29);
        goto L25
    L65:
        return r19;
    L47:
        if (r23 != 1) goto L91;
        Object r10 = Long.valueOf(ArrayDecoders.decodeFixed64(r18, r19));
    L62:
        r11.putObject(r17, r26, r10);
        r0 = r19 + 8;
        goto L63
    L91:
        return r19;
    L60:
        if (r23 != 1) goto L95;
        r10 = Double.valueOf(ArrayDecoders.decodeDouble(r18, r19));
        goto L62
    L95:
        return r19;
    L96:
        return r19;
    }

    private int parseRepeatedField(T r14, byte[] r15, int r16, int r17, int r18, int r19, int r20, int r21, long r22, int r24, long r25, ArrayDecoders.Registers r27) {
        Unsafe r9 = UNSAFE;
        Internal.ProtobufList r10 = (Internal.ProtobufList) ZeusTransformUtils.preCheckCast(r9.getObject(r14, r25), Internal.ProtobufList.class, "com.obric.memorydata.plugin");
        if (r10.isModifiable() == true) goto L6;
        r10 = r10.mutableCopyWithCapacity(r10.size() * 2);
        r9.putObject(r14, r25, r10);
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
        return ArrayDecoders.decodeSInt64List(r18, r15, r16, r17, r10, r27);
    L101:
        return r16;
    L78:
        return ArrayDecoders.decodePackedSInt64List(r15, r16, r10, r27);
    L15:
        if (r20 == 2) goto L80;
        if (r20 != 0) goto L102;
        return ArrayDecoders.decodeSInt32List(r18, r15, r16, r17, r10, r27);
    L102:
        return r16;
    L80:
        return ArrayDecoders.decodePackedSInt32List(r15, r16, r10, r27);
    L19:
        if (r20 != 2) goto L21;
        int r2 = ArrayDecoders.decodePackedVarint32List(r15, r16, r10, r27);
    L23:
        Internal.ProtobufList r110 = r10;
        SchemaUtil.filterUnknownEnumList(r14, r19, r110, getEnumFieldVerifier(r21), null, this.unknownFieldSchema);
        return r2;
    L21:
        if (r20 != 0) goto L103;
        r2 = ArrayDecoders.decodeVarint32List(r18, r15, r16, r17, r10, r27);
        goto L23
    L103:
        return r16;
    L24:
        if (r20 != 2) goto L104;
        return ArrayDecoders.decodeBytesList(r18, r15, r16, r17, r10, r27);
    L104:
        return r16;
    L26:
        if (r20 != 2) goto L105;
        return ArrayDecoders.decodeMessageList(getMessageFieldSchema(r21), r18, r15, r16, r17, r10, r27);
    L105:
        return r16;
    L28:
        if (r20 != 2) goto L106;
        long r0 = r22 & 536870912;
        Internal.ProtobufList r23 = r10;
        if (r0 != 0) goto L86;
        return ArrayDecoders.decodeStringList(r18, r15, r16, r17, r23, r27);
    L86:
        return ArrayDecoders.decodeStringListRequireUtf8(r18, r15, r16, r17, r23, r27);
    L106:
        return r16;
    L33:
        if (r20 == 2) goto L87;
        if (r20 != 0) goto L107;
        return ArrayDecoders.decodeBoolList(r18, r15, r16, r17, r10, r27);
    L107:
        return r16;
    L87:
        return ArrayDecoders.decodePackedBoolList(r15, r16, r10, r27);
    L37:
        if (r20 == 2) goto L89;
        if (r20 != 5) goto L108;
        return ArrayDecoders.decodeFixed32List(r18, r15, r16, r17, r10, r27);
    L108:
        return r16;
    L89:
        return ArrayDecoders.decodePackedFixed32List(r15, r16, r10, r27);
    L41:
        if (r20 == 2) goto L91;
        if (r20 != 1) goto L109;
        return ArrayDecoders.decodeFixed64List(r18, r15, r16, r17, r10, r27);
    L109:
        return r16;
    L91:
        return ArrayDecoders.decodePackedFixed64List(r15, r16, r10, r27);
    L45:
        if (r20 == 2) goto L93;
        if (r20 != 0) goto L110;
        return ArrayDecoders.decodeVarint32List(r18, r15, r16, r17, r10, r27);
    L110:
        return r16;
    L93:
        return ArrayDecoders.decodePackedVarint32List(r15, r16, r10, r27);
    L49:
        if (r20 == 2) goto L95;
        if (r20 != 0) goto L111;
        return ArrayDecoders.decodeVarint64List(r18, r15, r16, r17, r10, r27);
    L111:
        return r16;
    L95:
        return ArrayDecoders.decodePackedVarint64List(r15, r16, r10, r27);
    L53:
        if (r20 == 2) goto L97;
        if (r20 != 5) goto L112;
        return ArrayDecoders.decodeFloatList(r18, r15, r16, r17, r10, r27);
    L112:
        return r16;
    L97:
        return ArrayDecoders.decodePackedFloatList(r15, r16, r10, r27);
    L57:
        if (r20 == 2) goto L99;
        if (r20 != 1) goto L113;
        return ArrayDecoders.decodeDoubleList(r18, r15, r16, r17, r10, r27);
    L113:
        return r16;
    L99:
        return ArrayDecoders.decodePackedDoubleList(r15, r16, r10, r27);
    L9:
        if (r20 != 3) goto L62;
        return ArrayDecoders.decodeGroupList(getMessageFieldSchema(r21), r18, r15, r16, r17, r10, r27);
    L62:
        return r16;
    L114:
        return r16;
    }

    private int positionForFieldNumber(int r2) {
        if (r2 >= this.minFieldNumber) goto L5;
        return -1;
    L5:
        if (r2 <= this.maxFieldNumber) goto L7;
        return -1;
    L7:
        return slowPositionForFieldNumber(r2, 0);
    }

    private int positionForFieldNumber(int r2, int r3) {
        if (r2 >= this.minFieldNumber) goto L5;
        return -1;
    L5:
        if (r2 <= this.maxFieldNumber) goto L7;
        return -1;
    L7:
        return slowPositionForFieldNumber(r2, r3);
    }

    private int presenceMaskAndOffsetAt(int r1) {
        return this.buffer[r1 + 2];
    }

    private <E> void readGroupList(Object r3, long r4, Reader r6, Schema<E> r7, ExtensionRegistryLite r8) {
        Reader r9 = (Reader) ZeusTransformUtils.wrapperContextForParams(r6, Reader.class, "com.obric.memorydata.plugin");
        Schema<T> r10 = (Schema) ZeusTransformUtils.wrapperContextForParams(r7, Schema.class, "com.obric.memorydata.plugin");
        r9.readGroupList(this.listFieldSchema.mutableListAt(r3, r4), r10, r8);
    }

    private <E> void readMessageList(Object r3, int r4, Reader r5, Schema<E> r6, ExtensionRegistryLite r7) {
        Reader r8 = (Reader) ZeusTransformUtils.wrapperContextForParams(r5, Reader.class, "com.obric.memorydata.plugin");
        Schema<T> r9 = (Schema) ZeusTransformUtils.wrapperContextForParams(r6, Schema.class, "com.obric.memorydata.plugin");
        long r0 = offset(r4);
        r8.readMessageList(this.listFieldSchema.mutableListAt(r3, r0), r9, r7);
    }

    private void readString(Object r3, int r4, Reader r5) {
        Reader r6 = (Reader) ZeusTransformUtils.wrapperContextForParams(r5, Reader.class, "com.obric.memorydata.plugin");
        if (isEnforceUtf8(r4) == false) goto L6;
        long r0 = offset(r4);
        Object r2 = r6.readStringRequireUtf8();
    L5:
        UnsafeUtil.putObject(r3, r0, r2);
        return;
    L6:
        boolean r7 = this.lite;
        r0 = offset(r4);
        if (r7 == false) goto L9;
        r2 = r6.readString();
        goto L5
    L9:
        r2 = r6.readBytes();
        goto L5
    }

    private void readStringList(Object r3, int r4, Reader r5) {
        Reader r6 = (Reader) ZeusTransformUtils.wrapperContextForParams(r5, Reader.class, "com.obric.memorydata.plugin");
        boolean r0 = isEnforceUtf8(r4);
        ListFieldSchema r2 = this.listFieldSchema;
        if (r0 == false) goto L5;
        r6.readStringListRequireUtf8(r2.mutableListAt(r3, offset(r4)));
        return;
    L5:
        r6.readStringList(r2.mutableListAt(r3, offset(r4)));
    }

    private static java.lang.reflect.Field reflectField(Class<?> r6, String r7) {
        return r6.getDeclaredField(r7);
    L4:
        e = move-exception;
        java.lang.reflect.Field[] r1 = r6.getDeclaredFields();
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        java.lang.reflect.Field r4 = r1[r3];
        if (r7.equals(r4.getName()) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return r4;
    L12:
        throw new RuntimeException("Field " + r7 + " for " + r6.getName() + " not found. Known fields are " + Arrays.toString(r1), e);
    }

    private void setFieldPresent(T r5, int r6) {
        int r4 = presenceMaskAndOffsetAt(r6);
        long r0 = 1048575 & r4;
        if (r0 != 1048575) goto L5;
        return;
    L5:
        UnsafeUtil.putInt(r5, r0, (1 << (r4 >>> 20)) | UnsafeUtil.getInt(r5, r0));
    }

    private void setOneofPresent(T r3, int r4, int r5) {
        UnsafeUtil.putInt(r3, presenceMaskAndOffsetAt(r5) & 1048575, r4);
    }

    private int slowPositionForFieldNumber(int r5, int r6) {
        int r0 = (this.buffer.length / 3) - 1;
    L3:
        if (r6 > r0) goto L10;
        int r1 = (r0 + r6) >>> 1;
        int r2 = r1 * 3;
        int r3 = numberAt(r2);
        if (r5 == r3) goto L6;
        if (r5 < r3) goto L8;
        r6 = r1 + 1;
        goto L3
    L8:
        r0 = r1 - 1;
        goto L3
    L6:
        return r2;
    L10:
        return -1;
    }

    private static void storeFieldData(FieldInfo r8, int[] r9, int r10, Object[] r11) {
        OneofInfo r0 = r8.getOneof();
        int r1 = 0;
        if (r0 == null) goto L6;
        int r2 = r8.getType().id() + 51;
        int r3 = (int) UnsafeUtil.objectFieldOffset(r0.getValueField());
        java.lang.reflect.Field r4 = r0.getCaseField();
    L5:
        int r5 = (int) UnsafeUtil.objectFieldOffset(r4);
        int r6 = 0;
    L19:
        r9[r10] = r8.getFieldNumber();
        int r7 = r10 + 1;
        if (r8.isEnforceUtf8() == false) goto L22;
        int r12 = 536870912;
    L24:
        if (r8.isRequired() == false) goto L26;
        r1 = 268435456;
    L26:
        r9[r7] = ((r1 | r12) | (r2 << 20)) | r3;
        r9[r10 + 2] = r5 | (r6 << 20);
        Class<?> r13 = r8.getMessageFieldClass();
        if (r8.getMapDefaultEntry() == null) goto L34;
        int r14 = (r10 / 3) * 2;
        r11[r14] = r8.getMapDefaultEntry();
        if (r13 == null) goto L32;
        r11[r14 + 1] = r13;
        return;
    L32:
        if (r8.getEnumVerifier() == null) goto L41;
        r11[r14 + 1] = r8.getEnumVerifier();
        return;
    L41:
        return;
    L34:
        if (r13 == null) goto L37;
        r11[((r10 / 3) * 2) + 1] = r13;
        return;
    L37:
        if (r8.getEnumVerifier() == null) goto L44;
        r11[((r10 / 3) * 2) + 1] = r8.getEnumVerifier();
        return;
    L44:
        return;
    L22:
        r12 = 0;
        goto L24
    L6:
        FieldType r15 = r8.getType();
        r3 = (int) UnsafeUtil.objectFieldOffset(r8.getField());
        r2 = r15.id();
        if (r15.isList() == true) goto L16;
        if (r15.isMap() == true) goto L16;
        java.lang.reflect.Field r16 = r8.getPresenceField();
        if (r16 != null) goto L13;
        r5 = 1048575;
    L14:
        r6 = Integer.numberOfTrailingZeros(r8.getPresenceMask());
        goto L19
    L13:
        r5 = (int) UnsafeUtil.objectFieldOffset(r16);
    L16:
        if (r8.getCachedSizeField() != null) goto L18;
        r5 = 0;
        r6 = 0;
        goto L19
    L18:
        r4 = r8.getCachedSizeField();
        goto L5
    }

    private void storeMessageField(T r4, int r5, Object r6) {
        UNSAFE.putObject(r4, offset(typeAndOffsetAt(r5)), r6);
        setFieldPresent(r4, r5);
    }

    private void storeOneofMessageField(T r4, int r5, int r6, Object r7) {
        UNSAFE.putObject(r4, offset(typeAndOffsetAt(r6)), r7);
        setOneofPresent(r4, r5, r6);
    }

    private static int type(int r1) {
        return (r1 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int r1) {
        return this.buffer[r1 + 1];
    }

    private void writeFieldsInAscendingOrder(T r23, Writer r24) {
        Writer r9 = (Writer) ZeusTransformUtils.wrapperContextForParams(r24, Writer.class, "com.obric.memorydata.plugin");
        if (this.hasExtensions == false) goto L7;
        FieldSet<T> r0 = this.extensionSchema.getExtensions(r23);
        if (r0.isEmpty() == true) goto L7;
        Iterator r1 = r0.iterator();
        Map.Entry<?, ?> r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterator r11 = r1;
    L8:
        int r12 = this.buffer.length;
        Unsafe r13 = UNSAFE;
        int r3 = 1048575;
        int r4 = 0;
        int r5 = 0;
    L9:
        if (r5 >= r12) goto L179;
        int r6 = typeAndOffsetAt(r5);
        int r7 = numberAt(r5);
        int r10 = type(r6);
        if (r10 > 17) goto L19;
        int r15 = this.buffer[r5 + 2];
        Map.Entry<?, ?> r17 = r2;
        int r8 = r15 & 1048575;
        if (r8 == r3) goto L18;
        if (r8 != 1048575) goto L16;
        r4 = 0;
    L17:
        r3 = r8;
        goto L18
    L16:
        r4 = r13.getInt(r23, r8);
    L18:
        int r14 = r3;
        int r19 = 1 << (r15 >>> 20);
        Map.Entry<?, ?> r16 = r17;
    L20:
        int r18 = r4;
    L21:
        if (r16 == null) goto L28;
        if (this.extensionSchema.extensionNumber(r16) > r7) goto L28;
        this.extensionSchema.serializeExtension(r9, r16);
        if (r11.hasNext() == true) goto L26;
        r16 = null;
        goto L21
    L26:
        r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
    L28:
        long r20 = offset(r6);
        switch(r10) {
            case 0: goto L175;
            case 1: goto L172;
            case 2: goto L169;
            case 3: goto L166;
            case 4: goto L163;
            case 5: goto L160;
            case 6: goto L157;
            case 7: goto L154;
            case 8: goto L151;
            case 9: goto L148;
            case 10: goto L145;
            case 11: goto L142;
            case 12: goto L139;
            case 13: goto L136;
            case 14: goto L133;
            case 15: goto L130;
            case 16: goto L127;
            case 17: goto L124;
            case 18: goto L123;
            case 19: goto L122;
            case 20: goto L121;
            case 21: goto L120;
            case 22: goto L119;
            case 23: goto L118;
            case 24: goto L117;
            case 25: goto L116;
            case 26: goto L115;
            case 27: goto L114;
            case 28: goto L113;
            case 29: goto L111;
            case 30: goto L109;
            case 31: goto L107;
            case 32: goto L105;
            case 33: goto L103;
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
        Iterator r110 = r11;
        int r21 = r12;
        Map.Entry<?, ?> r22 = r16;
        int r111 = r5;
    L178:
        r5 = r111 + 3;
        r3 = r14;
        r11 = r110;
        r4 = r18;
        r12 = r21;
        r2 = r22;
        goto L9
    L85:
        writeMapHelper(r9, r7, r13.getObject(r23, r20), r5);
        goto L30
    L86:
        SchemaUtil.writeGroupList(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, getMessageFieldSchema(r5));
        goto L30
    L87:
        int r25 = numberAt(r5);
        List r26 = (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin");
        boolean r27 = true;
    L102:
        SchemaUtil.writeSInt64List(r25, r26, r9, r27);
        goto L30
    L88:
        boolean r28 = true;
    L104:
        SchemaUtil.writeSInt32List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, r28);
        goto L30
    L89:
        boolean r29 = true;
    L106:
        SchemaUtil.writeSFixed64List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, r29);
        goto L30
    L90:
        boolean r30 = true;
    L108:
        SchemaUtil.writeSFixed32List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, r30);
        goto L30
    L91:
        boolean r31 = true;
    L110:
        SchemaUtil.writeEnumList(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, r31);
        goto L30
    L92:
        boolean r32 = true;
    L112:
        SchemaUtil.writeUInt32List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, r32);
        goto L30
    L93:
        SchemaUtil.writeBoolList(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L94:
        SchemaUtil.writeFixed32List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L95:
        SchemaUtil.writeFixed64List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L96:
        SchemaUtil.writeInt32List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L97:
        SchemaUtil.writeUInt64List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L98:
        SchemaUtil.writeInt64List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L99:
        SchemaUtil.writeFloatList(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L100:
        SchemaUtil.writeDoubleList(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L101:
        r25 = numberAt(r5);
        r26 = (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin");
        r27 = false;
        goto L102
    L103:
        r28 = false;
        goto L104
    L105:
        r29 = false;
        goto L106
    L107:
        r30 = false;
        goto L108
    L109:
        r31 = false;
        goto L110
    L111:
        r32 = false;
        goto L112
    L113:
        SchemaUtil.writeBytesList(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9);
        goto L30
    L114:
        SchemaUtil.writeMessageList(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, getMessageFieldSchema(r5));
        goto L30
    L115:
        SchemaUtil.writeStringList(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9);
        goto L30
    L116:
        SchemaUtil.writeBoolList(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L117:
        SchemaUtil.writeFixed32List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L118:
        SchemaUtil.writeFixed64List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L119:
        SchemaUtil.writeInt32List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L120:
        SchemaUtil.writeUInt64List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L121:
        SchemaUtil.writeInt64List(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L122:
        SchemaUtil.writeFloatList(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L123:
        SchemaUtil.writeDoubleList(numberAt(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L124:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r5, r14, r18, r19) == false) goto L178;
        r9.writeGroup(r7, r13.getObject(r23, r20), getMessageFieldSchema(r111));
        goto L178
    L127:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeSInt64(r7, r13.getLong(r23, r20));
        goto L178
    L130:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeSInt32(r7, r13.getInt(r23, r20));
        goto L178
    L133:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeSFixed64(r7, r13.getLong(r23, r20));
        goto L178
    L136:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeSFixed32(r7, r13.getInt(r23, r20));
        goto L178
    L139:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeEnum(r7, r13.getInt(r23, r20));
        goto L178
    L142:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeUInt32(r7, r13.getInt(r23, r20));
        goto L178
    L145:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeBytes(r7, (ByteString) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), ByteString.class, "com.obric.memorydata.plugin"));
        goto L178
    L148:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeMessage(r7, r13.getObject(r23, r20), getMessageFieldSchema(r111));
        goto L178
    L151:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        writeString(r7, r13.getObject(r23, r20), r9);
        goto L178
    L154:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeBool(r7, booleanAt(r23, r20));
        goto L178
    L157:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeFixed32(r7, r13.getInt(r23, r20));
        goto L178
    L160:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeFixed64(r7, r13.getLong(r23, r20));
        goto L178
    L163:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeInt32(r7, r13.getInt(r23, r20));
        goto L178
    L166:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeUInt64(r7, r13.getLong(r23, r20));
        goto L178
    L169:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeInt64(r7, r13.getLong(r23, r20));
        goto L178
    L172:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeFloat(r7, floatAt(r23, r20));
        goto L178
    L175:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (isFieldPresent(r23, r111, r14, r18, r19) == false) goto L178;
        r9.writeDouble(r7, doubleAt(r23, r20));
        goto L178
    L32:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeGroup(r7, r13.getObject(r23, r20), getMessageFieldSchema(r5));
        goto L30
    L35:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeSInt64(r7, oneofLongAt(r23, r20));
        goto L30
    L38:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeSInt32(r7, oneofIntAt(r23, r20));
        goto L30
    L41:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeSFixed64(r7, oneofLongAt(r23, r20));
        goto L30
    L44:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeSFixed32(r7, oneofIntAt(r23, r20));
        goto L30
    L47:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeEnum(r7, oneofIntAt(r23, r20));
        goto L30
    L50:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeUInt32(r7, oneofIntAt(r23, r20));
        goto L30
    L53:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeBytes(r7, (ByteString) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), ByteString.class, "com.obric.memorydata.plugin"));
        goto L30
    L56:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeMessage(r7, r13.getObject(r23, r20), getMessageFieldSchema(r5));
        goto L30
    L59:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        writeString(r7, r13.getObject(r23, r20), r9);
        goto L30
    L62:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeBool(r7, oneofBooleanAt(r23, r20));
        goto L30
    L65:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeFixed32(r7, oneofIntAt(r23, r20));
        goto L30
    L68:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeFixed64(r7, oneofLongAt(r23, r20));
        goto L30
    L71:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeInt32(r7, oneofIntAt(r23, r20));
        goto L30
    L74:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeUInt64(r7, oneofLongAt(r23, r20));
        goto L30
    L77:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeInt64(r7, oneofLongAt(r23, r20));
        goto L30
    L80:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeFloat(r7, oneofFloatAt(r23, r20));
        goto L30
    L83:
        if (isOneofPresent(r23, r7, r5) == false) goto L30;
        r9.writeDouble(r7, oneofDoubleAt(r23, r20));
        goto L30
    L19:
        r14 = r3;
        r16 = r2;
        r19 = 0;
        goto L20
    L179:
        Iterator r112 = r11;
    L180:
        if (r2 == null) goto L185;
        this.extensionSchema.serializeExtension(r9, r2);
        if (r112.hasNext() == true) goto L183;
        r2 = null;
        goto L180
    L183:
        r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r112.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        goto L180
    L185:
        writeUnknownInMessageTo(this.unknownFieldSchema, r23, r9);
        return;
    L7:
        r2 = null;
        r11 = null;
        goto L8
    }

    private void writeFieldsInDescendingOrder(T r12, Writer r13) {
        Writer r14 = (Writer) ZeusTransformUtils.wrapperContextForParams(r13, Writer.class, "com.obric.memorydata.plugin");
        writeUnknownInMessageTo(this.unknownFieldSchema, r12, r14);
        if (this.hasExtensions == false) goto L7;
        FieldSet<T> r0 = this.extensionSchema.getExtensions(r12);
        if (r0.isEmpty() == true) goto L7;
        Iterator r1 = r0.descendingIterator();
        Map.Entry<?, ?> r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
    L8:
        int r4 = this.buffer.length - 3;
    L9:
        if (r4 < 0) goto L177;
        int r5 = typeAndOffsetAt(r4);
        int r6 = numberAt(r4);
    L11:
        if (r3 == null) goto L19;
        if (this.extensionSchema.extensionNumber(r3) <= r6) goto L19;
        this.extensionSchema.serializeExtension(r14, r3);
        if (r1.hasNext() == true) goto L16;
        r3 = null;
        goto L11
    L16:
        r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
    L19:
        switch(type(r5)) {
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
        writeMapHelper(r14, r6, UnsafeUtil.getObject(r12, offset(r5)), r4);
        goto L176
    L76:
        SchemaUtil.writeGroupList(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, getMessageFieldSchema(r4));
        goto L176
    L77:
        SchemaUtil.writeSInt64List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L78:
        SchemaUtil.writeSInt32List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L79:
        SchemaUtil.writeSFixed64List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L80:
        SchemaUtil.writeSFixed32List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L81:
        SchemaUtil.writeEnumList(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L82:
        SchemaUtil.writeUInt32List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L83:
        SchemaUtil.writeBoolList(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L84:
        SchemaUtil.writeFixed32List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L85:
        SchemaUtil.writeFixed64List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L86:
        SchemaUtil.writeInt32List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L87:
        SchemaUtil.writeUInt64List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L88:
        SchemaUtil.writeInt64List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L89:
        SchemaUtil.writeFloatList(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L90:
        SchemaUtil.writeDoubleList(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L91:
        SchemaUtil.writeSInt64List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L92:
        SchemaUtil.writeSInt32List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L93:
        SchemaUtil.writeSFixed64List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L94:
        SchemaUtil.writeSFixed32List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L95:
        SchemaUtil.writeEnumList(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L96:
        SchemaUtil.writeUInt32List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L97:
        SchemaUtil.writeBytesList(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14);
        goto L176
    L98:
        SchemaUtil.writeMessageList(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, getMessageFieldSchema(r4));
        goto L176
    L99:
        SchemaUtil.writeStringList(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14);
        goto L176
    L100:
        SchemaUtil.writeBoolList(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L101:
        SchemaUtil.writeFixed32List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L102:
        SchemaUtil.writeFixed64List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L103:
        SchemaUtil.writeInt32List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L104:
        SchemaUtil.writeUInt64List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L105:
        SchemaUtil.writeInt64List(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L106:
        SchemaUtil.writeFloatList(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L107:
        SchemaUtil.writeDoubleList(numberAt(r4), (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L22:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
    L110:
        r14.writeGroup(r6, UnsafeUtil.getObject(r12, offset(r5)), getMessageFieldSchema(r4));
        goto L176
    L25:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        long r7 = oneofLongAt(r12, offset(r5));
    L114:
        r14.writeSInt64(r6, r7);
        goto L176
    L28:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        int r8 = oneofIntAt(r12, offset(r5));
    L118:
        r14.writeSInt32(r6, r8);
        goto L176
    L31:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        long r9 = oneofLongAt(r12, offset(r5));
    L122:
        r14.writeSFixed64(r6, r9);
        goto L176
    L34:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        int r10 = oneofIntAt(r12, offset(r5));
    L126:
        r14.writeSFixed32(r6, r10);
        goto L176
    L37:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        int r11 = oneofIntAt(r12, offset(r5));
    L130:
        r14.writeEnum(r6, r11);
        goto L176
    L40:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        int r15 = oneofIntAt(r12, offset(r5));
    L134:
        r14.writeUInt32(r6, r15);
        goto L176
    L43:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
    L137:
        r14.writeBytes(r6, (ByteString) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r12, offset(r5)), ByteString.class, "com.obric.memorydata.plugin"));
        goto L176
    L46:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
    L140:
        r14.writeMessage(r6, UnsafeUtil.getObject(r12, offset(r5)), getMessageFieldSchema(r4));
        goto L176
    L49:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
    L143:
        writeString(r6, UnsafeUtil.getObject(r12, offset(r5)), r14);
        goto L176
    L52:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        boolean r16 = oneofBooleanAt(r12, offset(r5));
    L147:
        r14.writeBool(r6, r16);
        goto L176
    L55:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        int r17 = oneofIntAt(r12, offset(r5));
    L151:
        r14.writeFixed32(r6, r17);
        goto L176
    L58:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        long r18 = oneofLongAt(r12, offset(r5));
    L155:
        r14.writeFixed64(r6, r18);
        goto L176
    L61:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        int r19 = oneofIntAt(r12, offset(r5));
    L159:
        r14.writeInt32(r6, r19);
        goto L176
    L64:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        long r20 = oneofLongAt(r12, offset(r5));
    L163:
        r14.writeUInt64(r6, r20);
        goto L176
    L67:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        long r21 = oneofLongAt(r12, offset(r5));
    L167:
        r14.writeInt64(r6, r21);
        goto L176
    L70:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        float r22 = oneofFloatAt(r12, offset(r5));
    L171:
        r14.writeFloat(r6, r22);
        goto L176
    L73:
        if (isOneofPresent(r12, r6, r4) == false) goto L176;
        double r23 = oneofDoubleAt(r12, offset(r5));
    L175:
        r14.writeDouble(r6, r23);
        goto L176
    L109:
        if (isFieldPresent(r12, r4) == false) goto L176;
    L112:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r7 = longAt(r12, offset(r5));
        goto L114
    L116:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r8 = intAt(r12, offset(r5));
        goto L118
    L120:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r9 = longAt(r12, offset(r5));
        goto L122
    L124:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r10 = intAt(r12, offset(r5));
        goto L126
    L128:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r11 = intAt(r12, offset(r5));
        goto L130
    L132:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r15 = intAt(r12, offset(r5));
        goto L134
    L136:
        if (isFieldPresent(r12, r4) == false) goto L176;
    L139:
        if (isFieldPresent(r12, r4) == false) goto L176;
    L142:
        if (isFieldPresent(r12, r4) == false) goto L176;
    L145:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r16 = booleanAt(r12, offset(r5));
        goto L147
    L149:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r17 = intAt(r12, offset(r5));
        goto L151
    L153:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r18 = longAt(r12, offset(r5));
        goto L155
    L157:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r19 = intAt(r12, offset(r5));
        goto L159
    L161:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r20 = longAt(r12, offset(r5));
        goto L163
    L165:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r21 = longAt(r12, offset(r5));
        goto L167
    L169:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r22 = floatAt(r12, offset(r5));
        goto L171
    L173:
        if (isFieldPresent(r12, r4) == false) goto L176;
        r23 = doubleAt(r12, offset(r5));
    L176:
        r4 = r4 - 3;
    L177:
        if (r3 == null) goto L182;
        this.extensionSchema.serializeExtension(r14, r3);
        if (r1.hasNext() == true) goto L180;
        r3 = null;
        goto L177
    L180:
        r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        goto L177
    L182:
        return;
    L7:
        r1 = null;
        r3 = null;
        goto L8
    }

    private <K, V> void writeMapHelper(Writer r3, int r4, Object r5, int r6) {
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r3, Writer.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L6;
        r7.writeMap(r4, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(r6)), this.mapFieldSchema.forMapData(r5));
        return;
    }

    private void writeString(int r2, Object r3, Writer r4) {
        Writer r1 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L5;
        r1.writeString(r2, (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r1.writeBytes(r2, (ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> r2, T r3, Writer r4) {
        Writer r1 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        r2.writeTo(r2.getFromMessage(r3), r1);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T r5, T r6) {
        int r0 = this.buffer.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (equals(r5, r6, r2) == false) goto L6;
        r2 = r2 + 3;
        goto L3
    L6:
        return false;
    L9:
        if (this.unknownFieldSchema.getFromMessage(r5).equals(this.unknownFieldSchema.getFromMessage(r6)) == true) goto L12;
        return false;
    L12:
        if (this.hasExtensions == true) goto L14;
        return true;
    L14:
        return this.extensionSchema.getExtensions(r5).equals(this.extensionSchema.getExtensions(r6));
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v212 */
    /* JADX WARN: Type inference failed for: r0v214 */
    /* JADX WARN: Type inference failed for: r0v216 */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
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
    /* JADX WARN: Type inference failed for: r1v114 */
    /* JADX WARN: Type inference failed for: r1v115 */
    /* JADX WARN: Type inference failed for: r1v117 */
    /* JADX WARN: Type inference failed for: r1v27 */
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
    public int getSerializedSize(T r20) {
        Unsafe r8 = UNSAFE;
        int r9 = 1048575;
        ?? r10 = 0;
        int r0 = 1048575;
        ?? r1 = 0;
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r11 >= this.buffer.length) goto L231;
        int r2 = typeAndOffsetAt(r11);
        int r3 = type(r2);
        int r13 = numberAt(r11);
        int r4 = this.buffer[r11 + 2];
        int r5 = r4 & r9;
        int r6 = r0;
        ?? r7 = r1;
        if (r3 > 17) goto L13;
        if (r5 == r0) goto L12;
        if (r5 != r9) goto L10;
        ?? r14 = r10;
    L11:
        r7 = r14;
        r6 = r5 == true ? 1 : 0;
        goto L12
    L10:
        r14 = r8.getInt(r20, r5 == true ? 1 : 0);
    L12:
        int r15 = r6;
        ?? r16 = r7;
        ?? r17 = 1 << (r4 >>> 20);
    L14:
        long r18 = offset(r2);
        if (r3 < FieldType.DOUBLE_LIST_PACKED.id()) goto L19;
        ?? r19 = r5;
        if (r3 > FieldType.SINT64_LIST_PACKED.id()) goto L19;
    L20:
        ?? r21 = r19;
        switch(r3) {
            case 0: goto L226;
            case 1: goto L223;
            case 2: goto L220;
            case 3: goto L217;
            case 4: goto L214;
            case 5: goto L211;
            case 6: goto L208;
            case 7: goto L203;
            case 8: goto L197;
            case 9: goto L192;
            case 10: goto L189;
            case 11: goto L186;
            case 12: goto L183;
            case 13: goto L180;
            case 14: goto L177;
            case 15: goto L174;
            case 16: goto L171;
            case 17: goto L168;
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
        int r22 = this.mapFieldSchema.getSerializedSize(r13, r8.getObject(r20, r18), getMapFieldDefaultEntry(r11));
    L166:
        r12 = r12 + r22;
        goto L167
    L81:
        r22 = SchemaUtil.computeSizeGroupList(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), getMessageFieldSchema(r11));
        goto L166
    L82:
        int r23 = SchemaUtil.computeSizeSInt64ListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == true) goto L151;
    L152:
        r22 = (CodedOutputStream.computeTagSize(r13) + CodedOutputStream.computeUInt32SizeNoTag(r23)) + r23;
    L151:
        r8.putInt(r20, r21 == true ? 1 : 0, r23);
        goto L152
    L87:
        r23 = SchemaUtil.computeSizeSInt32ListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L92:
        r23 = SchemaUtil.computeSizeFixed64ListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L97:
        r23 = SchemaUtil.computeSizeFixed32ListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L102:
        r23 = SchemaUtil.computeSizeEnumListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L107:
        r23 = SchemaUtil.computeSizeUInt32ListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L112:
        r23 = SchemaUtil.computeSizeBoolListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L117:
        r23 = SchemaUtil.computeSizeFixed32ListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L122:
        r23 = SchemaUtil.computeSizeFixed64ListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L127:
        r23 = SchemaUtil.computeSizeInt32ListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L132:
        r23 = SchemaUtil.computeSizeUInt64ListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L137:
        r23 = SchemaUtil.computeSizeInt64ListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L142:
        r23 = SchemaUtil.computeSizeFixed32ListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L147:
        r23 = SchemaUtil.computeSizeFixed64ListNoTag((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.useCachedSizeField == false) goto L152;
    L153:
        r22 = SchemaUtil.computeSizeSInt64List(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L154:
        r22 = SchemaUtil.computeSizeSInt32List(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L155:
        r22 = SchemaUtil.computeSizeEnumList(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L156:
        r22 = SchemaUtil.computeSizeUInt32List(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L157:
        r22 = SchemaUtil.computeSizeByteStringList(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        goto L166
    L158:
        r22 = SchemaUtil.computeSizeMessageList(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), getMessageFieldSchema(r11));
        goto L166
    L159:
        r22 = SchemaUtil.computeSizeStringList(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        goto L166
    L160:
        r22 = SchemaUtil.computeSizeBoolList(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L161:
        r22 = SchemaUtil.computeSizeInt32List(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L162:
        r22 = SchemaUtil.computeSizeUInt64List(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L163:
        r22 = SchemaUtil.computeSizeInt64List(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L164:
        r22 = SchemaUtil.computeSizeFixed32List(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L165:
        r22 = SchemaUtil.computeSizeFixed64List(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L168:
        int r110 = r11;
        if (isFieldPresent(r20, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L207;
        int r24 = CodedOutputStream.computeGroupSize(r13, (MessageLite) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), MessageLite.class, "com.obric.memorydata.plugin"), getMessageFieldSchema(r110));
    L206:
        r12 = r12 + r24;
    L207:
        ?? r111 = 0;
    L230:
        r11 = r110 + 3;
        r0 = r15;
        r10 = r111;
        r1 = r16;
        r9 = 1048575;
        goto L4
    L171:
        int r112 = r11;
        if (isFieldPresent(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        int r25 = CodedOutputStream.computeSInt64Size(r13, r8.getLong(r20, r18));
    L195:
        r12 = r12 + r25;
    L196:
        r110 = r112;
        goto L207
    L174:
        r112 = r11;
        if (isFieldPresent(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r25 = CodedOutputStream.computeSInt32Size(r13, r8.getInt(r20, r18));
        goto L195
    L177:
        r112 = r11;
        if (isFieldPresent(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r25 = CodedOutputStream.computeSFixed64Size(r13, 0);
        goto L195
    L180:
        r112 = r11;
        if (isFieldPresent(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r12 = r12 + CodedOutputStream.computeSFixed32Size(r13, 0);
        goto L196
    L183:
        r112 = r11;
        if (isFieldPresent(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r25 = CodedOutputStream.computeEnumSize(r13, r8.getInt(r20, r18));
        goto L195
    L186:
        r112 = r11;
        if (isFieldPresent(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r25 = CodedOutputStream.computeUInt32Size(r13, r8.getInt(r20, r18));
        goto L195
    L189:
        r112 = r11;
        if (isFieldPresent(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r25 = CodedOutputStream.computeBytesSize(r13, (ByteString) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), ByteString.class, "com.obric.memorydata.plugin"));
        goto L195
    L192:
        r112 = r11;
        if (isFieldPresent(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r25 = SchemaUtil.computeSizeMessage(r13, r8.getObject(r20, r18), getMessageFieldSchema(r112));
        goto L195
    L197:
        r112 = r11;
        if (isFieldPresent(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        Object r26 = r8.getObject(r20, r18);
        if (ZeusTransformUtils.instanceOf(r26, ByteString.class) == false) goto L202;
        r25 = CodedOutputStream.computeBytesSize(r13, (ByteString) ZeusTransformUtils.preCheckCast(r26, ByteString.class, "com.obric.memorydata.plugin"));
        goto L195
    L202:
        r25 = CodedOutputStream.computeStringSize(r13, (String) ZeusTransformUtils.preCheckCast(r26, String.class, "com.obric.memorydata.plugin"));
        goto L195
    L203:
        r110 = r11;
        if (isFieldPresent(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L207;
        r24 = CodedOutputStream.computeBoolSize(r13, true);
        goto L206
    L208:
        r110 = r11;
        if (isFieldPresent(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L207;
        r111 = 0;
        int r27 = CodedOutputStream.computeFixed32Size(r13, 0);
    L229:
        r12 = r12 + r27;
        goto L230
    L211:
        r111 = r10;
        r110 = r11;
        if (isFieldPresent(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L230;
        r27 = CodedOutputStream.computeFixed64Size(r13, 0);
        r111 = r111;
        goto L229
    L214:
        r111 = r10;
        r110 = r11;
        if (isFieldPresent(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L230;
        r27 = CodedOutputStream.computeInt32Size(r13, r8.getInt(r20, r18));
        r111 = r111;
        goto L229
    L217:
        r111 = r10;
        r110 = r11;
        if (isFieldPresent(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L230;
        r27 = CodedOutputStream.computeUInt64Size(r13, r8.getLong(r20, r18));
        r111 = r111;
        goto L229
    L220:
        r111 = r10;
        r110 = r11;
        if (isFieldPresent(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L230;
        r27 = CodedOutputStream.computeInt64Size(r13, r8.getLong(r20, r18));
        r111 = r111;
        goto L229
    L223:
        r111 = r10;
        r110 = r11;
        if (isFieldPresent(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L230;
        r27 = CodedOutputStream.computeFloatSize(r13, 0.0f);
        r111 = r111;
        goto L229
    L226:
        r111 = r10;
        r110 = r11;
        if (isFieldPresent(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L230;
        r27 = CodedOutputStream.computeDoubleSize(r13, 0.0d);
        r111 = r111;
    L167:
        r111 = r10;
        r110 = r11;
        goto L230
    L24:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeGroupSize(r13, (MessageLite) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), MessageLite.class, "com.obric.memorydata.plugin"), getMessageFieldSchema(r11));
        goto L166
    L27:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeSInt64Size(r13, oneofLongAt(r20, r18));
        goto L166
    L30:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeSInt32Size(r13, oneofIntAt(r20, r18));
        goto L166
    L33:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeSFixed64Size(r13, 0);
        goto L166
    L36:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeSFixed32Size(r13, r10);
        goto L166
    L39:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeEnumSize(r13, oneofIntAt(r20, r18));
        goto L166
    L42:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeUInt32Size(r13, oneofIntAt(r20, r18));
        goto L166
    L45:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeBytesSize(r13, (ByteString) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), ByteString.class, "com.obric.memorydata.plugin"));
        goto L166
    L48:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = SchemaUtil.computeSizeMessage(r13, r8.getObject(r20, r18), getMessageFieldSchema(r11));
        goto L166
    L51:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        Object r28 = r8.getObject(r20, r18);
        if (ZeusTransformUtils.instanceOf(r28, ByteString.class) == false) goto L55;
        r22 = CodedOutputStream.computeBytesSize(r13, (ByteString) ZeusTransformUtils.preCheckCast(r28, ByteString.class, "com.obric.memorydata.plugin"));
        goto L166
    L55:
        r22 = CodedOutputStream.computeStringSize(r13, (String) ZeusTransformUtils.preCheckCast(r28, String.class, "com.obric.memorydata.plugin"));
        goto L166
    L57:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeBoolSize(r13, true);
        goto L166
    L60:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeFixed32Size(r13, r10);
        goto L166
    L63:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeFixed64Size(r13, 0);
        goto L166
    L66:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeInt32Size(r13, oneofIntAt(r20, r18));
        goto L166
    L69:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeUInt64Size(r13, oneofLongAt(r20, r18));
        goto L166
    L72:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeInt64Size(r13, oneofLongAt(r20, r18));
        goto L166
    L75:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeFloatSize(r13, 0.0f);
        goto L166
    L78:
        if (isOneofPresent(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.computeDoubleSize(r13, 0.0d);
    L19:
        r19 = r10;
        goto L20
    L13:
        r15 = r0 == true ? 1 : 0;
        r16 = r1 == true ? 1 : 0;
        r17 = r10;
        goto L14
    L231:
        int r113 = r12 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, r20);
        if (this.hasExtensions == true) goto L234;
        return r113;
    L234:
        return r113 + this.extensionSchema.getExtensions(r20).getSerializedSize();
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T r10) {
        int r0 = this.buffer.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L82;
        int r3 = typeAndOffsetAt(r1);
        int r4 = numberAt(r1);
        long r5 = offset(r3);
        int r7 = 37;
        switch(type(r3)) {
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
        Object r6 = UnsafeUtil.getObject(r10, r5);
        if (r6 != null) goto L68;
    L69:
        r2 = (r2 * 53) + r7;
    L68:
        r7 = r6.hashCode();
    L64:
        int r8 = r2 * 53;
        Object r9 = UnsafeUtil.getObject(r10, r5);
    L65:
        int r11 = r9.hashCode();
    L80:
        r2 = r8 + r11;
        goto L81
    L66:
        r6 = UnsafeUtil.getObject(r10, r5);
        if (r6 == null) goto L69;
    L70:
        r8 = r2 * 53;
        r11 = ((String) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r10, r5), String.class, "com.obric.memorydata.plugin")).hashCode();
        goto L80
    L71:
        r8 = r2 * 53;
        boolean r12 = UnsafeUtil.getBoolean(r10, r5);
    L72:
        r11 = Internal.hashBoolean(r12);
        goto L80
    L73:
        r8 = r2 * 53;
        r11 = UnsafeUtil.getInt(r10, r5);
        goto L80
    L74:
        r8 = r2 * 53;
        long r13 = UnsafeUtil.getLong(r10, r5);
    L79:
        r11 = Internal.hashLong(r13);
        goto L80
    L75:
        r8 = r2 * 53;
        float r14 = UnsafeUtil.getFloat(r10, r5);
    L76:
        r11 = Float.floatToIntBits(r14);
        goto L80
    L77:
        r8 = r2 * 53;
        double r15 = UnsafeUtil.getDouble(r10, r5);
    L78:
        r13 = Double.doubleToLongBits(r15);
        goto L79
    L8:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L33:
        r9 = UnsafeUtil.getObject(r10, r5);
        r8 = r2 * 53;
        goto L65
    L11:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L54:
        r8 = r2 * 53;
        r13 = oneofLongAt(r10, r5);
        goto L79
    L14:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L48:
        r8 = r2 * 53;
        r11 = oneofIntAt(r10, r5);
        goto L80
    L17:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L20:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L23:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L26:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L29:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L32:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L35:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L38:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
        r8 = r2 * 53;
        r12 = oneofBooleanAt(r10, r5);
        goto L72
    L41:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L44:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L47:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L50:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L53:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
    L56:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
        r8 = r2 * 53;
        r14 = oneofFloatAt(r10, r5);
        goto L76
    L59:
        if (isOneofPresent(r10, r4, r1) == false) goto L81;
        r8 = r2 * 53;
        r15 = oneofDoubleAt(r10, r5);
    L81:
        r1 = r1 + 3;
        goto L3
    L82:
        int r16 = (r2 * 53) + this.unknownFieldSchema.getFromMessage(r10).hashCode();
        if (this.hasExtensions == true) goto L85;
        return r16;
    L85:
        return (r16 * 53) + this.extensionSchema.getExtensions(r10).hashCode();
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T r18) {
        int r0 = 1048575;
        int r1 = 0;
        int r10 = 0;
    L4:
        if (r10 >= this.checkInitializedCount) goto L49;
        int r11 = this.intArray[r10];
        int r12 = numberAt(r11);
        int r13 = typeAndOffsetAt(r11);
        int r2 = this.buffer[r11 + 2];
        int r4 = r2 & 1048575;
        int r14 = 1 << (r2 >>> 20);
        if (r4 == r0) goto L10;
        if (r4 == 1048575) goto L9;
        r1 = UNSAFE.getInt(r18, r4);
    L9:
        int r16 = r1;
        int r15 = r4;
    L12:
        if (isRequired(r13) == true) goto L14;
    L16:
        int r3 = type(r13);
        if (r3 == 9) goto L43;
        if (r3 == 17) goto L43;
        if (r3 == 27) goto L40;
        if (r3 == 60) goto L35;
        if (r3 == 68) goto L35;
        if (r3 == 49) goto L40;
        if (r3 != 50) goto L47;
        if (isMapInitialized(r18, r13, r11) == true) goto L47;
        return false;
    L47:
        r10 = r10 + 1;
        r0 = r15;
        r1 = r16;
    L35:
        if (isOneofPresent(r18, r12, r11) == false) goto L47;
        if (isInitialized(r18, r13, getMessageFieldSchema(r11)) == true) goto L47;
        return false;
    L40:
        if (isListInitialized(r18, r13, r11) == true) goto L47;
        return false;
    L43:
        if (isFieldPresent(r18, r11, r15, r16, r14) == false) goto L47;
        if (isInitialized(r18, r13, getMessageFieldSchema(r11)) == true) goto L47;
        return false;
    L14:
        if (isFieldPresent(r18, r11, r15, r16, r14) == true) goto L16;
        return false;
    L10:
        r15 = r0;
        r16 = r1;
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
        if (ZeusTransformUtils.instanceOf(r8, GeneratedMessageLite.class) == false) goto L8;
        GeneratedMessageLite r0 = (GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r8, GeneratedMessageLite.class, "com.obric.memorydata.plugin");
        r0.clearMemoizedSerializedSize();
        r0.clearMemoizedHashCode();
        r0.markImmutable();
    L8:
        int r1 = this.buffer.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L29;
        int r3 = typeAndOffsetAt(r2);
        long r4 = offset(r3);
        int r5 = type(r3);
        if (r5 == 9) goto L26;
        if (r5 == 60) goto L23;
        if (r5 == 68) goto L23;
        switch(r5) {
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
        Unsafe r6 = UNSAFE;
        Object r7 = r6.getObject(r8, r4);
        if (r7 == null) goto L28;
        r6.putObject(r8, r4, this.mapFieldSchema.toImmutable(r7));
        goto L28
    L21:
        this.listFieldSchema.makeImmutableListAt(r8, r4);
    L28:
        r2 = r2 + 3;
    L23:
        if (isOneofPresent(r8, numberAt(r2), r2) == false) goto L28;
    L27:
        getMessageFieldSchema(r2).makeImmutable(UNSAFE.getObject(r8, r4));
    L26:
        if (isFieldPresent(r8, r2) == false) goto L28;
    L29:
        this.unknownFieldSchema.makeImmutable(r8);
        if (this.hasExtensions == false) goto L41;
        this.extensionSchema.makeImmutable(r8);
        return;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r7, Reader r8, ExtensionRegistryLite r9) {
        Reader r4 = (Reader) ZeusTransformUtils.wrapperContextForParams(r8, Reader.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r9);
        checkMutable(r7);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, r7, r4, r9);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r3, T r4) {
        checkMutable(r3);
        Objects.requireNonNull(r4);
        int r0 = 0;
    L4:
        if (r0 >= this.buffer.length) goto L6;
        mergeSingleField(r3, r4, r0);
        r0 = r0 + 3;
        goto L4
    L6:
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, r3, r4);
        if (this.hasExtensions == false) goto L11;
        SchemaUtil.mergeExtensions(this.extensionSchema, r3, r4);
        return;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T r8, byte[] r9, int r10, int r11, ArrayDecoders.Registers r12) {
        parseMessage(r8, r9, r10, r11, 0, r12);
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    int parseMessage(T r31, byte[] r32, int r33, int r34, int r35, ArrayDecoders.Registers r36) {
        MessageSchema<T> r15 = this;
        r31 = r31;
        r32 = r32;
        r34 = r34;
        r35 = r35;
        ArrayDecoders.Registers r9 = r36;
        checkMutable(r31);
        Unsafe r10 = UNSAFE;
        int r0 = r33;
        int r2 = 0;
        int r3 = 0;
        int r5 = 0;
        int r1 = -1;
        int r6 = 1048575;
    L4:
        if (r0 >= r34) goto L137;
        int r4 = r0 + 1;
        byte r7 = r32[r0];
        if (r7 >= 0) goto L8;
        int r8 = ArrayDecoders.decodeVarint32(r7, r32, r4, r9);
        int r11 = r9.int1;
    L9:
        int r12 = r11 >>> 3;
        int r13 = r11 & 7;
        int r37 = r8;
        if (r12 <= r1) goto L12;
        int r14 = r15.positionForFieldNumber(r12, r2 / 3);
    L13:
        int r16 = r14;
        if (r16 == (-1)) goto L15;
        int r17 = r15.buffer[r16 + 1];
        int r18 = type(r17);
        int r21 = r11;
        long r19 = offset(r17);
        if (r18 > 17) goto L95;
        int r110 = r15.buffer[r16 + 2];
        int r22 = 1 << (r110 >>> 20);
        int r111 = r110 & 1048575;
        if (r111 == r6) goto L26;
        if (r6 == 1048575) goto L22;
        r10.putInt(r31, r6, r5);
    L22:
        if (r111 != 1048575) goto L24;
        int r20 = 0;
    L25:
        int r112 = r111;
        int r113 = r20;
    L28:
        switch(r18) {
            case 0: goto L88;
            case 1: goto L84;
            case 2: goto L80;
            case 3: goto L80;
            case 4: goto L76;
            case 5: goto L73;
            case 6: goto L70;
            case 7: goto L63;
            case 8: goto L57;
            case 9: goto L53;
            case 10: goto L49;
            case 11: goto L76;
            case 12: goto L39;
            case 13: goto L70;
            case 14: goto L73;
            case 15: goto L36;
            case 16: goto L33;
            case 17: goto L31;
            default: goto L29;
        };
    L39:
        int r23 = r37;
        int r114 = r12;
        int r115 = r21;
        int r24 = r16;
        if (r13 != 0) goto L94;
        r0 = ArrayDecoders.decodeVarint32(r32, r23, r9);
        int r25 = r9.int1;
        Internal.EnumVerifier r26 = r15.getEnumFieldVerifier(r24);
        if (isLegacyEnumIsClosed(r17) == false) goto L48;
        if (r26 == null) goto L48;
        if (r26.isInRange(r25) == true) goto L48;
        getMutableUnknownFields(r31).storeField(r115, Long.valueOf(r25));
        r2 = r24;
        r5 = r113;
        r3 = r115;
        r6 = r112;
        r1 = r114;
        r34 = r34;
        r35 = r35;
    L48:
        r10.putInt(r31, r19, r25);
    L92:
        r5 = r113 | r22;
    L93:
        r2 = r24;
        r3 = r115;
        r6 = r112;
        r1 = r114;
    L107:
        r34 = r34;
    L94:
        int r27 = r35;
        int r28 = r23;
        int r29 = r24;
        Unsafe r210 = r10;
        int r30 = r115;
        String r211 = "com.obric.memorydata.plugin";
        int r212 = r112;
        int r116 = r113;
    L127:
        if (r30 != r27) goto L130;
        if (r27 == 0) goto L130;
        MessageSchema<T> r38 = this;
        int r117 = r27;
        int r39 = r28;
        r5 = r116;
    L138:
        int r40 = r212;
        if (r40 == 1048575) goto L141;
        T r41 = r31;
        r210.putInt(r41, r40, r5);
    L142:
        UnknownFieldSetLite r42 = null;
        int r118 = r38.checkInitializedCount;
    L144:
        if (r118 >= r38.repeatedFieldOffsetStart) goto L146;
        r42 = (UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(filterMapUnknownEnumValues(r31, r38.intArray[r118], r42, r38.unknownFieldSchema, r31), UnknownFieldSetLite.class, r211);
        r118 = r118 + 1;
        goto L144
    L146:
        if (r42 == null) goto L149;
        r38.unknownFieldSchema.setBuilderToMessage(r41, r42);
    L149:
        if (r117 != 0) goto L154;
        if (r39 != r34) goto L153;
    L156:
        return r39;
    L153:
        throw InvalidProtocolBufferException.parseFailure();
    L154:
        if (r39 > r34) goto L158;
        if (r30 == r117) goto L156;
    L158:
        throw InvalidProtocolBufferException.parseFailure();
    L141:
        r41 = r31;
    L130:
        int r119 = r27;
        if (this.hasExtensions == true) goto L133;
    L135:
        r0 = ArrayDecoders.decodeUnknownField(r30, r32, r28, r34, getMutableUnknownFields(r31), r36);
    L136:
        r3 = r30;
        r15 = this;
        r9 = r36;
        r5 = r116;
        r1 = r114;
        r6 = r212;
        r2 = r29;
        r35 = r119;
    L114:
        r10 = r210;
        goto L4
    L133:
        if (r36.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) goto L135;
        r0 = ArrayDecoders.decodeExtensionOrUnknownField(r30, r32, r28, r34, r31, this.defaultInstance, this.unknownFieldSchema, r36);
    L29:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        goto L94
    L31:
        if (r13 != 3) goto L29;
        Object r43 = r15.mutableMessageFieldForMerge(r31, r16);
        int r44 = (r12 << 3) | 4;
        r115 = r21;
        r114 = r12;
        r24 = r16;
        r0 = ArrayDecoders.mergeGroupField(r43, r15.getMessageFieldSchema(r16), r32, r37, r34, r44, r36);
    L56:
        r15.storeMessageField(r31, r24, r43);
        goto L92
    L33:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 0) goto L94;
        int r45 = ArrayDecoders.decodeVarint64(r32, r23, r9);
        long r46 = CodedInputStream.decodeZigZag64(r9.long1);
        long r47 = r19;
    L83:
        r10.putLong(r31, r47, r46);
        r5 = r113 | r22;
        r0 = r45;
        goto L93
    L36:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 0) goto L94;
        r0 = ArrayDecoders.decodeVarint32(r32, r23, r9);
        int r48 = CodedInputStream.decodeZigZag32(r9.int1);
    L79:
        r10.putInt(r31, r19, r48);
        goto L92
    L49:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        long r49 = r19;
        r24 = r16;
        if (r13 != 2) goto L94;
        r0 = ArrayDecoders.decodeBytes(r32, r23, r9);
    L52:
        r10.putObject(r31, r49, r9.object1);
        goto L92
    L53:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 2) goto L94;
        r43 = r15.mutableMessageFieldForMerge(r31, r24);
        r0 = ArrayDecoders.mergeMessageField(r43, r15.getMessageFieldSchema(r24), r32, r23, r34, r36);
        goto L56
    L57:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r49 = r19;
        r24 = r16;
        if (r13 != 2) goto L94;
        if (isEnforceUtf8(r17) == false) goto L62;
        r0 = ArrayDecoders.decodeStringRequireUtf8(r32, r23, r9);
        goto L52
    L62:
        r0 = ArrayDecoders.decodeString(r32, r23, r9);
        goto L52
    L63:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 0) goto L94;
        r0 = ArrayDecoders.decodeVarint64(r32, r23, r9);
        if (r9.long1 == 0) goto L68;
        boolean r50 = true;
    L69:
        UnsafeUtil.putBoolean(r31, r19, r50);
        goto L92
    L68:
        r50 = false;
        goto L69
    L70:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 5) goto L94;
        r10.putInt(r31, r19, ArrayDecoders.decodeFixed32(r32, r23));
    L87:
        r0 = r23 + 4;
        goto L92
    L73:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 1) goto L94;
        r10.putLong(r31, r19, ArrayDecoders.decodeFixed64(r32, r23));
    L91:
        r0 = r23 + 8;
        goto L92
    L76:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 0) goto L94;
        r0 = ArrayDecoders.decodeVarint32(r32, r23, r9);
        r48 = r9.int1;
        goto L79
    L80:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 0) goto L94;
        r45 = ArrayDecoders.decodeVarint64(r32, r23, r9);
        r47 = r19;
        r46 = r9.long1;
        goto L83
    L84:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 5) goto L94;
        UnsafeUtil.putFloat(r31, r19, ArrayDecoders.decodeFloat(r32, r23));
        goto L87
    L88:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 1) goto L94;
        UnsafeUtil.putDouble(r31, r19, ArrayDecoders.decodeDouble(r32, r23));
        goto L91
    L24:
        r20 = r10.getInt(r31, r111);
        goto L25
    L26:
        r113 = r5;
        r112 = r6;
        goto L28
    L95:
        r114 = r12;
        if (r18 != 27) goto L109;
        if (r13 != 2) goto L108;
        Internal.ProtobufList r51 = (Internal.ProtobufList) ZeusTransformUtils.preCheckCast(r10.getObject(r31, r19), Internal.ProtobufList.class, "com.obric.memorydata.plugin");
        if (r51.isModifiable() == true) goto L106;
        int r52 = r51.size();
        if (r52 != 0) goto L104;
        int r53 = 10;
    L105:
        r51 = r51.mutableCopyWithCapacity(r53);
        r10.putObject(r31, r19, r51);
        goto L106
    L104:
        r53 = r52 * 2;
    L106:
        r0 = ArrayDecoders.decodeMessageList(r15.getMessageFieldSchema(r16), r21, r32, r37, r34, r51, r36);
        r35 = r35;
        r2 = r16;
        r3 = r21;
        r5 = r5;
        r1 = r114;
        r6 = r6;
        goto L107
    L108:
        r116 = r5;
        r212 = r6;
        r211 = "com.obric.memorydata.plugin";
        r29 = r16;
        r210 = r10;
        int r120 = r37;
        int r310 = r21;
    L122:
        r30 = r310;
        r27 = r35;
        r28 = r120;
        goto L127
    L109:
        r116 = r5;
        r212 = r6;
        if (r18 > 49) goto L115;
        r211 = "com.obric.memorydata.plugin";
        r29 = r16;
        r210 = r10;
        r310 = r21;
        r0 = parseRepeatedField(r31, r32, r37, r34, r21, r114, r13, r29, r17, r18, r19, r36);
        if (r0 == r37) goto L126;
    L113:
        r15 = this;
        r3 = r310;
        r35 = r35;
        r9 = r36;
        r5 = r116;
        r1 = r114;
        r6 = r212;
        r2 = r29;
    L126:
        r30 = r310;
        r28 = r0;
        r27 = r35;
        goto L127
    L115:
        r211 = "com.obric.memorydata.plugin";
        r29 = r16;
        r210 = r10;
        r120 = r37;
        r310 = r21;
        if (r18 == 50) goto L118;
        r0 = parseOneofField(r31, r32, r120, r34, r310, r114, r13, r17, r18, r19, r29, r36);
        if (r0 == r120) goto L126;
    L118:
        if (r13 != 2) goto L122;
        r0 = parseMapField(r31, r32, r120, r34, r29, r19, r36);
        if (r0 == r120) goto L126;
    L15:
        r28 = r37;
        r30 = r11;
        r211 = "com.obric.memorydata.plugin";
        r116 = r5;
        r212 = r6;
        r114 = r12;
        r210 = r10;
        r27 = r35;
        r29 = 0;
        goto L127
    L12:
        r14 = r15.positionForFieldNumber(r12);
        goto L13
    L8:
        r11 = r7;
        r8 = r4;
        goto L9
    L137:
        r211 = "com.obric.memorydata.plugin";
        r212 = r6;
        r210 = r10;
        r117 = r35;
        r38 = r15;
        r39 = r0;
        r30 = r3;
        goto L138
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r5.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L5;
        writeFieldsInDescendingOrder(r3, r5);
        return;
    L5:
        writeFieldsInAscendingOrder(r3, r5);
    }
}
