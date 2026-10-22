package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v00 extends SSettingKey<Boolean> {
    public static final v00 a = null;

    static {
        a = new v00();
    }

    public v00() {
        super("live_hybrid_use_full_link_monitor", "hybrid容器启用全链路监控", Boolean.FALSE, Boolean.TRUE);
    }
}
