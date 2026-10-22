package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gg extends SSettingKey<p6> {
    public static final gg a = null;

    static {
        a = new gg();
    }

    public gg() {
        super("live_bg_broadcast_use_multi_process_config", "录屏开播是否使用多进程", new p6(0), new p6(0), true);
    }
}
