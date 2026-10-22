package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y2 extends SSettingKey<Boolean> {
    public static final y2 a = null;

    static {
        a = new y2();
    }

    public y2() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_layout_config_update_surface_view_location", "布局配置文件更新时同步更新语音聊天室surfaceview位置", r1, r1);
    }
}
