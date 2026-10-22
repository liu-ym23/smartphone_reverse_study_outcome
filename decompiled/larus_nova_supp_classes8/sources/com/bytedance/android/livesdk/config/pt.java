package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pt extends SSettingKey<Boolean> {
    public static final pt a = null;

    static {
        a = new pt();
    }

    public pt() {
        Boolean r1 = Boolean.FALSE;
        super("live_end_dynamic", "关播页开启动态加载机制", r1, r1);
    }
}
