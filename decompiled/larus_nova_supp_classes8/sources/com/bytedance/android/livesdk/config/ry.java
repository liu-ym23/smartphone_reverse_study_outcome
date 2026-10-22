package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ry extends SSettingKey<Boolean> {
    public static final ry a = null;

    static {
        a = new ry();
    }

    public ry() {
        Boolean r1 = Boolean.FALSE;
        super("live_get_enter_extra_params_opt", "获取extraParams异常优化", r1, r1);
    }
}
