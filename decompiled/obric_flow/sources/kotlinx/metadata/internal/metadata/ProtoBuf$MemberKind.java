package kotlinx.metadata.internal.metadata;

/* JADX INFO: loaded from: classes3.dex */
public final enum ProtoBuf$MemberKind extends Enum<ProtoBuf$MemberKind> implements kotlinx.metadata.internal.protobuf.r {
    public static final ProtoBuf$MemberKind DECLARATION = null;
    public static final int DECLARATION_VALUE = 0;
    public static final ProtoBuf$MemberKind DELEGATION = null;
    public static final int DELEGATION_VALUE = 2;
    public static final ProtoBuf$MemberKind FAKE_OVERRIDE = null;
    public static final int FAKE_OVERRIDE_VALUE = 1;
    public static final ProtoBuf$MemberKind SYNTHESIZED = null;
    public static final int SYNTHESIZED_VALUE = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r9.c f19058a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ProtoBuf$MemberKind[] f19059b = null;
    private final int value;

    static {
        ProtoBuf$MemberKind r5 = new ProtoBuf$MemberKind("DECLARATION", 0, 0);
        DECLARATION = r5;
        ProtoBuf$MemberKind r10 = new ProtoBuf$MemberKind("FAKE_OVERRIDE", 1, 1);
        FAKE_OVERRIDE = r10;
        ProtoBuf$MemberKind r11 = new ProtoBuf$MemberKind("DELEGATION", 2, 2);
        DELEGATION = r11;
        ProtoBuf$MemberKind r12 = new ProtoBuf$MemberKind("SYNTHESIZED", 3, 3);
        SYNTHESIZED = r12;
        f19059b = new ProtoBuf$MemberKind[]{r5, r10, r11, r12};
        f19058a = new r9.c(1);
    }

    public ProtoBuf$MemberKind(String r5, int r10, int r11) {
        super(r5, r10);
        this.value = r11;
    }

    public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
        return f19058a;
    }

    public static ProtoBuf$MemberKind valueOf(String r5) {
        return (ProtoBuf$MemberKind) Enum.valueOf(ProtoBuf$MemberKind.class, r5);
    }

    public static ProtoBuf$MemberKind[] values() {
        return (ProtoBuf$MemberKind[]) f19059b.clone();
    }

    @Override // kotlinx.metadata.internal.protobuf.r
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$MemberKind valueOf(int r5) {
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L14;
        if (r5 == 3) goto L12;
        return null;
    L12:
        return SYNTHESIZED;
    L14:
        return DELEGATION;
    L16:
        return FAKE_OVERRIDE;
    L18:
        return DECLARATION;
    }
}
