package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wy extends SSettingKey<Boolean> {
    public static final wy a = null;

    static {
        a = new wy();
    }

    public wy() {
        Boolean r1 = Boolean.TRUE;
        super("live_gift_down_coflict_opt", "横屏直播间小托盘下移冲突优化", r1, r1);
    }
}
