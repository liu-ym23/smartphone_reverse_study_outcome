package org.msgpack.value;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum ValueType extends Enum<ValueType> {
    private static final /* synthetic */ ValueType[] $VALUES = null;
    public static final ValueType ARRAY = null;
    public static final ValueType BINARY = null;
    public static final ValueType BOOLEAN = null;
    public static final ValueType EXTENSION = null;
    public static final ValueType FLOAT = null;
    public static final ValueType INTEGER = null;
    public static final ValueType MAP = null;
    public static final ValueType NIL = null;
    public static final ValueType STRING = null;
    private final boolean numberType;
    private final boolean rawType;

    static {
        ValueType r0 = new ValueType("NIL", 0, false, false);
        NIL = r0;
        ValueType r1 = new ValueType("BOOLEAN", 1, false, false);
        BOOLEAN = r1;
        ValueType r3 = new ValueType("INTEGER", 2, true, false);
        INTEGER = r3;
        ValueType r5 = new ValueType("FLOAT", 3, true, false);
        FLOAT = r5;
        ValueType r7 = new ValueType("STRING", 4, false, true);
        STRING = r7;
        ValueType r9 = new ValueType("BINARY", 5, false, true);
        BINARY = r9;
        ValueType r11 = new ValueType("ARRAY", 6, false, false);
        ARRAY = r11;
        ValueType r13 = new ValueType("MAP", 7, false, false);
        MAP = r13;
        ValueType r15 = new ValueType("EXTENSION", 8, false, false);
        EXTENSION = r15;
        $VALUES = new ValueType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
    }

    private ValueType(String r1, int r2, boolean r3, boolean r4) {
        super(r1, r2);
        this.numberType = r3;
        this.rawType = r4;
    }

    public static ValueType valueOf(String r2) {
        return (ValueType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ValueType.class, r2), ValueType.class, "com.obric.memorydata.plugin");
    }

    public static ValueType[] values() {
        return (ValueType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ValueType[].class, "com.obric.memorydata.plugin");
    }

    public boolean isArrayType() {
        if (this != ARRAY) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBinaryType() {
        if (this != BINARY) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBooleanType() {
        if (this != BOOLEAN) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isExtensionType() {
        if (this != EXTENSION) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFloatType() {
        if (this != FLOAT) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isIntegerType() {
        if (this != INTEGER) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isMapType() {
        if (this != MAP) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNilType() {
        if (this != NIL) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNumberType() {
        return this.numberType;
    }

    public boolean isRawType() {
        return this.rawType;
    }

    public boolean isStringType() {
        if (this != STRING) goto L5;
        return true;
    L5:
        return false;
    }
}
