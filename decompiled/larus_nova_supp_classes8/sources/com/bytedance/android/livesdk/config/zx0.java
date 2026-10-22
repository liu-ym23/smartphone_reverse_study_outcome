package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zx0 extends SSettingKey<Boolean> {
    public static final zx0 a = null;

    static {
        a = new zx0();
    }

    public zx0() {
        super("live_vs_media_episode_component_data", Boolean.TRUE, "模版开关是否影响组件数据来源兜底");
    }
}
