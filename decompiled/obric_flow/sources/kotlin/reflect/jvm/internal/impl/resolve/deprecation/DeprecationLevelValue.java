package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

/* JADX INFO: loaded from: classes3.dex */
public final enum DeprecationLevelValue extends Enum<DeprecationLevelValue> {
    private static final /* synthetic */ DeprecationLevelValue[] $VALUES = null;
    public static final DeprecationLevelValue ERROR = null;
    public static final DeprecationLevelValue HIDDEN = null;
    public static final DeprecationLevelValue WARNING = null;

    private static final /* synthetic */ DeprecationLevelValue[] $values() {
        return new DeprecationLevelValue[]{WARNING, ERROR, HIDDEN};
    }

    static {
        WARNING = new DeprecationLevelValue("WARNING", 0);
        ERROR = new DeprecationLevelValue("ERROR", 1);
        HIDDEN = new DeprecationLevelValue("HIDDEN", 2);
        $VALUES = $values();
    }

    private DeprecationLevelValue(String r5, int r10) {
        super(r5, r10);
    }

    public static DeprecationLevelValue valueOf(String r5) {
        return (DeprecationLevelValue) Enum.valueOf(DeprecationLevelValue.class, r5);
    }

    public static DeprecationLevelValue[] values() {
        return (DeprecationLevelValue[]) $VALUES.clone();
    }
}
