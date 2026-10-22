package d7;

/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f6848b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c f6849m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ c[] f6850n = null;

    static {
        c r8 = new c("HANDSHAKE_UNKNOWN", 0);
        f6847a = r8;
        c r10 = new c("HANDSHAKE_RESUME", 1);
        f6848b = r10;
        c r11 = new c("HANDSHAKE_FULL", 2);
        f6849m = r11;
        f6850n = new c[]{r8, r10, r11};
    }

    public c(String r8, int r10) {
        super(r8, r10);
    }

    public static c valueOf(String r8) {
        return (c) Enum.valueOf(c.class, r8);
    }

    public static c[] values() {
        return (c[]) f6850n.clone();
    }
}
