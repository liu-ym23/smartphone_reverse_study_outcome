package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveLongPressPanelItemConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m70 extends SSettingKey<LiveLongPressPanelItemConfig> {
    public static final m70 a = null;

    static {
        a = new m70();
    }

    public m70() {
        super("live_long_press_item_config", "长按面板item的一些配置", new LiveLongPressPanelItemConfig(), new LiveLongPressPanelItemConfig());
    }
}
