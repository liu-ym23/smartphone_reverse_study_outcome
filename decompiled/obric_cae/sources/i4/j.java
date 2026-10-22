package i4;

/* JADX INFO: loaded from: classes.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f8240b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final j f8241m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final j f8242n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final j f8243o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final j f8244p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ j[] f8245q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8246a;

    static {
        j r8 = new j("V3_EVENT", 0, 0);
        f8240b = r8;
        j r10 = new j("V1_EVENT", 1, 1);
        f8241m = r10;
        j r11 = new j("LOG_DATA", 2, 2);
        f8242n = r11;
        j r12 = new j("LAUNCH", 3, 3);
        f8243o = r12;
        j r13 = new j("TERMINATE", 4, 4);
        f8244p = r13;
        f8245q = new j[]{r8, r10, r11, r12, r13, new j("ITEM_IMPRESSION", 5, 5)};
    }

    public j(String r8, int r10, int r11) {
        super(r8, r10);
        this.f8246a = r11;
    }

    public static j a(String r8) {
        j[] r10 = values();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        j r13 = r10[r12];
        if (r13.name().equals(r8) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        return f8240b;
    }

    public static j valueOf(String r8) {
        return (j) Enum.valueOf(j.class, r8);
    }

    public static j[] values() {
        return (j[]) f8245q.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return name() + "-" + this.f8246a;
    }
}
