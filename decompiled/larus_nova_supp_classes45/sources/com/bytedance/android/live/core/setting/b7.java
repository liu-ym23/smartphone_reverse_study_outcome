package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.StreamAutoAdapterConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b7 extends SSettingKey<StreamAutoAdapterConfig> {
    public static final b7 a = null;

    static {
        a = new b7();
    }

    public b7() {
        super("live_stream_auto_adapter_config", "流画面自适应配置", new StreamAutoAdapterConfig(), new StreamAutoAdapterConfig());
    }
}
