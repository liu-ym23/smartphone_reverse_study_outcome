package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x2 extends SSettingKey<Boolean> {
    public static final x2 a = null;

    static {
        a = new x2();
    }

    public x2() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_layout_config_update_region", "布局配置文件更新时同步更新MultiLinkRegionUtils里的配置文件", r1, r1);
    }
}
