package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hu extends SSettingKey<Boolean> {
    public static final hu a = null;

    static {
        a = new hu();
    }

    public hu() {
        Boolean r4 = Boolean.FALSE;
        super("live_enter_room_container_opt", "是否使用新的进房架构", r4, r4, true);
    }
}
