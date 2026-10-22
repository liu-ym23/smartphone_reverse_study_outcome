package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t4 extends SSettingKey<y21> {
    public static final t4 a = null;

    static {
        t4 r0 = new t4();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public t4() {
        super("fast_match_optimize_v2_enable", "快速匹配优化二期是否开启", new y21(), new y21());
    }
}
