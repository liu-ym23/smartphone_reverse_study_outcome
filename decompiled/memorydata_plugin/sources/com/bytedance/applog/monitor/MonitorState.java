package com.bytedance.applog.monitor;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum MonitorState extends Enum<MonitorState> {
    private static final /* synthetic */ MonitorState[] $VALUES = null;
    public static final MonitorState bdinstall_lost_header_ready_callback = null;
    public static final MonitorState break_pack_misc_other_exception = null;
    public static final MonitorState cursor_window_size_overflow = null;
    public static final MonitorState empty = null;
    public static final MonitorState engine_event_cache_overflow = null;
    public static final MonitorState f_backoff_ratio = null;
    public static final MonitorState f_block = null;
    public static final MonitorState f_cache = null;
    public static final MonitorState f_congestion_control = null;
    public static final MonitorState f_db_delete = null;
    public static final MonitorState f_db_insert = null;
    public static final MonitorState f_device_none = null;
    public static final MonitorState f_exception = null;
    public static final MonitorState f_expire = null;
    public static final MonitorState f_filter = null;
    public static final MonitorState f_filter_terminate = null;
    public static final MonitorState f_forward_err = null;
    public static final MonitorState f_load = null;
    public static final MonitorState f_log_overflow = null;
    public static final MonitorState f_log_size_limit = null;
    public static final MonitorState f_lost_impression = null;
    public static final MonitorState f_migrate_old_events_failed = null;
    public static final MonitorState f_migrate_old_log_failed = null;
    public static final MonitorState f_migrate_old_sd_failed = null;
    public static final MonitorState f_net = null;
    public static final MonitorState f_net_10 = null;
    public static final MonitorState f_net_11 = null;
    public static final MonitorState f_net_12 = null;
    public static final MonitorState f_net_13 = null;
    public static final MonitorState f_net_14 = null;
    public static final MonitorState f_net_15 = null;
    public static final MonitorState f_net_1xx = null;
    public static final MonitorState f_net_2xx = null;
    public static final MonitorState f_net_3xx = null;
    public static final MonitorState f_net_4xx = null;
    public static final MonitorState f_net_5xx = null;
    public static final MonitorState f_net_minus = null;
    public static final MonitorState f_net_zero = null;
    public static final MonitorState f_no_network = null;
    public static final MonitorState f_no_session = null;
    public static final MonitorState f_not_init = null;
    public static final MonitorState f_oom = null;
    public static final MonitorState f_overflow = null;
    public static final MonitorState f_resp_error = null;
    public static final MonitorState f_rt_to_bytes = null;
    public static final MonitorState f_sampling = null;
    public static final MonitorState f_send_check = null;
    public static final MonitorState f_size_limit = null;
    public static final MonitorState f_split_terminate = null;
    public static final MonitorState f_stop = null;
    public static final MonitorState f_to_bytes = null;
    public static final MonitorState f_to_bytes_compress = null;
    public static final MonitorState f_to_bytes_encrypt = null;
    public static final MonitorState f_to_bytes_null = null;
    public static final MonitorState f_to_pack = null;
    public static final MonitorState increase_cursor_window_size = null;
    public static final MonitorState init = null;
    public static final MonitorState is_first_launch = null;
    public static final MonitorState monitor_default = null;
    public static final MonitorState only_impression = null;
    public static final MonitorState repeat_first_launch = null;
    public static final MonitorState s_rt_net = null;
    public static final MonitorState success = null;
    public static final MonitorState total_success = null;

    static {
        monitor_default = new MonitorState("monitor_default", 0);
        init = new MonitorState(CommonConsts.APM_INNER_EVENT_COST_INIT, 1);
        empty = new MonitorState("empty", 2);
        only_impression = new MonitorState("only_impression", 3);
        f_block = new MonitorState("f_block", 4);
        f_cache = new MonitorState("f_cache", 5);
        f_filter = new MonitorState("f_filter", 6);
        f_sampling = new MonitorState("f_sampling", 7);
        f_db_insert = new MonitorState("f_db_insert", 8);
        f_db_delete = new MonitorState("f_db_delete", 9);
        f_to_pack = new MonitorState("f_to_pack", 10);
        success = new MonitorState("success", 11);
        f_net = new MonitorState("f_net", 12);
        f_to_bytes = new MonitorState("f_to_bytes", 13);
        f_to_bytes_null = new MonitorState("f_to_bytes_null", 14);
        f_to_bytes_compress = new MonitorState("f_to_bytes_compress", 15);
        f_to_bytes_encrypt = new MonitorState("f_to_bytes_encrypt", 16);
        f_send_check = new MonitorState("f_send_check", 17);
        f_split_terminate = new MonitorState("f_split_terminate", 18);
        f_filter_terminate = new MonitorState("f_filter_terminate", 19);
        f_congestion_control = new MonitorState("f_congestion_control", 20);
        f_backoff_ratio = new MonitorState("f_backoff_ratio", 21);
        f_device_none = new MonitorState("f_device_none", 22);
        f_resp_error = new MonitorState("f_resp_error", 23);
        f_load = new MonitorState("f_load", 24);
        f_not_init = new MonitorState("f_not_init", 25);
        f_no_session = new MonitorState("f_no_session", 26);
        s_rt_net = new MonitorState("s_rt_net", 27);
        f_rt_to_bytes = new MonitorState("f_rt_to_bytes", 28);
        f_size_limit = new MonitorState("f_size_limit", 29);
        f_log_size_limit = new MonitorState("f_log_size_limit", 30);
        f_overflow = new MonitorState("f_overflow", 31);
        f_log_overflow = new MonitorState("f_log_overflow", 32);
        f_stop = new MonitorState("f_stop", 33);
        f_expire = new MonitorState("f_expire", 34);
        f_no_network = new MonitorState("f_no_network", 35);
        f_exception = new MonitorState("f_exception", 36);
        f_lost_impression = new MonitorState("f_lost_impression", 37);
        total_success = new MonitorState("total_success", 38);
        f_forward_err = new MonitorState("f_forward_err", 39);
        f_net_minus = new MonitorState("f_net_minus", 40);
        f_net_zero = new MonitorState("f_net_zero", 41);
        f_net_10 = new MonitorState("f_net_10", 42);
        f_net_11 = new MonitorState("f_net_11", 43);
        f_net_12 = new MonitorState("f_net_12", 44);
        f_net_13 = new MonitorState("f_net_13", 45);
        f_net_14 = new MonitorState("f_net_14", 46);
        f_net_15 = new MonitorState("f_net_15", 47);
        f_net_1xx = new MonitorState("f_net_1xx", 48);
        f_net_2xx = new MonitorState("f_net_2xx", 49);
        f_net_3xx = new MonitorState("f_net_3xx", 50);
        f_net_4xx = new MonitorState("f_net_4xx", 51);
        f_net_5xx = new MonitorState("f_net_5xx", 52);
        is_first_launch = new MonitorState("is_first_launch", 53);
        repeat_first_launch = new MonitorState("repeat_first_launch", 54);
        increase_cursor_window_size = new MonitorState("increase_cursor_window_size", 55);
        cursor_window_size_overflow = new MonitorState("cursor_window_size_overflow", 56);
        bdinstall_lost_header_ready_callback = new MonitorState("bdinstall_lost_header_ready_callback", 57);
        engine_event_cache_overflow = new MonitorState("engine_event_cache_overflow", 58);
        break_pack_misc_other_exception = new MonitorState("break_pack_misc_other_exception", 59);
        f_oom = new MonitorState("f_oom", 60);
        f_migrate_old_sd_failed = new MonitorState("f_migrate_old_sd_failed", 61);
        f_migrate_old_events_failed = new MonitorState("f_migrate_old_events_failed", 62);
        f_migrate_old_log_failed = new MonitorState("f_migrate_old_log_failed", 63);
        $VALUES = new MonitorState[]{monitor_default, init, empty, only_impression, f_block, f_cache, f_filter, f_sampling, f_db_insert, f_db_delete, f_to_pack, success, f_net, f_to_bytes, f_to_bytes_null, f_to_bytes_compress, f_to_bytes_encrypt, f_send_check, f_split_terminate, f_filter_terminate, f_congestion_control, f_backoff_ratio, f_device_none, f_resp_error, f_load, f_not_init, f_no_session, s_rt_net, f_rt_to_bytes, f_size_limit, f_log_size_limit, f_overflow, f_log_overflow, f_stop, f_expire, f_no_network, f_exception, f_lost_impression, total_success, f_forward_err, f_net_minus, f_net_zero, f_net_10, f_net_11, f_net_12, f_net_13, f_net_14, f_net_15, f_net_1xx, f_net_2xx, f_net_3xx, f_net_4xx, f_net_5xx, is_first_launch, repeat_first_launch, increase_cursor_window_size, cursor_window_size_overflow, bdinstall_lost_header_ready_callback, engine_event_cache_overflow, break_pack_misc_other_exception, f_oom, f_migrate_old_sd_failed, f_migrate_old_events_failed, f_migrate_old_log_failed};
    }

    private MonitorState(String r1, int r2) {
        super(r1, r2);
    }

    public static MonitorState valueOf(String r2) {
        return (MonitorState) ZeusTransformUtils.preCheckCast(Enum.valueOf(MonitorState.class, r2), MonitorState.class, "com.obric.memorydata.plugin");
    }

    public static MonitorState[] values() {
        return (MonitorState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MonitorState[].class, "com.obric.memorydata.plugin");
    }
}
