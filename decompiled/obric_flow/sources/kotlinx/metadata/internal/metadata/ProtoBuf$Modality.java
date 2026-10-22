package kotlinx.metadata.internal.metadata;

/* JADX INFO: loaded from: classes3.dex */
public final enum ProtoBuf$Modality extends Enum<ProtoBuf$Modality> implements kotlinx.metadata.internal.protobuf.r {
    public static final ProtoBuf$Modality ABSTRACT = null;
    public static final int ABSTRACT_VALUE = 2;
    public static final ProtoBuf$Modality FINAL = null;
    public static final int FINAL_VALUE = 0;
    public static final ProtoBuf$Modality OPEN = null;
    public static final int OPEN_VALUE = 1;
    public static final ProtoBuf$Modality SEALED = null;
    public static final int SEALED_VALUE = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s6.b f19060a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ProtoBuf$Modality[] f19061b = null;
    private final int value;

    static {
        ProtoBuf$Modality r5 = new ProtoBuf$Modality("FINAL", 0, 0);
        FINAL = r5;
        ProtoBuf$Modality r10 = new ProtoBuf$Modality("OPEN", 1, 1);
        OPEN = r10;
        ProtoBuf$Modality r11 = new ProtoBuf$Modality("ABSTRACT", 2, 2);
        ABSTRACT = r11;
        ProtoBuf$Modality r12 = new ProtoBuf$Modality("SEALED", 3, 3);
        SEALED = r12;
        f19061b = new ProtoBuf$Modality[]{r5, r10, r11, r12};
        f19060a = new s6.b(1);
    }

    public ProtoBuf$Modality(String r5, int r10, int r11) {
        super(r5, r10);
        this.value = r11;
    }

    public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
        return f19060a;
    }

    public static ProtoBuf$Modality valueOf(String r5) {
        return (ProtoBuf$Modality) Enum.valueOf(ProtoBuf$Modality.class, r5);
    }

    public static ProtoBuf$Modality[] values() {
        return (ProtoBuf$Modality[]) f19061b.clone();
    }

    @Override // kotlinx.metadata.internal.protobuf.r
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$Modality valueOf(int r5) {
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L14;
        if (r5 == 3) goto L12;
        return null;
    L12:
        return SEALED;
    L14:
        return ABSTRACT;
    L16:
        return OPEN;
    L18:
        return FINAL;
    }
}
