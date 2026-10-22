package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: classes3.dex */
public final enum Variance extends Enum<Variance> {
    private static final /* synthetic */ Variance[] $VALUES = null;
    public static final Variance INVARIANT = null;
    public static final Variance IN_VARIANCE = null;
    public static final Variance OUT_VARIANCE = null;
    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    private final String label;
    private final int superpositionFactor;

    private static final /* synthetic */ Variance[] $values() {
        return new Variance[]{INVARIANT, IN_VARIANCE, OUT_VARIANCE};
    }

    static {
        INVARIANT = new Variance("INVARIANT", 0, "", true, true, 0);
        IN_VARIANCE = new Variance("IN_VARIANCE", 1, "in", true, false, -1);
        OUT_VARIANCE = new Variance("OUT_VARIANCE", 2, "out", false, true, 1);
        $VALUES = $values();
    }

    private Variance(String r5, int r10, String r11, boolean r12, boolean r13, int r14) {
        super(r5, r10);
        this.label = r11;
        this.allowsInPosition = r12;
        this.allowsOutPosition = r13;
        this.superpositionFactor = r14;
    }

    public static Variance valueOf(String r5) {
        return (Variance) Enum.valueOf(Variance.class, r5);
    }

    public static Variance[] values() {
        return (Variance[]) $VALUES.clone();
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    public final String getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.label;
    }
}
