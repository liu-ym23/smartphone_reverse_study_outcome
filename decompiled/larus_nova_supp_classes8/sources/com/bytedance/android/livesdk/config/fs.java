package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fs extends SSettingKey<Boolean> {
    public static final fs a = null;

    static {
        a = new fs();
    }

    public fs() {
        Boolean r1 = Boolean.TRUE;
        super("enable_lynx_list_fps_monitor", "lynx列表fps监控是否打开", r1, r1);
    }
}
