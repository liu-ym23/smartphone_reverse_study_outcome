package com.bytedance.applog.monitor.v3;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes.dex */
public final enum EventStage extends Enum<EventStage> {
    private static final /* synthetic */ EventStage[] $VALUES = null;
    public static final EventStage CACHED_BEFORE_HANDLE = null;
    public static final EventStage CACHE_DROP_BEFORE_HANDLE = null;
    public static final EventStage COLLECTED = null;
    public static final EventStage DATA_LIST_ADDED = null;
    public static final EventStage DB_INSERT_START = null;
    public static final EventStage DB_SAVE_END = null;
    public static final EventStage DB_SAVE_FAILED = null;
    public static final EventStage DB_SAVE_START = null;
    public static final EventStage FILTER_CUSTOM_BLOCKED = null;
    public static final EventStage FILTER_EVENT_BLOCKED = null;
    public static final EventStage FILTER_SAMPLING_DROPPED = null;
    public static final EventStage FILTER_SERVER_BLOCKED = null;
    public static final EventStage HANDLE_REALTIME_START = null;
    public static final EventStage NOT_INIT_DROP = null;
    public static final EventStage NO_SESSION_DROP = null;
    public static final EventStage PACK_END = null;
    public static final EventStage PACK_INSERT_END = null;
    public static final EventStage PACK_INSERT_FAILED = null;
    public static final EventStage PACK_INSERT_START = null;
    public static final EventStage PARAMS_INVALID_DROP = null;
    public static final EventStage POST_FAILED = null;
    public static final EventStage POST_START = null;
    public static final EventStage PRE_EVENT_BLOCKED = null;
    public static final EventStage PRE_PROCESS_END = null;
    public static final EventStage PRE_PROCESS_START = null;
    public static final EventStage PRE_QUEUE_OVERFLOW = null;
    public static final EventStage PRIORITY_ACCEPT = null;
    public static final EventStage PRIORITY_HANDLE = null;
    public static final EventStage PROCESS_END = null;
    public static final EventStage PROCESS_START = null;
    public static final EventStage REALTIME_CRASH_DROP = null;
    public static final EventStage REALTIME_SEND_FAILED = null;
    public static final EventStage REALTIME_SEND_START = null;
    public static final EventStage REPORT_END = null;
    public static final EventStage REPORT_START = null;
    public static final EventStage TOURIST_BREAK = null;
    public static final EventStage UNKNOWN = null;
    private final String label;

    static {
        EventStage r0 = new EventStage("UNKNOWN", 0, StructuredDataId.RESERVED);
        UNKNOWN = r0;
        EventStage r1 = new EventStage("COLLECTED", 1, "00");
        COLLECTED = r1;
        EventStage r3 = new EventStage("PARAMS_INVALID_DROP", 2, "01");
        PARAMS_INVALID_DROP = r3;
        EventStage r5 = new EventStage("NOT_INIT_DROP", 3, "02");
        NOT_INIT_DROP = r5;
        EventStage r7 = new EventStage("PRE_PROCESS_START", 4, "03");
        PRE_PROCESS_START = r7;
        EventStage r9 = new EventStage("CACHED_BEFORE_HANDLE", 5, "04");
        CACHED_BEFORE_HANDLE = r9;
        EventStage r11 = new EventStage("CACHE_DROP_BEFORE_HANDLE", 6, "05");
        CACHE_DROP_BEFORE_HANDLE = r11;
        EventStage r13 = new EventStage("DATA_LIST_ADDED", 7, "06");
        DATA_LIST_ADDED = r13;
        EventStage r12 = new EventStage("PRE_QUEUE_OVERFLOW", 8, "07");
        PRE_QUEUE_OVERFLOW = r12;
        EventStage r10 = new EventStage("PRE_EVENT_BLOCKED", 9, "08");
        PRE_EVENT_BLOCKED = r10;
        EventStage r8 = new EventStage("PRE_PROCESS_END", 10, "0F");
        PRE_PROCESS_END = r8;
        EventStage r6 = new EventStage("PROCESS_START", 11, "10");
        PROCESS_START = r6;
        EventStage r4 = new EventStage("TOURIST_BREAK", 12, "11");
        TOURIST_BREAK = r4;
        EventStage r2 = new EventStage("FILTER_EVENT_BLOCKED", 13, "12");
        FILTER_EVENT_BLOCKED = r2;
        EventStage r14 = new EventStage("FILTER_SERVER_BLOCKED", 14, "13");
        FILTER_SERVER_BLOCKED = r14;
        EventStage r15 = new EventStage("FILTER_CUSTOM_BLOCKED", 15, "14");
        FILTER_CUSTOM_BLOCKED = r15;
        EventStage r16 = new EventStage("FILTER_SAMPLING_DROPPED", 16, "15");
        FILTER_SAMPLING_DROPPED = r16;
        EventStage r17 = new EventStage("NO_SESSION_DROP", 17, "16");
        NO_SESSION_DROP = r17;
        EventStage r18 = new EventStage("PROCESS_END", 18, "1F");
        PROCESS_END = r18;
        EventStage r19 = new EventStage("DB_SAVE_START", 19, "20");
        DB_SAVE_START = r19;
        EventStage r20 = new EventStage("HANDLE_REALTIME_START", 20, "21");
        HANDLE_REALTIME_START = r20;
        EventStage r21 = new EventStage("REALTIME_SEND_START", 21, BDLocationException.ERROR_AMAP_FAIL);
        REALTIME_SEND_START = r21;
        EventStage r22 = new EventStage("REALTIME_SEND_FAILED", 22, "23");
        REALTIME_SEND_FAILED = r22;
        EventStage r23 = new EventStage("REALTIME_CRASH_DROP", 23, BDLocationException.ERROR_UNKNOWN);
        REALTIME_CRASH_DROP = r23;
        EventStage r24 = new EventStage("PRIORITY_HANDLE", 24, BDLocationException.ERROR_SDK_START_FAIL);
        PRIORITY_HANDLE = r24;
        EventStage r25 = new EventStage("PRIORITY_ACCEPT", 25, "29");
        PRIORITY_ACCEPT = r25;
        EventStage r26 = new EventStage("DB_INSERT_START", 26, "2A");
        DB_INSERT_START = r26;
        EventStage r27 = new EventStage("DB_SAVE_FAILED", 27, "2B");
        DB_SAVE_FAILED = r27;
        EventStage r28 = new EventStage("DB_SAVE_END", 28, "2F");
        DB_SAVE_END = r28;
        EventStage r29 = new EventStage("REPORT_START", 29, BDLocationException.ERROR_SDK_NO_PERMISSION);
        REPORT_START = r29;
        EventStage r30 = new EventStage("PACK_END", 30, "31");
        PACK_END = r30;
        EventStage r31 = new EventStage("PACK_INSERT_START", 31, BDLocationException.ERROR_ABNORMAL_NETWORK);
        PACK_INSERT_START = r31;
        EventStage r32 = new EventStage("PACK_INSERT_FAILED", 32, "35");
        PACK_INSERT_FAILED = r32;
        EventStage r33 = new EventStage("PACK_INSERT_END", 33, BDLocationException.ERROR_BACKGROUND_LOCATE);
        PACK_INSERT_END = r33;
        EventStage r34 = new EventStage("POST_START", 34, "3A");
        POST_START = r34;
        EventStage r35 = new EventStage("POST_FAILED", 35, "3B");
        POST_FAILED = r35;
        EventStage r36 = new EventStage("REPORT_END", 36, "3F");
        REPORT_END = r36;
        $VALUES = new EventStage[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36};
    }

    private EventStage(String r1, int r2, String r3) {
        super(r1, r2);
        this.label = r3;
    }

    public static EventStage fromLabel(String r5) {
        EventStage[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        EventStage r3 = r0[r2];
        if (r3.label.equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return UNKNOWN;
    }

    public static EventStage valueOf(String r2) {
        return (EventStage) ZeusTransformUtils.preCheckCast(Enum.valueOf(EventStage.class, r2), EventStage.class, "com.obric.memorydata.plugin");
    }

    public static EventStage[] values() {
        return (EventStage[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EventStage[].class, "com.obric.memorydata.plugin");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.label;
    }
}
