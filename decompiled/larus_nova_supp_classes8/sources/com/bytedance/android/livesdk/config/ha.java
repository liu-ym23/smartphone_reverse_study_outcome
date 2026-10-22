package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ha extends SSettingKey<Integer> {
    public static final ha a = null;

    static {
        a = new ha();
    }

    public ha() {
        super("live_ai_load_more_inhibition", "首个直播间loadMore回调抑制端智能配置", 0, 0, new String[]{"0:不支持端智能接入", "1:支持端智能接入,不使用策略判断", "2:支持端智能接入,使用策略判断"});
    }
}
