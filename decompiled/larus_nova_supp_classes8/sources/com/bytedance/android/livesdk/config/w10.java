package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w10 extends SettingKey<Boolean> {
    public static final w10 a = null;

    static {
        a = new w10();
    }

    public w10() {
        Boolean r4 = Boolean.FALSE;
        super("live_inner_feed_rerank_old_logic_opt", "内流重排重复触发问题", r4, r4, true);
    }
}
