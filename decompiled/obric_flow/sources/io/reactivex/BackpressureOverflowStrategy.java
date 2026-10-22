package io.reactivex;

/* JADX INFO: loaded from: classes3.dex */
public final enum BackpressureOverflowStrategy extends Enum<BackpressureOverflowStrategy> {
    public static final BackpressureOverflowStrategy DROP_LATEST = null;
    public static final BackpressureOverflowStrategy DROP_OLDEST = null;
    public static final BackpressureOverflowStrategy ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackpressureOverflowStrategy[] f17602a = null;

    static {
        BackpressureOverflowStrategy r5 = new BackpressureOverflowStrategy("ERROR", 0);
        ERROR = r5;
        BackpressureOverflowStrategy r10 = new BackpressureOverflowStrategy("DROP_OLDEST", 1);
        DROP_OLDEST = r10;
        BackpressureOverflowStrategy r11 = new BackpressureOverflowStrategy("DROP_LATEST", 2);
        DROP_LATEST = r11;
        f17602a = new BackpressureOverflowStrategy[]{r5, r10, r11};
    }

    public static BackpressureOverflowStrategy valueOf(String r5) {
        return (BackpressureOverflowStrategy) Enum.valueOf(BackpressureOverflowStrategy.class, r5);
    }

    public static BackpressureOverflowStrategy[] values() {
        return (BackpressureOverflowStrategy[]) f17602a.clone();
    }
}
