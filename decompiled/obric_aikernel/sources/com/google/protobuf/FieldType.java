package com.google.protobuf;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
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
            int[] r10 = new int[JavaType.values().length];
            $SwitchMap$com$google$protobuf$JavaType = r10;
            r10[JavaType.BYTE_STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
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

        private Collection(String r10, int r11, boolean r12) {
            super(r10, r11);
            this.isList = r12;
        }

        public static Collection valueOf(String r10) {
            return (Collection) java.lang.Enum.valueOf(Collection.class, r10);
        }

        public static Collection[] values() {
            return (Collection[]) $VALUES.clone();
        }

        public boolean isList() {
            return this.isList;
        }
    }

    private static /* synthetic */ FieldType[] $values() {
        return new FieldType[]{DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64, GROUP, DOUBLE_LIST, FLOAT_LIST, INT64_LIST, UINT64_LIST, INT32_LIST, FIXED64_LIST, FIXED32_LIST, BOOL_LIST, STRING_LIST, MESSAGE_LIST, BYTES_LIST, UINT32_LIST, ENUM_LIST, SFIXED32_LIST, SFIXED64_LIST, SINT32_LIST, SINT64_LIST, DOUBLE_LIST_PACKED, FLOAT_LIST_PACKED, INT64_LIST_PACKED, UINT64_LIST_PACKED, INT32_LIST_PACKED, FIXED64_LIST_PACKED, FIXED32_LIST_PACKED, BOOL_LIST_PACKED, UINT32_LIST_PACKED, ENUM_LIST_PACKED, SFIXED32_LIST_PACKED, SFIXED64_LIST_PACKED, SINT32_LIST_PACKED, SINT64_LIST_PACKED, GROUP_LIST, MAP};
    }

    static {
        Collection r10 = Collection.SCALAR;
        JavaType r11 = JavaType.DOUBLE;
        DOUBLE = new FieldType("DOUBLE", 0, 0, r10, r11);
        JavaType r12 = JavaType.FLOAT;
        FLOAT = new FieldType("FLOAT", 1, 1, r10, r12);
        JavaType r13 = JavaType.LONG;
        INT64 = new FieldType("INT64", 2, 2, r10, r13);
        UINT64 = new FieldType("UINT64", 3, 3, r10, r13);
        JavaType r14 = JavaType.INT;
        INT32 = new FieldType("INT32", 4, 4, r10, r14);
        FIXED64 = new FieldType("FIXED64", 5, 5, r10, r13);
        FIXED32 = new FieldType("FIXED32", 6, 6, r10, r14);
        JavaType r15 = JavaType.BOOLEAN;
        BOOL = new FieldType("BOOL", 7, 7, r10, r15);
        JavaType r16 = JavaType.STRING;
        STRING = new FieldType("STRING", 8, 8, r10, r16);
        JavaType r17 = JavaType.MESSAGE;
        MESSAGE = new FieldType("MESSAGE", 9, 9, r10, r17);
        JavaType r18 = JavaType.BYTE_STRING;
        BYTES = new FieldType("BYTES", 10, 10, r10, r18);
        UINT32 = new FieldType("UINT32", 11, 11, r10, r14);
        JavaType r19 = JavaType.ENUM;
        ENUM = new FieldType("ENUM", 12, 12, r10, r19);
        SFIXED32 = new FieldType("SFIXED32", 13, 13, r10, r14);
        SFIXED64 = new FieldType("SFIXED64", 14, 14, r10, r13);
        SINT32 = new FieldType("SINT32", 15, 15, r10, r14);
        SINT64 = new FieldType("SINT64", 16, 16, r10, r13);
        GROUP = new FieldType("GROUP", 17, 17, r10, r17);
        Collection r20 = Collection.VECTOR;
        DOUBLE_LIST = new FieldType("DOUBLE_LIST", 18, 18, r20, r11);
        FLOAT_LIST = new FieldType("FLOAT_LIST", 19, 19, r20, r12);
        INT64_LIST = new FieldType("INT64_LIST", 20, 20, r20, r13);
        UINT64_LIST = new FieldType("UINT64_LIST", 21, 21, r20, r13);
        INT32_LIST = new FieldType("INT32_LIST", 22, 22, r20, r14);
        FIXED64_LIST = new FieldType("FIXED64_LIST", 23, 23, r20, r13);
        FIXED32_LIST = new FieldType("FIXED32_LIST", 24, 24, r20, r14);
        BOOL_LIST = new FieldType("BOOL_LIST", 25, 25, r20, r15);
        STRING_LIST = new FieldType("STRING_LIST", 26, 26, r20, r16);
        MESSAGE_LIST = new FieldType("MESSAGE_LIST", 27, 27, r20, r17);
        BYTES_LIST = new FieldType("BYTES_LIST", 28, 28, r20, r18);
        UINT32_LIST = new FieldType("UINT32_LIST", 29, 29, r20, r14);
        ENUM_LIST = new FieldType("ENUM_LIST", 30, 30, r20, r19);
        SFIXED32_LIST = new FieldType("SFIXED32_LIST", 31, 31, r20, r14);
        SFIXED64_LIST = new FieldType("SFIXED64_LIST", 32, 32, r20, r13);
        SINT32_LIST = new FieldType("SINT32_LIST", 33, 33, r20, r14);
        SINT64_LIST = new FieldType("SINT64_LIST", 34, 34, r20, r13);
        Collection r110 = Collection.PACKED_VECTOR;
        DOUBLE_LIST_PACKED = new FieldType("DOUBLE_LIST_PACKED", 35, 35, r110, r11);
        FLOAT_LIST_PACKED = new FieldType("FLOAT_LIST_PACKED", 36, 36, r110, r12);
        INT64_LIST_PACKED = new FieldType("INT64_LIST_PACKED", 37, 37, r110, r13);
        UINT64_LIST_PACKED = new FieldType("UINT64_LIST_PACKED", 38, 38, r110, r13);
        INT32_LIST_PACKED = new FieldType("INT32_LIST_PACKED", 39, 39, r110, r14);
        FIXED64_LIST_PACKED = new FieldType("FIXED64_LIST_PACKED", 40, 40, r110, r13);
        FIXED32_LIST_PACKED = new FieldType("FIXED32_LIST_PACKED", 41, 41, r110, r14);
        BOOL_LIST_PACKED = new FieldType("BOOL_LIST_PACKED", 42, 42, r110, r15);
        UINT32_LIST_PACKED = new FieldType("UINT32_LIST_PACKED", 43, 43, r110, r14);
        ENUM_LIST_PACKED = new FieldType("ENUM_LIST_PACKED", 44, 44, r110, r19);
        SFIXED32_LIST_PACKED = new FieldType("SFIXED32_LIST_PACKED", 45, 45, r110, r14);
        SFIXED64_LIST_PACKED = new FieldType("SFIXED64_LIST_PACKED", 46, 46, r110, r13);
        SINT32_LIST_PACKED = new FieldType("SINT32_LIST_PACKED", 47, 47, r110, r14);
        SINT64_LIST_PACKED = new FieldType("SINT64_LIST_PACKED", 48, 48, r110, r13);
        GROUP_LIST = new FieldType("GROUP_LIST", 49, 49, r20, r17);
        MAP = new FieldType("MAP", 50, 50, Collection.MAP, JavaType.VOID);
        $VALUES = $values();
        int r21 = 0;
        EMPTY_TYPES = new java.lang.reflect.Type[0];
        FieldType[] r22 = values();
        VALUES = new FieldType[r22.length];
        int r23 = r22.length;
    L3:
        if (r21 >= r23) goto L5;
        FieldType r24 = r22[r21];
        VALUES[r24.id] = r24;
        r21 = r21 + 1;
        goto L3
    }

    private FieldType(String r10, int r11, int r12, Collection r13, JavaType r14) {
        super(r10, r11);
        this.id = r12;
        this.collection = r13;
        this.javaType = r14;
        int r15 = r13.ordinal();
        boolean r16 = true;
        if (r15 == 1) goto L7;
        if (r15 == 3) goto L7;
        Class<?> r17 = null;
    L6:
        this.elementType = r17;
        if (r13 != Collection.SCALAR) goto L16;
        int r18 = AnonymousClass1.$SwitchMap$com$google$protobuf$JavaType[r14.ordinal()];
        if (r18 == 1) goto L16;
        if (r18 == 2) goto L16;
        if (r18 == 3) goto L16;
    L17:
        this.primitiveScalar = r16;
        return;
    L16:
        r16 = false;
    L7:
        r17 = r14.getBoxedType();
        goto L6
    }

    public static FieldType forId(int r10) {
        if (r10 < 0) goto L8;
        FieldType[] r11 = VALUES;
        if (r10 < r11.length) goto L7;
        return null;
    L7:
        return r11[r10];
    L8:
        return null;
    }

    private static java.lang.reflect.Type getGenericSuperList(Class<?> r10) {
        java.lang.reflect.Type[] r11 = r10.getGenericInterfaces();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L10;
        java.lang.reflect.Type r14 = r11[r13];
        if ((r14 instanceof ParameterizedType) == false) goto L9;
        if (List.class.isAssignableFrom((Class) ((ParameterizedType) r14).getRawType()) == false) goto L9;
        return r14;
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        java.lang.reflect.Type r15 = r10.getGenericSuperclass();
        if ((r15 instanceof ParameterizedType) == true) goto L13;
        return null;
    L13:
        if (List.class.isAssignableFrom((Class) ((ParameterizedType) r15).getRawType()) == false) goto L21;
        return r15;
    L21:
        return null;
    }

    private static java.lang.reflect.Type getListParameter(Class<?> r10, java.lang.reflect.Type[] r11) {
    L2:
        int r12 = 0;
        if (r10 == List.class) goto L37;
        java.lang.reflect.Type r13 = getGenericSuperList(r10);
        if ((r13 instanceof ParameterizedType) == true) goto L6;
        r11 = EMPTY_TYPES;
        Class<?>[] r14 = r10.getInterfaces();
        int r15 = r14.length;
    L30:
        if (r12 >= r15) goto L35;
        Class<?> r16 = r14[r12];
        if (List.class.isAssignableFrom(r16) == true) goto L33;
        r12 = r12 + 1;
        goto L30
    L33:
        r10 = r16;
        goto L2
    L35:
        r10 = r10.getSuperclass();
        goto L2
    L6:
        ParameterizedType r17 = (ParameterizedType) r13;
        java.lang.reflect.Type[] r18 = r17.getActualTypeArguments();
        int r19 = 0;
    L8:
        if (r19 >= r18.length) goto L28;
        java.lang.reflect.Type r20 = r18[r19];
        if ((r20 instanceof TypeVariable) == false) goto L27;
        TypeVariable<Class<?>>[] r21 = r10.getTypeParameters();
        if (r11.length != r21.length) goto L26;
        int r22 = 0;
    L15:
        if (r22 >= r21.length) goto L20;
        if (r20 == r21[r22]) goto L18;
        r22 = r22 + 1;
        goto L15
    L18:
        r18[r19] = r11[r22];
        boolean r23 = true;
    L21:
        if (r23 == true) goto L27;
        throw new RuntimeException("Unable to find replacement for " + r20);
    L20:
        r23 = false;
        goto L21
    L26:
        throw new RuntimeException("Type array mismatch");
    L27:
        r19 = r19 + 1;
        goto L8
    L28:
        r10 = (Class) r17.getRawType();
        r11 = r18;
        goto L2
    L37:
        if (r11.length != 1) goto L41;
        return r11[0];
    L41:
        throw new RuntimeException("Unable to identify parameter type for List<T>");
    }

    private boolean isValidForList(java.lang.reflect.Field r10) {
        Class<?> r11 = r10.getType();
        if (this.javaType.getType().isAssignableFrom(r11) == true) goto L6;
        return false;
    L6:
        java.lang.reflect.Type[] r12 = EMPTY_TYPES;
        if ((r10.getGenericType() instanceof ParameterizedType) == false) goto L9;
        r12 = ((ParameterizedType) r10.getGenericType()).getActualTypeArguments();
    L9:
        java.lang.reflect.Type r13 = getListParameter(r11, r12);
        if ((r13 instanceof Class) == true) goto L14;
        return true;
    L14:
        return this.elementType.isAssignableFrom((Class) r13);
    }

    public static FieldType valueOf(String r10) {
        return (FieldType) java.lang.Enum.valueOf(FieldType.class, r10);
    }

    public static FieldType[] values() {
        return (FieldType[]) $VALUES.clone();
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

    public boolean isValidForField(java.lang.reflect.Field r10) {
        if (Collection.VECTOR.equals(this.collection) == false) goto L7;
        return isValidForList(r10);
    L7:
        return this.javaType.getType().isAssignableFrom(r10.getType());
    }
}
