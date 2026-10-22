package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class es extends SSettingKey<Boolean> {
    public static final es a = null;

    static {
        a = new es();
    }

    public es() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_log_rankinfo", "是否开启麦序榜上报", r1, r1);
    }
}
