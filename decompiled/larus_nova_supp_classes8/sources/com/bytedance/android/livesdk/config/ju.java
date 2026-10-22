package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ju extends SSettingKey<Boolean> {
    public static final ju a = null;

    static {
        a = new ju();
    }

    public ju() {
        Boolean r1 = Boolean.FALSE;
        super("live_enter_room_duration_update", "进房耗时上报时机变更", r1, r1);
    }
}
