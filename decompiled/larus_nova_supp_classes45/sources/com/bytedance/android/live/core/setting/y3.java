package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y3 extends SSettingKey<Boolean> {
    public static final y3 a = null;

    static {
        a = new y3();
    }

    public y3() {
        Boolean r1 = Boolean.TRUE;
        super("live_play_together_widget_hide_opt", "适用于一起玩场景下的直播间容器精简的端上兜底总开关", r1, r1);
    }
}
