package v0;

/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f12682b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c f12683m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f12684n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ c[] f12685o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12686a;

    static {
        c r8 = new c("DEX_FILES", 0, 0);
        f12682b = r8;
        c r10 = new c("EXTRA_DESCRIPTORS", 1, 1);
        c r11 = new c("CLASSES", 2, 2);
        f12683m = r11;
        c r12 = new c("METHODS", 3, 3);
        f12684n = r12;
        f12685o = new c[]{r8, r10, r11, r12, new c("AGGREGATION_COUNT", 4, 4)};
    }

    public c(String r8, int r10, long r11) {
        super(r8, r10);
        this.f12686a = r11;
    }

    public static c valueOf(String r8) {
        return (c) Enum.valueOf(c.class, r8);
    }

    public static c[] values() {
        return (c[]) f12685o.clone();
    }
}
