package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e3 extends SSettingKey<Boolean> {
    public static final e3 a = null;

    static {
        a = new e3();
    }

    public e3() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_status_bar_visible_change_adjust_player", "状态栏可见性变化时调整播放器大小", r1, r1);
    }
}
