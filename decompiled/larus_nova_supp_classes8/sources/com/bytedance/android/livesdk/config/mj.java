package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mj extends SSettingKey<Boolean> {
    public static final mj a = null;

    static {
        a = new mj();
    }

    public mj() {
        Boolean r1 = Boolean.FALSE;
        super("live_cast_screen_log_fetch_url_enable", "是否上报投屏fetchUrl埋点", r1, r1);
    }
}
