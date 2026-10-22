package kotlinx.metadata.internal.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public enum WireFormat$FieldType extends Enum<WireFormat$FieldType> {
    public static final WireFormat$FieldType BOOL = null;
    public static final WireFormat$FieldType BYTES = null;
    public static final WireFormat$FieldType DOUBLE = null;
    public static final WireFormat$FieldType ENUM = null;
    public static final WireFormat$FieldType FIXED32 = null;
    public static final WireFormat$FieldType FIXED64 = null;
    public static final WireFormat$FieldType FLOAT = null;
    public static final WireFormat$FieldType GROUP = null;
    public static final WireFormat$FieldType INT32 = null;
    public static final WireFormat$FieldType INT64 = null;
    public static final WireFormat$FieldType MESSAGE = null;
    public static final WireFormat$FieldType SFIXED32 = null;
    public static final WireFormat$FieldType SFIXED64 = null;
    public static final WireFormat$FieldType SINT32 = null;
    public static final WireFormat$FieldType SINT64 = null;
    public static final WireFormat$FieldType STRING = null;
    public static final WireFormat$FieldType UINT32 = null;
    public static final WireFormat$FieldType UINT64 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WireFormat$FieldType[] f19143a = null;
    private final WireFormat$JavaType javaType;
    private final int wireType;

    static {
        WireFormat$FieldType r5 = new WireFormat$FieldType("DOUBLE", 0, WireFormat$JavaType.DOUBLE, 1);
        DOUBLE = r5;
        WireFormat$FieldType r10 = new WireFormat$FieldType("FLOAT", 1, WireFormat$JavaType.FLOAT, 5);
        FLOAT = r10;
        WireFormat$JavaType r11 = WireFormat$JavaType.LONG;
        final int r12 = 2;
        WireFormat$FieldType r13 = new WireFormat$FieldType("INT64", 2, r11, 0);
        INT64 = r13;
        final int r14 = 3;
        WireFormat$FieldType r15 = new WireFormat$FieldType("UINT64", 3, r11, 0);
        UINT64 = r15;
        WireFormat$JavaType r16 = WireFormat$JavaType.INT;
        WireFormat$FieldType r17 = new WireFormat$FieldType("INT32", 4, r16, 0);
        INT32 = r17;
        WireFormat$FieldType r18 = new WireFormat$FieldType("FIXED64", 5, r11, 1);
        FIXED64 = r18;
        WireFormat$FieldType r19 = new WireFormat$FieldType("FIXED32", 6, r16, 5);
        FIXED32 = r19;
        WireFormat$FieldType r110 = new WireFormat$FieldType("BOOL", 7, WireFormat$JavaType.BOOLEAN, 0);
        BOOL = r110;
        final int r20 = 8;
        final WireFormat$JavaType r111 = WireFormat$JavaType.STRING;
        final String r21 = "STRING";
        WireFormat$FieldType r22 = new AnonymousClass1(r21, r20, r111, r12);
        STRING = r22;
        final WireFormat$JavaType r112 = WireFormat$JavaType.MESSAGE;
        final String r23 = "GROUP";
        final int r24 = 9;
        WireFormat$FieldType r25 = new AnonymousClass2(r23, r24, r112, r14);
        GROUP = r25;
        final String r26 = "MESSAGE";
        final int r113 = 10;
        final int r27 = 2;
        WireFormat$FieldType r28 = new AnonymousClass3(r26, r113, r112, r27);
        MESSAGE = r28;
        final int r114 = 11;
        final WireFormat$JavaType r115 = WireFormat$JavaType.BYTE_STRING;
        final String r29 = "BYTES";
        WireFormat$FieldType r30 = new AnonymousClass4(r29, r114, r115, r27);
        BYTES = r30;
        WireFormat$FieldType r31 = new WireFormat$FieldType("UINT32", 12, r16, 0);
        UINT32 = r31;
        WireFormat$FieldType r32 = new WireFormat$FieldType("ENUM", 13, WireFormat$JavaType.ENUM, 0);
        ENUM = r32;
        WireFormat$FieldType r33 = new WireFormat$FieldType("SFIXED32", 14, r16, 5);
        SFIXED32 = r33;
        WireFormat$FieldType r34 = new WireFormat$FieldType("SFIXED64", 15, r11, 1);
        SFIXED64 = r34;
        WireFormat$FieldType r35 = new WireFormat$FieldType("SINT32", 16, r16, 0);
        SINT32 = r35;
        WireFormat$FieldType r116 = new WireFormat$FieldType("SINT64", 17, r11, 0);
        SINT64 = r116;
        f19143a = new WireFormat$FieldType[]{r5, r10, r13, r15, r17, r18, r19, r110, r22, r25, r28, r30, r31, r32, r33, r34, r35, r116};
    }

    public /* synthetic */ WireFormat$FieldType(String r5, int r10, WireFormat$JavaType r11, int r12, q0 r13) {
        this(r5, r10, r11, r12);
    }

    public static WireFormat$FieldType valueOf(String r5) {
        return (WireFormat$FieldType) Enum.valueOf(WireFormat$FieldType.class, r5);
    }

    public static WireFormat$FieldType[] values() {
        return (WireFormat$FieldType[]) f19143a.clone();
    }

    public WireFormat$JavaType getJavaType() {
        return this.javaType;
    }

    public int getWireType() {
        return this.wireType;
    }

    public boolean isPackable() {
        return true;
    }

    public WireFormat$FieldType(String r5, int r10, WireFormat$JavaType r11, int r12) {
        super(r5, r10);
        this.javaType = r11;
        this.wireType = r12;
    }
}
