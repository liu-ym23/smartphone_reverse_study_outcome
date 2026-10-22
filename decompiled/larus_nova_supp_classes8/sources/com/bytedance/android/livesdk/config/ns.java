package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ns extends SSettingKey<Boolean> {
    public static final ns a = null;

    static {
        a = new ns();
    }

    public ns() {
        Boolean r1 = Boolean.TRUE;
        super("enable_open_platform_network", "开放平台网络能力风险开关(后续要删除)", r1, r1);
    }
}
