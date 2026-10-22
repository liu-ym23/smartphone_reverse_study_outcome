package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: loaded from: classes3.dex */
public final enum MutabilityQualifier extends Enum<MutabilityQualifier> {
    private static final /* synthetic */ MutabilityQualifier[] $VALUES = null;
    public static final MutabilityQualifier MUTABLE = null;
    public static final MutabilityQualifier READ_ONLY = null;

    private static final /* synthetic */ MutabilityQualifier[] $values() {
        return new MutabilityQualifier[]{READ_ONLY, MUTABLE};
    }

    static {
        READ_ONLY = new MutabilityQualifier("READ_ONLY", 0);
        MUTABLE = new MutabilityQualifier("MUTABLE", 1);
        $VALUES = $values();
    }

    private MutabilityQualifier(String r5, int r10) {
        super(r5, r10);
    }

    public static MutabilityQualifier valueOf(String r5) {
        return (MutabilityQualifier) Enum.valueOf(MutabilityQualifier.class, r5);
    }

    public static MutabilityQualifier[] values() {
        return (MutabilityQualifier[]) $VALUES.clone();
    }
}
