package kotlinx.coroutines.selects;

/* JADX INFO: loaded from: classes3.dex */
public final enum TrySelectDetailedResult extends Enum<TrySelectDetailedResult> {
    private static final /* synthetic */ TrySelectDetailedResult[] $VALUES = null;
    public static final TrySelectDetailedResult ALREADY_SELECTED = null;
    public static final TrySelectDetailedResult CANCELLED = null;
    public static final TrySelectDetailedResult REREGISTER = null;
    public static final TrySelectDetailedResult SUCCESSFUL = null;

    private static final /* synthetic */ TrySelectDetailedResult[] $values() {
        return new TrySelectDetailedResult[]{SUCCESSFUL, REREGISTER, CANCELLED, ALREADY_SELECTED};
    }

    static {
        SUCCESSFUL = new TrySelectDetailedResult("SUCCESSFUL", 0);
        REREGISTER = new TrySelectDetailedResult("REREGISTER", 1);
        CANCELLED = new TrySelectDetailedResult("CANCELLED", 2);
        ALREADY_SELECTED = new TrySelectDetailedResult("ALREADY_SELECTED", 3);
        $VALUES = $values();
    }

    private TrySelectDetailedResult(String r10, int r11) {
        super(r10, r11);
    }

    public static TrySelectDetailedResult valueOf(String r10) {
        return (TrySelectDetailedResult) Enum.valueOf(TrySelectDetailedResult.class, r10);
    }

    public static TrySelectDetailedResult[] values() {
        return (TrySelectDetailedResult[]) $VALUES.clone();
    }
}
