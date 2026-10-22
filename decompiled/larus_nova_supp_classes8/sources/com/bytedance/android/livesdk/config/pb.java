package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pb extends SSettingKey<Boolean> {
    public static final pb a = null;

    static {
        a = new pb();
    }

    public pb() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_enable_monitor_merge", "主播侧埋点聚合上报", r1, r1);
    }
}
