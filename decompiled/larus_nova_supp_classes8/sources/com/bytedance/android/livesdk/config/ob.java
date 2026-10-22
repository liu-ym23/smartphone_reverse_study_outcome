package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ob extends SSettingKey<Boolean> {
    public static final ob a = null;

    static {
        a = new ob();
    }

    public ob() {
        Boolean r1 = Boolean.FALSE;
        super("live_anchor_enable_live_degrade", "直播间主播侧功能降级开关", r1, r1);
    }
}
