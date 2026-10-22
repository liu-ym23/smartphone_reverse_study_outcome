package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k40 extends SSettingKey<LiveKtvFirstLevelTabConfig> {
    public static final k40 a = null;

    static {
        a = new k40();
    }

    public k40() {
        super("live_ktv_frist_level_tab_config", "KTV 一级tab 配置", new LiveKtvFirstLevelTabConfig(), new LiveKtvFirstLevelTabConfig());
    }
}
