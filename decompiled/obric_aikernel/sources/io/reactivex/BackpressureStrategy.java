package io.reactivex;

/* JADX INFO: loaded from: classes2.dex */
public final enum BackpressureStrategy extends Enum<BackpressureStrategy> {
    private static final /* synthetic */ BackpressureStrategy[] $VALUES = null;
    public static final BackpressureStrategy BUFFER = null;
    public static final BackpressureStrategy DROP = null;
    public static final BackpressureStrategy ERROR = null;
    public static final BackpressureStrategy LATEST = null;
    public static final BackpressureStrategy MISSING = null;

    static {
        BackpressureStrategy r10 = new BackpressureStrategy("MISSING", 0);
        MISSING = r10;
        BackpressureStrategy r11 = new BackpressureStrategy("ERROR", 1);
        ERROR = r11;
        BackpressureStrategy r12 = new BackpressureStrategy("BUFFER", 2);
        BUFFER = r12;
        BackpressureStrategy r13 = new BackpressureStrategy("DROP", 3);
        DROP = r13;
        BackpressureStrategy r14 = new BackpressureStrategy("LATEST", 4);
        LATEST = r14;
        $VALUES = new BackpressureStrategy[]{r10, r11, r12, r13, r14};
    }

    private BackpressureStrategy(String r10, int r11) {
        super(r10, r11);
    }

    public static BackpressureStrategy valueOf(String r10) {
        return (BackpressureStrategy) Enum.valueOf(BackpressureStrategy.class, r10);
    }

    public static BackpressureStrategy[] values() {
        return (BackpressureStrategy[]) $VALUES.clone();
    }
}
