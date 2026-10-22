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

    private MutabilityQualifier(String r10, int r11) {
        super(r10, r11);
    }

    public static MutabilityQualifier valueOf(String r10) {
        return (MutabilityQualifier) Enum.valueOf(MutabilityQualifier.class, r10);
    }

    public static MutabilityQualifier[] values() {
        return (MutabilityQualifier[]) $VALUES.clone();
    }
}
