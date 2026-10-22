package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final enum JavaType extends java.lang.Enum<JavaType> {
    private static final /* synthetic */ JavaType[] $VALUES = null;
    public static final JavaType BOOLEAN = null;
    public static final JavaType BYTE_STRING = null;
    public static final JavaType DOUBLE = null;
    public static final JavaType ENUM = null;
    public static final JavaType FLOAT = null;
    public static final JavaType INT = null;
    public static final JavaType LONG = null;
    public static final JavaType MESSAGE = null;
    public static final JavaType STRING = null;
    public static final JavaType VOID = null;
    private final Class<?> boxedType;
    private final Object defaultDefault;
    private final Class<?> type;

    private static /* synthetic */ JavaType[] $values() {
        return new JavaType[]{VOID, INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING, BYTE_STRING, ENUM, MESSAGE};
    }

    static {
        VOID = new JavaType("VOID", 0, Void.class, Void.class, null);
        Class r10 = Integer.TYPE;
        INT = new JavaType("INT", 1, r10, Integer.class, 0);
        LONG = new JavaType("LONG", 2, Long.TYPE, Long.class, 0L);
        FLOAT = new JavaType("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        DOUBLE = new JavaType("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        BOOLEAN = new JavaType("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        STRING = new JavaType("STRING", 6, String.class, String.class, "");
        BYTE_STRING = new JavaType("BYTE_STRING", 7, ByteString.class, ByteString.class, ByteString.EMPTY);
        ENUM = new JavaType("ENUM", 8, r10, Integer.class, null);
        MESSAGE = new JavaType("MESSAGE", 9, Object.class, Object.class, null);
        $VALUES = $values();
    }

    private JavaType(String r10, int r11, Class r12, Class r13, Object r14) {
        super(r10, r11);
        this.type = r12;
        this.boxedType = r13;
        this.defaultDefault = r14;
    }

    public static JavaType valueOf(String r10) {
        return (JavaType) java.lang.Enum.valueOf(JavaType.class, r10);
    }

    public static JavaType[] values() {
        return (JavaType[]) $VALUES.clone();
    }

    public Class<?> getBoxedType() {
        return this.boxedType;
    }

    public Object getDefaultDefault() {
        return this.defaultDefault;
    }

    public Class<?> getType() {
        return this.type;
    }

    public boolean isValidType(Class<?> r10) {
        return this.type.isAssignableFrom(r10);
    }
}
