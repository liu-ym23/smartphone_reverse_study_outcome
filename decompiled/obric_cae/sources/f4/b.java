package f4;

/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ b[] f7323a = null;

    static {
        f7323a = new b[]{new b("InterruptionInvalidDid", 0), new b("InterruptionBlockList", 1), new b("InterruptionTouristMode", 2), new b("InterruptionEventList", 3), new b("InterruptionSampling", 4), new b("OutOfDataBoundary", 5), new b("CacheOverflow", 6), new b("CommonError", 7), new b("HighFrequency", 8), new b("LargeSize", 9)};
    }

    public b(String r8, int r10) {
        super(r8, r10);
    }

    public static b valueOf(String r8) {
        return (b) Enum.valueOf(b.class, r8);
    }

    public static b[] values() {
        return (b[]) f7323a.clone();
    }
}
