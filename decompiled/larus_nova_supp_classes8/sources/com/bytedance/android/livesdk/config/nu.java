package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nu extends SSettingKey<Boolean> {
    public static final nu a = null;

    static {
        nu r0 = new nu();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public nu() {
        Boolean r4 = Boolean.FALSE;
        super("live_enter_room_request_retrofit_opt", "room/enter接口retrofit优化", r4, r4, true);
    }
}
