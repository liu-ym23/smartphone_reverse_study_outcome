package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.GameGuessPredictorConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vx extends SSettingKey<GameGuessPredictorConfig> {
    public static final vx a = null;

    static {
        a = new vx();
    }

    public vx() {
        super("live_prophet_config", "游戏竞猜预言家玩法配置开关及跳转SCHEMA", new GameGuessPredictorConfig(), new GameGuessPredictorConfig());
    }
}
