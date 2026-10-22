package od;

/* JADX INFO: loaded from: classes2.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ d[] f9781a = null;

    static {
        f9781a = new d[]{new d("monitor_default", 0), new d("event", 1), new d("event_v3", 2), new d("log_data", 3), new d("item_impression", 4), new d("launch", 5), new d("terminate", 6), new d("real_event", 7), new d("pack", 8), new d("database", 9), new d("register", 10), new d("active", 11), new d("config", 12), new d("ab_config", 13), new d("engine", 14), new d("f_cache_event", 15), new d("filtered_event", 16), new d("f_db_insert_event", 17), new d("f_to_pack_event", 18), new d("sampling_event", 19), new d("f_to_bytes_event", 20), new d("f_to_bytes_encrypt_event", 21), new d("large_event", 22), new d("f_expire_event", 23), new d("f_oom_event", 24)};
    }

    public d(String r8, int r10) {
        super(r8, r10);
    }

    public static d valueOf(String r8) {
        return (d) Enum.valueOf(d.class, r8);
    }

    public static d[] values() {
        return (d[]) f9781a.clone();
    }
}
