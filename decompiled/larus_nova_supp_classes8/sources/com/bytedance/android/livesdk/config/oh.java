package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class oh extends SSettingKey<Boolean> {
    public static final oh a = null;

    static {
        a = new oh();
    }

    public oh() {
        Boolean r1 = Boolean.FALSE;
        super("live_broadcast_page_exit_monitor", "开播页异常跳出监控", r1, r1);
    }
}
