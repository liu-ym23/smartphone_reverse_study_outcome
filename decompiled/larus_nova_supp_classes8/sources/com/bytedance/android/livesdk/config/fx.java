package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.FlyingStarBroadcastConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fx extends SSettingKey<FlyingStarBroadcastConfig> {
    public static final fx a = null;

    static {
        a = new fx();
    }

    public fx() {
        super("flyingstar_broadcast_config", "飞星 - 主播侧配置", new FlyingStarBroadcastConfig(), new FlyingStarBroadcastConfig());
    }
}
