package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ny extends SSettingKey<Boolean> {
    public static final ny a = null;

    static {
        a = new ny();
    }

    public ny() {
        super("live_gcp_toolbar_load_config", "游戏联运直播间公共槽位前置加载开关", Boolean.FALSE, Boolean.TRUE);
    }
}
