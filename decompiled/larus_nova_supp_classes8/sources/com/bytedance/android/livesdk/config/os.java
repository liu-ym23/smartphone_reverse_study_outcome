package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class os extends SSettingKey<Integer> {
    public static final os a = null;

    public os() {
        super("live_enable_packup_banner", "是否开启右下角 banner 聚合", 0, 1);
    }

    static {
        a = new os();
    }
}
