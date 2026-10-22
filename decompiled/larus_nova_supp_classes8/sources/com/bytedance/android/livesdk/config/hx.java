package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hx extends SSettingKey<Boolean> {
    public static final hx a = null;

    static {
        a = new hx();
    }

    public hx() {
        Boolean r1 = Boolean.TRUE;
        super("live_fold_screen_anchor_adapt_enable", "主播侧是否开启折叠屏适配", r1, r1);
    }
}
