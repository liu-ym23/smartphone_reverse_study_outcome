package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.GameOpenPanelContentAdapterConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends SSettingKey<GameOpenPanelContentAdapterConfig> {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
        super("live_gcm_open_panel_content_adapter", "游戏直播面板展开画面自适应配置", new GameOpenPanelContentAdapterConfig(), new GameOpenPanelContentAdapterConfig());
    }
}
