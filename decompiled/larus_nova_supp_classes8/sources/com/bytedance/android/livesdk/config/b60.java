package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiLinkBaseDegradeConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b60 extends SSettingKey<MultiLinkBaseDegradeConfig> {
    public static final b60 a = null;

    static {
        a = new b60();
    }

    public b60() {
        super("live_performance_degrade_base", "多人基础性能降级", new MultiLinkBaseDegradeConfig(), new MultiLinkBaseDegradeConfig());
    }
}
