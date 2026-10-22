package io.reactivex;

/* JADX INFO: loaded from: classes3.dex */
public final enum BackpressureStrategy extends Enum<BackpressureStrategy> {
    public static final BackpressureStrategy BUFFER = null;
    public static final BackpressureStrategy DROP = null;
    public static final BackpressureStrategy ERROR = null;
    public static final BackpressureStrategy LATEST = null;
    public static final BackpressureStrategy MISSING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackpressureStrategy[] f17603a = null;

    static {
        BackpressureStrategy r5 = new BackpressureStrategy("MISSING", 0);
        MISSING = r5;
        BackpressureStrategy r10 = new BackpressureStrategy("ERROR", 1);
        ERROR = r10;
        BackpressureStrategy r11 = new BackpressureStrategy("BUFFER", 2);
        BUFFER = r11;
        BackpressureStrategy r12 = new BackpressureStrategy("DROP", 3);
        DROP = r12;
        BackpressureStrategy r13 = new BackpressureStrategy("LATEST", 4);
        LATEST = r13;
        f17603a = new BackpressureStrategy[]{r5, r10, r11, r12, r13};
    }

    public static BackpressureStrategy valueOf(String r5) {
        return (BackpressureStrategy) Enum.valueOf(BackpressureStrategy.class, r5);
    }

    public static BackpressureStrategy[] values() {
        return (BackpressureStrategy[]) f17603a.clone();
    }
}
