package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ka0 extends SettingKey<Boolean> {
    public static final ka0 a = null;

    static {
        a = new ka0();
    }

    public ka0() {
        Boolean r1 = Boolean.TRUE;
        super("live_more_panel_remove_fragment_sync_enable", "更多面板移除fragment使用异步", r1, r1);
    }
}
