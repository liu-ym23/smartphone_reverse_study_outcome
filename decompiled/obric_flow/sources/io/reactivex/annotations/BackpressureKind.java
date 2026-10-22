package io.reactivex.annotations;

/* JADX INFO: loaded from: classes3.dex */
public final enum BackpressureKind extends Enum<BackpressureKind> {
    public static final BackpressureKind ERROR = null;
    public static final BackpressureKind FULL = null;
    public static final BackpressureKind NONE = null;
    public static final BackpressureKind PASS_THROUGH = null;
    public static final BackpressureKind SPECIAL = null;
    public static final BackpressureKind UNBOUNDED_IN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackpressureKind[] f17604a = null;

    static {
        BackpressureKind r5 = new BackpressureKind("PASS_THROUGH", 0);
        PASS_THROUGH = r5;
        BackpressureKind r10 = new BackpressureKind("FULL", 1);
        FULL = r10;
        BackpressureKind r11 = new BackpressureKind("SPECIAL", 2);
        SPECIAL = r11;
        BackpressureKind r12 = new BackpressureKind("UNBOUNDED_IN", 3);
        UNBOUNDED_IN = r12;
        BackpressureKind r13 = new BackpressureKind("ERROR", 4);
        ERROR = r13;
        BackpressureKind r14 = new BackpressureKind("NONE", 5);
        NONE = r14;
        f17604a = new BackpressureKind[]{r5, r10, r11, r12, r13, r14};
    }

    public static BackpressureKind valueOf(String r5) {
        return (BackpressureKind) Enum.valueOf(BackpressureKind.class, r5);
    }

    public static BackpressureKind[] values() {
        return (BackpressureKind[]) f17604a.clone();
    }
}
