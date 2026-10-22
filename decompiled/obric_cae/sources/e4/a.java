package e4;

/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7115a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7116b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f7117m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ a[] f7118n = null;

    static {
        a r8 = new a("monitor_default", 0);
        a r10 = new a("event", 1);
        f7115a = r10;
        a r11 = new a("event_v3", 2);
        f7116b = r11;
        a r12 = new a("log_data", 3);
        f7117m = r12;
        f7118n = new a[]{r8, r10, r11, r12, new a("item_impression", 4), new a("launch", 5), new a("terminate", 6), new a("real_event", 7), new a("pack", 8), new a("database", 9), new a("register", 10), new a("active", 11), new a("config", 12), new a("ab_config", 13), new a("engine", 14), new a("log_send", 15), new a("migrate_old", 16), new a("f_cache_event", 17), new a("filtered_event", 18), new a("f_db_insert_event", 19), new a("f_to_pack_event", 20), new a("sampling_event", 21), new a("f_to_bytes_event", 22), new a("f_to_bytes_encrypt_event", 23), new a("large_event", 24), new a("f_expire_event", 25), new a("f_oom_event", 26)};
    }

    public a(String r8, int r10) {
        super(r8, r10);
    }

    public static a valueOf(String r8) {
        return (a) Enum.valueOf(a.class, r8);
    }

    public static a[] values() {
        return (a[]) f7118n.clone();
    }
}
