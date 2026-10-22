package com.bytedance.applog.monitor.v3;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum StatsCountKeys extends Enum<StatsCountKeys> {
    private static final /* synthetic */ StatsCountKeys[] $VALUES = null;
    public static final StatsCountKeys ACCEPT_EVENT_COUNT = null;
    public static final StatsCountKeys ADJUST_TERMINATE_BLOCK_REQUEST_COUNT = null;
    public static final StatsCountKeys APPLOG_BLOCK_EVENT_COUNT = null;
    public static final StatsCountKeys BACKOFF_BLOCK_REQUEST_COUNT = null;
    public static final StatsCountKeys CACHE_DROP_EVENT_COUNT = null;
    public static final StatsCountKeys CLEAN_UP_EVENT_COUNT = null;
    public static final StatsCountKeys CLEAN_UP_LAUNCH_COUNT = null;
    public static final StatsCountKeys CLEAN_UP_TERMINATE_COUNT = null;
    public static final StatsCountKeys COLD_START_BLOCK_REQUEST_COUNT = null;
    public static final StatsCountKeys COLLECT_EVENT_COUNT = null;
    public static final StatsCountKeys COLLECT_FRONT_LAUNCH_COUNT = null;
    public static final StatsCountKeys COLLECT_IMPRESSION_ERROR_COUNT = null;
    public static final StatsCountKeys COLLECT_LAUNCH_COUNT = null;
    public static final StatsCountKeys COLLECT_TERMINATE_COUNT = null;
    public static final StatsCountKeys COMPRESS_ERROR_COUNT = null;
    public static final StatsCountKeys CONCURRENT_MODIFY_ERROR_COUNT = null;
    public static final StatsCountKeys CONFIG_REQUEST_COUNT = null;
    public static final StatsCountKeys CONFIG_REQUEST_FAILED_COUNT = null;
    public static final StatsCountKeys CONGESTION_BLOCK_REQUEST_COUNT = null;
    public static final StatsCountKeys DB_ERROR_COUNT = null;
    public static final StatsCountKeys ENCRYPT_ERROR_COUNT = null;
    public static final StatsCountKeys ET_OG_REJECTED_COUNT = null;
    public static final StatsCountKeys ET_OG_REJECTED_REPAIR_COUNT = null;
    public static final StatsCountKeys ET_TRIGGER_COUNT = null;
    public static final StatsCountKeys FILTER_DROP_EVENT_COUNT = null;
    public static final StatsCountKeys FLUSH_COUNT = null;
    public static final StatsCountKeys INSERT_EVENT_MISC_FAILED_COUNT = null;
    public static final StatsCountKeys INSERT_EVENT_V1_FAILED_COUNT = null;
    public static final StatsCountKeys INSERT_EVENT_V3_FAILED_COUNT = null;
    public static final StatsCountKeys INSERT_PACK_FAILED_COUNT = null;
    public static final StatsCountKeys INSERT_PAGE_FAILED_COUNT = null;
    public static final StatsCountKeys INSERT_SESSION_FAILED_COUNT = null;
    public static final StatsCountKeys JSON_ERROR_COUNT = null;
    public static final StatsCountKeys MEM_ERROR_COUNT = null;
    public static final StatsCountKeys NO_NETWORK_COUNT = null;
    public static final StatsCountKeys PACK_ERROR_COUNT = null;
    public static final StatsCountKeys PARAMS_CLEARED_BY_EVENT_SIZE_LIMIT = null;
    public static final StatsCountKeys PILED_UP_DB_SIZE_KB = null;
    public static final StatsCountKeys PILED_UP_EVENT_COUNT = null;
    public static final StatsCountKeys PILED_UP_LAUNCH_COUNT = null;
    public static final StatsCountKeys PILED_UP_PACK_COUNT = null;
    public static final StatsCountKeys PILED_UP_TERMINATE_COUNT = null;
    public static final StatsCountKeys QUERY_EVENT_MISC_FAILED_COUNT = null;
    public static final StatsCountKeys QUERY_EVENT_V1_FAILED_COUNT = null;
    public static final StatsCountKeys QUERY_EVENT_V3_FAILED_COUNT = null;
    public static final StatsCountKeys QUERY_PAGE_FAILED_COUNT = null;
    public static final StatsCountKeys QUERY_SESSION_FAILED_COUNT = null;
    public static final StatsCountKeys REALTIME_EVENT_COUNT = null;
    public static final StatsCountKeys REMOVE_CUSTOM_HEADER_COUNT = null;
    public static final StatsCountKeys REMOVE_EVENT_PARAM_COUNT = null;
    public static final StatsCountKeys REPORT_EVENT_DELAY_METRICS = null;
    public static final StatsCountKeys REPORT_FAILED_EVENT_COUNT = null;
    public static final StatsCountKeys REPORT_FAILED_LAUNCH_COUNT = null;
    public static final StatsCountKeys REPORT_FAILED_TERMINATE_COUNT = null;
    public static final StatsCountKeys REPORT_ON_COUNT_OR_SIZE_REACHED = null;
    public static final StatsCountKeys REPORT_REALTIME_EVENTS_FAILED_COUNT = null;
    public static final StatsCountKeys REPORT_REALTIME_EVENTS_SUCCESS_COUNT = null;
    public static final StatsCountKeys REPORT_REQUEST_COUNT = null;
    public static final StatsCountKeys REPORT_REQUEST_FAILED_COUNT = null;
    public static final StatsCountKeys REPORT_SUCCESS_EVENT_COUNT = null;
    public static final StatsCountKeys REPORT_SUCCESS_LAUNCH_COUNT = null;
    public static final StatsCountKeys REPORT_SUCCESS_TERMINATE_COUNT = null;
    public static final StatsCountKeys REQUEST_ERROR_COUNT = null;
    public static final StatsCountKeys SAMPLING_DROP_EVENT_COUNT = null;
    public static final StatsCountKeys SOF_ERROR_COUNT = null;

    static {
        COLLECT_EVENT_COUNT = new StatsCountKeys("COLLECT_EVENT_COUNT", 0);
        COLLECT_LAUNCH_COUNT = new StatsCountKeys("COLLECT_LAUNCH_COUNT", 1);
        COLLECT_FRONT_LAUNCH_COUNT = new StatsCountKeys("COLLECT_FRONT_LAUNCH_COUNT", 2);
        COLLECT_TERMINATE_COUNT = new StatsCountKeys("COLLECT_TERMINATE_COUNT", 3);
        ACCEPT_EVENT_COUNT = new StatsCountKeys("ACCEPT_EVENT_COUNT", 4);
        REPORT_SUCCESS_EVENT_COUNT = new StatsCountKeys("REPORT_SUCCESS_EVENT_COUNT", 5);
        REPORT_FAILED_EVENT_COUNT = new StatsCountKeys("REPORT_FAILED_EVENT_COUNT", 6);
        REPORT_SUCCESS_LAUNCH_COUNT = new StatsCountKeys("REPORT_SUCCESS_LAUNCH_COUNT", 7);
        REPORT_FAILED_LAUNCH_COUNT = new StatsCountKeys("REPORT_FAILED_LAUNCH_COUNT", 8);
        REPORT_SUCCESS_TERMINATE_COUNT = new StatsCountKeys("REPORT_SUCCESS_TERMINATE_COUNT", 9);
        REPORT_FAILED_TERMINATE_COUNT = new StatsCountKeys("REPORT_FAILED_TERMINATE_COUNT", 10);
        REPORT_EVENT_DELAY_METRICS = new StatsCountKeys("REPORT_EVENT_DELAY_METRICS", 11);
        CACHE_DROP_EVENT_COUNT = new StatsCountKeys("CACHE_DROP_EVENT_COUNT", 12);
        FILTER_DROP_EVENT_COUNT = new StatsCountKeys("FILTER_DROP_EVENT_COUNT", 13);
        SAMPLING_DROP_EVENT_COUNT = new StatsCountKeys("SAMPLING_DROP_EVENT_COUNT", 14);
        REALTIME_EVENT_COUNT = new StatsCountKeys("REALTIME_EVENT_COUNT", 15);
        PILED_UP_EVENT_COUNT = new StatsCountKeys("PILED_UP_EVENT_COUNT", 16);
        PILED_UP_LAUNCH_COUNT = new StatsCountKeys("PILED_UP_LAUNCH_COUNT", 17);
        PILED_UP_TERMINATE_COUNT = new StatsCountKeys("PILED_UP_TERMINATE_COUNT", 18);
        PILED_UP_PACK_COUNT = new StatsCountKeys("PILED_UP_PACK_COUNT", 19);
        PILED_UP_DB_SIZE_KB = new StatsCountKeys("PILED_UP_DB_SIZE_KB", 20);
        REPORT_REQUEST_COUNT = new StatsCountKeys("REPORT_REQUEST_COUNT", 21);
        REPORT_REQUEST_FAILED_COUNT = new StatsCountKeys("REPORT_REQUEST_FAILED_COUNT", 22);
        CONFIG_REQUEST_COUNT = new StatsCountKeys("CONFIG_REQUEST_COUNT", 23);
        CONFIG_REQUEST_FAILED_COUNT = new StatsCountKeys("CONFIG_REQUEST_FAILED_COUNT", 24);
        CLEAN_UP_EVENT_COUNT = new StatsCountKeys("CLEAN_UP_EVENT_COUNT", 25);
        CLEAN_UP_LAUNCH_COUNT = new StatsCountKeys("CLEAN_UP_LAUNCH_COUNT", 26);
        CLEAN_UP_TERMINATE_COUNT = new StatsCountKeys("CLEAN_UP_TERMINATE_COUNT", 27);
        CONGESTION_BLOCK_REQUEST_COUNT = new StatsCountKeys("CONGESTION_BLOCK_REQUEST_COUNT", 28);
        BACKOFF_BLOCK_REQUEST_COUNT = new StatsCountKeys("BACKOFF_BLOCK_REQUEST_COUNT", 29);
        ADJUST_TERMINATE_BLOCK_REQUEST_COUNT = new StatsCountKeys("ADJUST_TERMINATE_BLOCK_REQUEST_COUNT", 30);
        FLUSH_COUNT = new StatsCountKeys("FLUSH_COUNT", 31);
        DB_ERROR_COUNT = new StatsCountKeys("DB_ERROR_COUNT", 32);
        MEM_ERROR_COUNT = new StatsCountKeys("MEM_ERROR_COUNT", 33);
        ENCRYPT_ERROR_COUNT = new StatsCountKeys("ENCRYPT_ERROR_COUNT", 34);
        PACK_ERROR_COUNT = new StatsCountKeys("PACK_ERROR_COUNT", 35);
        NO_NETWORK_COUNT = new StatsCountKeys("NO_NETWORK_COUNT", 36);
        REQUEST_ERROR_COUNT = new StatsCountKeys("REQUEST_ERROR_COUNT", 37);
        COMPRESS_ERROR_COUNT = new StatsCountKeys("COMPRESS_ERROR_COUNT", 38);
        CONCURRENT_MODIFY_ERROR_COUNT = new StatsCountKeys("CONCURRENT_MODIFY_ERROR_COUNT", 39);
        SOF_ERROR_COUNT = new StatsCountKeys("SOF_ERROR_COUNT", 40);
        JSON_ERROR_COUNT = new StatsCountKeys("JSON_ERROR_COUNT", 41);
        REPORT_REALTIME_EVENTS_SUCCESS_COUNT = new StatsCountKeys("REPORT_REALTIME_EVENTS_SUCCESS_COUNT", 42);
        REPORT_REALTIME_EVENTS_FAILED_COUNT = new StatsCountKeys("REPORT_REALTIME_EVENTS_FAILED_COUNT", 43);
        APPLOG_BLOCK_EVENT_COUNT = new StatsCountKeys("APPLOG_BLOCK_EVENT_COUNT", 44);
        REMOVE_EVENT_PARAM_COUNT = new StatsCountKeys("REMOVE_EVENT_PARAM_COUNT", 45);
        REMOVE_CUSTOM_HEADER_COUNT = new StatsCountKeys("REMOVE_CUSTOM_HEADER_COUNT", 46);
        INSERT_EVENT_V3_FAILED_COUNT = new StatsCountKeys("INSERT_EVENT_V3_FAILED_COUNT", 47);
        INSERT_EVENT_V1_FAILED_COUNT = new StatsCountKeys("INSERT_EVENT_V1_FAILED_COUNT", 48);
        INSERT_EVENT_MISC_FAILED_COUNT = new StatsCountKeys("INSERT_EVENT_MISC_FAILED_COUNT", 49);
        INSERT_SESSION_FAILED_COUNT = new StatsCountKeys("INSERT_SESSION_FAILED_COUNT", 50);
        INSERT_PAGE_FAILED_COUNT = new StatsCountKeys("INSERT_PAGE_FAILED_COUNT", 51);
        INSERT_PACK_FAILED_COUNT = new StatsCountKeys("INSERT_PACK_FAILED_COUNT", 52);
        QUERY_EVENT_V3_FAILED_COUNT = new StatsCountKeys("QUERY_EVENT_V3_FAILED_COUNT", 53);
        QUERY_EVENT_V1_FAILED_COUNT = new StatsCountKeys("QUERY_EVENT_V1_FAILED_COUNT", 54);
        QUERY_EVENT_MISC_FAILED_COUNT = new StatsCountKeys("QUERY_EVENT_MISC_FAILED_COUNT", 55);
        QUERY_SESSION_FAILED_COUNT = new StatsCountKeys("QUERY_SESSION_FAILED_COUNT", 56);
        QUERY_PAGE_FAILED_COUNT = new StatsCountKeys("QUERY_PAGE_FAILED_COUNT", 57);
        COLLECT_IMPRESSION_ERROR_COUNT = new StatsCountKeys("COLLECT_IMPRESSION_ERROR_COUNT", 58);
        PARAMS_CLEARED_BY_EVENT_SIZE_LIMIT = new StatsCountKeys("PARAMS_CLEARED_BY_EVENT_SIZE_LIMIT", 59);
        REPORT_ON_COUNT_OR_SIZE_REACHED = new StatsCountKeys("REPORT_ON_COUNT_OR_SIZE_REACHED", 60);
        COLD_START_BLOCK_REQUEST_COUNT = new StatsCountKeys("COLD_START_BLOCK_REQUEST_COUNT", 61);
        ET_TRIGGER_COUNT = new StatsCountKeys("ET_TRIGGER_COUNT", 62);
        ET_OG_REJECTED_COUNT = new StatsCountKeys("ET_OG_REJECTED_COUNT", 63);
        ET_OG_REJECTED_REPAIR_COUNT = new StatsCountKeys("ET_OG_REJECTED_REPAIR_COUNT", 64);
        $VALUES = new StatsCountKeys[]{COLLECT_EVENT_COUNT, COLLECT_LAUNCH_COUNT, COLLECT_FRONT_LAUNCH_COUNT, COLLECT_TERMINATE_COUNT, ACCEPT_EVENT_COUNT, REPORT_SUCCESS_EVENT_COUNT, REPORT_FAILED_EVENT_COUNT, REPORT_SUCCESS_LAUNCH_COUNT, REPORT_FAILED_LAUNCH_COUNT, REPORT_SUCCESS_TERMINATE_COUNT, REPORT_FAILED_TERMINATE_COUNT, REPORT_EVENT_DELAY_METRICS, CACHE_DROP_EVENT_COUNT, FILTER_DROP_EVENT_COUNT, SAMPLING_DROP_EVENT_COUNT, REALTIME_EVENT_COUNT, PILED_UP_EVENT_COUNT, PILED_UP_LAUNCH_COUNT, PILED_UP_TERMINATE_COUNT, PILED_UP_PACK_COUNT, PILED_UP_DB_SIZE_KB, REPORT_REQUEST_COUNT, REPORT_REQUEST_FAILED_COUNT, CONFIG_REQUEST_COUNT, CONFIG_REQUEST_FAILED_COUNT, CLEAN_UP_EVENT_COUNT, CLEAN_UP_LAUNCH_COUNT, CLEAN_UP_TERMINATE_COUNT, CONGESTION_BLOCK_REQUEST_COUNT, BACKOFF_BLOCK_REQUEST_COUNT, ADJUST_TERMINATE_BLOCK_REQUEST_COUNT, FLUSH_COUNT, DB_ERROR_COUNT, MEM_ERROR_COUNT, ENCRYPT_ERROR_COUNT, PACK_ERROR_COUNT, NO_NETWORK_COUNT, REQUEST_ERROR_COUNT, COMPRESS_ERROR_COUNT, CONCURRENT_MODIFY_ERROR_COUNT, SOF_ERROR_COUNT, JSON_ERROR_COUNT, REPORT_REALTIME_EVENTS_SUCCESS_COUNT, REPORT_REALTIME_EVENTS_FAILED_COUNT, APPLOG_BLOCK_EVENT_COUNT, REMOVE_EVENT_PARAM_COUNT, REMOVE_CUSTOM_HEADER_COUNT, INSERT_EVENT_V3_FAILED_COUNT, INSERT_EVENT_V1_FAILED_COUNT, INSERT_EVENT_MISC_FAILED_COUNT, INSERT_SESSION_FAILED_COUNT, INSERT_PAGE_FAILED_COUNT, INSERT_PACK_FAILED_COUNT, QUERY_EVENT_V3_FAILED_COUNT, QUERY_EVENT_V1_FAILED_COUNT, QUERY_EVENT_MISC_FAILED_COUNT, QUERY_SESSION_FAILED_COUNT, QUERY_PAGE_FAILED_COUNT, COLLECT_IMPRESSION_ERROR_COUNT, PARAMS_CLEARED_BY_EVENT_SIZE_LIMIT, REPORT_ON_COUNT_OR_SIZE_REACHED, COLD_START_BLOCK_REQUEST_COUNT, ET_TRIGGER_COUNT, ET_OG_REJECTED_COUNT, ET_OG_REJECTED_REPAIR_COUNT};
    }

    private StatsCountKeys(String r1, int r2) {
        super(r1, r2);
    }

    public static StatsCountKeys valueOf(String r2) {
        return (StatsCountKeys) ZeusTransformUtils.preCheckCast(Enum.valueOf(StatsCountKeys.class, r2), StatsCountKeys.class, "com.obric.memorydata.plugin");
    }

    public static StatsCountKeys[] values() {
        return (StatsCountKeys[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StatsCountKeys[].class, "com.obric.memorydata.plugin");
    }
}
