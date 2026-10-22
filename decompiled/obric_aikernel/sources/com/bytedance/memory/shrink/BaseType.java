package com.bytedance.memory.shrink;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final enum BaseType extends Enum<BaseType> {
    private static final /* synthetic */ BaseType[] $VALUES = null;
    public static final BaseType BOOLEAN = null;
    public static final BaseType BYTE = null;
    public static final BaseType CHAR = null;
    public static final BaseType DOUBLE = null;
    public static final BaseType FLOAT = null;
    public static final BaseType INT = null;
    public static final BaseType LONG = null;
    public static final BaseType OBJECT = null;
    public static final BaseType SHORT = null;
    private static Map<Integer, BaseType> sTypeMap;
    private int mId;
    private int mSize;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2166a = null;

        static {
            int[] r10 = new int[BaseType.values().length];
            f2166a = r10;
            r10[BaseType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f2166a[BaseType.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f2166a[BaseType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f2166a[BaseType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f2166a[BaseType.BYTE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f2166a[BaseType.SHORT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f2166a[BaseType.INT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f2166a[BaseType.LONG.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        int r10 = 0;
        BaseType r11 = new BaseType("OBJECT", 0, 2, 0);
        OBJECT = r11;
        BaseType r12 = new BaseType("BOOLEAN", 1, 4, 1);
        BOOLEAN = r12;
        BaseType r13 = new BaseType("CHAR", 2, 5, 2);
        CHAR = r13;
        BaseType r14 = new BaseType("FLOAT", 3, 6, 4);
        FLOAT = r14;
        BaseType r15 = new BaseType("DOUBLE", 4, 7, 8);
        DOUBLE = r15;
        BaseType r16 = new BaseType("BYTE", 5, 8, 1);
        BYTE = r16;
        BaseType r17 = new BaseType("SHORT", 6, 9, 2);
        SHORT = r17;
        BaseType r18 = new BaseType("INT", 7, 10, 4);
        INT = r18;
        BaseType r19 = new BaseType("LONG", 8, 11, 8);
        LONG = r19;
        $VALUES = new BaseType[]{r11, r12, r13, r14, r15, r16, r17, r18, r19};
        sTypeMap = new HashMap();
        BaseType[] r20 = values();
        int r21 = r20.length;
    L3:
        if (r10 >= r21) goto L5;
        BaseType r22 = r20[r10];
        sTypeMap.put(Integer.valueOf(r22.mId), r22);
        r10 = r10 + 1;
        goto L3
    }

    private BaseType(String r10, int r11, int r12, int r13) {
        super(r10, r11);
        this.mId = r12;
        this.mSize = r13;
    }

    public static String getClassNameOfPrimitiveArray(BaseType r10) {
        switch(a.f2166a[r10.ordinal()]) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return "long[]";
    L8:
        return "int[]";
    L10:
        return "short[]";
    L12:
        return "byte[]";
    L14:
        return "double[]";
    L16:
        return "float[]";
    L18:
        return "char[]";
    L20:
        return "boolean[]";
    L5:
        throw new IllegalArgumentException("OBJECT type is not a primitive type");
    }

    public static BaseType getType(int r10) {
        return sTypeMap.get(Integer.valueOf(r10));
    }

    public static BaseType valueOf(String r10) {
        return (BaseType) Enum.valueOf(BaseType.class, r10);
    }

    public static BaseType[] values() {
        return (BaseType[]) $VALUES.clone();
    }

    public int getSize(int r10) {
        int r11 = this.mSize;
        if (r11 != 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    public int getTypeId() {
        return this.mId;
    }
}
