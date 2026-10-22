package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wi extends SSettingKey<Boolean> {
    public static final wi a = null;

    static {
        a = new wi();
    }

    public wi() {
        Boolean r1 = Boolean.FALSE;
        super("live_bytecast_save_refresh_pull", "自研投屏刷新流格式记忆", r1, r1);
    }
}
