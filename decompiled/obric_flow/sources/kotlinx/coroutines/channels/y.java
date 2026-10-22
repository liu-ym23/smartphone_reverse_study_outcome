package kotlinx.coroutines.channels;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18818a = null;

    static {
        int[] r5 = new int[TickerMode.values().length];
        r5[TickerMode.FIXED_PERIOD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r5[TickerMode.FIXED_DELAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        f18818a = r5;
    }
}
