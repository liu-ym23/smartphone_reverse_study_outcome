package kotlinx.metadata.internal.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final enum WireFormat$JavaType extends Enum<WireFormat$JavaType> {
    public static final WireFormat$JavaType BOOLEAN = null;
    public static final WireFormat$JavaType BYTE_STRING = null;
    public static final WireFormat$JavaType DOUBLE = null;
    public static final WireFormat$JavaType ENUM = null;
    public static final WireFormat$JavaType FLOAT = null;
    public static final WireFormat$JavaType INT = null;
    public static final WireFormat$JavaType LONG = null;
    public static final WireFormat$JavaType MESSAGE = null;
    public static final WireFormat$JavaType STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WireFormat$JavaType[] f19144a = null;
    private final Object defaultDefault;

    static {
        WireFormat$JavaType r5 = new WireFormat$JavaType("INT", 0, 0);
        INT = r5;
        WireFormat$JavaType r10 = new WireFormat$JavaType("LONG", 1, 0L);
        LONG = r10;
        WireFormat$JavaType r11 = new WireFormat$JavaType("FLOAT", 2, Float.valueOf(0.0f));
        FLOAT = r11;
        WireFormat$JavaType r12 = new WireFormat$JavaType("DOUBLE", 3, Double.valueOf(0.0d));
        DOUBLE = r12;
        WireFormat$JavaType r13 = new WireFormat$JavaType("BOOLEAN", 4, Boolean.FALSE);
        BOOLEAN = r13;
        WireFormat$JavaType r14 = new WireFormat$JavaType("STRING", 5, "");
        STRING = r14;
        WireFormat$JavaType r15 = new WireFormat$JavaType("BYTE_STRING", 6, e.f19154a);
        BYTE_STRING = r15;
        WireFormat$JavaType r16 = new WireFormat$JavaType("ENUM", 7, null);
        ENUM = r16;
        WireFormat$JavaType r17 = new WireFormat$JavaType("MESSAGE", 8, null);
        MESSAGE = r17;
        f19144a = new WireFormat$JavaType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    public WireFormat$JavaType(String r5, int r10, Object r11) {
        super(r5, r10);
        this.defaultDefault = r11;
    }

    public static WireFormat$JavaType valueOf(String r5) {
        return (WireFormat$JavaType) Enum.valueOf(WireFormat$JavaType.class, r5);
    }

    public static WireFormat$JavaType[] values() {
        return (WireFormat$JavaType[]) f19144a.clone();
    }

    public Object getDefaultDefault() {
        return this.defaultDefault;
    }
}
