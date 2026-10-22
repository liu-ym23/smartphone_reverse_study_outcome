package com.ss.android.common.applog;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum MonitorState extends Enum<MonitorState> {
    private static final /* synthetic */ MonitorState[] $VALUES = null;
    public static final MonitorState bdinstall_lost_header_ready_callback = null;
    public static final MonitorState break_pack_misc_other_exception = null;
    public static final MonitorState cursor_window_size_overflow = null;
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
    public static final MonitorState f_load = null;
    public static final MonitorState f_log_overflow = null;
    public static final MonitorState f_log_size_limit = null;
    public static final MonitorState f_lost_impression = null;
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
    public static final MonitorState repeat_first_launch = null;
    public static final MonitorState s_rt_net = null;
    public static final MonitorState success = null;
    public static final MonitorState total_success = null;

    static {
        monitor_default = new MonitorState("monitor_default", 0);
        init = new MonitorState(CommonConsts.APM_INNER_EVENT_COST_INIT, 1);
        f_block = new MonitorState("f_block", 2);
        f_cache = new MonitorState("f_cache", 3);
        f_filter = new MonitorState("f_filter", 4);
        f_sampling = new MonitorState("f_sampling", 5);
        f_db_insert = new MonitorState("f_db_insert", 6);
        f_db_delete = new MonitorState("f_db_delete", 7);
        f_to_pack = new MonitorState("f_to_pack", 8);
        success = new MonitorState("success", 9);
        f_net = new MonitorState("f_net", 10);
        f_to_bytes = new MonitorState("f_to_bytes", 11);
        f_to_bytes_null = new MonitorState("f_to_bytes_null", 12);
        f_to_bytes_compress = new MonitorState("f_to_bytes_compress", 13);
        f_to_bytes_encrypt = new MonitorState("f_to_bytes_encrypt", 14);
        f_send_check = new MonitorState("f_send_check", 15);
        f_split_terminate = new MonitorState("f_split_terminate", 16);
        f_filter_terminate = new MonitorState("f_filter_terminate", 17);
        f_congestion_control = new MonitorState("f_congestion_control", 18);
        f_backoff_ratio = new MonitorState("f_backoff_ratio", 19);
        f_device_none = new MonitorState("f_device_none", 20);
        f_resp_error = new MonitorState("f_resp_error", 21);
        f_load = new MonitorState("f_load", 22);
        f_not_init = new MonitorState("f_not_init", 23);
        f_no_session = new MonitorState("f_no_session", 24);
        s_rt_net = new MonitorState("s_rt_net", 25);
        f_rt_to_bytes = new MonitorState("f_rt_to_bytes", 26);
        f_size_limit = new MonitorState("f_size_limit", 27);
        f_log_size_limit = new MonitorState("f_log_size_limit", 28);
        f_overflow = new MonitorState("f_overflow", 29);
        f_log_overflow = new MonitorState("f_log_overflow", 30);
        f_stop = new MonitorState("f_stop", 31);
        f_expire = new MonitorState("f_expire", 32);
        f_no_network = new MonitorState("f_no_network", 33);
        f_exception = new MonitorState("f_exception", 34);
        f_lost_impression = new MonitorState("f_lost_impression", 35);
        total_success = new MonitorState("total_success", 36);
        f_net_minus = new MonitorState("f_net_minus", 37);
        f_net_zero = new MonitorState("f_net_zero", 38);
        f_net_10 = new MonitorState("f_net_10", 39);
        f_net_11 = new MonitorState("f_net_11", 40);
        f_net_12 = new MonitorState("f_net_12", 41);
        f_net_13 = new MonitorState("f_net_13", 42);
        f_net_14 = new MonitorState("f_net_14", 43);
        f_net_15 = new MonitorState("f_net_15", 44);
        f_net_1xx = new MonitorState("f_net_1xx", 45);
        f_net_2xx = new MonitorState("f_net_2xx", 46);
        f_net_3xx = new MonitorState("f_net_3xx", 47);
        f_net_4xx = new MonitorState("f_net_4xx", 48);
        f_net_5xx = new MonitorState("f_net_5xx", 49);
        is_first_launch = new MonitorState("is_first_launch", 50);
        repeat_first_launch = new MonitorState("repeat_first_launch", 51);
        increase_cursor_window_size = new MonitorState("increase_cursor_window_size", 52);
        cursor_window_size_overflow = new MonitorState("cursor_window_size_overflow", 53);
        bdinstall_lost_header_ready_callback = new MonitorState("bdinstall_lost_header_ready_callback", 54);
        engine_event_cache_overflow = new MonitorState("engine_event_cache_overflow", 55);
        break_pack_misc_other_exception = new MonitorState("break_pack_misc_other_exception", 56);
        f_oom = new MonitorState("f_oom", 57);
        $VALUES = new MonitorState[]{monitor_default, init, f_block, f_cache, f_filter, f_sampling, f_db_insert, f_db_delete, f_to_pack, success, f_net, f_to_bytes, f_to_bytes_null, f_to_bytes_compress, f_to_bytes_encrypt, f_send_check, f_split_terminate, f_filter_terminate, f_congestion_control, f_backoff_ratio, f_device_none, f_resp_error, f_load, f_not_init, f_no_session, s_rt_net, f_rt_to_bytes, f_size_limit, f_log_size_limit, f_overflow, f_log_overflow, f_stop, f_expire, f_no_network, f_exception, f_lost_impression, total_success, f_net_minus, f_net_zero, f_net_10, f_net_11, f_net_12, f_net_13, f_net_14, f_net_15, f_net_1xx, f_net_2xx, f_net_3xx, f_net_4xx, f_net_5xx, is_first_launch, repeat_first_launch, increase_cursor_window_size, cursor_window_size_overflow, bdinstall_lost_header_ready_callback, engine_event_cache_overflow, break_pack_misc_other_exception, f_oom};
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
