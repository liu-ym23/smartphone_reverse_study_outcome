package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class op extends SettingKey<Integer> {
    public static final op a = null;

    public op() {
        super("live_draw_loadmore_config", "内流loadmore请求时机优化", 1, 3);
    }

    static {
        a = new op();
    }
}
