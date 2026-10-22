package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveWormholeFeatureOpt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fz0 extends SSettingKey<LiveWormholeFeatureOpt> {
    public static final fz0 a = null;

    static {
        a = new fz0();
    }

    public fz0() {
        super("live_wormhole_feature_opt", "内流预拉流结合泛特征尝试", new LiveWormholeFeatureOpt(), new LiveWormholeFeatureOpt());
    }
}
