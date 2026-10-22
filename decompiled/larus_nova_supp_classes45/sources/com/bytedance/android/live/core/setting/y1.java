package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y1 extends SSettingKey<Boolean> {
    public static final y1 a = null;

    static {
        a = new y1();
    }

    public y1() {
        Boolean r1 = Boolean.FALSE;
        super("live_hybrid_create_annie_card_opt", "跨端组件加载打散", r1, r1);
    }
}
