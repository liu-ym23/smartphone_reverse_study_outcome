package org.msgpack.value;

/* JADX INFO: loaded from: classes3.dex */
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
        ValueType r10 = new ValueType("NIL", 0, false, false);
        NIL = r10;
        ValueType r11 = new ValueType("BOOLEAN", 1, false, false);
        BOOLEAN = r11;
        ValueType r12 = new ValueType("INTEGER", 2, true, false);
        INTEGER = r12;
        ValueType r13 = new ValueType("FLOAT", 3, true, false);
        FLOAT = r13;
        ValueType r14 = new ValueType("STRING", 4, false, true);
        STRING = r14;
        ValueType r15 = new ValueType("BINARY", 5, false, true);
        BINARY = r15;
        ValueType r16 = new ValueType("ARRAY", 6, false, false);
        ARRAY = r16;
        ValueType r17 = new ValueType("MAP", 7, false, false);
        MAP = r17;
        ValueType r18 = new ValueType("EXTENSION", 8, false, false);
        EXTENSION = r18;
        $VALUES = new ValueType[]{r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    private ValueType(String r10, int r11, boolean r12, boolean r13) {
        super(r10, r11);
        this.numberType = r12;
        this.rawType = r13;
    }

    public static ValueType valueOf(String r10) {
        return (ValueType) Enum.valueOf(ValueType.class, r10);
    }

    public static ValueType[] values() {
        return (ValueType[]) $VALUES.clone();
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
