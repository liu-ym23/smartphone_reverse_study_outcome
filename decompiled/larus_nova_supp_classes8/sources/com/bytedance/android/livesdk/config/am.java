package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadCompData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class am extends SSettingKey<PreloadCompData> {
    public static final am a = null;

    static {
        a = new am();
    }

    public am() {
        super("live_comp_preload_config", "组件预加载配置", new PreloadCompData(), new PreloadCompData(), true);
    }
}
