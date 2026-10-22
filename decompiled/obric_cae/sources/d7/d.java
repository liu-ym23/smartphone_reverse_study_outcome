package d7;

/* JADX INFO: loaded from: classes.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f6851a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f6852b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f6853m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f6854n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f6855o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f6856p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d f6857q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ d[] f6858r = null;

    static {
        d r8 = new d("IDLE", 0);
        f6851a = r8;
        d r10 = new d("WAITING_FOR_STALLED_SOCKET_POOL", 1);
        d r11 = new d("WAITING_FOR_AVAILABLE_SOCKET", 2);
        d r12 = new d("WAITING_FOR_DELEGATE", 3);
        d r13 = new d("WAITING_FOR_CACHE", 4);
        d r14 = new d("WAITING_FOR_APPCACHE", 5);
        d r15 = new d("DOWNLOADING_PAC_FILE", 6);
        d r16 = new d("RESOLVING_PROXY_FOR_URL", 7);
        d r17 = new d("RESOLVING_HOST_IN_PAC_FILE", 8);
        d r18 = new d("ESTABLISHING_PROXY_TUNNEL", 9);
        d r19 = new d("RESOLVING_HOST", 10);
        f6852b = r19;
        d r110 = new d("CONNECTING", 11);
        f6853m = r110;
        d r111 = new d("SSL_HANDSHAKE", 12);
        f6854n = r111;
        d r112 = new d("SENDING_REQUEST", 13);
        f6855o = r112;
        d r113 = new d("WAITING_FOR_RESPONSE", 14);
        f6856p = r113;
        d r114 = new d("READING_RESPONSE", 15);
        f6857q = r114;
        f6858r = new d[]{r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114};
    }

    public d(String r8, int r10) {
        super(r8, r10);
    }

    public static d valueOf(String r8) {
        return (d) Enum.valueOf(d.class, r8);
    }

    public static d[] values() {
        return (d[]) f6858r.clone();
    }
}
