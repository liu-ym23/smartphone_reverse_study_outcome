package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public final enum BackoffPolicy extends Enum<BackoffPolicy> {
    private static final /* synthetic */ BackoffPolicy[] $VALUES = null;
    public static final BackoffPolicy EXPONENTIAL = null;
    public static final BackoffPolicy LINEAR = null;

    private static final /* synthetic */ BackoffPolicy[] $values() {
        return new BackoffPolicy[]{EXPONENTIAL, LINEAR};
    }

    static {
        EXPONENTIAL = new BackoffPolicy("EXPONENTIAL", 0);
        LINEAR = new BackoffPolicy("LINEAR", 1);
        $VALUES = $values();
    }

    private BackoffPolicy(String r10, int r11) {
        super(r10, r11);
    }

    public static BackoffPolicy valueOf(String r10) {
        return (BackoffPolicy) Enum.valueOf(BackoffPolicy.class, r10);
    }

    public static BackoffPolicy[] values() {
        return (BackoffPolicy[]) $VALUES.clone();
    }
}
