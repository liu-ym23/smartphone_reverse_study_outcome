package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.DislikeConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k2 extends SSettingKey<DislikeConfig> {
    public static final k2 a = null;

    static {
        a = new k2();
    }

    public k2() {
        super("live_long_press_dislike", "直播间满意度反馈相关配置", new DislikeConfig(), new DislikeConfig());
    }
}
