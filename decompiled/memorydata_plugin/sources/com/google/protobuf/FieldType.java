package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final enum FieldType extends java.lang.Enum<FieldType> {
    private static final /* synthetic */ FieldType[] $VALUES = null;
    public static final FieldType BOOL = null;
    public static final FieldType BOOL_LIST = null;
    public static final FieldType BOOL_LIST_PACKED = null;
    public static final FieldType BYTES = null;
    public static final FieldType BYTES_LIST = null;
    public static final FieldType DOUBLE = null;
    public static final FieldType DOUBLE_LIST = null;
    public static final FieldType DOUBLE_LIST_PACKED = null;
    private static final java.lang.reflect.Type[] EMPTY_TYPES = null;
    public static final FieldType ENUM = null;
    public static final FieldType ENUM_LIST = null;
    public static final FieldType ENUM_LIST_PACKED = null;
    public static final FieldType FIXED32 = null;
    public static final FieldType FIXED32_LIST = null;
    public static final FieldType FIXED32_LIST_PACKED = null;
    public static final FieldType FIXED64 = null;
    public static final FieldType FIXED64_LIST = null;
    public static final FieldType FIXED64_LIST_PACKED = null;
    public static final FieldType FLOAT = null;
    public static final FieldType FLOAT_LIST = null;
    public static final FieldType FLOAT_LIST_PACKED = null;
    public static final FieldType GROUP = null;
    public static final FieldType GROUP_LIST = null;
    public static final FieldType INT32 = null;
    public static final FieldType INT32_LIST = null;
    public static final FieldType INT32_LIST_PACKED = null;
    public static final FieldType INT64 = null;
    public static final FieldType INT64_LIST = null;
    public static final FieldType INT64_LIST_PACKED = null;
    public static final FieldType MAP = null;
    public static final FieldType MESSAGE = null;
    public static final FieldType MESSAGE_LIST = null;
    public static final FieldType SFIXED32 = null;
    public static final FieldType SFIXED32_LIST = null;
    public static final FieldType SFIXED32_LIST_PACKED = null;
    public static final FieldType SFIXED64 = null;
    public static final FieldType SFIXED64_LIST = null;
    public static final FieldType SFIXED64_LIST_PACKED = null;
    public static final FieldType SINT32 = null;
    public static final FieldType SINT32_LIST = null;
    public static final FieldType SINT32_LIST_PACKED = null;
    public static final FieldType SINT64 = null;
    public static final FieldType SINT64_LIST = null;
    public static final FieldType SINT64_LIST_PACKED = null;
    public static final FieldType STRING = null;
    public static final FieldType STRING_LIST = null;
    public static final FieldType UINT32 = null;
    public static final FieldType UINT32_LIST = null;
    public static final FieldType UINT32_LIST_PACKED = null;
    public static final FieldType UINT64 = null;
    public static final FieldType UINT64_LIST = null;
    public static final FieldType UINT64_LIST_PACKED = null;
    private static final FieldType[] VALUES = null;
    private final Collection collection;
    private final Class<?> elementType;
    private final int id;
    private final JavaType javaType;
    private final boolean primitiveScalar;

    /* JADX INFO: renamed from: com.google.protobuf.FieldType$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType = null;

        static {
            int[] r0 = new int[JavaType.values().length];
            $SwitchMap$com$google$protobuf$JavaType = r0;
            r0[JavaType.BYTE_STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static final enum Collection extends java.lang.Enum<Collection> {
        private static final /* synthetic */ Collection[] $VALUES = null;
        public static final Collection MAP = null;
        public static final Collection PACKED_VECTOR = null;
        public static final Collection SCALAR = null;
        public static final Collection VECTOR = null;
        private final boolean isList;

        private static /* synthetic */ Collection[] $values() {
            return new Collection[]{SCALAR, VECTOR, PACKED_VECTOR, MAP};
        }

        static {
            SCALAR = new Collection("SCALAR", 0, false);
            VECTOR = new Collection("VECTOR", 1, true);
            PACKED_VECTOR = new Collection("PACKED_VECTOR", 2, true);
            MAP = new Collection("MAP", 3, false);
            $VALUES = $values();
        }

        private Collection(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.isList = r3;
        }

        public static Collection valueOf(String r2) {
            return (Collection) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(Collection.class, r2), Collection.class, "com.obric.memorydata.plugin");
        }

        public static Collection[] values() {
            return (Collection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Collection[].class, "com.obric.memorydata.plugin");
        }

        public boolean isList() {
            return this.isList;
        }
    }

    private static /* synthetic */ FieldType[] $values() {
        return new FieldType[]{DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64, GROUP, DOUBLE_LIST, FLOAT_LIST, INT64_LIST, UINT64_LIST, INT32_LIST, FIXED64_LIST, FIXED32_LIST, BOOL_LIST, STRING_LIST, MESSAGE_LIST, BYTES_LIST, UINT32_LIST, ENUM_LIST, SFIXED32_LIST, SFIXED64_LIST, SINT32_LIST, SINT64_LIST, DOUBLE_LIST_PACKED, FLOAT_LIST_PACKED, INT64_LIST_PACKED, UINT64_LIST_PACKED, INT32_LIST_PACKED, FIXED64_LIST_PACKED, FIXED32_LIST_PACKED, BOOL_LIST_PACKED, UINT32_LIST_PACKED, ENUM_LIST_PACKED, SFIXED32_LIST_PACKED, SFIXED64_LIST_PACKED, SINT32_LIST_PACKED, SINT64_LIST_PACKED, GROUP_LIST, MAP};
    }

    static {
        DOUBLE = new FieldType("DOUBLE", 0, 0, Collection.SCALAR, JavaType.DOUBLE);
        FLOAT = new FieldType("FLOAT", 1, 1, Collection.SCALAR, JavaType.FLOAT);
        INT64 = new FieldType("INT64", 2, 2, Collection.SCALAR, JavaType.LONG);
        UINT64 = new FieldType("UINT64", 3, 3, Collection.SCALAR, JavaType.LONG);
        INT32 = new FieldType("INT32", 4, 4, Collection.SCALAR, JavaType.INT);
        FIXED64 = new FieldType("FIXED64", 5, 5, Collection.SCALAR, JavaType.LONG);
        FIXED32 = new FieldType("FIXED32", 6, 6, Collection.SCALAR, JavaType.INT);
        BOOL = new FieldType("BOOL", 7, 7, Collection.SCALAR, JavaType.BOOLEAN);
        STRING = new FieldType("STRING", 8, 8, Collection.SCALAR, JavaType.STRING);
        MESSAGE = new FieldType("MESSAGE", 9, 9, Collection.SCALAR, JavaType.MESSAGE);
        BYTES = new FieldType("BYTES", 10, 10, Collection.SCALAR, JavaType.BYTE_STRING);
        UINT32 = new FieldType("UINT32", 11, 11, Collection.SCALAR, JavaType.INT);
        ENUM = new FieldType("ENUM", 12, 12, Collection.SCALAR, JavaType.ENUM);
        SFIXED32 = new FieldType("SFIXED32", 13, 13, Collection.SCALAR, JavaType.INT);
        SFIXED64 = new FieldType("SFIXED64", 14, 14, Collection.SCALAR, JavaType.LONG);
        SINT32 = new FieldType("SINT32", 15, 15, Collection.SCALAR, JavaType.INT);
        SINT64 = new FieldType("SINT64", 16, 16, Collection.SCALAR, JavaType.LONG);
        GROUP = new FieldType("GROUP", 17, 17, Collection.SCALAR, JavaType.MESSAGE);
        DOUBLE_LIST = new FieldType("DOUBLE_LIST", 18, 18, Collection.VECTOR, JavaType.DOUBLE);
        FLOAT_LIST = new FieldType("FLOAT_LIST", 19, 19, Collection.VECTOR, JavaType.FLOAT);
        INT64_LIST = new FieldType("INT64_LIST", 20, 20, Collection.VECTOR, JavaType.LONG);
        UINT64_LIST = new FieldType("UINT64_LIST", 21, 21, Collection.VECTOR, JavaType.LONG);
        INT32_LIST = new FieldType("INT32_LIST", 22, 22, Collection.VECTOR, JavaType.INT);
        FIXED64_LIST = new FieldType("FIXED64_LIST", 23, 23, Collection.VECTOR, JavaType.LONG);
        FIXED32_LIST = new FieldType("FIXED32_LIST", 24, 24, Collection.VECTOR, JavaType.INT);
        BOOL_LIST = new FieldType("BOOL_LIST", 25, 25, Collection.VECTOR, JavaType.BOOLEAN);
        STRING_LIST = new FieldType("STRING_LIST", 26, 26, Collection.VECTOR, JavaType.STRING);
        MESSAGE_LIST = new FieldType("MESSAGE_LIST", 27, 27, Collection.VECTOR, JavaType.MESSAGE);
        BYTES_LIST = new FieldType("BYTES_LIST", 28, 28, Collection.VECTOR, JavaType.BYTE_STRING);
        UINT32_LIST = new FieldType("UINT32_LIST", 29, 29, Collection.VECTOR, JavaType.INT);
        ENUM_LIST = new FieldType("ENUM_LIST", 30, 30, Collection.VECTOR, JavaType.ENUM);
        SFIXED32_LIST = new FieldType("SFIXED32_LIST", 31, 31, Collection.VECTOR, JavaType.INT);
        SFIXED64_LIST = new FieldType("SFIXED64_LIST", 32, 32, Collection.VECTOR, JavaType.LONG);
        SINT32_LIST = new FieldType("SINT32_LIST", 33, 33, Collection.VECTOR, JavaType.INT);
        SINT64_LIST = new FieldType("SINT64_LIST", 34, 34, Collection.VECTOR, JavaType.LONG);
        DOUBLE_LIST_PACKED = new FieldType("DOUBLE_LIST_PACKED", 35, 35, Collection.PACKED_VECTOR, JavaType.DOUBLE);
        FLOAT_LIST_PACKED = new FieldType("FLOAT_LIST_PACKED", 36, 36, Collection.PACKED_VECTOR, JavaType.FLOAT);
        INT64_LIST_PACKED = new FieldType("INT64_LIST_PACKED", 37, 37, Collection.PACKED_VECTOR, JavaType.LONG);
        UINT64_LIST_PACKED = new FieldType("UINT64_LIST_PACKED", 38, 38, Collection.PACKED_VECTOR, JavaType.LONG);
        INT32_LIST_PACKED = new FieldType("INT32_LIST_PACKED", 39, 39, Collection.PACKED_VECTOR, JavaType.INT);
        FIXED64_LIST_PACKED = new FieldType("FIXED64_LIST_PACKED", 40, 40, Collection.PACKED_VECTOR, JavaType.LONG);
        FIXED32_LIST_PACKED = new FieldType("FIXED32_LIST_PACKED", 41, 41, Collection.PACKED_VECTOR, JavaType.INT);
        BOOL_LIST_PACKED = new FieldType("BOOL_LIST_PACKED", 42, 42, Collection.PACKED_VECTOR, JavaType.BOOLEAN);
        UINT32_LIST_PACKED = new FieldType("UINT32_LIST_PACKED", 43, 43, Collection.PACKED_VECTOR, JavaType.INT);
        ENUM_LIST_PACKED = new FieldType("ENUM_LIST_PACKED", 44, 44, Collection.PACKED_VECTOR, JavaType.ENUM);
        SFIXED32_LIST_PACKED = new FieldType("SFIXED32_LIST_PACKED", 45, 45, Collection.PACKED_VECTOR, JavaType.INT);
        SFIXED64_LIST_PACKED = new FieldType("SFIXED64_LIST_PACKED", 46, 46, Collection.PACKED_VECTOR, JavaType.LONG);
        SINT32_LIST_PACKED = new FieldType("SINT32_LIST_PACKED", 47, 47, Collection.PACKED_VECTOR, JavaType.INT);
        SINT64_LIST_PACKED = new FieldType("SINT64_LIST_PACKED", 48, 48, Collection.PACKED_VECTOR, JavaType.LONG);
        GROUP_LIST = new FieldType("GROUP_LIST", 49, 49, Collection.VECTOR, JavaType.MESSAGE);
        MAP = new FieldType("MAP", 50, 50, Collection.MAP, JavaType.VOID);
        $VALUES = $values();
        int r0 = 0;
        EMPTY_TYPES = new java.lang.reflect.Type[0];
        FieldType[] r1 = values();
        VALUES = new FieldType[r1.length];
        int r2 = r1.length;
    L3:
        if (r0 >= r2) goto L5;
        FieldType r3 = r1[r0];
        VALUES[r3.id] = r3;
        r0 = r0 + 1;
        goto L3
    }

    private FieldType(String r2, int r3, int r4, Collection r5, JavaType r6) {
        super(r2, r3);
        this.id = r4;
        this.collection = r5;
        this.javaType = r6;
        int r7 = r5.ordinal();
        boolean r8 = true;
        if (r7 == 1) goto L7;
        if (r7 == 3) goto L7;
        Class<?> r9 = null;
    L6:
        this.elementType = r9;
        if (r5 != Collection.SCALAR) goto L16;
        int r10 = AnonymousClass1.$SwitchMap$com$google$protobuf$JavaType[r6.ordinal()];
        if (r10 == 1) goto L16;
        if (r10 == 2) goto L16;
        if (r10 == 3) goto L16;
    L17:
        this.primitiveScalar = r8;
        return;
    L16:
        r8 = false;
    L7:
        r9 = r6.getBoxedType();
        goto L6
    }

    public static FieldType forId(int r2) {
        if (r2 < 0) goto L8;
        FieldType[] r0 = VALUES;
        if (r2 < r0.length) goto L7;
        return null;
    L7:
        return r0[r2];
    L8:
        return null;
    }

    private static java.lang.reflect.Type getGenericSuperList(Class<?> r7) {
        java.lang.reflect.Type[] r0 = r7.getGenericInterfaces();
        int r1 = r0.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L11;
        java.lang.reflect.Type r4 = r0[r2];
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == false) goto L10;
        if (List.class.isAssignableFrom((Class) ZeusTransformUtils.preCheckCast(((ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.memorydata.plugin")).getRawType(), Class.class, "com.obric.memorydata.plugin")) == false) goto L10;
        return r4;
    L10:
        r2 = r2 + 1;
        goto L4
    L11:
        java.lang.reflect.Type r8 = r7.getGenericSuperclass();
        if (ZeusTransformUtils.instanceOf(r8, ParameterizedType.class) == true) goto L14;
        return null;
    L14:
        if (List.class.isAssignableFrom((Class) ZeusTransformUtils.preCheckCast(((ParameterizedType) ZeusTransformUtils.preCheckCast(r8, ParameterizedType.class, "com.obric.memorydata.plugin")).getRawType(), Class.class, "com.obric.memorydata.plugin")) == false) goto L22;
        return r8;
    L22:
        return null;
    }

    private static java.lang.reflect.Type getListParameter(Class<?> r10, java.lang.reflect.Type[] r11) {
    L2:
        int r1 = 0;
        if (r10 == List.class) goto L37;
        java.lang.reflect.Type r0 = getGenericSuperList(r10);
        if (ZeusTransformUtils.instanceOf(r0, ParameterizedType.class) == true) goto L6;
        r11 = EMPTY_TYPES;
        Class<?>[] r2 = r10.getInterfaces();
        int r3 = r2.length;
    L30:
        if (r1 >= r3) goto L35;
        Class<?> r4 = r2[r1];
        if (List.class.isAssignableFrom(r4) == true) goto L33;
        r1 = r1 + 1;
        goto L30
    L33:
        r10 = r4;
        goto L2
    L35:
        r10 = r10.getSuperclass();
        goto L2
    L6:
        ParameterizedType r5 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r0, ParameterizedType.class, "com.obric.memorydata.plugin");
        java.lang.reflect.Type[] r6 = r5.getActualTypeArguments();
        int r7 = 0;
    L8:
        if (r7 >= r6.length) goto L28;
        java.lang.reflect.Type r8 = r6[r7];
        if (ZeusTransformUtils.instanceOf(r8, TypeVariable.class) == false) goto L27;
        TypeVariable<Class<?>>[] r9 = r10.getTypeParameters();
        if (r11.length != r9.length) goto L26;
        int r12 = 0;
    L15:
        if (r12 >= r9.length) goto L20;
        if (r8 == r9[r12]) goto L18;
        r12 = r12 + 1;
        goto L15
    L18:
        r6[r7] = r11[r12];
        boolean r13 = true;
    L21:
        if (r13 == true) goto L27;
        throw new RuntimeException("Unable to find replacement for " + r8);
    L20:
        r13 = false;
        goto L21
    L26:
        throw new RuntimeException("Type array mismatch");
    L27:
        r7 = r7 + 1;
        goto L8
    L28:
        r10 = (Class) ZeusTransformUtils.preCheckCast(r5.getRawType(), Class.class, "com.obric.memorydata.plugin");
        r11 = r6;
        goto L2
    L37:
        if (r11.length != 1) goto L41;
        return r11[0];
    L41:
        throw new RuntimeException("Unable to identify parameter type for List<T>");
    }

    private boolean isValidForList(java.lang.reflect.Field r5) {
        Class<?> r0 = r5.getType();
        if (this.javaType.getType().isAssignableFrom(r0) == true) goto L6;
        return false;
    L6:
        java.lang.reflect.Type[] r1 = EMPTY_TYPES;
        if (ZeusTransformUtils.instanceOf(r5.getGenericType(), ParameterizedType.class) == false) goto L9;
        r1 = ((ParameterizedType) ZeusTransformUtils.preCheckCast(r5.getGenericType(), ParameterizedType.class, "com.obric.memorydata.plugin")).getActualTypeArguments();
    L9:
        java.lang.reflect.Type r6 = getListParameter(r0, r1);
        if (ZeusTransformUtils.instanceOf(r6, Class.class) == true) goto L14;
        return true;
    L14:
        return this.elementType.isAssignableFrom((Class) ZeusTransformUtils.preCheckCast(r6, Class.class, "com.obric.memorydata.plugin"));
    }

    public static FieldType valueOf(String r2) {
        return (FieldType) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(FieldType.class, r2), FieldType.class, "com.obric.memorydata.plugin");
    }

    public static FieldType[] values() {
        return (FieldType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FieldType[].class, "com.obric.memorydata.plugin");
    }

    public JavaType getJavaType() {
        return this.javaType;
    }

    public int id() {
        return this.id;
    }

    public boolean isList() {
        return this.collection.isList();
    }

    public boolean isMap() {
        if (this.collection != Collection.MAP) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPacked() {
        return Collection.PACKED_VECTOR.equals(this.collection);
    }

    public boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }

    public boolean isScalar() {
        if (this.collection != Collection.SCALAR) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValidForField(java.lang.reflect.Field r3) {
        if (Collection.VECTOR.equals(this.collection) == false) goto L7;
        return isValidForList(r3);
    L7:
        return this.javaType.getType().isAssignableFrom(r3.getType());
    }
}
