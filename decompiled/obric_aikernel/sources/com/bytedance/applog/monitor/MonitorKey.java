package com.bytedance.applog.monitor;

import androidx.core.app.NotificationCompat;
import com.bytedance.crash.constants.Constants;

/* JADX INFO: loaded from: classes.dex */
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
    public static final MonitorKey log_send = null;
    public static final MonitorKey migrate_old = null;
    public static final MonitorKey monitor_default = null;
    public static final MonitorKey pack = null;
    public static final MonitorKey real_event = null;
    public static final MonitorKey register = null;
    public static final MonitorKey sampling_event = null;
    public static final MonitorKey terminate = null;

    static {
        MonitorKey r10 = new MonitorKey("monitor_default", 0);
        monitor_default = r10;
        MonitorKey r11 = new MonitorKey(NotificationCompat.CATEGORY_EVENT, 1);
        event = r11;
        MonitorKey r12 = new MonitorKey("event_v3", 2);
        event_v3 = r12;
        MonitorKey r13 = new MonitorKey("log_data", 3);
        log_data = r13;
        MonitorKey r14 = new MonitorKey("item_impression", 4);
        item_impression = r14;
        MonitorKey r15 = new MonitorKey(Constants.LAUNCH_TAG, 5);
        launch = r15;
        MonitorKey r16 = new MonitorKey("terminate", 6);
        terminate = r16;
        MonitorKey r17 = new MonitorKey("real_event", 7);
        real_event = r17;
        MonitorKey r18 = new MonitorKey("pack", 8);
        pack = r18;
        MonitorKey r19 = new MonitorKey("database", 9);
        database = r19;
        MonitorKey r110 = new MonitorKey("register", 10);
        register = r110;
        MonitorKey r111 = new MonitorKey("active", 11);
        active = r111;
        MonitorKey r20 = new MonitorKey("config", 12);
        config = r20;
        MonitorKey r21 = new MonitorKey("ab_config", 13);
        ab_config = r21;
        MonitorKey r22 = new MonitorKey("engine", 14);
        engine = r22;
        MonitorKey r23 = new MonitorKey("log_send", 15);
        log_send = r23;
        MonitorKey r24 = new MonitorKey("migrate_old", 16);
        migrate_old = r24;
        MonitorKey r25 = new MonitorKey("f_cache_event", 17);
        f_cache_event = r25;
        MonitorKey r26 = new MonitorKey("filtered_event", 18);
        filtered_event = r26;
        MonitorKey r27 = new MonitorKey("f_db_insert_event", 19);
        f_db_insert_event = r27;
        MonitorKey r28 = new MonitorKey("f_to_pack_event", 20);
        f_to_pack_event = r28;
        MonitorKey r29 = new MonitorKey("sampling_event", 21);
        sampling_event = r29;
        MonitorKey r30 = new MonitorKey("f_to_bytes_event", 22);
        f_to_bytes_event = r30;
        MonitorKey r31 = new MonitorKey("f_to_bytes_encrypt_event", 23);
        f_to_bytes_encrypt_event = r31;
        MonitorKey r32 = new MonitorKey("large_event", 24);
        large_event = r32;
        MonitorKey r33 = new MonitorKey("f_expire_event", 25);
        f_expire_event = r33;
        MonitorKey r34 = new MonitorKey("f_oom_event", 26);
        f_oom_event = r34;
        $VALUES = new MonitorKey[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34};
    }

    private MonitorKey(String r10, int r11) {
        super(r10, r11);
    }

    public static MonitorKey valueOf(String r10) {
        return (MonitorKey) Enum.valueOf(MonitorKey.class, r10);
    }

    public static MonitorKey[] values() {
        return (MonitorKey[]) $VALUES.clone();
    }
}
