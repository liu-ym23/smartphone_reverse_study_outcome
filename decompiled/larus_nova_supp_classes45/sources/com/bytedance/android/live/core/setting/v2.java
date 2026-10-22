package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v2 extends SSettingKey<MultiLinkFrequencyOptConfig> {
    public static final v2 a = null;

    static {
        a = new v2();
    }

    public v2() {
        super("multi_link_frequency_opt_config", "多人场景高频耗时函数优化Config", new MultiLinkFrequencyOptConfig(), new MultiLinkFrequencyOptConfig());
    }
}
