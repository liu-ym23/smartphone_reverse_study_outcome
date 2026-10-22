package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pu extends SSettingKey<Boolean> {
    public static final pu a = null;

    static {
        a = new pu();
    }

    public pu() {
        Boolean r4 = Boolean.FALSE;
        super("live_enter_room_trace_v2", "进退房trace日志", r4, r4, true);
    }
}
