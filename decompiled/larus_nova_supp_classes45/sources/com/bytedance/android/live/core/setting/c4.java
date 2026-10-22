package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.RadioSpeakingUpdateTimeConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c4 extends SSettingKey<RadioSpeakingUpdateTimeConfig> {
    public static final c4 a = null;

    static {
        a = new c4();
    }

    public c4() {
        super("live_radio_speaking_update_interval_time_config", "电台说话状态更新时间间隔配置", new RadioSpeakingUpdateTimeConfig(), new RadioSpeakingUpdateTimeConfig());
    }
}
