package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ua extends SSettingKey<Boolean> {
    public static final ua a = null;

    static {
        a = new ua();
    }

    public ua() {
        Boolean r1 = Boolean.TRUE;
        super("enable_anchor_perf_remind", "主播侧新版性能组件", r1, r1);
    }
}
