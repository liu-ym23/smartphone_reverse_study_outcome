package com.ss.android.common.applog;

import com.bytedance.crash.constants.Constants;
import com.ss.android.common.lib.AppLogNewUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum MonitorKey extends Enum<MonitorKey> {
    private static final /* synthetic */ MonitorKey[] $VALUES = null;
    public static final MonitorKey ab_config = null;
    public static final MonitorKey active = null;
    public static final MonitorKey config = null;
    public static final MonitorKey database = null;
    public static final MonitorKey engine = null;
    public static final MonitorKey event = null;
    public static final MonitorKey event_v3 = null;
    public static final MonitorKey f_cache_event = null;
    public static final MonitorKey f_db_insert_event = null;
    public static final MonitorKey f_expire_event = null;
    public static final MonitorKey f_oom_event = null;
    public static final MonitorKey f_to_bytes_encrypt_event = null;
    public static final MonitorKey f_to_bytes_event = null;
    public static final MonitorKey f_to_pack_event = null;
    public static final MonitorKey filtered_event = null;
    public static final MonitorKey item_impression = null;
    public static final MonitorKey large_event = null;
    public static final MonitorKey launch = null;
    public static final MonitorKey log_data = null;
    public static final MonitorKey monitor_default = null;
    public static final MonitorKey pack = null;
    public static final MonitorKey real_event = null;
    public static final MonitorKey register = null;
    public static final MonitorKey sampling_event = null;
    public static final MonitorKey terminate = null;

    static {
        MonitorKey r0 = new MonitorKey("monitor_default", 0);
        monitor_default = r0;
        MonitorKey r1 = new MonitorKey("event", 1);
        event = r1;
        MonitorKey r3 = new MonitorKey(AppLogNewUtils.EVENT_V3_CATEGORY, 2);
        event_v3 = r3;
        MonitorKey r5 = new MonitorKey("log_data", 3);
        log_data = r5;
        MonitorKey r7 = new MonitorKey("item_impression", 4);
        item_impression = r7;
        MonitorKey r9 = new MonitorKey(Constants.LAUNCH_TAG, 5);
        launch = r9;
        MonitorKey r11 = new MonitorKey("terminate", 6);
        terminate = r11;
        MonitorKey r13 = new MonitorKey("real_event", 7);
        real_event = r13;
        MonitorKey r15 = new MonitorKey("pack", 8);
        pack = r15;
        MonitorKey r14 = new MonitorKey("database", 9);
        database = r14;
        MonitorKey r12 = new MonitorKey("register", 10);
        register = r12;
        MonitorKey r10 = new MonitorKey("active", 11);
        active = r10;
        MonitorKey r8 = new MonitorKey("config", 12);
        config = r8;
        MonitorKey r6 = new MonitorKey("ab_config", 13);
        ab_config = r6;
        MonitorKey r4 = new MonitorKey("engine", 14);
        engine = r4;
        MonitorKey r2 = new MonitorKey("f_cache_event", 15);
        f_cache_event = r2;
        MonitorKey r16 = new MonitorKey("filtered_event", 16);
        filtered_event = r16;
        MonitorKey r17 = new MonitorKey("f_db_insert_event", 17);
        f_db_insert_event = r17;
        MonitorKey r18 = new MonitorKey("f_to_pack_event", 18);
        f_to_pack_event = r18;
        MonitorKey r19 = new MonitorKey("sampling_event", 19);
        sampling_event = r19;
        MonitorKey r20 = new MonitorKey("f_to_bytes_event", 20);
        f_to_bytes_event = r20;
        MonitorKey r21 = new MonitorKey("f_to_bytes_encrypt_event", 21);
        f_to_bytes_encrypt_event = r21;
        MonitorKey r22 = new MonitorKey("large_event", 22);
        large_event = r22;
        MonitorKey r23 = new MonitorKey("f_expire_event", 23);
        f_expire_event = r23;
        MonitorKey r24 = new MonitorKey("f_oom_event", 24);
        f_oom_event = r24;
        $VALUES = new MonitorKey[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24};
    }

    private MonitorKey(String r1, int r2) {
        super(r1, r2);
    }

    public static MonitorKey valueOf(String r2) {
        return (MonitorKey) ZeusTransformUtils.preCheckCast(Enum.valueOf(MonitorKey.class, r2), MonitorKey.class, "com.obric.memorydata.plugin");
    }

    public static MonitorKey[] values() {
        return (MonitorKey[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MonitorKey[].class, "com.obric.memorydata.plugin");
    }
}
