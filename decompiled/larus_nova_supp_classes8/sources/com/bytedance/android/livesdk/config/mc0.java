package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.model.NetworkApmSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mc0 extends SSettingKey<NetworkApmSetting> {
    public static final mc0 a = null;

    static {
        a = new mc0();
    }

    public mc0() {
        super("live_network_apm_config", NetworkApmSetting.class, "网络APM开关配置", new NetworkApmSetting(), new NetworkApmSetting());
    }
}
