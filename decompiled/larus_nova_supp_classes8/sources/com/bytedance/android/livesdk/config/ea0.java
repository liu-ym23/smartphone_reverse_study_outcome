package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ea0 extends SSettingKey<Boolean> {
    public static final ea0 a = null;

    static {
        a = new ea0();
    }

    public ea0() {
        Boolean r1 = Boolean.TRUE;
        super("live_more_panel_corner_mark_enable", "观众端更多面板是否使用新样式+角标触达", r1, r1);
    }
}
