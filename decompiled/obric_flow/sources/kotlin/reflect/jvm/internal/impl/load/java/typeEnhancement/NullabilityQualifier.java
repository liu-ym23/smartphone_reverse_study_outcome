package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: loaded from: classes3.dex */
public final enum NullabilityQualifier extends Enum<NullabilityQualifier> {
    private static final /* synthetic */ NullabilityQualifier[] $VALUES = null;
    public static final NullabilityQualifier FORCE_FLEXIBILITY = null;
    public static final NullabilityQualifier NOT_NULL = null;
    public static final NullabilityQualifier NULLABLE = null;

    private static final /* synthetic */ NullabilityQualifier[] $values() {
        return new NullabilityQualifier[]{FORCE_FLEXIBILITY, NULLABLE, NOT_NULL};
    }

    static {
        FORCE_FLEXIBILITY = new NullabilityQualifier("FORCE_FLEXIBILITY", 0);
        NULLABLE = new NullabilityQualifier("NULLABLE", 1);
        NOT_NULL = new NullabilityQualifier("NOT_NULL", 2);
        $VALUES = $values();
    }

    private NullabilityQualifier(String r5, int r10) {
        super(r5, r10);
    }

    public static NullabilityQualifier valueOf(String r5) {
        return (NullabilityQualifier) Enum.valueOf(NullabilityQualifier.class, r5);
    }

    public static NullabilityQualifier[] values() {
        return (NullabilityQualifier[]) $VALUES.clone();
    }
}
