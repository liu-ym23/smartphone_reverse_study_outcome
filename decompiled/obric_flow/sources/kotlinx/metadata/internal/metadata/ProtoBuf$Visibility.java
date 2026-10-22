package kotlinx.metadata.internal.metadata;

/* JADX INFO: loaded from: classes3.dex */
public final enum ProtoBuf$Visibility extends Enum<ProtoBuf$Visibility> implements kotlinx.metadata.internal.protobuf.r {
    public static final ProtoBuf$Visibility INTERNAL = null;
    public static final int INTERNAL_VALUE = 0;
    public static final ProtoBuf$Visibility LOCAL = null;
    public static final int LOCAL_VALUE = 5;
    public static final ProtoBuf$Visibility PRIVATE = null;
    public static final ProtoBuf$Visibility PRIVATE_TO_THIS = null;
    public static final int PRIVATE_TO_THIS_VALUE = 4;
    public static final int PRIVATE_VALUE = 1;
    public static final ProtoBuf$Visibility PROTECTED = null;
    public static final int PROTECTED_VALUE = 2;
    public static final ProtoBuf$Visibility PUBLIC = null;
    public static final int PUBLIC_VALUE = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sj.e f19086a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ProtoBuf$Visibility[] f19087b = null;
    private final int value;

    static {
        ProtoBuf$Visibility r5 = new ProtoBuf$Visibility("INTERNAL", 0, 0);
        INTERNAL = r5;
        ProtoBuf$Visibility r10 = new ProtoBuf$Visibility("PRIVATE", 1, 1);
        PRIVATE = r10;
        ProtoBuf$Visibility r11 = new ProtoBuf$Visibility("PROTECTED", 2, 2);
        PROTECTED = r11;
        ProtoBuf$Visibility r12 = new ProtoBuf$Visibility("PUBLIC", 3, 3);
        PUBLIC = r12;
        ProtoBuf$Visibility r13 = new ProtoBuf$Visibility("PRIVATE_TO_THIS", 4, 4);
        PRIVATE_TO_THIS = r13;
        ProtoBuf$Visibility r14 = new ProtoBuf$Visibility("LOCAL", 5, 5);
        LOCAL = r14;
        f19087b = new ProtoBuf$Visibility[]{r5, r10, r11, r12, r13, r14};
        f19086a = new sj.e();
    }

    public ProtoBuf$Visibility(String r5, int r10, int r11) {
        super(r5, r10);
        this.value = r11;
    }

    public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
        return f19086a;
    }

    public static ProtoBuf$Visibility valueOf(String r5) {
        return (ProtoBuf$Visibility) Enum.valueOf(ProtoBuf$Visibility.class, r5);
    }

    public static ProtoBuf$Visibility[] values() {
        return (ProtoBuf$Visibility[]) f19087b.clone();
    }

    @Override // kotlinx.metadata.internal.protobuf.r
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$Visibility valueOf(int r5) {
        if (r5 == 0) goto L26;
        if (r5 == 1) goto L24;
        if (r5 == 2) goto L22;
        if (r5 == 3) goto L20;
        if (r5 == 4) goto L18;
        if (r5 == 5) goto L16;
        return null;
    L16:
        return LOCAL;
    L18:
        return PRIVATE_TO_THIS;
    L20:
        return PUBLIC;
    L22:
        return PROTECTED;
    L24:
        return PRIVATE;
    L26:
        return INTERNAL;
    }
}
