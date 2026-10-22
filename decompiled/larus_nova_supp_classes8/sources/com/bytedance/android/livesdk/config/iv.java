package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class iv extends SSettingKey<Boolean> {
    public static final iv a = null;

    static {
        a = new iv();
    }

    public iv() {
        Boolean r1 = Boolean.TRUE;
        super("live_use_im_group_panel", "粉丝群管理打开IM页面schema", r1, r1);
    }
}
