package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public final enum ExistingWorkPolicy extends Enum<ExistingWorkPolicy> {
    private static final /* synthetic */ ExistingWorkPolicy[] $VALUES = null;
    public static final ExistingWorkPolicy APPEND = null;
    public static final ExistingWorkPolicy APPEND_OR_REPLACE = null;
    public static final ExistingWorkPolicy KEEP = null;
    public static final ExistingWorkPolicy REPLACE = null;

    private static final /* synthetic */ ExistingWorkPolicy[] $values() {
        return new ExistingWorkPolicy[]{REPLACE, KEEP, APPEND, APPEND_OR_REPLACE};
    }

    static {
        REPLACE = new ExistingWorkPolicy("REPLACE", 0);
        KEEP = new ExistingWorkPolicy("KEEP", 1);
        APPEND = new ExistingWorkPolicy("APPEND", 2);
        APPEND_OR_REPLACE = new ExistingWorkPolicy("APPEND_OR_REPLACE", 3);
        $VALUES = $values();
    }

    private ExistingWorkPolicy(String r10, int r11) {
        super(r10, r11);
    }

    public static ExistingWorkPolicy valueOf(String r10) {
        return (ExistingWorkPolicy) Enum.valueOf(ExistingWorkPolicy.class, r10);
    }

    public static ExistingWorkPolicy[] values() {
        return (ExistingWorkPolicy[]) $VALUES.clone();
    }
}
