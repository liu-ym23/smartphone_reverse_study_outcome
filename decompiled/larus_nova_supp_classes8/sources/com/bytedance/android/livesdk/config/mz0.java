package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mz0 extends SSettingKey<Boolean> {
    public static final mz0 a = null;

    static {
        a = new mz0();
    }

    public mz0() {
        super("live_xplay_anchor_pod_merge_stream_enable", "Xplay主播侧启动pod合流开关", Boolean.FALSE, Boolean.TRUE);
    }
}
