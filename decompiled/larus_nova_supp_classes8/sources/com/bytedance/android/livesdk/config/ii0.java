package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ii0 extends SettingKey<Boolean> {
    public static final ii0 a = null;

    static {
        a = new ii0();
    }

    public ii0() {
        Boolean r1 = Boolean.FALSE;
        super("live_player_sandwich_layout", "三明治布局自动适配", r1, r1);
    }
}
