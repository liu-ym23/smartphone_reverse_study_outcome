package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mf0 extends SSettingKey<LivePanelConfig> {
    public static final mf0 a = null;

    static {
        a = new mf0();
    }

    public mf0() {
        super("live_panel_manager_config", "面板manager配置", new LivePanelConfig(), new LivePanelConfig());
    }
}
