package com.bytedance.android.live.core.cmc.setting;

import com.bytedance.android.live.core.setting.SettingKey;
import e50.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface CMCSettings {
    public static final SettingKey<a> LIVE_CMC_CONFIG = null;

    static {
        LIVE_CMC_CONFIG = new SettingKey("live_cmc_config", "直播CMC框架配置", new a(), new a());
    }
}
