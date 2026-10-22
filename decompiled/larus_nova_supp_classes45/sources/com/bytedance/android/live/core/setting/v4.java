package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v4 extends SSettingKey<Boolean> {
    public static final v4 a = null;

    static {
        a = new v4();
    }

    public v4() {
        super("live_room_top_right_banner_style_switch", "直播间顶部右侧banner样式开关", Boolean.FALSE, Boolean.TRUE);
    }
}
