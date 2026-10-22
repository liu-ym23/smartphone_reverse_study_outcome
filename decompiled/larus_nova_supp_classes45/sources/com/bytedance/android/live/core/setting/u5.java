package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u5 extends SSettingKey<Boolean> {
    public static final u5 a = null;

    static {
        a = new u5();
    }

    public u5() {
        Boolean r1 = Boolean.FALSE;
        super("live_voice_banlance_degrade_config", "音量均衡性能降级", r1, r1);
    }
}
