package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i70 extends SSettingKey<Integer> {
    public static final i70 a = null;

    static {
        a = new i70();
    }

    public i70() {
        super("live_log_rankinfo_report_interval", "麦序榜上报间隔时间", 60000, 60000);
    }
}
