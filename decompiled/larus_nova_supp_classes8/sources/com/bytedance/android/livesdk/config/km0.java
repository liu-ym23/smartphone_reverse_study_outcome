package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveRoomFeatureSmartConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class km0 extends SSettingKey<LiveRoomFeatureSmartConfig> {
    public static final km0 a = null;

    static {
        a = new km0();
    }

    public km0() {
        super("live_recommend_feature_smart_config", "直播推荐特征上报smart平台开关", new LiveRoomFeatureSmartConfig(), new LiveRoomFeatureSmartConfig());
    }
}
