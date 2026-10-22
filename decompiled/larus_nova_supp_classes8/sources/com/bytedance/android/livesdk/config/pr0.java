package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pr0 extends SSettingKey<Boolean> {
    public static final pr0 a = null;

    static {
        a = new pr0();
    }

    public pr0() {
        Boolean r1 = Boolean.FALSE;
        super("live_setting_by_lazy_opt", "是否开启settings读取by lazy + 缓存优化", r1, r1);
    }
}
