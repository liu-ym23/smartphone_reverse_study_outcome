package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w3 extends SSettingKey<Boolean> {
    public static final w3 a = null;

    static {
        a = new w3();
    }

    public w3() {
        Boolean r1 = Boolean.TRUE;
        super("live_play_together_end_page_opt", "适用于一起玩场景下的关播页优化的端上兜底总开关", r1, r1);
    }
}
