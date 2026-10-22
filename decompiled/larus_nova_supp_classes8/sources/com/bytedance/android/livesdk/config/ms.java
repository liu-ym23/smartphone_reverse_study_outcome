package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ms extends SSettingKey<Boolean> {
    public static final ms a = null;

    static {
        a = new ms();
    }

    public ms() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_object_accelerated_opt", "直播大对象创建加速", r1, r1);
    }
}
