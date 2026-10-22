package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pg extends SettingKey<Integer> {
    public static final pg a = null;

    public pg() {
        super("live_bottom_bar_max_slot_debug", -1, "底bar按钮数量本地修改开关");
    }

    static {
        a = new pg();
    }
}
