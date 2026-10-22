package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q70 extends SSettingKey<Boolean> {
    public static final q70 a = null;

    static {
        a = new q70();
    }

    public q70() {
        Boolean r1 = Boolean.TRUE;
        super("lynx_list_fps_monitor_use_sample", "lynx列表fps上报是否使用采样", r1, r1);
    }
}
