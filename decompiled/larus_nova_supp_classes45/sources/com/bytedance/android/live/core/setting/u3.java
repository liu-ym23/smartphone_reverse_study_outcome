package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u3 extends SSettingKey<com.bytedance.android.livesdk.config.setting.m> {
    public static final u3 a = null;

    static {
        a = new u3();
    }

    public u3() {
        super("live_player_fetch_effect_model", "播放器拉取Effect模型配置", new com.bytedance.android.livesdk.config.setting.m(), new com.bytedance.android.livesdk.config.setting.m());
    }
}
