package od;

/* JADX INFO: loaded from: classes2.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9782a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f9783b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ e[] f9784m = null;

    static {
        e r8 = new e("monitor_default", 0);
        e r10 = new e("init", 1);
        f9782a = r10;
        e r11 = new e("f_block", 2);
        e r12 = new e("f_cache", 3);
        f9783b = r12;
        f9784m = new e[]{r8, r10, r11, r12, new e("f_filter", 4), new e("f_sampling", 5), new e("f_db_insert", 6), new e("f_db_delete", 7), new e("f_to_pack", 8), new e("success", 9), new e("f_net", 10), new e("f_to_bytes", 11), new e("f_to_bytes_null", 12), new e("f_to_bytes_compress", 13), new e("f_to_bytes_encrypt", 14), new e("f_send_check", 15), new e("f_split_terminate", 16), new e("f_filter_terminate", 17), new e("f_congestion_control", 18), new e("f_backoff_ratio", 19), new e("f_device_none", 20), new e("f_resp_error", 21), new e("f_load", 22), new e("f_not_init", 23), new e("f_no_session", 24), new e("s_rt_net", 25), new e("f_rt_to_bytes", 26), new e("f_size_limit", 27), new e("f_log_size_limit", 28), new e("f_overflow", 29), new e("f_log_overflow", 30), new e("f_stop", 31), new e("f_expire", 32), new e("f_no_network", 33), new e("f_exception", 34), new e("f_lost_impression", 35), new e("total_success", 36), new e("f_net_minus", 37), new e("f_net_zero", 38), new e("f_net_10", 39), new e("f_net_11", 40), new e("f_net_12", 41), new e("f_net_13", 42), new e("f_net_14", 43), new e("f_net_15", 44), new e("f_net_1xx", 45), new e("f_net_2xx", 46), new e("f_net_3xx", 47), new e("f_net_4xx", 48), new e("f_net_5xx", 49), new e("is_first_launch", 50), new e("repeat_first_launch", 51), new e("increase_cursor_window_size", 52), new e("cursor_window_size_overflow", 53), new e("bdinstall_lost_header_ready_callback", 54), new e("engine_event_cache_overflow", 55), new e("break_pack_misc_other_exception", 56), new e("f_oom", 57)};
    }

    public e(String r8, int r10) {
        super(r8, r10);
    }

    public static e valueOf(String r8) {
        return (e) Enum.valueOf(e.class, r8);
    }

    public static e[] values() {
        return (e[]) f9784m.clone();
    }
}
