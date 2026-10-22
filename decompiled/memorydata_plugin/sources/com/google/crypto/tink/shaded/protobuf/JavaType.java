package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum JavaType extends Enum<JavaType> {
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

    static {
        JavaType r6 = new JavaType("VOID", 0, Void.class, Void.class, null);
        VOID = r6;
        JavaType r0 = new JavaType("INT", 1, Integer.TYPE, Integer.class, 0);
        INT = r0;
        JavaType r2 = new JavaType("LONG", 2, Long.TYPE, Long.class, 0L);
        LONG = r2;
        JavaType r3 = new JavaType("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        FLOAT = r3;
        JavaType r4 = new JavaType("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        DOUBLE = r4;
        JavaType r5 = new JavaType("BOOLEAN", 5, Boolean.TYPE, Boolean.class, false);
        BOOLEAN = r5;
        JavaType r7 = new JavaType("STRING", 6, String.class, String.class, "");
        STRING = r7;
        JavaType r14 = new JavaType("BYTE_STRING", 7, ByteString.class, ByteString.class, ByteString.EMPTY);
        BYTE_STRING = r14;
        JavaType r8 = new JavaType("ENUM", 8, Integer.TYPE, Integer.class, null);
        ENUM = r8;
        JavaType r9 = new JavaType("MESSAGE", 9, Object.class, Object.class, null);
        MESSAGE = r9;
        $VALUES = new JavaType[]{r6, r0, r2, r3, r4, r5, r7, r14, r8, r9};
    }

    private JavaType(String r1, int r2, Class r3, Class r4, Object r5) {
        super(r1, r2);
        this.type = r3;
        this.boxedType = r4;
        this.defaultDefault = r5;
    }

    public static JavaType valueOf(String r2) {
        return (JavaType) ZeusTransformUtils.preCheckCast(Enum.valueOf(JavaType.class, r2), JavaType.class, "com.obric.memorydata.plugin");
    }

    public static JavaType[] values() {
        return (JavaType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), JavaType[].class, "com.obric.memorydata.plugin");
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

    public boolean isValidType(Class<?> r1) {
        return this.type.isAssignableFrom(r1);
    }
}
