package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.feed.tabviewmodel.MultiTabContainerConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ya1 extends SSettingKey<MultiTabContainerConfig> {
    public static final ya1 a = null;

    static {
        a = new ya1();
    }

    public ya1() {
        super("livesdk_multi_tab_container_config", "多tab容器配置", new MultiTabContainerConfig(), new MultiTabContainerConfig());
    }
}
